package CookingPlus.blocks.crops;

import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class CookingPlusEasyMutantCrop extends CookingPlusEasyCrop {

	public CookingPlusEasyMutantCrop(String myName) {
		super(myName);
	}
	
	 @Override
	    public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
	    {
	    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
	        ret.clear();
	        int growStage = ((Integer)myState.getValue(AGE)).intValue();
	        
	        ret.add(new ItemStack(GetSeedItem(), 1, 0)); //always drops at least one seed
	        
	        if (growStage >= 7)
	        {
	        	ret.add(new ItemStack(GetHarvestItem(), 1, 0)); //extra seeds if grown
	        }

	        return ret;
	    }

}
