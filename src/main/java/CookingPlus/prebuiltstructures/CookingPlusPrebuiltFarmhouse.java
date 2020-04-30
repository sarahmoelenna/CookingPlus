package CookingPlus.prebuiltstructures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusMain;
import CookingPlus.generation.CookingPlusWorldGen;

public class CookingPlusPrebuiltFarmhouse extends CookingPlusPreBuiltStructure {

	Block BuildingBlock = Blocks.BRICK_BLOCK;
	IBlockState LogBlock = Blocks.LOG.getDefaultState();
	IBlockState FloorBlock = Blocks.PLANKS.getDefaultState();
	Block StairBlock = Blocks.BIRCH_STAIRS;
	IBlockState SlabBlock = Blocks.WOODEN_SLAB.getDefaultState();
	
	public CookingPlusPrebuiltFarmhouse() {
		super(7, 7, 11);
		
		Random myRand = new Random();
		int myNum = myRand.nextInt(3);
		if(myNum == 0){
			BuildingBlock = Blocks.BRICK_BLOCK;
		}
		else if(myNum == 1){
			BuildingBlock = Blocks.STONEBRICK;
		}
		else if(myNum == 2){
			BuildingBlock = CookingPlusMain.blockBasaltSmooth;
		}
		
		myNum = myRand.nextInt(3);
		if(myNum == 0){
			//System.out.print("Acacia Log");
			LogBlock = Blocks.LOG2.getDefaultState();
			//LogBlock = Blocks.LOG2.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
			FloorBlock = Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
		}
		else if(myNum == 1){
			//System.out.print("Oak Log");
			LogBlock = Blocks.LOG.getDefaultState();
			//LogBlock = Blocks.LOG.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK);
			FloorBlock = Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK);
		}
		else if(myNum == 2){
			//System.out.print("Spruce Log");
			LogBlock = Blocks.LOG.getDefaultState();
			//LogBlock = Blocks.LOG.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
			FloorBlock = Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
		}
		
