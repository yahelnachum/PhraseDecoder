import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class FileReader {

	private File file;
	private byte[] bFile;
	
	public FileReader(String fileName){
		file = new File(fileName);
		bFile = new byte[(int) file.length()];
	}
	
	public void readFile(){
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(bFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	public ArrayList<Byte> bytesArePresent(ArrayList<Byte> b){
		return bytesArePresent(b, 0, bFile.length);
	}
	
	public ArrayList<Byte> bytesArePresent(ArrayList<Byte> b, int numOfBytesToRead){
		if(numOfBytesToRead > bFile.length){
			numOfBytesToRead = bFile.length;
		}
		
		Random rnd = new Random();
		int randomStartIndex = rnd.nextInt(bFile.length - numOfBytesToRead);
		return bytesArePresent(b, randomStartIndex, randomStartIndex+numOfBytesToRead);
	}
	
	public ArrayList<Byte> bytesArePresent(ArrayList<Byte> b, int startIndex, int endIndex){
		ArrayList<Byte> result = new ArrayList<Byte>();
		for(int i = startIndex; i < endIndex; i++){
			for(int j = 0; j < b.size(); j++){
				if(bFile[i] == b.get(j)){
					result.add(b.get(j));
					b.remove(j);
					j = b.size();
				}
			}
		}
		
		return result;
	}
	
	public boolean bytesArePresentNextToEachOther(ArrayList<Byte> b){
		return bytesArePresentNextToEachOther(b, 0, bFile.length);
	}
	
	public boolean bytesArePresentNextToEachOther(ArrayList<Byte> b, int numOfBytesToRead){
		if(numOfBytesToRead > bFile.length){
			numOfBytesToRead = bFile.length;
		}
		
		Random rnd = new Random();
		int randomStartIndex = rnd.nextInt(bFile.length - numOfBytesToRead);
		return bytesArePresentNextToEachOther(b, randomStartIndex, randomStartIndex+numOfBytesToRead);
	}
	
	public boolean bytesArePresentNextToEachOther(ArrayList<Byte> b, int startIndex, int endIndex){
		for(int i = startIndex; i < endIndex; i++){
			int index = i;
			for(int j = 0; j < b.size(); j++){
				if(bFile[index] != b.get(j)){
					j = b.size();
				}
				else if(j == b.size() - 1){
					return true;
				}
				else {
					index++;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Byte> bytesArePresentInOrder(ArrayList<Byte> b){
		ArrayList<Byte> results = new ArrayList<Byte>();
		for(int i = 0; i < bFile.length; i++){
			if(b.size() == results.size()){
				return results;
			}
			else if(bFile[i] == b.get(results.size())){
				results.add(b.get(results.size()));
			}
		}
		return results;
	}*/
	
	public ArrayList<Integer> byteNumberOfOccurances(ArrayList<Byte> b){
		ArrayList<Integer> results = new ArrayList<Integer>();
		for(int i = 0; i < b.size(); i++){
			results.add(0);
		}
		for(int i = 0; i < bFile.length; i++){
			for(int j = 0; j < b.size(); j++){
				if(bFile[i] == b.get(j)){
					results.set(j, results.get(j)+1);
					j = b.size();
				}
			}
		}
		return results;
	}
	
	public byte[] getByteArray(){
		return bFile;
	}
}
