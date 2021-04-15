package DAO;

import DTO.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachHangDAO {
    
    public ArrayList<KhachHang> getListKhachHang() {
        try {
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhachHang> dskh = new ArrayList<>();
            while(rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setHoTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(3));
                kh.setTongChiTieu(rs.getInt(4));
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException e) {
        }
        
        return null;
    }
}
