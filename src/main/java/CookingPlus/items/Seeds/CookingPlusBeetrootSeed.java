package CookingPlus.items.Seeds;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBeetrootSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "beetrootseed";

    public CookingPlusBeetrootSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockBeetrootCrop, Blocks.farmland);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("beetrootseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.tabFood);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockBeetrootCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}