package DTO;

public class KhachHang {
    private int maKH;
    private String hoTen;
    private String gioiTinh;
    private int tongChiTieu;

    public KhachHang() {
    }

    public KhachHang(int maKH, String hoTen, String gioiTinh, int tongChiTieu) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tongChiTieu = tongChiTieu;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(int tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }
}
