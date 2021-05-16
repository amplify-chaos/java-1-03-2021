package XOGame;

import java.awt.BorderLayout;
        import java.awt.Container;
        import java.awt.Cursor;
        import java.awt.Dimension;
        import java.awt.GridLayout;
        import java.awt.Toolkit;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JOptionPane;
        import javax.swing.JPanel;

public class KrestikiNoliki {
    public static void main(String[] args) {
        KOFrame frame = new KOFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
    }
}

class KOFrame extends JFrame {

    JLabel score;

    public KOFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension ss = kit.getScreenSize();
        int scrW = ss.width;
        int scrH = ss.height;

        int fW = 300;
        int fH = 350;

        JFrame frame = new JFrame();

        score = new JLabel();

        setSize(fW, fH);
        setLocation((scrW - fW) / 2, (scrH - fH) / 2);
        setTitle("Крестики-нолики");
        setCursor(Cursor.HAND_CURSOR);

        KOPanel panel = new KOPanel(this);
        Container contain = getContentPane();
        contain.add(panel);
        ExitPanel exit_panel = new ExitPanel(panel);
        contain.add(exit_panel, "South");
        add(score, BorderLayout.NORTH);
        refreshScore(0, 0);
    }

    public void refreshScore(int x, int o) {
        score.setText("     Крестики: " + x + "     Нолики: " + o);
    }

}

class ExitPanel extends JPanel {
    KOPanel koPanel;

    public ExitPanel(final KOPanel koPanel) {
        setLayout(new GridLayout(1, 2));
        KOButton exit = new KOButton(4, 4);
        KOButton restart = new KOButton(5, 5);
        this.koPanel = koPanel;
        add(restart);
        add(exit);
        exit.setText("Выход");
        restart.setText("Новая игра");

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                System.exit(0);
            }
        });

        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                koPanel.clear();
                koPanel.clearGameScreen();
            }
        });

    }
}

class KOPanel extends JPanel {
    char[][] game_arr = new char[3][3];
    {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                game_arr[i][j] = ' ';
            }
        }
    }

    KOButton[][] buttons = new KOButton[3][3];
    public int count = 0;

    ImageIcon krest = new ImageIcon("x.png");
    ImageIcon nol = new ImageIcon("o.png");
    ImageIcon start = new ImageIcon("def.jpg");

    KOFrame koFrame;
    int xCount = 0;
    int oCount = 0;

    public KOPanel(KOFrame koFrame) {
        this.koFrame = koFrame;
        setLayout(new GridLayout(3, 3));

        {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    buttons[i][j] = new KOButton(i, j);
                    buttons[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            KOButton sourceOfAction = (KOButton) event
                                    .getSource();
                            if (count % 2 == 0
                                    && game_arr[sourceOfAction.getRow()][sourceOfAction
                                    .getColumn()] == ' ') {
                                game_arr[sourceOfAction.getRow()][sourceOfAction
                                        .getColumn()] = 'x';
                                sourceOfAction.setIcon(krest);
                                check();
                                count++;

                            } else if (count % 2 == 1
                                    && game_arr[sourceOfAction.getRow()][sourceOfAction
                                    .getColumn()] == ' ') {
                                game_arr[sourceOfAction.getRow()][sourceOfAction
                                        .getColumn()] = 'o';
                                sourceOfAction.setIcon(nol);
                                check();
                                count++;
                            }
                        }
                    });
                    add(buttons[i][j]);
                }
            }
        }
    }

    public void check() {
        String exit_option_string;
        int exit_option = 0;

        if ((game_arr[0][0] == 'x' && game_arr[0][1] == 'x' && game_arr[0][2] == 'x')
                || (game_arr[1][0] == 'x' && game_arr[1][1] == 'x' && game_arr[1][2] == 'x')
                || (game_arr[2][0] == 'x' && game_arr[2][1] == 'x' && game_arr[2][2] == 'x')
                || (game_arr[0][0] == 'x' && game_arr[1][0] == 'x' && game_arr[2][0] == 'x')
                || (game_arr[0][1] == 'x' && game_arr[1][1] == 'x' && game_arr[2][1] == 'x')
                || (game_arr[0][2] == 'x' && game_arr[1][2] == 'x' && game_arr[2][2] == 'x')
                || (game_arr[0][0] == 'x' && game_arr[1][1] == 'x' && game_arr[2][2] == 'x')
                || (game_arr[2][0] == 'x' && game_arr[1][1] == 'x' && game_arr[0][2] == 'x')) {
            JOptionPane.showMessageDialog(null, "Выиграли крестики!");
            clear();
            clearGameScreen();
            xCount++;
            koFrame.refreshScore(xCount, oCount);
        }

        else if ((game_arr[0][0] == 'o' && game_arr[0][1] == 'o' && game_arr[0][2] == 'o')
                || (game_arr[1][0] == 'o' && game_arr[1][1] == 'o' && game_arr[1][2] == 'o')
                || (game_arr[2][0] == 'o' && game_arr[2][1] == 'o' && game_arr[2][2] == 'o')
                || (game_arr[0][0] == 'o' && game_arr[1][0] == 'o' && game_arr[2][0] == 'o')
                || (game_arr[0][1] == 'o' && game_arr[1][1] == 'o' && game_arr[2][1] == 'o')
                || (game_arr[0][2] == 'o' && game_arr[1][2] == 'o' && game_arr[2][2] == 'o')
                || (game_arr[0][0] == 'o' && game_arr[1][1] == 'o' && game_arr[2][2] == 'o')
                || (game_arr[2][0] == 'o' && game_arr[1][1] == 'o' && game_arr[0][2] == 'o')) {
            JOptionPane.showMessageDialog(null, "Выиграли нолики!");
            clear();
            clearGameScreen();
            oCount++;
            koFrame.refreshScore(xCount, oCount);
        }
        else {
            boolean isEmpty = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game_arr[i][j] == ' ')
                        isEmpty = false;
                }
            }
            if (isEmpty) {
                JOptionPane.showMessageDialog(null, "Ничья!");
                clear();
                clearGameScreen();
            }
        }

        }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game_arr[i][j] = ' ';
            }
        }
    }

    public void clearGameScreen() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setIcon(start);
            }
        }
    }

}

class KOButton extends JButton {
    public KOButton(int r, int c) {
        super();
        row = r;
        column = c;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private int row, column;
}