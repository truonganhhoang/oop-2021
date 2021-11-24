# Lớp: INT2204_3
# Thành viên:
1. Nguyễn Hoàng Long - 18020805
2. Trần Trung Hiếu - 19020077
3. Văn Quốc Dũng - 19020530

### Repo: https://github.com/youlookwhat/DesignPattern/tree/master/app/src/main/java/com/example/jingbin/designpattern

# BÁO CÁO SO SÁNH MẪU THIẾT KẾ

## **I. Nhóm Creational**

### Prototype:
- Sử dụng mẫu thiết kế Prototype pattern: là một trong những Creational pattern, có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new.
- Prototype Pattern được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại.
- Giống nhau: 
    + Abstract class Shape implement Cloneable.
    + Một class kế thừa lại lớp có sẵn là AppCompatActivity.
    + 3 lớp Circle, Rectangle, Square kế thừa lại lớp Shape.

- Khác nhau:
    + Không có sự khác nhau.
- Code:

'''
     public abstract class Shape implements Cloneable {
        @Override
        public Object clone() {
            Object object = null;
            try {
                object = super.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("--", e.getMessage());
            }
            return object;
        }
    }
'''

'''
    public class PrototypeActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ActivityPrototypeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_prototype);
            setTitle("原型模式");
            binding.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.PROTOTYPE_DEFINE));
            binding.btRectangle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Shape shapeCache = ShapeCache.getShape("2");
                    Log.e("Prototype", "Shape: " + shapeCache.type);
                }
            });
            binding.btSquare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Shape shapeCache = ShapeCache.getShape("3");
                    Log.e("Prototype", "Shape: " + shapeCache.type);
                }
            });
        }
      }
'''
