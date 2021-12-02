# OOP - 2021
### 1. Nguyễn Hoàng Anh - 19020493
### 2. Phạm Quốc Bảo - 19020502
### 3. Lê Huy Bình - 19020503


- **[Link tài liệu.](https://refactoring.guru/design-patterns/catalog)**
- **[Link repo của nhóm.](https://github.com/relaxday123/oop-2021)**
- **[Link đến repo sử dụng trong bài báo cáo.](https://github.com/questdb/questdb?fbclid=IwAR0bQVTOcpqL1NQS5uNAkb0NxlnfUlX6SVCKkpEX0B8kl4rYx1S7JI47EEk)**
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

#### Adapter

- Adapter pattern là một Structural pattern. Adapter pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng xây dựng và xử lí các dao diện khác nhau nhưng lại có hành vi giống nhau( Các lớp có hành vi tương tự nhưng phương thức khác nhau ).
- Ví dụ giao diện IndexFrameCursor:
```
    public interface IndexFrameCursor {
        IndexFrame getNext();
    }
```
- Lớp NullIndexFrameCursor
```
    public class NullIndexFrameCursor implements IndexFrameCursor {
        public static final NullIndexFrameCursor INSTANCE = new NullIndexFrameCursor();

        @Override
        public IndexFrame getNext() {
            return IndexFrame.NULL_INSTANCE;
        }
    }
```
- Lớp Cursor
```
    private class Cursor implements RowCursor, IndexFrameCursor {
        protected long valueCount;
        protected long minValue;
        protected long next;
        private long valueBlockOffset;
        private final BitmapIndexUtils.ValueBlockSeeker SEEKER = this::seekValue;

        @Override
        public IndexFrame getNext() {
            // See BitmapIndexFwdReader if it needs implementing
            throw new UnsupportedOperationException();
        }
        ...
      }
```
=> Các lớp này đều phát triển dựa trên giao diện IndexFrameCursor và có các method với hành vi khác nhau.
* Giống nhau : giống với mẫu chuẩn.
* Khác nhau :

#### Decorator

- Decorator pattern là một Structural pattern. Decorator pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng các lớp cho phép bạn tự động thay đổi hành vi của một đối tượng tại thời điểm chạy bằng cách gói chúng trong một đối tượng của lớp Decorator.
- Ví dụ giao diện RowCursor:
```
public interface RowCursor {
    /**
     * @return true if cursor has more rows, otherwise false.
     */
    boolean hasNext();

    /**
     * @return numeric index of the next row
     */
    long next();
}
```
- Lớp NullCursor được implements dựa trên Rowcursor và sẽ thay đổi giá trị value nếu ta tạo 1 lớp NullCursor lúc chạy chương trình.
```
private static class NullCursor implements RowCursor {
        private long value;

        @Override
        public boolean hasNext() {
            return value > -1;
        }

        @Override
        public long next() {
            return value--;
        }
    }
```

* Giống nhau : giống với mẫu chuẩn.
* Khác nhau :

#### Facade

- Facade là một mẫu thiết kế cấu trúc cung cấp một giao diện đơn giản hóa cho một thư viện, một khuôn khổ hoặc bất kỳ tập hợp lớp phức tạp nào khác.
- Ví dụ giao diện FilesFacade:
```
      public interface FilesFacade {
          long MAP_FAILED = -1;
      
          long append(long fd, long buf, int len);
      
          boolean close(long fd);
      
          int copy(LPSZ from, LPSZ to);
      
          int errno();
      
          boolean exists(LPSZ path);
          
          ...
      }
```
- Facade cung cấp truy cập thuận tiện đối với một phần cụ thể của chức năng của hệ thống phụ. Nó biết nơi định hướng yêu cầu của khách hàng và cách vận hành tất cả các bộ phận chuyển động.
- Máy khách sử dụng mặt tiền thay vì gọi trực tiếp các đối tượng hệ thống con.

* Giống nhau : giống với mẫu chuẩn.
* Khác nhau :

#### Flyweight

- Flyweight là một mẫu thiết kế cấu trúc cho phép bạn lắp nhiều đối tượng hơn vào dung lượng RAM có sẵn bằng cách chia sẻ các phần trạng thái chung giữa nhiều đối tượng thay vì giữ tất cả dữ liệu trong mỗi đối tượng.
- Ví dụ lớp MigrationContext:
```
    class MigrationContext {
          private final long tempMemory;
          private final int tempMemoryLen;
          private final MemoryARW tempVirtualMem;
          private final MemoryMARW rwMemory;
          private long metadataFd;
      
          public MemoryMARW createRwMemoryOf(FilesFacade ff, Path path) {
              // re-use same rwMemory
              // assumption that it is re-usable after the close() and then of()  methods called.
              rwMemory.smallFile(ff, path, MemoryTag.NATIVE_DEFAULT);
              return rwMemory;
          }
      
          public CairoConfiguration getConfiguration() {
              return engine.getConfiguration();
          }
      
          public long getTempMemory(int size) {
              if (size <= tempMemoryLen) {
                  return tempMemory;
              }
              throw new UnsupportedOperationException("No temp memory of size "
                      + size
                      + " is allocate. Only "
                      + tempMemoryLen
                      + " is available");
          }
      
          public MemoryARW getTempVirtualMem() {
              return tempVirtualMem;
          }
    }
```
- Lớp Flyweight chứa một phần trạng thái của đối tượng ban đầu có thể được chia sẻ giữa nhiều đối tượng. Cùng một đối tượng flyweight có thể được sử dụng trong nhiều ngữ cảnh khác nhau.
- Máy khách sử dụng mặt tiền thay vì gọi trực tiếp các đối tượng hệ thống con.
- Thay vì lưu trữ cùng một dữ liệu trong nhiều đối tượng, nó chỉ được lưu giữ trong một vài đối tượng nhẹ và được liên kết với các đối tượng thích hợp hoạt động như các ngữ cảnh. Mã máy khách tạo các đối tượng cây mới bằng cách sử dụng nhà máy flyweight, gói gọn sự phức tạp của việc tìm kiếm đối tượng phù hợp và sử dụng lại nó nếu cần.

* Giống nhau :
  * Mẫu thiết kế trích xuất trạng thái nội tại lặp lại từ lớp chính và chuyển nó vào lớp flyweight MigrationContext
* Khác nhau :


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
- Ưu điểm của Chain of Responsibility:
  - Giảm kết nối: Thay vì một đối tượng có khả năng xử lý yêu cầu chứa tham chiếu đến tất cả các đối tượng khác, nó chỉ cần một tham chiếu đến đối tượng tiếp theo.
  - Tăng tính linh hoạt : đảm bảo Open/Closed Principle.
  - Phân chia trách nhiệm cho các đối tượng: đảm bảo Single Responsibility Principle.
  - Có khả năng thay đổi dây chuyền (chain) trong thời gian chạy.
  - Không đảm bảo có đối tượng xử lý yêu cầu
- Link: https://github.com/questdb/questdb/tree/ce5977cb08dc8d60e42896d3dcaf867907fb6d5c/core/src/main/java/io/questdb/log
- Giống nhau : Về cơ bản là tương đồng so với mẫu chuẩn.

<br />
<br />

#### Iterator

- Iterator cho phép bạn duyệt qua các phần tử của một bộ sưu tập mà không để lộ biểu diễn cơ bản của nó (list, stack, tree, ...).

```
      public interface ImmutableIterator<T> extends Iterator<T>, Iterable<T> {
          @Override
          @NotNull
          default Iterator<T> iterator() {
              return this;
          }
      }

```
- Iterator interface khai báo các hoạt động cần thiết để vượt qua một bộ sưu tập: lấy phần tử tiếp theo, lấy vị trí hiện tại, khởi động lại lặp , ...
- Ưu điểm của Iterator:
  - Bạn có thể làm sạch mã máy khách và các bộ sưu tập bằng cách trích xuất các thuật toán truyền tải cồng kềnh thành các lớp riêng biệt.
  - Bạn có thể triển khai các loại bộ sưu tập và trình vòng lặp mới và chuyển chúng vào mã hiện có mà không vi phạm bất kỳ điều gì.
  - Bạn có thể lặp song song trên cùng một bộ sưu tập vì mỗi đối tượng trình lặp chứa trạng thái lặp riêng của nó.
  - Vì lý do tương tự, bạn có thể trì hoãn một lần lặp lại và tiếp tục nó khi cần.
* Giống nhau : giống với mẫu chuẩn.
* Khác nhau :