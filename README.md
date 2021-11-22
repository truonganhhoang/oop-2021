# oop-2021
Môn học Lập trình hướng đối tượng với Java

Nhóm gồm các thành viên:
- Nguyễn Anh Đức 20021336
- Nguyễn Thị Thúy Quỳnh 20021426
- Đặng Thành Trung 20021455


Các repo đã tìm được và phân tích:

+ Repo 1: Link https://github.com/shuleisanshi/myblog

  Mẫu thiết kế: Factory trong package service, mục đích tạo các lớp kế thừa các giao diện 
    (ở đây đặc biệt ở chỗ: với mỗi giao diện chỉ có 1 lớp kế thừa)
  
 
 
+ Repo 2: Link https://github.com/simple-android-framework/android_design_patterns_analysis
 
  Tóm tắt về đầy đủ 23 mẫu thiết kế
  
  Có code minh họa theo 2 mẫu thiết kế:
  - Command
  - Iterator

+ Repo 3: Link https://github.com/braisdom/ObjectiveSql
  
  Dựa vào mẫu thiết kế Active record khuyến khích phát triển nhanh chóng và làm sạch, mã có ít nhất và quy ước về cấu hình.

+ Repo 4: Link https://github.com/Anuken/Mindustry
+  Sử dụng mẫu thiết kế:
+   Strategy với:
+	  interface: SlotAssignmentStrategy,
+	  các ConcreteStategy: BoundedSlotAssignmentStrategy, DistanceAssignmentStrategy, FreeSlotAssignmentStrategy
	  BoundedSlotAssignmentStrategy có concrete: SoftRoleSlotAssignmentStrategy
+	Factory Method:
+	  Creator: FormationPattern
+	  Concretecreator: CircleFormation, SquareFormation
+	Abstract Factory:
+	  UnitController->AIController
+	  AIController->BuilderAI, DefenderAI, FlyingAI, FormationAI, GroundAI, HugAI, LogicAI, MinerAI, RepairAI
+	Facade:
+	  facade: ContentList
+	  subsystems: Blocks, Bullets, Items, Liquids, Loadouts, PLanets, SectorPresets, StatusEffects, TechTree, UnitTypes, Weathers
+	-> dễ dang quản lý, điều hướng
