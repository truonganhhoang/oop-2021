# BÁO CÁO VỀ MẪU THIẾT KẾ

## 1. GIỚI THIỆU:

### 1.1 Yêu cầu:

- Tìm các mẫu thiết kế trong mã nguồn của các dự án có trên 1000 sao trên github. 

- So sánh các mẫu tìm được với mẫu chuẩn của 23 mẫu thiết kế. 

- Viết báo cáo ở dạng file .md và nộp bằng pull request đến repo của giáo viên.

### 1.2 Các repo đã them khảo:
- [REPO_PATTERNLOCKVIEW](https://github.com/aritraroy/PatternLockView?fbclid=IwAR2Pg4eIPS8W2NUxNkU0bnueW8uWCbMEjOYuYU90euGqcMmc1WsAi7St5bU)
	*Repo của tác giả aritraroy với 2700 sao trên github*

- [REPO_CPPDESIGNPATTERN](https://github.com/liu-jianhao/Cpp-Design-Patterns?fbclid=IwAR1GkSRQBmd5q7f4AAvW8veAEl3oz39jhyf_BwHeiGKWkr1CVzy5Manv1Z8)
	*Repo của tác giả liu-jianhao với với 1000 sao trên github*

### 1.3 Thành viên nhóm (MSV - Họ và tên):

- 20021395 Nguyễn Quang Minh

- 20021387 Nguyễn Phúc Long

- 20021334 Đào Văn Đức

### 1.4 Repo của nhóm: 

https://github.com/minh16022002/NguyenQuangMinh

*Các thành viên nộp vào repo của nhóm, sau đó nhóm trưởng tổng hợp lại và gửi lên repo của giáo viên.*


## 2. BÁO CÁO:
*Sau khi tham khảo 2 repo trên, nhóm em tiến hành so sánh với các mẫu thiết kế:*

### 2.1 Nhóm các mẫu thiết kế Creational:
*Những Design pattern loại này cung cấp một giải pháp để tạo ra các object và che giấu được logic của việc tạo ra nó, thay vì tạo ra object một cách*

 *trực tiếp bằng cách sử dụng method new.* 
*Điều này giúp cho chương trình trở nên mềm dẻo hơn trong việc quyết định object nào cần được tạo ra trong những tình huống được đưa ra.*


#### 2.1.1 Abstract Factory: 

**Trong package ``com.andrognito.rxpatternlockview.events`` của repo số 1:**

*Đường dẫn: https://github.com/aritraroy/PatternLockView/tree/master/patternlockview-reactive/src/main/java/com/andrognito/rxpatternlockview/events*
	
Abstract class ``BasePatternLockEvent`` được kế thừa bởi các class sau:

```Java
class PatternLockCompleteEvent

class PatternLockCompoundEvent

class PatternLockProgressEvent 
```
**Trong package ``com.andrognito.rxpatternlockview.observables`` của repo số 1:**

*Đường dẫn: https://github.com/aritraroy/PatternLockView/tree/master/patternlockview-reactive/src/main/java/com/andrognito/rxpatternlockview/observables*

Abstract class ``BasePatternLockViewObservable`` được kế thừa bởi các class sau:

```Java
class PatternLockViewCompleteObservable

class PatternLockViewCompoundObservable

class PatternLockViewProgressObservable
```

Việc tạo ra những Super-factory này dùng để tạo ra các Factory tiếp theo rất giống với mẫu thiết kế Abstract Factory.

Trong Abstract Factory pattern, một interface có nhiệm vụ tạo ra một Factory của các object có liên quan tới nhau mà không cần phải chỉ ra trực tiếp các class của object. Mỗi Factory được tạo ra có thể tạo ra các object bằng phương pháp giống như Factory pattern.


#### 2.1.2 Singleton:

**Trong package ``com.andrognito.patternlockview.utils`` của repo số 1:**

*Đường dẫn: https://github.com/aritraroy/PatternLockView/tree/master/patternlockview/src/main/java/com/andrognito/patternlockview/utils*

*Mô tả: đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp cho bạn một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.*

Các lớp dưới đây đều chỉ có một thể hiện và chỉ cung cấp một method có thể truy xuất được thể hiện duy nhất đó

```Java
class PatternLockUtils
private PatternLockUtils() {
        throw new AssertionError("You can not instantiate this class. Use its static utility " +
                "methods instead");
    }
```

```Java
class RandomUtils
private RandomUtils() {
        throw new AssertionError("You can not instantiate this class. Use its static utility " +
                "methods instead");
    }
```

```Java
class ResourceUtils
private ResourceUtils() {
        throw new AssertionError("You can not instantiate this class. Use its static utility " +
                "methods instead");
    }
```
*Khác so với Singleton: Các class vẫn tồn tại những hàm ngoài luồng, dùng để xử lý ngoại lệ, đôi khi khó nhận biết*

#### 2.1.3 Builder:

*Mô tả: Tách rời việc xây dựng (construction) một đối tượng phức tạp khỏi biểu diễn của nó sao cho cùng một tiến trình xây dựng có thể tạo được các biểu diễn khác nhau.*

*Đường dẫn: https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Builder*

Đối tượng House được biểu diễn bằng cách tách thành nhiều biểu diễn nhỏ và ít phức tạp hơn như Builder, Director:

```C++
class House

class HouseBuilder

class HouseDirector

class StoneHouse

class StoneHouseBuilder
```
Mẫu thiết kế này khá giống với mẫu thiết kế chuẩn.


#### 2.1.4 Prototype:

*Mô tả: Prototype cho phép sao chép các đối tượng hiện có mà không làm cho code của bạn phụ thuộc vào các lớp của chúng.*

*Đường dẫn: https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Prototype*

Thể hiện việc cho phép các đối tượng hiện có được sao chép mà không làm cho code bị phụ thuộc:

```C++
class BinarySplitter

class TxtSplitter

class PictureSplitter

class VideoSplitter

class ISplitter{
public:
    virtual void split()=0;
    virtual ISplitter* clone()=0;
    
    virtual ~ISplitter(){}

};
```

### 2.2 Nhóm các mẫu thiết kế Structural:

*Những Design pattern loại này liên quan tới class và các thành phần của object. Nó dùng để thiết lập, định nghĩa quan hệ giữa các đối tượng.*

#### 2.2.1 Adapter:

*Mô tả: Các interface không liên quan tới nhau có thể làm việc cùng nhau.*

**Adapter được thể hiện trong repo số 1:**

*Đường dẫn:https://github.com/aritraroy/PatternLockView/tree/master/patternlockview-reactive/src/main/java/com/andrognito/rxpatternlockview/observables*

Nhóm các class dưới đây tuy mang những chức năng khác nhau nhưng vẫn làm việc cùng nhau, kế thừa từ class ``io.reactivex.Observable``

```Java
class PatternLockViewCompleteObservable
```

```Java
class PatternLockViewCompoundObservable
```

```Java
class PatternLockViewProgressObservable
```

*Sau khi so sánh với mẫu thiết kế Adapter, nhóm mình thấy việc sử dụng mẫu thiết kế này khá phổ biến và có nhiều biến thể của chúng, chẳng
 hạn như việc các lớp có thể tuy cùng kế thừa từ một class, có mục đích sử dụng khác nhau, nhưng vẫn hoạt động và làm việc cùng nhau bình 
 thường.* 

#### 2.2.2 Bridge Pattern:

*Mô tả: Tách tính trừu tượng ra khỏi tính hiện thực của nó. Từ đó có thể dễ dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những
 nơi có sử dụng lớp ban đầu -> cả hai bộ phận có thể thay đổi độc lập nhau. Nó giúp giảm sự phụ thuộc giữa trừu tượng và hiện thực, 
 giảm số lượng những lớp con không cần thiết, code gọn gàng, dễ bảo trì, mở rộng về sau.*

*Đường dẫn: https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Bridge*

Đoạn code minh hoạ cho việc tách tính trừu tượng ra khỏi tính hiện thực trong class Messager

```C++
class Messager{
public:
    virtual void Login(string username, string password)=0;
    virtual void SendMessage(string message)=0;
    virtual void SendPicture(Image image)=0;

    virtual void PlaySound()=0;
    virtual void DrawShape()=0;
    virtual void WriteText()=0;
    virtual void Connect()=0;
    
    virtual ~Messager(){}
};

class PCMessagerBase

class MobileMessagerBase

class PCMessagerLite

class PCMessagerPerfect

class MobileMessagerLite

class MobileMessagerPerfect
```

#### 2.2.3 Composite Pattern:

*Mô tả:Tổ chức các đối tượng theo cấu trúc phân cấp dạng cây. Tất cả các đối tượng trong cấu trúc được thao tác theo một cách thuần nhất 
như nhau.*

*Đường dẫn: https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Composite*

Minh hoạ: 

```C++
class Component {
public:
    virtual void process() = 0;
    virtual ~Component(){}
};

class Composite

class Leaf : public Component{
    string name;
public:
    Leaf(string s) : name(s) {}
            
    void process(){
        //process current node
    }
};
```

#### 2.2.4 Decorator Pattern:

*Mô tả: Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) vào lúc chạy (dynamically) mà không làm thay đổi cấu trúc lớp của nó. 
Decorator thể hiện như là đóng gói của một lớp đã tồn tại.*

*Đường dẫn: https://github.com/liu-jianhao/Cpp-Design-Patterns/tree/master/Decorator-Pattern*

Minh hoạ cho Decorator Pattern:
```C++
class Stream{
public:
    virtual char Read(int number)=0;
    virtual void Seek(int position)=0;
    virtual void Write(char data)=0;
    
    virtual ~Stream(){}
};

class FileStream: public Stream{
public:
    virtual char Read(int number){
        //读文件流
    }
    virtual void Seek(int position){
        //定位文件流
    }
    virtual void Write(char data){
        //写文件流
    }

};

class NetworkStream :public Stream{
public:
    virtual char Read(int number){
    }
    virtual void Seek(int position){
    }
    virtual void Write(char data){
    }
    
};

class MemoryStream :public Stream{
public:
    virtual char Read(int number){
        
    }
    virtual void Seek(int position){
        
    }
    virtual void Write(char data){
        
    }
    
};

class CryptoFileStream

class CryptoNetworkStream

class CryptoMemoryStream

class BufferedFileStream

class BufferedNetworkStream

class BufferedMemoryStream

class CryptoBufferedFileStream
```
Từ các class minh hoạ ta thấy mẫu thiết kế này khá giống với mẫu thiết kế chuẩn.

#### 2.2.6 Flyweight:

*Mô tả: Phương pháp trả về các đối tượng được lưu trong bộ nhớ đệm thay vì tạo mới.*

```C++
class Font {
private:
    string key;
public:
    Font(const string& key){
        //...
    }
};

class FontFactory{
private:
    map<string,Font* > fontPool;
    
public:
    Font* GetFont(const string& key){

        map<string,Font*>::iterator item=fontPool.find(key);
        
        if(item!=footPool.end()){
            return fontPool[key];
        }
        else{
            Font* font = new Font(key);
            fontPool[key]= font;
            return font;
        }

    }
    
    void clear(){
        //...
    }
};
```

#### 2.2.7 Proxy:

*Mô tả: Ủy quyền tất cả công việc thực sự cho một số đối tượng khác và mỗi phương thức proxy phải tham chiếu đến một đối tượng dịch vụ trừ khi proxy là một lớp con của một dịch vụ.*

Code minh hoạ: 

```C++
class ISubject{
public:
    virtual void process();
};

class SubjectProxy: public ISubject{
    
public:
    virtual void process(){
        
    }
};

class ClientApp{
    
    ISubject* subject;
    
public:
    ClientApp(){
        subject=new SubjectProxy();
    }
    
    void DoTask(){
        subject->process();
    }
};
```

## 3. KẾT LUẬN:

Sau khi tìm hiểu các mẫu thiết kế trong hai repo trên, nhóm chúng mình xin đưa ra những kết luận chung của bài báo cáo:

- Đa phần các mẫu thiết kế được sử dụng khá giống các mẫu thiết kế chuẩn, có sửa đổi linh hoạt để phù hợp với dự án.

- Lợi ích của việc vận dụng được các mẫu thiết kế vào dự án: 
	- Đơn giản hoá mã nguồn.
	- Giảm thời gian và công sức suy nghĩ các cách phân bố và cấu trúc chương trình.
	- Dễ dàng kiểm tra, nâng cấp mã nguồn.

Cảm ơn thầy và các bạn đã đọc và nhận xét. Phần báo cáo của nhóm mình còn nhiều thiếu sót, mong thầy và các bạn thông cảm.
