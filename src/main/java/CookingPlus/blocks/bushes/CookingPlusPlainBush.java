package CookingPlus.blocks.bushes;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomGrowingBush;

public class CookingPlusPlainBush extends CookingPlusCustomGrowingBush {

	private final String name = "bush";
	
	public CookingPlusPlainBush()
    {
        // Basic block setup
		
        setUnlocalizedName("bush");
        GameRegistry.registerBlock(this, name);
        //setBlockTextureName("cookingplus:bushleaves");
    }
	
	@Override
	public Block getBushBlock(){
    	return CookingPlusMain.blockBush;
    }
    
	@Override
	public String getName()
	{
		return name;
	}
	
	 @Override
	    public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
	    {
	    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
	        ret.clear();
	        int growStage = ((Integer)myState.getValue(AGE)).intValue();
	        
	        ret.add(new ItemStack(Item.getItemFromBlock(getBushBlock()), 1, 0)); //always drops at least one seed
	        
	        return ret;
	    }
	
}
