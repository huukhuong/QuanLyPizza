package DTO;

public class TaiKhoan {

    private String maNhanVien;
    private String matKhau;
    private String chucVu;

    public TaiKhoan() {
    }

    public TaiKhoan(String maNhanVien, String matKhau, String chucVu) {
        this.maNhanVien = maNhanVien;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
