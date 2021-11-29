 Báo cáo tìm hiểu về mẫu thiết kế
## Thành viên: Họ và tên - MSSV
## 1. Hồ Thanh Huyền - 20020323
## 2. Đặng Việt Linh - 20021383
## 3. Nguyễn Ngọc Hiệp - 20021349
- **[Link đến reposition được sử dụng trong bài báo cáo](https://github.com/dbacinski/Design-Patterns-In-Kotlin
-                                                        https://github.com/bethrobson/Head-First-Design-Patterns
- )**

Abstract Factory: Nó có thể được hình dung như một nhà máy lớn, bên trong có các nhà máy nhỏ hơn sản xuất ra những loạt sản phẩm liên quan đến nhau.
Cung cấp hướng tiếp cận với Interface thay thì các implement, che giấu sự phức tạp của việc khởi tạo các đối tượng với người dùng (client), độc lập giữa việc khởi tạo đối tượng và hệ thống sử dụng,...
Giúp tránh được việc sử dụng điều kiện logic bên trong Factory Pattern. Khi một Factory Method lớn (có quá nhiều sử lý if-else hay switch-case), chúng ta nên sử dụng theo mô hình Abstract Factory để dễ quản lý hơn (cách phân chia có thể là gom nhóm các sub-class cùng loại vào một Factory).
Abstract Factory Pattern là factory của các factory, có thể dễ dạng mở rộng để chứa thêm các factory và các sub-class khác.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/AbstractFactory.kt

Adapter Pattern (Người chuyển đổi) là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Adapter Pattern cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.
Chuyển đổi giao diện của một lớp thành một giao diện khác mà khách hàng mong đợi. Bộ điều hợp cho phép các lớp hoạt động cùng nhau mà không thể vì các giao diện không tương thích, tức là. cho phép sử dụng máy khách có giao diện không tương thích bởi Bộ điều hợp thực hiện chuyển đổi. Bộ điều hợp có mục đích cấu trúc và có thể được áp dụng trên các lớp và cả trên đối tượng. Bộ điều hợp lớp sử dụng đa kế thừa để điều chỉnh một giao diện này sang một giao diện khác và bộ điều hợp đối tượng sử dụng thành phần đối tượng để kết hợp các lớp với các giao diện khác nhau.
bạn muốn sử dụng một lớp hiện có và giao diện của nó không khớp với một lớp bạn cần
bạn muốn tạo một lớp có thể sử dụng lại hợp tác với các lớp không nhất thiết phải có giao diện tương thích
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Adapter.kt

Bridge Pattern được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt. Do đó, các thành phần này có thể thay đổi một cách độc lập mà không ảnh hưởng đến các thành phần khác. Thay vì liên hệ với nhau bằng quan hệ kế thừa, hai thành phần này liên hệ với nhau thông qua quan hệ “chứa trong” (object composition).
Dạng thức bắc cầu là một dạng thức thiết kế được dùng trong công nghệ phần mềm. Dạng thức bắc cầu dùng để "tách riêng tính trừu tượng ra khỏi thực thể của nó để cho cả hai có thể thay đổi một cách độc lập".
=> https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/bridge/example/Demo.java

Builder pattern là một mẫu thiết kế thuộc "Nhóm khởi tạo" (Creational Pattern). Mẫu thiết kế này cho phép lập trình viên tạo ra những đối tượng phức tạp nhưng chỉ cần thông qua các câu lệnh đơn giản để tác động nên các thuộc tính của nó.
Builder là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và biểu diễn khác nhau của một đối tượng bằng cách sử dụng cùng một hàm khởi tạo (construction).
đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.
ConcreateBuilder: là thành phần triển khai, cụ thể hóa các lớp trừu tượng cho để tạo ra các thành phần và tập hợp các thành phần đó với nhau. thành phần này sẽ xác định và nắm giữ các thể hiện mà nó tạo ra. Đồng thời nó cũng cung cấp phương thức để trả các các thể hiện mà nó đã tạo ra trước đó.
Product: thành phần này trong bài viết sẽ đại diện cho đối tượng phức tạp phải tạo ra
Director: thành phần này sẽ khởi tạo đối tượng Builder
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Builder.kt

