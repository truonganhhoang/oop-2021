So sánh với mẫu chuẩn:

** Giống nhau **:

- Có kết cấu giống với mẫu chuẩn . Ví dụ như Singleton là các class IvoryTower, EnumIvoryTower, InitializingOnDemandHolderIdiom, ThreadSafeDoubleCheckLocking,

ThreadSafeLazyLoadedIvoryTower.

- Đảm bảo chỉ có duy nhất một instance trong một class, và class đó sẽ cung cấp phương thức toàn cục để truy cập đến thực thể đó.

- Truy cập instance ở bất cứ đâu và bất cứ khi nào.

- Ẩn constructor của class.

- Các lớp tự chịu trách nhiệm kiểm soát sự khởi tạo của nó .

- Cung cấp việc truy cập vào Object global.

- Vi phạm nguyên tắc Single Responsibility Principle, một pattern giải quyết cùng lúc 2 vấn đề.

** Khác nhau **:

- Không có sự khác biệt với mẫu chuẩn,đây là mẫu thiết kế gần như giống với mẫu chuẩn về mọi mặt.
