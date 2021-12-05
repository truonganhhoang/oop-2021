# Lớp: INT2204_3
# Thành viên:
1. Nguyễn Hoàng Long - 18020805
2. Trần Trung Hiếu - 19020077
3. Văn Quốc Dũng - 19020530

### Repo: https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern

# BÁO CÁO SO SÁNH MẪU THIẾT KẾ

## I. Nhóm Creational

### Singleton:
- Sử dụng Singleton pattern: là mẫu thiết kế sáng tạo cho phép đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp một method để có  thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.
- Mỗi class bao gồm 1 class Singleton và 1 class SingletonClient để kiểm tra tính unique của Singleton class.
- **Giống nhau:** 
    + Kế thừa lại AppCompatActivity thông qua lớp SingletonActivity
    + Implement Singleton Pattern bằng cách Bill Pugh Singleto
- **Khác nhau:** 
    + không có sự khác nhau.
- **Code:** 
````
public class SingletonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ehan:
                SingletonEHan instance = SingletonEHan.getInstance();
                break;
            case R.id.bt_lanhan:
                SingletonLanHan singletonLanHanFour = SingletonLanHan.getSingletonLanHanFour();
                break;
            case R.id.bt_inclass:
                SingletonIn singletonIn = SingletonIn.getSingletonIn();
                break;
            case R.id.bt_enum:
                SingletonEnum.instance.whateverMethod();
                break;
            default:
                break;
        }
    }
}
````

### Abstract Factory:
- Sử dụng mẫu thiết kế Abstract Factory: là một trong những Pattern thuộc nhóm Creational Design Pattern. Abstract Factory cho phép một lớp trả về một nhà máy của các lớp, được sử dụng khi hệ thống cần phải độc lập với cách đối tượng của nó được tạo ra hoặc khi hệ thống cần được cấu hình với một trong nhiều họ đối tượng.
- Gồm các thành phần cơ bản: Sub classes, Factory class, Abstract Factory class...
- **Giống nhau:** 
    + Factory class là AnimalFactory và InsectFactory có trách nhiệm khởi tạo các sub classes.
    + Abstract Factory class là CreatureFactory.
- **Khác nhau:** 
    + Không có Super class để các Sub class kế thừa (ví dụ khai báo 1 class có tên Creatures trong đó có method Activity()).
- **Code:** 
````
public abstract class RoujiaMo {

    protected String name;
    
    public void prepare() {
        Log.e();
    }
}
````

### Prototype:
- Sử dụng mẫu thiết kế Prototype pattern: là một trong những Creational pattern, có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new.
- Prototype Pattern được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại.
- **Giống nhau:** 
    + Abstract class Shape implement Cloneable.
    + Một class kế thừa lại lớp có sẵn là AppCompatActivity.
    + 3 lớp Circle, Rectangle, Square kế thừa lại lớp Shape.
- **Khác nhau:** 
    + Không có sự khác nhau.
- **Code:** 
````
     public abstract class Shape implements Cloneable {
        @Override
        public Object clone() {
            Object object = null;
            try {
                object = super.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("--", e.getMessage());
            }
            return object;
        }
    }
````

````
    public class PrototypeActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ActivityPrototypeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_prototype);
            setTitle("原型模式");
            binding.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.PROTOTYPE_DEFINE));
            binding.btRectangle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Shape shapeCache = ShapeCache.getShape("2");
                    Log.e("Prototype", "Shape: " + shapeCache.type);
                }
            });
            binding.btSquare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Shape shapeCache = ShapeCache.getShape("3");
                    Log.e("Prototype", "Shape: " + shapeCache.type);
                }
            });
        }
      }
````

### Factory pattern:
- Sử dụng mẫu thiết kế Factory Method/Factory Pattern: xác định một interface hoặc lớp trừu tượng (abstract) để tạo một đối tượng nhưng để cho các lớp con quyết định lớp nào sẽ khởi tạo. Nói cách khác, các lớp con chịu trách nhiệm tạo ra thể hiện của lớp.
- Client chỉ tương tác với Interface hoặc lớp abstract, nó sẽ làm việc với lớp implements interface đó hoặc extends từ lớp abstract.
- **Giống nhau:** 
    + Một interface để tạo đối tượng: public abstract RouJiaMo sellRoujiaMo(String type);
    + Lớp được khởi tạo sẽ được xác định bởi các lớp con, như ta có thể thấy đối tượng bánh roujiamo được tạo từ các lớp con trong code sau:
````
    public abstract RoujiaMo sellRoujiaMo(String type);

        public RoujiaMo sellRoujiaMo(String type) {

            RoujiaMo roujiaMo = creatRoujiaMo(type);
            roujiaMo.prepare();
            roujiaMo.fire();
            roujiaMo.pack();
            return roujiaMo;
        }
````
- **Khác nhau:** 
    + Không có sự khác nhau.

### Builder:
- Sử dụng mẫu thiết kế Builder: là một mẫu thiết kế thuộc "Nhóm khởi tạo" cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và biểu diễn khác nhau của một đối tượng bằng cách sử dụng cùng một hàm khởi tạo (construction).
- Builder được sử dụng khi làm việc với một lớp mà có chứa rất nhiều các thuộc tính và cần phải tạo ra nhiều hàm khởi tạo với số lượng các thuộc tính tăng dần.
- **Giống nhau:**
    + Bao gồm 4 thành phần chính: 
