package BUS;

import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhap;
import java.util.ArrayList;

public class CTPhieuNhapBUS {

    private ArrayList<CTPhieuNhap> listPhieuNhap = null;
    private CTPhieuNhapDAO ctPhieuNhapDAO = new CTPhieuNhapDAO();

    public CTPhieuNhapBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listPhieuNhap = ctPhieuNhapDAO.getListCTPhieuNhap();
    }

    public ArrayList<CTPhieuNhap> getListPhieuNhap() {
        if (listPhieuNhap == null) {
            docDanhSach();
        }
        return null;
    }

    public boolean luuCTPhieuNhap(CTPhieuNhap ctpn) {
        return ctPhieuNhapDAO.addCTPhieuNhap(ctpn);
    }
}
