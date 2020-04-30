package CookingPlus.blocks.leaves;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusPeachLeaves extends CookingPlusCustomLeaves {

	private final String name = "peachleaves";
	
	public CookingPlusPeachLeaves() {
		super("peachleaves");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getFruit(){
		return CookingPlusMain.peach;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockPeachSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockPeachLeaves;
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
