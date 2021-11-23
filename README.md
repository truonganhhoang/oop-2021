# OOP-2021
Môn học Lập trình hướng đối tượng với Java



Thành viên trong nhóm:
+ Bùi Minh Sơn 20021427
+ Nông Ngọc Sơn 20021430
+ Nguyễn Đức Dũng 20020181

Repo đã tìm được và phân tích: https://github.com/OmarElgabry/DesignPatterns/tree/master/src?fbclid=IwAR3zcvkF1NME6gIojqlXHsJEQnlaZ-fpN46HoGKMaSQouK-o_uOHSZNU6eU


Điểm giống nhau:

Có kết cấu tương tự với mẫu chuẩn.

Hệ thống làm việc độc lập với cách sản phẩm của nó được tạo ra, cấu tạo và đại diện.

Mỗi lớp chỉ chịu trách nhiệm về 1 một việc.

Khi chỉnh sửa thêm bớt thành phần thì không cần thay đổi code hiện tại.

Code sạch sẽ

Điểm khác nhau:

Không nhiều do là 1 mẫu thiết kế tương tự mẫu thiết kế chuẩn.

•	Singleton:
o	Đảm bảo 1 class chỉ có 1 instance và cung cấp 1 điểm truy xuất toàn cục đến nó.
 vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/singleton
 
•	Abstract Factory:
o	Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/factory/abstr

•	Factory Method:
o	Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/factory

•	Prototype:
o	Qui định loại của các đối tượng cần tạo bằng cách dùng một đối tượng mẫu, tạo mới nhờ vào sao chép đối tượng mẫu này.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/prototype

•	Adapter:
o	Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/adapter
•	Bridge:
o	Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (ngữ nghĩa và cài đặt) có thể thay đổi độc lập nhau.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/bridge
•	Composite:
o	Tổ chức các đối tượng theo cấu trúc phân cấp dạng cây. Tất cả các đối tượng trong cấu trúc được thao tác theo một cách thuần nhất như nhau.
Tạo quan hệ thứ bậc bao gộp giữa các đối tượng. Client có thể xem đối tượng bao gộp và bị bao gộp như nhau -> khả năng tổng quát hoá trong code của client -> dễ phát triển, nâng cấp, bảo trì.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/composite

•	Decorator:
o	Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) vào lúc chạy (dynamically).
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/decorator

•	Iterator: 
o	Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/iterator

•	State: 
o	Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/state

•	Observer: 
o	Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/observer

•	Strategy: 
o	Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.Cung cấp một họ giải thuật cho phép client chọn lựa linh động một giải thuật cụ thể khi sử dụng.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/strategy


