# So sánh câc mẫu thiết kế tìm được với mẫu chuẩn.
`Nguyễn Việt Quân`
# Builder package:
 1. _Giống nhau_: 
   - Builder pattern là một mẫu thiết kế thuộc "Nhóm khởi tạo" (Creational Pattern). Mẫu thiết kế này cho phép lập trình viên tạo ra những đối tượng phức tạp nhưng chỉ cần thông qua các câu lệnh đơn giản để tác động nên các thuộc tính của nó.
   - Đều dùng khi cần tạo ra một đối tượng phức tạp. Một đối tượng mà thuật toán để tạo tạo lập các thuộc tính là độc lập đối với các thuộc tính khác.
   - Về cấu trúc, đều sử dụng các 4 thành phần cơ bản như: Builder, Director, ConcreateBuilder, Product. Các đối tượng tương ứng trong lớp này là: HouseBuilder, PizzaBuilder, HouseDirector,..
   2. _Khác nhau_:
- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế Builder chuẩn.
# Bridge package
1. _Giống nhau_:
- Bridge Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Ý tưởng của nó là tách tính trừu tượng (abstraction) ra khỏi tính hiện thực (implementation) của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu.
- Được sử dụng để tách thành phần trừu tượng (Abstraction) và thành phần thực thi (Implementation) riêng biệt.
- Gồm 4 thành phần cơ bản: Client, Abstraction, Refined Abstraction (AbstractionImpl), Implementor, ConcreteImplementor...
- Cụ thể ở trong mẫu đã chọn là các lớp Client.java, các lớp abstract như RemoteControl.java, Imprementor như GenericRemote.java...
2. _Khác nhau_:
- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế Builder chuẩn.
# Adapt package:
1. _Giống nhau_:
- Đều sử dụng Adapt Pattern: Adapter Pattern (Người chuyển đổi) là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Adapter Pattern cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.
- Gồm các thành phần cơ bản: Adaptee, Adapter, Target, Client.
- Client là lớp Duck.java, Target là Drone.java, Adapter là Mallarđuck,...
2. _Khác nhau_:
- Sử dụng thêm mẫu Iterator pattern, cụ thể ở package iterenum.
- Còn lại cơ bản là giống với mẫu thiết kế mẫu.
# Factory package:
1. _Giống nhau_:
- Đều sử dụng mẫu thiết kế Factory pattern: là một trong những Pattern thuộc nhóm Creational Design Pattern. Nhiệm vụ của Factory Pattern là quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn.
- Gồm các thành phần cơ bản sau: Super Class, Sub classes, Factory Class,...
- Trong đó, Super class như Pizza đại diện cho các loại Pizza, các sub classes của nó là cheesePizza, clamPizza, PepperoniPizza, VeggiePizza.
- Factory class là simplePizzaFactory, PizzStore có trách nhiệm khởi tạo các sub classes.
2. _Khác nhau_:
- Có cấu trúc giống với mẫu thiết kế chuẩn.
# Iterator package
1. _Giống nhau_:
- Đều sừ dụng mẫu thiết kế Iterator: là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Nó được sử dụng để “Cung cấp một cách thức truy cập tuần tự tới các phần tử của một đối tượng tổng hợp, mà không cần phải tạo dựng riêng các phương pháp truy cập cho đối tượng tổng hợp này”.
- Gồm các thành phần cơ bản như: Aggregate, ConcreteAggregate, Iterator, ConcreteIterator, Client.
- Trong đó Aggregate là lớp Menu và Iterator- là một interface định nghĩa cho các phương thức để tạo iterator object. Client là các các class như DinerMenu, MenuItem được quản lý thông qua Iterator.
2. _Khác nhau_:
- Có cấu trúc giống với mẫu thiết kế chuẩn.

