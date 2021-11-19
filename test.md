# Design Pattern - UET - Nhom3 - INT2204 3 - N2

## A. File Github sử dụng
Trong báo cáo này, chúng tôi sẽ sử dụng https://github.com/checkstyle/checkstyle . Đây là một công cụ dùng để kiểm tra về format code Java của lập trình viên, cho phép họ viết code tuân theo một quy chuẩn thống nhất. Mặc định, tool sẽ kiểm tra theo quy chuẩn lập trình Java của Google, nhưng nó có thể được điều chỉnh bởi lập trình viên với nhiều mục đích khác nhau.

## B. Design Pattern
Trong quá trình viết phần mềm này, nhà phát triển đã ứng dụng một số mẫu thiết kế thông dụng, giúp quá trình lập trình trở nên dễ dàng hơn. Sau đây là một số Design Patterns đã được sử dụng:

### 1. Factory Pattern
Đây là một trong nhưng mẫu được sử dụng phổ biến nhất hiện nay trong lập trình hướng đối tượng. Về cơ bản, với mẫu này, người lập trình có thể tạo một đối tượng mới mà dựa trên một Interface có sẵn. Sau đây ta xét ví dụ trong dự án trên:

Trong file checkstyle/src/main/java/com/puppycrawl/tools/checkstyle , có hai file Java có áp dụng Factory Pattern là ModuleFactory.java và PackageObjectFactory.java. Ta xét từng file một:

#### a. ModuleFactory.java
Đây là một Interface để sử dụng cho PackageObjectFactory.java. 

#### b. PackageObjectFactory.java
Class này đã được ứng dụng Interface ModuleFactory.java đễ thực hiện mục đích của mình.
