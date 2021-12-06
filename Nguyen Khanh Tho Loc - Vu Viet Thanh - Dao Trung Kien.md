# oop-2021
## Môn học Lập trình hướng đối tượng với Java
** Thành viên nhóm: **
* - 20021389 Nguyễn Khánh Thọ Lộc.*
* - 20021436 Vũ Viết Thành.*
* - 20020182 Đào Trung Kiên.*

### Creational design pattern:
*link: https://github.com/ajanata/PretendYoureXyzzy/tree/master/src/main/java/net/socialgamer/cah *

**1, Singleton Pattern:**
- Đảm bảo 1 class chỉ có 1 instance và cung cấp 1 điểm truy xuất toàn cục đến nó.

- Khi nào sử dụng mẫu thiết kế Singleton: 
 + Đối với các resources khá đắt để tạo (như các đối tượng kết nối cơ sở dữ liệu).
 + Đó là một good practice để giữ tất cả các logger như Singletons làm tăng hiệu suất.
 + Các classes cung cấp quyền truy cập vào cài đặt cấu hình cho ứng dụng.
 + Các classes có chứa reesource được truy cập trong chế độ chia sẻ. 

- Trong bài Singleton được sử dụng trong HibernateUtil.java
```java
public class HibernateUtil {
  public static final HibernateUtil instance = new HibernateUtil();
  /**
   * Hibernate session factory to use.
   */
   
  public final SessionFactory sessionFactory;
  private HibernateUtil() {
    sessionFactory = new Configuration().configure().buildSessionFactory();
  }
}
```
`- So sánh: mẫu thiết kế trong Repo em tìm kiếm giống với mẫu gốc theo link. Cả 2 đều đảm bảo 1 class chỉ có 1 instance và cung cấp 1 điểm truy xuất toàn cục đến nó (https://stackjava.com/design-pattern/singleton-pattern.html).`

**2, Factory Method Design Pattern:**
- Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.
- Khi nào sử dụng mẫu thiết kế Factory Method:
 + Khi việc implementation một interface hoặc một abstract class dự kiến sẽ thay đổi thường xuyên.
 + Khi implementation hiện tại không thể dễ dàng thích ứng với thay đổi mới.
 + Khi quá trình khởi tạo tương đối đơn giản và hàm tạo chỉ yêu cầu một số tham số.  

- ví dụ : trong CacheControlFilter.java
```java
public class CacheControlFilter implements Filter {
  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain) throws IOException, ServletException {
    final HttpServletResponse resp = (HttpServletResponse) response;
    final DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
    resp.setHeader("Expires", "Tue, 03 Jul 2001 06:00:00 GMT");
    resp.setHeader("Last-Modified", format.format(new Date()));
    resp.setHeader("Cache-Control", "must-revalidate, max-age=0");
    chain.doFilter(request, response);
  }
  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {
    // pass
  }
  @Override
  public void destroy() {
    // TODO pass
  }
}
```
Hoặc:
```java
Public abstract class SafeTimerTask implements Runnable {

  private static final Logger logger = Logger.getLogger(SafeTimerTask.class);

  @Override
  public final void run() {
    try {
      process();
    } catch (final Exception e) {
      logger.error("Exception running SafeTimerTask", e);
    }
  }

  public abstract void process();

}

public class UserPingTask extends SafeTimerTask {

  private final ConnectedUsers users;
  private final ScheduledThreadPoolExecutor globalTimer;

  @Inject
  public UserPingTask(final ConnectedUsers users, final ScheduledThreadPoolExecutor globalTimer) {
    this.users = users;
    this.globalTimer = globalTimer;
  }

  @Override
  public void process() {
    users.checkForPingAndIdleTimeouts();
    globalTimer.purge();
  }
}
```
`- So sánh: mẫu thiết kế này định nghĩa 1 inteface để tạo các objects, nhưng để các class con quyết định loại class nào được tạo ra.
giống với mẫu gốc nhưng ít các objects hơn.(https://stackjava.com/design-pattern/factory-pattern.html)`


