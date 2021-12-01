# **Báo cáo tìm hiểu về mẫu thiết kế**
## **Thành viên:**
- Lương Duy Đạt
- Lê Văn Minh
- Nguyễn Tấn Huy
## **Cách thức thực hiện bài báo cáo:** 
Các thành viên làm phần bài báo cáo của mình vào một cái google doc chung rồi một bạn sẽ phụ trách commit.

**[Link đến reposition được sử dụng trong bài báo cáo](https://github.com/bethrobson/Head-First-Design-Patterns)**

## **Các mẫu thiết kế được sử dụng trong reposition:**
### *Abstract Factory*: 
- Là một mẫu thiết kế sáng tạo cho phép bạn tạo ra các họ các đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng.
- Minh họa:  https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/abstract_factory/example/Demo.java

### *Adapter Pattern* 
- Là một mẫu thiết kế cấu trúc cho phép các đối tượng có giao diện không tương thích cộng tác.Đối tượng giúp kết nối các interface gọi là Adapter.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/adapter/example/Demo.java

### *Bridge Pattern* 
- Là một mẫu thiết kế cấu trúc cho phép bạn chia một lớp lớn hoặc một tập hợp các lớp có liên quan chặt chẽ thành hai phân cấp riêng biệt — trừu tượng và thực thi — có thể được phát triển độc lập với nhau.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/bridge/example/Demo.java

### *Builder pattern* 
- Là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và hình ảnh đại diện khác nhau của một đối tượng bằng cách sử dụng cùng một mã xây dựng.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/builder/example/Demo.java

### *Factory Method Pattern* 
- Là một mẫu thiết kế sáng tạo cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/factory_method/example/Demo.java

### *Facade Pattern* 
- Là một mẫu thiết kế sáng tạo cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/facade/example/Demo.java

### *Prototype pattern* 
- Là một mẫu thiết kế sáng tạo cho phép bạn sao chép các đối tượng hiện có mà không làm cho mã của bạn phụ thuộc vào các lớp của chúng.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/prototype/example/Demo.java

### *Chain_of_responsibility* 
- Là một mẫu thiết kế hành vi bao gồm một nguồn các đối tượng lệnh và một loạt các đối tượng xử lý. Mỗi đối tượng xử lý chứa logic xác định các loại đối tượng lệnh mà nó có thể xử lý, phần còn lại được chuyển cho đối tượng xử lý tiếp theo trong chuỗi.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/chain_of_responsibility/example/Demo.java

### *Command Pattern*  
- Là một mẫu thiết kế hành vi biến một yêu cầu thành một đối tượng độc lập chứa tất cả thông tin về yêu cầu. Sự chuyển đổi này cho phép bạn chuyển các yêu cầu dưới dạng đối số của phương thức, trì hoãn hoặc xếp hàng đợi việc thực hiện một yêu cầu và hỗ trợ các hoạt động hoàn tác.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/command/example/Demo.java

### *Composite Pattern* 
- Là một mẫu thiết kế cấu trúc cho phép bạn sắp xếp các đối tượng thành cấu trúc cây và sau đó làm việc với các cấu trúc này như thể chúng là các đối tượng riêng lẻ.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/composite/example/Demo.java

### *Decorator Pattern* 
- Là một mẫu thiết kế cấu trúc cho phép bạn đính kèm các hành vi mới vào các đối tượng bằng cách đặt các đối tượng này bên trong các đối tượng trình bao bọc đặc biệt có chứa các hành vi.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/decorator/example/Demo.java

### *Flyweight Pattern* 
- Là một mẫu thiết kế cấu trúc cho phép bạn lắp nhiều đối tượng hơn vào dung lượng RAM có sẵn bằng cách chia sẻ các phần trạng thái chung giữa nhiều đối tượng thay vì giữ tất cả dữ liệu trong mỗi đối tượng.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/flyweight/example/Demo.java

### *Interpreter Pattern* 
- Là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Interpreter Pattern giúp người lập trình có thể “xây dựng” những đối tượng “động” bằng cách đọc mô tả về đối tượng rồi sau đó “xây dựng” đối tượng đúng theo mô tả đó.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/interpreter/example/Demo.java

### *Iterator pattern* 
- Iterator là một mẫu thiết kế hành vi cho phép bạn duyệt qua các phần tử của một bộ sưu tập mà không để lộ biểu diễn cơ bản của nó (danh sách, ngăn xếp, cây, v.v.).

- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/iterator/example/Demo.java

### *Mediator Pattern* 
- Là một mẫu thiết kế hành vi cho phép bạn giảm bớt sự phụ thuộc hỗn loạn giữa các đối tượng. Mẫu hạn chế giao tiếp trực tiếp giữa các đối tượng và buộc chúng chỉ cộng tác thông qua một đối tượng trung gian.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/mediator/example/Demo.java

### *Memento* 
- Là một mẫu thiết kế hành vi cho phép bạn lưu và khôi phục trạng thái trước đó của một đối tượng mà không tiết lộ chi tiết về quá trình triển khai của nó.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/memento/example/Demo.java 


### *Observer pattern* 
- Là một mẫu thiết kế hành vi cho phép bạn xác định cơ chế đăng ký để thông báo cho nhiều đối tượng về bất kỳ sự kiện nào xảy ra với đối tượng mà họ đang quan sát.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/observer/example/Demo.java

### *Proxy Pattern* 
- Là mẫu thiết kế mà ở đó tất cả các truy cập trực tiếp đến một đối tượng nào đó sẽ được chuyển hướng vào một đối tượng trung gian (Proxy Class). Mẫu Proxy (người đại diện) đại diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với múc đích sử dụng.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/proxy/example/Demo.java

### *Single Pattern* 
- Là một design pattern mà
    Đảm bảo rằng một class chỉ có duy nhất một instance (khởi tạo - mình xin phép để nguyên không dịch từ này)
    Và cung cấp một cáchs toàn cầu để truy cấp tới instance đó.

- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/singleton/example/non_thread_safe/Singleton.java

### *State Pattern* 
- Là một trong những mẫu thiết kế thuộc nhóm behavioral cho phép một object có thể biến đổi hành vi của nó khi có những sự thay đổi trạng thái nội bộ.
-Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/state/example/Demo.java

### *Strategy pattern* 
- Là một mẫu thiết kế hành vi cho phép bạn xác định một nhóm thuật toán, đặt mỗi thuật toán vào một lớp riêng biệt và làm cho các đối tượng của chúng có thể hoán đổi cho nhau.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/strategy/example/Demo.java

### *Template Method Pattern* 
- Là một mẫu thiết kế hành vi xác định khung của một thuật toán trong lớp cha nhưng cho phép các lớp con ghi đè các bước cụ thể của thuật toán mà không thay đổi cấu trúc của nó.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/template_method/example/Demo.java

### *Visitor* 
- Là mẩu thiết kế(Design Patterns là một mẫu thiết kế hành vi cho phép bạn tách các thuật toán khỏi các đối tượng mà chúng hoạt động trên đó.
- Minh họa: https://github.com/RefactoringGuru/design-patterns-java/blob/master/src/refactoring_guru/visitor/example/Demo.java

## **Kết luận:** 
Trong dự án mà nhóm tìm hiểu, mẫu thiết kế được sử dụng khá tương đồng với 23 mẫu thiết kế chuẩn.
