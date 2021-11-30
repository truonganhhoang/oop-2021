# Báo cáo về 23 mẫu thiết kế

***Nhóm em gồm các thành viên:***

*Nguyễn Anh Đức 20021336*

*Nguyễn Thị Thúy Quỳnh 20021426*

*Đặng Thành Trung 20021455*

Trong quá trình tìm kiếm, phân tích, nhóm em đã tìm được một số repo mã nguồn trên github có 23 mẫu thiết kế như sau.

## Tóm tắt:
*Nhóm em đã tìm được và phân tích 4 repo:
	 1. https://github.com/shuleisanshi/myblog
	 2. https://github.com/simple-android-framework/android_design_patterns_analysis
	 3. https://github.com/braisdom/ObjectiveSql
	 4. https://github.com/Anuken/Mindustry*

### Repo 1: Link https://github.com/shuleisanshi/myblog

Repo này là mã nguồn của 1 blog cá nhân của tác giả. Tại đây, nhóm đã

Mẫu thiết kế: Factory trong package service, mục đích tạo các lớp kế thừa các giao diện (ở đây đặc biệt ở chỗ: với mỗi giao diện chỉ có 1 lớp kế thừa)

Ví dụ:
* Giao diện MenuService:
```java
public interface MenuService {
    List<Menu> listMenu() ;

    Menu insertMenu(Menu menu) ;

    void deleteMenu(Integer id) ;

    void updateMenu(Menu menu) ;

    Menu getMenuById(Integer id) ;
}
```
* Lớp MenuServiceImpl:
```java
public class MenuServiceImpl implements MenuService {

    @Autowired(required = false)
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listMenu() {
        List<Menu> menuList = menuMapper.listMenu();
        return menuList;
    }

    @Override
    public Menu insertMenu(Menu menu) {
        menuMapper.insert(menu);
        return menu;
    }

    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteById(id);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.update(menu);
    }

    @Override
    public Menu getMenuById(Integer id) {
        return menuMapper.getMenuById(id);
    }
}
```

### Repo 2: Link https://github.com/simple-android-framework/android_design_patterns_analysis

Tóm tắt về đầy đủ 23 mẫu thiết kế

Có code minh họa theo 2 mẫu thiết kế:

#### * Command:

* Giao diện Command
```java
public interface Command {
	public void execute();
	public void undo();
	public void redo();
	
}
```
* Lớp ConcreteCommandImpl1
```java
public class ConcreteCommandImpl1 implements Command{
    	private ReceiverRole receiverRole1;
    
    	public ConcreteCommandImpl1(ReceiverRole receiverRole1) {
    		this.receiverRole1 = receiverRole1;
    	}
    	
    	@Override
    	public void execute() {
    		receiverRole1.opActionUpdateAge(1001);
    	}
    
    	@Override
    	public void undo() {
    		receiverRole1.rollBackAge();
    	}
    
    	@Override
    	public void redo() {
    	}
    }
```
* Lớp ReceiverRole
```java
public class ReceiverRole {
    	private PeopleBean people; 
    	private PeopleBean peopleCache = new PeopleBean();     	
      
      public ReceiverRole() {
    	this.people = new PeopleBean(-1, "NULL");
      }
    	
      public ReceiverRole(PeopleBean people) {
    	this.people = people;
      }
	
      public void opActionUpdateAge(int age) {
        System.out.println("执行命令前："+people.toString());
        this.people.update(age);
        System.out.println("执行命令后："+people.toString()+"\n");
      }

      public void opActionUpdateName(String name) {
        System.out.println("执行命令前："+people.toString());
        this.people.update(name);
        System.out.println("执行命令后："+people.toString()+"\n");
      }

      public void rollBackAge() {
        people.setAge(peopleCache.getAge());
        System.out.println("命令回滚后："+people.toString()+"\n");
      }
      public void rollBackName() {
        people.setName(peopleCache.getName());
        System.out.println("命令回滚后："+people.toString()+"\n");
      }
}
```
* Lớp ClientRole
```java
public class ClientRole {
    public void assembleAction() {
    		ReceiverRole receiverRole1 = new ReceiverRole();
    		Command command1 = new ConcreteCommandImpl1(receiverRole1);           		    
        Command command2 = new ConcreteCommandImpl2(receiverRole1);
    
    		InvokerRole invokerRole = new InvokerRole();
    		invokerRole.setCommand1(command1);
    		invokerRole.setCommand2(command2);
    		invokerRole.invoke(0);			
    		invokerRole.invoke(1);				
    }
}
```
* Lớp Invoker
```java
public class InvokerRole {
    private Command command1;
    private Command command2;
    	
    public void setCommand1(Command command1) {
    		this.command1 = command1;
    }
    public void setCommand2(Command command2) {
    		this.command2 = command2;
    }
    	
    public void invoke(int args) {
    		if(args == 0){
    			command1.execute();
    			command2.execute();
    		} else if(args == 1){
    			command1.undo();
    			command2.undo();
    		}
    }   	
}
```

