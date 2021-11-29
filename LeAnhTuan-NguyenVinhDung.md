# Lê Anh Tuấn - 20021464
# Nguyễn Vĩnh Dũng - 20021317



# Link project trên github: https://github.com/QianMo/Unity-Design-Pattern

Các loại Design Pattern cơ bản

* Creational Patterns: Nhóm này cung cấp phương pháp tạo ra các đối tượng một cách linh hoạt hơn, quyết định đối tượng nào được tạo ra tuỳ thuộc vào trường hợp sử dụng nhất định.

* Structural Pattern: Nhóm này liên quan đến sự kết hợp giữa các đối tượng với nhau

* Behavioral Patterns: Mẫu thiết kế này trình bày phương pháp thiết kế liên quan đến hành vi của các đối tượng.

CÁC MẪU THIẾT KẾ ĐƯỢC SỬ DỤNG TRONG PROJECT
 
* Command Pattern: Đóng gói một yêu cầu dưới dạng một đối tượng, do đó cho phép bạn tham số hóa các máy khách với các yêu cầu khác nhau, yêu cầu hàng đợi hoặc nhật ký và hỗ trợ các hoạt động hoàn tác. 

    - Các lớp và đối tượng minh hoạ: 

    Command (khai báo một giao diện để thực hiện một hoạt động)

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/Command%20Pattern

* State Pattern: Cho phép một đối tượng thay đổi hành vi của nó khi trạng thái bên trong của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.

    - Các lớp và đối tượng minh hoạ: 

        Context (Account): 
        
            xác định giao diện mà khách hàng quan tâm, duy trì một thể hiện của lớp con ConcreteState xác định trạng thái hiện tại.

        Concrete State (RedState, SilverState, GoldState): 
        
            mỗi lớp con thực hiện một hành vi được liên kết với một trạng thái của Context

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/State%20Pattern

* Observer Pattern: Xác định sự phụ thuộc một-nhiều giữa các đối tượng để khi một đối tượng thay đổi trạng thái, tất cả các thành phần phụ thuộc của nó sẽ được thông báo và cập nhật tự động.
    - Các lớp và đối tượng minh hoạ: 
        
        Subject (Stock): 
        
            biết những người quan sát nó. Bất kỳ số lượng đối tượng Người quan sát nào cũng có thể observe a subject, cung cấp một giao diện để gắn và tách các đối tượng Observer.

        ConcreteSubject (IBM): 
        
            gửi thông báo cho những người quan sát khi trạng thái của nó thay đổi

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/Observer%20Pattern

* Mediator Pattern: Định nghĩa một đối tượng đóng gói cách một tập hợp các đối tượng tương tác. Mediator thúc đẩy kết hợp lỏng lẻo bằng cách giữ cho các đối tượng không tham chiếu đến nhau một cách rõ ràng và nó cho phép bạn thay đổi tương tác của chúng một cách độc lập.

    - Các lớp và đối tượng minh hoạ:

        Mediator (IChatroom): 
        
            xác định một giao diện để giao tiếp với Colleague objects

        ConcreteMediator (Chatroom): 
        
            thực hiện hành vi hợp tác bằng cách phối hợp Colleague objects, biết và duy trì các đồng nghiệp của mình

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/Mediator%20Pattern

* Interpreter Pattern: Cho một ngôn ngữ, hãy xác định một biểu diễn cho ngữ pháp của nó cùng với một trình thông dịch sử dụng biểu diễn để diễn giải các câu trong ngôn ngữ đó.

    - Các lớp và đối tượng minh hoạ:

        AbstractExpression (Expression): 
        
            khai báo một giao diện để thực hiện một hoạt động

        TerminalExpression ( ThousandExpression, HundredExpression, TenExpression, OneExpression ): 
        
            triển khai hoạt động Diễn giải được liên kết với các ký hiệu đầu cuối trong ngữ pháp, một trường hợp được yêu cầu cho mọi ký hiệu đầu cuối trong câu.

        Client (InterpreterApp):

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/Interpreter%20Pattern#interpreter-pattern-%E8%A7%A3%E9%87%8A%E5%99%A8%E6%A8%A1%E5%BC%8F

