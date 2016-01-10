package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusTeleportCrystal;

public class CookingPlusSkyCrystalTileEntity extends CystalBaseTileEntity {
	
	public CookingPlusSkyCrystalTileEntity(){
		super();

	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockSkyCrystal) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockSkyCrystal) == false){
				world.removeTileEntity(pos);
			}
		}
		return false;
    }
	
	@Override
	public void processActivate(EntityPlayer Player) {
		//Player.setPositionAndUpdate(Player.getBedLocation().getX(), Player.getBedLocation().getY(), Player.getBedLocation().getZ());
		if(Player.getCurrentEquippedItem().getItem() == CookingPlusMain.teleportcrystal){
			CookingPlusTeleportCrystal myCrystal = (CookingPlusTeleportCrystal) Player.getCurrentEquippedItem().getItem();
			myCrystal.ProcessTeleport(true, Player.getCurrentEquippedItem(), this.getPos(), Player);
		}
	}
        
	
}
