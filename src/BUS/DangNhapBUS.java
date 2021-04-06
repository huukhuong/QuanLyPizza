package BUS;

import DAO.DangNhapDAO;
import DTO.TaiKhoan;
import MyCustom.MyDialog;

public class DangNhapBUS {

    private final static int EMPTY_ERROR = 1;
    private final static int WRONG_ERROR = 2;

    public static TaiKhoan getTaiKhoanDangNhap(String user, String password) {
        if (kiemTraDangNhap(user, password) == EMPTY_ERROR) {
            MyDialog dlg = new MyDialog("Không được để trống thông tin!",
                    MyDialog.ERROR_DIALOG);
            return null;
        }
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDangNhap(user);
        tk.setMatKhau(password);
        
        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        TaiKhoan account = dangNhapDAO.dangNhap(tk);
        
        if (account == null) {
            MyDialog dlg = new MyDialog("Sai thông tin đăng nhập!",
                    MyDialog.ERROR_DIALOG);
        } else {
            MyDialog dlg = new MyDialog("Đăng nhập thành công!",
                    MyDialog.SUCCESS_DIALOG);
        }
        return account;
    }

    private static int kiemTraDangNhap(String user, String password) {
        user = user.replaceAll("\\s+", "");
        password = password.replaceAll("\\s+", "");
        int result = 0;
        
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDangNhap(user);
        tk.setMatKhau(password);
        
        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        TaiKhoan account = dangNhapDAO.dangNhap(tk);
        
        if (user.length() <= 0 || password.length() <= 0) {
            result = EMPTY_ERROR;
        } else if (account == null) {
            result = WRONG_ERROR;
        }
        return result;
    }

}
