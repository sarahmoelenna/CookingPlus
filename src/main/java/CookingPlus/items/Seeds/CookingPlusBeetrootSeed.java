package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class CookingPlusBeetrootSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "beetrootseed";

    public CookingPlusBeetrootSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockBeetrootCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("beetrootseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.FOOD);
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