package application.utilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


/**
 * @author Yahel
 * Converts strings / chars to bytes and back and forth.
 */
public class Converter {

	/**
	 * Converts a byte to a char.
	 * @param b The byte given
	 * @return The char representation of the byte given.
	 */
	public static char byteToChar(byte b){
		return (char) (b & 0xFF);
	}
	
	/**
	 * Converts a char to a byte.
	 * @param c The char given.
	 * @return The byte representation of the char given.
	 */
	public static byte charToByte(char c){
		return (byte) c;
	}
	
	/**
	 * Turns a string into an ArrayList<Byte>
	 * @param str The string given.
	 * @return The ArrayList<Byte> converted from the string given.
	 */
	public static ArrayList<Byte> stringToByteArray(String str){
		ArrayList<Byte> result = new ArrayList<Byte>(); 
		for(int i = 0; i < str.length(); i++){
			result.add(new Byte(charToByte(str.charAt(i))));
		}
		return result;
	}
	
	/**
	 * Converts a char array to a string.
	 * @param array The char array given.
	 * @return The string representation of the char array.
	 */
	public static String charArrayToString(char[] array){
		String result = "";
		for(char c : array){
			result += c;
		}
		return result;
	}
	
	/**
	 * Converts a resource stream into a temporary file.
	 * @param fileName The stream to convert to a file
	 * @return Returns the temporary file.
	 */
	public static File resourceStreamToFile(String fileName){
		
    	// create temp file and push the resource stream into it
		File yourFile = null;
		try {
			yourFile = File.createTempFile("stream2file", ".tmp");
			InputStream inputStream = Converter.class.getResourceAsStream(fileName);
			OutputStream outputStream = new FileOutputStream(yourFile);
			
			int read = 0;
			byte[] bytes = new byte[1024];
			
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return yourFile;
	}
}
