package CookingPlus.Dimension;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
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
	
	
	public void TranslateToWorld(World myWorld, int X, int Y, int Z){
		for(int i = 0; i < MyList.size(); i++){
			myWorld.setBlockState(MyList.get(i).add(X, Y, Z), Blocks.stone.getDefaultState(), 0);
		}
		for(int i = 0; i < MyDirtList.size(); i++){
			myWorld.setBlockState(MyDirtList.get(i).add(X, Y, Z), Blocks.dirt.getDefaultState(), 0);
		}
		for(int i = 0; i < MyGrassList.size(); i++){
			myWorld.setBlockState(MyGrassList.get(i).add(X, Y, Z), Blocks.grass.getDefaultState(), 0);
		}
		
		
	}
	
}
