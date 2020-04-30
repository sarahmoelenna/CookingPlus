package CookingPlus.Dimension;

import java.util.ArrayList;
import java.util.Random;

import CookingPlus.CookingPlusConfig;

public class CookingPlusIslandHelper {

	private static final ArrayList<CookingPlusIslandObject> IslandList = new ArrayList<CookingPlusIslandObject>();
	
	public static void PregenerateIslands(){
		for(int i = 0; i < CookingPlusConfig.PreGeneratedIslandCount; i++){
			IslandList.add(new CookingPlusIslandObject());
		}
	}
	
	public static CookingPlusIslandObject GetRandomIsland(){
		Random myRand = new Random();
		return IslandList.get(myRand.nextInt(CookingPlusConfig.PreGeneratedIslandCount));
	}
}
