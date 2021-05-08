package QuanLyPizza.GUI;

import QuanLyPizza.BUS.ThongKeBUS;
import QuanLyPizza.DTO.ThongKe;
import MyCustom.TransparentPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

import java.awt.*;

import static Main.Main.changLNF;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;

public class PnQuanLyThongKeGUI extends JPanel {

    public PnQuanLyThongKeGUI() {
        changLNF("Windows");
        addControls();
        addEvents();
    }

    ThongKeBUS thongKeBUS = new ThongKeBUS();
    final Color colorPanel = new Color(56, 56, 56);
    JLabel lblThongKeThucDon, lblThongKeKhachHang, lblThongKeNhanVien, lblThongKeDoanhThu;
    JLabel lblDoanhThuQuy1, lblDoanhThuQuy2, lblDoanhThuQuy3, lblDoanhThuQuy4, lblTongDoanhThu;
    JButton btnView, btnBack;
    JComboBox<Integer> cmbNam;
    CardLayout cardLayoutThongKe = new CardLayout();
    JPanel pnMain;
    JLabel lblMon1, lblMon2, lblMon3, lblMon4, lblMon5, lblSoLuong1, lblSoLuong2, lblSoLuong3, lblSoLuong4, lblSoLuong5;
    private ChartPanel chartPanel;
    JPanel pnThongKeChiTiet, pnChart;
    JButton btn_filter;

    private void addControls() {
        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        int w = 1030;
        int h = 844;

        //========================================
        pnMain = new TransparentPanel();
        pnMain.setFont(new Font("Tahoma", Font.PLAIN, 18));
        pnMain.setLayout(cardLayoutThongKe);

        JPanel pnThongKeTong = new JPanel(null);
        pnThongKeTong.setBackground(colorPanel);
        JLabel lblTileThongKeTong, lblBackgroundThucDon, lblBackgroundKhachHang, lblBackgroundNhanVien, lblBackgroundDoanhThu;

        lblTileThongKeTong = new JLabel("THỐNG KÊ TỔNG QUÁT", JLabel.CENTER);
        lblTileThongKeTong.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnView = new JButton(new ImageIcon("image/icons8_view_40px.png"));
        lblBackgroundThucDon = new JLabel(new ImageIcon("image/ManagerUI/thongKeMon.png"));
        lblBackgroundKhachHang = new JLabel(new ImageIcon("image/ManagerUI/thongKeKhachHang.png"));
        lblBackgroundNhanVien = new JLabel(new ImageIcon("image/ManagerUI/thongKeNhanVien.png"));
        lblBackgroundDoanhThu = new JLabel(new ImageIcon("image/ManagerUI/thongKeDoanhThu.png"));

        lblTileThongKeTong.setBounds(0, 15, w, 50);
        btnView.setBounds(10, 10, 45, 45);
        lblBackgroundThucDon.setBounds(98, 85, 369, 201);
        lblBackgroundKhachHang.setBounds(563, 85, 369, 201);
        lblBackgroundNhanVien.setBounds(98, 340, 369, 201);
        lblBackgroundDoanhThu.setBounds(563, 340, 369, 201);

        btnView.setToolTipText("Xem chi tiết");
        btnView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblThongKeThucDon = new JLabel("55", JLabel.CENTER);
        lblThongKeKhachHang = new JLabel("46", JLabel.CENTER);
        lblThongKeNhanVien = new JLabel("23", JLabel.CENTER);
        lblThongKeDoanhThu = new JLabel("1.286.379.000", JLabel.CENTER);

        Font font = new Font("Tahoma", Font.BOLD, 48);
        lblThongKeThucDon.setFont(font);
        lblThongKeKhachHang.setFont(font);
        lblThongKeNhanVien.setFont(font);
        lblThongKeDoanhThu.setFont(font);

        lblTileThongKeTong.setForeground(Color.white);
        lblThongKeThucDon.setForeground(Color.white);
        lblThongKeKhachHang.setForeground(Color.white);
        lblThongKeNhanVien.setForeground(Color.white);
        lblThongKeDoanhThu.setForeground(Color.white);

        lblThongKeThucDon.setBounds(98, 100, 232, 87);
        lblThongKeKhachHang.setBounds(563, 100, 232, 87);
        lblThongKeNhanVien.setBounds(98, 350, 232, 87);
        lblThongKeDoanhThu.setBounds(563, 350, 369, 87);

        pnThongKeTong.add(lblTileThongKeTong);
        pnThongKeTong.add(btnView);
        pnThongKeTong.add(lblThongKeThucDon);
        pnThongKeTong.add(lblThongKeKhachHang);
        pnThongKeTong.add(lblThongKeNhanVien);
        pnThongKeTong.add(lblThongKeDoanhThu);
        pnThongKeTong.add(lblBackgroundThucDon);
        pnThongKeTong.add(lblBackgroundKhachHang);
        pnThongKeTong.add(lblBackgroundNhanVien);
        pnThongKeTong.add(lblBackgroundDoanhThu);

        lblDoanhThuQuy1 = new JLabel("2.000.000", JLabel.CENTER);
        lblDoanhThuQuy2 = new JLabel("3.000.000", JLabel.CENTER);
        lblDoanhThuQuy3 = new JLabel("9.000.000", JLabel.CENTER);
        lblDoanhThuQuy4 = new JLabel("12.000.000", JLabel.CENTER);
        lblTongDoanhThu = new JLabel("26.000.000", JLabel.CENTER);

        Font font1 = new Font("Tahoma", Font.BOLD, 22);
        lblDoanhThuQuy1.setFont(font1);
        lblDoanhThuQuy2.setFont(font1);
        lblDoanhThuQuy3.setFont(font1);
        lblDoanhThuQuy4.setFont(font1);
        font1 = new Font("Tahoma", Font.BOLD, 28);
        lblTongDoanhThu.setFont(font1);

        lblDoanhThuQuy1.setForeground(Color.WHITE);
        lblDoanhThuQuy2.setForeground(Color.WHITE);
        lblDoanhThuQuy3.setForeground(Color.WHITE);
        lblDoanhThuQuy4.setForeground(Color.WHITE);
        lblTongDoanhThu.setForeground(Color.WHITE);

        int x = 265;
        int y = 673;
        lblDoanhThuQuy1.setBounds(x, y, 167, 63);
        lblDoanhThuQuy2.setBounds(x += 167, y, 167, 63);
        lblDoanhThuQuy3.setBounds(x += 167, y, 167, 63);
        lblDoanhThuQuy4.setBounds(x += 167, y, 167, 63);
        lblTongDoanhThu.setBounds(265, 735, 667, 63);

        pnThongKeTong.add(lblTongDoanhThu);
        pnThongKeTong.add(lblDoanhThuQuy1);
        pnThongKeTong.add(lblDoanhThuQuy2);
        pnThongKeTong.add(lblDoanhThuQuy3);
        pnThongKeTong.add(lblDoanhThuQuy4);

        cmbNam = new JComboBox<>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = year; i >= year - 10; i--)
            cmbNam.addItem(i);
        cmbNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cmbNam.setBounds(w / 2 - 100 / 2, 560, 120, 35);
        pnThongKeTong.add(cmbNam);
        
