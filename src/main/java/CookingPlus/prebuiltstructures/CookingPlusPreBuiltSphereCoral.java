package CookingPlus.prebuiltstructures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CookingPlusPreBuiltSphereCoral extends CookingPlusPreBuiltStructure {

	public Block myBlock;
	
	public CookingPlusPreBuiltSphereCoral(Block blockIn) {
		super(8, 3, 8);
		myBlock = blockIn;
		
		this.MyStructureArray[0][0][3] = 1;
		this.MyStructureArray[0][0][4] = 1;
		this.MyStructureArray[1][0][1] = 1;
		this.MyStructureArray[1][0][2] = 1;
		this.MyStructureArray[1][0][5] = 1;
		this.MyStructureArray[1][0][6] = 1;
		this.MyStructureArray[2][0][1] = 1;
		this.MyStructureArray[2][0][6] = 1;
		this.MyStructureArray[3][0][0] = 1;
		this.MyStructureArray[3][0][7] = 1;
		this.MyStructureArray[7][0][3] = 1;
		this.MyStructureArray[7][0][4] = 1;
		this.MyStructureArray[6][0][1] = 1;
		this.MyStructureArray[6][0][2] = 1;
		this.MyStructureArray[6][0][5] = 1;
		this.MyStructureArray[6][0][6] = 1;
		this.MyStructureArray[5][0][1] = 1;
		this.MyStructureArray[5][0][6] = 1;
		this.MyStructureArray[4][0][0] = 1;
		this.MyStructureArray[4][0][7] = 1;
		
		this.MyStructureArray[3][0][3] = 1;
		this.MyStructureArray[3][0][4] = 1;
		this.MyStructureArray[4][0][3] = 1;
		this.MyStructureArray[4][0][4] = 1;
		
		this.MyStructureArray[1][1][2] = 1;
		this.MyStructureArray[1][1][3] = 1;
		this.MyStructureArray[1][1][4] = 1;
		this.MyStructureArray[1][1][5] = 1;
		this.MyStructureArray[2][1][1] = 1;
		this.MyStructureArray[2][1][2] = 1;
		this.MyStructureArray[2][1][5] = 1;
		this.MyStructureArray[2][1][6] = 1;
		this.MyStructureArray[3][1][1] = 1;
		this.MyStructureArray[3][1][6] = 1;
		this.MyStructureArray[6][1][2] = 1;
		this.MyStructureArray[6][1][3] = 1;
		this.MyStructureArray[6][1][4] = 1;
		this.MyStructureArray[5][1][5] = 1;
		this.MyStructureArray[5][1][1] = 1;
		this.MyStructureArray[5][1][2] = 1;
		this.MyStructureArray[5][1][5] = 1;
		this.MyStructureArray[5][1][6] = 1;
		this.MyStructureArray[4][1][1] = 1;
		this.MyStructureArray[4][1][6] = 1;
		
		this.MyStructureArray[3][1][3] = 1;
		this.MyStructureArray[3][1][4] = 1;
		this.MyStructureArray[4][1][3] = 1;
		this.MyStructureArray[4][1][4] = 1;
		
		this.MyStructureArray[2][2][3] = 1;	
		this.MyStructureArray[2][2][4] = 1;	
		this.MyStructureArray[3][2][2] = 1;
		this.MyStructureArray[3][2][3] = 1;
		this.MyStructureArray[3][2][4] = 1;
		this.MyStructureArray[3][2][5] = 1;
		this.MyStructureArray[5][2][3] = 1;	
		this.MyStructureArray[5][2][4] = 1;	
		this.MyStructureArray[4][2][2] = 1;
		this.MyStructureArray[4][2][3] = 1;
		this.MyStructureArray[4][2][4] = 1;
		this.MyStructureArray[4][2][5] = 1;
		
	}
	
	@Override
	public void setBlock(World worldIn, Random randIn, BlockPos myPos, int i,int j, int k, int rotation) {

		if (this.MyStructureArray[i][j][k] == 1) {
			worldIn.setBlockState(myPos, myBlock.getDefaultState());
		}
	}

}
