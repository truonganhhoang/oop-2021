**Đây là 23 mẫu thiết kế mở sử dụng trong dự án github 1000 sao được các thành viên trong nhóm so sánh với 23 mẫu thiết kế chuẩn dưới đây:**

**Nhóm gồm các thành viên:**
<ul>
<li>Nguyễn Ngọc Sơn</li>
<li>Lầu Văn Quang</li>
<li>Phùng Văn An</li>
</ul>

**Link**
<ul>
	<li>Sau khi tìm hiểu các repo trên github nhóm đã đã lựa chọn được repo sau gồm 23 mẫu thiết kế</li>
	<li>link mẫu: https://refactoring.guru/design-patterns/java</li>
	<li>link so sánh: https://github.com/google/ExoPlayer</li>
</ul>

**Singleton**
```
	public boolean onCreateOptionsMenu(Menu menu) {
	super.onCreateOptionsMenu(menu);
	getMenuInflater().inflate(R.menu.menu, menu);
    CastButtonFactory.setUpMediaRouteButton(this, menu, R.id.media_route_menu_item);
	return true;
  }
```
<ul>
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
```
	 private View buildSampleListView() {
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
```
	
<ul>
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
```
	public View getView(int position, @Nullable View convertView, ViewGroup parent) {
  	View view = super.getView(position, convertView, parent);
  	((TextView) view).setText(Util.castNonNull(getItem(position)).mediaMetadata.title);
  	return view;
	}
 ```
	
<ul>
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
```
	private void updateCurrentItemIndex() {
	int playbackState = currentPlayer.getPlaybackState();
	maybeSetCurrentItemAndNotify(
    	playbackState != Player.STATE_IDLE && playbackState != Player.STATE_ENDED
        	? currentPlayer.getCurrentMediaItemIndex()
        	: C.INDEX_UNSET);
  }
```
<ul>
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
```
	 private void maybeSetCurrentItemAndNotify(int currentItemIndex) {
	if (this.currentItemIndex != currentItemIndex) {
  	int oldIndex = this.currentItemIndex;
  	this.currentItemIndex = currentItemIndex;
  	listener.onQueuePositionChanged(oldIndex, currentItemIndex);
	}
  }
```
<ul>
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
```
	 SurfaceView surfaceView = new SurfaceView(this);
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
```
<ul>
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
```
	 public void onResume() {
	super.onResume();
 
	if (isOwner && player == null) {
  	initializePlayer();
	}
 
	setCurrentOutputView(nonFullScreenView);
 
	PlayerControlView playerControlView = Assertions.checkNotNull(this.playerControlView);
	playerControlView.setPlayer(player);
	playerControlView.show();
  }
```
<ul>
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


**Composite**
```
	 public void onPause() {
	super.onPause();
 
    Assertions.checkNotNull(playerControlView).setPlayer(null);
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Cho phép sắp xếp các đối tượng thành cấu trúc cây và sau đó làm việc với các cấu trúc này như thể chúng là các đối tượng riêng lẻ.</li>
	<li>Mẫu tổng hợp cho phép chạy một cách đệ quy một hành vi trên tất cả các thành phần của cây đối tượng.</li>
	<li>Các thành phần giao diện mô tả hoạt động mà là chung cho cả hai đơn giản và các yếu tố phức tạp của cây.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Khó cung cấp một giao diện chung cho các lớp có chức năng khác nhau quá nhiều</li>
</ul>
</ul>


**Decorator**
```
	 String drmScheme = Assertions.checkNotNull(intent.getStringExtra(DRM_SCHEME_EXTRA));
  	String drmLicenseUrl = Assertions.checkNotNull(intent.getStringExtra(DRM_LICENSE_URL_EXTRA));
  	UUID drmSchemeUuid = Assertions.checkNotNull(Util.getDrmUuid(drmScheme));
  	HttpDataSource.Factory licenseDataSourceFactory = new DefaultHttpDataSource.Factory();
  	HttpMediaDrmCallback drmCallback =
      	new HttpMediaDrmCallback(drmLicenseUrl, licenseDataSourceFactory);
  	drmSessionManager =
      	new DefaultDrmSessionManager.Builder()
              .setUuidAndExoMediaDrmProvider(drmSchemeUuid, FrameworkMediaDrm.DEFAULT_PROVIDER)
          	.build(drmCallback);
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Cho phép đính kèm các hành vi mới vào các đối tượng bằng cách đặt các đối tượng này bên trong các đối tượng trình bao bọc đặc biệt có chứa các hành vi.</li>
	<li>Các ứng dụng có thể định cấu hình các ngăn xếp phức tạp của trình trang trí thông báo</li>.
	<li>Các phương pháp thông báo khác nhau trở thành người trang trí.</li>
