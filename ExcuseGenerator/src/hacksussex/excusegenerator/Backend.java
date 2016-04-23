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
	private HashMap<String, Integer> wordFrequencyRankings;
	
	public Backend(){
		String wordRankings = "WordRankings.csv";
		randomExcuses = new String[]{"I would but, my cat ate my list of excuses, choked, and died.",
				"As much as I love to, the reason I can't do that isn't you - it's me.",
				"It'd be great to do that - but I'm reading this really interesting blog post about how I keep making excuses for everything."};
		wordFrequencyRankings = new HashMap<String, Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(wordRankings));
			String line;
			while((line = reader.readLine()) != null){
				String[] values = line.split(",");
				wordFrequencyRankings.put(values[0], Integer.parseInt(values[1]));
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The word rankings file could not be found.");
		} catch (IOException e) {
			System.out.println("Wel, something went wrong with reading the file...");
		} catch (NumberFormatException e) {
			System.out.println("Euurghh!  Did you break the word ranking file?");
		}
		
		randomExcuses = new String[]{"I would but, my cat ate my list of excuses, choked, and died.",
				"As much as I love to, the reason I can't do that isn't you - it's me.",
				"It'd be great to do that - but I'm reading this really interesting blog post about how I keep making excuses for everything."};
		for(int i = 0; i < 10; i++){
			System.out.println(randomExcuse());
		}
	}
	
	
	/**
	 * Generates an excuse
	 * @param problem The user inputted situation for which an excuse is needed
	 * @return An excuse
	 */
	public String getExcuse(String problem){
		String[] words = problem.split(" ");
		//Higher number is less common
		int leastCommonRanking = 0;
		String leastCommonWord = null;
		String response = null;
		
		for(String word : words){
			String formattedWord = formatWord(word);
			Integer ranking = wordFrequencyRankings.get(formattedWord);
			if(ranking != null){
				if(ranking > leastCommonRanking){
					leastCommonRanking = ranking;
					leastCommonWord = formattedWord;
				}
			}
		}
		
		if(leastCommonWord == null){
			response = randomExcuse();
		}
		
		System.out.println("Response " + response);
		
		return response;
	}
	
	/**
	 * Formats the given string so it is suitable to search in the hashmap.
	 * Converts string to lowercase and removes punctuation.
	 * @param word The word/string you wish to format
	 * @return The formatted word/string, suitable for searching the hashmap
	 */
	private String formatWord(String word){
		word = word.replaceAll("[!\"#$%&'()*+,\\-./:;<=>?@[\\\\]^_`{|}~]", "");
		word = word.toLowerCase();
		return word;
	}
		
	private static String randomExcuse(){
		if(randomExcuseCount < randomExcuses.length - 1){
			randomExcuseCount++;
		} else{
			randomExcuseCount = 0;
		}
		return randomExcuses[randomExcuseCount];
	}

}
