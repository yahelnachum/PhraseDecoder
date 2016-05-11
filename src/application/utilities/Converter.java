package application.utilities;
import java.util.ArrayList;


public class Converter {

	public static char byteToChar(byte b){
		return (char) (b & 0xFF);
	}
	
	public static byte charToByte(char c){
		return (byte) c;
	}
	
	public static ArrayList<Byte> stringToByteArray(String str){
		ArrayList<Byte> result = new ArrayList<Byte>(); 
		for(int i = 0; i < str.length(); i++){
			result.add(new Byte(charToByte(str.charAt(i))));
		}
		return result;
	}
	
	public static String charArrayToString(char[] array){
		String result = "";
		for(char c : array){
			result += c;
		}
		return result;
	}
}
