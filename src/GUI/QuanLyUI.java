package GUI;

import DAO.MyConnect;
import Main.Main;
import static Main.Main.changLNF;
import MyCustom.TransparentPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QuanLyUI extends JFrame {

    public static void main(String[] args) {
        new MyConnect();
        changLNF("Nimbus");
        QuanLyUI ui = new QuanLyUI();
        ui.showWindow();
    }

    public QuanLyUI() {
        this.setSize(1280, 900);
        addControls();
        addEvents();
    }

    public void showWindow() {
        Image icon = Toolkit.getDefaultToolkit().getImage("image/ManagerUI/icon-app.png");
        this.setIconImage(icon);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Phần mềm quản lý cửa hàng pizza");
        this.setVisible(true);
    }

    private JPanel pnTitle, pnMenuLeft, pnCard, pnBanHang, pnNhapHang, pnSanPham, pnNhanVien, pnKhachHang;
    private JLabel btnClose, btnMinimize, lblBanHang, lblNhapHang, lblSanPham, lblNhanVien, lblKhachHang;
    private final Color clLeftItem = new Color(63, 74, 89);
    private final Color clLeftItemHover = new Color(72, 88, 107);
    private final Color clLeftItemSelected = new Color(51, 202, 187);
    private ArrayList<JLabel> listMenuLeft;
    private CardLayout cardMenuLeftGroup = new CardLayout();

    private void addControls() {
        int width = this.getWidth();
        int height = this.getHeight();

        Container con = getContentPane();

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        /*
        ============================================================
                                TITLE BAR
        ============================================================
         */
        pnTitle = new JPanel(null);
        pnTitle.setPreferredSize(new Dimension(width, 46));
        pnTitle.setBackground(new Color(242, 153, 74));

        JLabel lblIconApp = new JLabel(new ImageIcon("image/ManagerUI/icon-app.png"));
        lblIconApp.setBounds(7, 7, 32, 32);
        pnTitle.add(lblIconApp);

        JLabel lblTitleText = new JLabel(new ImageIcon("image/ManagerUI/title-text.png"));
        lblTitleText.setBounds(width / 2 - 428 / 2, 3, 428, 38);
        pnTitle.add(lblTitleText);

        btnMinimize = new JLabel(new ImageIcon("image/ManagerUI/btn-minimize.png"));
        btnMinimize.setBounds(width - 85, 5, 38, 35);
        btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTitle.add(btnMinimize);

        btnClose = new JLabel(new ImageIcon("image/ManagerUI/btn-close.png"));
        btnClose.setBounds(width - 40, 5, 35, 35);
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTitle.add(btnClose);

        pnMain.add(pnTitle, BorderLayout.NORTH);
        /*
        ============================================================
                                SIDE BAR MENU
        ============================================================
         */
        pnMenuLeft = new JPanel();
        pnMenuLeft.setPreferredSize(new Dimension(250, height - pnTitle.getHeight()));
        pnMenuLeft.setBackground(clLeftItem);
        pnMenuLeft.setLayout(new BoxLayout(pnMenuLeft, BoxLayout.Y_AXIS));

        JLabel lblAvatar = new JLabel(new ImageIcon("image/ManagerUI/avatar.png"), JLabel.CENTER);
        lblAvatar.setPreferredSize(new Dimension(250, 210));
        pnMenuLeft.add(lblAvatar);

        lblBanHang = new JLabel(new ImageIcon("image/ManagerUI/lblBanHang.png"));
        lblNhapHang = new JLabel(new ImageIcon("image/ManagerUI/lblNhapHang.png"));
        lblSanPham = new JLabel(new ImageIcon("image/ManagerUI/lblSanPham.png"));
        lblNhanVien = new JLabel(new ImageIcon("image/ManagerUI/lblNhanVien.png"));
        lblKhachHang = new JLabel(new ImageIcon("image/ManagerUI/lblKhachHang.png"));

        listMenuLeft = new ArrayList<>();
        listMenuLeft.add(lblBanHang);
        listMenuLeft.add(lblNhapHang);
        listMenuLeft.add(lblSanPham);
        listMenuLeft.add(lblNhanVien);
        listMenuLeft.add(lblKhachHang);

        for (JLabel lbl : listMenuLeft) {
            lbl.setPreferredSize(new Dimension(250, 65));
            lbl.setOpaque(true);
            lbl.setBackground(clLeftItem);
            lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pnMenuLeft.add(lbl);
        }

        lblBanHang.setBackground(clLeftItemSelected);

        pnMain.add(pnMenuLeft, BorderLayout.WEST);

        /*
        ============================================================
                                CARD PANEL           
        ============================================================
         */
        pnCard = new JPanel(cardMenuLeftGroup);

        pnBanHang = new JPanel();
        pnNhapHang = new JPanel();
        pnSanPham = new JPanel();
        pnNhanVien = new JPanel();
        pnKhachHang = new JPanel();

        pnCard.add(pnBanHang, "1");
        pnCard.add(pnNhapHang, "2");
        pnCard.add(pnSanPham, "3");
        pnCard.add(pnNhanVien, "4");
        pnCard.add(pnKhachHang, "5");

        addControlsBanHang();
        addControlsNhapHang();
        addControlsSanPham();
        addControlsNhanVien();
        addControlsKhachHang();

        pnMain.add(pnCard);
        /*
        ============================================================
                                CARD PANEL           
        ============================================================
         */
        con.add(pnMain);
    }

    private int xMouse, yMouse;

    private void addEvents() {
        pnTitle.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                moverFrame(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });

        btnMinimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thuNhoFrame();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnMinimize.setIcon(new ImageIcon("image/ManagerUI/btn-minimize--hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMinimize.setIcon(new ImageIcon("image/ManagerUI/btn-minimize.png"));
            }
        });

        btnClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thoatChuongTrinh();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnClose.setIcon(new ImageIcon("image/ManagerUI/btn-close--hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClose.setIcon(new ImageIcon("image/ManagerUI/btn-close.png"));
            }
        });

        for (JLabel lbl : listMenuLeft) {
            lbl.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JLabel lblDisable : listMenuLeft) {
                        lblDisable.setBackground(clLeftItem);
                    }
                    lbl.setBackground(clLeftItemSelected);

                    // Xử lý lật trang theo menu
                    String cardName = "";
                    if (lbl == lblBanHang) {
                        cardName = "1";
                    } else if (lbl == lblNhapHang) {
                        cardName = "2";
                    } else if (lbl == lblSanPham) {
                        cardName = "3";
                    } else if (lbl == lblNhanVien) {
                        cardName = "4";
                    } else {
                        cardName = "5";
                    }
                    cardMenuLeftGroup.show(pnCard, cardName);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (lbl.getBackground().equals(clLeftItem)) {
                        lbl.setBackground(clLeftItemHover);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (lbl.getBackground().equals(clLeftItemHover)) {
                        lbl.setBackground(clLeftItem);
                    }
                }
            });
        }

        lblTabbedBanHang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedHoaDon.setIcon(tabbedDefault);
                lblTabbedBanHang.setIcon(tabbedSelected);
                cardBanHangGroup.show(pnTabbedBanHang, "1");
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

        lblTabbedHoaDon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedHoaDon.setIcon(tabbedSelected);
                lblTabbedBanHang.setIcon(tabbedDefault);
                cardBanHangGroup.show(pnTabbedBanHang, "2");
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

    private void moverFrame(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void thuNhoFrame() {
        this.setState(Frame.ICONIFIED);
    }

    private void thoatChuongTrinh() {
        this.dispose();
    }

    private void addControlsKhachHang() {

    }

    private void addControlsSanPham() {

    }

    private void addControlsNhapHang() {

    }

    private JLabel lblTabbedBanHang, lblTabbedHoaDon;
    private final ImageIcon tabbedSelected = new ImageIcon("image/ManagerUI/tabbed-btn--selected.png");
    private final ImageIcon tabbedDefault = new ImageIcon("image/ManagerUI/tabbed-btn.png");
    private final Color colorPanel = new Color(247, 247, 247);
    private CardLayout cardBanHangGroup = new CardLayout();
    private JPanel pnTabbedBanHang;
    private JTable tblBanHang, tblGioHang;
    private DefaultTableModel dtmBanHang, dtmGioHang;
    private JTextField txtMaSPBanHang, txtTenSPBanHang, txtDonGiaBanHang, txtSoLuongBanHang;
    private JComboBox<String> cmbLoaiSPBanHang;
    private JLabel btnThemVaoGio, lblAnhSP;

    private void addControlsBanHang() {
        pnBanHang.setLayout(new FlowLayout());
        pnBanHang.setBackground(colorPanel);

        int w = (int) (this.getWidth() - pnMenuLeft.getPreferredSize().getWidth());
        int h = (int) (this.getHeight() - pnTitle.getPreferredSize().getHeight());

        /*
        =========================================================================
                                    PANEL TABBED
        =========================================================================
         */
        Font font = new Font("", Font.PLAIN, 20);
        JPanel pnTop = new TransparentPanel();
        pnTop.setPreferredSize(new Dimension(w, 41));
        pnTop.setLayout(null);
        pnTop.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, clLeftItem));

        lblTabbedBanHang = new JLabel("Bán hàng");
        lblTabbedBanHang.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedBanHang.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedBanHang.setIcon(tabbedSelected);
        lblTabbedBanHang.setBounds(2, 2, 140, 37);
        lblTabbedBanHang.setFont(font);
        lblTabbedBanHang.setForeground(Color.white);
        lblTabbedBanHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblTabbedHoaDon = new JLabel("Hoá đơn");
        lblTabbedHoaDon.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedHoaDon.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedHoaDon.setIcon(tabbedDefault);
        lblTabbedHoaDon.setBounds(143, 2, 140, 37);
        lblTabbedHoaDon.setFont(font);
        lblTabbedHoaDon.setForeground(Color.white);
        lblTabbedHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        pnTop.add(lblTabbedBanHang);
        pnTop.add(lblTabbedHoaDon);

        /*
        =========================================================================
                                    PANEL CT BÁN HÀNG
        =========================================================================
         */
        JPanel pnCTBanHang = new TransparentPanel();
        pnCTBanHang.setLayout(new BoxLayout(pnCTBanHang, BoxLayout.Y_AXIS));

        JPanel pnTableBanHang = new TransparentPanel();
        pnTableBanHang.setLayout(new BorderLayout());

        //====================Bảng hàng hoá====================
        JPanel pnTopBanHang = new TransparentPanel();
        pnCTBanHang.add(pnTopBanHang);
        pnTopBanHang.setLayout(new BoxLayout(pnTopBanHang, BoxLayout.X_AXIS));

        Main.changLNF("Metal");
        Main.changLNF("Windows");
        dtmBanHang = new DefaultTableModel();
        dtmBanHang.addColumn("Mã SP");
        dtmBanHang.addColumn("Tên SP");
        dtmBanHang.addColumn("Đơn giá");
        dtmBanHang.addColumn("Số lượng");
        dtmBanHang.addColumn("Đơn vị tính");
        dtmBanHang.addColumn("Ảnh");
        tblBanHang = new JTable(dtmBanHang);
        JScrollPane scrTblBanHang = new JScrollPane(tblBanHang);

        pnTableBanHang.add(scrTblBanHang, BorderLayout.CENTER);
        pnTopBanHang.add(pnTableBanHang);

        //====================Thông tin bán hàng====================
        JPanel pnThongTinBanHang = new JPanel();
        pnThongTinBanHang.setLayout(new BoxLayout(pnThongTinBanHang, BoxLayout.PAGE_AXIS));

        JPanel pnLoaiSP = new TransparentPanel();
        JLabel lblLoai = new JLabel("Loại SP");
        lblLoai.setFont(font);
        cmbLoaiSPBanHang = new JComboBox<>();
        cmbLoaiSPBanHang.setFont(font);
        loadDataComboboxLoaiBanSP();
        pnLoaiSP.add(lblLoai);
        pnLoaiSP.add(cmbLoaiSPBanHang);
        pnThongTinBanHang.add(pnLoaiSP);

        Main.changLNF("Nimbus");
        JPanel pnMaSP = new TransparentPanel();
        JLabel lblMa = new JLabel("Mã SP");
        lblMa.setFont(font);
        txtMaSPBanHang = new JTextField(15);
        txtMaSPBanHang.setFont(font);
        pnMaSP.add(lblMa);
        pnMaSP.add(txtMaSPBanHang);
        pnThongTinBanHang.add(pnMaSP);

        JPanel pnTenSP = new TransparentPanel();
        JLabel lblTen = new JLabel("Tên SP");
        lblTen.setFont(font);
        txtTenSPBanHang = new JTextField(15);
        txtTenSPBanHang.setFont(font);
        pnTenSP.add(lblTen);
        pnTenSP.add(txtTenSPBanHang);
        pnThongTinBanHang.add(pnTenSP);

        JPanel pnDonGiaSP = new TransparentPanel();
        JLabel lblDonGia = new JLabel("Đơn giá");
        lblDonGia.setFont(font);
        txtDonGiaBanHang = new JTextField(15);
        txtDonGiaBanHang.setFont(font);
        pnDonGiaSP.add(lblDonGia);
        pnDonGiaSP.add(txtDonGiaBanHang);
        pnThongTinBanHang.add(pnDonGiaSP);

        JPanel pnSoLuongSP = new TransparentPanel();
        JLabel lblSoLuong = new JLabel("Số lượng");
        lblSoLuong.setFont(font);
        txtSoLuongBanHang = new JTextField(15);
        txtSoLuongBanHang.setFont(font);
        pnSoLuongSP.add(lblSoLuong);
        pnSoLuongSP.add(txtSoLuongBanHang);
        pnThongTinBanHang.add(pnSoLuongSP);

        JPanel pnButtonBan = new TransparentPanel();
        btnThemVaoGio = new JLabel(new ImageIcon("image/ManagerUI/btn-BanHang.png"));
        pnButtonBan.add(btnThemVaoGio);
        pnThongTinBanHang.add(pnButtonBan);

        cmbLoaiSPBanHang.setPreferredSize(txtMaSPBanHang.getPreferredSize());
        Dimension sizeLabel = lblSoLuong.getPreferredSize();
        lblLoai.setPreferredSize(sizeLabel);
        lblMa.setPreferredSize(sizeLabel);
        lblTen.setPreferredSize(sizeLabel);
        lblDonGia.setPreferredSize(sizeLabel);

        pnTopBanHang.add(pnThongTinBanHang);

        //====================Thông tin giỏ hàng====================
        JPanel pnBottomBanHang = new TransparentPanel();
        pnBottomBanHang.setLayout(new BoxLayout(pnBottomBanHang, BoxLayout.X_AXIS));

        JPanel pnTableGioHang = new TransparentPanel();
        pnTableGioHang.setLayout(new BorderLayout());

        Main.changLNF("Metal");
        Main.changLNF("Windows");
        dtmGioHang = new DefaultTableModel();
        dtmGioHang.addColumn("Tên SP");
        dtmGioHang.addColumn("Số lượng");
        dtmGioHang.addColumn("Đơn giá");
        dtmGioHang.addColumn("Thành tiền");

        tblGioHang = new JTable(dtmGioHang);
        JScrollPane scrTblGioHang = new JScrollPane(tblGioHang);
        pnTableGioHang.add(scrTblGioHang, BorderLayout.CENTER);

        JPanel pnAnhSP = new TransparentPanel();
        pnAnhSP.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        pnAnhSP.setPreferredSize(new Dimension(
                (int) pnThongTinBanHang.getPreferredSize().getWidth(),
                (int) ((int) h - pnTitle.getHeight() - pnThongTinBanHang.getPreferredSize().getHeight())));
        lblAnhSP = new JLabel();
        lblAnhSP.setPreferredSize(new Dimension(200, 200));
        lblAnhSP.setBorder(BorderFactory.createLineBorder(clLeftItemSelected));
        JLabel lblTextAnh = new JLabel("Ảnh minh hoạ", JLabel.CENTER);
        lblTextAnh.setFont(font);
        lblTextAnh.setPreferredSize(new Dimension((int) pnAnhSP.getPreferredSize().getWidth(), 30));
        pnAnhSP.add(lblTextAnh);
        pnAnhSP.add(lblAnhSP);

        pnBottomBanHang.add(pnTableGioHang);
        pnBottomBanHang.add(pnAnhSP);

        pnCTBanHang.add(pnBottomBanHang);
        /*
        =========================================================================
                                    PANEL CT HOÁ ĐƠN
        =========================================================================
         */
        JPanel pnCTHoaDon = new JPanel();

        pnTabbedBanHang = new JPanel(cardBanHangGroup);
        pnTabbedBanHang.add(pnCTBanHang, "1");
        pnTabbedBanHang.add(pnCTHoaDon, "2");
        pnTabbedBanHang.setPreferredSize(new Dimension(w, (int) (h - pnTop.getPreferredSize().getHeight())));

        pnBanHang.add(pnTop);
        pnBanHang.add(pnTabbedBanHang);
    }

    private void addControlsNhanVien() {

    }

    private void loadDataComboboxLoaiBanSP() {
        cmbLoaiSPBanHang.addItem("0 - Chọn loại");

        //fake data trước, đoạn này đổ database
        cmbLoaiSPBanHang.addItem("1 - Pizza");
        cmbLoaiSPBanHang.addItem("2 - Nước uống");
    }

}
