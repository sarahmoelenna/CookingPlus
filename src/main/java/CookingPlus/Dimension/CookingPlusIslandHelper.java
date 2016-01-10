package CookingPlus.Dimension;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.Item;

public class CookingPlusIslandHelper {

	private static final ArrayList<CookingPlusIslandObject> IslandList = new ArrayList<CookingPlusIslandObject>();
	
	public static void PregenerateIslands(){
		for(int i = 0; i < 15; i++){
			IslandList.add(new CookingPlusIslandObject());
		}
	}
	
	public static CookingPlusIslandObject GetRandomIsland(){
		Random myRand = new Random();
		return IslandList.get(myRand.nextInt(15));
	}
}
