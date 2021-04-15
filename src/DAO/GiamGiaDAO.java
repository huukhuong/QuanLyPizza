/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.GiamGia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GiamGiaDAO {
    public ArrayList<GiamGia> getListGiamGia() {
        ArrayList<GiamGia> dsGiamGia = new ArrayList<>();
        try {
            String sql = "SELECT * FROM giamgia";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                GiamGia giamGia = new GiamGia();
                giamGia.setMaGiam(rs.getInt(1));
                giamGia.setNgayBD(rs.getDate(2));
                giamGia.setNgayKT(rs.getDate(3));
                dsGiamGia.add(giamGia);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dsGiamGia;
    }
    
    public GiamGia getGiamGia(int maGiam) {
        GiamGia giamGia = null;
        try {
            String sql = "SELECT * FROM giamgia WHERE MaGiam="+maGiam;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                giamGia = new GiamGia();
                giamGia.setMaGiam(rs.getInt(1));
                giamGia.setNgayBD(rs.getDate(2));
                giamGia.setNgayKT(rs.getDate(3));
            }
        } catch(SQLException ex) {
            return null;
        }
        return giamGia;
    }
    
    public boolean addGiamGia(GiamGia giamGia) {
        boolean result = false;
        try {
            String sql = "INSERT INTO giamgia VALUES(?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, giamGia.getMaGiam());
            prep.setDate(2, new java.sql.Date(giamGia.getNgayBD().getTime()));
            prep.setDate(3, new java.sql.Date(giamGia.getNgayKT().getTime()));
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            
        }
        return result;
    }
    
    public boolean deleteGiamGia(int maGiam) {
        boolean result = false;
        try {
            String sql = "DELETE FROM giamgia WHERE MaGiam="+maGiam;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean updateGiamGia(int maGiam, GiamGia giamGia) {
        boolean result = false;
        try {
            String sql = "UPDATE giamgia SET MaGiam=?, NgayBD=?, NgayKT=? "
                    + "WHERE MaGiam="+maGiam;
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, giamGia.getMaGiam());
            prep.setDate(2, new java.sql.Date(giamGia.getNgayBD().getTime()));
            prep.setDate(3, new java.sql.Date(giamGia.getNgayKT().getTime()));
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
}
