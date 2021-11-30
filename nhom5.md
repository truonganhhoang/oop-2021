Danh sách thành viên: Nguyễn Tuấn Nam, Đỗ Anh Tú, Lương Trung Kiên

Link repo sử dụng: https://github.com/square/retrofit + https://github.com/iluwatar/java-design-patterns

Dưới đây là báo cáo của nhóm mình về các mẫu Design Pattern

- # Creational pattern  

Nhóm khởi tạo – 5 mẫu gồm: Factory Method, Abstract Factory, Builder, Prototype, Singleton. Những Design pattern loại này cung cấp một giải pháp để tạo ra các object và che giấu được logic của việc tạo ra nó, thay vì tạo ra object một cách trực tiếp bằng cách sử dụng method new. Điều này giúp cho chương trình trở nên mềm dẻo hơn trong việc quyết định object nào cần được tạo ra trong những tình huống được đưa ra. 
  
  - ## [Prototype](https://github.com/iluwatar/java-design-patterns/tree/master/prototype)


Prototype pattern là một trong những Creational pattern. Nó có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new. Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.

Prototype Pattern được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại.

Trong Java cung cấp mẫu prototype pattern này bằng việc implement interface Cloneable và sử dụng method copy() để tạo object có đầy đủ thuộc tính của đối tượng ban đầu. 

Đầu tiên khởi tạo một interface với 1 method để clone đối tượng.

```Java
public interface Prototype {
  Object copy();
}
```

Code ở đây có nhiều lớp các sinh vật khác nhau, ví dụ như Beast và OrcBeast.

```Java
@EqualsAndHashCode
@NoArgsConstructor
public abstract class Beast implements Prototype {

  public Beast(Beast source) {
  }

  @Override
  public abstract Beast copy();
}

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class OrcBeast extends Beast {

  private final String weapon;

  public OrcBeast(OrcBeast orcBeast) {
    super(orcBeast);
    this.weapon = orcBeast.weapon;
  }

  @Override
  public OrcBeast copy() {
    return new OrcBeast(this);
  }

  @Override
  public String toString() {
    return "Orcish wolf attacks with " + weapon;
  }
}

```

Ta có thể tạo lớp HeroFactory và HeroFactoryImpl để sinh ra những sinh vật khác nhau từ prototypes.

```Java
public interface HeroFactory {
  
  Mage createMage();
  Warlord createWarlord();
  Beast createBeast();
}

@RequiredArgsConstructor
public class HeroFactoryImpl implements HeroFactory {

  private final Mage mage;
  private final Warlord warlord;
  private final Beast beast;

  public Mage createMage() {
    return mage.copy();
  }

  public Warlord createWarlord() {
    return warlord.copy();
  }

  public Beast createBeast() {
    return beast.copy();
  }
}
```
 - ## [Abstract Factory](https://github.com/iluwatar/java-design-patterns/tree/master/abstract-factory)


Abstract Factory pattern là một trong những Creational pattern. Nó là phương pháp tạo ra một Super-factory dùng để tạo ra các Factory khác. Hay còn được gọi là Factory của các Factory. Abstract Factory Pattern là một Pattern cấp cao hơn so với Factory Method Pattern.

>Ví dụ: Có rất nhiều kiểu vương quốc thì việc dùng Abstract Factory là hợp lý khi ta có thể lựa chọn các loại vương quốc khác nhau.

```Java
// tao trước thành phần của kiểu vương quốc Elf
public interface Castle {
  String getDescription();
}

public interface King {
  String getDescription();
}

public interface Army {
  String getDescription();
}

// Elven implementations ->
public class ElfCastle implements Castle {
  static final String DESCRIPTION = "This is the elven castle!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
public class ElfKing implements King {
  static final String DESCRIPTION = "This is the elven king!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
public class ElfArmy implements Army {
  static final String DESCRIPTION = "This is the elven Army!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}

// sau đó tạo interface kingdom rồi dùng ElfKingdomFactory implements KingdomFactory
public interface KingdomFactory {
  Castle createCastle();
  King createKing();
  Army createArmy();
}

public class ElfKingdomFactory implements KingdomFactory {

  @Override
  public Castle createCastle() {
    return new ElfCastle();
  }

  @Override
  public King createKing() {
    return new ElfKing();
  }

  @Override
  public Army createArmy() {
    return new ElfArmy();
  }
}
```
**Nhận xét**
  1. Giống với mẫu chuẩn.
  2. Tạo 1 vài interface Castle, King, Army rồi chia nhỏ ra từng lớp ứng với từng loại ví dụ với ElfKingdom thì có ElfCastle, ElfKing, ElfArmy thì ta được 1 loại của Object Kingdom

  - ## [Singleton](https://github.com/iluwatar/java-design-patterns/tree/master/singleton)

