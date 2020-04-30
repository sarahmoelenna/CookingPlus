package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class CookingPlusPineappleSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "pineappleseed";

    public CookingPlusPineappleSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockPineappleCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockPineappleCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}