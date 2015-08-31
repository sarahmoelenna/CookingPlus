package CookingPlus.blocks.bushes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomGrowingBush;

public class CookingPlusBlueBerryBush extends CookingPlusCustomGrowingBush {

	private final String name = "blueberrybush";
	
	public CookingPlusBlueBerryBush()
    {
        // Basic block setup
		
        setUnlocalizedName("blueberrybush");
        GameRegistry.registerBlock(this, name);
        //setBlockTextureName("cookingplus:bushleaves");
    }
	
	@Override
	public Block getBushBlock(){
    	return CookingPlusMain.blockBlueBerryBush;
    }
    
	@Override
    public Item getBushDrop(){
    	return CookingPlusMain.blueberry;
    }
	
	@Override
	public String getName()
	{
		return name;
	}
	
}
