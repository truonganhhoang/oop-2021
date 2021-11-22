Báo cáo về Design Patterns
Link nguồn tham khảo: https://github.com/JakubVojvoda/design-patterns-java

So sánh Prototype:
     - Nó có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new. Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.
     cụ thể: https://github.com/JakubVojvoda/design-patterns-java/blob/master/prototype/Prototype.java
     
So sánh Composite:
Composite Pattern được sử dụng khi chúng ta cần xử lý một nhóm đối tượng tương tự theo cách xử lý 1 object. Composite pattern sắp xếp các object theo cấu trúc cây để diễn giải 1 phần cũng như toàn bộ hệ thống phân cấp. Pattern này tạo một lớp chứa nhóm đối tượng của riêng nó. Lớp này cung cấp các cách để sửa đổi nhóm của cùng 1 object. Pattern này cho phép Client có thể viết code giống nhau để tương tác với composite object này, bất kể đó là một đối tượng riêng lẻ hay tập hợp các đối tượng.
cụ thể: https://github.com/JakubVojvoda/design-patterns-java/blob/master/composite/Composite.java
     
 
So sánh Iterator:
Iterator Pattern là một loại design pattern trong nhóm Behavioral Design Pattern -> liên quan đến hành vi của các object. Iterator pattern là mẫu thiết kế rât thường được sử dụng trong môi trường lập trình Java và .NET. Mẫu này được sử dụng để truy cập vào các phần tử của collection object một cách tuần tự mà không cần phải hiểu biết về nó.
cụ thể: https://github.com/JakubVojvoda/design-patterns-java/blob/master/iterator/Iterator.java

So sánh Chain of Responsibility:
Chain of Responsibility (COR) là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern).
Chain of Responsiblity cho phép một đối tượng gửi một yêu cầu nhưng không biết đối tượng nào sẽ nhận và xử lý nó. Điều này được thực hiện bằng cách kết nối các đối tượng nhận yêu cầu thành một chuỗi (chain) và gửi yêu cầu theo chuỗi đó cho đến khi có một đối tượng xử lý nó.
Chain of Responsibility Pattern hoạt động như một danh sách liên kết (Linked list) với việc đệ quy duyệt qua các phần tử (recursive traversal).

So sánh Singleton:
Giới hạn chỉ có duy nhất 1 instance của class đó tồn tại ở bất kỳ thời điểm nào class đó được request
Cho phép quyền truy cập global
Những tài nguyên được chia sẻ như DB để truy suất, file vật lý được sử dụng chung. Những tài nguyên này nên chỉ có 1 instance tồn tại để sử dụng và theo dõi trạng thái của nó trong suốt quá trình sử dụng.
Hoặc những kiểu object không cần thiết phải tạo instance mới mỗi lần sử dụng như logging object, hãy tưởng tượng chuyện gì xảy với mỗi dòng log chúng ta lại tạo mới một logging object.

So sánh Factory Method:
Factory method là một pattern thuộc nhóm creational patterns. Định nghĩa interface giúp client tạo object nhưng ủy quyền cho các concreate factory để xác định class nào được trả về cho client. Được sử dụng với mục đích
Đưa toàn bộ logic của việc tạo mới object vào trong factory, che giấu logic của việc khởi tạo
Giảm sự phụ thuộc nhằm tăng tính mở rộng
