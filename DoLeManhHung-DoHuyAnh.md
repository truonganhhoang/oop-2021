### OOP-2021
********************************************************************************************************************************************************************************
## Danh sách thành viên trong nhóm:

* **Đỗ Huy Anh** - *20020180*

* **Đỗ Lê Mạnh Hùng** - *20020322*
********************************************************************************************************************************************************************************

# **BẢN BÁO CÁO VỀ 23 MẪU THIẾT KẾ DESIGN PATTERN**
********************************************************************************************************************************************************************************

#### *CÁC LIÊN KẾT ĐƯỢC SỬ DỤNG TRONG BÀI:*

- [Repository tham khảo 573 stars](https://bit.ly/3E8BNzk)   

- [23 mẫu chuẩn thiết kế Java design pattern](https://bit.ly/3pdSX8p)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### I. **Định nghĩa:**
- Design Pattern là một kỹ thuật trong lập trình hướng đối tượng, được sử dụng thường xuyên trong các ngôn ngữ hướng đối tượng. Design Pattern cung cấp các "mẫu thiết kế" và giải pháp để giải quyết các vấn đề chung thường gặp trong lập trình một cách tối ưu nhất.
********************************************************************************************************************************************************************************

### II. **Phân loại:**

#### *Hệ thống các mẫu Design pattern có 23 mẫu được chia thành 3 nhóm:*

**1. Creational Pattern (Nhóm khởi tạo) gồm 5 mẫu:**
- Factory Method 
- Abstract Factory 
- Builder 
- Prototype 
- Singleton

**2. Structural Pattern (nhóm cấu trúc) gồm 7 mẫu:**
- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

**3. Behavioral Pattern (nhóm tương tác/ hành vi) gồm 11 mẫu:**
- Interpreter
- Template Method
- Chain of Responsibility
- Command
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Visitor
********************************************************************************************************************************************************************************

### III. **Phân tích và so sánh:**

********************************************************************************************************************************************************************************

### **Nhóm 1:**

********************************************************************************************************************************************************************************

#### *1. Factory Method:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Factory Method](https://github.com/JamesZBL/java_design_patterns/tree/master/factory-method) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4352-huong-dan-java-design-pattern-factory-method/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.factory.method;

/**
 * 食物类型
 */
public enum FoodType {

  HOT("热的"), COLD("凉的");

  private String name;

  FoodType(String foodType) {
    this.name = foodType;
  }

  public String getName() {
    return name;
  }
}

```
![Mẫu thiết kế chuẩn](https://gpcoder.com/wp-content/uploads/2018/09/design-patterns-factory-method-diagram.png)

## _Nhận xét:_

* Mô hình các loại thức ăn.
* Super Class đã được cài đặt chính xác
* Sub Class đã được cài đặt chính xác
* Factory Class đã được cài đặt chính xác

********************************************************************************************************************************************************************************

#### *2. Abstract Factory:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Abstract Factory](https://github.com/JamesZBL/java_design_patterns/tree/master/abstract-factory) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4365-huong-dan-java-design-pattern-abstract-factory/) được minh họa bằng hình ảnh dưới đây:*

``` java
public class YoungTeamFactory implements TeamFactory {

  public Ship createShip() {
    return new NewShip();
  }

  public Captain createCaptain() {
    return new YoungCaptain();
  }

  public Sailor createSailor() {
    return new YoungSailor();
  }
}

```
![Mẫu thiết kế chuẩn](https://gpcoder.com/wp-content/uploads/2018/09/design-patterns-abstract-factory-diagram.png)

## _Nhận xét:_

* AbstractProduct được khai báo chính xác.
* Product đã được cài đặt chính xác.
* AbstractFactory được khai báo chính xác.
* ConcreteFactory có được xây dựng nhưng không theo cấu trúc chuẩn.
* Lớp YoungTeamFactory trong mã nguồn tương ứng với 1 trong 4 lớp sau: Plastic Chair, Plastic Table, Wood Chair, Wood Table.

********************************************************************************************************************************************************************************

#### *3. Builder:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Builder](https://github.com/JamesZBL/java_design_patterns/tree/master/builder) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4434-huong-dan-java-design-pattern-builder/) được minh họa bằng hình ảnh dưới đây:*

``` java
public class Person {
  private final String name;
  private final Integer age;
  private final Nationality nationality;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Nationality getNationality() {
    return nationality;
  }

  public SkinColor getSkinColor() {
    return skinColor;
  }

  private final SkinColor skinColor;

  public Person(Builder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.skinColor = builder.skinColor;
    this.nationality = builder.nationality;
  }
}
```

![Mẫu thiết kế chuẩn](https://gpcoder.com/wp-content/uploads/2018/09/design-patterns-builder-diagram.png)

## _Nhận xét:_

* ConcreteBuilder chưa kế thừa Builder
* Director đã được cài đặt chính xác
* Product  đã được cài đặt chính xác
* Builder chưa phải là abstract class hay interface

********************************************************************************************************************************************************************************

 #### *4. Prototype:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Prototype](https://github.com/JamesZBL/java_design_patterns/tree/master/prototype) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4413-huong-dan-java-design-pattern-prototype/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.prototype;

/**
 * 乘客
 */
public abstract class Passenger extends Prototype {

  @Override
  protected abstract Passenger clone() throws CloneNotSupportedException;
}
```

![Mẫu thiết kế chuẩn](https://gpcoder.com/wp-content/uploads/2018/09/design-patterns-prototype-diagram.png)

## _Nhận xét:_

* Hàm abstract giống hệt mẫu chuẩn.
* Prototype đã được cài đặt chính xác
* ConcretePrototype đã dược cài đặt chính xác
* Client đã được cài đặt
 
 ********************************************************************************************************************************************************************************

#### *5. Singleton:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Singleton](https://github.com/JamesZBL/java_design_patterns/tree/master/singleton) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4190-huong-dan-java-design-pattern-singleton/) được minh họa bằng hình ảnh dưới đây:*

``` java

public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
} 
```

![Mẫu thiết kế chuẩn](https://gpcoder.com/wp-content/uploads/2018/09/singleton-pattern.png)

## _Nhận xét:_

* Đã có một method public static được cài đặt
* Private Contructor đã được cài đặt
* Chưa cài đặt biến ở dưới dạng ***private static final***

********************************************************************************************************************************************************************************

### **Nhóm 2:**

********************************************************************************************************************************************************************************

#### *6. Adapter:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Adapter](https://github.com/JamesZBL/java_design_patterns/tree/master/adapter) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4483-huong-dan-java-design-pattern-adapter/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.adapter;

/**
 * 公共汽车适配器
 */
public class BusAdapter implements Car {

  private Bus bus;

  public BusAdapter() {
    this.bus = new Bus();
  }

  @Override
  public void drive() {
    bus.run();
  }
}

```

![Mẫu thiết kế chuẩn](https://gpcoder.com/wp-content/uploads/2018/10/design-patterns-class-adapter-diagram.png)

## _Nhận xét:_

* Một ví dụ về mô hình xe Bus trong class Car.
* Adaptee đã được khai báo chính xác
* Adapter được khai báo chính xác
* Target được khai báo chính xác

********************************************************************************************************************************************************************************

#### *7. Bridge:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Bridge](https://github.com/JamesZBL/java_design_patterns/tree/master/bridge) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4520-huong-dan-java-design-pattern-bridge/) được minh họa bằng hình ảnh dưới đây:*

``` java
public interface War {
  Enemy getEnemy();
  void startWar();
  void combatting();
  void stopWar();
}
```

``` java
package me.zbl.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 强大的敌人
 */
public class IntrepidEnemy implements Enemy {

  private static final Logger LOGGER = LoggerFactory.getLogger(IntrepidEnemy.class);

  @Override
  public void onStartWar() {
    LOGGER.info("敌人信心满满，准备迎战");
  }

  @Override
  public void onCombatting() {
    LOGGER.info("敌人正在积极反抗");
  }

  @Override
  public void onStopWar() {
    LOGGER.info("双方达成了平手");
  }
}

```

![](https://gpcoder.com/wp-content/uploads/2018/10/design-patterns-bridge-diagram.png)

## _Nhận xét:_

* Refined Abstraction được cài đặt chính xác
* Implementor được khai báo chính xác
* ConcreteImplementor được khai báo chính xác
* Abstraction có một vài phần không theo cấu trúc chuẩn
* Mô hình Intrep trong Enemy.

********************************************************************************************************************************************************************************


#### *8. Composite:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Composite](https://github.com/JamesZBL/java_design_patterns/tree/master/composite) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4554-huong-dan-java-design-pattern-composite/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母组合的抽象类
 */
public abstract class CharacterComposite {

  private List<CharacterComposite> children = new ArrayList<>();

  public void add(CharacterComposite character) {
    children.add(character);
  }

  public int count() {
    return this.children.size();
  }

  public void printBefore() {
  }

  public void printAfter() {
  }

  public void print() {
    printBefore();
    for (CharacterComposite item : children) {
      item.print();
    }
    printAfter();
  }
}

```

![a](https://gpcoder.com/wp-content/uploads/2018/11/design-patterns-composite-diagram.png)

## _Nhận xét:_

* Thêm các thứ tiếng, giống y hệt mẫu chuẩn.
* Base Component đã được khai báo chính xác
* Leaf đã được cài đặt chính xác
* Composite đã được cài đặt chính xác

********************************************************************************************************************************************************************************

#### *9. Decorator:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Decorator](https://github.com/JamesZBL/java_design_patterns/tree/master/decorator) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4574-huong-dan-java-design-pattern-decorator/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.decorator;

/**
 * 流水线上操作行为的接口
 */
public interface Operation {

  void checkBefore();

  void join();

  void chekcAfter();
}

```

![a](https://gpcoder.com/wp-content/uploads/2018/11/design-patterns-decorator-diagram.png)


## _Nhận xét:_

* Hàm Interface Operation có các hàm bên trong giống theo cấu trúc mẫu chuẩn.
* Component đã được cài đặt đúng
* ConcreteComponent đã được cài đặt chính xác
* Decorator đã được cài đặt chính xác
* ConcreteDecorator đã được cài đặt chính xác



********************************************************************************************************************************************************************************
#### *10. Facade:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Facade](https://gpcoder.com/4604-huong-dan-java-design-pattern-facade/) dùng để so sánh với [mẫu chuẩn](https://github.com/JamesZBL/java_design_patterns/tree/master/facade) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 课堂参与者抽象类
 */
public abstract class CourseParticipator {

  private static final Logger LOGGER = LoggerFactory.getLogger(CourseParticipator.class);

  public void prepareCourse() {
    LOGGER.info("{}准备上课", name());
  }

  public void proceedCourse() {
    LOGGER.info("{}正在上课", name());
  }

  public void stopCourse() {
    LOGGER.info("{}下课", name());
  }

  public void goToSchool() {
    LOGGER.info("{}赶往学校", name());
  }

  public void goHome() {
    LOGGER.info("{}回家", name());
  }

  public abstract String name();

  public void action(Event... events) {
    for (Event e : events) {
      action(e);
    }
  }

  private void action(Event e) {
    switch (e) {
      case EVENT_PREPARE: {
        prepareCourse();
        break;
      }
      case EVENT_PROCEED: {
        proceedCourse();
        break;
      }
      case EVENT_STOP: {
        stopCourse();
        break;
      }
      case EVENT_GO_HOME: {
        goHome();
        break;
      }
      case EVENT_GOTO_SCHOOL: {
        goToSchool();
        break;
      }
      default: {
        LOGGER.info("未知操作");
        break;
      }
    }
  }

  static enum Event {
    EVENT_GOTO_SCHOOL, EVENT_PREPARE, EVENT_PROCEED, EVENT_STOP, EVENT_GO_HOME;
  }
  }
  
  ```
  
  ![a](https://gpcoder.com/wp-content/uploads/2018/11/design-patterns-facade-diagram.png)
  
  ## _Nhận xét:_
  
  * Hàm abstract có các lớp con là student và teacher.
  * Có đầy đủ các cấu trúc giống như định dạng chuẩn.
   
********************************************************************************************************************************************************************************

#### *11. Flyweight:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Flyweight](https://github.com/JamesZBL/java_design_patterns/tree/master/flyweight) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4626-huong-dan-java-design-pattern-flyweight/) được minh họa bằng hình ảnh dưới đây:*


``` java
package me.zbl.flyweight;

import java.util.EnumMap;
import java.util.Map;

import static me.zbl.flyweight.GunType.*;

/**
 * 武器工厂
 */
public class GunFactory {

  private Map<GunType, Shooting> gunRepo;

  public GunFactory() {
    gunRepo = new EnumMap<GunType, Shooting>(GunType.class);
  }

  public Shooting createGun(GunType type) {
    Shooting gun = gunRepo.get(type);
    if (null == gun) {
      switch (type) {
        case HANDGUN: {
          gun = new HandGun();
          gunRepo.put(HANDGUN, gun);
          break;
        }
        case MUSKET: {
          gun = new Musket();
          gunRepo.put(MUSKET, gun);
          break;
        }
        case SNIPER: {
          gun = new Sniper();
          gunRepo.put(SNIPER, gun);
          break;
        }
        case SUBMACHINE: {
          gun = new Submachine();
          gunRepo.put(SUBMACHINE, gun);
          break;
        }
      }
    }
    return gun;
  }
}

```

![a](https://gpcoder.com/wp-content/uploads/2018/11/design-patterns-flyweight-diagram.png)

## _Nhận xét:_

* Code về các loại súng.
* Flyweight đã được cài đặt chính xác
* ConcreteFlyweight đã được cài đặt chính xác
* UnsharedFlyweight đã được cài đặt chính xác
* FlyweightFactory đã được cài đặt chính xác
* Client đã được cài đặt
 
********************************************************************************************************************************************************************************

#### *12. Proxy:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Proxy](https://github.com/JamesZBL/java_design_patterns/tree/master/proxy) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4644-huong-dan-java-design-pattern-proxy/) được minh họa bằng hình ảnh dưới đây:*

``` java

package me.zbl.proxy;

/**
 * 房间接口
 */
public interface Room {

  void enter(Customer customer);
}

```
![a](https://gpcoder.com/wp-content/uploads/2018/11/design-patterns-proxy-diagram.png)

## _Nhận xét:_

* Interface Room có hàm "void enter" giống như mẫu chuẩn thiết kế proxy.
* Giống cấu trúc gốc 100%.
 
********************************************************************************************************************************************************************************

### **Nhóm 3:**

********************************************************************************************************************************************************************************

#### *13. Interpreter:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Interpreter](https://github.com/JamesZBL/java_design_patterns/tree/master/interpreter) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4702-huong-dan-java-design-pattern-interpreter/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.interpreter;

/**
 * 减法表达式
 */
public class MinusExpression extends Expression {

  private Expression expressionLeft;
  private Expression expressionRight;

  public MinusExpression(Expression expressionLeft, Expression expressionRight) {
    this.expressionLeft = expressionLeft;
    this.expressionRight = expressionRight;
  }

  @Override
  public int interpret() throws Exception {
    return expressionLeft.interpret() - expressionRight.interpret();
  }

  @Override
  public String toString() {
    return "-";
  }
}

```

![a](https://gpcoder.com/wp-content/uploads/2018/12/design-patterns-interpreter-diagram.png)

## _Nhận xét:_

* Theo mẫu chuẩn, ta thấy được có lớp MinusEx đã kế thừa lớp Expression.
* Mẫu thiết kế giống 90%, thiếu mất cấu trúc context.

********************************************************************************************************************************************************************************

#### *14. Template Method:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Factory Method](https://github.com/JamesZBL/java_design_patterns/tree/master/template-method) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4810-huong-dan-java-design-pattern-template-method/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.template.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Template method
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    Student student = new Student(new PositiveLearningMethod());
    student.learn("上课走神", "同学");
    LOGGER.info("更换学习方法");
    student.changeMethod(new NegativeLearinngMethod());
    student.learn("认证听讲", "老师");
  }
}

```

![a](https://gpcoder.com/wp-content/uploads/2019/01/design-patterns-template-method-example.png)

## _Nhận xét:_
* Hàm tượng trưng client trong mẫu chuẩn.
* Có đầy đủ cấu trúc Abstract Class và 1 concrete  Class ngoài ra thêm 1 phương thức của Abstract class và 1 hàm nữa.
 
********************************************************************************************************************************************************************************

#### *15. Chain of Responsibility:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Chain of Responsibility](https://github.com/JamesZBL/java_design_patterns/tree/master/chain) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4665-huong-dan-java-design-pattern-chain-of-responsibility/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理者
 */
public abstract class RequestHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);
  private RequestHandler next;

  public RequestHandler(RequestHandler next) {
    this.next = next;
  }

  public void handleRequest(Request request) {
    if (null != next) {
      next.handleRequest(request);
    }
  }

  @Override
  public abstract String toString();

  protected void printHandleMessage(Request request) {
    LOGGER.info("{}处理消息中，消息内容为：{}", this, request);
  }
}

```
![a](https://gpcoder.com/wp-content/uploads/2018/12/design-patterns-chain-of-responsibility-diagram.png)

## _Nhận xét:_
* Hàm abstract giống như mẫu chuẩn.
* Mẫu thiết kế theo repo có cấu trúc giống 90% theo mẫu chuẩn, chỉ khác có thêm 2 lớp để khai báo.

********************************************************************************************************************************************************************************

#### *16. Command:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Command](https://github.com/JamesZBL/java_design_patterns/tree/master/command) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4686-huong-dan-java-design-pattern-command/) được minh họa bằng hình ảnh dưới đây:*


``` java
package me.zbl.command;

/**
 * 命令抽象类
 */
public abstract class Command {

  public abstract void execute();

  public abstract void undo();

  public abstract void redo();

  @Override
  public abstract String toString();
}
```
![a](https://gpcoder.com/wp-content/uploads/2018/12/design-patterns-command-diagram.png)


## _Nhận xét:_
* Hầm abstract có các hàm hỗ trợ cho lớp Command, giống như mẫu chuẩn.
* Mẫu thiết kế theo repo có đủ cấu trúc, đó là interface or abstract class, có implemention, có tiếp nhận request, tiếp nhật concrete và nơi nhận( giống 100%).
 
 
********************************************************************************************************************************************************************************

#### *17. Iterator:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Iterator](https://github.com/JamesZBL/java_design_patterns/tree/master/iterator) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4724-huong-dan-java-design-pattern-iterator/) được minh họa bằng hình ảnh dưới đây:*

```  java
public class Item {

  private ItemType type;
  private String name;

  public Item(ItemType type, String name) {
    this.type = type;
    this.name = name;
  }

  public final void setType(ItemType type) {
    this.type = type;
  }

  public ItemType getType() {
    return type;
  }

  @Override
  public String toString() {
    return name;
  }
}
```


![a](https://gpcoder.com/wp-content/uploads/2018/12/design-patterns-iterator-diagram.png)

## _Nhận xét:_
* Class Item gồm các item con bên trong, là lớp cha của các items đó.
* Mẫu thiết kế giống 100%
 
 
********************************************************************************************************************************************************************************

#### *18. Mediator:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Mediator](https://github.com/JamesZBL/java_design_patterns/tree/master/mediator) dùng để so sánh với [mẫu chuẩn](  https://gpcoder.com/4740-huong-dan-java-design-pattern-mediator/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 派对成员抽象类
 */
public abstract class AbstractPartyMember implements PartyMember {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPartyMember.class);

  private Party party;

  @Override
  public void joinParty(Party party) {
    LOGGER.info("{}加入了派对", this);
    this.party = party;
  }

  @Override
  public void act(Activity activity) {
    if (null != activity) {
      LOGGER.info("{}提议进行{}活动", this, activity);
      party.letAct(this, activity);
    }
  }

  @Override
  public void partyActivity(Activity activity) {
    LOGGER.info("进行派对活动，名称：{}，介绍：{}", activity, activity.getDescription());
  }

  @Override
  public abstract String toString();
}

```
![a](https://gpcoder.com/wp-content/uploads/2018/12/design-patterns-mediator-diagram.png)

## _Nhận xét:_

* Class abtract khai báo các biến và hàm con, giống lớp chuẩn.
* Có đầy đủ cấu trúc giống form chuẩn, và thêm 1 biến enum.
 
********************************************************************************************************************************************************************************

#### *19. Memento:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Memento](https://github.com/JamesZBL/java_design_patterns/tree/master/memento) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4763-huong-dan-java-design-pattern-memento/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.memento;

/**
 * 植物接口
 */
public interface Plant {

  int getWeight();

  int getHeight();

  FlowerType getType();
}

```
![a](https://gpcoder.com/wp-content/uploads/2018/12/design-patterns-memento-diagram.png)

## _Nhận xét:_
* Lớp interface Plant giống lớp Interface của mẫu chuẩn thiết kế.
* Mẫu thiết kế theo repo đầy đủ cấu trúc originator, caretaker và memento trong đó có thêm 1 loại biến enum.
 
********************************************************************************************************************************************************************************

#### *20. Observer:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Observer](https://github.com/JamesZBL/java_design_patterns/tree/master/observer) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4747-huong-dan-java-design-pattern-observer/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 南方人
 */
public class Southern implements TimeObserver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Southern.class);

  @Override
  public void update(TimePoint time) {

    LOGGER.info("南方人吃饭了");
    switch (time) {
      case MORNING:
        LOGGER.info("热干面");
        break;
      case NOON:
        LOGGER.info("米饭");
        break;
      case AFTERNOON:
        LOGGER.info("茶");
        break;
      case EVENING:
        LOGGER.info("鱼");
        break;
      default:
        break;
    }
  }
}

```
![a](https://gpcoder.com/wp-content/uploads/2018/12/design-patterns-observer-diagram.png)

## _Nhận xét:_
* Hàm Southern kế thừa TimeObserver như mẫu chuẩn.
* Có đầy đủ các  trúc như subject, observer, concreteSubject và concreteObserver, và thêm 1 biến enum.


#### *21. State:*
*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [State](https://github.com/JamesZBL/java_design_patterns/tree/master/state) dùng để so sánh với [mẫu chuẩn]( https://gpcoder.com/4785-huong-dan-java-design-pattern-state/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 清闲的状态
 */
public class IdleState implements State {

  private static final Logger LOGGER = LoggerFactory.getLogger(IdleState.class);

  private Coder coder;

  public IdleState(Coder coder) {
    this.coder = coder;
  }

  @Override
  public void onPreparing() {
    LOGGER.info("{}正努力使自己变得平静", coder);
  }

  @Override
  public void onEnterState() {
    LOGGER.info("{}正悠闲的听着歌", coder);
  }
}

```
![a](https://gpcoder.com/wp-content/uploads/2019/01/design-patterns-state-diagram.png)


## _Nhận xét:_
* Lớp con IdleState kế thừa lớp cha State theo cấu trúc mẫu chuẩn State.
* Có đầy đủ các cấu trúc context, state và concreteState và có thêm hàm main.
 

********************************************************************************************************************************************************************************
#### *22. Strategy:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Strategy](https://github.com/JamesZBL/java_design_patterns/tree/master/strategy) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4796-huong-dan-java-design-pattern-strategy/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.strategy;

/**
 * 商人
 */
public class BusinessMan {

  private TransportationStrategy strategy;

  public BusinessMan(TransportationStrategy strategy) {
    this.strategy = strategy;
  }

  public void changetStrategy(TransportationStrategy strategy) {
    this.strategy = strategy;
  }

  public void transport() {
    this.strategy.go();
  }
}
```
![a](https://gpcoder.com/wp-content/uploads/2019/01/design-patterns-strategy-example.png)


## _Nhận xét:_

* Mô hình BusinessMan đầy đủ các biến như trên.
* Có đầy đủ các cấu trúc như strategy, 2 concreteStrategy, context và 1 hàm main.
 
********************************************************************************************************************************************************************************
#### *23. Visitor:*

*Bên dưới là đoạn mã nguồn được sử dụng trong mẫu [Visitor](https://github.com/JamesZBL/java_design_patterns/tree/master/visitor) dùng để so sánh với [mẫu chuẩn](https://gpcoder.com/4813-huong-dan-java-design-pattern-visitor/) được minh họa bằng hình ảnh dưới đây:*

``` java
package me.zbl.visitor;

/**
 * 可访问的单元
 */
public abstract class Unit {

  private Unit[] children;

  public Unit(Unit... children) {
    this.children = children;
  }

  /**
   * 接受访问
   */
  public void beVisited(UnitVisitor visitor) {
    for (Unit childUnit : children) {
      childUnit.beVisited(visitor);
    }
  }
}
```
![a](https://gpcoder.com/wp-content/uploads/2019/01/design-patterns-visitor-diagram.png)

## _Nhận xét:_
* Nhìn vào dòng code cho thấy các desgin pattern đã được chuẩn bị giống 90%.
* Có đầy đủ các file trong cấu trúc như visitor, concreteVisitor, element và phương thức của elements, objectStructure và client, và 1 hàm để chạy.


********************************************************************************************************************************************************************************

# ***Kết luận: Repository chúng mình tìm được có điểm tương đồng tới 90% với 23 mẫu thiết kế chuẩn của ngôn ngữ java, các sự khác biệt đến từ các hàm khai báo con và các lớp cài đặt được thêm vào.***
********************************************************************************************************************************************************************************


### *Cảm ơn các bạn đã xem!*

********************************************************************************************************************************************************************************

