### [Link repo so sánh](https://github.com/kamranahmedse/design-patterns-for-humans.git)
### [Link repo gốc](https://refactoring.guru/design-patterns)
# Bài thu hoạch OOP.
## Thành Viên Nhóm:
- Trịnh Công Vinh
- Trương Văn Độ
- Mai Hoàng Anh

## Lời mở đầu
- Repo này không phải là một dự án thực tế nhưng lại là một repo hay để hiểu thêm về các mẫu thiết kế trong lập trình hướng đối tượng. Điểm mạnh của repo này là có giải thích rõ ràng, có code minh họa và có đưa ví dụ liên quan đến thực tế để người đọc nắm rõ hơn thay vì một cách hàn lâm làm cho những người mới bắt đầu tìm hiểu về các mẫu lập trình bị khó hiểu và không biết tại sao lại phải sử dụng các mẫu thiết kế đó.
- repo này đã chỉ ra một cách rõ ràng về những hiểu lầm mà những người mới bát đầu tìm hiểu thường bị mắc phải, được trích nguyên văn sau đây:
>  - **Design patterns are not a silver bullet to all your problems.**
>  - **Do not try to force them; bad things are supposed to happen, if done so.**
>  - **Keep in mind that design patterns are solutions to problems, not solutions finding problems; so don't overthink.**
>  - **If used in a correct place in a correct manner, they can prove to be a savior; or else they can result in a horrible mess of a code.**

- 23 mẫu thiết kế được chia thành 3 nhóm chính là:
    - Creational
    - Structural
    - Behavioral
- Trong bài thu hoạch này nhóm xin trình bày 2 nhóm là **Creational** và **Stuctural**.
# Nhóm thứ nhất Creational
- Trong nhóm thứ nhất này chúng ta sẽ xét đến 2 mẫu thiết kế được sử dụng khá phổ biến là factory method và abstract factory.
 - Giải thích được định nghĩa, lấy ví dụ thực tế, rõ ràng dễ hiểu.
 - Đưa ra được khi nào nên sử dụng trong thực tế.
 - **Tác giả đã giải thích được sự khác nhau giữa factory method và factory abstract.**
### 1. Factory method:
    Được dùng để tạo ra một object nhưng mà lớp con sẽ quyết định coi lớp cha nào sẽ được khởi tạo
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
tạo thêm một abstract class HiringManager
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
thêm một class con
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
trong hàm main:
```php
$devManager = new DevelopmentManager();
$devManager->takeInterview(); // Output: Asking about design patterns

$marketingManager = new MarketingManager();
$marketingManager->takeInterview(); // Output: Asking about community building.
```
Có thể thấy từ đoạn code trên, dựa vào lớp con mà lớp cha sẽ sử dụng cái nào và sẽ có output khác nhau. Ví dụ dựa vào lớp con, cụ thể nếu là tuyển một **DevelopmentManager()** thì dựa trên đoạn code trên thì lớp cha sẽ lấy một interviewer là **Developer** chứ không phải là **CommunityExecutive**.

### 2. Factory abstract: 
    Được định nghĩa một interface hoặc lớp trừu tượng (abstract) để tạo ra các họ hàng của các đối tượng liên quan (hoặc phụ thuộc) mà không cần chỉ rõ các lớp con cụ thể của chúng.
- Nói một cách dễ hiểu trong repo này tác giả đã lấy ví dụ về cửa gỗ và thợ làm cửa gỗ, hay cửa nhôm thì sẽ đi với thợ sửa cửa nhôm.
- Hai class Door và DoorFittingExpert sau khi được khởi tạo thì sẽ được gọi thông qua các con của interface class DoorFactory và được sử dụng trong hàm main cụ thể như sau.
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
Có thể thấy với mỗi loại cửa khác nhau sẽ gọi đến những gì liên quan đến nó hay là phải quan tâm đến những lớp con của của nó ví dụ như hàm **makeDoor()**  hay là hàm **MakeFittingExpert()**. 

# Nhóm thứ hai Structural
    Trong nhóm thứ hai này chúng ta sẽ xét đến 2 mẫu thiết kế được sử dụng khá phổ biến là adapter pattern và decorator pattern.
- Giải thích được định nghĩa, lấy ví dụ thực tế, rõ ràng dễ hiểu.
- Đưa ra được khi nào nên sử dụng trong thực tế.
- **Tác giả đã giải thích được sự khác nhau giữa adapter pattern và decorator pattern.**
### 1. adapter pattern: là một mẫu thiết kế phần mềm cho phép giao diện của một lớp hiện có được sử dụng như một giao diện khác. Nó thường được sử dụng để làm cho các lớp hiện có hoạt động với những lớp khác mà không cần sửa đổi mã nguồn của chúng.
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
tạo thêm một class Hunter
```php
class Hunter
{
    public function hunt(Lion $lion)
    {
        $lion->roar();
    }
}
```
thêm một class con
```php
class WildDog
{
    public function bark()
    {
    }
}

// Adapter around wild dog to make it compatible with our game
class WildDogAdapter implements Lion
{
    protected $dog;

    public function __construct(WildDog $dog)
    {
        $this->dog = $dog;
    }

    public function roar()
    {
        $this->dog->bark();
    }
}
```
khi đó chúng ta có thể gọi WilDog thông qua WildDogAdapter:
```php
$wildDog = new WildDog();
$wildDogAdapter = new WildDogAdapter($wildDog);

$hunter = new Hunter();
$hunter->hunt($wildDogAdapter);
```
Có thể thấy từ đoạn code mẫu trên Adapter pattern cho phép bạn bọc một đối tượng không tương thích khác trong bộ điều hợp để làm cho nó tương thích với một lớp khác trong trường hợp này là lớp WildDog.

### 2. decorator pattern: là một mẫu thiết kế cho phép thêm hành vi vào một đối tượng riêng lẻ, tĩnh hoặc động, mà không ảnh hưởng đến hành vi của các đối tượng khác từ cùng một lớp.
- Trong mẫu thiết kế này tác giả đã lấy ví dụ về cà phê và những miêu tả thêm về chúng.

đầu tiên tạo ra interface Coffee và lớp SimpleCoffee
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

tạo thêm decorators cho lớp Coffee
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
khi khởi tạo chúng ta có thể :
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
Có thể thấy **someCoffee** có thể có thêm nhiều decorators cho phép bạn tự động thay đổi hành vi của **someCoffee** tại thời điểm chạy bằng cách gói chúng trong một đối tượng của lớp decorator.

# Summary
**Giống nhau:**
- Các mẫu thiết kế có cấu trúc khá giống trong repo gốc.
- Các ví dụ được đưa ra tường minh và dễ hiểu.

**Khác nhau:**

- Không có sự khác nhau, đây là một mẫu thiết kế gần như giống hệt so với mẫu chuẩn về mọi mặt.
