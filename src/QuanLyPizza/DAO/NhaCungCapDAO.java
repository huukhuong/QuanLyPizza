package QuanLyPizza.DAO;

import QuanLyPizza.DTO.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhaCungCapDAO {

    public ArrayList<NhaCungCap> getListNhaCungCap() {
        try {
            ArrayList<NhaCungCap> dsncc = new ArrayList<>();
            String sql = "SELECT * FROM nhacungcap";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setDienThoai(rs.getString(4));
                dsncc.add(ncc);
            }
            return dsncc;
        } catch (SQLException ex) {
            return null;
        }
    }

    public NhaCungCap getNhaCungCap(int maNCC) {
        NhaCungCap ncc = null;
        try {
            String sql = "SELECT * FROM nhacungcap WHERE MaNCC=" + maNCC;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setDienThoai(rs.getString(4));
            }
        } catch (SQLException ex) {
            return null;
        }
        return ncc;
    }

    public boolean addNCC(NhaCungCap ncc) {
        boolean result = false;
        try {
            String sql = "INSERT INTO nhacungcap VALUES(?,?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ncc.getMaNCC());
            prep.setString(2, ncc.getTenNCC());
            prep.setString(3, ncc.getDiaChi());
            prep.setString(4, ncc.getDienThoai());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateNCC(NhaCungCap ncc) {
        boolean result = false;
        try {
            String sql = "UPDATE nhacungcap SET TenNCC=?, DiaChi=?, DienThoai=? WHERE MaNCC=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setString(1, ncc.getTenNCC());
            prep.setString(2, ncc.getDiaChi());
            prep.setString(3, ncc.getDienThoai());
            prep.setInt(4, ncc.getMaNCC());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    public boolean deleteNCC(int maNCC) {
        boolean result = false;
        try {
            String sql = "DELETE FROM nhacungcap WHERE MaNCC=" + maNCC;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
}
