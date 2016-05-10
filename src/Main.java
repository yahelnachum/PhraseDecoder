import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock c = new Clock();
		
		FileReader fr = new FileReader("DSCF1107.JPG");
		fr.readFile();
		ArrayList<Byte> list = new ArrayList<Byte>();
		for(int i = 0; i < 26; i++){
			list.add(new Byte("" + (i + 97)));
			list.add(new Byte("" + (i + 65)));
		}
		list.add(new Byte("" + (46)));
		list.add(new Byte("" + (44)));
		list.add(new Byte("" + (63)));
		list.add(new Byte("" + (39)));
		list.add(new Byte("" + (33)));
	
		
		System.out.println(Converter.byteToChar((byte)63));
		System.out.println(Converter.charToByte('?'));
		
		ArrayList<Byte> resultList = Converter.stringToByteArray("be");
		System.out.println(resultList.get(0));
		System.out.println(resultList.get(1));
		
		ArrayList<Integer> list01 = fr.byteNumberOfOccurances(Converter.stringToByteArray("abcdefghijklmnopqrstuvwxyz"));
		for(int i = 0; i < list01.size(); i++){
			
			System.out.print(list01.get(i) + " ");
		}
		System.out.println();
		System.out.println("Time: " + c.delta());

        
	}
}
