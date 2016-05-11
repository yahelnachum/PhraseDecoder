package application.entities;
import java.util.Arrays;


public class Phrase {

	private char[] phrase;
	private char[] decodedPhrase;
	
	public Phrase(String phrase){
		this.phrase = phrase.toCharArray();
		this.decodedPhrase = new char[phrase.length()];
		Arrays.fill(decodedPhrase, ' ');
	}
	
	public void decode(char character){
		for(int i = 0; i < phrase.length; i++){
			if(phrase[i] == character){
				decodedPhrase[i] = phrase[i];
			}
		}
	}
	
	public void decode(char[] characters){
		for(char character : characters){
			decode(character);
		}
	}
	
	public char[] getPhrase(){
		return phrase;
	}
	
	public char[] getDecodedPhrase(){
		return decodedPhrase;
	}
	
	public void resetDecodedPhrase(){
		Arrays.fill(decodedPhrase, ' ');
	}
	
	public boolean isCharacterInPhrase(char character){
		for(char c : phrase){
			if(c == character){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isCharacterDecoded(char character){
		for(char c : decodedPhrase){
			if(c == character){
				return true;
			}
		}
		return false;
	}
	
	public boolean phraseFullyDecoded(){
		for(int i = 0; i < phrase.length; i++){
			if(phrase[i] != decodedPhrase[i]){
				return false;
			}
		}
		return true;
	}
}
