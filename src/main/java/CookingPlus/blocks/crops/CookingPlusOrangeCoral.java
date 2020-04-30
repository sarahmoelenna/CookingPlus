package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingCoral;

public class CookingPlusOrangeCoral extends CookingPlusCustomSpreadingCoral{

	private final String name = "orangecoral";
	
	public CookingPlusOrangeCoral(){
		super();
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Block GetCropBlock(){
		return CookingPlusMain.blockOrangeCoral;
	}
	
}
