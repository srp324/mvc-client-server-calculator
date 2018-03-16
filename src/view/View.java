package view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class View extends JFrame implements Observer {

    private JPanel main;
    private JPanel p1;
    private JPanel p2;
    private JPanel pError;

    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;

    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtEqual;
    private JButton jbtClear;
    private JTextField jtfResult;

    private JButton jbtDiscard;
    private JButton jbtReset;

    public View() {

        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 4));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtAdd = new JButton("+"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtSubtract = new JButton("-"));
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtMultiply = new JButton("*"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtEqual = new JButton("="));
        p1.add(jbtClear = new JButton("C"));
        p1.add(jbtDivide = new JButton("/"));

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(20));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setEditable(false);

        pError = new JPanel();
        pError.setLayout(new GridLayout(2,2));
        pError.add(jbtDiscard = new JButton("Discard"));
        pError.add(jbtReset = new JButton("Reset"));
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

        jtfResult.setText((String) arg);
    }

    public JButton getJbtNum1() {
        return jbtNum1;
    }

    public JButton getJbtNum2() {
        return jbtNum2;
    }

    public JButton getJbtNum3() {
        return jbtNum3;
    }

    public JButton getJbtNum4() {
        return jbtNum4;
    }

    public JButton getJbtNum5() {
        return jbtNum5;
    }

    public JButton getJbtNum6() {
        return jbtNum6;
    }

    public JButton getJbtNum7() {
        return jbtNum7;
    }

    public JButton getJbtNum8() {
        return jbtNum8;
    }

    public JButton getJbtNum9() {
        return jbtNum9;
    }

    public JButton getJbtNum0() {
        return jbtNum0;
    }

    public JButton getJbtAdd() {
        return jbtAdd;
    }

    public JButton getJbtSubtract() {
        return jbtSubtract;
    }

    public JButton getJbtMultiply() {
        return jbtMultiply;
    }

    public JButton getJbtDivide() {
        return jbtDivide;
    }

    public JButton getJbtEqual() {
        return jbtEqual;
    }

    public JButton getJbtClear() {
        return jbtClear;
    }

    public JButton getJbtDiscard() {
        return jbtDiscard;
    }

    public JButton getJbtReset() {
        return jbtReset;
    }
}