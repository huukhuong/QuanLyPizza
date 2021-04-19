package DAO;

import DTO.PhanQuyen;
import java.sql.ResultSet;
import java.sql.Statement;

public class PhanQuyenDAO {

    public PhanQuyen getQuyen(String quyen) {
        try {
            String sql = "SELECT * FROM PhanQuyen WHERE quyen='" + quyen+"'";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                PhanQuyen phanQuyen = new PhanQuyen();
                phanQuyen.setQuyen(quyen);
                phanQuyen.setNhapHang(rs.getInt(2));
                phanQuyen.setQlSanPham(rs.getInt(3));
                phanQuyen.setQlNhanVien(rs.getInt(4));
                phanQuyen.setQlKhachHang(rs.getInt(5));
                phanQuyen.setThongKe(rs.getInt(6));
                return phanQuyen;
            }
        } catch (Exception e) {
        }
        return null;
    }

}
