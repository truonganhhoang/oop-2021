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
