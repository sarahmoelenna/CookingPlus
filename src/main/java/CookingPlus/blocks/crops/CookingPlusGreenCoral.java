package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingCoral;

public class CookingPlusGreenCoral extends CookingPlusCustomSpreadingCoral{

	private final String name = "greencoral";
	
	public CookingPlusGreenCoral(){
		super();
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Block GetCropBlock(){
		return CookingPlusMain.blockGreenCoral;
	}
	
}
