package controller;

import controller.state.*;
import model.CalcModel;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class Controller extends Observable {
    View view;
    CalcModel model;
    State state;
    Command command;

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

            /*
            else if (state instanceof ErrorState) {
                //TODO
                System.out.println("State: ErrorOp");
                model.update();
            }*/

            setChanged();
            notifyObservers(model.equation);
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
            notifyObservers(model.equation);
        }
    }

    public void setModel(CalcModel _model) {
        model = _model;
    }

    public void setView(View _view) {
        view = _view;

        view.getJbtNum1().addActionListener(new DigitListener(1));
        view.getJbtNum2().addActionListener(new DigitListener(2));
        view.getJbtNum3().addActionListener(new DigitListener(3));
        view.getJbtNum4().addActionListener(new DigitListener(4));
        view.getJbtNum5().addActionListener(new DigitListener(5));
        view.getJbtNum6().addActionListener(new DigitListener(6));
        view.getJbtNum7().addActionListener(new DigitListener(7));
        view.getJbtNum8().addActionListener(new DigitListener(8));
        view.getJbtNum9().addActionListener(new DigitListener(9));
        view.getJbtNum0().addActionListener(new DigitListener(0));
        view.getJbtAdd().addActionListener(new OpListener("+"));
        view.getJbtSubtract().addActionListener(new OpListener("-"));
        view.getJbtMultiply().addActionListener(new OpListener("*"));
        view.getJbtDivide().addActionListener(new OpListener("/"));
        view.getJbtEqual().addActionListener(new OpListener("="));
        view.getJbtClear().addActionListener(new OpListener("C"));

        //TODO: Set Reset and Discard Action Listeners
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
