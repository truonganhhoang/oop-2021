# OOP-2021
Môn học Lập trình hướng đối tượng với Java
# Nhóm HLN
 ## Báo cáo tìm hiểu về mẫu thiết kế
 ## Thành viên: Họ và tên - MSSV
 ## 1. Đỗ Ngọc Long - 20021385
 ## 2. Cấn Mạnh Hùng - 20021364
 ## 3. Nguyễn Phúc Nguyên - 20021406

### **Cách thức thực hiện bài báo cáo**: Mỗi thành viên làm phần bài báo cáo của mình rồi commit vào reposition của nhóm ([Link reposition của nhóm](https://github.com/dongoclong/nhomHLN)), bạn Đỗ Ngọc Long tổng hợp và sắp xếp phần báo cáo của các thành viên vào file báo cáo của nhóm.
 
 - **[Link đến reposition được sử dụng trong bài báo cáo] (https://github.com/sshahine/JFoenix/tree/master/demo)**

## Abstract Factory:
-	Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần quy định lớp khi hay xác định lớp cụ thể (concrete) tạo mỗi đối tượng.
-	Hãy lấy một hãng sản xuất ô tô làm ví dụ, chẳng hạn Hyundai. Họ có nhà máy, hoặc xưởng, chế tạo bánh xe: bánh của Azera, bánh của Sonata, bánh của Veloster, v.v… Đến lượt cửa xe, cũng có nhà máy chế tạo cửa Azera, cửa Sonata, cửa Veloster. Thân xe, động cơ, đèn, và các thành phần khác có những nhà máy chế tạo chúng.
-	Example: https://github.com/JangirSumit/abstract-factory-design-pattern .
```
	public abstract class Shape{
		String color;
	}
	public class Square extends Shape {
		public Square(){}
	}
	public shapeFactory{
		public Shape getShape(String shapeType) {
			if(shapeType.equals("SQUARE")
				return new Square();
```

## Factory Method:
-	Định nghĩa Interface để sinh ra đối tượng nhưng để cho lớp con quyết định lớp nào được dùng để sinh ra đối tượng Factory method cho phép một lớp chuyển quá trình khởi tạo đối tượng cho lớp con.
-	Factory method, đầy đủ là Factory method pattern, là thiết kế mẫu hướng đối tượng trong việc thiết kế phần mềm cho máy tính, nhằm giải quyết vấn đề tạo một đối tượng mà không cần thiết chỉ ra một cách chính xác lớp nào sẽ được tạo
-	Example: https://github.com/iluwatar/java-design-patterns/tree/master/factory-method .
```
	public interface GiongCayTrongFactory {
		public Giong chonGiong();
	}
```
## Adapter:
-	Do vấn đề tương thích, thay đổi interface của một lớp thành một interface khác phù hợp với yêu cầu người sử dụng lớp.
-	Trong công nghệ phần mềm, Adapter pattern là một mẫu thiết kế tiếp hợp cho phép chuyển đổi một interface có sẵn thành một interface khác thích hợp cho lớp đang viết.
- Example: https://github.com/Adapter-Hub/Hub .
```
package com.gpcoder.patterns.structural.adapter;
 
public class JapaneseAdaptee {
 
    public void receive(String words) {
        System.out.println("Retrieving words from Adapter ...");
        System.out.println(words);
    }
}
```

## Bridge:
-	Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mục đích để cả hai bộ phận (ngữ nghĩa và cài đặt) có thể thay đổi độc lập nhau.
-	Dạng thức bắc cầu là một dạng thức thiết kế được dùng trong công nghệ phần mềm. Dạng thức bắc cầu dùng để "tách riêng tính trừu tượng ra khỏi thực thể của nó để cho cả hai có thể thay đổi một cách độc lập".
-	Example: https://github.com/MoienTajik/Bridge-Pattern-Sample .
```
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
		...........
		@Override
  		public Enchantment getEnchantment() {
    			return enchantment;
  		}
	}
```


