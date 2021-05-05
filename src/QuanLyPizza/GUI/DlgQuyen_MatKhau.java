package QuanLyPizza.GUI;

import QuanLyPizza.BUS.PhanQuyenBUS;
import QuanLyPizza.BUS.TaiKhoanBUS;
import QuanLyPizza.DTO.PhanQuyen;
import MyCustom.MyDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class DlgQuyen_MatKhau extends javax.swing.JDialog {

    private String maNV;

    public DlgQuyen_MatKhau(String maNV) {
        this.maNV = maNV;
        initComponents();
        this.setTitle("Chỉnh sửa tài khoản");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("image/ManagerUI/icon-app.png");
        this.setIconImage(icon);

        loadDataCmbQuyen();
    }
    private PhanQuyenBUS phanQuyenBUS = new PhanQuyenBUS();
    private TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();

    private void loadDataCmbQuyen() {
        txtMatKhau_MaNV.setText(maNV);
        txtQuyen_MaNV.setText(maNV);

        String tenDangNhap = taiKhoanBUS.getTenDangNhapTheoMa(maNV);
        if (tenDangNhap.equals("")) {
            new MyDialog("Nhân viên này chưa có tài khoản!", MyDialog.ERROR_DIALOG);
            btnCapMatKhau.setEnabled(false);
            btnLuuQuyen.setEnabled(false);
        }
        txtMatKhau_TenDangNhap.setText(tenDangNhap);

        cmbQuyen.removeAllItems();
        phanQuyenBUS.docDanhSachQuyen();
        ArrayList<PhanQuyen> dsq = phanQuyenBUS.getListQuyen();
        for (PhanQuyen pq : dsq) {
            cmbQuyen.addItem(pq.getQuyen());
        }

        String quyen = taiKhoanBUS.getQuyenTheoMa(maNV);
        for (int i = 0; i < cmbQuyen.getItemCount(); i++) {
            if (cmbQuyen.getItemAt(i).equals(quyen)) {
                cmbQuyen.setSelectedIndex(i);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTab = new javax.swing.JTabbedPane();
        pnCapMatKhau = new javax.swing.JPanel();
        pnTitleMatKhau = new javax.swing.JPanel();
        lblTitleMatKhau = new javax.swing.JLabel();
        pnMatKhauInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMatKhau_MaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhau_TenDangNhap = new javax.swing.JTextField();
        pnMatKhauButton = new javax.swing.JPanel();
        btnCapMatKhau = new javax.swing.JButton();
        pnCapMatKhau2 = new javax.swing.JPanel();
        pnTitleMatKhau2 = new javax.swing.JPanel();
        lblTitleMatKhau2 = new javax.swing.JLabel();
        pnMatKhauInfo2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtQuyen_MaNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pnMatKhauButton2 = new javax.swing.JPanel();
        btnLuuQuyen = new javax.swing.JButton();
        cmbQuyen = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnTab.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        pnCapMatKhau.setLayout(new javax.swing.BoxLayout(pnCapMatKhau, javax.swing.BoxLayout.Y_AXIS));

        lblTitleMatKhau.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitleMatKhau.setText("Cấp lại mật khẩu");
        pnTitleMatKhau.add(lblTitleMatKhau);

        pnCapMatKhau.add(pnTitleMatKhau);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã Nhân viên");

        txtMatKhau_MaNV.setEditable(false);
        txtMatKhau_MaNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập");

        txtMatKhau_TenDangNhap.setEditable(false);
        txtMatKhau_TenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCapMatKhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCapMatKhau.setText("Đặt lại mật khẩu");
        btnCapMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapMatKhauActionPerformed(evt);
            }
        });
        pnMatKhauButton.add(btnCapMatKhau);

        javax.swing.GroupLayout pnMatKhauInfoLayout = new javax.swing.GroupLayout(pnMatKhauInfo);
        pnMatKhauInfo.setLayout(pnMatKhauInfoLayout);
        pnMatKhauInfoLayout.setHorizontalGroup(
            pnMatKhauInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMatKhauInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMatKhauInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnMatKhauInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatKhau_TenDangNhap)
                    .addComponent(txtMatKhau_MaNV))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMatKhauInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnMatKhauButton, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnMatKhauInfoLayout.setVerticalGroup(
            pnMatKhauInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMatKhauInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMatKhauInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatKhau_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnMatKhauInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatKhau_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnMatKhauButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCapMatKhau.add(pnMatKhauInfo);

        pnTab.addTab("Cấp lại mật khẩu", pnCapMatKhau);

        pnCapMatKhau2.setLayout(new javax.swing.BoxLayout(pnCapMatKhau2, javax.swing.BoxLayout.Y_AXIS));

        lblTitleMatKhau2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitleMatKhau2.setText("Chỉnh sửa quyền");
        pnTitleMatKhau2.add(lblTitleMatKhau2);

        pnCapMatKhau2.add(pnTitleMatKhau2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã Nhân viên");

        txtQuyen_MaNV.setEditable(false);
        txtQuyen_MaNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Quyền Tài Khoản");

        btnLuuQuyen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLuuQuyen.setText("Lưu thay đổi");
        btnLuuQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuQuyenActionPerformed(evt);
            }
        });
        pnMatKhauButton2.add(btnLuuQuyen);

        cmbQuyen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnMatKhauInfo2Layout = new javax.swing.GroupLayout(pnMatKhauInfo2);
        pnMatKhauInfo2.setLayout(pnMatKhauInfo2Layout);
        pnMatKhauInfo2Layout.setHorizontalGroup(
            pnMatKhauInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMatKhauInfo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMatKhauInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnMatKhauInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuyen_MaNV)
                    .addComponent(cmbQuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMatKhauInfo2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnMatKhauButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnMatKhauInfo2Layout.setVerticalGroup(
            pnMatKhauInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMatKhauInfo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMatKhauInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuyen_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnMatKhauInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnMatKhauButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCapMatKhau2.add(pnMatKhauInfo2);

        pnTab.addTab("Chỉnh sửa quyền", pnCapMatKhau2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapMatKhauActionPerformed
        taiKhoanBUS.datLaiMatKhau(maNV, txtMatKhau_TenDangNhap.getText());
    }//GEN-LAST:event_btnCapMatKhauActionPerformed

    private void btnLuuQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuQuyenActionPerformed
        taiKhoanBUS.datLaiQuyen(maNV, cmbQuyen.getSelectedItem() + "");
    }//GEN-LAST:event_btnLuuQuyenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapMatKhau;
    private javax.swing.JButton btnLuuQuyen;
    private javax.swing.JComboBox<String> cmbQuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblTitleMatKhau;
    private javax.swing.JLabel lblTitleMatKhau2;
    private javax.swing.JPanel pnCapMatKhau;
    private javax.swing.JPanel pnCapMatKhau2;
    private javax.swing.JPanel pnMatKhauButton;
    private javax.swing.JPanel pnMatKhauButton2;
    private javax.swing.JPanel pnMatKhauInfo;
    private javax.swing.JPanel pnMatKhauInfo2;
    private javax.swing.JTabbedPane pnTab;
    private javax.swing.JPanel pnTitleMatKhau;
    private javax.swing.JPanel pnTitleMatKhau2;
    private javax.swing.JTextField txtMatKhau_MaNV;
    private javax.swing.JTextField txtMatKhau_TenDangNhap;
    private javax.swing.JTextField txtQuyen_MaNV;
    // End of variables declaration//GEN-END:variables
}
