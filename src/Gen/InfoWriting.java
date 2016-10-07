package Gen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class InfoWriting {
	String info;
    File file;
	FileOutputStream fos;	
	OutputStreamWriter osw;
	
	public InfoWriting(String host){
		this.file = new File(Constants.infopath+host+"_info.txt");
	}
	
	public void WritingFile(String info){
	
		try {
			fos = new FileOutputStream(file, true);
			osw = new OutputStreamWriter(fos);
	//		String time = Constants.formattime();
			System.out.println("write to file ");
			osw.write(info+"\n");
			System.out.println(info);
			osw.flush();
			osw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
