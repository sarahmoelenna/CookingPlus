package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleRopeCropSeed;

public class CookingPlusHopSeed extends CookingPlusCustomEdibleRopeCropSeed 
{
	private final String name = "hopseed";

    public CookingPlusHopSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockHopCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("hopseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.FOOD);
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