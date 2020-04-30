package CookingPlus.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class InscriptionRecipeHelper 
{
    private static final InscriptionRecipeHelper inscriptionBase = new InscriptionRecipeHelper();
    
    public final ArrayList<ItemStack> recipeList = new ArrayList();

    public static InscriptionRecipeHelper instance()
    {
        return inscriptionBase;
    }

    public InscriptionRecipeHelper()
    {
   
    }

    public void addInscriptionRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut)
    {
    	recipeList.add(parItemStackIn);
    	recipeList.add(parItemStackOut);
    }

    public boolean isItemValidInput(ItemStack parItemStack){
    	if(parItemStack != null){
    	 for(int i = 0; i < recipeList.size(); i += 2){
      	   if(recipeList.get(i).getItem() == parItemStack.getItem()){
      		   return true;
      	   }
         }
    	}
    	 
    	 return false;
    }
    
    public ItemStack getInscriptionResult(ItemStack parItemStack)
    {
       for(int i = 0; i < recipeList.size(); i += 2){
    	   if(recipeList.get(i).getItem() == parItemStack.getItem()){
    		   return new ItemStack(recipeList.get(i + 1).getItem());
    	   }
       }
       return null;
    }

    private boolean areItemStacksEqual(ItemStack parItemStack1, ItemStack parItemStack2)
    {
    	if(parItemStack1 == null || parItemStack2 == null){
    		return false;
    	}
        return parItemStack2.getItem().equals(parItemStack1.getItem());
    }

    public ArrayList<ItemStack> getInscriptionList()
    {
        return recipeList;
    }

    
}