# oop-2021
Môn học Lập trình hướng đối tượng với Java
Thành viên nhóm:
* 20021389 Nguyễn Khánh Thọ Lộc.
* 20021436 Vũ Viết Thành.
* 20020182 Đào Trung Kiên.

***Creational design pattern:
link: https://github.com/ajanata/PretendYoureXyzzy/tree/master/src/main/java/net/socialgamer/cah

1, Singleton Pattern:
- Đảm bảo 1 class chỉ có 1 instance và cung cấp 1 điểm truy xuất toàn cục đến nó.

**Khi nào sử dụng mẫu thiết kế Singleton
Đối với các resources khá đắt để tạo (như các đối tượng kết nối cơ sở dữ liệu).
Đó là một good practice để giữ tất cả các logger như Singletons làm tăng hiệu suất.
Các classes cung cấp quyền truy cập vào cài đặt cấu hình cho ứng dụng.
Các classes có chứa reesource được truy cập trong chế độ chia sẻ. 

Trong bài Singleton được sử dụng trong HibernateUtil.java
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

2, Factory Method Design Pattern:
- Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.

ví dụ : trong CacheControlFilter.java 
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
**Khi nào sử dụng mẫu thiết kế Factory Method:
Khi việc implementation một interface hoặc một abstract class dự kiến sẽ thay đổi thường xuyên.
Khi implementation hiện tại không thể dễ dàng thích ứng với thay đổi mới.
Khi quá trình khởi tạo tương đối đơn giản và hàm tạo chỉ yêu cầu một số tham số.  


3, Builder Design Pattern trong Constant.java:
- Tách rời việc xây dựng (construction) một đối tượng phức tạp khỏi biểu diễn của nó sao cho cùng một tiến trình xây dựng có thể tạo được các biểu diễn khác nhau.

@Override
    public String toString() {
      return event;
    }
@Override
    public String toString() {
      return code;
    }
@Override
    public String getString() {
      return message;
    }
**Khi nào sử dụng mẫu thiết kế Builder:
Khi xử lý liên quan đến việc tạo một đối tượng là vô cùng phức tạp, với rất nhiều tham số bắt buộc và tùy chọn
Khi sự gia tăng số lượng tham số của hàm tạo dẫn đến một danh sách lớn các hàm tạo
Khi client muốn các biểu diễn khác nhau cho đối tượng được xây dựng
 

4, Abstract Factory Design Pattern dùng trong Constants.java:
Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng

ví dụ:
 public enum DisconnectReason implements Localizable{
 }
 public enum AjaxResponse implements ReturnableData{
 }
 public enum ErrorInformation implements ReturnableData{
 }
 public enum LongPollResponse implements ReturnableData{
 }

5, Prototype Pattern:
- Qui định loại của các đối tượng cần tạo bằng cách dùng một đối tượng mẫu, tạo mới nhờ vào sao chép đối tượng mẫu này.
link ví dụ: https://github.com/gpcodervn/Design-Pattern-Tutorial/blob/master/DesignPatternTutorial/src/com/gpcoder/patterns/creational/prototype/computer/Computer.java

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

***Behavioral Design Patterns:
link:https://github.com/sherxon/AlgoDS.git

1, Command Pattern trong Interval.java. 
Command Pattern được tạo ra để lưu trữ các câu lệnh và trạng thái của object. Nó cho phép tất cả những yêu cầu gửi đến object đó dưới dạng một object Command.
Khi nó tìm được cách giải quyết thích hợp, nó sẽ chuyển đến Command, nơi mà nó sẽ được thực thi.

public class Interval { 
 public int start; public int end;

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

public class Vertex<T> {
    private T value;
    private Set<Vertex<T>> neighbors; // used with Unweighted graphs
    private Vertex<T> parent; // used in dfs and bfs
    private boolean visited; //used for bfs and dfs
    private Number weight;
    public Vertex(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

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
