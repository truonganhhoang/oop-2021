# So sánh với mẫu chuẩn

Thành viên: 
- Phùng Đức Thản 
- Đinh Duy Thành
- Nguỵ Thế Huy

**Link GitHub sử dụng: https://github.com/tylerlaberge/PyPattyrn**

**Python**

# 1. Factory Method

**Giống nhau:**
	
- Sử dụng mẫu thiết kế Factory pattern: là một trong những Pattern thuộc nhóm Creational Design Pattern. Factory Method cho phép các lớp con chọn kiểu đối tượng cần tạo, giúp cho việc khởi tạo đối tượng một cách linh hoạt hơn.
	
- Gồm các thành phần cơ bản: Sub classes, Factory class,...
	
- Factory class là AnimalFactory có trách nhiệm khởi tạo các sub classes.

**Khác nhau:**
	
- Không có thành phần Super class.

**Src code**
````
class Cat(object):

    def speak(self):
        print('meow')


class Dog(object):

    def speak(self):
        print('woof')


class AnimalFactory(Factory):  # A factory class for creating animals.

    def create(self, animal_type):  # Implement the abstract create method.
        if animal_type == 'cat':
            return Cat()
        elif animal_type == 'dog':
            return Dog()
        else:
            return None
````
# 2. Abstract Factory

**Giống nhau:**

- Sử dụng mẫu thiết kế Abstract Factory: là một trong những Pattern thuộc nhóm Creational Design Pattern. Abstract Factory cho phép một lớp trả về một nhà máy của các lớp, được sử dụng khi hệ thống cần phải độc lập với cách đối tượng của nó được tạo ra hoặc khi hệ thống cần được cấu hình với một trong nhiều họ đối tượng.
	
- Gồm các thành phần cơ bản: Sub classes, Factory class, Abstract Factory class...
	
- Factory class là AnimalFactory và InsectFactory có trách nhiệm khởi tạo các sub classes.

- Abstract Factory class là CreatureFactory.

**Khác nhau:**

- Không có Super class để các Sub class kế thừa (ví dụ khai báo 1 class có tên Creatures trong đó có method Activity()).

**Src code**
````
class Cat(object):

    def speak(self):
        print('meow')


class Dog(object):

    def speak(self):
        print('woof')


class Ant(object):

    def march(self):
        print('march')


class Fly(object):

    def fly(self):
        print('fly')


class AnimalFactory(Factory):  # A factory class for creating animals.

    def create(self, animal_type):  # Implement the abstract create method.
        if animal_type == 'cat':
            return Cat()
        elif animal_type == 'dog':
            return Dog()
        else:
            return None


class InsectFactory(Factory):  # A factory class for creating insects.

    def create(self, insect_type):  # Implement the abstract create method.
        if insect_type == 'ant':
            return Ant()
        elif insect_type == 'fly':
            return Fly()
        else:
            return None


class CreatureFactory(AbstractFactory):  # A Factory class for creating creatures.

    def __init__(self):
        super().__init__()
        self._register('insect_factory', InsectFactory())  # Register an InsectFactory with a keyword.
        self._register('animal_factory', AnimalFactory())  # Register an AnimalFactory with a keyword.

    def create(self, creature_type):  # Implement the Abstract create method.
        if creature_type == 'cat' or creature_type == 'dog':
            return self._factories['animal_factory'].create(creature_type)  #Use the AnimalFactory
        elif creature_type == 'ant' or creature_type == 'fly':
            return self._factories['insect_factory'].create(creature_type)  #Use the InsectFactory
        else:
            return None
````

# 3. Buider

**Giống nhau:**

- Sử dụng mẫu thiết kế Builder: là một mẫu thiết kế sáng tạo cho phép bạn xây dựng các đối tượng phức tạp theo từng bước. Mẫu cho phép bạn tạo ra các kiểu và hình ảnh đại diện khác nhau của một đối tượng bằng cách sử dụng cùng một mã xây dựng.

- Được sử dụng khi tạo một đối tượng phức tạp và có quá nhiều Constructor.

