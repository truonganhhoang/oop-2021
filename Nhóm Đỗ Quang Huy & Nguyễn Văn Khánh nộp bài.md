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
  <b> => Như vậy mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Factory Pattern chuẩn<br/> </b>
  </ul>
 <b>Mẫu thiết kế: <a href="https://github.com/sockeqwe/AdapterDelegates/tree/master/app/src/main/java/com/hannesdorfmann/adapterdelegates4/sample/adapterdelegates">Builder pattern</a></b>
 <br />
 <ul>
  <li>Có tác dụng xây dựng đối tượng phức tạp từ các đối tượng đơn giản như DiffCatAdapterDelegate, DiffDogAdapterDelegate, CatAdapterDelegate, DogAdapterDelegate,...</li>
  <b>=>Mẫu thiết kế này tương tự như mẫu thiết kế  Builder pattern chuẩn.</b>
</ul>
<p> - - --------------------------- </p>
<br />
<a href = "https://github.com/youlookwhat/DesignPattern"><b>Repo 2</b></a><br />
<b> Mẫu thiết kế: </b> trong dự án trên chúng ta có thể thấy được các mẫu thiết kế sau: <br />
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
  
<b> Mẫu 6: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/composite"> Composite Pattern </a></b>
 <br /> - được sử dụng để tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Base Component : là một interface hoặc abstract class quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.<br/>
+ Leaf : là lớp hiện thực (implements) các phương thức của Component. Nó là các object không có con. <br />
+ Composite : lưu trữ tập hợp các Leaf và cài đặt các phương thức của Base Component. C<br />
+ Client: sử dụng Base Component để làm việc với các đối tượng trong Composite.<br />
    => Trong mẫu này chỉ có 2 class CompositeActivity và Employee.Như vậy nó bị khuyết hai thành phần là Base Component và Leaf so với mẫu thiết kế Composite Pattern chuẩn</b>
  
<b> Mẫu 7: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/decorator"> Decorator Pattern </a></b>
 <br /> - cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác. Kiểu thiết kế này có cấu trúc hoạt động như một lớp bao bọc (wrap) cho lớp hiện có. Mỗi khi cần thêm tính năng mới, đối tượng hiện có được wrap trong một đối tượng mới (decorator class).<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Component: là một interface quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.<br />
+ ConcreteComponent : là lớp hiện thực (implements) các phương thức của Component.<br />
+ Decorator : là một abstract class dùng để duy trì một tham chiếu của đối tượng Component và đồng thời cài đặt các phương thức của Component  interface.<br />
+ ConcreteDecorator : là lớp hiện thực (implements) các phương thức của Decorator, nó cài đặt thêm các tính năng mới cho Component.<br />
+ Client : đối tượng sử dụng Component.<br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Decorator Pattern chuẩn </b>
  
<b> Mẫu 8: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/facade"> Facade Pattern </a></b>
 <br /> - cho phép các đối tượng truy cập trực tiếp giao diện chung này để giao tiếp với các giao diện có trong hệ thống con. Mục tiêu là che giấu các hoạt động phức tạp bên trong hệ thống con, làm cho hệ thống con dễ sử dụng hơn.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Facade: biết rõ lớp của hệ thống con nào đảm nhận việc đáp ứng yêu cầu của client, sẽ chuyển yêu cầu của client đến các đối tượng của hệ thống con tương ứng.<br/>
+ Subsystems: cài đặt các chức năng của hệ thống con, xử lý công việc được gọi bởi Facade.<br/>
+ Client: đối tượng sử dụng Facade để tương tác với các subsystem.<br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Facade Pattern chuẩn </b>
               
<b> Mẫu 9: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/factory"> Factory Method Pattern </a></b>
 <br /> - quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn. Nó giống như một nhà máy, và nhà máy này sẽ “sản xuất” các đối tượng theo yêu cầu của chúng ta.
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Super Class: một interface, abstract class hay một class thông thường.<br/>
+ Sub Classes: các sub class sẽ implement các phương thức của supper class theo nghiệp vụ riêng của nó.<br/>
+ Factory Class: một class chịu tránh nhiệm khởi tạo các đối tượng sub class dựa theo tham số đầu vào. <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Factory Method Pattern chuẩn </b>
                 
<b> Mẫu 10: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/flyweight"> Flyweight Pattern </a></b>
 <br /> - cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng hoặc tạo đối tượng mới khi không tìm thấy đối tượng phù hợp.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + phần Flyweight là class Shape <br /> + phần ConcreteFlyweight là class Circle <br /> + phần FlyweightFactory thuộc class ShapeFactory <br /> + phần Client thuộc class FlyweightActivity <br />
    => Như vậy mẫu thiết kế này khuyết phần UnsharedFlyweight so với mẫu thiết kế Flyweight Pattern chuẩn </b>
  
<b> Mẫu 11: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/interpreter"> Interpreter Pattern </a></b>
 <br /> - giúp người lập trình có thể “xây dựng” những đối tượng “động” bằng cách đọc mô tả về đối tượng rồi sau đó “xây dựng” đối tượng đúng theo mô tả đó.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Context tương ứng với class AndExpression và class OrExpression
