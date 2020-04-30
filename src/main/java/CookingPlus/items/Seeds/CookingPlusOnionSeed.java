package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class CookingPlusOnionSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "onionseed";

    public CookingPlusOnionSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockOnionCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("onionseed");
        //setTextureName("cookingplus:onionseed");
        setCreativeTab(CreativeTabs.FOOD);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockOnionCrop;
    }
}