package CookingPlus.blocks.leaves;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusCoconutLeaves extends CookingPlusTropicalLeaves {

	private final String name = "coconutleaves";
	
	public CookingPlusCoconutLeaves() {
		super("coconutleaves");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockCoconutSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockCoconutLeaves;
	}
	
	@Override
	public int getDecayRange(){
		return 1;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public int GetFruitChance(){
		return 101;
	}

}
