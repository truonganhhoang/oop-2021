#### Lê Hữu Đức - 19020525
# So sánh với mẫu chuẩn (12 mẫu đầu tiên)
**Giống nhau:**

- Đa số có kết cấu giống với mẫu chuẩn như cách sử dụng interface, abstract class, chức năng từng lớp.

- Đa số các lớp chỉ chịu trách nhiệm về 1 một việc.

**Khác nhau:**

- Hầu như các pattern không biểu diễn lớp `client`.

- _Brigde:_ không impliment **interface**.

- _Builder:_ class `PersionBuilder` nằm trong class `Person` thay vì extends `Person`.

- _Command:_ không có class `editor` gộp 3 class function lại.

- _Composite:_ không có class `editor`.

- _Decorator:_ không dùng **interface** impliment ra các class chức năng.