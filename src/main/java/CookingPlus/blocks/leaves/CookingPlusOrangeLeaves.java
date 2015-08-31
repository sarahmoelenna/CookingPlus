package CookingPlus.blocks.leaves;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusOrangeLeaves extends CookingPlusCustomLeaves {

	private final String name = "orangeleaves";
	
	public CookingPlusOrangeLeaves() {
		super("orangeleaves");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getFruit(){
		return CookingPlusMain.orange;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockOrangeSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockOrangeLeaves;
	}

	@Override
	public String getName()
	{
		return name;
	}
}
