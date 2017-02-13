package scrabble;
/* AMANDA ORTIZ - CHALLENGE 4 - SCRABBLE ELITE
 * Kart - Component Based Programming
 * Fall 2016 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static scrabble.ScrabbleEliteTileConstants.*;

public class ScrabbleEliteConfiguration_Ortiz
{
	private ScrabbleEliteConfiguration_Ortiz()
	{
		throw new RuntimeException("DO NOT INSTANTIATE!");
	}
	
	public final static String[] ELITE_TILES = new String[]{FOUR, B, C, D, THREE, F, SIX, H, I, J, K, ONE, M, N, ZERO, P, Q, R, FIVE, SEVEN, U, V, W, X, Y, TWO, DOT, PARENTHESIZED_D, V_DOT, PHI};
	
	public static Set<String> getEliteTileSet()
	{
		Set<String> classicTileSet = new HashSet<String>(Arrays.asList(ELITE_TILES));
		return classicTileSet;
	}
	
	private static Map<String, Integer> eliteTileToPointsMap = new HashMap<String, Integer>();
	static
	{
		eliteTileToPointsMap.put(FOUR, 1);
		eliteTileToPointsMap.put(B, 3);
		eliteTileToPointsMap.put(C, 3);
		eliteTileToPointsMap.put(D, 2);
		eliteTileToPointsMap.put(THREE, 1);
		eliteTileToPointsMap.put(F, 4);
		eliteTileToPointsMap.put(SIX, 2);
		eliteTileToPointsMap.put(H, 4);
		eliteTileToPointsMap.put(I, 1);
		eliteTileToPointsMap.put(J, 8);
		eliteTileToPointsMap.put(K, 5);
		eliteTileToPointsMap.put(ONE, 1);
		eliteTileToPointsMap.put(M, 3);
		eliteTileToPointsMap.put(N, 1);
		eliteTileToPointsMap.put(ZERO, 1);
		eliteTileToPointsMap.put(P, 3);
		eliteTileToPointsMap.put(Q, 10);
		eliteTileToPointsMap.put(R, 1);
		eliteTileToPointsMap.put(FIVE, 1);
		eliteTileToPointsMap.put(SEVEN, 1);
		eliteTileToPointsMap.put(U, 1);
		eliteTileToPointsMap.put(V, 4);
		eliteTileToPointsMap.put(W, 4);
		eliteTileToPointsMap.put(X, 8);
		eliteTileToPointsMap.put(Y, 4);
		eliteTileToPointsMap.put(TWO, 10);
		eliteTileToPointsMap.put(DOT, 0);
		eliteTileToPointsMap.put(PARENTHESIZED_D, 0);
		eliteTileToPointsMap.put(V_DOT, 0);
		eliteTileToPointsMap.put(PHI, 2);
		
	}
	
	public static Map<String, Integer> getEliteTileToPointsMap()
	{
		return eliteTileToPointsMap;
	}
	
	private static Map<String, Set<String>> eliteTileToTranslationSetMap = new HashMap<String, Set<String>>();
	static
	{
		
		eliteTileToTranslationSetMap.put(FOUR, new HashSet<String>(Arrays.asList("a")));
		eliteTileToTranslationSetMap.put(B, new HashSet<String>(Arrays.asList("b")));
		eliteTileToTranslationSetMap .put(C, new HashSet<String>(Arrays.asList("c")));
		eliteTileToTranslationSetMap .put(D, new HashSet<String>(Arrays.asList("d")));
		eliteTileToTranslationSetMap .put(THREE, new HashSet<String>(Arrays.asList("e")));
		eliteTileToTranslationSetMap .put(F, new HashSet<String>(Arrays.asList("f")));
		eliteTileToTranslationSetMap .put(SIX, new HashSet<String>(Arrays.asList("g")));
		eliteTileToTranslationSetMap .put(H, new HashSet<String>(Arrays.asList("h")));
		eliteTileToTranslationSetMap .put(I, new HashSet<String>(Arrays.asList("i")));
		eliteTileToTranslationSetMap .put(J, new HashSet<String>(Arrays.asList("j")));
		eliteTileToTranslationSetMap .put(K, new HashSet<String>(Arrays.asList("k")));
		eliteTileToTranslationSetMap .put(ONE, new HashSet<String>(Arrays.asList("l")));
		eliteTileToTranslationSetMap .put(M, new HashSet<String>(Arrays.asList("m")));
		eliteTileToTranslationSetMap .put(N, new HashSet<String>(Arrays.asList("n")));
		eliteTileToTranslationSetMap .put(ZERO, new HashSet<String>(Arrays.asList("o")));
		eliteTileToTranslationSetMap .put(P, new HashSet<String>(Arrays.asList("p")));
		eliteTileToTranslationSetMap .put(Q, new HashSet<String>(Arrays.asList("q")));
		eliteTileToTranslationSetMap .put(R, new HashSet<String>(Arrays.asList("r")));
		eliteTileToTranslationSetMap .put(FIVE, new HashSet<String>(Arrays.asList("s")));
		eliteTileToTranslationSetMap .put(SEVEN, new HashSet<String>(Arrays.asList("t")));
		eliteTileToTranslationSetMap .put(U, new HashSet<String>(Arrays.asList("u")));
		eliteTileToTranslationSetMap .put(V, new HashSet<String>(Arrays.asList("v")));
		eliteTileToTranslationSetMap .put(W, new HashSet<String>(Arrays.asList("w")));
		eliteTileToTranslationSetMap .put(X, new HashSet<String>(Arrays.asList("x")));
		eliteTileToTranslationSetMap .put(Y, new HashSet<String>(Arrays.asList("y")));
		eliteTileToTranslationSetMap .put(TWO, new HashSet<String>(Arrays.asList("z")));
		eliteTileToTranslationSetMap .put(DOT, new HashSet<String>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")));
		eliteTileToTranslationSetMap .put(PARENTHESIZED_D, new HashSet<String>(Arrays.asList("a","e","g","l","o","s","t","z")));
		eliteTileToTranslationSetMap .put(V_DOT, new HashSet<String>(Arrays.asList("a","e","i","o","u")));
		eliteTileToTranslationSetMap .put(PHI, new HashSet<String>(Arrays.asList("p","f")));
	}
	
	public static Map<String, Set<String>> getEliteTileToTranslationSetMap()
	{
		return eliteTileToTranslationSetMap;
	}
	
	private static List<String> readFile(File filename)
	{
		try
		{
			List<String> wordList = new ArrayList<String>();

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("resources/" + filename.getName());
			assert input != null : "input is null! : Check that the resources folder is on the classpath, the file name is correct, and the file is in the resources folder";
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
			String str;
			do
			{
				str = bufferedReader.readLine();
				if(str != null)
				{
					wordList.add(str);
				}
			}while(str != null);
			return wordList;
		}catch(IOException ioException)
		{
			throw new RuntimeException(ioException.getMessage());
		}
	}
	
	public static List<String> getEliteWordList()
	{
		List<String> wordList = readFile(new File("words.txt"));
		
		final int EXPECTED_SIZE = 113809;
		assert wordList.get(0).equals("aa");
		assert wordList.size() == EXPECTED_SIZE : "wordList.size() = " + wordList.size() + " <> " + EXPECTED_SIZE + " = expected size!";
		assert wordList.get(EXPECTED_SIZE - 1).equals("zymurgy");
		
		return wordList;
	}
}