> # Lớp: INT2204_21
> # Thành viên: 
>* Phạm Thị Khánh Linh 20020324	
>* Lê Phương Uyên 20021475	
>* Phan Hiền An 20021281	
>### Repo: https://github.com/youlookwhat/DesignPattern

# BÁO CÁO SO SÁNH VỀ MẪU THIẾT KẾ 

## **1. Nhóm Creational**
### Singleton:

- Giống nhau: giống nhau hoàn toàn.
    - Implement Singleton Pattern bằng cách **Bill Pugh Singleton Implementation:**
        - Sử dụng 1 static nested class với vai trò 1 helper khi muốn tách biệt chức năng cho 1 class function rõ ràng hơn.
        - Khi Singleton được tải vào bộ nhớ thì ***SingletonInHodler*** chưa được tải vào. Nó chỉ được tải khi và chỉ khi phương thức ***getSingletonIn()*** được gọi. Với cách này tránh được lỗi cơ chế khởi tạo instance của Singleton trong Multi-Thread, performance cao do tách biệt được quá trình xử lý.
    
    ```java
    public class SingletonIn {
    
        private SingletonIn() {
        }
    
        private static class SingletonInHodler {
            private static SingletonIn singletonIn = new SingletonIn();
        }
    
        public static SingletonIn getSingletonIn() {
            return SingletonInHodler.singletonIn;
        }
    }
    ```
    
- Khác nhau: không có sự khác nhau.

### Factory Pattern:

- Giống nhau:
    - 1 Super Class là 1 Abstract Class - *[RoujiaMoStore](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/gcff/RoujiaMoStore.java)* đại diện cho cửa hàng bán bánh Rou Ji A nói chung.
    
    ```java
    public abstract class RoujiaMoStore {
    
        public abstract RoujiaMo sellRoujiaMo(String type);
    
    //    public RoujiaMo sellRoujiaMo(String type) {
    //
    //        RoujiaMo roujiaMo = creatRoujiaMo(type);
    //        roujiaMo.prepare();
    //        roujiaMo.fire();
    //        roujiaMo.pack();
    //        return roujiaMo;
    //
    //    }
    
    }
    ```
    
    - Các Sub Class là các chi nhánh cửa hàng. *([XianKuRoujiMo](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/gcff/XianKuRoujiMo.java), [XianSuanRoujiMo](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/gcff/XianSuanRoujiMo.java), [XianlaRoujiMo](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/gcff/XianlaRoujiMo.java), [XianSuanRoujiMo](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/gcff/XianSuanRoujiMo.java))*
    - 1 Factory Class - *[XianSimpleRoujiaMoFactory](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/gcff/XianSimpleRoujiaMoFactory.java)* sẽ nhận input rồi trả lại chi nhánh tương ứng.
    
    ```java
    public class XianSimpleRoujiaMoFactory {
    
        public RoujiaMo creatRoujiaMo(String type) {
            RoujiaMo roujiaMo = null;
            switch (type) {
                case "Suan":
                    roujiaMo = new XianSuanRoujiMo();
                    break;
                case "La":
                    roujiaMo = new XianKuRoujiMo();
                    break;
                case "Tian":
                    roujiaMo = new XianlaRoujiMo();
                    break;
                default:// 默认为酸肉夹馍
                    roujiaMo = new XianSuanRoujiMo();
                    break;
            }
            return roujiaMo;
        }
    }
    ```
    
- Khác nhau: không có sự khác nhau.

### Abstract Factory:

- Giống nhau:
    - **Abstract Factory:** 1 Interface *[RouJiaMoYLFactroy](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/cxgc/RoujiaMoYLFactory.java)* chứa các phương thức tạo đối tượng là nguyên liệu làm ra món Rou Ji A. (Meat, Yuan Liao).
    
    ```java
    public interface RoujiaMoYLFactory {
    
        public Meet creatMeet();
        public YuanLiao creatYuanLiao();
    
    }
    ```
    
    - **Product** Các đối tượng Meat, Yuan Liao có các class con (đối tượng cụ thể): *[XianFreshMeet](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/cxgc/XianFreshMeet.java)*, *[ChangShaFreshMeet](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/cxgc/ChangShaFreshMeet.java), [XianTeSeYuanLiao](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/cxgc/XianTeSeYuanLiao.java)*, *[ChangShaTeSeYuanLiao](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/cxgc/ChangShaTeSeYuanLiao.java),...)* là các **Concrete Factory.**
    - **Client**: [RoujiaMo](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/factory/cxgc/RoujiaMo.java)
