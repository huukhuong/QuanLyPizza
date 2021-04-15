package GUI;

import BUS.LoaiBUS;
import BUS.SanPhamBUS;
import DTO.LoaiSP;
import DTO.SanPham;
import static Main.Main.changLNF;
import MyCustom.MyDialog;
import MyCustom.TransparentPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class SanPhamGUI extends JPanel {

    public SanPhamGUI() {
        changLNF("Windows");
        addControlsSanPham();
        addEventsSanPham();
    }

    SanPhamBUS spBUS = new SanPhamBUS();
    LoaiBUS loaiBUS = new LoaiBUS();
    final Color colorPanel = new Color(247, 247, 247);
    JTable tblSanPham;
    DefaultTableModel dtmSanPham;
    JTextField txtMa, txtTen, txtsoLuong, txtdonViTinh, txtdonGia, txtTimKiem;
    JComboBox<String> cmbLoai;
    JButton btnThem, btnSua, btnXoa, btnTim, btnChonAnh, btnReset;
    JLabel lblAnhSP;

    private void addControlsSanPham() {
        Font font = new Font("Tahoma", Font.PLAIN, 20);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(colorPanel);

        int w = 1030;
        int h = 844;

        JPanel pnTitle = new TransparentPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ SẢN PHẨM</h1></html>");
        btnReset = new JButton(new ImageIcon("image/Refresh-icon.png"));
        btnReset.setPreferredSize(new Dimension(40, 40));
        pnTitle.add(lblTitle);
        pnTitle.add(btnReset);
        this.add(pnTitle);

        JPanel pnThongTin = new TransparentPanel();
        pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.X_AXIS));

        //================PANEL INPUT=========
        JPanel pnTextField = new TransparentPanel();
        pnTextField.setLayout(new BoxLayout(pnTextField, BoxLayout.Y_AXIS));
        JLabel lblMa, lblTen, lblLoai, lblSoLuong, lblDonViTinh, lblDonGia;

        lblMa = new JLabel("Mã SP");
        lblTen = new JLabel("Tên SP");
        lblLoai = new JLabel("Loại");
        lblSoLuong = new JLabel("Số lượng");
        lblDonViTinh = new JLabel("Đơn vị tính");
        lblDonGia = new JLabel("Đơn giá");

        txtMa = new JTextField(15);
        txtMa.setEditable(false);
        txtTen = new JTextField(15);
        cmbLoai = new JComboBox<String>();
        txtsoLuong = new JTextField(15);
        txtdonViTinh = new JTextField(15);
        txtdonGia = new JTextField(15);

        JPanel pnMa = new TransparentPanel();
        lblMa.setFont(font);
        txtMa.setFont(font);
        pnMa.add(lblMa);
        pnMa.add(txtMa);
        pnTextField.add(pnMa);

        JPanel pnTen = new TransparentPanel();
        lblTen.setFont(font);
        txtTen.setFont(font);
        pnTen.add(lblTen);
        pnTen.add(txtTen);
        pnTextField.add(pnTen);

        JPanel pnLoai = new TransparentPanel();
        lblLoai.setFont(font);
        cmbLoai.setFont(font);
        cmbLoai.setPreferredSize(txtMa.getPreferredSize());
        pnLoai.add(lblLoai);
        pnLoai.add(cmbLoai);
        pnTextField.add(pnLoai);

        JPanel pnSoLuong = new TransparentPanel();
        lblSoLuong.setFont(font);
        txtsoLuong.setFont(font);
        pnSoLuong.add(lblSoLuong);
        pnSoLuong.add(txtsoLuong);
        pnTextField.add(pnSoLuong);

        JPanel pnDonViTinh = new TransparentPanel();
        lblDonViTinh.setFont(font);
        txtdonViTinh.setFont(font);
        pnDonViTinh.add(lblDonViTinh);
        pnDonViTinh.add(txtdonViTinh);
        pnTextField.add(pnDonViTinh);

        JPanel pnDonGia = new TransparentPanel();
        lblDonGia.setFont(font);
        txtdonGia.setFont(font);
        pnDonGia.add(lblDonGia);
        pnDonGia.add(txtdonGia);
        pnTextField.add(pnDonGia);

        Dimension lblSize = lblDonViTinh.getPreferredSize();
        lblMa.setPreferredSize(lblSize);
        lblTen.setPreferredSize(lblSize);
        lblLoai.setPreferredSize(lblSize);
        lblSoLuong.setPreferredSize(lblSize);
        lblDonViTinh.setPreferredSize(lblSize);
        lblDonGia.setPreferredSize(lblSize);

        pnThongTin.add(pnTextField);

        //=================PANEL ẢNH==========
        JPanel pnAnh = new TransparentPanel();
        pnAnh.setLayout(new BoxLayout(pnAnh, BoxLayout.Y_AXIS));

        JPanel pnChuaAnh = new TransparentPanel();
        pnChuaAnh.setPreferredSize(new Dimension((int) pnAnh.getPreferredSize().getWidth(), 250));
        lblAnhSP = new JLabel();
        lblAnhSP.setPreferredSize(new Dimension(200, 200));
        lblAnhSP.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblAnhSP.setIcon(getAnhSP(""));
        pnChuaAnh.add(lblAnhSP);
        pnAnh.add(pnChuaAnh);

        JPanel pnButtonAnh = new TransparentPanel();
        pnButtonAnh.setPreferredSize(new Dimension(
                (int) pnChuaAnh.getPreferredSize().getHeight(), 40));
        btnChonAnh = new JButton("Chọn ảnh");
        btnChonAnh.setFont(font);
        pnButtonAnh.add(btnChonAnh);
        pnChuaAnh.add(pnButtonAnh);

        pnThongTin.add(pnAnh);
        this.add(pnThongTin);

        JPanel pnButton = new TransparentPanel();

        btnThem = new JButton("Thêm");
        btnSua = new JButton("Lưu");
        btnXoa = new JButton("Xoá");
        btnTim = new JButton("Tìm kiếm");

        btnThem.setFont(font);
        btnSua.setFont(font);
        btnXoa.setFont(font);
        btnTim.setFont(font);

        btnThem.setIcon(new ImageIcon("image/add-icon.png"));
        btnSua.setIcon(new ImageIcon("image/Pencil-icon.png"));
        btnXoa.setIcon(new ImageIcon("image/delete-icon.png"));
        btnTim.setIcon(new ImageIcon("image/Search-icon.png"));

        JPanel pnTimKiem = new TransparentPanel();
        JLabel lblTimKiem = new JLabel("Từ khoá tìm");
        lblTimKiem.setFont(font);
        txtTimKiem = new JTextField(20);
        txtTimKiem.setFont(font);
        pnTimKiem.add(lblTimKiem);
        pnTimKiem.add(txtTimKiem);
        this.add(pnTimKiem);

        pnButton.add(btnThem);
        pnButton.add(btnSua);
        pnButton.add(btnXoa);
        pnButton.add(btnTim);

