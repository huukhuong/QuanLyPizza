package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien;
import java.util.ArrayList;

public class NhanVienBUS {

    private NhanVienDAO nvDAO = new NhanVienDAO();
    private ArrayList<NhanVien> listNhanVien = new ArrayList<>();

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        return nvDAO.getDanhSachNhanVien();
    }

}
