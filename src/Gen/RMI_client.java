package Gen;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class RMI_client implements Runnable {
	
	public ArrayList<String> supers;

	public RMI_client() {
		// TODO Auto-generated constructor stub
		this.supers = new ArrayList<String>();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String name = "sysinfo";
			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1699);
			Job job = (Job) reg.lookup(name);
			CollectinSV cs = new CollectinSV();
			String result = cs.executeJob();
			System.out.println("getting result "+ result);
//			System.out.println("job done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
