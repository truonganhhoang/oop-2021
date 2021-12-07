# Báo cáo design pattern nhóm 15:
 - Nguyễn Thị Kiều Trang
 - Trần Văn Hùng
 - Nguyễn Quang Vịnh

 ĐỀ BÀI: Tìm hiểu các design pattern được sửa dụng trong một repo có trên 1000 sao trên github. So sánh cái mẫu thiết kế được dùng trong repo với cái mẫu thiết kế chuẩn, tìm ra những điểm giống vào khác nhau trong đó. Do một repo không có đủ cái 22 mẫu thiết kế nên nhóm phải tìm ở nhiều repo khác nhau. Các mẫu design pattern được chia thành 3 nhóm sau đâu:

###I. Creational Patterns
    Trong nhóm design pattern thứ nhất nhóm sẽ tìm hiểu về cái pattern trong repo: https://github.com/airbnb/lottie-android
1. Abstract Factory Pattern:
   Abstract Factory pattern là phương pháp tạo ra một Super-factory dùng để tạo ra các Factory khác. Trong Abstract Factory pattern, một interface có nhiệm vụ tạo ra một Factory của các object có liên quan tới nhau mà không cần phải chỉ ra trực tiếp các class của object. Mỗi Factory được tạo ra có thể tạo ra các object bằng phương pháp giống như Factory pattern.
   - Với ý tưởng tạo ra một kiểu trừu tượng (abstract type) để dùng vào việc tạo ra một nhóm những products khác.
   - Cơ bản không có sự khác biệt so với mẫu thiết kế tiêu chuẩn.
   - Abstract platform: AbstractFactory, SenderFactory.
   
2. Builder Pattern: 
    Không tìm Thấy design pattern trong repo.

3. Factory Method Pattern:
   Factory method là để đưa toàn bộ logic của việc tạo mới object vào trong factory, che giấu logic của việc khởi tạo.Được định nghĩa interface giúp client tạo object nhưng ủy quyền cho các concreate factory để xác định class nào được trả về cho client. Cơ bản không có sự khác biệt so với mẫu thiết kế tiêu chuẩn. Factory Method trong đó Factory pattern đã dùng để khởi tạo một product mới.

4. Prototype Pattern:
   Singleton pattern (thuộc Creational) đảm bảo chỉ duy nhất môt new instance được tạo ra cho 1 lớp và nó sẽ cung cấp cho bạn một method để truy cập đến đối tượng duy nhất đó. Dù cho việc thực hiện cài đặt Singleton bằng cách nào đi nữa cũng đều dựa vào nguyên tắc dưới đây.

   - Private constructor để hạn chế khởi tạo đối tượng từ bên ngoài

   - Đặt private static variable cho đối tượng được khởi tạo, đảm bảo biến chỉ được khởi tạo trong chính lớp này.

   - Có một method public để return instance đã được khởi tạo ở trên.

5. Singleton Pattern:
   Giới hạn chỉ có duy nhất 1 instance của class đó tồn tại ở bất kỳ thời điểm nào class đó được request Cho phép quyền truy cập global Những tài nguyên được chia sẻ như DB để truy suất, file vật lý được sử dụng chung. Những tài nguyên này nên chỉ có 1 instance tồn tại để sử dụng và theo dõi trạng thái của nó trong suốt quá trình sử dụng. Hoặc những kiểu object không cần thiết phải tạo instance mới mỗi lần sử dụng như logging object, hãy tưởng tượng chuyện gì xảy với mỗi dòng log chúng ta lại tạo mới một logging object.

###II. Structural Patterns
    Trong nhóm design pattern thứ hai nhóm sẽ tìm hiểu về cái pattern trong repo: https://github.com/bazelbuild/bazel.git
6. Adapter Pattern: tần suất sử dụng: 2/5
   Sử dụng Adapter khi:
      - Muốn sử dụng một class nhưng interface của nó không tương thích với phần còn lại của chương trình
      - Muốn tạo một lớp có thể tái sử dụng và thể kết hợp với nhiều interface khác.
      - Cần sử dụng lại một số subclass đã có sẵn nhưng không thể điều chỉnh interface của chúng.
      
7. Bridge Pattern: tần suất sử dụng: 

8. Composite Pattern: tần suất sử dụng: 4/5
   Sử dụng khi:
      - Muốn biểu diễn phân cấp một phần/toàn bộ của đối tượng
      - Muốn client bỏ qua sự khác biệt giữa bố cục của các đối tượng và từng thành phần riêng lẻ
      
9. Decorator Pattern: tần suất sử dụng: 

10. Facade Pattern: tần suất sử dụng: 1/5
   Sử dụng Facade khi:
      - Muốn cung cấp một interface đơn giản cho một hệ thống con phức tạp. Các hệ thống con thường trở nên phức tạp hơn khi chúng phát triển. Hầu hết các mẫu, khi được áp           dụng, sẽ tạo ra nhiều class hơn và nhỏ hơn. Điều này làm cho hệ thống con có thể tái sử dụng nhiều hơn và dễ tùy chỉnh hơn, nhưng nó cũng trở nên khó sử dụng hơn đối với         các client không cần tùy chỉnh nó
      - Muốn phân lớp các hệ thống con.
      
