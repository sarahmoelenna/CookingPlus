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

public class CookingPlusWaterCrystalTileEntity extends CystalBaseTileEntity {
	
	public CookingPlusWaterCrystalTileEntity(){
		super();

	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockWaterCrystal) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockWaterCrystal) == false){
				world.removeTileEntity(pos);
			}
		}
		return false;
    }
	
	@Override
	public void processActivate(EntityPlayer Player) {
		Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.waterorb), false);
	}
        
	
}
