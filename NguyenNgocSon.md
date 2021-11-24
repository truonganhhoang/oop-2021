# OOP-2021
Môn học Lập trình hướng đối tượng với Java

Singleton 
-Giống nhau:
	-Một lớp chỉ có một thể hiện, đồng thời cung cấp một điểm truy cập toàn cục cho thể hiện này.
	-Đặt phương thức khởi tạo mặc định là riêng tư, để ngăn các đối tượng khác sử dụng new toán tử với lớp Singleton
	-Tạo một phương thức tạo tĩnh hoạt động như một phương thức khởi tạo. Bên dưới, phương thức này gọi phương thức khởi tạo riêng để tạo một đối tượng và lưu nó trong một trường tĩnh. Tất cả các lệnh gọi sau đến phương thức này đều trả về đối tượng được lưu trong bộ nhớ cache

-Khác nhau:
	-Một đối tượng cơ sở dữ liệu duy nhất được chia sẻ bởi các phần khác nhau của chương trình.
	-Phần thân của getInstance phương thức.

Factory Method
-Giống nhau:
	-Cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo.
	-Các lớp con có thể thay đổi lớp của các đối tượng được trả về bởi phương thức gốc.
	-Tất cả các sản phẩm phải theo cùng một giao diện.
	-Tất cả các lớp sản phẩm đều triển khai một giao diện chung, bạn có thể chuyển các đối tượng của chúng sang mã máy khách mà không cần phá vỡ nó.
-Khác nhau:
	-Các lớp giao diện người dùng cụ thể.
	-Sự phụ thuộc của các đối tượng mà mã của bạn sẽ hoạt động.
	-Các phương thức tạo trong lớp cơ sở và các lớp con.

Abstract Factory
-Giống nhau:
	-Có thể tạo ra các họ các đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng.
	- Khai báo rõ ràng các giao diện cho từng sản phẩm riêng biệt của họ sản phẩm
	-Các triển khai khác nhau của các sản phẩm trừu tượng, được nhóm theo các biến thể.
	-Các Abstract Factory giao diện tuyên bố một tập hợp các phương pháp để tạo ra mỗi sản phẩm trừu tượng.

-Khác nhau:
	-Rất nhiều giao diện và lớp mới được giới thiệu cùng với mẫu.


Builder
-Giống nhau:
	-Các đối tượng phức tạp được xây dựng theo từng bước.
	-Concrete Builders cung cấp các cách triển khai khác nhau của các bước xây dựng
	-Director biết các bước xây dựng cần thực hiện để có được một sản phẩm hoạt động.
	-Các builders khác nhau thực hiện cùng một nhiệm vụ theo nhiều cách khác nhau.
-Khác nhau :
	-Độ phức tạp tổng thể của mã tăng lên vì mẫu yêu cầu tạo nhiều lớp mới.

Prototype
-Giống nhau:
	-Cho phép sao chép các đối tượng hiện có mà không làm cho mã của ban đầu phụ thuộc vào các lớp của chúng.
	-Prototypes được tạo sẵn có thể là một giải pháp thay thế cho subclassing.
-Khác nhau:
	-Mẫu Prototype cung cấp cho mã máy khách một giao diện chung để làm việc với tất cả các đối tượng hỗ trợ nhân bản. Giao diện này làm cho mã máy khách độc lập với các lớp cụ thể của các đối tượng mà nó sao chép.

Adapter
-Giống nhau:
	-Cho phép các đối tượng có giao diện không tương thích cộng tác.
	-Có thể gọi các phương thức của adapter một cách an toàn.
	-Một lớp chứa logic nghiệp vụ hiện có của chương trình.
-Khác nhau:
	-Khi muốn sử dụng lại một số lớp con hiện có thiếu một số chức năng phổ biến không thể thêm vào lớp cha.
	-Độ phức tạp tổng thể của mã tăng lên.
