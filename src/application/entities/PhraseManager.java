package application.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import application.utilities.Converter;

public class PhraseManager {

	private ArrayList<Phrase> phrases = new ArrayList<Phrase>();
	private static PhraseManager phraseManagerInstance = new PhraseManager();
	private int currentPhraseIndex = 0;
	private Random rnd = new Random();
	
	private ArrayList<CharacterOccurrences> characterOccurrences = new ArrayList<CharacterOccurrences>();
	private final String characters = "abcdefghijklmnopqrstuvwxyz" +
									  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
									  ".,?'!";
	
	private PhraseManager(){
		
		phrases.add(new Phrase("Caroline is the most beautiful person in the world!"));
		phrases.add(new Phrase("Caroline is the smartest person ever!"));
		phrases.add(new Phrase("I love her so much!"));
		phrases.add(new Phrase("She is the most important person in my life."));
		phrases.add(new Phrase("I love cooking with her."));
		phrases.add(new Phrase("Happy 21st birthday sweetie!"));
				
		for(int i = 0; i < characters.length(); i++){
			characterOccurrences.add(new CharacterOccurrences(characters.charAt(i)));
		}
		resetManager();
	}
	
	public static PhraseManager getPhraseManagerInstance(){
		return phraseManagerInstance;
	}
	
	public void resetManager(){
		phrases.get(currentPhraseIndex).resetDecodedPhrase();
		currentPhraseIndex = rnd.nextInt(phrases.size());
	}
	
	public void resetCharacterOccurances(){
		for(CharacterOccurrences co : characterOccurrences){
			co.setOccurrences(0);
		}
	}
	
	public Phrase getCurrentPhrase(){
		return phrases.get(currentPhraseIndex);
	}
	
	public void decodeCurrentPhrase(String fileName){
		
		resetCharacterOccurances();
		
		FileReader fr = new FileReader(fileName);
		fr.readFile();
		fr.numberOfCharacterOccurrences(characterOccurrences);
		
		Collections.sort(characterOccurrences);
		Collections.reverse(characterOccurrences);
		
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
