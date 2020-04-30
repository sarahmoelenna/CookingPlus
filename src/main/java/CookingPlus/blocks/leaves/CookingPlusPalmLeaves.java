package CookingPlus.blocks.leaves;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusPalmLeaves extends CookingPlusTropicalLeaves {

	private final String name = "palmleaves";
	
	public CookingPlusPalmLeaves() {
		super("palmleaves");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public int getDecayRange(){
		return 1;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockPalmSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockPalmLeaves;
	}
	
	@Override
	public String getName()
	{
		return "palmleaves";
	}
	
	@Override
	public int GetFruitChance(){
		return 101;
	}
	

}
