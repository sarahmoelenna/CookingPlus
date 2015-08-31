package CookingPlus.blocks.crops;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSagePlant extends CookingPlusCustomSpreadingHerb {

	private final String name = "sage";
	
	public CookingPlusSagePlant() {
		super();
		this.setUnlocalizedName("sage");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetHarvestItem(){
		return CookingPlusMain.sageleaf;
	}
	
	@Override
	protected Block GetHerbItem(){
		return CookingPlusMain.blockSage;
	}
}
