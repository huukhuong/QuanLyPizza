package QuanLyPizza.BUS;

import MyCustom.MyDialog;
import QuanLyPizza.DAO.PhieuNhapDAO;
import QuanLyPizza.DTO.PhieuNhap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public PhieuNhap timPhieuNhap(String maPN) {
        int ma = Integer.parseInt(maPN);
        for (PhieuNhap pn : listPhieuNhap) {
            if (pn.getMaPN() == ma) {
                return pn;
            }
        }
        return null;
    }

    public ArrayList<PhieuNhap> getListPhieuNhapTheoGia(String giaThap, String giaCao) {
        try {
            int min = Integer.parseInt(giaThap);
            int max = Integer.parseInt(giaCao);
            if (max < min) {
                new MyDialog("Hãy nhập khoảng giá phù hợp!", MyDialog.ERROR_DIALOG);
                return null;
            }
            ArrayList<PhieuNhap> result = new ArrayList<>();
            for (PhieuNhap pn : listPhieuNhap) {
                if (pn.getTongTien() <= max && pn.getTongTien() >= min) {
                    result.add(pn);
                }
            }
            return result;
        } catch (Exception e) {
            new MyDialog("Hãy nhập số nguyên cho khoảng giá!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }

    public ArrayList<PhieuNhap> getListPhieuNhapTheoNgay(String tuNgay, String denNgay) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            
            Date min = sdf.parse(tuNgay);
            Date max = sdf.parse(denNgay);
            if (max.before(min)) {
                new MyDialog("Hãy nhập khoảng ngày phù hợp!", MyDialog.ERROR_DIALOG);
                return null;
            }
            ArrayList<PhieuNhap> result = new ArrayList<>();
            for (PhieuNhap pn : listPhieuNhap) {
                if (pn.getNgayLap().after(min) && pn.getNgayLap().before(max)) {
                    result.add(pn);
                }
            }
            return result;
        } catch (Exception e) {
            new MyDialog("Hãy nhập ngày hợp lệ (dd/MM/yyy)!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }

}
