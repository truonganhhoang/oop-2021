# Báo cáo tìm hiểu về mẫu thiết kế

## Thành viên:
## 1. Nguyễn Hồng Hạnh - 20021343
## 2. Nguyễn Công Khoa - 20021376

### Link GitHub tham khảo:
- **[Link đến phần nội dung lý thuyết tham khảo](https://gpcoder.com/4164-gioi-thieu-design-patterns/)**
- **[Link đến reposition được sử dụng trong bài báo cáo](https://github.com/bethrobson/Head-First-Design-Patterns)**



###1. Factory:
- File CoinFactory.java chứa lớp CoinFactory thực chất là một lớp Factory hỗ trợ việc việc khởi tạo các các đối tượng thuộc các lớp Coin khác nhau nhằm che giấu việc phương thức khởi tạo và thống nhất việc khởi tạo các đối tượng cụ thể thuộc các lớp như CopperCoin, GoldCoin đều implements 1 interface là Coin
```
	public class CoinFactory{
		public static Coin getCoin(CoinType type)
	}
```
- Mặc dù tác giả của project gán static cho method getCoin nhưng không bắt buộc; tác dụng không phải khởi tạo factory trong khi vẫn có thể sử dụng tính năng trả về đối tượng nhằm khởi tạo chúng được
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


###2. AbstractFactory:
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


###3. Bridge:
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
-> Sự thay đổi của bùa chú (enchantment) từ phương thức khởi tạo sẽ dẫn đến thay đổi trong method getgetEnchantment mà không phải tạo ra các method với từng loại bùa nếu thay đổi method thành trả về tác dụng của bùa thì sẽ thay đổi với từng loại bùa mà không phải tạo ra vô số các method tương ứng với từng loại bùa xong lại phải xét để thực hiện phương thức ứng với loại bùa đã cho.


###4. Facade:
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


###5. State:
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


###6. Template method:
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


###7. Buider:
+ Trong HouseBuilder.java khởi tạo lớp abstract HouseBuilder có chứa các phương thức abstract sử dụng mẫu thiết kế Fluent Interface Pattern trả về chính HouseBuider
```
  public abstract HouseBuilder addWalls();
  
  public abstract HouseBuilder addRoof();
  
  public abstract HouseBuilder addWindows();
 ``` 
+ Các lớp WoodHouseBuilder, StoneHouseBuilder, GingerbreadHouseBuilder kế thừa các thuộc tính trong lớp abstract HouseBuilder
=> Tách tiến trình xây dựng 1 đối tượng phức tạp sao cho một tiến trình tạo được các biểu diễn khác nhau => Builder Design Pattern


###8. Adapter:
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



###9. Prototype:
+ File Monster.java khởi tạo lớp Monster, lớp này được dùng làm đối tượng mẫu để quy định các loại đối tượng của lớp Dragon, Drakon. 2 lớp này kế thừa lớp Monster và tạo mới nhờ sao chép đối tượng mẫu
Trong Dragon.java và Drakon.java đều chứa:

```
	public Monster copy() throws CloneNotSupportedException {
		return (Monster)this.clone();
	}
```

=> Sử dụng mẫu thiết kế Prototype


###10. Singleton:
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
