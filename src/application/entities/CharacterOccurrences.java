package application.entities;

import application.utilities.Converter;

public class CharacterOccurrences implements Comparable<CharacterOccurrences>{

	private char character;
	private byte byteVersion;
	private int occurrences = 0;
	
	public CharacterOccurrences(char character){
		this.character = character;
		byteVersion = Converter.charToByte(character);
	}
	
	public void setOccurrences(int occur){
		occurrences = occur;
	}
	
	public void incrementOccurrences(){
		occurrences++;
	}
	
	public char getCharacter(){
		return character;
	}
	
	public byte getByteVersion(){
		return byteVersion;
	}
	
	public int getOccurrences(){
		return occurrences;
	}

	@Override
	public int compareTo(CharacterOccurrences o) {
		if(occurrences < o.getOccurrences()){
			return -1;
		}
		else if(o.getOccurrences() < occurrences){
			return 1;
		}
		else{
			return 0;
		}
	}
}
