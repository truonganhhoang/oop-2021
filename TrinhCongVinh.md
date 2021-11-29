#Link: https://github.com/kamranahmedse/design-patterns-for-humans.git

# Nhóm

- Trịnh Công Vinh
- Trương Văn Độ
- Mai Hoàng Anh

- Repo này không phải là một dự án thực tế nhưng lại là một repo hay để hiểu thêm về các mẫu thiết kế trong lập trình hướng đối tượng. Điểm mạnh của repo này là có giải thích rõ ràng, có code minh họa và có đưa ví dụ liên quan đến thực tế để người đọc nắm rõ hơn thay vì một cách hàn lâm làm cho những người mới bắt đầu tìm hiểu về các mẫu lập trình bị khó hiểu và không biết tại sao lại phải sử dụng các mẫu thiết kế đó.
- repo này đã chỉ ra một cách rõ ràng về những hiểu lầm mà những người mới bát đầu tìm hiểu thường bị mắc phải, được trích nguyên văn sau đây:
** 
> Design patterns are not a silver bullet to all your problems.
> Do not try to force them; bad things are supposed to happen, if done so.
> Keep in mind that design patterns are solutions to problems, not solutions finding problems; so don't overthink.
> If used in a correct place in a correct manner, they can prove to be a savior; or else they can result in a horrible mess of a code.
**
- 23 mẫu thiết kế được chia thành 3 nhóm chính là:
- Creational
- Structural
- Behavioral

# Nhóm thứ nhất Creational
## Simple factory, factory method, factory abstract
- Giải thích được định nghĩa, lấy ví dụ thực tế, rõ ràng dễ hiểu.
- Đưa ra được khi nào nên sử dụng trong thực tế.

## Tác giả đã giải thích được sự khác nhau giữa factory method và factory abstract.
### factory method: được dùng để tạo ra một object nhưng mà lớp con sẽ quyết định coi lớp cha nào sẽ được khởi tạo
interface Interviewer
{
    public function askQuestions();
}

class Developer implements Interviewer
{
    public function askQuestions()
    {
        echo 'Asking about design patterns!';
    }
}

class CommunityExecutive implements Interviewer
{
    public function askQuestions()
    {
        echo 'Asking about community building';
    }
}

tạo thêm một abstract class HiringManager

abstract class HiringManager
{

    // Factory method
    abstract protected function makeInterviewer(): Interviewer;

    public function takeInterview()
    {
        $interviewer = $this->makeInterviewer();
        $interviewer->askQuestions();
    }
}
thêm một class con
class DevelopmentManager extends HiringManager
{
    protected function makeInterviewer(): Interviewer
    {
        return new Developer();
    }
}

class MarketingManager extends HiringManager
{
    protected function makeInterviewer(): Interviewer
    {
        return new CommunityExecutive();
    }
}
trong hàm main:
$devManager = new DevelopmentManager();
$devManager->takeInterview(); // Output: Asking about design patterns

$marketingManager = new MarketingManager();
$marketingManager->takeInterview(); // Output: Asking about community building.

Có thể thấy dựa trên lớp con mà lớp cha sẽ hỏi câu hỏi khác nhau.

### factory abstract: định nghĩa một interface hoặc lớp trừu tượng (abstract) để tạo ra các họ hàng của các đối tượng liên quan (hoặc phụ thuộc) mà không cần chỉ rõ các lớp con cụ thể của chúng.
- Nói một cách dễ hiểu trong repo này tác giả đã lấy ví dụ về cửa gỗ và thợ làm cửa gỗ, hay cửa nhôm thì sẽ đi với thợ sửa cửa nhôm.
- Hai class Door và DoorFittingExpert sau khi được khởi tạo thì sẽ được gọi thông qua các con interface class DoorFactory và được sử dụng trong hàm main cụ thể như sau.
$woodenFactory = new WoodenDoorFactory();

$door = $woodenFactory->makeDoor();
$expert = $woodenFactory->makeFittingExpert();

$door->getDescription();  // Output: I am a wooden door
$expert->getDescription(); // Output: I can only fit wooden doors

// Same for Iron Factory
$ironFactory = new IronDoorFactory();

$door = $ironFactory->makeDoor();
$expert = $ironFactory->makeFittingExpert();

$door->getDescription();  // Output: I am an iron door
$expert->getDescription(); // Output: I can only fit iron doors

Có thể thấy với mỗi loại cửa khác nhau sẽ gọi đến những gì liên quan đến nó.


**Giống nhau:**

- Có 23 mẫu thiết kế giống vơi mẫu chuẩn sử dụng ngông ngữ PHP

- Mỗi design pattern có đầy đủ các class , cấu trúc , code dễ đọc dễ hiểu

- Giải thích rõ ràng dễ hiểu, Code tường minh dễ hiểu.

**Khác nhau:**

- Không có sự khác nhau, đây là một mẫu thiết kế gần như giống hệt so với mẫu chuẩn về mọi mặt.