**3, Builder Design Pattern trong Constant.java:**
- Tách rời việc xây dựng (construction) một đối tượng phức tạp khỏi biểu diễn của nó sao cho cùng một tiến trình xây dựng có thể tạo được các biểu diễn khác nhau.
- Khi nào sử dụng mẫu thiết kế Builder:
 + Khi xử lý liên quan đến việc tạo một đối tượng là vô cùng phức tạp, với rất nhiều tham số bắt buộc và tùy chọn
 + Khi sự gia tăng số lượng tham số của hàm tạo dẫn đến một danh sách lớn các hàm tạo
 + Khi client muốn các biểu diễn khác nhau cho đối tượng được xây dựng
- Trong bài:
```java
public class Player {
  private final User user;

  private final List<WhiteCard> hand = new LinkedList<WhiteCard>();
  private int score = 0;
  private int skipCount = 0;

  /**
   * Create a new player object.
   * 
   * @param user
   *          The {@code User} associated with this player.
   */
  public Player(final User user) {
    this.user = user;
  }

  /**
   * @return The {@code User} associated with this player.
   */
  public User getUser() {
    return user;
  }

  /**
   * @return The player's score.
   */
  public int getScore() {
    return score;
  }

  /**
   * Increase the player's score by 1 point.
   */
  public void increaseScore() {
    score++;
  }

  /**
   * Increase the player's score by the specified amount.
   */
  public void increaseScore(final int offset) {
    score += offset;
  }

  /**
   * Reset the player's score to 0.
   */
  public void resetScore() {
    score = 0;
  }

  /**
   * Increases this player's skipped round count.
   */
  public void skipped() {
    skipCount++;
  }

  /**
   * Reset this player's skipped round count to 0, because they have been back for a round.
   */
  public void resetSkipCount() {
    skipCount = 0;
  }

  /**
   * @return This player's skipped round count.
   */
  public int getSkipCount() {
    return skipCount;
  }

  /**
   * @return The backing object for the player's hand (i.e., it can be modified).
   */
  public List<WhiteCard> getHand() {
    return hand;
  }

  @Override
  public String toString() {
    return String.format("%s (%dp, %ds)", user.toString(), score, skipCount);
  }
}
```
`- So sánh: mẫu thiết kế trong Repo gióng với mẫu code theo link đều có cấu trúc khá giống nhau cũng có cả overide phương thức(https://stackjava.com/design-pattern/builder-pattern.html)`


**4, Abstract Factory Design Pattern:**
- Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng

