package CookingPlus.blocks.leaves;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusLimeLeaves extends CookingPlusCustomLeaves {

	private final String name = "limeleaves";
	
	public CookingPlusLimeLeaves() {
		super("limeleaves");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getFruit(){
		return CookingPlusMain.lime;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockLimeSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockLimeLeaves;
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
