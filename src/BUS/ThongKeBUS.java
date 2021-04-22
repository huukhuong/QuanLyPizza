/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKe;

/**
 *
 * @author User
 */
public class ThongKeBUS {
    public ThongKeDAO thongKeDAO = new ThongKeDAO();
    public ThongKeBUS() {
    }
    
    public ThongKe thongKe() {
        return thongKeDAO.getThongKe();
    }
}
