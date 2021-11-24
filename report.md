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

### 2.2 Bridge
* [Bridge]()https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/bridge.swift)

#### Giống:

- Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (ngữ nghĩa và cài đặt) có thể thay đổi độc lập nhau.
- Được sử dụng để tách thành phần trừu tượng (Abstraction) và thành phần thực thi (Implementation) riêng biệt.

#### Khác:

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.

### 2.3 Decorator
* [Decorator](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/decorator.swift)

#### Giống:

- Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) vào lúc chạy (dynamically).

#### Khác:

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.

### 2.4 Composite
* [Composite](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/composite.swift)

#### Giống:

- Tổ chức các đối tượng theo cấu trúc phân cấp dạng cây. Tất cả các đối tượng trong cấu trúc được thao tác theo một cách thuần nhất như nhau.
- Tạo quan hệ thứ bậc bao gộp giữa các đối tượng. Client có thể xem đối tượng bao gộp và bị bao gộp như nhau -> khả năng tổng quát hoá trong code của client -> dễ phát triển, nâng cấp, bảo trì.

#### Khác:

- Về cơ bản, khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.

### 2.5 Facade
* [Facade](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/facade.swift)

#### Giống:

- Cung cấp một interface thuần nhất cho một tập hợp các interface trong một “hệ thống con” (subsystem). Nó định nghĩa 1 interface cao hơn các interface có sẵn để làm cho hệ
  thống con dễ sử dụng hơn

#### Khác:

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.

### 2.6 Flyweight
* [Flyweight](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/flyweight.swift)

#### Giống:

- Sử dụng việc chia sẻ để thao tác hiệu quả trên một số lượng lớn đối tượng “cở nhỏ” (chẳng hạn paragraph, dòng, cột, ký tự…).
- Cố gắng sử dụng lại các đối tượng hiện có cùng loại, nếu không tìm thấy đối tượng phù hợp, một đối tượng mới sẽ được tạo.

#### Khác:

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.

### 2.7 Proxy
* [Protection Proxy](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/protection_proxy.swift)
* [Virtual Proxy](https://github.com/ochococo/Design-Patterns-In-Swift/blob/master/source/structural/virtual_proxy.swift)

#### Giống:

- Cung cấp đối tượng đại diện cho một đối tượng khác để hỗ trợ hoặc kiểm soát quá trình truy xuất đối tượng đó. Đối tượng thay thế gọi là proxy.

#### Khác:

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.


## Link tham khảo
* [23 Design patterns - Tutorialspoint](https://www.tutorialspoint.com/design_pattern/index.htm).
![](https://cdn.discordapp.com/attachments/888331184986284033/910731491087097856/unknown.png)
