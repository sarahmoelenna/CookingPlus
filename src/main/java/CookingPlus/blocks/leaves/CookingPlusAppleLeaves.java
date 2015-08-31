package CookingPlus.blocks.leaves;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusAppleLeaves extends CookingPlusCustomLeaves {

	private final String name = "appleleaves";
	
	public CookingPlusAppleLeaves() {
		super("appleleaves");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getFruit(){
		return Items.apple;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockAppleSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockAppleLeaves;
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
