package CookingPlus.Slots;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CookingPlusOutputSlot extends Slot {

	public CookingPlusOutputSlot(IInventory p_i1824_1_, int p_i1824_2_,int p_i1824_3_, int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	 public boolean isItemValid(ItemStack stack)
	 {
		 	return false;
	 }

}
