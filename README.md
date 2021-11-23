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


