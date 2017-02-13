package scrabble;
/* AMANDA ORTIZ - CHALLENGE 4 - SCRABBLE ELITE
 * Kart - Component Based Programming
 * Fall 2016 
 */
import static scrabbleInClass.ScrabbleConstants.A;

import java.util.Set;

public class ScrabbleWordScorerImpl_Ortiz implements ScrabbleWordScorer
{
	private TileScorer tileScorer;
	private TileTranslator tileTranslator;
	private Dictionary dictionary;

	public ScrabbleWordScorerImpl_Ortiz(TileScorer tilePoints, TileTranslator tileTranslator, Dictionary dictionary)
	{
		assert tilePoints != null : "tilePoints is null!";
		assert tileTranslator != null : "tileTranslator is null!";
		assert dictionary != null : "dictionary is null!";
		assert tilePoints.getTiles().equals(tileTranslator.getTileSet()) : "tilePoints and tileTranslator tile sets must equal!";

		this.tileScorer = tilePoints;
		this.tileTranslator = tileTranslator;
		this.dictionary = dictionary;
	}

	@Override
	//part of post: !rv.contains(null)
	//part of post: String e in rv ==> e.codePointCount(0, e.length()) == 1
	public Set<String> getTiles()
	{
		assert !tileScorer.getTiles().contains(null);
		return tileScorer.getTiles();
	}

	@Override
	public boolean dictionaryContains(String string)
	{
		//checks if dictionary contains string
		return dictionary.contains(string);
	}

	@Override
	//pre: tileSequence != null
	//pre: target != null
	//post: rv == true OR false
	//post: indexOfTileSequence >= 0
	//post: codePointCharAsTranslatedTileSet != null
	public boolean isLegalTransformation(String tileSequence, String target)
	{
		assert tileSequence != null : "tileSequence is null!";
		assert target != null : "target is null!";

		final int TILE_COUNT = tileSequence.codePointCount(0, tileSequence.length());
		final int TARGET_CODEPOINT_COUNT = target.codePointCount(0, target.length());

		boolean isLegalTransformation = true;

		int tileSequenceCodePointCount = getCodePointCount(tileSequence);
		int codePoint = 0;
		int indexOfTileSequence = 0;

		String codePointCharAsString = "";
		String singleCharFromTargetString;
		Set<String> codePointCharAsTranslatedTileSet;

		if(TILE_COUNT != TARGET_CODEPOINT_COUNT)
		{
			isLegalTransformation = false;
		}
		else
		{
			/*pull first tile, get in string form
			 * get first codepoint, convert to string
			 * use translated string and check to see if it's in the set
			 * how to get hands on the translation set:
			 * etttsm.get(FOUR) -> {"a'"}
			 * ask {"a} set if it .contains ("w") 
			 * 
			 * * while-loop checks each tile in tileSequence to make sure each tileSequence translation == each 
			 * char in target.
			 * ex: ⒷⒾⓇⒹ.isLegalTranslation("bird") => true
			 */
			int indexOfCodepoint = 0;
			while (indexOfCodepoint < tileSequenceCodePointCount && isLegalTransformation)
			{
				assert indexOfTileSequence < tileSequence.length() : indexOfTileSequence + " " + tileSequence.length();
				/* lines 93 - 95:
				 * converting tile to 'letter' 
				 * ex:codePointCharAsString = Ⓑ -----> codePointCharAsTranslatedTileSet {"b"}
				 */
				codePoint = getCodePoint(tileSequence,indexOfTileSequence);
				codePointCharAsString = getStringWithSingleCodePoint(codePoint);
				codePointCharAsTranslatedTileSet = translateCodePointCharAsString(codePointCharAsString); 
			
				singleCharFromTargetString = getCharFromStringAtIndex(target,indexOfCodepoint); 

				assert codePointCharAsTranslatedTileSet != null : "codePointChar = " + codePointCharAsString + " - codePoint INT: " + codePoint + "i = " + indexOfCodepoint;
				
				//checking to see if codePointCharAsTranslatedTileSet - {"b"}, contains single char from target string - "b"
				if(!codePointCharAsTranslatedTileSet.contains(singleCharFromTargetString) && !singleCharFromTargetString.equals("") )
				{
					isLegalTransformation = false;
				}

				final int MOVE_OVER_ONE = 1;
				indexOfTileSequence = tileSequence.offsetByCodePoints(indexOfTileSequence, MOVE_OVER_ONE); //the char index that corresponds to codePoint #indexCodePoint
				assert indexOfTileSequence >= 0;
				indexOfCodepoint++;
			}
		}
		return isLegalTransformation;
	}

