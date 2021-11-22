Báo cáo về Design Patterns
Link nguồn tham khảo: https://github.com/JakubVojvoda/design-patterns-java

So sánh Prototype:
     - Nó có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new. Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.
     cụ thể: https://github.com/JakubVojvoda/design-patterns-java/blob/master/prototype/Prototype.java
     
So sánh Composite:
Composite Pattern được sử dụng khi chúng ta cần xử lý một nhóm đối tượng tương tự theo cách xử lý 1 object. Composite pattern sắp xếp các object theo cấu trúc cây để diễn giải 1 phần cũng như toàn bộ hệ thống phân cấp. Pattern này tạo một lớp chứa nhóm đối tượng của riêng nó. Lớp này cung cấp các cách để sửa đổi nhóm của cùng 1 object. Pattern này cho phép Client có thể viết code giống nhau để tương tác với composite object này, bất kể đó là một đối tượng riêng lẻ hay tập hợp các đối tượng.
cụ thể: https://github.com/JakubVojvoda/design-patterns-java/blob/master/composite/Composite.java
    
So sánh Singleton:
1. Giới hạn chỉ có duy nhất 1 instance của class đó tồn tại ở bất kỳ thời điểm nào class đó được request
2. Cho phép quyền truy cập global
Làm sao để đảm bảo rằng 1 class chỉ có 1 instance duy nhất và nó luôn sẵn sàng để sử dụng ở bất kỳ thời điểm hoặc vị trí nào trong phần mềm của chúng ta. Có thể lấy ví dụ như:
Những tài nguyên được chia sẻ như DB để truy suất, file vật lý được sử dụng chung. Những tài nguyên này nên chỉ có 1 instance tồn tại để sử dụng và theo dõi trạng thái của nó trong suốt quá trình sử dụng. Hoặc những kiểu object không cần thiết phải tạo instance mới mỗi lần sử dụng như logging object, hãy tưởng tượng chuyện gì xảy với mỗi dòng log chúng ta lại tạo mới một logging object.

So sánh Decorator:
Decorator pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Nó cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác. Kiểu thiết kế này có cấu trúc hoạt động như một lớp bao bọc (wrap) cho lớp hiện có. Mỗi khi cần thêm tính năng mới, đối tượng hiện có được wrap trong một đối tượng mới (decorator class). Decorator pattern sử dụng composition thay vì inheritance (thừa kế) để mở rộng đối tượng
