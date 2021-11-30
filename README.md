# OOP-2021
Môn học Lập trình hướng đối tượng với Java
# Nhóm HLN
 ## Báo cáo tìm hiểu về mẫu thiết kế

 ## Thành viên: Họ và tên - MSSV
 ## 1. Đỗ Ngọc Long - 20021385
 ## 2. Cấn Mạnh Hùng - 20021364
 ## 3. Nguyễn Phúc Nguyên - 20021406



 **[Link đến reposition được sử dụng trong bài báo cáo mà nhóm đã tìm được và phân tích]: https://github.com/tcorral/Design-Patterns-in-Javascript**.
 
- Bài báo cáo dựa trên sự đóng góp của các thành viên qua trao đổi để viết nên.
- Repo được đánh giá 2.4k sao.
- sau khi tham khảo và phân tích thì nhóm mình sẽ đi phân tích để mọi ngừoi hiểu rõ được Repo làm những gì và ứng dụng của Design Pattern.

## Phân tích và so sánh mẫu thế kế


## Abstract Factory:
-	Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần quy định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng.
-	Giúp tránh được việc sử dụng điều kiện logic bên trong Factory Pattern. Khi một Factory Method lớn (có quá nhiều sử lý if-else hay switch-case), chúng ta nên sử dụng theo mô hình Abstract Factory để dễ quản lý hơn (cách phân chia có thể là gom nhóm các sub-class cùng loại vào một Factory).
-	Hãy lấy một hãng sản xuất ô tô làm ví dụ, chẳng hạn Hyundai. Họ có nhà máy, hoặc xưởng, chế tạo bánh xe: bánh của Azera, bánh của Sonata, bánh của Veloster, v.v… Đến lượt cửa xe, cũng có nhà máy chế tạo cửa Azera, cửa Sonata, cửa Veloster. Thân xe, động cơ, đèn, và các thành phần khác có những nhà máy chế tạo chúng.
-	Example: https://github.com/JangirSumit/abstract-factory-design-pattern .
-	code Repo https://github.com/tcorral/Design-Patterns-in-Javascript/blob/es6/Adapter/scripts/Duck.js .
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
=> Code Repo tương đối giống với mẫu.
=> https://github.com/tcorral/Design-Patterns-in-Javascript/tree/es6/Factory

## Factory Method:
-	Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.
-	Factory method, đầy đủ là Factory method pattern, là thiết kế mẫu hướng đối tượng trong việc thiết kế phần mềm cho máy tính, nhằm giải quyết vấn đề tạo một đối tượng mà không cần thiết chỉ ra một cách chính xác lớp nào sẽ được tạo
-	Factory Pattern giúp giảm sự phụ thuộc giữa các module (loose coupling): cung cấp 1 hướng tiếp cận với Interface thay thì các implement. Giúp chuơng trình độc lập với những lớp cụ thể mà chúng ta cần tạo 1 đối tượng, code ở phía client không bị ảnh hưởng khi thay đổi logic ở factory hay sub class.
-	Thống nhất về naming convention: giúp cho các developer có thể hiểu về cấu trúc source code.
-	Example: https://github.com/iluwatar/java-design-patterns/tree/master/factory-method .
-	Code Repo: https://github.com/tcorral/Design-Patterns-in-Javascript/blob/es6/Factory/1/scripts/Pizza.js .
```
	public class BankFactory {
 
    private BankFactory() {
    }
 
    public static final Bank getBank(BankType bankType) {
        switch (bankType) {
 
        case TPBANK:
            return new TPBank();
 
        case VIETCOMBANK:
            return new VietcomBank();
 
        default:
            throw new IllegalArgumentException("This bank type is unsupported");
        }
    }
 
}
```
=> Code Repo tương đối giống với mẫu.
=> https://github.com/tcorral/Design-Patterns-in-Javascript/tree/es6/Factory

## Adapter:
-	Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
-	Trong công nghệ phần mềm, Adapter pattern là một mẫu thiết kế tiếp hợp cho phép chuyển đổi một interface có sẵn thành một interface khác thích hợp cho lớp đang viết.
-	Tăng khả năng sử dụng lại thư viện với interface không thay đổi do không có mã nguồn.
-	Cho phép nhiều đối tượng có interface giao tiếp khác nhau có thể tương tác và giao tiếp với nhau.
-	bạn muốn sử dụng một lớp hiện có và giao diện của nó không khớp với một lớp bạn cần.
-	bạn muốn tạo một lớp có thể sử dụng lại hợp tác với các lớp không nhất thiết phải có giao diện tương thích.
- Example: https://github.com/Adapter-Hub/Hub .
- Code Repo: https://github.com/tcorral/Design-Patterns-in-Javascript/blob/es6/Adapter/scripts/Duck.js .
```
package com.gpcoder.patterns.structural.adapter;
 
public class JapaneseAdaptee {
 
    public void receive(String words) {
        System.out.println("Retrieving words from Adapter ...");
        System.out.println(words);
    }
}
```
=> Code Repo tương đối giống với mẫu.
=> https://github.com/tcorral/Design-Patterns-in-Javascript/tree/es6/Adapter

