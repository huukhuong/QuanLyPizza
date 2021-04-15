package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.util.ArrayList;

public class KhachHangBUS {

    private ArrayList<KhachHang> listKhachHang = new ArrayList<>();
    private KhachHangDAO khachHangDAO = new KhachHangDAO();

    public ArrayList<KhachHang> getListKhachHang() {
        this.listKhachHang =  khachHangDAO.getListKhachHang();
        return listKhachHang;
    }

    public ArrayList<KhachHang> timKiemKhachHang(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHang> dskh = new ArrayList<>();
        for (KhachHang kh : listKhachHang) {
            String hoTen = kh.getHoTen().toLowerCase();
            if (hoTen.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

}