- Khác nhau: Abstract Factory chứa phương thức tạo đối tượng không phải abstract *(Meat, Yuan Liao) →* **Không có Abstract Factory** mà chỉ có class thường.

### Builder:

- Giống nhau: có **Builder** *([Builder.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/builder/Builder.java))* là 1 abstract class về 1 cửa hàng bán xe và được kế thừa bởi 1 **ConcreteBuilder** *([ConcreteBuider.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/builder/ConcreteBuilder.java))*, có **Director** *([Director.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/builder/Director.java))* để gọi tới Builder (lấy xe).

```java
public abstract class Builder {

    public abstract void setPart(String name, String type);

    public abstract Product getProduct();
}
```

```java
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
```

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

- Khác nhau: không có sự khác nhau.

### Prototype:

- Giống nhau:
    - **Prototype:** 1 abstract Shape *([Shape.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/prototype/Shape.java)) implements* `Cloneable`.
    
    ```java
    public abstract class Shape implements Cloneable {
    
        private String id;
        protected String type;
    
        public abstract void draw();
    
        public String getId() {
            return id;
        }
    
        public void setId(String id) {
            this.id = id;
        }
    
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
    ```
    
    - **ConcretePrototype:** *[ShapeCache.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/prototype/ShapeCache.java)* thể hiện cụ thể phương thức ***clone()***.
    
    ```java
    public class ShapeCache {
    
        private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();
    
        public static Shape getShape(String shapeId) {
            Shape shapeCache = shapeMap.get(shapeId);
            return (Shape) shapeCache.clone();
        }
    
        // 对每种形状都运行数据库查询，并创建该形状
        // shapeMap.put(shapeKey, shape);
        // 例如，我们要添加三种形状
        public static void loadCache() {
            Circle circle = new Circle();
            circle.setId("1");
            shapeMap.put(circle.getId(), circle);
    
            Rectangle rectangle = new Rectangle();
            rectangle.setId("2");
            shapeMap.put(rectangle.getId(), rectangle);
    
            Square square = new Square();
            square.setId("3");
            shapeMap.put(square.getId(), square);
        }
    }
    ```
    
- Khác nhau: không có sự khác nhau.

## **2. Nhóm Structural**
> Các mẫu có kết cấu giống với mẫu chuẩn, không có sự khác nhau, gần như giống hệt so với mẫu chuẩn về mọi mặt.
### Adapter:
Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
Giống:
* Gồm các thành phần cơ bản: Adaptee, Adapter, Target, Client.
* Ở đây có thể thấy rằng điện thoại di động dựa trên một giao diện cung cấp điện áp 5V, còn điện gia đình là 220V. Vì vậy cần phải có **Adapter** (bucker) để sạc điện thoại di động.
* Kiểm tra cuối cùng: sạc điện thoại
   ```java
 	Mobile mobile = new Mobile();
	V5Power v5Power = new V5PowerAdapter(new V200Power());
	mobile.inputPower(v5Power);
   ```
The v5 interface is passed in, and classes that implement this interface can also be passed in
Khác: 
* Cơ bản giống với mẫu thiết kế chuẩn

### Bridge
Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (abstraction và implementation) có thể thay đổi độc lập nhau. 
Giống: 
* Lấy việc vẽ hình tròn với nhiều màu sắc khác nhau làm ví dụ. Tạo một lớp triển khai cầu nối thực thể triển khai giao diện DrawAPI: draw a read circle và draw a green circle
* Về cấu trúc, gồm 4 thành phần cơ bản: Client, Abstraction, Refined Abstraction (AbstractionImpl), Implementor, ConcreteImplementor...
* Các bước: 
1. Tạo cầu nối để thực hiện giao diện.
	```java
	public interface DrawAPI {
	    void drawCircle(int radius, int x, int y);
	}
	```
