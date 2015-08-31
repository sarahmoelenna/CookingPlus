package CookingPlus.blocks;

import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusWhiteCoralBlock extends CookingPlusCustomTranslucentCoral {

	private final String name = "whitecoralblock";
	
	public CookingPlusWhiteCoralBlock(){
		super();
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
    {
    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
        ret.clear();
        Random myRand = new Random();
        
        ret.add(new ItemStack(CookingPlusMain.blockWhiteCoral, myRand.nextInt(2) + 1, 0)); //always drops at least one seed
        

        return ret;
    }
	
}
