package QuanLyPizza.GUI;

import QuanLyPizza.BUS.KhachHangBUS;
import QuanLyPizza.DTO.KhachHang;
import MyCustom.MyDialog;
import MyCustom.MyTable;
import MyCustom.TransparentPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import static Main.Main.changLNF;

public class PnQuanLyKhachHangGUI extends JPanel {

    public PnQuanLyKhachHangGUI() {
        changLNF("Windows");
        addControls();
        addEvents();
    }

    private KhachHangBUS khachHangBUS = new KhachHangBUS();

    final Color colorPanel = new Color(247, 247, 247);
    JButton btnReset;
    JTextField txtMa, txtHo, txtTen, txtTongChiTieu, txtTukhoa, txtMaxChiTieu, txtMinchiTieu;
    JComboBox<String> cmbGioiTinh;
    JButton btnThem, btnSua, btnXoa, btnTim;
    MyTable tblKhachHang;
    DefaultTableModel dtmKhachHang;

    private void addControls() {
        Font font = new Font("Tahoma", Font.PLAIN, 20);

        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        int w = 1030;
        int h = 844;

        /*
        =========================================================================
                                    PANEL KHÁCH HÀNG
        =========================================================================
         */
        JPanel pnKhachHang = new TransparentPanel();
        pnKhachHang.setLayout(new BoxLayout(pnKhachHang, BoxLayout.Y_AXIS));

        JPanel pnTopKH = new TransparentPanel();
        pnTopKH.setLayout(new BoxLayout(pnTopKH, BoxLayout.Y_AXIS));

        JPanel pnTitle = new TransparentPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ KHÁCH HÀNG</h1></html>");
        btnReset = new JButton(new ImageIcon("image/Refresh-icon.png"));
        btnReset.setPreferredSize(new Dimension(40, 40));
        pnTitle.add(lblTitle);
        pnTitle.add(btnReset);
        pnTopKH.add(pnTitle);

        //======PANEL TEXT FIELD=======
        JPanel pnTextField = new TransparentPanel();
        pnTextField.setLayout(new BoxLayout(pnTextField, BoxLayout.Y_AXIS));

        JLabel lblMa, lblHo, lblTen, lblGioiTinh, lblTongChiTieu;
        lblMa = new JLabel("Mã Khách hàng");
        lblHo = new JLabel("Họ đệm");
        lblTen = new JLabel("Tên");
        lblGioiTinh = new JLabel("Giới tính");
        lblTongChiTieu = new JLabel("Tổng chi tiêu");

        lblMa.setFont(font);
        lblHo.setFont(font);
        lblTen.setFont(font);
        lblGioiTinh.setFont(font);
        lblTongChiTieu.setFont(font);

        txtMa = new JTextField(20);
        txtMa.setEditable(false);
        txtHo = new JTextField(20);
        txtTen = new JTextField(20);
        txtTongChiTieu = new JTextField(20);
        txtTongChiTieu.setEditable(false);
        cmbGioiTinh = new JComboBox<>();
        cmbGioiTinh.addItem("Chọn giới tính");
        cmbGioiTinh.addItem("Nam");
        cmbGioiTinh.addItem("Nữ");

        txtMa.setFont(font);
        txtHo.setFont(font);
        txtTen.setFont(font);
        txtTongChiTieu.setFont(font);
        cmbGioiTinh.setFont(font);

        JPanel pnMa = new TransparentPanel();
        pnMa.add(lblMa);
        pnMa.add(txtMa);
        pnTextField.add(pnMa);

        JPanel pnHo = new TransparentPanel();
        pnHo.add(lblHo);
        pnHo.add(txtHo);
        pnTextField.add(pnHo);

        JPanel pnTen = new TransparentPanel();
        pnTen.add(lblTen);
        pnTen.add(txtTen);
        pnTextField.add(pnTen);

        JPanel pnGioiTinh = new TransparentPanel();
        pnGioiTinh.add(lblGioiTinh);
        pnGioiTinh.add(cmbGioiTinh);
        pnTextField.add(pnGioiTinh);

        JPanel pnTongChiTieu = new TransparentPanel();
        pnTongChiTieu.add(lblTongChiTieu);
        pnTongChiTieu.add(txtTongChiTieu);
        pnTextField.add(pnTongChiTieu);

        Dimension lblSize = lblMa.getPreferredSize();
        lblMa.setPreferredSize(lblSize);
        lblHo.setPreferredSize(lblSize);
        lblTen.setPreferredSize(lblSize);
        lblGioiTinh.setPreferredSize(lblSize);
        lblTongChiTieu.setPreferredSize(lblSize);
        cmbGioiTinh.setPreferredSize(txtHo.getPreferredSize());

        pnTopKH.add(pnTextField);
        pnKhachHang.add(pnTopKH);

        //===============PANEL BUTTON=============
        JPanel pnButton = new TransparentPanel();
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Lưu");
        btnXoa = new JButton("Xoá");

        btnThem.setIcon(new ImageIcon("image/add-icon.png"));
        btnSua.setIcon(new ImageIcon("image/Pencil-icon.png"));
        btnXoa.setIcon(new ImageIcon("image/delete-icon.png"));
        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);

