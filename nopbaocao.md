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
TranslatorAdapter.java
package com.gpcoder.patterns.structural.adapter;
 
public class TranslatorAdapter implements VietnameseTarget {
 
    private JapaneseAdaptee adaptee;
 
    public TranslatorAdapter(JapaneseAdaptee adaptee) {
        this.adaptee = adaptee;
    }
 
    @Override
    public void send(String words) {
        System.out.println("Reading Words ...");
        System.out.println(words);
        String vietnameseWords = this.translate(words);
        System.out.println("Sending Words ...");
        adaptee.receive(vietnameseWords);
    }
 
    private String translate(String vietnameseWords) {
        System.out.println("Translated!");
        return "こんにちは";
    }
}

🚡 Bridge
------
Ví Dụ
> Xem xét bạn có một trang web với các trang khác nhau và bạn phải cho phép người dùng thay đổi chủ đề. Anh sẽ làm gì? Tạo nhiều bản sao của mỗi trang cho mỗi chủ đề hay bạn sẽ chỉ tạo chủ đề riêng biệt và tải chúng dựa trên sở thích của người dùng? Mô hình cầu cho phép bạn thực hiện lần thứ hai tức là.

> Mô hình Cầu là về việc ưu tiên thành phần hơn thừa kế. Chi tiết thực hiện được đẩy từ hệ thống phân cấp sang đối tượng khác với hệ thống phân cấp riêng biệt.

