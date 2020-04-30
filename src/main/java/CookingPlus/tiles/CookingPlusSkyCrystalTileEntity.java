package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
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
		if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() == CookingPlusMain.teleportcrystal){
			CookingPlusTeleportCrystal myCrystal = (CookingPlusTeleportCrystal) Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem();
			myCrystal.ProcessTeleport(true, Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND), this.getPos(), Player);
		}
	}
        
	
}
