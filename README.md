# OOP-2021
Môn học Lập trình hướng đối tượng với Java

# Báo cáo Design Pattern 

Thành viên trong nhóm:
+ Bùi Minh Sơn 20021427
+ Nông Ngọc Sơn 20021430
+ Nguyễn Đức Dũng 20020181

Repo nhóm đã tìm được và phân tích: https://github.com/OmarElgabry/DesignPatterns/tree/master/src?fbclid=IwAR3zcvkF1NME6gIojqlXHsJEQnlaZ-fpN46HoGKMaSQouK-o_uOHSZNU6eU

**Sau đây là đánh giá của nhóm về design pattern**

### Điểm giống nhau:

-Có kết cấu tương tự với mẫu chuẩn.

-Hệ thống làm việc độc lập với cách sản phẩm của nó được tạo ra, cấu tạo và đại diện.

-Mỗi lớp chỉ chịu trách nhiệm về 1 một việc.

-Khi chỉnh sửa thêm bớt thành phần thì không cần thay đổi code hiện tại.

-Code sạch sẽ

### Điểm khác nhau:

-Không nhiều do là 1 mẫu thiết kế tương tự mẫu thiết kế chuẩn.

• Singleton:
o Đảm bảo 1 class chỉ có 1 instance và cung cấp 1 điểm truy xuất toàn cục đến nó.

 vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/singleton
 package singleton.classic;
```java
public class Database {

	private static Database database = null;
	
	private Database(){}
	
	public static Database getInstance(){
		if(database == null){
			database = new Database();
		}
		return database;
	}
	
	public void display(){
		System.out.println("I'm the Classic Singleton");
		System.out.println("Be Caution: I'm NOT thread safe");
	}
}
 ```
•	Abstract Factory:
o	Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/factory/abstr
package factory.abstr;
```java
public class MammalsFactory extends AnimalFactory{

	@Override
	public Animal create(String animal) {
		
		animal = animal.toUpperCase();

		if(animal.equals("CAT")){
			return new Cat();
		}else if(animal.equals("FOX")){
			return new Fox();
		}
		return null;
	}

}
```
•	Factory Method:
o	Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/factory
package factory.method;
```java
public class AnimalFactory {

	public Animal create(String animal){
		
		animal = animal.toUpperCase();

		if(animal.equals("CAT")){
			return new Cat();
		}else if(animal.equals("DOG")){
			return new Dog();
		}
		return null;
	}
}
```
•	Prototype:
o	Qui định loại của các đối tượng cần tạo bằng cách dùng một đối tượng mẫu, tạo mới nhờ vào sao chép đối tượng mẫu này.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/prototype
ackage prototype.inter;
```java
public class ProductFactory {

	private Book book;
	private Album album;
	private Movie movie;
	
	public ProductFactory(Album _album, Book _book, Movie _movie){
		album = _album;
		book = _book;
		movie = _movie;
	}
	
	public Book getBook() {
		return book.clone();
	}

	public Album getAlbum() {
		return album.clone();
	}

	public Movie getMovie() {
		return movie.clone();
	}	
	
}
```
•	Adapter:
o	Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/adapter
package adapter.inter;
```java
public class FormatAdapter implements MediaPlayer{

	private MediaPackage media;
	
	public FormatAdapter(MediaPackage _media){
		media = _media;
	}
	
	@Override
	public void play() {
		System.out.print("Using Adapter - ");
		media.playFile();
	}
	
}
```
•	Bridge:
o	Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (ngữ nghĩa và cài đặt) có thể thay đổi độc lập nhau.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/bridge
```java
package bridge;

public class Main {

	public static void main(String[] args) {
		
		// decouple Rectangle & Circle classes from Color Implementation,
		// As long as they can vary independently during the run time.
		AbstractShape shape = new Rectangle(new Blue());
		shape.applyColor();
		
		shape = new Circle(new Red());
		shape.applyColor();
	}

}
```
•	Composite:
o	Tổ chức các đối tượng theo cấu trúc phân cấp dạng cây. Tất cả các đối tượng trong cấu trúc được thao tác theo một cách thuần nhất như nhau.
Tạo quan hệ thứ bậc bao gộp giữa các đối tượng. Client có thể xem đối tượng bao gộp và bị bao gộp như nhau -> khả năng tổng quát hoá trong code của client -> dễ phát triển, nâng cấp, bảo trì.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/composite
```java
package composite;

public class Main {

	public static void main(String[] args) {
		
		// start drawing zoo picture
		Picture zoo = new Picture("Zoo");
		
		// add shapes(circle, rectangle, line, picture) to picture
		zoo.add(new Circle());
		zoo.add(new Rectangle());
		zoo.add(new Line());

		Picture lion = new Picture("Lion");

		lion.add(new Circle());
		lion.add(new Rectangle());
		
		zoo.add(lion);

		// draw zoo picture
		zoo.draw();
	}

}
```
•	Decorator:
o	Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) vào lúc chạy (dynamically).
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/decorator
```java
public interface MenuItem {

	public double cost();
	
	public String description();
	
}
```
•	Iterator: 
o	Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/iterator