- Ví dụ: trong code theo Repo
```java
Public class QueuedMessage implements Comparable<QueuedMessage> {

  private final MessageType messageType;
  private final Map<ReturnableData, Object> data;

  /**
   * Create a new queued message.
   * 
   * @param messageType
   *          Type of message to be queued. The type influences the priority in returning messages
   *          to the client.
   * @param data
   *          The data of the message to be queued.
   */
  public QueuedMessage(final MessageType messageType, final Map<ReturnableData, Object> data) {
    this.messageType = messageType;
    this.data = data;
  }

  /**
   * @return The type of the message.
   */
  public MessageType getMessageType() {
    return messageType;
  }

  /**
   * @return The data in the message.
   */
  public Map<ReturnableData, Object> getData() {
    return data;
  }

  /**
   * This is not guaranteed to be consistent with .equals() since we do not care about the data for
   * ordering.
   */
  @Override
  public int compareTo(final QueuedMessage qm) {
    return this.messageType.getWeight() - qm.messageType.getWeight();
  }

  @Override
  public String toString() {
    return messageType.toString() + "_" + data.toString();
  }

  /**
   * Types of messages that can be queued. The numerical value is the priority that this message
   * should be delivered (lower = more important) compared to other queued messages.
   */
  public enum MessageType {
    KICKED(1), PLAYER_EVENT(3), GAME_EVENT(3), GAME_PLAYER_EVENT(4), CHAT(5);

    private final int weight;

    MessageType(final int weight) {
      this.weight = weight;
    }

    public int getWeight() {
      return weight;
    }
  }
}
```
`- So sánh: rất giống với mấu thiết kế trong code mẫu theo link (https://www.baeldung.com/java-abstract-factory-pattern) , cùng có 1 interface mà để tạo các họ các đối tượng liên quan hoặc phụ thuộc mà không chỉ định các lớp cụ thể của chúng.`
```java	
  	public interface AbstractFactory<T> {
    		T create(String animalType) ;
	}
	
	
	public class AnimalFactory implements AbstractFactory<Animal> {

   	@Override
    	public Animal create(String animalType) {
        	if ("Dog".equalsIgnoreCase(animalType)) {
            		return new Dog();
        	} else if ("Duck".equalsIgnoreCase(animalType)) {
            		return new Duck();
        	}

        		return null;
    		}

	}
```
**5, Prototype Pattern:**
- Qui định loại của các đối tượng cần tạo bằng cách dùng một đối tượng mẫu, tạo mới nhờ vào sao chép đối tượng mẫu này.
link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/creational/prototype/computer/Computer.java
```java
package com.gpcoder.patterns.creational.prototype.computer;

public class Computer implements Cloneable {
	private String os;
	private String office;
	private String antivirus;
	private String browser;
	private String others;

	public Computer(String os, String office, String antivirus, String browser, String other) {
		super();
		this.os = os;
		this.office = office;
		this.antivirus = antivirus;
		this.browser = browser;
		this.others = other;
	}

	@Override
	protected Computer clone() {
		try {
			return (Computer) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Computer [os=" + os + ", office=" + office + ", antivirus=" + antivirus + ", browser=" + browser
				+ ", others=" + others + "]";
	}

	public void setOthers(String others) {
		this.others = others;
	}
}
```
So sánh: có cấu trúc hoàn toàn giống với code mẫu theo link (https://stackjava.com/design-pattern/prototype-pattern.html)
```java
public class User {
  private String firstName;
  private String lastName;
  private String displayName;
  private String email;
  private Address address;
  public User() {
  }
  public User(String firstName, String lastName, String displayName, String email, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.displayName = displayName;
    this.email = email;
    this.address = address;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Address getAddress() {
    return address;
  }
  public void setAddress(Address address) {
    this.address = address;
  }
  public User shallowCopy() {
    User user = new User(this.firstName, this.lastName, this.displayName, this.email, this.address);
    return user;
  }
  public User deepCopy() {
    Address address = new Address(this.getAddress().getProvince(), this.getAddress().getDistrict(),
        this.getAddress().getStreet());
    User user = new User(this.firstName, this.lastName, this.displayName, this.email, address);
    return user;
  }
  @Override
  public String toString() {
    return "User [firstName=" + firstName + ", lastName=" + lastName + ", displayName=" + displayName + ", email="
        + email + ", address=" + address + "]";
  }
}
```
### Behavioral Design Patterns:
link:https://github.com/sherxon/AlgoDS.git

1, Command Pattern trong Interval.java. 
Command Pattern được tạo ra để lưu trữ các câu lệnh và trạng thái của object. Nó cho phép tất cả những yêu cầu gửi đến object đó dưới dạng một object Command.
Khi nó tìm được cách giải quyết thích hợp, nó sẽ chuyển đến Command, nơi mà nó sẽ được thực thi.

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

2, Observer Pattern trong ValidateCard.java. 
Observer Pattern được sử dụng để theo dõi trạng thái của một object nhất định. Thường là trong một nhóm hoặc một mối quan hệ một - nhiều.
Trong những trường hợp như vậy, hầu hết thời gian và trạng thái thay đổi của một object sẽ ảnh hưởng đến trạng thái của phần còn lại. Vì vậy, phải có một hệ thống ghi nhận lại những thay đổi, và thông báo cho các object khác.
Mặc dù Java cung cấp cả một class và interface có lưu ý đến pattern này. Nhưng nó không phổ biến vì nó không được thực hiện một cách lý tưởng.

public class ValidateCard {

    static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {

        return Arrays.stream(cardsToValidate).
                map(e -> ToMap(e, bannedPrefixes)).collect(Collectors.toList());

    }

    private static Map<String, Object> ToMap(String e, String[] bannedPrefixes) {
        Map<String, Object> map = new HashMap<>();
        map.put("card", e);
        map.put("isValid", isValid(e));
        map.put("isAllowed", isAllowed(e, bannedPrefixes));
        return map;
    }

    private static boolean isAllowed(String e, String[] bannedPrefixes) {
        for (String bannedPrefix : bannedPrefixes) {
            if (e.startsWith(bannedPrefix))
                return false;
        }
        return true;
    }

    private static boolean isValid(String e) {
        int sum = 0;
        for (int i = 0; i < e.length() - 1; i++) {
            sum += (e.charAt(i) - '0') * 2;
        }

        return sum % 10 == e.charAt(e.length() - 1) - '0';
    }
}

3, Interpreter pattern trong Factorial.java
Interpreter Pattern được sử dụng bất cứ lúc nào chúng ta cần đánh giá, chuyển đổi bất kì loại ngữ pháp hay ngôn ngữ nào.
Một ví dụ điển hình cho pattern này là google translate, nó sẽ nhận đầu vào và hiển thị cho chúng ta kết quả bằng ngôn ngữ khác.
Một ví dụ khác đó là trình biên dịch Java. Trình biên dịch sẽ thông dịch mã Java và chuyển nó thành bytecode. Sau đó, JVM sử dụng để thực hiện các hoạt động trên thiết bị.
public class Factorial {
    private static long factorial(int num) {
        if (num <= 1)        // 1! = 1, hence return 1 when the num becomes 1.
            return 1;
        return num * factorial(num - 1); // num! = num * (num - 1)!
    }

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
}

4, Template Method Pattern trong CycleDetection.java
Template Method còn được gọi là Template Pattern được sử dụng để xác định một class abstract (trừu tượng), cung cấp các cách để chạy chạy phương thức của nó. Các class con kế thừa các phương thức này cũng phải tuân theo các định nghĩa bên trong nó.
Trong một số trường hợp, class abstract có thể đã bao gồm một phương thức đã được triển khai trước đó. Và dĩ nhiên nó sẽ được chia sẽ đến tất cả các lớp con.

public abstract class CycleDetection {
    protected Graph graph;
    protected Set<Integer> visited;
    protected Set<Integer> exited;

    public CycleDetection(Graph graph) {
        this.graph = graph;
        visited = new HashSet<>();
        exited = new HashSet<>();
    }

    public boolean hasCycle() {

        for (Integer vertex : graph.getVertices()) {
            if (!visited.contains(vertex) && !dfs(vertex))
                return false;
        }
        return true;
    }

    private boolean dfs(Integer start) {
        visited.add(start);

        for (Integer neighbor : graph.getNeighbors(start)) {

            if (visited.contains(neighbor) && !exited.contains(neighbor))
                return true;

            if (!visited.contains(neighbor) && dfs(neighbor))
                return true;
        }
        exited.add(start);
        return false;
    }
}

5, Chain of Responsibility Pattern trong IsConnected.
Chain of Resppinsibility Pattern được sử dụng rất nhiều trong lập trình. Nó thực hiện công việc định nghĩa ra một chuỗi các object, chúng ta sẽ gọi lần lượt từng object để xử lý yêu cầu. Vì vậy, mỗi bộ xử lý trong chuỗi có các logic xử lý riêng.
Một điều quan trọng nữa là nó rất tiện dụng để tách sender ra khỏi receiver.

public class IsConnected extends DFS{
    Graph graph;

    public IsConnected(Graph graph) {
        super(graph);
        this.graph=graph;
    }

    public boolean isConnected(){
        search(1); // any random vertex

        Set<Integer> graphVertices=graph.getVertices();

        if(graphVertices.size()!=visited.size())return false;

        for (Integer integer : graph.getVertices()) {
            if(!visited.contains(integer)) return false;
        }
        return true;
    }
}
	
6, Iterator Pattern trong Graph.java
Iterator Pattern được sử dụng rất nhiều trong Java, và được xem như là mẫu cốt lõi của Java's Collection Framework.
Pattern này có thể truy cập vào tất cả các phần tử của một collection object một cách tuần tự.
	
public interface Graph {
     boolean addVertex(Integer t);

     Double addEdge(Integer from, Integer to);

     boolean addEdge(Integer from, Integer to, Double weight);

     boolean removeVertex(Integer t);

     boolean removeEdge(Integer from, Integer to);

     Set<Integer> getVertices();

     Set<Integer> getNeighbors(Integer ver);
     int size();
}
	
7, Mediator Pattern trong Vertex.
Mediator Pattern tương tự như Adapter Pattern nhưng đó được sử dụng trong mục đích khác. Mediator Pattern hoạt động như một cầu nối.
Trong các ứng dụng quy mô lớn, Mediator Pattern sẽ cung cấp một class trung gian để xử lý thông tin giữa các class.
	
    public Number getWeight() {
        return weight;
    }

    public void setWeight(Number weight) {
        this.weight = weight;
    }

    public void addNeighbor(Vertex<T> vertex){
        this.neighbors.add(vertex);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }
8, Memento Pattern trong RecursiveCircus.java
Memento Pattern liên quan đến các trạng thái trước đó của object. Điều này có nghĩa là nó được sử dụng khi chúng ta muốn lưu một số trạng thái của một object.
Khi chúng ta sử dụng pattern này để lưu lại các trạng thái đó, thì chúng ta có thể hoàn toàn khôi phục lại nó sau này.

public class RecursiveCircus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            try {
                String s = scanner.nextLine();
                if (s.equals("1"))
                    break;
                list.add(s);
            } catch (Exception e) {
                break;
            }
        }
        System.out.println(solve2(list));
    }
}

