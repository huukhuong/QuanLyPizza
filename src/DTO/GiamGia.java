package DTO;

import java.util.Date;

public class GiamGia {
    private String maGiam;
    private Date ngayBD;
    private Date ngayKT;

    public GiamGia() {
    }

    public GiamGia(String maGiam, Date ngayBD, Date ngayKT) {
        this.maGiam = maGiam;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public String getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(String maGiam) {
        this.maGiam = maGiam;
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
}
