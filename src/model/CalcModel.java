package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Is the View the only observer that has to be added to model?
// If so, is the observer pattern followed when I add the View as an actionListener to the model since it will update the view everytime an event occurs from controller?
public class CalcModel extends CalcList {
    private ArrayList<ActionListener> actionListenerList;

    public CalcModel() {
        super();
    }

    // 2. Transitions model state and then processesEvent to update the view
    public void update() {
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "update"));
    }

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
