package QuanLyPizza.GUI;

import QuanLyPizza.BUS.DangNhapBUS;
import QuanLyPizza.BUS.NhanVienBUS;
import QuanLyPizza.BUS.SanPhamBUS;
import QuanLyPizza.DTO.CTPhieuNhap;
import QuanLyPizza.DTO.NhanVien;
import QuanLyPizza.DTO.SanPham;
import MyCustom.MyDialog;
import MyCustom.MyTable;
import QuanLyPizza.BUS.CTPhieuNhapBUS;
import QuanLyPizza.BUS.PhieuNhapBUS;
import QuanLyPizza.DTO.PhieuNhap;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PnQuanLyNhapHangGUI extends javax.swing.JPanel {

    public PnQuanLyNhapHangGUI() {
        initComponents();
        customControls();
        loadDataCmbNhanVien();
        loadDataTableKho();
        loadDataTablePhieuNhap();
        loadDataTableCTPhieuNhap();
    }

    private SanPhamBUS sanPhamBUS = new SanPhamBUS();
    private NhanVienBUS nhanVienBUS = new NhanVienBUS();
    private PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();
    private CTPhieuNhapBUS ctPhieuNhapBUS = new CTPhieuNhapBUS();
    private DefaultTableModel dtmKho, dtmGioNhap, dtmPhieuNhap, dtmCTPhieuNhap;

    private void customControls() {
        dtmKho = new DefaultTableModel();
        dtmKho.addColumn("Mã SP");
        dtmKho.addColumn("Tên SP");
        dtmKho.addColumn("Tồn kho");
        tblKho.setModel(dtmKho);

        dtmGioNhap = new DefaultTableModel();
        dtmGioNhap.addColumn("Mã SP");
        dtmGioNhap.addColumn("Tên SP");
        dtmGioNhap.addColumn("Số lượng");
        dtmGioNhap.addColumn("Đơn giá");
        dtmGioNhap.addColumn("Thành tiền");
        tblGioNhap.setModel(dtmGioNhap);

        tblKho.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblKho.getColumnModel().getColumn(1).setPreferredWidth(440);
        tblKho.getColumnModel().getColumn(2).setPreferredWidth(67);

        tblGioNhap.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblGioNhap.getColumnModel().getColumn(1).setPreferredWidth(225);
        tblGioNhap.getColumnModel().getColumn(2).setPreferredWidth(42);
        tblGioNhap.getColumnModel().getColumn(3).setPreferredWidth(78);
        tblGioNhap.getColumnModel().getColumn(4).setPreferredWidth(77);

        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                btnTimKiem.doClick();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                btnTimKiem.doClick();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                btnTimKiem.doClick();
            }
        });
        btnTimKiem.setVisible(false);

        //====================================================================
        //====================================================================
        //====================================================================
        //====================================================================
        //====================================================================
        dtmPhieuNhap = new DefaultTableModel();
        dtmPhieuNhap.addColumn("Mã PN");
        dtmPhieuNhap.addColumn("Ngày lập");
        dtmPhieuNhap.addColumn("Tổng tiền");
        tblPhieuNhap.setModel(dtmPhieuNhap);
        tblPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(20);

        dtmCTPhieuNhap = new DefaultTableModel();
        dtmCTPhieuNhap.addColumn("Mã SP");
        dtmCTPhieuNhap.addColumn("Số lượng");
        dtmCTPhieuNhap.addColumn("Đơn giá");
        dtmCTPhieuNhap.addColumn("Thành tiền");

        tblCTPhieuNhap.setModel(dtmCTPhieuNhap);

        //=========================================================
        //================CENTER CÁC CELL CỦA TABLE================
        //=========================================================
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < dtmKho.getColumnCount(); i++) {
            tblKho.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < dtmGioNhap.getColumnCount(); i++) {
            tblGioNhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < dtmPhieuNhap.getColumnCount(); i++) {
            tblPhieuNhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < dtmCTPhieuNhap.getColumnCount(); i++) {
            tblCTPhieuNhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        tabNhapHang = new javax.swing.JTabbedPane();
        pnNhapHang = new javax.swing.JPanel();
        pnTable = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnResetKho = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        scrTblKho = new javax.swing.JScrollPane();
        tblKho = new MyTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        scrTblGioNhap = new javax.swing.JScrollPane();
        tblGioNhap = new MyTable();
        pnThongTin = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        btnThemVaoGio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnXoaKhoiGio = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNhaCungCap = new javax.swing.JTextField();
        btnChonNhaCungCap = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbNhanVien = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        pnCTPhieuNhap = new javax.swing.JPanel();
        pnPhieuNhap = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnResetTabXemLai = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        txtMaPN = new javax.swing.JTextField();
        txtMaNCC = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        txtTongTienPN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new MyTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        txtGiaThap = new javax.swing.JTextField();
        txtGiaCao = new javax.swing.JTextField();
        txtTuNgay = new javax.swing.JTextField();
        txtDenNgay = new javax.swing.JTextField();
        pnThongTinCT = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTPhieuNhap = new MyTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        txtCTSanPham = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        txtCTSoLuong = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        txtCTDonGia = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        txtCTThanhTien = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(1033, 844));
        setMinimumSize(new java.awt.Dimension(1033, 844));
        setPreferredSize(new java.awt.Dimension(1033, 844));

        tabNhapHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        pnTable.setPreferredSize(new java.awt.Dimension(1033, 844));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Kho hàng");
        jPanel2.add(jLabel1);

        btnResetKho.setIcon(new javax.swing.ImageIcon("E:\\LapTrinhJava\\DoAn_QuanLyBanPizza\\image\\Refresh-icon.png")); // NOI18N
        btnResetKho.setPreferredSize(new java.awt.Dimension(40, 40));
        btnResetKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetKhoActionPerformed(evt);
            }
        });
        jPanel2.add(btnResetKho);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Tìm kiếm");
        jPanel15.add(jLabel12);

        txtTimKiem.setColumns(20);
        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel15.add(txtTimKiem);

        btnTimKiem.setIcon(new javax.swing.ImageIcon("E:\\LapTrinhJava\\DoAn_QuanLyBanPizza\\image\\Search-icon.png")); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel15.add(btnTimKiem);

        tblKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoMouseClicked(evt);
            }
        });
        scrTblKho.setViewportView(tblKho);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Hàng chờ nhập");
        jPanel3.add(jLabel2);

        tblGioNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblGioNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioNhapMouseClicked(evt);
            }
        });
        scrTblGioNhap.setViewportView(tblGioNhap);

        javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
        pnTable.setLayout(pnTableLayout);
        pnTableLayout.setHorizontalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTableLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnTableLayout.createSequentialGroup()
                        .addGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrTblGioNhap)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrTblKho, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnTableLayout.setVerticalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTableLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTblKho, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTblGioNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã SP");
        jLabel5.setPreferredSize(new java.awt.Dimension(56, 22));
        jPanel7.add(jLabel5);

        jTextField2.setEditable(false);
        jTextField2.setColumns(15);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jTextField2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Thông tin sản phẩm");
        jPanel5.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đơn giá nhập");
        jLabel4.setPreferredSize(new java.awt.Dimension(116, 22));
        jPanel6.add(jLabel4);

        txtDonGia.setColumns(15);
        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDonGia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(txtDonGia);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tên SP");
        jPanel8.add(jLabel6);

        jTextField3.setEditable(false);
        jTextField3.setColumns(15);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel8.add(jTextField3);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Thông tin phiếu nhập");
        jPanel4.add(jLabel7);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnThemVaoGio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThemVaoGio.setIcon(new javax.swing.ImageIcon("E:\\LapTrinhJava\\DoAn_QuanLyBanPizza\\image\\check-icon.png")); // NOI18N
        btnThemVaoGio.setText("Chọn nhập");
        btnThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoGioActionPerformed(evt);
            }
        });
        jPanel11.add(btnThemVaoGio);

        btnXoaKhoiGio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXoaKhoiGio.setIcon(new javax.swing.ImageIcon("E:\\LapTrinhJava\\DoAn_QuanLyBanPizza\\image\\delete-icon.png")); // NOI18N
        btnXoaKhoiGio.setText("Xoá");
        btnXoaKhoiGio.setPreferredSize(new java.awt.Dimension(141, 41));
        btnXoaKhoiGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiGioActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaKhoiGio);

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon("E:\\LapTrinhJava\\DoAn_QuanLyBanPizza\\image\\check-icon.png")); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        jPanel1.add(btnXacNhan);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Nhà cung cấp");

        txtNhaCungCap.setEditable(false);
        txtNhaCungCap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnChonNhaCungCap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnChonNhaCungCap.setText("...");
        btnChonNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonNhaCungCapActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nhân viên");

        cmbNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNhanVien.setEnabled(false);
        cmbNhanVien.setPreferredSize(new java.awt.Dimension(280, 28));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbNhanVien, 0, 332, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtNhaCungCap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChonNhaCungCap))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonNhaCungCap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Số lượng nhập");
        jPanel9.add(jLabel8);

        txtSoLuong.setColumns(15);
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel9.add(txtSoLuong);

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnNhapHangLayout = new javax.swing.GroupLayout(pnNhapHang);
        pnNhapHang.setLayout(pnNhapHangLayout);
        pnNhapHangLayout.setHorizontalGroup(
            pnNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhapHangLayout.createSequentialGroup()
                .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 383, Short.MAX_VALUE))
            .addGroup(pnNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhapHangLayout.createSequentialGroup()
                    .addGap(0, 691, Short.MAX_VALUE)
                    .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnNhapHangLayout.setVerticalGroup(
            pnNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
            .addGroup(pnNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnNhapHangLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        tabNhapHang.addTab("Nhập hàng", pnNhapHang);

        pnCTPhieuNhap.setLayout(new java.awt.BorderLayout());

        pnPhieuNhap.setPreferredSize(new java.awt.Dimension(350, 808));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("Phiếu nhập");
        jPanel22.add(jLabel17);

        btnResetTabXemLai.setIcon(new javax.swing.ImageIcon("E:\\LapTrinhJava\\DoAn_QuanLyBanPizza\\image\\Refresh-icon.png")); // NOI18N
        btnResetTabXemLai.setPreferredSize(new java.awt.Dimension(40, 40));
        btnResetTabXemLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTabXemLaiActionPerformed(evt);
            }
        });
        jPanel22.add(btnResetTabXemLai);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin PN"));

        txtMaPN.setEditable(false);
        txtMaPN.setColumns(15);
        txtMaPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaPN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaPN.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã PN"));
        jPanel18.add(txtMaPN);

        txtMaNCC.setEditable(false);
        txtMaNCC.setColumns(15);
        txtMaNCC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaNCC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã NCC"));
        jPanel18.add(txtMaNCC);

        txtMaNV.setEditable(false);
        txtMaNV.setColumns(15);
        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã NV"));
        jPanel18.add(txtMaNV);

        txtNgayLap.setEditable(false);
        txtNgayLap.setColumns(15);
        txtNgayLap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNgayLap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgayLap.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày lập"));
        jPanel18.add(txtNgayLap);

        txtTongTienPN.setEditable(false);
        txtTongTienPN.setColumns(15);
        txtTongTienPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTienPN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTongTienPN.setBorder(javax.swing.BorderFactory.createTitledBorder("Tổng tiền"));
        jPanel18.add(txtTongTienPN);

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã PN", "Ngày lập", "Tổng tiền"
            }
        ));
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jPanel26.setPreferredSize(new java.awt.Dimension(350, 91));

        txtGiaThap.setColumns(10);
        txtGiaThap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGiaThap.setBorder(javax.swing.BorderFactory.createTitledBorder("Giá từ"));
        txtGiaThap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaThapActionPerformed(evt);
            }
        });
        jPanel26.add(txtGiaThap);

        txtGiaCao.setColumns(10);
        txtGiaCao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGiaCao.setBorder(javax.swing.BorderFactory.createTitledBorder("tới"));
        txtGiaCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaCaoActionPerformed(evt);
            }
        });
        jPanel26.add(txtGiaCao);

        txtTuNgay.setColumns(10);
        txtTuNgay.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTuNgay.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ ngày"));
        txtTuNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuNgayActionPerformed(evt);
            }
        });
        jPanel26.add(txtTuNgay);

        txtDenNgay.setColumns(10);
        txtDenNgay.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDenNgay.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến ngày"));
        txtDenNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDenNgayActionPerformed(evt);
            }
        });
        jPanel26.add(txtDenNgay);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnPhieuNhapLayout = new javax.swing.GroupLayout(pnPhieuNhap);
        pnPhieuNhap.setLayout(pnPhieuNhapLayout);
        pnPhieuNhapLayout.setHorizontalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnPhieuNhapLayout.setVerticalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhieuNhapLayout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnCTPhieuNhap.add(pnPhieuNhap, java.awt.BorderLayout.WEST);

        pnThongTinCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(204, 204, 204)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Chi tiết phiếu nhập");
        jPanel23.add(jLabel18);

        tblCTPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblCTPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTPhieuNhap);

        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

        txtCTSanPham.setEditable(false);
        txtCTSanPham.setColumns(15);
        txtCTSanPham.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCTSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));
        jPanel20.add(txtCTSanPham);

        jPanel17.add(jPanel20);

        txtCTSoLuong.setEditable(false);
        txtCTSoLuong.setColumns(15);
        txtCTSoLuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCTSoLuong.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng"));
        jPanel19.add(txtCTSoLuong);

        jPanel17.add(jPanel19);

        txtCTDonGia.setEditable(false);
        txtCTDonGia.setColumns(15);
        txtCTDonGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCTDonGia.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn giá"));
        jPanel25.add(txtCTDonGia);

        jPanel17.add(jPanel25);

        txtCTThanhTien.setEditable(false);
        txtCTThanhTien.setColumns(15);
        txtCTThanhTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCTThanhTien.setBorder(javax.swing.BorderFactory.createTitledBorder("Thành tiền"));
        jPanel21.add(txtCTThanhTien);

        jPanel17.add(jPanel21);

        javax.swing.GroupLayout pnThongTinCTLayout = new javax.swing.GroupLayout(pnThongTinCT);
        pnThongTinCT.setLayout(pnThongTinCTLayout);
        pnThongTinCTLayout.setHorizontalGroup(
            pnThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnThongTinCTLayout.setVerticalGroup(
            pnThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinCTLayout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
        );

        pnCTPhieuNhap.add(pnThongTinCT, java.awt.BorderLayout.CENTER);

        tabNhapHang.addTab("Xem lại phiếu nhập", pnCTPhieuNhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataTableKho() {
        dtmKho.setRowCount(0);
        ArrayList<SanPham> dssp = sanPhamBUS.getListSanPham();
        for (SanPham sp : dssp) {
            if (sp.getMaLoai() != 1) {
                Vector vec = new Vector();
                vec.add(sp.getMaSP());
                vec.add(sp.getTenSP());
                vec.add(sp.getSoLuong());
                dtmKho.addRow(vec);
            }
        }
    }

    private void loadDataTableKho(String tuKhoa) {
        dtmKho.setRowCount(0);
        ArrayList<SanPham> dssp = sanPhamBUS.getSanPhamTheoTen(tuKhoa);
        for (SanPham sp : dssp) {
            if (sp.getMaLoai() != 1) {
                Vector vec = new Vector();
                vec.add(sp.getMaSP());
                vec.add(sp.getTenSP());
                vec.add(sp.getSoLuong());
                dtmKho.addRow(vec);
            }
        }
    }

    private void loadDataCmbNhanVien() {
        cmbNhanVien.removeAllItems();
        ArrayList<NhanVien> dsnv = nhanVienBUS.getDanhSachNhanVien();
        if (dsnv != null) {
            for (NhanVien nv : dsnv) {
                cmbNhanVien.addItem(nv.getMaNV() + " - " + nv.getHo() + " " + nv.getTen());
            }
        }

        for (int i = 0; i < cmbNhanVien.getItemCount(); i++) {
            String[] cmbValue = cmbNhanVien.getItemAt(i).split(" - ");
            if (cmbValue[0].equals(DangNhapBUS.taiKhoanLogin.getMaNhanVien() + "")) {
                cmbNhanVien.setSelectedIndex(i);
                break;
            }
        }
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
    DecimalFormat dcf = new DecimalFormat("###,###");

    private void loadDataTablePhieuNhap() {
        phieuNhapBUS.docDanhSach();
        ArrayList<PhieuNhap> dspn = phieuNhapBUS.getListPhieuNhap();
        duaDataVaoTablePhieuNhap(dspn);
    }

    private void duaDataVaoTablePhieuNhap(ArrayList<PhieuNhap> dspn) {
        if (dspn != null) {
            dtmPhieuNhap.setRowCount(0);
            for (PhieuNhap pn : dspn) {
                Vector vec = new Vector();
                vec.add(pn.getMaPN());
                vec.add(sdf.format(pn.getNgayLap()));
                vec.add(dcf.format(pn.getTongTien()));
                dtmPhieuNhap.addRow(vec);
            }
        }
    }

    private void loadDataTablePhieuNhapTheoGia(String giaThap, String giaCao) {
        phieuNhapBUS.docDanhSach();
        ArrayList<PhieuNhap> dspn = phieuNhapBUS.getListPhieuNhapTheoGia(giaThap, giaCao);
        duaDataVaoTablePhieuNhap(dspn);
    }

    private void loadDataTablePhieuNhapTheoNgay(String tuNgay, String denNgay) {
        phieuNhapBUS.docDanhSach();
        ArrayList<PhieuNhap> dspn = phieuNhapBUS.getListPhieuNhapTheoNgay(tuNgay, denNgay);
        duaDataVaoTablePhieuNhap(dspn);
    }

    private void loadDataTableCTPhieuNhap() {
        dtmCTPhieuNhap.setRowCount(0);
        ArrayList<CTPhieuNhap> dsct = ctPhieuNhapBUS.getListPhieuNhap();
        if (dsct != null) {
            for (CTPhieuNhap ct : dsct) {
                Vector vec = new Vector();
                vec.add(ct.getMaSP());
                vec.add(dcf.format(ct.getSoLuong()));
                vec.add(dcf.format(ct.getDonGia()));
                vec.add(dcf.format(ct.getThanhTien()));
                dtmCTPhieuNhap.addRow(vec);
            }
        }
    }

    private void loadDataTableCTPhieuNhap(String maPN) {
        dtmCTPhieuNhap.setRowCount(0);
        ArrayList<CTPhieuNhap> dsct = ctPhieuNhapBUS.getListPhieuNhap(maPN);
        if (dsct != null) {
            for (CTPhieuNhap ct : dsct) {
                Vector vec = new Vector();
                vec.add(ct.getMaSP());
                vec.add(dcf.format(ct.getSoLuong()));
                vec.add(dcf.format(ct.getDonGia()));
                vec.add(dcf.format(ct.getThanhTien()));
                dtmCTPhieuNhap.addRow(vec);
            }
        }
    }

    private void btnThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoGioActionPerformed
        int soLuong = 0;
        int donGia = 0;
        try {
            soLuong = Integer.parseInt(txtSoLuong.getText());
            donGia = Integer.parseInt(txtDonGia.getText());
        } catch (Exception e) {
            new MyDialog("Phải có số lượng và đơn giá nhập!", MyDialog.ERROR_DIALOG);
            return;
        }

        int row = tblKho.getSelectedRow();
        if (row > -1) {
            String maSP = tblKho.getValueAt(row, 0) + "";
            for (int i = 0; i < tblGioNhap.getRowCount(); i++) {
                if (maSP.equals(tblGioNhap.getValueAt(i, 0))) {
                    int soLuongCu = Integer.parseInt(tblGioNhap.getValueAt(i, 2) + "");
                    soLuong += soLuongCu;
                    int thanhTien = soLuong * donGia;
                    tblGioNhap.setValueAt(soLuong, i, 2);
                    tblGioNhap.setValueAt(donGia, i, 3);
                    tblGioNhap.setValueAt(thanhTien, i, 4);
                    return;
                }
            }
            String tenSP = tblKho.getValueAt(row, 1) + "";
            int thanhTien = soLuong * donGia;
            Vector vec = new Vector();
            vec.add(maSP);
            vec.add(tenSP);
            vec.add(soLuong);
            vec.add(donGia);
            vec.add(thanhTien);
            dtmGioNhap.addRow(vec);
        } else {
            new MyDialog("Chưa chọn sản phẩm để nhập!", MyDialog.ERROR_DIALOG);
        }
    }//GEN-LAST:event_btnThemVaoGioActionPerformed

    private void btnXoaKhoiGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiGioActionPerformed
        int row = tblGioNhap.getSelectedRow();

        if (row > -1) {
            dtmGioNhap.removeRow(row);
        } else {
            new MyDialog("Chưa chọn sao xoá :)", MyDialog.ERROR_DIALOG);
        }
    }//GEN-LAST:event_btnXoaKhoiGioActionPerformed

    private void tblKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoMouseClicked
        txtDonGia.setText("1");
        txtSoLuong.setText("1");
        tblGioNhap.clearSelection();
    }//GEN-LAST:event_tblKhoMouseClicked

    private void tblGioNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioNhapMouseClicked
        tblKho.clearSelection();
        int row = tblGioNhap.getSelectedRow();
        if (row > -1) {
            txtSoLuong.setText(tblGioNhap.getValueAt(row, 2) + "");
            txtDonGia.setText(tblGioNhap.getValueAt(row, 3) + "");
        }
    }//GEN-LAST:event_tblGioNhapMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        loadDataTableKho(txtTimKiem.getText());
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int row = tblGioNhap.getRowCount();
        if (row < 1) {
            new MyDialog("Chưa có gì để nhập hết á!", MyDialog.ERROR_DIALOG);
            return;
        }

        String nhaCungCap = txtNhaCungCap.getText();
        String nhanVien = cmbNhanVien.getSelectedItem() + "";

        if (nhaCungCap.equals("")) {
            new MyDialog("Hãy chọn nhà cung cấp!", MyDialog.ERROR_DIALOG);
            return;
        }

        ArrayList<CTPhieuNhap> dsct = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int maSP = Integer.parseInt(tblGioNhap.getValueAt(i, 0) + "");
            int soLuong = Integer.parseInt(tblGioNhap.getValueAt(i, 2) + "");
            int donGia = Integer.parseInt(tblGioNhap.getValueAt(i, 3) + "");
            int thanhTien = Integer.parseInt(tblGioNhap.getValueAt(i, 4) + "");
            CTPhieuNhap ctpn = new CTPhieuNhap(0, maSP, soLuong, donGia, thanhTien);
            dsct.add(ctpn);
        }
        XuatPhieuNhapGUI xuatPhieuNhap = new XuatPhieuNhapGUI(nhaCungCap, nhanVien, dsct);
        xuatPhieuNhap.setVisible(true);
        if (xuatPhieuNhap.getCheckNhap()) {
            dtmGioNhap.setRowCount(0);
            sanPhamBUS.docListSanPham();
            loadDataTableKho();
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnChonNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonNhaCungCapActionPerformed
        DlgChonNhaCungCap dlg = new DlgChonNhaCungCap();
        dlg.setVisible(true);

        if (dlg.getNhaCungCap() != null) {
            txtNhaCungCap.setText(dlg.getNhaCungCap().getMaNCC() + " - " + dlg.getNhaCungCap().getTenNCC());
        } else {
            txtNhaCungCap.setText("");
        }
    }//GEN-LAST:event_btnChonNhaCungCapActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        int row = tblPhieuNhap.getSelectedRow();
        if (row < 0) {
            return;
        }
        String maPN = tblPhieuNhap.getValueAt(row, 0) + "";
        PhieuNhap pn = phieuNhapBUS.timPhieuNhap(maPN);
        txtMaPN.setText(pn.getMaPN() + "");
        txtMaNCC.setText(pn.getMaNCC() + "");
        txtMaNV.setText(pn.getMaNV() + "");
        txtNgayLap.setText(sdf.format(pn.getNgayLap()));
        txtTongTienPN.setText(dcf.format(pn.getTongTien()));

        loadDataTableCTPhieuNhap(maPN);
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void btnResetTabXemLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTabXemLaiActionPerformed
        loadDataTableCTPhieuNhap();
        loadDataTablePhieuNhap();
    }//GEN-LAST:event_btnResetTabXemLaiActionPerformed

    private void tblCTPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhieuNhapMouseClicked
        int row = tblCTPhieuNhap.getSelectedRow();
        if (row < 0) {
            return;
        }
        String tenSP = sanPhamBUS.getTenSP(Integer.parseInt(tblCTPhieuNhap.getValueAt(row, 0) + ""));
        txtCTSanPham.setText(tenSP);
        txtCTSoLuong.setText(tblCTPhieuNhap.getValueAt(row, 1) + "");
        txtCTDonGia.setText(tblCTPhieuNhap.getValueAt(row, 2) + "");
        txtCTThanhTien.setText(tblCTPhieuNhap.getValueAt(row, 3) + "");
    }//GEN-LAST:event_tblCTPhieuNhapMouseClicked

    private void txtGiaThapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaThapActionPerformed
        txtGiaCao.requestFocus();
    }//GEN-LAST:event_txtGiaThapActionPerformed

    private void txtGiaCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaCaoActionPerformed
        loadDataTablePhieuNhapTheoGia(txtGiaThap.getText(), txtGiaCao.getText());
    }//GEN-LAST:event_txtGiaCaoActionPerformed

    private void txtTuNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuNgayActionPerformed
        txtDenNgay.requestFocus();
    }//GEN-LAST:event_txtTuNgayActionPerformed

    private void txtDenNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDenNgayActionPerformed
        loadDataTablePhieuNhapTheoNgay(txtTuNgay.getText(), txtDenNgay.getText());
    }//GEN-LAST:event_txtDenNgayActionPerformed

    private void btnResetKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetKhoActionPerformed
        sanPhamBUS.docListSanPham();
        loadDataTableKho();
        dtmGioNhap.setRowCount(0);
    }//GEN-LAST:event_btnResetKhoActionPerformed

