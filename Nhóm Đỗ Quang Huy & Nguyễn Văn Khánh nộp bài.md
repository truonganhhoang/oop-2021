Bài báo cáo design pattern môn lập trình hướng đối tượng
=============================

**Nhóm gồm các thành viên**

*   Đỗ Quang Huy - _20021365_
*   Nguyễn Văn Khánh - _20021375_

_Sau đây là kết quả tìm hiểu của nhóm mình về cách áp dụng design pattern của một số repo._

  
>[**Repo 1: sockeqwe/AdapterDelegates**](https://github.com/sockeqwe/AdapterDelegates/)  

**Mẫu thiết kế:** [Adapter pattern nằm trong AdapterDelegates](https://github.com/sockeqwe/AdapterDelegates/tree/master/library/src/main/java/com/hannesdorfmann/adapterdelegates4)

*   Ý tưởng của thư viện này là xây dựng các bộ điều hợp của bạn bằng cách tạo các thành phần có thể tái sử dụng. Ý tưởng là bạn xác định một AdapterDelegate cho mỗi loại chế độ xem. Người đại diện này chịu trách nhiệm tạo ViewHolder và ràng buộc ViewHolder cho một kiểu xem nhất định. Sau đó, bạn có thể soạn RecyclerView Adapter của mình bằng cách đăng ký AdapterDelegates mà bạn thực sự cần.

**Mẫu thiết kế: [Factory Pattern](https://github.com/sockeqwe/AdapterDelegates/tree/master/app/src/main/java/com/hannesdorfmann/adapterdelegates4/sample/model)**  

*   chúng ta tạo đối tượng mà không để lộ logic tạo đối tượng ở phía người dùng và tham chiếu đến đối tượng mới được tạo ra bằng cách sử dụng một interface chung là DiffItem.
```java
public interface DiffItem {
    long getItemId();

    int getItemHash();
}
```
**\=> Như vậy mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Factory Pattern chuẩn.**

**Mẫu thiết kế: [Builder pattern](https://github.com/sockeqwe/AdapterDelegates/tree/master/app/src/main/java/com/hannesdorfmann/adapterdelegates4/sample/adapterdelegates)**  

*   Có tác dụng xây dựng đối tượng phức tạp từ các đối tượng đơn giản như DiffCatAdapterDelegate, DiffDogAdapterDelegate, CatAdapterDelegate, DogAdapterDelegate,...
```java
public class AdvertisementAdapterDelegate extends AdapterDelegate<List<DisplayableItem>> {

    LayoutInflater inflater;

    public AdvertisementAdapterDelegate(Activity activity) {
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<DisplayableItem> items, int position) {
        return items.get(position) instanceof Advertisement;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new AdvertisementViewHolder(inflater.inflate(R.layout.item_advertisement, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<DisplayableItem> items, int position, @NonNull RecyclerView.ViewHolder holder, @Nullable List<Object> payloads) {
        // Notihing to bind in this example
    }

    /**
     * The ViewHolder
     */
    static class AdvertisementViewHolder extends RecyclerView.ViewHolder {
        public AdvertisementViewHolder(View itemView) {
            super(itemView);
        }
    }
}
```

**\=>Mẫu thiết kế này tương tự như mẫu thiết kế Builder pattern chuẩn.**

\- - ---------------------------

  
>[**Repo 2: youlookwhat/DesignPattern**](https://github.com/youlookwhat/DesignPattern)  

**Mẫu thiết kế:** trong dự án trên chúng ta có thể thấy được các mẫu thiết kế sau:  
*   **Mẫu 1: [Adapter Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/adapter)**  
\- cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau  
**Mẫu thiết kế này có các thành phần sau:  
\+ phần Adaptee là class V5Power  
```java
public interface V5Power {
    public int provideV5Power();
}
```
\+ phần Adapter là class V5PowerAdapter  
```java
public class V5PowerAdapter implements V5Power {

    private int v220power;

    public V5PowerAdapter(V220Power v220Power) {
        v220power = v220Power.provideV220Power();
    }

    @Override
    public int provideV5Power() {

        Log.e("---", "适配器: 经过复杂的操作,将" + v220power + "v电压转为5v");
        return 5;
    }


}
```
\+ phần Client thuộc lớp AdapterActivity  
```java
public class AdapterActivity extends AppCompatActivity {

    @BindView(R.id.tv_define)
    TextView tvDefine;
    @BindView(R.id.activity_adapter)
    LinearLayout activityAdapter;
    @BindView(R.id.by_adapter)
    Button byAdapter;
    @BindView(R.id.bt_adapter_text)
    Button btAdapterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        ButterKnife.bind(this);
        setTitle("适配器模式");
        tvDefine.setText(EMTagHandler.fromHtml(AppConstant.ADAPTER_DEFINE));
        btAdapterText.setText("将220V家用电转换为5V");

        btAdapterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 给手机充电
                 */
                Mobile mobile = new Mobile();
                V5Power v5Power = new V5PowerAdapter(new V220Power());
                mobile.inputPower(v5Power);
            }
        });
    }
}
```
**\=> Như vậy nó giống với mẫu chuẩn khai cài đặt theo cách Class Adapter – Inheritance** 


*   **Mẫu 2: [Bridge Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/bridge)** \- được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.  
**Mẫu thiết kế này có các thành phần sau:  
\+ phần Implementor là class Shape  
\+ phần Abstraction tương ứng với class DrawAPI  
```java
public interface DrawAPI {

    public void drawCircle(int radius, int x, int y);

}
```
\+ phần Refined Abstraction (AbstractionImpl) tương ứng với các class GreenCircle và RedCircle  
\+ phần ConcreteImplementor tương ứng với class Circle  
\+ phần Client tương ứng với class BridgeActivity  
```java
public class BridgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBridgeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bridge);
        setTitle("桥接模式");
        binding.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.BRIDGE_DEFINE));

        binding.btRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 画红圆
                Circle circle = new Circle(10, 10, 100, new RedCircle());
                circle.draw();
            }
        });

        binding.btGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 画绿圆
                Circle circle = new Circle(20, 20, 100, new GreenCircle());
                circle.draw();
            }
        });
    }

}
```
**\=> Như vậy mẫu thiết kế này hoàn toàn giống với mẫu chuẩn** 


*   **Mẫu 3: [Builder Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/builder)** \- Builder pattern là một trong những Creational pattern. Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.  
**Mẫu thiết kế này có các thành phần sau:  
\+ phần Product là class BuilderActivity  
\+ phần Builder là class Builder  
\+ phần ConcreteBuilder thuộc class ConcreteBuilder  
\+ Director/ Client: là nơi sẽ gọi tới Builder để tạo ra đối tượng tương ứng với các class Director và Product  
```java
public class Director {

    private Builder builder = new ConcreteBuilder();

    public Product getAProduct() {
        builder.setPart("奥迪汽车", "Q5");
        return builder.getProduct();
    }

    public Product getBProduct() {
        builder.setPart("宝马汽车", "X7");
        return builder.getProduct();
    }
}
```

**\=> Như vậy nó nó có đầy đủ các thành phần của mẫu thiết kế Builder pattern chuẩn** 


*   **Mẫu 4: [Chain of Responsibility](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/chainofresponsibility)** \- Chain of Responsiblity cho phép một đối tượng gửi một yêu cầu nhưng không biết đối tượng nào sẽ nhận và xử lý nó. Điều này được thực hiện bằng cách kết nối các đối tượng nhận yêu cầu thành một chuỗi (chain) và gửi yêu cầu theo chuỗi đó cho đến khi có một đối tượng xử lý nó. 
**Mẫu thiết kế này có các thành phần sau:  
\+ Handler : định nghĩa 1 interface để xử lý các yêu cầu. Gán giá trị cho đối tượng successor (không bắt buộc).
```java
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // 责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        // 递归效果，不断调用下一级 logMessage
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}
```

**\+ ConcreteHandler : xử lý yêu cầu. Có thể truy cập đối tượng successor (thuộc class Handler). Nếu đối tượng ConcreateHandler không thể xử lý được yêu cầu, nó sẽ gởi lời yêu cầu cho successor của nó.  
\+ Client : tạo ra các yêu cầu và yêu cầu đó sẽ được gửi đến các đối tượng tiếp nhận.  
\=> Mẫu thiết kế này có đủ các thành phần như trong mẫu thiết kế Chain of Responsibility chuẩn** 


*   **Mẫu 5: [Command Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/command)**  
\- cho phép tất cả những Request gửi đến object được lưu trữ trong chính object đó dưới dạng một object Command - giống như một class trung gian được tạo ra để lưu trữ các câu lệnh và trạng thái của object tại một thời điểm nào đó.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Command : là một interface hoặc abstract class, chứa một phương thức trừu tượng thực thi (execute) một hành động (operation) 
```java
public interface Command {

    public void execute();
}
```
\+ ConcreteCommand : là các implementation của Command. Định nghĩa một sự gắn kết giữa một đối tượng Receiver và một hành động.  
\+ Client : tiếp nhận request từ phía người dùng, đóng gói request thành ConcreteCommand thích hợp và thiết lập receiver của nó.  
\+ Invoker : tiếp nhận ConcreteCommand từ Client và gọi execute() của ConcreteCommand để thực thi request.  
\+ Receiver : đây là thành phần thực sự xử lý business logic cho case request.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Command Pattern chuẩn** 


*   **Mẫu 6: [Composite Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/composite)**  
\- được sử dụng để tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Base Component : là một interface hoặc abstract class quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.  
\+ Leaf : là lớp hiện thực (implements) các phương thức của Component. Nó là các object không có con.  
\+ Composite : lưu trữ tập hợp các Leaf và cài đặt các phương thức của Base Component.
\+ Client: sử dụng Base Component để làm việc với các đối tượng trong Composite.  
\=> Trong mẫu này chỉ có 2 class CompositeActivity và Employee.Như vậy nó bị khuyết hai thành phần là Base Component và Leaf so với mẫu thiết kế Composite Pattern chuẩn** 



*   **Mẫu 7: [Decorator Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/decorator)**  
\- cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác. Kiểu thiết kế này có cấu trúc hoạt động như một lớp bao bọc (wrap) cho lớp hiện có. Mỗi khi cần thêm tính năng mới, đối tượng hiện có được wrap trong một đối tượng mới (decorator class).  
**Mẫu thiết kế này có các thành phần sau:  
\+ Component: là một interface quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.  
\+ ConcreteComponent : là lớp hiện thực (implements) các phương thức của Component.  
\+ Decorator : là một abstract class dùng để duy trì một tham chiếu của đối tượng Component và đồng thời cài đặt các phương thức của Component interface.  
\+ ConcreteDecorator : là lớp hiện thực (implements) các phương thức của Decorator, nó cài đặt thêm các tính năng mới cho Component.  
\+ Client : đối tượng sử dụng Component.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Decorator Pattern chuẩn** 


*   **Mẫu 8: [Facade Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/facade)**  
\- cho phép các đối tượng truy cập trực tiếp giao diện chung này để giao tiếp với các giao diện có trong hệ thống con. Mục tiêu là che giấu các hoạt động phức tạp bên trong hệ thống con, làm cho hệ thống con dễ sử dụng hơn.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Facade: biết rõ lớp của hệ thống con nào đảm nhận việc đáp ứng yêu cầu của client, sẽ chuyển yêu cầu của client đến các đối tượng của hệ thống con tương ứng.  
\+ Subsystems: cài đặt các chức năng của hệ thống con, xử lý công việc được gọi bởi Facade.  
\+ Client: đối tượng sử dụng Facade để tương tác với các subsystem.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Facade Pattern chuẩn** 


*   **Mẫu 9: [Factory Method Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/factory)**  
\- quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn. Nó giống như một nhà máy, và nhà máy này sẽ “sản xuất” các đối tượng theo yêu cầu của chúng ta. **Mẫu thiết kế này có các thành phần sau:  
\+ Super Class: một interface, abstract class hay một class thông thường.  
\+ Sub Classes: các sub class sẽ implement các phương thức của supper class theo nghiệp vụ riêng của nó.  
\+ Factory Class: một class chịu tránh nhiệm khởi tạo các đối tượng sub class dựa theo tham số đầu vào.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Factory Method Pattern chuẩn** 


*   **Mẫu 10: [Flyweight Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/flyweight)**  
\- cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng hoặc tạo đối tượng mới khi không tìm thấy đối tượng phù hợp.  
**Mẫu thiết kế này có các thành phần sau:  
\+ phần Flyweight là class Shape  
\+ phần ConcreteFlyweight là class Circle  
\+ phần FlyweightFactory thuộc class ShapeFactory  
\+ phần Client thuộc class FlyweightActivity  
\=> Như vậy mẫu thiết kế này khuyết phần UnsharedFlyweight so với mẫu thiết kế Flyweight Pattern chuẩn** 


*   **Mẫu 11: [Interpreter Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/interpreter)**  
\- giúp người lập trình có thể “xây dựng” những đối tượng “động” bằng cách đọc mô tả về đối tượng rồi sau đó “xây dựng” đối tượng đúng theo mô tả đó.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Context tương ứng với class AndExpression và class OrExpression  
\+ Expression tương ứng với class Expression  
```java
public interface Expression {
    public boolean interpreter(String content);
}
```
\+ TerminalExpression tương ứng với class TerminalExpression  
\+ NonTerminalExpression tương ứng với class AndExpression,OrExpression<br/>
\+ Client tương ứng với class InterpreterActivity 
```java
public class InterpreterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInterpreterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_interpreter);
        setTitle("解释器模式");
        binding.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.INTERPRETER_DEFINE));

        // 3. InterpreterPatternDemo 使用 Expression 类来创建规则，并解析它们
        binding.btMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression maleExpression = getMaleExpression();
                // jingbin is male: true
                Log.e("---", "jingbin is male: " + maleExpression.interpreter("jingbin"));
            }
        });

        binding.btMarriedWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression womanExpression = getMarriedWomanExpression();
                // Julie is married woman: true
                Log.e("---", "Julie is married woman: " + womanExpression.interpreter("Married Julie"));
            }
        });
    }

    /**
     * 规则：jingbin 和 youlookwhat 是男性
     */
    public static Expression getMaleExpression() {
        TerminalExpression jingbin = new TerminalExpression("jingbin");
        TerminalExpression youlookwhat = new TerminalExpression("youlookwhat");
        return new OrExpression(jingbin, youlookwhat);
    }

    /**
     * 规则：Julie 是一个已婚的女性
     */
    public static Expression getMarriedWomanExpression() {
        TerminalExpression julie = new TerminalExpression("Julie");
        TerminalExpression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }
}
``` 
**\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Interpreter Pattern chuẩn**


*   **Mẫu 12: [Iterator Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/iterator)**  
\-được sử dụng để cung cấp một cách thức truy cập tuần tự tới các phần tử của một đối tượng tổng hợp, mà không cần phải tạo dựng riêng các phương pháp truy cập cho đối tượng tổng hợp này.  
**Mẫu thiết kế này có các thành phần sau:  
\+ phần Aggregate là class Container  
\+ phần Iterator là class Iterator  
\+ phần Client thuộc class ConcreteIterator  
\+ phần ConcreteAggregate và ConcreteIterator được đặt chung trong class NameRepository  
\=> Như vậy, nhìn chung nó có đầy đủ các thành phần như mẫu thiết kế Iterator Pattern, nhưng có một chút khác biệt về vị trí của các thành phần** 


*   **Mẫu 13: [Mediator Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/mediator)**  
\- được sử dụng để giảm sự phức tạp trong “giao tiếp” giữa các lớp và các đối tượng. Mô hình này cung cấp một lớp trung gian có nhiệm vụ xử lý thông tin liên lạc giữa các tầng lớp, hỗ trợ bảo trì mã code dễ dàng bằng cách khớp nối lỏng lẻo.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Colleague : là một abstract class, giữ tham chiếu đến Mediator object.  
\+ ConcreteColleague : cài đặt các phương thức của Colleague. Giao tiếp thông qua Mediator khi cần giao tiếp với Colleague khác.  
\+ Mediator : là một interface, định nghĩa các phương thức để giao tiếp với các Colleague object.  
\+ ConcreteMediator : cài đặt các phương thức của Mediator, biết và quản lý các Colleague object.  
\=> Mẫu thiết kế này có sự khác biệt so với mẫu thiết kế Mediator Pattern chuẩn: Nó không có các lớp trừu trượng ở trên như trong mẫu thiết kế chuẩn** 


*   **Mẫu 14: [Memento Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/memento)**  
\- là mẫu thiết kế có thể lưu lại trạng thái của một đối tượng để khôi phục lại sau này mà không vi phạm nguyên tắc đóng gói.  
**Mẫu thiết kế này có các thành phần sau:  
\+ phần Originator là class Originator  
\+ phần Caretaker là class CareTaker  
\+ phần Memento là class Memento  
\+ Ngoài ra nó còn có một lớp để thực thi MementoActivity.  
\=> Như vậy mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Memento Pattern chuẩn** 


*   **Mẫu 15: [Observer Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/observer)**  
\- được sử dụng để định nghĩa mối phụ thuộc một – nhiều giữa các đối tượng để khi mà một đối tượng có sự thay đổi trạng thái, tất các thành phần phụ thuộc của nó sẽ được thông báo và cập nhật một cách tự động.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Subject : chứa danh sách các observer, cung cấp phương thức để có thể thêm và loại bỏ observer.  
\+ Observer : định nghĩa một phương thức update() cho các đối tượng sẽ được subject thông báo đến khi có sự thay đổi trạng thái.  
\+ ConcreteSubject : cài đặt các phương thức của Subject, lưu trữ trạng thái danh sách các ConcreateObserver, gửi thông báo đến các observer của nó khi có sự thay đổi trạng thái.  
\+ ConcreteObserver : cài đặt các phương thức của Observer, lưu trữ trạng thái của subject, thực thi việc cập nhật để giữ cho trạng thái đồng nhất với subject gửi thông báo đến.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Observer Pattern chuẩn** 


*   **Mẫu 16: [Prototype Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/prototype)**  
\- có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Prototype : khai báo một class, interface hoặc abtract class cho việc clone chính nó.  
\+ ConcretePrototype class : các lớp này thực thi interface (hoặc kế thừa từ lớp abstract) được cung cấp bởi Prototype để copy (nhân bản) chính bản thân nó.  
\+ Client class : tạo mới object bằng cách gọi Prototype thực hiện clone chính nó.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Prototype Pattern chuẩn** 


*   **Mẫu 17: [Proxy Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/proxy)**  
\- được sử dụng để tạo ra một đối tượng sẽ ủy quyền, thay thế cho một đối tượng khác.  
**Mẫu thiết kế này có các thành phần sau:  
phần Subject tương ứng với class Image  
\+ phần Proxy tương ứng với class ProxyImage  
\+ phần RealSubject tương ứng với class RealImage  
\+ phần Client tương ứng với class ProxyActivity  
\=> Như vậy mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Proxy Pattern chuẩn** 


*   **Mẫu 18: [Singleton Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/singleton)**  
\-được sử dụng để đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp cho bạn một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.  
**Mẫu thiết kế trong dự án đã mô tả rất nhiều cách implement singleton dựa trên những nguyên tắc thiết kế Singleton và hoàn toàn giống với mẫu thiết kế Singleton Pattern chuẩn** 


*   **Mẫu 19: [State Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/state)**  
\- cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Context : được sử dụng bởi Client. Client không truy cập trực tiếp đến State của đối tượng. Lớp Context này chứa thông tin của ConcreteState object, cho hành vi nào tương ứng với trạng thái nào hiện đang được thực hiện.  
\+ State : là một interface hoặc abstract class xác định các đặc tính cơ bản của tất cả các đối tượng ConcreteState. Chúng sẽ được sử dụng bởi đối tượng Context để truy cập chức năng có thể thay đổi.  
\+ ConcreteState : cài đặt các phương thức của State. Mỗi ConcreteState có thể thực hiện logic và hành vi của riêng nó tùy thuộc vào Context.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế State Pattern chuẩn** 


*   **Mẫu 20: [Strategy Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/strategy)**  
\- cho phép định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và dễ dàng thay đổi linh hoạt các thuật toán bên trong object. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Strategy : định nghĩa các hành vi có thể có của một Strategy.  
\+ ConcreteStrategy : cài đặt các hành vi cụ thể của Strategy.  
\+ Context : chứa một tham chiếu đến đối tượng Strategy và nhận các yêu cầu từ Client, các yêu cầu này sau đó được ủy quyền cho Strategy thực hiện.  
\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Strategy Pattern chuẩn** 


*   **Mẫu 21: [Template Method Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/templatemethod)**
\- cho phép lớp con định nghĩa lại cách thực hiện của một thuật toán, mà không phải thay đổi cấu trúc thuật toán.  
**Mẫu thiết kế này có các thành phần sau:  
\+ AbstractClass : Định nghĩa các phương thức trừu tượng cho từng bước có thể được điều chỉnh bởi các lớp con.  
\+ ConcreteClass : là một thuật toán cụ thể, cài đặt các phương thức của AbstractClass. Các thuật toán này ghi đè lên các phương thức trừu tượng để cung cấp các triển khai thực sự. Nó không thể ghi đè phương thức duy nhất đã được cài đặt ở AbstractClass (templateMethod).  
\=> Mẫu thiết kế này hoàn toàn giống với mẫu thiết kế Template Method Pattern chuẩn do có AbstractClass tương ứng class Worker và ConcreteClass bao gồm các class còn lại** 


*   **Mẫu 22: [Visitor Pattern](https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern/visitor)**
\- Cho phép định nghĩa các thao tác (operations) trên một tập hợp các đối tượng (objects) không đồng nhất (về kiểu) mà không làm thay đổi định nghĩa về lớp (classes) của các đối tượng đó.  
**Mẫu thiết kế này có các thành phần sau:  
\+ Visitor : Là một interface hoặc một abstract class được sử dụng để khai báo các hành vi cho tất cả các loại visitor. Class này định nghĩa một loạt các các phương thức truy cập chấp nhận các ConcreteElement cụ thể khác nhau làm tham số. Điều này sẽ hơi giống với cơ chế nạp chồng (overloading) nhưng các loại tham số nên khác nhau do đó các hành vi hoàn toàn khác nhau. Các hành vi truy cập sẽ được thực hiện trên từng phần tử cụ thể trong cấu trúc đối tượng thông qua phương thức visit(). Loại phần tử cụ thể đầu vào sẽ quyết định phương thức được gọi.  
```java
public interface ComputerPartVisitor {

    public void visit(Computer computer);

    public void visit(Mouse mouse);

    public void visit(Keyboard keyboard);

    public void visit(Monitor monitor);
```
\+ ConcreteVisitor : cài đặt tất cả các phương thức abstract đã khai báo trong Visitor. Mỗi visitor sẽ chịu trách nhiệm cho các hành vi khác nhau của đối tượng.  
```java
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        Log.e("---", "Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        Log.e("---", "Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        Log.e("---", "Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        Log.e("---", "Displaying Monitor.");
    }
}
```
\+ Element (Visitable): là một thành phần trừu tượng, nó khai báo phương thức accept() và chấp nhận đối số là Visitor.  
```java
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
```
\+ ConcreteElement (ConcreteVisitable): cài đặt phương thức đã được khai báo trong Element dựa vào đối số visitor được cung cấp.  
```java
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
```
```java
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
```
```java
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
```
\+ ObjectStructure : là một lớp chứa tất cả các đối tượng Element, cung cấp một cơ chế để duyệt qua tất cả các phần tử. Cấu trúc đối tượng này có thể là một tập hợp (collection) hoặc một cấu trúc phức tạp giống như một đối tượng tổng hợp (composite).  
```java
public class Computer implements ComputerPart {

    private ComputerPart[] parts;

    public Computer() {
        this.parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart part : parts) {
            part.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
```
\+ Client : không biết về ConcreteElement và chỉ gọi phương thức accept() của Element.  
```java
public class VisitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVisitorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_visitor);
        setTitle("访问者模式");
        binding.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.VISITOR_DEFINE));

        // 5. 使用 ComputerPartDisplayVisitor 来显示 Computer 的组成部分。
        binding.btComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputerPart computer = new Computer();
                computer.accept(new ComputerPartDisplayVisitor());
                /*
                 *打印：
                 *---: Displaying Mouse.
                 *---: Displaying Keyboard.
                 *---: Displaying Monitor.
                 *---: Displaying Computer.
                 */
            }
        });
    }
}
```
**\=> Mẫu thiết kế này có đủ các thành phần như trên giống như trong mẫu thiết kế Visitor Pattern chuẩn.**

**KẾT LUẬN: Các mẫu thiết kế tìm được ở trên phần lớn giống như trong mẫu thiết kế chuẩn.**<br/>
_Bên trên là tất cả kết quả tìm hiểu của nhóm mình, nếu có thiếu sót hay có gì cần bổ sung mong sẽ được các bạn ghi ở dưới comment!_

 
