/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author User
 */
public class ThongKe {
    public int soLuongSP;
    public int[] tongThuQuy;

    public ThongKe() {
    }

    public ThongKe(int soLuongSP, int[] tongThuQuy) {
        this.soLuongSP = soLuongSP;
        this.tongThuQuy = tongThuQuy;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public int[] getTongThuQuy() {
        return tongThuQuy;
    }

    public void setTongThuQuy(int[] tongThuQuy) {
        this.tongThuQuy = tongThuQuy;
    }
    
    
}
