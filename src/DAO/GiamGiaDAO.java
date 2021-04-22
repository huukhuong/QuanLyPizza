package DAO;

import DTO.GiamGia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GiamGiaDAO {


    public ArrayList<GiamGia> getDanhSachMaGiam() {
        try {
            String sql = "SELECT * FROM GiamGia";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<GiamGia> dsgg = new ArrayList<>();
            while(rs.next()) {
                GiamGia gg = new GiamGia();
                gg.setMaGiam(rs.getInt(1));
                gg.setTenChuongTrinh(rs.getString(2));
                gg.setNgayBD(rs.getDate(3));
                gg.setNgayKT(rs.getDate(4));
                gg.setPhanTramGiam(rs.getInt(4));
                gg.setDieuKien(rs.getInt(5));
                dsgg.add(gg);
            }
            return dsgg;
        } catch (Exception e) {
        }
        return null;
    }

}
