package serverApplication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
    String check() throws RemoteException;
    void newMsg(String msg) throws RemoteException;
}