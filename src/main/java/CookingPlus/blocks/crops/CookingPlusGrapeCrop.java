package CookingPlus.blocks.crops;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusGrapeCrop extends CookingPlusCustomRopeCrop {

	private final String name = "grapecrop";
	
	public CookingPlusGrapeCrop() {		
		this.setUnlocalizedName("grapecrop");
		//GameRegistry.registerBlock(this, null, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	protected Item GetCropItem(){
		return CookingPlusMain.grape;
	}
	
	@Override
	protected Block GetCropBlock(){
    	return CookingPlusMain.blockGrapeCrop;
    }
	
	@Override
	protected Item GetSeedItem(){
		return CookingPlusMain.grapeseed;
	}

}
