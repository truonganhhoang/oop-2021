## Báo cáo về mẫu thiết kế (Design Pattern)


<details>
  <summary><strong>Table of Contents</strong></summary>
  <ol>
    <li>
      <a href="#Thành-viên">Giới thiệu</a>
    </li>
    <li>
      <a href="#Nội-dung">Nội dung</a>
    </li>
  </ol>
</details>
<br />

## Thành viên
- Lê Trung Hiếu ([@naslth](https://github.com/naslth)) - 20021354.
- Nguyễn Đình Hoàng ([@hoangndst](https://github.com/hoangndst)) - 20021361. 

### Đường dẫn tới project tham khảo 
- [GitHub](https://github.com/iluwatar/java-design-patterns)

# Nội dung

- [Creational](#creational-design-patterns)
- [Structural](#structural-design-patterns)
- [Behavioral](#behavioral-design-patterns)


# Creational Design Patterns
 * [Simple Factory](#Mẫu-thiết-kế-bình-thường)
 * [Factory Method](#factory-method)
 * [Abstract Factory](#abstract-factory)
 * [Builder](#builder)
 * [Prototype](#prototype)
 * [Singleton](#singleton)

## Mẫu thiết kế bình thường.
- [Factory (object-oriented programming)](https://en.wikipedia.org/wiki/Factory_(object-oriented_programming))
#### Một interface và việc triển khai
```php
interface Door
{
    public function getWidth(): float;
    public function getHeight(): float;
}

class WoodenDoor implements Door
{
    protected $width;
    protected $height;

    public function __construct(float $width, float $height)
    {
        $this->width = $width;
        $this->height = $height;
    }

    public function getWidth(): float
    {
        return $this->width;
    }

    public function getHeight(): float
    {
        return $this->height;
    }
}
```
#### Sau đó tạo class nhà máy sản xuất cửa.
```php
class DoorFactory
{
    public static function makeDoor($width, $height): Door
    {
        return new WoodenDoor($width, $height);
    }
}
```
#### Sử dụng:
```php
// Make me a door of 100x200
$door = DoorFactory::makeDoor(100, 200);

echo 'Width: ' . $door->getWidth();
echo 'Height: ' . $door->getHeight();

// Make me a door of 50x100
$door2 = DoorFactory::makeDoor(50, 100);
```
#### Sử dụng khi:
Khi việc tạo một đối tượng không chỉ là một vài nhiệm vụ và liên quan đến một số logic, bạn nên đặt nó vào một nhà máy thay vì lặp lại cùng một đoạn mã ở khắp mọi nơi.

## Abstract Factory
- [Abstract Factory](https://en.wikipedia.org/wiki/Abstract_factory_pattern)

### Giao diện `Door` và một số triển khai.
```php
interface Door
{
    public function getDescription();
}

class WoodenDoor implements Door
{
    public function getDescription()
    {
        echo 'I am a wooden door';
    }
}

class IronDoor implements Door
{
    public function getDescription()
    {
        echo 'I am an iron door';
    }
}
```
### Sau đó, chia thành một số chuyên gia về lắp đặt cho từng loại cửa.
```php
interface DoorFittingExpert
{
    public function getDescription();
}

class Welder implements DoorFittingExpert
{
    public function getDescription()
    {
        echo 'I can only fit iron doors';
    }
}

class Carpenter implements DoorFittingExpert
{
    public function getDescription()
    {
        echo 'I can only fit wooden doors';
    }
}
```

### Bây giờ tạo nhà máy trừu tượng cho phép sản xuất các đồ vật liên quan, tức là nhà máy sản xuất cửa gỗ sẽ tạo ra một chuyên gia lắp đặt cửa gỗ và cửa gỗ và nhà máy sản xuất cửa sắt sẽ tạo ra một chuyên gia lắp cửa sắt và cửa sắt.

```php
interface DoorFactory
{
    public function makeDoor(): Door;
    public function makeFittingExpert(): DoorFittingExpert;
}

// Wooden factory to return carpenter and wooden door
class WoodenDoorFactory implements DoorFactory
{
    public function makeDoor(): Door
    {
        return new WoodenDoor();
    }

    public function makeFittingExpert(): DoorFittingExpert
    {
        return new Carpenter();
    }
}

// Iron door factory to get iron door and the relevant fitting expert
class IronDoorFactory implements DoorFactory
{
    public function makeDoor(): Door
    {
        return new IronDoor();
    }

    public function makeFittingExpert(): DoorFittingExpert
    {
        return new Welder();
    }
}
```

### Sử dụng:
```php
$woodenFactory = new WoodenDoorFactory();

$door = $woodenFactory->makeDoor();
$expert = $woodenFactory->makeFittingExpert();

$door->getDescription();  // Output: I am a wooden door
$expert->getDescription(); // Output: I can only fit wooden doors

// Same for Iron Factory
$ironFactory = new IronDoorFactory();

$door = $ironFactory->makeDoor();
$expert = $ironFactory->makeFittingExpert();

$door->getDescription();  // Output: I am an iron door
$expert->getDescription(); // Output: I can only fit iron doors
```

Như các bạn thấy `wooden door factory` đã gói gọn `carpenter` và `wooden door` cũng vậy `iron door factory` đã gói gọn `iron door` và `welder`. Và do đó, nó đã giúp chúng ta đảm bảo rằng đối với mỗi cánh cửa được tạo ra, chúng ta không nhận được một chuyên gia lắp sai.


### Sử dụng khi:
Khi có các phụ thuộc liên quan với nhau với logic sáng tạo không đơn giản liên quan.

## Factory Method
- [Factory Method](https://en.wikipedia.org/wiki/Factory_method_pattern)
### Lấy ví dụ về người quản lý tuyển dụng. Trước hết tạo giao diện người phỏng vấn và một số triển khai.

```php
interface Interviewer
{
    public function askQuestions();
}

class Developer implements Interviewer
{
    public function askQuestions()
    {
        echo 'Asking about design patterns!';
    }
}

class CommunityExecutive implements Interviewer
{
    public function askQuestions()
    {
        echo 'Asking about community building';
    }
}
```
### Bây giờ tạo `HiringManager`
```php
abstract class HiringManager
{

    // Factory method
    abstract protected function makeInterviewer(): Interviewer;

    public function takeInterview()
    {
        $interviewer = $this->makeInterviewer();
        $interviewer->askQuestions();
    }
}

```
### Bây giờ bất kỳ lớp con nào cũng có thể mở rộng nó và cung cấp cho người phỏng vấn được yêu cầu.

```php
class DevelopmentManager extends HiringManager
{
    protected function makeInterviewer(): Interviewer
    {
        return new Developer();
    }
}

class MarketingManager extends HiringManager
{
    protected function makeInterviewer(): Interviewer
    {
        return new CommunityExecutive();
    }
}
```

### Sử dụng:

```php
$devManager = new DevelopmentManager();
$devManager->takeInterview(); // Output: Asking about design patterns

$marketingManager = new MarketingManager();
$marketingManager->takeInterview(); // Output: Asking about community building.
```

### Sử dụng khi:
Hữu ích khi có một số xử lý chung trong một lớp nhưng lớp con bắt buộc được quyết định động trong thời gian chạy. Hay nói cách khác, khi khách hàng không biết chính xác lớp con mà nó có thể cần.

## Builder
- [Builder](https://en.wikipedia.org/wiki/Builder_pattern)

### Trước hết, tạo một `Burger`.
```php
class Burger
{
    protected $size;

    protected $cheese = false;
    protected $pepperoni = false;
    protected $lettuce = false;
    protected $tomato = false;

    public function __construct(BurgerBuilder $builder)
    {
        $this->size = $builder->size;
        $this->cheese = $builder->cheese;
        $this->pepperoni = $builder->pepperoni;
        $this->lettuce = $builder->lettuce;
        $this->tomato = $builder->tomato;
    }
}
```

### Và sau là trình xây dựng `BurgerBuilder`
```php
class BurgerBuilder
{
    public $size;

    public $cheese = false;
    public $pepperoni = false;
    public $lettuce = false;
    public $tomato = false;

    public function __construct(int $size)
    {
        $this->size = $size;
    }

    public function addPepperoni()
    {
        $this->pepperoni = true;
        return $this;
    }

    public function addLettuce()
    {
        $this->lettuce = true;
        return $this;
    }

    public function addCheese()
    {
        $this->cheese = true;
        return $this;
    }

    public function addTomato()
    {
        $this->tomato = true;
        return $this;
    }

    public function build(): Burger
    {
        return new Burger($this);
    }
}
```

### Sử dụng
```php
$burger = (new BurgerBuilder(14))
                    ->addPepperoni()
                    ->addLettuce()
                    ->addTomato()
                    ->build();
```

Sự khác biệt chính so với mô hình nhà máy là: `Factory pattern` sẽ được sử dụng khi quá trình tạo là một bước trong khi `Builder pattern` sẽ được sử dụng khi quá trình tạo là một quá trình nhiều bước.

## Prototype
- [Prototype](https://en.wikipedia.org/wiki/Prototype_pattern)

### Mẫu class cơ bản:
```php
class Sheep
{
    protected $name;
    protected $category;

    public function __construct(string $name, string $category = 'Mountain Sheep')
    {
        $this->name = $name;
        $this->category = $category;
    }

    public function setName(string $name)
    {
        $this->name = $name;
    }

    public function getName()
    {
        return $this->name;
    }

    public function setCategory(string $category)
    {
        $this->category = $category;
    }

    public function getCategory()
    {
        return $this->category;
    }
}
```

### Sau đó, nó có thể được nhân bản như dưới đây(Chỉ có trong PHP)

```php
$original = new Sheep('Jolly');
echo $original->getName(); // Jolly
echo $original->getCategory(); // Mountain Sheep

// Clone and modify what is required
$cloned = clone $original;
$cloned->setName('Dolly');
echo $cloned->getName(); // Dolly
echo $cloned->getCategory(); // Mountain sheep
```

Sử dụng khi một đối tượng được yêu cầu tương tự với đối tượng hiện có hoặc khi việc tạo sẽ tốn kém hơn so với việc nhân bản.

## Singleton
- [Singleton](https://en.wikipedia.org/wiki/Singleton_pattern)

### Để tạo một singleton, hãy đặt hàm tạo ở chế độ riêng tư, tắt tính năng sao chép, tắt tiện ích mở rộng và tạo một biến tĩnh để chứa cá thể
```php
final class President
{
    private static $instance;

    private function __construct()
    {
        // Hide the constructor
    }

    public static function getInstance(): President
    {
        if (!self::$instance) {
            self::$instance = new self();
        }

        return self::$instance;
    }

    private function __clone()
    {
        // Disable cloning
    }

    private function __wakeup()
    {
        // Disable unserialize
    }
}
```

### Sử dụng

```php
$president1 = President::getInstance();
$president2 = President::getInstance();

var_dump($president1 === $president2); // true
```

# Structural Design Patterns

 * [Adapter](#adapter)
 * [Bridge](#bridge)
 * [Composite](#composite)
 * [Decorator](#decorator)
 * [Facade](#facade)
 * [Flyweight](#flyweight)
 * [Proxy](#proxy)

## Adapter
- [Adapter](https://en.wikipedia.org/wiki/Adapter_pattern)

Hãy xem xét một trò chơi trong đó có một người thợ săn và anh ta săn những con sư tử.

### Đầu tiên, chúng ta có một giao diện `Lion` mà tất cả các loại sư tử phải triển khai

```php
interface Lion
{
    public function roar();
}

class AfricanLion implements Lion
{
    public function roar()
    {
    }
}

class AsianLion implements Lion
{
    public function roar()
    {
    }
}
```

### Và thợ săn mong đợi bất kỳ triển khai nào của giao diện `Lion` đều có thể săn được.
```php
class Hunter
{
    public function hunt(Lion $lion)
    {
        $lion->roar();
    }
}
```

### Và bây giờ có thể sử dụng `WildDog` trong trò chơi bằng cách sử dụng` WildDogAdapter`.

```php
$wildDog = new WildDog();
$wildDogAdapter = new WildDogAdapter($wildDog);

$hunter = new Hunter();
$hunter->hunt($wildDogAdapter);
```

## Bridge
- [Bridge](https://en.wikipedia.org/wiki/Bridge_pattern)
### Hệ thống phân cấp `WebPage`
```php
interface WebPage
{
    public function __construct(Theme $theme);
    public function getContent();
}

class About implements WebPage
{
    protected $theme;

    public function __construct(Theme $theme)
    {
        $this->theme = $theme;
    }

    public function getContent()
    {
        return "About page in " . $this->theme->getColor();
    }
}

class Careers implements WebPage
{
    protected $theme;

    public function __construct(Theme $theme)
    {
        $this->theme = $theme;
    }

    public function getContent()
    {
        return "Careers page in " . $this->theme->getColor();
    }
}
```

### Hệ thống phân cấp chủ đề riêng biệt
```php

interface Theme
{
    public function getColor();
}

class DarkTheme implements Theme
{
    public function getColor()
    {
        return 'Dark Black';
    }
}
class LightTheme implements Theme
{
    public function getColor()
    {
        return 'Off white';
    }
}
class AquaTheme implements Theme
{
    public function getColor()
    {
        return 'Light blue';
    }
}
```

### Cả hai hệ thống phân cấp 
```php
$darkTheme = new DarkTheme();

$about = new About($darkTheme);
$careers = new Careers($darkTheme);

echo $about->getContent(); // "About page in Dark Black";
echo $careers->getContent(); // "Careers page in Dark Black";
```

## Composite
- [Composite](https://en.wikipedia.org/wiki/Composite_pattern)

### Lấy ví dụ về nhân viên ở trên. Ở đây có các loại nhân viên khác nhau.

```php
interface Employee
{
    public function __construct(string $name, float $salary);
    public function getName(): string;
    public function setSalary(float $salary);
    public function getSalary(): float;
    public function getRoles(): array;
}

class Developer implements Employee
{
    protected $salary;
    protected $name;
    protected $roles;
    
    public function __construct(string $name, float $salary)
    {
        $this->name = $name;
        $this->salary = $salary;
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setSalary(float $salary)
    {
        $this->salary = $salary;
    }

    public function getSalary(): float
    {
        return $this->salary;
    }

    public function getRoles(): array
    {
        return $this->roles;
    }
}

class Designer implements Employee
{
    protected $salary;
    protected $name;
    protected $roles;

    public function __construct(string $name, float $salary)
    {
        $this->name = $name;
        $this->salary = $salary;
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setSalary(float $salary)
    {
        $this->salary = $salary;
    }

    public function getSalary(): float
    {
        return $this->salary;
    }

    public function getRoles(): array
    {
        return $this->roles;
    }
}
```

### Sau đó tạo một tổ chức bao gồm một số loại nhân viên khác nhau
```php
class Organization
{
    protected $employees;

    public function addEmployee(Employee $employee)
    {
        $this->employees[] = $employee;
    }

    public function getNetSalaries(): float
    {
        $netSalary = 0;

        foreach ($this->employees as $employee) {
            $netSalary += $employee->getSalary();
        }

        return $netSalary;
    }
}
```

### Sử dụng:
```php
// Prepare the employees
$john = new Developer('John Doe', 12000);
$jane = new Designer('Jane Doe', 15000);

// Add them to organization
$organization = new Organization();
$organization->addEmployee($john);
$organization->addEmployee($jane);

echo "Net salaries: " . $organization->getNetSalaries(); // Net Salaries: 27000
```

## Decorator
- [Decorator](https://en.wikipedia.org/wiki/Decorator_pattern)

### Trước hết, chúng tôi có một giao diện `Coffee` đơn giản.
```php
interface Coffee
{
    public function getCost();
    public function getDescription();
}

class SimpleCoffee implements Coffee
{
    public function getCost()
    {
        return 10;
    }

    public function getDescription()
    {
        return 'Simple coffee';
    }
}
```
### Chúng ta muốn làm cho nó có thể mở rộng để cho phép các tùy chọn sửa đổi nó nếu được yêu cầu. Hãy tạo một số tiện ích bổ sung (`decorators`) cho giao diện `Coffee`.
```php
class MilkCoffee implements Coffee
{
    protected $coffee;

    public function __construct(Coffee $coffee)
    {
        $this->coffee = $coffee;
    }

    public function getCost()
    {
        return $this->coffee->getCost() + 2;
    }

    public function getDescription()
    {
        return $this->coffee->getDescription() . ', milk';
    }
}

class WhipCoffee implements Coffee
{
    protected $coffee;

    public function __construct(Coffee $coffee)
    {
        $this->coffee = $coffee;
    }

    public function getCost()
    {
        return $this->coffee->getCost() + 5;
    }

    public function getDescription()
    {
        return $this->coffee->getDescription() . ', whip';
    }
}

class VanillaCoffee implements Coffee
{
    protected $coffee;

    public function __construct(Coffee $coffee)
    {
        $this->coffee = $coffee;
    }

    public function getCost()
    {
        return $this->coffee->getCost() + 3;
    }

    public function getDescription()
    {
        return $this->coffee->getDescription() . ', vanilla';
    }
}
```

### Sừ dụng:
```php
$someCoffee = new SimpleCoffee();
echo $someCoffee->getCost(); // 10
echo $someCoffee->getDescription(); // Simple Coffee

$someCoffee = new MilkCoffee($someCoffee);
echo $someCoffee->getCost(); // 12
echo $someCoffee->getDescription(); // Simple Coffee, milk

$someCoffee = new WhipCoffee($someCoffee);
echo $someCoffee->getCost(); // 17
echo $someCoffee->getDescription(); // Simple Coffee, milk, whip

$someCoffee = new VanillaCoffee($someCoffee);
echo $someCoffee->getCost(); // 20
echo $someCoffee->getDescription(); // Simple Coffee, milk, whip, vanilla
```

`Decorator pattern` cho phép bạn tự động thay đổi hành vi của một đối tượng tại thời điểm chạy bằng cách gói chúng trong một đối tượng của lớp trang trí.

## Facade
- [Facade](https://en.wikipedia.org/wiki/Facade_pattern)
### Ở đây chúng ta có lớp máy tính `Computer`.

```php
class Computer
{
    public function getElectricShock()
    {
        echo "Ouch!";
    }

    public function makeSound()
    {
        echo "Beep beep!";
    }

    public function showLoadingScreen()
    {
        echo "Loading..";
    }

    public function bam()
    {
        echo "Ready to be used!";
    }

    public function closeEverything()
    {
        echo "Bup bup bup buzzzz!";
    }

    public function sooth()
    {
        echo "Zzzzz";
    }

    public function pullCurrent()
    {
        echo "Haaah!";
    }
}
```
### Chúng ta tiến hành `facade` cho máy tính.
```php
class ComputerFacade
{
    protected $computer;

    public function __construct(Computer $computer)
    {
        $this->computer = $computer;
    }

    public function turnOn()
    {
        $this->computer->getElectricShock();
        $this->computer->makeSound();
        $this->computer->showLoadingScreen();
        $this->computer->bam();
    }

    public function turnOff()
    {
        $this->computer->closeEverything();
        $this->computer->pullCurrent();
        $this->computer->sooth();
    }
}
```

### Sừ dụng:
```php
$computer = new ComputerFacade(new Computer());
$computer->turnOn(); // Ouch! Beep beep! Loading.. Ready to be used!
$computer->turnOff(); // Bup bup buzzz! Haah! Zzzzz
```

`Facade pattern` cung cấp một giao diện đơn giản hóa cho một hệ thống con phức tạp.

## Flyweight
- [Flyweight](https://en.wikipedia.org/wiki/Flyweight_pattern)

### Trước hết, tạo các lớp loại trà và máy pha trà

```php
// Anything that will be cached is flyweight.
// Types of tea here will be flyweights.
class KarakTea
{
}

// Acts as a factory and saves the tea
class TeaMaker
{
    protected $availableTea = [];

    public function make($preference)
    {
        if (empty($this->availableTea[$preference])) {
            $this->availableTea[$preference] = new KarakTea();
        }

        return $this->availableTea[$preference];
    }
}
```

### Sau đó, tạo `TeaShop` nhận đơn đặt hàng và phục vụ họ.
```php
class TeaShop
{
    protected $orders;
    protected $teaMaker;

    public function __construct(TeaMaker $teaMaker)
    {
        $this->teaMaker = $teaMaker;
    }

    public function takeOrder(string $teaType, int $table)
    {
        $this->orders[$table] = $this->teaMaker->make($teaType);
    }

    public function serve()
    {
        foreach ($this->orders as $table => $tea) {
            echo "Serving tea to table# " . $table;
        }
    }
}
```

### Sừ dụng:
```php
$teaMaker = new TeaMaker();
$shop = new TeaShop($teaMaker);

$shop->takeOrder('less sugar', 1);
$shop->takeOrder('more milk', 2);
$shop->takeOrder('without sugar', 5);

$shop->serve();
// Serving tea to table# 1
// Serving tea to table# 2
// Serving tea to table# 5
```

`Flyweight pattern` được sử dụng để giảm thiểu việc sử dụng bộ nhớ hoặc chi phí tính toán bằng cách chia sẻ càng nhiều càng tốt với các đối tượng tương tự.