        btn_filter = new JButton("Chi tiết");
        btn_filter.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn_filter.setBounds((w / 2 - 100 / 2) + 140, 560, 100, 35);
//        pnThongKeTong.add(btn_filter);

        JLabel lblBackgroundBang = new JLabel(new ImageIcon("image/ManagerUI/bangThongKe.png"));
        lblBackgroundBang.setBounds(98, 610, 834, 189);
        pnThongKeTong.add(lblBackgroundBang);

        pnMain.add(pnThongKeTong, "1");

        // ==============================================
        //              THỐNG KÊ CHI TIẾT
        // ==============================================
        pnThongKeChiTiet = new TransparentPanel(null);

        btnBack = new JButton(new ImageIcon("image/icons8_undo_40px.png"));
        btnBack.setToolTipText("Quay lại");
        btnBack.setBounds(10, 10, 45, 45);
        pnThongKeChiTiet.add(btnBack);

        JLabel lblBackGroundBangChiTiet = new JLabel(new ImageIcon("image/ManagerUI/bangChiTiet.png"));
        lblBackGroundBangChiTiet.setBounds(172, 10, 686, 363);
        pnThongKeChiTiet.add(lblBackGroundBangChiTiet);

        lblMon1 = new JLabel("0");
        lblMon2 = new JLabel("0");
        lblMon3 = new JLabel("0");
        lblMon4 = new JLabel("0");
        lblMon5 = new JLabel("0");
        lblSoLuong1 = new JLabel("0", JLabel.CENTER);
        lblSoLuong2 = new JLabel("0", JLabel.CENTER);
        lblSoLuong3 = new JLabel("0", JLabel.CENTER);
        lblSoLuong4 = new JLabel("0", JLabel.CENTER);
        lblSoLuong5 = new JLabel("0", JLabel.CENTER);

        x = 236;
        y = 123;
        lblMon1.setBounds(x, y, 493, 50);
        lblMon2.setBounds(x, y += 50, 493, 50);
        lblMon3.setBounds(x, y += 50, 493, 50);
        lblMon4.setBounds(x, y += 50, 493, 50);
        lblMon5.setBounds(x, y += 50, 493, 50);
        x = 729;
        y = 123;
        lblSoLuong1.setBounds(x, y, 128, 50);
        lblSoLuong2.setBounds(x, y += 50, 128, 50);
        lblSoLuong3.setBounds(x, y += 50, 128, 50);
        lblSoLuong4.setBounds(x, y += 50, 128, 50);
        lblSoLuong5.setBounds(x, y += 50, 128, 50);

        lblMon1.setForeground(Color.BLACK);
        lblMon2.setForeground(Color.BLACK);
        lblMon3.setForeground(Color.BLACK);
        lblMon4.setForeground(Color.BLACK);
        lblMon5.setForeground(Color.BLACK);
        lblSoLuong1.setForeground(Color.BLACK);
        lblSoLuong2.setForeground(Color.BLACK);
        lblSoLuong3.setForeground(Color.BLACK);
        lblSoLuong4.setForeground(Color.BLACK);
        lblSoLuong5.setForeground(Color.BLACK);

