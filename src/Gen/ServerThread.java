package Gen;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.channels.AlreadyBoundException;


public class ServerThread implements Runnable{
	InputStream is;
	InputStreamReader isr;
//	Object ni;
//	int count;
	String host;
	BufferedReader br;
	Socket s;
	String ip;
	String receiving;
	String result;
	
	public ServerThread(Socket s) throws IOException {

		this.s = s;

//		ip = s.getInetAddress().toString().substring(1);
		ip = s.getInetAddress().getHostName();
		receiving = "";
		result = "";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {

			is = s.getInputStream();

			isr = new InputStreamReader(is);
			
			br = new BufferedReader(isr);
			
			while ((receiving=br.readLine())!= null) {
				
		//		System.out.println("read line "+ receiving);
				result += receiving;
				
			}
			br.close();
			InfoWriting iw = new InfoWriting(ip);
			iw.WritingFile(result);
//			System.out.println("info received "+result);
		}catch (EOFException e) {


		} catch (IOException e) {
			// TODO Auto-generated catch block

		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}

	}
}
