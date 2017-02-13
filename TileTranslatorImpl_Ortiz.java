package scrabble;
/* AMANDA ORTIZ - CHALLENGE 4 - SCRABBLE ELITE
 * Kart - Component Based Programming
 * Fall 2016 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TileTranslatorImpl_Ortiz implements TileTranslator
{
	private Map<String, Set<String>> tileToTranslationSetMap;

	public TileTranslatorImpl_Ortiz(Map<String, Set<String>> tileToTranslationSetMap)
	{
		this.tileToTranslationSetMap = tileToTranslationSetMap;
	}

	@Override
	//The return value is the domain of this TileTranslator instance
	//part of post: !rv.contains(null)
	//part of post: String e in rv ==> e.codePointCount(0, e.length()) == 1
	public Set<String> getTileSet()
	{
		return tileToTranslationSetMap.keySet();	
	}

	@Override
	//part of pre: getTileSet().contains(tile)
	//part of post: !rv.contains(null)
	//part of post: String e in rv ==> e.codePointCount(0, e.length()) == 1
	public Set<String> getTranslationSet(String tile)
	{
		return tileToTranslationSetMap.get(tile);
	}

	@Override
	//part of post: !rv.contains(null)
	//part of post: String e in rv ==> e.codePointCount(0, e.length()) == 1
	public Set<String> getTranslationUniverse()
	{
		Set<String> translationUniverseSet = new HashSet<String>();
		List<String> tileToTranslationSetMapAsList = new ArrayList <String>(tileToTranslationSetMap.keySet()); 
		assert tileToTranslationSetMapAsList.size() == tileToTranslationSetMap.size();
		
		for(int i = 0; i < tileToTranslationSetMapAsList.size(); i++)
		{
			//get tile at i from tileToTranslationSetMap list
			String tile_i = tileToTranslationSetMapAsList.get(i);
			//get the translation of tile at i and put into new set
			Set<String> translates = tileToTranslationSetMap.get(tile_i);
			//add to final set
			translationUniverseSet.addAll(translates);
		}
		return translationUniverseSet;
	}
}