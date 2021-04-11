package BUS;

import DAO.LoaiDAO;
import DTO.LoaiSP;
import java.util.ArrayList;

public class LoaiBUS {

    private LoaiDAO loaiDAO = new LoaiDAO();
    private ArrayList<LoaiSP> listLoai = new ArrayList<>();

    public ArrayList<LoaiSP> getDanhSachLoai() {
        return loaiDAO.getDanhSachLoai();
    }
}
