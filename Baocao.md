Thành viên:   Vũ Hoàng Dương-19020533
              Nguyễn Tiến Đạt-19020521
              Vũ Đức Hải-19020538
- Singleton:
+ Là pattern dành cho việc khởi tạo đối tượng.Đảm bảo một lớp chỉ có một cá thể và cung cấp một điểm truy cập toàn cầu cho nó. Mẫu có mục đích sáng tạo và xử lý các mối quan hệ đối tượng, các mối quan hệ này năng động hơn. Singleton thường được sử dụng như một phần của các mẫu thiết kế khác
+ Một singleton clas là một class chỉ có thể có một instance được tạo ra tại một thời điểm. Sau lần đầu tiên được khởi tạo, ở những lần khởi tạo sau chúng ta vẫn sẽ nhận một tham chiếu đến 

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/singleton

- Abstract Factory:
+ Cung cấp hướng tiếp cận với Interface thay thì các implement, che giấu sự phức tạp của việc khởi tạo các đối tượng với người dùng (client), độc lập giữa việc khởi tạo đối tượng và hệ thống sử dụng,...
+ Giúp tránh được việc sử dụng điều kiện logic bên trong Factory Pattern. Khi một Factory Method lớn (có quá nhiều sử lý if-else hay switch-case), chúng ta nên sử dụng theo mô hình Abstract Factory để dễ quản lý hơn (cách phân chia có thể là gom nhóm các sub-class cùng loại vào một Factory).
+ Abstract Factory Pattern là factory của các factory, có thể dễ dạng mở rộng để chứa thêm các factory và các sub-class khác.

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/abstract-factory

- Factory Method:
+ Cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo.
+ Factory method giải quyết vấn đề này bằng cách định nghĩa một phương thức cho việc tạo đối tượng, và các lớp con thừa kế có thể override để chỉ rõ đối tượng nào sẽ được tạo. 
+ Tất cả các lớp sản phẩm đều triển khai một giao diện chung, bạn có thể chuyển các đối tượng của chúng sang mã máy khách mà không cần phá vỡ nó.
+ Chúng ta có một super class với nhiều sub-class và dựa trên đầu vào, chúng ta cần trả về một sub-class. Mô hình này giúp chúng ta đưa trách nhiệm của việc khởi tạo một lớp từ phía người dùng (client) sang lớp Factory.
+ Chúng ta không biết sau này sẽ cần đến những sub-class nào nữa. Khi cần mở rộng, hãy tạo ra sub class và implement thêm vào factory method cho việc khởi tạo sub class này.

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/factory-method

- Builder:
+ Builder là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và biểu diễn khác nhau của một đối tượng bằng cách sử dụng cùng một hàm khởi tạo (construction).
+ đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.
+ ConcreateBuilder: là thành phần triển khai, cụ thể hóa các lớp trừu tượng cho để tạo ra các thành phần và tập hợp các thành phần đó với nhau. thành phần này sẽ xác định và nắm giữ các thể hiện mà nó tạo ra. Đồng thời nó cũng cung cấp phương thức để trả các các thể hiện mà nó đã tạo ra trước đó.
+ Product: thành phần này trong bài viết sẽ đại diện cho đối tượng phức tạp phải tạo ra
+ Director: thành phần này sẽ khởi tạo đối tượng Builder

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/builder

- Prototype:
+ cho phép bạn sao chép các object hiện có mà không làm cho code của bạn phụ thuộc vào các class của chúng.
+ prototypes được tạo sẵn có thể là một giải pháp thay thế cho subclassing.
+ khi các lớp cần khởi tạo được chỉ định tại thời gian chạy
+ để tránh xây dựng một hệ thống phân cấp các nhà máy song song với hệ thống phân cấp các sản phẩm

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/prototype

- Adapter:
+ Chuyển đổi giao diện của một lớp thành một giao diện khác mà khách hàng mong đợi. Bộ điều hợp cho phép các lớp hoạt động cùng nhau mà không thể vì các giao diện không tương thích, tức là. cho phép sử dụng máy khách có giao diện không tương thích bởi Bộ điều hợp thực hiện chuyển đổi. Bộ điều hợp có mục đích cấu trúc và có thể được áp dụng trên các lớp và cả trên đối tượng. Bộ điều hợp lớp sử dụng đa kế thừa để điều chỉnh một giao diện này sang một giao diện khác và bộ điều hợp đối tượng sử dụng thành phần đối tượng để kết hợp các lớp với các giao diện khác nhau.
+ bạn muốn sử dụng một lớp hiện có và giao diện của nó không khớp với một lớp bạn cần
+ bạn muốn tạo một lớp có thể sử dụng lại hợp tác với các lớp không nhất thiết phải có giao diện tương thích

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/adapter

- Command:
+ Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo…
+ muốn tham số hóa các đối tượng bằng một hành động để thực hiện
+ muốn chỉ định, xếp hàng và thực hiện các yêu cầu tại các thời điểm khác nhau
+ cấu trúc một hệ thống xung quanh các hoạt động cấp cao được xây dựng trên các hoạt động ban đầu

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/command

- Interpreter:
+ Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ.
+ Đối với một ngôn ngữ, mẫu xác định sự lưu ý cho ngữ pháp của nó cùng với trình thông dịch sử dụng biểu diễn để diễn giải các câu trong ngôn ngữ đó. Mẫu thông dịch viên có mục đích hành vi và áp dụng cho các lớp.

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/interpreter

- Iterator:
+ Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử.
+ để truy cập nội dung của một đối tượng tổng hợp mà không để lộ phần đại diện bên trong của nó
+ để cung cấp một giao diện thống nhất để duyệt qua các cấu trúc tổng hợp khác nhau (để hỗ trợ lặp lại đa hình)
+ để hỗ trợ nhiều đường truyền của các đối tượng tổng hợp

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/iterator

- Mediator:
+ Mẫu xác định một đối tượng đóng gói cách một tập hợp các đối tượng tương tác. Nó thúc đẩy kết hợp lỏng lẻo bằng cách giữ cho các đối tượng không tham chiếu đến nhau một cách rõ ràng và nó cho phép bạn thay đổi tương tác của chúng một cách độc lập.
+ một hành vi được phân phối giữa một số lớp nên có thể tùy chỉnh mà không cần nhiều lớp con.Việc sử dụng lại một đối tượng rất khó vì nó đề cập và giao tiếp với nhiều đối tượng khác

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/mediator

- Memento;
+ Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu.
+ không vi phạm tính đóng gói, nắm bắt và ngoại hóa trạng thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái này sau đó. Mẫu có mục đích hành vi và áp dụng cho các đối tượng.

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/memento

- Proxy:
+ cung cấp trình thay thế hoặc trình giữ chỗ cho một đối tượng khác để kiểm soát quyền truy cập vào nó. Mẫu có mục đích cấu trúc và áp dụng cho các đối tượng.

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/proxy

- Flyweight:
+ Sử dụng việc chia sẻ để thao tác hiệu quả trên một số lượng lớn đối tượng “cở nhỏ” (chẳng hạn paragraph, dòng, cột, ký tự…).

link: https://github.com/JakubVojvoda/design-patterns-java/tree/master/flyweight
