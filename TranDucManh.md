
### 17.Mediator
##### Giới thiệu về Mediator
Mediator Pattern là một trong những Pattern thuộc nhóm hành vi Behavior Pattern.Mô hình này cung cấp một lớp trung gian có nhiệm vụ xử lý thông tin liên lạc giữa các tầng lớp, hỗ trợ bảo trì mã code dễ dàng bằng cách khớp nối lỏng lẻo.
##### Cách sử dụng Mediator trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Mediator** được thể hiện như sau:
```
// Mediator provides a mediator interface.
type Mediator interface {
	Notify(msg string)
}


type ConcreteMediator struct {
	*Farmer
	*Cannery
	*Shop
}
```

```
// Notify implementation.
func (m *ConcreteMediator) Notify(msg string) {
	if msg == "Farmer: Tomato complete..." {
		m.Cannery.AddMoney(-15000.00)
		m.Farmer.AddMoney(15000.00)
		m.Cannery.MakeKetchup(m.Farmer.GetTomato())
	} else if msg == "Cannery: Ketchup complete..." {
		m.Shop.AddMoney(-30000.00)
		m.Cannery.AddMoney(30000.00)
		m.Shop.SellKetchup(m.Cannery.GetKetchup())
	}
```

##### Nhận xét về cách sử dụng Mediator ở trên:
* Mediator: là một interface, định nghĩa các phương thức để giao tiếp với các Colleague object.
* ConcreteMediator: cài đặt các phương thức của Mediator, biết và quản lý các Colleague object.
-------------------------------------------------------------------------


### 18.Memento
##### Giới thiệu về Memento
Memento là một trong những Pattern thuộc nhóm hành vi Behavior Pattern. Memento là mẫu thiết kế có thể lưu lại trạng thái của một đối tượng để khôi phục lại sau này mà không vi phạm nguyên tắc đóng gói.
##### Cách sử dụng Memento trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Memento** được thể hiện như sau:
```
// Package memento is an example of the Memento Pattern.
package memento

// Originator implements a state master.
type Originator struct {
	State string
}

// CreateMemento returns state storage.
func (o *Originator) CreateMemento() *Memento {
	return &Memento{state: o.State}
}

// SetMemento sets old state.
func (o *Originator) SetMemento(memento *Memento) {
	o.State = memento.GetState()
}

// Memento implements storage for the state of Originator
type Memento struct {
	state string
}

// GetState returns state.
func (m *Memento) GetState() string {
	return m.state
}

// Caretaker keeps Memento until it is needed by Originator.
type Caretaker struct {
	Memento *Memento
}
```

##### Nhận xét về cách sử dụng Memento ở trên:
* Originator: đại diện cho đối tượng mà chúng ta muốn lưu. Nó sử dụng memento để lưu và khôi phục trạng thái bên trong của nó.
* Memento: đại diện cho một đối tượng để lưu trữ trạng thái của Originator. 
-------------------------------------------------------------------------


### 19.Observer
##### Giới thiệu về Observer
Observer Pattern là một trong những Pattern thuộc nhóm hành vi Behavior Pattern. Nó định nghĩa mối phụ thuộc một – nhiều giữa các đối tượng để khi mà một đối tượng có sự thay đổi trạng thái, tất các thành phần phụ thuộc của nó sẽ được thông báo và cập nhật một cách tự động.
##### Cách sử dụng Observer trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Observer** được thể hiện như sau:
```
// Publisher interface.
type Publisher interface {
	Attach(observer Observer)
	SetState(state string)
	Notify()
}

// Observer provides a subscriber interface.
type Observer interface {
	Update(state string)
}

// ConcretePublisher implements the Publisher interface.
type ConcretePublisher struct {
	observers []Observer
	state     string
}
```

##### Nhận xét về cách sử dụng Observer ở trên:
* Observer: định nghĩa một phương thức update() cho các đối tượng sẽ được subject thông báo đến khi có sự thay đổi trạng thái.
* ConcretePublisher: cài đặt các phương thức của Subject, lưu trữ trạng thái danh sách các ConcretePublisher, gửi thông báo đến các observer của nó khi có sự thay đổi trạng thái.
-------------------------------------------------------------------------


### 20.State
##### Giới thiệu về State
State Pattern là một trong những Pattern thuộc nhóm hành vi Behavior Pattern. Nó cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
##### Cách sử dụng State trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **State** được thể hiện như sau:
```
// MobileAlertStater provides a common interface for various states.
type MobileAlertStater interface {
	Alert() string
}

// MobileAlert implements an alert depending on its state.
type MobileAlert struct {
	state MobileAlertStater
}

// Alert returns a alert string
func (a *MobileAlert) Alert() string {
	return a.state.Alert()
}

// SetState changes state
func (a *MobileAlert) SetState(state MobileAlertStater) {
	a.state = state
}
```

