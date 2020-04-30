package CookingPlus.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Slots.CookingPlusFuelSlot;

public class CookingPlusHeaterContainer extends Container {
	private final IInventory tileGrinder;
	private final int sizeInventory;
	private int ticksGrindingItemSoFar;
	private int ticksPerItem;
	private int timeCanGrind;

	public CookingPlusHeaterContainer(InventoryPlayer parInventoryPlayer,TileEntity tileEntity) {
		// DEBUG
		// System.out.println("ContainerGrinder constructor()");

		tileGrinder = (IInventory) tileEntity;
		sizeInventory = tileGrinder.getSizeInventory();
		// addSlotToContainer(new Slot(tileGrinder,
		// BrickOvenTileEntity.slotEnum.INPUT_SLOT.ordinal(), 56, 35));
		// addSlotToContainer(new SlotGrinderOutput(parInventoryPlayer.player,
		// tileGrinder, TileEntityGrinder.slotEnum.OUTPUT_SLOT.ordinal(), 116,
		// 35));

		// add player inventory slots
		// note that the slot numbers are within the player inventory so can
		// be same as the tile entity inventory
		int i;
		//for (i = 0; i < 3; i++) {
		//	for (int j = 0; j < 3; j++) {
		//		addSlotToContainer(new Slot(tileGrinder, j + i * 3, 8 + j * 18,20 + i * 18));// input 0 - 8
		//	}
		//}
		addSlotToContainer(new CookingPlusFuelSlot(tileGrinder, 0, 80, 37)); // input - 1
		//addSlotToContainer(new CookingPlusFuelSlot(tileGrinder, 1, 80, 37)); // fuel - 1
		//addSlotToContainer(new CookingPlusSingleSlot(tileGrinder, 1, 129, 37)); // output - 2

		///for (i = 0; i < 3; i++) {
		//	for (int j = 0; j < 3; j++) {
		//		addSlotToContainer(new CookingPlusOutputSlot(tileGrinder, j + i * 3 + 10,116 + j * 18, 20 + i * 18)); // output 10 - 18
		//		//System.out.println(j + i * 3 + 10);
		//	}
		//}

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

	//@Override
		//public void addCraftingToCrafters(ICrafting listener) {
		//	super.addCraftingToCrafters(listener);
		//	listener.sendContainerAndContentsToPlayer(this,
		//			this.inventoryItemStacks);
		//}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
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
	
	public boolean isitemStackFuel(ItemStack MyStack){
		if(MyStack.getItem().equals(Item.getItemFromBlock(Blocks.LOG))){
			return true;
		}
		else if(MyStack.getItem().equals(Item.getItemFromBlock(Blocks.LOG2))){
			return true;
		}
		else if(MyStack.getItem().equals(Item.getItemFromBlock(Blocks.PLANKS))){
			return true;
		}
		else if(MyStack.getItem().equals(Items.COAL)){
			return true;
		}
		else return false;
	}
}
