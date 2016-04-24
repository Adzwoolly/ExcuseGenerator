package hacksussex.excusegenerator;

import java.util.Comparator;

/** Class for containing information about each word.
 * 
 * @author JRIngram
 * @version 24/04/2016
 */
public class Word implements Comparator<Word>, Comparable<Word>{
	private String excuse;
	private int frequency;
	
	/** Constructs the Word object
	 * 
	 * @param frequency The frequency ranking of the word - the higher the number the rarer the word.
	 * @param excuse The excuse associated with said word.
	 */

	public Word(int frequency, String excuse) {
		this.excuse = excuse;
		this.frequency = frequency;
	}
	
	/** Returns the frequency of the item.
	 * 
	 * @return The frequency rating of the item - the higher the number the rarer the word.
	 */
	
	public int getFrequency(){
		return frequency;
	}
	
	/** Returns the excuse for the word object.
	 * 
	 * @return The excuse for the given word.
	 */
	public String getExcuse(){
		return excuse;
	}
	
	public int compare(Word w1, Word w2){
		return w1.getFrequency() - w2.getFrequency();
	}

	@Override
	public int compareTo(Word w) {
		return frequency - w.getFrequency();
	}

}
