
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
