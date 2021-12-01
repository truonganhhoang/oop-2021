<ul>
<li>Nguyễn Ngọc Sơn</li>
<li>Lầu Văn Quang</li>
<li>Phùng Văn An</li>
</ul>
link repo so sánh: https://github.com/google/ExoPlayer

**Singleton**
<ul>
<li>public boolean onCreateOptionsMenu(Menu menu) {
	super.onCreateOptionsMenu(menu);
	getMenuInflater().inflate(R.menu.menu, menu);
    CastButtonFactory.setUpMediaRouteButton(this, menu, R.id.media_route_menu_item);
	return true;
  }
</li>
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
<li> private View buildSampleListView() {
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
</li>
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


**Abstract Factory**
<ul>
<li>public View getView(int position, @Nullable View convertView, ViewGroup parent) {
  	View view = super.getView(position, convertView, parent);
  	((TextView) view).setText(Util.castNonNull(getItem(position)).mediaMetadata.title);
  	return view;
	}
 </li>
<li>Giống nhau:</li>
<ul>
	<li>Có thể tạo ra các họ các đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng.</li>
	<li> Khai báo rõ ràng các giao diện cho từng sản phẩm riêng biệt của họ sản phẩm</li>
	<li>Các triển khai khác nhau của các sản phẩm trừu tượng, được nhóm theo các biến thể.</li>
	<li>Các Abstract Factory giao diện tuyên bố một tập hợp các phương pháp để tạo ra mỗi sản phẩm trừu tượng.</li>
</ul>


<li>Khác nhau:</li>
<ul>
	<li>Rất nhiều giao diện và lớp mới được giới thiệu cùng với mẫu.</li>
</ul>
</ul>



**Builder**
<ul>
<li>private void updateCurrentItemIndex() {
	int playbackState = currentPlayer.getPlaybackState();
	maybeSetCurrentItemAndNotify(
    	playbackState != Player.STATE_IDLE && playbackState != Player.STATE_ENDED
        	? currentPlayer.getCurrentMediaItemIndex()
        	: C.INDEX_UNSET);
  }
 </li>
<li>Giống nhau:</li>
<ul>
	<li>Các đối tượng phức tạp được xây dựng theo từng bước.</li>
	<li>Concrete Builders cung cấp các cách triển khai khác nhau của các bước xây dựng</li>
	<li>Director biết các bước xây dựng cần thực hiện để có được một sản phẩm hoạt động.</li>
	<li>Các builders khác nhau thực hiện cùng một nhiệm vụ theo nhiều cách khác nhau.</li>
</ul>

<li>Khác nhau :</li>
<ul>
	<li>Độ phức tạp tổng thể của mã tăng lên vì mẫu yêu cầu tạo nhiều lớp mới.</li>
</ul>
</ul>


**Prototype**
<ul>
<li> private void maybeSetCurrentItemAndNotify(int currentItemIndex) {
	if (this.currentItemIndex != currentItemIndex) {
  	int oldIndex = this.currentItemIndex;
  	this.currentItemIndex = currentItemIndex;
  	listener.onQueuePositionChanged(oldIndex, currentItemIndex);
	}
  }
</li>
<li>Giống nhau:</li>
<ul>
	<li>Cho phép sao chép các đối tượng hiện có mà không làm cho mã của ban đầu phụ thuộc vào các lớp của chúng.</li>
	<li>Prototypes được tạo sẵn có thể là một giải pháp thay thế cho subclassing.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Mẫu Prototype cung cấp cho mã máy khách một giao diện chung để làm việc với tất cả các đối tượng hỗ trợ nhân bản. Giao diện này làm cho mã máy khách độc lập với các lớp cụ thể của các đối tượng mà nó sao chép.</li>
</ul>
</ul>


**Adapter**
<ul>
<li> SurfaceView surfaceView = new SurfaceView(this);
    	view = surfaceView;
    	attachSurfaceListener(surfaceView);
    	surfaceView.setOnClickListener(
        	v -> {
              setCurrentOutputView(surfaceView);
          	nonFullScreenView = surfaceView;
        	});
    	if (nonFullScreenView == null) {
      	nonFullScreenView = surfaceView;
    	}
</li>
<li>Giống nhau:</li>
<ul>
	<li>Cho phép các đối tượng có giao diện không tương thích cộng tác.</li>
	<li>Có thể gọi các phương thức của adapter một cách an toàn.</li>
	<li>Một lớp chứa logic nghiệp vụ hiện có của chương trình.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Khi muốn sử dụng lại một số lớp con hiện có thiếu một số chức năng phổ biến không thể thêm vào lớp cha.</li>
	<li>Độ phức tạp tổng thể của mã tăng lên.</li>
</ul>
</ul>


**Bridge**
<ul>
<li> public void onResume() {
	super.onResume();
 
	if (isOwner && player == null) {
  	initializePlayer();
	}
 
	setCurrentOutputView(nonFullScreenView);
 
	PlayerControlView playerControlView = Assertions.checkNotNull(this.playerControlView);
	playerControlView.setPlayer(player);
	playerControlView.show();
  }
</li>
<li>Giống nhau:</li>
<ul>
	<li> Chia một lớp lớn hoặc một tập hợp các lớp có liên quan chặt chẽ thành hai phân cấp riêng biệt — trừu tượng và thực thi — có thể được phát triển độc lập với nhau.</li>
	<li>Thực hiện thay đổi đối với các mô-đun nhỏ hơn, được xác định rõ ràng dễ dàng hơn nhiều.</li>
	<li>Triển khai Concrete chứa mã dành riêng cho nền tảng</li>
	<li>Cung cấp các biến thể của logic điều khiển</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Mất nhiều thời gian để thực hiện thay đổi</li>
</ul>
</ul>