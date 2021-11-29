## ***Nhóm gồm các thành viên:***

# **Nguyễn Anh Đức 20021336**

# **Nguyễn Thị Thúy Quỳnh 20021426**

# **Đặng Thành Trung 20021455**


## *Các repo đã tìm được và phân tích:*

### Repo 1: Link https://github.com/shuleisanshi/myblog

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

### Repo 4: Link https://github.com/Anuken/Mindustry

Sử dụng mẫu thiết kế:

Strategy với:

Interface: SlotAssignmentStrategy, Các ConcreteStategy: BoundedSlotAssignmentStrategy, DistanceAssignmentStrategy, FreeSlotAssignmentStrategy

BoundedSlotAssignmentStrategy có concrete: SoftRoleSlotAssignmentStrategy

Factory Method:

Creator: FormationPattern

Concretecreator: CircleFormation, SquareFormation

Abstract Factory:

UnitController->AIController

AIController->BuilderAI, DefenderAI, FlyingAI, FormationAI, GroundAI, HugAI, LogicAI, MinerAI, RepairAI

Facade:

facade: ContentList

subsystems: Blocks, Bullets, Items, Liquids, Loadouts, PLanets, SectorPresets, StatusEffects, TechTree, UnitTypes, Weathers

-> dễ dàng quản lý, điều hướng
