# OOP 2021
Môn học lập trình hướng đối tượng Java

## Thành viên
* Đinh Ngọc Sơn - 19020607 - K64K1
* Nguyễn Tiến Nghĩa - 19020586 - K64K1
*

## Báo cáo
## Báo cáo
### Repo mẫu thiết kế: [](https://github.com/ochococo/Design-Patterns-In-Swift)

- Đây là repo chứa đầy đủ 23 mẫu thiết kế được thiết kế dựa trên các mẫu thiết kế chuẩn. Dưới đây là sự so sánh giữa các mẫu trong repo với các mẫu thiết kế chuẩn tại https://refactoring.guru/design-patterns/java.
- Mối quan hệ của 23 pattern cơ bản:
  ![image](https://user-images.githubusercontent.com/40727116/143217386-00be1b04-1ec3-408d-8fe0-b64634deb18a.png)

## 1. Creational: [](https://github.com/ochococo/Design-Patterns-In-Swift/tree/master/source/creational)

- Nhóm này cung cấp phương pháp tạo ra các đối tượng một cách linh hoạt hơn. Nghĩa là quyết định đối tượng nào được tạo ra tuỳ thuộc vào trường hợp sử dụng nhất định.
- 5 mẫu: Factory Method, Abstract Factory, Builder, Prototype, Singleton.

### 1.1 Singleton

#### Giống:

  - Đảm bảo 1 class chỉ có 1 instance và cung cấp 1 điểm truy xuất toàn cục đến nó.
  - Dùng "new" để tạo các object mới trong class.
  - Các đối tượng mới không thể được sử dụng bời các chương trình khác.
  - Định nghĩa, cung cấp các public method trả về các object được tạo trong class này.

#### Khác:

- Singleton mang kiẻu Inner Class. [](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/creational/singleton.swift)
- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.

### 1.2 Abstract Factory / Factory
* [Factory](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/creational/factory.swift)
* [AbstractFactory](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/creational/abstract_factory.swift)

#### Giống:

- Abstract Factory: Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng.
- Factory: Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.
- Mục tiêu của Factory Pattern là quản lý và trả về các object theo yêu cầu, giúp cho việc khởi tạo object một cách linh hoạt hơn.
- Gồm các thành phần cơ bản sau: Super Class, Sub classes, Factory Class,...
  > Super class như CurrencyDescribing, các sub classes của nó là Euro, UnitedStatesDolar.

#### Khác:

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.

### 1.3 Prototype
* [Prototype](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/creational/prototype.swift)

#### Giống:

- Qui định loại của các object cần tạo bằng cách dùng một object mẫu, tạo mới nhờ vào sao chép object mẫu này.
- Có method Clone cho từng class phục vụ cho Moonwalke

#### Khác

- Thêm method Clone, chưa có nhiều thay đổi so với mẫu thiết kế chuẩn.

### 1.4 Builder
* [Builder](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/creational/builder.swift)

#### Giống:

- Tách rời việc xây dựng (construction) một đối tượng phức tạp khỏi biểu diễn của nó sao cho cùng một tiến trình xây dựng có thể tạo được các biểu diễn khác nhau.
- Đều dùng khi cần tạo ra một đối tượng phức tạp mà thuật toán để tạo tạo lập các thuộc tính là độc lập đối với các thuộc tính khác.

#### Khác:

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế Builder chuẩn.

## 2. Structural
- Nhóm này liên quan đến sự kết hợp giữa các đối tượng với nhau.
- 7 mẫu: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy.
- 
### 2.1 Adapter
* [Adapter](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/adapter.swift)

#### Giống:

- Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
- Cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau.

#### Khác:

- Sử dụng thêm mẫu Iterator pattern
- Ngoài ra không có sự thay đổi đáng kể so với mẫu thiết kế cơ bản


## Link tham khảo
* [23 Design patterns - Tutorialspoint](https://www.tutorialspoint.com/design_pattern/index.htm).
![](https://cdn.discordapp.com/attachments/888331184986284033/910731491087097856/unknown.png)
