package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingCoral;

public class CookingPlusWhiteCoral extends CookingPlusCustomSpreadingCoral{

	private final String name = "whitecoral";
	
	public CookingPlusWhiteCoral(){
		super();
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Block GetCropBlock(){
		return CookingPlusMain.blockWhiteCoral;
	}
	
}
