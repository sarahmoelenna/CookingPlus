package CookingPlus.prebuiltstructures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CookingPlusPreBuiltSpikyCoral extends CookingPlusPreBuiltStructure {

	public Block myBlock;
	
	public CookingPlusPreBuiltSpikyCoral(Block blockIn) {
		super(4, 7, 4);
		myBlock = blockIn;
		
		this.MyStructureArray[2][0][2] = 1;
		
		this.MyStructureArray[2][1][2] = 1;
		
		this.MyStructureArray[2][2][2] = 1;
		this.MyStructureArray[1][2][2] = 1;
		this.MyStructureArray[2][2][1] = 1;
		
		this.MyStructureArray[2][3][2] = 1;
		this.MyStructureArray[0][3][2] = 1;
		this.MyStructureArray[2][3][0] = 1;
		this.MyStructureArray[2][3][3] = 1;
		
		this.MyStructureArray[0][4][2] = 1;
		this.MyStructureArray[2][4][0] = 1;
		this.MyStructureArray[2][4][3] = 1;
		this.MyStructureArray[3][4][2] = 1;
		this.MyStructureArray[1][4][1] = 1;
		
		this.MyStructureArray[2][5][3] = 1;
		this.MyStructureArray[3][5][2] = 1;
		this.MyStructureArray[1][5][1] = 1;
		
		this.MyStructureArray[3][6][2] = 1;
	}
	
	@Override
	public void setBlock(World worldIn, Random randIn, BlockPos myPos, int i,int j, int k, int rotation) {

		if (this.MyStructureArray[i][j][k] == 1) {
			worldIn.setBlockState(myPos, myBlock.getDefaultState());
		}
	}

}