9, State Pattern trong PeekingIterajava
State Pattern được sử dụng khi một object cụ thể cần thay đổi hành động, dựa trên trạng thái của nó. Điều này được thực hiện bằng cách cung cấp cho mỗi object này một hoặc nhiều object state.
Dựa trên các object state này, chúng ta hoàn toàn có thể thay đổi các hành động của các object liên quan.

public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    LinkedList<Integer> list;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator=iterator;
        list=new LinkedList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
    }

    public Integer peek() {
       return list.getFirst();
    }

    @Override
    public boolean hasNext() {
        return list.iterator().hasNext();
    }

    @Override
    public Integer next() {
        return list.removeFirst();
    }
}
	
10, Strategy Pattern trong Edge.java
Strategy Pattern được sử dụng trong các tình huống các thuật toán hoặc hành vi của class là các các hành vi động (có thể thay đổi). Điều này có nghĩa là cả hành vi và thuật toán đều có thể thay đổi trong thời gian chạy, dựa vào đầu vào của client.
Tương tự như State Pattern, Strategy Pattern sử dụng nhiều object xác định, tùy thuộc vào các mục tiêu khác nhau.
	
public class Edge implements Comparable<Edge> {
    private Double weight;
    private Integer from;
    private Integer to;

    public Edge(Double weight) {
        this.weight = weight;
    }

