package DAO;

import DTO.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienDAO {

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        try {
            String sql = "SELECT * FROM NhanVien";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<NhanVien> dssv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();

                nv.setMaNV(rs.getInt(1));
                nv.setHoTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setChucVu(rs.getString(4));

                dssv.add(nv);
            }
            return dssv;
        } catch (SQLException e) {
        }

        return null;
    }
    
    public NhanVien getNhanVien(int maNV) {
        NhanVien nv = null;
        try {
            String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(0, maNV);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getInt(1));
                nv.setHoTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setChucVu(rs.getString(4));
            }
        } catch (SQLException e) {
            return null;
        }

        return nv;
    }
    
    public boolean updateNhanVien(int maNV, NhanVien nv) {
        boolean result=false;
        try {
            String sql = "UPDATE nhanvien SET MaNV=?, HoTen=?, GioiTinh=?, ChucVu=? WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, nv.getMaNV());
            pre.setString(2, nv.getHoTen());
            pre.setString(3, nv.getGioiTinh());
            pre.setString(4, nv.getChucVu());
            pre.setInt(5, maNV);
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean deleteNhanVien(int maNV) {
        boolean result=false;
        try {
            String sql = "DELETE FROM nhanvien WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maNV);
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }

}
