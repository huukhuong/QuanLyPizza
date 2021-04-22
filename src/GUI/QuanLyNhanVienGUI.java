package GUI;

import static Main.Main.changLNF;

import BUS.NhanVienBUS;
import BUS.PhanQuyenBUS;
import DTO.NhanVien;
import DTO.PhanQuyen;
import MyCustom.MyDialog;
import MyCustom.MyTable;
import MyCustom.TransparentPanel;
import MyCustom.XuLyFileExcel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVienGUI extends JPanel {

    public QuanLyNhanVienGUI() {
        changLNF("Windows");
        addControlsNhanVien();
        addEventsNhanVien();
    }

    private PhanQuyenBUS phanQuyenBUS = new PhanQuyenBUS();
    private NhanVienBUS nhanVienBUS = new NhanVienBUS();

    JLabel lblTabbedNhanVien, lblTabbedQuyen;
    final ImageIcon tabbedSelected = new ImageIcon("image/ManagerUI/tabbed-btn--selected.png");
    final ImageIcon tabbedDefault = new ImageIcon("image/ManagerUI/tabbed-btn.png");
    final Color colorPanel = new Color(247, 247, 247);
    CardLayout cardNhanVienGroup = new CardLayout();
    JPanel pnCardTabNhanVien;
    JTextField txtMaNV, txtHo, txtTen, txtChucVu, txtTimNV;
    JComboBox<String> cmbGioiTinh;
    MyTable tblNhanVien;
    DefaultTableModel dtmNhanVien;
    JButton btnReset, btnThemNV, btnSuaNV, btnXoaNV, btnTimNV, btnCapTaiKhoan, btnResetMatKhau, btnXuatExcel, btnNhapExcel;

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
        txtHo = new JTextField(25);
        txtTen = new JTextField(25);
        cmbGioiTinh = new JComboBox<>();
        txtChucVu = new JTextField(25);

        txtMaNV.setFont(font);
        txtHo.setFont(font);
        txtTen.setFont(font);
        cmbGioiTinh.setFont(font);
        txtChucVu.setFont(font);

        cmbGioiTinh.addItem("Chọn giới tính");
        cmbGioiTinh.addItem("Nam");
        cmbGioiTinh.addItem("Nữ");

        JLabel lblMa, lblHo, lblTen, lblGioiTinh, lblChucVu;

        lblMa = new JLabel("Mã Nhân viên");
        lblHo = new JLabel("Họ đệm");
        lblTen = new JLabel("Tên");
        lblGioiTinh = new JLabel("Giới tính");
        lblChucVu = new JLabel("Chức vụ");

        lblMa.setFont(font);
        lblHo.setFont(font);
        lblTen.setFont(font);
        lblGioiTinh.setFont(font);
        lblChucVu.setFont(font);

        JPanel pnMa = new TransparentPanel();
        pnMa.add(lblMa);
        pnMa.add(txtMaNV);
        pnText.add(pnMa);

        JPanel pnHo = new TransparentPanel();
        pnHo.add(lblHo);
        pnHo.add(txtHo);
        pnText.add(pnHo);

        JPanel pnTen = new TransparentPanel();
        pnTen.add(lblTen);
        pnTen.add(txtTen);
        pnText.add(pnTen);

        JPanel pnGioiTinh = new TransparentPanel();
        pnGioiTinh.add(lblGioiTinh);
        pnGioiTinh.add(cmbGioiTinh);
        pnText.add(pnGioiTinh);

        JPanel pnChucVu = new TransparentPanel();
        pnChucVu.add(lblChucVu);
        pnChucVu.add(txtChucVu);
        pnText.add(pnChucVu);

        Dimension lblSize = lblMa.getPreferredSize();
        lblMa.setPreferredSize(lblSize);
        lblHo.setPreferredSize(lblSize);
        lblTen.setPreferredSize(lblSize);
        lblGioiTinh.setPreferredSize(lblSize);
        lblChucVu.setPreferredSize(lblSize);
        cmbGioiTinh.setPreferredSize(txtChucVu.getPreferredSize());

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

        btnThemNV = new JButton("Thêm");
        btnSuaNV = new JButton("Lưu");
        btnXoaNV = new JButton("Xoá");
        btnTimNV = new JButton("Tìm kiếm");
        btnXuatExcel = new JButton("Xuất");
        btnNhapExcel = new JButton("Nhập");

        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
        btnThemNV.setFont(fontButton);
        btnSuaNV.setFont(fontButton);
        btnXoaNV.setFont(fontButton);
        btnTimNV.setFont(fontButton);
        btnXuatExcel.setFont(fontButton);
        btnNhapExcel.setFont(fontButton);

        btnThemNV.setIcon(new ImageIcon("image/add-icon.png"));
        btnSuaNV.setIcon(new ImageIcon("image/Pencil-icon.png"));
        btnXoaNV.setIcon(new ImageIcon("image/delete-icon.png"));
        btnTimNV.setIcon(new ImageIcon("image/Search-icon.png"));
        btnXuatExcel.setIcon(new ImageIcon("image/excel-icon.png"));
        btnNhapExcel.setIcon(new ImageIcon("image/excel-icon.png"));

        pnButton.add(btnThemNV);
        pnButton.add(btnSuaNV);
        pnButton.add(btnXoaNV);
        pnButton.add(btnTimNV);
        pnButton.add(btnXuatExcel);
        pnButton.add(btnNhapExcel);

        Dimension btnSize = btnTimNV.getPreferredSize();
        btnThemNV.setPreferredSize(btnSize);
        btnSuaNV.setPreferredSize(btnSize);
        btnXoaNV.setPreferredSize(btnSize);
        btnTimNV.setPreferredSize(btnSize);
        btnXuatExcel.setPreferredSize(btnSize);
        btnNhapExcel.setPreferredSize(btnSize);

        pnTopNV.add(pnButton);
        pnNhanVien.add(pnTopNV, BorderLayout.NORTH);

        //===================TABLE NHÂN VIÊN=====================
        dtmNhanVien = new DefaultTableModel();
        dtmNhanVien.addColumn("Mã NV");
        dtmNhanVien.addColumn("Họ đệm");
        dtmNhanVien.addColumn("Tên");
        dtmNhanVien.addColumn("Giới tính");
        dtmNhanVien.addColumn("Chức vụ");

        tblNhanVien = new MyTable(dtmNhanVien);
        JScrollPane scrTblNhanVien = new JScrollPane(tblNhanVien);
        pnNhanVien.add(scrTblNhanVien, BorderLayout.CENTER);
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

        loadDataTblNhanVien();
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

        tblNhanVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyClickTblNhanVien();
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

        txtTimNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTimKiemNhanVien();
            }
        });

        btnTimNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTimKiemNhanVien();
            }
        });

        btnThemNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemNhanVien();
            }
        });

        btnSuaNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaNhanVien();
            }
        });

        btnXoaNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaNhanVien();
            }
        });

        btnXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXuatExcel();
            }
        });

        btnNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyNhapExcel();
            }
        });
    }

    private void xuLyNhapExcel() {
        XuLyFileExcel nhapExcel = new XuLyFileExcel();
        nhapExcel.nhapExcel(tblNhanVien);

        int row = tblNhanVien.getRowCount();
        for (int i = 0; i < row; i++) {
            String ho = tblNhanVien.getValueAt(i, 1) + "";
            String ten = tblNhanVien.getValueAt(i, 2) + "";
            String gioiTinh = tblNhanVien.getValueAt(i, 3) + "";
            String chucVu = tblNhanVien.getValueAt(i, 4) + "";

            nhanVienBUS.nhapExcel(ho, ten, gioiTinh, chucVu);
        }
    }

    private void xuLyXuatExcel() {
        XuLyFileExcel xuatExcel = new XuLyFileExcel();
        xuatExcel.xuatExcel(tblNhanVien);
    }

    private void xuLyXoaNhanVien() {
        String ma = txtMaNV.getText();
        boolean flag = nhanVienBUS.xoaNhanVien(ma);
        if (flag) {
            nhanVienBUS.docDanhSach();
            loadDataTblNhanVien();
        }
    }

    private void xuLySuaNhanVien() {
        if (cmbGioiTinh.getSelectedIndex() == 0) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return;
        }
        String ma = txtMaNV.getText();
        String ho = txtHo.getText();
        String ten = txtTen.getText();
        String gioiTinh = cmbGioiTinh.getSelectedItem() + "";
        String chucVu = txtChucVu.getText();
        if (nhanVienBUS.updateNhanVien(ma, ho, ten, gioiTinh, chucVu)) {
            nhanVienBUS.docDanhSach();
            loadDataTblNhanVien();
        }
    }

    private void xuLyThemNhanVien() {
        if (cmbGioiTinh.getSelectedIndex() == 0) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return;
        }
        String ho = txtHo.getText();
        String ten = txtTen.getText();
        String gioiTinh = cmbGioiTinh.getSelectedItem() + "";
        String chucVu = txtChucVu.getText();
        if (nhanVienBUS.themNhanVien(ho, ten, gioiTinh, chucVu)) {
            nhanVienBUS.docDanhSach();
            loadDataTblNhanVien();
        }
    }

    private void xuLyTimKiemNhanVien() {
        ArrayList<NhanVien> dsnv = nhanVienBUS.timNhanVien(txtTimNV.getText());
        dtmNhanVien.setRowCount(0);
        for (NhanVien nv : dsnv) {
            Vector vec = new Vector();
            vec.add(nv.getMaNV());
            vec.add(nv.getHo());
            vec.add(nv.getTen());
            vec.add(nv.getGioiTinh());
            vec.add(nv.getChucVu());
            dtmNhanVien.addRow(vec);
        }
    }

    private void xuLyClickTblNhanVien() {
        int row = tblNhanVien.getSelectedRow();
        if (row > -1) {
            txtMaNV.setText(tblNhanVien.getValueAt(row, 0) + "");
            txtHo.setText(tblNhanVien.getValueAt(row, 1) + "");
            txtTen.setText(tblNhanVien.getValueAt(row, 2) + "");
            txtChucVu.setText(tblNhanVien.getValueAt(row, 4) + "");

            String gioiTinh = "";
            if ((tblNhanVien.getValueAt(row, 3) + "").equals("Nam")) {
                cmbGioiTinh.setSelectedIndex(1);
            } else {
                cmbGioiTinh.setSelectedIndex(2);
            }
        }
    }

    private void loadDataTblNhanVien() {
        dtmNhanVien.setRowCount(0);
        ArrayList<NhanVien> dsnv = nhanVienBUS.getDanhSachNhanVien();

        for (NhanVien nv : dsnv) {
            Vector vec = new Vector();
            vec.add(nv.getMaNV());
            vec.add(nv.getHo());
            vec.add(nv.getTen());
            vec.add(nv.getGioiTinh());
            vec.add(nv.getChucVu());
            dtmNhanVien.addRow(vec);
        }
    }

}
