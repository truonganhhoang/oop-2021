 - https://github.com/bazelbuild/bazel.git (Link repo)

I. Creational Patterns
1.Abstract Factory
2.Builder
3.Factory Method
4.Prototype
5.Singleton

II. Structural Patterns
6.Adapter: tần suất sử dụng: 2/5
   Sử dụng Adapter khi:
      - Muốn sử dụng một class nhưng interface của nó không tương thích với phần còn lại của chương trình
      - Muốn tạo một lớp có thể tái sử dụng và thể kết hợp với nhiều interface khác.
      - Cần sử dụng lại một số subclass đã có sẵn nhưng không thể điều chỉnh interface của chúng.
7. Bridge: tần suất sử dụng: 
8. Composite: tần suất sử dụng: 4/5
   Sử dụng khi:
      - Muốn biểu diễn phân cấp một phần/toàn bộ của đối tượng
      - Muốn client bỏ qua sự khác biệt giữa bố cục của các đối tượng và từng thành phần riêng lẻ
9. Decorator: tần suất sử dụng: 
10. Facade: tần suất sử dụng: 1/5
   Sử dụng Facade khi:
      - Muốn cung cấp một interface đơn giản cho một hệ thống con phức tạp. Các hệ thống con thường trở nên phức tạp hơn khi chúng phát triển. Hầu hết các mẫu, khi được áp           dụng, sẽ tạo ra nhiều class hơn và nhỏ hơn. Điều này làm cho hệ thống con có thể tái sử dụng nhiều hơn và dễ tùy chỉnh hơn, nhưng nó cũng trở nên khó sử dụng hơn đối với         các client không cần tùy chỉnh nó
      - Muốn phân lớp các hệ thống con.
11. Flyweight: tần suất sử dụng: 4/5
   Sử dụng khi:
      - Muốn build một ứng dụng mà sử dụng một lượng lớn object
      - tốn không gian lưu trữ vì số lượng lớn các object
      - Nhiều nhóm các object có thể được thay thế bằng tương đối ít object được chia sẻ sau khi trạng thái bên ngoài bị loại bỏ.
      - Ứng dụng không phụ thuộc vào nhận dạng object. Vì các flyweight object có thể được chia sẻ, các bài kiểm tra nhận dạng sẽ trả về true cho các đối tượng khác biệt về mặt         khái niệm.
12. Proxy: tần suất sử dụng: 

III. Behavioral Patterns
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
    
 15. Command:
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
    Đây là một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, người lập trình có thể Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng Task.java và lớp con kế thừa lớp này là CheckstyleAntTask.java.

19. Observer Pattern
    Đây là một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng AuditEventFormatter.java và lớp con kế thừa lớp này là AuditEventDefaultFormatter.java

20. State Pattern
    Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng AuditEventFormatter.java và lớp con kế thừa lớp này là AuditEventDefaultFormatter.java

21. Strategy Pattern
    Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình cao trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.Cung cấp một họ giải thuật cho phép client chọn lựa linh động một giải thuật cụ thể khi sử dụng.
    
22. Template method Pattern
    Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Định nghĩa phần khung của một thuật toán, tức là một thuật toán tổng quát gọi đến một số phương thức chưa được cài đặt trong lớp cơ sở; việc cài đặt các phương thức được ủy nhiệm cho các lớp kế thừa.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp Interface TreeModel.java và lớp con kế thừa lớp này là ParseTreeTableModel.java

23. Visitor Pattern
    Đây là một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Cho phép định nghĩa thêm phép toán mới tác động lên các phần tử của một cấu trúc đối tượng mà không cần thay đổi các lớp định nghĩa cấu trúc đó.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng JTable.java và lớp con kế thừa lớp này là TreeTable.java



