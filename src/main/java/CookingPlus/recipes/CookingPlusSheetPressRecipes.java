package CookingPlus.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class CookingPlusSheetPressRecipes 
{
    private static final CookingPlusSheetPressRecipes pressBase = new CookingPlusSheetPressRecipes();
    private final Map grindingList = Maps.newHashMap();
    private final Map sheetList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();

    //public final ArrayList<ItemStack> input = new ArrayList();
    //public final ArrayList<ItemStack> output = new ArrayList();
    public final ArrayList<ItemStack> recipeList = new ArrayList();
    
    public static CookingPlusSheetPressRecipes instance()
    {
        return pressBase;
    }

    public CookingPlusSheetPressRecipes()
    {

    }

    public void addSheetPressRecipe(ItemStack parItemStackIn, ItemStack parItemStackSheetIn, ItemStack parItemStackOut, float parExperience)
    {
    	//input.add(parItemStackIn);
    	//input.add(parItemStackSheetIn);
    	//output.add(parItemStackOut);
    	
    	recipeList.add(parItemStackIn);
    	recipeList.add(parItemStackSheetIn);
    	recipeList.add(parItemStackOut);
    	
        grindingList.put(parItemStackIn, parItemStackOut);
        sheetList.put(parItemStackOut, parItemStackSheetIn);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }

    /**
     * Returns the grinding result of an item.
     */
    public ItemStack getPressSheetResult(ItemStack parItemStack)
    {
        Iterator iterator = grindingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    public ItemStack getPressSheetItem(ItemStack parItemStack)
    {
        Iterator iterator = sheetList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean areItemStacksEqual(ItemStack parItemStack1, ItemStack parItemStack2)
    {
    	if(parItemStack1 == null || parItemStack2 == null){
    		return false;
    	}
        return parItemStack2.getItem().equals(parItemStack1.getItem());
    }

    public Map getGrindingList()
    {
        return grindingList;
    }

    public boolean[] getAppropriateSlot(Item myItem){
    	boolean[] mySlotUseage = new boolean[3];
    	mySlotUseage[0] = false;
    	mySlotUseage[1] = false;
    	mySlotUseage[2] = false;
    	for (int i = 0; i < CookingPlusSheetPressRecipes.instance().recipeList.size(); i += 3) {
    		if(myItem == CookingPlusSheetPressRecipes.instance().recipeList.get(i).getItem()){
    			mySlotUseage[1] = true;
    		}
    		if(myItem == CookingPlusSheetPressRecipes.instance().recipeList.get(i + 1).getItem()){
    			mySlotUseage[0] = true;
    		}
    		if(myItem == CookingPlusSheetPressRecipes.instance().recipeList.get(i + 2).getItem()){
    			mySlotUseage[2] = true;
    		}
    	}
    	
    	return mySlotUseage;
    }
    
    public float getGrindingExperience(ItemStack parItemStack)
    {
        Iterator iterator = experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, 
              (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}