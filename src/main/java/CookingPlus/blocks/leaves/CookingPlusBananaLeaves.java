package CookingPlus.blocks.leaves;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusBananaLeaves extends CookingPlusTropicalLeaves {

	private final String name = "bananaleaves";
	
	public CookingPlusBananaLeaves() {
		super("bananaleaves");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockBananaSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockBananaLeaves;
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
	
	@Override
	public int getDecayRange(){
		return 1;
	}

}