```Java
  abstract class SingletonTest<S> {
  
  private final Supplier<S> singletonInstanceMethod;

  public SingletonTest(final Supplier<S> singletonInstanceMethod) {
    this.singletonInstanceMethod = singletonInstanceMethod;
  }

  @Test
  void testMultipleCallsReturnTheSameObjectInSameThread() {
    // Create several instances in the same calling thread
    var instance1 = this.singletonInstanceMethod.get();
    var instance2 = this.singletonInstanceMethod.get();
    var instance3 = this.singletonInstanceMethod.get();
    // now check they are equal
    assertSame(instance1, instance2);
    assertSame(instance1, instance3);
    assertSame(instance2, instance3);
  }

  @Test
  void testMultipleCallsReturnTheSameObjectInDifferentThreads() throws Exception {
    assertTimeout(ofMillis(10000), () -> {
      // Create 10000 tasks and inside each callable instantiate the singleton class
      final var tasks = IntStream.range(0, 10000)
          .<Callable<S>>mapToObj(i -> this.singletonInstanceMethod::get)
          .collect(Collectors.toCollection(ArrayList::new));

      // Use up to 8 concurrent threads to handle the tasks
      final var executorService = Executors.newFixedThreadPool(8);
      final var results = executorService.invokeAll(tasks);

      // wait for all of the threads to complete
      final var expectedInstance = this.singletonInstanceMethod.get();
      for (var res : results) {
        final var instance = res.get();
        assertNotNull(instance);
        assertSame(expectedInstance, instance);
      }

      // tidy up the executor
      executorService.shutdown();
    });

  }
```
  
  Singleton pattern (thuộc Creational) đảm bảo chỉ duy nhất môt new instance được tạo ra cho 1 lớp và nó sẽ cung cấp cho bạn một method để truy cập đến đối tượng duy nhất đó. Dù cho việc thực hiện cài đặt Singleton bằng cách nào đi nữa cũng đều dựa vào nguyên tắc dưới đây.
-  private constructor để hạn chế khởi tạo đối tượng từ bên ngoài
- đặt private static variable cho đối tượng được khởi tạo, đảm bảo biến chỉ được khởi tạo trong chính lớp này.
- có một method public để return instance đã được khởi tạo ở trên.




- ## [Builder](https://github.com/square/retrofit/blob/master/retrofit-mock/src/main/java/retrofit2/mock/MockRetrofit.java) 

```Java
  public static final class Builder {
    private final Retrofit retrofit;
    private @Nullable NetworkBehavior behavior;
    private @Nullable ExecutorService executor;

    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public Builder(Retrofit retrofit) {
      if (retrofit == null) throw new NullPointerException("retrofit == null");
      this.retrofit = retrofit;
    }

    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public Builder networkBehavior(NetworkBehavior behavior) {
      if (behavior == null) throw new NullPointerException("behavior == null");
      this.behavior = behavior;
      return this;
    }

    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public Builder backgroundExecutor(ExecutorService executor) {
      if (executor == null) throw new NullPointerException("executor == null");
      this.executor = executor;
      return this;
    }

    public MockRetrofit build() {
      if (behavior == null) behavior = NetworkBehavior.create();
      if (executor == null) executor = Executors.newCachedThreadPool();
      return new MockRetrofit(retrofit, behavior, executor);
    } 
```

Builder pattern là một trong những Creational pattern. Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với các đối tượng khác.

Builder Pattern được xây dựng để khắc phục một số nhược điểm của Factory Pattern và Abstract Factory Pattern khi mà Object có nhiều thuộc tính.

Có ba vấn đề chính với  Factory Pattern và Abstract Factory Pattern khi Object có nhiều thuộc tính:

- Quá nhiều tham số phải truyền vào từ phía client tới Factory Class.
- Một số tham số có thể là tùy chọn nhưng trong Factory Pattern, chúng ta phải gửi tất cả tham số, với tham số tùy chọn nếu không nhập gì thì sẽ truyền là null.
- Nếu một Object có quá nhiều thuộc tính thì việc tạo sẽ phức tạp.

**Giống nhau**: 
- Giống với mẫu chuẩn.
- Build từ Retrofit, NetworkBehavior và ExecutorService