Chain_of_responsibility: là một mẫu thiết kế hành vi bao gồm một nguồn các đối tượng lệnh và một loạt các đối tượng xử lý. Mỗi đối tượng xử lý chứa logic xác định các loại đối tượng lệnh mà nó có thể xử lý, phần còn lại được chuyển cho đối tượng xử lý tiếp theo trong chuỗi.
Trong thiết kế hướng đối tượng, mẫu chuỗi trách nhiệm là một mẫu thiết kế hành vi bao gồm một nguồn các đối tượng lệnh và một loạt các đối tượng xử lý. Mỗi đối tượng xử lý chứa logic xác định các loại đối tượng lệnh mà nó có thể xử lý; phần còn lại được chuyển cho đối tượng xử lý tiếp theo trong chuỗi.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/ChainOfResponsibility.kt

Mẫu thiết kế Flyweight là mẫu thiết kế được sử dụng việc chia sẻ để trợ giúp một lượng lớn các đối tượng một cách hiệu quả. Các hiệu ứng của FLyweight pattern đòi hỏi nhiều vào việc được sử dụng ở đâu và sử dụng như nào.
Flyweight là một mẫu thiết kế phần mềm. Khi nhiều đối tượng phải được xử lý mà chương trình không thể chịu nổi một lượng dữ liệu khổng lồ, thì cần dùng flyweight. Trong mẫu flyweight, dữ liệu không có các con trỏ đến các phương thức của kiểu dữ liệu đó, vì như thế sẽ tốn rất nhiều bộ nhớ.
=> https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/flyweight/example/Demo.java

Interpreter Pattern là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Interpreter Pattern giúp người lập trình có thể “xây dựng” những đối tượng “động” bằng cách đọc mô tả về đối tượng rồi sau đó “xây dựng” đối tượng đúng theo mô tả đó.
Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ.
Đối với một ngôn ngữ, mẫu xác định sự lưu ý cho ngữ pháp của nó cùng với trình thông dịch sử dụng biểu diễn để diễn giải các câu trong ngôn ngữ đó. Mẫu thông dịch viên có mục đích hành vi và áp dụng cho các lớp.
=> https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/interpreter/example/Demo.java

Iterator pattern là mẫu thiết kế rât thường được sử dụng trong môi trường lập trình Java và .NET. Mẫu này được sử dụng để truy cập vào các phần tử của collection object một cách tuần tự mà không cần phải hiểu biết về nó.
Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử.
để truy cập nội dung của một đối tượng tổng hợp mà không để lộ phần đại diện bên trong của nó
để cung cấp một giao diện thống nhất để duyệt qua các cấu trúc tổng hợp khác nhau (để hỗ trợ lặp lại đa hình)
để hỗ trợ nhiều đường truyền của các đối tượng tổng hợp
=>https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/iterator/example/Demo.java

Mediator Pattern là một Design Pattern thuộc loại Behavior, đóng vai trò giảm sự phụ thuộc lẫn nhau của các tượng. Mediator Pattern hạn chế việc tương tác trức tiếp với nhau giữa các đối tượng và bắt chúng phải tương tác với nhau qua một đối tượng chung gian là Mediator.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Mediator.kt

Memento là một Design Pattern thuộc loại Behavior. Nó cho phép chúng ta lưu trữ và khôi phục trạng thái của một đối tượng mà không tiết lộ chi tiết bên trong của nó.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Memento.kt

Observer pattern là một mẫu thiết kế phần mềm mà một đối tượng, gọi là subject, duy trì một danh sách các thành phần phụ thuộc nó, gọi là observer, và thông báo tới chúng một cách tự động về bất cứ thay đổi nào, thường thì bằng cách gọi 1 hàm của chúng.
=> https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/observer/example/Demo.java

Prototype pattern là một trong những Creational pattern. Nó có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new. Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.
=> https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/prototype/example/Demo.java

Proxy Pattern là mẫu thiết kế mà ở đó tất cả các truy cập trực tiếp đến một đối tượng nào đó sẽ được chuyển hướng vào một đối tượng trung gian (Proxy Class). Mẫu Proxy (người đại diện) đại diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với múc đích sử dụng.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/ProtectionProxy.kt

