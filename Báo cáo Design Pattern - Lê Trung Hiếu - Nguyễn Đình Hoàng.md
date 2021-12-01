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
- [23 mẫu thiết kế](https://github.com/kamranahmedse/design-patterns-for-humans)
# Nội dung
- [Creational](#creational-design-patterns)
- [Structural](#structural-design-patterns)
- [Behavioral](#behavioral-design-patterns)

# Creational Design Patterns
 * [Simple Factory](#Simple-factory)
 * [Factory Method](#factory-method)
 * [Abstract Factory](#abstract-factory)
 * [Builder](#builder)
 * [Prototype](#prototype)
 * [Singleton](#singleton)

## Simple Factory
- [Simple Factory](https://en.wikipedia.org/wiki/Factory_(object-oriented_programming))
### Đây là một interface thường gặp về Door và cách triển khai của nó:
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
### Sau đó chúng ta có thể tạo class nhà máy sản xuất cánh cửa:
```php
class DoorFactory
{
    public static function makeDoor($width, $height): Door
    {
        return new WoodenDoor($width, $height);
    }
}
```
### Cách sử dụng:
```php
// Make me a door of 100x200
$door = DoorFactory::makeDoor(100, 200);

echo 'Width: ' . $door->getWidth();
echo 'Height: ' . $door->getHeight();

// Make me a door of 50x100
$door2 = DoorFactory::makeDoor(50, 100);
```
Ở đây ta thấy lớp factory chịu trách nhiệm tạo ít đối tượng hơn. Do có ít đối tượng được tạo hơn nên logic nghiệp vụ trong phương thức factory sẽ không quá phức tạp. Máy khách chỉ cần biết các tham số được truyền vào phương thức tĩnh của lớp factory, và không cần quan tâm đến chi tiết của việc tạo đối tượng.

## Abstract Factory
- [Abstract Factory](https://en.wikipedia.org/wiki/Abstract_factory_pattern)

### Giả sử có giao diện `Door` và một số triển khai.
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

### Sử dụng:
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

### Sử dụng:
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

### Sử dụng:
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
## Proxy
- [Proxy](https://en.wikipedia.org/wiki/Proxy_pattern)

### Lấy ví dụ trên về cửa an toàn (security door). Đầu tiên chúng ta có giao diện và triển khai như sau:

```php
interface Door
{
    public function open();
    public function close();
}

class LabDoor implements Door
{
    public function open()
    {
        echo "Opening lab door";
    }

    public function close()
    {
        echo "Closing the lab door";
    }
}
```

### Chúng ta sẽ có một proxy để bảo vệ cánh cửa mà chúng ta muốn:
```php
interface Door
{
    public function open();
    public function close();
}

class LabDoor implements Door
{
    public function open()
    {
        echo "Opening lab door";
    }

    public function close()
    {
        echo "Closing the lab door";
    }
}
```

### Và đây là cách sử dụng:
```php
$door = new SecuredDoor(new LabDoor());
$door->open('invalid'); // Big no! It ain't possible.

$door->open('$ecr@t'); // Opening lab door
$door->close(); // Closing lab door
```

`Proxy pattern` được sử dụng khi muốn bảo vệ quyền truy xuất vào các phương thức của object thực hoặc cần một số thao tác bổ sung trước khi thực hiện phương thức của object thực. Giúp cải thiện Performance thông qua lazy loading, chỉ tải các tài nguyên khi chúng được yêu cầu và cung cấp sự bảo vệ cho đối tượng thực từ thế giới bên ngoài.
# Behavioral Design Patterns

 * [Chain of Responsibility](#Chain-of-responsibility)
 * [Command](#command)
 * [Iterator](#iterator)
 * [Mediator](#mediator)
 * [Memento](#memento)
 * [Observer](#observer)
 * [Visitor](#visitor)
 * [Strategy](#strategy)
 * [State](#state)
 * [Template Method](#Template-method)

## Chain of Responsibility
- [Chain of Responsibility](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern)

Ví dụ: Bạn có ba phương thức thanh toán (A, B và C) được thiết lập trong tài khoản của mình; mỗi phương thức có một số dư khác nhau trong đó. A có 100 USD, B có 300 USD và C có 1000 USD và phương thức được chọn thanh toán là A rồi đến B rồi C. Bạn cố gắng mua thứ gì đó trị giá 210 USD. Trước hết tài khoản A sẽ được kiểm tra xem nó có thể thực hiện giao dịch mua hay không, nếu có sẽ thực hiện mua hàng và dừng lại. Nếu không, yêu cầu sẽ chuyển tiếp đến tài khoản B để kiểm tra số tiền nếu có thể mua sẽ dùng tài khoản B, nếu không, yêu cầu sẽ tiếp tục chuyển tiếp cho đến khi tìm được phương thức mua phù hợp. Ở đây A, B và C là các mắt xích của 1 chuỗi gọi là Chain of responsibility.

### Đầu tiên, chúng ta có tài khoản gồm các phương thức mua hàng như trên:

```php
abstract class Account
{
    protected $successor;
    protected $balance;

    public function setNext(Account $account)
    {
        $this->successor = $account;
    }

    public function pay(float $amountToPay)
    {
        if ($this->canPay($amountToPay)) {
            echo sprintf('Paid %s using %s' . PHP_EOL, $amountToPay, get_called_class());
        } elseif ($this->successor) {
            echo sprintf('Cannot pay using %s. Proceeding ..' . PHP_EOL, get_called_class());
            $this->successor->pay($amountToPay);
        } else {
            throw new Exception('None of the accounts have enough balance');
        }
    }

    public function canPay($amount): bool
    {
        return $this->balance >= $amount;
    }
}

class Bank extends Account
{
    protected $balance;

    public function __construct(float $balance)
    {
        $this->balance = $balance;
    }
}

class Paypal extends Account
{
    protected $balance;

    public function __construct(float $balance)
    {
        $this->balance = $balance;
    }
}

class Bitcoin extends Account
{
    protected $balance;

    public function __construct(float $balance)
    {
        $this->balance = $balance;
    }
}
```

### Và giờ sử dụng Chain of Responsibility như sau:.
```php
// Let's prepare a chain like below
//      $bank->$paypal->$bitcoin
//
// First priority bank
//      If bank can't pay then paypal
//      If paypal can't pay then bit coin

$bank = new Bank(100);          // Bank with balance 100
$paypal = new Paypal(200);      // Paypal with balance 200
$bitcoin = new Bitcoin(300);    // Bitcoin with balance 300

$bank->setNext($paypal);
$paypal->setNext($bitcoin);

// Let's try to pay using the first priority i.e. bank
$bank->pay(259);

// Output will be
// ==============
// Cannot pay using bank. Proceeding ..
// Cannot pay using paypal. Proceeding ..:
// Paid 259 using Bitcoin!
```
`Chain of Responsibility pattern` được sử dụng khi có nhiều hơn một đối tượng có khả thực xử lý một yêu cầu và không xác định đối tượng cụ thể nào sẽ xử lý yêu cầu đó, khi cần phải thực thi các trình xử lý theo một thứ tự nhất định,... Nó giúp tránh sự liên kết trực tiếp giữa đối tượng gửi yêu cầu (sender) và các đối tượng nhận yêu cầu (receivers) đồng thời tăng tính linh hoạt: đảm bảo Open/Closed Principle và phân chia trách nhiệm cho các đối tượng: đảm bảo Single Responsibility Principle.
## Command
- [Command](https://en.wikipedia.org/wiki/Command_pattern)

Ví dụ: Giả sử chúng ta (i.e Client) muốn tắt/bật  (i.e Command) đèn (i.e Receiver) bằng cách ấn nút (i.e Invoker).

### Đầu tiên, chúng ta có class Bulb thực hiện các command:

```php
// Receiver
class Bulb
{
    public function turnOn()
    {
        echo "Bulb has been lit";
    }

    public function turnOff()
    {
        echo "Darkness!";
    }
}
```

### Và một interface các command cần thực hiện và triển khai interface đó:
```php
interface Command
{
    public function execute();
    public function undo();
    public function redo();
}

// Command
class TurnOn implements Command
{
    protected $bulb;

    public function __construct(Bulb $bulb)
    {
        $this->bulb = $bulb;
    }

    public function execute()
    {
        $this->bulb->turnOn();
    }

    public function undo()
    {
        $this->bulb->turnOff();
    }

    public function redo()
    {
        $this->execute();
    }
}

class TurnOff implements Command
{
    protected $bulb;

    public function __construct(Bulb $bulb)
    {
        $this->bulb = $bulb;
    }

    public function execute()
    {
        $this->bulb->turnOff();
    }

    public function undo()
    {
        $this->bulb->turnOn();
    }

    public function redo()
    {
        $this->execute();
    }
}
```
### Cuối cùng là một cách thức để thực hiện:

```php
// Invoker
class RemoteControl
{
    public function submit(Command $command)
    {
        $command->execute();
    }
}
```
### Đây là cách chúng ta sử dụng:
```php
$bulb = new Bulb();

$turnOn = new TurnOn($bulb);
$turnOff = new TurnOff($bulb);

$remote = new RemoteControl();
$remote->submit($turnOn); // Bulb has been lit!
$remote->submit($turnOff); // Darkness!
```
`Command pattern` được sử dụng khi cần tham số hóa các đối tượng theo một hành động thực hiện giúp đóng gói một yêu cầu trong một đối tượng và dễ dàng chuyển dữ liệu dưới dạng đối tượng giữa các thành phần hệ thống.
## Iterator
- [Iterator](https://en.wikipedia.org/wiki/Iterator_pattern)

Radio là ví dụ về Iterator do chúng ta có thể chuyển kênh tự do qua lại trên radio để chuyển bài hát. 

### Đầu tiên, chúng ta có class  RadioStation như sau:

```php
class RadioStation
{
    protected $frequency;

    public function __construct(float $frequency)
    {
        $this->frequency = $frequency;
    }

    public function getFrequency(): float
    {
        return $this->frequency;
    }
}
```

### Và iterator giúp chuyển kênh qua lại trên Radio:
```php
use Countable;
use Iterator;

class StationList implements Countable, Iterator
{
    /** @var RadioStation[] $stations */
    protected $stations = [];

    /** @var int $counter */
    protected $counter;

    public function addStation(RadioStation $station)
    {
        $this->stations[] = $station;
    }

    public function removeStation(RadioStation $toRemove)
    {
        $toRemoveFrequency = $toRemove->getFrequency();
        $this->stations = array_filter($this->stations, function (RadioStation $station) use ($toRemoveFrequency) {
            return $station->getFrequency() !== $toRemoveFrequency;
        });
    }

    public function count(): int
    {
        return count($this->stations);
    }

    public function current(): RadioStation
    {
        return $this->stations[$this->counter];
    }

    public function key()
    {
        return $this->counter;
    }

    public function next()
    {
        $this->counter++;
    }

    public function rewind()
    {
        $this->counter = 0;
    }

    public function valid(): bool
    {
        return isset($this->stations[$this->counter]);
    }
}
```
### Đây là cách sử dụng:

```php
$stationList = new StationList();

$stationList->addStation(new RadioStation(89));
$stationList->addStation(new RadioStation(101));
$stationList->addStation(new RadioStation(102));
$stationList->addStation(new RadioStation(103.2));

foreach($stationList as $station) {
    echo $station->getFrequency() . PHP_EOL;
}

$stationList->removeStation(new RadioStation(89)); // Will remove station 89
```
## Mediator
 - [Mediator](https://en.wikipedia.org/wiki/Mediator_pattern)

Ví dụ là khi bạn nói chuyện với ai đó qua điện thoại di động của mình, có một nhà cung cấp mạng ở giữa bạn và họ và cuộc trò chuyện của bạn được thực hiện gián tiếp qua đó thay vì trực tiếp giữa 2 người. Trong trường hợp này, nhà cung cấp mạng là Mediator(trung gian)

### Trước hết, chúng ta có Mediator, tức là chat room
```php
interface ChatRoomMediator 
{
    public function showMessage(User $user, string $message);
}

// Mediator
class ChatRoom implements ChatRoomMediator
{
    public function showMessage(User $user, string $message)
    {
        $time = date('M d, y H:i');
        $sender = $user->getName();

        echo $time . '[' . $sender . ']:' . $message;
    }
}
```
Và chúng ta có cài đặt người sử dụng
```php
class User {
    protected $name;
    protected $chatMediator;

    public function __construct(string $name, ChatRoomMediator $chatMediator) {
        $this->name = $name;
        $this->chatMediator = $chatMediator;
    }

    public function getName() {
        return $this->name;
    }

    public function send($message) {
        $this->chatMediator->showMessage($this, $message);
    }
}
```
Và đây là cách `Mediator pattern` được sử dụng
```php
$mediator = new ChatRoom();

$john = new User('John Doe', $mediator);
$jane = new User('Jane Doe', $mediator);

$john->send('Hi there!');
$jane->send('Hey!');

// Output will be
// Feb 14, 10:58 [John]: Hi there!
// Feb 14, 10:58 [Jane]: Hey!
```
## Memento
- [Memento](https://en.wikipedia.org/wiki/Memento_pattern)

Lấy ví dụ về máy tính (i.e. originator), trong đó bất cứ khi nào bạn thực hiện một phép tính nào đó, phép tính cuối cùng sẽ được lưu vào bộ nhớ (i.e. memento) để bạn có thể quay lại và có thể khôi phục nó bằng một số nút tác vụ (i.e. caretaker).

### Đầu tiên, chúng ta có class EditorMemento giữ trạng thái chỉnh sửa

```php
class EditorMemento
{
    protected $content;

    public function __construct(string $content)
    {
        $this->content = $content;
    }

    public function getContent()
    {
        return $this->content;
    }
}
```

### Sau đó ta có class Editor(  i.e. originator ) sử dụng các trạng thái đã lưu ở class trên: 
```php
class Editor
{
    protected $content = '';

    public function type(string $words)
    {
        $this->content = $this->content . ' ' . $words;
    }

    public function getContent()
    {
        return $this->content;
    }

    public function save()
    {
        return new EditorMemento($this->content);
    }

    public function restore(EditorMemento $memento)
    {
        $this->content = $memento->getContent();
    }
}
```

### Và bây giờ có thể sử dụng như sau:

```php
$editor = new Editor();

// Type some stuff
$editor->type('This is the first sentence.');
$editor->type('This is second.');

// Save the state to restore to : This is the first sentence. This is second.
$saved = $editor->save();

// Type some more
$editor->type('And this is third.');

// Output: Content before Saving
echo $editor->getContent(); // This is the first sentence. This is second. And this is third.

// Restoring to last saved state
$editor->restore($saved);

$editor->getContent(); // This is the first sentence. This is second.
```
## Observe
- [Observe](https://en.wikipedia.org/wiki/Observer_pattern)

Một ví dụ điển hình là những người tìm việc đăng ký vào một số trang web đăng việc và họ được thông báo bất cứ khi nào có cơ hội việc làm phù hợp.

### Trước hết, chúng ta có những người tìm việc cần được thông báo để đăng tuyển

```php
class JobPost
{
    protected $title;

    public function __construct(string $title)
    {
        $this->title = $title;
    }

    public function getTitle()
    {
        return $this->title;
    }
}

class JobSeeker implements Observer
{
    protected $name;

    public function __construct(string $name)
    {
        $this->name = $name;
    }

    public function onJobPosted(JobPost $job)
    {
        // Do something with the job posting
        echo 'Hi ' . $this->name . '! New job posted: '. $job->getTitle();
    }
}
```

### Sau đó, chúng ta có các tin tuyển dụng mà người tìm việc sẽ đăng ký 
```php
class EmploymentAgency implements Observable
{
    protected $observers = [];

    protected function notify(JobPost $jobPosting)
    {
        foreach ($this->observers as $observer) {
            $observer->onJobPosted($jobPosting);
        }
    }

    public function attach(Observer $observer)
    {
        $this->observers[] = $observer;
    }

    public function addJob(JobPost $jobPosting)
    {
        $this->notify($jobPosting);
    }
}
```

### Và bây giờ có thể sử dụng như sau:

```php
// Create subscribers
$johnDoe = new JobSeeker('John Doe');
$janeDoe = new JobSeeker('Jane Doe');

// Create publisher and attach subscribers
$jobPostings = new EmploymentAgency();
$jobPostings->attach($johnDoe);
$jobPostings->attach($janeDoe);

// Add a new job and see if subscribers get notified
$jobPostings->addJob(new JobPost('Software Engineer'));

// Output
// Hi John Doe! New job posted: Software Engineer
// Hi Jane Doe! New job posted: Software Engineer
```
## Visitor
- [Visitor](https://en.wikipedia.org/wiki/Visitor_pattern)

Visitor pattern cho phép bạn thêm các thao tác khác vào các đối tượng mà không cần phải sửa đổi chúng.

### Lấy một ví dụ về mô phỏng vườn thú nơi chúng ta có một số loại động vật khác nhau và chúng ta phải làm cho chúng phát ra âm thanh

```php
// Visitee
interface Animal
{
    public function accept(AnimalOperation $operation);
}

// Visitor
interface AnimalOperation
{
    public function visitMonkey(Monkey $monkey);
    public function visitLion(Lion $lion);
    public function visitDolphin(Dolphin $dolphin);
}
```

### Chúng ta có các triển khai interface Animal:
```php
class Monkey implements Animal
{
    public function shout()
    {
        echo 'Ooh oo aa aa!';
    }

    public function accept(AnimalOperation $operation)
    {
        $operation->visitMonkey($this);
    }
}

class Lion implements Animal
{
    public function roar()
    {
        echo 'Roaaar!';
    }

    public function accept(AnimalOperation $operation)
    {
        $operation->visitLion($this);
    }
}

class Dolphin implements Animal
{
    public function speak()
    {
        echo 'Tuut tuttu tuutt!';
    }

    public function accept(AnimalOperation $operation)
    {
        $operation->visitDolphin($this);
    }
}
```

### Và các triển khai cho visitor:

```php
class Speak implements AnimalOperation
{
    public function visitMonkey(Monkey $monkey)
    {
        $monkey->shout();
    }

    public function visitLion(Lion $lion)
    {
        $lion->roar();
    }

    public function visitDolphin(Dolphin $dolphin)
    {
        $dolphin->speak();
    }
}
```
### Chương trình có thể sử dụng như sau:
```php
$monkey = new Monkey();
$lion = new Lion();
$dolphin = new Dolphin();

$speak = new Speak();

$monkey->accept($speak);    // Ooh oo aa aa!    
$lion->accept($speak);      // Roaaar!
$dolphin->accept($speak);   // Tuut tutt tuutt!
```
### Chúng ta có thể làm tạo âm thanh đơn giản bằng cách có một hệ thống phân cấp kế thừa cho các loài động vật nhưng sau đó sẽ phải sửa đổi các loài động vật bất cứ khi nào có thêm hành động mới cho động vật. Với `visitor pattern` sẽ không phải thay đổi chúng. Ví dụ: giả sử chúng ta được yêu cầu thêm hành vi nhảy cho động vật, chúng ta có thể chỉ cần thêm hành vi đó bằng cách tạo một new visitor
```php
class Jump implements AnimalOperation
{
    public function visitMonkey(Monkey $monkey)
    {
        echo 'Jumped 20 feet high! on to the tree!';
    }

    public function visitLion(Lion $lion)
    {
        echo 'Jumped 7 feet! Back on the ground!';
    }

    public function visitDolphin(Dolphin $dolphin)
    {
        echo 'Walked on water a little and disappeared';
    }
}
```
### và cách sử dụng:
```php
$jump = new Jump();

$monkey->accept($speak);   // Ooh oo aa aa!
$monkey->accept($jump);    // Jumped 20 feet high! on to the tree!

$lion->accept($speak);     // Roaaar!
$lion->accept($jump);      // Jumped 7 feet! Back on the ground!

$dolphin->accept($speak);  // Tuut tutt tuutt!
$dolphin->accept($jump);   // Walked on water a little and disappeared
```
## Strategy
- [Strategy](https://en.wikipedia.org/wiki/Strategy_pattern)

Strategy pattern cho phép chúng ta chuyển đổi thuật toán hoặc cách triển khai dựa trên tình huống cụ thể.

### Lấy một ví dụ về các thuật toán sort với các dữ liệu khác nhau sẽ cần các thuật toán sort khác nhau:

```php
interface SortStrategy
{
    public function sort(array $dataset): array;
}

class BubbleSortStrategy implements SortStrategy
{
    public function sort(array $dataset): array
    {
        echo "Sorting using bubble sort";

        // Do sorting
        return $dataset;
    }
}

class QuickSortStrategy implements SortStrategy
{
    public function sort(array $dataset): array
    {
        echo "Sorting using quick sort";

        // Do sorting
        return $dataset;
    }
}
```

### Chúng ta có một class để sử dụng Sort:
```php
interface SortStrategy
{
    public function sort(array $dataset): array;
}

class BubbleSortStrategy implements SortStrategy
{
    public function sort(array $dataset): array
    {
        echo "Sorting using bubble sort";

        // Do sorting
        return $dataset;
    }
}

class QuickSortStrategy implements SortStrategy
{
    public function sort(array $dataset): array
    {
        echo "Sorting using quick sort";

        // Do sorting
        return $dataset;
    }
}
```

### Chương trình có thể sử dụng như sau:
```php
interface SortStrategy
{
    public function sort(array $dataset): array;
}

class BubbleSortStrategy implements SortStrategy
{
    public function sort(array $dataset): array
    {
        echo "Sorting using bubble sort";

        // Do sorting
        return $dataset;
    }
}

class QuickSortStrategy implements SortStrategy
{
    public function sort(array $dataset): array
    {
        echo "Sorting using quick sort";

        // Do sorting
        return $dataset;
    }
}
```
## State
- [State](https://en.wikipedia.org/wiki/State_pattern)

Lấy một ví dụ về trình soạn thảo văn bản, nó cho phép bạn thay đổi trạng thái của văn bản được nhập, tức là nếu bạn đã chọn in đậm, nó sẽ bắt đầu viết in đậm, nếu nghiêng thì viết nghiêng, v.v.

### Trước hết, chúng ta có interface  WritingState và triển khai của nó:

```php
interface WritingState
{
    public function write(string $words);
}

class UpperCase implements WritingState
{
    public function write(string $words)
    {
        echo strtoupper($words);
    }
}

class LowerCase implements WritingState
{
    public function write(string $words)
    {
        echo strtolower($words);
    }
}

class DefaultText implements WritingState
{
    public function write(string $words)
    {
        echo $words;
    }
}
```

### Tiếp đó là trình soạn thảo TextEditor:
```php
class TextEditor
{
    protected $state;

    public function __construct(WritingState $state)
    {
        $this->state = $state;
    }

    public function setState(WritingState $state)
    {
        $this->state = $state;
    }

    public function type(string $words)
    {
        $this->state->write($words);
    }
}
```

### Chương trình có thể sử dụng như sau:
```php
$editor = new TextEditor(new DefaultText());

$editor->type('First line');

$editor->setState(new UpperCase());

$editor->type('Second line');
$editor->type('Third line');

$editor->setState(new LowerCase());

$editor->type('Fourth line');
$editor->type('Fifth line');

// Output:
// First line
// SECOND LINE
// THIRD LINE
// fourth line
// fifth line
```

## Template Method
- [Template Method](https://en.wikipedia.org/wiki/Template_method_pattern)

Template Method xác định cách một thuật toán nhất định có thể được thực hiện, việc triển khai các bước đó để cho các lớp con.

### Ví dụ chúng ta có tool giúp xây dựng, test,... trên các hệ thống khác nhau. Đầu tiên ta phải lớp cơ sở chỉ định khung cho các thuật toán của tool
```php
abstract class Builder
{

    // Template method
    final public function build()
    {
        $this->test();
        $this->lint();
        $this->assemble();
        $this->deploy();
    }

    abstract public function test();
    abstract public function lint();
    abstract public function assemble();
    abstract public function deploy();
}
```
### Sau đó là triển khai của các thuật toán được khai báo ở trên:
```php
class AndroidBuilder extends Builder
{
    public function test()
    {
        echo 'Running android tests';
    }

    public function lint()
    {
        echo 'Linting the android code';
    }

    public function assemble()
    {
        echo 'Assembling the android build';
    }

    public function deploy()
    {
        echo 'Deploying android build to server';
    }
}

class IosBuilder extends Builder
{
    public function test()
    {
        echo 'Running ios tests';
    }

    public function lint()
    {
        echo 'Linting the ios code';
    }

    public function assemble()
    {
        echo 'Assembling the ios build';
    }

    public function deploy()
    {
        echo 'Deploying ios build to server';
    }
}
```
### Chúng ta có thể sử dụng `template method` trong chương trình như sau:
```php
$androidBuilder = new AndroidBuilder();
$androidBuilder->build();

// Output:
// Running android tests
// Linting the android code
// Assembling the android build
// Deploying android build to server

$iosBuilder = new IosBuilder();
$iosBuilder->build();

// Output:
// Running ios tests
// Linting the ios code
// Assembling the ios build
// Deploying ios build to server
```
Sử dụng `template method pattern` giúp tái sử dụng code (reuse), tránh trùng lặp code (duplicate): đưa những phần trùng lặp vào lớp cha (abstract class) và cho phép người dùng override chỉ một số phần nhất định của thuật toán lớn, làm cho chúng ít bị ảnh hưởng hơn bởi những thay đổi xảy ra với các phần khác của thuật toán.