2. Tạo một lớp triển khai cầu nối thực thể triển khai giao diện DrawAPI: RedCircle , GreenCircle
	```java
	public class RedCircle implements DrawAPI {

	    @Override
	    public void drawCircle(int radius, int x, int y) {
		Log.e("---", "Drawing Circle[ color: red, radius: "
			+ radius + ", x: " + x + ", " + y + "]");
	    }
	}
	```
3. Sử dụng giao diện DrawAPI để tạo một lớp trừu tượng: Shape.
	```java
	public abstract class Shape {

	    protected DrawAPI drawAPI;

	    protected Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	    }

	    public abstract void draw();
	}
	```
4. Tạo một lớp thực thể thực hiện giao diện Shape.
	```java
	public class Circle extends Shape {

	    private int x, y, radius;

	    protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	    }

	    @Override
	    public void draw() {
		drawAPI.drawCircle(radius, x, y);
	    }
	}
	```
5. Sử dụng các lớp Shape và DrawAPI để vẽ các vòng tròn có màu sắc khác nhau.
	```java
	// 画红圆
	Circle circle = new Circle(10, 10, 100, new RedCircle());s
	circle.draw();
	// 画绿圆
	Circle circle2 = new Circle(20, 20, 100, new GreenCircle());
	circle2.draw();
	```
* Không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế Bridge chuẩn.
	
### Composite
* Còn được gọi là mẫu tổng thể từng phần, được sử dụng để coi một nhóm các đối tượng tương tự như một đối tượng duy nhất. Chế độ kết hợp kết hợp các đối tượng dựa trên cấu trúc cây, được sử dụng để thể hiện các cấp độ một phần và tổng thể. Kiểu thiết kế này là kiểu cấu trúc, tạo ra cấu trúc dạng cây của các nhóm đối tượng.
* Để tạo và in hệ thống phân cấp của nhân viên làm ví dụ
1. Tạo một lớp Employee với danh sách các đối tượng Employee.
	```java
	public class Employee {

	    private String name;
	    // 部门
	    private String dept;
	    // 工资
	    private int salary;
	    // 员工 list
	    private List<Employee> subordinates;

	    public Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subordinates = new ArrayList<Employee>();
	    }

	    public void add(Employee e) {
		subordinates.add(e);
	    }

	    public void remove(Employee e) {
		subordinates.remove(e);
	    }

	    public List<Employee> getSubordinates() {
		return subordinates;
	    }

	    @Override
	    public String toString() {
		return "Employee{" +
			"name='" + name + '\'' +
			", dept='" + dept + '\'' +
			", salary=" + salary +
			", subordinates=" + subordinates +
			'}';
	    }
	}
	```
2. Sử dụng lớp Employee để tạo và in hệ thống phân cấp của nhân viên.
	```java
	final Employee ceo = new Employee("John", "CEO", 30000);

	Employee headSales = new Employee("Robert", "Head sales", 20000);

	Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

	Employee clerk1 = new Employee("Laura", "Marketing", 10000);
	Employee clerk2 = new Employee("Bob", "Marketing", 10000);

	Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
	Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

	ceo.add(headSales);
	ceo.add(headMarketing);

	headSales.add(salesExecutive1);
	headSales.add(salesExecutive2);

	headMarketing.add(clerk1);
	headMarketing.add(clerk2);

	Log.e("---", ceo.toString());

	// 打印
	/*
	 * Employee{name='John', dept='CEO', salary=30000,
	 * subordinates=[Employee{name='Robert', dept='Head sales', salary=20000,
	 * subordinates=[
	 * Employee{name='Richard', dept='Sales', salary=10000, subordinates=[]},
	 * Employee{name='Rob', dept='Sales', salary=10000, subordinates=[]}]},
	 * Employee{name='Michel', dept='Head Marketing', salary=20000,
	 * subordinates=[Employee{name='Laura', dept='Marketing', salary=10000, subordinates=[]},
	 * Employee{name='Bob', dept='Marketing', salary=10000, subordinates=[]}]}]}
	 */
	 ```
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
	