```java

public class MyList implements Iterable<String>{

	private static final int MAX_SIZE = 6;
	private int length = 0;
	private String list[];

	public MyList(){
		list = new String[MAX_SIZE];
	}
	
	public void addItem(String str){
		if(length >= MAX_SIZE){
			System.out.println("The list is full, You can't add anymore");
		}else{
			list[length++] = str;
		}
	}
	
	@Override
	public Iterator<String> iterator() {
		return new ListIterator(list, length);
	}
}
	
//single
	
public class MyList implements Iterable<String>{

	private static final int MAX_SIZE = 6;
	private int length = 0;
	private String list[];

	public MyList(){
		list = new String[MAX_SIZE];
	}
	
	public void addItem(String str){
		if(length >= MAX_SIZE){
			System.out.println("The list is full, You can't add anymore");
		}else{
			list[length++] = str;
		}
	}
	
	@Override
	public Iterator<String> iterator() {
		return new ListIterator(list);
	}
	
	private class ListIterator implements Iterator<String> {

		private String list[];
		private int size = 0;
		private int curIndex = 0;
		
		public ListIterator(String[] list) {
			this.list = list;
			this.size = length;
		}
		
		@Override
		public boolean hasNext() {
			return size > curIndex;
		}

		@Override
		public String next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return list[curIndex++];
		}
		
		public void remove(){
			throw new UnsupportedOperationException(); 
		}
	}
}
 ```

•	State: 
o	Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/state
```java
public class Microwave {

	private State WaitingState;
	private State WorkingState;
	private State PausedState;

	private State curState;
	
	public Microwave(){
		WaitingState = new WaitingState(this);
		WorkingState = new WorkingState(this);
		PausedState  = new PausedState(this);
		
		curState  = WaitingState;
	}
	
	public void start(){
		curState.start();
	}
	
	public void pause(){
		curState.pause();
	}
	
	public void stop(){
		curState.stop();
	}
	
	public void setCurState(State state){
		curState = state;
	}
	
	public State getWaitingState() {
		return WaitingState;
	}

	public State getWorkingState() {
		return WorkingState;
	}

	public State getPausedState() {
		return PausedState;
	}
	
}
```
•	Observer: 
o	Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/observer
```java
public class Subscriber implements Observer{

	private String name;
	
	public Subscriber(String _name, Observable observable){
		name = _name;
		observable.addObserver(this);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		if(observable instanceof Newsletter){
			System.out.println("Subscriber " + name + " was notified " + observable);			
		}
	}

	
}
```
•	Strategy: 
o	Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.Cung cấp một họ giải thuật cho phép client chọn lựa linh động một giải thuật cụ thể khi sử dụng.
vd: https://github.com/OmarElgabry/DesignPatterns/tree/master/src/strategy
```java
public abstract class Customer {
	
	private Payment payment;
	
	public Customer(){
	}
	
	public void setPayment(Payment _payment){
		payment = _payment;
	}
	
	public void purchase(int amount){
		payment.make(amount);
	}
	
	public abstract void display();
}
```
