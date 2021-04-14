package RMIChatProjekt;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class ServerOperation extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;
    public static String[] chatMessage;
    public static int messageIndex = 1;
    
    protected ServerOperation() throws RemoteException {
        super();
    }

    @Override
    public String helloTo(String name) throws RemoteException{
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    public static void main(String[] args) throws RemoteException{
		chatMessage = new String[messageIndex];
		chatMessage[0] = "Chat Connected \n";
        try {
        	//LocateRegistry.createRegistry(Registry.REGISTRY_PORT );
            Naming.rebind("//localhost/MyServer", new ServerOperation());            
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

	
	public void addMessages(String message, String name) throws RemoteException {
		String[] temp = new String[chatMessage.length];
		for (int i = 0; i < chatMessage.length; i++) {
			temp[i] = chatMessage[i];
		}
		messageIndex++;
		chatMessage = new String[messageIndex];
		
		for (int i = 0; i < temp.length;i++) {
			chatMessage[i] = temp[i];
		}
		chatMessage[temp.length] = name + " : " + message + "\n";
	}


	public String[] getMessages() throws RemoteException {
		String[] tess = chatMessage;
		
		return tess;
	}
}