package DAL;

import DTO.TaiKhoan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DangNhapDAL {

    public static TaiKhoan dangNhap(String user, String password) {
        TaiKhoan tk = null;
        try {
            String sql = "SELECT * FROM taikhoan WHERE TenDangNhap=? AND MatKhau=?";
            PreparedStatement pre = Connect.conn.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tk = new TaiKhoan();
                tk.setMaNhanVien(rs.getString("MaNV"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setQuyen(rs.getString("Quyen"));
            }
            return tk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }
}