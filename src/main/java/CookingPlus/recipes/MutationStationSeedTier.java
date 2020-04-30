package CookingPlus.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MutationStationSeedTier {
	
	private ArrayList<Item> seedInList = new ArrayList();
	private Item outputItem;
	private Item failItem;
	private int SuccessChance;
	
	public MutationStationSeedTier(Item outputSeed, Item failSeed, int chance){
		outputItem = outputSeed;
		failItem = failSeed;
		SuccessChance = chance;
	}
	
	public ArrayList getSeedInList(){
		return seedInList;
	}
	
	public boolean doesContainSeed(Item checkSeed){
		return seedInList.contains(checkSeed);
	}
	
	public Item getOutputSeed(){
		return outputItem;
	}
	
	public Item getFailSeed(){
		return failItem;
	}
	
	public int getSuccessChance(){
		return SuccessChance;
	}
	
	public void addInputSeed(Item myItem){
		seedInList.add(myItem);
	}
	
	public List<ItemStack> getListForJEI(){
		List<ItemStack> mySingleRecipe = new ArrayList();
		for(int i = 0; i < seedInList.size(); i++){
			mySingleRecipe.add(new ItemStack(seedInList.get(i)));
		}
		mySingleRecipe.add(new ItemStack(outputItem));
		return mySingleRecipe;
	}
}
