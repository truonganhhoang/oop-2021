III. Behavioral Patterns - https://github.com/bazelbuild/bazel.git (Link repo)

8. Adapter: tần suất sử dụng: 2/5
   Sử dụng Adapter khi:
      - Muốn sử dụng một class nhưng interface của nó không tương thích với phần còn lại của chương trình
      - Muốn tạo một lớp có thể tái sử dụng và thể kết hợp với nhiều interface khác.
      - Cần sử dụng lại một số subclass đã có sẵn nhưng không thể điều chỉnh interface của chúng.
10. Bridge: tần suất sử dụng: 
12. Composite: tần suất sử dụng: 4/5
   Sử dụng khi:
      - Muốn biểu diễn phân cấp một phần/toàn bộ của đối tượng
      - Muốn client bỏ qua sự khác biệt giữa bố cục của các đối tượng và từng thành phần riêng lẻ
14. Decorator: tần suất sử dụng: 
16. Facade: tần suất sử dụng: 1/5
   Sử dụng Facade khi:
      - Muốn cung cấp một interface đơn giản cho một hệ thống con phức tạp. Các hệ thống con thường trở nên phức tạp hơn khi chúng phát triển. Hầu hết các mẫu, khi được áp           dụng, sẽ tạo ra nhiều class hơn và nhỏ hơn. Điều này làm cho hệ thống con có thể tái sử dụng nhiều hơn và dễ tùy chỉnh hơn, nhưng nó cũng trở nên khó sử dụng hơn đối với         các client không cần tùy chỉnh nó
      - Muốn phân lớp các hệ thống con.
18. Flyweight: tần suất sử dụng: 4/5
   Sử dụng khi:
      - Muốn build một ứng dụng mà sử dụng một lượng lớn object
      - tốn không gian lưu trữ vì số lượng lớn các object
      - Nhiều nhóm các object có thể được thay thế bằng tương đối ít object được chia sẻ sau khi trạng thái bên ngoài bị loại bỏ.
      - Ứng dụng không phụ thuộc vào nhận dạng object. Vì các flyweight object có thể được chia sẻ, các bài kiểm tra nhận dạng sẽ trả về true cho các đối tượng khác biệt về mặt         khái niệm.
20. Proxy: tần suất sử dụng: 

11. Chain of Responsibility Pattern
   Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể. Tần suất sử dụng: TB thấp - 2/5.
Lợi ích: 
    - Giảm kết nối (loose coupling): Thay vì một đối tượng có khả năng xử lý yêu cầu chứa tham chiếu đến tất cả các đối tượng khác, nó chỉ cần một tham chiếu đến đối tượng tiếp theo. Tránh sự liên kết trực tiếp giữa đối tượng gửi yêu cầu (sender) và các đối tượng nhận yêu cầu (receivers).
    - Tăng tính linh hoạt : đảm bảo Open/Closed Principle.
    - Phân chia trách nhiệm cho các đối tượng: đảm bảo Single Responsibility Principle.
    - Có khả năng thay đổi dây chuyền (chain) trong thời gian chạy.
    - Không đảm bảo có đối tượng xử lý yêu cầu.
12. Iterator Pattern:
   Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử. Tần suất sử dụng: Cao - 5/5.
Lợi ích: 
    - Đảm bảo nguyên tắc Single responsibility principle (SRP) : chúng ta có thể tách phần cài đặt các phương thức của tập hợp và phần duyệt qua các phần tử (iterator) theo từng class riêng lẻ.
    - Đảm bảo nguyên tắc Open/Closed Principle (OCP) : chúng ta có thể implement các loại collection mới và iterator mới, sau đó chuyển chúng vào code hiện có mà không vi phạm bất cứ nguyên tắc gì.
    - Chúng ta có thể truy cập song song trên cùng một tập hợp vì mỗi đối tượng iterator có chứa trạng thái riêng của nó.
  13. Mẫu thiết kế đầy đủ cấu trúc originator, caretaker và memento .