**Khác biệt**:
- Không có.

- # Structural pattern

Structural Pattern (nhóm cấu trúc – 7 mẫu) gồm: Adapter, Bridge, Composite, Decorator, Facade, Flyweight và Proxy. Những Design pattern loại này liên quan tới class và các thành phần của object. Nó dùng để thiết lập, định nghĩa quan hệ giữa các đối tượng.

- ## [Bridge](https://github.com/iluwatar/java-design-patterns/tree/master/bridge)

Bridge Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Ý tưởng của nó là tách tính trừu tượng (abstraction) ra khỏi tính hiện thực (implementation) của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu.

Điều đó có nghĩa là, ban đầu chúng ta thiết kế một class với rất nhiều xử lý, bây giờ chúng ta không muốn để những xử lý đó trong class đó nữa. Vì thế, chúng ta sẽ tạo ra một class khác và move các xử lý đó qua class mới. Khi đó, trong lớp cũ sẽ giữ một đối tượng thuộc về lớp mới, và đối tượng này sẽ chịu trách nhiệm xử lý thay cho lớp ban đầu.

Bridge Pattern khá giống với mẫu Adapter Pattern ở chỗ là sẽ nhờ vào một lớp khác để thực hiện một số xử lý nào đó. Tuy nhiên, ý nghĩa và mục đích sử dụng của hai mẫu thiết kế này hoàn toàn khác nhau:

- **Adapter Pattern** hay còn gọi là Wrapper pattern được dùng để biến đổi một class/ interface sang một dạng khác có thể sử dụng được. Adapter Pattern giúp các lớp không tương thích hoạt động cùng nhau mà bình thường là không thể.
- **Bridge Pattern** được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (implementation) riêng biệt.
- **Adapter Pattern** làm cho mọi thứ có thể hoạt động với nhau sau khi chúng đã được thiết kế (đã tồn tại). Bridge Pattern nên được thiết kế trước khi phát triển hệ thống để Abstraction và Implementation có thể thực hiện một cách độc lập.

Ví dụ: Interface Weapon trừu tượng riêng biệt và có class Sword, Hammer cài đặt riêng biệt.

```Java
public interface Weapon {
  void wield();
  void swing();
  void unwield();
  Enchantment getEnchantment();
}

public class Sword implements Weapon {

  private final Enchantment enchantment;

  public Sword(Enchantment enchantment) {
    this.enchantment = enchantment;
  }

  @Override
  public void wield() {
    LOGGER.info("The sword is wielded.");
    enchantment.onActivate();
  }

  @Override
  public void swing() {
    LOGGER.info("The sword is swinged.");
    enchantment.apply();
  }

  @Override
  public void unwield() {
    LOGGER.info("The sword is unwielded.");
    enchantment.onDeactivate();
  }

  @Override
  public Enchantment getEnchantment() {
    return enchantment;
  }
}

public class Hammer implements Weapon {

  private final Enchantment enchantment;

  public Hammer(Enchantment enchantment) {
    this.enchantment = enchantment;
  }

  @Override
  public void wield() {
    LOGGER.info("The hammer is wielded.");
    enchantment.onActivate();
  }

  @Override
  public void swing() {
    LOGGER.info("The hammer is swinged.");
    enchantment.apply();
  }

  @Override
  public void unwield() {
    LOGGER.info("The hammer is unwielded.");
    enchantment.onDeactivate();
  }

  @Override
  public Enchantment getEnchantment() {
    return enchantment;
  }
}
```

- ## [Flyweight](https://github.com/iluwatar/java-design-patterns/tree/master/flyweight)

Flyweight Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Nó cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng hoặc tạo đối tượng mới khi không tìm thấy đối tượng phù hợp.

>Ví dụ: Một cửa hàng phép thuật bán rất nhiều thuốc, trong đó thay vì chúng ta tạo hàng loạt các Object mới cho từng loại thuốc thì ta có thể dùng 1 Object đại diện và dùng được cho tất cả các loại thuốc từ đó có thể giảm thiểu được dung lượng.

Đầu tiên ta tạo rất nhiều loại thuốc

