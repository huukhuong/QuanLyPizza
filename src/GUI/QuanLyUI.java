package GUI;

import DAO.MyConnect;
import static Main.Main.changLNF;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

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

    private JPanel pnTitle, pnCard, pnBanHang, pnNhapHang, pnSanPham, pnNhanVien, pnKhachHang;
    ;
    private JLabel btnClose, btnMinimize, lblBanHang, lblNhapHang, lblSanPham, lblNhanVien, lblKhachHang;
    private final Color clLeftItem = new Color(63, 74, 89);
    private final Color clLeftItemHover = new Color(72, 88, 107);
    private final Color clLeftItemSelected = new Color(51, 202, 187);
    private ArrayList<JLabel> listMenuLeft;
    private CardLayout cardGroup = new CardLayout();

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
        JPanel pnMenuLeft = new JPanel();
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
        pnCard = new JPanel(cardGroup);

        pnBanHang = new JPanel();
        pnNhapHang = new JPanel();
        pnSanPham = new JPanel();
        pnNhanVien = new JPanel();
        pnKhachHang = new JPanel();

        pnBanHang.setBackground(Color.BLACK);
        pnNhapHang.setBackground(Color.BLUE);
        pnSanPham.setBackground(Color.CYAN);
        pnNhanVien.setBackground(Color.GRAY);
        pnKhachHang.setBackground(Color.MAGENTA);

        pnCard.add(pnBanHang, "1");
        pnCard.add(pnNhapHang, "2");
        pnCard.add(pnSanPham, "3");
        pnCard.add(pnNhanVien, "4");
        pnCard.add(pnKhachHang, "5");

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
                    cardGroup.show(pnCard, cardName);
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

}
