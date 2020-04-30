package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;

public class CookingPlusChamomilePlant extends CookingPlusCustomSpreadingHerb {

	private final String name = "chamomile";
	
	public CookingPlusChamomilePlant() {
		super();
		this.setUnlocalizedName("chamomile");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetHarvestItem(){
		return CookingPlusMain.chamomileflower;
	}
	
	@Override
	protected Block GetHerbItem(){
		return CookingPlusMain.blockChamomile;
	}
}
