package CookingPlus.Dimension;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CookingPlusEdenDimensionWorldGen {
	
	public static void GenerateWorld(int chunkX, int chunkZ, World myWorld, Random myRand){
		
		//if(myRand.nextFloat() < 0.05f){
		//	CookingPlusIslandHelper.GetRandomIsland().TranslateToWorld(myWorld, chunkX * 16, 82, chunkZ * 16);
		//}
		myWorld.markChunkDirty(new BlockPos(chunkX, 0, chunkZ), null);
	}
}
