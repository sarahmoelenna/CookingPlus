package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.property.IExtendedBlockState;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;

public class CookingPlusHopsCrop extends CookingPlusCustomRopeCrop {

	private final String name = "hopcrop";
	
	public CookingPlusHopsCrop() {		
		this.setUnlocalizedName("hopcrop");
		//GameRegistry.registerBlock(this, null, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public Item GetCropItem(){
		return CookingPlusMain.hops;
	}
	
	@Override
	protected Block GetCropBlock(){
    	return CookingPlusMain.blockHopCrop;
    }
	
	@Override
	public Item GetSeedItem(){
		return CookingPlusMain.hopseed;
	}
	
	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (state instanceof IExtendedBlockState) {
			//state.withProperty(AGE, 0);
			return ((IExtendedBlockState) state).withProperty(JAI, 2);
		}
		return state;
	}

}
