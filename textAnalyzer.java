/**
 * Tiffany Baksh
 *Assignment 2
 *Software Development I
 */
 
package textAnalyzer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/** Analyzes text from an HTML file and returns the results. */
public class textAnalyzer {

public static void main(String[] args) throws IOException {
	
		
		//URL of document
		URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
		String wordHold = null;
		int wordCount = 1;
		
		HashMap <String, Integer> wordList = new HashMap <String, Integer>();		
		Scanner sc = new Scanner(url.openStream());
				
		//Get an iterator scanner and remove unneeded characters
		while (sc.hasNext()) {
			wordCount = 1;
			wordHold = sc.next().replaceAll("[0-10, , ,\\s+ ,<$>, /*, . , =, ;, :, !, ', a]", "");
			
			
			if (wordList.isEmpty()) {
				wordList.put(wordHold, wordCount);
			} else {
				if (wordList.containsKey(wordHold)) {
					wordCount = wordList.get(wordHold);
					wordCount++;
					wordList.put(wordHold, wordCount);
				} else {
					wordList.put(wordHold, wordCount);
				}
			}
			
			
		}
		
		//Call method to sort HashMap	
		Map<String, Integer> wordSorted = sortByValue(wordList);
		wordSorted.remove("");
		
		int counter = 0;
		
		//Map with the sorted words
		System.out.println("WORD ANALYZER: Top 20 words - The Raven: ");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Map.Entry<String, Integer> me : wordSorted.entrySet()) {
			if(counter < 20) {
				System.out.println("Word: " + me.getKey() + " --> Frequency of Word: " + me.getValue());
				counter++;
				}
			
			}
		
		}

	public static HashMap<String, Integer> sortByValue (HashMap<String, Integer> wordList){
		
		//This list is for the new data
		List<Map.Entry<String, Integer> > List = new LinkedList<Map.Entry<String, Integer>>(wordList.entrySet());
		
		
		//Organize Data
		Collections.sort(List, new Comparator<Map.Entry<String, Integer>> (){
			public int compare (Map.Entry<String, Integer> obj1,
					Map.Entry<String, Integer> obj2)
			{
				return(obj2.getValue()).compareTo(obj1.getValue());
			}
			
		});
		
		//Create new HashMap to hold sorted data
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> me: List) {
			temp.put(me.getKey(),me.getValue());
		}
		
		//Return map
		return temp;
		
	}

}