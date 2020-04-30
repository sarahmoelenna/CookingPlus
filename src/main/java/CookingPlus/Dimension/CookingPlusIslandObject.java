package CookingPlus.Dimension;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CookingPlusIslandObject {

	ArrayList<BlockPos> MyList;
	ArrayList<BlockPos> MyDirtList;
	ArrayList<BlockPos> MyGrassList;
	int OffsetY = 0;
	int OffsetX = 0;
	int OffsetZ = 0;
	int L;
	int H;
	int W;
	
	public CookingPlusIslandObject(){
		MyList = new ArrayList<BlockPos>();
		MyDirtList = new ArrayList<BlockPos>();
		MyGrassList = new ArrayList<BlockPos>();
		CellularAutomationIslands myIsland = new CellularAutomationIslands(null, 96, 50, 96);
		myIsland.BeginGeneration(15, 3);
		int [][][] MyIsland = myIsland.GetIsland();
		L = myIsland.l;
		H = myIsland.h;
		W = myIsland.w;
		
		MyList = myIsland.MyList;
		MyDirtList = myIsland.MyDirtList;
		MyGrassList = myIsland.MyGrassList;
		
	}
	
	
	public void TranslateToWorld(World myWorld, int X, int Y, int Z, Random myRand){
		
		IBlockState topBlock = myWorld.getBiomeGenForCoords(new BlockPos(X, Y, Z)).topBlock;
		IBlockState fillerBlock = myWorld.getBiomeGenForCoords(new BlockPos(X, Y, Z)).fillerBlock;
		
		int XMultiplier = 1;
		int ZMultiplier = 1;
		
		if(myRand.nextInt(2) == 1){
			XMultiplier = -1;
		}
		if(myRand.nextInt(2) == 1){
			ZMultiplier = -1;
		}
		
		BlockPos myPos = new BlockPos(X, Y, Z);
		
		for(int i = 0; i < MyList.size(); i++){
			BlockPos islandPos = MyList.get(i);
			myWorld.setBlockState(myPos.add(islandPos.getX() * XMultiplier, islandPos.getY(), islandPos.getZ() * ZMultiplier), Blocks.STONE.getDefaultState(), 0);
		}
		for(int i = 0; i < MyDirtList.size(); i++){
			BlockPos islandPos = MyDirtList.get(i);
			myWorld.setBlockState(myPos.add(islandPos.getX() * XMultiplier, islandPos.getY(), islandPos.getZ() * ZMultiplier), fillerBlock, 0);
		}
		for(int i = 0; i < MyGrassList.size(); i++){
			BlockPos islandPos = MyGrassList.get(i);
			myWorld.setBlockState(myPos.add(islandPos.getX() * XMultiplier, islandPos.getY(), islandPos.getZ() * ZMultiplier), topBlock, 0);
		}
		
		
	}
	
}