- Gồm các thành phần: Product(class Building), Builder(class HomeBuilder), Director(class HomeDirector), ConcreteBuilder(class FlatBuilder). 
	
**Khác nhau:**

- Hầu như không có sự khác nhau vì mẫu thiết kế này được xây dựng dựa trên mẫu thiết kế chuẩn.

**Src code**
````
class Building(object):  # The object being constructed.

    def __init__(self):
        self.floor = None
        self.size = None

    def __repr__(self):
        return 'Floor: {0.floor} | Size: {0.size}'.format(self)


class HomeBuilder(Builder):  # A base Builder class for constructing homes.

    def __init__(self):
        super().__init__(Building())  # Initialize the Builder class with a Building instance.
        self._register('floor', self._build_floor)  # Register the keyword 'floor' with the _build_floor method.
        self._register('size', self._build_size)  # Register the keyword 'size' with the _build_size method.

    def _build_floor(self):
        pass

    def _build_size(self):
        pass


class HouseBuilder(HomeBuilder):  # A concrete HomeBuilder class for constructing houses

    def _build_floor(self):
        self.constructed_object.floor = 'One'  # Alter the Building's floor attribute.

    def _build_size(self):
        self.constructed_object.size = 'Big'  # Alter the Building's size attribute.


class FlatBuilder(HomeBuilder):  # A concrete HomeBuilder class for constructing flats

    def _build_floor(self):
        self.constructed_object.floor = 'More than one'  # Alter the Building's floor attribute.

    def _build_size(self):
        self.constructed_object.size = 'Small'  # Alter the Building's size attribute.


class HomeDirector(Director):  # A Director class for managing home construction.

    def construct(self):
        self.builder.build('floor')  # Build the floor part of the Building by using the keyword 'floor'
        self.builder.build('size')  # Build the size part of the Building by using the keyword 'size'

````
# 4. Prototype 

**Giống nhau:**

- Sử dụng mẫu thiết kế Prototype pattern: là một trong những Creational pattern, có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new. 

- Prototype Pattern được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại 

**Khác nhau:**

- Không có sự khác biệt vì mẫu thiết kế này chỉ tạo các lớp implement và method clone().

**Src code**
````
class Point(Prototype):
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def move(self, x, y):
        self.x += x
        self.y += y


point_one = Point(15, 15)
point_two = point_one.prototype(z=20)
point_three = point_two.prototype()

assert point_one.x == point_two.x
assert point_one.y == point_two.y
assert not hasattr(point_one, 'z')
assert hasattr(point_two, 'z')
assert point_two.z == 20
assert point_three.__dict__ == point_two.__dict__

from math import sqrt
def distance_to(this, other):
    return sqrt((this.x - other.x) ** 2 + (this.y - other.y) ** 2)
````

# 5. Singleton

**Giống nhau:**

- Sử dụng Singleton pattern: là mẫu thiết kế sáng tạo cho phép đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.

- Mỗi class bao gồm 1 class Singleton và 1 class SingletonClient để kiểm tra tính unique của Singleton class

**Khác nhau:**

- Có nhiều cách để implement Singleton class, như trong ví dụ dưới đây là 1 cách, còn lại có thể implement theo Static block initialization hay Lazy Initialization...v.v..

**Src code**
````
class DummySingletonOne(object, metaclass=Singleton):

    def __init__(self):
        pass


class DummySingletonTwo(object, metaclass=Singleton):

    def __init__(self):
        pass


dummy_class_one_instance_one = DummySingletonOne()
dummy_class_one_instance_two = DummySingletonOne()

dummy_class_two_instance_one = DummySingletonTwo()
dummy_class_two_instance_two = DummySingletonTwo()

assert id(dummy_class_one_instance_one) == id(dummy_class_one_instance_two)
assert id(dummy_class_two_instance_one) == id(dummy_class_two_instance_two)

assert id(dummy_class_one_instance_one) != id(dummy_class_two_instance_one)
assert id(dummy_class_one_instance_two) != id(dummy_class_two_instance_two)
````
# 6. Pool Pattern

