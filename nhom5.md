Danh sách thành viên: Nguyễn Tuấn Nam, Đỗ Anh Tú, Lương Trung Kiên

Link repo sử dụng: https://github.com/square/retrofit

##Factory Method
interface: https://github.com/square/retrofit/blob/515bfc977fbc567919a595206749256f5a8b4620/retrofit/src/main/java/retrofit2/CallAdapter.java#L28


families class: https://github.com/square/retrofit/blob/master/retrofit-adapters/guava/src/main/java/retrofit2/adapter/guava/GuavaCallAdapterFactory.java
+ private static final class BodyCallAdapter<R> implements CallAdapter<R, ListenableFuture<R>>
+ private static final class ResponseCallAdapter<R>
  implements CallAdapter<R, ListenableFuture<Response<R>>>


##Prototype

public final class HttpException extends retrofit2.HttpException {
public HttpException(Response<?> response) {
super(response);
}
}

link:https://github.com/square/retrofit/blob/515bfc977fbc567919a595206749256f5a8b4620/retrofit-adapters/java8/src/main/java/retrofit2/adapter/java8/HttpException.java#L22







