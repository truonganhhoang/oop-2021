# Design Pattern - UET - Nhom3 - INT2204 3 - N2

## A. File Github sử dụng
Trong báo cáo này, chúng tôi sẽ sử dụng https://github.com/checkstyle/checkstyle . Đây là một công cụ dùng để kiểm tra về format code Java của lập trình viên, cho phép họ viết code tuân theo một quy chuẩn thống nhất. Mặc định, tool sẽ kiểm tra theo quy chuẩn lập trình Java của Google, nhưng nó có thể được điều chỉnh bởi lập trình viên với nhiều mục đích khác nhau.

## B. Design Pattern
Trong quá trình viết phần mềm này, nhà phát triển đã ứng dụng một số mẫu thiết kế thông dụng, giúp quá trình lập trình trở nên dễ dàng hơn. Sau đây là một số Design Patterns đã được sử dụng:

### 1. Factory Pattern
Đây là một trong nhưng mẫu được sử dụng phổ biến nhất hiện nay trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, người lập trình có thể tạo một đối tượng mới mà dựa trên một Interface có sẵn. Sau đây ta xét ví dụ trong dự án trên:

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle, có hai file Java có áp dụng Factory Pattern là ModuleFactory.java và PackageObjectFactory.java. Ta xét từng file một:

#### a. ModuleFactory.java
Đây là một Interface để sử dụng cho PackageObjectFactory.java. Trong class có duy nhất một hàm trừu tượng createModule(String name), với kiểu giá trị trả về là một Object. 

#### b. PackageObjectFactory.java
Class này đã được ứng dụng Interface ModuleFactory.java để thực hiện mục đích của mình: Tạo ra các đối tượng dựa trên tên Package và tên Class. Đầu tiên, hàm tạo một Object instance có giá trị bằng null. Tiếp đó, tùy vào khuôn dạng của biến đầu vào name mà hàm sẽ lần lượt đi qua các hàm check khác nhau, và tạo các object tương ứng với từng trường hợp. Ví dụ, nếu biến name không có dấu chấm, hàm sẽ thông qua hàm phụ trợ createFromStandardCheckSet để tạo đối tượng. 

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Có một Interface và một lớp áp dụng Interface đó để tạo đối tượng mới. 

### 2. Builder Pattern
Đây là một kiểu mẫu thiết kế chuyên về việc khởi tạo các đối tượng. Với mẫu thiết kế này, người lập trình có thể dễ dàng tạo ra các đối tượng mà không phải quan tâm đến việc cần những tham số nào cho hàm khởi tạo. Khi áp dụng, ta sẽ xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và tiếp cận từng bước, cho đến kết quả cuối cùng, mà không phải cùng lúc truyền nhiều tham số tới hàm khởi tạo, dễ gây nhầm lẫn và khó bảo trì. Với dự án trên, người ta đã áp dụng vào việc kiểm tra tuân theo các biểu thức chính quy (RegEx). Cụ thể là trong package com.puppycrawl.tools.checkstyle.checks.regexp

#### a. DetectorOptions.java
Class có ý nghĩa là chứa đựng các tùy chọn trong khi lọc các pattern. Đặc biệt, trong này còn có cả lớp con Builder, chính là hàm để xây dựng lên đối tượng mà mình mong muốn.

#### b. Ứng dụng trong các lớp khác.
Với file RegexpMultilineCheck.java, đối tượng Builder được sử dụng như sau:

    final DetectorOptions options = DetectorOptions.newBuilder() 
                .reporter(this)             
                .compileFlags(getRegexCompileFlags())
                .format(format)
                .message(message)
                .minimum(minimum)
                .maximum(maximum)
                .ignoreCase(ignoreCase)
                .build();

#### c. So sánh với mẫu chuẩn
Với mẫu chuẩn, ta cần 1 Interface và một class có implements Interface đó. Còn trong trường hợp này, người ta sử dụng Builder như một lớp con final trong một lớp cha final.