```Java
public interface Potion {
  void drink();
}

@Slf4j
public class HealingPotion implements Potion {
  @Override
  public void drink() {
    LOGGER.info("You feel healed. (Potion={})", System.identityHashCode(this));
  }
}

@Slf4j
public class HolyWaterPotion implements Potion {
  @Override
  public void drink() {
    LOGGER.info("You feel blessed. (Potion={})", System.identityHashCode(this));
  }
}

@Slf4j
public class InvisibilityPotion implements Potion {
  @Override
  public void drink() {
    LOGGER.info("You become invisible. (Potion={})", System.identityHashCode(this));
  }
}
```
Thay vì phải tạo từng loại thuốc thì với class PotionFactory thì ta đã có thể rút ngắn được việc tạo 1 Object mới
```Java
public class PotionFactory {

  private final Map<PotionType, Potion> potions;

  public PotionFactory() {
    potions = new EnumMap<>(PotionType.class);
  }

  Potion createPotion(PotionType type) {
    var potion = potions.get(type);
    if (potion == null) {
      switch (type) {
        case HEALING:
          potion = new HealingPotion();
          potions.put(type, potion);
          break;
        case HOLY_WATER:
          potion = new HolyWaterPotion();
          potions.put(type, potion);
          break;
        case INVISIBILITY:
          potion = new InvisibilityPotion();
          potions.put(type, potion);
          break;
        default:
          break;
      }
    }
    return potion;
  }
}

```
**Lợi ích**
- Giảm số lượng đối tượng được tạo ra bằng cách chia sẻ đối tượng. Vì vậy, tiết kiệm bộ nhớ và các thiết bị lưu trữ cần thiết.
- Cãi thiện khả năng cache dữ liệu vì thời gian đáp ứng nhanh.
- Tăng performance.


- ## [Composite](https://github.com/iluwatar/java-design-patterns/tree/master/composite)
```Java
  package com.iluwatar.composite;

import java.util.List;

/**
 * Word.
 */
public class Word extends LetterComposite {

  /**
   * Constructor.
   */
  public Word(List<Letter> letters) {
    letters.forEach(this::add);
  }

  /**
   * Constructor.
   * @param letters to include
   */
  public Word(char... letters) {
    for (char letter : letters) {
      this.add(new Letter(letter));
    }
  }

  @Override
  protected void printThisBefore() {
    System.out.print(" ");
  }
}
```

Composite pattern (thuộc Structural) cho phép tương tác với tất cả các đối tượng tương tự nhau giống như là các đối tượng đơn hoặc collections. Ví dụ: Đối tượng File sẽ là 1 đối tượng đơn nếu bên trong nó không có file nào khác, nhưng đối tượng file (folder) sẽ được đối xử giống như 1 collections nếu bên trong nó lại có những File khác.


- # Behavioral pattern

Behavioral Pattern (nhóm tương tác/ hành vi – 11 mẫu) gồm: Interpreter, Template Method, Chain of Responsibility, Command, Iterator, Mediator, Memento, Observer, State, Strategy và Visitor. Nhóm này dùng trong thực hiện các hành vi của đối tượng, sự giao tiếp giữa các object với nhau.

 - ## [Memento](https://github.com/iluwatar/java-design-patterns/tree/master/memento)

Memento là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Memento là mẫu thiết kế có thể lưu lại trạng thái của một đối tượng để khôi phục lại sau này mà không vi phạm nguyên tắc đóng gói.

Dữ liệu trạng thái đã lưu trong đối tượng memento không thể truy cập bên ngoài đối tượng được lưu và khôi phục. Điều này bảo vệ tính toàn vẹn của dữ liệu trạng thái đã lưu.

Hoàn tác (Undo) hoặc ctrl + z là một trong những thao tác được sử dụng nhiều nhất trong trình soạn thảo văn bản (editor). Mẫu thiết kế Memento được sử dụng để thực hiện thao tác Undo. Điều này được thực hiện bằng cách lưu trạng thái hiện tại của đối tượng mỗi khi nó thay đổi trạng thái, từ đó chúng ta có thể khôi phục nó trong mọi trường hợp có lỗi.

>Ví dụ thực tế: Ta cần phải tạo ra một ứng dụng thiên văn học để phân tích thuộc tính của các ngôi sao theo thời gian. Chúng ta sẽ sử dụng Memento pattern để tạo ra những trạng thái nhớ của các ngôi sao.

Ban đầu ta định nghĩa các loại ngôi sao cần xử lý.

```Java
public enum StarType {
  SUN("sun"),
  RED_GIANT("red giant"),
  WHITE_DWARF("white dwarf"),
  SUPERNOVA("supernova"),
  DEAD("dead star");
  ...
}

```