### Decorator
Để thiết kế hệ thống trang bị của trò chơi, các yêu cầu cơ bản là có thể tính toán sức tấn công và mô tả của từng trang bị được khảm bằng các loại đá quý khác nhau:
1. Lớp cha của thiết bị: [IEquip.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/decorator/IEquip.java)
2. Lớp thực tế của mỗi thiết bị:
ví dụ: Hiện thực hóa vũ khí : [ArmEquip.java ](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/decorator/equip/ArmEquip.java)
3. Lớp siêu trang trí (đồ trang trí cũng thuộc về thiết bị): [IEquipDecorator.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/decorator/gem/IEuipDecorator.java)
4. Lớp hiện thực hóa trang trí:
	ví dụ: Lớp triển khai Sapphire (tích lũy): [BlueGemDecorator.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/decorator/gem/BlueGemDecorator.java)
	
### Facade
* Cung cấp một giao diện thống nhất để truy cập một nhóm giao diện trong hệ thống con. Sự xuất hiện xác định giao diện cấp cao giúp hệ thống con dễ sử dụng hơn. Trên thực tế, để thuận tiện cho khách hàng, một nhóm các thao tác được gói gọn thành một phương thức.
* Ví dụ: Khi muốn xem một bộ phim, cần:Bật máy làm bắp rang bơ, Làm bỏng ngô, Giảm độ sáng, Bật máy chiếu, Đặt vùng chiếu của máy chiếu xuống, Bật máy tính, Mở trình phát, Đặt âm của trình phát thành âm thanh vòm,...
* Xem phim tốn nhiều tiền, mệt, xem xong phải tắt từng bước một. Vì vậy, sử dụng chế độ **Facade** để giải quyết các bước phức tạp này và thưởng thức bộ phim một cách dễ dàng. 
* Kiểm tra cuối cùng: Xem bằng 1 cú nhấp chuột:
	```java
	new HomeTheaterFacade(computer, light, player, popcornPopper, projector).watchMovie();
	```

	
### Flyweight
* Chứng minh chế độ này bằng cách tạo ra 5 đối tượng để vẽ 20 vòng tròn phân bố ở các vị trí khác nhau. Vì chỉ có 5 màu khả dụng nên thuộc tính màu được sử dụng để kiểm tra đối tượng Circle hiện có.
* Khi có số lượng lớn đối tượng có thể gây tràn bộ nhớ, trừu tượng hóa các phần chung, nếu có các yêu cầu nghiệp vụ giống nhau thì trả về trực tiếp các đối tượng hiện có trong bộ nhớ để tránh tạo lại. Lấy ngẫu nhiên nhiều hình dạng làm ví dụ, có 4 bước:
1. Tạo giao diện.
	```java
	public interface Shape {
	    void draw();
	}
	```
2. Tạo một lớp thực thể triển khai giao diện.
	```java
	    public class Circle implements Shape {

	    private String color;
	    private int x;
	    private int y;
	    private int radius;

	    public Circle(String color) {
		this.color = color;
	    }

	    public void setX(int x) {
		this.x = x;
	    }

	    public void setY(int y) {
		this.y = y;
	    }

	    public void setRadius(int radius) {
		this.radius = radius;
	    }

	    @Override
	    public void draw() {
		Log.e("---", "Circle: Draw() [Color : " + color
			+ ", x : " + x + ", y :" + y + ", radius :" + radius);
	    }
	}
	```
3. Tạo một factory để tạo ra các đối tượng của các lớp thực thể dựa trên thông tin đã cho.
	```java
	public class ShapeFactory {

	    private static final HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

	    public static Shape getShape(String color) {
		Shape shape = circleMap.get(color);
		if (shape == null) {
		    shape = new Circle(color);
		    circleMap.put(color, shape);
		    Log.e("getShape", "Creating circle of color : " + color);
		}
		return shape;
	    }

	}
	```
4. Sử dụng factory này để lấy các đối tượng lớp thực thể bằng cách chuyển thông tin về màu sắc.
	```java
	for (int i = 0; i < 20; i++) {
	    Circle circle = (Circle) ShapeFactory.getShape(getRandomColor());
	    circle.setX(getRandomX());
	    circle.setY(getRandomY());
	    circle.setRadius(100);
	    circle.draw();
	}
	```
Về cơ bản, khuôn dạng cũng khá giống với mẫu tiêu chuẩn. Khi lớp trừu tượng thay đổi lớp con cũng thay đổi theo.
	