![](https://cloud.githubusercontent.com/assets/11269635/23065293/33b7aea0-f515-11e6-983f-98823c9845ee.png)

theo Wikipedia
> Mô hình cầu là một mô hình thiết kế được sử dụng trong kỹ thuật phần mềm có nghĩa là "tách rời một sự trừu tượng từ việc thực hiện nó để cả hai có thể thay đổi độc lập"

🌿 Composite
-----------------
Ví Dụ
> Mọi tổ chức đều bao gồm nhân viên. Mỗi nhân viên có các tính năng giống nhau, tức là có mức lương, có một số trách nhiệm, có thể hoặc không thể báo cáo cho ai đó, có thể có hoặc không có một số cấp dưới, v.v.

> Mô hình Composite cho phép khách hàng xử lý các đối tượng riêng lẻ một cách thống nhất.

Theo Wikipedia
> Trong kỹ thuật phần mềm, mô hình composite là một mô hình thiết kế phân vùng. Mô hình tổng hợp mô tả rằng một nhóm các đối tượng sẽ được xử lý theo cách tương tự như một trường hợp duy nhất của một đối tượng. Mục đích của một hỗn hợp là "soạn" các đối tượng thành các cấu trúc cây để đại diện cho các hệ thống phân cấp toàn bộ một phần. Thực hiện mô hình tổng hợp cho phép khách hàng xử lý các đối tượng và bố cục riêng lẻ một cách thống nhất.

☕ Decorator
-------------
Ví Dụ
> Hãy tưởng tượng bạn điều hành một cửa hàng dịch vụ xe hơi cung cấp nhiều dịch vụ. Bây giờ làm thế nào để bạn tính toán hóa đơn sẽ được tính phí? Bạn chọn một dịch vụ và tự động tiếp tục thêm vào nó giá cho các dịch vụ được cung cấp cho đến khi bạn nhận được chi phí cuối cùng. Ở đây mỗi loại dịch vụ là một nhà trang trí.

> Mẫu Trang trí cho phép bạn tự động thay đổi hành vi của một đối tượng tại thời điểm chạy bằng cách bọc chúng trong một đối tượng của lớp trang trí.

📦 Facade
----------------

> Làm thế nào để bạn bật máy tính? "Nhấn nút nguồn", bạn nói! Đó là những gì bạn tin bởi vì bạn đang sử dụng một giao diện đơn giản mà máy tính cung cấp ở bên ngoài, bên trong nó phải làm rất nhiều thứ để làm cho nó xảy ra. Giao diện đơn giản này cho hệ thống con phức tạp là một mặt tiền.

> Mẫu Mặt tiền cung cấp một giao diện đơn giản cho một hệ thống con phức tạp.

🍃 Flyweight
---------

> Bạn đã bao giờ uống trà tươi từ một quầy hàng nào đó chưa? Họ thường làm nhiều hơn một cốc mà bạn yêu cầu và tiết kiệm phần còn lại cho bất kỳ khách hàng nào khác để tiết kiệm tài nguyên ví dụ như khí đốt, v.v. Mô hình flyweight là tất cả về đó tức là chia sẻ.

> Nó được sử dụng để giảm thiểu việc sử dụng bộ nhớ hoặc chi phí tính toán bằng cách chia sẻ càng nhiều càng tốt với các đối tượng tương tự.

🎱 Proxy
-------------------
> Bạn đã bao giờ sử dụng thẻ truy cập để đi qua một cánh cửa? Có nhiều tùy chọn để mở cánh cửa đó tức là nó có thể được mở bằng thẻ truy cập hoặc bằng cách nhấn một nút bỏ qua bảo mật. Chức năng chính của cánh cửa là mở nhưng có một proxy được thêm vào trên nó để thêm một số chức năng. Hãy để tôi giải thích rõ hơn bằng cách sử dụng ví dụ mã dưới đây.

> Sử dụng mẫu proxy, một lớp đại diện cho chức năng của một lớp khác.

Behavioral Design Patterns
==========================

🔗 Chain of Responsibility
-----------------------

> Ví dụ: bạn có ba phương thức thanh toán ('A', 'B' và 'C') trong tài khoản của mình; Mỗi người có một số tiền khác nhau trong đó. 'A' có 100 USD, 'B' có 300 USD và 'C' có 1000 USD và ưu tiên thanh toán được chọn là 'A' sau đó 'B' sau đó 'C'. Bạn cố gắng mua một cái gì đó trị giá 210 USD. Sử dụng Chuỗi trách nhiệm, trước hết tài khoản 'A' sẽ được kiểm tra xem nó có thể mua hàng hay không, nếu có mua sẽ được thực hiện và chuỗi sẽ bị hỏng. Nếu không, yêu cầu sẽ chuyển tiếp đến tài khoản 'B' kiểm tra số tiền nếu chuỗi có sẽ bị hỏng nếu không yêu cầu sẽ tiếp tục chuyển tiếp cho đến khi nó tìm thấy người xử lý phù hợp. Ở đây 'A', 'B' và 'C' là các liên kết của chuỗi và toàn bộ hiện tượng là Chuỗi trách nhiệm.

> Nó giúp xây dựng một chuỗi các đối tượng. Yêu cầu nhập từ một đầu và tiếp tục đi từ đối tượng này sang đối tượng khác cho đến khi nó tìm thấy trình xử lý phù hợp.

👮 Command
-------

> Một ví dụ chung sẽ là bạn đặt thức ăn tại một nhà hàng. Bạn (tức là 'Khách hàng') yêu cầu người phục vụ (tức là 'Invoker') mang theo một số thực phẩm (tức là 'Lệnh') và người phục vụ chỉ đơn giản là chuyển tiếp yêu cầu cho Đầu bếp (tức là 'Người nhận') người có kiến thức về những gì và cách nấu ăn.
> Một ví dụ khác sẽ là bạn (tức là 'Khách hàng') bật (tức là 'Lệnh') tv (tức là 'Người nhận') bằng cách sử dụng điều khiển từ xa ('Invoker').

> Cho phép bạn gói gọn các hành động trong các đối tượng. Ý tưởng chính đằng sau mô hình này là cung cấp các phương tiện để tách rời khách hàng khỏi người nhận.

➿ Iterator
--------
> Một bộ radio cũ sẽ là một ví dụ điển hình về máy lặp lại, nơi người dùng có thể bắt đầu ở một số kênh và sau đó sử dụng các nút tiếp theo hoặc trước đó để đi qua các kênh tương ứng. Hoặc lấy một ví dụ về máy nghe nhạc MP3 hoặc tv nơi bạn có thể nhấn các nút tiếp theo và trước đó để đi qua các kênh liên tiếp hoặc nói cách khác là tất cả chúng đều cung cấp giao diện để lặp lại thông qua các kênh, bài hát hoặc đài phát thanh tương ứng.  

> Nó trình bày một cách để truy cập các yếu tố của một đối tượng mà không để lộ bản trình bày bên dưới.

👽 Mediator
========

> Một ví dụ chung sẽ là khi bạn nói chuyện với ai đó trên điện thoại di động của mình, có một nhà cung cấp mạng ngồi giữa bạn và họ và cuộc trò chuyện của bạn đi qua nó thay vì được gửi trực tiếp. Trong trường hợp này, nhà cung cấp mạng là trung gian hòa giải.

> mẫu Hòa giải viên thêm một đối tượng của bên thứ ba (được gọi là hòa giải) để kiểm soát sự tương tác giữa hai đối tượng (được gọi là đồng nghiệp). Nó giúp giảm sự kết hợp giữa các lớp giao tiếp với nhau. Bởi vì bây giờ họ không cần phải có kiến thức về việc thực hiện của nhau.

💾 Memento
-------

> Lấy ví dụ về máy tính (tức là người khởi xướng), trong đó bất cứ khi nào bạn thực hiện một số phép tính, phép tính cuối cùng được lưu trong bộ nhớ (tức là vật lưu niệm) để bạn có thể quay lại với nó và có thể khôi phục nó bằng một số nút hành động (tức là người chăm sóc).

> mô hình Memento là về việc chụp và lưu trữ trạng thái hiện tại của một đối tượng theo cách mà nó có thể được khôi phục sau này một cách trơn tru.

😎 Observer
--------

> Một ví dụ điển hình sẽ là những người tìm việc nơi họ đăng ký một số trang web đăng tuyển dụng và họ được thông báo bất cứ khi nào có cơ hội việc làm phù hợp.   

> Xác định sự phụ thuộc giữa các đối tượng để bất cứ khi nào một đối tượng thay đổi trạng thái của nó, tất cả những người phụ thuộc của nó đều được thông báo.

🏃 Visitor
-------

> xem xét ai đó đến thăm Dubai. Họ chỉ cần một cách (tức là visa) để vào Dubai. Sau khi đến, họ có thể tự đến thăm bất kỳ nơi nào ở Dubai mà không cần phải xin phép hoặc làm một số công việc chân để ghé thăm bất kỳ nơi nào ở đây; Chỉ cần cho họ biết về một nơi và họ có thể ghé thăm nó. Mô hình khách truy cập cho phép bạn làm điều đó, nó giúp bạn thêm địa điểm để ghé thăm để họ có thể ghé thăm càng nhiều càng tốt mà không phải làm bất kỳ công việc chân tay nào.

> mẫu Khách truy cập cho phép bạn thêm các thao tác tiếp theo vào các đối tượng mà không cần phải sửa đổi chúng.

💡 Strategy
--------

> Xem xét ví dụ về phân loại, chúng tôi đã thực hiện phân loại bong bóng nhưng dữ liệu bắt đầu phát triển và phân loại bong bóng bắt đầu trở nên rất chậm. Để giải quyết vấn đề này, chúng tôi đã thực hiện loại Nhanh. Nhưng bây giờ mặc dù thuật toán sắp xếp nhanh đã hoạt động tốt hơn cho các bộ dữ liệu lớn, nhưng nó rất chậm đối với các bộ dữ liệu nhỏ hơn. Để xử lý điều này, chúng tôi đã thực hiện một chiến lược trong đó đối với các bộ dữ liệu nhỏ, loại bong bóng sẽ được sử dụng và để sắp xếp lớn hơn, nhanh chóng.

> mô hình Chiến lược cho phép bạn chuyển đổi thuật toán hoặc chiến lược dựa trên tình huống.


💢 State
-----

> Hãy tưởng tượng bạn đang sử dụng một số ứng dụng vẽ, bạn chọn bàn chải sơn để vẽ. Bây giờ bàn chải thay đổi hành vi của nó dựa trên màu đã chọn tức là nếu bạn đã chọn màu đỏ, nó sẽ vẽ màu đỏ, nếu màu xanh thì nó sẽ có màu xanh, v.v.  

> Nó cho phép bạn thay đổi hành vi của một lớp khi trạng thái thay đổi.

📒 Template Method
---------------

> giả sử chúng ta đang xây dựng một ngôi nhà nào đó. Các bước để xây dựng có thể trông giống như
> - Chuẩn bị cơ sở nhà
> - Xây dựng các bức tường
> - Thêm mái nhà
> - Thêm các tầng khác

> Thứ tự của các bước này không bao giờ có thể được thay đổi, tức là bạn không thể xây dựng mái nhà trước khi xây dựng các bức tường vv nhưng mỗi bước có thể được sửa đổi ví dụ như tường có thể được làm bằng gỗ hoặc polyester hoặc đá.

> Phương pháp Mẫu > xác định bộ xương về cách một thuật toán nhất định có thể được thực hiện, nhưng trì hoãn việc thực hiện các bước đó cho các lớp học dành cho trẻ em.


