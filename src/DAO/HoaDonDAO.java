/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDon;
import MyCustom.MyDialog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author User
 */
public class HoaDonDAO {
    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM hoadon";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaKH(rs.getInt(2));
                hd.setMaNV(rs.getInt(3));
                hd.setNgayLap(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setGhiChu(rs.getString(6));
                dshd.add(hd);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dshd;
    }

    public HoaDon getHoaDon(String maHD) {
        HoaDon hd = null;
        try {
            String sql = "SELECT * FROM hoadon WHERE MaHD=" + maHD;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaKH(rs.getInt(2));
                hd.setMaNV(rs.getInt(3));
                hd.setNgayLap(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setGhiChu(rs.getString(6));
            }
        } catch (SQLException ex) {
            return null;
        }
        return hd;
    }

    public boolean deleteHoaDon(String maHD) {
        boolean result = false;
        try {
            String sql = "DELETE FROM hoadon WHERE MaHD=" + maHD;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {

        }
        return result;
    }

    public boolean addHoaDon(HoaDon hd) {
        boolean result = false;
        try {
            String sql = "INSERT INTO hoadon(MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, hd.getMaKH());
            prep.setInt(2, hd.getMaNV());
            prep.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setInt(4, hd.getTongTien());
            prep.setString(5, hd.getGhiChu());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    public boolean updateHoaDon(int maHD, HoaDon hd) {
        boolean result = false;
        try {
            String sql = "UPDATE hoadon SET MaHD=?, MaKH=?, MaNV=?, NgayLap=? WHERE MaHD=" + maHD;
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, hd.getMaHD());
            prep.setInt(2, hd.getMaKH());
            prep.setInt(3, hd.getMaNV());
            prep.setDate(4, new java.sql.Date(hd.getNgayLap().getTime()));
            prep.setInt(5, hd.getTongTien());
            prep.setString(6, hd.getGhiChu());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public int getMaHoaDonMoiNhat() {
        try {
            String sql = "SELECT MAX(maHD) FROM hoadon";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
