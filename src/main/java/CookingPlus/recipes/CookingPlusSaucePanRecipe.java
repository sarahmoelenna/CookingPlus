package CookingPlus.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class CookingPlusSaucePanRecipe 
{
    private static final CookingPlusSaucePanRecipe pressBase = new CookingPlusSaucePanRecipe();
    private final Map grindingList = Maps.newHashMap();
    private final Map sheetList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();

    public static CookingPlusSaucePanRecipe instance()
    {
        return pressBase;
    }

    public CookingPlusSaucePanRecipe()
    {

    }

    public void addSaucePanRecipe(ItemStack parItemStackIn, ItemStack parItemStackSheetIn, ItemStack parItemStackOut, float parExperience)
    {
        grindingList.put(parItemStackIn, parItemStackOut);
        sheetList.put(parItemStackOut, parItemStackSheetIn);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }

    /**
     * Returns the grinding result of an item.
     */
    public ItemStack getSaucePanResult(ItemStack parItemStack)
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
    
    public ItemStack getSecondarySaucePanItem(ItemStack parItemStack)
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