package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;

public class CookingPlusMintPlant extends CookingPlusCustomSpreadingHerb {

	private final String name = "mint";
	
	public CookingPlusMintPlant() {
		super();
		this.setUnlocalizedName("mint");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetHarvestItem(){
		return CookingPlusMain.mintleaf;
	}
	
	@Override
	protected Block GetHerbItem(){
		return CookingPlusMain.blockMint;
	}
}
