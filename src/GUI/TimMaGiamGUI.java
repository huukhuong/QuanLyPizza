package GUI;

import BUS.GiamGiaBUS;
import DAO.MyConnect;
import DTO.GiamGia;
import MyCustom.MyDialog;
import MyCustom.MyTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class TimMaGiamGUI extends JDialog {

    public static void main(String[] args) {
        Main.Main.changLNF("Windows");
        new MyConnect();
        new TimMaGiamGUI().setVisible(true);
    }

    public static GiamGia maGiamTimDuoc = null;
    private GiamGiaBUS giamGiaBUS = new GiamGiaBUS();

    public TimMaGiamGUI() {
        addControls();
        addEvents();

        this.setSize(500, 400);
        this.setModal(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private JTextField txtTuKhoa;
    private JTable tblMaGiam;
    private DefaultTableModel dtmMaGiam;
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
        dtmMaGiam = new DefaultTableModel();
        dtmMaGiam.addColumn("Mã giảm");
        dtmMaGiam.addColumn("Ngày bắt đầu");
        dtmMaGiam.addColumn("Ngày kết thúc");
        dtmMaGiam.addColumn("Trạng thái");
        tblMaGiam = new MyTable(dtmMaGiam);
        JScrollPane scrMaGiam = new JScrollPane(tblMaGiam);
        pnTable.add(scrMaGiam, BorderLayout.CENTER);
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
                xuLyChonMaGiam();
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThoat();
            }
        });
    }

    private void xuLyChonMaGiam() {
        int row = tblMaGiam.getSelectedRow();
        if (row > -1) {
            try {
                if (tblMaGiam.getValueAt(row, 3).equals("Không hiệu lực")) {
                    new MyDialog("Mã này đã hết hiệu lực!", MyDialog.ERROR_DIALOG);
                    loadDataLenTable();
                    return;
                }
                int ma = Integer.parseInt(tblMaGiam.getValueAt(row, 0) + "");
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Date ngayBD = sdf.parse(tblMaGiam.getValueAt(row, 1) + "");
                Date ngayKT = sdf.parse(tblMaGiam.getValueAt(row, 2) + "");

                maGiamTimDuoc = new GiamGia();
                maGiamTimDuoc.setMaGiam(ma);
                maGiamTimDuoc.setNgayBD(ngayBD);
                maGiamTimDuoc.setNgayKT(ngayKT);
            } catch (ParseException ex) {
            }
        }
        xuLyThoat();
    }

    private void xuLyThoat() {
        dispose();
    }

    private void loadDataLenTable() {
        dtmMaGiam.setRowCount(0);
        giamGiaBUS.docDanhSach();
        ArrayList<GiamGia> dsg = giamGiaBUS.getDanhSachGiamGia();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (GiamGia gg : dsg) {
            Vector vec = new Vector();
            vec.add(gg.getMaGiam());
            vec.add(sdf.format(gg.getNgayBD()));
            vec.add(sdf.format(gg.getNgayKT()));

            Date now = new Date();
            if (gg.getNgayBD().before(now) && gg.getNgayKT().after(now)) {
                vec.add("Có hiệu lực");
            } else {
                vec.add("Không hiệu lực");
            }

            dtmMaGiam.addRow(vec);
        }
    }

    private void loadDataLenTable(String tuKhoa) {

    }

}
