Danh sách thành viên: Nguyễn Tuấn Nam, Đỗ Anh Tú, Lương Trung Kiên

Link repo sử dụng: https://github.com/square/retrofit

## Factory Method
interface: https://github.com/square/retrofit/blob/515bfc977fbc567919a595206749256f5a8b4620/retrofit/src/main/java/retrofit2/CallAdapter.java#L28


families class: https://github.com/square/retrofit/blob/master/retrofit-adapters/guava/src/main/java/retrofit2/adapter/guava/GuavaCallAdapterFactory.java
+ private static final class BodyCallAdapter<R> implements CallAdapter<R, ListenableFuture<R>>
+ private static final class ResponseCallAdapter<R>
  implements CallAdapter<R, ListenableFuture<Response<R>>>


## Prototype

public final class HttpException extends retrofit2.HttpException {
public HttpException(Response<?> response) {
super(response);
}
}

link:https://github.com/square/retrofit/blob/515bfc977fbc567919a595206749256f5a8b4620/retrofit-adapters/java8/src/main/java/retrofit2/adapter/java8/HttpException.java#L22

public final class Java8OptionalConverterFactory extends Converter.Factory {
  public static Java8OptionalConverterFactory create() {
    return new Java8OptionalConverterFactory();
 }

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

**Giống nhau**: 
- Giống với mẫu chuẩn.
- Build từ Retrofit, NetworkBehavior và ExecutorService
- Prototype gần như giống hệt so với mẫu chuẩn : cho phép khởi tạo một đối tượng bằng cách sao chép từ một đối tượng khác đã tồn tại thay vì sử dụng toán tử new.

**Khác biệt**:
- Không có.

https://github.com/square/retrofit/blob/master/retrofit-mock/src/main/java/retrofit2/mock/MockRetrofit.java









