# Lớp: INT2204_3
# Thành viên:
1. Nguyễn Hoàng Long - 18020805
2. Trần Trung Hiếu - 19020077
3. Văn Quốc Dũng - 19020530

### Repo: https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern

# BÁO CÁO SO SÁNH MẪU THIẾT KẾ

## **I. Nhóm Creational**

### Singleton:
- Sử dụng Singleton pattern: là mẫu thiết kế sáng tạo cho phép đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp một method để có  thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.
- Mỗi class bao gồm 1 class Singleton và 1 class SingletonClient để kiểm tra tính unique của Singleton class.

**Giống nhau:** 
    - Kế thừa lại AppCompatActivity thông qua lớp SingletonActivity
    - Implement Singleton Pattern bằng cách Bill Pugh Singleto
**Khác nhau:** 
    - không có sự khác nhau.

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
## Abstract Factory

- Sử dụng mẫu thiết kế Abstract Factory: là một trong những Pattern thuộc nhóm Creational Design Pattern. Abstract Factory cho phép một lớp trả về một nhà máy của các lớp, được sử dụng khi hệ thống cần phải độc lập với cách đối tượng của nó được tạo ra hoặc khi hệ thống cần được cấu hình với một trong nhiều họ đối tượng.

- Gồm các thành phần cơ bản: Sub classes, Factory class, Abstract Factory class...

**Giống nhau:**
    - Factory class là AnimalFactory và InsectFactory có trách nhiệm khởi tạo các sub classes.
    - Abstract Factory class là CreatureFactory.

**Khác nhau:**
    - Không có Super class để các Sub class kế thừa (ví dụ khai báo 1 class có tên Creatures trong đó có method Activity()).
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
**Giống nhau:** 
    + Abstract class Shape implement Cloneable.
    + Một class kế thừa lại lớp có sẵn là AppCompatActivity.
    + 3 lớp Circle, Rectangle, Square kế thừa lại lớp Shape.

**Khác nhau:**
    + Không có sự khác nhau.
- Code:
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
- Giống nhau:
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
- Khác nhau:
    + Không có sự khác nhau.

### Builder:
- 
