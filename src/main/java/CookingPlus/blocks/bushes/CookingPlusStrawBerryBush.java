package CookingPlus.blocks.bushes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomGrowingBush;

public class CookingPlusStrawBerryBush extends CookingPlusCustomGrowingBush {

	private final String name = "strawberrybush";
	
	public CookingPlusStrawBerryBush()
    {
        // Basic block setup
		
        setUnlocalizedName("strawberrybush");
        GameRegistry.registerBlock(this, name);
        //setBlockTextureName("cookingplus:bushleaves");
    }
	
	@Override
	public Block getBushBlock(){
    	return CookingPlusMain.blockStrawBerryBush;
    }
    
	@Override
    public Item getBushDrop(){
    	return CookingPlusMain.strawberry;
    }
	
	@Override
	public String getName()
	{
		return name;
	}
	
}
