### 9.Decorator
##### Giới thiệu về Decorator
Decorator pattern là một trong những Pattern thuộc nhóm cấu trúc. Nó cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác. Kiểu thiết kế này có cấu trúc hoạt động như một lớp bao bọc (wrap) cho lớp hiện có. Mỗi khi cần thêm tính năng mới, đối tượng hiện có được wrap trong một đối tượng mới (decorator class).
##### Cách sử dụng Decorator trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Decorator** được thể hiện như sau:
```
// Package decorator is an example of the Decorator Pattern.
package decorator
// Component provides an interface for a decorator and component.
type Component interface {
	Operation() string
}
// ConcreteComponent implements a component.
type ConcreteComponent struct {
}
// Operation implementation.
func (c *ConcreteComponent) Operation() string {
	return "I am component!"
}
// ConcreteDecorator implements a decorator.
type ConcreteDecorator struct {
	component Component
}
// Operation wraps operation of component
func (d *ConcreteDecorator) Operation() string {
	return "<strong>" + d.component.Operation() + "</strong>"
}
```

##### Nhận xét về cách sử dụng Decorator ở trên:
* Component: là một interface quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.
* ConcreteComponent: là lớp hiện thực (implements) các phương thức của Component.
* ConcreteDecorator: là lớp hiện thực (implements) các phương thức của Decorator, nó cài đặt thêm các tính năng mới cho Component.
-------------------------------------------------------------------------


### 10.Facade
##### Giới thiệu về Facade
Facade Pattern là một trong những Pattern thuộc nhóm cấu trúc Structural Pattern. Pattern này cung cấp một giao diện chung đơn giản thay cho một nhóm các giao diện có trong một hệ thống con. Facade Pattern định nghĩa một giao diện ở một cấp độ cao hơn để giúp cho người dùng có thể dễ dàng sử dụng hệ thống con này.
##### Cách sử dụng Facade trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Facade** được thể hiện như sau:
```
// Package facade is an example of the Facade Pattern.
package facade
import (
	"strings"
)
// NewMan creates man.
func NewMan() *Man {
	return &Man{
		house: &House{},
		tree:  &Tree{},
		child: &Child{},
	}
}
// Man implements man and facade.
type Man struct {
	house *House
	tree  *Tree
	child *Child
}
```

```
// Todo returns that man must do.
func (m *Man) Todo() string {
	result := []string{
		m.house.Build(),
		m.tree.Grow(),
		m.child.Born(),
	}
	return strings.Join(result, "\n")
}
```

##### Nhận xét về cách sử dụng Facade ở trên:
* Facade: biết rõ lớp của hệ thống con nào đảm nhận việc đáp ứng yêu cầu của client, sẽ chuyển yêu cầu của client đến các đối tượng của hệ thống con tương ứng.
* Giảm sự phụ thuộc của các mã code bên ngoài với hiện thực bên trong của thư viện, vì hầu hết các code đều dùng Facade, vì thế cho phép sự linh động trong phát triển các hệ thống.
-------------------------------------------------------------------------


### 11.Flyweight
##### Giới thiệu về Flyweight
Flyweight Pattern là một trong những Pattern thuộc nhóm cấu trúc Structural Pattern. Nó cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng hoặc tạo đối tượng mới khi không tìm thấy đối tượng phù hợp.
##### Cách sử dụng Flyweight trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Flyweight** được thể hiện như sau:
```
// Package flyweight is an example of the Flyweight Pattern.
package flyweight
import "fmt"
// Flyweighter interface
type Flyweighter interface {
	Draw(width, height int, opacity float64) string
}
// FlyweightFactory implements a factory.
// If a suitable flyweighter is in pool, then returns it.
type FlyweightFactory struct {
	pool map[string]Flyweighter
}
// GetFlyweight creates or returns a suitable Flyweighter by state.
func (f *FlyweightFactory) GetFlyweight(filename string) Flyweighter {
	if f.pool == nil {
		f.pool = make(map[string]Flyweighter)
	}
	if _, ok := f.pool[filename]; !ok {
		f.pool[filename] = &ConcreteFlyweight{filename: filename}
	}
	return f.pool[filename]
}
// ConcreteFlyweight implements a Flyweighter interface.
type ConcreteFlyweight struct {
	filename string // internal state
}
// Draw draws image. Args width, height and opacity is external state.
func (f *ConcreteFlyweight) Draw(width, height int, opacity float64) string {
	return fmt.Sprintf("draw image: %s, width: %d, height: %d, opacity: %.2f", f.filename, width, height, opacity)
}
```

