package hacksussex.excusegenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Generates excuses from a given string
 * @author Adam Woollen
 * @author Jamie Ingram
 *
 */
public class Backend {
	private static String[] randomExcuses;
	private static int randomExcuseCount = 0;
	private HashMap<String,Word> wordInfo;
	
	
	public Backend(){
		wordInfo = new HashMap<String, Word>();
		
		//The file containing words and their frequencies
		String wordRankings = "WordRankings.csv";
		
		try {
			//Read the word frequencies file line by line
			BufferedReader reader = new BufferedReader(new FileReader(wordRankings));
			String line;
			while((line = reader.readLine()) != null){
				//It's a comma separated file, so split by comma to
				//Separate the word and it's frequency rank.
				String[] values = line.split(",");
				//Insert the values into a HashMap to be used later
				Word word = new Word(Integer.parseInt(values[1]), values[2]);
				wordInfo.put(values[0], word);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The word rankings file could not be found.");
		} catch (IOException e) {
			System.out.println("Wel, something went wrong with reading the file...");
		} catch (NumberFormatException e) {
			System.out.println("Euurghh!  Did you break the word ranking file?");
		}
		
		//Initialise the array of random excuses with random excuses
		randomExcuses = new String[]{"I would but, my cat ate my list of excuses, choked, and died.",
				"As much as I love to, the reason I can't do that isn't you - it's me.",
				"It'd be great to do that - but I'm reading this really interesting blog post about how I keep making excuses for everything."};
		
	}
	
	/**
	 * Generates an excuse
	 * @param problem The user inputted situation for which an excuse is needed
	 * @return An excuse
	 */
	public String getExcuse(String problem){
		//Split the given sentence into an array of words
		String[] words = problem.split(" ");
		//Higher number is less common
		int leastCommonRanking = 0;
		String leastCommonWord = null;
		String response = null;
		
		//Loop through all words inputted by user, determining which is least common
		for(String word : words){
			//format the word to be compatible with the HashMap
			String formattedWord = formatWord(word);
			Word rankedWord = wordInfo.get(formattedWord);
			Integer ranking = rankedWord.getFrequency();
			if(ranking != null){
				//If this word is less common than the least common so far
				if(ranking > leastCommonRanking){
					//Set it to be the new least common
					leastCommonRanking = ranking;
					leastCommonWord = formattedWord;
				}
			}
		}
		
		//If none of the user defined words were in the rankings list, use a random excuse
		if(leastCommonWord == null){
			response = randomExcuse();
		}
		
		System.out.println("Response: " + response);
		
		return response;
	}
	
	/**
	 * Formats the given string so it is suitable to search in the hashmap.
	 * Converts string to lower case and removes punctuation.
	 * @param word The word/string you wish to format
	 * @return The formatted word/string, suitable for searching the hashmap
	 */
	private String formatWord(String word){
		//Remove all symbols
		word = word.replaceAll("[!\"#$%&'()*+,\\-./:;<=>?@[\\\\]^_`{|}~]", "");
		word = word.toLowerCase();
		return word;
	}
	
	/**
	 * Generates a random excuse without consideration of an inputted string
	 * @return
	 */
	private static String randomExcuse(){
		String randomExcuse = randomExcuses[randomExcuseCount];
		//Increment the counter to the next value until the maximum is reached, and then reset to 0.
		if(randomExcuseCount < randomExcuses.length - 1){
			randomExcuseCount++;
		} else{
			randomExcuseCount = 0;
		}
		return randomExcuse;
	}

}
