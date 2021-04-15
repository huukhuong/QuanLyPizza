/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PhieuNhapDAO {
    public ArrayList<PhieuNhap> getListPhieuNhap() {
        ArrayList<PhieuNhap> dspn = new ArrayList<>();
        try {
            String sql = "SELECT * FROM phieunhap";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(rs.getInt(1));
                pn.setMaNCC(rs.getInt(2));
                pn.setMaNV(rs.getInt(3));
                pn.setNgayLap(rs.getDate(4));
                pn.setTongTien(rs.getInt(5));
                dspn.add(pn);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dspn;
    }
    
    public PhieuNhap getPhieuNhap(int maPN) {
        PhieuNhap pn = null;
        try {
            String sql = "SELECT * FROM phieunhap WHERE MaPN="+maPN;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                pn = new PhieuNhap();
                pn.setMaPN(rs.getInt(1));
                pn.setMaNCC(rs.getInt(2));
                pn.setMaNV(rs.getInt(3));
                pn.setNgayLap(rs.getDate(4));
                pn.setTongTien(rs.getInt(5));
            }
        } catch(SQLException ex) {
            return null;
        }
        return pn;
    }
    
    public boolean deletePhieuNhap(int maPN) {
        boolean result = false;
        try {
            String sql = "DELETE FROM phieunhap WHERE MaPN="+maPN;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean updatePhieuNhap(int maPN, PhieuNhap pn) {
        boolean result = false;
        try {
            String sql = "UPDATE phieunhap SET MaPN=?, MaNCC=?, MaNV=?, NgayLap=?, TongTien=? "
                    + "WHERE MaPN="+maPN;
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, pn.getMaPN());
            prep.setInt(2, pn.getMaNCC());
            prep.setInt(3, pn.getMaNV());
            prep.setDate(4, new java.sql.Date(pn.getNgayLap().getTime()));
            prep.setInt(5, pn.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
}
 