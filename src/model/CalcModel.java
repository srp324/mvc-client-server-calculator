package model;

import controller.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


// TODO: How do I follow observer pattern?
//      Is the View the only observer that has to be added to model?
//      If so, is the observer pattern followed when I add the View as an actionListener to the model since it will update the view everytime an event occurs from controller?
// TODO: How does composite and visitor play into this?
public class CalcModel extends CalcList {
    private ArrayList<ActionListener> actionListenerList;

    public CalcModel() {
        super();
    }

    // 2. Transitions model state and then processesEvent to update the view
    public void digitOperation(Integer digit) {
        switch (digit) {
            case 1:
                transition(Command.ONE);
                break;
            case 2:
                transition(Command.TWO);
                break;
            case 3:
                transition(Command.THREE);
                break;
            case 4:
                transition(Command.FOUR);
                break;
            case 5:
                transition(Command.FIVE);
                break;
            case 6:
                transition(Command.SIX);
                break;
            case 7:
                transition(Command.SEVEN);
                break;
            case 8:
                transition(Command.EIGHT);
                break;
            case 9:
                transition(Command.NINE);
                break;
            case 0:
                transition(Command.ZERO);
                break;
        }
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "digit"));
    }

    // 2. Transitions model state and then processesEvent to update the view
    public void addOperation(String display) {
        transition(Command.ADD);
        full = full + " + ";
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "add"));
    }

    /**
     * Register an action event listener.
     */
    public synchronized void addActionListener(ActionListener l) {
        if (actionListenerList == null)
            actionListenerList = new ArrayList<ActionListener>();
        actionListenerList.add(l);
    }

    private void processEvent(ActionEvent e) {

        for (int i = 0; i < actionListenerList.size(); i++) {
            ActionListener listener = actionListenerList.get(i);
            listener.actionPerformed(e);
        }
    }
}
