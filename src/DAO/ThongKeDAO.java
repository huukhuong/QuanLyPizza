package DAO;

import DTO.ThongKe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ThongKeDAO {
    public ThongKe getThongKe(int nam) {
        ThongKe thongKe = new ThongKe();
        int[] tongThuQuy = new int[4];
        thongKe.setSoLuongSP(getTongSoLuongSP());
        tongThuQuy[0] = getTongThuQuy(nam, 1);
        tongThuQuy[1] = getTongThuQuy(nam, 2);
        tongThuQuy[2] = getTongThuQuy(nam, 3);
        tongThuQuy[3] = getTongThuQuy(nam, 4);
        thongKe.setTongThuQuy(tongThuQuy);
        return thongKe;
    }
    
    private int getTongSoLuongSP() {
        try {
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM sanpham");
            while(rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;  
    }
    
    private String[] getDateString(int nam, int quy) {
        int namBatDau = nam;
        int namKetThuc = nam;
        int thangBatDau = 1;
        int thangKetThuc = 4;
        String[] kq = new String[2];
        switch(quy) {
            case 1:
                thangBatDau = 1;
                thangKetThuc = 4;
            case 2:
                thangBatDau = 3;
                thangKetThuc = 7;
            case 3:
                thangBatDau = 6;
                thangKetThuc = 10;
            case 4:
                thangBatDau = 9;
                thangKetThuc = 1;
                namKetThuc++;
        }
        String strBatDau = Integer.toString(namBatDau) + Integer.toString(thangBatDau) + "01";
        String strKetThuc = Integer.toString(namKetThuc) + Integer.toString(thangKetThuc) + "01";
        kq[0] = strBatDau;
        kq[1] = strKetThuc;
        return kq;
    }
    
    private int getTongThuQuy(int nam,int quy) {     
        String[] dateString = getDateString(nam, quy);
        try {
            PreparedStatement prep = MyConnect.conn.prepareStatement("SELECT SUM(TongTien) FROM hoadon "
                    + "WHERE NgayLap >= ? AND NgayLap < ?");
            prep.setString(1, dateString[0]);
            prep.setString(2, dateString[1]);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }
    
    private int getSoLuongNhanVien() {
        try {
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM nhanvien");
            while(rs.next()) {
                return rs.getInt(1);
            }
        } catch(SQLException ex) {
            return -1;
        }
        return 0;
    }
    
    private int getSoLuongKhachHang() {
        try {
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM khachhang");
            while(rs.next()) {
                return rs.getInt(1);
            }
        } catch(SQLException ex) {
            return -1;
        }
        return 0;
    }
}
