package GUI;

import MyCustom.TransparentPanel;

import javax.swing.*;

import java.awt.*;

import static Main.Main.changLNF;

public class QuanLyThongKeGUI extends JPanel {

    public QuanLyThongKeGUI() {
        changLNF("Windows");
        addControls();
        addEvents();
    }

    final Color colorPanel = new Color(56, 56, 56);
    JLabel lblThongKeThucDon, lblThongKeKhachHang, lblThongKeNhanVien, lblThongKeDoanhThu;
    JLabel lblDoanhThuQuy1, lblDoanhThuQuy2, lblDoanhThuQuy3, lblDoanhThuQuy4, lblTongDoanhThu;
    JButton btnReset;

    private void addControls() {
        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        int w = 1030;
        int h = 844;

        //========================================
        JPanel pnMain = new TransparentPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnThongKeTong = new JPanel(null);
        pnThongKeTong.setBackground(colorPanel);
        JLabel lblTile, lblBackgroundThucDon, lblBackgroundKhachHang, lblBackgroundNhanVien, lblBackgroundDoanhThu;

        lblTile = new JLabel("THỐNG KÊ TỔNG QUÁT", JLabel.CENTER);
        lblTile.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnReset = new JButton("Reset");
        lblBackgroundThucDon = new JLabel(new ImageIcon("image/ManagerUI/thongKeMon.png"));
        lblBackgroundKhachHang = new JLabel(new ImageIcon("image/ManagerUI/thongKeKhachHang.png"));
        lblBackgroundNhanVien = new JLabel(new ImageIcon("image/ManagerUI/thongKeNhanVien.png"));
        lblBackgroundDoanhThu = new JLabel(new ImageIcon("image/ManagerUI/thongKeDoanhThu.png"));

        lblTile.setBounds(0, 15, w, 50);
        btnReset.setBounds(492, 295, 40 ,40);
        lblBackgroundThucDon.setBounds(98, 85, 369, 201);
        lblBackgroundKhachHang.setBounds(563, 85, 369, 201);
        lblBackgroundNhanVien.setBounds(98, 340, 369, 201);
        lblBackgroundDoanhThu.setBounds(563, 340, 369, 201);

        lblThongKeThucDon = new JLabel("55", JLabel.CENTER);
        lblThongKeKhachHang = new JLabel("46", JLabel.CENTER);
        lblThongKeNhanVien = new JLabel("23", JLabel.CENTER);
        lblThongKeDoanhThu = new JLabel("1.286.379.000", JLabel.CENTER);

        Font font = new Font("Tahoma", Font.BOLD, 48);
        lblThongKeThucDon.setFont(font);
        lblThongKeKhachHang.setFont(font);
        lblThongKeNhanVien.setFont(font);
        lblThongKeDoanhThu.setFont(font);

        lblTile.setForeground(Color.white);
        lblThongKeThucDon.setForeground(Color.white);
        lblThongKeKhachHang.setForeground(Color.white);
        lblThongKeNhanVien.setForeground(Color.white);
        lblThongKeDoanhThu.setForeground(Color.white);

        lblThongKeThucDon.setBounds(98, 100, 232, 87);
        lblThongKeKhachHang.setBounds(563, 100, 232, 87);
        lblThongKeNhanVien.setBounds(98, 350, 232, 87);
        lblThongKeDoanhThu.setBounds(563, 350, 369, 87);

        pnThongKeTong.add(lblTile);
        pnThongKeTong.add(btnReset);
        pnThongKeTong.add(lblThongKeThucDon);
        pnThongKeTong.add(lblThongKeKhachHang);
        pnThongKeTong.add(lblThongKeNhanVien);
        pnThongKeTong.add(lblThongKeDoanhThu);
        pnThongKeTong.add(lblBackgroundThucDon);
        pnThongKeTong.add(lblBackgroundKhachHang);
        pnThongKeTong.add(lblBackgroundNhanVien);
        pnThongKeTong.add(lblBackgroundDoanhThu);

        lblDoanhThuQuy1 = new JLabel("2.000.000", JLabel.CENTER);
        lblDoanhThuQuy2 = new JLabel("3.000.000", JLabel.CENTER);
        lblDoanhThuQuy3 = new JLabel("9.000.000", JLabel.CENTER);
        lblDoanhThuQuy4 = new JLabel("12.000.000", JLabel.CENTER);
        lblTongDoanhThu = new JLabel("26.000.000", JLabel.CENTER);

        Font font1 = new Font("Tahoma", Font.BOLD, 22);
        lblDoanhThuQuy1.setFont(font1);
        lblDoanhThuQuy2.setFont(font1);
        lblDoanhThuQuy3.setFont(font1);
        lblDoanhThuQuy4.setFont(font1);
        font1 = new Font("Tahoma", Font.BOLD, 28);
        lblTongDoanhThu.setFont(font1);

        lblDoanhThuQuy1.setForeground(Color.WHITE);
        lblDoanhThuQuy2.setForeground(Color.WHITE);
        lblDoanhThuQuy3.setForeground(Color.WHITE);
        lblDoanhThuQuy4.setForeground(Color.WHITE);
        lblTongDoanhThu.setForeground(Color.WHITE);

        int x = 265;
        int y = 662;
        lblDoanhThuQuy1.setBounds(x, y, 167, 63);
        lblDoanhThuQuy2.setBounds(x += 167, y, 167, 63);
        lblDoanhThuQuy3.setBounds(x += 167, y, 167, 63);
        lblDoanhThuQuy4.setBounds(x += 167, y, 167, 63);
        lblTongDoanhThu.setBounds(265, 725, 667, 63);

        pnThongKeTong.add(lblTongDoanhThu);
        pnThongKeTong.add(lblDoanhThuQuy1);
        pnThongKeTong.add(lblDoanhThuQuy2);
        pnThongKeTong.add(lblDoanhThuQuy3);
        pnThongKeTong.add(lblDoanhThuQuy4);

        JLabel lblBackgroundBang = new JLabel(new ImageIcon("image/ManagerUI/bangThongKe.png"));
        lblBackgroundBang.setBounds(98, 600, 834, 189);
        pnThongKeTong.add(lblBackgroundBang);

        pnMain.add(pnThongKeTong);

        this.add(pnMain, BorderLayout.CENTER);
    }

    private void addEvents() {
        btnReset.addAtionListener(
    }

    private void hienThiThongKe() {
    
    }

}
