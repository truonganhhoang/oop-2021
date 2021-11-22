> # Lớp: INT2204_21
> # Thành viên: 
>* Phạm Thị Khánh Linh 20020324	
>* Lê Phương Uyên 20021475	
>* Phan Hiền An 20021281	
>### Repo: https://github.com/youlookwhat/DesignPattern

## **1. Nhóm Creational**


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



	
