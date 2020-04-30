package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;

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
