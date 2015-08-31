package CookingPlus.items.Seeds;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCottonSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "cottonseed";

    public CookingPlusCottonSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockCottonCrop, Blocks.farmland);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("cottonseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.tabFood);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockCottonCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}