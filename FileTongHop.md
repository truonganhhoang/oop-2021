# Báo cáo design parttens môn OOP
Báo cáo môn OOP INT2204 3<br>
Thành viên nhóm gồm:<br>
* Lê Sỹ Hưng - 19020315 - P1-8<br>
* Trần Đức Mạnh - 19020365 P17-23<br>
* Trần Sơn Tùng - 19020480 P9-16 

### 1.Singleton Pattern
##### Giới thiệu về Singleton Pattern
Singleton đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp cho chúng ta một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.
##### Cách sử dụng Singleton Pattern trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Singleton Pattern** được thể hiện như sau:
```
// Package singleton is an example of the Singleton Pattern.
package singleton
import (
	"sync"
)
// Singleton implementation.
type Singleton struct {
}
var (
	instance *Singleton
	once     sync.Once
)
// GetInstance returns singleton
func GetInstance() *Singleton {
	once.Do(func() {
		instance = &Singleton{}
	})
	return instance
}
```

##### Nhận xét về cách sử dụng Singleton Pattern ở trên:
* Đoạn code cho chúng ta thấy chỉ có một instance của lớp.
* Việc quản lý việc truy cập tốt hơn vì chỉ có một thể hiện duy nhất.
* Có thể quản lý số lượng thể hiện của một lớp trong giớn hạn chỉ định.
-------------------------------------------------------------------------

### 2.Abstract Factory 
##### Giới thiệu về Abstract Factory 
Abstract Factory pattern là một trong những Creational pattern. Nó là phương pháp tạo ra một Super-factory dùng để tạo ra các Factory khác. Hay còn được gọi là Factory của các Factory.
##### Cách sử dụng Abstract Factory  trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Abstract Factory** được thể hiện như sau:
```
// Package abstract_factory is an example of the Abstract Factory Pattern.
package abstract_factory
// AbstractFactory provides an interface for creating families of related objects.
type AbstractFactory interface {
	CreateWater(volume float64) AbstractWater
	CreateBottle(volume float64) AbstractBottle
}
// AbstractWater provides a water interface.
type AbstractWater interface {
	GetVolume() float64
}
// AbstractBottle provides a bottle interface.
type AbstractBottle interface {
	PourWater(water AbstractWater) // Bottle interacts with a water.
	GetBottleVolume() float64
	GetWaterVolume() float64
}
```

```
// CocaColaFactory implements AbstractFactory interface.
type CocaColaFactory struct {
}
// NewCocaColaFactory is the CocaColaFactory constructor.
func NewCocaColaFactory() AbstractFactory {
	return &CocaColaFactory{}
}
// CreateWater implementation.
func (f *CocaColaFactory) CreateWater(volume float64) AbstractWater {
	return &CocaColaWater{volume: volume}
}
// CreateBottle implementation.
func (f *CocaColaFactory) CreateBottle(volume float64) AbstractBottle {
	return &CocaColaBottle{volume: volume}
}
```

```
type CocaColaBottle struct {
	water  AbstractWater // Bottle must contain a drink.
	volume float64       // Volume of bottle.
}
```

##### Nhận xét về cách sử dụng Singleton Pattern ở trên:
* định nghĩa ra CocaColaFactory để xây dựng, cài đặt các phương thức tạo các đối tượng cụ thể
* định nghĩa ra AbstractBottle để khai báo dạng interface hoặc abstract class để định nghĩa đối tượng abstract.


-------------------------------------------------------------------

### 3.Builder
##### Giới thiệu về Builder
Builder pattern là một trong những Creational pattern. Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.
##### Cách sử dụng Builder trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Builder** được thể hiện như sau:
```
// Package builder is an example of the Builder Pattern.
package builder
// Builder provides a builder interface.
type Builder interface {
	MakeHeader(str string)
	MakeBody(str string)
	MakeFooter(str string)
}
```

```
// ConcreteBuilder implements Builder interface.
type ConcreteBuilder struct {
	product *Product
}
// MakeHeader builds a header of document..
func (b *ConcreteBuilder) MakeHeader(str string) {
	b.product.Content += "<header>" + str + "</header>"
}
// MakeBody builds a body of document.
func (b *ConcreteBuilder) MakeBody(str string) {
	b.product.Content += "<article>" + str + "</article>"
}
// MakeFooter builds a footer of document.
func (b *ConcreteBuilder) MakeFooter(str string) {
	b.product.Content += "<footer>" + str + "</footer>"
}
```

##### Nhận xét về cách sử dụng Builder ở trên:
* Builder : là interface khai báo phương thức tạo đối tượng.
* ConcreteBuilder : kế thừa Builder và cài đặt chi tiết cách tạo ra đối tượng. Nó sẽ xác định và nắm giữ các thể hiện mà nó tạo ra, đồng thời nó cũng cung cấp phương thức để trả các các thể hiện mà nó đã tạo ra trước đó.

------------------------------------------------------
### 4.Factory Method
##### Giới thiệu về Factory Method
Factory Method Design Pattern hay gọi ngắn gọn là Factory Pattern là một trong những Pattern thuộc nhóm Creational Design Pattern. Nhiệm vụ của Factory Pattern là quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn.
##### Cách sử dụng Factory Method trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Factory Method** được thể hiện như sau:
```
// Creator provides a factory interface.
type Creator interface {
	CreateProduct(action action) Product // Factory Method
}
```

