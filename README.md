# Bài Tập Design Pattern 

## Thành viên nhóm:

+ **Trần Huỳnh Đức - 19020526**
+ **Nông Đức Việt Anh - 19020495**
+ **Phạm Tiến Dũng - 19020532**
+ **Phạm Hoàng Anh - 19020499**

## Các link repository:

+ https://github.com/MrEngineer13/SnackBar
+ https://github.com/roughike/BottomBar
+ https://github.com/aritraroy/PatternLockView
+ https://github.com/Anuken/Mindustry

## Ngôn ngữ: Java 100%



## Creational

1. **Singleton**

   * **Singleton** đảm bảo chỉ duy nhất **một thể hiện (instance)** được tạo ra và nó sẽ cung cấp cho bạn một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.
   * Sử dụng **Singleton** khi chúng ta muốn:
     - Đảm bảo rằng chỉ có một instance của lớp.
     - Việc quản lý việc truy cập tốt hơn vì chỉ có một thể hiện duy nhất.
     - Có thể quản lý số lượng thể hiện của một lớp trong giớn hạn chỉ định.

### Example:



```swift

final class ElonMusk {



  static let shared = ElonMusk()



  private init() {

​    // Private initialization to ensure just one instance is created.

  }

}

```



### Usage:



```swift

let elon = ElonMusk.shared // There is only one Elon Musk folks.

```



* Ở trong ví dụ này thì chỉ có một instance của class ElonMusk tồn tại.

## Factory Method

* **Factory Method Design Pattern** hay gọi ngắn gọn là **Factory Pattern** là một trong những Pattern thuộc nhóm **Creational Design Pattern**. Nhiệm vụ của Factory Pattern là quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một cách linh hoạt hơn
* **Factory Pattern** đúng nghĩa là một **nhà máy**, và nhà máy này sẽ “**sản xuất**” các đối tượng theo yêu cầu của chúng ta.
* Trong Factory Pattern, chúng ta tạo đối tượng mà không để lộ logic tạo đối tượng ở phía người dùng và tham chiếu đến đối tượng mới được tạo ra bằng cách sử dụng một interface chung.
* Factory Pattern được sử dụng khi có một class cha (super-class) với nhiều class con (sub-class), dựa trên đầu vào và phải trả về 1 trong những class con đó.

### Example



```swift

protocol *CurrencyDescribing* {

  var symbol: *String* { get }

  var code: *String* { get }

}



final class Euro: CurrencyDescribing {

  var symbol: *String* {

​    return "€"

  }

  

  var code: *String* {

​    return "EUR"

  }

}



final class UnitedStatesDolar: CurrencyDescribing {

  var symbol: *String* {

​    return "$"

  }

  

  var code: *String* {

​    return "USD"

  }

}



enum *Country* {

  case unitedStates

  case spain

  case uk

  case greece

}



enum *CurrencyFactory* {

  static func currency(for *country*: Country) -> CurrencyDescribing? {



​    switch country {

​      case .spain, .greece:

​        return Euro()

​      case .unitedStates:

​        return UnitedStatesDolar()

​      default:

​        return nil

​    }

​    

  }

}

```



### Usage



```swift

let noCurrencyCode = "No Currency Code Available"



CurrencyFactory.currency(for: .greece)?.code ?? noCurrencyCode

CurrencyFactory.currency(for: .spain)?.code ?? noCurrencyCode

CurrencyFactory.currency(for: .unitedStates)?.code ?? noCurrencyCode

CurrencyFactory.currency(for: .uk)?.code ?? noCurrencyCode

```
* u

## Abstract Factory
* Abstract Factory pattern là một trong những Creational pattern. Nó là phương pháp tạo ra một Super-factory dùng để tạo ra các Factory khác. Hay còn được gọi là Factory của các Factory. Abstract Factory Pattern là một Pattern cấp cao hơn so với Factory Method Pattern.
* Trong Abstract Factory pattern, một interface có nhiệm vụ tạo ra một Factory của các object có liên quan tới nhau mà không cần phải chỉ ra trực tiếp các class của object. Mỗi Factory được tạo ra có thể tạo ra các object bằng phương pháp giống như Factory pattern.
* Hãy tưởng tượng, Abstract factory như là một nhà máy lớn chứa nhiều nhà máy nhỏ, trong các nhà máy đó có những xưởng sản xuất, các xưởng đó tạo ra những sản phẩm khác nhau.

### Example

Protocols

```swift

protocol BurgerDescribing {
    var ingredients: [String] { get }
}

struct CheeseBurger: BurgerDescribing {
    let ingredients: [String]
}

protocol BurgerMaking {
    func make() -> BurgerDescribing
}

// Number implementations with factory methods

final class BigKahunaBurger: BurgerMaking {
    func make() -> BurgerDescribing {
        return CheeseBurger(ingredients: ["Cheese", "Burger", "Lettuce", "Tomato"])
    }
}

final class JackInTheBox: BurgerMaking {
    func make() -> BurgerDescribing {
        return CheeseBurger(ingredients: ["Cheese", "Burger", "Tomato", "Onions"])
    }
}

```

