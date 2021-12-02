# OOP-2021
Môn học Lập trình hướng đối tượng với Java <br />
Thành viên Nhóm: <br />
+ Dương Bình Cương<br />
+ Vũ Minh Chiến<br /> 
+ Nghiêm Văn Quang<br />

Link github sử dụng : https://github.com/halo-dev/halo.git<br />
Link tài liệu: https://refactoring.guru/design-patterns/catalog<br /><br />
***Iterator**
_- Giống nhau:_
Duyệt qua các phần tử của một bộ sưu tập mà không để lộ biểu diễn cơ bản của nó (danh sách, ngăn xếp, cây, v.v.).
Trình lặp thực hiện các thuật toán duyệt khác nhau. Một số đối tượng trình lặp có thể duyệt cùng một bộ sưu tập cùng một lúc.

_- Khác nhau:_
Trình lặp đóng gói các chi tiết làm việc với cấu trúc dữ liệu phức tạp
Mã của các thuật toán lặp không tầm thường có xu hướng rất cồng kềnh
Mẫu cung cấp một vài giao diện chung cho cả bộ sưu tập và trình vòng lặp

**Mediator**
_Giống nhau:_
Giảm bớt sự phụ thuộc hỗn loạn giữa các đối tượng. Mẫu hạn chế giao tiếp trực tiếp giữa các đối tượng và buộc chúng chỉ cộng tác thông qua một đối tượng trung gian.
Các phần tử giao diện người dùng giao tiếp gián tiếp, thông qua đối tượng trung gian.

_Khác nhau:_
Khó thay đổi một số lớp
Không thể sử dụng lại một thành phần trong một chương trình khác vì nó quá phụ thuộc vào các thành phần khác.

**Memento**
_Giống nhau:_
Cho phép lưu và khôi phục trạng thái trước đó của một đối tượng mà không tiết lộ chi tiết về quá trình triển khai của nó.
Người tạo có toàn quyền truy cập vào memento, trong khi người chăm sóc chỉ có thể truy cập siêu dữ liệu.

_Khác nhau:_
Có thể khôi phục trạng thái trước đó của đối tượng.
Không đối tượng nào khác có thể đọc ảnh chụp nhanh, làm cho dữ liệu trạng thái của đối tượng ban đầu được an toàn và bảo mật.

**Builder**

+ Mẫu thiết kế Builder: Là một mẫu thiết kế thuộc "nhóm khởi tạo" (Creational Pattern). Mẫu thiết kế này cho phép lập trình viên tạo ra những đối tượng phức tạp nhưng chỉ cần thông qua các câu lệnh đơn giản để tác động nên các thuộc tính của nó. 
+ Một số tham số có thể là tùy chọn nhưng trong Factory Pattern, chúng ta phải gửi tất cả tham số, với tham số tùy chọn nếu không nhập gì thì sẽ truyền là null
+ Tách construction một đối tượng phức tạp khỏi biểu diễn của nó để các construction giống nhau có thể tạo ra các biểu diễn khác nhau
+ Gồm các thành phần: Product(class Building), Builder(class HomeBuilder), Director(class HomeDirector), ConcreteBuilder(class FlatBuilder)
+ Nếu một Object có quá nhiều thuộc tính thì việc tạo sẽ phức tạp.

_Trong file Student.java link repo có các thành phần cấu trúc Product,Builder, Director, ConcretBuilder_

// Product 
...
    public Student(String id, String firstName, String lastName, String dayOfBirth, String currentClass, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.currentClass = currentClass;
        this.phone = phone;
    }
// Builder 
public interface StudentBuilder {

    StudentBuilder setId(String id);

    StudentBuilder setFirstName(String firstName);

    StudentBuilder setLastName(String lastName);

    StudentBuilder setDayOfBirth(String dayOfBirth);

    StudentBuilder setCurrentClass(String currentClass);

    StudentBuilder setPhone(String phone);

    Student build();
}
=> 
// ConcreteBuilder
public class StudentConcreteBuilder implements StudentBuilder {

    private String id;
    private String firstName;
    private String lastName;
    private String dayOfBirth;
    private String currentClass;
    private String phone;

    @Override
    public StudentBuilder setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public StudentBuilder setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
        return this;
    }

    @Override
    public StudentBuilder setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
        return this;
    }

    @Override
    public StudentBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public Student build() {
        return new Student(id, firstName, lastName, dayOfBirth, currentClass, phone);
    }
}

_Giống nhau:_
+ giống với mẫu chuẩn.

_Khác nhau:_
+ Về cơ bản, cách tiếp cận của youlookwhat không có khác biệt đối với cách kinh điển của GOF.


**Singleton**

Singeton pattern thuộc loại Creational Design Pattern. Single Pattern là một design pattern mà đảm bảo rằng một class chỉ có duy nhất một instance và cung cấp một cáchs toàn cầu để truy cấp tới instance đó.

_trong file Initialized.java được sử dụng như sau:_
```

public class EagerInitializedSingleton {

   private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

   //private constructor to avoid client applications to use constructor
   private EagerInitializedSingleton(){}

   public static EagerInitializedSingleton getInstance(){
       return instance;
   }
}
```
_Giống nhau:_
Giống mới mẫu thiết kế mẫu

_Khác nhau:_


**Adapter**
- Adapter pattern là một Structural pattern. Adapter pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng xây dựng và xử lí các dao diện khác nhau nhưng lại có hành vi giống nhau( Các lớp có hành vi tương tự nhưng phương thức khác nhau ).

- Trong file FrameCursor.java chúng ta có thế thấy mẫu thiết kế này
 
```
    public class NullIndexFrameCursor implements IndexFrameCursor {
        public static final NullIndexFrameCursor INSTANCE = new NullIndexFrameCursor();
        @Override
        public IndexFrame getNext() {
            return IndexFrame.NULL_INSTANCE;
        }
    }
```
```
    private class Cursor implements RowCursor, IndexFrameCursor {
        protected long valueCount;
        protected long minValue;
        protected long next;
        private long valueBlockOffset;
        private final BitmapIndexUtils.ValueBlockSeeker SEEKER = this::seekValue;
        @Override
        public IndexFrame getNext() {
            // See BitmapIndexFwdReader if it needs implementing
            throw new UnsupportedOperationException();
        }
        ...
      }
```

```
// Check is installed
boolean isInstalled = optionService
    .getByPropertyOrDefault(PrimaryProperties.IS_INSTALLED, Boolean.class, false);

if (isInstalled) {
    throw new BadRequestException("该博客已初始化，不能再次安装！");
}

// Initialize settings
initSettings(installParam);

// Create default user
User user = createUser(installParam);

// Create default category
Category category = createDefaultCategoryIfAbsent();

// Create default post
PostDetailVO post = createDefaultPostIfAbsent(category);

// Create default sheet
createDefaultSheet();

// Create default postComment
createDefaultComment(post);

// Create default menu
createDefaultMenu();

eventPublisher.publishEvent(
    new LogEvent(this, user.getId().toString(), LogType.BLOG_INITIALIZED, "博客已成功初始化")
);

return BaseResponse.ok("安装完成！");
```
