<h1>Môn lập trình hướng đối tượng</h1>

<b>Nhóm gồm các thành viên</b>
<ul><li>Đỗ Quang Huy - <i>20021365</i></li><li>Nguyễn Văn Khánh - <i>20021375</i></li></ul>
<br />

<a href = "https://github.com/sockeqwe/AdapterDelegates/"><b>Repo 1</b></a><br />
<b>Mẫu thiết kế: </b><a href="https://github.com/sockeqwe/AdapterDelegates/tree/master/library/src/main/java/com/hannesdorfmann/adapterdelegates4">
  Adapter pattern nằm trong AdapterDelegates</a>

<ul>
  <li>Ý tưởng của thư viện này là xây dựng các bộ điều hợp của bạn bằng cách tạo các thành phần có thể tái sử dụng. Ý tưởng là bạn xác định một AdapterDelegate cho mỗi loại chế độ xem. Người đại diện này chịu trách nhiệm tạo ViewHolder và ràng buộc ViewHolder cho một kiểu xem nhất định. Sau đó, bạn có thể soạn RecyclerView Adapter của mình bằng cách đăng ký AdapterDelegates mà bạn thực sự cần.</li>
</ul>
<b> Mẫu thiết kế:
<a href="https://github.com/sockeqwe/AdapterDelegates/tree/master/app/src/main/java/com/hannesdorfmann/adapterdelegates4/sample/model"> Factory Pattern </a></b>
  </br>
  <ul> 
  <li> chúng ta tạo đối tượng mà không để lộ logic tạo đối tượng ở phía người dùng và tham chiếu đến đối tượng mới được tạo ra bằng cách sử dụng một interface chung là DiffItem.
  </li>
  </ul>
<p> - - --------------------------- </p>
<br />
<a href = "https://github.com/youlookwhat/DesignPattern"><b>Repo 2</b></a><br />
<b> Mẫu thiết kế: </b> trong dự án trên chúng ta có thể thầy được các mẫu thiết kế sau: <br />
<b> Mẫu 1: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/adapter"> Adapter Pattern </a></b><br/>
 - cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau <br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br />    + phần Adaptee là class V5Power <br />    + phần Adapter là class V5PowerAdapter <br />    + phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
  
<b> Mẫu 2: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a></b>
 - được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt. <br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br />    + phần Implementor là class Shape <br />    + phần Abstraction tương ứng với class DrawAPI <br />    + phần Refined Abstraction (AbstractionImpl) tương ứng với các class GreenCircle và RedCircle<br />    + phần ConcreteImplementor tương ứng với class Circle <br />    + phần Client tương ứng với class BridgeActivity <br/>
    => Như vậy mẫu thiết kế này hoàn toàn giống với mẫu chuẩn </b>
  
<b> Mẫu 3: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/builder"> Builder Pattern </a></b>
 - Builder pattern là một trong những Creational pattern. Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + phần Product là class BuilderActivity <br /> + phần Builder là class Builder <br /> 
    + phần ConcreteBuilder thuộc class ConcreteBuilder <br /> 
    + Director/ Client: là nơi sẽ gọi tới Builder để tạo ra đối tượng tương ứng với các class Director và Product<br />
    => Như vậy nó nó có đầy đủ các thành phần của mẫu thiết kế Builder pattern chuẩn </b>
  
<b> Mẫu 4: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/chainofresponsibility"> 
  Chain of Responsibility </a></b>
 - Chain of Responsiblity cho phép một đối tượng gửi một yêu cầu nhưng không biết đối tượng nào sẽ nhận và xử lý nó. Điều này được thực hiện bằng cách kết nối các đối tượng nhận yêu cầu thành một chuỗi (chain) và gửi yêu cầu theo chuỗi đó cho đến khi có một đối tượng xử lý nó.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> 
  + Handler : định nghĩa 1 interface để xử lý các yêu cầu. Gán giá trị cho đối tượng successor (không bắt buộc).<br />
+ ConcreteHandler : xử lý yêu cầu. Có thể truy cập đối tượng successor (thuộc class Handler). Nếu đối tượng ConcreateHandler không thể xử lý được yêu cầu, nó sẽ gởi lời yêu cầu cho successor của nó.<br/>
+ Client : tạo ra các yêu cầu và yêu cầu đó sẽ được gửi đến các đối tượng tiếp nhận. <br />
    => Mẫu thiết kế này có đủ các thành phần như trong mẫu thiết kế Chain of Responsibility chuẩn </b>
  
