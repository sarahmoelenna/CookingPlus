package CookingPlus.blocks.leaves;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusEasyLeaf extends CookingPlusCustomLeaves {

	private String name;
	private Block leafBlock;
	private Block saplingBlock;
	private Item fruitItem;
	
	public CookingPlusEasyLeaf(String myName) {
		super(myName);
		name = myName;
		GameRegistry.registerBlock(this, name);
	}
	
	public void SetDrops(Block myLeaf, Block mySapling, Item myFruit){
		leafBlock = myLeaf;
		saplingBlock = mySapling;
		fruitItem = myFruit;
	}
	
	@Override
	public Item getFruit(){
		return fruitItem;
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(saplingBlock);
	}
	
	@Override
	public Block getLeaves(){
		return leafBlock;
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
