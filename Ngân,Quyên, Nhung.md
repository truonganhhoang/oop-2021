# OOP-2021
Môn học Lập trình hướng đối tượng với Java
## Báo cáo về Design Pattern - Trần Thị Ngân-20021399
link nguồn tham khảo 
https://github.com/signalapp/Signal-Android

### Factory Method
* Factory method là để đưa toàn bộ logic của việc tạo mới object vào trong factory, che giấu logic của việc khởi tạo.Được định nghĩa interface giúp client tạo object nhưng ủy quyền cho các concreate factory để xác định class nào được trả về cho client
* Factory Method : https://github.com/signalapp/SignalAndroid/blob/a5e5a735800cbdb3afa01a67390b6efa2fc91be6/app/src/main/java/org/thoughtcrime/securesms/video/exo/SignalMediaSourceFactory.java.
trong đó factory method khác so với mẫu tiêu chuẩn bởi vì ở mẫu tiêu chuẩn dùng factory method để tạo(sản xuất) ra các đối tượng. Trong khi đó, ở đây đã dùng để override các phương thức.
