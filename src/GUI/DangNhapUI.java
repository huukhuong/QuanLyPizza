package GUI;

import BLL.DangNhapService;
import DTO.TaiKhoan;
import quanlysinhvien.GUI.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DangNhapUI extends JFrame {

    public DangNhapUI() {
        this.setTitle("Đăng nhập");
        this.setSize(443, 590);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        addControls();
        addEvents();
    }

    private JLabel btnExit, btnLogin, btnForgot;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JPanel pnMain;

    private void addControls() {
        Container con = getContentPane();

        pnMain = new ImagePanel("image/background-login.png");
        pnMain.setLayout(null);

        btnExit = new JLabel(new ImageIcon("image/btn-close.png"));
        btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnExit.setBounds(395, 120, 28, 28);

        btnLogin = new JLabel(new ImageIcon("image/btn-login.png"));
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setBounds(40, 448, 362, 55);

        btnForgot = new JLabel(new ImageIcon("image/btn-forgot.png"));
        btnForgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnForgot.setBounds(140, 516, 166, 30);

        Font fontTXT = new Font("", Font.BOLD, 18);
        txtUser = new JTextField();
        txtUser.setBackground(new Color(0, 0, 0, 0f));
        txtUser.setBorder(BorderFactory.createEmptyBorder());
        txtUser.setForeground(Color.WHITE);
        txtUser.setFont(fontTXT);
        txtUser.setHorizontalAlignment(JTextField.LEFT);
        txtUser.setBounds(52, 290, 340, 45);

        txtPassword = new JPasswordField();
        txtPassword.setEchoChar('•');
        txtPassword.setBackground(new Color(0, 0, 0, 0f));
        txtPassword.setBorder(BorderFactory.createEmptyBorder());
        txtPassword.setForeground(Color.WHITE);
        txtPassword.setFont(fontTXT);
        txtPassword.setHorizontalAlignment(JTextField.LEFT);
        txtPassword.setBounds(52, 375, 340, 45);

        pnMain.add(btnExit);
        pnMain.add(txtUser);
        pnMain.add(txtPassword);
        pnMain.add(btnLogin);
        pnMain.add(btnForgot);

        con.add(pnMain);
    }

    private void addEvents() {
        moveFrame();
        btnExit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyThoat();
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
        txtUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyDangNhap();
            }
        });
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyDangNhap();
            }
        });
        btnForgot.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyQuenMatKhau();
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
        btnLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyDangNhap();
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

    int xMouse, yMouse;

    private void moveFrame() {
        pnMain.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                Move(x, y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });
    }

    private void Move(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void xuLyThoat() {
        System.exit(0);
    }

    private void xuLyQuenMatKhau() {
        new MyDialog("Xin liên hệ Admin để giải quyết!", MyDialog.INFO_DIALOG);
    }

    private void xuLyDangNhap() {
        TaiKhoan tk = DangNhapService.getTaiKhoanDangNhap(txtUser.getText(),
                txtPassword.getText());
        if (tk == null) {

        } else {

        }
    }

    public void showWindow() {
        this.setVisible(true);
    }

}
