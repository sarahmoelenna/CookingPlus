package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class CookingPlusTeaSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "teaseed";

    public CookingPlusTeaSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockTeaCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("teaseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.FOOD);
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