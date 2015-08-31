package CookingPlus.items.Seeds;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleRopeCropSeed;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusHopSeed extends CookingPlusCustomEdibleRopeCropSeed 
{
	private final String name = "hopseed";

    public CookingPlusHopSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockHopCrop, Blocks.farmland);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("hopseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.tabFood);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockHopCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}