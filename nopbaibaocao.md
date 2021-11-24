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
