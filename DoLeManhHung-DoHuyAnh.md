#OOP-2021

##Thành viên trong nhóm:

###- Đỗ Huy Anh - 20020180
###- Đỗ Lê Mạnh Hùng - 20020322

##Báo cáo về Design Pattern
### Link GitHub tham khảo:
> https://github.com/JamesZBL/java_design_patterns

__ __

###1. So sánh Abstract Factory
* AbstractFactory được khai báo chính xác
* ConcreteFactory có được xây dựng nhưng không theo cấu trúc chuẩn
* AbstractProduct được khai báo chính xác
* Product đã được cài đặt chính xác

###2. So sánh Adapter
* Adaptee đã được khai báo chính xác
* Adapter được khai báo chính xác
* Target được khai báo chính xác

###3. So sánh Bridge
* Abstraction có một vài phần không theo cấu trúc chuẩn
* Refined Abstraction được cài đặt chính xác
* Implementor được khai báo chính xác
* ConcreteImplementor được khai báo chính xác

###4. So sánh Builder
* Builder chưa phải là abstract class hay ìnterface
* ConcreteBuilder chưa kế thừa Builder
* Director đã được cài đặt chính xác
* Product  đã được cài đặt chính xác

###5. So sánh Composite
* Base Component đã được khai báo chính xác
* Leaf đã được cài đặt nhưng chưa implement các phương thức của Component
* Composite đã được cài đặt chính xác

###6. So sánh Decorator
* Component đã được cài đặt đúng
* ConcreteComponent đã được cài đặt chính xác
* Decorator đã được cài đặt chính xác
* ConcreteDecorator đã được cài đặt chính xác

###7. So sánh Factory Method
* Super Class đã được cài đặt chính xác
* Sub Class đã được cài đặt chính xác
* Factory Class đã được cài đặt chính xác

###8. So sánh Flyweight
* Flyweight đã được cài đặt chính xác
* ConcreteFlyweight đã được cài đặt chính xác
* UnsharedFlyweight đã được cài đặt chính xác
* FlyweightFactory đã được cài đặt chính xác
* Client đã được cài đặt

###9. So sánh Prototype
* Prototype đã được cài đặt chính xác
* ConcretePrototype đã dược cài đặt chính xác
* Client đã được cài đặt

###10. So sánh Singleton
* Private Contructor đã được cài đặt
* Chưa cài đặt biến ở dưới dạng ***private static final***
* Đã có một method public static được cài đặt

###11.Chain of Responsibility:
* Mẫu thiết kế theo repo có cấu trúc giống 90% theo mẫu chuẩn, chỉ khác có thêm 2 lớp để khai báo.
###12.Command:
* Mẫu thiết kế theo repo có đủ cấu trúc, đó là interface or abstract class, có implemention, có tiếp nhận request, tiếp nhật concrete và nơi nhận( giống 100%).
###13.Facade:
* Có đầy đủ các cấu trúc giống như định dạng chuẩn.
###14.Interpreter:
* Mẫu thiết kế giống 90%, thiếu mất cấu trúc context.
###15.Interator:
* Mẫu thiết kế giống 100%
###16.Mediator:
* Có đầy đủ cấu trúc giống form chuẩn, và thêm 1 biến enum.
###17.Memento
* Mẫu thiết kế theo repo đầy đủ cấu trúc originator, caretaker và memento trong đó có thêm 1 loại biến enum
###18.Observer
* Có đầy đủ các cấ trúc như subject, observer, concreteSubject và concreteObserver, và thêm 1 biến enum.
###19.Proxy
* Giống cấu trúc gốc 100%
###20.Template method
* Có đầy đủ cấu trúc Abstract Class và 1 concrete  Class ngoài ra thêm 1 phương thức của Abstract class và 1 hàm nữa
###21.State
* Có đầy đủ các cấu trúc context, state và concreteState và có thêm hàm main
###22.Strategy
* Có đầy đủ các cấu trúc như strategy, 2 concreteStrategy, context và 1 hàm main.
###23.Visitor
* Có đầy đủ các file trong cấu trúc như visitor, concreteVisitor, element và phương thức của elements, objectStructure và client, và 1 hàm để chạy.