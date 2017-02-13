package scrabble;

import java.util.Set;

public interface ScrabbleWordScorer
{
	//part of post: !rv.contains(null)
	//part of post: String e in rv ==> e.codePointCount(0, e.length()) == 1
	public Set<String> getTiles();
	public boolean dictionaryContains(String string);
	
	//pre: student needs to figure out my precondition
	//post: student needs to figure out my postcondition
	public boolean isLegalTransformation(String tileSequence, String string);
	
	//part of pre: tileSequence != null
	//part of pre: tileSequence.codePointCount(0, tileSequence.length()) == tilePointsMultipliers.length()
	//NOTICE: the ith codePoint of tileSequence can be written as: tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, i)) 
	//part of post: rv == tilePointsMultipliers[0]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, 0)) +
	//					  tilePointsMultipliers[1]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, 1)) +
	//					  tilePointsMultipliers[2]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, 2)) +
	//						...
	//					  tilePointsMultipliers[tilePointsMultipliers.length() - 1]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, tilePointsMultipliers.length() - 1))
	public int getScore(String tileSequence, int[] tilePointsMultipliers);
	
	//part of pre: getTiles().contains(tile)
	public int getPoints(String tile);
}
