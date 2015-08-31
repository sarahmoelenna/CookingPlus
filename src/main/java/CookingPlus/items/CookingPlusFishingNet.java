package CookingPlus.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class CookingPlusFishingNet extends CookingPlusCustomItem {

	private final String name = "fnet";
	
	public CookingPlusFishingNet(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("fishingnet");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":fishingnet");
		setNoRepair();
		this.setMaxDamage(20);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack parStack, World parWorld, EntityPlayer parPlayer) {
		parPlayer.swingItem();
		if(parPlayer.isSwingInProgress == true){
	    Vec3 vec3 = new Vec3(parPlayer.getPosition().getX(), parPlayer.getPosition().getY() + 1.62f, parPlayer.getPosition().getZ());
	    
	    //vec3.xCoord = parPlayer.getPosition().getX();
	    //vec3.yCoord = parPlayer.getPosition().getY() + 1.62f;
	    //vec3.zCoord = parPlayer.getPosition().getZ();

	    Vec3 vec31 = parPlayer.getLook(1.0F);

	    Vec3 vec32 = vec3.addVector(vec31.xCoord * 5, vec31.yCoord * 5, vec31.zCoord * 5);

	    MovingObjectPosition look = parWorld.rayTraceBlocks(vec3, vec32, true);
	    if(look != null){
	    //if(parWorld.blockExists(look.blockX, look.blockY, look.blockZ) == true){
	    	Block blockAt = parWorld.getBlockState(look.getBlockPos()).getBlock();
	    
	    	if (blockAt == Blocks.water) { 

	    		// do stuff here
	    		//parPlayer.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.shelledprawn), true);
	    		MyItemUse(parPlayer);
	    		if(parStack.attemptDamageItem(1, itemRand)){
	    			parPlayer.getCurrentEquippedItem().stackSize--;
	    		}
	    		if(parStack.getItemDamage() == parStack.getMaxDamage()){
	    			parPlayer.getCurrentEquippedItem().stackSize--;
	    		}
	    	}
	    }
		}
	    
		return parStack;

	}
	
	protected void MyItemUse(EntityPlayer parPlayer){
		float MyRan = itemRand.nextFloat()*100;
		if(MyRan >= 70){
			int which = itemRand.nextInt(3);
			if(which == 0){
				parPlayer.dropPlayerItemWithRandomChoice(new ItemStack(Items.leather_boots), true);
			}
			if(which == 1){
				parPlayer.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.shelledprawn), true);
			}
			if(which == 2){
				parPlayer.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.shelledoyster), true);
			}
		}
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
