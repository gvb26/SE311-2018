package hw4;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Controller {
	
	double value = 0.0;
	View view;
	String equation = "";
	ArrayList<String> equations = new ArrayList<String>();
	public Controller() {
		view = new View(this);
		
	}
	
	public ActionListener actionListener() {
		return new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton) e.getSource();
					String input = button.getText();
					if (input == "=") {
						Socket socket;
						try {
							socket = new Socket("127.0.0.1", 9876);
							ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());  
					        os.writeObject(equation);

					        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
					        double result;
							try {
								result = (double) is.readObject();
								view.setValue(Double.toString(result));
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							os.flush();
							equations.add(equation);
							os.writeObject(equations);
							socket.close();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					} else if (input == "C") {
						view.setValue("0");
						equation = "";
					}
					else {
						if (input == "+" || input == "-" || input == "*" || input == "/") {
							equation += String.format(" %s ", input);
						} else {
							equation += input;
						}	
						view.setValue(equation);
					}
					
					//view.setValue(input);
				}
			};
	}
	

}
