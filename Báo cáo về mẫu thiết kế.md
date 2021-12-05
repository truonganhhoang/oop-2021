> # Lớp: INT2204_21
> # Thành viên: 
>* Phạm Thị Khánh Linh 20020324	
>* Lê Phương Uyên 20021475	
>* Phan Hiền An 20021281	
>### Repo: https://github.com/youlookwhat/DesignPattern

## **1. Nhóm Creational**
### Singleton:
- Giống nhau: giống nhau hoàn toàn.
    - Implement Singleton Pattern bằng cách **Bill Pugh Singleton Implementation:**
        - Sử dụng 1 static nested class với vai trò 1 helper khi muốn tách biệt chức năng cho 1 class function rõ ràng hơn.
- Khác nhau: không có sự khác nhau.

### Factory Pattern:
- Giống nhau:
    - 1 Super Class là 1 Abstract Class - *RoujiaMoStore* đại diện cho cửa hàng bán bánh Rou Ji A nói chung.
    - Các Sub Class là các chi nhánh cửa hàng. *(XianKuRoujiMo, XianSuanRoujiMo, XianlaRoujiMo, XianSuanRoujiMo)*
    - 1 Factory Class - *XianSimpleRoujiaMoFactory* sẽ nhận input rồi trả lại chi nhánh tương ứng.
- Khác nhau: không có sự khác nhau.

### Abstract Factory:
- Giống nhau:
    - **Abstract Factory:** 1 Interface *RouJiaMoYLFactroy* chứa các phương thức tạo đối tượng là nguyên liệu làm ra món Rou Ji A. (Meat, Yuan Liao).
    - **Product** Các đối tượng Meat, Yuan Liao có các class con (đối tượng cụ thể): *XianFreshMeet*, *ChangShaFreshMeet, XianFreshYuanLiao*, *ChangShaFreshMeetYuanLiao,...)* là các ****Concrete Factory.**
    - **Client**: RoujiaMo.java
- Khác nhau: Abstract Factory chứa phương thức tạo đối tượng không phải abstract *(Meat, Yuan Liao) →* **Không có Abstract Product** mà chỉ có class thường.

### Builder:
- Giống nhau: có **Builder** *(Builder.java)* là 1 abstract class và được kế thừa bởi 1 **ConcreteBuilder** *(ConcreteBuider.java)*, có **Director** *(Director.java)* để gọi tới Builder.
- Khác nhau: không có sự khác nhau.

### Prototype:
- Giống nhau:
    - **Prototype:** 1 abstract Shape *(Shape.java) implements* `Cloneable`.
    - **ConcretePrototype:** *ShapeCache.java*
- Khác nhau: không có sự khác nhau.

## **2. Nhóm Structural**
> Các mẫu có kết cấu giống với mẫu chuẩn, không có sự khác nhau, gần như giống hệt so với mẫu chuẩn về mọi mặt.
### Adapter:
Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
Giống:
* Gồm các thành phần cơ bản: Adaptee, Adapter, Target, Client.
* Ở đây có thể thấy rằng điện thoại di động dựa trên một giao diện cung cấp điện áp 5V, còn điện gia đình là 220V. Vì vậy cần phải có **Adapter** (bucker) để sạc điện thoại di động.
The v5 interface is passed in, and classes that implement this interface can also be passed in
Khác: 
* Cơ bản giống với mẫu thiết kế chuẩn

### Bridge
Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (abstraction và implementation) có thể thay đổi độc lập nhau. 
Giống: 
* Lấy việc vẽ hình tròn với nhiều màu sắc khác nhau làm ví dụ. Tạo một lớp triển khai cầu nối thực thể triển khai giao diện DrawAPI: draw a read circle và draw a green circle
* Về cấu trúc, gồm 4 thành phần cơ bản: Client, Abstraction, Refined Abstraction (AbstractionImpl), Implementor, ConcreteImplementor...
* Các bước: 
1. Tạo cầu nối để thực hiện giao diện.
2. Tạo một lớp triển khai cầu nối thực thể triển khai giao diện DrawAPI. RedCircle , GreenCircle
3. Sử dụng giao diện DrawAPI để tạo một lớp trừu tượng: Shape.
4. Tạo một lớp thực thể thực hiện giao diện Shape.
5. Sử dụng các lớp Shape và DrawAPI để vẽ các vòng tròn có màu sắc khác nhau.
Khác:
* Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế Builder chuẩn.
	
### Composite
* Còn được gọi là mẫu tổng thể từng phần, được sử dụng để coi một nhóm các đối tượng tương tự như một đối tượng duy nhất. Chế độ kết hợp kết hợp các đối tượng dựa trên cấu trúc cây, được sử dụng để thể hiện các cấp độ một phần và tổng thể. Kiểu thiết kế này là kiểu cấu trúc, tạo ra cấu trúc dạng cây của các nhóm đối tượng.
* Để tạo và in hệ thống phân cấp của nhân viên làm ví dụ
1. Tạo một lớp Employee với danh sách các đối tượng Employee.
2. Sử dụng lớp Employee để tạo và in hệ thống phân cấp của nhân viên.
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
	
### Decorator
Để thiết kế hệ thống trang bị của trò chơi, các yêu cầu cơ bản là có thể tính toán sức tấn công và mô tả của từng trang bị được khảm bằng các loại đá quý khác nhau:
1. Lớp cha của thiết bị: IEquip.java
2. Lớp thực tế của mỗi thiết bị:
ví dụ: Hiện thực hóa vũ khí : ArmEquip.java
3. Lớp siêu trang trí (đồ trang trí cũng thuộc về thiết bị): IEquipDecorator.java
4. Lớp hiện thực hóa trang trí:
	ví dụ: Lớp triển khai Sapphire (tích lũy): BlueGemDecorator.java
	
