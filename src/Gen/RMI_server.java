package Gen;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class RMI_server implements Job{
	
    public static void main(String[] args){
    	try {
    		String name = "sysinfo";
        	Job job = new RMI_server();
			Job stub = (Job) UnicastRemoteObject.exportObject(job, 0);
			
			Registry reg = LocateRegistry.createRegistry(1699);
			reg.rebind(name, stub);
			System.out.println("service running");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
//			System.out.println("binding error");
			e.printStackTrace();
		}
}

	@Override
	public String executeJob() throws RemoteException {
		// TODO Auto-generated method stub
		return "";
	}
}
