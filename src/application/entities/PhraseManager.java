package application.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import application.utilities.Converter;

/**
 * @author Yahel
 * Manages the phrases used in the application.
 */
public class PhraseManager {

	private ArrayList<Phrase> phrases = new ArrayList<Phrase>();
	private static PhraseManager phraseManagerInstance = new PhraseManager();
	private int currentPhraseIndex = 0;
	private Random rnd = new Random();
	
	private ArrayList<CharacterOccurrences> characterOccurrences = new ArrayList<CharacterOccurrences>();
	private final String characters = "abcdefghijklmnopqrstuvwxyz" +
									  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
									  "0123456789" +
									  ".,?'!";
	
	/**
	 * Constructs all the phrases that will appear.
	 */
	private PhraseManager(){
		
		phrases.add(new Phrase("Caroline is the most beautiful person in the world!"));
		phrases.add(new Phrase("Caroline is the smartest person ever!"));
		phrases.add(new Phrase("I love her so much!"));
		phrases.add(new Phrase("Caroline is the most important person in my life."));
		phrases.add(new Phrase("I love cooking with her."));
		phrases.add(new Phrase("Happy 21st birthday sweetie!"));
		phrases.add(new Phrase("I wish you a very happy birthday!"));
		phrases.add(new Phrase("Caroline is the top chef in the kitchen."));
		phrases.add(new Phrase("Caroline looks good in any outfit she wears."));
		phrases.add(new Phrase("Caroline is my sweet little bumble bee."));
				
		for(int i = 0; i < characters.length(); i++){
			characterOccurrences.add(new CharacterOccurrences(characters.charAt(i)));
		}
		resetManager();
	}
	
	/**
	 * @return Returns an instance of the PhraseManager
	 */
	public static PhraseManager getPhraseManagerInstance(){
		return phraseManagerInstance;
	}
	
	/**
	 * Resets the PhraseManager by picking a new phrase
	 */
	public void resetManager(){
		phrases.get(currentPhraseIndex).resetDecodedPhrase();
		currentPhraseIndex = rnd.nextInt(phrases.size());
	}
	
	/**
	 * Resets the character occurrences to 0
	 */
	private void resetCharacterOccurances(){
		for(CharacterOccurrences co : characterOccurrences){
			co.setOccurrences(0);
		}
	}
	
	/**
	 * @return Returns the current phrase that is being decoded.
	 */
	public Phrase getCurrentPhrase(){
		return phrases.get(currentPhraseIndex);
	}
	
	/**
	 * Decodes the current phrase
	 * @param fileName The name of the file that is used for decoding.
	 */
	public void decodeCurrentPhrase(String fileName){
		
		// reset occurrences to 0
		resetCharacterOccurances();
		
		// read file and get number of each character occurrence
		FileReader fr = new FileReader(fileName);
		fr.readFile();
		fr.numberOfCharacterOccurrences(characterOccurrences);
		
		// sort and reverse to get from most to least occurrences
		Collections.sort(characterOccurrences);
		Collections.reverse(characterOccurrences);
		
		// decode up to 3 of the most occurring characters
		int numberOfCharactersToDecode = rnd.nextInt(3) + 1;
		for(int i = 0; i < characterOccurrences.size(); i++){
			if(getCurrentPhrase().isCharacterInPhrase(characterOccurrences.get(i).getCharacter()) && 
			   !(getCurrentPhrase().isCharacterDecoded(characterOccurrences.get(i).getCharacter()))){
				getCurrentPhrase().decode(characterOccurrences.get(i).getCharacter());
				
				if(numberOfCharactersToDecode == 0){
					i = characterOccurrences.size();
				}
				else{
					numberOfCharactersToDecode--;
				}
			}
		}
	}
}