### Proxy
* Trong Proxy Pattern, một lớp đại diện cho chức năng của lớp khác.
* Có cấu trúc giống với mẫu thiết kế chuẩn
Lấy hình ảnh từ đĩa làm ví dụ
1. Tạo giao diện. (Image.java)
	```java
	public interface Image {
	   void display();
	}
	```
2. Tạo một RealImage lớp thực thể triển khai giao diện. (Lớp proxy tương ứng: ProxyImage)
	```java
	public class RealImage implements Image {

	    private String fileName;

	    public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	    }

	    private void loadFromDisk(String fileName) {
		Log.e("RealImage", "loading " + fileName);
	    }

	    @Override
	    public void display() {
		Log.e("RealImage", "Displaying " + fileName);
	    }
	}
	```

	```java
	public class ProxyImage implements Image {

	    private String fileName;
	    private RealImage realImage;

	    public ProxyImage(String fileName) {
		this.fileName = fileName;
	    }

	    @Override
	    public void display() {
		if (realImage == null) {
		    realImage = new RealImage(fileName);
		}
		realImage.display();
	    }
	}
	```
3. Khi được yêu cầu, hãy sử dụng ProxyImage để lấy các đối tượng của lớp RealImage.
```java
Image image = new ProxyImage("test_10mb.png");
// 第一次是new的，图像从磁盘加载
image.display();
// 第二次取缓存，图像不需要从磁盘加载
image.display();
```

## **3. Nhóm Behavior**
### Observer: 
Xác định một-nhiều phụ thuộc giữa các đối tượng, để khi một đối tượng thay đổi, tất cả các phụ thuộc của nó sẽ được thông báo và cập nhật tự động. Một số file mà sự án sử dụng Observer:
* *[Subject.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/observer/interfaces/Subject.java)* : interface chủ đề.
	```java
	/**
	 * 注册一个观察者
	 */
	public void registerObserver(Observer observer);

	/**
	 * 移除一个观察者
	 */
	public void removeObserver(Observer observer);

	/**
	 * 通知所有观察者
	 */
	public void notifyObservers();
	 ```
* *[ObjectFor3D.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/observer/classs/ObjectFor3D.java)* : Lớp triển khai của 3D service number.
	```java
	@Override
	public void registerObserver(Observer observer) {
	    observers.add(observer);
	}
	@Override
	public void removeObserver(Observer observer) {
	    int index = observers.indexOf(observer);
	    if (index >= 0) {
		observers.remove(index);
	    }
	}
	@Override
	public void notifyObservers() {
	    for (Observer observer : observers) {
		observer.update(msg);
	    }
	}
	/**
	 * 主题更新信息
	 */
	public void setMsg(String msg) {
	    this.msg = msg;
	    notifyObservers();
	}
	```
* *[Observer.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/observer/interfaces/Observer.java)*: Tất cả observer đều cần triển khai interface này.
	```java
	public ObserverUser1(Subject subject) {
	    subject.registerObserver(this);
	}
	@Override
	public void update(String msg) {
	    Log.e("-----ObserverUser1 ", "得到 3D 号码:" + msg + ", 我要记下来。");
	}
	```

* *[ObserverActivity.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/observer/ObserverActivity.java)*: final test
	```java
	// 创建服务号
	 objectFor3D = new ObjectFor3D();
	 // 创建两个订阅者
	 observerUser1 = new ObserverUser1(objectFor3D);
	 observerUser2 = new ObserverUser2(objectFor3D);
	 // 两个观察者,发送两条信息
	 objectFor3D.setMsg("201610121 的3D号为:127");
	 objectFor3D.setMsg("20161022 的3D号为:000");
	 ```

=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Command: 
Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo… Một số file mà sự án sử dụng Command:
* *[Door.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/command/Door.java)*: API của thiết bị gia dụng.
	```java
	package com.example.jingbin.designpattern.command;

	import android.util.Log;

	/**
	 * Created by jingbin on 2016/10/31.
	 * 门
	 */

	public class Door {

	    public void open() {
		Log.e("Door:", "---打开门");
	    }

	    public void close() {
		Log.e("Door:", "---关闭门");
	    }
	   ```

