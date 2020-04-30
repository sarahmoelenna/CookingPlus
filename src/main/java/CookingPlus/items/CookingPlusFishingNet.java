package CookingPlus.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class CookingPlusFishingNet extends CookingPlusCustomItem {

	private final String name = "fnet";
	
	public CookingPlusFishingNet(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("fishingnet");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":fishingnet");
		setNoRepair();
		this.setMaxDamage(20);
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack parStack, World parWorld, EntityPlayer parPlayer, EnumHand hand)
	{
		parPlayer.swingArm(hand);
		if(parPlayer.isSwingInProgress == true){
	    Vec3d Vec3d = new Vec3d(parPlayer.getPosition().getX(), parPlayer.getPosition().getY() + 1.62f, parPlayer.getPosition().getZ());
	    
	    //Vec3d.xCoord = parPlayer.getPosition().getX();
	    //Vec3d.yCoord = parPlayer.getPosition().getY() + 1.62f;
	    //Vec3d.zCoord = parPlayer.getPosition().getZ();

	    Vec3d Vec3d1 = parPlayer.getLook(1.0F);

	    Vec3d Vec3d2 = Vec3d.addVector(Vec3d1.xCoord * 5, Vec3d1.yCoord * 5, Vec3d1.zCoord * 5);

	    RayTraceResult look = parWorld.rayTraceBlocks(Vec3d, Vec3d2, true);
	    if(look != null){
	    //if(parWorld.blockExists(look.blockX, look.blockY, look.blockZ) == true){
	    	Block blockAt = parWorld.getBlockState(look.getBlockPos()).getBlock();
	    
	    	if (blockAt == Blocks.WATER) { 

	    		// do stuff here
	    		//parPlayer.dropItem(new ItemStack(CookingPlusMain.shelledprawn), true);
	    		MyItemUse(parPlayer);
	    		if(parStack.attemptDamageItem(1, itemRand)){
	    			parPlayer.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize--;
	    		}
	    		if(parStack.getItemDamage() == parStack.getMaxDamage()){
	    			parPlayer.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize--;
	    		}
	    	}
	    }
		}
	    
		return new ActionResult(EnumActionResult.PASS, parStack);

	}
	
	protected void MyItemUse(EntityPlayer parPlayer){
		float MyRan = itemRand.nextFloat()*100;
		if(MyRan >= 70){
			int which = itemRand.nextInt(5);
			if(which == 4){
				MyRan = itemRand.nextFloat()*100;
				if(MyRan >= 50){
					parPlayer.dropItem(new ItemStack(CookingPlusMain.silicondust), true);
				}
				else{
					which = itemRand.nextInt(4);
				}
			}
			if(which == 0){
				parPlayer.dropItem(new ItemStack(Items.LEATHER_BOOTS), true);
			}
			if(which == 1){
				parPlayer.dropItem(new ItemStack(CookingPlusMain.shelledprawn), true);
			}
			if(which == 2){
				parPlayer.dropItem(new ItemStack(CookingPlusMain.shelledoyster), true);
			}
			if(which == 3){
				parPlayer.dropItem(new ItemStack(CookingPlusMain.fishegg), true);
			}
		}
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
