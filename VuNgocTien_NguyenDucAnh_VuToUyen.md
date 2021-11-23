# OOP-2021
Môn học Lập trình hướng đối tượng với Java

# So sánh với mẫu chuẩn

Nhóm 21: 

Vũ Ngọc Tiến (18021273), 

Vũ Tố Uyên (18021412), 

Nguyễn Đức Anh(18020127)

Link: https://github.com/DesignPatternsPHP/DesignPatternsPHP

1. Abstract Factory
- Để tạo một loạt các đối tượng liên quan hoặc phụ thuộc mà không chỉ định các lớp cụ thể của chúng. Thông thương các lớp đều được triển khai trên cùng một giao diện. Client của Abstract Factory không quan tâm đến việc các đối tượng này được tạo ra như nào, nó chỉ biết chúng đi cùng nhau như thế nào.
2. Builder
- Là một giao diện xây dựng các phần của một đối tượng phức tạp
- Nếu trình tạo có kiến thức tốt hơn về nhưng gì nó xây dựng giao diện này có thể là một lớp trừu tượng với các phương thức mặc định
- Nếu có một cây thừa kế phức tạp cho các đối tượng, thì sẽ sinh ra một cây thừa kế phức tạp cho các trình xây dựng.
3. Factory Method
- Có thể phân lớp nó để triển khai các cách tạo đối tượng khác nhau
- Đối với những trường hợp đơn giản, lớp trừu tượng này chỉ có thể là một giao diện.
- Mẫu này là mẫu thiết kế “thực” vì nó đạt được nguyên tắc phụ thuộc a.k.a chữ D trong nguyên tắc SOLID
- Lớp này phụ thuộc vào các lớp trừu tượng không phải các lớp cụ thể. Đây là thủ thuật so với SimpleFactory hoặc StaticFactory
4. Prototype
- Để tránh chi phí tạo các đối tượn theo cách chuẩn và thay vào đó thì tạo một nguyên mẫu và sao chép nó
5. Singleton
- Chỉ có một bản của đối tượng này trong ứng dụng và nó sẽ xử lý tất cả các cuộc gọi.
6. Adapter
- Đây là lớp dịch giao diện cho một lớp thành. Bộ điều hợp cho phép các lớp làm việc cùng nhau mà thông thường không thể do các giao diện không tương thích bằng cách cung cấp giao diện của nó cho các máy khách trong khi sử dụng giao diện gốc
7. Bridge
- Tách một phần trừu tượng khỏi sự triển khai của nó để hai phần này có thể khác nhau một cách độc lập
8. Composite
- Để xử lý một nhóm đối tượng theo cách giống nhau như một thể hiện riêng lẻ của đối tượng.
9. Decorator
- Để them chức năng mới của lớp
10. Façade
- Mục tiêu chính tránh việc đọc hướng dẫn sử dụng một API phức tạp. Nó chỉ là một tách dụng phụ. Mục tiêu đầu tiên là giảm sự ghép nối và tuân theo Định luật Demeter.
- Façade có nghĩa là tách một máy khách và một hệ thống con bằng cách nhúng nhiều giao diện và tất nhiên để giảm độ phức tạp.
- NÓ không cấm bạn truy cập vào hệ thống con. 
- Facede tốt nhất sẽ có phương thức khởi tạo tham số gợi ý kiểu giao diện. 
11. Flyweight
- Để giảm thiểu việc sử dụng bộ nhớ, Flyweight chia sẻ càng nhiều bộ nhớ càng tốt với các đối tượng tương tự. Nó là cần thiết khi một lượng lớn các đối tượng được sử dụng mà trạng thái không khác nhau nhiều. Một thực tế phổ biến là giữ trạng thái trong cấu trúc dữ liệu bên ngoài và chuyển chúng đến đối tượng flyweight khi cần thiết.
12. Proxy
- Để giao diện với bất kỳ thứ gì đắt tiền hoặc không thể sao chép.	
13. Chain of Responsibility
- Để xây dựng một chuỗi các đối tượng để xử lý một cuộc gọi theo thứ tự tuần tự. Nếu một đối tượng không thể xử lý một cuộc gọi, nó sẽ ủy quyền cuộc gọi tới đối tượng tiếp theo trong chuỗi, v.v.
14. Command
- Để đóng gói lời gọi và phân tách.
- Có một Invoker và một Receiver. Mẫu này sử dụng một "Lệnh" để ủy quyền cuộc gọi phương thức chống lại Bộ nhận và trình bày cùng một phương thức "thực thi". Do đó, Invoker chỉ biết gọi "thi hành" để xử lý Lệnh của client. Người nhận được tách khỏi Invoker.
- Khía cạnh thứ hai của mẫu này là undo (), hoàn tác phương thức execute (). Lệnh cũng có thể được tổng hợp để kết hợp các lệnh phức tạp hơn với mức sao chép-dán tối thiểu và dựa vào thành phần thay vì kế thừa.
15. Iterator
- Để làm cho một đối tượng có thể lặp lại và làm cho nó giống như một tập hợp các đối tượng.
16. Mediator
- Mô hình này cung cấp một cách dễ dàng để tách nhiều thành phần làm việc cùng nhau. Nó là một sự thay thế tốt cho Observer NẾU có "trí thông minh trung tâm", giống như một bộ điều khiển (nhưng không phải theo nghĩa của MVC).
- Tất cả các thành phần (được gọi là Colleague) chỉ được ghép nối với giao diện Mediator.
17. Memento
- Nó cung cấp khả năng khôi phục một đối tượng về trạng thái trước đó (hoàn tác thông qua khôi phục) hoặc để có quyền truy cập vào trạng thái của đối tượng, mà không tiết lộ việc triển khai của nó (tức là đối tượng không bắt buộc phải có chức năng để trả lại trạng thái hiện tại).
- Mẫu vật lưu niệm được thực hiện với ba đối tượng: Người khởi tạo, Người chăm sóc và Người ghi nhớ.
18. Observer
- Để thực hiện hành vi xuất bản / đăng ký đối với một đối tượng, bất cứ khi nào đối tượng "Chủ đề" thay đổi trạng thái của nó, "Người quan sát" được đính kèm sẽ được thông báo. Nó được sử dụng để rút ngắn số lượng các đối tượng được ghép nối và sử dụng khớp nối lỏng lẻo để thay thế.
19. State
- Đóng gói các hành vi khác nhau cho cùng một quy trình dựa trên trạng thái của đối tượng. Đây có thể là một cách rõ ràng hơn để một đối tượng thay đổi hành vi của nó trong thời gian chạy mà không cần dùng đến các câu lệnh điều kiện nguyên khối lớn.
20. Strategy
- Để phân tách các chiến lược và cho phép chuyển đổi nhanh giữa chúng. Ngoài ra, mẫu này là một sự thay thế tốt cho kế thừa (thay vì có một lớp trừu tượng được mở rộng).
21. Template Method
- Phương pháp là một mẫu thiết kế hành vi.
- Ý tưởng là để cho các lớp con của mẫu trừu tượng này "hoàn thành" hành vi của một thuật toán.
- A.k.a là "nguyên tắc Hollywood": "Đừng gọi cho chúng tôi, chúng tôi gọi cho bạn." Lớp này không được gọi bởi các lớp con mà là lớp nghịch đảo. Thế nào? Tất nhiên là với sự trừu tượng.
- Nói cách khác, đây là một bộ xương của thuật toán, rất thích hợp cho các thư viện khung. Người dùng chỉ cần triển khai một phương thức và lớp cha thực hiện công việc.
- Đó là một cách dễ dàng để tách các lớp cụ thể và giảm việc sao chép-dán, đó là lý do tại sao bạn sẽ tìm thấy nó ở khắp mọi nơi.
22. Visitor
- Mẫu khách truy cập cho phép bạn thuê ngoài các hoạt động trên các đối tượng cho các đối tượng khác. Lý do chính để làm điều này là để giữ tách biệt các mối quan tâm. Nhưng các lớp phải xác định một hợp đồng để cho phép khách truy cập (trong ví dụ là phương thức Role :: accept).
- Hợp đồng là một lớp trừu tượng nhưng bạn cũng có thể có một giao diện sạch sẽ. Trong trường hợp đó, mỗi Khách truy cập phải tự chọn phương pháp để gọi cho khách truy cập.

