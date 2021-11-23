## Báo cáo về mẫu thiết kế (Design Pattern)


<details>
  <summary><strong>Table of Contents</strong></summary>
  <ol>
    <li>
      <a href="#Thànhviên">Introduction</a>
    </li>
    <li>
      <a href="#demo-image">Demo Image</a>
      <ul>
        <li><a href="#translate-word">Translate Word</a></li>
        <li><a href="#translate-sentence">Translate Sentence</a></li>
        <li><a href="#bookmark">Bookmark</a></li>
      </ul>
    </li>
    <li><a href="#translate-api">Translate API</a></li>
    <li><a href="#database">Database</a></li>
    <li><a href="#libraries">Libraries</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>
<br />

## Thành viên
- Lê Trung Hiếu ([@naslth](https://github.com/naslth)) - 20021354.
- Nguyễn Đình Hoàng ([@hoangndst](https://github.com/hoangndst)) - 20021361. 

### Đường dẫn tới project tham khảo 
- [GitHub](https://github.com/iluwatar/java-design-patterns)

## Nội dung

- [Creational](#creational-design-patterns)
- [Structural](#structural-design-patterns)
- [Behavioral](#behavioral-design-patterns)


## Creational Design Patterns
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

Giao diện `Door` và một số triển khai.
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
Sau đó, chia thành một số chuyên gia về lắp đặt cho từng loại cửa.
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

Bây giờ tạo nhà máy trừu tượng cho phép sản xuất các đồ vật liên quan, tức là nhà máy sản xuất cửa gỗ sẽ tạo ra một chuyên gia lắp đặt cửa gỗ và cửa gỗ và nhà máy sản xuất cửa sắt sẽ tạo ra một chuyên gia lắp cửa sắt và cửa sắt.

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

Sử dụng:
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

#### Sử dụng khi:
Khi có các phụ thuộc liên quan với nhau với logic sáng tạo không đơn giản liên quan.