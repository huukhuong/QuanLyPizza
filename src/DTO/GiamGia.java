package DTO;

import java.util.Date;

public class GiamGia {
    private int maGiam;
    private Date ngayBD;
    private Date ngayKT;

    public GiamGia() {
    }

    public GiamGia(int maGiam, Date ngayBD, Date ngayKT) {
        this.maGiam = maGiam;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public int getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(int maGiam) {
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