<b> Mẫu 5: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/command"> Command Pattern </a></b>
 <br /> - cho phép tất cả những Request gửi đến object được lưu trữ trong chính object đó dưới dạng một object Command - giống như một class trung gian được tạo ra để lưu trữ các câu lệnh và trạng thái của object tại một thời điểm nào đó.<br />
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Command : là một interface hoặc abstract class, chứa một phương thức trừu tượng thực thi (execute) một hành động (operation)<br/>
+ ConcreteCommand : là các implementation của Command. Định nghĩa một sự gắn kết giữa một đối tượng Receiver và một hành động.<br/>
+ Client : tiếp nhận request từ phía người dùng, đóng gói request thành ConcreteCommand thích hợp và thiết lập receiver của nó.<br/>
+ Invoker : tiếp nhận ConcreteCommand từ Client và gọi execute() của ConcreteCommand để thực thi request.<br/>
+ Receiver : đây là thành phần thực sự xử lý business logic cho case request. <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Command Pattern chuẩn </b>
  
<b> Mẫu 6: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/composite"> Composite Pattern </a>
 <br /> - được sử dụng để tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Base Component : là một interface hoặc abstract class quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.<br/>
+ Leaf : là lớp hiện thực (implements) các phương thức của Component. Nó là các object không có con. <br />
+ Composite : lưu trữ tập hợp các Leaf và cài đặt các phương thức của Base Component. C<br />
+ Client: sử dụng Base Component để làm việc với các đối tượng trong Composite.<br />
    => Trong mẫu này chỉ có 2 class CompositeActivity và Employee.Như vậy nó bị khuyết hai thành phần là Base Component và Leaf so với mẫu thiết kế Composite Pattern chuẩn</b>
  
<b> Mẫu 7: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/decorator"> Decorator Pattern </a>
 <br /> - cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác. Kiểu thiết kế này có cấu trúc hoạt động như một lớp bao bọc (wrap) cho lớp hiện có. Mỗi khi cần thêm tính năng mới, đối tượng hiện có được wrap trong một đối tượng mới (decorator class).<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Component: là một interface quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.<br />
+ ConcreteComponent : là lớp hiện thực (implements) các phương thức của Component.<br />
+ Decorator : là một abstract class dùng để duy trì một tham chiếu của đối tượng Component và đồng thời cài đặt các phương thức của Component  interface.<br />
+ ConcreteDecorator : là lớp hiện thực (implements) các phương thức của Decorator, nó cài đặt thêm các tính năng mới cho Component.<br />
+ Client : đối tượng sử dụng Component.<br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Decorator Pattern chuẩn </b>
  
<b> Mẫu 8: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/facade"> Facade Pattern </a>
 <br /> - ho phép các đối tượng truy cập trực tiếp giao diện chung này để giao tiếp với các giao diện có trong hệ thống con. Mục tiêu là che giấu các hoạt động phức tạp bên trong hệ thống con, làm cho hệ thống con dễ sử dụng hơn.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Facade: biết rõ lớp của hệ thống con nào đảm nhận việc đáp ứng yêu cầu của client, sẽ chuyển yêu cầu của client đến các đối tượng của hệ thống con tương ứng.
+ Subsystems: cài đặt các chức năng của hệ thống con, xử lý công việc được gọi bởi Facade.
+ Client: đối tượng sử dụng Facade để tương tác với các subsystem.<br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Facade Pattern chuẩn </b>
               
<b> Mẫu 9: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
                 
<b> Mẫu 10: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
  
<b> Mẫu 11: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
  
<b> Mẫu 12: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
    
<b> Mẫu 13: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
      
<b> Mẫu 14: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
        
<b> Mẫu 15: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
          
<b> Mẫu 16: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
            
<b> Mẫu 17: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
              
<b> Mẫu 18: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
  
<b> Mẫu 19: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> - được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br />    + phần Adaptee là class V5Power <br />    + phần Adapter là class V5PowerAdapter <br />    + phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
    
<b> Mẫu 20: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau:<br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
      
<b> Mẫu 21: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
        
<b> Mẫu 22: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge"> Bridge Pattern </a>
 <br /> -được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Adaptee là class V5Power <br /> phần Adapter là class V5PowerAdapter <br /> phần Client thuộc lớp AdapterActivity <br />
    => Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance </b>
                

  




