package CookingPlus.items;

import net.minecraft.item.ItemFood;

public class CookingPlusCustomEdibleFood extends ItemFood
{

    public CookingPlusCustomEdibleFood(int parHealAmount, float parSaturationModifier)
    {
        super(parHealAmount, parSaturationModifier, false);
    }
    
    public String getName()
    {
    	return null;
    }
    
    public void setPotionEffect(int a, int b, int c, int d){
    	//this.setPotionEffect(new PotionEffect(Potion.getPotionById(a), b, c), 1);
    }
    
    

}