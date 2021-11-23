# OOP-2021
Môn học Lập trình hướng đối tượng với Java

Thành viên nhóm
- 20021350 Nguyễn Tuấn Hiệp
- 20020155 Ngô Văn Minh Thắng



Link project: https://github.com/RefactoringGuru/design-patterns-java/tree/master/src/refactoring_guru



Các loại mẫu thiết kế:


# Creational pattern: Những Design pattern loại này cung cấp một giải pháp để tạo ra các object và che giấu được logic của việc tạo ra nó, thay vì tạo ra object một cách trực tiếp bằng cách sử dụng method new. Điều này giúp cho chương trình trở nên mềm dẻo hơn trong việc quyết định object nào cần được tạo ra trong những tình huống được đưa ra.
 
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

# Structural pattern: Những Design pattern loại này liên quan tới class và các thành phần của object. Nó dùng để thiết lập, định nghĩa quan hệ giữa các đối tượng.

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

