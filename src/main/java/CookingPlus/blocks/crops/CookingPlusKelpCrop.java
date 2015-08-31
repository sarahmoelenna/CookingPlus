package CookingPlus.blocks.crops;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomUnderwaterCrop;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusKelpCrop extends CookingPlusCustomUnderwaterCrop{

	private final String name = "kelp";
	
	public CookingPlusKelpCrop(){
		super();
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Block GetCropBlock(){
		return CookingPlusMain.blockKelpCrop;
	}

	public Block GetGroundBlock(){
		return Blocks.sand;
	}
	
}
