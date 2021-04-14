package RMIChatProjekt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


import javax.swing.JOptionPane;




public class ClientOperation {

    private static RMIInterface look_up;
    public String[] chatMessages;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        
        look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
        String name = JOptionPane.showInputDialog("What is your name?");
            
        String response = look_up.helloTo(name);
        JOptionPane.showMessageDialog(null, response);
        
        while (true) {
	        String message = JOptionPane.showInputDialog("enter msg");
	
	        look_up.addMessages(message, name);
	        String[] messageArray = look_up.getMessages();
	        for (int i = 0; i < messageArray.length; i++) {
	        System.out.print(messageArray[i]);	
	        }
        }

    }
}