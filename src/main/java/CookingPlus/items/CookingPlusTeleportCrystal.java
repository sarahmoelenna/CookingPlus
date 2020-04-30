package CookingPlus.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import CookingPlus.CookingPlusGenericHelper;
import CookingPlus.CookingPlusMain;

public class CookingPlusTeleportCrystal extends CookingPlusSingleStackItem {

	public CookingPlusTeleportCrystal() {
		super("teleportcrystal");
	}
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		NBTTagCompound myTag = new NBTTagCompound();
		myTag.setInteger("CrystalX", 0);
		myTag.setInteger("CrystalY", -5);
		myTag.setInteger("CrystalZ", 0);
	    itemStack.setTagCompound(myTag);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		ProcessTeleport(false, itemStackIn, null, playerIn);
		return new ActionResult(EnumActionResult.PASS, itemStackIn);
		
	}
	
	public void ProcessTeleport(boolean Type, ItemStack myStack, BlockPos myPos, EntityPlayer myPlayer){
		
		if(myStack.hasTagCompound() == false){
			NBTTagCompound myTag = new NBTTagCompound();
			myStack.setTagCompound(myTag);
			myStack.getTagCompound().setInteger("CrystalX", 0);
			myStack.getTagCompound().setInteger("CrystalY", -5);
			myStack.getTagCompound().setInteger("CrystalZ", 0);
		}

		if(Type == true){
			myStack.getTagCompound().setInteger("CrystalX", myPos.getX());
			myStack.getTagCompound().setInteger("CrystalY", myPos.getY());
			myStack.getTagCompound().setInteger("CrystalZ", myPos.getZ());
			myPlayer.addChatMessage(new TextComponentTranslation("msg.teleportbound.txt"));
		}
		else{
			NBTTagCompound myTag = myStack.getTagCompound();
			BlockPos myCrystalPos = new BlockPos(myTag.getInteger("CrystalX"), myTag.getInteger("CrystalY"), myTag.getInteger("CrystalZ"));
			if(myCrystalPos.getY() != -5){
				if(myPlayer.getEntityWorld().getBlockState(myCrystalPos).getBlock() == CookingPlusMain.blockSkyCrystal){
					BlockPos TeleportPos = CookingPlusGenericHelper.instance().NearestPlayerSafeSpot(myCrystalPos, myPlayer.getEntityWorld());
					if(TeleportPos != null){
						myPlayer.setPositionAndUpdate(TeleportPos.getX() + 0.5f, TeleportPos.getY(), TeleportPos.getZ() + 0.5f);
					}
					else{
						myPlayer.addChatMessage(new TextComponentTranslation("msg.teleportobstructed.txt"));
					}
				}
				else{
					myPlayer.addChatMessage(new TextComponentTranslation("msg.teleportmissing.txt"));
				}
			}
			else{
				myPlayer.addChatMessage(new TextComponentTranslation("msg.teleportunbound.txt"));
			}
		}

	}

}