</ul>

<li>-Khác nhau:</li>
<ul>
	<li>Khó mở rộng thêm một lớp</li>
	<li>Cấu trúc lôgic nghiệp vụ</li>
</ul>
</ul>


**Facade**
```
	  
ExoPlayer player = new ExoPlayer.Builder(getApplicationContext()).build();
	player.setMediaSource(mediaSource);
	player.prepare();
	player.play();
    player.setRepeatMode(Player.REPEAT_MODE_ALL);
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Cung cấp một giao diện đơn giản hóa cho một thư viện, một khuôn khổ hoặc bất kỳ tập hợp lớp phức tạp nào khác.</li>
	<li>Các Facade cung cấp truy cập thuận tiện đối với một phần cụ thể của chức năng của hệ thống phụ.</li>
	<li>Các lớp hệ thống con không nhận thức được sự tồn tại của mặt tiền. Chúng hoạt động trong hệ thống và làm việc trực tiếp với nhau.</li>
</ul>

<li>-Khác nhau:</li>
<ul>
	<li>Các hệ thống con trở nên phức tạp hơn theo thời gian.</li>
</ul>
</ul>


**Flyweight**
```
	surfaceControl =
    	new SurfaceControl.Builder()
        	.setName(SURFACE_CONTROL_NAME)
        	.setBufferSize(/* width= */ 0, /* height= */ 0)
        	.build();
	videoSurface = new Surface(surfaceControl);
	player.setVideoSurface(videoSurface);
	MainActivity.player = player;
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Cho phép lắp nhiều đối tượng hơn vào dung lượng RAM có sẵn bằng cách chia sẻ các phần trạng thái chung giữa nhiều đối tượng thay vì giữ tất cả dữ liệu trong mỗi đối tượng.</li>
	<li>Chứa một phần trạng thái của đối tượng ban đầu có thể được chia sẻ giữa nhiều đối tượng.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Một ứng dụng cần tạo ra một số lượng lớn các đối tượng tương tự.</li>
	<li>Các đối tượng chứa các trạng thái trùng lặp có thể được trích xuất và chia sẻ giữa nhiều đối tượng</li>
	<li>Mã trở nên phức tạp hơn nhiều</li>
</ul>
</ul>





