package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class CookingPlusCottonSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "cottonseed";

    public CookingPlusCottonSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockCottonCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("cottonseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.FOOD);
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