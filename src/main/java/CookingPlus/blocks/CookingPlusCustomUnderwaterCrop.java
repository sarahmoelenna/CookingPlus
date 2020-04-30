package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import CookingPlus.blocks.tileentity.CookingPlusGathererBlock;

public class CookingPlusCustomUnderwaterCrop extends CookingPlusCustomUnderwaterPlant {

public CookingPlusCustomUnderwaterCrop(){
	super();
	this.setTickRandomly(true);
	this.setLightOpacity(Blocks.WATER.getLightOpacity(Blocks.WATER.getDefaultState()));
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
	if(myRand.nextInt(5) == 0){
		if(myWorld.getBlockState(myPos.up()).getBlock() == Blocks.WATER){
			if(canBlockStay(myWorld, myPos.up())){
				myWorld.setBlockState(myPos.up(), GetCropBlock().getDefaultState());
			}
		}
	}
		
		if(!canBlockStay(myWorld, myPos)){
			myWorld.setBlockState(myPos, Blocks.WATER.getDefaultState());
			this.dropBlockAsItem(myWorld, myPos, this.getDefaultState(), 0);
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
	return null;
}

public boolean isValidDown(World world, BlockPos pos){
	Block myBlock = world.getBlockState(pos).getBlock();
	if(myBlock == GetCropBlock()){
		return true;
	}
	else if(myBlock == GetGroundBlock()){
		return true;
	}
	return false;
}

public boolean isValidTop(World world, BlockPos pos){
	Block myBlock = world.getBlockState(pos).getBlock();
	if(myBlock == Blocks.WATER){
		return true;
	}
	else if(myBlock == GetCropBlock()){
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
	


}


