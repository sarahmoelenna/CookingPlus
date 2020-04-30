package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleRopeCropSeed;

public class CookingPlusVanillaSeed extends CookingPlusCustomEdibleRopeCropSeed 
{
	private final String name = "vanillaseed";

    public CookingPlusVanillaSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockVanillaCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("vanillaseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.FOOD);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockVanillaCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}