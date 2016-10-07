package Gen;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.SynchronousQueue;


public class AdminServer {
	ServerSocket ss;
	Socket s;

	public AdminServer() {
		try {
				ss = new ServerSocket(Constants.adminserverport);
		//		System.out.println("start listening");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}
	
	
	public static void main(String[] args) {
		AdminServer as = new AdminServer();
		
		while (true) {
			try {
				as.s = as.ss.accept();
				System.out.println("receiveing from "+as.s.getInetAddress().getHostName());
				new Thread(new ServerThread(as.s)).start();

			} catch (BindException e) {

			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
		}

	}
}
