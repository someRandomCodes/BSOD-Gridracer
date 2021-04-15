package client;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.util.Scanner;

import chatInterface.ChatInterface;

public class Client extends UnicastRemoteObject implements ChatInterface , Runnable {
    private static final long serialVersionUID = 1L;
    private ChatInterface server;
    private String ClientName;
    boolean chkExit = true;
    boolean chkLog = false;
 
    protected Client(ChatInterface chatinterface,String clientname) throws RemoteException {
        this.server = chatinterface;
        this.ClientName = clientname;
        chkLog = server.checkClientCredintials(this,clientname);
    }

    public void sendMessageToClient(String message) throws RemoteException {
        System.out.println(message); 
    }
    public void sendMessageToClients(String message) throws RemoteException {
        System.out.println("sollte gehen"); 
    }
 
    public void broadcastMessage(String clientname,String message) throws RemoteException {}
 
    public boolean checkClientCredintials(ChatInterface chatinterface ,String clientname) throws RemoteException {
        return true;
    }
    

    public void run() {
        if(chkLog) {
            System.out.println("Successfully Connected To RMI Server");
            System.out.println("NOTE : Type LOGOUT to Exit From The Service");
            System.out.println("Now Your Online To Chat\n");
            Scanner scanner = new Scanner(System.in);
            String message;
            
            while(chkExit) {
                message = scanner.nextLine();
                if(message.equals("LOGOUT")) {
                    chkExit = false;
                }
                else {
                    try {
                        server.broadcastMessage(ClientName , message);
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                    }
                }  
            } 
            System.out.println("\nSuccessfully Logout From The RMI Chat Program\nThank You For Using...\nDeveloped By Nifal Nizar");
        }
        else {
            System.out.println("\nClient Name or Password Incorrect...");
        }  
    }
    public static void main(String[] args) throws MalformedURLException,RemoteException,NotBoundException {
        Scanner scanner = new Scanner(System.in);
        String clientName = "";

  
        System.out.println("\n~~ Welcome To RMI Chat Program ~~\n");  
        System.out.print("Enter The Name : ");
        clientName = scanner.nextLine();
        System.out.println("\nConnecting To RMI Server...\n");

        ChatInterface chatinterface = (ChatInterface)Naming.lookup("//localhost/RMIServer");
        new Thread(new Client(chatinterface , clientName)).start();
    }
 
}