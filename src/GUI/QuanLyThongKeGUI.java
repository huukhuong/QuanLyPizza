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
        lblBackgroundThucDon = new JLabel(new ImageIcon("image/ManagerUI/thongKeMon.png"));
        lblBackgroundKhachHang = new JLabel(new ImageIcon("image/ManagerUI/thongKeKhachHang.png"));
        lblBackgroundNhanVien = new JLabel(new ImageIcon("image/ManagerUI/thongKeNhanVien.png"));
        lblBackgroundDoanhThu = new JLabel(new ImageIcon("image/ManagerUI/thongKeDoanhThu.png"));

        lblTile.setBounds(0, 15, w, 50);
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
        pnThongKeTong.add(lblThongKeThucDon);
        pnThongKeTong.add(lblThongKeKhachHang);
        pnThongKeTong.add(lblThongKeNhanVien);
        pnThongKeTong.add(lblThongKeDoanhThu);
        pnThongKeTong.add(lblBackgroundThucDon);
        pnThongKeTong.add(lblBackgroundKhachHang);
        pnThongKeTong.add(lblBackgroundNhanVien);
        pnThongKeTong.add(lblBackgroundDoanhThu);

        pnMain.add(pnThongKeTong);


        this.add(pnMain, BorderLayout.CENTER);
    }

    private void addEvents() {

    }

}
