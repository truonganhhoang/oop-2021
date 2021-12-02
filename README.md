# oop-2021
Môn học Lập trình hướng đối tượng với Java
**Singleton**
<ul>
&gt;public boolean onCreateOptionsMenu(Menu menu) {
	super.onCreateOptionsMenu(menu);
	getMenuInflater().inflate(R.menu.menu, menu);
    CastButtonFactory.setUpMediaRouteButton(this, menu, R.id.media_route_menu_item);
	return true;
  }
&gt;
<li>Giống nhau:</li>
<ul>
<li>Một lớp chỉ có một thể hiện, đồng thời cung cấp một điểm truy cập toàn cục cho thể hiện này.</li>
	<li>Đặt phương thức khởi tạo mặc định là riêng tư, để ngăn các đối tượng khác sử dụng new toán tử với lớp Singleton</li>
	<li>Tạo một phương thức tạo tĩnh hoạt động như một phương thức khởi tạo. Bên dưới, phương thức này gọi phương thức khởi tạo riêng để tạo một đối tượng và lưu nó trong một trường tĩnh. Tất cả các lệnh gọi sau đến phương thức này đều trả về đối tượng được lưu trong bộ nhớ cache</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Một đối tượng cơ sở dữ liệu duy nhất được chia sẻ bởi các phần khác nhau của chương trình.</li>
	<li>Phần thân của getInstance phương thức.</li>
</ul>
</ul>

**Factory Method**
<ul>
> private View buildSampleListView() {
	View dialogList = getLayoutInflater().inflate(R.layout.sample_list, null);
	ListView sampleList = dialogList.findViewById(R.id.sample_list);
	sampleList.setAdapter(new SampleListAdapter(this));
	sampleList.setOnItemClickListener(
    	(parent, view, position, id) -> {
      	playerManager.addItem(DemoUtil.SAMPLES.get(position));
          mediaQueueListAdapter.notifyItemInserted(playerManager.getMediaQueueSize() - 1);
    	});
	return dialogList;
  }

<li>Giống nhau:</li>
<ul>
	<li>Cung cấp một giao diện để tạo các đối tượng trong lớp cha, nhưng cho phép các lớp con thay đổi loại đối tượng sẽ được tạo.</li>
	<li>Các lớp con có thể thay đổi lớp của các đối tượng được trả về bởi phương thức gốc.</li>
	<li>Tất cả các sản phẩm phải theo cùng một giao diện.</li>
	<li>Tất cả các lớp sản phẩm đều triển khai một giao diện chung, bạn có thể chuyển các đối tượng của chúng sang mã máy khách mà không cần phá vỡ nó.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Các lớp giao diện người dùng cụ thể.</li>
	<li>Sự phụ thuộc của các đối tượng mà mã của bạn sẽ hoạt động.</li>
	<li>Các phương thức tạo trong lớp cơ sở và các lớp con.</li>
</ul>
</ul>