11. Flyweight Pattern: tần suất sử dụng: 4/5
   Sử dụng khi:
      - Muốn build một ứng dụng mà sử dụng một lượng lớn object
      - tốn không gian lưu trữ vì số lượng lớn các object
      - Nhiều nhóm các object có thể được thay thế bằng tương đối ít object được chia sẻ sau khi trạng thái bên ngoài bị loại bỏ.
      - Ứng dụng không phụ thuộc vào nhận dạng object. Vì các flyweight object có thể được chia sẻ, các bài kiểm tra nhận dạng sẽ trả về true cho các đối tượng khác biệt về mặt         khái niệm.
      
12. Proxy Pattern: tần suất sử dụng: 

###III. Behavioral Patterns
    Trong nhóm design pattern thứ ba nhóm sẽ tìm hiểu về cái pattern trong repo: https://github.com/bazelbuild/bazel.git
13. Chain of Responsibility Pattern
   Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể. Tần suất sử dụng: TB thấp - 2/5.
Lợi ích: 
    - Giảm kết nối (loose coupling): Thay vì một đối tượng có khả năng xử lý yêu cầu chứa tham chiếu đến tất cả các đối tượng khác, nó chỉ cần một tham chiếu đến đối tượng tiếp theo. Tránh sự liên kết trực tiếp giữa đối tượng gửi yêu cầu (sender) và các đối tượng nhận yêu cầu (receivers).
    - Tăng tính linh hoạt : đảm bảo Open/Closed Principle.
    - Phân chia trách nhiệm cho các đối tượng: đảm bảo Single Responsibility Principle.
    - Có khả năng thay đổi dây chuyền (chain) trong thời gian chạy.
    - Không đảm bảo có đối tượng xử lý yêu cầu.
    
14. Iterator Pattern:
   Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử. Tần suất sử dụng: Cao - 5/5.
Lợi ích: 
    - Đảm bảo nguyên tắc Single responsibility principle (SRP) : chúng ta có thể tách phần cài đặt các phương thức của tập hợp và phần duyệt qua các phần tử (iterator) theo từng class riêng lẻ.
    - Đảm bảo nguyên tắc Open/Closed Principle (OCP) : chúng ta có thể implement các loại collection mới và iterator mới, sau đó chuyển chúng vào code hiện có mà không vi phạm bất cứ nguyên tắc gì.
    - Chúng ta có thể truy cập song song trên cùng một tập hợp vì mỗi đối tượng iterator có chứa trạng thái riêng của nó.
    
 15. Command Pattern:
   Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo…
    Chúng ta có thể xử lí vấn đề theo hướng command - đóng gói ý tưởng, những action cần làm khi button được ấn hoặc menu item được chọn. Tức là gom code để xử lý việc ấn button hoặc chọn menu trong object riêng. Những action này chính là những commands của Command pattern.
    Example: https://github.com/joshnh/Git-Commands .
    Code Repo: https://github.com/tcorral/Design-Patterns-in-Javascript/blob/es6/Command/1/scripts/Command.js .

package com.gpcoder.patterns.behavioral.command.bank;
 
public class Account {
    private String name;
 
    public Account(String name) {
        this.name = name;
    }
 
    public void open() {
        System.out.println("Account [" + name + "] Opened\n");
    }
 
    public void close() {
        System.out.println("Account [" + name + "] Closed\n");
    }
}

16. Mediator Pattern
    Đây là một trong nhưng mẫu không được sử dụng phổ biến hiện nay trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, một đối tượng để bao bọc việc giao tiếp giữa một số đối tượng với nhau. Sau đây ta xét ví dụ trong dự án trên:

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có AbstractCheck.java là lớp trừu tượng và AnnotationLocationCheck.java, AnnotationOnSameLineCheck.java, AnnotationUseStyleCheck.java là các lớp con kế thứa lớp AbstractCheck.java và thông qua lớp mẹ để giao tiếp với nhau.

17. Memento Pattern
    Memento là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Memento là mẫu thiết kế có thể lưu lại trạng thái của một đối tượng để khôi phục lại sau này mà không vi phạm nguyên tắc đóng gói.

18. Observer Pattern
    Mẫu design pattern này được sửa dụng giống với mẫu thiết kế chuẩn.

19. State Pattern
    State pattern cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó. Không có sự khác nhau so với mẫu thiết kế tiêu chuẩn.
    - Giữ hành vi cụ thể tương ứng với trạng thái.
    - Giúp chuyển trạng thái một cách rõ ràng.
    - Thêm một State mới mà không ảnh hưởng đến State khác hay Context hiện có.

20. Strategy Pattern
    Strategy pattern cho phép định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và dễ dàng thay đổi linh hoạt các thuật toán bên trong object. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng. Cơ bản không có sự khác nhau so với mẫu thiết kế tiêu chuẩn.
    - Cung cấp một sự thay thế cho kế thừa.
    - Dễ dàng mở rộng và kết hợp hành vi mới mà không thay đổi ứng dụng.

21. Template method Pattern
    Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Định nghĩa phần khung của một thuật toán, tức là một thuật toán tổng quát gọi đến một số phương thức chưa được cài đặt trong lớp cơ sở; việc cài đặt các phương thức được ủy nhiệm cho các lớp kế thừa.

22. Visitor Pattern
    Mẫu design pattern này được sửa dụng giống với mẫu thiết kế chuẩn.


