/**
 * @tác giả: Nguyễn Đức Hoàng Java2201A(LT0822A). ITPlus
 * @tóm tắt: Chương trình phần mềm hướng đối tượng Java, Quản Lý Nhân Viên.
 */
import java.util.Scanner;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

class// lớp
NhânViên extends ĐốiTượng {

    String TênNV;
    int NămSinh;
    float CânNặng;
    char NhómMáu;
    Boolean GiớiTính;
    Boolean CaLàm;
    LocalDate NgàyVàoLàm;

    @Override
    void Nhập() {

        var scan = new Scanner(System.in);

        out.print("\n Nhập Tên Nhân viên: ");
        this.TênNV = scan.nextLine();

        out.print("\n Nhập Năm Sinh: ");
        this.NămSinh = scan.nextInt();

        out.print("\n Nhập Cân Nặng: ");
        this.CânNặng = scan.nextFloat();

        out.print("\n Nhập nhóm máu (A,B,O): ");
        this.NhómMáu = scan.next().charAt(0);

        out.print("\n Giới tính (true=Nam/false=Nữ): ");
        this.GiớiTính = scan.nextBoolean();

        out.print("\n Ca Làm (true=FullTime/false=PartTime): ");
        this.CaLàm = scan.nextBoolean();

        out.print("\n Ngày nhập trường (ví dụ: 23/12/1997): ");
        var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.NgàyVàoLàm = LocalDate.parse(scan.next(), dtf);

    }

    @Override
    void Xuất() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'Xuất'");
    }

    /**
     * Kiểm tra tính hợp lệ về mặt dữ liệu
     * của một đối tượng: Sinh Viên
     * 
     */
    Boolean HợpLệ() {
        var hợp_lệ = true;

        this.ThôngBáoLỗi = "";

        if (this.TênNV.length() < 2) {
            hợp_lệ = false;
            this.ThôngBáoLỗi += "\n ->Tên phải từ 2 kí tự trở lên.\n";
        }

        if (this.TênNV.length() > 100) {
            hợp_lệ = false;
            this.ThôngBáoLỗi += "\n ->Tên phải không quá 100 kí tự.\n";
        }

        if (this.CânNặng < 0) {
            hợp_lệ = false;
            this.ThôngBáoLỗi += "\n ->Cân nặng không được âm(<0).\n";
        }

        if (this.NămSinh < 1900) {
            hợp_lệ = false;
            this.ThôngBáoLỗi += "\n ->Bạn đã quá tuổi đi làm.\n";
        }

        int currentYear = Year.now().getValue();
        if (this.NămSinh > currentYear) {
            hợp_lệ = false;
            this.ThôngBáoLỗi += "\n ->Năm sinh không được lớn hơn năm hiện tại.\n";
        }

        LocalDate currentDate = LocalDate.now();
        if (this.NgàyVàoLàm.isAfter(currentDate)) {
            hợp_lệ = false;
            this.ThôngBáoLỗi += "\n ->Ngày tháng năm vào làm không được lớn hơn ngày tháng năm hiện tại.\n";
        }

        return hợp_lệ;
    }

    String Lỗi() {
        return this.ThôngBáoLỗi;
    }
}// kết thúc lớp
