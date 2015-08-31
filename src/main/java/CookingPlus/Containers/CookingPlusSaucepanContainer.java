package CookingPlus.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Slots.CookingPlusFuelSlot;
import CookingPlus.Slots.CookingPlusOutputSlot;
import CookingPlus.Slots.CookingPlusSingleSlot;

public class CookingPlusSaucepanContainer extends Container {
	private final IInventory tileGrinder;
	private final int sizeInventory;
	private int ticksGrindingItemSoFar;
	private int ticksPerItem;
	private int timeCanGrind;

	public CookingPlusSaucepanContainer(InventoryPlayer parInventoryPlayer,TileEntity tileEntity) {
		// DEBUG
		// System.out.println("ContainerGrinder constructor()");

		tileGrinder = (IInventory) tileEntity;
		sizeInventory = tileGrinder.getSizeInventory();
		
		int i;
		
		addSlotToContainer(new Slot(tileGrinder, 0, 33, 37)); // input - 1 food
		
		addSlotToContainer(new CookingPlusSingleSlot(tileGrinder, 1, 33, 58)); // input - 2 water
		
		addSlotToContainer(new CookingPlusOutputSlot(tileGrinder, 2, 129, 37)); // output - 3



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
	public void addCraftingToCrafters(ICrafting listener) {
		super.addCraftingToCrafters(listener);
		listener.sendContainerAndContentsToPlayer(this,
				this.inventoryItemStacks);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) crafters.get(i);

		}

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
			//System.out.println(slotIndex);
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
				// try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
					//if (!this.mergeItemStack(itemstack1, 0, 1, false)) {//input
						return null;
					//}
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
