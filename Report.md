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
