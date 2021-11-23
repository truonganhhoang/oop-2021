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

#### Factory Method
- File Metrics.java chứa lớp Metrics thực chất là một lớp Factory hỗ trợ việc việc khởi tạo các các đối tượng thuộc interface Scrapable nhằm che giấu việc phương thức khởi tạo và thống nhất việc khởi tạo các đối tượng cụ thể thuộc các lớp như Counter, CounterWithOneLabel đều implements 1 interface là Scrapable
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

* Giống nhau : giống với mẫu chuẩn
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

* Giống nhau : giống với mẫu chuẩn
* Khác nhau : 
