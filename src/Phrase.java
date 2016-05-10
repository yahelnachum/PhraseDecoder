import java.util.Arrays;


public class Phrase {

	private char[] phrase;
	private char[] decodedPhrase;
	
	public Phrase(String phrase){
		this.phrase = phrase.toCharArray();
		this.decodedPhrase = new char[phrase.length()];
		Arrays.fill(decodedPhrase, ' ');
	}
	
	public void decode(char[] characters){
		for(int i = 0; i < phrase.length; i++){
			for(int j = 0; j < characters.length; j++){
				if(phrase[i] == characters[j]){
					decodedPhrase[i] = phrase[i];
					j = characters.length;
				}
			}
		}
	}
	
	public char[] getPhrase(){
		return phrase;
	}
	
	public char[] getDecodedPhrase(){
		return decodedPhrase;
	}
}
