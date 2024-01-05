/**
 * Giao Diện Hàm Chức Năng.
 * (mang tính khái lược, chung chung: kiểu T chưa biết,
 * nó có thể là SinhVien, Dog, Cat, v.v...).
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
