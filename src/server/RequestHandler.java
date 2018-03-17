package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandler extends Thread{
    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public RequestHandler(Socket _clientSocket) {
        clientSocket = _clientSocket;
    }

    public void run() {
        try {
            in = new ObjectInputStream(this.clientSocket.getInputStream());
            out = new ObjectOutputStream(this.clientSocket.getOutputStream());

            Object input = receiveMsg();
            while (input != null) {
                //Print out equation and count
                System.out.println(input);
                Server.printCount();

                //Block until another message
                input = receiveMsg();
            }

            clientSocket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
