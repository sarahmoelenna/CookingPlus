package CookingPlus.blocks.leaves;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusLemonLeaves extends CookingPlusCustomLeaves {

	private final String name = "lemonleaves";
	
	public CookingPlusLemonLeaves() {
		super("lemonleaves");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getFruit(){
		return CookingPlusMain.lemon;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockLemonSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockLemonLeaves;
	}

	@Override
	public String getName()
	{
		return name;
	}
}
