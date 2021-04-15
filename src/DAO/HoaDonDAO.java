package DAO;

import DTO.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonDAO {

    public int taoMaHoaDon() {
        try {
            String sql = "SELECT MAX(MaHD) FROM HoaDon";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            return rs.getInt(1) + 1;
        } catch (SQLException e) {
        }
        return 0;
    }

    public void themHoaDon(HoaDon hd) {
        int maHD = taoMaHoaDon();
        
    }

    public void themCTHoaDon(int maSP, int soLuong, int donGia, int thanhTien) {
        
    }

}
