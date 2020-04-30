package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleRopeCropSeed;

public class CookingPlusGrapeSeed extends CookingPlusCustomEdibleRopeCropSeed 
{
	private final String name = "grapeseed";

    public CookingPlusGrapeSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockGrapeCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("grapeseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.FOOD);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockGrapeCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}