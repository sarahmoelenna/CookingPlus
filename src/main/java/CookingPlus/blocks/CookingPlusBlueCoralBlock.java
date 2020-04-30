package CookingPlus.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class CookingPlusBlueCoralBlock extends CookingPlusCustomTranslucentCoral {

	private final String name = "bluecoralblock";
	
	public CookingPlusBlueCoralBlock(){
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
        
        ret.add(new ItemStack(CookingPlusMain.blockBlueCoral, myRand.nextInt(2) + 1, 0)); //always drops at least one seed
        

        return ret;
    }
	
}