* Iterator Pattern: Cung cấp một cách để truy cập các phần tử của một đối tượng tổng hợp một cách tuần tự mà không để lộ phần biểu diễn cơ bản của nó.


    - Các lớp và đối tượng minh hoạ: 

        Iterator (AbstractIterator): 
        
            định nghĩa một giao diện để truy cập và duyệt qua các phần tử.

        ConcreteIterator (Iterator): 
        
            triển khai giao diện Iterator, theo dõi vị trí hiện tại trong đường truyền của tổng thể.

        Aggregate (AbstractCollection): 
        
            định nghĩa một giao diện để tạo một đối tượng Iterator

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/Iterator%20Pattern

* Strategy Pattern: Xác định nhóm thuật toán, đóng gói từng thuật toán và làm cho chúng có thể hoán đổi cho nhau. Chiến lược cho phép thuật toán thay đổi độc lập với các khách hàng sử dụng nó.

    - Các lớp và đối tượng minh hoạ: 

        Strategy (SortStrategy): 
        
            khai báo một giao diện chung cho tất cả các thuật toán được hỗ trợ. Ngữ cảnh sử dụng giao diện này để gọi thuật toán được xác định bởi ConcreteStrategy.

        ConcreteStrategy (QuickSort, ShellSort, MergeSort): 
        
            triển khai thuật toán bằng giao diện Strategy/

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/Strategy%20Pattern

* Visitor Pattern: Biểu diễn một thao tác được thực hiện trên các phần tử của cấu trúc đối tượng. Khách truy cập cho phép bạn xác định một hoạt động mới mà không cần thay đổi các lớp của các phần tử mà nó hoạt động.

    - Các lớp và đối tượng minh hoạ: 

        ConcreteVisitor (IncomeVisitor, VacationVisitor): 
        
            thực hiện từng thao tác do Khách truy cập khai báo. Mỗi hoạt động thực hiện một phân đoạn của thuật toán được xác định cho lớp hoặc đối tượng tương ứng trong cấu trúc. ConcreteVisitor cung cấp ngữ cảnh cho thuật toán và lưu trữ trạng thái cục bộ của nó. Trạng thái này thường tích lũy các kết quả trong quá trình di chuyển cấu trúc.

        ConcreteElement (Employee): 
        
            triển khai hoạt động Chấp nhận lấy khách truy cập làm đối số

        ObjectStructure (Employees): 
        
            có thể liệt kê các yếu tố của nó, cung cấp giao diện cấp cao để cho phép khách truy cập vào các phần tử của nó, tổng hợp (mẫu) hoặc một tập hợp chẳng hạn như danh sách hoặc tập hợp

    - Các lớp và đối tượng minh hoạ:  https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Behavioral%20Patterns/Visitor%20Pattern


* Adapter Pattern: Chuyển đổi giao diện của một lớp thành giao diện khác mà khách hàng mong đợi. Bộ điều hợp cho phép các lớp hoạt động cùng nhau mà không thể vì giao diện không tương thích.

    - Các lớp và đối tượng minh hoạ: 

        Target (ChemicalCompound): 
        
            xác định giao diện miền cụ thể mà Khách hàng sử dụng.

        Adapter (Compound): 
        
            điều chỉnh giao diện Adaptee với giao diện Target.

        Adaptee (ChemicalDatabank): 
        
            xác định một giao diện hiện có cần thích ứng.
        
    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Structural%20Patterns/Adapter%20Pattern

