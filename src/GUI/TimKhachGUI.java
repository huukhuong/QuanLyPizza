package GUI;

import BUS.KhachHangBUS;
import DAO.MyConnect;
import DTO.KhachHang;
import MyCustom.MyTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TimKhachGUI extends JDialog {

    public static void main(String[] args) {
        Main.Main.changLNF("Windows");
        new MyConnect();
        new TimKhachGUI().setVisible(true);
    }

    private KhachHangBUS khachHangBUS = new KhachHangBUS();
    public static KhachHang khachHangTimDuoc = null;

    public TimKhachGUI() {
        addControls();
        addEvents();

        this.setSize(500, 400);
        this.setModal(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private JTextField txtTuKhoa;
    private JTable tblKhachHang;
    private DefaultTableModel dtmKhachHang;
    private JButton btnChon, btnThoat;

    private void addControls() {
        Container con = getContentPane();
        con.setLayout(new BorderLayout());

        Font font = new Font("Tahoma", Font.PLAIN, 16);
        JPanel pnTop = new JPanel();
        JLabel lblTuKhoa = new JLabel("Từ khoá tìm");
        txtTuKhoa = new JTextField(20);
        lblTuKhoa.setFont(font);
        txtTuKhoa.setFont(font);
        pnTop.add(lblTuKhoa);
        pnTop.add(txtTuKhoa);
        con.add(pnTop, BorderLayout.NORTH);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        dtmKhachHang = new DefaultTableModel();
        dtmKhachHang.addColumn("Mã KH");
        dtmKhachHang.addColumn("Họ");
        dtmKhachHang.addColumn("Tên");
        dtmKhachHang.addColumn("Giới tính");
        dtmKhachHang.addColumn("Tổng chi tiêu");
        tblKhachHang = new MyTable(dtmKhachHang);
        JScrollPane scrKhachHang = new JScrollPane(tblKhachHang);
        pnTable.add(scrKhachHang, BorderLayout.CENTER);
        con.add(pnTable, BorderLayout.CENTER);

        JPanel pnButton = new JPanel();
        btnChon = new JButton("Chọn");
        btnThoat = new JButton("Thoát");
        btnChon.setFont(font);
        btnThoat.setFont(font);
        pnButton.add(btnChon);
        pnButton.add(btnThoat);
        con.add(pnButton, BorderLayout.SOUTH);

        btnChon.setPreferredSize(new Dimension(120, 40));
        btnThoat.setPreferredSize(btnChon.getPreferredSize());

        loadDataLenTable();
    }

    private void addEvents() {
        txtTuKhoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataLenTable(txtTuKhoa.getText());
            }
        });

        btnChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChonKhachHang();
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThoat();
            }
        });
    }

    private void xuLyChonKhachHang() {
        int row = tblKhachHang.getSelectedRow();
        if (row > -1) {
            int ma = Integer.parseInt(tblKhachHang.getValueAt(row, 0) + "");
            String ho = tblKhachHang.getValueAt(row, 1) + "";
            String ten = tblKhachHang.getValueAt(row, 2) + "";
            String gioiTinh = tblKhachHang.getValueAt(row, 3) + "";
            int tongChiTieu = Integer.parseInt(tblKhachHang.getValueAt(row, 4) + "");

            khachHangTimDuoc = new KhachHang(ma, ho, ten, gioiTinh, tongChiTieu);
        }
        xuLyThoat();
    }

    private void xuLyThoat() {
        dispose();
    }

    private void loadDataLenTable() {
        dtmKhachHang.setRowCount(0);
        ArrayList<KhachHang> dskh = khachHangBUS.getListKhachHang();
        if (dskh != null)
            for (KhachHang kh : dskh) {
                Vector vec = new Vector();
                vec.add(kh.getMaKH());
                vec.add(kh.getHo());
                vec.add(kh.getTen());
                vec.add(kh.getGioiTinh());
                vec.add(kh.getTongChiTieu());
                dtmKhachHang.addRow(vec);
            }
    }

    private void loadDataLenTable(String tuKhoa) {
        dtmKhachHang.setRowCount(0);
        ArrayList<KhachHang> dskh = khachHangBUS.timKiemKhachHang(tuKhoa);
        for (KhachHang kh : dskh) {
            Vector vec = new Vector();
            vec.add(kh.getMaKH());
            vec.add(kh.getHo());
            vec.add(kh.getTen());
            vec.add(kh.getGioiTinh());
            vec.add(kh.getTongChiTieu());
            dtmKhachHang.addRow(vec);
        }
    }

}
