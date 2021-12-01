# So sánh với mẫu chuẩn

**Các mẫu được sử dụng**
* Singleton Pattern.
* MVC (Model View Controller).
* Template Pattern.
* Factory Method Pattern.

**1. Autowired Singletons**
 * Sử dụng Singleton pattern: là mẫu thiết kế sáng tạo cho phép đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.
 * Đối tượng ID trong OwnerRepository và OwnerController là như nhau.
 * 

**2. MVC (Model View Controller)**
 * Model và controller nằm trong java/org/springframework/samples/petclinic.
 * View nằm trong resources.
 * link minh hoạ: https://github.com/spring-projects/spring-petclinic/tree/main/src/main/java/org/springframework/samples/petclinic

**3. Template Pattern**
 * Các repository trong đều sử dụng Repository template của spring boot cung cấp.
 * Cách sủ dụng: Mẫu Phương pháp Mẫu khá phổ biến trong các khung công tác Java. Các nhà phát triển thường sử dụng nó để cung cấp cho người dùng khung một phương tiện đơn giản để mở rộng chức năng tiêu chuẩn bằng cách sử dụng tính năng kế thừa.
 *  Các repository trong đều sử dụng Repository template của spring boot cung cấp.
 *  link minh hoạ : https://github.com/spring-projects/spring-petclinic/tree/main/src/main/java/org/springframework/samples/petclinic

**4. Factory Method Pattern**
 * Sử dụng mẫu thiết kế Abstract Factory: là một trong những Pattern thuộc nhóm Creational Design Pattern. Abstract Factory cho phép một lớp trả về một nhà máy của các lớp, được sử dụng khi hệ thống cần phải độc lập với cách đối tượng của nó được tạo ra hoặc khi hệ thống cần được cấu hình với một trong nhiều họ đối tượng.
 * Spring coi một ***bean container*** là một ***factory*** tạo ra ***bean***.
 * Spring định nghĩa ***BeanFactory interface*** như một trừu tượng của ***bean container***.
 * Gồm các thành phần cơ bản: Sub classes, Factory class, Abstract Factory class...
 ```Java
 public interface BeanFactory {
    getBean(Class<T> requiredType);
    getBean(Class<T> requiredType, Object... args);
    getBean(String name);
    // ...
]
 ```
 * Mỗi phương thức *getBean* được coi là một *factory method* trả về một ***bean*** với các tiêu chí được cung cấp cho phương thức, ví dụ là tên, kiểu của ***bean***.


