### Báo cáo Design Pattern.

### Các thành viên trong nhóm:
### * Phạm Trọng Tấn - 18021124
### * Phí Văn Tuân - 18021356

### **Link đến reposition được sử dụng trong bài báo cáo [spring-projects/spring-boot](https://github.com/spring-projects/spring-boot)**

### Factory Pattern
* Factory Pattern là một design pattern được sử dụng rộng rãi để ra lệnh tạo các object. Trong đó, một class Factory được tạo như là lớp cha của tất cả các lớp con thuộc một logic segment (phân đoạn logic) nhất định.
* Factory Method: [artifactory](https://github.com/spring-projects/spring-boot/blob/main/buildSrc/src/main/java/org/springframework/boot/build/artifactory/ArtifactoryRepository.java) ta thấy các Factory Method trên giống so với mẫu tiêu chuẩn bởi vì chúng đều tạo một Factory cho các class con đã được tạo và sử dụng nó để khởi tạo các object của mình mà không cần tiếp xúc trực tiếp với các object.
