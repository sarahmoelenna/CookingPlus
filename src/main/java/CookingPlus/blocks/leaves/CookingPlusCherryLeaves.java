package CookingPlus.blocks.leaves;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusCherryLeaves extends CookingPlusCustomLeaves {

	private final String name = "cherryleaves";
	
	public CookingPlusCherryLeaves() {
		super("cherryleaves");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getFruit(){
		return CookingPlusMain.cherry;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockCherrySapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockCherryLeaves;
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