### 3. Abstract Factory

### 4. Singleton

### 5. Prototype

### 6. Adaptor

### 7. Bridge

### 8. Composite

### 9. Decorator Pattern:
Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) vào lúc chạy (dynamically). Tần suất sử dụng: TB - 3/5.
Lợi ích:
    - Giúp cho hệ thống của bạn trở nên đơn giản hơn trong việc sử dụng và trong việc hiểu nó, vì một mẫu Facade có các phương thức tiện lợi cho các tác vụ chung.
    - Giảm sự phụ thuộc của các mã code bên ngoài với hiện thực bên trong của thư viện, vì hầu hết các code đều dùng Facade, vì thế cho phép sự linh động trong phát triển các hệ thống.
    - Đóng gói tập nhiều hàm API được thiết kế không tốt bằng một hàm API đơn có thiết kế tốt hơn.

### 10. Facade Pattern
    Cung cấp một interface thuần nhất cho một tập hợp các interface trong một “hệ thống con” (subsystem). Nó định nghĩa 1 interface cao hơn các interface có sẵn để làm cho hệ thống con dễ sử dụng hơn. Tần suất sử dụng: Cao - 5/5.
Lợi ích: 
    - Giúp cho hệ thống của bạn trở nên đơn giản hơn trong việc sử dụng và trong việc hiểu nó, vì một mẫu Facade có các phương thức tiện lợi cho các tác vụ chung.
    - Giảm sự phụ thuộc của các mã code bên ngoài với hiện thực bên trong của thư viện, vì hầu hết các code đều dùng Facade, vì thế cho phép sự linh động trong phát triển các hệ thống.
    - Đóng gói tập nhiều hàm API được thiết kế không tốt bằng một hàm API đơn có thiết kế tốt hơn.
    
    * Trong src/main/java/com/puppycrawl/tools/checkstyle, class Checker.java có nhiệm vụ kiểm tra 1 tập file đóng gói 1 tập đối tượng thành phần, interface phục vụ kiểm tra riêng lẻ.
    => Giống hoàn toàn thiết kế mẫu.
### 11. Flyweight Pattern
Sử dụng việc chia sẻ để thao tác hiệu quả trên một số lượng lớn đối tượng “cở nhỏ” (chẳng hạn paragraph, dòng, cột, ký tự…). Tần suất sử dụng: Thấp - 1/5.
Lợi ích: 
    - Giảm số lượng đối tượng được tạo ra bằng cách chia sẻ đối tượng. Vì vậy, tiết kiệm bộ nhớ và các thiết bị lưu trữ cần thiết.
    - Cải thiện khả năng cache dữ liệu vì thời gian đáp ứng nhanh.
    - Tăng hiệu năng.
    
### 12. Proxy Pattern
Cung cấp đối tượng đại diện cho một đối tượng khác để hỗ trợ hoặc kiểm soát quá trình truy xuất đối tượng đó. Đối tượng thay thế gọi là proxy. Tần suất sử dụng: Cao TB - 4/5.
Lợi ích: 
    - Cải thiện performance thông qua lazy loading, chỉ tải các tài nguyên khi chúng được yêu cầu.
    - Nó cung cấp sự bảo vệ cho đối tượng thực từ thế giới bên ngoài.
    - Giảm chi phí khi có nhiều truy cập vào đối tượng có chi phí khởi tạo ban đầu lớn.
    - Dễ nâng cấp, bảo trì.

