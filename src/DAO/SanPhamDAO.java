package DAO;

import DTO.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SanPhamDAO {

    public ArrayList<SanPham> getListSanPham() {
        try {
            String sql = "SELECT * FROM SanPham";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<SanPham> dssp = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();

                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoai(rs.getInt(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHinhAnh(rs.getString(6));
                sp.setDonGia(rs.getInt(7));

                dssp.add(sp);
            }
            return dssp;
        } catch (Exception e) {
        }

        return null;
    }
    
    public ArrayList<SanPham> getListSanPham(int trang, int soSanPham) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        int batDau = soSanPham * (trang - 1);
        try {
            String sql = "SELECT * FROM SanPham LIMIT "+batDau+", "+soSanPham;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoai(rs.getInt(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHinhAnh(rs.getString(6));
                sp.setDonGia(rs.getInt(7));
                dssp.add(sp);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dssp;
    }

    public SanPham getSanPham(int ma) {
        try {
            String sql = "SELECT *FROM SanPham WHERE MaSP=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoai(rs.getInt(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHinhAnh(rs.getString(6));
                sp.setDonGia(rs.getInt(7));

                return sp;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public ArrayList<SanPham> getSanPhamTheoLoai(int maLoai) {
        try {
            String sql = "SELECT * FROM SanPham WHERE MaLoai=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maLoai);
            ResultSet rs = pre.executeQuery();
            ArrayList<SanPham> dssp = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();

                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoai(rs.getInt(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHinhAnh(rs.getString(6));
                sp.setDonGia(rs.getInt(7));

                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException e) {
        }

        return null;
    }
    
    public ArrayList<SanPham> getSanPhamTheoLoai(int maLoai, int trang, int soSanPham) {
        try {
            String sql = "SELECT * FROM SanPham WHERE MaLoai=? LIMIT ?,?";
            int batDau = soSanPham * (trang - 1);
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maLoai);
            pre.setInt(2, batDau);
            pre.setInt(3, soSanPham);
            ResultSet rs = pre.executeQuery();
            ArrayList<SanPham> dssp = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();

                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoai(rs.getInt(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHinhAnh(rs.getString(6));
                sp.setDonGia(rs.getInt(7));

                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException e) {
        }

        return null;
    }

    public String getAnh(int ma) {
        try {
            String sql = "SELECT HinhAnh FROM SanPham WHERE MaSP=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString("HinhAnh");
            }
        } catch (SQLException e) {
        }
        return "";
    }

    public void capNhatSoLuongSP(int ma, int soLuongMat) {
        SanPham sp = getSanPham(ma);
        int soLuong = sp.getSoLuong();
        sp.setSoLuong(soLuong + soLuongMat);
        try {
            String sql = "UPDATE SanPham SET SoLuong=? WHERE MaSP=" + ma;
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, sp.getSoLuong());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public boolean updateSanPham(int ma, SanPham sp) {
        boolean result = false;
        try {
            String sql = "UPDATE SanPham SET MaSP=?, TenSP=?, MaLoai=?, SoLuong=?,"
                    + "DonViTinh=?, HinhAnh=?, DonGia=? WHERE MaSP=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, sp.getMaSP());
            pre.setString(2, sp.getTenSP());
            pre.setInt(3, sp.getMaLoai());
            pre.setInt(4, sp.getSoLuong());
            pre.setString(5, sp.getDonViTinh());
            pre.setInt(6, sp.getDonGia());
            pre.setInt(7, ma);
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
        
    }
    
    public boolean deleteSanPham(int ma) {
        boolean result = false;
        try {
            String sql = "DELETE FROM SanPham WHERE MaSP = "+ma;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
}
