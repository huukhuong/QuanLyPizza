package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingGUI extends JFrame {

    private Timer timer;
    int time = 0;

    public LoadingGUI() {
        this.setUndecorated(true);
        Container con = getContentPane();
        JLabel lblImage = new JLabel(new ImageIcon("image/loading.gif"));
        con.add(lblImage);
    }

    public void showWindow() {
        this.setBackground(new Color(0, 0, 0, 0));
        this.setSize(600, 600);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (time >= 0) {
                    time--;
                    if (time == 60) {
                        quanLyGUI = new MainQuanLyGUI();
                    }
                } else {
                    quanLyGUI.showWindow();
                    thoatFrame();
                }
            }
        });

        time = 100;
        timer.start();
    }

    MainQuanLyGUI quanLyGUI = null;

    private void thoatFrame() {
        time = 0;
        timer.stop();
        this.dispose();
    }
}