##### Nhận xét về cách sử dụng Flyweight ở trên:
* Flyweight: là một interface class, định nghĩa các các thành phần của một đối tượng.
* ConcreteFlyweight: triển khai các phương thức đã được định nghĩa trong Flyweight. Việc triển khai này phải thực hiện các khả năng của trạng thái nội tại. Đó là dữ liệu phải không thể thay đổi và có thể chia sẻ. Các đối tượng là phi trạng thái trong triển khai này. Vì vậy, đối tượng ConcreteFlyweight giống nhau có thể được sử dụng trong các ngữ cảnh khác nhau.
-------------------------------------------------------------------------


### 12.Proxy
##### Giới thiệu về Proxy
Proxy Pattern là mẫu thiết kế mà ở đó tất cả các truy cập trực tiếp đến một đối tượng nào đó sẽ được chuyển hướng vào một đối tượng trung gian (Proxy Class). Mẫu Proxy đại diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với múc đích sử dụng.
##### Cách sử dụng Proxy trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Proxy** được thể hiện như sau:
```
// Package proxy is an example of the Adapter Pattern.
package proxy
// Subject provides an interface for a real subject and its surrogate.
type Subject interface {
	Send() string
}
// Proxy implements a surrogate.
type Proxy struct {
	realSubject Subject
}
// Send sends a message
func (p *Proxy) Send() string {
	if p.realSubject == nil {
		p.realSubject = &RealSubject{}
	}
	return "<strong>" + p.realSubject.Send() + "</strong>"
}
// RealSubject implements a real subject
type RealSubject struct {
}
// Send sends a message
func (s *RealSubject) Send() string {
	return "I’ll be back!"
}
```

##### Nhận xét về cách sử dụng Proxy ở trên:
* Cung cấp mức truy cập gián tiếp vào một đối tượng.
* Tham chiếu vào đối tượng đích và chuyển tiếp các yêu cầu đến đối tượng đó.
-------------------------------------------------------------------------


### 13.Chain of Responsibility
##### Giới thiệu về Chain of Responsibility
Chain of Responsiblity cho phép một đối tượng gửi một yêu cầu nhưng không biết đối tượng nào sẽ nhận và xử lý nó. Điều này được thực hiện bằng cách kết nối các đối tượng nhận yêu cầu thành một chuỗi (chain) và gửi yêu cầu theo chuỗi đó cho đến khi có một đối tượng xử lý nó.
##### Cách sử dụng Chain of Responsibility trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Chain of Responsibility** được thể hiện như sau:
```
// Handler provides a handler interface.
type Handler interface {
	SendRequest(message int) string
}
// ConcreteHandlerA implements handler "A".
type ConcreteHandlerA struct {
	next Handler
}
// SendRequest implementation.
func (h *ConcreteHandlerA) SendRequest(message int) (result string) {
	if message == 1 {
		result = "Im handler 1"
	} else if h.next != nil {
		result = h.next.SendRequest(message)
	}
	return
}
// ConcreteHandlerB implements handler "B".
type ConcreteHandlerB struct {
	next Handler
}
```

##### Nhận xét về cách sử dụng Chain of Responsibility ở trên:
* Handle : định nghĩa 1 interface để xử lý các yêu cầu. Gán giá trị cho đối tượng successor (không bắt buộc).
* ConcreteHandler: xử lý yêu cầu. Có thể truy cập đối tượng successor (thuộc class Handler). Nếu đối tượng ConcreateHandler không thể xử lý được yêu cầu, nó sẽ gởi lời yêu cầu cho successor của nó.
-------------------------------------------------------------------------


