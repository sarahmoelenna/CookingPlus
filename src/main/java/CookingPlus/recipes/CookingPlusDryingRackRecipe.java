package CookingPlus.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class CookingPlusDryingRackRecipe 
{
    private static final CookingPlusDryingRackRecipe dryingrackBase = new CookingPlusDryingRackRecipe();
    /** The list of grinding results. */
    private final Map grindingList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();
    
    public final ArrayList<ItemStack> recipeList = new ArrayList();

    public static CookingPlusDryingRackRecipe instance()
    {
        return dryingrackBase;
    }

    public CookingPlusDryingRackRecipe()
    {
   
    }

    public void addDryingRackRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, float parExperience)
    {
    	recipeList.add(parItemStackIn);
    	recipeList.add(parItemStackOut);
    	
        grindingList.put(parItemStackIn, parItemStackOut);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }

    /**
     * Returns the grinding result of an item.
     */
    public ItemStack getDryingRackResult(ItemStack parItemStack)
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