**Giống nhau**
- Sử dụng Object Pool Pattern cung cấp một kỹ thuật để tái sử dụng objects thay vì khởi tạo không kiểm soát.

- Khi client cần sử dụng object, thay vì tạo ra một đối tượng mới thì client chỉ cần đơn giản yêu cầu Object pool lấy một đối tượng đã có sẵn trong object pool. Sau khi object được sử dụng nó sẽ không hủy mà sẽ được trả về pool cho client khác sử dụng.

**Khác nhau:**

- Không có sự khác biệt vì mẫu thiết kế này đều xây dựng hàm release() và aquires().

**Src code**
````
from abc import ABCMeta
from copy import deepcopy
from pypattyrn.behavioral.memento import Originator


class Reusable(Originator, metaclass=ABCMeta):
    """
    An abstract reusable class.
    - External Usage documentation: U{https://github.com/tylerlaberge/PyPattyrn#object-pool-pattern}
    - External Object Pool Pattern documentation: U{https://en.wikipedia.org/wiki/Object_pool_pattern}
    """
    def __init__(self):
        """
        Initialize a new Reusable instance.
        """
        self.memento = self.commit()

    def reset(self):
        """
        Reset this objects state to the state that it was created with.
        """
        memento = self.memento
        self.rollback(deepcopy(memento))
        self.memento = memento


class Pool(object):
    """
    An Object Pool design pattern implementation.
    - External Usage documentation: U{https://github.com/tylerlaberge/PyPatterns/wiki/Creational-Pattern-Usage}
    - External Object Pool Pattern documentation: U{https://en.wikipedia.org/wiki/Object_pool_pattern}
    """
    def __init__(self, reusable_class, *args, **kwargs):
        """
        Initialize a new object pool instance.
        @param reusable_class: The reusable class this object pool is responsible for.
        @param args: args for reusable object creation.
        @param kwargs: kwargs for reusable object creation.
        """
        self.reusables = list()
        self.reusable_class = reusable_class
        self.args = args
        self.kwargs = kwargs
        self.pool_size = 2
        self._expand(self.pool_size)

    def acquire(self):
        """
        Acquire an object from the pool.
        @return: An object from the pool.
        """
        try:
            reusable = self.reusables.pop()
        except IndexError:
            self._expand(self.pool_size)
            reusable = self.reusables.pop()

        return reusable

    def release(self, reusable):
        """
        Release an object back into the pool.
        @param reusable: The object to return to the pool.
        """
        reusable.reset()
        self.reusables.append(reusable)

    def _expand(self, size):
        for i in range(0, size):
            self.reusables.append(self.reusable_class(*self.args, **self.kwargs))
````

# 7. Adaper Pattern

**Giống nhau**

- Sử dụng Adapter Pattern cho phép các inteface (giao diện) không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.

- Chuyển đổi interface của một hay nhiều lớp có sẵn thành một interface khác, thích hợp cho lớp đang viết.

**Khác nhau**

- Sự khác biệt chính là Class Adapter sử dụng Inheritance (kế thừa) để kết nối Adapter và Adaptee trong khi Object Adapter sử dụng Composition (chứa trong) để kết nối Adapter và Adaptee.

- Trong cách tiếp cận Class Adapter, nếu một Adaptee là một class và không phải là một interface thì Adapter sẽ là một lớp con của Adaptee. Do đó, nó sẽ không phục vụ tất cả các lớp con khác theo cùng một cách vì Adapter là một lớp phụ cụ thể của Adaptee.
 
**Src Code**
````
class Adapter(object):
    """
    Adapter class as part of the Adapter design pattern.
    - External Usage Documentation: U{https://github.com/tylerlaberge/PyPattyrn#adapter-pattern}
    - External Adapter Pattern Documentation: U{https://en.wikipedia.org/wiki/Adapter_pattern}
    """
    def __init__(self, adaptee, **adapted_methods):
        """
        Initialize a new adapter instance.
        @param adaptee: The object to adapt to a new interface.
        @type adaptee: Object
        @param adapted_methods: A dictionary of methods to adapt.
        @type adapted_methods: dict
        """
        self.__adaptee = adaptee
        self.__dict__.update({k: v for k, v in adapted_methods.items() if callable(v) and
                              getattr(self.__adaptee, v.__name__, None)})

    def __getattr__(self, attr):
        """
        All non-adapted calls are passed to the adaptee.
        @param attr: The attribute to get from the adaptee.
        """
        return getattr(self.__adaptee, attr)

    def original_dict(self):
        """
        Get the adaptee's  __dict__
        """
        return self.__adaptee.__dict__
