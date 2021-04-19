package GUI;

import static Main.Main.changLNF;
import MyCustom.MyTable;
import MyCustom.TransparentPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NhanVienGUI extends JPanel {

    public NhanVienGUI() {
        changLNF("Windows");
        addControlsNhanVien();
        addEventsNhanVien();
    }

    JLabel lblTabbedNhanVien, lblTabbedQuyen;
    final ImageIcon tabbedSelected = new ImageIcon("image/ManagerUI/tabbed-btn--selected.png");
    final ImageIcon tabbedDefault = new ImageIcon("image/ManagerUI/tabbed-btn.png");
    final Color colorPanel = new Color(247, 247, 247);
    CardLayout cardNhanVienGroup = new CardLayout();
    JPanel pnCardTabNhanVien;
    JTextField txtMaNV, txtHoTen, txtChucVu, txtTenDangNhap, txtTimNV;
    JComboBox<String> cmbGioiTinh, cmbQuyen;
    MyTable tblNhanVien;
    DefaultTableModel dtmNhanVien;
    JButton btnReset, btnThemNV, btnSuaNV, btnXoaNV, btnTimNV, btnCapTaiKhoan;

    private void addControlsNhanVien() {
        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        int w = 1030;
        int h = 844;
        /*
        =========================================================================
                                    PANEL TABBED
        =========================================================================
         */
        JPanel pnTop = new TransparentPanel();
        //<editor-fold defaultstate="collapsed" desc="Panel Tab Nhân viên & Quyền">
        Font font = new Font("", Font.PLAIN, 20);
        pnTop.setPreferredSize(new Dimension(w, 41));
        pnTop.setLayout(null);
        pnTop.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.GRAY));

        lblTabbedNhanVien = new JLabel("Nhân viên");
        lblTabbedNhanVien.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedNhanVien.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedNhanVien.setIcon(tabbedSelected);
        lblTabbedNhanVien.setBounds(2, 2, 140, 37);
        lblTabbedNhanVien.setFont(font);
        lblTabbedNhanVien.setForeground(Color.white);
        lblTabbedNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblTabbedQuyen = new JLabel("Quyền");
        lblTabbedQuyen.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedQuyen.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedQuyen.setIcon(tabbedDefault);
        lblTabbedQuyen.setBounds(143, 2, 140, 37);
        lblTabbedQuyen.setFont(font);
        lblTabbedQuyen.setForeground(Color.white);
        lblTabbedQuyen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        pnTop.add(lblTabbedNhanVien);
        pnTop.add(lblTabbedQuyen);
        //</editor-fold>
        this.add(pnTop, BorderLayout.NORTH);

        /*
        =========================================================================
                                    PANEL NHÂN VIÊN
        =========================================================================
         */
        JPanel pnNhanVien = new TransparentPanel();
        pnNhanVien.setLayout(new BorderLayout());

        JPanel pnTopNV = new TransparentPanel();
        pnTopNV.setLayout(new BoxLayout(pnTopNV, BoxLayout.Y_AXIS));

        JPanel pnTitle = new TransparentPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ NHÂN VIÊN</h1></html>");
        btnReset = new JButton(new ImageIcon("image/Refresh-icon.png"));
        btnReset.setPreferredSize(new Dimension(40, 40));
        pnTitle.add(lblTitle);
        pnTitle.add(btnReset);
        pnTopNV.add(pnTitle);
        pnTopNV.setBackground(Color.DARK_GRAY);
        //==========
        JPanel pnText = new TransparentPanel();
        pnText.setLayout(new BoxLayout(pnText, BoxLayout.Y_AXIS));

        txtMaNV = new JTextField(25);
        txtMaNV.setEditable(false);
        txtHoTen = new JTextField(25);
        cmbGioiTinh = new JComboBox<>();
        txtChucVu = new JTextField(25);
        txtTenDangNhap = new JTextField(25);
        txtTenDangNhap.setEditable(false);
        cmbQuyen = new JComboBox<>();

        txtMaNV.setFont(font);
        txtHoTen.setFont(font);
        cmbGioiTinh.setFont(font);
        txtChucVu.setFont(font);
        txtTenDangNhap.setFont(font);
        cmbQuyen.setFont(font);

        JLabel lblMa, lblTen, lblGioiTinh, lblChucVu, lblTenDangNhap, lblQuyen;

        lblMa = new JLabel("Mã Nhân viên");
        lblTen = new JLabel("Họ tên");
        lblGioiTinh = new JLabel("Giới tính");
        lblChucVu = new JLabel("Chức vụ");
        lblTenDangNhap = new JLabel("Tên đăng nhập");
        lblQuyen = new JLabel("Quyền");

        lblMa.setFont(font);
        lblTen.setFont(font);
        lblGioiTinh.setFont(font);
        lblChucVu.setFont(font);
        lblTenDangNhap.setFont(font);
        lblQuyen.setFont(font);

        JPanel pnMa = new TransparentPanel();
        pnMa.add(lblMa);
        pnMa.add(txtMaNV);
        pnText.add(pnMa);

        JPanel pnTen = new TransparentPanel();
        pnTen.add(lblTen);
        pnTen.add(txtHoTen);
        pnText.add(pnTen);

        JPanel pnGioiTinh = new TransparentPanel();
        pnGioiTinh.add(lblGioiTinh);
        pnGioiTinh.add(cmbGioiTinh);
        pnText.add(pnGioiTinh);

        JPanel pnChucVu = new TransparentPanel();
        pnChucVu.add(lblChucVu);
        pnChucVu.add(txtChucVu);
        pnText.add(pnChucVu);

        JPanel pnTenDangNhap = new TransparentPanel();
        pnTenDangNhap.add(lblTenDangNhap);
        pnTenDangNhap.add(txtTenDangNhap);
        pnText.add(pnTenDangNhap);

        JPanel pnQuyen = new TransparentPanel();
        pnQuyen.add(lblQuyen);
        pnQuyen.add(cmbQuyen);
        pnText.add(pnQuyen);

        Dimension lblSize = lblTenDangNhap.getPreferredSize();
        lblMa.setPreferredSize(lblSize);
        lblTen.setPreferredSize(lblSize);
        lblGioiTinh.setPreferredSize(lblSize);
        lblChucVu.setPreferredSize(lblSize);
        lblTenDangNhap.setPreferredSize(lblSize);
        lblQuyen.setPreferredSize(lblSize);
        cmbGioiTinh.setPreferredSize(txtChucVu.getPreferredSize());
        cmbQuyen.setPreferredSize(txtChucVu.getPreferredSize());

        pnTopNV.add(pnText);
        
        //==========
        JPanel pnTimNV = new TransparentPanel();
        JLabel lblTim = new JLabel("Từ khoá tìm");
        lblTim.setFont(font);
        txtTimNV = new JTextField(25);
        txtTimNV.setFont(font);
        pnTimNV.add(lblTim);
        pnTimNV.add(txtTimNV);
        pnTopNV.add(pnTimNV);
        lblTim.setPreferredSize(lblSize);
        //==========
        JPanel pnButton = new TransparentPanel();
        
        pnTopNV.add(pnButton);
        

        pnNhanVien.add(pnTopNV, BorderLayout.NORTH);
        /*
        =========================================================================
                                    PANEL QUYỀN
        =========================================================================
         */
        JPanel pnPhanQuyen = new TransparentPanel();

        //========================
        pnCardTabNhanVien = new JPanel(cardNhanVienGroup);
        pnCardTabNhanVien.add(pnNhanVien, "1");
        pnCardTabNhanVien.add(pnPhanQuyen, "2");
        this.add(pnCardTabNhanVien);
    }

    private void addEventsNhanVien() {
        lblTabbedNhanVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedNhanVien.setIcon(tabbedSelected);
                lblTabbedQuyen.setIcon(tabbedDefault);
                cardNhanVienGroup.show(pnCardTabNhanVien, "1");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        lblTabbedQuyen.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedQuyen.setIcon(tabbedSelected);
                lblTabbedNhanVien.setIcon(tabbedDefault);
                cardNhanVienGroup.show(pnCardTabNhanVien, "2");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

}
