package view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class View extends JFrame implements Observer {

    private JPanel p1;
    private JPanel pError;

    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JButton jb9;
    private JButton jb0;

    private JButton jbAdd;
    private JButton jbSub;
    private JButton jbMult;
    private JButton jbDiv;
    private JButton jbEqual;
    private JButton jbClear;
    private JTextField jtfDisplay;

    private JButton jbDiscard;
    private JButton jbReset;

    public View() {

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 4));
        p1.add(jb1 = new JButton("1"));
        p1.add(jb2 = new JButton("2"));
        p1.add(jb3 = new JButton("3"));
        p1.add(jbAdd = new JButton("+"));
        p1.add(jb4 = new JButton("4"));
        p1.add(jb5 = new JButton("5"));
        p1.add(jb6 = new JButton("6"));
        p1.add(jbSub = new JButton("-"));
        p1.add(jb7 = new JButton("7"));
        p1.add(jb8 = new JButton("8"));
        p1.add(jb9 = new JButton("9"));
        p1.add(jbMult = new JButton("*"));
        p1.add(jb0 = new JButton("0"));
        p1.add(jbEqual = new JButton("="));
        p1.add(jbClear = new JButton("C"));
        p1.add(jbDiv = new JButton("/"));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfDisplay = new JTextField(20));
        jtfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        jtfDisplay.setEditable(false);

        pError = new JPanel();
        pError.setLayout(new GridLayout(2,2));
        pError.add(jbDiscard = new JButton("Discard"));
        pError.add(jbReset = new JButton("Reset"));
        pError.setVisible(false);

        main.add(p2);
        main.add(pError);
        main.add(p1);

        add(main);
    }

    public void init() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("error")) {
            p1.setVisible(false);
            pError.setVisible(true);
        }
        else {
            p1.setVisible(true);
            pError.setVisible(false);
        }

        jtfDisplay.setText((String) arg);
    }

    public JButton getJb1() {
        return jb1;
    }

    public JButton getJb2() {
        return jb2;
    }

    public JButton getJb3() {
        return jb3;
    }

    public JButton getJb4() {
        return jb4;
    }

    public JButton getJb5() {
        return jb5;
    }

    public JButton getJb6() {
        return jb6;
    }

    public JButton getJb7() {
        return jb7;
    }

    public JButton getJb8() {
        return jb8;
    }

    public JButton getJb9() {
        return jb9;
    }

    public JButton getJb0() {
        return jb0;
    }

    public JButton getJbAdd() {
        return jbAdd;
    }

    public JButton getJbSub() {
        return jbSub;
    }

    public JButton getJbMult() {
        return jbMult;
    }

    public JButton getJbDiv() {
        return jbDiv;
    }

    public JButton getJbEqual() {
        return jbEqual;
    }

    public JButton getJbClear() {
        return jbClear;
    }

    public JButton getJbDiscard() {
        return jbDiscard;
    }

    public JButton getJbReset() {
        return jbReset;
    }
}