````

# 8. Composite Pattern

**Giống nhau**

- Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.

- Sắp xếp các object theo cấu trúc cây để diễn giải 1 phần cũng như toàn bộ hệ thống phân cấp. Pattern này tạo một lớp chứa nhóm đối tượng của riêng nó. Lớp này cung cấp các cách để sửa đổi nhóm của cùng 1 object.

**Khác nhau**

- Không có sự khác nhau vì đều có cấu trúc Component -> Composite/Leaf

**Src Code**
````
class Composite(object):
    """
    Composite class as part of the Composite pattern.
    - External Usage Documentation: U{https://github.com/tylerlaberge/PyPattyrn#composite-pattern}
    - External Composite Pattern documentation: U{https://en.wikipedia.org/wiki/Composite_pattern}
    """
    def __init__(self, interface):
        """
        Initialize a new Composite instance.
        @param interface: The interface the all child components must adhere to when added to this composite.
        @type interface: class
        """
        self.components = set()
        self.interface = interface

    def add_component(self, component):
        """
        Add a component to this composite.
        @param component: The component to add to this Composite
        @raise AttributeError: If the component does not adhere to this Composites interface.
        """
        valid = False
        try:
            if component.interface == self.interface:
                valid = True
        except AttributeError:
            if self.interface in component.__class__.__mro__:
                valid = True
        finally:
            if valid:
                self.components.add(component)
            else:
                raise AttributeError('Component {0} does not follow this composites interface {1}'.format(
                    component.__class__, self.interface))

    def remove_component(self, component):
        """
        Remove a component from this composite.
        @param component: The component to remove from this Composite.
        """
        try:
            self.components.remove(component)
        except KeyError:
            pass

    def _delegate(self, func_name):
        """
        Apply a function to all child components by function name.
        @param func_name: The name of the function to call with all child components.
        @type func_name: str
        @raise AttributeError: If a child component does not have a callable function with the given name.
        """
        for component in self.components:
            attribute = getattr(component, func_name)
            if callable(attribute):
                attribute()
            else:
                raise AttributeError()

    def __getattr__(self, item):
        """
        Override getattr to delegate all function calls to children.
        @param item: The function to call with this composites children components.
        @type item: str
        @return: A function that when called will call all child functions with the given function name.
        """
        return lambda: self._delegate(item)
````

# 9. Decorator Pattern

**Giống nhau**

- Cho phép người dùng thêm chức năng mới vào đối tượng hiện tại mà không muốn ảnh hưởng đến các đối tượng khác. 

- Tất cả các wrapper có một trường để lưu trữ một giá trị của một đối tượng gốc. Hầu hết các wrapper khởi tạo trường đó với một đối tượng được truyền vào constructor của chúng.

**Khác nhau**

- Decorator cho phép thêm một tính năng mới vào một object nhưng không được phép sử dụng thừa kế. Nó cho phép thay đổi lúc thực thi (run-time).

- Có xu hướng hoạt động trên một đối tượng.

**Src Code**
````
from functools import partial
from abc import ABCMeta, abstractmethod

class Decorator(object, metaclass=ABCMeta):
    """
    Base Decorator class that all decorator classes inherit from.
    - External Usage Documentation: U{https://github.com/tylerlaberge/PyPattyrn#decorator-pattern}
    - External Decorator Pattern documentation: U{https://en.wikipedia.org/wiki/Decorator_pattern}
    """
    def __get__(self, instance, owner):
        """
        Override __get__ in order to get the instance of a bound of method call.
        """
        return partial(self.__call__, instance)

    @abstractmethod
    def __call__(self, *args, **kwargs):
        """
        All decorators must implement a __call__ method.
        """
        pass


