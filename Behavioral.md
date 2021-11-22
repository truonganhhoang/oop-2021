3.	Nhóm Behavioral
a.	Observer: Xác định một-nhiều phụ thuộc giữa các đối tượng, để khi một đối tượng thay đổi, tất cả các phụ thuộc của nó sẽ được thông báo và cập nhật tự động. Một số file mà sự án sử dụng Observer:
-	Subject.java: interface chủ đề.
-	ObjectFor3D.java: Lớp triển khai của 3D service number.
-	Observer.java: Tất cả observer đều cần triển khai interface này.
-	ObserverActivity.java: final test
	Khuôn dạng khá giống mẫu tiêu chuẩn.

b.	Command: Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo… Một số file mà sự án sử dụng Command:
-	Door.java: API của thiết bị gia dụng.
-	Command.java: interface lệnh hợp nhất.
-	DoorOpenCommand.java
-	ControlPanel.java: Điều khiển từ xa.
-	QuickCommand.java: Định nghĩa một lệnh có thể thực hiện một loạt việc:
-	CommandActivity.java: Thực thi bảng điều khiển từ xa.
	Khuôn dạng khá giống mẫu tiêu chuẩn.

c.	Status: Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi. Một số file mà sự án sử dụng Status:
-	VendingMachine.java: Nhận diện ban đầu về máy bán hàng tự động cần được cải tiến.
-	VendingMachine.java: Máy máy bán hàng tự động cần được cải tiến.
-	State.java: status interface
-	Lớp thực thi interface trạng thái tương ứng:
+ WinnerState.java: winner status.
+ SoldState.java: Trạng thái đã bán.
	Khuôn dạng khá giống mẫu tiêu chuẩn.
d.	Iterator: Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử. Trong phần này:
-	Tạo interface Iterator, Container.
-	Tạo một lớp thực thể triển khai interface Container. Lớp này có một NameIterator của lớp bên trong thực hiện interface Iterator.
-	Sử dụng NameRepository để lấy trình lặp và in tên.
	Khuôn dạng khá giống mẫu tiêu chuẩn.
e.	Mediator: Định nghĩa một đối tượng để bao bọc việc giao tiếp giữa một số đối tượng với nhau. => Khuôn dạng khá giống mẫu tiêu chuẩn.
f.	Memento: Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu. => Khuôn dạng khá giống mẫu tiêu chuẩn.
g.	Interpreter: Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ. Trong phần này:
- Tạo interface Expression.
- Tạo một lớp thực thể thực hiện interface trên. TerminalExpression, OrExpression, AndExpression.
- Sử dụng class Expression để tạo các quy tắc và phân tích cú pháp chúng.
=> Khuôn dạng khá giống mẫu tiêu chuẩn.
   h. Chain of Responsibility: Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể. => Khuôn dạng khá giống mẫu tiêu chuẩn.
