Thành viên:   Vũ Hoàng Dương
              Nguyễn Tiến Đạt
              Vũ Đức Hải
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
