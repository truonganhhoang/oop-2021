# OOP-2021
Môn học Lập trình hướng đối tượng với Java

Thành viên nhóm
- 20021350 Nguyễn Tuấn Hiệp
- 20020155 Ngô Văn Minh Thắng


Link project: https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru


Các loại mẫu thiết kế:


# Creational Pattern (nhóm khởi tạo): Những Design pattern loại này cung cấp một giải pháp để tạo ra các object và che giấu được logic của việc tạo ra nó, thay vì tạo ra object một cách trực tiếp bằng cách sử dụng method new. Điều này giúp cho chương trình trở nên mềm dẻo hơn trong việc quyết định object nào cần được tạo ra trong những tình huống được đưa ra.
 
 - Abstract Factory: 
   + Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng. 
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/abstract_factory/example
   
 - Factory Method:
   + Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/factory_method/example

 - Builder:
   + Tách rời việc xây dựng (construction) một đối tượng phức tạp khỏi biểu diễn của nó sao cho cùng một tiến trình xây dựng có thể tạo được các biểu diễn khác nhau.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/builder/example
 
 - Prototype:
   + Qui định loại của các đối tượng cần tạo bằng cách dùng một đối tượng mẫu, tạo mới nhờ vào sao chép đối tượng mẫu này.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/prototype

 - Singleton:
   + Đảm bảo 1 class chỉ có 1 instance và cung cấp 1 điểm truy xuất toàn cục đến nó.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/singleton/example

# Structural Pattern (nhóm cấu trúc): Những Design pattern loại này liên quan tới class và các thành phần của object. Nó dùng để thiết lập, định nghĩa quan hệ giữa các đối       tượng.

 - Adapter:
   + Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/adapter/example
 
 - Bridge:
   + Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (ngữ nghĩa và cài đặt) có thể thay đổi độc lập nhau.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/bridge/example
  
 - Composite:
   + Tổ chức các đối tượng theo cấu trúc phân cấp dạng cây. Tất cả các đối tượng trong cấu trúc được thao tác theo một cách thuần nhất như nhau. Tạo quan hệ thứ bậc bao gộp giữa các đối tượng. Client có thể xem đối tượng bao gộp và bị bao gộp như nhau -> khả năng tổng quát hoá trong code của client -> dễ phát triển, nâng cấp, bảo trì. 
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/composite/example
 
 - Decorator:
   + Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) vào lúc chạy (dynamically).
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/decorator/example
   
 - Facade:
   + Cung cấp một interface thuần nhất cho một tập hợp các interface trong một “hệ thống con” (subsystem). Nó định nghĩa 1 interface cao hơn các interface có sẵn để làm cho hệ thống con dễ sử dụng hơn.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/facade/example

 - Flyweight:
   + Sử dụng việc chia sẻ để thao tác hiệu quả trên một số lượng lớn đối tượng “cở nhỏ” (chẳng hạn paragraph, dòng, cột, ký tự…).
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/flyweight/example
   
 - Proxy:
   + Cung cấp đối tượng đại diện cho một đối tượng khác để hỗ trợ hoặc kiểm soát quá trình truy xuất đối tượng đó. Đối tượng thay thế gọi là proxy.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/proxy/example

# Behavioral Pattern (nhóm hành vi/ tương tác): Những Design pattern loại này liên quan tới class và các thành phần của object. Nó dùng để thiết lập, định nghĩa quan hệ giữa các đối tượng.

 = Chain Of Responsibilities (COR): 

   + Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể.
   + Tần suất sử dụng: trung bình thấp.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/chain_of_responsibility/example
  
 - Command:

   + Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo…
   + Tần suất sử dụng: cao trung bình.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/command/example
  
 - Interpreter:
  
   + Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ.
   + Tần suất sử dụng: thấp.
   + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/interpreter/example
  
 - Iterator: 
    + Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử.
    + Tần suất sử dụng: cao.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/iterator/example
    
 - Mediator:
    + Định nghĩa một đối tượng để bao bọc việc giao tiếp giữa một số đối tượng với nhau.
    + Tần suất sử dụng: trung bình thấp.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/mediator/example
    
 - Memento: 
    + Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu.
    + Tần suất sử dụng: thấp.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/memento/example
    
 - Observer:
    + Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.
    + Tần suất sử dụng: cao.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/observer/example
    
 - State:
    + Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.
    + Tần suất sử dụng: trung bình.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/state/example
 
 - Strategy:
    + Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.Cung cấp một họ giải thuật cho phép client chọn lựa linh động một giải thuật cụ thể khi sử dụng.
    + Tần suất sử dụng: cao trung bình.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/strategy/example

 - Template Method:
    + Định nghĩa phần khung của một thuật toán, tức là một thuật toán tổng quát gọi đến một số phương thức chưa được cài đặt trong lớp cơ sở; việc cài đặt các phương thức được ủy nhiệm cho các lớp kế thừa.
    + Tần suất sử dụng: trung bình.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/template_method/example

 - Visitor:
    + Cho phép định nghĩa thêm phép toán mới tác động lên các phần tử của một cấu trúc đối tượng mà không cần thay đổi các lớp định nghĩa cấu trúc đó.
    + Tần suất sử dụng: thấp.
    + https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru/visitor/example


