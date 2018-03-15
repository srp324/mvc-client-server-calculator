package controller;

import controller.state.StartState;
import controller.state.State;
import model.CalcModel;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    View view;
    CalcModel model;
    State state;
    Command command;

    Controller() {
        state = new StartState();
    }

    class DigitListener implements ActionListener {
        private Integer digit;

        DigitListener(Integer _digit) {
            digit = _digit;
        }

        public void actionPerformed(ActionEvent e) {
            //Controller State is changed based on Command
            command = Command.DIGIT;
            state.handle(Controller.this);

            model.digitOperation(digit);
        }
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Controller State is changed based on Command
            command = Command.ADD;
            state.handle(Controller.this);

            model.addOperation(view.getDisplay());
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
        view.getJbtAdd().addActionListener(new AddListener());
    }
}