Tiếp theo ta có lớp Star để giải quyết với những trạng thái (các memento) mà chúng ta cần làm việc cùng.

```Java
public interface StarMemento {
}

public class Star {

  private StarType type;
  private int ageYears;
  private int massTons;

  public Star(StarType startType, int startAge, int startMass) {
    this.type = startType;
    this.ageYears = startAge;
    this.massTons = startMass;
  }

  public void timePasses() {
    ageYears *= 2;
    massTons *= 8;
    switch (type) {
      case RED_GIANT:
        type = StarType.WHITE_DWARF;
        break;
      case SUN:
        type = StarType.RED_GIANT;
        break;
      case SUPERNOVA:
        type = StarType.DEAD;
        break;
      case WHITE_DWARF:
        type = StarType.SUPERNOVA;
        break;
      case DEAD:
        ageYears *= 2;
        massTons = 0;
        break;
      default:
        break;
    }
  }

  StarMemento getMemento() {
    var state = new StarMementoInternal();
    state.setAgeYears(ageYears);
    state.setMassTons(massTons);
    state.setType(type);
    return state;
  }

  void setMemento(StarMemento memento) {
    var state = (StarMementoInternal) memento;
    this.type = state.getType();
    this.ageYears = state.getAgeYears();
    this.massTons = state.getMassTons();
  }

  @Override
  public String toString() {
    return String.format("%s age: %d years mass: %d tons", type.toString(), ageYears, massTons);
  }

  private static class StarMementoInternal implements StarMemento {

    private StarType type;
    private int ageYears;
    private int massTons;

    // setters and getters ->
    ...
  }
}

```

Và đây là cách ta sử dụng các memento để lưu và trả lại trạng thái cho các ngôi sao:

```Java
    var states = new Stack<>();
    var star = new Star(StarType.SUN, 10000000, 500000);
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    while (states.size() > 0) {
      star.setMemento(states.pop());
      LOGGER.info(star.toString());
    }

```

- ## [Strategy](https://github.com/iluwatar/java-design-patterns/tree/master/strategy)

Strategy Pattern là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Nó cho phép định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và dễ dàng thay đổi linh hoạt các thuật toán bên trong object. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng.

Ý nghĩa thực sự của Strategy Pattern là giúp tách rời phần xử lý một chức năng cụ thể ra khỏi đối tượng. Sau đó tạo ra một tập hợp các thuật toán để xử lý chức năng đó và lựa chọn thuật toán nào mà chúng ta thấy đúng đắn nhất khi thực thi chương trình. Mẫu thiết kế này thường được sử dụng để thay thế cho sự kế thừa, khi muốn chấm dứt việc theo dõi và chỉnh sửa một chức năng qua nhiều lớp con.

>Ví dụ: Những người diệt rồng đã phát triển ra những chiến thuật tranh đấu khác nhau cho từng loại rồng.

Đầu tiên chúng ta có interface chứa chiến lược diệt rồng và cách cài đặt của nó:

```Java
@FunctionalInterface
public interface DragonSlayingStrategy {

  void execute();
}

@Slf4j
public class MeleeStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    LOGGER.info("With your Excalibur you sever the dragon's head!");
  }
}

@Slf4j
public class ProjectileStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    LOGGER.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!");
  }
}

@Slf4j
public class SpellStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    LOGGER.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!");
  }
}

```

Và người diệt rồng sẽ chọn chiến lược phù hợp với đối thủ của mình.

```Java
public class DragonSlayer {

  private DragonSlayingStrategy strategy;

  public DragonSlayer(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void changeStrategy(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void goToBattle() {
    strategy.execute();
  }
}

```


- ## [Data transfer object](https://github.com/iluwatar/java-design-patterns/tree/master/data-transfer-object)

Transfer Object/ Data Transfer Object Pattern là một dạng Architectural Design Pattern, được sử dụng khi chúng ta muốn truyền dữ liệu qua lại giữa các tầng trong ứng dụng, giữa Client – Server. Data Transfer Object (DTO) còn được gọi là Value Object (VO).

Transfer Object đơn giản là một POJO (Plain Old Java Object), chỉ chứa các getter/ setter method và có thể có implement serialize để truyền tải dữ liệu thông qua network.

