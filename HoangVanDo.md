# 1. Creational Patterns
## 1.1 Abstract Factory
- Là một mẫu thiết kế sáng tạo cho phép bạn tạo ra các họ các đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng.
- Code: [Abstract Factory](https://github.com/abishekaditya/DesignPatterns/tree/master/FactoryPattern/Abstract%20Factory)
- Ở đây, cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng, 2 class được khai báo theo mẫu chuẩn.
```
internal class ChicagoIngredientsFactory : IIngredientsFactory
internal class NyIngredientsFactory : IIngredientsFactory
```

## 1.2 Factory Method
- Là một mẫu thiết kế sáng tạo cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo.
- Code: [Factory Method](https://github.com/abishekaditya/DesignPatterns/tree/master/FactoryPattern/Factory%20Method)
- Lớp tạo khai báo phương thức gốc phải trả về một đối tượng của một lớp sản phẩm. Các lớp con ChicagoPizzaFactory, NyPizzaFactory cung cấp việc triển khai phương thức này.
```
abstract class PizzaFactory
    {
        public Pizza Order(string type) {}
        protected abstract Pizza Create(string type);
    }
class ChicagoPizzaFactory : PizzaFactory
    {
        protected override Pizza Create(string type) {}
    }
class NyPizzaFactory : PizzaFactory
    {
        protected override Pizza Create(string type) {}
    }
```
## 1.3 Builder
- Builder là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và hình ảnh đại diện khác nhau của một đối tượng bằng cách sử dụng cùng một mã xây dựng.
- Code: [Builder](https://github.com/abishekaditya/DesignPatterns/tree/master/BuilderPattern)
- Khởi tạo interface IBuilder:
```
public interface IBuilder
    {
        void AddIngredients();
        void AddShape();
        void AddSize();
        void Reset();
        Hamburger Build();
    }
```
- Các lớp MyHamburgerBuilder, WifesHamburgerBuilder kế thừa các thuộc tính trong lớp IBuilder. Tách tiến trình xây dựng 1 đối tượng phức tạp sao cho một tiến trình tạo được các biểu diễn khác nhau 
=> Builder Design Pattern
## 1.4 Prototype Pattern
- Prototype là một mẫu thiết kế sáng tạo cho phép bạn sao chép các đối tượng hiện có mà không làm cho mã của bạn phụ thuộc vào các lớp của chúng.
- Code: [Prototype Pattern](https://github.com/abishekaditya/DesignPatterns/tree/master/PrototypePattern)
- Khởi tạo `interface IFigure : ICloneable` dùng làm đối tượng mẫu để quy định các loại đối tượng của lớp Circle và Rectangle, hai lớp đó kế thừa lớp IFigure. Tất cả các lớp sau tuân theo cùng một interface, cung cấp một phương thức clone().
```
interface IFigure : ICloneable
    {}
class Circle : IFigure
    {
        public object Clone()
        {
            return new Circle(_radius);
        }
    }
class Rectangle : IFigure
    {
        public object Clone()
        {
            return new Rectangle(_width, _height);
        }
    }
 ```
 - Giống với mẫu chuẩn trong [Prototype Pattern](https://refactoring.guru/design-patterns/prototype)
 
 ## 1.5 Singleton
 - Singleton cho phép đảm bảo rằng một lớp chỉ có một thể hiện, đồng thời cung cấp một điểm truy cập toàn cục cho thể hiện này.
 - Code: [Singleton](https://github.com/abishekaditya/DesignPatterns/tree/master/SingletonPattern)
 - Class `ChocolateBoiler` được khởi tạo là `internal partial class ChocolateBoiler`, bên trong là phương thức khởi tạo tĩnh và phương thức khởi tạo private.
 ```
 internal partial class ChocolateBoiler
    {
        private static readonly Lazy<ChocolateBoiler> _singleton = new Lazy<ChocolateBoiler>(() => new ChocolateBoiler());

        public static ChocolateBoiler GetInstance() => _singleton.Value;

        private Status _boiler;

        private ChocolateBoiler()
        {
            Console.WriteLine("Starting");
            _boiler = Status.Empty;
        }

        public void Fill() {}

        public void Drain() {}

        public void Boil() {}

        private bool IsEmpty => (_boiler == Status.Empty);

        private bool IsBoiled => (_boiler == Status.Boiled);
    }
 ```
 - Giống với mẫu chuẩn trong [Singleton](https://refactoring.guru/design-patterns/singleton)
 
 # 2. Behavioral Patterns
 ## 2.1 Chain of Responsibility
 - cho phép chuyển các yêu cầu dọc theo một chuỗi các trình xử lý. Khi nhận được yêu cầu, mỗi trình xử lý sẽ quyết định xử lý yêu cầu hoặc chuyển nó cho trình xử lý tiếp theo trong chuỗi.
 - Code: [Chain of Responsibility](https://github.com/abishekaditya/DesignPatterns/tree/master/ChainOfResponsibilityPattern)
 ```
 // Giao diện trình xử lý khai báo một phương pháp để xây dựng một chuỗi trình xử lý. Nó cũng khai báo phương thức để thực hiện một yêu cầu.
public interface IHandler {
        void AddChain(IHandler handler);
        double Handle(double[] values, string action);
    }
    
// The base class for simple components.
public abstract class BaseHandler : IHandler {
        public void AddChain(IHandler handler) {
            _nextInLine = handler;    
        }

        public abstract double Handle(double[] values, string action);
    }
    
// Các mối quan hệ dây chuyền được thành lập. Class kế thừa override Handler từ cha nó.
public class AdditionHandler : BaseHandler {
        public override double Handle(double[] values, string action) {}
public class MultiplicationHandler : BaseHandler {
        public override double Handle(double[] values, string action) {}
```
- Không có sự thay đổi so với mẫu chuẩn [Chain of Responsibility](https://refactoring.guru/design-patterns/chain-of-responsibility)

## 2.2 Command
- Command biến một yêu cầu thành một đối tượng độc lập chứa tất cả thông tin về yêu cầu. Sự chuyển đổi này cho phép bạn chuyển các yêu cầu dưới dạng đối số của phương thức, trì hoãn hoặc xếp hàng đợi việc thực hiện một yêu cầu và hỗ trợ các hoạt động hoàn tác.
- Code: 
- The base command class xác định giao diện chung cho các concrete commands.
```
internal interface ICommand
    {
        void Execute();
        void Undo();
    }
```
- The concrete commands:
```
internal class GarageDoorCloseCommand : ICommand
    {
        public GarageDoorCloseCommand(Garage g) {...}
        public void Execute() {}
        public void Undo() {}
    }
internal class GarageDoorOpenCommand : ICommand
    {
        public GarageDoorOpenCommand(Garage g) {...}
        public void Execute() {}
        public void Undo() {}
    }
v.v.....
```
- Tất cả các class GarageDoorCloseCommand, GarageDoorOpenCommand, LightOffCommand, LightOnCommand, MacroCommand, NoCommand, .... đều đưuọc xác định từ ICommand nhưng là những đối tượng độc lập, chứa các yêu cầu Execute(), Undo().
- Không có thay đổi so với mẫu chuẩn [Command](https://refactoring.guru/design-patterns/command)
