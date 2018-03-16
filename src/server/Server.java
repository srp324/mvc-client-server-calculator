package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int portNum;

    public static void main(String[] args) {
        portNum = Integer.parseInt(args[0]);

        try (ServerSocket ss = new ServerSocket(portNum)) {         //Listen For Connections
            while (true) {
                Socket client = ss.accept();

                RequestHandler rh = new RequestHandler(client);
                rh.start();
                System.out.println("A client has connected!");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
