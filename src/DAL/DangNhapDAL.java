package DAL;

import DTO.TaiKhoan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DangNhapDAL {

    public static TaiKhoan dangNhap(String user, String password) {
        TaiKhoan tk = null;
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap=? AND MatKhau=?";
            PreparedStatement pre = Connect.conn.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tk = new TaiKhoan();
                tk.setMaNhanVien(user);
                tk.setMatKhau(password);
                tk.setChucVu(rs.getString("ChucVu"));
            }
            return tk;
        } catch (SQLException e) {
        }
        return tk;
    }
}