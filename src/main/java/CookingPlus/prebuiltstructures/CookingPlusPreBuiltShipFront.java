package CookingPlus.prebuiltstructures;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusMain;

public class CookingPlusPreBuiltShipFront extends CookingPlusPreBuiltStructure {

	public CookingPlusPreBuiltShipFront() {
		super(7, 9, 13);
		
		this.MyStructureArray[3][0][0] = 1;
		this.MyStructureArray[3][0][1] = 1;
		this.MyStructureArray[3][0][2] = 1;
		
		this.MyStructureArray[2][1][0] = 1;
		this.MyStructureArray[2][1][1] = 1;
		this.MyStructureArray[3][1][0] = 1;
		this.MyStructureArray[3][1][1] = 1;
		this.MyStructureArray[3][1][2] = 1;
		this.MyStructureArray[3][1][3] = 1;
		this.MyStructureArray[3][1][4] = 1;
		this.MyStructureArray[4][1][0] = 1;
		this.MyStructureArray[4][1][1] = 1;
		
		this.MyStructureArray[1][2][0] = 1;
		this.MyStructureArray[1][2][1] = 1;
		this.MyStructureArray[2][2][1] = 1;
		this.MyStructureArray[2][2][2] = 1;
		this.MyStructureArray[3][2][2] = 2;
		this.MyStructureArray[3][2][3] = 1;
		this.MyStructureArray[3][2][4] = 1;
		this.MyStructureArray[3][2][5] = 1;
		this.MyStructureArray[3][2][6] = 1;
		this.MyStructureArray[4][2][1] = 1;
		this.MyStructureArray[4][2][3] = 1;
		this.MyStructureArray[4][2][4] = 1;
		this.MyStructureArray[5][2][0] = 1;
		this.MyStructureArray[5][2][1] = 1;
		
		this.MyStructureArray[1][3][1] = 1;
		this.MyStructureArray[1][3][2] = 1;
		this.MyStructureArray[2][3][4] = 1;
		this.MyStructureArray[2][3][5] = 1;
		this.MyStructureArray[2][3][6] = 1;
		this.MyStructureArray[3][3][4] = 1;
		this.MyStructureArray[3][3][5] = 1;
		this.MyStructureArray[3][3][6] = 1;
		this.MyStructureArray[3][3][7] = 1;
		this.MyStructureArray[3][3][8] = 1;
		this.MyStructureArray[4][3][4] = 1;
		this.MyStructureArray[4][3][5] = 1;
		this.MyStructureArray[4][3][6] = 1;
		this.MyStructureArray[6][3][1] = 1;
		this.MyStructureArray[6][3][2] = 1;
		this.MyStructureArray[6][3][3] = 1;
		this.MyStructureArray[6][3][4] = 1;
		
		this.MyStructureArray[0][4][2] = 1;
		this.MyStructureArray[0][4][3] = 1;
		this.MyStructureArray[0][4][4] = 1;
		this.MyStructureArray[1][4][2] = 1;
		this.MyStructureArray[1][4][3] = 1;
		this.MyStructureArray[1][4][4] = 1;
		this.MyStructureArray[1][4][5] = 1;
		this.MyStructureArray[1][4][6] = 1;
		this.MyStructureArray[2][4][1] = 1;
		this.MyStructureArray[2][4][2] = 1;
		this.MyStructureArray[2][4][3] = 1;
		this.MyStructureArray[2][4][4] = 1;
		this.MyStructureArray[2][4][5] = 1;
		this.MyStructureArray[2][4][6] = 1;
		this.MyStructureArray[2][4][7] = 1;
		this.MyStructureArray[2][4][8] = 1;
		this.MyStructureArray[3][4][1] = 1;
		this.MyStructureArray[3][4][2] = 1;
		this.MyStructureArray[3][4][3] = 1;
		this.MyStructureArray[3][4][4] = 1;
		this.MyStructureArray[3][4][5] = 1;
		this.MyStructureArray[3][4][6] = 1;
		this.MyStructureArray[3][4][7] = 1;
		this.MyStructureArray[3][4][8] = 1;
		this.MyStructureArray[3][4][9] = 1;
		this.MyStructureArray[3][4][10] = 1;
		this.MyStructureArray[4][4][1] = 1;
		this.MyStructureArray[4][4][2] = 1;
		this.MyStructureArray[4][4][3] = 1;
		this.MyStructureArray[4][4][4] = 1;
		this.MyStructureArray[4][4][5] = 1;
		this.MyStructureArray[4][4][6] = 1;
		this.MyStructureArray[4][4][7] = 1;
		this.MyStructureArray[4][4][8] = 1;
		this.MyStructureArray[5][4][2] = 1;
		this.MyStructureArray[5][4][3] = 1;
		this.MyStructureArray[5][4][4] = 1;
		this.MyStructureArray[5][4][5] = 1;
		this.MyStructureArray[5][4][6] = 1;
		this.MyStructureArray[6][4][3] = 1;
		this.MyStructureArray[6][4][4] = 1;
		this.MyStructureArray[0][5][4] = 1;
		this.MyStructureArray[0][5][5] = 1;
		this.MyStructureArray[1][5][5] = 1;
		this.MyStructureArray[1][5][6] = 1;
		this.MyStructureArray[2][5][7] = 1;
		this.MyStructureArray[2][5][8] = 1;
		this.MyStructureArray[3][5][5] = 1;
		this.MyStructureArray[3][5][9] = 1;
		this.MyStructureArray[3][5][10] = 1;
		this.MyStructureArray[3][5][11] = 1;
		this.MyStructureArray[3][5][12] = 1;
		this.MyStructureArray[4][5][7] = 1;
		this.MyStructureArray[4][5][8] = 1;
		this.MyStructureArray[5][5][5] = 1;
		this.MyStructureArray[5][5][6] = 1;
		this.MyStructureArray[6][5][5] = 1;
		
		this.MyStructureArray[3][6][5] = 1;
		this.MyStructureArray[3][7][5] = 1;
		this.MyStructureArray[3][8][5] = 1;
	}
	
