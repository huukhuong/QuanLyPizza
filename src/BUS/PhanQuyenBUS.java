package BUS;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyen;

import java.util.ArrayList;

public class PhanQuyenBUS {

    public static PhanQuyen quyenTK = null;
    private PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
    private ArrayList<PhanQuyen> listPhanQuyen = null;

    public void docDanhSachQuyen() {
        this.listPhanQuyen = phanQuyenDAO.getListQuyen();
    }

    public void kiemTraQuyen(String quyen) {
        quyenTK = phanQuyenDAO.getQuyen(quyen);
    }

    public ArrayList<PhanQuyen> getListQuyen() {
        if (listPhanQuyen == null)
            docDanhSachQuyen();
        return this.listPhanQuyen;
    }

}