## Bridge:
-	Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (ngữ nghĩa và cài đặt) có thể thay đổi độc lập nhau.
-	Dạng thức bắc cầu là một dạng thức thiết kế được dùng trong công nghệ phần mềm. Dạng thức bắc cầu dùng để "tách riêng tính trừu tượng ra khỏi thực thể của nó để cho cả hai có thể thay đổi một cách độc lập".
-	Bridge Pattern được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt. Do đó, các thành phần này có thể thay đổi một cách độc lập mà không ảnh hưởng đến các thành phần khác. Thay vì liên hệ với nhau bằng quan hệ kế thừa, hai thành phần này liên hệ với nhau thông qua quan hệ “chứa trong” (object composition).
-	Example: https://github.com/MoienTajik/Bridge-Pattern-Sample .
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
=> Code Repo tương đối giống với mẫu.
=> https://github.com/tcorral/Design-Patterns-in-Javascript/tree/es6/Bridge

## Command: 
-	Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.Đóng gói request vào trong một Object, nhờ đó có thể nthông số hoá chương trình nhận request và thực hiện các thao tác trên request: sắp xếp, log, undo…
-	Chúng ta có thể xử lí vấn đề theo hướng command - đóng gói ý tưởng, những action cần làm khi button được ấn hoặc menu item được chọn. Tức là gom code để xử lý việc ấn button hoặc chọn menu trong object riêng. Những action này chính là những commands của Command pattern.
- Example:	https://github.com/joshnh/Git-Commands .
- Code Repo: https://github.com/tcorral/Design-Patterns-in-Javascript/blob/es6/Command/1/scripts/Command.js .
```
package com.gpcoder.patterns.behavioral.command.bank;
 
public class Account {
    private String name;
 
    public Account(String name) {
        this.name = name;
    }
 
    public void open() {
        System.out.println("Account [" + name + "] Opened\n");
    }
 
    public void close() {
        System.out.println("Account [" + name + "] Closed\n");
    }
}
```
=> Code Repo tương đối giống với mẫu.
=> https://github.com/tcorral/Design-Patterns-in-Javascript/tree/es6/Command .

## Observer: 
-	Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.
-	Trong bài toán đưa ra, ta có thể thấy rằng mối quan hệ 1-n ở đây đó là 1-WeatherData và n-Screen(currentConditionstDisplay,statisticsDisplay, ...). Mỗi khi WeatherData có sự thay đổi về trạng thái (nhiệt độ, độ ẩm, áp suất) thì nó sẽ "thông báo" cho các màn hình đang "quan sát" sát nó để cập nhật lại việc hiển thị thông tin.
-	Example: https://github.com/design-pattern-list/observer-pattern .
-	Code Repo: https://github.com/tcorral/Design-Patterns-in-Javascript/blob/es6/Observer/scripts/CurrentConditionsDisplay.js .
```
package refactoring_guru.observer.example.listeners;

import java.io.File;

public interface EventListener {
	void update(String eventType, File file);
}
```
=> Code Repo tương đối giống với mẫu.
=> https://github.com/tcorral/Design-Patterns-in-Javascript/tree/es6/Observer .

## Buider:
+ Trong HouseBuilder.java khởi tạo lớp abstract HouseBuilder có chứa các phương thức abstract sử dụng mẫu thiết kế Fluent Interface Pattern trả về chính HouseBuider
+ đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.
```
  public abstract HouseBuilder addWalls();
  
  public abstract HouseBuilder addRoof();
  
  public abstract HouseBuilder addWindows();
 ``` 
 - code gốc bên Repo.
 ```
 class MealBuilder {
    prepareVeganMeal() {
        var meal = new Meal();
        meal.addItem(new VeganBurger());
        meal.addItem(new Water());
        meal.addItem(new Salad());
        return meal;
    }
    prepareNonVeganMeal() {
        var meal = new Meal();
        meal.addItem(new BeefBurger());
        meal.addItem(new Coke());
        meal.addItem(new Fries());
        return meal;
    }
    prepareDeluxeMeal() {
        var meal = new Meal();
        meal.addItem(new KobeBurger());
        meal.addItem(new Champagne());
        meal.addItem(new Crudettes());
        return meal;
    }
}
 ```
+ Các lớp WoodHouseBuilder, StoneHouseBuilder, GingerbreadHouseBuilder kế thừa các thuộc tính trong lớp abstract HouseBuilder.
=> Tách tiến trình xây dựng 1 đối tượng phức tạp sao cho một tiến trình tạo được các biểu diễn khác nhau => Builder Design Pattern.
=> ode Repo tương đối giống với mẫu.
=> https://github.com/tcorral/Design-Patterns-in-Javascript/tree/es6/Builder .


## Kết luận: Trong dự án trên do nội dung là về design pattern nên mẫu thiết kế được sử dụng khá tương đồng với 23 mẫu thiết kế chuẩn.