	public void GenChest(World worldIn, Random random, BlockPos myPos){
		
		worldIn.setBlockState(myPos, Blocks.CHEST.getDefaultState());
		TileEntityChest MyChest = (TileEntityChest)worldIn.getTileEntity(myPos);
		
		int chance = 90;
		for(int i = 0; i < 27; i++){
			//ItemStack itemstack = new ItemStack(CookingPlusMain.onionseed, 2);
			int mychance = (int) (random.nextFloat() * 100);
			//System.out.println(mychance + " " + chance);
			if(mychance > chance){
				chance = 90;
				MyChest.setInventorySlotContents(i, GenChestItem(random));
			}
			else{
				chance -= 7;
			}
		}
	}
	
	private ItemStack GenChestItem(Random random){
		ItemStack MyStack = new ItemStack(CookingPlusMain.wine, 1);
		int which = random.nextInt(4);
		
		if(which == 0){
			MyStack = new ItemStack(CookingPlusMain.wine, random.nextInt(15) + 1);
		}
		else if(which == 1){
			MyStack = new ItemStack(CookingPlusMain.beer, random.nextInt(15) + 1);
		}
		else if(which == 2){
			MyStack = new ItemStack(CookingPlusMain.cider, random.nextInt(15) + 1);
		}
		else if(which == 3){
			MyStack = new ItemStack(CookingPlusMain.soakedbook,1);
		}
		
		return MyStack;
	}

	@Override
	public void setBlock(World worldIn, Random randIn, BlockPos myPos, int i, int j, int k, int rotation){
		
		if(this.MyStructureArray[i][j][k] == 1){
			worldIn.setBlockState(myPos, Blocks.PLANKS.getDefaultState());
		}
		else if(this.MyStructureArray[i][j][k] == 2){
			GenChest(worldIn, randIn, myPos);
		}
	}
}
