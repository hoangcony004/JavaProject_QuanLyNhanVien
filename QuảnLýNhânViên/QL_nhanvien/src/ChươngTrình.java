
/**
 * @tác giả: Nguyễn Đức Hoàng Java2201A(LT0822A). ITPlus
 * @tóm tắt: Chương trình phần mềm hướng đối tượng Java, Quản Lý Nhân Viên.
 */
import java.util.Scanner;
import static java.lang.System.out;

public class ChươngTrình {
    public static void main(String[] args) {

        DS<NhânViên> ds = new QuảnLý(); // Chỉ định người thực hiện hợp đồng

        while (true) {
            out.print("\n+-----------------------------------------+");
            out.print("\n|            QUẢN LÝ NHÂN VIÊN      31       |");
            out.print("\n| (c) 2024.01.05 14h00. Nguyễn Đức Hoàng  |");
            out.print("\n+-----------------------------------------+");
            out.print("\n| 1.Thêm Mới | 2.Chỉnh Sửa | 3.Xoá Bỏ     |");
            out.print("\n+-----------------------------------------+");
            out.print("\n| 4.Nhỏ Nhất | 5.Lớn Nhất  | 6.Trung Bình |");
            out.print("\n+-----------------------------------------+");
            out.print("\n| 7.Sắp Xếp  | 8.Phân Loại | 9.Tìm Kiếm   |");
            out.print("\n+-----------------------------------------+");
            out.print("\n| 10.Lưu File | 11. Mở File | 0.Thoát     |");
            out.print("\n+-----------------------------------------+");

            out.print("\n Chọn menu: ");
            var scan = new Scanner(System.in);
            var menu = scan.nextInt();
            // scan.close();

            switch (menu) {
                case 1:
                    ds.Thêm();
                    break;
                case 2:
                    ds.Sửa();
                    break;
                case 3:
                    ds.Xóa();
                    break;
                case 4:
                    ds.Min();
                    break;
                case 5:
                    ds.Max();
                    break;
                case 6:
                    ds.Tbc();
                    break;
                case 7:
                    ds.Xếp();
                    break;
                case 8:
                    ds.Nhóm();
                    break;
                case 9:
                    ds.Tìm();
                    break;

                case 10:
                    ds.GhiFile();
                    break;
                case 11:
                    ds.ĐọcFile();
                    break;
                case 0:
                    out.print("\n Đang thoát...");
                    // Thread.sleep(3000);
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    out.print("\n Hãy nhập menu hợp lệ !");
                    break;
            }// kết thúc switch

            out.print("\n Bạn có muốn tiếp tục không ?");
            out.print("\n Ấn chữ 'k' để dừng chương trình hoặc phím bất kì để tiếp tục: ");
            char ck = scan.next().charAt(0);
            if (ck == 'k' || ck == 'K') {

                scan.close();
                System.exit(0);
            } else// ngược lại thì
                continue; // tiếp tục hiện menu

        } // kết thúc vòng lặp menu
    }// kết thúc main()
}// kết thúc lớp

