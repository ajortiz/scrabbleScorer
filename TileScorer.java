package scrabble;

import java.util.Set;

public interface TileScorer
{
	//The return value is the domain of this TileScorer instance
	//part of post: !rv.contains(null)
	//part of post: String e in rv ==> e.codePointCount(0, e.length()) == 1
	public Set<String> getTiles();
	//part of pre: getTiles().contains(tile)
	public int getPoints(String tile);
}