+ Expression tương ứng với class Expression
+ TerminalExpression tương ứng với class TerminalExpression
+ NonTerminalExpression tương ứng với class
+ Client tương ứng với class InterpreterActivity <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Interpreter Pattern chuẩn </b>
  
<b> Mẫu 12: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/iterator"> Iterator Pattern </a></b>
 <br /> -được sử dụng để cung cấp một cách thức truy cập tuần tự tới các phần tử của một đối tượng tổng hợp, mà không cần phải tạo dựng riêng các phương pháp truy cập cho đối tượng tổng hợp này.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + phần Aggregate là class Container <br /> + phần Iterator là class Iterator <br /> 
  + phần Client thuộc class ConcreteIterator <br /> + phần ConcreteAggregate và ConcreteIterator được đặt chung trong class NameRepository<br/>
    => Như vậy, nhìn chung nó có đầy đủ các thành phần như mẫu thiết kế Iterator Pattern, nhưng có một chút khác biệt về vị trí của các thành phần </b>
    
<b> Mẫu 13: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/mediator"> Mediator Pattern </a></b>
 <br /> - được sử dụng để giảm sự phức tạp trong “giao tiếp” giữa các lớp và các đối tượng. Mô hình này cung cấp một lớp trung gian có nhiệm vụ xử lý thông tin liên lạc giữa các tầng lớp, hỗ trợ bảo trì mã code dễ dàng bằng cách khớp nối lỏng lẻo.<br />
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Colleague : là một abstract class, giữ tham chiếu đến Mediator object.<br/>
+ ConcreteColleague : cài đặt các phương thức của Colleague. Giao tiếp thông qua Mediator khi cần giao tiếp với Colleague khác.<br/>
+ Mediator : là một interface, định nghĩa các phương thức để giao tiếp với các Colleague object.<br/>
+ ConcreteMediator : cài đặt các phương thức của Mediator, biết và quản lý các Colleague object. <br />
    => Mẫu thiết kế này có sự khác biệt so với mẫu thiết kế Mediator Pattern chuẩn: Nó không có các lớp trừu trượng ở trên như trong mẫu thiết kế chuẩn </b>
      
<b> Mẫu 14: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/memento"> Memento Pattern </a></b>
 <br /> - là mẫu thiết kế có thể lưu lại trạng thái của một đối tượng để khôi phục lại sau này mà không vi phạm nguyên tắc đóng gói.<br />
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + phần Originator là class Originator <br /> + phần Caretaker là class CareTaker <br /> + phần Memento là class Memento 
  <br />
  + Ngoài ra nó còn có một lớp để thực thi MementoActivity.<br />
    => Như vậy mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Memento Pattern chuẩn </b>
        
<b> Mẫu 15: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/observer"> Observer Pattern </a></b>
 <br /> - được sử dụng để định nghĩa mối phụ thuộc một – nhiều giữa các đối tượng để khi mà một đối tượng có sự thay đổi trạng thái, tất các thành phần phụ thuộc của nó sẽ được thông báo và cập nhật một cách tự động.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Subject : chứa danh sách các observer,  cung cấp phương thức để có thể thêm và loại bỏ observer.<br />
+ Observer : định nghĩa một phương thức update() cho các đối tượng sẽ được subject thông báo đến khi có sự thay đổi trạng thái.<br />
+ ConcreteSubject : cài đặt các phương thức của Subject, lưu trữ trạng thái danh sách các ConcreateObserver, gửi thông báo đến các observer của nó khi có sự thay đổi trạng thái.<br />
+ ConcreteObserver : cài đặt các phương thức của Observer, lưu trữ trạng thái của subject, thực thi việc cập nhật để giữ cho trạng thái đồng nhất với subject gửi thông báo đến. <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Observer Pattern chuẩn</b>
          
<b> Mẫu 16: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/prototype"> Prototype Pattern </a></b>
 <br /> - có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new.<br />
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Prototype : khai báo một class, interface hoặc abtract class cho việc clone chính nó.<br />
+ ConcretePrototype class : các lớp này thực thi interface (hoặc kế thừa từ lớp abstract) được cung cấp bởi Prototype để copy (nhân bản) chính bản thân nó.<br />
+ Client class : tạo mới object bằng cách gọi Prototype thực hiện clone chính nó. <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Prototype Pattern chuẩn</b>
            
<b> Mẫu 17: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/proxy"> Proxy Pattern </a></b>
 <br /> - được sử dụng để tạo ra một đối tượng sẽ ủy quyền, thay thế cho một đối tượng khác.<br />
  <b> Mẫu thiết kế này có các thành phần sau: <br /> phần Subject tương ứng với class Image <br />
+ phần Proxy tương ứng với class ProxyImage <br /> + phần RealSubject tương ứng với class RealImage <br/>
+ phần Client tương ứng với class ProxyActivity <br />
    => Như vậy mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Proxy Pattern chuẩn</b>
              