#### Iterator:
```java
private class ArrayListIterator implements Iterator<E> {
    /** Number of elements remaining in this iteration */
    private int remaining = size;

    /** Index of element that remove() would remove, or -1 if no such elt */
    private int removalIndex = -1;

    /** The expected modCount value */
    private int expectedModCount = modCount;

    public boolean hasNext() {
        return remaining != 0;
    }

    @SuppressWarnings("unchecked") public E next() {
        ArrayList<E> ourList = ArrayList.this;
        int rem = remaining;
        if (ourList.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        if (rem == 0) {
            throw new NoSuchElementException();
        }
        remaining = rem - 1;
        return (E) ourList.array[removalIndex = ourList.size - rem];
    }

    public void remove() {
        Object[] a = array;
        int removalIdx = removalIndex;
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        if (removalIdx < 0) {
            throw new IllegalStateException();
        }
        System.arraycopy(a, removalIdx + 1, a, removalIdx, remaining);
        a[--size] = null;  // Prevent memory leak
        removalIndex = -1;
        expectedModCount = ++modCount;
    }
}
```

### Repo 3: Link https://github.com/braisdom/ObjectiveSql

Dựa vào mẫu thiết kế Active record khuyến khích phát triển nhanh chóng và làm sạch, mã có ít nhất và quy ước về cấu hình.

Interface ORMFramework trong package benchmark.
```java
public interface ORMFramework {

    void initialize() throws Exception;

    void update() throws Exception;

    User query() throws Exception;

    void teardown();

    class Factory {

        public static ORMFramework createORMFramework(String frameworkName, HikariDataSource dataSource) {
            switch (frameworkName) {
                case MyBatis.FRAMEWORK_NAME:
                    return new MyBatis(dataSource);
                case Jdbc.FRAMEWORK_NAME:
                    return new Jdbc(dataSource);
                case ObjectiveSQL.FRAMEWORK_NAME:
                    return new ObjectiveSQL(dataSource);
                case Hibernate.FRAMEWORK_NAME:
                    return new Hibernate(dataSource);
                default:
                    throw new IllegalArgumentException("Cannot find ORM framework: " + frameworkName);
            }
        }
    }
}
```

Lớp User trong package benchmark.
```java
public class User implements Serializable {

    @Id
    @PrimaryKey
    private Integer id;
    private String name;
    private int age;

    @Transient
    @javax.persistence.Transient
    private Map<String, Object> rawAttributes = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Object> getRawAttributes() {
        return rawAttributes;
    }
}
```
Lớp ObjectiveSQL trong package benchmark.
```java
public class ObjectiveSQL implements ORMFramework, ConnectionFactory, Logger, LoggerFactory {

    public static final String FRAMEWORK_NAME = "objsql";

    private final HikariDataSource dataSource;

    public ObjectiveSQL(HikariDataSource dataSource) {
        this.dataSource = dataSource;

        Databases.installConnectionFactory(this);
        Databases.installLoggerFactory(this);
    }

    @Override
    public void initialize() throws Exception {
        Databases.execute("insert into user(id, name, age) values(1, 'ash', 25)");
    }

    @Override
    public void update() throws Exception {
        User.update("age = 12", "id = ?", 1);
    }

    @Override
    public User query() throws Exception {
        return User.queryByPrimaryKey(1);
    }

    @Override
    public void teardown() {
        dataSource.close();
    }

    @Override
    public Connection getConnection(String dataSourceName) throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void debug(long elapsedTime, String sql, Object[] params) {
        // Do nothing
    }

    @Override
    public void info(long elapsedTime, String sql, Object[] params) {
        // Do nothing
    }

    @Override
    public void error(String message, Throwable throwable) {
        // Do nothing
    }

    @Override
    public Logger create(Class<?> clazz) {
        return new ObjectiveSQL(dataSource);
    }
}
```

