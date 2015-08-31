package CookingPlus.items.Seeds;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusTeaSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "teaseed";

    public CookingPlusTeaSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockTeaCrop, Blocks.farmland);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("teaseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.tabFood);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockTeaCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}