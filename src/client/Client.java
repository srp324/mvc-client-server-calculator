package client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket s1;
    private ObjectInputStream in;
    private static ObjectOutputStream out;

    //TODO: Separate client and server into two projects
    /***
     * Slide 2
     * -This is going to be a rich client application.
     * -Yes, the controller can be the context of States.
     * Q: Is it correct to have the Model (Composite Structure) contained within the controller.Controller and have controller.Controller be the context of States?
     * A: it depends on how do you define controller.
     * The composite structure should have separate classes, which should be different from the controller class,
     * which, in turn, should be an observer of the GUI.
     * Yes, the controller can be the context of States.
     *
     * Slide 3
     * Q: Would it be wrong to only have the composite/visitor pattern on the server side?
     * A: no. it is up to your design; you can put visitor either on the client or server side
     * Q: Does composite need to be on the client side? Or am I able to keep track of numbers/operators in the concrete states?
     * A: Composite can be on the client side
     *
     * Slide 4
     * - calculation should be done by a concrete visitor
     *
     * Slide 5
     * - All the buttons are Subjects in the observer pattern; the GUI (view) should have no knowledge of the model, that is, composite classes, or the visitors
     *
     * Slide 6:
     * - The controller should be the observer of the GUI, and take the context role of the state pattern.
     * - Remember that Controller in MVC is a component, which may contain multiple classes
     * - Controller class is the context in the state pattern, and individual state control state change, and controller just holds the current state.
     * Q: You mean state pattern classes are controller part itself?
     * A:  Yes, you can say that.
     *
     * Slide 9:
     * - MCV is architectural pattern, observer is a design pattern. the MVC will be implemented using observer.
     * - the GUI is the view component in the MVC, but it takes the Subject  role in the observer pattern.
     *
     ****Slide 10:****
     * Q: could you please explain how/what we're supposed to use composite/visitor pattern?
     * A:
     * ------> The composite pattern holds the data structure of the binary tree, !!!which is the model of the system.!!!
     * ------> You should have two concrete visitors: one for calculating the equations, another for forming the equation string.
     * ------> The visitors will have to visit the composite to do their jobs.
     *
     * ====================
     * Model: Composite pattern (holds the data structure of the binary tree)
     *        Two concrete visitors (calculating the equation and forming the equation string) when visiting the composites
     * View: GUI. It is the subject (as all the buttons are) in the observer pattern.
     * Controller: Context in the State pattern
     *             Also the observer (listeners are)
     *             Individual state... controls state change?
     *             Controller just holds the current state. The State pattern classes are part of the controller itself.
     * ====================
     *
     * Q: Is it correct to have the Model (Composite Structure) contained within the Controller and have Controller be the context of States?
     * State Pattern Slide 6: A context may pass itself as an argument to the State object handling the
                              request. This lets the State object access the context if necessary
     * So essentially, the controller will call state.handle(this) and is able to access the composite model from there.




     */
    public boolean initConn(String hostName, int port) {
        // Socket Magic Here!
        try {
            s1 = new Socket(hostName, port);
        } catch (IOException e1) {
            return false;
        }
        try {
            out = new ObjectOutputStream(this.s1.getOutputStream());
            in = new ObjectInputStream(this.s1.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /****************************************************
     * Sends Message of Move to Server to be Validated
     * @param m1
     ****************************************************/

    public static void sendMsg(Object m1) {
        try {
            out.writeObject(m1);
            out.flush();
            out.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**************************************************************
     * Receives message from Server For ClientAdapter to Process
     * @return
     **************************************************************/

    public Object receiveMsg(){
        Object m1= null;
        try {
            m1 = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return m1;
    }

    /*
     public <T> T receiveMsg(Class<T> type){
        T m1= null;
        try {
            m1 = (T) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return m1;
    }
    */

}
