package CookingPlus.items.Seeds;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class CookingPlusChilliSeed extends CookingPlusCustomEdibleSeed 
{
	private final String name = "chilliseed";

    public CookingPlusChilliSeed() 
    {
        super(1, 0.3F, CookingPlusMain.blockChilliCrop, Blocks.FARMLAND);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("chilliseed");
        //setTextureName("cookingplus:chilliseed");
        setCreativeTab(CreativeTabs.FOOD);
    }
    
    public Block GetCropBlock(){
		return CookingPlusMain.blockChilliCrop;
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}