* Bridge Pattern: Tách một phần trừu tượng khỏi quá trình triển khai của nó để hai phần này có thể khác nhau một cách độc lập.

    - Các lớp và đối tượng minh hoạ: 

        Abstraction (BusinessObject): 
        
            xác định giao diện của phần trừu tượng, duy trì một tham chiếu đến một đối tượng kiểu Implementor.

        RefinedAbstraction (CustomersBusinessObject): 
        
            mở rộng giao diện được xác định bởi Trừu tượng.

        Implementor (DataObject): 
        
            định nghĩa giao diện cho các lớp thực thi. Giao diện này không nhất thiết phải tương ứng chính xác với giao diện của Abstraction; trong thực tế, hai giao diện có thể hoàn toàn khác nhau. Thông thường, giao diện Triển khai chỉ cung cấp các hoạt động nguyên thủy và Trừu tượng xác định các hoạt động cấp cao hơn dựa trên các nguyên thủy này.
        
    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Structural%20Patterns/Bridge%20Pattern

* Composite Pattern: Soạn các đối tượng thành cấu trúc cây để biểu diễn cấu trúc phân cấp một phần toàn bộ. Composite cho phép khách hàng xử lý các đối tượng riêng lẻ và bố cục của các đối tượng một cách đồng nhất.

    - Các lớp và đối tượng minh hoạ: 

        Component (DrawingElement): 

            thành phần.
            Thực hiện hành vi mặc định cho giao diện chung cho tất cả các lớp, nếu thích hợp.
            Khai báo một giao diện để truy cập và quản lý các thành phần con của nó.
            (tùy chọn) Định nghĩa một giao diện để truy cập cha của một thành phần trong cấu trúc đệ quy và triển khai nó nếu điều đó phù hợp.

        Leaf (PrimitiveElement): 
        
            đại diện cho các đối tượng leaf trong bố cục. A leaf không có con, xác định hành vi cho các đối tượng nguyên thủy trong thành phần.

        Composite (CompositeElement): 
        
            xác định hành vi cho các thành phần có con, lưu trữ các thành phần con, triển khai các hoạt động liên quan đến con trong Component interface.
        
    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Structural%20Patterns/Composite%20Pattern

* Decorator Pattern: Đính kèm các trách nhiệm bổ sung vào một đối tượng động. Trình trang trí cung cấp một giải pháp thay thế linh hoạt cho phân lớp để mở rộng chức năng.

    - Các lớp và đối tượng minh hoạ: 

        Component (LibraryItem):

            Xác định giao diện cho các đối tượng có thể có các trách nhiệm được thêm động vào chúng.

        ConcreteComponent (Book, Video):

            Xác định một đối tượng mà các trách nhiệm bổ sung có thể được gắn vào.

        Decorator (Decorator): 

            Duy trì một tham chiếu đến một đối tượng Thành phần và xác định một giao diện phù hợp với giao diện của Thành phần.
        
    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Structural%20Patterns/Decorator%20Pattern




* Proxy Pattern: Cung cấp người thay thế hoặc trình giữ chỗ cho một đối tượng khác để kiểm soát quyền truy cập vào nó.

    - Các lớp và đối tượng minh hoạ:

        Proxy (MathProxy): 

            Duy trì một tham chiếu cho phép proxy truy cập vào chủ thể thực. Proxy có thể tham chiếu đến Chủ thể nếu giao Diện RealSubject và Subject giống nhau.

            Cung cấp một giao diện giống hệt với Chủ đề để có thể thay thế một proxy cho chủ thể thực.

            Kiểm soát quyền truy cập vào chủ thể thực và có thể chịu trách nhiệm tạo và xóa nó.

        Subject (IMath):

            Xác định giao diện chung cho RealSubject và Proxy để một Proxy có thể được sử dụng ở bất cứ đâu mà RealSubject được mong đợi.

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Structural%20Patterns/Proxy%20Pattern    


* Prototype Pattern: 

    - Các lớp và đối tượng minh hoạ:

        Prototype (ColorPrototype):

            Khai báo một giao diện để nhân bản chính nó

        ConcretePrototype (Color):

            Thực hiện một hoạt động để nhân bản chính nó

        Client (ColorManager):

            Tạo một đối tượng mới bằng cách yêu cầu một nguyên mẫu để nhân bản chính nó

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Creational%20Patterns/Prototype%20Pattern


