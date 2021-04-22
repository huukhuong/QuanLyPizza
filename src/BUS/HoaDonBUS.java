package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDon;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class HoaDonBUS {

    private ArrayList<HoaDon> listHoaDon;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon = hoaDonDAO.getListHoaDon();
        return listHoaDon;
    }

    public void luuHoaDon(int maKH, String nhanVien, int tongTien, String ghiChu) {
        HoaDon hd = new HoaDon();
        String[] arrNV = nhanVien.split(" - ");
        int maNV = Integer.parseInt(arrNV[0]);
        hd.setMaNV(maNV);
        hd.setMaKH(maKH);
        hd.setGhiChu(ghiChu);
        hd.setTongTien(tongTien);

        hoaDonDAO.addHoaDon(hd);
    }

    public int getMaHoaDonMoiNhat() {
        return hoaDonDAO.getMaHoaDonMoiNhat();
    }
}
