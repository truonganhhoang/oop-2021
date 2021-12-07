#### Lê Hữu Đức - 19020525
# So sánh với mẫu chuẩn (12 mẫu đầu tiên)
**Giống nhau:**

- Đa số có kết cấu giống với mẫu chuẩn như cách sử dụng interface, abstract class, chức năng từng lớp.
- Đa số các lớp chỉ chịu trách nhiệm về 1 một việc.

**Khác nhau:**
- Hầu như các pattern không biểu diễn lớp `client`.
- _Brigde:_ không impliment **interface**:
```Java
public class WildGift extends Gift {
    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }
}
```
- _Builder:_ class `PersionBuilder` nằm trong class `Person` thay vì extends `Person`:
```Java
    package com.mashibing.dp.builder;

    public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    private Person() {}

    public static class PersonBuilder {
        Person p = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {
            p.id = id;
            p.name = name;
            p.age = age;
            return this;
        }

        public PersonBuilder weight(double weight) {
            p.weight = weight;
            return this;
        }

        public PersonBuilder score(int score) {
            p.score = score;
            return this;
        }

        public PersonBuilder loc(String street, String roomNo) {
            p.loc = new Location(street, roomNo);
            return this;
        }

        public Person build() {
            return p;
        }
    }
}

class Location {
String street;
String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
```
- _Command:_ không có class `editor` gộp 3 class function lại:
```Java
public class CopyCommand extends Command {
    Content c;
    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length()/2);
    }
}
```
```Java
public class DeleteCommand extends Command {
    Content c;
    String deleted;
    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        deleted = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
    }

    @Override
    public void undo() {
        c.msg = deleted + c.msg;
    }
}
```
```Java
public class InsertCommand extends Command {
    Content c;
    String strToInsert = "http://www.mashibing.com";
    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length()-strToInsert.length());
    }
}
```
- _Composite:_ không có class `editor`;
```Java
abstract class Node {
    abstract public void p();
}

class LeafNode extends Node {
    String content;
    public LeafNode(String content) {this.content = content;}

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();

    String name;
    public BranchNode(String name) {this.name = name;}

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node n) {
        nodes.add(n);
    }

    static void tree(Node b, int depth) {
        for(int i=0; i<depth; i++) System.out.print("--");
        b.p();

        if(b instanceof BranchNode) {
            for (Node n : ((BranchNode)b).nodes) {
                tree(n, depth + 1);
            }
        }
    }
}
```
- Chain of Responsibility: Cấu trúc đơn nhánh, không có các phương án xử lí với các lựa chọn khác nhau:
```Java
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter())
        .add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new URLFilter());

        fc.add(fc2);

        fc.doFilter(msg);
        System.out.println(msg);

        } 
```
- _Decorator:_ không dùng **interface** impliment ra các class chức năng:
```Java
public class Main {
    public static void main(String[] args) throws Exception {
        File f = new File("c:/work/test.data");
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("http://www.mashibing.com");
        bw.flush();
        bw.close();
    }
}
```