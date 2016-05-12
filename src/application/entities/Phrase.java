package application.entities;
import java.util.Arrays;


/**
 * @author Yahel
 * A phrase that starts encoded and gets decoded.
 */
public class Phrase {

	private char[] phrase;
	private char[] decodedPhrase;
	
	/**
	 * Construct a new phrase with the given string.
	 * @param phrase The phrase as a string.
	 */
	public Phrase(String phrase){
		this.phrase = phrase.toCharArray();
		this.decodedPhrase = new char[phrase.length()];
		Arrays.fill(decodedPhrase, ' ');
	}
	
	/**
	 * Decode the phrase given the character given.
	 * @param character The character that is to be decoded.
	 */
	public void decode(char character){
		for(int i = 0; i < phrase.length; i++){
			if(phrase[i] == character){
				decodedPhrase[i] = phrase[i];
			}
		}
	}
	
	/**
	 * Decode a list of characters.
	 * @param characters The characters that are to be decoded.
	 */
	public void decode(char[] characters){
		for(char character : characters){
			decode(character);
		}
	}
	
	/**
	 * @return The char array version of the full phrase.
	 */
	public char[] getPhrase(){
		return phrase;
	}
	
	/**
	 * @return The char array version of the currently decoded phrase.
	 */
	public char[] getDecodedPhrase(){
		return decodedPhrase;
	}
	
	/**
	 * Reset the decoded phrase to empty char array.
	 */
	public void resetDecodedPhrase(){
		Arrays.fill(decodedPhrase, ' ');
	}
	
	/**
	 * Checks if the character is in the phrase at all.
	 * @param character The character to search for in the phrase.
	 * @return Returns true if the character is found in the phrase, false otherwise.
	 */
	public boolean isCharacterInPhrase(char character){
		for(char c : phrase){
			if(c == character){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the character has already been decoded in from the phrase.
	 * @param character The character to search for.
	 * @return Returns true if the character has been decoded in the phrase, false otherwise.
	 */
	public boolean isCharacterDecoded(char character){
		for(char c : decodedPhrase){
			if(c == character){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks to see if the phrase has been fully decoded.
	 * @return Returns true if it has been fully decoded, false otherwise.
	 */
	public boolean phraseFullyDecoded(){
		for(int i = 0; i < phrase.length; i++){
			if(phrase[i] != decodedPhrase[i]){
				return false;
			}
		}
		return true;
	}
}