//        btnTim.setPreferredSize(new Dimension(120, 40));
        Dimension btnSize = btnTim.getPreferredSize();
        btnThem.setPreferredSize(btnSize);
        btnSua.setPreferredSize(btnSize);
        btnXoa.setPreferredSize(btnSize);
        btnTim.setPreferredSize(btnSize);

        this.add(pnButton);

        //============PANEL BẢNG===========
        JPanel pnTable = new TransparentPanel(new BorderLayout());
        //====================Bảng hàng hoá====================
        //<editor-fold defaultstate="collapsed" desc="Bảng sản phẩm">
        dtmSanPham = new DefaultTableModel();
        dtmSanPham.addColumn("Mã SP");
        dtmSanPham.addColumn("Tên SP");
        dtmSanPham.addColumn("Loại SP");
        dtmSanPham.addColumn("Đơn giá");
        dtmSanPham.addColumn("Số lượng");
        dtmSanPham.addColumn("Đơn vị tính");
        dtmSanPham.addColumn("Ảnh");
        tblSanPham = new JTable(dtmSanPham);

        customTable(tblSanPham);

        tblSanPham.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        TableColumnModel columnModelBanHang = tblSanPham.getColumnModel();
        columnModelBanHang.getColumn(0).setPreferredWidth(77);
        columnModelBanHang.getColumn(1).setPreferredWidth(282);
        columnModelBanHang.getColumn(2).setPreferredWidth(120);
        columnModelBanHang.getColumn(3).setPreferredWidth(85);
        columnModelBanHang.getColumn(4).setPreferredWidth(138);
        columnModelBanHang.getColumn(5).setPreferredWidth(140);
        columnModelBanHang.getColumn(6).setPreferredWidth(0);

        JScrollPane scrTblSanPham = new JScrollPane(tblSanPham);
        //</editor-fold>
        pnTable.add(scrTblSanPham, BorderLayout.CENTER);
        this.add(pnTable);

        loadDataCmbLoai();
        loadDataLenBangSanPham();
    }

    private void addEventsSanPham() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAnh("");
                loadDataLenBangSanPham();
                txtMa.setText("");
                txtTen.setText("");
                txtdonGia.setText("");
                txtdonViTinh.setText("");
                txtsoLuong.setText("");
                cmbLoai.setSelectedIndex(0);
            }
        });

        tblSanPham.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyClickTblSanPham();
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

        cmbLoai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemLoai();
            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemSanPham();
            }
        });

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaSanPham();
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaSanPham();
            }
        });

        btnChonAnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChonAnh();
            }
        });

        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTimKiem();
            }
        });

        txtTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTimKiem();
            }
        });
    }

    private void loadAnh(String anh) {
        lblAnhSP.setIcon(getAnhSP(anh));
    }

    File fileAnhSP;

    private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        //Xử lý ảnh
        BufferedImage img = null;
        File fileImg = new File("image/SanPham/" + src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("image/SanPham/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileAnhSP = new File("image/SanPham/" + src);
        } catch (IOException e) {
            fileAnhSP = new File("image/SanPham/default.png");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

            return new ImageIcon(dimg);
        }
        return null;
    }

    //<editor-fold defaultstate="collapsed" desc="Custom table">
    private void customTable(JTable tbl) {
        //======CUSTOM TABLE=======
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.setRowHeight(25);
        tbl.setSelectionBackground(new Color(50, 154, 114));
        tbl.setSelectionForeground(Color.white);
        tbl.setFont(new Font("Arial", Font.PLAIN, 16));

        JTableHeader header = tbl.getTableHeader();
        header.setBackground(new Color(242, 153, 74));
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setOpaque(false);
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        //======/CUSTOM TABLE/=======
    }
