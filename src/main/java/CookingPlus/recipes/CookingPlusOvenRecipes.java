package CookingPlus.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import CookingPlus.CookingPlusConfig;

import com.google.common.collect.Maps;



public class CookingPlusOvenRecipes 
{
    private static final CookingPlusOvenRecipes ovenBase = new CookingPlusOvenRecipes();
    /** The list of grinding results. */
    private final Map grindingList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();

    public final ArrayList<ItemStack> recipeList = new ArrayList();
    
    public final ArrayList<String> whiteListedUnlocalisedName = new ArrayList();
    public final ArrayList<String> whiteListedOreDictionary = new ArrayList();
    
    public static CookingPlusOvenRecipes instance()
    {
        return ovenBase;
    }

    public CookingPlusOvenRecipes()
    {
    	//System.out.println("rawr");
        addOvenRecipe(new ItemStack(Items.PORKCHOP), new ItemStack(Items.COOKED_PORKCHOP), 0.7F);
        addOvenRecipe(new ItemStack(Items.BEEF), new ItemStack(Items.COOKED_BEEF), 0.7F);
        addOvenRecipe(new ItemStack(Items.FISH), new ItemStack(Items.COOKED_FISH), 0.7F);
        addOvenRecipe(new ItemStack(Items.CHICKEN), new ItemStack(Items.COOKED_CHICKEN), 0.7F);
        addOvenRecipe(new ItemStack(Items.POTATO), new ItemStack(Items.BAKED_POTATO), 0.7F);
        addOvenRecipe(new ItemStack(Items.MUTTON), new ItemStack(Items.COOKED_MUTTON), 0.7f);
        addOvenRecipe(new ItemStack(Items.RABBIT), new ItemStack(Items.COOKED_RABBIT), 0.7f);
        //addOvenRecipe(new ItemStack(CookingPlusMain.rawprawn), new ItemStack(CookingPlusMain.cookedprawn), 0.7F);
    }
    
    public void switchModFoodFurnaceRecipestoBrickOven(){
    	Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
    	for (Iterator<Map.Entry<ItemStack,ItemStack>> entries = recipes.entrySet().iterator(); entries.hasNext(); ){
    		
    		Map.Entry<ItemStack,ItemStack> entry = entries.next();
    		ItemStack result = entry.getValue();
    		ItemStack input = entry.getKey();
    		
    		if(CookingPlusConfig.enableBrickOvenRecipeTransferDebug == true){
    			System.out.println("output item unlocalised name " + result.getItem().getUnlocalizedName());
    			System.out.println("input item unlocalised name " + input.getItem().getUnlocalizedName());
    		
    			System.out.println("output item ore dictionary name " + OreDictionary.getOreName(result.getItem().getIdFromItem(result.getItem())));
    			System.out.println("input item ore dictionary name " + OreDictionary.getOreName(input.getItem().getIdFromItem(input.getItem())));
    		}
    		if(result.getItem() instanceof ItemFood 
    				|| input.getItem() instanceof IPlantable 
    				|| input.getItem() instanceof ItemFood 
    				|| whiteListedUnlocalisedName.contains(result.getUnlocalizedName()) 
    				|| whiteListedOreDictionary.contains(OreDictionary.getOreName(result.getItem().getIdFromItem(result.getItem())))){
    			
    			entries.remove();
    			this.addOvenRecipe(input, result, 0.7f);
    		}
    		
    	}
    }

    public void addOvenRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, float parExperience)
    {
    	
    	recipeList.add(parItemStackIn);
    	recipeList.add(parItemStackOut);
    	
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

    public boolean isItemInput(ItemStack myItemStack){
    	Item myItem = myItemStack.getItem();
    	for (int i = 0; i < CookingPlusOvenRecipes.instance().recipeList.size(); i += 2) {
    		if(myItem == CookingPlusOvenRecipes.instance().recipeList.get(i).getItem()){
    			return true;
    		}
    	}
    	return false;
    }
    
}