package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;
import java.util.ArrayList;

public class PhieuNhapBUS {

    private PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    private ArrayList<PhieuNhap> listPhieuNhap = null;

    public PhieuNhapBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listPhieuNhap = phieuNhapDAO.getListPhieuNhap();
    }

    public ArrayList<PhieuNhap> getListPhieuNhap() {
        if (listPhieuNhap == null) {
            docDanhSach();
        }
        return listPhieuNhap;
    }

    public boolean themPhieuNhap(String nhaCungCap, String nhanVien, int tongTien) {
        String[] NCC = nhaCungCap.split(" - ");
        String[] NV = nhanVien.split(" - ");
        
        int maNCC = Integer.parseInt(NCC[0]);
        int maNV = Integer.parseInt(NV[0]);
        
        PhieuNhap pn = new PhieuNhap();
        pn.setMaNCC(maNCC);
        pn.setMaNV(maNV);
        pn.setTongTien(tongTien);

        return phieuNhapDAO.themPhieuNhap(pn);
    }

    public int getLastID() {
        return phieuNhapDAO.getLastID();
    }

}
