package QuanLyPizza.GUI;

import QuanLyPizza.BUS.LoaiBUS;
import QuanLyPizza.DTO.LoaiSP;
import MyCustom.MyDialog;
import MyCustom.MyTable;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DlgQuanLyLoai extends javax.swing.JDialog {

    DefaultTableModel dtmLoai;

    public DlgQuanLyLoai() {
        initComponents();
        dtmLoai = new DefaultTableModel();
        dtmLoai.addColumn("Mã loại");
        dtmLoai.addColumn("Tên loại");
        tblLoai.setModel(dtmLoai);
        loadDataLenTblLoai();
        this.setLocationRelativeTo(null);
    }

    LoaiBUS loaiBUS = new LoaiBUS();

    private void loadDataLenTblLoai() {
        dtmLoai.setRowCount(0);
        ArrayList<LoaiSP> dsl = loaiBUS.getDanhSachLoai();
        if (dsl != null) {
            for (LoaiSP loai : dsl) {
                Vector vec = new Vector();
                vec.add(loai.getMaLoai());
                vec.add(loai.getTenLoai());
                dtmLoai.addRow(vec);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoai = new MyTable();
        jPanel3 = new javax.swing.JPanel();
        pnMaLoai = new javax.swing.JPanel();
        lblMaLoai = new javax.swing.JLabel();
        txtMaLoai = new javax.swing.JTextField();
        pnTenLoai = new javax.swing.JPanel();
        lblTenLoai = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        pnButton = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ LOẠI");
        jPanel1.add(jLabel1);

        tblLoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại", "Tên loại"
            }
        ));
        tblLoai.getTableHeader().setReorderingAllowed(false);
        tblLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoai);

        javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
        pnTable.setLayout(pnTableLayout);
        pnTableLayout.setHorizontalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnTableLayout.setVerticalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTableLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        lblMaLoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMaLoai.setText("Mã loại");
        lblMaLoai.setPreferredSize(new java.awt.Dimension(63, 22));
        pnMaLoai.add(lblMaLoai);

        txtMaLoai.setEditable(false);
        txtMaLoai.setColumns(15);
        txtMaLoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnMaLoai.add(txtMaLoai);

        jPanel3.add(pnMaLoai);

        lblTenLoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTenLoai.setText("Tên loại");
        pnTenLoai.add(lblTenLoai);

        txtTenLoai.setColumns(15);
        txtTenLoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnTenLoai.add(txtTenLoai);

        jPanel3.add(pnTenLoai);

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(80, 35));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnButton.add(btnThem);

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(80, 35));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnButton.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setPreferredSize(new java.awt.Dimension(80, 35));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnButton.add(btnXoa);

        jPanel3.add(pnButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
            .addComponent(pnTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiMouseClicked
        int row = tblLoai.getSelectedRow();
        if (row > -1) {
            String maLoai = tblLoai.getValueAt(row, 0) + "";
            String tenLoai = tblLoai.getValueAt(row, 1) + "";
            txtMaLoai.setText(maLoai);
            txtTenLoai.setText(tenLoai);
        }
    }//GEN-LAST:event_tblLoaiMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (loaiBUS.themLoai(dtmLoai.getRowCount(), txtTenLoai.getText())) {
            loadDataLenTblLoai();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if (dlg.OK_OPTION == dlg.getAction()) {
            String ma = txtMaLoai.getText();
            if (loaiBUS.xoaLoai(ma)) {
                loadDataLenTblLoai();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String ma = txtMaLoai.getText();
        String ten = txtTenLoai.getText();
        if (loaiBUS.suaLoai(ma, ten)) {
            loadDataLenTblLoai();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaLoai;
    private javax.swing.JLabel lblTenLoai;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnMaLoai;
    private javax.swing.JPanel pnTable;
    private javax.swing.JPanel pnTenLoai;
    private javax.swing.JTable tblLoai;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtTenLoai;
    // End of variables declaration//GEN-END:variables
}
