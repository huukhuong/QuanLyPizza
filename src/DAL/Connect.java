package DAL;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    public static Connection conn = null;
    private String dbName = "quanlypizza";
    String userName = "root";
    String password = "";

    public Connect() {
        String strConnect = "jdbc:mysql://localhost/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        Properties pro = new Properties();
        pro.put("user", userName);
        pro.put("password", password);
        try {
            com.mysql.jdbc.Driver driver = new Driver();
            conn = driver.connect(strConnect, pro);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