        btnThem.setFont(fontButton);
        btnSua.setFont(fontButton);
        btnXoa.setFont(fontButton);
        pnKhachHang.add(pnButton);

        pnButton.add(btnThem);
        pnButton.add(btnSua);
        pnButton.add(btnXoa);

        btnThem.setIcon(new ImageIcon("image/add-icon.png"));
        btnSua.setIcon(new ImageIcon("image/Pencil-icon.png"));
        btnXoa.setIcon(new ImageIcon("image/delete-icon.png"));
        Dimension btnSize = btnThem.getPreferredSize();
        btnThem.setPreferredSize(btnSize);
        btnSua.setPreferredSize(btnSize);
        btnXoa.setPreferredSize(btnSize);

        //====PANEL SEARCH=====
        JPanel pnTimKiem = new TransparentPanel();
        JLabel lblTimKiem = new JLabel("Từ khoá tìm");
        lblTimKiem.setFont(font);
        txtTukhoa = new JTextField(20);
        txtTukhoa.setFont(font);
        pnTimKiem.add(lblTimKiem);
        pnTimKiem.add(txtTukhoa);
        pnKhachHang.add(pnTimKiem);

        JPanel pnTimGioiHan = new TransparentPanel();
        JLabel lblMin = new JLabel("Chi tiêu từ:");
        JLabel lblMax = new JLabel("đến:");
        lblMin.setFont(font);
        lblMax.setFont(font);
        txtMinchiTieu = new JTextField(5);
        txtMinchiTieu.setHorizontalAlignment(JTextField.CENTER);
        txtMaxChiTieu = new JTextField(5);
        txtMaxChiTieu.setHorizontalAlignment(JTextField.CENTER);
        txtMinchiTieu.setFont(font);
        txtMaxChiTieu.setFont(font);
        btnTim = new JButton(new ImageIcon("image/Search-icon.png"));
        btnTim = new JButton(new ImageIcon("image/Search-icon.png"));
        pnTimGioiHan.add(lblMin);
        pnTimGioiHan.add(txtMinchiTieu);
        pnTimGioiHan.add(lblMax);
        pnTimGioiHan.add(txtMaxChiTieu);
        pnTimGioiHan.add(btnTim);
        pnKhachHang.add(pnTimGioiHan);
        //=========================TABLE=====================
        dtmKhachHang = new DefaultTableModel();
        dtmKhachHang.addColumn("Mã KH");
        dtmKhachHang.addColumn("Họ đệm");
        dtmKhachHang.addColumn("Tên");
        dtmKhachHang.addColumn("Giới tính");
        dtmKhachHang.addColumn("Tổng chi tiêu");

