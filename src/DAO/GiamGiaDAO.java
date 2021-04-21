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
                gg.setNgayBD(rs.getDate(2));
                gg.setNgayKT(rs.getDate(3));
                dsgg.add(gg);
            }
            return dsgg;
        } catch (Exception e) {
        }
        return null;
    }

}