##### Nhận xét về cách sử dụng State ở trên:
* State: là một interface hoặc abstract class xác định các đặc tính cơ bản của tất cả các đối tượng ConcreteState. Chúng sẽ được sử dụng bởi đối tượng Context để truy cập chức năng có thể thay đổi.
* Giữ hành vi cụ thể tương ứng với trạng thái.
-------------------------------------------------------------------------


### 21.Strategy
##### Giới thiệu về Strategy
Strategy Pattern là một trong những Pattern thuộc nhóm hành vi Behavior Pattern. Nó cho phép định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và dễ dàng thay đổi linh hoạt các thuật toán bên trong object. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng.
##### Cách sử dụng Strategy trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Strategy** được thể hiện như sau:
```
// Package strategy is an example of the Strategy Pattern.
package strategy

// StrategySort provides an interface for sort algorithms.
type StrategySort interface {
	Sort([]int)
}

// BubbleSort implements bubble sort algorithm.
type BubbleSort struct {
}

// Sort sorts data.
func (s *BubbleSort) Sort(a []int) {
	size := len(a)
	if size < 2 {
		return
	}
	for i := 0; i < size; i++ {
		for j := size - 1; j >= i+1; j-- {
			if a[j] < a[j-1] {
				a[j], a[j-1] = a[j-1], a[j]
			}
		}
	}
}
```

##### Nhận xét về cách sử dụng Strategy ở trên:
* Đảm bảo nguyên tắc Open/Closed Principle (OCP) : chúng ta dễ dàng mở rộng và kết hợp hành vi mới mà không thay đổi ứng dụng.
* Cung cấp một sự thay thế cho kế thừa.
-------------------------------------------------------------------------


### 22.Template method
##### Giới thiệu về Template method
Template Method Pattern được sử dụng khá nhiều trong mô hình Abstract – Concrete Class. Khi chúng ta muốn các Concrete class tự thực thi xử lí theo cách của nó, nhưng đồng thời vẫn đảm bảo tuận theo những ràng buộc nhất định từ Abstract class.
##### Cách sử dụng Template method trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Template method** được thể hiện như sau:
```
// QuotesInterface provides an interface for setting different quotes.
type QuotesInterface interface {
	Open() string
	Close() string
}

// Quotes implements a Template Method.
type Quotes struct {
	QuotesInterface
}

// Quotes is the Template Method.
func (q *Quotes) Quotes(str string) string {
	return q.Open() + str + q.Close()
}

// NewQuotes is the Quotes constructor.
func NewQuotes(qt QuotesInterface) *Quotes {
	return &Quotes{qt}
}
```

##### Nhận xét về cách sử dụng Template method ở trên:
* Cho phép người dùng override chỉ một số phần nhất định của thuật toán lớn, làm cho chúng ít bị ảnh hưởng hơn bởi những thay đổi xảy ra với các phần khác của thuật toán.
* Tái sử dụng code, tránh trùng lặp code: đưa những phần trùng lặp vào lớp cha (abstract class).
-------------------------------------------------------------------------


### 23.Visitor
##### Giới thiệu về Visitor
Visitor Pattern là một trong những Pattern thuộc nhóm hành vi Behavior Pattern. Visitor cho phép định nghĩa các thao tác trên một tập hợp các đối tượng không đồng nhất mà không làm thay đổi định nghĩa về lớp của các đối tượng đó.
##### Cách sử dụng Visitor trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Visitor** được thể hiện như sau:
```
// Visitor provides a visitor interface.
type Visitor interface {
	VisitSushiBar(p *SushiBar) string
	VisitPizzeria(p *Pizzeria) string
	VisitBurgerBar(p *BurgerBar) string
}

// Place provides an interface for place that the visitor should visit.
type Place interface {
	Accept(v Visitor) string
}
```

```
// VisitBurgerBar implements visit to BurgerBar.
func (v *People) VisitBurgerBar(p *BurgerBar) string {
	return p.BuyBurger()
}
```

##### Nhận xét về cách sử dụng Visitor ở trên:
* Visitor Là một interface class được sử dụng để khai báo các hành vi cho tất cả các loại visitor.
* Cho phép một hoặc nhiều hành vi được áp dụng cho một tập hợp các đối tượng tại thời điểm run-time, tách rời các hành vi khỏi cấu trúc đối tượng.
