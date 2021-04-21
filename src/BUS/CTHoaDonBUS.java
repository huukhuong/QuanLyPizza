package BUS;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDon;
import DTO.HoaDon;

import java.util.ArrayList;

public class CTHoaDonBUS {

    private ArrayList<CTHoaDon> listCTHoaDon;
    private CTHoaDonDAO ctHDDAO = new CTHoaDonDAO();

    public CTHoaDonBUS() {
        docListCTHoaDon();
    }

    public void docListCTHoaDon() {
        this.listCTHoaDon = ctHDDAO.getListCTHoaDon();
    }

    public ArrayList<CTHoaDon> getListCTHoaDon() {
        return listCTHoaDon;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaHD(String maHD) {
        int ma = Integer.parseInt(maHD);
        ArrayList<CTHoaDon> dsct = new ArrayList<>();

        for (CTHoaDon cthd:listCTHoaDon) {
            if (cthd.getMaHD() == ma)
                dsct.add(cthd);
        }

        return dsct;
    }
}
