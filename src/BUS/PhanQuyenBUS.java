package BUS;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyen;

public class PhanQuyenBUS {

    public static PhanQuyen quyenTK = null;
    
    public void kiemTraQuyen(String quyen) {
        quyenTK = new PhanQuyenDAO().getQuyen(quyen);
    }
    
}