Abstract factory

```swift

enum BurgerFactoryType: BurgerMaking {

    case bigKahuna
    case jackInTheBox

    func make() -> BurgerDescribing {
        switch self {
        case .bigKahuna:
            return BigKahunaBurger().make()
        case .jackInTheBox:
            return JackInTheBox().make()
        }
    }
}
```

### Usage

```swift
let bigKahuna = BurgerFactoryType.bigKahuna.make()
let jackInTheBox = BurgerFactoryType.jackInTheBox.make()
```

## Builder
* Builder pattern là một trong những Creational pattern. Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.
* Builder Pattern được xây dựng để khắc phục một số nhược điểm của Factory Pattern và Abstract Factory Pattern khi mà Object có nhiều thuộc tính.
* Có ba vấn đề chính với  Factory Pattern và Abstract Factory Pattern khi Object có nhiều thuộc tính:

    * Quá nhiều tham số phải truyền vào từ phía client tới Factory Class.
    * Một số tham số có thể là tùy chọn nhưng trong Factory Pattern, chúng ta phải gửi tất cả tham số, với tham số tùy chọn nếu không nhập gì thì sẽ truyền là null.
    * Nếu một Object có quá nhiều thuộc tính thì việc tạo sẽ phức tạp.

### Example

```swift
final class DeathStarBuilder {

    var x: Double?
    var y: Double?
    var z: Double?

    typealias BuilderClosure = (DeathStarBuilder) -> ()

    init(buildClosure: BuilderClosure) {
        buildClosure(self)
    }
}

struct DeathStar : CustomStringConvertible {

    let x: Double
    let y: Double
    let z: Double

    init?(builder: DeathStarBuilder) {

        if let x = builder.x, let y = builder.y, let z = builder.z {
            self.x = x
            self.y = y
            self.z = z
        } else {
            return nil
        }
    }

    var description:String {
        return "Death Star at (x:\(x) y:\(y) z:\(z))"
    }
}
```

### Usage

```swift
let empire = DeathStarBuilder { builder in
    builder.x = 0.1
    builder.y = 0.2
    builder.z = 0.3
}

let deathStar = DeathStar(builder:empire)
```

## Prototype
* Prototype pattern là một trong những Creational pattern. Nó có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new. Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.
* Prototype Pattern được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại.
* Trong Java cung cấp mẫu prototype pattern này bằng việc implement interface Cloneable và sử dụng method clone() để tạo object có đầy đủ thuộc tính của đối tượng ban đầu.

### Example

```swift
class MoonWorker {

    let name: String
    var health: Int = 100

    init(name: String) {
        self.name = name
    }

    func clone() -> MoonWorker {
        return MoonWorker(name: name)
    }
}
```

### Usage

```swift
let prototype = MoonWorker(name: "Sam Bell")

var bell1 = prototype.clone()
bell1.health = 12

var bell2 = prototype.clone()
bell2.health = 23

var bell3 = prototype.clone()
bell3.health = 0
```

## Object Pool
* Object Pool Pattern là một trong những Creational pattern. Nó không nằm trong danh sách các Pattern được giới thiệu bởi GoF. Object Pool Pattern cung cấp một kỹ thuật để tái sử dụng objects thay vì khởi tạo không kiểm soát.
* Ý tưởng của Object Pooling là: chúng ta dùng Object Pool Pattern quản lý một tập hợp các objects mà sẽ được tái sử dụng trong chương trình. Khi client cần sử dụng object, thay vì tạo ra một đối tượng mới thì client chỉ cần đơn giản yêu cầu Object pool lấy một đối tượng đã có sẵn trong object pool. Sau khi object được sử dụng nó sẽ không hủy mà sẽ được trả về pool cho client khác sử dụng. Nếu tất cả các object trong pool được sử dụng thì client phải chờ cho tới khi object được trả về pool.
* Object pool thông thường hoạt động theo kiểu: tự tạo đối tượng mới nếu chưa có sẵn hoặc khởi tạo trước 1 object pool chứa một số đối tượng hạn chế trong đó.





## Structural

1. **Adapter**


2. **Bridge**


3. **Composite**


4. **Decorator**


5. **Facade**


6. **Flyweight**


7. **Proxy**



## Behavioral

1. **Chain of Responsibility**


2. **Command**


3. **Interpreter**


4. **Iterator**


5. **Mediator**


6. **Memento**


7. **Observer**


8. **State**


9.  **Strategy**


10. **Temple Method**


11. **Visitor**
https://github.com/torokmark/design_patterns_in_typescript/blob/master/visitor/visitor.ts



