# oop-2021
Môn học Lập trình hướng đối tượng với Java
+, creational design pattern:
link: https://github.com/ajanata/PretendYoureXyzzy/tree/master/src/main/java/net/socialgamer/cah
Singleton Pattern:
Khi nào sử dụng mẫu thiết kế Singleton
Đối với các resources khá đắt để tạo (như các đối tượng kết nối cơ sở dữ liệu).
Đó là một good practice để giữ tất cả các logger như Singletons làm tăng hiệu suất.
Các classes cung cấp quyền truy cập vào cài đặt cấu hình cho ứng dụng.
Các classes có chứa reesource được truy cập trong chế độ chia sẻ. 

trong bài Singleton được sử dụng trong HibernateUtil.java
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

+, Behavioral Pattern:
