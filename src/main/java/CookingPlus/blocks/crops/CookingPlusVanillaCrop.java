package CookingPlus.blocks.crops;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusVanillaCrop extends CookingPlusCustomRopeCrop {

	private final String name = "vanillacrop";
	
	public CookingPlusVanillaCrop() {		
		this.setUnlocalizedName("vanillacrop");
		//GameRegistry.registerBlock(this, null, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetCropItem(){
		return CookingPlusMain.vanillapod;
	}
	
	@Override
	protected Block GetCropBlock(){
    	return CookingPlusMain.blockVanillaCrop;
    }
	
	@Override
	protected Item GetSeedItem(){
		return CookingPlusMain.vanillaseed;
	}
	
	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (state instanceof IExtendedBlockState) {
			//state.withProperty(AGE, 0);
			return ((IExtendedBlockState) state).withProperty(JAI, 3);
		}
		return state;
	}

}
