package application.entities;

import application.utilities.Converter;

/**
 * @author Yahel
 * A single object to hold a character, its byte version, and the number of occurrences it had.
 */
public class CharacterOccurrences implements Comparable<CharacterOccurrences>{

	private char character;
	private byte byteVersion;
	private int occurrences = 0;
	
	/**
	 * Create a CharacterOccurrences object for the given character.
	 * @param character The character that the occurrences are related to.
	 */
	public CharacterOccurrences(char character){
		this.character = character;
		byteVersion = Converter.charToByte(character);
	}
	
	/**
	 * Set the number of occurrences of the character.
	 * @param occur The number of occurrences of the character.
	 */
	public void setOccurrences(int occur){
		occurrences = occur;
	}
	
	/**
	 * Increment the occurrences by one.
	 */
	public void incrementOccurrences(){
		occurrences++;
	}
	
	/**
	 * @return Returns the character the object represents.
	 */
	public char getCharacter(){
		return character;
	}
	
	/**
	 * @return Returns the byte version of the character.
	 */
	public byte getByteVersion(){
		return byteVersion;
	}
	
	/**
	 * @return Returns the number of occurrences of the character.
	 */
	public int getOccurrences(){
		return occurrences;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
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
