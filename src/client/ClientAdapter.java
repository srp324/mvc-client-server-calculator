package client;

import controller.Controller;
import model.CalcModel;
import view.View;

public class ClientAdapter {
    private static int port;
    private static String hostName;
    private static Client client;

    public static void main(String[] args) {
        hostName = args[0];
        port = Integer.parseInt(args[1]);
        System.out.println("Host: " + hostName + " Port: " + port);
        client = new Client();
        if(!client.initConn(hostName,port)){
            System.out.println("Enter the correct host and port in the config file");
            System.exit(0);
        }

        //Driver
        View calcView = new View();
        CalcModel model = new CalcModel();
        Controller controller = new Controller();

        controller.setModel(model);
        controller.setView(calcView);
        controller.addObserver(calcView);
        calcView.init();
    }
}
