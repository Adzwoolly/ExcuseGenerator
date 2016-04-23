package hacksussex.excusegenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Backend {
	
	HashMap<String, Integer> common = new HashMap<String, Integer>();
	
	String problem = "";
	
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
		this.problem = problem;
		
		String[] words = problem.split(" ");
		//Higher number is less common
		int leastCommonRanking = 0;
		String leastCommonWord = "";
		
		for(String word : words){
			Integer ranking = common.get(word);
			if(ranking != null){
				if(ranking > leastCommonRanking){
					leastCommonRanking = ranking;
					leastCommonWord = word;
				}
			}
		}
		
		System.out.println("Least common word: " + leastCommonWord);
		
		return null;
	}

}
