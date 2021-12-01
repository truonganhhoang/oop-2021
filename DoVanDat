# So sánh với mẫu chuẩn

**Các mẫu được sử dụng**
* Singleton Pattern.
* MVC (Model View Controller).
* Template Pattern.
* Factory Method Pattern.

**1. Autowired Singletons**
 * Đối tượng ID trong OwnerRepository và OwnerController là như nhau.
 
**2. MVC (Model View Controller)**
 * Model và controller nằm trong java/org/springframework/samples/petclinic.
 * View nằm trong resources.
 
**3. Template Pattern**
 * Các repository trong đều sử dụng Repository template của spring boot cung cấp.

**4. Factory Method Pattern**
 * Spring coi một ***bean container*** là một ***factory*** tạo ra ***bean***.
 * Spring định nghĩa ***BeanFactory interface*** như một trừu tượng của ***bean container***.
 ```Java
 public interface BeanFactory {

    getBean(Class<T> requiredType);
    getBean(Class<T> requiredType, Object... args);
    getBean(String name);

    // ...
]
 ```
 * Mỗi phương thức *getBean* được coi là một *factory method* trả về một ***bean*** với các tiêu chí được cung cấp cho phương thức, ví dụ là tên, kiểu của ***bean***.


**Khác nhau**
 * Về cơ bản các mẫu thiết kế này không có sự khác biệt so với mẫu thiết kế gốc.

**Thông tin nhóm:**
1. ***Lại Trung Dũng - 18020376***.
2. ***Thân Chí Đạt - 17020678***.
3. ***Đỗ Văn Đạt - 19020244***.

**Repository:** [spring-boot](https://github.com/spring-projects/spring-boot)
