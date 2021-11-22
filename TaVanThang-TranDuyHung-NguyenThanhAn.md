# Báo cáo tìm hiểu về mẫu thiết kế
## Thành viên: Họ và tên - MSSV
## 1. Tạ Văn Thắng - 20021440
## 2. Trần Duy Hưng - 20021371
## 3. Nguyễn Thành An - 20021280
### **Cách thức thực hiện bài báo cáo**: Mỗi thành viên làm phần bài báo cáo của mình rồi commit vào reposition của nhóm ([Link reposition của nhóm](https://github.com/Thang12321/BT_OOP_DesignPattern)), bạn Tạ Văn Thắng tổng hợp và sắp xếp phần báo cáo của các thành viên vào file báo cáo của nhóm.
- **[Link đến phần nội dung lý thuyết tham khảo](https://gpcoder.com/4164-gioi-thieu-design-patterns/)**
- **[Link đến reposition được sử dụng trong bài báo cáo](https://github.com/bethrobson/Head-First-Design-Patterns)**
## Sau khi tìm hiểu về mẫu thiết kế được sử dụng trong mã nguồn của dự án nêu trên, nhóm đã hoàn thành được bản báo cáo như sau: ##

+ Trong folder Factory:
- file CoinFactory.java chứa lớp CoinFactory thực chất là một lớp Factory hỗ trợ việc việc khởi tạo các các đối tượng thuộc các lớp Coin khác nhau nhằm che giấu việc phương thức khởi tạo và thống nhất việc khởi tạo các đối tượng cụ thể thuộc các lớp như CopperCoin, GoldCoin đều implements 1 interface là Coin
```
	public class CoinFactory{
		public static Coin getCoin(CoinType type)

	}
```
- mặc dù tác giả của project gán static cho method getCoin nhưng không bắt buộc; tác dụng không phải khởi tạo factory trong khi vẫn có thể sử dụng tính năng trả về đối tượng nhằm khởi tạo chúng được
dưới đây là một ví dụ khác về factory:
```
	public abstract class Shape{
		String color;
	}
	public class Square extends Shape {
		public Square(){}
	}
	public shapeFactory{
		public Shape getShape(String shapeType) {
			if(shapeType.equals("SQUARE")
				return new Square();
```
+ Trong folder AbstractFactory:
- Trước khi xem xét project của tác giả thì ta phải lí giải được thế nào Abstract Factory. Abstract Factory là Factory của Factory nghĩa là 1 cái Factory tổng cho phép trả về các Factory con nhằm che giấu việc khởi tạo các factory con. Bổ sung ví dụ vào bài factory của tác giả nếu ta có Coin Factory cho phép sinh ra các loại coin thì ta có thể có thêm CashFactory sinh ra các loại cash tiền mặt khi đó ta có thể tạo một moneyFactory sinh ra cả 2 loại factory đó.
- Trong project trên git thì abstractFactory là FactoryMaker và các Factory là ElfKingdomFactory và  OrcKingdomFactory -> đây chính là 2 Factor giống như CoinFactory ở ví dụ trên.
	public static KingdomFactory makeFactory(KingdomType type)
-> đây là phương thức cho phép sinh ra các Factory.
```
	public static class FactoryMaker {
		public enum KingdomType {
    			ELF, ORC
  	}

	public static KingdomFactory makeFactory(KingdomType type) {
    		switch (type) {
      			case ELF:
        		return new ElfKingdomFactory(); 
			// khởi tạo đối tượng thuộc ElfKingdomFactory nếu truyền vào ELF VD: KingdomFactory Elf_kd = FactoryMaker.makeFactory(KingdomType.ELF).
      			case ORC:
       			return new OrcKingdomFactory(); 
			// khởi tạo đối tượng thuộc OrcKingdomFactory nếu truyền vào ORC giống vd trên.
      		default:
        		throw new IllegalArgumentException("KingdomType not supported.");
    }
  }
}
```
+ Trong folder Bridge:
- Tóm tắt về mẫu thiết kế Bridge trước khi đi vào phân tích project: đây là mẫu thiết kế cho phép tách phần thực thi và phần trừu tượng để chúng khác nhau độc lập; làm cho các lớp cụ thể độc lập với các lớp thực thi interface.
- Ví dụ: có nhiều chiếc máy tính và nhiều chip cpu nếu tạo ra từng bản sao cụ thể của từng máy tính khác nhau gắn với từng cpu khác nhau rất tốn thời gian thay vào đó có thể tạo ra một đối tượng duy nhất thay đổi hiệu năng với các loại cpu gắn vào.
- mẫu bridge trên Git: nếu bạn chơi game rồi thì sẽ biết trong game có các loại bùa(enchantment: FlyingEnchantment & SoulEatingEnchantment) với các hiệu quả khác nhau cùng với vô số loại vũ khí(weapon) cụ thể là class Hammer và class Sword giả sử có hàng trăm các loại bùa khác nhau thì việc tạo hằng trăm method của từng weapon gắn với các loại bùa là không khôn ngoan.
- tóm tắt mẫu bridge của project:
```
	public interface Weapon {
  		void wield();

  		void swing();

  		void unwield();

  		Enchantment getEnchantment();
	}
	public class Sword implements Weapon {
  		private final Enchantment enchantment;
  			
		public Sword(Enchantment enchantment) {
    			this.enchantment = enchantment;
  		}
		...........
		@Override
  		public Enchantment getEnchantment() {
    			return enchantment;
  		}
	}
```
-> sự thay đổi của bùa chú (enchantment) từ phương thức khởi tạo sẽ dẫn đến thay đổi trong method getgetEnchantment mà không phải tạo ra các method với từng loại bùa nếu thay đổi method thành trả về tác dụng của bùa thì sẽ thay đổi với từng loại bùa mà không phải tạo ra vô số các method tương ứng với từng loại bùa xong lại phải xét để thực hiện phương thức ứng với loại bùa đã cho.
+ Trong folder Facade:
- Mẫu thiết kế Facade che giấu độ phức tạp của hệ thống mà vẫn cung cấp được giao diện cho khách hàng truy cập hệ thống. Liên quan đến một lớp duy nhất có các phương thức đơn giản hóa.
```
	public abstract class DwarvenMineWorker {
 		public void goToSleep() {
		}

		public void wakeUp() {
  		}

		public void goHome() {
		}

		public void goToMine() {
  		}
	}
```
```	
	public class DwarvenTunnelDigger extends DwarvenMineWorker {
		..................
	}
	
	public class DwarvenGoldDigger extends DwarvenMineWorker {
		..................
	}
	
	public class DwarvenCartOperator extends DwarvenMineWorker {
		..................
	}
```
```
	public class DwarvenGoldmineFacade {
		workers = List.of(
            		new DwarvenGoldDigger(),
            		new DwarvenCartOperator(),
            		new DwarvenTunnelDigger());
  		}		

		public void startNewDay() {
    			makeActions(workers, DwarvenMineWorker.Action.WAKE_UP, DwarvenMineWorker.Action.GO_TO_MINE);
  		}

  		public void digOutGold() {
    			makeActions(workers, DwarvenMineWorker.Action.WORK);
  		}

		public void endDay() {
    			makeActions(workers, DwarvenMineWorker.Action.GO_HOME, DwarvenMineWorker.Action.GO_TO_SLEEP);
  		}

		private static void makeActions(Collection<DwarvenMineWorker> workers,
      			DwarvenMineWorker.Action... actions) {
		}
	}
```
- cung cấp một mẫu giao diện đơn giản cho khách hàng là lớp DwarvenGoldmineFacade có thể thống nhất là do có sự tương đồng về 1 số phương thức của các lớp DwarvenTunnelDigger, DwarvenGoldDigger, DwarvenCartOperator được thừa kế từ abstract class DwarvenMineWorker. nên có thể tạo ra 1 lớp chung để sử lí các hành động này 
+ Trong folder state:
- Mẫu thiết kế State cho phép đối tượng thay đổi hành vi khi trạng thái của chúng thay đổi.
- Ví dụ trên gitHub thể hiện mẫu trạng thái State bằng việc diễn tả hành động của voi ma mút thay đổi theo các trạng thái khác nhau.
```
public interface State {

  void onEnterState();

  void observe();
}

public class PeacefulState implements State {

  private final Mammoth mammoth;

  public PeacefulState(Mammoth mammoth) {
    this.mammoth = mammoth;
  }

  @Override
  public void observe() {
    LOGGER.info("{} is calm and peaceful.", mammoth);
  }

  @Override
  public void onEnterState() {
    LOGGER.info("{} calms down.", mammoth);
  }
}

public class AngryState implements State {

  private final Mammoth mammoth;

  public AngryState(Mammoth mammoth) {
    this.mammoth = mammoth;
  }

  @Override
  public void observe() {
    LOGGER.info("{} is furious!", mammoth);
  }

  @Override
  public void onEnterState() {
    LOGGER.info("{} gets angry!", mammoth);
  }
}
```
- lúc này nếu khởi tạo PeacefulState với một con mammoth thì trạng thái của nó sẽ là bình yên còn khi chuyển sang AngryState thì nó sẽ có các phương thức observe và onEnterState tương ứng.
```
public class Mammoth {

  private State state;

  public Mammoth() {
    state = new PeacefulState(this);
  }

  public void timePasses() {
    if (state.getClass().equals(PeacefulState.class)) {
      changeStateTo(new AngryState(this));
    } else {
      changeStateTo(new PeacefulState(this));
    }
  }

  private void changeStateTo(State newState) {
    this.state = newState;
    this.state.onEnterState();
  }
}
```
- quan sát các phương thức class Mammoth thì ta thấy mammoth sẽ được khởi tạo với trạng thái PeacefulState timePasses sẽ là phương thức thay đổi trạng thái của mammoth sang trạng thái còn lại và phương thức changState chính là  phương thức thực hiện sự thay đổi đấy 
-> kiểu thiết kế này nên được sử với các đối tượng có hành vi thay đổi theo trạng thái, và thay đổi hành vi theo thời gian chạy tùy thuộc vào các trạng thái.
+ Trong folder template method:
- Trong mẫu thiết kế template thuộc về mẫu thiết kế hành vi. Có lớp trừu tượng đã xác định sẵn khung cho lớp con, có thể ghi đè nhưng không được phép thay đổi lời gọi.
```
public abstract class StealingMethod {

  protected abstract String pickTarget();

  protected abstract void confuseTarget(String target);

  protected abstract void stealTheItem(String target);

  public void steal() {
    var target = pickTarget();
    LOGGER.info("The target has been chosen as {}.", target);
    confuseTarget(target);
    stealTheItem(target);
  }
}
```
-> đây chính là lớp trừu tượng mà tôi muốn nói đến xác định sẵn các bước trộm đồ của một tên trộm, chúng có thể có nhiều cách trộm nhưng các cách đấy vẫn sẽ là tập hợp của những bước cơ bản trên (được thể hiện trong steal).
```
public class SubtleMethod extends StealingMethod {

  @Override
  protected String pickTarget() {
    return "shop keeper";
  }

  @Override
  protected void confuseTarget(String target) {
    LOGGER.info("Approach the {} with tears running and hug him!", target);
  }

  @Override
  protected void stealTheItem(String target) {
    LOGGER.info("While in close contact grab the {}'s wallet.", target);
  }
}
 
public class HitAndRunMethod extends StealingMethod {

  @Override
  protected String pickTarget() {
    return "old goblin woman";
  }

  @Override
  protected void confuseTarget(String target) {
    LOGGER.info("Approach the {} from behind.", target);
  }

  @Override
  protected void stealTheItem(String target) {
    LOGGER.info("Grab the handbag and run away fast!");
  }
}
```
- 2 phương thức SubtleMethod và HitAndRunMethod khác nhau nhưng lời gọi hàm là giống nhau đã được xác định sẵn trong StealingMethod.
- Mẫu thiết kế khung(template) Để triển khai các phần bất biến của thuật toán một lần và để nó cho các lớp con để triển khai hành vi có thể thay đổi

- Trong folder Buider:
+ Trong HouseBuilder.java khởi tạo lớp abstract HouseBuilder có chứa các phương thức abstract sử dụng mẫu thiết kế Fluent Interface Pattern trả về chính HouseBuider
```
  public abstract HouseBuilder addWalls();
  
  public abstract HouseBuilder addRoof();
  
  public abstract HouseBuilder addWindows();
 ``` 
+ Các lớp WoodHouseBuilder, StoneHouseBuilder, GingerbreadHouseBuilder kế thừa các thuộc tính trong lớp abstract HouseBuilder
=> Tách tiến trình xây dựng 1 đối tượng phức tạp sao cho một tiến trình tạo được các biểu diễn khác nhau => Builder Design Pattern

- Trong folder Adapter:
+ Trong DuckAdapter.java có 2 hàm quack() và fly(), các lớp Turkey và Drone implements lớp Duck và thay đổi 2 hàm quack() và fly() cho phù hợp
 Ví dụ:
 Trong Duck:
 ```
 public interface Duck {
	public void quack();
	public void fly();
}
```
Trong  DuckAdapter:
```
	public void gobble() {
		duck.quack();
	}
	public void fly() {
		if (rand.nextInt(5)  == 0) {
		     duck.fly();
		}
	}
```
Trong Drone:
 ```
      public void quack() {
  		  drone.beep();
  	  }
  	  public void fly() {
  		  drone.spin_rotors();
  		  drone.take_off();
  	  }
  ```
=> Sử dụng mẫu thiết kế Adapter.

- Trong folder Prototype:
+ File Monster.java khởi tạo lớp Monster, lớp này được dùng làm đối tượng mẫu để quy định các loại đối tượng của lớp Dragon, Drakon. 2 lớp này kế thừa lớp Monster và tạo mới nhờ sao chép đối tượng mẫu
Trong Dragon.java và Drakon.java đều chứa:

```
	public Monster copy() throws CloneNotSupportedException {
		return (Monster)this.clone();
	}
```

=> Sử dụng mẫu thiết kế Prototype

- Trong folder Singleton:
+ Các folder trong Singleton đều chứa ví dụ về mẫu thiết kế Singleton, các file Singleton.java đều chứa 1 phương thức instance và chỉ duy nhất 1 điểm truy xuất toàn cục đến nó
Ví dụ:
	
 ```
	public static Singleton getInstance() {
	if (uniqueInstance == null) {
		uniqueInstance = new Singleton();
	}
	return uniqueInstance;
  }
  ```

=> Mẫu thiết kế Singleton được sử dụng với tần suất cao do việc tạo instance cho mỗi đối tượng là cần thiết

- Trong folder Flyweight:
+ Lớp interface Tree chia sẻ thông tin cho 2 lớp con của nó là ConiferTree và DeciduousTree giúp giảm dung lượng bộ nhớ thông qua chia sẻ các đối tượng
Ví dụ: Phương thức isWithinRange và display ở trong Tree.java được chia sẻ cho 2 lớp con:
Trong Tree:

```	
	public default boolean isWithinRange(LocalDate aDate) {
		Month month = aDate.getMonth();
		return (month.getValue() > 2) && (month.getValue() < 11);
	} 
```

Trong ConiferTree:

```
	public void display(int x, int y) {
		System.out.println("Conifer tree is located at " + x + ", " + y);
	}
```

Trong DeciduousTree:

```
	public void display(int x, int y) {
		System.out.println("Deciduous tree is located at " + x + ", " + y);
		if (!this.isWithinRange(LocalDate.now())) {
			System.out.println("The tree currently has no leaves");
		}
	}
 ```
 
- Trong folder Proxy:
+ Trong javaproxy có chứa lớp Person, lớp này được lớp PersonImpl implements làm đại diện hỗ trợ kiểm soát quá trình truy xuất các đối tượng trong đó, đối tượng thay thế 	PersonImpl là Proxy
Lớp Person:
```
public interface Person {
	String getName();
	String getGender();
	String getInterests();
	int getGeekRating();
    	void setName(String name);
    	void setGender(String gender);
    	void setInterests(String interests);
    	void setGeekRating(int rating); 
}
```
Lớp PersonImpl
```
public class PersonImpl implements Person {
	String name;
	String gender;
	String interests;
	int rating;
	int ratingCount = 0;
	public String getName() {
		return name;	
	} 
	public String getGender() {
		return gender;
	}
	public String getInterests() {
		return interests;
	}
	public int getGeekRating() {
		if (ratingCount == 0) return 0;
		return (rating/ratingCount);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	} 
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public void setGeekRating(int rating) {
		this.rating += rating;	
		ratingCount++;
	}
}
```
=> Sử dụng mẫu thiết kế Proxy

- Trong folder Observer:
+ Xét trong folder simple, lớp trừu tượng Observer có duy nhất 1 thuộc tính update, thuộc tính này được lớp SimpleObserver implements, điều này định nghĩa sự phụ thuộc giữa các đối tượng, khi một đối tượng thay đổi trạng thái thì các đối tượng khác sẽ thay đổi theo
File Observer.java:
```
public interface Observer {
	public void update(int value);
}
```
File SimpleObserver.java:
```
public class SimpleObserver implements Observer {
	private int value;
	private Subject simpleSubject;
	public SimpleObserver(Subject simpleSubject) {
		this.simpleSubject = simpleSubject;
		simpleSubject.registerObserver(this);
	}
	public void update(int value) {
		this.value = value;
		display();
	}
	public void display() {
		System.out.println("Value: " + value);
	}
}
```
=> Sử dụng mẫu thiết kế Observer giúp cho việc thay đổi trạng thái của một đối tượng kéo theo sự thay đổi trạng thái của những đối tượng khác, đây là điều rất cần thiết với những chương trình kích thước lớn nên có tần suất sử dụng cao.

Decorator pattern:
* Trong folder Decorator, có các folder là pizza, starbuzz, có các file java như là ToppingDecorator.java, CondimentDecorator.java là các các lớp decorator(hay wrapper).
```
public abstract class ToppingDecorator extends Pizza {
	Pizza pizza;
	public abstract String getDescription();
}
```
* Như trong folder Pizza, người dùng muốn order 1 chiếc pizza nhưng sau đó muốn thêm nhiều loại topping khác vào chính chiếc pizza đó, cũng như việc số tiền tổng chi cho chiếc pizza đó phải tăng theo số topping dc thêm vào, file ToppingDecorator.java hay là decorator pattern giúp chúng ta thực hiện việc này, thêm chức năng mới vào đối tượng pizza hiện tại mà ko làm ảnh hưởng đến nó.
  => Kiểu thiết kế này có cấu trúc hoạt động như một lớp bao bọc (wrap) cho lớp hiện có. Mỗi khi cần thêm tính năng mới, đối tượng hiện có được wrap trong một đối tượng mới (decorator class).
```
public class Cheese extends ToppingDecorator {
	
 
	public Cheese(Pizza pizza) {
		this.pizza = pizza;
	}
 
	public String getDescription() {
		return pizza.getDescription() + ", Cheese";
	}
 
	public double cost() {
		return pizza.cost(); // cheese is free
	}
}
```
Composite pattern:
* Trong folder composite có file Menu.java dùng để lưu trữ tập hợp các menu components hay các đối tượng tương tự nhau, để xử lí các đối tượng này hoạt động như 1 đối tượng duy nhất (theo cùng 1 cách). Menu.java cài đặt các phương thức được định nghĩa trong interface menuComponent bằng cách ủy nhiệm cho các thành phần con xử lý
  => Composite patterns.
```
import java.util.Iterator;
import java.util.ArrayList;

public class Menu extends MenuComponent {
	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	String name;
	String description;
  
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
 
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
 
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
 
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	}
 
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}
 
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
  
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = 
				(MenuComponent)iterator.next();
			menuComponent.print();
		}
	}
}
```

Strategy patterns:
* Folder challenge trong Strategy có file ShareStrategy.java chứa các hành vi có thể có của 1 strategy, mà ở trong folder này là share các photo đã chụp dc bằng các hành vi như post lên social media, texting photo va email photo.
```
@FunctionalInterface
public interface ShareStrategy {
	public void share();
}
```
* Đây là 1 strategy pattern, đóng gói từng thuật toán, method lại, và dễ dàng thay đổi linh hoạt nó bên trong object, ý nghĩa của việc chia ra các hành vi có thể có của 1 đối tượng như vậy là để tạo ra một tập hợp các thuật toán để xử lý chức năng đó và lựa chọn thuật toán nào mà chúng ta thấy đúng đắn nhất khi thực thi chương trình. Ví dụ như trong trường hợp này, ta có thể chọn các hành vi share khác nhau của 1 object là photo :
```
public class Txt implements ShareStrategy {
	public void share() {
		System.out.println("I'm txting the photo");
	}
}

public class Social implements ShareStrategy {
	public void share() {
		System.out.println("I'm posting the photo on social media");
	}
}

public class Email implements ShareStrategy {
	public void share() {
		System.out.println("I'm emailing the photo");
	}
}
```

Iterator:
* Trong folder iterator/dinermerger có file Iterator.java, đây là 1 lớp iterator, lớp này có tác dụng để truy cập tuần tự tới các phần tử của một đối tượng.
```
public interface Iterator {
	boolean hasNext();
	MenuItem next();
}
```
* Lớp trên cung cấp một interface duy nhất để duyệt qua các phần tử của một tập hợp. Như trong trường hợp này thì lớp iterator dc dùng để duyệt qua các items của 1 menu.
```
import java.util.ArrayList;

public class ArrayListIterator implements Iterator {
	ArrayList<MenuItem> items;
	int position = 0;
 
	public ArrayListIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}
 
	public MenuItem next() {
		MenuItem item = items.get(position);
		position = position + 1;
		return item;
	}
 
	public boolean hasNext() {
		if (position >= items.size()) {
			return false;
		} else {
			return true;
		}
	}
}
```

# Kết luận: Trong dự án trên do nội dung là về design pattern nên mẫu thiết kế được sử dụng khá tương đồng với 23 mẫu thiết kế chuẩn.
