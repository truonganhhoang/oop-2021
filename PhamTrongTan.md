### Báo cáo Design Pattern.

### Các thành viên trong nhóm:
### * Phạm Trọng Tấn - 18021124
### * Phí Văn Tuân

### **Link đến reposition được sử dụng trong bài báo cáo [spring-projects/spring-boot](https://github.com/spring-projects/spring-boot)**

### Factory Pattern
* Factory Pattern là một design pattern được sử dụng rộng rãi để ra lệnh tạo các object. Trong đó, một class Factory được tạo như là lớp cha của tất cả các lớp con thuộc một logic segment (phân đoạn logic) nhất định.
* Factory Method: [artifactory](https://github.com/spring-projects/spring-boot/blob/main/buildSrc/src/main/java/org/springframework/boot/build/artifactory/ArtifactoryRepository.java) trong đó các Factory Method trên giống so với mẫu tiêu chuẩn bởi vì chúng đều tạo một Factory cho các class con đã được tạo và sử dụng nó để khởi tạo các object của mình mà không cần tiếp xúc trực tiếp với các object.

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