DTO hoàn toàn không chứa behavior/ logic, chỉ được sử dụng để truyền dữ liệu và map dữ liệu từ các Domain Model trước khi truyền tới Client. Trong các ứng dụng đơn giản, các Domain Model thường có thể được sử dụng lại trực tiếp dưới dạng DTO và được truyền trực tiếp đến lớp hiển thị, do đó chỉ có một Data Model thống nhất. Đối với các ứng dụng phức tạp hơn, chúng ta không muốn hiển thị toàn bộ Domain Model cho Client, do đó, việc ánh xạ từ các Domain Model sang DTO là cần thiết.

>Ví dụ: Ta cần phải thu thập thông tin của khách hàng từ một remote database. Thay vì truy vấn từng thuộc tính, ta có thể sử dụng data transfer object để chuyển tất cả những thuộc tính liên quan trong một lần duy nhất.

Đầu tiên chúng ta có lớp CustomerDTO:

```Java
public class CustomerDto {
  private final String id;
  private final String firstName;
  private final String lastName;

  public CustomerDto(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}

```

CustomerResource sẽ là server cho thông tin khách hàng.

```Java
public class CustomerResource {
  private final List<CustomerDto> customers;

  public CustomerResource(List<CustomerDto> customers) {
    this.customers = customers;
  }

  public List<CustomerDto> getAllCustomers() {
    return customers;
  }

  public void save(CustomerDto customer) {
    customers.add(customer);
  }

  public void delete(String customerId) {
    customers.removeIf(customer -> customer.getId().equals(customerId));
  }
}

```

Giờ việc thu thập thông tin của khách hàng trở nên dễ dàng hơn nhiều khi chúng ta có data transfer object.

```Java
    var allCustomers = customerResource.getAllCustomers();
    allCustomers.forEach(customer -> LOGGER.info(customer.getFirstName()));
    // Kelly
    // Alfonso

```

- ## [Iterator](https://github.com/iluwatar/java-design-patterns/tree/master/iterator)

Iterator Pattern là một trong những Pattern thuộc nhóm hành vi (Behavior Pattern). Nó được sử dụng để “Cung cấp một cách thức truy cập tuần tự tới các phần tử của một đối tượng tổng hợp, mà không cần phải tạo dựng riêng các phương pháp truy cập cho đối tượng tổng hợp này”.

>Ví dụ: Rương kho báu có rất nhiều vật phẩm như nhẫn(rings), thuốc(potions) và vũ khí(weapons), ta có thể truy cập tuần tự bằng cách sử dụng Iterator pattern

Đầu tiên ta tạo 1 rương có nhiều vật phẩm
```Java
public class TreasureChest {

  private final List<Item> items;

  public TreasureChest() {
    items = List.of(
        new Item(ItemType.POTION, "Potion of courage"),
        new Item(ItemType.RING, "Ring of shadows"),
        new Item(ItemType.POTION, "Potion of wisdom"),
        new Item(ItemType.POTION, "Potion of blood"),
        new Item(ItemType.WEAPON, "Sword of silver +1"),
        new Item(ItemType.POTION, "Potion of rust"),
        new Item(ItemType.POTION, "Potion of healing"),
        new Item(ItemType.RING, "Ring of armor"),
        new Item(ItemType.WEAPON, "Steel halberd"),
        new Item(ItemType.WEAPON, "Dagger of poison"));
  }

  public Iterator<Item> iterator(ItemType itemType) {
    return new TreasureChestItemIterator(this, itemType);
  }

  public List<Item> getItems() {
    return new ArrayList<>(items);
  }
}

```
Sau đó ta định nghĩa lại Item 
```Java
public class Item {

  private ItemType type;
  private final String name;

  public Item(ItemType type, String name) {
    this.setType(type);
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public ItemType getType() {
    return type;
  }

  public final void setType(ItemType type) {
    this.type = type;
  }
}

public enum ItemType {

  ANY, WEAPON, RING, POTION

}
```
Sau đó ta chỉ việc tuần tự tìm vật phẩm trong rương.
```Java
public interface Iterator<T> {

  boolean hasNext();

  T next();
}

var itemIterator = TREASURE_CHEST.iterator(ItemType.RING);
while (itemIterator.hasNext()) {
  LOGGER.info(itemIterator.next().toString());
}

```

**Một số lợi ích khi sử dụng Iterator Pattern:**
- Đảm bảo nguyên tắc Single responsibility principle (SRP) : chúng ta có thể tách phần cài đặt các phương thức của tập hợp và phần duyệt qua các phần tử (iterator) theo từng class riêng lẻ.
- Chúng ta có thể truy cập song song trên cùng một tập hợp vì mỗi đối tượng iterator có chứa trạng thái riêng của nó.
  

  
  
