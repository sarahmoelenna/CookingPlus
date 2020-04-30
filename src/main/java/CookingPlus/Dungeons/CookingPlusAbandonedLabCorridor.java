package CookingPlus.Dungeons;

import java.util.ArrayList;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CookingPlusAbandonedLabCorridor implements CookingPlusStructureComponent {

	public final ArrayList<CookingPlusStructureComponent> componentList = new ArrayList();
	public final ArrayList<BlockPos> doorList = new ArrayList();
	CookingPlusStructureBoundingBox myBox;
	int floodLevel;
	int nodeLevel;
	protected BlockPos corridorEnd;
	protected EnumFacing corridorDirection;
	
	public CookingPlusAbandonedLabCorridor(){
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

	}

	@Override
	public void doesBoundingBoxCollide(CookingPlusStructureBoundingBox myBoundingBox) {
		
	}
	
	public void addDoorWay(BlockPos myPos){
		doorList.add(myPos);
	}
	
	public void setCorridorEnd(BlockPos myPos, EnumFacing myDirection, int myNode){
		corridorEnd = myPos;
		nodeLevel = myNode;
		corridorDirection = myDirection;
	}

	@Override
	public void generateComponent(World myWorld, Random myRand) {
		for(int x = 0; x <= myBox.getSizeX(); x++){
			for(int y = 0; y <= myBox.getSizeY(); y++){
				for(int z = 0; z <= myBox.getSizeZ(); z++){
					if(z == 0 || x == 0 || y == 0 || x == myBox.getSizeX() || y == myBox.getSizeY() || z == myBox.getSizeZ()){
						if(y == 0){
							myWorld.setBlockState(new BlockPos(new Vec3d(x + myBox.getX(), y + myBox.getY(), z + myBox.getZ())), getFloorBlock(x + myBox.getX(), y + myBox.getY(), z + myBox.getZ()));
							
						}else{
							myWorld.setBlockState(new BlockPos(new Vec3d(x + myBox.getX(), y + myBox.getY(), z + myBox.getZ())), CookingPlusMain.blockRustedCopperSheetBlock.getDefaultState());
						}
					}else{
						if(y + myBox.getY() < floodLevel){
							myWorld.setBlockState(new BlockPos(new Vec3d(x + myBox.getX(), y + myBox.getY(), z + myBox.getZ())), Blocks.WATER.getDefaultState());
						}else{
							myWorld.setBlockState(new BlockPos(new Vec3d(x + myBox.getX(), y + myBox.getY(), z + myBox.getZ())), Blocks.AIR.getDefaultState());
						}
					}
				}
			}
		}
		
		for(int i = 0; i < doorList.size(); i++){
			int y = doorList.get(i).getY();
			
			if(y < floodLevel){
				myWorld.setBlockState(doorList.get(i), Blocks.WATER.getDefaultState());
			}
			else{
				myWorld.setBlockState(doorList.get(i), Blocks.AIR.getDefaultState());
			}
			if(y + 1 < floodLevel){
				myWorld.setBlockState(doorList.get(i).up(), Blocks.WATER.getDefaultState());
			}
			else{
				myWorld.setBlockState(doorList.get(i).up(), Blocks.AIR.getDefaultState());
			}
		}
		
	}
	
	public int getChanceofRoom(){
		return (nodeLevel+1) * 25 + 1;
	}
	
	public int getChanceofAdditionalCorridor(){
		return 100/(nodeLevel+1);
	}
	
	public int getMaxAdditionalLength(){
		if(nodeLevel == 0){
			return 16;
		} else if(nodeLevel == 1){
			return 12;
		} else if(nodeLevel == 2){
			return 8;
		} else if(nodeLevel == 3){
			return 4;
		} else {
			return 1;
		}
	}

	public EnumFacing getRandomRoomDirection(Random myRand){
		int direction = myRand.nextInt(3);
		EnumFacing myDirection = EnumFacing.UP;
		
		if(corridorDirection == EnumFacing.NORTH){
			if(direction == 0){
				myDirection = EnumFacing.SOUTH;
			} else if(direction == 1){
				myDirection = EnumFacing.EAST;
			} else if(direction == 2){
				myDirection = EnumFacing.WEST;
			}
		}
		
		if(corridorDirection == EnumFacing.SOUTH){
			if(direction == 0){
				myDirection = EnumFacing.NORTH;
			} else if(direction == 1){
				myDirection = EnumFacing.EAST;
			} else if(direction == 2){
				myDirection = EnumFacing.WEST;
			}
		}
		
		if(corridorDirection == EnumFacing.EAST){
			if(direction == 0){
				myDirection = EnumFacing.SOUTH;
			} else if(direction == 1){
				myDirection = EnumFacing.NORTH;
			} else if(direction == 2){
				myDirection = EnumFacing.WEST;
			}
		}
		
		if(corridorDirection == EnumFacing.WEST){
			if(direction == 0){
				myDirection = EnumFacing.SOUTH;
			} else if(direction == 1){
				myDirection = EnumFacing.NORTH;
			} else if(direction == 2){
				myDirection = EnumFacing.EAST;
			}
		}
		
		return myDirection;
	}
	
	@Override
	public void generateAttachedComponents(Random myRand) {
		
		int myY = 0;
		int myX = 0;
		int myZ = 0;
		int length = 0;
		int width = 0;
		
		boolean southcorridor = myRand.nextInt(100) <= getChanceofAdditionalCorridor();
		boolean northcorridor = myRand.nextInt(100) <= getChanceofAdditionalCorridor();
		boolean westcorridor = myRand.nextInt(100) <= getChanceofAdditionalCorridor();
		boolean eastcorridor = myRand.nextInt(100) <= getChanceofAdditionalCorridor();
		
		if(myRand.nextInt(100) < getChanceofRoom() || (southcorridor == false && northcorridor == false && eastcorridor == false && westcorridor == false)){
			
			EnumFacing RoomDirection = getRandomRoomDirection(myRand);
			if(RoomDirection == EnumFacing.NORTH){
				myY = corridorEnd.getY();
				myX = corridorEnd.getX();
				myZ = corridorEnd.getZ() - 3;
				length = myRand.nextInt(8);
				width = myRand.nextInt(8)/2 + 2;
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 2 - width, myY, myZ - 5 - length)), new BlockPos(new Vec3d(myX + 2 + width, myY + 5, myZ)));
				CookingPlusAbandonedLabRoom myEntrance = new CookingPlusAbandonedLabRoom();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 2, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 2, myY + 1, myZ)));
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
			
			if(RoomDirection == EnumFacing.SOUTH){
				myY = corridorEnd.getY();
				myX = corridorEnd.getX();
				myZ = corridorEnd.getZ() + 3;
				length = myRand.nextInt(8);
				width = myRand.nextInt(8)/2 + 2;
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 2 - width, myY, myZ)), new BlockPos(new Vec3d(myX + 2 + width, myY + 5, myZ + 5 + length)));
				CookingPlusAbandonedLabRoom myEntrance = new CookingPlusAbandonedLabRoom();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 2, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 2, myY + 1, myZ)));
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
			
			if(RoomDirection == EnumFacing.EAST){
				myY = corridorEnd.getY();
				myX = corridorEnd.getX() - 3;
				myZ = corridorEnd.getZ();
				length = myRand.nextInt(8);
				width = myRand.nextInt(8)/2 + 2;
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX, myY, myZ - 2 - width)), new BlockPos(new Vec3d(myX + 5 + length, myY + 5, myZ + 2 + width)));
				CookingPlusAbandonedLabRoom myEntrance = new CookingPlusAbandonedLabRoom();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 2)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 2)));
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
			
			if(RoomDirection == EnumFacing.WEST){
				myY = corridorEnd.getY();
				myX = corridorEnd.getX() + 3;
				myZ = corridorEnd.getZ();
				length = myRand.nextInt(8);
				width = myRand.nextInt(8)/2 + 2;
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 5 - length, myY, myZ - 2 - width)), new BlockPos(new Vec3d(myX, myY + 5, myZ + 2 + width)));
				CookingPlusAbandonedLabRoom myEntrance = new CookingPlusAbandonedLabRoom();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 2)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 2)));
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
			
		}
		else{
		
			//negative Z
			if(corridorDirection != EnumFacing.SOUTH && southcorridor == true){
				myY = corridorEnd.getY();
				myX = corridorEnd.getX();
				myZ = corridorEnd.getZ() - 3;
				length = myRand.nextInt(getMaxAdditionalLength());
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 3, myY, myZ - 10 - length)), new BlockPos(new Vec3d(myX + 3, myY + 5, myZ)));
				CookingPlusAbandonedLabCorridor myEntrance = new CookingPlusAbandonedLabCorridor();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 2, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 2, myY + 1, myZ)));
				myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX, myY, myZ  - 10 - length + 3)), EnumFacing.NORTH, nodeLevel + 1);
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
			//positive Z
			if(corridorDirection != EnumFacing.NORTH && northcorridor == true){
				myY = corridorEnd.getY();
				myX = corridorEnd.getX();
				myZ = corridorEnd.getZ() + 3;
				length = myRand.nextInt(getMaxAdditionalLength());
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 3, myY, myZ)), new BlockPos(new Vec3d(myX + 3, myY + 5, myZ  + 10 + length)));
				CookingPlusAbandonedLabCorridor myEntrance = new CookingPlusAbandonedLabCorridor();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX - 2, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 1, myY + 1, myZ)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX + 2, myY + 1, myZ)));
				myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX, myY, myZ  + 10 + length - 3)), EnumFacing.SOUTH, nodeLevel + 1);
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
			
			if(corridorDirection != EnumFacing.EAST && eastcorridor == true){
				//negative X
				myY = corridorEnd.getY();
				myX = corridorEnd.getX() - 3;
				myZ = corridorEnd.getZ();
				length = myRand.nextInt(getMaxAdditionalLength());
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 10 - length, myY, myZ - 3)), new BlockPos(new Vec3d(myX, myY + 5, myZ + 3)));
				CookingPlusAbandonedLabCorridor myEntrance = new CookingPlusAbandonedLabCorridor();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 2)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 2)));
				myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX - 10 - length + 3, myY, myZ)), EnumFacing.WEST, nodeLevel + 1);
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
		
			if(corridorDirection != EnumFacing.WEST && westcorridor == true){
				//positive X
				myY = corridorEnd.getY();
				myX = corridorEnd.getX() + 3;
				myZ = corridorEnd.getZ();
				length = myRand.nextInt(getMaxAdditionalLength());
				CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX, myY, myZ - 3)), new BlockPos(new Vec3d(myX + 10 + length, myY + 5, myZ + 3)));
				CookingPlusAbandonedLabCorridor myEntrance = new CookingPlusAbandonedLabCorridor();
				myEntrance.setBoundingBox(myTempBoundingBox);
				myEntrance.setFloodLevel(floodLevel);
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ - 2)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 1)));
				myEntrance.addDoorWay(new BlockPos(new Vec3d(myX, myY + 1, myZ + 2)));
				myEntrance.setCorridorEnd(new BlockPos(new Vec3d(myX + 10 + length - 3, myY, myZ)), EnumFacing.EAST, nodeLevel + 1);
				if(CookingPlusStructureBase.doesBoundingBlockCollideWithList(componentList, myTempBoundingBox) == false){
					componentList.add(myEntrance);
				}
			}
			
		}
		
	}
	
	public void setFloodLevel(int value){
		floodLevel = value;
	}

	@Override
	public void setComponentList(ArrayList<CookingPlusStructureComponent> myComponentList) {
		componentList.addAll(myComponentList);
	}

	@Override
	public ArrayList<CookingPlusStructureComponent> getUpdatedComponentList() {
		return componentList;
	}

	protected IBlockState getFloorBlock(int x, int y, int z){
		
		int r = Math.abs(x%4);
		int r2 = Math.abs(z%4);
		if(r >= 0 && r < 2){
			if(r2 >= 0 && r2 < 2){
				return CookingPlusMain.blockRustedIronTileSheetBlock.getDefaultState();
			}
		}
		
		if(r >= 0 && r < 2){
			if(r2 >= 2){
				return CookingPlusMain.blockRustedCopperTileSheetBlock.getDefaultState();
			}
		}
		
		if(r >= 2){
			if(r2 >= 0 && r2 < 2){
				return CookingPlusMain.blockRustedCopperTileSheetBlock.getDefaultState();
			}
		}
		
		if(r >= 2){
			if(r2 >= 2){
				return CookingPlusMain.blockRustedIronTileSheetBlock.getDefaultState();
			}
		}
		
		
		return CookingPlusMain.blockRedstoneTileSheetBlock.getDefaultState();
	}

	
	@Override
	public void decorateComponent(World myWorld, Random myRand) {
		// TODO Auto-generated method stub
		
		if(corridorDirection == EnumFacing.EAST || corridorDirection == EnumFacing.WEST){
			for(int x = 0; x <= myBox.getSizeX(); x++){
				for(int z = 0; z <= myBox.getSizeZ(); z++){
					for(int y = 0; y <= myBox.getSizeY(); y++){
						int myX = x + myBox.getX();
						int myY = y + myBox.getY();
						int myZ = z + myBox.getZ();
						
						if(myX%4 == 0 && x > 0 && x < myBox.getSizeX() && y > 0){
							if(myY == myBox.getY() + myBox.getSizeY() - 1 && z < myBox.getSizeZ() && z > 0){
								myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedIronScaff.getDefaultState());
							}
							if(z == 1 || z == myBox.getSizeZ() - 1){
								myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedIronScaff.getDefaultState());
							}
						}
					}
				}
			}
		}
		
		if(corridorDirection == EnumFacing.NORTH || corridorDirection == EnumFacing.SOUTH){
			for(int x = 0; x <= myBox.getSizeX(); x++){
				for(int z = 0; z <= myBox.getSizeZ(); z++){
					for(int y = 0; y <= myBox.getSizeY(); y++){
						int myX = x + myBox.getX();
						int myY = y + myBox.getY();
						int myZ = z + myBox.getZ();
						
						if(myZ%4 == 0 && z > 0 && z < myBox.getSizeZ() && y > 0){
							if(myY == myBox.getY() + myBox.getSizeY() - 1  && x < myBox.getSizeX() && x > 0){
								myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedIronScaff.getDefaultState());
							}
							if(x == 1 || x == myBox.getSizeX() - 1){
								myWorld.setBlockState(new BlockPos(new Vec3d(myX, myY, myZ)), CookingPlusMain.blockRustedIronScaff.getDefaultState());
							}
						}
					}
				}
			}
		}
		
	}
	
}