    public Edge(Integer from, Integer to, Double weight) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (weight != null ? !weight.equals(edge.weight) : edge.weight != null) return false;
        if (from != null ? !from.equals(edge.from) : edge.from != null) return false;
        return !(to != null ? !to.equals(edge.to) : edge.to != null);
    }
}
	
11, Visitor Pattern trong Vertex.java
Visitor Pattern được sử dụng để chuyển logic hoạt động từ từng phần riêng lẻ của một group sang một class mới. Class mới này thực hiện các thao tác bằng cách sử dụng dữ liệu từ mỗi phần tử riêng lẻ đó.
Điều này được thực hiện bằng cách làm cho các phần tử chấp nhận một "Visitor". Visitor này sẽ thực hiện các thay đổi trong một class riêng biệt, mà không thay đổi các cấu trúc của lớp đã truy cập. Điều này giúp các bạn dễ dàng thêm chức năng mới mà không cần thay đổi các lớp đã truy cập.
	
public class Vertex<T> implements Comparable<Vertex<T>> {
   
    @Override
    public String toString() {
        return "Vertex{" +
                "value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        return value.equals(vertex.value);

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

***Structural patterns:

1. Adapter pattern:
- Adapter Pattern có chức năng điều chỉnh interface (giao diện) này sang interface khác. Nó hoạt động như một cầu nối giữa hai interface không liên quan, tương tự như scanner hoạt động như một cầu nối giữa paper và computer.
Điều này giúp các class có các interface khác nhau có thể giao tiếp với nhau thông qua một interface trung gian.
- Link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/structural/adapter/TranslatorAdapter.java
package com.gpcoder.patterns.structural.adapter;

public class TranslatorAdapter implements VietnameseTarget {

	private JapaneseAdaptee adaptee;

	public TranslatorAdapter(JapaneseAdaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void send(String words) {
		System.out.println("Reading Words ...");
		System.out.println(words);
		String vietnameseWords = this.translate(words);
		System.out.println("Sending Words ...");
		adaptee.receive(vietnameseWords);
	}

	private String translate(String vietnameseWords) {
		System.out.println("Translated!");
		return "こんにちは";
	}
}
	
2. Bridge pattern:
- Bridge Pattern là một trong những Design Pattern thuộc nhóm Structural Pattern được sử dụng để tách biệt các class abstract (lớp trừu tượng) khỏi các implementations (khởi tạo) và đóng vai trò là cầu nối của chúng.
- Link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/structural/bridge/TPBank.java
package com.gpcoder.patterns.structural.bridge;

public class TPBank extends Bank {

	public TPBank(Account account) {
		super(account);
	}

	@Override
	public void openAccount() {
		System.out.print("Open your account at TPBank is a ");
		account.openAccount();
	}
}
	
3. Composite pattern:
- Composite Pattern được sử dụng khi chúng ta cần xử lý một nhóm các object tương tự như cách xử lý một object.
Điều này thường được thực hiện bới class “owns” của object và cung cấp một tập hợp các phương thức để xử lý chúng như thể xử lý một object.
- Link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/structural/composite/FolderComposite.java
package com.gpcoder.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class FolderComposite implements FileComponent {

	private List<FileComponent> files = new ArrayList<>();

	public FolderComposite(List<FileComponent> files) {
		this.files = files;
	}

	@Override
	public void showProperty() {
		for (FileComponent file : files) {
			file.showProperty();
		}
	}

	@Override
	public long totalSize() {
		long total = 0;
		for (FileComponent file : files) {
			total += file.totalSize();
		}
		return total;
	}
}
	
4. Decorator pattern:
- Decorator Pattern được sử dụng để thay đổi một instance riêng lẻ của một class, bằng cách tạo một class decorator bao bọc class gốc.
Bằng cách này, việc thay đổi hoặc thêm chức năng của object decorator sẽ không ảnh hưởng đến cấu trúc hoặc chức năng của object ban đầu.
Nó khác với kế thừa là nó được thực hiện trong thời gian chạy và chỉ áp dụng cho một cá thể, trong khi kế thừa sẽ ảnh hưởng đến tất cả các trường hợp.
- Link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/structural/decorator/TeamMember.java
package com.gpcoder.patterns.structural.decorator;

public class TeamMember extends EmployeeDecorator {

	protected TeamMember(EmployeeComponent employee) {
		super(employee);
	}

	public void reportTask() {
		System.out.println(this.employee.getName() + " is reporting his assigned tasks.");
	}

	public void coordinateWithOthers() {
		System.out.println(this.employee.getName() + " is coordinating with other members of his team.");
	}

	@Override
	public void doTask() {
		employee.doTask();
		reportTask();
		coordinateWithOthers();
	}
}
	
5. Facade pattern:
- Facade Pattern cung cấp một interface đơn giản và cao cấp nhất cho phía client (máy khách) và cho phép nó truy cập vào hệ thống mà không cần biết bên trong có logic hệ thống nào hay nó hoạt động như thế nào.
- Link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/structural/facade/ShopFacade.java
package com.gpcoder.patterns.structural.facade;

public class ShopFacade {

	private static final ShopFacade INSTANCE = new ShopFacade();

	private AccountService accountService;
	private PaymentService paymentService;
	private ShippingService shippingService;
	private EmailService emailService;
	private SmsService smsService;

	private ShopFacade() {
		accountService = new AccountService();
		paymentService = new PaymentService();
		shippingService = new ShippingService();
		emailService = new EmailService();
		smsService = new SmsService();
	}

	public static ShopFacade getInstance() {
		return INSTANCE;
	}

	public void buyProductByCashWithFreeShipping(String email) {
		accountService.getAccount(email);
		paymentService.paymentByCash();
		shippingService.freeShipping();
		emailService.sendMail(email);
		System.out.println("Done\n");
	}

	public void buyProductByPaypalWithStandardShipping(String email, String mobilePhone) {
		accountService.getAccount(email);
		paymentService.paymentByPaypal();
		shippingService.standardShipping();
		emailService.sendMail(email);
		smsService.sendSMS(mobilePhone);
		System.out.println("Done\n");
	}
}
	
6. Flyweight pattern:
- Flyweight Pattern được sử dụng để giảm sự căng thẳng cho JVM và bộ nhớ của nó. Điều này rất quan trọng đối với các thiết bị không có nhiều bộ nhớ, cũng như tối ưu hóa ứng dụng.
Khi một ứng dụng nhất định cần tạo nhiều instance của cùng một class. Khi đó một nhóm chung được tạo để các ứng dụng tương tự có thể được sử dụng lại, thay vì phải tạo lại.
Việc triển khai nổi tiếng nhất của Pattern này là String Pool trong Java. Các chuỗi được sử dụng thường xuyên hơn bất kỳ đối tượng nào khác trong ngôn ngữ và do đó, chúng tiêu thụ một phần lớn tài nguyên.
Bằng cách tạo một nhóm các chuỗi chung và gán nhiều biến tham chiếu cho các biến có cùng nội dung. Và chỉ tạo chuỗi mới khi không tìm thấy kết quả phù hợp sẽ ảnh hưởng rất lớn đến hiệu suất của Java.
- Link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/structural/flyweight/GameApp.java
package com.gpcoder.patterns.structural.flyweight;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Client
 */
public class GameApp {

	private static List<ISoldier> soldiers = new ArrayList<>();

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		createSoldier(5, "Yuri", 1);
		createSoldier(5, "Spy", 1);
		createSoldier(3, "Spy", 3);
		createSoldier(2, "Yuri", 2);
		long endTime = System.currentTimeMillis();
		System.out.println("---");
		System.out.println("Total soldiers made : " + soldiers.size());
		System.out.println("Total time worked : " + Duration.ofMillis(endTime - startTime).getSeconds() + " seconds");
		System.out.println("Total type of soldiers made : " + SoldierFactory.getTotalOfSoldiers());
	}

	private static void createSoldier(int numberOfSoldier, String soldierName, int numberOfStar) {
		for (int i = 1; i <= numberOfSoldier; i++) {
			Context star = new Context("Soldier" + (soldiers.size() + 1), numberOfStar);
			ISoldier soldier = SoldierFactory.createSoldier(soldierName);
			soldier.promote(star);
			soldiers.add(soldier);
		}
	}
}
								
7. Proxy pattern:
- Proxy Pattern được sử dụng khi chúng ta muốn giới hạn khả năng và chức năng của một class, bằng cách sử dụng một class khác giới hạn nó.
Bằng cách sử dụng class Proxy này, client sẽ sử dụng một interface đã xác định để truy cập vào class gốc. Điều này đảm bảo rằng client không thể làm thay đổi bất cứ điều gì với class ban đầu. Vì tất cả các yêu cầu của client đều được chuyển qua class Proxy để thực hiện.
- Link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/structural/proxy/protection/UserServiceProxy.java
```java
package com.gpcoder.patterns.structural.proxy.protection;

public class UserServiceProxy implements UserService {

	private String role;
	private UserService userService;

	public UserServiceProxy(String name, String role) {
		this.role = role;
		userService = new UserServiceImpl(name);
	}

	@Override
	public void load() {
		userService.load();
	}

	@Override
	public void insert() {
		if (isAdmin()) {
			userService.insert();
		} else {
			throw new IllegalAccessError("Access denied");
		}
	}

	private boolean isAdmin() {
		return "admin".equalsIgnoreCase(this.role);
	}
}
```
