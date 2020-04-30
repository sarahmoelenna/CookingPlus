package CookingPlus.blocks.crops;

import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;
import CookingPlus.recipes.MutationStationRecipeHandler;

public class TierFiveMutantCrops extends CookingPlusCustomCrops
{

	private final String name = "fivemutantcrop";
	
    public TierFiveMutantCrops()
    {
        // Basic block setup
        this.setUnlocalizedName("fivemutantcrop");
        GameRegistry.registerBlock(this, "fivemutantcrop");
    }

    @Override
    protected Item GetSeedItem(){
    	return null;
    }
    
    @Override
    protected Item GetHarvestItem(){
    	return null;
    }
  
    @Override
	public String getName()
	{
		return name;
	}
    
    public void setToRandomCrop(Random parRand, World parWorld, BlockPos myPos, IBlockState myState){
    	parWorld.setBlockState(myPos, (MutationStationRecipeHandler.instance().getRandomCrop(5, parRand)).getDefaultState().withProperty(CookingPlusCustomCrops.AGE, 7));
    }
    
    @Override
    public void updateTick(World parWorld, BlockPos myPos, IBlockState myState, Random parRand)
    {
        super.updateTick(parWorld, myPos, myState, parRand);
        int prevStage = ((Integer)myState.getValue(AGE)).intValue();
        int growStage = ((Integer)myState.getValue(AGE)).intValue() + 1;
        
        if (growStage > 7)
        {
            growStage = 7;
        }
        if(growStage == 7 && prevStage != growStage){
        	if(parRand.nextInt(100) > 30){
        		setToRandomCrop(parRand, parWorld, myPos, myState);
        	}
        }

        if(parWorld.getBlockState(myPos).getBlock() == this){
        	parWorld.setBlockState(myPos, myState.withProperty(AGE, Integer.valueOf(growStage)), 2);
        }
       
    }
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
    {
    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
        ret.clear();

        return ret;
    }

}
    
    