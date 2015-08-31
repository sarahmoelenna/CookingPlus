package CookingPlus.blocks.crops;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBuchuPlant extends CookingPlusCustomSpreadingHerb {

	private final String name = "buchu";
	
	public CookingPlusBuchuPlant() {
		super();
		this.setUnlocalizedName("buchu");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetHarvestItem(){
		return CookingPlusMain.buchuleaf;
	}
	
	@Override
	protected Block GetHerbItem(){
		return CookingPlusMain.blockBuchu;
	}
}