		myNum = myRand.nextInt(5);
		if(myNum == 0){
			//System.out.print("Acacia Stairs");
			SlabBlock = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
			StairBlock = Blocks.ACACIA_STAIRS;
		}
		else if(myNum == 1){
			//System.out.print("Oak Stairs");
			SlabBlock = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK);
			StairBlock = Blocks.OAK_STAIRS;
		}
		else if(myNum == 2){
			//System.out.print("Spruce Stairs");
			SlabBlock = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
			StairBlock = Blocks.SPRUCE_STAIRS;
		}
		else if(myNum == 3){
			//System.out.print("Birch Stairs");
			SlabBlock = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH);
			StairBlock = Blocks.BIRCH_STAIRS;
		}
		else if(myNum == 4){
			//System.out.print("Dark Oak Stairs");
			SlabBlock = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK);
			StairBlock = Blocks.DARK_OAK_STAIRS;
		}
		 
		//floor
		this.MyStructureArray[1][0][1] = 6;
		this.MyStructureArray[2][0][1] = 1;
		this.MyStructureArray[3][0][1] = 1;
		this.MyStructureArray[4][0][1] = 1;
		this.MyStructureArray[5][0][1] = 6;
		this.MyStructureArray[1][0][2] = 1;
		this.MyStructureArray[2][0][2] = 2;
		this.MyStructureArray[3][0][2] = 2;
		this.MyStructureArray[4][0][2] = 2;
		this.MyStructureArray[5][0][2] = 1;
		this.MyStructureArray[1][0][3] = 1;
		this.MyStructureArray[2][0][3] = 2;
		this.MyStructureArray[3][0][3] = 2;
		this.MyStructureArray[4][0][3] = 2;
		this.MyStructureArray[5][0][3] = 1;
		this.MyStructureArray[1][0][4] = 1;
		this.MyStructureArray[2][0][4] = 2;
		this.MyStructureArray[3][0][4] = 2;
		this.MyStructureArray[4][0][4] = 2;
		this.MyStructureArray[5][0][4] = 1;
		this.MyStructureArray[1][0][5] = 6;
		this.MyStructureArray[2][0][5] = 2;
		this.MyStructureArray[3][0][5] = 2;
		this.MyStructureArray[4][0][5] = 2;
		this.MyStructureArray[5][0][5] = 6;
		this.MyStructureArray[1][0][6] = 1;
		this.MyStructureArray[2][0][6] = 2;
		this.MyStructureArray[3][0][6] = 2;
		this.MyStructureArray[4][0][6] = 2;
		this.MyStructureArray[5][0][6] = 1;
		this.MyStructureArray[1][0][7] = 1;
		this.MyStructureArray[2][0][7] = 2;
		this.MyStructureArray[3][0][7] = 2;
		this.MyStructureArray[4][0][7] = 2;
		this.MyStructureArray[5][0][7] = 1;
		this.MyStructureArray[1][0][8] = 1;
		this.MyStructureArray[2][0][8] = 2;
		this.MyStructureArray[3][0][8] = 2;
		this.MyStructureArray[4][0][8] = 2;
		this.MyStructureArray[5][0][8] = 1;
		this.MyStructureArray[1][0][9] = 6;
		this.MyStructureArray[2][0][9] = 1;
		this.MyStructureArray[3][0][9] = 1;
		this.MyStructureArray[4][0][9] = 1;
		this.MyStructureArray[5][0][9] = 6;
		
		//layer1
		this.MyStructureArray[1][1][1] = 6;
		this.MyStructureArray[2][1][1] = 1;
		this.MyStructureArray[3][1][1] = 1;
		//this.MyStructureArray[4][1][1] = 1;
		//this.MyStructureArray[5][1][1] = 6;
		this.MyStructureArray[1][1][2] = 1;
		//this.MyStructureArray[5][1][2] = 1;
		this.MyStructureArray[1][1][3] = 1;
		this.MyStructureArray[5][1][3] = 1;
		this.MyStructureArray[1][1][4] = 1;
		this.MyStructureArray[5][1][4] = 1;
		//this.MyStructureArray[1][1][5] = 6;
		this.MyStructureArray[5][1][5] = 6;
		//this.MyStructureArray[1][1][6] = 1;
		this.MyStructureArray[5][1][6] = 1;
		this.MyStructureArray[1][1][7] = 1;
		this.MyStructureArray[5][1][7] = 1;
		this.MyStructureArray[1][1][8] = 1;
		this.MyStructureArray[5][1][8] = 1;
		this.MyStructureArray[1][1][9] = 6;
		this.MyStructureArray[2][1][9] = 1;
		this.MyStructureArray[3][1][9] = 1;
		this.MyStructureArray[4][1][9] = 1;
		this.MyStructureArray[5][1][9] = 6;
		
		//glass layer
		this.MyStructureArray[1][2][1] = 6;
		this.MyStructureArray[2][2][1] = 1;
		//this.MyStructureArray[3][2][1] = 3;
		//this.MyStructureArray[4][2][1] = 1;
		//this.MyStructureArray[5][2][1] = 6;
		this.MyStructureArray[1][2][2] = 1;
		//this.MyStructureArray[5][2][2] = 1;
		this.MyStructureArray[1][2][3] = 3;
		this.MyStructureArray[5][2][3] = 3;
		//this.MyStructureArray[1][2][4] = 1;
		this.MyStructureArray[5][2][4] = 1;
		//this.MyStructureArray[1][2][5] = 6;
		this.MyStructureArray[5][2][5] = 6;
		//this.MyStructureArray[1][2][6] = 1;
		this.MyStructureArray[5][2][6] = 1;
		this.MyStructureArray[1][2][7] = 3;
		this.MyStructureArray[5][2][7] = 3;
		this.MyStructureArray[1][2][8] = 1;
		this.MyStructureArray[5][2][8] = 1;
		this.MyStructureArray[1][2][9] = 6;
		this.MyStructureArray[2][2][9] = 1;
		this.MyStructureArray[3][2][9] = 3;
		this.MyStructureArray[4][2][9] = 1;
		this.MyStructureArray[5][2][9] = 6;
		
		//layer 3
		this.MyStructureArray[1][3][1] = 6;
		this.MyStructureArray[2][3][1] = 1;
		//this.MyStructureArray[3][3][1] = 3;
		//this.MyStructureArray[4][3][1] = 1;
		//this.MyStructureArray[5][3][1] = 6;
		this.MyStructureArray[1][3][2] = 1;
		//this.MyStructureArray[5][3][2] = 1;
		this.MyStructureArray[1][3][3] = 1;
		//this.MyStructureArray[5][3][3] = 1;
		//this.MyStructureArray[1][3][4] = 1;
		//this.MyStructureArray[5][3][4] = 1;
		//this.MyStructureArray[1][3][5] = 6;
		this.MyStructureArray[5][3][5] = 6;
		//this.MyStructureArray[1][3][6] = 1;
		this.MyStructureArray[5][3][6] = 1;
		//this.MyStructureArray[1][3][7] = 1;
		this.MyStructureArray[5][3][7] = 1;
		this.MyStructureArray[1][3][8] = 1;
		this.MyStructureArray[5][3][8] = 1;
		this.MyStructureArray[1][3][9] = 6;
		this.MyStructureArray[2][3][9] = 1;
		this.MyStructureArray[3][3][9] = 3;
		this.MyStructureArray[4][3][9] = 1;
		this.MyStructureArray[5][3][9] = 6;
		
		//layer4
		this.MyStructureArray[2][4][1] = 6;
		//this.MyStructureArray[3][4][1] = 1;
		//this.MyStructureArray[4][4][1] = 6;
		this.MyStructureArray[2][4][9] = 6;
		this.MyStructureArray[3][4][9] = 1;
		this.MyStructureArray[4][4][9] = 6;
		
		//layer 5
		this.MyStructureArray[3][5][1] = 6;
		this.MyStructureArray[3][5][9] = 6;
		
		//layer 6
		this.MyStructureArray[3][6][0] = 5;
		this.MyStructureArray[3][6][1] = 5;
		this.MyStructureArray[3][6][2] = 5;
		this.MyStructureArray[3][6][3] = 5;
		this.MyStructureArray[3][6][4] = 5;
		this.MyStructureArray[3][6][5] = 5;
		this.MyStructureArray[3][6][6] = 5;
		this.MyStructureArray[3][6][7] = 5;
		this.MyStructureArray[3][6][8] = 5;
		this.MyStructureArray[3][6][9] = 5;
		this.MyStructureArray[3][6][9] = 5;
		this.MyStructureArray[3][6][10] = 5;
		
		//stairs layer 3 
		this.MyStructureArray[0][3][0] = 4;
		this.MyStructureArray[0][3][1] = 4;
		this.MyStructureArray[0][3][2] = 4;
		this.MyStructureArray[0][3][3] = 4;
		//this.MyStructureArray[0][3][4] = 4;
		//this.MyStructureArray[0][3][5] = 4;
		//this.MyStructureArray[0][3][6] = 4;
		//this.MyStructureArray[0][3][7] = 4;
		this.MyStructureArray[0][3][8] = 4;
		this.MyStructureArray[0][3][9] = 4;
		this.MyStructureArray[0][3][10] = 4;
		//this.MyStructureArray[6][3][0] = 8;
		//this.MyStructureArray[6][3][1] = 8;
		//this.MyStructureArray[6][3][2] = 8;
		//this.MyStructureArray[6][3][3] = 8;
		//this.MyStructureArray[6][3][4] = 8;
		this.MyStructureArray[6][3][5] = 8;
		this.MyStructureArray[6][3][6] = 8;
		this.MyStructureArray[6][3][7] = 8;
		this.MyStructureArray[6][3][8] = 8;
		this.MyStructureArray[6][3][9] = 8;
		this.MyStructureArray[6][3][10] = 8;
		
		//stairs layer 4
		this.MyStructureArray[1][4][0] = 4;
		this.MyStructureArray[1][4][1] = 4;
		this.MyStructureArray[1][4][2] = 4;
		this.MyStructureArray[1][4][3] = 4;
		this.MyStructureArray[1][4][4] = 4;
		//this.MyStructureArray[1][4][5] = 4;
		//this.MyStructureArray[1][4][6] = 4;
		this.MyStructureArray[1][4][7] = 4;
		this.MyStructureArray[1][4][8] = 4;
		this.MyStructureArray[1][4][9] = 4;
		this.MyStructureArray[1][4][10] = 4;
		//this.MyStructureArray[5][4][0] = 8;
		//this.MyStructureArray[5][4][1] = 8;
		//this.MyStructureArray[5][4][2] = 8;
		//this.MyStructureArray[5][4][3] = 8;
		this.MyStructureArray[5][4][4] = 8;
		this.MyStructureArray[5][4][5] = 8;
		this.MyStructureArray[5][4][6] = 8;
		this.MyStructureArray[5][4][7] = 8;
		this.MyStructureArray[5][4][8] = 8;
		this.MyStructureArray[5][4][9] = 8;
		this.MyStructureArray[5][4][10] = 8;
		
		//stairs layer 5
		this.MyStructureArray[2][5][0] = 4;
		this.MyStructureArray[2][5][1] = 4;
		this.MyStructureArray[2][5][2] = 4;
		this.MyStructureArray[2][5][3] = 4;
		this.MyStructureArray[2][5][4] = 4;
		this.MyStructureArray[2][5][5] = 4;
		//this.MyStructureArray[2][5][6] = 4;
		this.MyStructureArray[2][5][7] = 4;
		this.MyStructureArray[2][5][8] = 4;
		this.MyStructureArray[2][5][9] = 4;
		this.MyStructureArray[2][5][10] = 4;
		this.MyStructureArray[4][5][0] = 8;
		this.MyStructureArray[4][5][1] = 8;
		this.MyStructureArray[4][5][2] = 8;
		this.MyStructureArray[4][5][3] = 8;
		this.MyStructureArray[4][5][4] = 8;
		this.MyStructureArray[4][5][5] = 8;
		this.MyStructureArray[4][5][6] = 8;
		this.MyStructureArray[4][5][7] = 8;
		this.MyStructureArray[4][5][8] = 8;
		this.MyStructureArray[4][5][9] = 8;
		this.MyStructureArray[4][5][10] = 8;
		
		//chests
		this.MyStructureArray[2][1][8] = 7;
		this.MyStructureArray[3][1][8] = 7;
		
	}

	@Override
	public void setBlock(World worldIn, Random randIn, BlockPos myPos, int i,int j, int k, int rotation) {

		if (this.MyStructureArray[i][j][k] == 1) {
			worldIn.setBlockState(myPos, BuildingBlock.getDefaultState());
		} else if (this.MyStructureArray[i][j][k] == 2) {
			worldIn.setBlockState(myPos, FloorBlock);
		} else if (this.MyStructureArray[i][j][k] == 3) {
			worldIn.setBlockState(myPos, Blocks.GLASS_PANE.getDefaultState());
		} else if (this.MyStructureArray[i][j][k] == 8) {
			if(rotation == 1){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
			}
			else if(rotation == 2){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
			}
			else if(rotation == 3){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH));
			}
			else if(rotation == 4){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
			}
		} else if (this.MyStructureArray[i][j][k] == 4) {
			if(rotation == 1){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
			}
			else if(rotation == 2){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH));
			}
			else if(rotation == 3){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
			}
			else if(rotation == 4){
				worldIn.setBlockState(myPos, StairBlock.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
			}
		} else if (this.MyStructureArray[i][j][k] == 5) {
			worldIn.setBlockState(myPos, SlabBlock);
		} else if (this.MyStructureArray[i][j][k] == 6) {
			worldIn.setBlockState(myPos, LogBlock);
		} else if (this.MyStructureArray[i][j][k] == 7) {
			GenChest(worldIn, randIn, myPos, rotation);
		}
		
		if(j == 0){
			Boolean Done = false;
			for(int y = myPos.getY() - 1; y > 0 && Done == false; y--){
				BlockPos myCheckPos = new BlockPos(myPos.getX(), y, myPos.getZ());
				Material myMat = worldIn.getBlockState(myCheckPos).getBlock().getMaterial(worldIn.getBlockState(myCheckPos));
				if(myMat == Material.AIR || myMat == Material.PLANTS || myMat == Material.LAVA || myMat == Material.WATER || myMat == Material.GRASS){
					worldIn.setBlockState(myCheckPos, BuildingBlock.getDefaultState());
				}
				else{
					Done = true;
				}
			}
		}
	}

	public void GenChest(World worldIn, Random random, BlockPos myPos, int rotation) {
		if(rotation == 1){
			worldIn.setBlockState(myPos, Blocks.CHEST.getDefaultState().withProperty(Blocks.CHEST.FACING, EnumFacing.WEST));
		}
		else if(rotation == 2){
			worldIn.setBlockState(myPos, Blocks.CHEST.getDefaultState().withProperty(Blocks.CHEST.FACING, EnumFacing.NORTH));
		}
		else if(rotation == 3){
			worldIn.setBlockState(myPos, Blocks.CHEST.getDefaultState().withProperty(Blocks.CHEST.FACING, EnumFacing.SOUTH));
		}
		else if(rotation == 4){
			worldIn.setBlockState(myPos, Blocks.CHEST.getDefaultState().withProperty(Blocks.CHEST.FACING, EnumFacing.EAST));
		}
		
		CookingPlusWorldGen.FillFarmerChest((TileEntityChest)worldIn.getTileEntity(myPos), random);
		
	}

}
