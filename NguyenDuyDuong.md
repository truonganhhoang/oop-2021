 # BÁO CÁO TÌM HIỂU VỀ 23 MẪU  ThIẾT KẾ
 ## Lớp: INT2204 3
 ## Thành viên: 
*Nguyễn Duy Đường - 19020266


## Adapter
Được sử dụng trong [AdaptePattern.](https://github.com/abishekaditya/DesignPatterns/tree/master/AdapterPattern)
Các client interface:
IDuck.cs:
```
	public interface IDuck
    {
        void Quack();
        void Fly();
    }
```

ITurkey.cs:
```
public interface ITurkey
    {
        void Gobble();
        void Fly();
    }
```
Method Tester trong class Program.cs tương ứng là methodService.
```
private static void Tester(IDuck duck)
    {
        duck.Fly();
        duck.Quack();
    }
```

Môt instance của ITukey muốn sử dụng Tester phải chuyển đổi sang IDuck thông qua class TurkeyAdapter:
```
    public class TurkeyAdapter : IDuck
    {
    ...
        public void Quack()
        {
             ...
        }

        public void Fly()
        {
            ...
        }
    }
```
Ví dụ với 2 client WildTurkey và TurkeyAdapter

```
    private static void Main()
    {
        var turkey = new WildTurkey();
        var adapter = new TurkeyAdapter(turkey);

        Tester(adapter);
    }
```

Kết luận: hoàn toàn tương đồng so với mẫu thiết kế Adapte, sử dụng adapter để chuyển đổi một instance để phù hợp với service;

##Bridge
Được sử dụng trong [BridgePattern.](https://github.com/abishekaditya/DesignPatterns/tree/master/BridgePattern)
Các implementation gồm IEnchantment và IWeapon:
```
    public interface IEnchantment
    {
        void OnActivate();
        void Apply();
        void OnDeactivate();
    }
  
    public interface IWeapon
    {
        void Wield();
        void Swing();
        void Unwield();
        IEnchantment GetEnchantment();
    }
```
Các instance của IEnchantment: SoulEatingEnchantment FlyingEnchantment.
Các instance của IWeapon: Sword, Hammer.

Author đã sử dụng 2 bridge để quán lý 2 thể loại vũ khí là bùa mê (Enchantment) và vũ khí vật lý (Weapon). Các intance sẽ cho biết cách sử dụng và hiệu ứng của từng loại. Giống với mẫu Brigde

Điểm khác: Author có kết hợp sử dụng thêm mẫu Adapter để chuyển đổi IWeapon sang IEnchantment.
```
    public interface IWeapon
    {
        ...
        IEnchantment GetEnchantment();
    }
```

##Composite

Được sử dụng trong [CompositePattern.](https://github.com/abishekaditya/DesignPatterns/tree/master/CompositePattern)

Lớp cha MenuComponent gồm các leaf Menu, MenuIteam và Composite là Client

Ví dụ trong program.cs, Client sử dụng các instance của MenuComponent để quản lý bữa ăn (sửa dụng Menu) và thực đơn trong bữa ăn (MenuIteam).

```
static class Program
    {
        public static void Main()
        {

            var breakfast = new Menu("Breakfast", "Pancake House");
            var lunch = new Menu("Lunch", "Deli Diner");
            var dinner = new Menu("Dinner", "Dinneroni");

            var dessert = new Menu("Dessert", "Ice Cream");

            var menu = new Menu("All", "McDonalds");

            breakfast.Add(new MenuItem("Waffles", "Butterscotch waffles", 140, false));
            breakfast.Add(new MenuItem("Corn Flakes", "Kellogs", 80, true));

            lunch.Add(new MenuItem("Burger", "Cheese and Onion Burger", 250, true));
            lunch.Add(new MenuItem("Sandwich", "Chicken Sandwich", 280, false));

            dinner.Add(new MenuItem("Pizza", "Cheese and Tomato Pizza", 210, true));
            dinner.Add(new MenuItem("Pasta", "Chicken Pasta", 280, false));

            dessert.Add(new MenuItem("Ice Cream", "Vanilla and Chocolate", 120, true));
            dessert.Add(new MenuItem("Cake", "Choclate Cake Slice", 180, false));

            dinner.Add(dessert);
            menu.Add(breakfast);
            menu.Add(lunch);
            menu.Add(dinner);

            menu.Print();
        }
    }
```

Kết luận: Sử dụng mẫu Composite để quản lý các loại Menu, cây tạo ra đơn giản dễ hiểu và hiệu quả.


## Facade

Được dùng tại [FacadePattern.](https://github.com/abishekaditya/DesignPatterns/tree/master/FacadePattern)
**Facade** tương ứng với class *HomeTheatreFacade* được dùng để ... gồm các **Subsystem class** : *Dimmer*, *Dvd* và *DvdPlayer*. Với Dimmer quản lý độ sáng của màn hình, Dvd quản lý các moive, DvdPlayer quản lý các tác vụ điều khiển khi xem phim (ví dụ bật, dừng phim).

Kết luận: Author đã sử dụng mẫu Facade để thiết kế các class quản lý từng tác vụ được quản lý chung bới class *HomeTheatreFacade* khi đó Client chỉ cần thao tác với *HomeTheatreFacade* để sử dụng các chứ năng được cung cấp bởi tất cả các subsystem.
Ví dụ trong program.cs:
```
    internal static class Program
    {
        private static void Main()
        {
            var dimmer = new Dimmer();
            var dvdPlayer = new DvdPlayer();
            var dvd = new Dvd("Gone with the Wind 2 : Electric Bugaloo");
            var homeTheater = new HomeTheatreFacade(dimmer, dvd, dvdPlayer);

            homeTheater.WatchMovie();
            Console.WriteLine();
            homeTheater.Pause();
            Console.WriteLine();
            homeTheater.Resume();
            Console.WriteLine();
            homeTheater.Pause();
        }
    }
```

## Decorator
Được sử dụng tại [DecoratorPattern](https://github.com/abishekaditya/DesignPatterns/tree/master/DecoratorPattern)

**Component** tương ứng là abstract class *Beverage* khai báo các method chung cho quá trình bao bọc (Mix đồ uống - Description và giá thành - Cost) và đối tượng là đồ uống:

```
    abstract class Beverage
    {
        protected string _description = "No Description";
        public abstract string Description { get; }
        public abstract double Cost();
    }
```
Các **Concrete Component** là các class Espresso, DrakRoast, HouseBlend. Là các đối tượng đồ uống xác định.
ví dụ Espresso.cs
```
class Espresso : Beverage
    {
        public Espresso()
        {
            _description = "Espresso";
        }

        public override string Description => _description;

        public override double Cost()
        {
            return 1.99;
        }
    }
```

**Base Decorator** tương ứng là *Condiment Decorator* có các **Concrete Decorator** tương ứng là  *MochaCondiment*  *WhipCondiment* quản lý việc bổ sung các loại condiment cho đồ uống. 

Điểm khác: Component được sử dụng là abstract class thay vì interface như trong mẫu.

## Flyweight
Được sử dụng tại [FlyweightPattern](https://github.com/abishekaditya/DesignPatterns/tree/master/FlyweightPattern)

IBeverage  OolingMilkTea FoamMilkTea CoconutMilkTea BubbleMilkTea 

**Flyweight Factory** tương ứng là class *BubbleTeaShop* đại diện cho một cửa hàng đồ uống quản lý các loại đồ uống - Enumerate(), các hóa đơn - TakeOrders():
```
    private void TakeOrders()
        {
            var factory = new BeverageFlyweightFactory();

            takeAwayOrders.Add(factory.MakeBeverage(BeverageType.BubbleMilk));
            takeAwayOrders.Add(factory.MakeBeverage(BeverageType.BubbleMilk));
            takeAwayOrders.Add(factory.MakeBeverage(BeverageType.CoconutMilk));
            takeAwayOrders.Add(factory.MakeBeverage(BeverageType.FoamMilk));
            takeAwayOrders.Add(factory.MakeBeverage(BeverageType.OolongMilk));
            takeAwayOrders.Add(factory.MakeBeverage(BeverageType.OolongMilk));
        }

        public void Enumerate()
        {
            Console.WriteLine("Enumerating take away orders\n");
            foreach (var beverage in takeAwayOrders)
            {
                beverage.Drink();
            }
        }
```
Có 4 loại đồ uống có khác nhau tương ứng với 4 **Context** :  *BubbleMilk, FoamMilk, OolongMilk, CoconutMilk* có **Flyweight** là *IBeverage*.

Kết luận: Tương đồng với mẫu thiết ké nhưng chưa thể hiện rõ các repeatingState và uniquaState.

## Proxy
Được sử dụng tại [ProxyPattern](https://github.com/abishekaditya/DesignPatterns/tree/master/ProxyPattern)

**Service** là RealImg
```
    public class RealImage : Image
    {

        private string _fileName;

        public RealImage(string fileName)
        {
            _fileName = fileName;
            loadFromDisk(_fileName);
        }

        public void display()
        {
            Console.WriteLine("Displaying " + _fileName);
        }

        private void loadFromDisk(string fileName)
        {
            Console.WriteLine("Loading " + fileName);
        }
    }
```
**Service Interface** tương ứng là class Image cung cấp service display() của class RealImg. Và **Proxy** tương ứng là ProxyImg tham chiếu đến display().
```
    public class ProxyImage : Image
    {
    ...
        public void display()
        {
            if (_realImage == null)
            {
                _realImage = new RealImage(_fileName);
            }
            _realImage.display();
        }
    }
```
Kết luận: hoàn toàn tương đồng với mẫu thiết kế, không có sự khác biệt