        Font fontChiTiet = new Font("Tahoma", Font.BOLD, 18);
        lblMon1.setFont(fontChiTiet);
        lblMon2.setFont(fontChiTiet);
        lblMon3.setFont(fontChiTiet);
        lblMon4.setFont(fontChiTiet);
        lblMon5.setFont(fontChiTiet);
        lblSoLuong1.setFont(fontChiTiet);
        lblSoLuong2.setFont(fontChiTiet);
        lblSoLuong3.setFont(fontChiTiet);
        lblSoLuong4.setFont(fontChiTiet);
        lblSoLuong5.setFont(fontChiTiet);

        pnThongKeChiTiet.add(lblMon1);
        pnThongKeChiTiet.add(lblMon2);
        pnThongKeChiTiet.add(lblMon3);
        pnThongKeChiTiet.add(lblMon4);
        pnThongKeChiTiet.add(lblMon5);
        pnThongKeChiTiet.add(lblSoLuong1);
        pnThongKeChiTiet.add(lblSoLuong2);
        pnThongKeChiTiet.add(lblSoLuong3);
        pnThongKeChiTiet.add(lblSoLuong4);
        pnThongKeChiTiet.add(lblSoLuong5);

        //========BIỂU ĐỒ CỘT=============
        pnChart = new TransparentPanel();
        pnChart.setBounds(0, 398, 1030, 441);

        chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new Dimension(1030, 441));

        pnChart.add(chartPanel);
        //================================
        pnThongKeChiTiet.add(pnChart);
        pnMain.add(pnThongKeChiTiet, "2");

        this.add(pnMain, BorderLayout.CENTER);
        hienThiThongKe();
    }

    private void addEvents() {
        btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hienThiThongKe();
                veLaiChart();
                cardLayoutThongKe.show(pnMain, "2");
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hienThiThongKe();
                cardLayoutThongKe.show(pnMain, "1");
            }
        });
        cmbNam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hienThiThongKe();
            }
        });
        btn_filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DlgLocThongKe dlg = new DlgLocThongKe();
                dlg.setVisible(true);
            }
        });
    }

    private void veLaiChart() {
        pnChart.removeAll();

        chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new Dimension(1030, 441));

        pnChart.add(chartPanel);
    }

    private JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh thu năm " + Calendar.getInstance().get(Calendar.YEAR),
                "Tháng", "Doanh thu",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i <= 12; i++) {
            double value = thongKeBUS.getDoanhThuThang(i, Calendar.getInstance().get(Calendar.YEAR));
            dataset.addValue(value, "Doanh thu", i + "");
        }
        return dataset;
    }

    private DecimalFormat dcf = new DecimalFormat("###,###");

    private void hienThiThongKe() {
        ThongKe thongKe = thongKeBUS.thongKe(Integer.parseInt(cmbNam.getSelectedItem() + ""));
        lblThongKeThucDon.setText(dcf.format(thongKe.getSoLuongSP()));
        lblThongKeKhachHang.setText(dcf.format(thongKe.getSoLuongKH()));
        lblThongKeNhanVien.setText(dcf.format(thongKe.getSoLuongNV()));
        lblThongKeDoanhThu.setText(dcf.format(thongKe.getTongDoanhThu()));
        lblDoanhThuQuy1.setText(dcf.format(thongKe.getTongThuQuy(1)));
        lblDoanhThuQuy2.setText(dcf.format(thongKe.getTongThuQuy(2)));
        lblDoanhThuQuy3.setText(dcf.format(thongKe.getTongThuQuy(3)));
        lblDoanhThuQuy4.setText(dcf.format(thongKe.getTongThuQuy(4)));
        lblTongDoanhThu.setText(dcf.format(thongKe.getTongDoanhThu()));
        lblMon1.setText(thongKe.getTopSanPhamBanChay().get(0).getTenSP());
        lblMon2.setText(thongKe.getTopSanPhamBanChay().get(1).getTenSP());
        lblMon3.setText(thongKe.getTopSanPhamBanChay().get(2).getTenSP());
        lblMon4.setText(thongKe.getTopSanPhamBanChay().get(3).getTenSP());
        lblMon5.setText(thongKe.getTopSanPhamBanChay().get(4).getTenSP());
        lblSoLuong1.setText("" + thongKe.getTopSanPhamBanChay().get(0).getSoLuong());
        lblSoLuong2.setText("" + thongKe.getTopSanPhamBanChay().get(1).getSoLuong());
        lblSoLuong3.setText("" + thongKe.getTopSanPhamBanChay().get(2).getSoLuong());
        lblSoLuong4.setText("" + thongKe.getTopSanPhamBanChay().get(3).getSoLuong());
        lblSoLuong5.setText("" + thongKe.getTopSanPhamBanChay().get(4).getSoLuong());
    }

}
