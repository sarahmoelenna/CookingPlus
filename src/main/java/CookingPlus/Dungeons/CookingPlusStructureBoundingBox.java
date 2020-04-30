package CookingPlus.Dungeons;

import net.minecraft.util.math.BlockPos;

public class CookingPlusStructureBoundingBox{

	BlockPos myOne;
	BlockPos myTwo;
	
	public CookingPlusStructureBoundingBox(BlockPos myPosOne, BlockPos myPosTwo){
		myOne = myPosOne;
		myTwo = myPosTwo;
	}
	
	public int getX(){
		return myOne.getX();
	}
	
	public int getY(){
		return myOne.getY();
	}
	
	public int getZ(){
		return myOne.getZ();
	}
	
	public int getSizeX(){
		return Math.abs(myTwo.getX() - myOne.getX());
	}
	
	public int getSizeY(){
		return Math.abs(myTwo.getY() - myOne.getY());
	}
	
	public int getSizeZ(){
		return Math.abs(myTwo.getZ() - myOne.getZ());
	}
	
}
