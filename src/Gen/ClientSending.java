package Gen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class ClientSending {
	Socket s;
	static OutputStream os;
	static OutputStreamWriter osw;
	static BufferedWriter bw;
	String info;
	
	public ClientSending(String des) throws UnknownHostException, IOException, InterruptedException{
		try {
	//	System.out.println("info is "+ info);
			this.s = new Socket(des, Constants.adminserverport);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("server is not repsonding, please try again later");
			TimeUnit.MILLISECONDS.sleep(5000);
			this.s = new Socket(des, Constants.adminserverport);
			System.out.println("reconnect with server");
		}
	}
	public static void infoSending(Socket s, String info){
			try {
				os = s.getOutputStream();
				osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				bw.write(info);
				//System.out.println("writing finish");
				bw.flush();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
			
		
		
	}
	
	