        tblKhachHang = new MyTable(dtmKhachHang);

        JScrollPane scrtblKhachHang = new JScrollPane(tblKhachHang);

        this.add(pnKhachHang, BorderLayout.NORTH);
        this.add(scrtblKhachHang, BorderLayout.CENTER);

        loadDataLenTableKhachHang();
    }

    private void addEvents() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataLenTableKhachHang();
                txtMa.setText("");
                txtHo.setText("");
                txtTen.setText("");
                txtTongChiTieu.setText("");
                txtTukhoa.setText("");
                txtMinchiTieu.setText("");
                txtMaxChiTieu.setText("");
                cmbGioiTinh.setSelectedIndex(0);
            }
        });

        tblKhachHang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyClicktblKhachHang();
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

        txtTukhoa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                xuLyLiveSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                xuLyLiveSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                xuLyLiveSearch();
            }
        });

        txtMinchiTieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaxChiTieu.requestFocus();
            }
        });

        txtMaxChiTieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnTim.doClick();
            }
        });

        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTimKiemTheoKhoang();
            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemKhachHang();
            }
        });

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaKhachHang();
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaKhachHang();
            }
        });
    }

    private void loadDataLenTableKhachHang() {
        khachHangBUS.docDanhSach();
        ArrayList<KhachHang> dskh = khachHangBUS.getListKhachHang();
        loadDataLenTableKhachHang(dskh);
    }

    private void loadDataLenTableKhachHang(ArrayList<KhachHang> dskh) {
        dtmKhachHang.setRowCount(0);
        DecimalFormat dcf = new DecimalFormat("###,###");
        for (KhachHang kh : dskh) {
            Vector vec = new Vector();
            vec.add(kh.getMaKH());
            vec.add(kh.getHo());
            vec.add(kh.getTen());
            vec.add(kh.getGioiTinh());
            vec.add(dcf.format(kh.getTongChiTieu()));
            dtmKhachHang.addRow(vec);
        }
    }

    private void xuLyClicktblKhachHang() {
        int row = tblKhachHang.getSelectedRow();
        if (row > -1) {
            txtMa.setText(tblKhachHang.getValueAt(row, 0) + "");
            txtHo.setText(tblKhachHang.getValueAt(row, 1) + "");
            txtTen.setText(tblKhachHang.getValueAt(row, 2) + "");
            int index = tblKhachHang.getValueAt(row, 3).equals("Nam") ? 1 : 2;
            cmbGioiTinh.setSelectedIndex(index);
            txtTongChiTieu.setText(tblKhachHang.getValueAt(row, 4) + "");
        }
    }

    private void xuLyTimKiemTheoKhoang() {
        ArrayList<KhachHang> dskh = khachHangBUS.timKiemKhachHang(txtMinchiTieu.getText(), txtMaxChiTieu.getText());
        if (dskh == null)
            return;
        loadDataLenTableKhachHang(dskh);
    }

    private void xuLyLiveSearch() {
        ArrayList<KhachHang> dskh = khachHangBUS.timKiemKhachHang(txtTukhoa.getText());
        loadDataLenTableKhachHang(dskh);
    }

    private void xuLyThemKhachHang() {
        if (khachHangBUS.themKhachHang(txtHo.getText(), txtTen.getText(), cmbGioiTinh.getSelectedItem() + ""))
            btnReset.doClick();
    }

    private void xuLySuaKhachHang() {
        if (khachHangBUS.suaKhachHang(txtMa.getText(), txtHo.getText(), txtTen.getText(), cmbGioiTinh.getSelectedItem() + ""))
            btnReset.doClick();
    }

    private void xuLyXoaKhachHang() {
        if(khachHangBUS.xoaKhachHang(txtMa.getText()))
            btnReset.doClick();
    }
}
