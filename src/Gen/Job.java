package Gen;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Job extends Remote{
	 String executeJob() throws RemoteException;
}