<b> Mẫu 18: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/singleton"> Singleton Pattern </a></b>
 <br /> -được sử dụng để đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp cho bạn một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.<br />
  <b> Mẫu thiết kế trong dự án đã mô tả rất nhiều cách implement singleton dựa trên những nguyên tắc thiết kế Singleton và hoàn toàn giống với mẫu thiết kế Singleton Pattern chuẩn</b>
  
<b> Mẫu 19: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/state"> State Pattern </a></b>
 <br /> - cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.<br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Context : được sử dụng bởi Client. Client không truy cập trực tiếp đến State của đối tượng. Lớp Context này chứa thông tin của ConcreteState object, cho hành vi nào tương ứng với trạng thái nào hiện đang được thực hiện.<br/>
+ State : là một interface hoặc abstract class xác định các đặc tính cơ bản của tất cả các đối tượng ConcreteState. Chúng sẽ được sử dụng bởi đối tượng Context để truy cập chức năng có thể thay đổi.<br/>
+ ConcreteState : cài đặt các phương thức của State. Mỗi ConcreteState có thể thực hiện logic và hành vi của riêng nó tùy thuộc vào Context. <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế State Pattern chuẩn </b>
    
<b> Mẫu 20: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/strategy"> Strategy Pattern </a></b>
 <br /> - cho phép định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và dễ dàng thay đổi linh hoạt các thuật toán bên trong object. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng.<br/>
  <b> Mẫu thiết kế này có các thành phần sau:<br /> + Strategy : định nghĩa các hành vi có thể có của một Strategy.<br />
+ ConcreteStrategy : cài đặt các hành vi cụ thể của Strategy.<br />
+ Context : chứa một tham chiếu đến đối tượng Strategy và nhận các yêu cầu từ Client, các yêu cầu này sau đó được ủy quyền cho Strategy thực hiện. <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Strategy Pattern chuẩn </b>
      
<b> Mẫu 21: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/templatemethod"> Template Method Pattern </a>
 <br /> - cho phép lớp con định nghĩa lại cách thực hiện của một thuật toán, mà không phải thay đổi cấu trúc thuật toán.<br />
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + AbstractClass : Định nghĩa các phương thức trừu tượng cho từng bước có thể được điều chỉnh bởi các lớp con.<br />
+ ConcreteClass : là một thuật toán cụ thể, cài đặt các phương thức của AbstractClass. Các thuật toán này ghi đè lên các phương thức trừu tượng để cung cấp các triển khai thực sự. Nó không thể ghi đè phương thức duy nhất đã được cài đặt ở AbstractClass (templateMethod).<br />
    => Mẫu thiết kế này hoàn toàn giống với mẫu thiết kế Template Method Pattern chuẩn do có AbstractClass tương ứng class Worker và ConcreteClass bao gồm các class còn lại  </b>
        
<b> Mẫu 22: <a href = "https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/visitor"> Visitor Pattern </a>
 <br /> - cho phép định nghĩa các thao tác (operations) trên một tập hợp các đối tượng (objects) không đồng nhất (về kiểu) mà không làm thay đổi định nghĩa về lớp (classes) của các đối tượng đó. <br/>
  <b> Mẫu thiết kế này có các thành phần sau: <br /> + Visitor :<br/>
    public interface ComputerPartVisitor {

    public void visit(Computer computer);

    public void visit(Mouse mouse);

    public void visit(Keyboard keyboard);

    public void visit(Monitor monitor);
}
+ ConcreteVisitor : cài đặt tất cả các phương thức abstract đã khai báo trong Visitor. Mỗi visitor sẽ chịu trách nhiệm cho các hành vi khác nhau của đối tượng.<br/>
    public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override<br />
    public void visit(Computer computer) {
        Log.e("---", "Displaying Computer.");
    }

    @Override<br />
    public void visit(Mouse mouse) {
        Log.e("---", "Displaying Mouse.");
    }

    @Override<br />
    public void visit(Keyboard keyboard) {
        Log.e("---", "Displaying Keyboard.");
    }

    @Override<br />
    public void visit(Monitor monitor) {
        Log.e("---", "Displaying Monitor.");
    }
}
+ Element (Visitable):<br/>
                         public interface ComputerPart {<br/>
    public void accept(ComputerPartVisitor computerPartVisitor);
}<br/>
+ ConcreteElement (ConcreteVisitable): cài đặt phương thức đã được khai báo trong Element dựa vào đối số visitor được cung cấp.
+ ObjectStructure : là một lớp chứa tất cả các đối tượng Element, cung cấp một cơ chế để duyệt qua tất cả các phần tử. Cấu trúc đối tượng này có thể là một tập hợp (collection) hoặc một cấu trúc phức tạp giống như một đối tượng tổng hợp (composite).
+ Client : không biết về ConcreteElement và chỉ gọi phương thức accept() của Element. <br />
    => Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Visitor Pattern chuẩn. </b>
                

  




