/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTGiamGia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CTGiamGiaDAO {
    public ArrayList<CTGiamGia> getListCTGiamGia() {
        ArrayList<CTGiamGia> dsctgg = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ctgiamgia";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTGiamGia ctgg = new CTGiamGia();
                ctgg.setMaGiam(rs.getInt(1));
                ctgg.setMaSP(rs.getInt(2));
                ctgg.setPhanTramGiam(rs.getInt(3));
                dsctgg.add(ctgg);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dsctgg;
    }
    
    public ArrayList<CTGiamGia> getListCTGiamGiaTheoMaSP(int maSP) {
        ArrayList<CTGiamGia> dsctgg = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ctgiamgia WHERE MaSP="+maSP;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTGiamGia ctgg = new CTGiamGia();
                ctgg.setMaGiam(rs.getInt(1));
                ctgg.setMaSP(rs.getInt(2));
                ctgg.setPhanTramGiam(rs.getInt(3));
                dsctgg.add(ctgg);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dsctgg;
    }
    
    public CTGiamGia getCTGiamGia(int maGiam, int maSP) {
        CTGiamGia ctgg = null;
        try {
            String sql = "SELECT * FROM ctgiamgia "
                    + "WHERE MaSP="+maSP+" AND MaGiam="+maGiam;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                ctgg = new CTGiamGia();
                ctgg.setMaGiam(rs.getInt(1));
                ctgg.setMaSP(rs.getInt(2));
                ctgg.setPhanTramGiam(rs.getInt(3));
            }
        } catch(SQLException ex) {
            return null;
        }
        return ctgg;
    }
    
    public boolean addCTGiamGia(CTGiamGia ctGiamGia) {
        boolean result = false;
        try {
            String sql = "INSERT INTO ctgiamgia VALUES(?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ctGiamGia.getMaGiam());
            prep.setInt(2, ctGiamGia.getMaSP());
            prep.setInt(3, ctGiamGia.getPhanTramGiam());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean updateCTGiamGia(int maGiam, int maSP, CTGiamGia ctGiamGia) {
        boolean result = false;
        try {
            String sql = "UPDATE ctgiamgia SET MaGiam=?, maSP=?, phanTramGiam=? "
                    + "WHERE MaGiam="+maGiam;
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ctGiamGia.getMaGiam());
            prep.setInt(2, ctGiamGia.getMaSP());
            prep.setInt(3, ctGiamGia.getPhanTramGiam());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean deleteCTGiamGia(int maGiam, int maSP) {
        boolean result = false;
        try {
            String sql = "DELETE FROM ctgiamgia "
                    + "WHERE MaGiam="+maGiam+" AND MaSP="+maSP;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
}
