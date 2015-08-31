package CookingPlus.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;



public class CookingPlusOvenRecipes 
{
    private static final CookingPlusOvenRecipes ovenBase = new CookingPlusOvenRecipes();
    /** The list of grinding results. */
    private final Map grindingList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();

    public static CookingPlusOvenRecipes instance()
    {
        return ovenBase;
    }

    public CookingPlusOvenRecipes()
    {
    	//System.out.println("rawr");
        addOvenRecipe(new ItemStack(Items.porkchop), new ItemStack(Items.cooked_porkchop), 0.7F);
        addOvenRecipe(new ItemStack(Items.beef), new ItemStack(Items.cooked_beef), 0.7F);
        addOvenRecipe(new ItemStack(Items.fish), new ItemStack(Items.cooked_fish), 0.7F);
        addOvenRecipe(new ItemStack(Items.chicken), new ItemStack(Items.cooked_chicken), 0.7F);
        addOvenRecipe(new ItemStack(Items.potato), new ItemStack(Items.baked_potato), 0.7F);
        addOvenRecipe(new ItemStack(Items.mutton), new ItemStack(Items.cooked_mutton), 0.7f);
        addOvenRecipe(new ItemStack(Items.rabbit), new ItemStack(Items.cooked_rabbit), 0.7f);
        //addOvenRecipe(new ItemStack(CookingPlusMain.rawprawn), new ItemStack(CookingPlusMain.cookedprawn), 0.7F);
    }

    public void addOvenRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, float parExperience)
    {
        grindingList.put(parItemStackIn, parItemStackOut);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }

    /**
     * Returns the grinding result of an item.
     */
    public ItemStack getOvenResult(ItemStack parItemStack)
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