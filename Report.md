# Bài báo cáo tìm hiểu về các mẫu thiết kế
## Môn lập trình hướng đối tượng
### Lớp INT_2204_3

#### Danh sách thành viên:
* Nguyễn Trường Sơn - MSV: 19020609
* Nguyễn Hoàng Hiệp - MSV: 19020541
* Phạm Thanh Ngân - MSV: 19020584

#### **Về việc làm bài báo cáo**: 
- Mỗi thành viên sẽ làm phần việc mình được giao và sẽ commit vào repo chung của nhóm khi đã hoàn tất (**[link repo của nhóm](https://github.com/sonishere/oop-2021)**)
- **[Link repo làm tài liệu tham khảo và phân tích](https://github.com/youlookwhat/DesignPattern)**

## Nội dung báo cáo:
### **A. Creational Pattern**
#### ***1. Abstract Factory***
- Giống nhau: 
  -  Pattern có cấu tạo như sau:
  1. AbstractFactory: interface *XianRoujiaMoYLFoctory* chứa công đoạn làm món ăn **Rou Jia Mo** (Bánh mì kẹp Tây An)
  2. Product: Các đối tượng Meet, Yuanlao
  3. ConcreteFactory: Các subclass của các Product như: ChangShaFreshMeet, ChangShaTeSeYuanLiao, XianTeSeYuanLiao...
  4. Client: **Rou Jia Mo**
- Khác nhau: 
  - Không tồn tại AbstractProduct, các Method (Meet, YuanLao) được khởi tạo chỉ dưới dạng class thường, không phải abstract hoặc interface
```java
                  package com.example.jingbin.designpattern.factory.cxgc;

                  /**
                   * Created by jingbin on 2016/10/26.
                   */

                  public class Meet {
                  }
```

#### ***2. Factory Method***
- Giống nhau:
  - Cấu tạo của Pattern:
  1. Super Class: Class RoujiaMoStore đại diện cho các cửa hàng bán **Rou Jia Mo**, chứa các công đoạn chuẩn bị và xuất kho
  2. Sub Class: Các chi nhánh: XianKuRoujiMo, XianSuanRoujiMo, XianlaRoujiMo, XianSuanRoujiMo
  3. Factory: Class XianSimpleRoujiaMoFactory xử lí input và đưa về các chi nhánh (sub class)
- Khác nhau:
  - Không có sự khác nhau, Pattern đang xét tuân thủ đúng theo cấu trúc mẫu
 
 #### ***3. Builder***
 - Giống nhau:
 
<p align="center">
 <img src="https://github.com/sonishere/sonishere/blob/main/UML.png" width="500">
</p>

 - Như ta có thể thấy theo hình trên, pattern builder của repo có cấu trúc tương tự như của Gang Of Four (GOF):
    - Builder: (Builder.java) là 1 abstract class và được kế thừa bởi 1 ConcreteBuilder (ConcreteBuider.java)
    - Director: (Director.java) để gọi tới Builder
    - Product: đại diện cho đối tượng cần tạo, đối tượng này phức tạp, có nhiều thuộc tính
- Khác nhau: Không có sự khác nhau, Pattern đang xét tuân thủ đúng theo cấu trúc mẫu

 #### ***4. Prototype***
 - Giống nhau:
    - Prototype: Class Shape đóng vai trò khởi tạo một hình nói chung
    - ConcretePrototype: Các class con đóng vai trò clone theo yêu cầu (Circle, Rectangle, Square)
    - Client: Class ShapeCache đóng vai trò yêu cầu Shape clone các hình (Circle, Rectangle, Square)
```java
              public class ShapeCache {

              private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

              public static Shape getShape(String shapeId) {
                  Shape shapeCache = shapeMap.get(shapeId);
                  return (Shape) shapeCache.clone();
              }

              public static void loadCache() {
                  Circle circle = new Circle();
                  circle.setId("1");
                  shapeMap.put(circle.getId(), circle);

                  Rectangle rectangle = new Rectangle();
                  rectangle.setId("2");
                  shapeMap.put(rectangle.getId(), rectangle);

                  Square square = new Square();
                  square.setId("3");
                  shapeMap.put(square.getId(), square);
              }
          }
```
- Khác nhau: Không có sự khác nhau, Pattern đang xét tuân thủ đúng theo cấu trúc mẫu

#### ***5. Singleton***
- Giống nhau: Đều tuân thủ các nguyên tắc cơ bản của Implement Singleton Pattern:
    - private constructor để hạn chế truy cập từ class bên ngoài.
    - Đặt private static final variable đảm bảo biến chỉ được khởi tạo trong class.
    - Có một method public static để return instance được khởi tạo ở trên.
- Repo có một số loại Implement khá hiệu quả như: 
  - Double Check Locking Singleton:
```java
        private static SingletonLanHan singletonLanHanFour;

        public static SingletonLanHan getSingletonLanHanFour() {
            if (singletonLanHanFour == null) {
                synchronized (SingletonLanHan.class) {
                    if (singletonLanHanFour == null) {
                        singletonLanHanFour = new SingletonLanHan();
                    }
                }
            }
            return singletonLanHanFour;
        }
```

   > Cách này đã khắc phục được nhược điểm của cách Thread Safe Singleton (một phương thức synchronized sẽ chạy rất chậm và tốn hiệu năng, bất kỳ Thread nào gọi đến đều phải chờ nếu có một Thread khác đang sử dụng. Có những tác vụ xử lý trước và sau khi tạo thể hiện không cần thiết phải block). Để implement theo cách này, chúng ta sẽ kiểm tra sự tồn tại thể hiện của lớp, với sự hổ trợ của đồng bộ hóa, hai lần trước khi khởi tạo. Phải khai báo volatile cho instance để tránh lớp làm việc không chính xác do quá trình tối ưu hóa của trình biên dịch.
    
   - Bill Pugh Singleton Implementation:
  
```java
      public class SingletonIn {

          private SingletonIn() {
          }

          private static class SingletonInHodler {
              private static SingletonIn singletonIn = new SingletonIn();
          }

          public static SingletonIn getSingletonIn() {
              return SingletonInHodler.singletonIn;
          }
      }
```

  >Với cách làm này bạn sẽ tạo ra static nested class với vai trò 1 Helper khi muốn tách biệt chức năng cho 1 class function rõ ràng hơn. Đây là cách thường hay được sử dụng và có hiệu suất tốt (theo các chuyên gia đánh giá). Khi Singleton được tải vào bộ nhớ thì SingletonInHodler chưa được tải vào. Nó chỉ được tải khi và chỉ khi phương thức getSingletonIn() được gọi. Với cách này tránh được lỗi cơ chế khởi tạo instance của Singleton trong Multi-Thread, performance cao do tách biệt được quá trình xử lý. Do đó, cách làm này được đánh giá là cách triển khai Singleton nhanh và hiệu quả nhất.

- Khác nhau: Không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF

- Khác nhau: Không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF

### **B. Structural Pattern**
#### ***1. Adapter***
  Adapter Pattern (Người chuyển đổi) là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Adapter Pattern cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.
- Giống nhau: Pattern bao gồm các thành phần cơ bản sau:
  1. Adaptee
  2. Adapter
  3. Target
  4. Client
  - Trong đó giao diện trên một chiếc điện thoại di động tốn 5V, điện áp gia đình là 220, vậy nên ta cần 1 Adapter (cụ thể là class V5PowerAdapter) để chuyển đổi điện áp 220V sang 5V:

```java
          public class V5PowerAdapter implements V5Power {

              private int v220power;

              public V5PowerAdapter(V220Power v220Power) {
                  v220power = v220Power.provideV220Power();
              }

              @Override
              public int provideV5Power() {

                  Log.e("---", "适配器: 经过复杂的操作,将" + v220power + "v电压转为5v");
                  return 5;
              }
          }
```

-Khác nhau: Về cơ bản, không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF

#### ***2. Bridge***
- Bridge Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Ý tưởng của nó là tách tính trừu tượng (abstraction) ra khỏi tính hiện thực (implementation) của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu.
- Giống nhau:
   -  Cấu trúc Pattern Bridge:
   1. Client: đại diện cho khách hàng sử dụng các chức năng thông qua Abstraction.
   2. Abstraction : định ra một abstract interface quản lý việc tham chiếu đến đối tượng hiện thực cụ thể (Implementor).
   3. Refined Abstraction (AbstractionImpl) : hiện thực (implement) các phương thức đã được định ra trong Abstraction bằng cách sử dụng một tham chiếu đến một đối tượng của      Implementer.
   4. Implementor : định ra các interface cho các lớp hiện thực. Thông thường nó là interface định ra các tác vụ nào đó của Abstraction.
   5. ConcreteImplementor : hiện thực Implementor interface.
   - Trong đó repo đã sử dụng các ví dụ về vẽ vòng tròn và màu sắc gồm các bước:
      - Tạo class DrawAPI để thực hiện việc tạo giao diện
      - Tạo các class triển khai dao diện dựa trên DrawAPI
      - Tạo class Shape dựa trên DrawAPI
      - Tạo class Circle dựa trên Shape
      - Sử dụng Shape và DrawAPI để vẽ các hình màu khác nhau
```java
        binding.btRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 画红圆
                Circle circle = new Circle(10, 10, 100, new RedCircle());
                circle.draw();
            }
        });

        binding.btGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 画绿圆
                Circle circle = new Circle(20, 20, 100, new GreenCircle());
                circle.draw();
            }
        });
```

-Khác nhau: Về cơ bản, không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF

#### ***3. Composite***
- Bản chất: Composite là một mẫu thiết kế thuộc nhóm cấu trúc (Structural Pattern). Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.
- Trong repo lần này tác giả đã không theo quy tắc chuẩn của GOF bởi không tồn tại FileComponent một cách cụ thể, chỉ tồn tại FolderComposite tên Employee (bản thân đã đóng vai trò là FileComponent và bao gồm các Leaf)
```java
    public class Employee {

    private String name;
    // 部门
    private String dept;
    // 工资
    private int salary;
    // 员工 list
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +
                '}';
    }
```

-  Và class **Client** (class CompositeActivity) để thao tác:

```java
        final Employee ceo = new Employee("John", "CEO", 30000);

        Employee headSales = new Employee("Robert", "Head sales", 20000);

        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

        ceo.add(headSales);
        ceo.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
```
#### ***4. Decorator***
- Bản chất: Decorator pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Nó cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác. Kiểu thiết kế này có cấu trúc hoạt động như một lớp bao bọc (wrap) cho lớp hiện có. Mỗi khi cần thêm tính năng mới, đối tượng hiện có được wrap trong một đối tượng mới (decorator class).
- Repo đang xét đã lấy ví dụ về việc đính đá quý (GemDecorator) lên các thiết bị (Equips) trong trò chơi, trong đó:
  -  Lớp **Component** tên IEquips là một interface quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này (ví dụ ở đây là calculateAttack và description)
```java
        public interface IEquip {

            /**
             * 计算攻击力
             */
            public int caculateAttack();

            /**
             * 装备的描述
             */
            public String description();
        }
```
  - Lớp **ConcreteComponent** là các lớp thực thể của Component (ArmEquips, RingEquips,...)
  - Lớp **Decorator** tên IEuipDecorator quản lý việc "đính" các đá quý lên trang bị (Concrete Component)
  - Lớp **Concrete Decorator** là lớp hiện thực cho Decorator, cụ thể ở đây là các loại đá quý (BlueGemDecorator, RedGemDecorator, GreenGemDecorator)
 - Tổng kết, không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF
#### ***5. Facade***
- Bản chất: Facade Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Pattern này cung cấp một giao diện chung đơn giản thay cho một nhóm các giao diện có trong một hệ thống con (subsystem). Facade Pattern định nghĩa một giao diện ở một cấp độ cao hơn để giúp cho người dùng có thể dễ dàng sử dụng hệ thống con này.
- Giống nhau:
  - Repo đã dùng cấu trúc của việc chiếu phim tại nhà (HomeTheater) để làm ví dụ, trong đó: 
    - Khi xem phim tại nhà, ta cần chuẩn bị rất nhiều thứ như: bật máy tính, tắt đèn, bật máy lòng bỏng ngô, làm bỏng ngô, bật máy chiếu, bật âm thanh.... và sau khi xem xong lại phải lặp lại 1 loạt để thực hiện việc kết thúc. Nếu như không sắp xếp các công việc rõ ràng thì sẽ rất mệt và tốn thời gian!
    - Vì vậy class HomeTheaterFacade đã sắp xếp các công việc riêng lẻ vào từng hành động chính (xem phim và ngừng xem phim) một cách hợp lí. Các công việc này không cần biết class Facade và ko cần Implement từ nó.
```java
      public void watchMovie() {
        computer.on();
        light.down();
        popcornPopper.on();
        popcornPopper.makePopcorn();
        projector.on();
        projector.open();
        player.on();
        player.make3DListener();
    }

    public void stopMovie() {
        computer.off();
        light.up();
        player.off();
        popcornPopper.off();
        projector.close();
        projector.off();
    }
```
- Khác nhau: không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF
#### ***6. Flyweight***
- Bản chất: Flyweight Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Nó cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng hoặc tạo đối tượng mới khi không tìm thấy đối tượng phù hợp.
- Giống nhau:
  - Repo đã sử dụng việc vẽ 20 hình tròn bằng 5 màu tại các vị trí random (ngẫu nhiên) để làm ví dụ, trong đó:
  -  Class FlyweightActivity đóng vai trò như FlyweightFactory quản lí việc vẽ hình tròn. Để tránh tình trạng tràn bộ nhớ hoặc quái tải bộ nhớ, Hàm ShapeFactory cố gắng sử dụng lại các đối tượng hiện có cùng loại và nếu không tìm thấy đối tượng phù hợp, một đối tượng mới sẽ được tạo, nếu hình tròn chuẩn bị vẽ cùng màu thì sẽ gọi sẵn những hình đã vẽ.
```java
    public static Shape getShape(String color) {
        Shape shape = circleMap.get(color);
        if (shape == null) {
            shape = new Circle(color);
            circleMap.put(color, shape);
            Log.e("getShape", "Creating circle of color : " + color);
        }
        return shape;
    }
```
- Khác nhau: không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF

#### ***7. Proxy***

- Bản chất: Proxy Pattern là mẫu thiết kế mà ở đó tất cả các truy cập trực tiếp đến một đối tượng nào đó sẽ được chuyển hướng vào một đối tượng trung gian (Proxy Class). Mẫu Proxy (người đại diện) đại diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với múc đích sử dụng.
- Giống nhau:
   - Repo đã lấy việc load ảnh từ disk làm ví dụ:
   1. Tạo giao diện (Image.java)
   2. Tạo một RealImage lớp thực thể triển khai giao diện. (Lớp proxy tương ứng: ProxyImage)
   3. Khi được yêu cầu, hãy sử dụng ProxyImage để lấy các đối tượng của lớp RealImage. 
```java
     public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        Log.e("RealImage", "loading " + fileName);
    }

    @Override
    public void display() {
        Log.e("RealImage", "Displaying " + fileName);
    }
```
- Khác nhau: không có quá nhiều sự khác biệt rõ rệt, cơ bản Pattern tuân thủ theo GOF
