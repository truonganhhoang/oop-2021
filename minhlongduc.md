Design pattern's report:
## 20021395 Nguyễn Quang Minh
## 20021387 Nguyễn Phúc Long
## 20021334 Đào Văn Đức
## Các thành viên commit vào repo của nhóm: https://github.com/minh16022002/NguyenQuangMinh

**1. Repo 1:https://github.com/aritraroy/PatternLockView?fbclid=IwAR2Pg4eIPS8W2NUxNkU0bnueW8uWCbMEjOYuYU90euGqcMmc1WsAi7St5bU**
- Abstract Factory: là phương pháp tạo ra một Super-factory dùng để tạo ra các Factory khác. Hay còn được gọi là Factory của các Factory.

+ package com.andrognito.rxpatternlockview.events
	abstract class BasePatternLockEvent
		-> extends: class PatternLockCompleteEvent
		-> extends: class PatternLockCompoundEvent
		-> extends: class PatternLockProgressEvent

+ package com.andrognito.rxpatternlockview.observables
	abstract class BasePatternLockViewObservable
		-> extends: class PatternLockViewCompleteObservable
		-> extends: class PatternLockViewCompoundObservable
		-> extends: class PatternLockViewProgressObservable

- Singleton: đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp cho bạn một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.

package com.andrognito.patternlockview.utils;
class PatternLockUtils

class RandomUtils

class ResourceUtils

- Adapter: các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau.

	abstract class BasePatternLockViewObservable extends: io.reactivex.Observable
		-> extends: class PatternLockViewCompleteObservable
		-> extends: class PatternLockViewCompoundObservable
		-> extends: class PatternLockViewProgressObservable

**2. Repo 2: https://github.com/liu-jianhao/Cpp-Design-Patterns?fbclid=IwAR1GkSRQBmd5q7f4AAvW8veAEl3oz39jhyf_BwHeiGKWkr1CVzy5Manv1Z8**

## Creational Patterns:
+ Builder pattern: Tách rời việc xây dựng (construction) một đối tượng phức tạp khỏi biểu diễn của nó sao cho cùng một tiến trình xây dựng có thể tạo được các biểu diễn khác nhau.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Builder

+ Factory Method được sinh ra nhằm mục đích khởi tạo một đối tượng mới mà không cần thiết phải chỉ ra một cách chính xác class nào sẽ được khởi tạo, chúng được trả về dưới dạng các lớp trừu tượng.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Factory-Pattern

+ Prototype pattern là một trong những Creational pattern. Nó cho phép sao chép các đối tượng hiện có mà không làm cho mã của bạn phụ thuộc vào các lớp của chúng.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Prototype


## Structural Patterns:
+ Bridge Pattern là một trong những Pattern thuộc nhóm Structural Pattern. Ý tưởng của nó là tách tính trừu tượng (abstraction) ra khỏi tính hiện thực (implementation) của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu -> cả hai bộ phận có thể thay đổi độc lập nhau. Nó giúp giảm sự phụ thuộc giữa abstraction và implementation, giảm số lượng những lớp con không cần thiết, code gọn gàng, dễ bảo trì, mở rộng về sau và cho phép ẩn các chi tiết implement từ. Tuy nhiên nó có thể làm tăng độ phức tạp khi áp dụng cho một lớp có tính gắn kết cao.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Bridge

+ Composite Pattern là một mẫu thiết kế thuộc nhóm Structural Pattern: Tổ chức các đối tượng theo cấu trúc phân cấp dạng cây. Tất cả các đối tượng trong cấu trúc được thao tác theo một cách thuần nhất như nhau. Tạo quan hệ thứ bậc bao gộp giữa các đối tượng. Client có thể xem đối tượng bao gộp và bị bao gộp như nhau -> khả năng tổng quát hoá trong code của client -> dễ phát triển, nâng cấp, bảo trì.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Composite

+ Decorator Pattern: Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) vào lúc chạy (dynamically) mà không làm thay đổi cấu trúc lớp của nó. Decorator này nằm trong nhóm mẫu thiết kế mang tính cấu trúc (Structural pattern) bởi vì nó thể hiện như là đóng gói của một lớp đã tồn tại.
==> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Decorator-Pattern

+ Facade Pattern là một lớp có một interface đơn giản nhưng uỷ quyền hầu hết các công việc cho lớp khác.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Decorator-Pattern

+ Flyweight là một phương pháp trả về các đối tượng được lưu trong bộ nhớ đệm thay vì tạo mới.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Flyweight

+ Proxy ủy quyền tất cả công việc thực sự cho một số đối tượng khác. Cuối cùng, mỗi phương thức proxy phải tham chiếu đến một đối tượng dịch vụ trừ khi proxy là một lớp con của một dịch vụ.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Proxy


## Behavioral Patterns:
+ Chain_of_responsibility: hắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Chain%20of%20Resposibility

+ Command Pattern thuộc nhóm các pattern hành vi: Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo…

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Command-Pattern

+ Iterator pattern mẫu này được sử dụng để truy cập vào các phần tử một cách tuần tự mà không cần phải hiểu biết về nó.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Iterator

+ Mediator Pattern sử dụng phổ biến nhất là hỗ trợ giao tiếp giữa các thành phần GUI của một ứng dụng.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Mediator

+ Memento sử dụng tuần tự hóa, điều này khá phổ biến trong C++, nó cho phép lưu trữ các bản sao lưu trạng thái trong khi bảo vệ cấu trúc của người khởi tạo khỏi các đối tượng khác.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Memento

+ Observer pattern có thể được nhận dạng bằng các phương thức đăng ký, lưu trữ các đối tượng trong một danh sách và bằng các lệnh gọi đến phương thức cập nhật được cấp cho các đối tượng trong danh sách đó.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Observer-Pattern

+ State Pattern là một trong những mẫu thiết kế thuộc nhóm Behavioral Pattern cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/State

+ Strategy pattern (mẫu chiến lược): cho phép bạn xác định một nhóm thuật toán, đặt mỗi thuật toán vào một lớp riêng biệt và làm cho các đối tượng của chúng có thể hoán đổi cho nhau.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Strategy-Pattern

+ Template Method Pattern là một trong những Pattern thuộc nhóm Behavior Pattern. Nó xác định khung của một thuật toán trong lớp cha nhưng cho phép lớp con ghi đè các bước cụ thể của thuật toán mà không thay đổi cấu trúc của nó.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Template-Pattern

+ Visitor là mẩu thiết kế thuộc Behavioral pattern, cho phép bạn tách các thuật toán khỏi các đối tượng mà chúng hoạt động trên đó.

=> https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Visitor

## Kết luận:
	Các mẫu thiết kế trên đều tương đồng với mẫu thiết kế chuẩn.
