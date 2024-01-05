
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.System.out;
import java.time.format.DateTimeFormatter;

class// lớp
QuảnLý implements // triển khai giao diện hàm chức năng
        DS<NhânViên> {

    // Khai báo biến chứa danh sách
    List<NhânViên> ds;

    public QuảnLý() {
        // khởi tạo danh sách
        ds = new ArrayList<NhânViên>();
    }

    // dl=dữ liệu
    @Override
    public void Thêm() {
        var dl = new NhânViên();
        // Tạo sinh viên mới

        dl.Nhập();
        // yêu cầu sinh viên cầm bút lên, điền thông tin của mình vào form

        // kiểm duyệt dữ liệu: validate
        if// nếu
        (dl.HợpLệ()) {
            ds.add(dl);
            out.print("\n Đã thêm nhân viên thành công.\n");
        } else// ngược lại
        {
            out.print("\n Lỗi nhập liệu dữ liệu không hợp lệ!\n");
            out.print(dl.Lỗi());
            return;
        }
    }

    // dl=dữ liệu
    @Override
    public void Sửa() {

        int chỉ_số = 0;
        // vị trí của phần tử cần sửa trong danh sách

        this.Bảng();
        var scan = new Scanner(System.in);

        out.print("\n Nhập số thứ tự của nhân viên để sửa: ");
        int stt = scan.nextInt();

        chỉ_số = stt - 1;
        var dl = new NhânViên();
        // Tạo nhân viên mới

        dl.Nhập();
        // yêu cầu nhân viên cầm bút lên, điền thông tin của mình vào form

        // kiểm duyệt dữ liệu: validate
        if// nếu
        (dl.HợpLệ()) {
            // update vào bản ghi cũ
            ds.set(chỉ_số, dl);
            out.print("\n Đã sửa nhân viên thành công. \n");

        } else// ngược lại
        {
            out.print("\n Lỗi nhập liệu dữ liệu không hợp lệ!\n");
            out.print(dl.Lỗi());
            return;
        }

    }

    @Override
    public void Xóa() {

        int chỉ_số = 0;
        // vị trí của phần tử cần sửa trong danh sách
        // Kiểm tra chỉ số để xóa xem có hợp lệ

        this.Bảng();
        var scan = new Scanner(System.in);

        out.print("\n Nhập số thứ tự của nhân viên để xóa: ");
        int stt = scan.nextInt();// Nếu lỗi thì dùng cách 2 bên dưới:

        chỉ_số = stt - 1;
        ds.remove(chỉ_số);
        out.print("\n Xóa nhân viên thành công. \n");
    }

    // dl=dữ liệu
    @Override
    public void Xếp() {

        out.print("\n  Sắp Xếp Danh Sách Nhân Viên Giảm Dần Theo Cân Nặng: \n");

        ds.sort(Comparator.comparing(dl -> dl.CânNặng));
        // sau đó đảo ngược danh sách:
        Collections.reverse(ds);

        Bảng();
        out.print("\n Đã xắp xếp nhân viên thành công. \n");
    }

    // dl=dữ liệu
    @Override
    public void Nhóm() {

        out.print("\n Phân Loại Nân Viên Theo Nhóm Máu: ");
        Map<Character, List<NhânViên>> các_nhóm = ds.stream().collect(Collectors.groupingBy(dl -> dl.NhómMáu));

        // Đếm xem mỗi nhóm bao nhiêu phần tử
        out.print("\n Đếm số lượng từng nhóm: ");
        for// với mỗi nhóm
        (Character key : các_nhóm.keySet()) {

            out.printf("\n Nhóm máu %c có %d nhân viên.",
                    key, các_nhóm.get(key).size());

            int stt = 0;
            for// với mỗi phần tử trong nhóm
            (NhânViên dl : các_nhóm.get(key)) {
                stt++;
                if (stt == 1)
                    Cột();
                Dòng(dl, stt);
            }

        }
        out.print("\n Đã phân loại nhân viên thành công. \n");

    }

    // dl=dữ liệu
    @Override
    public void Tìm() {
        out.print("\n Tìm Nhân Viên Theo Tên Và Khoảng Cân Nặng.");

        var scan = new Scanner(System.in);

        out.print("\n Nhập tên nhân viên muốn tìm: ");
        var tên = scan.next();

        out.print("\n Cân nặng nhỏ nhất: ");
        float cânnặng_min = scan.nextFloat();

        out.print("\n Cân nặng lớn nhất: ");
        float cânnặng_max = Float.parseFloat(scan.next());

        List<NhânViên> kq;
        // Tìm theo từng tiêu chí một
        kq = ds.stream().filter(dl -> dl.TênNV.contains(tên))
                .filter(dl -> dl.CânNặng <= cânnặng_max)
                .filter(dl -> dl.CânNặng >= cânnặng_min)
                .collect(Collectors.toList());

        // rồi in ra kết quả tìm kiếm
        int stt = 0;
        for (NhânViên dl : kq) {
            stt++;
            if (stt == 1)
                Cột();
            Dòng(dl, stt);
        }
        out.print("\n Tìm nhân viên thành công. \n");
    }

    // dl=dữ liệu
    @Override
    public void Min() {
        out.print("\n Nhân viên có cân nặng nhỏ nhất: ");
        NhânViên minDL = ds.stream()
                .min((dl1, dl2) -> Float.compare(dl1.CânNặng, dl2.CânNặng))
                .orElse(null);

        int stt = 0;
        for// với mỗi
        (NhânViên dl : ds) {
            if// nếu
            (minDL.CânNặng == dl.CânNặng) {
                stt++;
                if (stt == 1)
                    Cột();
                // hiện
                Dòng(dl, stt);
            }
        }
        out.print("\n Tìm nhân viên thành công. \n");
    }

    // dl=dữ liệu
    @Override
    public void Max() {
        out.print("\n Nhân viên có cân nặng lớn nhất: ");
        NhânViên maxDL = ds.stream()
                .max((dl1, dl2) -> Float.compare(dl1.CânNặng, dl2.CânNặng))
                .orElse(null);

        int stt = 0;
        for// với mỗi
        (NhânViên dl : ds) {
            if// nếu
            (maxDL.CânNặng == dl.CânNặng) {
                stt++;
                if (stt == 1)
                    Cột();
                // hiện
                Dòng(dl, stt);
            }
        }
        out.print("\n Tìm nhân viên thành công. \n");

    }

    // dl=dữ liệu
    @Override
    public void Tbc() {
        double tbc = ds.stream().collect(Collectors.averagingDouble(dl -> dl.CânNặng));
        out.printf("\n Cân nặng trung bình của nhân viên là: %.2f \n", tbc);
    }

    @Override
    public void Cột() {
        out.print(
                "\n+--------------------------------------------------------------------------------------------------+");
        out.print(
                "\n| STT | TÊN CỦA NHÂN VIÊN | NĂM SINH | CÂN NẶNG | NHÓM MÁU | GIỚI TÍNH | CA VÀO LÀM | NGÀY VÀO LÀM |");
        out.print(
                "\n+--------------------------------------------------------------------------------------------------+");

    }

    // dl=dữ liệu
    @Override
    public void Dòng(NhânViên dl, int stt) {

        // Biến phái sinh
        String GiớiTính_Text = (dl.GiớiTính == true) ? "Nam" : "Nữ";

        String CaLàm_Text = (dl.CaLàm == true) ? "FullTime" : "PartTime";

        var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String NgàyVàoLàm_Text = dtf.format(dl.NgàyVàoLàm);

        out.printf("\n| %3d | %-17s | %8d | %8.1f | %8s | %9s | %10s | %12s |",
                stt, dl.TênNV, dl.NămSinh, dl.CânNặng, dl.NhómMáu, GiớiTính_Text, CaLàm_Text, NgàyVàoLàm_Text);
        out.print(
                "\n+--------------------------------------------------------------------------------------------------+");
    }

    @Override
    public void Bảng() {

        out.print("\n Bảng Dữ Liệu Nhân Viên:");

        // in cột
        Cột();

        // in các dòng
        // @todo Nếu dữ liệu dòng NULL thì sao ?
        for (int i = 0; i < ds.size(); i++) {
            int stt = i + 1;
            NhânViên dữ_liệu = ds.get(i);
            Dòng(dữ_liệu, stt);
        }
    }

    /**
     * @abstract Lưu dữ liệu mảng vào tệp, với định dạng DAT
     *           Các dị thường có thể xảy ra:
     *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
     *           không hỗ trợ
     *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *           FileNotFoundException
     */
    @Override
    public void GhiFile() {

        var scan = new Scanner(System.in);
        try {

            // Đường dẫn tĩnh để test nhanh
            String filePath = "C:\\Users\\Public\\nhanvien.dat";

            // Đường dẫn động nhập từ bàn phím:
            // ví dụ: c:/users/public/mang.dat
            out.print("\n Nhập đường dẫn tệp file cần ghi dữ liệu: ");
            filePath = scan.next();

            var fos = new FileOutputStream(filePath); // FileNotFoundException
            var oos = new ObjectOutputStream(fos); // IOException
            oos.writeObject(ds);
            oos.close();

        } catch (Exception ex) {
            out.print("\n Lỗi tệp file hoặc vào ra dữ liệu: ");
            ex.printStackTrace();
        } finally {

        }

        System.out.println("\n Đã ghi file .dat");
    }

    /**
     * @abstract Đọc dữ liệu tệp nhị phân DAT và chuyển đổi nó thành mảng
     *           Các dị thường có thể xảy ra:
     *           -IOException: Lỗi vào ra dữ liệu
     *           không hỗ trợ
     *           -FileNotFoundException: Lỗi Không tìm thấy tệp trên ổ cứng
     * 
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *           FileNotFoundException
     * 
     *           Lỗi tệp file hoặc mã hóa bộ kí tự UTF8:
     *           java.lang.NullPointerException: Cannot invoke
     *           "java.lang.Boolean.boolea
     *           ava.lang.Boolean.booleanValue()" because "dt.Giới" is null
     */
    @SuppressWarnings("unchecked") // loại bỏ cảnh báo chỗ: ois.readObject();
    public void ĐọcFile() {
        var scan = new Scanner(System.in);

        try {

            // Đường dẫn tĩnh để test nhanh
            String filePath = "C:\\Users\\Public\\nhanvien.dat";

            // Đường dẫn động nhập từ bàn phím:
            // ví dụ: c:/users/public/mang.dat
            out.print("\n Nhập đường dẫn tệp file cần đọc dữ liệu: ");
            filePath = scan.next();

            var fis = new FileInputStream(filePath); // FileNotFoundException
            var ois = new ObjectInputStream(fis); // IOException

            ds = (List<NhânViên>) ois.readObject();
            ois.close();

            this.Bảng();
        } catch (Exception e) {
            out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
            e.printStackTrace();
        }

    }// kết thúc hàm

}// kết thúc lớp
