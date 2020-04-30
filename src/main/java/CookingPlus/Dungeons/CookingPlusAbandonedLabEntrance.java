package CookingPlus.Dungeons;

import java.util.ArrayList;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

public class CookingPlusAbandonedLabEntrance implements CookingPlusStructureComponent {

	public final ArrayList<CookingPlusStructureComponent> componentList = new ArrayList();
	
	CookingPlusStructureBoundingBox myBox;
	int floodLevel;
	
	public CookingPlusAbandonedLabEntrance(){
		floodLevel = 0;
	}
	
	@Override
	public void setBoundingBox(CookingPlusStructureBoundingBox myBoundingBox) {
		myBox = myBoundingBox;
	}

	@Override
	public CookingPlusStructureBoundingBox getBoundingBox() {
		return myBox;
	}

	@Override
	public void isBlockPosWithingBoundingBox(BlockPos myCheckPos) {
		// TODO Auto-generated method stub
		
	}
	
	public void setFloodLevel(int value){
		floodLevel = value;
	}

	@Override
	public void doesBoundingBoxCollide(CookingPlusStructureBoundingBox myBoundingBox) {
		
	}

	@Override
	public void generateComponent(World myWorld, Random myRand) {
		int topY = myBox.getY();
		
		int AdditionalYUp = 0;
		if(myBox.getY() + myBox.getSizeY() < 230){
			AdditionalYUp = 20;
		}
		for(int y = 0; y < myBox.getSizeY() + AdditionalYUp; y ++){
			for(int x = 0; x < 21; x ++){
				for(int z = 0; z < 21; z ++){
					int myX = x + myBox.getX();
					int myY = myBox.getY() - y + AdditionalYUp + myBox.getSizeY();
					int myZ = z + myBox.getZ();
					if(y == myBox.getSizeY() + AdditionalYUp - 1){
						if(CookingPlusStructureBase.isPointWithinCircle(myBox.getX() + 10, myBox.getZ() + 10, myX, myZ, 10)){
							myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedCopperSheetBlock.getDefaultState());
						}
					}
					else{
						if(CookingPlusStructureBase.isPointWithinCircle(myBox.getX() + 10, myBox.getZ() + 10, myX, myZ, 10)){
							if(CookingPlusStructureBase.isPointWithinCircle(myBox.getX() + 10, myBox.getZ() + 10, myX, myZ, 9)){
								if(myY < floodLevel){
									myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), Blocks.WATER.getDefaultState());
								}else{
									myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), Blocks.AIR.getDefaultState());
								}
							}else{
								if(y > AdditionalYUp){
									myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedCopperSheetBlock.getDefaultState());
								}
								else{
									if(myWorld.getBlockState(new BlockPos(new Vec3d(myX, myY, myZ))).getBlock() != Blocks.AIR){
										if(myWorld.getBlockState(new BlockPos(new Vec3d(myX, myY, myZ))).getBlock() instanceof BlockLeaves == false){
											if(myWorld.getBlockState(new BlockPos(new Vec3d(myX, myY, myZ))).getBlock() instanceof BlockBush == false){
											if(myWorld.getBlockState(new BlockPos(new Vec3d(myX, myY, myZ))).getBlock().canSustainLeaves(myWorld.getBlockState(new BlockPos(new Vec3d(myX, myY, myZ))), myWorld, new BlockPos(new Vec3d(myX, myY, myZ))) == false){
												myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedCopperSheetBlock.getDefaultState());
											}	
										}
										}
									}
								}
							}
						}
					}
					if(y%10 == 0 && y > AdditionalYUp){
						if(CookingPlusStructureBase.isPointWithinCircle(myBox.getX() + 10, myBox.getZ() + 10, myX, myZ, 9)){
							if(CookingPlusStructureBase.isPointWithinCircle(myBox.getX() + 10, myBox.getZ() + 10, myX, myZ, 5)){
								if(myY < floodLevel){
									myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), Blocks.WATER.getDefaultState());
								}else{
									myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), Blocks.AIR.getDefaultState());
								}
							}else{
								myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedIronSheetBlock.getDefaultState());
							}
							if(CookingPlusStructureBase.isPointWithinCircle(myBox.getX() + 10, myBox.getZ() + 10, myX, myZ, 3)){
								myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedIronSheetBlock.getDefaultState());
							}
						}
					}
					
				}
			}
		}
		
		for(int y = 0; y < myBox.getSizeY() + AdditionalYUp; y ++){
			int myX = myBox.getX() + 10;
			int myZ = myBox.getZ() + 10;
			int myY = myBox.getY() - y + AdditionalYUp + myBox.getSizeY();
			if(y != myBox.getSizeY() + AdditionalYUp - 1 && y > AdditionalYUp){
				if(myWorld.getBlockState(new BlockPos(new Vec3d(myX, myY, myZ))).getBlock().isReplaceable(myWorld, new BlockPos(new Vec3d(myX, myY, myZ)))){
					myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedPipe.getDefaultState());
				}
			}
			if(y%10 == 0 && y > AdditionalYUp){
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY + 1, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY + 1, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY + 1, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY - 1, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY - 1, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX + 1, myY - 1, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY - 1, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY - 1, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX - 1, myY - 1, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY - 1, myZ - 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY - 1, myZ)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY - 1, myZ + 1)), CookingPlusMain.blockIronSheetBlock.getDefaultState());
				
			}
		}
		
	}

	@Override
	public void setComponentList(ArrayList<CookingPlusStructureComponent> myComponentList) {
		componentList.addAll(myComponentList);
		
	}

	@Override
	public ArrayList<CookingPlusStructureComponent> getUpdatedComponentList() {
		return componentList;
	}

	@Override
	public void generateAttachedComponents(Random myRand) {
		int topY = myBox.getY();
		int count = 2;
		
		int AdditionalYUp = 0;
		if(myBox.getY() + myBox.getSizeY() < 230){
			AdditionalYUp = 20;
		}
		for(int y = 0; y < myBox.getSizeY() + AdditionalYUp; y ++){
			if(y%10 == 0 && y > AdditionalYUp){
				if(count%2 == 0){
					if(count > 2){
					int myY = myBox.getY() + myBox.getSizeY() - y + AdditionalYUp;
					int myX = myBox.getX() + 10;
					int myZ = myBox.getZ() + 1;
					int length = myRand.nextInt(20);
					
					//negative Z
					CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 3, myY, myZ - 10 - length)), new BlockPos(new Vec3d(myX + 3, myY + 5, myZ)));
					CookingPlusAbandonedLabCorridor myEntrance = new CookingPlusAbandonedLabCorridor();
					myEntrance.setBoundingBox(myTempBoundingBox);
					myEntrance.setFloodLevel(floodLevel);
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 2, myY + 1, myZ)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 2, myY + 1, myZ)));
					myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX, myY, myZ  - 10 - length + 3)), EnumFacing.NORTH, 0);
					componentList.add(myEntrance);
				
					myX = myBox.getX() + 10;
					myZ = myBox.getZ() + myBox.getSizeZ() - 1;
					length = myRand.nextInt(20);
					//positive z
					myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 3, myY, myZ)), new BlockPos(new Vec3d(myX + 3, myY + 5, myZ + 10 + length)));
					myEntrance = new CookingPlusAbandonedLabCorridor();
					myEntrance.setBoundingBox(myTempBoundingBox);
					myEntrance.setFloodLevel(floodLevel);
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 2, myY + 1, myZ)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 2, myY + 1, myZ)));
					myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX, myY, myZ  + 10 + length - 3)), EnumFacing.SOUTH, 0);
					componentList.add(myEntrance);
					}
				}
				else{
					int myY = myBox.getY() + myBox.getSizeY() - y + AdditionalYUp;
					int myX = myBox.getX() + 1;
					int myZ = myBox.getZ() + 10;
					int length = myRand.nextInt(20);
					
					//negative X
					CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 10 - length, myY, myZ - 3)), new BlockPos(new Vec3d(myX, myY + 5, myZ + 3)));
					CookingPlusAbandonedLabCorridor myEntrance = new CookingPlusAbandonedLabCorridor();
					myEntrance.setBoundingBox(myTempBoundingBox);
					myEntrance.setFloodLevel(floodLevel);
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 1)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 2)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 1)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 2)));
					myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX - 10 - length + 3, myY, myZ)), EnumFacing.WEST, 0);
					componentList.add(myEntrance);
				
					myX = myBox.getX() + myBox.getSizeX() - 1;
					myZ = myBox.getZ() + 10;
					length = myRand.nextInt(20);
					//positive X
					myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX, myY, myZ - 3)), new BlockPos(new Vec3d(myX + 10 + length, myY + 5, myZ + 3)));
					myEntrance = new CookingPlusAbandonedLabCorridor();
					myEntrance.setBoundingBox(myTempBoundingBox);
					myEntrance.setFloodLevel(floodLevel);
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 1)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 2)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 1)));
					myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 2)));
					myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX + 10 + length - 3, myY, myZ)), EnumFacing.EAST, 0);
					componentList.add(myEntrance);
				}
				
				
				count++;
			}
		}
	}

	@Override
	public void decorateComponent(World myWorld, Random myRand) {
		// TODO Auto-generated method stub
		
	}

}
