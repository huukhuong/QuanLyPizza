package DTO;

public class CTGiamGia {
    private int maGiam;
    private int maSP;
    private int phanTramGiam;

    public CTGiamGia() {
    }

    public CTGiamGia(int maGiam, int maSP, int phanTramGiam) {
        this.maGiam = maGiam;
        this.maSP = maSP;
        this.phanTramGiam = phanTramGiam;
    }

    public int getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(int maGiam) {
        this.maGiam = maGiam;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
}
