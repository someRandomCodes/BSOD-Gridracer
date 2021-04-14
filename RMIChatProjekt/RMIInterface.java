package RMIChatProjekt;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    public String helloTo(String name) throws RemoteException;
    public void addMessages(String message, String name) throws RemoteException;
    public String[] getMessages() throws RemoteException;

}
