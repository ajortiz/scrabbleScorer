package scrabble;
/* AMANDA ORTIZ - CHALLENGE 4 - SCRABBLE ELITE
 * Kart - Component Based Programming
 * Fall 2016 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DictionaryImpl_Ortiz implements Dictionary
{
	private List<String> dictionaryList;
	
	//constructs dictionaryList with received wordList
	public DictionaryImpl_Ortiz(List<String> wordList)
	{
		dictionaryList = wordList;
	}
	
	@Override
	public boolean contains(String string) 
	{ 
		//returns boolean -> if dictionaryList contains string
		return dictionaryList.contains(string);	
	}
}
