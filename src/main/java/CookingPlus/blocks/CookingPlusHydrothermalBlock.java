package CookingPlus.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class CookingPlusHydrothermalBlock extends CookingPlusCustomBlock{

	private final String name = "hydrothermalvein";
	
	public CookingPlusHydrothermalBlock() {
		super(Material.sand);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("hydrothermalvein");
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel("shovel", 0);
		this.setStepSound(soundTypeGravel);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		int which = random.nextInt(100);
	    if(which > 97){
	    	return Items.diamond;
	    }
	    else if(which > 77 && which <= 97){
	    	return Items.redstone;
	    }
	    else{
	    	if(random.nextInt(2) == 0){
	    		return Items.coal;
	    	}
	    	else{
	    		return Items.flint;
	    	}
	    }
	}
	
	@Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
    {
    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
        ret.clear();
        Random myRand = new Random();
        
        ret.add(new ItemStack(getItemDropped(myState, myRand, fortune), myRand.nextInt(2) + 1, 0)); //always drops at least one seed
        

        return ret;
    }
	
	@Override
	public String getName()
	{
		return name;
	}
	

}