### 13. Chain of Responsibility Pattern
Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể. Tần suất sử dụng: TB thấp - 2/5.
Lợi ích: 
    - Giảm kết nối (loose coupling): Thay vì một đối tượng có khả năng xử lý yêu cầu chứa tham chiếu đến tất cả các đối tượng khác, nó chỉ cần một tham chiếu đến đối tượng tiếp theo. Tránh sự liên kết trực tiếp giữa đối tượng gửi yêu cầu (sender) và các đối tượng nhận yêu cầu (receivers).
    - Tăng tính linh hoạt : đảm bảo Open/Closed Principle.
    - Phân chia trách nhiệm cho các đối tượng: đảm bảo Single Responsibility Principle.
    - Có khả năng thay đổi dây chuyền (chain) trong thời gian chạy.
    - Không đảm bảo có đối tượng xử lý yêu cầu.

### 14. Command Pattern:
Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo… Tần suất sử dụng: Cao TB - 4/5.
Lợi ích:
    - Dễ dàng thêm các Command mới trong hệ thống mà không cần thay đổi trong các lớp hiện có. Đảm bảo Open/Closed Principle.
    - Tách đối tượng gọi operation từ đối tượng thực sự thực hiện operation. Giảm kết nối giữa Invoker và Receiver.
    - Cho phép tham số hóa các yêu cầu khác nhau bằng một hành động để thực hiện.
Cho phép lưu các yêu cầu trong hàng đợi.
Đóng gói một yêu cầu trong một đối tượng. Dễ dàng chuyển dữ liệu dưới dạng đối tượng giữa các thành phần hệ thống.

* Thể hiện trong interface CommentListener trong /src/main/java/com/puppycrawl/tools/checkstyle/grammar với chức năng gửi thông báo lỗi ngữ pháp.
* Giống thiết kế mẫu.

### 15. Interpreter Pattern:
Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ. Tần suất sử dụng: Thấp - 1/5.
Lợi ích:
    - Đảm bảo nguyên tắc Single responsibility principle (SRP) : chúng ta có thể tách phần cài đặt các phương thức của tập hợp và phần duyệt qua các phần tử (iterator) theo từng class riêng lẻ.
    - Đảm bảo nguyên tắc Open/Closed Principle (OCP) : chúng ta có thể implement các loại collection mới và iterator mới, sau đó chuyển chúng vào code hiện có mà không vi phạm bất cứ nguyên tắc gì.
    - Chúng ta có thể truy cập song song trên cùng một tập hợp vì mỗi đối tượng iterator có chứa trạng thái riêng của nó.

### 16. Iterator Pattern:
Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử. Tần suất sử dụng: Cao - 5/5.
Lợi ích: 
    - Đảm bảo nguyên tắc Single responsibility principle (SRP) : chúng ta có thể tách phần cài đặt các phương thức của tập hợp và phần duyệt qua các phần tử (iterator) theo từng class riêng lẻ.
    - Đảm bảo nguyên tắc Open/Closed Principle (OCP) : chúng ta có thể implement các loại collection mới và iterator mới, sau đó chuyển chúng vào code hiện có mà không vi phạm bất cứ nguyên tắc gì.
    - Chúng ta có thể truy cập song song trên cùng một tập hợp vì mỗi đối tượng iterator có chứa trạng thái riêng của nó.
    

### 17. Mediator Pattern
Đây là một trong nhưng mẫu không được sử dụng phổ biến hiện nay trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, một đối tượng để bao bọc việc giao tiếp giữa một số đối tượng với nhau. Sau đây ta xét ví dụ trong dự án trên:

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có AbstractCheck.java là lớp trừu tượng và AnnotationLocationCheck.java, AnnotationOnSameLineCheck.java, AnnotationUseStyleCheck.java là các lớp con kế thứa lớp AbstractCheck.java và thông qua lớp mẹ để giao tiếp với nhau.

Xét từng lớp cụ thể:

#### a. AbstractCheck.java
Đây là một Abstract sử dụng cho việc check các annotation, có rất nhiều hàm, và có 3 hàm trừu tượng mà lớp con phải override. 

#### b. AnnotationLocationCheck.java
Đây là class con kiểm tra vị trí chú thích.

#### c. AnnotationOnSameLineCheck.java
Đây là class con kiểm tra các chú thích trên cùng một dòng.

