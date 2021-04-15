package DAO;

import DTO.LoaiSP;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoaiDAO {

    public ArrayList<LoaiSP> getDanhSachLoai() {
        try {
            String sql = "SELECT * FROM Loai";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<LoaiSP> dsl = new ArrayList<>();
            while(rs.next()) {
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
    
    public LoaiSP getLoai(int maLoai) {
        LoaiSP loai = null;
        try {
            String sql = "SELECT * FROM Loai WHERE MaLoai="+maLoai;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                loai = new LoaiSP();
                loai.setMaLoai(rs.getInt(1));
                loai.setTenLoai(rs.getString(2));
            }
        } catch(SQLException ex) {
            return null;
        }
        return loai;
    }
    
    public boolean addLoai(LoaiSP loai) {
        boolean result=false;
        try {
            String sql = "INSERT INTO Loai VALUES(?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, loai.getMaLoai());
            pre.setString(2, loai.getTenLoai());
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean updateLoai(int maLoai, LoaiSP loai) {
        boolean result=false;
        try {
            String sql = "UPDATE Loai SET MaLoai=?, TenLoai=? WHERE MaLoai=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, loai.getMaLoai());
            pre.setString(2, loai.getTenLoai());
            pre.setInt(3, maLoai);
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean deleteLoai(int maLoai) {
        boolean result=false;
        try {
            String sql = "DELETE FROM Loai WHERE MaLoai=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maLoai);
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
}
