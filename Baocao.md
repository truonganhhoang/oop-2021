Thành viên:   Vũ Hoàng Dương
              Nguyễn Tiến Đạt
              Vũ Đức Hải
- Composite: 
+ Được sử dụng khi chúng ta cần xử lý một nhóm các object tương tự như cách xử lý một object.Điều này thường được thực hiện bới class “owns” của object và cung cấp một tập hợp các phương thức để xử lý chúng như thể xử lý một object.
+ Là một đối tượng được thiết kế như một thành phần của một hoặc nhiều đối tượng giống nhau, tất cả đều có chức năng tương tự

Điều này thường được thực hiện bới class “owns” của object và cung cấp một tập hợp các phương thức để xử lý chúng như thể xử lý một object.
- Chain of Responsibility :
+ Chain of Responsibility (COR) là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern).
+ Chain of Responsiblity cho phép một đối tượng gửi một yêu cầu nhưng không biết đối tượng nào sẽ nhận và xử lý nó. Điều này được thực hiện bằng cách kết nối các đối tượng nhận yêu cầu thành một chuỗi (chain) và gửi yêu cầu theo chuỗi đó cho đến khi có một đối tượng xử lý nó.
+ Chain of Responsibility Pattern hoạt động như một danh sách liên kết (Linked list) với việc đệ quy duyệt qua các phần tử (recursive traversal).

- Iterator: 
+ Iterator Pattern là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Nó được sử dụng để “Cung cấp một cách thức truy cập tuần tự tới các phần tử của một đối tượng tổng hợp, mà không cần phải tạo dựng riêng các phương pháp truy cập cho đối tượng tổng hợp này”.
+ Một Iterator được thiết kế cho phép xử lý nhiều loại tập hợp khác nhau bằng cách truy cập những phần tử của tập hợp với cùng một phương pháp, cùng một cách thức định sẵn, mà không cần phải hiểu rõ về những chi tiết bên trong của những tập hợp này.

- Prototype: 
+ cho phép bạn sao chép các object hiện có mà không làm cho code của bạn phụ thuộc vào các class của chúng.
+ prototypes được tạo sẵn có thể là một giải pháp thay thế cho subclassing.

- Singleton 
+ Là pattern dành cho việc khởi tạo đối tượng.
+ Một singleton clas là một class chỉ có thể có một instance được tạo ra tại một thời điểm. Sau lần đầu tiên được khởi tạo, ở những lần khởi tạo sau chúng ta vẫn sẽ nhận một tham chiếu đến instance đã khởi tạo ở lần đầu tiên. Vì vậy việc thay đổi các instance của một singleton class sẽ ảnh hưởng đến toàn bộ những nơi sử dụng biến tham chiếu đến instance này.
