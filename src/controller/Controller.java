package controller;

import controller.state.*;
import model.CalcModel;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class Controller extends Observable {
    private View view;
    private CalcModel model;
    private State state;
    private Command command;

    public Controller() {
        state = new StartState();
    }

    class DigitListener implements ActionListener {
        private Integer digit;

        DigitListener(Integer _digit) {
            digit = _digit;
        }

        public void actionPerformed(ActionEvent e) {
            command = Command.DIGIT.getDigit(digit);
            state.handle(Controller.this);

            setChanged();
            notifyObservers(model.getEquation());
        }
    }

    class OpListener implements ActionListener {
        private String op;

        OpListener(String _op) {
            op = _op;
        }

        public void actionPerformed(ActionEvent e) {
            command = Command.OP.getOp(op);
            state.handle(Controller.this);

            setChanged();
            notifyObservers(model.getEquation());
        }
    }

    public void setModel(CalcModel _model) {
        model = _model;
    }

    public void setView(View _view) {
        view = _view;

        view.getJb1().addActionListener(new DigitListener(1));
        view.getJb2().addActionListener(new DigitListener(2));
        view.getJb3().addActionListener(new DigitListener(3));
        view.getJb4().addActionListener(new DigitListener(4));
        view.getJb5().addActionListener(new DigitListener(5));
        view.getJb6().addActionListener(new DigitListener(6));
        view.getJb7().addActionListener(new DigitListener(7));
        view.getJb8().addActionListener(new DigitListener(8));
        view.getJb9().addActionListener(new DigitListener(9));
        view.getJb0().addActionListener(new DigitListener(0));
        view.getJbAdd().addActionListener(new OpListener("+"));
        view.getJbSub().addActionListener(new OpListener("-"));
        view.getJbMult().addActionListener(new OpListener("*"));
        view.getJbDiv().addActionListener(new OpListener("/"));
        view.getJbEqual().addActionListener(new OpListener("="));
        view.getJbClear().addActionListener(new OpListener("C"));
        view.getJbDiscard().addActionListener(new OpListener("Discard"));
        view.getJbReset().addActionListener(new OpListener("Reset"));
    }

    public void setState(State s) {
        this.state = s;
    }

    public Command getCommand() {
        return command;
    }

    public CalcModel getModel() {
        return model;
    }
}
