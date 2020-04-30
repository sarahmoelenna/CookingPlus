package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;

public class CookingPlusLicoricePlant extends CookingPlusCustomSpreadingHerb {

	private final String name = "licorice";
	
	public CookingPlusLicoricePlant() {
		super();
		this.setUnlocalizedName("licorice");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetHarvestItem(){
		return CookingPlusMain.licoriceleaf;
	}
	
	@Override
	protected Block GetHerbItem(){
		return CookingPlusMain.blockLicorice;
	}
}