class DecoratorSimple(Decorator, metaclass=ABCMeta):
    """
    A Base Decorator class for decorators with no arguments.
    - External Usage Documentation: U{https://github.com/tylerlaberge/PyPattyrn#decorator-pattern}
    - External Decorator Pattern documentation: U{https://en.wikipedia.org/wiki/Decorator_pattern}
    """
    def __init__(self, func):
        """
        Initialize a new DecoratorSimple instance.
        @param func: The function being decorated.
        """
        self.func = func


class DecoratorComplex(Decorator, metaclass=ABCMeta):
    """
    A Base Decorator class for decorators with arguments.
    - External Usage Documentation: U{https://github.com/tylerlaberge/PyPattyrn#decorator-pattern}
    - External Decorator Pattern documentation: U{https://en.wikipedia.org/wiki/Decorator_pattern}
    """
    @abstractmethod
    def __init__(self, *args, **kwargs):
        """
        Initialize a new DecoratorComplex instance.
        @param args: Args for the decorator.
        @param kwargs: Keyword args for the decorator.
        """
        pass

    @abstractmethod
    def __call__(self, func, *args, **kwargs):
        """
        Concrete DecoratorComplex instances must override the __call__ method.
        @param func: The function being decorated.
        @param args: Arguments for the decorated function.
        @param kwargs: Keyword arguments for the decorated function.
        @return:
        """
        pass


class CallWrapper(DecoratorSimple):
    """
    A Decorator for wrapping DecoratorComplex __call__ methods.
    - External Usage Documentation: U{https://github.com/tylerlaberge/PyPattyrn#decorator-pattern}
    - External Decorator Pattern documentation: U{https://en.wikipedia.org/wiki/Decorator_pattern}
    """
    def __call__(self, instance, func):
        """
        Wrap a concrete DecoratorComplex __call__ method.
        """
        def wrapped(*args, **kwargs):
            return self.func(instance, func, *args, **kwargs)

        return wrapped
````

# 10. Flyweight Pattern


**Giống nhau**

- Nó cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng hoặc tạo đối tượng mới khi không tìm thấy đối tượng phù hợp.

- Được thiết kế nhằm giảm bộ nhớ bằng cách chia sẽ các đối tượng.

**Khác nhau**
- Flyweight object là immutable, nghĩa là không thể thay đổi khi nó đã được khởi tạo.

**Src Code**
````
class FlyweightMeta(type):
    """
    Flyweight meta class as part of the Flyweight design pattern.
    - External Usage Documentation: U{https://github.com/tylerlaberge/PyPattyrn#flyweight-pattern}
    - External Flyweight Pattern documentation: U{https://en.wikipedia.org/wiki/Flyweight_pattern}
    """
    def __new__(mcs, name, bases, attrs):
        """
        Override class construction to add 'pool' attribute to classes dict.
        @param name: The name of the class.
        @param bases: Base classes of the class.
        @param attrs: Attributes of the class.
        @return: A new Class.
        """
        attrs['pool'] = dict()
        return super(FlyweightMeta, mcs).__new__(mcs, name, bases, attrs)

    @staticmethod
    def _serialize(cls, *args, **kwargs):
        """
        Serialize arguments to a string representation.
        """
        serialized_args = [str(arg) for arg in args]
        serialized_kwargs = [str(kwargs), cls.__name__]

        serialized_args.extend(serialized_kwargs)

        return ''.join(serialized_args)

    def __call__(cls, *args, **kwargs):
        """
        Override call to use objects from a pool if identical parameters are used for object creation.
        @param args: Arguments for class instantiation.
        @param kwargs: Keyword arguments for class instantiation.
        @return: A new instance of the class.
        """
        key = FlyweightMeta._serialize(cls, *args, **kwargs)
        pool = getattr(cls, 'pool', {})

        instance = pool.get(key)
        if not instance:
            instance = super(FlyweightMeta, cls).__call__(*args, **kwargs)
            pool[key] = instance

        return instance

````
