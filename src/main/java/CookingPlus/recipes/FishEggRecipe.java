package CookingPlus.recipes;

import net.minecraft.item.Item;

public class FishEggRecipe {

	protected Item myFish;
	protected Item myEgg;
	
	public FishEggRecipe(Item fish, Item egg){
		myFish = fish;
		myEgg = egg;
	}
	
	public Item getFish(){
		return myFish;
	}
	
	public Item getEgg(){
		return myEgg;
	}
	
}