### Facade
* Cung cấp một giao diện thống nhất để truy cập một nhóm giao diện trong hệ thống con. Sự xuất hiện xác định giao diện cấp cao giúp hệ thống con dễ sử dụng hơn. Trên thực tế, để thuận tiện cho khách hàng, một nhóm các thao tác được gói gọn thành một phương thức.
* Ví dụ: Khi muốn xem một bộ phim, cần:Bật máy làm bắp rang bơ, Làm bỏng ngô, Giảm độ sáng, Bật máy chiếu, Đặt vùng chiếu của máy chiếu xuống, Bật máy tính, Mở trình phát, Đặt âm của trình phát thành âm thanh vòm,...
* Xem phim tốn nhiều tiền, mệt, xem xong phải tắt từng bước một. Vì vậy, sử dụng chế độ **Facade** để giải quyết các bước phức tạp này và thưởng thức bộ phim một cách dễ dàng. 
	
### Flyweight
* Chứng minh chế độ này bằng cách tạo ra 5 đối tượng để vẽ 20 vòng tròn phân bố ở các vị trí khác nhau. Vì chỉ có 5 màu khả dụng nên thuộc tính màu được sử dụng để kiểm tra đối tượng Circle hiện có.
* Khi có số lượng lớn đối tượng có thể gây tràn bộ nhớ, trừu tượng hóa các phần chung, nếu có các yêu cầu nghiệp vụ giống nhau thì trả về trực tiếp các đối tượng hiện có trong bộ nhớ để tránh tạo lại. Lấy ngẫu nhiên nhiều hình dạng làm ví dụ, có 4 bước:
1. Tạo giao diện.
2. Tạo một lớp thực thể triển khai giao diện.
3. Tạo một factory để tạo ra các đối tượng của các lớp thực thể dựa trên thông tin đã cho.
4. Sử dụng factory này để lấy các đối tượng lớp thực thể bằng cách chuyển thông tin về màu sắc.
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
	
### Proxy
* Trong Proxy Pattern, một lớp đại diện cho chức năng của lớp khác.
Lấy hình ảnh từ đĩa làm ví dụ
1. Tạo giao diện. (Image.java)
2. Tạo một RealImage lớp thực thể triển khai giao diện. (Lớp proxy tương ứng: ProxyImage)
3. Khi được yêu cầu, hãy sử dụng ProxyImage để lấy các đối tượng của lớp RealImage.

## **3. Nhóm Behavior**
### Observer: Xác định một-nhiều phụ thuộc giữa các đối tượng, để khi một đối tượng thay đổi, tất cả các phụ thuộc của nó sẽ được thông báo và cập nhật tự động. Một số file mà sự án sử dụng Observer:
* Subject.java: interface chủ đề.
* ObjectFor3D.java: Lớp triển khai của 3D service number.
* Observer.java: Tất cả observer đều cần triển khai interface này.
* ObserverActivity.java: final test
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Command: Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo… Một số file mà sự án sử dụng Command:
* Door.java: API của thiết bị gia dụng.
* Command.java: interface lệnh hợp nhất.
* DoorOpenCommand.java
* ControlPanel.java: Điều khiển từ xa.
* QuickCommand.java: Định nghĩa một lệnh có thể thực hiện một loạt việc:
* CommandActivity.java: Thực thi bảng điều khiển từ xa.
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Status: Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi. Một số file mà sự án sử dụng Status:
* VendingMachine.java: Nhận diện ban đầu về máy bán hàng tự động cần được cải tiến.
* VendingMachine.java: Máy máy bán hàng tự động cần được cải tiến.
* State.java: status interface
* Lớp thực thi interface trạng thái tương ứng:
+ WinnerState.java: winner status.
+ SoldState.java: Trạng thái đã bán.
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Iterator: Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử. Trong phần này:
* Tạo interface Iterator, Container.
* Tạo một lớp thực thể triển khai interface Container. Lớp này có một NameIterator của lớp bên trong thực hiện interface Iterator.
* Sử dụng NameRepository để lấy trình lặp và in tên.
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Mediator: Định nghĩa một đối tượng để bao bọc việc giao tiếp giữa một số đối tượng với nhau. => Khuôn dạng khá giống mẫu tiêu chuẩn.

### Memento: Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu. => Khuôn dạng khá giống mẫu tiêu chuẩn.

### Interpreter: Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ. Trong phần này:
* Tạo interface Expression.
* Tạo một lớp thực thể thực hiện interface trên. TerminalExpression, OrExpression, AndExpression.
* Sử dụng class Expression để tạo các quy tắc và phân tích cú pháp chúng.
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Chain of Responsibility: Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể. => Khuôn dạng khá giống mẫu tiêu chuẩn.

### Strategy:
- Giống nhau:
    - Nhân vật trò chơi ban đầu: Role.java
    - Khi có mã trùng lặp, lớp cha được tái cấu trúc.
- Khác nhau: không có sự khác nhau.

### Template Method:
- Giống nhau:
    - Abstract Class: *Worker.java*
    - Concrete Class: *ITWorker.java*
- Khác nhau: không có sự khác nhau.

### Visitor:
- Giống nhau:
    - 1 Interface đại diện cho các yếu tố: *ComputerPart.java*
    - Các class implements từ Interface đó: *Computer, Mouse, Monitor, Keyboard*.
    - 1 Interface riêng cho khách truy cập *(ComputerPartVisitor.java)*
    - Class dành cho khách truy cập *(ComputerPartDisplayVisitor.java)*
    - Class hiển thị *(ComputerPartDisplayVisitor.java)*
- Khác nhau: không có sự khác nhau.
