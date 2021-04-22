package GUI;

import static Main.Main.changLNF;
import MyCustom.TransparentPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;

public class QuanLyNhapHangGUI extends JPanel {

    JLabel lblTabbedNhapHang, lblTabbedPhieuNhap;
    final ImageIcon tabbedSelected = new ImageIcon("image/ManagerUI/tabbed-btn--selected.png");
    final ImageIcon tabbedDefault = new ImageIcon("image/ManagerUI/tabbed-btn.png");
    final Color colorPanel = new Color(247, 247, 247);
    CardLayout cardNhapHangGroup = new CardLayout();
    JPanel pnCardTabNhapHang;

    public QuanLyNhapHangGUI() {
        changLNF("Windows");
        addControlsNhapHang();
        addEventsNhapHang();
    }

    private void addControlsNhapHang() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

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
        //<editor-fold defaultstate="collapsed" desc="Panel Tab Nhập hàng & Phiếu nhập">
        Font font = new Font("", Font.PLAIN, 20);
        pnTop.setPreferredSize(new Dimension(w, 41));
        pnTop.setLayout(null);
        pnTop.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.GRAY));

        lblTabbedNhapHang = new JLabel("Nhập hàng");
        lblTabbedNhapHang.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedNhapHang.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedNhapHang.setIcon(tabbedSelected);
        lblTabbedNhapHang.setBounds(2, 2, 140, 37);
        lblTabbedNhapHang.setFont(font);
        lblTabbedNhapHang.setForeground(Color.white);
        lblTabbedNhapHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblTabbedPhieuNhap = new JLabel("Phiếu nhập");
        lblTabbedPhieuNhap.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedPhieuNhap.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedPhieuNhap.setIcon(tabbedDefault);
        lblTabbedPhieuNhap.setBounds(143, 2, 140, 37);
        lblTabbedPhieuNhap.setFont(font);
        lblTabbedPhieuNhap.setForeground(Color.white);
        lblTabbedPhieuNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        pnTop.add(lblTabbedNhapHang);
        pnTop.add(lblTabbedPhieuNhap);
        //</editor-fold>
        this.add(pnTop, BorderLayout.NORTH);
        /*
        =========================================================================
                                    PANEL NHẬP HÀNG
        =========================================================================
         */
        JPanel pnNhapHang = new TransparentPanel();
        /*
        =========================================================================
                                    PANEL PHIẾU NHẬP
        =========================================================================
         */
        JPanel pnPhieuNhap = new TransparentPanel();
        
        //========================
        pnCardTabNhapHang = new JPanel(cardNhapHangGroup);
        pnCardTabNhapHang.add(pnNhapHang, "1");
        pnCardTabNhapHang.add(pnPhieuNhap, "2");
    }

    private void addEventsNhapHang() {
        lblTabbedNhapHang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedNhapHang.setIcon(tabbedSelected);
                lblTabbedPhieuNhap.setIcon(tabbedDefault);
                cardNhapHangGroup.show(pnCardTabNhapHang, "1");
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
        
        lblTabbedPhieuNhap.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedPhieuNhap.setIcon(tabbedSelected);
                lblTabbedNhapHang.setIcon(tabbedDefault);
                cardNhapHangGroup.show(pnCardTabNhapHang, "2");
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
        
    }
}
