package CookingPlus.blocks.crops;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusRosemaryPlant extends CookingPlusCustomSpreadingHerb {

	private final String name = "rosemary";
	
	public CookingPlusRosemaryPlant() {
		super();
		this.setUnlocalizedName("rosemary");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetHarvestItem(){
		return CookingPlusMain.rosemaryleaf;
	}
	
	@Override
	protected Block GetHerbItem(){
		return CookingPlusMain.blockRosemary;
	}
}
