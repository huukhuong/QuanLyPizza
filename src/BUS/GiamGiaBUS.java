package BUS;

import DAO.GiamGiaDAO;
import DTO.GiamGia;

import java.util.ArrayList;

public class GiamGiaBUS {

    private ArrayList<GiamGia> listGiamGia = new ArrayList<>();
    private GiamGiaDAO giamGiaDAO = new GiamGiaDAO();

    public GiamGiaBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listGiamGia = giamGiaDAO.getDanhSachMaGiam();
    }

    public ArrayList<GiamGia> getDanhSachGiamGia() {
        if (this.listGiamGia == null)
            docDanhSach();
        return this.listGiamGia;
    }

}
