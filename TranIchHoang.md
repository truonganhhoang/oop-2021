## Báo cáo về Design Pattern

## Singleton
**So sánh**

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


## Strategy

**Giống nhau**:
- Xác định một nhóm thuật toán, đặt mỗi thuật toán vào một lớp riêng biệt và làm cho các đối tượng của chúng có thể hoán đổi cho nhau.

- Mỗi thuật toán định tuyến có thể được trích xuất thành lớp riêng của nó bằng một buildRoute phương pháp duy nhất
**Khác nhau**:
- Gián tiếp thay đổi hành vi của đối tượng trong thời gian chạy bằng cách liên kết nó với các đối tượng con khác nhau có thể thực hiện các nhiệm vụ con cụ thể theo những cách khác nhau.

- Trích xuất các hành vi khác nhau thành một hệ thống phân cấp lớp riêng biệt và kết hợp các lớp ban đầu thành một, do đó giảm mã trùng lặp

- Tách biệt mã, dữ liệu nội bộ và các phần phụ thuộc của các thuật toán khác nhau khỏi phần còn lại của mã

- Loại bỏ điều kiện như vậy bằng cách trích xuất tất cả các thuật toán thành các lớp riêng biệt, tất cả đều triển khai cùng một giao diện

## Template Method

**Giống nhau**:
- Xác định khung của một thuật toán trong lớp cha nhưng cho phép các lớp con ghi đè các bước cụ thể của thuật toán mà không thay đổi cấu trúc của nó.

- Chia nhỏ thuật toán thành các bước, cho phép các lớp con ghi đè các bước này nhưng không phải là phương thức thực.

**Khác nhau**:
- Khách hàng chỉ mở rộng các bước cụ thể của một thuật toán, nhưng không mở rộng toàn bộ thuật toán hoặc cấu trúc của nó.

- Mã khác nhau giữa các lớp con có thể vẫn còn trong các lớp con.

## Visitor

**Giống nhau**:
- Tách các thuật toán khỏi các đối tượng mà chúng hoạt động trên đó.

- Mỗi phương thức có thể nhận các đối số thuộc các kiểu khác nhau

- Cung cấp cho phương thức của khách truy cập quyền truy cập vào tất cả dữ liệu cần thiết có trong đối tượng.

- Double Dispatch , giúp thực thi phương thức thích hợp trên một đối tượng mà không cần các điều kiện rườm rà.


**Khác nhau**:
- Một đối tượng khách triển khai một số biến thể của cùng một thao tác, tương ứng với tất cả các lớp mục tiêu.

- Trích xuất tất cả các hành vi khác vào một tập hợp các lớp khách truy cập.

- Chấp nhận các đối tượng của các lớp có liên quan, để trống phần còn lại.