### 14.Command
##### Giới thiệu về Command
Command Pattern là một trong những Pattern thuộc nhóm hành vi Behavior Pattern. Nó cho phép chuyển yêu cầu thành đối tượng độc lập, có thể được sử dụng để tham số hóa các đối tượng với các yêu cầu khác nhau như log, queue (undo/redo), transtraction.
##### Cách sử dụng Command trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Command** được thể hiện như sau:
```
// Package command is an example of the Command Pattern.
package command
// Command provides a command interface.
type Command interface {
	Execute() string
}
// ToggleOnCommand implements the Command interface.
type ToggleOnCommand struct {
	receiver *Receiver
}
// Execute command.
func (c *ToggleOnCommand) Execute() string {
	return c.receiver.ToggleOn()
}
```

##### Nhận xét về cách sử dụng Command ở trên:
* Command: là một interface class, chứa một phương thức trừu tượng thực thi một hành động. Request sẽ được đóng gói dưới dạng Command.
* Đóng gói một yêu cầu trong một đối tượng. Dễ dàng chuyển dữ liệu dưới dạng đối tượng giữa các thành phần hệ thống.
-------------------------------------------------------------------------


### 15.Interpreter
##### Giới thiệu về Interpreter
Interpreter Pattern giúp người lập trình có thể “xây dựng” những đối tượng “động” bằng cách đọc mô tả về đối tượng rồi sau đó “xây dựng” đối tượng đúng theo mô tả đó.
##### Cách sử dụng Iterator trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Interpreter** được thể hiện như sau:
```
// Iterator provides a iterator interface.
type Iterator interface {
	Index() int
	Value() interface{}
	Has() bool
	Next()
	Prev()
	Reset()
	End()
}
// Aggregate provides a collection interface.
type Aggregate interface {
	Iterator() Iterator
}
```

```
// BookIterator implements the Iterator interface.
type BookIterator struct {
	shelf    *BookShelf
	index    int
	internal int
}
// Index returns current index
func (i *BookIterator) Index() int {
	return i.index
}
// Value returns current value
func (i *BookIterator) Value() interface{} {
	return i.shelf.Books[i.index]
}
```

##### Nhận xét về cách sử dụng Interpreter ở trên:
* Iterator là một interface hoặc abstract class, định nghĩa phương thức interpreter chung cho tất cả các node trong cấu trúc cây phân tích ngữ pháp. Expression được biểu diễn như một cấu trúc cây phân cấp, mỗi implement của Expression có thể gọi một node.
* Cài đặt và sử dụng ngữ pháp rất đơn giản. Các lớp xác định các nút trong cây cú pháp có các implement tương tự.
-------------------------------------------------------------------------


### 16.Iterator
##### Giới thiệu về Iterator
Iterator Pattern là một trong những Pattern thuộc nhóm hành vi Behavior Pattern. Nó được sử dụng để cung cấp một cách thức truy cập tuần tự tới các phần tử của một đối tượng tổng hợp, mà không cần phải tạo dựng riêng các phương pháp truy cập cho đối tượng tổng hợp này.
##### Cách sử dụng Iterator trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Iterator** được thể hiện như sau:
```
// Iterator provides a iterator interface.
type Iterator interface {
	Index() int
	Value() interface{}
	Has() bool
	Next()
	Prev()
	Reset()
	End()
}
// Aggregate provides a collection interface.
type Aggregate interface {
	Iterator() Iterator
}
```

```
// BookIterator implements the Iterator interface.
type BookIterator struct {
	shelf    *BookShelf
	index    int
	internal int
}
// Index returns current index
func (i *BookIterator) Index() int {
	return i.index
}
// Value returns current value
func (i *BookIterator) Value() interface{} {
	return i.shelf.Books[i.index]
}
```

##### Nhận xét về cách sử dụng Iterator ở trên:
* Iterator: là một interface class, định nghĩa các phương thức để truy cập và duyệt qua các phần tử.
* Có thể implement các loại collection mới và iterator mới, sau đó chuyển chúng vào code hiện có mà không vi phạm bất cứ nguyên tắc gì.
-------------------------------------------------------------------------
