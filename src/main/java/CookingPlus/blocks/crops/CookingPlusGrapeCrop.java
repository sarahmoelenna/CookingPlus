package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;

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
	public Item GetCropItem(){
		return CookingPlusMain.grape;
	}
	
	@Override
	protected Block GetCropBlock(){
    	return CookingPlusMain.blockGrapeCrop;
    }
	
	@Override
	public Item GetSeedItem(){
		return CookingPlusMain.grapeseed;
	}

}