// <editor-fold defaultstate="collapsed" desc="Variable">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonNhaCungCap;
    private javax.swing.JButton btnResetKho;
    private javax.swing.JButton btnResetTabXemLai;
    private javax.swing.JButton btnThemVaoGio;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoaKhoiGio;
    private javax.swing.JComboBox<String> cmbNhanVien;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel pnCTPhieuNhap;
    private javax.swing.JPanel pnNhapHang;
    private javax.swing.JPanel pnPhieuNhap;
    private javax.swing.JPanel pnTable;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JPanel pnThongTinCT;
    private javax.swing.JScrollPane scrTblGioNhap;
    private javax.swing.JScrollPane scrTblKho;
    private javax.swing.JTabbedPane tabNhapHang;
    private javax.swing.JTable tblCTPhieuNhap;
    private javax.swing.JTable tblGioNhap;
    private javax.swing.JTable tblKho;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTextField txtCTDonGia;
    private javax.swing.JTextField txtCTSanPham;
    private javax.swing.JTextField txtCTSoLuong;
    private javax.swing.JTextField txtCTThanhTien;
    private javax.swing.JTextField txtDenNgay;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaCao;
    private javax.swing.JTextField txtGiaThap;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtNhaCungCap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTienPN;
    private javax.swing.JTextField txtTuNgay;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

}
