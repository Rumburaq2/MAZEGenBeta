import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyLogin {
    private static int sizeI=3;
    public static int sizeJ=3;

    public static int getSizeJ(){
        return sizeJ;
    }
    public static int getSizeI(){
        return sizeI;
    }
    private JFrame f = new JFrame("Login");
    private JButton bok = new JButton("generovat");
    private JPanel panel = new JPanel();

    String[] optionsToChoose = {"5x5", "10x10", "15x15", "20x20", "None of the listed"};
    JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);


    public MyLogin() {

        f.setPreferredSize(new Dimension(600, 600));
        f.pack();
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        bok.setPreferredSize(new Dimension(120, 40));
        jComboBox.setBounds(80, 60, 140, 20);
        panel.add(bok);
        panel.add(jComboBox);
        //f.add((jComboBox));
        //f.getContentPane().add(bok);
        f.getContentPane().add(panel);
        //f.add(bok);
        //f.add(panel);


        /*
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(panel);
        f.pack();
        f.setLocationByPlatform(true);
        f.setVisible(true);

         */

        jComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //f.dispose();
                JComboBox cb = (JComboBox)ae.getSource();
                String size = (String)cb.getSelectedItem();
                if(size == "5x5"){
                    sizeI = 5;
                    sizeJ = 5;
                }
                else if(size == "15x15"){
                    sizeI = 15;
                    sizeJ = 15;
                }
                //new SecondFrame();
            }
        });

        bok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                f.dispose();
                new SecondFrame();
            }
        });


        f.setSize(500,500);
        f.setVisible(true);
    }
}
