package CookingPlus.items.Seeds;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusOnionSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "onionseed";

    public CookingPlusOnionSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockOnionCrop, Blocks.farmland);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("onionseed");
        //setTextureName("cookingplus:onionseed");
        setCreativeTab(CreativeTabs.tabFood);
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