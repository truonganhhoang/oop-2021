Danh sách thành viên: Nguyễn Tuấn Nam, Đỗ Anh Tú, Lương Trung Kiên

Link repo sử dụng: https://github.com/square/retrofit

## Factory Method
interface: https://github.com/square/retrofit/blob/515bfc977fbc567919a595206749256f5a8b4620/retrofit/src/main/java/retrofit2/CallAdapter.java#L28


families class: https://github.com/square/retrofit/blob/master/retrofit-adapters/guava/src/main/java/retrofit2/adapter/guava/GuavaCallAdapterFactory.java
+ private static final class BodyCallAdapter<R> implements CallAdapter<R, ListenableFuture<R>>
+ private static final class ResponseCallAdapter<R>
  implements CallAdapter<R, ListenableFuture<Response<R>>>

Factory Method Design Pattern hay gọi ngắn gọn là Factory Pattern là một trong những Pattern thuộc nhóm Creational Design Pattern. Nhiệm vụ của Factory Pattern là quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn.

Factory Pattern đúng nghĩa là một nhà máy, và nhà máy này sẽ “sản xuất” các đối tượng theo yêu cầu của chúng ta.

Trong Factory Pattern, chúng ta tạo đối tượng mà không để lộ logic tạo đối tượng ở phía người dùng và tham chiếu đến đối tượng mới được tạo ra bằng cách sử dụng một interface chung.

Factory Pattern được sử dụng khi có một class cha (super-class) với nhiều class con (sub-class), dựa trên đầu vào và phải trả về 1 trong những class con đó.
  
**Giống nhau**:
- Giống với mẫu chuẩn
  
**Khác nhau**:  
- có 1 số function không bị ghi đè



## Prototype
```
public final class HttpException extends retrofit2.HttpException {
public HttpException(Response<?> response) {
super(response);
}
}
```
link:https://github.com/square/retrofit/blob/515bfc977fbc567919a595206749256f5a8b4620/retrofit-adapters/java8/src/main/java/retrofit2/adapter/java8/HttpException.java#L22
```
public final class Java8OptionalConverterFactory extends Converter.Factory {
  public static Java8OptionalConverterFactory create() {
    return new Java8OptionalConverterFactory();
 }
```

Prototype pattern đề cập đến việc tạo Object trùng lặp trong khi vẫn giữ được hiệu suất trong quá trình, là một pattern thuộc nhóm Creational Patterns.
Kiểu design pattern này được tạo ra theo mô hình Creational Pattern vì Pattern này cung cấp một trong những cách tốt nhất để tạo ra một đối tượng thay vì tạo ra Object, Prototype pattern sử dụng việc cloning (copy nguyên mẫu của Object). Ví dụ, một Object sẽ được tạo ra sau khi một hoạt động cơ sở dữ liệu tốn kém. Chúng ta có thể cache Object, trả về clone của nó theo yêu cầu tiếp theo và cập nhật cơ sở dữ liệu khi nào cần và do đó giảm các cuộc gọi cơ sở dữ liệu.

**Giống nhau**:
- Prototype gần như giống hệt so với mẫu chuẩn : cho phép khởi tạo một đối tượng bằng cách sao chép từ một đối tượng khác đã tồn tại thay vì sử dụng toán tử new.

link: https://github.com/square/retrofit/blob/master/retrofit-converters/java8/src/main/java/retrofit/converter/java8/Java8OptionalConverterFactory.java


## Builder 

```
  public static final class Builder {
    private final Retrofit retrofit;
    private @Nullable NetworkBehavior behavior;
    private @Nullable ExecutorService executor;

    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public Builder(Retrofit retrofit) {
      if (retrofit == null) throw new NullPointerException("retrofit == null");
      this.retrofit = retrofit;
    }

    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public Builder networkBehavior(NetworkBehavior behavior) {
      if (behavior == null) throw new NullPointerException("behavior == null");
      this.behavior = behavior;
      return this;
    }

    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public Builder backgroundExecutor(ExecutorService executor) {
      if (executor == null) throw new NullPointerException("executor == null");
      this.executor = executor;
      return this;
    }

    public MockRetrofit build() {
      if (behavior == null) behavior = NetworkBehavior.create();
      if (executor == null) executor = Executors.newCachedThreadPool();
      return new MockRetrofit(retrofit, behavior, executor);
    } 
```

Builder pattern là một trong những Creational pattern. Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.

Builder Pattern được xây dựng để khắc phục một số nhược điểm của Factory Pattern và Abstract Factory Pattern khi mà Object có nhiều thuộc tính.

Có ba vấn đề chính với  Factory Pattern và Abstract Factory Pattern khi Object có nhiều thuộc tính:

- Quá nhiều tham số phải truyền vào từ phía client tới Factory Class.
- Một số tham số có thể là tùy chọn nhưng trong Factory Pattern, chúng ta phải gửi tất cả tham số, với tham số tùy chọn nếu không nhập gì thì sẽ truyền là null.
- Nếu một Object có quá nhiều thuộc tính thì việc tạo sẽ phức tạp.

**Giống nhau**: 
- Giống với mẫu chuẩn.
- Build từ Retrofit, NetworkBehavior và ExecutorService


**Khác biệt**:
- Không có.

https://github.com/square/retrofit/blob/master/retrofit-mock/src/main/java/retrofit2/mock/MockRetrofit.java









