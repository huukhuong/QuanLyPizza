package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDon;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;

public class HoaDonBUS {

    private ArrayList<HoaDon> listHoaDon;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon = hoaDonDAO.getListHoaDon();
        return listHoaDon;
    }

    public void luuHoaDon(ArrayList<Vector> dsGioHang, LocalDateTime now, int tongTien) {
        
    }
}
