package application.entities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * @author Yahel
 * FileReader takes in a file name and reads it byte per byte.
 */
public class FileReader {

	private File file;
	private byte[] bFile;
	
	/**
	 * Construct a FileReader with the file name given.
	 * @param fileName A string representation of the file name.
	 */
	public FileReader(String fileName){
		file = new File(fileName);
		bFile = new byte[(int) file.length()];
	}
	
	/**
	 * Read the entire file.
	 */
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
	
	/**
	 * Get the number of occurrences of each character.
	 * @param characterOccurrencesList The list of characters to look for.
	 */
	public void numberOfCharacterOccurrences(ArrayList<CharacterOccurrences> characterOccurrencesList){
		for(int i = 0; i < bFile.length; i++){
			for(int j = 0; j < characterOccurrencesList.size(); j++){
				if(bFile[i] == characterOccurrencesList.get(j).getByteVersion()){
					characterOccurrencesList.get(j).incrementOccurrences();
					j = characterOccurrencesList.size();
				}
			}
		}
	}
	
	/**
	 * @return The byte array of the entire file.
	 */
	public byte[] getByteArray(){
		return bFile;
	}
	
	/*
	 * Discarded functions because they did not offer enough interesting behaviors.
	 * 
 	public ArrayList<Byte> bytesArePresent(ArrayList<Byte> b){
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
}
