package DTO;

public class PhieuNhap {
    private int maPN;
    private int maNCC;
    private int maNV;
    private String tongTien;

    public PhieuNhap() {
    }

    public PhieuNhap(int maPN, int maNCC, int maNV, String tongTien) {
        this.maPN = maPN;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.tongTien = tongTien;
    }

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }
}