````
+ Builder.java: là thành phần định nghĩa một lớp trừu tượng (abstract class) để tạo ra một hoặc nhiều phần của đối tượng Product.

public abstract class Builder {

    public abstract void setPart(String name, String type);

    public abstract Product getProduct();
}
````
````
+ ConcreteBuilder.java: là thành phần triển khai, cụ thể hóa các lớp trừu tượng cho để tạo ra các thành phần và tập hợp các thành phần đó với nhau.
Thành phần này sẽ xác định và nắm giữ các thể hiện mà nó tạo ra. Đồng thời nó cũng cung cấp phương thức để trả các các thể hiện mà nó đã tạo ra trước đó.

public class ConcreteBuilder extends Builder {

    private Product product = new Product();

    @Override
    public void setPart(String name, String type) {
        product.setName(name);
        product.setType(type);
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
````
````
+ Director.java: thành phần này sẽ khởi tạo đối tượng Builder.

public class Director {

    private Builder builder = new ConcreteBuilder();

    public Product getAProduct() {
        builder . setPart( " Audi cars " , " Q5 " );
        return builder.getProduct();
    }

    public Product getBProduct() {
        builder . setPart( " BMW Car " , " X7 " );
        return builder.getProduct();
    }
}
````
````
+ Product.java: thành phần này sẽ đại diện cho đối tượng phức tạp phải tạo ra.

public class Product {

    private String name;
    private String type;

    public void showProduct() {
        Log.e("---", "Name：" + name);
        Log.e("---", "Type：" + type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
````
- **Khác nhau:**
    + Không có sự khác nhau vì sử dụng các thành phần cơ bản của mẫu thiết kế Builder.
## II . Nhóm Behavioral
### Observer :

- **Code:
```
package refactoring_guru.observer.example.listeners;
import java.io.File;
public interface EventListener {
	void update(String eventType, File file);
}
```
- Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.
- Một đối tượng có thể thông báo đến một số lượng không giới hạn các đối tượng khác, một trong nhưng mẫu có hiệu suất sử dụng thấp trong lập trình hướng đối tượng.
- **Giống Nhau:**
+ Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
- **Khác Nhau:**
+ Không có sự khác nhau vì sử dụng các thành phần cơ bản của mẫu thiết kế Observer.
### State
- **Code** :
```
package com.example.jingbin.designpattern.state.old;

import android.util.Log;

public class VendingMachine {


    private final static int HAS_MONEY = 0;

    private final static int NO_MONEY = 1;

    private final static int SOLD = 2;

    private final static int SOLD_OUT = 3;

    private int currentStatus = NO_MONEY;

    private int count = 0;

    public VendingMachine(int count) {
        this.count = count;
        if (count > 0) {
            currentStatus = NO_MONEY;
        }
    }
```
- Một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Nó cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
+  VendingMachine.java: Nhận diện ban đầu về máy bán hàng tự động cần được cải tiến.
+ State.java: status interface.
+ WinnerState.java: winner status.
+ ...
- **Giống nhau** : từ trên ta có thể thấy khuôn dạng khá giống các mẫu tiêu chuẩn, khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
- **Khác nhau** : Không có sự khác nhau
### Mediator :
**Code**:
```
package com.example.jingbin.designpattern.mediator;


public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        CharRoom.showMessage(this, message);
    }
}
```
```
package com.example.jingbin.designpattern.mediator;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        CharRoom.showMessage(this, message);
    }
}
```
- Định nghĩa một đối tượng gói gọn cách một tập hợp các đối tượng tương tác, thúc đẩy sự khớp nối lỏng lẻo (loose coupling) bằng cách ngăn không cho các đối tượng đề cập đến nhau một cách rõ ràng và nó cho phép bạn thay đổi sự tương tác của họ một cách độc lập
- **Giống nhau** :
+ Khuôn dạng cũng khá giống với mẫu tiêu chuẩn
+ Có một lớp trừu tượng và một các lớp con kế thừa nó để tạo ra đối tuượng mới và có liên quan đến nhau
- **Khác Nhau** : Không có sự khác nhau
### Chain of Responsibility
**Code** :
```
package com.example.jingbin.designpattern.chainofresponsibility;
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    protected int level;
    protected AbstractLogger nextLogger;
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }
    protected abstract void write(String message);
}
```
```
package com.example.jingbin.designpattern.chainofresponsibility;
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }
    protected abstract void write(String message);
}
```
-  Cho phép một đối tượng gửi một yêu cầu nhưng không biết đối tượng nào sẽ nhận và xử lý nó, được thực hiện bằng cách kết nối các đối tượng nhận yêu cầu thành một chuỗi (chain) và gửi yêu cầu theo chuỗi đó cho đến khi có một đối tượng xử lý nó.
-  Lợi ích : tăng tính linh hoạt, giảm kết nối, phân chia trách nhiệm đối tượng, không đảm có đối tượng xử lý yêu cầu.
- **Giống nhau** :
+ Từ những điều trên nên khuôn mẫu khá giống mẫu tiêu chuẩn .
- **Khác Nhau** :
+ Không có sự khác nhau .
