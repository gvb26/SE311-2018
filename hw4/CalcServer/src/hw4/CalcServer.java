package hw4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9876);

        while(true) {
            Socket client = server.accept();

            RequestHandler rh = new RequestHandler(client);
            rh.start();
        }

    }
}