#### d. AnnotationUseStyleCheck.java
Đây là class con kiểm tra kiểu chú thích. 

#### e. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Có một lớp trừu tượng và một các lớp con kế thừa nó để tạo ra đối tuượng mới và có liên quan đến nhau. 

### 18. Memento Pattern
Đây là một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, người lập trình có thể Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng Task.java và lớp con kế thừa lớp này là CheckstyleAntTask.java.

Xét từng lớp cụ thể:

#### a. Task.java
Là một lớp interface task.

#### b. CheckstyleAntTask.java
Class này đã được ứng dụng Interface Task.java để thực hiện mục đích của mình: Tạo ra các đối tượng dựa trên tên Package và tên Class. Kiểm tra các kiểu  bài tập mong muốn được thực thi.

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn.

### 19. Observer Pattern
Đây là một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng AuditEventFormatter.java và lớp con kế thừa lớp này là AuditEventDefaultFormatter.java

Xét từng lớp cụ thể:

#### a. AuditEventFormatter.java
Là một lớp trừu tượng kiểm tra các định dạng của các sự kiện diễn ra.

#### b. AuditEventDefaultFormatter.java
Class này đã được ứng dụng Abstract AuditEventFormatter.java để thực hiện mục đích của mình: Kiểm tra các sự kiện có khuôn dạng mặc định.

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.

### 20. State Pattern
Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng AuditEventFormatter.java và lớp con kế thừa lớp này là AuditEventDefaultFormatter.java

Xét từng lớp cụ thể:

#### a. AuditEventFormatter.java
Là một lớp trừu tượng kiểm tra các định dạng của các sự kiện diễn ra.

#### b. AuditEventDefaultFormatter.java
Class này đã được ứng dụng Abstract AuditEventFormatter.java để thực hiện mục đích của mình: Kiểm tra các sự kiện có khuôn dạng mặc định.

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.

### 21. Strategy Pattern
Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình cao trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.Cung cấp một họ giải thuật cho phép client chọn lựa linh động một giải thuật cụ thể khi sử dụng.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng Configuration.java và lớp con kế thừa lớp này là DefaultConfiguration.java

Xét từng lớp cụ thể:

#### a. Configuration.java
Là một lớp trừu tượng định nghĩa các cấu hình của client.

#### b. DefaultConfiguration.java
Class này đã được ứng dụng Interface DefaultConfiguration.java để thực hiện mục đích của mình: cấu hình mặc định cho client.

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn.

### 22. Template method Pattern
Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Định nghĩa phần khung của một thuật toán, tức là một thuật toán tổng quát gọi đến một số phương thức chưa được cài đặt trong lớp cơ sở; việc cài đặt các phương thức được ủy nhiệm cho các lớp kế thừa.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp Interface TreeModel.java và lớp con kế thừa lớp này là  ParseTreeTableModel.java

Xét từng lớp cụ thể:

#### a. TreeModel.java
Là một lớp trừu tượng định nghĩa các mô hình cây.

#### b.  ParseTreeTableModel.java
Class này đã được ứng dụng Interface TreeModel.java để phân tích cú pháp mô hình bàn cây.

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Đánh giá dựa trên thuật toán mô hình cây.

### 23. Visitor Pattern
Đây là một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Cho phép định nghĩa thêm phép toán mới tác động lên các phần tử của một cấu trúc đối tượng mà không cần thay đổi các lớp định nghĩa cấu trúc đó.

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có lớp trừu tượng JTable.java và lớp con kế thừa lớp này là TreeTable.java

Xét từng lớp cụ thể:

#### a. JTable.java
Là một lớp trừu tượng định nghĩa trong thư viện của java.

#### b.  TreeTable.java
Class này đã được ứng dụng Interface TreeModel.java sử dụng các thuật toán để thiết lập một mô hình bảng cây.

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Đánh giá dựa trên thuật toán mô hình cây.
