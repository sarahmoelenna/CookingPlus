package CookingPlus.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Slots.CookingPlusSingleSlot;

public class CookingPlusResearchContainer extends Container {
	private final IInventory tileGrinder;
	private final int sizeInventory;
	private int ticksGrindingItemSoFar;
	private int ticksPerItem;
	private int timeCanGrind;

	public CookingPlusResearchContainer(InventoryPlayer parInventoryPlayer,TileEntity tileEntity) {
		// DEBUG

		tileGrinder = (IInventory) tileEntity;
		sizeInventory = tileGrinder.getSizeInventory();
		
		int i;
		addSlotToContainer(new CookingPlusSingleSlot(tileGrinder, 0, 80, 35)); // input - 1
		
		

		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(parInventoryPlayer, j + i * 9 + 9,8 + j * 18, 84 + i * 18));
			}
		}

		// add hotbar slots
		for (i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(parInventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		// tileGrinder.setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileGrinder.isUseableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex) {
		ItemStack itemstack = null;
		Slot slotObject = (Slot) inventorySlots.get(slotIndex);

		if (slotObject != null && slotObject.getHasStack()) {

			ItemStack itemstack1 = slotObject.getStack();
			itemstack = itemstack1.copy();
			ItemStack mySingleItemStack = itemstack1.copy();
			mySingleItemStack.stackSize = 1;
			if (slotIndex < tileGrinder.getSizeInventory()) { //merge into inventory
				// try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
				// so the last slot in the inventory won't get checked if you don't add 1
				if (!this.mergeItemStack(itemstack1,tileGrinder.getSizeInventory(),tileGrinder.getSizeInventory() + 36, true)) {
					return null;
				}
				slotObject.onSlotChange(itemstack1, itemstack);
			}
			// itemstack is in player inventory, try to place in appropriate input slot
			else if (slotIndex >= tileGrinder.getSizeInventory()) {
					/*boolean[] mySlot = CookingPlusSheetPressRecipes.instance().getAppropriateSlot(mySingleItemStack.getItem());
					if(mySlot[0] == true || mySlot[1] == true){
						if(mySlot[0] == true && tileGrinder.getStackInSlot(0) == null){
							if (!this.mergeItemStack(mySingleItemStack, 0, 1, false)) {//input 1
								if(mySlot[1] == true && tileGrinder.getStackInSlot(1) == null){
									if (!this.mergeItemStack(mySingleItemStack, 1, 2, false)) {//input 2
										return null;
									}
									else{
										itemstack1.stackSize = itemstack1.stackSize - 1;
									}
								}
								else{
									return null;
								}
							}
							else{
								itemstack1.stackSize = itemstack1.stackSize - 1;
							}
						}
						if(mySlot[1] == true && tileGrinder.getStackInSlot(1) == null){
							if (!this.mergeItemStack(mySingleItemStack, 1, 2, false)) {//input 2
								if(mySlot[0] == true && tileGrinder.getStackInSlot(0) == null){
									if (!this.mergeItemStack(mySingleItemStack, 0, 1, false)) {//input 1
										return null;
									}
									else{
										itemstack1.stackSize = itemstack1.stackSize - 1;
									}
								}
								else{
									return null;
								}
							}
							else{
								itemstack1.stackSize = itemstack1.stackSize - 1;
							}
						}
					}
					else{
						return null;
					}*/
					return null;
			}
			if (itemstack1.stackSize == 0) {
				slotObject.putStack((ItemStack) null);
			} else {
				slotObject.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slotObject.onPickupFromSlot(playerIn, itemstack1);

		}
		return itemstack;
	}
	
}
