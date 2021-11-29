# **Báo cáo tìm hiểu về mẫu thiết kế**
## **Thành viên:**
- Lương Duy Đạt - 19020039.
- Lê Văn Minh - 19020367.
- Nguyễn Tấn Huy - 19020322.
## **Cách thức thực hiện bài báo cáo:** 
Các thành viên làm phần bài báo cáo của mình vào một cái google doc chung rồi một bạn sẽ phụ trách commit.

**[Link đến reposition được sử dụng trong bài báo cáo](https://github.com/bethrobson/Head-First-Design-Patterns)**

## **I. Giới thiệu về mẫu thiết kế:**
Giả sử bạn muốn tạo một lớp và sử dụng lớp này để tạo một đối tượng mà đối tượng này được sử dụng bởi tất cả các lớp khác. Giải pháp tốt nhất trong trường hợp này là sử dụng Singleton design pattern.
Như vậy design pattern là độc lập với ngôn ngữ lập trình để giải quyết các vấn đề phổ biến trong thiết kế hướng đối tượng. Nghĩa là một design pattern là một ý tưởng, không phải là một cài đặt cụ thể.
Bằng cách sử dụng design pattern, chúng ta sẽ tạo ra những đoạn code linh hoạt hơn, có khả năng tái sử dụng hơn và dễ bảo trì nâng cấp hơn.
## **II. Các mẫu thiết kế được sử dụng trong reposition:**
## **1. Abstract Factory ( nhà máy trừu tượng)**:
- Là một mẫu thiết kế sáng tạo cho phép bạn tạo ra các họ các đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng. Pattern Factory giống như một nhà máy sản sinh các đối tượng tương tự nhau này cho bạn.Pattern Factory  tạo các đối tượng đặc biệt từ các lớp cha và dễ dàng tạo extends system từ system cũ.
- Minh hoạ: 
```swift
	import refactoring_guru.abstract_factory.example.app.Application;
	import refactoring_guru.abstract_factory.example.factories.GUIFactory;
	import refactoring_guru.abstract_factory.example.factories.MacOSFactory;
	import refactoring_guru.abstract_factory.example.factories.WindowsFactory;

	public class Demo {
	    private static Application configureApplication() {
	        Application app;
	        GUIFactory factory;
	        String osName = System.getProperty("os.name").toLowerCase();
	        if (osName.contains("mac")) {
	            factory = new MacOSFactory();
	            app = new Application(factory);
	        } else {
	            factory = new WindowsFactory();
	            app = new Application(factory);
	        }
	        return app;
	    }
	

	    public static void main(String[] args) {
	        Application app = configureApplication();
	        app.paint();
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 2. Adapter Pattern (Người chuyển đổi) 
- Adapter Pattern là pattern giữ vai trò trung gian giữa hai lớp, chuyển đổi giao diện của một hay nhiều lớp có sẵn thành một giao diện khác, thích hợp cho lớp đang viết. Điều này cho phép các lớp có các giao diện khác nhau có thể dễ dàng giao tiếp tốt với nhau thông qua giao diện trung gian, không cần thay đổi code của lớp có sẵn cũng như lớp đang viết. Adapter Pattern còn gọi là Wrapper Pattern do cung cấp một giao diện “bọc ngoài” tương thích cho một hệ thống có sẵn, có dữ liệu và hành vi phù hợp nhưng có giao diện không tương thích với lớp đang viết.
- Minh hoạ:
```swift

	import refactoring_guru.adapter.example.adapters.SquarePegAdapter;
	import refactoring_guru.adapter.example.round.RoundHole;
	import refactoring_guru.adapter.example.round.RoundPeg;
	import refactoring_guru.adapter.example.square.SquarePeg;
	
	public class Demo {
	    public static void main(String[] args) {
	        // EN: Round fits round, no surprise.
	        RoundHole hole = new RoundHole(5);
	        RoundPeg rpeg = new RoundPeg(5);
	        if (hole.fits(rpeg)) {
	            System.out.println("Round peg r5 fits round hole r5.");
	        }
	

	        SquarePeg smallSqPeg = new SquarePeg(2);
	        SquarePeg largeSqPeg = new SquarePeg(20);
	        // EN: hole.fits(smallSqPeg); // Won't compile.
	      
	        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
	        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
	        if (hole.fits(smallSqPegAdapter)) {
	            System.out.println("Square peg w2 fits round hole r5.");
	        }
	        if (!hole.fits(largeSqPegAdapter)) {
	            System.out.println("Square peg w20 does not fit into round hole r5.");
	        }
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 3. Bridge Pattern:
- Là một mẫu thiết kế cấu trúc cho phép bạn chia một lớp lớn hoặc một tập hợp các lớp có liên quan chặt chẽ thành hai phân cấp riêng biệt — trừu tượng và thực thi — có thể được phát triển độc lập với nhau. Bridge pattern được sử dụng khi chúng ta muốn tách một abtraction từ implementation của nó để cả hai có thể thay đổi một cách độc lập với nhau. Bridge Pattern là một mẫu cấu trúc (Structural Pattern)
- Minh hoạ:
```swift
package refactoring_guru.bridge.example;
	

	import refactoring_guru.bridge.example.devices.Device;
	import refactoring_guru.bridge.example.devices.Radio;
	import refactoring_guru.bridge.example.devices.Tv;
	import refactoring_guru.bridge.example.remotes.AdvancedRemote;
	import refactoring_guru.bridge.example.remotes.BasicRemote;
	

	public class Demo {
	    public static void main(String[] args) {
	        testDevice(new Tv());
	        testDevice(new Radio());
	    }
	

	    public static void testDevice(Device device) {
	        System.out.println("Tests with basic remote.");
	        BasicRemote basicRemote = new BasicRemote(device);
	        basicRemote.power();
	        device.printStatus();
	

	        System.out.println("Tests with advanced remote.");
	        AdvancedRemote advancedRemote = new AdvancedRemote(device);
	        advancedRemote.power();
	        advancedRemote.mute();
	        device.printStatus();
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 4. Builder pattern:
- Là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và hình ảnh đại diện khác nhau của một đối tượng bằng cách sử dụng cùng một mã xây dựng.
- Minh hoạ:
```swift
package refactoring_guru.builder.example;
	

	import refactoring_guru.builder.example.builders.CarBuilder;
	import refactoring_guru.builder.example.builders.CarManualBuilder;
	import refactoring_guru.builder.example.cars.Car;
	import refactoring_guru.builder.example.cars.Manual;
	import refactoring_guru.builder.example.director.Director;
	public class Demo {
	

	    public static void main(String[] args) {
	        Director director = new Director();
	

	        // EN: Director gets the concrete builder object from the client
	        // (application code). That's because application knows better which
	        // builder to use to get a specific product.
	        CarBuilder builder = new CarBuilder();
	        director.constructSportsCar(builder);
	

	        // EN: The final product is often retrieved from a builder object, since
	        // Director is not aware and not dependent on concrete builders and
	        // products.
	        //
	        Car car = builder.getResult();
	        System.out.println("Car built:\n" + car.getCarType());
	        CarManualBuilder manualBuilder = new CarManualBuilder();
	        director.constructSportsCar(manualBuilder);
	        Manual carManual = manualBuilder.getResult();
	        System.out.println("\nCar manual built:\n" + carManual.print());
	    }
	

	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 5. Factory Method Pattern
 - Là một mẫu thiết kế sáng tạo cung cấp mục đích khởi tạo một đối tượng mới mà không cần thiết phải chỉ ra một cách chính xác class nào sẽ được khởi tạo. Factory Method Pattern giải quyết vấn đề này bằng cách định nghĩa một factory method cho việc tạo đối tượng, và các lớp con thừa kế có thể override phương thức này để chỉ rõ đối tượng nào sẽ được khởi tạo.
- Minh hoạ:
```swift
package refactoring_guru.factory_method.example;
	

	import refactoring_guru.factory_method.example.factory.Dialog;
	import refactoring_guru.factory_method.example.factory.HtmlDialog;
	import refactoring_guru.factory_method.example.factory.WindowsDialog;
	
	public class Demo {
	    private static Dialog dialog;
	

	    public static void main(String[] args) {
	        configure();
	        runBusinessLogic();
	    }
	
	    static void configure() {
	        if (System.getProperty("os.name").equals("Windows 10")) {
	            dialog = new WindowsDialog();
	        } else {
	            dialog = new HtmlDialog();
	        }
	    }
	
	    static void runBusinessLogic() {
	        dialog.renderWindow();
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 6. Facade Pattern:
- Là một mẫu thiết kế sáng tạo cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo. Facade Pattern cung cấp một interface đơn giản và cao cấp nhất cho phía client (máy khách) và cho phép nó truy cập vào hệ thống mà không cần biết bên trong có logic hệ thống nào hay nó hoạt động như thế nào.
- Minh hoạ: 
```swift
package refactoring_guru.facade.example;
	

	import refactoring_guru.facade.example.facade.VideoConversionFacade;
	

	import java.io.File;
	

	public class Demo {
	    public static void main(String[] args) {
	        VideoConversionFacade converter = new VideoConversionFacade();
	        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
	        // ...
	    }
	}
```
-So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 7. Prototype pattern:
- Là một Design Pattern được sử dụng chủ yếu để giảm chi phí khi tạo object. Thường là khi các ứng dụng quy mô lớn tạo, cập nhật hoặc truy xuất các đối tượng tốn nhiều tài nguyên. Điều này được thực hiện bằng cách sao chép object, nó được tạo và sử dụng lại bản sao của object trong các yêu cầu ở phía sau khi có, để tránh thực hiện một hoạt động tốn tài nguyên khác.
- Minh hoạ:
```swift
package refactoring_guru.prototype.example;
	

	import refactoring_guru.prototype.example.shapes.Circle;
	import refactoring_guru.prototype.example.shapes.Rectangle;
	import refactoring_guru.prototype.example.shapes.Shape;
	

	import java.util.ArrayList;
	import java.util.List;
	

	public class Demo {
	    public static void main(String[] args) {
	        List<Shape> shapes = new ArrayList<>();
	        List<Shape> shapesCopy = new ArrayList<>();
	

	        Circle circle = new Circle();
	        circle.x = 10;
	        circle.y = 20;
	        circle.radius = 15;
	        circle.color = "red";
	        shapes.add(circle);
	

	        Circle anotherCircle = (Circle) circle.clone();
	        shapes.add(anotherCircle);
	

	        Rectangle rectangle = new Rectangle();
	        rectangle.width = 10;
	        rectangle.height = 20;
	        rectangle.color = "blue";
	        shapes.add(rectangle);
	

	        cloneAndCompare(shapes, shapesCopy);
	    }
	

	    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
	        for (Shape shape : shapes) {
	            shapesCopy.add(shape.clone());
	        }
	

	        for (int i = 0; i < shapes.size(); i++) {
	            if (shapes.get(i) != shapesCopy.get(i)) {
	                System.out.println(i + ": Shapes are different objects (yay!)");
	                if (shapes.get(i).equals(shapesCopy.get(i))) {
	                    System.out.println(i + ": And they are identical (yay!)");
	                } else {
	                    System.out.println(i + ": But they are not identical (booo!)");
	                }
	            } else {
	                System.out.println(i + ": Shape objects are the same (booo!)");
	            }
	        }
	    }
	}
```	
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 8. Chain_of_responsibility:
- Là một mẫu thiết kế hành vi bao gồm một nguồn các đối tượng lệnh và một loạt các đối tượng xử lý. Mỗi đối tượng xử lý chứa logic xác định các loại đối tượng lệnh mà nó có thể xử lý, phần còn lại được chuyển cho đối tượng xử lý tiếp theo trong chuỗi.
- Minh hoạ:
```swift
package refactoring_guru.chain_of_responsibility.example;
	

	import refactoring_guru.chain_of_responsibility.example.middleware.Middleware;
	import refactoring_guru.chain_of_responsibility.example.middleware.RoleCheckMiddleware;
	import refactoring_guru.chain_of_responsibility.example.middleware.ThrottlingMiddleware;
	import refactoring_guru.chain_of_responsibility.example.middleware.UserExistsMiddleware;
	import refactoring_guru.chain_of_responsibility.example.server.Server;
	

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	// EN: Demo class. Everything comes together here.
	public class Demo {
	    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    private static Server server;
	

	    private static void init() {
	        server = new Server();
	        server.register("admin@example.com", "admin_pass");
	        server.register("user@example.com", "user_pass");
	

	        // EN: All checks are linked. Client can build various chains using the
	        // same components.
	        Middleware middleware = new ThrottlingMiddleware(2);
	        middleware.linkWith(new UserExistsMiddleware(server))
	                .linkWith(new RoleCheckMiddleware());
	

	        // EN: Server gets a chain from client code.
	        //
	        // RU: Сервер получает цепочку от клиентского кода.
	        server.setMiddleware(middleware);
	    }
	

	    public static void main(String[] args) throws IOException {
	        init();
	

	        boolean success;
	        do {
	            System.out.print("Enter email: ");
	            String email = reader.readLine();
	            System.out.print("Input password: ");
	            String password = reader.readLine();
	            success = server.logIn(email, password);
	        } while (!success);
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 9. Command Pattern:
- Là một mẫu thiết kế hành vi biến một yêu cầu thành một đối tượng độc lập chứa tất cả thông tin về yêu cầu. Sự chuyển đổi này cho phép bạn chuyển các yêu cầu dưới dạng đối số của phương thức, trì hoãn hoặc xếp hàng đợi việc thực hiện một yêu cầu và hỗ trợ các hoạt động hoàn tác.
- Minh hoạ:
```swift
package refactoring_guru.command.example;
	

	import refactoring_guru.command.example.editor.Editor;
	

	public class Demo {
	    public static void main(String[] args) {
	        Editor editor = new Editor();
	        editor.init();
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 10. Composite:
- Là một mẫu thiết kế thuộc nhóm Structural Pattern. Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.
- Minh hoạ:
```swift
package refactoring_guru.composite.example;
	

	import refactoring_guru.composite.example.editor.ImageEditor;
	import refactoring_guru.composite.example.shapes.Circle;
	import refactoring_guru.composite.example.shapes.CompoundShape;
	import refactoring_guru.composite.example.shapes.Dot;
	import refactoring_guru.composite.example.shapes.Rectangle;
	

	import java.awt.*;
	

	public class Demo {
	    public static void main(String[] args) {
	        ImageEditor editor = new ImageEditor();
	

	        editor.loadShapes(
	                new Circle(10, 10, 10, Color.BLUE),
	

	                new CompoundShape(
	                    new Circle(110, 110, 50, Color.RED),
	                    new Dot(160, 160, Color.RED)
	                ),
	

	                new CompoundShape(
	                        new Rectangle(250, 250, 100, 100, Color.GREEN),
	                        new Dot(240, 240, Color.GREEN),
	                        new Dot(240, 360, Color.GREEN),
	                        new Dot(360, 360, Color.GREEN),
	                        new Dot(360, 240, Color.GREEN)
	                )
	        );
	    }
	}
```
-So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 11. Decorator Pattern:
- Là một mẫu thiết kế cấu trúc cho phép bạn đính kèm các hành vi mới vào các đối tượng bằng cách đặt các đối tượng này bên trong các đối tượng trình bao bọc đặc biệt có chứa các hành vi.
- Minh hoạ:
```swift 
package refactoring_guru.decorator.example;
	

	import refactoring_guru.decorator.example.decorators.*;
	

	public class Demo {
	    public static void main(String[] args) {
	        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
	        DataSourceDecorator encoded = new CompressionDecorator(
	                                         new EncryptionDecorator(
	                                             new FileDataSource("out/OutputDemo.txt")));
	        encoded.writeData(salaryRecords);
	        DataSource plain = new FileDataSource("out/OutputDemo.txt");
	

	        System.out.println("- Input ----------------");
	        System.out.println(salaryRecords);
	        System.out.println("- Encoded --------------");
	        System.out.println(plain.readData());
	        System.out.println("- Decoded --------------");
	        System.out.println(encoded.readData());
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 12. Flyweight Pattern:
- Là một mẫu thiết kế cấu trúc cho phép bạn lắp nhiều đối tượng hơn vào dung lượng RAM có sẵn bằng cách chia sẻ các phần trạng thái chung giữa nhiều đối tượng thay vì giữ tất cả dữ liệu trong mỗi đối tượng.
- Minh hoạ:
```swift
package refactoring_guru.flyweight.example;
	
	import refactoring_guru.flyweight.example.forest.Forest;
	

	import java.awt.*;
	

	public class Demo {
	    static int CANVAS_SIZE = 500;
	    static int TREES_TO_DRAW = 1000000;
	    static int TREE_TYPES = 2;
	

	    public static void main(String[] args) {
	        Forest forest = new Forest();
	        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
	            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
	                    "Summer Oak", Color.GREEN, "Oak texture stub");
	            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
	                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
	        }
	        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
	        forest.setVisible(true);
	

	        System.out.println(TREES_TO_DRAW + " trees drawn");
	        System.out.println("---------------------");
	        System.out.println("Memory usage:");
	        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
	        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
	        System.out.println("---------------------");
	        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
	                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
	    }
	

	    private static int random(int min, int max) {
	        return min + (int) (Math.random() * ((max - min) + 1));
	    }
	}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 13. Interpreter Pattern: 
- Là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Interpreter Pattern giúp người lập trình có thể “xây dựng” những đối tượng “động” bằng cách đọc mô tả về đối tượng rồi sau đó “xây dựng” đối tượng đúng theo mô tả đó.
- Minh họa: 
```swift
package refactoring_guru.interpreter.example;
	

import refactoring_guru.interpreter.example.expressions.AndExpression;
import refactoring_guru.interpreter.example.expressions.Context;
import refactoring_guru.interpreter.example.expressions.OrExpression;
import refactoring_guru.interpreter.example.expressions.VariableExpression;

 // EN: Interpreter Design Pattern.
 // Defines a representation for a grammar as well as a mechanism to understand and act upon the grammar.
public class Demo {
    private static void example1() throws Exception {
        var context = new Context();


        var a = new VariableExpression("A");
        var b = new VariableExpression("B");
        var c = new VariableExpression("C");


        // example 1:
        // A ∧ (B ∨ C)
        var example1 = new AndExpression(
                a,
                new OrExpression(b, c)
        );


        context.assign(a, true);
        context.assign(b, true);
        context.assign(c, false);


        var result = example1.interpret(context) ? "true" : "false";


        System.out.println("boolean expression A ∧ (B ∨ C) = " + result + ", with variables A=true, B=true, C=false");
    }


    private static void example2() throws Exception {
        var context = new Context();


        var a = new VariableExpression("A");
        var b = new VariableExpression("B");
        var c = new VariableExpression("C");


        // example 2:
        // B ∨ (A ∧ (B ∨ C))
        var example2 = new OrExpression(
                b,
                new AndExpression(
                        a,
                        new OrExpression(b, c)
                )
        );


        context.assign(a, false);
        context.assign(b, false);
        context.assign(c, true);


        var result2 = example2.interpret(context) ? "true" : "false";


        System.out.println("boolean expression B ∨ (A ∧ (B ∨ C)) = " + result2 + ", with variables A=false, B=false, C=true");
    }


    public static void main(String[] args) throws Exception {
        example1();
        example2();
    }
}
```
- So sánh: 
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 14. Iterator pattern: 
- Là một mẫu thiết kế hành vi cho phép bạn duyệt qua các phần tử của một bộ sưu tập mà không để lộ biểu diễn cơ bản của nó (danh sách, ngăn xếp, cây, v.v.).
- Minh họa:
```swift
Package refactoring_guru.iterator.example;
	

import refactoring_guru.iterator.example.profile.Profile;
import refactoring_guru.iterator.example.social_networks.Facebook;
import refactoring_guru.iterator.example.social_networks.LinkedIn;
import refactoring_guru.iterator.example.social_networks.SocialNetwork;
import refactoring_guru.iterator.example.spammer.SocialSpammer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 // EN: Demo class. Everything comes together here.

 
public class Demo {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Please specify social network to target spam tool (default:Facebook):");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();


        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        }
        else {
            network = new Facebook(createTestProfiles());
        }


        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("anna.smith@bing.com",
                "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
        spammer.sendSpamToCoworkers("anna.smith@bing.com",
                "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
    }


    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<Profile>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 15. Mediator Pattern 
- Là một mẫu thiết kế hành vi cho phép bạn giảm bớt sự phụ thuộc hỗn loạn giữa các đối tượng. Mẫu hạn chế giao tiếp trực tiếp giữa các đối tượng và buộc chúng chỉ cộng tác thông qua một đối tượng trung gian.
- Minh họa:
```swift
package refactoring_guru.mediator.example;
	

import refactoring_guru.mediator.example.components.*;
import refactoring_guru.mediator.example.mediator.Editor;
import refactoring_guru.mediator.example.mediator.Mediator;


import javax.swing.*;

 // EN: Demo class. Everything comes together here.
 
public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();


        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());


        mediator.createGUI();
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 16. Memento
- Là một mẫu thiết kế hành vi cho phép bạn lưu và khôi phục trạng thái trước đó của một đối tượng mà không tiết lộ chi tiết về quá trình triển khai của nó.
- Minh họa:
```swift
package refactoring_guru.memento.example;
	

import refactoring_guru.memento.example.editor.Editor;
import refactoring_guru.memento.example.shapes.Circle;
import refactoring_guru.memento.example.shapes.CompoundShape;
import refactoring_guru.memento.example.shapes.Dot;
import refactoring_guru.memento.example.shapes.Rectangle;


import java.awt.*;


public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),


                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),


                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
```
- So sánh: 
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 17. Observer pattern 
- Là một mẫu thiết kế hành vi cho phép bạn xác định cơ chế đăng ký để thông báo cho nhiều đối tượng về bất kỳ sự kiện nào xảy ra với đối tượng mà họ đang quan sát.
- Minh họa:
```swift
package refactoring_guru.observer.example;


import refactoring_guru.observer.example.editor.Editor;
import refactoring_guru.observer.example.listeners.EmailNotificationListener;
import refactoring_guru.observer.example.listeners.LogOpenListener;


public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));


        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 18. Proxy Pattern 
- Là mẫu thiết kế mà ở đó tất cả các truy cập trực tiếp đến một đối tượng nào đó sẽ được chuyển hướng vào một đối tượng trung gian (Proxy Class). Mẫu Proxy (người đại diện) đại diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với múc đích sử dụng.
- Minh họa:
```swift
package refactoring_guru.proxy.example;
	

import refactoring_guru.proxy.example.downloader.YouTubeDownloader;
import refactoring_guru.proxy.example.proxy.YouTubeCacheProxy;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyYouTubeClass;


public class Demo {


    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());


        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");


    }


    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();


        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");


        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 19. Single Pattern 
- Là một design pattern mà đảm bảo rằng một class chỉ có duy nhất một instance (khởi tạo - mình xin phép để nguyên không dịch từ này) và cung cấp một cáchs toàn cầu để truy cấp tới instance đó.
- Minh họa:
```swift
package refactoring_guru.singleton.example.non_thread_safe;
	

public final class Singleton {
    private static Singleton instance;
    public String value;


    private Singleton(String value) {
        // EN: The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }


    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 20. State Pattern 
- Là một trong những mẫu thiết kế thuộc nhóm behavioral cho phép một object có thể biến đổi hành vi của nó khi có những sự thay đổi trạng thái nội bộ.
- Minh họa: 
```swift
package refactoring_guru.state.example;
	

import refactoring_guru.state.example.ui.Player;
import refactoring_guru.state.example.ui.UI;

 // EN: Demo class. Everything comes together here.

 
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
```
- So sánh: 
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 21. Strategy pattern (mẫu chiến lược) 
- Là một mẫu thiết kế hành vi cho phép bạn xác định một nhóm thuật toán, đặt mỗi thuật toán vào một lớp riêng biệt và làm cho các đối tượng của chúng có thể hoán đổi cho nhau.
- Minh họa:
```swift
package refactoring_guru.strategy.example;
	

import refactoring_guru.strategy.example.order.Order;
import refactoring_guru.strategy.example.strategies.PayByCreditCard;
import refactoring_guru.strategy.example.strategies.PayByPayPal;
import refactoring_guru.strategy.example.strategies.PayStrategy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;



 // EN: World first console e-commerce application.

public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;


    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }


    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;


            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));


            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();


                // EN: Client creates different strategies based on input from
                // user, application configuration, etc.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }


            // EN: Order object delegates gathering payment data to strategy
            // object, since only strategies know what data they need to
            // process a payment.
	    
            order.processOrder(strategy);


            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // EN: Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 22. Template Method Pattern 
- Là một mẫu thiết kế hành vi xác định khung của một thuật toán trong lớp cha nhưng cho phép các lớp con ghi đè các bước cụ thể của thuật toán mà không thay đổi cấu trúc của nó.
- Minh họa:
```swift
package refactoring_guru.template_method.example;
	

import refactoring_guru.template_method.example.networks.Facebook;
import refactoring_guru.template_method.example.networks.Network;
import refactoring_guru.template_method.example.networks.Twitter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


 // EN: Demo class. Everything comes together here.
 
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();


        // EN: Enter the message.
        System.out.print("Input message: ");
        String message = reader.readLine();


        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());


        // EN: Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## 23. Visitor 
- Là mẫu thiết kế (Design Patterns là một mẫu thiết kế hành vi cho phép bạn tách các thuật toán khỏi các đối tượng mà chúng hoạt động trên đó.
- Minh họa:
```swift
package refactoring_guru.visitor.example;
	

import refactoring_guru.visitor.example.shapes.*;
import refactoring_guru.visitor.example.visitor.XMLExportVisitor;


public class Demo {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);


        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);


        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);


        export(circle, compoundShape);
    }


    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
```
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.
## **III. Kết Luận** 
Có thể nói, mẫu thiết kế là kỹ thuật trong lập trình hướng đối tượng, nó rất quan trọng khi giải quyết vấn đề của nhiều bài toán khác nhau. Đây là sự đúc kết kinh nghiệm để linh hoạt trong quá trình sử dụng về sau và mỗi lập trình viên muốn giỏi đều phải biết.
Tóm lại, 23 mẫu thiết kế có thể chia thành 3 loại:
1.	Creational Patterns
2.	Structural Patterns
3.	Behavioral Patterns
Sau khi tìm hiểu các mẫu thiết kế, nhóm chúng em đã có những kiến thức hiểu cơ bản song trên thực tiễn khi áp dụng có thể sẽ mất nhiều thời gian để ngấm sâu về nó.