* *[Command.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/command/Command.java)*: interface lệnh hợp nhất.
* *[DoorOpenCommand.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/command/DoorOpenCommand.java)*
* *[ControlPanel.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/command/ControlPanel.java)*: Điều khiển từ xa.
* *[QuickCommand.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/command/QuickCommand.java)*: Định nghĩa một lệnh có thể thực hiện một loạt việc:
* *[CommandActivity.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/command/CommandActivity.java)*: Thực thi bảng điều khiển từ xa.
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Status: 
Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi. Một số file mà sự án sử dụng Status:
* *[VendingMachine.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/state/old/VendingMachine.java)*: Nhận diện ban đầu về máy bán hàng tự động cần được cải tiến.
* *[VendingMachineBetter.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/state/better/VendingMachineBetter.java)*: Máy máy bán hàng tự động cần được cải tiến.
	```java
	// 放钱
	public void insertMoney() {
	    currentState.insertMoney();
	}
	// 退钱
	public void backMoney() {
	    currentState.backMoney();
	}
	// 转动曲柄
	public void turnCrank() {
	    currentState.turnCrank();
	    if (currentState == soldState || currentState == winnerState) {
		currentState.dispense();//两种情况会出货
	    }
	}
	// 出商品
	public void dispense() {
	    Log.e("VendingMachineBetter", "---发出一件商品");
	    if (count > 0) {
		count--;
	    }
	}
	// 设置对应状态
	public void setState(State state) {
	    this.currentState = state;
	}
	```

* *[State.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/state/better/State.java)*: status interface
* Lớp thực thi interface trạng thái tương ứng:
+ *[WinnerState.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/state/better/WinnerState.java)*: winner status.
+ *[SoldState.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/state/better/SoldState.java)*: Trạng thái đã bán.

=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Iterator: 
Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử. Trong phần này:
* *[Container.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/iterator/Container.java)*
* *[Iterator.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/iterator/Iterator.java)*
* *[IteratorActivity.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/iterator/IteratorActivity.java)*
* *[NameRepository.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/iterator/NameRepository.java)*
1. Tạo interface Iterator, Container.
2. Tạo một lớp thực thể triển khai interface Container. Lớp này có một NameIterator của lớp bên trong thực hiện interface Iterator.
3. Sử dụng NameRepository để lấy trình lặp và in tên.

=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Mediator: 
Định nghĩa một đối tượng để bao bọc việc giao tiếp giữa một số đối tượng với nhau. 
* *[CharRoom.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/mediator/CharRoom.java)*
* *[MediatorActivity.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/mediator/MediatorActivity.java)*
* *[User.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/mediator/User.java)*
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Memento: 
Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu. 
* *[CareTaker.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/memento/CareTaker.java)*
* *[Memento.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/memento/Memento.java)*
* *[MementoActivity.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/memento/MementoActivity.java)*
* *[Originator.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/memento/Originator.java)*
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Interpreter: Hỗ trợ việc định nghĩa biểu diễn văn phạm và bộ thông dịch cho một ngôn ngữ. Trong phần này:
1. Tạo interface Expression.
	 ```public interface Expression {
	    public boolean interpreter(String content);
	}
	```
2. Tạo một lớp thực thể thực hiện interface trên. TerminalExpression, OrExpression, AndExpression.
* ```public class TerminalExpression implements Expression {

	private String data;

	public TerminalExpression(String data) {
		   this.data = data;
	}

	@Override
	public boolean interpreter(String content) {
		  // 是包含判断
		   return content.contains(data);
	}
}
```

* ```public class OrExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpreter(String content) {
        return expression1.interpreter(content) || expression2.interpreter(content);
    }
}
```

* ```public class AndExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpreter(String content) {
        return expression1.interpreter(content) && expression2.interpreter(content);
    }
}
```

3. Sử dụng class Expression để tạo các quy tắc và phân tích cú pháp chúng.
```/**
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

Expression maleExpression = getMaleExpression();
// jingbin is male: true
Log.e("---", "jingbin is male: " + maleExpression.interpreter("jingbin"));

Expression womanExpression = getMarriedWomanExpression();
// Julie is married woman: true
Log.e("---", "Julie is married woman: " + womanExpression.interpreter("Married Julie"));
```
=> Khuôn dạng khá giống mẫu tiêu chuẩn.

