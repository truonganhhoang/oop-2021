# OOP - 2021
### 1. Nguyễn Hoàng Anh - 19020493 - Nhóm Trưởng
### 2. Phạm Quốc Bảo - 19020502
### 3. Lê Huy Bình - 19020503


- **[Link tài liệu.](https://refactoring.guru/design-patterns/catalog)**
- **[Link repo của nhóm.](https://github.com/Thang12321/BT_OOP_DesignPattern)**
- **[Link đến repo sử dụng trong bài báo cáo.](https://github.com/bethrobson/Head-First-Design-Patterns)**
  <br />
  <br />

  | Creational patterns | Structural patterns | Behavioral patterns |
  | :-----------: | :-----------: | :-----------: |
  | ![img.png](https://images.viblo.asia/db99da2e-7eee-45b2-90ee-8e599f975a29.png) | ![img_1.png](https://images.viblo.asia/d32eddff-6ff8-4e3c-a2f2-9aa0185312a7.png) | ![img_2.png](https://images.viblo.asia/6653a5ac-b273-4002-9226-8470e4eb6867.png) |
  | Các mẫu này cung cấp các cơ chế tạo đối tượng khác nhau, giúp tăng tính linh hoạt và khả năng tái sử dụng mã hiện có.      | Những mẫu này giải thích cách tập hợp các đối tượng và lớp thành các cấu trúc lớn hơn trong khi vẫn giữ cho các cấu trúc này linh hoạt và hiệu quả.       | Các mẫu này liên quan đến các thuật toán và sự phân công trách nhiệm giữa các đối tượng. |

## I, Creational

#### Factory Method
- File Metrics.java chứa lớp Metrics thực chất là một lớp Factory hỗ trợ việc việc khởi tạo các các đối tượng thuộc interface Scrapable nhằm che giấu việc phương thức khởi tạo và thống nhất việc khởi tạo các đối tượng cụ thể thuộc các lớp như Counter, CounterWithOneLabel đều implements 1 interface là Scrapable.
  <br />  <br />
- Metrics ghi đè phương thức gốc của factory để nó trả về một loại khác.

```

    public class Metrics implements Scrapable {
        public static Metrics enabled() {
            return new Metrics(true, new MetricsRegistryImpl());
        }
        
        public static Metrics disabled() {
            return new Metrics(false, new NullMetricsRegistry());
        }
    }

```

* Giống nhau : giống với mẫu chuẩn.
* Khác nhau : 

#### Singleton

- Lớp RecordValueSinkFactory khai báo phương thức tĩnh getInstance trả về cùng một thể hiện của lớp riêng của nó.

Phương thức khởi tạo của RecordValueSinkFactory nên được ẩn khỏi code của client. Gọi phương thức getInstance là cách duy nhất để lấy đối tượng RecordValueSinkFactory.


```

      public class RecordValueSinkFactory {

          public static RecordValueSink getInstance(BytecodeAssembler asm, ColumnTypes columnTypes, @Transient ColumnFilter columnFilter) {
              return asm.newInstance();
          }

```

* Giống nhau : giống với mẫu chuẩn.
* Khác nhau : 

#### Builder

- Builder pattern là một trong những Creational pattern. Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.
- Builder Pattern được xây dựng để khắc phục một số nhược điểm của Factory Pattern và Abstract Factory Pattern khi mà Object có nhiều thuộc tính.
  - Quá nhiều tham số phải truyền vào từ phía client tới Factory Class.
  - Một số tham số có thể là tùy chọn nhưng trong Factory Pattern, chúng ta phải gửi tất cả tham số, với tham số tùy chọn nếu không nhập gì thì sẽ truyền là null.
  - Nếu một Object có quá nhiều thuộc tính thì việc tạo sẽ phức tạp.

- Link: 
  - https://github.com/questdb/questdb/blob/master/core/src/main/java/io/questdb/DefaultServerConfiguration.java
  - https://github.com/questdb/questdb/blob/ce5977cb08dc8d60e42896d3dcaf867907fb6d5c/core/src/main/java/io/questdb/ServerConfiguration.java#L36    

* Giống nhau : giống với mẫu chuẩn.
* Khác nhau : 

## II, Structural 

## III, Behavioral

#### Chain of Responsibility

- Chain of Responsiblity cho phép một đối tượng gửi một yêu cầu nhưng không biết đối tượng nào sẽ nhận và xử lý nó.Điều này được thực hiện bằng cách kết nối các đối tượng nhận yêu cầu thành một chuỗi (chain) và gửi yêu cầu theo chuỗi đó cho đến khi có một đối tượng xử lý nó.
- Các thành phần tham gia mẫu Chain of Responsibility:

  - Handler : định nghĩa 1 interface để xử lý các yêu cầu. Gán giá trị cho đối tượng successor (không bắt buộc).
  - ConcreteHandler : xử lý yêu cầu. Có thể truy cập đối tượng successor (thuộc class Handler). Nếu đối tượng ConcreateHandler không thể xử lý được yêu cầu, nó sẽ gởi lời yêu cầu cho successor của nó.
  - Client : tạo ra các yêu cầu và yêu cầu đó sẽ được gửi đến các đối tượng tiếp nhận.
- Trong ví dụ là hệ thống Logger:
  - Logger: là một class Handler, cho phép thực hiện một chain logger dựa vào giá trị LogLevel ứng với từng Handler.
  - LogConsoleWriter, LogFileWriter, EmailLogger: đây là các ConcreteHandler, nó xác định LogLevel mà nó có thể xử lý.
  - LogLevel : là một class dùng để xác định các mức độ ghi log.
- Link: https://github.com/questdb/questdb/tree/ce5977cb08dc8d60e42896d3dcaf867907fb6d5c/core/src/main/java/io/questdb/log
