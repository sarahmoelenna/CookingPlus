package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusWine extends CookingPlusCustomJuice
{

	private final String name = "wine";
	
    public CookingPlusWine() 
    {
        super(6, 4F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("wine");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 100, 10, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
    
    @Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn,EntityPlayer playerIn) {
    	PotionEffect myNausea = new PotionEffect(Potion.confusion.getId(), 100, 10);
    	Potion.confusion.getId();
		playerIn.addPotionEffect(myNausea);
		return super.onItemUseFinish(stack, worldIn, playerIn);
		//return null;
	}
}