```
// CreateProduct is a Factory Method.
func (p *ConcreteCreator) CreateProduct(action action) Product {
	var product Product
	switch action {
	case A:
		product = &ConcreteProductA{string(action)}
	case B:
		product = &ConcreteProductB{string(action)}
	case C:
		product = &ConcreteProductC{string(action)}
	default:
		log.Fatalln("Unknown Action")
	}
	return product
}
```


##### Nhận xét về cách sử dụng Factory Method ở trên:
* Creator là một supper class trong Factory Pattern và là một interface,
* Factory class sử dụng Factory method dạng switch-case để xác định class con đầu ra.

--------------------------------------------------------------

### 5.Prototype
##### Giới thiệu về Prototype
Prototype pattern là một trong những Creational pattern. Nó có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new. Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.
##### Cách sử dụng Prototype trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Prototype** được thể hiện như sau:
```
// Package prototype is an example of the Singleton Pattern.
package prototype
// Prototyper provides a cloning interface.
type Prototyper interface {
	Clone() Prototyper
	GetName() string
}
// ConcreteProduct implements product "A"
type ConcreteProduct struct {
	name string // Имя продукта
}
// NewConcreteProduct is the Prototyper constructor.
func NewConcreteProduct(name string) Prototyper {
	return &ConcreteProduct{
		name: name,
	}
}
// GetName returns product name
func (p *ConcreteProduct) GetName() string {
	return p.name
}
// Clone returns a cloned object.
func (p *ConcreteProduct) Clone() Prototyper {
	return &ConcreteProduct{p.name}
}
```

##### Nhận xét về cách sử dụng Prototype ở trên:
* Cải thiện performance: giảm chi phí để tạo ra một đối tượng mới theo chuẩn, điều này sẽ làm tăng hiệu suất so với việc sử dụng từ khóa new để tạo đối tượng mới.
* Giảm độ phức tạp cho việc khởi tạo đối tượng: do mỗi lớp chỉ implement cách clone của chính nó.


----------------------------------------------------------------------------
### 6.Adapter
##### Giới thiệu về Adapter
Adapter Pattern là một trong những Pattern thuộc nhóm cấu trúc. Adapter Pattern cho phép các inteface không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.
##### Cách sử dụng Adapter trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Adapter** được thể hiện như sau:
```
// Package adapter is an example of the Adapter Pattern.
package adapter
// Target provides an interface with which the system should work.
type Target interface {
	Request() string
}
// Adaptee implements system to be adapted.
type Adaptee struct {
}
```

```
// NewAdapter is the Adapter constructor.
func NewAdapter(adaptee *Adaptee) Target {
	return &Adapter{adaptee}
}
// SpecificRequest implementation.
func (a *Adaptee) SpecificRequest() string {
	return "Request"
}
// Adapter implements Target interface and is an adapter.
type Adapter struct {
	*Adaptee
}
// Request is an adaptive method.
func (a *Adapter) Request() string {
	return a.SpecificRequest()
}
```

##### Nhận xét về cách sử dụng Adapter ở trên:
* Cho phép nhiều đối tượng có interface giao tiếp khác nhau có thể tương tác và giao tiếp với nhau.
* Tăng khả năng sử dụng lại thư viện với interface không thay đổi do không có mã nguồn.

-------------------------------------------------

### 7.Bridge
##### Giới thiệu về Bridge
Bridge Pattern là một trong những Pattern thuộc nhóm cấu trúc Structural Pattern. Ý tưởng của nó là tách tính trừu tượng ra khỏi tính hiện thực của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu.
##### Cách sử dụng Bridge trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Bridge** được thể hiện như sau:
```
// Carer provides car interface.
type Carer interface {
	Rase() string
}
// Enginer provides engine interface.
type Enginer interface {
	GetSound() string
}
// Car implementation.
type Car struct {
	engine Enginer
}
```

```
// NewCar is the Car constructor.
func NewCar(engine Enginer) Carer {
	return &Car{
		engine: engine,
	}
}
// Rase implementation.
func (c *Car) Rase() string {
	return c.engine.GetSound()
}
```

##### Nhận xét về cách sử dụng Bridge ở trên:
* Implementor: định ra các interface cho các lớp hiện thực. Thông thường nó là interface định ra các tác vụ nào đó của Abstraction.
* Code sẽ gọn gàn hơn và kích thước ứng dụng sẽ nhỏ hơn: do giảm được số class không cần thiết.

-------------------------------------------------

### 8.Composite
##### Giới thiệu về Composite
Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.
##### Cách sử dụng Composite trong link github tìm được
Trong phần repo ở [link github](https://github.com/AlexanderGrom/go-patterns) mà nhóm bọn mình đã tìm hiểu được thì việc sử dụng **Composite** được thể hiện như sau:
```
// Component provides an interface for branches and leaves of a tree.
type Component interface {
	Add(child Component)
	Name() string
	Child() []Component
	Print(prefix string) string
}
// Directory implements branches of a tree
type Directory struct {
	name   string
	childs []Component
}
```

```
// Add appends an element to the tree branch.
func (d *Directory) Add(child Component) {
	d.childs = append(d.childs, child)
}
// Name returns name of the Component.
func (d *Directory) Name() string {
	return d.name
}
// Child returns child elements.
func (d *Directory) Child() []Component {
	return d.childs
}
```

##### Nhận xét về cách sử dụng Composite ở trên:
* Base Component: là một interface hoặc abstract class quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.
* Việc quản lý việc truy cập tốt hơn vì chỉ có một thể hiện duy nhất.
* Cung cấp cùng một cách sử dụng đối với từng đối tượng riêng lẻ hoặc nhóm các đối tượng với nhau.

----------------------------------------------------------------------

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