**Proxy**
```
	private void setCurrentOutputView(@Nullable SurfaceView surfaceView) {
	currentOutputView = surfaceView;
	if (surfaceView != null && surfaceView.getHolder().getSurface() != null) {
  	reparent(surfaceView);
	}
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Một proxy kiểm soát quyền truy cập vào đối tượng ban đầu, cho phép bạn thực hiện điều gì đó trước hoặc sau khi yêu cầu được chuyển đến đối tượng ban đầu.</li>
	<li>Các giao diện Service tuyên bố giao diện của Dịch Vụ. Proxy phải tuân theo giao diện này để có thể tự ngụy trang thành một đối tượng dịch vụ.</li>
	<li>Proxy quản lý toàn bộ vòng đời của các đối tượng dịch vụ </li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Có thể trì hoãn việc khởi tạo đối tượng đến thời điểm thực sự cần thiết.</li>
	<li>Proxy có thể chuyển yêu cầu đến đối tượng dịch vụ chỉ khi thông tin xác thực của khách hàng phù hợp với một số tiêu chí.</li>
	<li>Proxy có thể sử dụng các tham số của yêu cầu làm khóa bộ nhớ cache</li>
</ul>
</ul>


**Chain of Responsibility**
```
	 private void attachSurfaceListener(SurfaceView surfaceView) {
	surfaceView
    	.getHolder()
    	.addCallback(
        	new SurfaceHolder.Callback() {
          	@Override
          	public void surfaceCreated(SurfaceHolder surfaceHolder) {
            	if (surfaceView == currentOutputView) {
              	reparent(surfaceView);
            	}
          	}
 
          	@Override
	          public void surfaceChanged(
              	SurfaceHolder surfaceHolder, int format, int width, int height) {}
 
          	@Override
          	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {}
        	});
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Chuyển các yêu cầu dọc theo một chuỗi các trình xử lý. Khi nhận được yêu cầu, mỗi trình xử lý sẽ quyết định xử lý yêu cầu hoặc chuyển nó cho trình xử lý tiếp theo trong chuỗi.</li>
	<li>Những người xử lý được xếp từng hàng một, tạo thành một chuỗi.</li>
	<li>Một chuỗi có thể được hình thành từ một nhánh của cây đối tượng.
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Một số yêu cầu chưa được giải quyết.</li>
</ul>
</ul>


**Command**
```
	 SurfaceControl surfaceControl = Assertions.checkNotNull(MainActivity.surfaceControl);
	if (surfaceView == null) {
  	new SurfaceControl.Transaction()
      	.reparent(surfaceControl, /* newParent= */ null)
      	.setBufferSize(surfaceControl, /* w= */ 0, /* h= */ 0)
      	.setVisibility(surfaceControl, /* visible= */ false)
      	.apply();
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Biến một yêu cầu thành một đối tượng độc lập chứa tất cả thông tin về yêu cầu</li>
	<li>Sự chuyển đổi này cho phép bạn chuyển các yêu cầu dưới dạng đối số của phương thức, trì hoãn hoặc xếp hàng đợi việc thực hiện một yêu cầu và hỗ trợ các hoạt động hoàn tác.</li>
	<li>Các đối tượng GUI có thể truy cập trực tiếp vào các đối tượng logic nghiệp vụ.</li>
	<li>Truy cập lớp logic nghiệp vụ thông qua một lệnh.</li>
	<li>Các đối tượng GUI ủy quyền công việc cho các lệnh.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Tham số hóa các đối tượng bằng các phép toán</li>
	<li>Xếp hàng đợi các hoạt động, lên lịch thực thi hoặc thực thi chúng từ xa.</li>
	<li>Triển khai các hoạt động có thể đảo ngược</li>
</ul>
</ul>


**Iterator**
```
	trackSelectionParameters =
          DefaultTrackSelector.Parameters.CREATOR.fromBundle(
              savedInstanceState.getBundle(KEY_TRACK_SELECTION_PARAMETERS));
  	startAutoPlay = savedInstanceState.getBoolean(KEY_AUTO_PLAY);
  	startItemIndex = savedInstanceState.getInt(KEY_ITEM_INDEX);
  	startPosition = savedInstanceState.getLong(KEY_POSITION);
```
<ul>
<li>Giống nhau:</li>
	<li>Duyệt qua các phần tử của một bộ sưu tập mà không để lộ biểu diễn cơ bản của nó (danh sách, ngăn xếp, cây, v.v.).</li>
	<li>Trình lặp thực hiện các thuật toán duyệt khác nhau. Một số đối tượng trình lặp có thể duyệt cùng một bộ sưu tập cùng một lúc.
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Trình lặp đóng gói các chi tiết làm việc với cấu trúc dữ liệu phức tạp</li>
	<li>Mã của các thuật toán lặp không tầm thường có xu hướng rất cồng kềnh</li>
	<li>Mẫu cung cấp một vài giao diện chung cho cả bộ sưu tập và trình vòng lặp</li>
</ul>
</ul>


**Mediator**
```
	 public void onNewIntent(Intent intent) {
	super.onNewIntent(intent);
	releasePlayer();
	releaseAdsLoader();
	clearStartPosition();
	setIntent(intent);
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Giảm bớt sự phụ thuộc hỗn loạn giữa các đối tượng. Mẫu hạn chế giao tiếp trực tiếp giữa các đối tượng và buộc chúng chỉ cộng tác thông qua một đối tượng trung gian.</li>
	<li>Các phần tử giao diện người dùng giao tiếp gián tiếp, thông qua đối tượng trung gian</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Khó thay đổi một số lớp</li>
	<li>Không thể sử dụng lại một thành phần trong một chương trình khác vì nó quá phụ thuộc vào các thành phần khác.</li>
</ul>
</ul>

**Memento**
```
	public void onStart() {
	super.onStart();
	if (Util.SDK_INT > 23) {
  	initializePlayer();
  	if (playerView != null) {
    	playerView.onResume();
  	}
	}
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Cho phép lưu và khôi phục trạng thái trước đó của một đối tượng mà không tiết lộ chi tiết về quá trình triển khai của nó.</li>
	<li>Người tạo có toàn quyền truy cập vào memento, trong khi người chăm sóc chỉ có thể truy cập siêu dữ liệu.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Có thể khôi phục trạng thái trước đó của đối tượng.</li>
	<li>Không đối tượng nào khác có thể đọc ảnh chụp nhanh, làm cho dữ liệu trạng thái của đối tượng ban đầu được an toàn và bảo mật.</li>
</ul>
</ul>

**Observer**
```
	 public void onDestroy() {
	super.onDestroy();
	releaseAdsLoader();
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Cho phépxác định cơ chế đăng ký để thông báo cho nhiều đối tượng về bất kỳ sự kiện nào xảy ra với đối tượng mà họ đang quan sát.</li>
	<li>Cơ chế đăng ký cho phép các đối tượng riêng lẻ đăng ký nhận thông báo sự kiện</li>
	<li>Nhà xuất bản thông báo cho người đăng ký bằng cách gọi phương thức thông báo cụ thể trên các đối tượng của họ.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Một số đối tượng trong ứng dụng của bạn phải quan sát những đối tượng khác, nhưng chỉ trong thời gian giới hạn hoặc trong các trường hợp cụ thể.</li>
</ul>
</ul>


**State**
```
	public void onRequestPermissionsResult(
  	int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	if (grantResults.length == 0) {
  	// Empty results are triggered if a permission is requested while another request was already
  	// pending and can be safely ignored in this case.
  	return;
	}
	if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
  	initializePlayer();
	} else {
      showToast(R.string.storage_permission_denied);
  	finish();
	}
  }
```
<ul>
<li>Giống nhau:</li>	
<ul>
	<li>Một đối tượng thay đổi hành vi của nó khi trạng thái bên trong của nó thay đổi. Nó xuất hiện như thể đối tượng đã thay đổi lớp của nó.</li>
	<li>Tài liệu ủy quyền công việc cho một đối tượng trạng thái.</li>
</ul>

<li>Khác nhau:</li>	
<ul>
	<li>Số lượng trạng thái là rất lớn và mã của trạng thái cụ thể thường xuyên thay đổi.</li>
	<li>State pattern cho phép bạn trích xuất các nhánh của các điều kiện này thành các phương thức của các lớp trạng thái tương ứng</li>
	<li>State pattern cho phép bạn soạn cấu trúc phân cấp của các lớp trạng thái và giảm sự trùng lặp bằng cách trích xuất mã chung vào các lớp cơ sở trừu tượng.</li>
</ul>
</ul>


**Strategy**
```
	   public boolean dispatchKeyEvent(KeyEvent event) {
	// See whether the player view wants to handle media or DPAD keys events.
	return playerView.dispatchKeyEvent(event) || super.dispatchKeyEvent(event);
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li> Xác định một nhóm thuật toán, đặt mỗi thuật toán vào một lớp riêng biệt và làm cho các đối tượng của chúng có thể hoán đổi cho nhau.</li>
	<li>Mỗi thuật toán định tuyến có thể được trích xuất thành lớp riêng của nó bằng một buildRoute phương pháp duy nhất </li>
</ul>

<li>Khác nhau:</li>	
<ul>
	<li>Gián tiếp thay đổi hành vi của đối tượng trong thời gian chạy bằng cách liên kết nó với các đối tượng con khác nhau có thể thực hiện các nhiệm vụ con cụ thể theo những cách khác nhau.</li>
	<li>Trích xuất các hành vi khác nhau thành một hệ thống phân cấp lớp riêng biệt và kết hợp các lớp ban đầu thành một, do đó giảm mã trùng lặp</li>
	<li>Tách biệt mã, dữ liệu nội bộ và các phần phụ thuộc của các thuật toán khác nhau khỏi phần còn lại của mã</li>
	<li>Loại bỏ điều kiện như vậy bằng cách trích xuất tất cả các thuật toán thành các lớp riêng biệt, tất cả đều triển khai cùng một giao diện</li>
</ul>
</ul>


**Template Method**
```
	 public void onClick(View view) {
	if (view == selectTracksButton
    	&& !isShowingTrackSelectionDialog
    	&& TrackSelectionDialog.willHaveContent(trackSelector)) {
  	isShowingTrackSelectionDialog = true;
  	TrackSelectionDialog trackSelectionDialog =
      	TrackSelectionDialog.createForTrackSelector(
          	trackSelector,
          	/* onDismissListener= */ dismissedDialog -> isShowingTrackSelectionDialog = false);
      trackSelectionDialog.show(getSupportFragmentManager(), /* tag= */ null);
	}
  }
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Xác định khung của một thuật toán trong lớp cha nhưng cho phép các lớp con ghi đè các bước cụ thể của thuật toán mà không thay đổi cấu trúc của nó.</li>
	<li>Chia nhỏ thuật toán thành các bước, cho phép các lớp con ghi đè các bước này nhưng không phải là phương thức thực.</li>
</ul>

<li>Khác nhau:</li>
<ul>
	<li>Khách hàng chỉ mở rộng các bước cụ thể của một thuật toán, nhưng không mở rộng toàn bộ thuật toán hoặc cấu trúc của nó.</li>
	<li>Mã khác nhau giữa các lớp con có thể vẫn còn trong các lớp con.</li>
</ul>
</ul>

**Visitor**
```
	 protected boolean initializePlayer() {
	if (player == null) {
  	Intent intent = getIntent();
 
  	mediaItems = createMediaItems(intent);
  	if (mediaItems.isEmpty()) {
    	return false;
  	}
```
<ul>
<li>Giống nhau:</li>
<ul>
	<li>Tách các thuật toán khỏi các đối tượng mà chúng hoạt động trên đó.</li>
	<li>Mỗi phương thức có thể nhận các đối số thuộc các kiểu khác nhau</li>
	<li>Cung cấp cho phương thức của khách truy cập quyền truy cập vào tất cả dữ liệu cần thiết có trong đối tượng.</li>
	<li>Double Dispatch , giúp thực thi phương thức thích hợp trên một đối tượng mà không cần các điều kiện rườm rà.</li>
</ul>

<li>Khác nhau:</li>	
<ul>
	<li>Một đối tượng khách triển khai một số biến thể của cùng một thao tác, tương ứng với tất cả các lớp mục tiêu.</li>
	<li>Trích xuất tất cả các hành vi khác vào một tập hợp các lớp khách truy cập.</li>
	<li>Chấp nhận các đối tượng của các lớp có liên quan, để trống phần còn lại.</li>
</ul>
</ul>


**Kết luận: Nhìn chung các mẫu thiết kế giống nhau không có sự khác biệt nhiều.**