### Chain of Responsibility: 
Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó. Tránh việc gắn kết cứng giữa phần tử gởi request với phần tử nhận và xử lý request bằng cách cho phép hơn 1 đối tượng có có cơ hội xử lý request. Liên kết các đối tượng nhận request thành 1 dây chuyền rồi gửi request xuyên qua từng đối tượng xử lý đến khi gặp đối tượng xử lý cụ thể. 
* *[AbstractLogger.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/chainofresponsibility/AbstractLogger.java)*
* *[ChainOfResponsibilityActivity.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/chainofresponsibility/ChainOfResponsibilityActivity.java)*
=> Khuôn dạng khá giống mẫu tiêu chuẩn.


### Strategy:

- Giống nhau:
    - Nhân vật trò chơi ban đầu: [*Role.java*](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/strategy/old/Role.java)
    
    ```java
    public abstract class Role {
    
        protected String name;
    
        // 着装
        protected abstract void display();
    
        // 逃跑
        protected abstract void run();
    
        // 攻击
        protected abstract void attack();
    
        // 防御
        protected abstract void defend();
    }
    ```
    
    - Khi có mã trùng lặp, lớp cha được tái cấu trúc.
- Khác nhau: không có sự khác nhau.

### Template Method:

- Giống nhau:
    - Abstract Class: *[Worker.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/templatemethod/Worker.java) "*khung" nhân viên nói chung. Trong khung sẽ có nhiều đối tượng cụ thể có cùng các bước thực hiện nhưng trong mỗi bước có thể khác nhau. (Ví dụ đều cùng có tên, vào công ty, bật máy tính và làm việc sau đó tắt máy tan ca)
    
    ```java
    public abstract class Worker {
    
        protected String name;
    
        public Worker(String name) {
            this.name = name;
        }
    
        public final void workOneDay() {
            Log.e("workOneDay", "-----------------work start----------------");
    
            enterCompany();
            computerOn();
            work();
            computerOff();
            exitCompany();
    
            Log.e("workOneDay", "-----------------work end----------------");
        }
    
        public abstract void work();
    
        public boolean isNeedPrintDate() {
            return false;
        }
    
        private void exitCompany() {
            if (isNeedPrintDate()) {
                Log.e("exitCompany", "---" + new Date().toLocaleString() + "--->");
            }
            Log.e("exitCompany", name + "---离开公司");
        }
    
    //    -----------------------------------
    
        private void computerOn() {
            Log.e("computerOn", "---打开电脑");
        }
    
        private void computerOff() {
            Log.e("computerOff", "---关闭电脑");
        }
    
        private void enterCompany() {
            Log.e("enterCompany", "---进入公司");
        }
    }
    ```
    
    - Concrete Class: các đối tượng cụ thể khác nhau: *[ITWorker.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/templatemethod/worker/ITWorker.java), [HRWorker.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/templatemethod/worker/HRWorker.java), [CTOWorker.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/templatemethod/worker/CTOWorker.java).*
- Khác nhau: không có sự khác nhau.

### Visitor:

- Giống nhau:
    - 1 Interface đại diện cho các yếu tố: *[ComputerPart.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/visitor/ComputerPart.java)*
    
    ```java
    public interface ComputerPart {
        public void accept(ComputerPartVisitor computerPartVisitor);
    }
    ```
    
    - Các class implements từ Interface đó: *[Computer](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/visitor/impl/Computer.java), [Mouse](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/visitor/impl/Mouse.java), [Monitor](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/visitor/impl/Monitor.java), [Keyboard](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/visitor/impl/Keyboard.java)*.
    - 1 Interface riêng cho khách truy cập *([ComputerPartVisitor.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/visitor/ComputerPartVisitor.java))*
    
    ```java
    public interface ComputerPart {
        public void accept(ComputerPartVisitor computerPartVisitor);
    }
    ```
    
    - Class dành cho khách truy cập và hiển thị output *([ComputerPartDisplayVisitor.java](https://github.com/youlookwhat/DesignPattern/blob/master/app/src/main/java/com/example/jingbin/designpattern/visitor/ComputerPartDisplayVisitor.java))*
    
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
    
- Khác nhau: không có sự khác nhau.

## **4. Kết luận**
Nhìn chung, 23 mẫu thiết kế dùng trong project trên không có sự khác biệt so với 23 mẫu thiết kế tiêu chuẩn. 
