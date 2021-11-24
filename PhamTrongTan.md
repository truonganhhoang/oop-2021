### Báo cáo Design Pattern.

### Các thành viên trong nhóm:
### * Phạm Trọng Tấn - 18021124
### * Phí Văn Tuân - 18021356

### **Link đến reposition được sử dụng trong bài báo cáo [spring-projects/spring-boot](https://github.com/spring-projects/spring-boot) + [Pizza-Delivery-System](https://github.com/DuyguKeskek/Pizza-Delivery-System)**

### Factory Pattern
* Factory Pattern là một design pattern được sử dụng rộng rãi để ra lệnh tạo các object. Trong đó, một class Factory được tạo như là lớp cha của tất cả các lớp con thuộc một logic segment (phân đoạn logic) nhất định.
* Factory Method: [artifactory](https://github.com/spring-phttps://github.com/DuyguKeskek/Pizza-Delivery-Systemring-boot/blob/main/buildSrc/src/main/java/org/springframework/boot/build/artifactory/ArtifactoryRepository.java) trong đó các Factory Method trên giống so với mẫu tiêu chuẩn bởi vì chúng đều tạo một Factory cho các class con đã được tạo và sử dụng nó để khởi tạo các object của mình mà không cần tiếp xúc trực tiếp với các object.

### Abstract Factory
* Abstract Factory là một design pattern thuộc nhóm Creational Pattern Design được xây dựng dựa trên Factory Pattern, nó sẽ tạo ra các factory là class con của nó và các factory này được tạo ra giống như cách mà factory tạo ra các sub-class.
* Abstract Factory: [AbstractConnectionFactoryConfigurer](https://github.com/spring-projects/spring-boot/blob/main/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/amqp/AbstractConnectionFactoryConfigurer.java) trong đó Abstract Factory trên giống khá giống với mẫu chuẩn là đều tạo ra các factory là các class con của nó, ở đây nó tạo ra nhóm các ConnetionFactoryConfigurer.

### Builder Pattern
* Builder Pattern là một design pattern thuộc nhóm Creational Design Pattern được sử dụng để xây dựng các object phức tạp với số lượng lớn các class và tham số.
* Builder Pattern: [Builder](https://github.com/spring-projects/spring-boot/blob/4eed637481186b0b85bc1cf0b1e77090139477dc/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/builder/SpringApplicationBuilder.java#L184) nó được sử dụng giống với mẫu thiết kế chuẩn, ở đây nó tạo ra 1 class SpringApplicationBuilder để xây dựng các object SpringApplication với số lượng khá lớn các class lồng nhau có cùng thuộc tính với SpringApplication.
* Builder Pattern: [Health](https://github.com/spring-projects/spring-boot/blob/4eed637481186b0b85bc1cf0b1e77090139477dc/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/health/Health.java#L331) nó thể hiện giống với mẫu thiết kế chuẩn, đều có Product, Builder, ConcreteBuilder, Director, tuy nhiên, người ta đã gộp luôn Builder và ConcreteBuilder thành static nested class bên trong Product. Cụ thể ở đây Product là class Health, đồng thời cung cấp method build() trong Class Builder để trả về đối tượng mà client cần.

### Singleton Pattern
* Singleton Pattern là một mẫu thiết kế tạo dựng (Creation Pattern). Singleton Pattern được dùng để ngăn cản việc tạo các thể hiện của một lớp (class) nhằm đảm bảo rằng luôn chỉ có 1 thể hiện của class tồn tại trong JVM.
* Singleton Pattern: [boot](https://github.com/spring-projects/spring-boot/blob/4eed637481186b0b85bc1cf0b1e77090139477dc/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/LazyInitializationBeanFactoryPostProcessor.java) trong đó Pattern trên không giống so với mẫu thiết kế chuẩn bởi vì mẫu thiết kế chuẩn trả về instance còn ở đây nó có sử dụng Lazy Initialization và dùng để kiểm tra và trả về dạng true/false, nó được tạo theo cách đó là tạo thể hiện của Class Singleton trong method access. Cách này có nhược điểm là không hoạt động đúng trong trường hợp có nhiều thread, giả sử có nhiều thread cùng lúc gọi method getInstance() sẽ có nhiều thể hiện khác nhau được tạo. 

### Filter Pattern
* Filter Pattern được sử dụng khi chúng ta cần lọc một object nào đó với các điều kiện khác nhau. Chúng ta có thể sâu chuỗi các điều kiện cho Filter hoặc có thể được thực hiện theo cách tách rời.
* Filter Pattern: [condition](https://github.com/spring-projects/spring-boot/blob/4eed637481186b0b85bc1cf0b1e77090139477dc/spring-boot-project/spring-boot-actuator-autoconfigure/src/main/java/org/springframework/boot/actuate/autoconfigure/condition/ConditionsReportEndpoint.java) chúng giống với mẫu thiết chuẩn, ở đây chúng sử dụng để lọc một object theo những điều kiện sau đó thêm nó vào list.

### Prototype Pattern
* Prototype Pattern là một mẫu tạo dựng, được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại.
* Prototype Pattern: [Info](https://github.com/spring-projects/spring-boot/blob/main/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/info/InfoProperties.java) chúng được thiết kế giống với mẫu thiết kế chuẩn để copy các object ban đầu sang object mới và thay đổi một số thuộc tính của đối tượng.

### MVC Pattern
* MVC Pattern là một mẫu kiến trúc, mô hình lập trình phổ biến được sử dụng để tạo cấu trúc cho nhiều trang web, ứng dụng tiên tiến.Ứng dụng sẽ được chia thành ba phần phụ thuộc và kết nối với nhau: Model, Views, Controller.
* MVC Pattern: [web](https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/web) chúng khá giống với thiết kế mẫu đều có ba thành phần là Model, Views, Controller, được thẻ hiện qua server, selvet, client, sql và các folder trong web.

### Facade Pattern
* Facade Pattern được dùng để các ứng dụng phía client dễ dàng giao tiếp với hệ thống. Thay vì phải làm việc với nhiều hệ thống/module con, Facade Pattern giúp ứng dụng client chỉ phải giao tiếp với 1 hệ thống duy nhất.
* Facade Pattern: [client](https://github.com/spring-projects/spring-boot/blob/main/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/web/client/BasicAuthentication.java) về cơ bản khá giống với mẫu thiết kế chuẩn, đều giúp cho phía client có thể dễ dàng giảo tiếp với hệ thống thông qua HttpRequest.

### Bridge Pattern
* Bridge Pattern hoạt động như một cầu nối làm cho chức năng của các lớp cụ thể độc lập với các lớp triển khai giao diện. Cả hai loại lớp đều có thể được thay đổi cấu trúc mà không ảnh hưởng đến nhau.
* Bridge Pattern: [bridge](https://github.com/JakubVojvoda/design-patterns-cpp/blob/master/bridge/Bridge.cpp) xây dựng dựa theo code chuẩn nên ko có sự khác biết

### Iterator Pattern
* Iterator Pattern được sử dụng để có được cách truy cập các phần tử của đối tượng tập hợp theo cách tuần tự mà không cần biết cấu trấu biểu diễn của chúng (có thể là array hoặc arrayList), hay có thể hoạt động trên nhiều loại Collections
* [Pizza-Delivery-System](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L243)

### Command Pattern
* Command Pattern là mẫu thiết kế hành vi chuyển đổi các yêu cầu hoặc hoạt động đơn giản thành các đối tượng. Mẫu này được sử dụng như một sự thay thế cho các lệnh gọi lại để tham số hóa các phần tử UI bằng các hành động. Nó cũng được sử dụng cho các tác vụ xếp hàng, theo dõi lịch sử hoạt động...
* Giao diện [Command](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L12) được tạo cho lớp  [PizzaRequestCommand](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L95) và [DrinkRequestCommand](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L107)
* Khác biệt so với mẫu chuẩn: Giao diện [Command](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L12) không chỉ để khởi tạo [PizzaRequestCommand](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L95) và [DrinkRequestCommand](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L107) mà còn được dùng để xây dựng trong lớp [TruckDriver](https://github.com/DuyguKeskek/Pizza-Delivery-System/blob/e241ec799240e92dc05ee8a6d8240f5421123f41/Pizza-Delivery-System.cpp#L121)
