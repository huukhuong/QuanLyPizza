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
        thongKe.setSoLuongKH(getSoLuongKhachHang());
        thongKe.setSoLuongNV(getSoLuongNhanVien());
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
        System.out.println("quy"+quy);
        int namBatDau = nam;
        int namKetThuc = nam;
        String thangBatDau = "01"; //kiểu String do có số 0 ở phía trước
        String thangKetThuc = "04"; //kiểu String do có số 0 ở phía trước
        String[] kq = new String[2];
        switch(quy) {
            case 1:
                thangBatDau = "01";
                thangKetThuc = "04";
                break;
            case 2:
                thangBatDau = "03";
                thangKetThuc = "07";
                break;
            case 3:
                thangBatDau = "06";
                thangKetThuc = "10";
                break;
            case 4:
                thangBatDau = "09";
                thangKetThuc = "01";
                namKetThuc++;
        }
        String strBatDau = Integer.toString(namBatDau) + thangBatDau + "01";
        String strKetThuc = Integer.toString(namKetThuc) + thangKetThuc + "01";
        kq[0] = strBatDau;
        kq[1] = strKetThuc;
        System.out.println(kq[0]);
        System.out.println(kq[1]);
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
