package BUS;

import DAO.SanPhamDAO;
import DTO.SanPham;
import java.util.ArrayList;

public class SanPhamBUS {

    private ArrayList<SanPham> listSanPham;
    private SanPhamDAO spDAO = new SanPhamDAO();

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public ArrayList<SanPham> getListSanPham() {
        listSanPham = spDAO.getListSanPham();
        return listSanPham;
    }

    public SanPham getSanPham(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maSP = Integer.parseInt(ma);
                return spDAO.getSanPham(maSP);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<SanPham> getSanPhamTheoLoai(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maLoai = Integer.parseInt(ma);
                return spDAO.getSanPhamTheoLoai(maLoai);
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    public String getAnh(String ma) {
        int maSP = Integer.parseInt(ma);
        return spDAO.getAnh(maSP);
    }
    
    public void capNhatSoLuongSP(int ma, int soLuongMat) {
        spDAO.capNhatSoLuongSP(ma, soLuongMat);
    }
}
