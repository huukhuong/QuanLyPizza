package QuanLyPizza.GUI;

import QuanLyPizza.BUS.NhaCungCapBUS;
import QuanLyPizza.DTO.NhaCungCap;

public class DlgSuaNhaCungCap extends javax.swing.JDialog {

    public DlgSuaNhaCungCap(NhaCungCap nhaCungCap) {
        checkSuaNCC = false;

        initComponents();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setResizable(false);

        txtMaNCC.setText(nhaCungCap.getMaNCC() + "");
        txtTenNCC.setText(nhaCungCap.getTenNCC());
        txtDiaChiNCC.setText(nhaCungCap.getDiaChi());
        txtDienThoaiNCC.setText(nhaCungCap.getDienThoai());
    }

    private boolean checkSuaNCC = false;

    public boolean getCheckSuaNCC() {
        return checkSuaNCC;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtMaNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        txtDiaChiNCC = new javax.swing.JTextField();
        txtDienThoaiNCC = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sửa thông tin Nhà cung cấp");
        jPanel1.add(jLabel1);

        txtMaNCC.setEditable(false);
        txtMaNCC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã NCC"));
        txtMaNCC.setOpaque(false);

        txtTenNCC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên NCC"));
        txtTenNCC.setOpaque(false);
        txtTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNCCActionPerformed(evt);
            }
        });

        txtDiaChiNCC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDiaChiNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Địa chỉ"));
        txtDiaChiNCC.setOpaque(false);
        txtDiaChiNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiNCCActionPerformed(evt);
            }
        });

        txtDienThoaiNCC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDienThoaiNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Điện thoại"));
        txtDienThoaiNCC.setOpaque(false);
        txtDienThoaiNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienThoaiNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNCC)
                    .addComponent(txtMaNCC)
                    .addComponent(txtDiaChiNCC)
                    .addComponent(txtDienThoaiNCC))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDienThoaiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLuu.setText("Lưu lại");
        btnLuu.setPreferredSize(new java.awt.Dimension(85, 40));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel3.add(btnLuu);

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHuy.setText("Huỷ");
        btnHuy.setPreferredSize(new java.awt.Dimension(85, 40));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel3.add(btnHuy);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDienThoaiNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienThoaiNCCActionPerformed
        btnLuu.doClick();
    }//GEN-LAST:event_txtDienThoaiNCCActionPerformed

    private void txtDiaChiNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiNCCActionPerformed
        txtDienThoaiNCC.requestFocus();
    }//GEN-LAST:event_txtDiaChiNCCActionPerformed

    private void txtTenNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNCCActionPerformed
        txtDiaChiNCC.requestFocus();
    }//GEN-LAST:event_txtTenNCCActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
        checkSuaNCC = nhaCungCapBUS.suaNhaCungCap(
                txtMaNCC.getText(),
                txtTenNCC.getText(),
                txtDiaChiNCC.getText(),
                txtDienThoaiNCC.getText());
        if (checkSuaNCC) {
            this.dispose();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtDiaChiNCC;
    private javax.swing.JTextField txtDienThoaiNCC;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
