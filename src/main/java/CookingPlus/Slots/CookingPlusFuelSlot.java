package CookingPlus.Slots;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CookingPlusFuelSlot extends Slot {

	public CookingPlusFuelSlot(IInventory p_i1824_1_, int p_i1824_2_,int p_i1824_3_, int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	 public boolean isItemValid(ItemStack stack)
	 {
		 	if(stack.getItem().equals(Item.getItemFromBlock(Blocks.log))){
				return true;
			}
		 	else if(stack.getItem().equals(Item.getItemFromBlock(Blocks.log2))){
				return true;
			}
		 	else if(stack.getItem().equals(Item.getItemFromBlock(Blocks.planks))){
				return true;
			}
		 	else if(stack.getItem().equals(Items.coal)){
				return true;
			}
		 	else return false;
	 }

}