**Các mẫu thiết kế dự án không sử dụng**
* 5.Adapter Pattern (Người chuyển đổi) là một trong cấu trúc nhóm thuộc tính (Structural Pattern). Adapter Pattern cho phép các inteface (giao diện) không liên kết với nhau có thể làm việc giống nhau. Giúp kết nối các giao diện được gọi là Adapter. Hiện tại dự án không sử dụng.
* 6.Bridge Pattern được sử dụng để tách biệt thành phần (trừu tượng) và thành phần thực thi (thực thi) riêng. Do đó, các thành phần này có thể thay đổi một cách độc lập mà không ảnh hưởng đến các thành phần khác. Thay vì liên kết với nhau bằng hệ thống thừa kế, hai thành phần này liên kết với nhau thông qua hệ thống “chứa trong” (thành phần đối tượng).
Hiện tại dự án không sử dụng.
* 7.Composite là một mẫu thiết kế cấu trúc cho phép bạn sắp xếp các đối tượng thành cấu trúc cây và sau đó làm việc với các cấu trúc này như thể chúng là các đối tượng riêng lẻ.Hiện tại dự án không sử dụng
* 8.Proxy Pattern là thiết kế mẫu mà ở đó tất cả các truy cập trực tiếp đến một đối tượng nào đó sẽ được chuyển hướng vào một trung gian đối tượng (Proxy Class). Proxy Model (the face) đại diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với mục tiêu sử dụng.Hiện tại dự án không sử dụng
* 9.Builder là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và hình ảnh đại diện khác nhau của một đối tượng bằng cách sử dụng cùng một mã xây dựng.Nhiều thiết kế bắt đầu bằng cách sử dụng Factory Method (ít phức tạp hơn và có thể tùy chỉnh nhiều hơn thông qua các lớp con) và phát triển theo hướng Abstract Factory , Prototype hoặc Builder (linh hoạt hơn nhưng phức tạp hơn).Hiện tại dự án không sử dụng
* 10.Decorator là một mẫu thiết kế cấu trúc cho phép bạn đính kèm các hành vi mới vào các đối tượng bằng cách đặt các đối tượng này bên trong các đối tượng trình bao bọc đặc biệt có chứa các hành vi.
* 11.Facade là Cung cấp giao diện đơn giản hóa cho thư viện, khung công tác hoặc bất kỳ tập hợp lớp phức tạp nào khác.Nó định nghĩa 1 interface cao hơn các interface có sẵn để làm cho hệ thống con dễ sử dụng hơn
* 12.Flyweight Pattern là Sử dụng việc chia sẻ để thao tác hiệu quả trên một số lượng lớn đối tượng “cở nhỏ” (chẳng hạn paragraph, dòng, cột, ký tự…).Giảm số lượng đối tượng được tạo ra bằng cách chia sẻ đối tượng. Vì vậy, tiết kiệm bộ nhớ và các thiết bị lưu trữ cần thiết. - Cải thiện khả năng cache dữ liệu vì thời gian đáp ứng nhanh. - Tăng hiệu năng.
* 13.Command Pattern là Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo…
* 14.Interpreter Pattern là Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ. . Lợi ích: - Đảm bảo nguyên tắc Single responsibility principle (SRP) : chúng ta có thể tách phần cài đặt các phương thức của tập hợp và phần duyệt qua các phần tử (iterator) theo từng class riêng lẻ. - Đảm bảo nguyên tắc Open/Closed Principle (OCP) : chúng ta có thể implement các loại collection mới và iterator mới, sau đó chuyển chúng vào code hiện có mà không vi phạm bất cứ nguyên tắc gì. - Chúng ta có thể truy cập song song trên cùng một tập hợp vì mỗi đối tượng iterator có chứa trạng thái riêng của nó.
* 15.Iterator là Là một mẫu thiết kế hành vi cho phép duyệt tuần tự thông qua một cấu trúc dữ liệu phức tạp mà không để lộ các chi tiết bên trong của nó. Ý tưởng chính của mẫu Iterator là trích xuất hành vi truyền tải của một tập hợp thành một đối tượng riêng biệt được gọi là trình vòng lặp.Ví dụ như trình vòng lặp hồ sơ mạng xã hội, mẫu Iterator được sử dụng để duyệt qua các hồ sơ có trong một bộ sưu tập mạng xã hội từ xa mà không để lộ bất kỳ chi tiết giao tiếp nào với phía client.
* 16.Mediator là Làm giảm sự ghép nối giữa các thành phần của chương trình bằng cách làm cho chúng giao tiếp gián tiếp, thông qua một đối tượng trung gian đặc biệt.
Ví dụ rất nhiều phần tử GUI hợp tác với sự trợ giúp của người trung gian nhưng không phụ thuộc vào nhau.
* 17.Memento là Cho phép tạo ảnh chụp nhanh trạng thái của một đối tượng và khôi phục nó trong tương lai.Không làm ảnh hưởng đến cấu trúc bên trong của đối tượng mà nó làm việc cùng, cũng như dữ liệu được lưu giữ bên trong ảnh chụp nhanh.
* 18.Observer là Cho phép một số đối tượng thông báo cho các đối tượng khác về những thay đổi trong trạng thái của chúng.Cung cấp một cách để đăng ký và hủy đăng ký cho bất kỳ đối tượng nào triển khai giao diện người đăng ký.
* 19.State Pattern là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.
* 20.Strategy Pattern là một trong nhưng mẫu có hiệu suất sử dụng trung bình cao trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.Cung cấp một họ giải thuật cho phép client chọn lựa linh động một giải thuật cụ thể khi sử dụng.
* 21.Template method Pattern là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Định nghĩa phần khung của một thuật toán, tức là một thuật toán tổng quát gọi đến một số phương thức chưa được cài đặt trong lớp cơ sở; việc cài đặt các phương thức được ủy nhiệm cho các lớp kế thừa.
* 22.Visitor Pattern là một mẫu thiết kế hành vi cho phép bạn tách các thuật toán khỏi các đối tượng mà chúng hoạt động trên đó.Mẫu khách truy cập gợi ý rằng bạn đặt hành vi mới vào một lớp riêng biệt được gọi là khách truy cập , thay vì cố gắng tích hợp nó vào các lớp hiện có. Đối tượng ban đầu phải thực hiện hành vi hiện được chuyển cho một trong các phương thức của khách truy cập như một đối số, cung cấp cho phương thức này quyền truy cập vào tất cả dữ liệu cần thiết có trong đối tượng.
* 23.Prototype là một mẫu thiết kế sáng tạo cho phép bạn sao chép các đối tượng hiện có mà không làm cho mã của bạn phụ thuộc vào các lớp của chúng.Prototype Pattern là một Design Pattern được sử dụng chủ yếu để giảm chi phí khi tạo object. Thường là khi các ứng dụng quy mô lớn tạo, cập nhật hoặc truy xuất các đối tượng tốn nhiều tài nguyên.
Điều này được thực hiện bằng cách sao chép object, nó được tạo và sử dụng lại bản sao của object trong các yêu cầu ở phía sau khi có, để tránh thực hiện một hoạt động tốn tài nguyên khác.

**Khác nhau**
 * Về cơ bản các mẫu thiết kế này không có sự khác biệt so với mẫu thiết kế gốc.
 * Về cơ bản các mẫu thiết kế được sử dụng bởi dự án  này không có sự khác biệt so với mẫu thiết kế gốc. Tỉ lệ giống lên tới 95 %.
 * 
**Thông tin nhóm:**
1. ***Lại Trung Dũng - 18020376***.
2. ***Thân Chí Đạt - 17020678***.
3. ***Đỗ Văn Đạt - 19020244***.
**Repository:** [spring-boot](https://github.com/spring-projects/spring-petclinic)
