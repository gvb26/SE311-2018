package hw4;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class RequestHandler extends Thread {

    private Socket clientSocket = null;

    public RequestHandler(Socket cs) {
        clientSocket = cs;
    }


    public void run() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(clientSocket.getInputStream());
            @SuppressWarnings("unchecked")
            String input = (String) is.readObject();
            double result;
            StringTokenizer s = new StringTokenizer(input);
            double n1 = Integer.parseInt(s.nextToken());
            String op = s.nextToken();
            double n2 = Integer.parseInt(s.nextToken());
            ArrayList<String> equations = new ArrayList<String>();
            switch (op) {
                case "+":
                    result = n1 + n2;
                    os.writeObject(result);
                case "-":
                    result = n1 - n2;
                    os.writeObject(result);
                case "*":
                    result = n1 * n2;
                    os.writeObject(result);
                case "/":
                    result = n1 / n2;
                    os.writeObject(result);
            }
            //ObjectInputStream is1 = new ObjectInputStream(clientSocket.getInputStream());
            ArrayList<String> eq = (ArrayList<String>) is.readObject();
            System.out.println(String.format("Number of Successful Equations: %s", eq.size()));
            System.out.println("Equations: ");
            for (int i = 0; i < eq.size(); i++) {
                System.out.println(eq.get(i));
            }
            clientSocket.close();
        } catch (IOException | ClassNotFoundException ioex) {
            ioex.printStackTrace();
        }
    }

    public ArrayList<String> equationList(ArrayList<String> e) {
        return e;
    }
}

