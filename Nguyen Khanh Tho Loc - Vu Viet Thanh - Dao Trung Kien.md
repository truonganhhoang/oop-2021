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