//</editor-fold>

    private void xuLyClickTblSanPham() {
        int row = tblSanPham.getSelectedRow();
        if (row > -1) {
            String ma = tblSanPham.getValueAt(row, 0) + "";
            String ten = tblSanPham.getValueAt(row, 1) + "";
            String loai = tblSanPham.getValueAt(row, 2) + "";
            String donGia = tblSanPham.getValueAt(row, 3) + "";
            String soLuong = tblSanPham.getValueAt(row, 4) + "";
            String donViTinh = tblSanPham.getValueAt(row, 5) + "";
            String anh = tblSanPham.getValueAt(row, 6) + "";

            txtMa.setText(ma);
            txtTen.setText(ten);
            txtdonGia.setText(donGia);
            txtsoLuong.setText(soLuong);
            txtdonViTinh.setText(donViTinh.replace(",", ""));

            int flag = 0;
            for (int i = 0; i < cmbLoai.getItemCount(); i++) {
                if (cmbLoai.getItemAt(i).contains(loai)) {
                    flag = i;
                    break;
                }
            }
            cmbLoai.setSelectedIndex(flag);
            loadAnh(anh);
        }
    }

    private void loadDataLenBangSanPham() {
        changLNF("Windows");
        spBUS.docListSanPham();
        dtmSanPham.setRowCount(0);

        ArrayList<SanPham> dssp = spBUS.getListSanPham();

        DecimalFormat dcf = new DecimalFormat("###,###");

        for (SanPham sp : dssp) {
            Vector vec = new Vector();
            vec.add(sp.getMaSP());
            vec.add(sp.getTenSP());
            String tenLoai = loaiBUS.getTenLoai(sp.getMaLoai());
            vec.add(tenLoai);
            vec.add(dcf.format(sp.getDonGia()));
            vec.add(dcf.format(sp.getSoLuong()));
            vec.add(sp.getDonViTinh());
            vec.add(sp.getHinhAnh());
            dtmSanPham.addRow(vec);
        }
    }

    private void loadDataCmbLoai() {
        cmbLoai.removeAllItems();

        ArrayList<LoaiSP> dsl = loaiBUS.getDanhSachLoai();
        cmbLoai.addItem("0 - Chọn loại");
        for (LoaiSP loai : dsl) {
            if (!loai.getTenLoai().equalsIgnoreCase("Nguyên liệu")) {
                cmbLoai.addItem(loai.getMaLoai() + " - " + loai.getTenLoai());
            }
        }
        cmbLoai.addItem("Khác...");
    }

    private void xuLyThemLoai() {
        int x = cmbLoai.getSelectedIndex();
        if (x == cmbLoai.getItemCount() - 1) {
            QuanLyLoaiGUI loaiGUI = new QuanLyLoaiGUI();
            loaiGUI.setVisible(true);
            loadDataCmbLoai();
        }
    }

    private void xuLyThemSanPham() {
        String anh = fileAnhSP.getName();
        boolean flag = spBUS.themSanPham(txtTen.getText(),
                cmbLoai.getSelectedItem() + "",
                txtsoLuong.getText(),
                txtdonViTinh.getText(),
                anh,
                txtdonGia.getText());
        if (flag) {
            loadDataLenBangSanPham();
        }
    }

    private void xuLySuaSanPham() {
        String anh = fileAnhSP.getName();
        boolean flag = spBUS.suaSanPham(txtMa.getText(),
                txtTen.getText(),
                cmbLoai.getSelectedItem() + "",
                txtsoLuong.getText(),
                txtdonViTinh.getText(),
                anh,
                txtdonGia.getText());
        if (flag) {
            loadDataLenBangSanPham();
        }
    }

    private void xuLyXoaSanPham() {
        MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if (dlg.OK_OPTION == dlg.getAction()) {
            boolean flag = spBUS.xoaSanPham(txtMa.getText());
            if (flag) {
                loadDataLenBangSanPham();
            }
        }
    }

    private void xuLyChonAnh() {
        JFileChooser fileChooser = new JFileChooser("image/SanPham/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Tệp hình ảnh", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String name = fileChooser.getSelectedFile().getName();
            lblAnhSP.setIcon(getAnhSP(name));
        }
    }

    private void xuLyTimKiem() {
        String ten = txtTimKiem.getText().toLowerCase();
        dtmSanPham.setRowCount(0);
        ArrayList<SanPham> dssp = null;
        dssp = spBUS.getSanPhamTheoTen(ten);
        DecimalFormat dcf = new DecimalFormat("###,###");
        for (SanPham sp : dssp) {
            Vector vec = new Vector();
            vec.add(sp.getMaSP());
            vec.add(sp.getTenSP());
            String tenLoai = loaiBUS.getTenLoai(sp.getMaLoai());
            vec.add(tenLoai);
            vec.add(dcf.format(sp.getDonGia()));
            vec.add(dcf.format(sp.getSoLuong()));
            vec.add(sp.getDonViTinh());
            vec.add(sp.getHinhAnh());
            dtmSanPham.addRow(vec);
        }
        MyDialog dlg = new MyDialog("Số kết quả tìm được: " + dssp.size(), MyDialog.INFO_DIALOG);
    }
}
