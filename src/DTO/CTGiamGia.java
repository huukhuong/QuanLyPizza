package DTO;

public class CTGiamGia {
    private String maGiam;
    private String maSP;
    private int phanTramGiam;

    public CTGiamGia() {
    }

    public CTGiamGia(String maGiam, String maSP, int phanTramGiam) {
        this.maGiam = maGiam;
        this.maSP = maSP;
        this.phanTramGiam = phanTramGiam;
    }

    public String getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(String maGiam) {
        this.maGiam = maGiam;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
}
