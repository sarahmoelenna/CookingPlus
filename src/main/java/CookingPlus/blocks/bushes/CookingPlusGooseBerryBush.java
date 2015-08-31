package CookingPlus.blocks.bushes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomGrowingBush;

public class CookingPlusGooseBerryBush extends CookingPlusCustomGrowingBush {

	private final String name = "gooseberrybush";
	
	public CookingPlusGooseBerryBush()
    {
        // Basic block setup
		
        setUnlocalizedName("gooseberrybush");
        GameRegistry.registerBlock(this, name);
        //setBlockTextureName("cookingplus:bushleaves");
    }
	
	@Override
	public Block getBushBlock(){
    	return CookingPlusMain.blockGooseBerryBush;
    }
    
	@Override
    public Item getBushDrop(){
    	return CookingPlusMain.gooseberry;
    }
	
	@Override
	public String getName()
	{
		return name;
	}
	
}
