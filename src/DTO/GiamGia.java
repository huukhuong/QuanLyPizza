package DTO;

import java.util.Date;

public class GiamGia {
    private int maGiam;
    private String tenChuongTrinh;
    private Date ngayBD;
    private Date ngayKT;
    private int phanTramGiam;
    private int dieuKien;

    public GiamGia() {
    }

    public GiamGia(int maGiam, String tenChuongTrinh, Date ngayBD, Date ngayKT, int phanTramGiam, int dieuKien) {
        this.maGiam = maGiam;
        this.tenChuongTrinh = tenChuongTrinh;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.phanTramGiam = phanTramGiam;
        this.dieuKien = dieuKien;
    }

    public int getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(int maGiam) {
        this.maGiam = maGiam;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public int getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(int dieuKien) {
        this.dieuKien = dieuKien;
    }
    
        
}
