# Design Pattern - UET - Nhom3 - INT2204 3 - N2

## A. File Github sử dụng
Trong báo cáo này, chúng tôi sẽ sử dụng https://github.com/checkstyle/checkstyle . Đây là một công cụ dùng để kiểm tra về format code Java của lập trình viên, cho phép họ viết code tuân theo một quy chuẩn thống nhất. Mặc định, tool sẽ kiểm tra theo quy chuẩn lập trình Java của Google, nhưng nó có thể được điều chỉnh bởi lập trình viên với nhiều mục đích khác nhau.

## B. Design Pattern
Trong quá trình viết phần mềm này, nhà phát triển đã ứng dụng một số mẫu thiết kế thông dụng, giúp quá trình lập trình trở nên dễ dàng hơn. Sau đây là một số Design Patterns đã được sử dụng:

### 1. Factory Pattern
Đây là một trong nhưng mẫu được sử dụng phổ biến nhất hiện nay trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, người lập trình có thể tạo một đối tượng mới mà dựa trên một Interface có sẵn. Sau đây ta xét ví dụ trong dự án trên:

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có hai file Java có áp dụng Factory Pattern là ModuleFactory.java và PackageObjectFactory.java. Ta xét từng file một:

#### a. ModuleFactory.java
Đây là một Interface để sử dụng cho PackageObjectFactory.java. Trong class có duy nhất một hàm trừu tượng createModule(String name), với kiểu giá trị trả về là một Object. 

#### b. PackageObjectFactory.java
Class này đã được ứng dụng Interface ModuleFactory.java để thực hiện mục đích của mình: Tạo ra các đối tượng dựa trên tên Package và tên Class. Đầu tiên, hàm tạo một Object instance có giá trị bằng null. Tiếp đó, tùy vào khuôn dạng của biến đầu vào name mà hàm sẽ lần lượt đi qua các hàm check khác nhau, và tạo các object tương ứng với từng trường hợp. Ví dụ, nếu biến name không có dấu chấm, hàm sẽ thông qua hàm phụ trợ createFromStandardCheckSet để tạo đối tượng. 

#### c. So sánh với mẫu chuẩn 
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Có một Interface và một lớp áp dụng Interface đó để tạo đối tượng mới. 

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
