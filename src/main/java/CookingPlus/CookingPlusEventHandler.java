package CookingPlus;

import java.util.Random;

import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusEventHandler {

	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++)
			if (event.craftMatrix.getStackInSlot(i) != null) {
				
				ItemStack j = event.craftMatrix.getStackInSlot(i);
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.pestle)) {
					ItemStack k = new ItemStack(CookingPlusMain.pestle, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.knife)) {
					ItemStack k = new ItemStack(CookingPlusMain.knife, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.juicerguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.juicerguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.juicer)) {
					ItemStack k = new ItemStack(CookingPlusMain.juicer, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.mugguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.mugguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.sphereguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.sphereguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.chipguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.chipguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.teapotguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.teapotguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.plateguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.plateguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.cookiebatter)) {
					ItemStack k = new ItemStack(Items.BOWL, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.vanillabuttercream)) {
					ItemStack k = new ItemStack(Items.BOWL, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.fryingpanguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.fryingpanguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.saucepanguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.saucepanguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.breadtinguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.breadtinguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.caketinguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.caketinguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.mooncutter)) {
					ItemStack k = new ItemStack(CookingPlusMain.mooncutter, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.circlecutter)) {
					ItemStack k = new ItemStack(CookingPlusMain.circlecutter, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.heartcutter)) {
					ItemStack k = new ItemStack(CookingPlusMain.heartcutter, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.starcutter)) {
					ItemStack k = new ItemStack(CookingPlusMain.starcutter, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.vegetableoil)) {
					ItemStack k = new ItemStack(Items.GLASS_BOTTLE, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.lemonjuice)) {
					ItemStack k = new ItemStack(Items.GLASS_BOTTLE, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.vinegar)) {
					ItemStack k = new ItemStack(Items.GLASS_BOTTLE, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.vanillaessence)) {
					ItemStack k = new ItemStack(Items.GLASS_BOTTLE, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.mintessence)) {
					ItemStack k = new ItemStack(Items.GLASS_BOTTLE, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.strawberryjuice)) {
					ItemStack k = new ItemStack(Items.GLASS_BOTTLE, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.creambucket)) {
					ItemStack k = new ItemStack(Items.BUCKET, 1);
					if(!event.player.inventory.addItemStackToInventory(k)){
						event.player.dropItem(k, false);
					}
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.cuptrayguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.cuptrayguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem().equals(CookingPlusMain.largecuptrayguide)) {
					ItemStack k = new ItemStack(CookingPlusMain.largecuptrayguide, 2);
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				
				
			}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) 
	{
	    ///entityLiving in fact refers to EntityLivingBase so to understand everything about this part go to EntityLivingBase instead
	    if (event.getEntityLiving().isPotionActive(Potion.getPotionById(32)))
	    {
	    	 if(event.getEntityLiving() instanceof EntityPlayer){
	    		 
	    		 ((EntityPlayer)event.getEntityLiving()).getFoodStats().setFoodSaturationLevel(20);
	    		 ((EntityPlayer)event.getEntityLiving()).removePotionEffect(Potion.getPotionById(32));
	    	 }
	    }
	}
	
	 @SubscribeEvent
	 public void onDrops(BlockEvent.HarvestDropsEvent event) {
		 if(CookingPlusConfig.addSeedsToGrassLoot){
		 Random myRand = new Random();
		 //System.out.println("A");
			if(event.getState().getBlock() == Blocks.TALLGRASS){
				//System.out.println("B");
				if(event.getDrops().size() == 0){
					//System.out.println("C");
					if(myRand.nextInt(10) == 1){
						//System.out.println("D");
						event.getDrops().add(new ItemStack(CookingPlusLootHelper.instance().GetRandomSeed(myRand), 1));
					}
				}
		 	}
		 }
	 }
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event)
	{
		 if ((event.getEntity() instanceof EntitySquid))
		 {
			 if (!event.getEntity().worldObj.isRemote)
			 {
				 //if(event.entity == true){
					 event.getEntity().dropItem(CookingPlusMain.rawsquid, event.getEntity().worldObj.rand.nextInt(3) + 1);
				 //}
			 }
		 }
	}
}