* Singleton Pattern: Đảm bảo một lớp chỉ có một phiên bản và cung cấp một điểm truy cập toàn cục cho nó.

    - Các lớp và đối tượng minh hoạ:

        Singleton (LoadBalancer): 
        
            Định nghĩa một hoạt động Phiên bản cho phép khách hàng truy cập phiên bản duy nhất của nó. Phiên bản là một hoạt động của lớp.

            Chịu trách nhiệm tạo và duy trì phiên bản duy nhất của riêng nó.

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Creational%20Patterns/Singleton%20Pattern

* Abstract Factory Pattern: Cung cấp giao diện để tạo họ các đối tượng liên quan hoặc phụ thuộc mà không chỉ định các lớp cụ thể của chúng.

    - Các lớp và đối tượng minh hoạ:

        AbstractFactory (ContinentFactory):

            Khai báo một giao diện cho các hoạt động tạo ra các sản phẩm trừu tượng

        ConcreteFactory (AfricaFactory, AmericaFactory):

            Thực hiện các hoạt động để tạo ra các đối tượng sản phẩm cụ thể

        AbstractProduct (Herbivore, Carnivore):

            Khai báo một giao diện cho một loại đối tượng sản phẩm

        Product (Wildebeest, Lion, Bison, Wolf): 

            Xác định một đối tượng sản phẩm sẽ được tạo ra bởi nhà máy bê tông tương ứng

            Triển khai giao diện AbstractProduct

        Client (AnimalWorld): 
        
            Sử dụng các giao diện được khai báo bởi các lớp AbstractFactory và AbstractProduct


    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Creational%20Patterns/Abstract%20Factory%20Pattern



* Builder Pattern: Tách cấu trúc của một đối tượng phức tạp khỏi biểu diễn của nó để quá trình xây dựng giống nhau có thể tạo ra các biểu diễn khác nhau.

    - Các lớp và đối tượng minh hoạ:

        Builder (VehicleBuilder):

            Chỉ định một giao diện trừu tượng để tạo các phần của đối tượng Product

        ConcreteBuilder (MotorCycleBuilder, CarBuilder, ScooterBuilder):

            Xây dựng và lắp ráp các bộ phận của sản phẩm bằng cách triển khai giao diện Builder

            Xác định và theo dõi biểu diễn mà nó tạo ra

            Cung cấp một giao diện để lấy sản phẩm

        Director (Shop): 
        
            Tạo một đối tượng bằng giao diện Builder

        Product (Vehicle): 
        
            Đại diện cho đối tượng phức tạp đang được xây dựng. ConcreteBuilder xây dựng đại diện bên trong của sản phẩm và xác định quy trình mà nó được lắp ráp

            Bao gồm các lớp xác định các bộ phận cấu thành, bao gồm các giao diện để lắp ráp các bộ phận thành kết quả cuối cùng

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Creational%20Patterns/Builder%20Pattern#builder-pattern-%E5%BB%BA%E9%80%A0%E8%80%85%E6%A8%A1%E5%BC%8F


* Factory Method Pattern: Xác định giao diện để tạo một đối tượng, nhưng hãy để các lớp con quyết định lớp nào sẽ khởi tạo. Factory Method cho phép một lớp trì hoãn quá trình khởi tạo lớp con.

    - Các lớp và đối tượng minh hoạ:

        Product (Page): 

            Xác định giao diện của các đối tượng mà phương thức factory tạo ra

            ConcreteProduct (SkillsPage, EducationPage, ExperiencePage)

            Triển khai giao diện Sản phẩm

        Creator (Document): 

            Khai báo phương thức factory, phương thức này trả về một đối tượng kiểu Sản phẩm. Người tạo cũng có thể xác định một triển khai mặc định của phương thức gốc trả về một đối tượng ConcreteProduct mặc định.

            Có thể gọi phương thức factory để tạo một đối tượng Sản phẩm.

        ConcreteCreator (Report, Resume): 

            Ghi đè phương thức factory để trả về một phiên bản của ConcreteProduct.

    - Link folder chi tiết: https://github.com/QianMo/Unity-Design-Pattern/tree/master/Assets/Creational%20Patterns/Factory%20Method%20Pattern
        






