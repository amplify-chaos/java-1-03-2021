package HomeWorkApp8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame {

    private static final ImageIcon ICON_X = new ImageIcon("x.png");
    private static final ImageIcon ICON_O = new ImageIcon("0.png");
    private static final ImageIcon ICON_DEFAULT = new ImageIcon("def.jpg");

    public Window() throws HeadlessException {
        setSize(500, 500);
        setLocation(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("FILE");
        JMenuItem item1 = new JMenuItem("open");
        JMenuItem item2 = new JMenuItem("save");
        JMenuItem item3 = new JMenuItem("exit");
        item3.addActionListener(e -> dispose());
        item1.addActionListener(e -> {
            new Window();
            dispose();
        });

        JMenu view = new JMenu("VIEW");

        file.add(item1);
        file.add(item2);
        file.add(item3);

        view.add(new JMenuItem("view"));
        view.add(new JMenuItem("edit"));

        menuBar.add(file);
        menuBar.add(view);

        add(menuBar);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Copyright Anastasia Russkih, 2021");
        JPanel fp = new JPanel(new GridLayout(3,3));
        JButton [][] buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(ICON_DEFAULT);
                buttons[i][j].setDisabledIcon(ICON_DEFAULT);
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].addActionListener(e -> {
                    System.out.println(finalI + " " + finalJ);
                    buttons[finalI][finalJ].setIcon(ICON_X);
                    buttons[finalI][finalJ].setEnabled(false);
                    buttons[finalI][finalJ].setDisabledIcon(ICON_X);
                    // moveAi(buttons);
                });
                fp.add(buttons[i][j]);
            }
        }

        panel.add(menuBar, BorderLayout.NORTH);
        panel.add(label, BorderLayout.SOUTH);
        panel.add(fp, BorderLayout.CENTER);
        add(panel);
        panel.setVisible(true);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}