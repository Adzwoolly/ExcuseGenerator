package hacksussex.excusegenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Backend {
	
	public static void main(String[] args){
		Backend b = new Backend();
		b.getExcuse("Do you want to go to Hack Sussex?");
	}
	
	HashMap<String, Integer> common = new HashMap<String, Integer>();
	
	public Backend(){
		String wordRankings = "WordRankings.csv";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(wordRankings));
			String line;
			while((line = reader.readLine()) != null){
				String[] values = line.split(",");
				common.put(values[0], Integer.parseInt(values[1]));
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		String leastCommonWord = "[failed]";
		
		for(String word : words){
			String formattedWord = formatWord(word);
			System.out.println(formattedWord);
			
			Integer ranking = common.get(formattedWord);
			if(ranking != null){
				if(ranking > leastCommonRanking){
					leastCommonRanking = ranking;
					leastCommonWord = formattedWord;
				}
			} else{
				System.out.println("Not in top 5000");
			}
		}
		
		System.out.println("Least common word: " + leastCommonWord);
		
		return leastCommonWord;
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

}