Single Pattern là một design pattern mà
    Đảm bảo rằng một class chỉ có duy nhất một instance
    Và cung cấp một cáchs toàn cầu để truy cấp tới instance đó.

=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Singleton.kt

State Pattern là một trong những mẫu thiết kế thuộc nhóm behavioral cho phép một object có thể biến đổi hành vi của nó khi có những sự thay đổi trạng thái nội bộ.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/State.kt

Strategy pattern (mẫu chiến lược): hiểu một cách đơn giản thì đây là mẫu thiết kế giúp bạn trừu tượng hóa những hành vi (behavior, method, function) của một đối tượng bằng cách đưa ra những cài đặt vào những lớp khác nhau.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Strategy.kt

Template Method Pattern là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Pattern này nói rằng “Định nghĩa một bộ khung của một thuật toán trong một chức năng, chuyển giao việc thực hiện nó cho các lớp con. Mẫu Template Method cho phép lớp con định nghĩa lại cách thực hiện của một thuật toán, mà không phải thay đổi cấu trúc thuật toán“.
=> https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/template_method/example/Demo.java

Visitor là mẩu thiết kế(Design Patterns) cho phép định nghĩa các thao tác(operations) trên một tập hợp các đối tượng (objects) không đồng nhất (về kiểu) mà không làm thay đổi định nghĩa về lớp(classes) của các đối tượng đó.
=> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Visitor.kt
Command Pattern:
Command pattern thuộc nhóm các pattern hành vi: Đóng gói tất cả thông tin cần thiết vào 1 đối tượng để thực hiện hành động hay kích hoạt một sự kiện thực hiện sau đó. Các thông tin có thể bao gồm tên phương thức, các biến và giá trị cần thiết...hay đơn giản hơn đó là nó cho phép chuyển yêu cầu thành đối tượng độc lập, có thể được sử dụng để tham số hóa các đối tượng với các yêu cầu khác nhau như log, queue (undo/redo), transtraction.Command pattern thuộc nhóm các pattern hành vi: Đóng gói tất cả thông tin cần thiết vào 1 đối tượng để thực hiện hành động hay kích hoạt một sự kiện thực hiện sau đó. Các thông tin có thể bao gồm tên phương thức, các biến và giá trị cần thiết...hay đơn giản hơn đó là nó cho phép chuyển yêu cầu thành đối tượng độc lập, có thể được sử dụng để tham số hóa các đối tượng với các yêu cầu khác nhau như log, queue (undo/redo), transtraction.
==> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Command.kt

Composite Pattern
Composite là một mẫu thiết kế thuộc nhóm Structural Pattern. Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.
==> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Composite.kt

Decorator Pattern
Decorator là một trong 23 mẫu thiết kế Gang of Four mô tả làm thế nào để giải quyết vấn đề thiết kế các phần mềm mang tính hướng đối tượng một các linh hoạt và có tính tái sử dụng.
Decorator cho phép người dùng thêm các tính năng mới vào một đối tượng đã có mà không làm thay đổi cấu trúc lớp của nó.
Decorator này nằm trong nhóm mẫu thiết kế mang tính cấu trúc (Structural pattern) bởi vì nó thể hiện như là đóng gói của một lớp đã tồn tại.
==> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Decorator.kt

Facade Pattern
Facade Pattern cung cấp một interface đơn giản và cao cấp nhất cho phía client (máy khách) và cho phép nó truy cập vào hệ thống mà không cần biết bên trong có logic hệ thống nào hay nó hoạt động như thế nào.
==> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Facade.kt

Factory Method Pattern
Là một design pattern thuộc nhóm khởi tạo (Creational patterns). Pattern này được sinh ra nhằm mục đích khởi tạo một đối tượng mới mà không cần thiết phải chỉ ra một cách chính xác class nào sẽ được khởi tạo. Factory Method Pattern giải quyết vấn đề này bằng cách định nghĩa một factory method cho việc tạo đối tượng, và các lớp con thừa kế có thể override phương thức này để chỉ rõ đối tượng nào sẽ được khởi tạo.
==> https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/FactoryMethod.kt

#Kết luận: Trong dự án trên do nội dung là về design pattern nên mẫu thiết kế được sử dụng khá tương đồng với 23 mẫu thiết kế chuẩn.
