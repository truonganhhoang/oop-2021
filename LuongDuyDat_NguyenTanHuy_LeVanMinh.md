# **Báo cáo tìm hiểu về mẫu thiết kế**
## **Thành viên:**
- Lương Duy Đạt.
- Lê Văn Minh
- Nguyễn Tấn Huy
## **Cách thức thực hiện bài báo cáo:** 
Các thành viên làm phần bài báo cáo của mình vào một cái google doc chung rồi một bạn sẽ phụ trách commit.

**[Link đến reposition được sử dụng trong bài báo cáo](https://github.com/bethrobson/Head-First-Design-Patterns)**

## **I.Giới thiệu về mẫu thiết kế:**
Giả sử bạn muốn tạo một lớp và sử dụng lớp này để tạo một đối tượng mà đối tượng này được sử dụng bởi tất cả các lớp khác. Giải pháp tốt nhất trong trường hợp này là sử dụng Singleton design pattern.
Như vậy design pattern là độc lập với ngôn ngữ lập trình để giải quyết các vấn đề phổ biến trong thiết kế hướng đối tượng. Nghĩa là một design pattern là một ý tưởng, không phải là một cài đặt cụ thể.
Bằng cách sử dụng design pattern, chúng ta sẽ tạo ra những đoạn code linh hoạt hơn, có khả năng tái sử dụng hơn và dễ bảo trì nâng cấp hơn.
## **II. Các mẫu thiết kế được sử dụng trong reposition:**
## **1. Abstract Factory ( nhà máy trừu tượng)**:
-Là một mẫu thiết kế sáng tạo cho phép bạn tạo ra các họ các đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng. Pattern Factory giống như một nhà máy sản sinh các đối tượng tương tự nhau này cho bạn.Pattern Factory  tạo các đối tượng đặc biệt từ các lớp cha và dễ dàng tạo extends system từ system cũ.
-Minh hoạ: 
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
- So sánh:
+ Giống nhau: Giống với mẫu chuẩn.
+ Khác nhau: Không có sự khác nhau.

## 2. Adapter Pattern (Người chuyển đổi) 
-Adapter Pattern là pattern giữ vai trò trung gian giữa hai lớp, chuyển đổi giao diện của một hay nhiều lớp có sẵn thành một giao diện khác, thích hợp cho lớp đang viết. Điều này cho phép các lớp có các giao diện khác nhau có thể dễ dàng giao tiếp tốt với nhau thông qua giao diện trung gian, không cần thay đổi code của lớp có sẵn cũng như lớp đang viết. Adapter Pattern còn gọi là Wrapper Pattern do cung cấp một giao diện “bọc ngoài” tương thích cho một hệ thống có sẵn, có dữ liệu và hành vi phù hợp nhưng có giao diện không tương thích với lớp đang viết.
-Minh hoạ:
package refactoring_guru.adapter.example;
	

	import refactoring_guru.adapter.example.adapters.SquarePegAdapter;
	import refactoring_guru.adapter.example.round.RoundHole;
	import refactoring_guru.adapter.example.round.RoundPeg;
	import refactoring_guru.adapter.example.square.SquarePeg;
	

	/**
	 * EN: Somewhere in client code...
	 *
	 * RU: Где-то в клиентском коде...
	 */
	public class Demo {
	    public static void main(String[] args) {
	        // EN: Round fits round, no surprise.
	        //
	        // RU: Круглое к круглому — всё работает.
	        RoundHole hole = new RoundHole(5);
	        RoundPeg rpeg = new RoundPeg(5);
	        if (hole.fits(rpeg)) {
	            System.out.println("Round peg r5 fits round hole r5.");
	        }
	

	        SquarePeg smallSqPeg = new SquarePeg(2);
	        SquarePeg largeSqPeg = new SquarePeg(20);
	        // EN: hole.fits(smallSqPeg); // Won't compile.
	        //
	        // RU: hole.fits(smallSqPeg); // Не скомпилируется.
	

	        // EN: Adapter solves the problem.
	        //
	        // RU: Адаптер решит проблему.
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
- So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 3. Bridge Pattern:
Là một mẫu thiết kế cấu trúc cho phép bạn chia một lớp lớn hoặc một tập hợp các lớp có liên quan chặt chẽ thành hai phân cấp riêng biệt — trừu tượng và thực thi — có thể được phát triển độc lập với nhau. Bridge pattern được sử dụng khi chúng ta muốn tách một abtraction từ implementation của nó để cả hai có thể thay đổi một cách độc lập với nhau. Bridge Pattern là một mẫu cấu trúc (Structural Pattern)
Minh hoạ:
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
So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 4. Builder pattern:
- Là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và hình ảnh đại diện khác nhau của một đối tượng bằng cách sử dụng cùng một mã xây dựng.
Minh hoạ:
package refactoring_guru.builder.example;
	

	import refactoring_guru.builder.example.builders.CarBuilder;
	import refactoring_guru.builder.example.builders.CarManualBuilder;
	import refactoring_guru.builder.example.cars.Car;
	import refactoring_guru.builder.example.cars.Manual;
	import refactoring_guru.builder.example.director.Director;
	

	/**
	 * EN: Demo class. Everything comes together here.
	 *
	 * RU: Демо-класс. Здесь всё сводится воедино.
	 */
	public class Demo {
	

	    public static void main(String[] args) {
	        Director director = new Director();
	

	        // EN: Director gets the concrete builder object from the client
	        // (application code). That's because application knows better which
	        // builder to use to get a specific product.
	        //
	        // RU: Директор получает объект конкретного строителя от клиента
	        // (приложения). Приложение само знает какой строитель использовать,
	        // чтобы получить нужный продукт.
	        CarBuilder builder = new CarBuilder();
	        director.constructSportsCar(builder);
	

	        // EN: The final product is often retrieved from a builder object, since
	        // Director is not aware and not dependent on concrete builders and
	        // products.
	        //
	        // RU: Готовый продукт возвращает строитель, так как Директор чаще всего
	        // не знает и не зависит от конкретных классов строителей и продуктов.
	        Car car = builder.getResult();
	        System.out.println("Car built:\n" + car.getCarType());
	

	

	        CarManualBuilder manualBuilder = new CarManualBuilder();
	

	        // EN: Director may know several building recipes.
	        //
	        // RU: Директор может знать больше одного рецепта строительства.
	        director.constructSportsCar(manualBuilder);
	        Manual carManual = manualBuilder.getResult();
	        System.out.println("\nCar manual built:\n" + carManual.print());
	    }
	

	}
-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 5. Factory Method Pattern
 - Là một mẫu thiết kế sáng tạo cung cấp mục đích khởi tạo một đối tượng mới mà không cần thiết phải chỉ ra một cách chính xác class nào sẽ được khởi tạo. Factory Method Pattern giải quyết vấn đề này bằng cách định nghĩa một factory method cho việc tạo đối tượng, và các lớp con thừa kế có thể override phương thức này để chỉ rõ đối tượng nào sẽ được khởi tạo.
Minh hoạ:
package refactoring_guru.factory_method.example;
	

	import refactoring_guru.factory_method.example.factory.Dialog;
	import refactoring_guru.factory_method.example.factory.HtmlDialog;
	import refactoring_guru.factory_method.example.factory.WindowsDialog;
	

	/**
	 * EN: Demo class. Everything comes together here.
	 *
	 * RU: Демо-класс. Здесь всё сводится воедино.
	 */
	public class Demo {
	    private static Dialog dialog;
	

	    public static void main(String[] args) {
	        configure();
	        runBusinessLogic();
	    }
	

	    /**
	     * EN: The concrete factory is usually chosen depending on configuration or
	     * environment options.
	     *
	     * RU: Приложение создаёт определённую фабрику в зависимости от конфигурации
	     * или окружения.
	     */
	    static void configure() {
	        if (System.getProperty("os.name").equals("Windows 10")) {
	            dialog = new WindowsDialog();
	        } else {
	            dialog = new HtmlDialog();
	        }
	    }
	

	    /**
	     * EN: All of the client code should work with factories and products
	     * through abstract interfaces. This way it does not care which factory it
	     * works with and what kind of product it returns.
	     *
	     * RU: Весь остальной клиентский код работает с фабрикой и продуктами только
	     * через общий интерфейс, поэтому для него неважно какая фабрика была
	     * создана.
	     */
	    static void runBusinessLogic() {
	        dialog.renderWindow();
	    }
	}
So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 6. Facade Pattern:
-Là một mẫu thiết kế sáng tạo cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo. Facade Pattern cung cấp một interface đơn giản và cao cấp nhất cho phía client (máy khách) và cho phép nó truy cập vào hệ thống mà không cần biết bên trong có logic hệ thống nào hay nó hoạt động như thế nào.
-Minh hoạ: 
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
-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 7. Prototype pattern:
-Là một Design Pattern được sử dụng chủ yếu để giảm chi phí khi tạo object. Thường là khi các ứng dụng quy mô lớn tạo, cập nhật hoặc truy xuất các đối tượng tốn nhiều tài nguyên. Điều này được thực hiện bằng cách sao chép object, nó được tạo và sử dụng lại bản sao của object trong các yêu cầu ở phía sau khi có, để tránh thực hiện một hoạt động tốn tài nguyên khác.
-Minh hoạ:
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
-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 8. Chain_of_responsibility:
-Là một mẫu thiết kế hành vi bao gồm một nguồn các đối tượng lệnh và một loạt các đối tượng xử lý. Mỗi đối tượng xử lý chứa logic xác định các loại đối tượng lệnh mà nó có thể xử lý, phần còn lại được chuyển cho đối tượng xử lý tiếp theo trong chuỗi.
-Minh hoạ:
package refactoring_guru.chain_of_responsibility.example;
	

	import refactoring_guru.chain_of_responsibility.example.middleware.Middleware;
	import refactoring_guru.chain_of_responsibility.example.middleware.RoleCheckMiddleware;
	import refactoring_guru.chain_of_responsibility.example.middleware.ThrottlingMiddleware;
	import refactoring_guru.chain_of_responsibility.example.middleware.UserExistsMiddleware;
	import refactoring_guru.chain_of_responsibility.example.server.Server;
	

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	

	/**
	 * EN: Demo class. Everything comes together here.
	 *
	 * RU: Демо-класс. Здесь всё сводится воедино.
	 */
	public class Demo {
	    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    private static Server server;
	

	    private static void init() {
	        server = new Server();
	        server.register("admin@example.com", "admin_pass");
	        server.register("user@example.com", "user_pass");
	

	        // EN: All checks are linked. Client can build various chains using the
	        // same components.
	        //
	        // RU: Проверки связаны в одну цепь. Клиент может строить различные
	        // цепи, используя одни и те же компоненты.
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
-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 9. Command Pattern:
-Là một mẫu thiết kế hành vi biến một yêu cầu thành một đối tượng độc lập chứa tất cả thông tin về yêu cầu. Sự chuyển đổi này cho phép bạn chuyển các yêu cầu dưới dạng đối số của phương thức, trì hoãn hoặc xếp hàng đợi việc thực hiện một yêu cầu và hỗ trợ các hoạt động hoàn tác.
Minh hoạ:
package refactoring_guru.command.example;
	

	import refactoring_guru.command.example.editor.Editor;
	

	public class Demo {
	    public static void main(String[] args) {
	        Editor editor = new Editor();
	        editor.init();
	    }
	}
-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 10. Composite:
-Là một mẫu thiết kế thuộc nhóm Structural Pattern. Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.
-Minh hoạ:
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
-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 11. Decorator Pattern:
-Là một mẫu thiết kế cấu trúc cho phép bạn đính kèm các hành vi mới vào các đối tượng bằng cách đặt các đối tượng này bên trong các đối tượng trình bao bọc đặc biệt có chứa các hành vi.
Minh hoạ: 
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
-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.

## 12. Flyweight Pattern:
-Là một mẫu thiết kế cấu trúc cho phép bạn lắp nhiều đối tượng hơn vào dung lượng RAM có sẵn bằng cách chia sẻ các phần trạng thái chung giữa nhiều đối tượng thay vì giữ tất cả dữ liệu trong mỗi đối tượng.
-Minh hoạ:
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

-So sánh:
Giống nhau: Giống với mẫu chuẩn.
Khác nhau: Không có sự khác nhau.




