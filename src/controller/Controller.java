package controller;

import controller.state.*;
import model.CalcModel;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
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
            //Controller State is changed based on Command

            command = Command.DIGIT.getDigit(digit);
            state.handle(Controller.this);

            /*if (state instanceof FirstOpState) {
                System.out.println("State: FirstOp");
                model.update();
            }
            else if (state instanceof SecondOpState) {
                System.out.println("State: SecondOp");
                model.update();
            }
            else if (state instanceof ErrorState) {
                //TODO
                System.out.println("State: ErrorOp");
                model.update();
            }*/
            model.update();
        }
    }

    /*class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Controller State is changed based on Command
            command = Command.ADD;
            state.handle(Controller.this);

            if (state instanceof NextOpState) {
                System.out.println("State: NextOp");

                //model.addOperation(view.getDisplay());
                model.update();
            }
            else if (state instanceof ErrorState) {
                System.out.println("State: ErrorOp");
                model.update();
            }
        }
    }*/

    class OpListener implements ActionListener {
        private String op;

        OpListener(String _op) {
            op = _op;
        }

        public void actionPerformed(ActionEvent e) {
            command = Command.OP.getOp(op);
            state.handle(Controller.this);

            /*if (state instanceof NextOpState) {
                System.out.println("State: NextOp");
                model.update();
            }
            else if (state instanceof ErrorState) {
                System.out.println("State: ErrorOp");
                model.update();
            }*/
            model.update();
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
