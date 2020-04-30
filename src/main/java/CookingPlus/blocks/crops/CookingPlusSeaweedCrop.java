package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomUnderwaterCrop;

public class CookingPlusSeaweedCrop extends CookingPlusCustomUnderwaterCrop{

	private final String name = "seaweed";
	
	public CookingPlusSeaweedCrop(){
		super();
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Block GetCropBlock(){
		return CookingPlusMain.blockSeaweedCrop;
	}

	public Block GetGroundBlock(){
		return Blocks.SAND;
	}
	
}
