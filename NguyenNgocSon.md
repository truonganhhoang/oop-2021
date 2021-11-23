# So sánh với mẫu chuẩn

Singleton 
-Giống nhau:
	- một lớp chỉ có một thể hiện, đồng thời cung cấp một điểm truy cập toàn cục cho thể hiện này.
	-Đặt phương thức khởi tạo mặc định là riêng tư, để ngăn các đối tượng khác sử dụng new toán tử với lớp Singleton
	-Tạo một phương thức tạo tĩnh hoạt động như một phương thức khởi tạo. Bên dưới, phương thức này gọi phương thức khởi tạo riêng để tạo một đối tượng và lưu nó trong một trường tĩnh. Tất cả các lệnh gọi sau đến phương thức này đều trả về đối tượng được lưu trong bộ nhớ cache

-Khác nhau:
	-một đối tượng cơ sở dữ liệu duy nhất được chia sẻ bởi các phần khác nhau của chương trình.
	-phần thân của getInstance phương thức.

Factory Method
-Giống nhau:
	-cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo.
	-Các lớp con có thể thay đổi lớp của các đối tượng được trả về bởi phương thức gốc.
	-Tất cả các sản phẩm phải theo cùng một giao diện.
	-tất cả các lớp sản phẩm đều triển khai một giao diện chung, bạn có thể chuyển các đối tượng của chúng sang mã máy khách mà không cần phá vỡ nó.
-Khác nhau:
	-các lớp giao diện người dùng cụ thể.
	-sự phụ thuộc của các đối tượng mà mã của bạn sẽ hoạt động.
	-các phương thức tạo trong lớp cơ sở và các lớp con.

Abstract Factory
-Giống nhau:
	-có thể tạo ra các họ các đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng.
	- khai báo rõ ràng các giao diện cho từng sản phẩm riêng biệt của họ sản phẩm
	-các triển khai khác nhau của các sản phẩm trừu tượng, được nhóm theo các biến thể.
	-Các Abstract Factory giao diện tuyên bố một tập hợp các phương pháp để tạo ra mỗi sản phẩm trừu tượng.

-Khác nhau:
	-rất nhiều giao diện và lớp mới được giới thiệu cùng với mẫu.


Builder
-Giống nhau:
	-các đối tượng phức tạp được xây dựng theo từng bước.
	-Concrete Builders cung cấp các cách triển khai khác nhau của các bước xây dựng
	-Director biết các bước xây dựng cần thực hiện để có được một sản phẩm hoạt động.
	-Các builders khác nhau thực hiện cùng một nhiệm vụ theo nhiều cách khác nhau.
-Khác nhau :
	-Độ phức tạp tổng thể của mã tăng lên vì mẫu yêu cầu tạo nhiều lớp mới.

Prototype
-Giống nhau:
	-cho phép sao chép các đối tượng hiện có mà không làm cho mã của ban đầu phụ thuộc vào các lớp của chúng.
	-prototypes được tạo sẵn có thể là một giải pháp thay thế cho subclassing.
-Khác nhau:
	-Mẫu Prototype cung cấp cho mã máy khách một giao diện chung để làm việc với tất cả các đối tượng hỗ trợ nhân bản. Giao diện này làm cho mã máy khách độc lập với các lớp cụ thể của các đối tượng mà nó sao chép.

Adapter
-Giống nhau:
	-cho phép các đối tượng có giao diện không tương thích cộng tác.
	-có thể gọi các phương thức của adapter một cách an toàn.
	-một lớp chứa logic nghiệp vụ hiện có của chương trình.
-Khác nhau:
	-khi muốn sử dụng lại một số lớp con hiện có thiếu một số chức năng phổ biến không thể thêm vào lớp cha.
	-Độ phức tạp tổng thể của mã tăng lên.

Bridge
-Giống nhau:
	- chia một lớp lớn hoặc một tập hợp các lớp có liên quan chặt chẽ thành hai phân cấp riêng biệt — trừu tượng và thực thi — có thể được phát triển độc lập với nhau.
	-Thực hiện thay đổi đối với các mô-đun nhỏ hơn, được xác định rõ ràng dễ dàng hơn nhiều.
	-Triển khai Concrete chứa mã dành riêng cho nền tảng
	-cung cấp các biến thể của logic điều khiển
-Khác nhau:
	-mất nhiều thời gian để thực hiện thay đổi

Composite
-Giống nhau:
	-cho phép sắp xếp các đối tượng thành cấu trúc cây và sau đó làm việc với các cấu trúc này như thể chúng là các đối tượng riêng lẻ.
	-Mẫu tổng hợp cho phép chạy một cách đệ quy một hành vi trên tất cả các thành phần của cây đối tượng.
	-Các thành phần giao diện mô tả hoạt động mà là chung cho cả hai đơn giản và các yếu tố phức tạp của cây.
-Khác nhau:
	-khó cung cấp một giao diện chung cho các lớp có chức năng khác nhau quá nhiều
	
	
	