Lớp Hibernate trong package benchmark.
```java
public class Hibernate implements ORMFramework {

    public static final String FRAMEWORK_NAME = "hibernate";

    private final HikariDataSource dataSource;
    private final SessionFactory sessionFactory;

    public Hibernate(HikariDataSource dataSource) {
        this.dataSource = dataSource;
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    @Override
    public void initialize() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setId(1);
        user.setName("ash");
        user.setAge(25);
        session.save( user );
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setId(1);
        user.setName("ash");
        user.setAge(15);
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User query() throws Exception {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from com.github.braisdom.objsql.benchmark.User " +
                "user where user.id = 1");
        User user = query.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public void teardown() {
        dataSource.close();
        sessionFactory.close();
    }
}
```

### Repo 4: Link https://github.com/Anuken/Mindustry

Sử dụng mẫu thiết kế:

Strategy với:

Interface: SlotAssignmentStrategy

```java
public interface SlotAssignmentStrategy{

    /** Updates the assignment of members to slots */
    void updateSlotAssignments(Seq<SlotAssignment> assignments);

    /** Calculates the number of slots from the assignment data. */
    int calculateNumberOfSlots(Seq<SlotAssignment> assignments);

    /** Removes the slot assignment at the specified index. */
    void removeSlotAssignment(Seq<SlotAssignment> assignments, int index);

}
```
Các ConcreteStategy: BoundedSlotAssignmentStrategy, DistanceAssignmentStrategy, FreeSlotAssignmentStrategy

```java
public abstract class BoundedSlotAssignmentStrategy implements SlotAssignmentStrategy{

    @Override
    public abstract void updateSlotAssignments(Seq<SlotAssignment> assignments);

    @Override
    public int calculateNumberOfSlots(Seq<SlotAssignment> assignments){
        //code
    }

    @Override
    public void removeSlotAssignment(Seq<SlotAssignment> assignments, int index){
        //code
    }
}
public class DistanceAssignmentStrategy implements SlotAssignmentStrategy{
    private final Vec3 vec = new Vec3();
    private final FormationPattern form;

    public DistanceAssignmentStrategy(FormationPattern form){
        this.form = form;
    }
}
public class FreeSlotAssignmentStrategy implements SlotAssignmentStrategy{

    @Override
    public void updateSlotAssignments(Seq<SlotAssignment> assignments){
        // A very simple assignment algorithm: we simply go through
        // each assignment in the list and assign sequential slot numbers
        for(int i = 0; i < assignments.size; i++){
            assignments.get(i).slotNumber = i;
        }
    }

    @Override
    public int calculateNumberOfSlots(Seq<SlotAssignment> assignments){
        return assignments.size;
    }

    @Override
    public void removeSlotAssignment(Seq<SlotAssignment> assignments, int index){
        assignments.remove(index);
    }

}
```
BoundedSlotAssignmentStrategy có concrete: SoftRoleSlotAssignmentStrategy

```java
public class SoftRoleSlotAssignmentStrategy extends BoundedSlotAssignmentStrategy{
    //code
}
```
Factory Method:

Creator: FormationPattern

Concretecreator: CircleFormation, SquareFormation

Abstract Factory:

UnitController->AIController
Mindustry/core/src/mindustry/entities/units/UnitController.java

```java
public interface UnitController{
}
```
Mindustry/core/src/mindustry/ai/types
AIController->BuilderAI, DefenderAI, FlyingAI, FormationAI, GroundAI, HugAI, LogicAI, MinerAI, RepairAI

Facade:

facade: ContentList
Mindustry/core/src/mindustry/ctype/ContentList.jav

```java
public interface ContentList{
    /** This method should create all the content. */
    void load();
}
```
subsystems: Blocks, Bullets, Items, Liquids, Loadouts, PLanets, SectorPresets, StatusEffects, TechTree, UnitTypes, Weathers
Mindustry/core/src/mindustry/content

```java
public class Blocks implements ContentList{
    public static Block...
}
public class Bullets implements ContentList{
    public static BulletType...
}
public class Items implements ContentList{
    public static Item
    scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
    phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass;
}
public class Loadouts implements ContentList{
    public static Schematic
    basicShard,
    basicFoundation,
    basicNucleus;

    @Override
    public void load(){
        basicShard = Schematics.readBase64...
    }
}
public class TechTree implements ContentList{
    static ObjectMap<UnlockableContent, TechNode> map = new ObjectMap<>();
    static TechNode context = null;

    public static Seq<TechNode> all;
    public static TechNode root;
    //code
}
public class Weathers implements ContentList{
    public static Weather
    rain,
    snow,
    sandstorm,
    sporestorm,
    fog,
    suspendParticles;

    @Override
    public void load(){
        snow = ...
        rain = ...
        sandstorm = ...
        sporestorm = ...
        fog = ...
        suspendParticles = ...
    }
}
```   
-> dễ dàng quản lý, điều hướng
