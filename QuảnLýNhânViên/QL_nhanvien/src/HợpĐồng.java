/**
 * @tác giả: Nguyễn Đức Hoàng Java2201A(LT0822A). ITPlus
 * @tóm tắt: Chương trình phần mềm hướng đối tượng Java, Quản Lý Nhân Viên.
 */
interface DS<K> {

    // cụm 1
    void Thêm();

    void Sửa();

    void Xóa();

    // cụm 2
    void Min();

    void Max();

    void Tbc();

    // cụm 3
    void Xếp();

    void Nhóm();

    void Tìm();

    // cụm 4
    void GhiFile();

    void ĐọcFile();

    // hàm phụ trợ
    void Cột();

    void Dòng(K đt, int stt);

    void Bảng();

}
