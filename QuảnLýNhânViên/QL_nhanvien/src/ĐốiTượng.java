/**
 * @tác giả: Nguyễn Đức Hoàng Java2201A(LT0822A). ITPlus
 * @tóm tắt: Chương trình phần mềm hướng đối tượng Java, Quản Lý Nhân Viên.
 */
import java.io.Serializable;
import java.time.*;

abstract// trừu tượng
class// lớp
ĐốiTượng implements Serializable {

    LocalDate NgàyTạo;
    LocalDate NgàySửa;
    String ThôngBáoLỗi;

    abstract void Nhập();

    abstract void Xuất();

    String Lỗi() {
        return this.ThôngBáoLỗi;
    }
}
