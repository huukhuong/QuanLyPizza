package QuanLyPizza.DAO;

import QuanLyPizza.DTO.LoaiSP;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoaiDAO {

    public ArrayList<LoaiSP> getDanhSachLoai() {
        try {
            String sql = "SELECT * FROM Loai";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<LoaiSP> dsl = new ArrayList<>();
            while (rs.next()) {
                LoaiSP loai = new LoaiSP();
                loai.setMaLoai(rs.getInt(1));
                loai.setTenLoai(rs.getString(2));
                dsl.add(loai);
            }
            return dsl;
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean themLoai(LoaiSP loai) {
        try {
            String sql = "insert into loai(TenLoai) "
                    + "values ("
                    + "'" + loai.getTenLoai() + "')";
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean xoaLoai(int maLoai) {
        try {
            String sql = "DELETE FROM Loai WHERE MaLoai=" + maLoai;
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean suaLoai(int maLoai, String ten) {
        try {
            String sql = "UPDATE Loai SET TenLoai='" + ten + "' WHERE MaLoai=" + maLoai;
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException e) {
        }
        return false;
    }

}
