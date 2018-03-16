package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

public class RequestHandler extends Thread{
    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            in = new ObjectInputStream(this.clientSocket.getInputStream());
            out = new ObjectOutputStream(this.clientSocket.getOutputStream());

            Object input = receiveMsg();
            while (input != null && !input.equals("quit")) {
                System.out.println(input);
                input = receiveMsg();
            }

            clientSocket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObjectInputStream getIn() {
        return in;
    }
    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }
    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    private Object receiveMsg(){

        Object receivedMsg = null;
        try {
            Object obj;                             //This will be the object that is read from the socket

            if ((obj = in.readObject()) != null)
                return obj;

        } catch (Exception e) {                     //Could not get input from reading; notify sending player
            System.out.println("Client disconnected.");
        }

        return receivedMsg;
    }

    private void sendMsg(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Integer> filterOdds(ArrayList<Integer> input) {
        ArrayList<Integer> oddsList = new ArrayList<>();
        for (Integer num : input)
            if (num % 2 == 1)
                oddsList.add(num);

        return oddsList;
    }

}
