# So sánh với mẫu chuẩn

Thành viên:

- Trần Minh Trí
- Cấn Quang Thịnh
- Luyện Huy Tín


🏠 Simple Factory
--------------
Xem xét một ví dụ

> Giả sử bạn muốn một cái ghế, thì bạn có 2 lựa chọn là lấy gỗ, đinh
>, keo để tự làm cái ghế đó. Hoặc bạn sẽ ra cửa hàng hoặc lên shopee mua cái có sẵn
> mà không cần bất kì kinh nghiệm hay kiến thức nào về làm ghế

Nói cách khác
> Simple factory chỉ cần tạo một phiên bản cho máy khách mà không để lộ bất kỳ logic khởi tạo nào cho máy khách

Theo Wikipedia
>Trong lập trình hướng đối tượng (OOP), factory là một đối tượng để tạo các đối tượng khác - chính thức nhà máy là một hàm hoặc phương thức trả về các đối tượng của một nguyên mẫu hoặc lớp khác nhau từ một số lệnh gọi phương thức, được giả định là "mới".

**Program Example**

First of all we have a door interface and the implementation
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

```php
class DoorFactory
{
    public static function makeDoor($width, $height): Door
    {
        return new WoodenDoor($width, $height);
    }
}
```

```php
// Make me a door of 100x200
$door = DoorFactory::makeDoor(100, 200);

echo 'Width: ' . $door->getWidth();
echo 'Height: ' . $door->getHeight();

// Make me a door of 50x100
$door2 = DoorFactory::makeDoor(50, 100);
```


🏭 Factory Method
--------------

Ví dụ thực tế
>Hãy xem xét trường hợp của một người quản lý tuyển dụng. Không thể có một người phỏng vấn cho mỗi vị trí. Dựa trên cơ hội việc làm, ta phải quyết định và giao các bước phỏng vấn cho những người khác nhau

In plain words
>Nó cung cấp một cách để ủy quyền logic khởi tạo cho các lớp con

Theo Wikipedia
>Trong lập trình dựa trên lớp, mẫu phương thức gốc là một mẫu sáng tạo sử dụng các phương thức gốc để giải quyết vấn đề tạo đối tượng mà không cần phải chỉ định chính xác lớp của đối tượng sẽ được tạo. Điều này được thực hiện bằng cách tạo các đối tượng bằng cách gọi một phương thức gốc — hoặc được chỉ định trong một giao diện và được thực thi bởi các lớp con, hoặc được thực hiện trong một lớp cơ sở và được ghi đè tùy chọn bởi các lớp dẫn xuất — chứ không phải bằng cách gọi một phương thức khởi tạo.

**Programmatic Example**

Taking our hiring manager example above. First of all we have an interviewer interface and some implementations for it


🔨 Abstract Factory
----------------

Ví dụ
> Extending our door example from Simple Factory. Based on your needs you might get a wooden door from a wooden door shop, iron door from an iron shop or a PVC door from the relevant shop. Plus you might need a guy with different kind of specialities to fit the door, for example a carpenter for wooden door, welder for iron door etc. As you can see there is a dependency between the doors now, wooden door needs carpenter, iron door needs a welder etc.

Định nghĩa
>Nhà máy của các nhà máy; một nhà máy nhóm các nhà máy cá nhân nhưng liên quan / phụ thuộc lại với nhau mà không chỉ định các lớp cụ thể của họ.

Theo Wikipedia
> Mô hình nhà máy trừu tượng cung cấp một cách để gói gọn một nhóm các nhà máy riêng lẻ có một chủ đề chung mà không chỉ định các lớp cụ thể của họ.




👷 Builder
--------------------------------------------

>Hãy tưởng tượng bạn đang ở Hardee và bạn đặt hàng một thỏa thuận cụ thể, hãy nói, "Big Hardee" và họ giao nó cho bạn mà không có bất kỳ câu hỏi nào; Đây là ví dụ về nhà máy đơn giản. Nhưng có những trường hợp khi logic tạo có thể liên quan đến nhiều bước hơn. Ví dụ: bạn muốn có một thỏa thuận Subway tùy chỉnh, bạn có một số tùy chọn trong cách bánh mì kẹp thịt của bạn được làm, ví dụ như bánh mì nào bạn muốn? Bạn thích loại nước sốt nào? Bạn muốn phô mai gì? v.v. Trong những trường hợp như vậy, mô hình xây dựng đến để giải cứu.

Nói cách khác
> Cho phép bạn tạo ra các kiểu khác nhau của một đối tượng trong khi tránh làm rắc rối constructor. Hữu ích khi có thể có một số hương vị của một đối tượng. Hoặc khi có rất nhiều bước liên quan đến việc tạo ra một đối tượng.

Wikipedia
> Mô hình xây dựng là một mô hình thiết kế phần mềm tạo đối tượng với ý định tìm giải pháp cho trình anti-pattern.

🐑 Prototype
------------

>Còn nhớ dolly không? Con cừu đã được nhân bản! Đừng đi vào chi tiết nhưng điểm mấu chốt ở đây là đó là tất cả về nhân bản

Nói cách khác
> Tạo đối tượng dựa trên một đối tượng hiện có thông qua nhân bản.


Nói tóm lại, nó cho phép bạn tạo một bản sao của một đối tượng hiện có và sửa đổi nó theo nhu cầu của bạn, thay vì trải qua rắc rối khi tạo ra một đối tượng từ đầu và thiết lập nó.
**Programmatic Example**


```php
package com.gpcoder.patterns.creational.prototype.computer;
 
public class Computer implements Cloneable {
    private String os;
    private String office;
    private String antivirus;
    private String browser;
    private String others;
 
    public Computer(String os, String office, String antivirus, String browser, String other) {
        super();
        this.os = os;
        this.office = office;
        this.antivirus = antivirus;
        this.browser = browser;
        this.others = other;
    }
 
    @Override
    protected Computer clone() {
        try {
            return (Computer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public String toString() {
        return "Computer [os=" + os + ", office=" + office + ", antivirus=" + antivirus + ", browser=" + browser
                + ", others=" + others + "]";
    }
 
    public void setOthers(String others) {
        this.others = others;
    }
}


Singleton Class được khởi tạo ngay khi được gọi đến. Đây là cách dễ nhất nhưng nó có một nhược điểm mặc dù instance đã được khởi tạo mà có thể sẽ không dùng tới.
package com.gpcoder.patterns.creational.singleton;
 
public class EagerInitializedSingleton {
 
    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();
 
    // Private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton() {
         
    }
 
    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }
}
```
