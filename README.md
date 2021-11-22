# oop-2021
Môn học Lập trình hướng đối tượng với Java
***Creational design pattern:

link: https://github.com/ajanata/PretendYoureXyzzy/tree/master/src/main/java/net/socialgamer/cah
Singleton Pattern:
Khi nào sử dụng mẫu thiết kế Singleton
Đối với các resources khá đắt để tạo (như các đối tượng kết nối cơ sở dữ liệu).
Đó là một good practice để giữ tất cả các logger như Singletons làm tăng hiệu suất.
Các classes cung cấp quyền truy cập vào cài đặt cấu hình cho ứng dụng.
Các classes có chứa reesource được truy cập trong chế độ chia sẻ. 

***trong bài Singleton được sử dụng trong HibernateUtil.java

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

***Factory Method Design Pattern

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

***Builder Design Pattern trong Constant.java

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

**Khi nào sử dụng mẫu thiết kế Factory Method:
Khi việc implementation một interface hoặc một abstract class dự kiến sẽ thay đổi thường xuyên.
Khi implementation hiện tại không thể dễ dàng thích ứng với thay đổi mới.
Khi quá trình khởi tạo tương đối đơn giản và hàm tạo chỉ yêu cầu một số tham số.

***Abstract Factory Design Pattern dùng trong Constants.java 

 public enum DisconnectReason implements Localizable{
 }
 public enum AjaxResponse implements ReturnableData{
 }
 public enum ErrorInformation implements ReturnableData{
 }
 public enum LongPollResponse implements ReturnableData{
 }
+, Behavioral Pattern:
link:https://github.com/sherxon/AlgoDS.git
* Command Pattern trong Interval.java
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

* Observer Pattern trong ValidateCard.
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
