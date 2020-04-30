package CookingPlus.Dungeons;

import java.util.ArrayList;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusRotatedRustedMachine;
import CookingPlus.blocks.tileentity.CookingPlusBotBlock;
import CookingPlus.blocks.tileentity.MutationStationBlock;
import CookingPlus.tiles.BotTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CookingPlusAbandonedLabRoom implements CookingPlusStructureComponent {

	public final ArrayList<CookingPlusStructureComponent> componentList = new ArrayList();
	public final ArrayList<BlockPos> doorList = new ArrayList();
	CookingPlusStructureBoundingBox myBox;
	int floodLevel;
	
	public CookingPlusAbandonedLabRoom(){
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

	@Override
	public void doesBoundingBoxCollide(
			CookingPlusStructureBoundingBox myBoundingBox) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void generateAttachedComponents(Random myRand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setComponentList(ArrayList<CookingPlusStructureComponent> myComponentList) {
		componentList.addAll(myComponentList);
	}

	@Override
	public ArrayList<CookingPlusStructureComponent> getUpdatedComponentList() {
		return componentList;
	}

	
	public void addDoorWay(BlockPos myPos){
		doorList.add(myPos);
	}
	
	public void setFloodLevel(int value){
		floodLevel = value;
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
		int myRoom = myRand.nextInt(100);
		if(myRoom < 50){
			decorateLowLevelTechRoom(myWorld, myRand);
		} else if(myRoom >= 50){
			decorateHighLevelTechRoom(myWorld, myRand);
		}
	
	}
	
	public void decorateLowLevelTechRoom(World myWorld, Random myRand){
		for(int x = 0; x <= myBox.getSizeX(); x++){
			for(int y = 0; y <= myBox.getSizeY(); y++){
				for(int z = 0; z <= myBox.getSizeX(); z++){
					int myX = x + myBox.getX();
					int myY = y + myBox.getY();
					int myZ = z + myBox.getZ();
					
					if(x%5 == 3 && z%5 == 3 && y == 1){
						generateLowLevelTechSection(new BlockPos(new Vec3d(myX, myY, myZ)), myWorld, myRand);
					}
				}
			}
		}
	}
	
	public void decorateHighLevelTechRoom(World myWorld, Random myRand){
		for(int x = 0; x <= myBox.getSizeX(); x++){
			for(int y = 0; y <= myBox.getSizeY(); y++){
				for(int z = 0; z <= myBox.getSizeX(); z++){
					int myX = x + myBox.getX();
					int myY = y + myBox.getY();
					int myZ = z + myBox.getZ();
					
					if(x%5 == 3 && z%5 == 3 && y == 1){
						generateLowLevelTechSection(new BlockPos(new Vec3d(myX, myY, myZ)), myWorld, myRand);
					}
				}
			}
		}
	}
	
	
	protected void generateLowLevelTechSection(BlockPos myPos, World myWorld, Random myRand){
		boolean canGenerateSection = true;
		for(int x = 0; x < 5; x++){
			for(int z = 0; z < 5; z++){
				if(myWorld.getBlockState(myPos.east(x - 2).north(z - 2)).getMaterial() == Material.AIR || myWorld.getBlockState(myPos.east(x - 2).north(z - 2)).getMaterial() == Material.WATER){
					//System.out.println(myWorld.getBlockState(myPos.east(x - 2).west(z - 2)).getBlock().getUnlocalizedName());
				}
				else{
					//System.out.println(myWorld.getBlockState(myPos.east(x - 2).north(z - 2)).getBlock().getUnlocalizedName() + " False");
					canGenerateSection = false;
				}
			}
		}
		if(canGenerateSection == true){
			int stationType = myRand.nextInt(3);
			if(stationType == 0){
				generateMutationTechStation(myPos, myWorld);
			} else if(stationType == 1){
				generateHydroponicsStation(myPos, myWorld);
			} else if(stationType == 2){
				generateAnalysisTechStation(myPos, myWorld);
			}
		}
	}
	
	protected void generateMutationTechStation(BlockPos myPos, World myWorld){
		myWorld.setBlockState(myPos.west(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.east(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.north(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.NORTH));
		myWorld.setBlockState(myPos.south(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.SOUTH));
		
		myWorld.setBlockState(myPos.west().up(), CookingPlusMain.blockRustedMutationStation.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.east().up(), CookingPlusMain.blockRustedMutationStation.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.north().up(), CookingPlusMain.blockRustedMutationStation.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.NORTH));
		myWorld.setBlockState(myPos.south().up(), CookingPlusMain.blockRustedMutationStation.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.SOUTH));
		
		for(int y = 0; y < myBox.getSizeY(); y++){
			if(myWorld.getBlockState(myPos.up(y)).getMaterial() == Material.AIR || myWorld.getBlockState(myPos.up(y)).getMaterial() == Material.WATER){
				myWorld.setBlockState(myPos.up(y), CookingPlusMain.blockRustedPipe.getDefaultState());
			}
		}
	}
	
	protected void generateAnalysisTechStation(BlockPos myPos, World myWorld){
		myWorld.setBlockState(myPos.west(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.east(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.north(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.NORTH));
		myWorld.setBlockState(myPos.south(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.SOUTH));
		
		myWorld.setBlockState(myPos.west().up(), CookingPlusMain.blockRustedAnalyser.getDefaultState());
		myWorld.setBlockState(myPos.east().up(), CookingPlusMain.blockRustedAnalyser.getDefaultState());
		myWorld.setBlockState(myPos.north().up(), CookingPlusMain.blockRustedAnalyser.getDefaultState());
		myWorld.setBlockState(myPos.south().up(), CookingPlusMain.blockRustedAnalyser.getDefaultState());
		
		for(int y = 0; y < myBox.getSizeY(); y++){
			if(myWorld.getBlockState(myPos.up(y)).getMaterial() == Material.AIR || myWorld.getBlockState(myPos.up(y)).getMaterial() == Material.WATER){
				myWorld.setBlockState(myPos.up(y), CookingPlusMain.blockRustedPipe.getDefaultState());
			}
		}
	}
	
	protected void generateHydroponicsStation(BlockPos myPos, World myWorld){
		
		myWorld.setBlockState(myPos.west().up(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.east().up(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.north().up(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.NORTH));
		myWorld.setBlockState(myPos.south().up(), CookingPlusMain.blockRustedBot.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.SOUTH));
		
		myWorld.setBlockState(myPos.west().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.east().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.north().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.NORTH));
		myWorld.setBlockState(myPos.south().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.SOUTH));
		
		myWorld.setBlockState(myPos.west(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.east(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.north(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.NORTH));
		myWorld.setBlockState(myPos.south(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.SOUTH));
		
		myWorld.setBlockState(myPos.west().north(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.west().north().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.west().north().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.west().south(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.west().south().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		myWorld.setBlockState(myPos.west().south().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.WEST));
		
		myWorld.setBlockState(myPos.east().north(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.east().north().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.east().north().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.east().south(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.east().south().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		myWorld.setBlockState(myPos.east().south().up().up(), CookingPlusMain.blockRustedHydrophonic.getDefaultState().withProperty(CookingPlusRotatedRustedMachine.FACING, EnumFacing.EAST));
		
		for(int y = 0; y < myBox.getSizeY(); y++){
			if(myWorld.getBlockState(myPos.up(y)).getMaterial() == Material.AIR || myWorld.getBlockState(myPos.up(y)).getMaterial() == Material.WATER){
				myWorld.setBlockState(myPos.up(y), CookingPlusMain.blockRustedPipe.getDefaultState());
			}
		}
		
	}

}
