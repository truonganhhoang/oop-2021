# Báo cáo design partens
Báo cáo môn OOP INT2204 3<br>
Thành viên nhóm gồm:<br>
* Lê Sỹ Hưng - 19020315<br>
* Trần Đức Mạnh - 19020365<br>
* Trần Sơn Tùng - 19020480

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