# Pattern

** FactoryMethod:**
* Giống: 
Sử dụng mẫu thiết kế Factory pattern: là một trong những Pattern thuộc nhóm Creational Design Pattern.
Factory class là SimpleVehicleFactory khởi tạo các sub class
Factory Method cho phép các lớp con chọn kiểu đối tượng cần tạo, giúp cho việc khởi tạo đối tượng một cách linh hoạt hơn.
Có Super Class , Factory Class, Sub classes
* Khác :
Các lớp giao diện người dùng cụ thể.
Sự phụ thuộc của các đối tượng mà mã của bạn sẽ hoạt động.

** Flyweight **
* Giống nhau:
Cung cấp một giao diện đơn giản hóa cho một thư viện, một khuôn khổ hoặc bất kỳ tập hợp lớp phức tạp nào khác.
Các Facade cung cấp truy cập thuận tiện đối với một phần cụ thể của chức năng của hệ thống phụ.
* Khác nhau:
Các hệ thống con trở nên phức tạp hơn theo thời gian.


** Observer:**
* Giống:
Cho phép xác định cơ chế đăng ký để thông báo cho nhiều đối tượng về bất kỳ sự kiện nào xảy ra với đối tượng mà họ đang quan sát.

hạn chế về phạm vi áp dụng.


** Prototype:**
* Giống:
có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new
Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.

* Khác: 


** Proxy:**
* Giông:
Tất cả các truy cập trực tiếp đến một đối tượng nào đó sẽ được chuyển hướng vào một đối tượng trung gian
Mẫu Proxy (người đại diện) đại diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với múc đích sử dụng.


* Khác:

Có thể trì hoãn việc khởi tạo đối tượng đến thời điểm thực sự cần thiết.

** Singleton:**
* Giống:
Đảm bảo rằng chỉ có một instance của lớp.
Việc quản lý việc truy cập tốt hơn vì chỉ có một thể hiện duy nhất.
Có thể quản lý số lượng thể hiện của một lớp trong giớn hạn chỉ định.


* Khác:
Một đối tượng cơ sở dữ liệu duy nhất được chia sẻ bởi các phần khác nhau của chương trình.



** State**
* Giống:
cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. 
Đối tượng sẽ xuất hiện để thay đổi lớp của nó.

* Khác:
Số lượng trạng thái là rất lớn và mã của trạng thái cụ thể thường xuyên thay đổi.

** Strategy:**

* Giống:
cho phép định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và dễ dàng thay đổi linh hoạt các thuật toán bên trong object.
cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng.



** visitor:**
* Giống:
Tách các thuật toán khỏi các đối tượng mà chúng hoạt động trên đó.
Mỗi phương thức có thể nhận các đối số thuộc các kiểu khác nhau
* Khác:
Chấp nhận các đối tượng của các lớp có liên quan, để trống phần còn lại.
