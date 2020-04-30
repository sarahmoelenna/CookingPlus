package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.tileentity.CookingPlusGathererBlock;

public class CookingPlusCustomSpreadingCoral extends CookingPlusCustomUnderwaterPlant {

public CookingPlusCustomSpreadingCoral(){
	super();
	this.setTickRandomly(true);
	this.setLightOpacity(Blocks.WATER.getLightOpacity(Blocks.WATER.getDefaultState()));
	this.setLightLevel(0.5f);
}

public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
{
    return null;
}
	
@Override
public boolean canPlaceBlockAt(World world, BlockPos pos)
{
   return canBlockStay(world, pos);
}

@Override
public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
{
   return false;
}

@Override
public void updateTick(World myWorld, BlockPos myPos, IBlockState myState, Random myRand)
{	
	if(CookingPlusConfig.CoralSpreading == true){
		TryToSpread(myWorld, myRand, myPos);
	}
		
		if(!canBlockStay(myWorld, myPos)){
			myWorld.setBlockState(myPos, Blocks.WATER.getDefaultState());
			//this.dropBlockAsItem(myWorld, myPos, this.getDefaultState(), 0);
		}
}

public boolean canBlockStay(World world, BlockPos pos)
{
	//return false;
	return (isValidBlock(world, pos.east()) && isValidBlock(world, pos.north()) && isValidBlock(world, pos.south()) && isValidBlock(world, pos.west()) && isValidDown(world, pos.down()) && isValidTop(world, pos.up()));
}

public boolean isValidBlock(World world, BlockPos pos){
	
	Block myBlock = world.getBlockState(pos).getBlock();
	//System.out.println(myBlock.getUnlocalizedName());
	if(myBlock == Blocks.WATER)
	{
		//System.out.println("WATER");
		return true;
	}
	else if(myBlock == GetGroundBlock())
	{
		//System.out.println("WATER");
		return true;
	}
	else if(myBlock instanceof CookingPlusCustomUnderwaterPlant)
	{
		//System.out.println("plant");
		return true;
	}
	else if(myBlock instanceof CookingPlusGathererBlock)
	{
		//System.out.println("plant");
		return true;
	}
	return false;
}

public Block GetCropBlock(){
	return null;
}

public Block GetGroundBlock(){
	return CookingPlusMain.blockCoralRock;
}

public boolean isValidDown(World world, BlockPos pos){
	Block myBlock = world.getBlockState(pos).getBlock();
	if(myBlock == GetGroundBlock()){
		return true;
	}
	return false;
}

public boolean isValidTop(World world, BlockPos pos){
	Block myBlock = world.getBlockState(pos).getBlock();
	if(myBlock == Blocks.WATER){
		return true;
	}
	return false;
}

public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock)
	{
		if(!isValidDown(worldIn, pos.down())){
			worldIn.setBlockState(pos, Blocks.WATER.getDefaultState());
			this.dropBlockAsItem(worldIn, pos, this.getDefaultState(), 0);
		}
	}

public void TryToSpread(World worldIn, Random rand, BlockPos pos){
	if(rand.nextInt(100) > 100 - CookingPlusConfig.CoralSpreadRate){
		int place = rand.nextInt(4);
		//System.out.println("place: " + place);
		boolean done = false;
			if(place == 0){
				if(canBlockStay(worldIn, pos.east()) && done == false){
					if(worldIn.getBlockState(pos.east()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.east(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.east().down()) && done == false){
					if(worldIn.getBlockState(pos.east().down()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.east().down(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.east().up()) && done == false){
					if(worldIn.getBlockState(pos.east().up()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.east().up(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
			}
			if(place == 1){
				if(canBlockStay(worldIn, pos.north()) && done == false){
					if(worldIn.getBlockState(pos.north()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.north(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.north().down()) && done == false){
					if(worldIn.getBlockState(pos.north().down()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.north().down(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.north().up()) && done == false){
					if(worldIn.getBlockState(pos.north().up()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.north().up(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
			}
			if(place == 2){
				if(canBlockStay(worldIn, pos.west()) && done == false){
					if(worldIn.getBlockState(pos.west()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.west(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.west().down()) && done == false){
					if(worldIn.getBlockState(pos.west().down()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.west().down(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.west().up()) && done == false){
					if(worldIn.getBlockState(pos.west().up()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.west().up(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
			}
			if(place == 3){
				if(canBlockStay(worldIn, pos.south()) && done == false){
					if(worldIn.getBlockState(pos.south()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.south(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.south().down()) && done == false){
					if(worldIn.getBlockState(pos.south().down()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.south().down(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
				if(canBlockStay(worldIn, pos.south().up()) && done == false){
					if(worldIn.getBlockState(pos.south().up()).getBlock() == Blocks.WATER){
						worldIn.setBlockState(pos.south().up(), GetCropBlock().getDefaultState());
						done = true;
					}
				}
			}
	}
}

}


