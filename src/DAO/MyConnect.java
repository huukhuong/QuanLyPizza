package DAO;

import MyCustom.MyDialog;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnect {

    public static Connection conn = null;
    private String dbName = "quanlypizza";
    String userName = "root";
    String password = "";

    public MyConnect() {
        String strConnect = "jdbc:mysql://localhost/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        Properties pro = new Properties();
        pro.put("user", userName);
        pro.put("password", password);
        try {
            com.mysql.jdbc.Driver driver = new Driver();
            conn = driver.connect(strConnect, pro);
        } catch (SQLException ex) {
            new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
            System.exit(0);
        }

    }
}
