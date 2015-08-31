package CookingPlus.prebuiltstructures;

import java.util.Random;

import CookingPlus.generation.CookingPlusWorldGen;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class CookingPlusPreBuiltTropicalHut extends
		CookingPlusPreBuiltStructure {

	public CookingPlusPreBuiltTropicalHut() {
		super(7, 6, 7);
		
		this.MyStructureArray[2][0][0] = 3;
		this.MyStructureArray[3][0][0] = 3;
		this.MyStructureArray[4][0][0] = 3;
		this.MyStructureArray[1][0][1] = 3;
		this.MyStructureArray[5][0][1] = 3;
		this.MyStructureArray[0][0][2] = 3;
		this.MyStructureArray[6][0][2] = 3;
		this.MyStructureArray[6][0][3] = 3;
		this.MyStructureArray[0][0][4] = 3;
		this.MyStructureArray[6][0][4] = 3;
		this.MyStructureArray[1][0][5] = 3;
		this.MyStructureArray[5][0][5] = 3;
		this.MyStructureArray[2][0][6] = 3;
		this.MyStructureArray[3][0][6] = 3;
		this.MyStructureArray[4][0][6] = 3;
		
		this.MyStructureArray[3][1][3] = 4;
		
		this.MyStructureArray[2][1][0] = 1;
		this.MyStructureArray[3][1][0] = 1;
		this.MyStructureArray[4][1][0] = 1;
		this.MyStructureArray[1][1][1] = 1;
		this.MyStructureArray[5][1][1] = 1;
		this.MyStructureArray[0][1][2] = 1;
		this.MyStructureArray[6][1][2] = 1;
		this.MyStructureArray[6][1][3] = 1;
		this.MyStructureArray[0][1][4] = 1;
		this.MyStructureArray[6][1][4] = 1;
		this.MyStructureArray[1][1][5] = 1;
		this.MyStructureArray[5][1][5] = 1;
		this.MyStructureArray[2][1][6] = 1;
		this.MyStructureArray[3][1][6] = 1;
		this.MyStructureArray[4][1][6] = 1;
		
		this.MyStructureArray[2][2][0] = 1;
		this.MyStructureArray[3][2][0] = 1;
		this.MyStructureArray[4][2][0] = 1;
		this.MyStructureArray[1][2][1] = 1;
		this.MyStructureArray[5][2][1] = 1;
		this.MyStructureArray[0][2][2] = 1;
		this.MyStructureArray[6][2][2] = 1;
		this.MyStructureArray[6][2][3] = 1;
		this.MyStructureArray[0][2][4] = 1;
		this.MyStructureArray[6][2][4] = 1;
		this.MyStructureArray[1][2][5] = 1;
		this.MyStructureArray[5][2][5] = 1;
		this.MyStructureArray[2][2][6] = 1;
		this.MyStructureArray[3][2][6] = 1;
		this.MyStructureArray[4][2][6] = 1;
		
		this.MyStructureArray[2][3][0] = 2;
		this.MyStructureArray[3][3][0] = 2;
		this.MyStructureArray[4][3][0] = 2;
		this.MyStructureArray[1][3][1] = 2;
		this.MyStructureArray[5][3][1] = 2;
		this.MyStructureArray[0][3][2] = 2;
		this.MyStructureArray[6][3][2] = 2;
		this.MyStructureArray[6][3][3] = 2;
		this.MyStructureArray[0][3][4] = 2;
		this.MyStructureArray[6][3][4] = 2;
		this.MyStructureArray[1][3][5] = 2;
		this.MyStructureArray[5][3][5] = 2;
		this.MyStructureArray[2][3][6] = 2;
		this.MyStructureArray[3][3][6] = 2;
		this.MyStructureArray[4][3][6] = 2;
		
		this.MyStructureArray[2][3][1] = 1;
		this.MyStructureArray[3][3][1] = 1;
		this.MyStructureArray[4][3][1] = 1;
		this.MyStructureArray[1][3][2] = 1;
		this.MyStructureArray[5][3][2] = 1;
		this.MyStructureArray[1][3][3] = 1;
		this.MyStructureArray[5][3][3] = 1;
		this.MyStructureArray[1][3][4] = 1;
		this.MyStructureArray[5][3][4] = 1;
		this.MyStructureArray[2][3][5] = 1;
		this.MyStructureArray[3][3][5] = 1;
		this.MyStructureArray[4][3][5] = 1;
		
		this.MyStructureArray[2][4][1] = 2;
		this.MyStructureArray[3][4][1] = 2;
		this.MyStructureArray[4][4][1] = 2;
		this.MyStructureArray[1][4][2] = 2;
		this.MyStructureArray[5][4][2] = 2;
		this.MyStructureArray[1][4][3] = 2;
		this.MyStructureArray[5][4][3] = 2;
		this.MyStructureArray[1][4][4] = 2;
		this.MyStructureArray[5][4][4] = 2;
		this.MyStructureArray[2][4][5] = 2;
		this.MyStructureArray[3][4][5] = 2;
		this.MyStructureArray[4][4][5] = 2;
		
		this.MyStructureArray[2][5][2] = 2;
		this.MyStructureArray[3][5][2] = 2;
		this.MyStructureArray[4][5][2] = 2;
		this.MyStructureArray[2][5][3] = 2;
		this.MyStructureArray[4][5][3] = 2;
		this.MyStructureArray[2][5][4] = 2;
		this.MyStructureArray[3][5][4] = 2;
		this.MyStructureArray[4][5][4] = 2;
	}

	@Override
	public void setBlock(World worldIn, Random randIn, BlockPos myPos, int i,int j, int k, int rotation) {

		if (this.MyStructureArray[i][j][k] == 1) {
			worldIn.setBlockState(myPos, Blocks.planks.getDefaultState());
		} else if (this.MyStructureArray[i][j][k] == 2) {
			worldIn.setBlockState(myPos, Blocks.hay_block.getDefaultState());
		} else if (this.MyStructureArray[i][j][k] == 3) {
			worldIn.setBlockState(myPos, Blocks.sand.getDefaultState());
		} else if (this.MyStructureArray[i][j][k] == 4) {
			GenChest(worldIn, randIn, myPos, rotation);
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
