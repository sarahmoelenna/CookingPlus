package CookingPlus.prebuiltstructures;

import java.util.Random;

import CookingPlus.CookingPlusMain;
import CookingPlus.generation.CookingPlusWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class CookingPlusPrebuiltFarmhouse extends CookingPlusPreBuiltStructure {

	Block BuildingBlock = Blocks.brick_block;
	IBlockState LogBlock = Blocks.log.getDefaultState();
	IBlockState FloorBlock = Blocks.planks.getDefaultState();
	Block StairBlock = Blocks.birch_stairs;
	IBlockState SlabBlock = Blocks.wooden_slab.getDefaultState();
	
	public CookingPlusPrebuiltFarmhouse() {
		super(7, 7, 11);
		
		Random myRand = new Random();
		int myNum = myRand.nextInt(3);
		if(myNum == 0){
			BuildingBlock = Blocks.brick_block;
		}
		else if(myNum == 1){
			BuildingBlock = Blocks.stonebrick;
		}
		else if(myNum == 2){
			BuildingBlock = CookingPlusMain.blockBasaltSmooth;
		}
		
		myNum = myRand.nextInt(3);
		if(myNum == 0){
			LogBlock = Blocks.log2.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
			FloorBlock = Blocks.planks.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
		}
		else if(myNum == 1){
			LogBlock = Blocks.log.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK);
			FloorBlock = Blocks.planks.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK);
		}
		else if(myNum == 2){
			LogBlock = Blocks.log.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
			FloorBlock = Blocks.planks.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
		}
		
		myNum = myRand.nextInt(5);
		if(myNum == 0){
			SlabBlock = Blocks.wooden_slab.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
			StairBlock = Blocks.acacia_stairs;
		}
		else if(myNum == 1){
			SlabBlock = Blocks.wooden_slab.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK);
			StairBlock = Blocks.oak_stairs;
		}
		else if(myNum == 2){
			SlabBlock = Blocks.wooden_slab.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
			StairBlock = Blocks.spruce_stairs;
		}
		else if(myNum == 3){
			SlabBlock = Blocks.wooden_slab.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH);
			StairBlock = Blocks.birch_stairs;
		}
		else if(myNum == 4){
			SlabBlock = Blocks.wooden_slab.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK);
			StairBlock = Blocks.dark_oak_stairs;
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
			worldIn.setBlockState(myPos, Blocks.glass_pane.getDefaultState());
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
				Material myMat = worldIn.getBlockState(myCheckPos).getBlock().getMaterial();
				if(myMat == Material.air || myMat == Material.plants || myMat == Material.lava || myMat == Material.water || myMat == Material.grass){
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
			worldIn.setBlockState(myPos, Blocks.chest.getDefaultState().withProperty(Blocks.chest.FACING, EnumFacing.WEST));
		}
		else if(rotation == 2){
			worldIn.setBlockState(myPos, Blocks.chest.getDefaultState().withProperty(Blocks.chest.FACING, EnumFacing.NORTH));
		}
		else if(rotation == 3){
			worldIn.setBlockState(myPos, Blocks.chest.getDefaultState().withProperty(Blocks.chest.FACING, EnumFacing.SOUTH));
		}
		else if(rotation == 4){
			worldIn.setBlockState(myPos, Blocks.chest.getDefaultState().withProperty(Blocks.chest.FACING, EnumFacing.EAST));
		}
		
		CookingPlusWorldGen.FillFarmerChest((TileEntityChest)worldIn.getTileEntity(myPos), random);
		
	}

}
