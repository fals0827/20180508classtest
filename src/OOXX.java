import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OOXX extends JFrame{
    private JButton jbtRun = new JButton("Run");
    private JButton jbtRset = new JButton("Reset");
    private JButton jbtExit = new JButton("Exit");
    private JButton [][] jbtns = new JButton[3][3] ;
    private Container cp ;
    private JPanel jpnC = new JPanel(new GridLayout(3,3,2,2));
    private JPanel jpnE = new JPanel(new GridLayout(3,1,2,2));
    private Boolean flag = true;

    public OOXX () {
        this.init();
    }

    private void init () {
        setBounds(200,100,1280,960);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnE,BorderLayout.EAST);

        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 3 ; j ++){
                jbtns [i][j] = new JButton();
                jpnC.add(jbtns[i][j]);
                jbtns [i][j].setBackground(new Color(18, 116, 255));
                jbtns [i][j].setFont(new Font(null,Font.BOLD,100));
                jbtns [i][j].setEnabled(false);
                jbtns [i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmp = (JButton) e.getSource();
                        if (tmp.getText().equals("")){
                            if (flag){
                                tmp.setText("O");
                            }
                            else {
                                tmp.setText("X");
                            }
                        }
                        flag = !flag;
                        tmp.setBackground(new Color(233, 255, 4));
                        checkW();
                    }
                });
            }
        }

        jpnE.add(jbtRun);
        jpnE.add(jbtRset);
        jpnE.add(jbtExit);

        jbtRun.setFont(new Font(null,Font.BOLD,50));
        jbtRset.setFont(new Font(null,Font.BOLD,50));
        jbtExit.setFont(new Font(null,Font.BOLD,50));

        jbtRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 3 ; i ++){
                    for (int j = 0 ; j < 3 ; j ++){
                        jbtns[i][j].setEnabled(true);
                    }
                }
            }
        });

        jbtRset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 3 ; i ++){
                    for (int j = 0 ; j < 3 ; j ++){
                        jbtns[i][j].setEnabled(false);
                        jbtns[i][j].setBackground(new Color(18, 116, 255));
                        jbtns[i][j].setText("");
                    }
                }
            }
        });

        jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void checkW (){
        if (jbtns[0][0].getText().equals(jbtns[0][1].getText()) &&
                jbtns[0][0].getText().equals(jbtns[0][2].getText()) &&
                !jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[0][0].getText() + "  Win");
        }else if (jbtns[1][0].getText().equals(jbtns[1][1].getText()) &&
                jbtns[1][0].getText().equals(jbtns[1][2].getText()) &&
                !jbtns[1][0].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[1][0].getText() + "  Win");
        }else if (jbtns[2][0].getText().equals(jbtns[2][1].getText()) &&
                jbtns[2][0].getText().equals(jbtns[2][2].getText()) &&
                !jbtns[2][0].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[2][0].getText() + "  Win");
        }else if (jbtns[0][0].getText().equals(jbtns[1][0].getText()) &&
                jbtns[0][0].getText().equals(jbtns[2][0].getText()) &&
                !jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[0][0].getText() + "  Win");
        }else if (jbtns[0][1].getText().equals(jbtns[1][1].getText()) &&
                jbtns[0][1].getText().equals(jbtns[2][1].getText()) &&
                !jbtns[0][1].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[0][1].getText() + "  Win");
        }else if (jbtns[0][2].getText().equals(jbtns[1][2].getText()) &&
                jbtns[0][2].getText().equals(jbtns[2][2].getText()) &&
                !jbtns[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[0][2].getText() + "  Win");
        }else if (jbtns[0][0].getText().equals(jbtns[1][1].getText()) &&
                jbtns[0][0].getText().equals(jbtns[2][2].getText()) &&
                !jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[0][0].getText() + "  Win");
        }else if (jbtns[0][2].getText().equals(jbtns[1][1].getText()) &&
                jbtns[0][2].getText().equals(jbtns[2][0].getText()) &&
                !jbtns[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(OOXX.this , jbtns[0][2].getText() + "  Win");
        }
    }
}
