package Gen;

import java.time.Instant;

public class Constants {
	static String adminserver = "115.146.89.52";
//	static String adminserver = "127.0.0.1";
	static int adminserverport = 17538;
//	static String infopath = "/Users/yidwa/Desktop/";

	static String infopath = "/home/ubuntu/infofolder/";
	
	public static String formattime(){
		Instant instant = Instant.now (); // Current date-time in UTC.
		String output = instant.toString ();
		output = instant.toString ().replace ( "T" , " " ).replace( "Z" , "");
		return output;
	}
}
