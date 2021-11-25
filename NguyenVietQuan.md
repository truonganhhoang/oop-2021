# Bài báo cáo tìm hiểu về các mẫu thiết kế
## Môn lập trình hướng đối tượng
### Lớp INT_2204_3

# Danh sách thành viên:
* Nguyễn Việt Quân - 19020596
* Trần Ngọc Vinh - 19020659

#### Git repository link: https://github.com/bethrobson/Head-First-Design-Patterns.
#### Đây là repo chứa đầy đủ 23 mẫu thiết kế được thiết kế dựa trên các mẫu thiết kế chuẩn. Dưới đây là sự so sánh giữa các mẫu trong repo với các mẫu thiết kế chuẩn tại https://refactoring.guru/design-patterns/java.

# Builder package:
 1. _Giống nhau_: 
   - Builder pattern là một mẫu thiết kế thuộc "Nhóm khởi tạo" (Creational Pattern). Mẫu thiết kế này cho phép lập trình viên tạo ra những đối tượng phức tạp nhưng chỉ cần thông qua các câu lệnh đơn giản để tác động nên các thuộc tính của nó.
   - Đều dùng khi cần tạo ra một đối tượng phức tạp. Một đối tượng mà thuật toán để tạo tạo lập các thuộc tính là độc lập đối với các thuộc tính khác.
   - Về cấu trúc, đều sử dụng các 4 thành phần cơ bản như: Builder, Director, ConcreateBuilder, Product. Các đối tượng tương ứng trong lớp này là: HouseBuilder, PizzaBuilder, HouseDirector,..
   - Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/builder/house.
   2. _Khác nhau_:
- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế Builder chuẩn.
# Bridge package
1. _Giống nhau_:
- Bridge Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Ý tưởng của nó là tách tính trừu tượng (abstraction) ra khỏi tính hiện thực (implementation) của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu.
- Được sử dụng để tách thành phần trừu tượng (Abstraction) và thành phần thực thi (Implementation) riêng biệt.
- Gồm 4 thành phần cơ bản: Client, Abstraction, Refined Abstraction (AbstractionImpl), Implementor, ConcreteImplementor...
- Cụ thể ở trong mẫu đã chọn là các lớp Client.java, các lớp abstract như RemoteControl.java, Imprementor như GenericRemote.java...
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/bridge/remote.
2. _Khác nhau_:
- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế Builder chuẩn.
# Adapt package:
1. _Giống nhau_:
- Đều sử dụng Adapt Pattern: Adapter Pattern (Người chuyển đổi) là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Adapter Pattern cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.
- Gồm các thành phần cơ bản: Adaptee, Adapter, Target, Client.
- Client là lớp Duck.java, Target là Drone.java, Adapter là Mallarđuck,...
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/adapter/ducks.
2. _Khác nhau_:
- Sử dụng thêm mẫu Iterator pattern, cụ thể ở package iterenum.
- Còn lại cơ bản là giống với mẫu thiết kế mẫu.
# Factory package:
1. _Giống nhau_:
- Đều sử dụng mẫu thiết kế Factory pattern: là một trong những Pattern thuộc nhóm Creational Design Pattern. Nhiệm vụ của Factory Pattern là quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn.
- Gồm các thành phần cơ bản sau: Super Class, Sub classes, Factory Class,...
- Trong đó, Super class như Pizza đại diện cho các loại Pizza, các sub classes của nó là cheesePizza, clamPizza, PepperoniPizza, VeggiePizza.
- Factory class là simplePizzaFactory, PizzStore có trách nhiệm khởi tạo các sub classes.
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/factory/pizzas.
2. _Khác nhau_:
- Có cấu trúc giống với mẫu thiết kế chuẩn.
# Singleton package:
1. _Giống nhau_:
- Sử dụng Singleton pattern: Đảm bảo class tạo ra duy nhất 1 biến đó (kiểu như là static class vậy). Và tất nhiên là static thì phải có cách truy cập trong phạm vi toàn cầu
- Mỗi class đều bao gồm 1 class Singleton và 1 class SingletonClient để kiểm tra tính unique của Singleton class
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/singleton/enumS.
2. _Khác nhau_:
- Mỗi class lại chưa 1 cách để implement Singleton pattern khác nhau
- Ngoài các cách thường thấy còn có, Enum Initialization, Volatitle Initialization
# Prototype package:
1. _Giống nhau_:
- Sử dụng Protype pattern: Tạo 1 đối tượng bằng cách Clone một đối tượng đã tồn tại
- Có method Copy cho từng class phục vụ cho Clone
- Link design pattern:https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/prototype.
2. _Khác nhau_:
- Đơn giản chỉ là việc Implement thêm method clone nên không có sự mới mẻ gì    
# Facade package:
1. _Giống nhau_:
- Sử dụng Facade pattern: Tức là định nghĩa 1 giao diện cao hơn làm cầu nối giữa các giao diện nhỏ trong 1 nhóm giao diện
- Ở đây Class Movie đóng vai trò như 1 container giúp các đối tượng khác truy cập đến các class trong hệ thống movie theater như <Projector, Screen...vv>  thông qua class này.
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/facade/hometheater.
2. _Khác nhau_:
- Đối tượng Facade ở đây <MovieTheaterFacade> không phải là Singleton
# Iterator package
1. _Giống nhau_:
- Đều sừ dụng mẫu thiết kế Iterator: là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Nó được sử dụng để “Cung cấp một cách thức truy cập tuần tự tới các phần tử của một đối tượng tổng hợp, mà không cần phải tạo dựng riêng các phương pháp truy cập cho đối tượng tổng hợp này”.
- Gồm các thành phần cơ bản như: Aggregate, ConcreteAggregate, Iterator, ConcreteIterator, Client.
- Trong đó Aggregate là lớp Menu và Iterator- là một interface định nghĩa cho các phương thức để tạo iterator object. Client là các các class như DinerMenu, MenuItem được quản lý thông qua Iterator.
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/iterator/dinermerger.
2. _Khác nhau_:
- Có cấu trúc giống với mẫu thiết kế chuẩn.
# State package
1. _Giống nhau_:
- Đều sử dụng mẫu thiết kế State Pattern: Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.
- Nó gồm những thành phần cơ bản như: Context, State, ConcreteState.
- Cụ thể: State.java là một lớp trừu tượng kiểm tra các sự kiện đang diễn ra. HasQuarterState.java Class này đã được ứng dụng Abstract State.java để thực hiện mục đích của mình: Kiểm tra các sự kiện có khuôn dạng mặc định.
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/state/gumballstatewinner.
2. _Khác nhau_:
- Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
# Strategy Package:
1. _Giống nhau_: 
- Đều sử dụng mẫu thiết kế chuẩn Strategy Pattern: Đây là một trong nhưng mẫu có hiệu suất sử dụng trung bình cao trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.Cung cấp một họ giải thuật cho phép client chọn lựa linh động một giải thuật cụ thể khi sử dụng.
- Gồm 4 thành phần cơ bản: Strategy, ConcreteStrategy, Context.
- Cụ thể: QuackBehavior.java là một lớp trừu tượng đại diên cho hành vi của Client. Tiếp đến Quack.java Class này được ứng dụng QuackBehavior.java để thực hiện mục đích của mình: Cấu hình cho client.
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/strategy.
2. _Khác nhau_:
- Về cơ bản, khuôn dạng cũng giống với mẫu chuẩn.
# Observer Package
1. _Giống nhau_:
- Đều sử dụng mẫu thiết kế chuẩn Observer Pattern: Đây là một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.
- Gồm những thành phần cơ bản sau: Subject, Observer, ConcreteSubject, ConcreteObserver.
- Xét những đối tượng cụ thể: Ta có Observer là lớp Observer.java sẽ được subject thông báo đến khi có sự thay đổi trạng thái. Subject là lớp Subject.java là một lớp trừu tượng kiểm tra các định dạng của các sự kiện diễn ra.
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/observer/weather.
2. _Khác nhau_: 
- Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
# Flyweight Package:
1: _Giống nhau_:
- Đều sử dụng mẫu thiết kế Flyweight Pattern:  là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Nó cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng hoặc tạo đối tượng mới khi không tìm thấy đối tượng phù hợp.
- Nó gồm 2 trạng thái chính: Intrinsic State (trạng thái nội tại) và Extrinsic State (trạng thái bên ngoài).
- Xét những đối tượng cụ thể: 
- - Ta có lớp Tree.java là một interface định nghĩa các các thành phần của một đối tượng. 
- - ConiferTree.java triển khai các phương thức đã định nghĩa trong Tree. 
- - TreeFactory.java ớp này có thể là một Factory Pattern được sử dụng để giữ tham chiếu đến đối tượng Flyweight đã được tạo ra.
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/flyweight.
2: _Khác nhau_:
- Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
# Composite Package:
1. _Giống nhau_:
- Đều sử dụng mẫu thiết kế Composite Pattern: là một mẫu thiết kế thuộc nhóm cấu trúc (Structural Pattern). Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.
- Gồm các thành phần cơ bản sau:
- - Base Component : là một interface hoặc abstract class quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.
- - Leaf : là lớp hiện thực (implements) các phương thức của Component. Nó là các object không có con.
- - Composite : lưu trữ tập hợp các Leaf và cài đặt các phương thức của Base Component. Composite cài đặt các phương thức được định nghĩa trong interface Component bằng cách ủy nhiệm cho các thành phần con xử lý.
- - Client: sử dụng Base Component để làm việc với các đối tượng trong Composite.
- Cụ thể:
- - Base Component là lớp MenuComponent.java
- - Leaf là lớp Menu.java.
- - Composite là lớp MenuItem.java
- - Client là Waitress.java
- Link design pattern: https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/composite/menuiterator.
2. _Khác nhau_:
- Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.