	@Override
	//part of pre: tileSequence != null
	//part of pre: tileSequence.codePointCount(0, tileSequence.length()) == tilePointsMultipliers.length()
	//NOTICE: the ith codePoint of tileSequence can be written as: tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, i)) 
	//part of post: rv == tilePointsMultipliers[0]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, 0)) +
	//					  tilePointsMultipliers[1]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, 1)) +
	//					  tilePointsMultipliers[2]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, 2)) +
	//						...
	//					  tilePointsMultipliers[tilePointsMultipliers.length() - 1]*tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, tilePointsMultipliers.length() - 1))
	/* Ex: tilePointsMultipliers[0] = 1
	 * 	tileSequence.codePointAt(tileSequence.offsetByCodePoints(0, 0)) = *codepoint number*
	 * 	after conversion, value of translated codepoint to char:
	 * 		1 * value of translated codepoint to char = score
	 */
	public int getScore(String tileSequence, int[] tilePointsMultipliers)
	{
		assert tileSequence != null : "tileSequence is null!";
		final int CODE_POINT_COUNT = tileSequence.codePointCount(0, tileSequence.length());
		assert CODE_POINT_COUNT == tilePointsMultipliers.length : "CODE_POINT_COUNT = " + CODE_POINT_COUNT + " <> " + tilePointsMultipliers.length + " = tilePointsMultipliers.length! : tileSequence = " + tileSequence;


		int score = 0; 
		int codePointCount = getCodePointCount(tileSequence);
		int codePoint = 0;
		String codePointChar = "";
		int indexChar = 0;
		for(int i = 0; i < codePointCount; i++)
		{
			codePoint = tileSequence.codePointAt(indexChar);
			codePointChar = new String(Character.toChars(codePoint));
			//score  =  point value of char * quantity of tiles 
			// ex: getPoints('a') => 1
			//	   tilePointsMultipliers[i] => 2
			//		score = 1 * 2 => 2
			final int MOVE_OVER_ONE = 1;
			indexChar = tileSequence.offsetByCodePoints(indexChar, MOVE_OVER_ONE);
			score = score + (getPoints(codePointChar) * tilePointsMultipliers[i]);
		}
		return score;
	}

	@Override
	//part of pre: getTiles().contains(tile)
	// ex: tileScorer.getPoints('a') => 1
	public int getPoints(String tile)
	{
		assert getTiles().contains(tile);
		assert tile != null : "tile is null";
		assert tile.codePointCount(0, tile.length()) == 1 : "String tile doesn't have exactly one code point! : tile.codePointCount(0, tile.length()) = " + tile.codePointCount(0, tile.length());

		return tileScorer.getPoints(tile);
	}
	
//-------------- HELPER METHODS ------------------
	
	private static String getCharFromStringAtIndex(String target, int indexOfCodePoint)
	{
		return "" + target.charAt(indexOfCodePoint);
	}

	private static String getStringWithSingleCodePoint(int codePoint)
	{
		final int MINIMUM_CODEPOINT = 0x10FFFF;
		assert codePoint >= 0 : "codePoint = " + codePoint + " < " + MINIMUM_CODEPOINT + " = MINIMUM_CODEPOINT!";

		final int MAXIMUM_CODEPOINT = 0x10FFFF;
		assert codePoint <= 0x10FFFF : "codePoint = " + codePoint + " > " + MAXIMUM_CODEPOINT + " = MAXIMUM_CODEPOINT!";

		return  new String(Character.toChars(codePoint));
		
	}

	private static int getCodePointCount (String tileSequence)
	{
		return tileSequence.codePointCount(0, tileSequence.length());
	}

	private static int getCodePoint (String tileSequence, int charIndexOfTileSequence) 
	{
		return tileSequence.codePointAt(charIndexOfTileSequence);
	}
	
	private Set<String> translateCodePointCharAsString(String codePointChar) 
	{
		return tileTranslator.getTranslationSet(codePointChar);
	}

} // end main



