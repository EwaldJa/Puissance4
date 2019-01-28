package projPuissance4IA;

import java.io.*;

public class ClavierReader {
	private static BufferedReader mybr=new BufferedReader(new InputStreamReader(System.in));


	public static char getChar() {
		return getString().charAt(0);
	}

	
	public static char[] getChars() {
		String s = getString();
		return s.toCharArray();
	}
				

	public static String getString() {
		return getLine();
	}
		

	public static int getInt() {
		try{
			return Integer.parseInt(getLine());
		} catch(NumberFormatException e) { return -1;}
	}
		
	public static void pause() {
		try{
			mybr.read();
		} catch(IOException e) {}
	}

	private static String getLine() {
		String line;
		try{
			line = mybr.readLine();
		} catch(IOException e) { return "";}
		return line;
	}
}
