# OOP - 2021
### 1. Phạm Quốc Bảo - 19020502
### 2. Lê Huy Bình - 19020503
### 3. Nguyễn Hoàng Anh - 19020493 - Nhóm Truỏng

- **[Link tài liệu.](https://refactoring.guru/design-patterns/catalog)**
- **[Link repo của nhóm.](https://github.com/Thang12321/BT_OOP_DesignPattern)**
- **[Link đến repo sử dụng trong bài báo cáo.](https://github.com/bethrobson/Head-First-Design-Patterns)**
  <br />
  <br />

#### Factory Method
- file Metrics.java chứa lớp Metrics thực chất là một lớp Factory hỗ trợ việc việc khởi tạo các các đối tượng thuộc interface Scrapable nhằm che giấu việc phương thức khởi tạo và thống nhất việc khởi tạo các đối tượng cụ thể thuộc các lớp như Counter, CounterWithOneLabel đều implements 1 interface là Scrapable
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

Test
