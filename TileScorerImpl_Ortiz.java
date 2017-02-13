package scrabble;
/* AMANDA ORTIZ - CHALLENGE 4 - SCRABBLE ELITE
 * Kart - Component Based Programming
 * Fall 2016 
 */
import java.util.Map;
import java.util.Set;

public class TileScorerImpl_Ortiz implements TileScorer
{
	private Map<String, Integer> tileToPointsMap;


	public TileScorerImpl_Ortiz(Map<String, Integer> tileToPointsMap)
	{
		this.tileToPointsMap = tileToPointsMap;
	}

	@Override
	//The return value is the domain of this TileScorer instance
	//part of post: !rv.contains(null)
	//part of post: String e in rv ==> e.codePointCount(0, e.length()) == 1
	public Set<String> getTiles()
	{
		return tileToPointsMap.keySet();
	}

	@Override
	//part of pre: getTiles().contains(tile)
	public int getPoints(String tile)
	{
		assert tile != null : "tile is null!";
		assert tile.codePointCount(0, tile.length()) == 1 : "tile.codePointCount(0, tile.length()) = " + tile.codePointCount(0, tile.length()) + " <> 1!";
		assert getTiles().contains(tile) : "tile = " + tile + " is not a tile! getTiles() = " + getTiles();

		int tilePoints = 0;

		if(tileToPointsMap.containsKey(tile))
		{
			tilePoints = tileToPointsMap.get(tile);
		}

		return tilePoints;
	}
}
