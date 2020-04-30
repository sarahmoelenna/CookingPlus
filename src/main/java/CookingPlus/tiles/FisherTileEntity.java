package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;
import CookingPlus.CookingPlusMain;

public class FisherTileEntity extends CookingPlusCustomTileEntity implements ITickable {

	float Rotation;
	
	public FisherTileEntity() {
		Random myRand = new Random();
		Rotation = myRand.nextInt(360);
	}
	

	public void processActivate(EntityPlayer Player) {
		
	}
	

	@Override
    public void update(){
		Rotation += 0.03f;
		
		if(!CookingPlusMain.blockFisher.canPlaceBlockAt(this.getWorld(), this.getPos())){
			CookingPlusMain.blockFisher.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
			this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
		}
		
	}
	
	public float getMovement(){
		return Rotation;
	}

	

}
