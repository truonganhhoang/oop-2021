# Báo cáo bài tập Design Pattern

## 1. Các thành viên nhóm: 
### - Trần Thị Ngân - 20021399
### - Lê Thị Cẩm Nhung - 20021408
### - Phạm Thị Quyên - 20021421

## 2. Link đến reposition được sử dụng trong bài báo cáo: 
### - [signalapp/Signal-Android](https://github.com/signalapp/Signal-Android)
### - [landy8530/DesignPatterns](https://github.com/landy8530/DesignPatterns)
### - [HAOGRE/Jnotes](https://github.com/HAOGRE/Jnotes)

## 3. So sánh
### Factory Method
* Factory method là để đưa toàn bộ logic của việc tạo mới object vào trong factory, che giấu logic của việc khởi tạo.Được định nghĩa interface giúp client tạo object nhưng ủy quyền cho các concreate factory để xác định class nào được trả về cho client.
* Factory Method: [SignalMediaSourceFactory](https://github.com/signalapp/SignalAndroid/blob/a5e5a735800cbdb3afa01a67390b6efa2fc91be6/app/src/main/java/org/thoughtcrime/securesms/video/exo/SignalMediaSourceFactory.java)
trong đó factory method khác so với mẫu tiêu chuẩn bởi vì ở mẫu tiêu chuẩn dùng factory method để tạo(sản xuất) ra các đối tượng. Trong khi đó, ở đây đã dùng để override các phương thức.

### Abstract Factory
* Link [AbstractFactory](https://github.com/landy8530/DesignPatterns/blob/be08a3ff79094c8dff94fdeb555047aa4620bf43/design-patterns-basic/src/main/java/org/landy/factory/abstr/AbstractFactory.java)
* Với ý tưởng tạo ra một kiểu trừu tượng (abstract type) để dùng vào việc tạo ra một nhóm những products khác.
* Abstract platform : AbstractFactory, SenderFactory.

### Facade pattern
* Facade Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Pattern này cung cấp một giao diện chung đơn giản thay cho một nhóm các giao diện có trong một hệ thống con (subsystem).
* Facade Pattern định nghĩa một giao diện ở một cấp độ cao hơn để giúp cho người dùng có thể dễ dàng sử dụng hệ thống con này: [IdentifyTest](https://github.com/landy8530/DesignPatterns/blob/be08a3ff79094c8dff94fdeb555047aa4620bf43/design-patterns-business/src/test/java/business/identify/IdentifyTest.java)

### Builder pattern
* Builder pattern được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.
* Kó đầy đủ 4 thành phần: Director, Product ([Block](https://github.com/prestodb/presto/blob/2ad67dcf000be86ebc5ff7732bbb9994c8e324a8/presto-common/src/main/java/com/facebook/presto/common/block/Block.java)), ConcreteBuilder ([SingleArrayBlockWriter](https://github.com/prestodb/presto/blob/2ad67dcf000be86ebc5ff7732bbb9994c8e324a8/presto-common/src/main/java/com/facebook/presto/common/block/SingleArrayBlockWriter.java)), Builder ([BlockBuilder](https://github.com/prestodb/presto/blob/2ad67dcf000be86ebc5ff7732bbb9994c8e324a8/presto-common/src/main/java/com/facebook/presto/common/block/BlockBuilder.java#L19))
* Không có sự khác nhau lắm giữa mẫu thiết kế Builder chuẩn.
* Abstract class Builder ([BlockBuilder](https://github.com/prestodb/presto/blob/2ad67dcf000be86ebc5ff7732bbb9994c8e324a8/presto-common/src/main/java/com/facebook/presto/common/block/BlockBuilder.java#L19)) khai báo các method cần được triển khai bên trong các class kế thừa. Còn method này sẽ trả về chính class BlockBuilder đễ quá trình khởi tạo tiếp tục được diễn ra. Bên trong class kế thừa có một hàm gọi là build() tương ứng với việc trả về kết quả cuối cùng của quá trình khởi tạo

### Decorator pattern
* Decorator pattern cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác.
* Có sự khác biệt với mẫu thiết kế Decorator chuẩn: không đầy đủ 5 thành phần
* Decorator [PaymentDecorator](https://github.com/signalapp/Signal-Android/blob/24ac705fe89ce41f78db42f17dfb4bf8da789c53/app/src/main/java/org/thoughtcrime/securesms/payments/PaymentDecorator.java)
* Component [Payment](https://github.com/signalapp/Signal-Android/blob/24ac705fe89ce41f78db42f17dfb4bf8da789c53/app/src/main/java/org/thoughtcrime/securesms/payments/Payment.java#L20): quy định các method chung
* ConcreteDecorator [BlockOverridePayment](https://github.com/signalapp/Signal-Android/blob/24ac705fe89ce41f78db42f17dfb4bf8da789c53/app/src/main/java/org/thoughtcrime/securesms/payments/reconciliation/LedgerReconcile.java#L238): cài đặt thêm các tính năng mới cho Payment

### Proxy
* Không có sự khác biệt so với mẫu thiết kế chuẩn: đầy đủ các thành phần
* Subject ([PagingController](https://github.com/signalapp/Signal-Android/blob/8c9eb880cf9cd9c5cac0364f4f0ff47702fca091/paging/lib/src/main/java/org/signal/paging/PagingController.java#L4))
* Proxy ([ProxyPagingController](https://github.com/signalapp/Signal-Android/blob/8c9eb880cf9cd9c5cac0364f4f0ff47702fca091/paging/lib/src/main/java/org/signal/paging/ProxyPagingController.java)): tất cả các truy cập trực tiếp đến một đối tượng PagingController sẽ được chuyển hướng vào một đối tượng trung gian ProxyPagingController
* RealSubject [BufferedPagingController](https://github.com/signalapp/Signal-Android/blob/8c9eb880cf9cd9c5cac0364f4f0ff47702fca091/paging/lib/src/main/java/org/signal/paging/BufferedPagingController.java), [FixedSizePagingController](https://github.com/signalapp/Signal-Android/blob/8c9eb880cf9cd9c5cac0364f4f0ff47702fca091/paging/lib/src/main/java/org/signal/paging/FixedSizePagingController.java)
* [Client](https://github.com/signalapp/Signal-Android/blob/223c0c4bce348749917856809c3eb6f9df4b0567/app/src/main/java/org/thoughtcrime/securesms/logsubmit/SubmitDebugLogViewModel.java#L39)

### Chain of Responsibility
* Chain of Responsibility cho phép chuyển các yêu cầu dọc theo một chuỗi các trình xử lý cho đến khi có một đối tượng xử lý nó.
* Cơ bản không có sự khác nhau so với mẫu thiết kế tiêu chuẩn
* [UnreadPayments](https://github.com/signalapp/Signal-Android/blob/24ac705fe89ce41f78db42f17dfb4bf8da789c53/app/src/main/java/org/thoughtcrime/securesms/conversationlist/model/UnreadPayments.java)
* Khi qua mỗi một handler, handler kiểm tra xem mình có đủ tài nguyên, thông tin và thẩm quyền đối với yêu cầu đó hay không. Nếu đáp ứng yêu cầu, handler sẽ xử lý yêu cầu đó. Nếu không đáp ứng yêu cầu, handler sẽ chuyển tiếp yêu cầu sang handler tiếp theo trong chuỗi, tiếp diễn cho đến khi tìm được một handler phù hợp sẽ xử lý yêu cầu đó.

### Iterator pattern
* Iterator cho phép xử lý nhiều loại tập hợp khác nhau bằng cách truy cập những phần tử của tập hợp với cùng một phương pháp, cùng một cách thức định sẵn, mà không cần phải hiểu rõ về những chi tiết bên trong của những tập hợp này.
* Có sự khác nhau nhỏ so với mẫu thiết kế chuẩn. Trong repo này, Interator Pattern được áp dụng với Interface iterator trong gói java.util.Iterator ([CharacterIterator](https://github.com/signalapp/Signal-Android/blob/d74e9f74103ad76eb7b5378e06fb789e7b365767/app/src/main/java/org/thoughtcrime/securesms/util/CharacterIterable.java#L26))

### Memento pattern
* Memento là mẫu thiết kế có thể lưu lại trạng thái của một đối tượng để khôi phục lại sau này mà không vi phạm nguyên tắc đóng gói.
* Cơ bản không có sự khác biệt so với mẫu thiết kế tiêu chuẩn.
* Có đầy đủ các thành phần:
* Originator ([BlankOriginator](https://github.com/HAOGRE/Jnotes/blob/master/src/com/haogre/dp/memento/BlackMemento.java#L19)): Đại diện cho đối tượng mà muốn lưu. Nó sử dụng memento để lưu và khôi phục trạng thái bên trong của nó.
* Caretaker ([BlackCareTaker](https://github.com/HAOGRE/Jnotes/blob/master/src/com/haogre/dp/memento/BlackMemento.java#L53)): Nó giữ đối tượng memento và chịu trách nhiệm bảo vệ an toàn cho các đối tượng. Để khôi phục trạng thái trước đó, nó trả về đối tượng memento cho BlackOriginator.
* Memento ([BlackMemento](https://github.com/HAOGRE/Jnotes/blob/master/src/com/haogre/dp/memento/BlackMemento.java#L10)): Đại diện cho một đối tượng để lưu trữ trạng thái của BlackOriginator. Nó bảo vệ chống lại sự truy cập của các đối tượng khác ngoài BlackOriginator.

### Mediator
* Mediator Patern sử dụng để giảm sự phức tạp trong giao tiếp giữa các lớp và các đối tượng, cung cấp một lớp trung gian có nhiệm vụ xử lý thông tin liên lạc giữa các tầng lớp, hỗ trợ bảo trì mã code dễ dàng bằng cách khớp nối lỏng lẻo.
* Có sự khác biệt nhỏ so với mẫu thiết kế tiêu chuẩn:
* Không tạo Mediator Interface mà sử dụng TabLayoutMediator (import com.google.android.material.tabs.TabLayoutMediator)
* Thành phần Colleague CustomChatColorCreatorFragment giữ tham chiếu đến [TabLayoutMediator](https://github.com/signalapp/Signal-Android/blob/811bef8c35291219b13a0995dfb8a50ef6d6b3d7/app/src/main/java/org/thoughtcrime/securesms/conversation/colors/ui/custom/CustomChatColorCreatorFragment.kt#21)

### Bridge Pattern:
*là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Ý tưởng của nó là tách tính trừu tượng (abstraction) ra khỏi tính hiện thực (implementation) của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu.
* ![Bridge Pattern](https://github.com/baomidou/dynamic-datasource-spring-boot-starter/tree/master/src/main/java/com/baomidou/dynamic/datasource/creator)
* INTERFACE: ![Ví dụ](https://github.com/baomidou/dynamic-datasource-spring-boot-	starter/blob/master/src/main/java/com/baomidou/dynamic/datasource/creator/DataSourceCreator.java)
* Abstraction : định ra một abstract interface quản lý việc tham chiếu đến đối tượng hiện thực cụ thể (Implementor).
![]()

### Adapter pattern:
* là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Adapter Pattern cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.
* ![Adapter pattern](https://github.com/Islam031218/library/blob/79f25a45f2e0c920c494e06e9f2a2ca818908e1d/S%D1%81hoolProject/Main.java) 
	->BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	->InputStreamReader : đây là một Adapter ở giữa hai interface không tương thích: System.in và BufferedReader giúp cho chúng có thể hoạt động được với nhau.
* Cho phép nhiều đối tượng có interface giao tiếp khác nhau có thể tương tác và giao tiếp với nhau.
* Tăng khả năng sử dụng lại thư viện với interface không thay đổi do không có mã nguồn.

### Singleton pattern:
* ![Singleton pattern](https://github.com/signalapp/Signal-Android/blob/018782e63dd9ab345db87a2e57bf11720ede45b6/app/src/main/java/org/thoughtcrime/securesms/dependencies/ApplicationDependencies.java)
Giống nhau
* Đảm bảo rằng một class chỉ có duy nhất một instance.
* Và cung cấp một cách toàn cầu để truy cấp tới instance đó.

### Prototype pattern:
* ![Prototype pattern](https://github.com/Dempsy/dempsy/blob/642c357f1be5e9cd5a864965bbf694d24e08a5fc/dempsy-framework.api/src/test/java/net/dempsy/lifecycle/annotations/TestMps.java)
* Giảm việc phân lớp, tránh việc tạo nhiều lớp con cho việc khởi tạo đối tượng 
* Giảm độ phức tạp cho việc khởi tạo đối tượng
	`public static class TestMp implements Cloneable {
        public boolean activated = false;
        public boolean passivateCalled = false;

        @MessageHandler
        public void handleMsg(final Message val) {}

        @Activation
        public void activate(final String key, final byte[] data) {
            this.activated = true;
        }

        @Passivation
        public byte[] passivate() {
            passivateCalled = true;
            return "passivate".getBytes();
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }`

### Visitor Pattern:
* ![Visistor pattern 1](https://github.com/mirsfang/ExamplesOfDesignPatterns/blob/master/src/action/visitor/visitorAbs/IVisitor.java)
* ![Visistor pattern 2](https://github.com/mirsfang/ExamplesOfDesignPatterns/blob/master/src/action/visitor/visitorIml/Visitor.java)
* Cho phép một hoặc nhiều hành vi được áp dụng cho một tập hợp các đối tượng tại thời điểm run-time, tách rời các hành vi khỏi cấu trúc đối tượng.
* Đảm bảo nguyên tắc Open/ Close: đối tượng gốc không bị thay đổi, dễ dàng thêm hành vi mới cho đối tượng thông qua visitor

### Composite pattern:
* ![Composite](https://github.com/landy8530/DesignPatterns/blob/master/design-patterns-business/src/main/java/org/landy/business/domain/file/CustomerRequestFile.java)
	->abtract RequestFile<CustomerRequestDetail>;
* Cung cấp cùng một cách sử dụng đối với từng đối tượng riêng lẻ hoặc nhóm các đối tượng với nhau


### State pattern:
* Cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
* ![State pattern 1](https://github.com/landy8530/DesignPatterns/blob/master/design-patterns-business/src/main/java/org/landy/business/identify/component/annotation/KeyIdentificationStrategy.java)
* ![Stata pattern 2](https://github.com/landy8530/DesignPatterns/tree/master/design-patterns-business/src/main/java/org/landy/business/identify/component/primary)
* Giữ hành vi cụ thể tương ứng với trạng thái.
* Giúp chuyển trạng thái một cách rõ ràng.
* Thêm một State mới mà không ảnh hưởng đến State khác hay Context hiện có.

  ### Strategy pattern:
* Cho phép định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và dễ dàng thay đổi linh hoạt các thuật toán bên trong object. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng.
* ![Strategy pattern](https://github.com/gywgiehub/demo/blob/8087d5b917352c69ead34c913e7b5952c46ef64f/eurake-client/src/main/java/com/demo/gyw/strategy/StrategyModel.java)
* Cung cấp một sự thay thế cho kế thừa.
* Dễ dàng mở rộng và kết hợp hành vi mới mà không thay đổi ứng dụng.



