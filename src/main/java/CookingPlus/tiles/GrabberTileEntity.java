package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;
import CookingPlus.CookingPlusMain;

public class GrabberTileEntity extends CookingPlusCustomTileEntity implements ITickable {

	float rotation;
	float timing;
	boolean direction;
	Random myRand;
	float speed;
	
	public GrabberTileEntity() {
		myRand = new Random();
		rotation = myRand.nextFloat() * 360;
		timing = 0;
		direction = false;
		speed = 0;
	}
	

	public void processActivate(EntityPlayer Player) {
		
	}
	

	@Override
    public void update(){
		if(timing <= 0){
			timing = myRand.nextFloat() * 1000;
			speed = myRand.nextFloat()/10;
			if(myRand.nextFloat() > 0.5f){
				direction = true;
			}
			else{
				direction = false;
			}
		}
		else{
			if(direction == true){
				rotation += speed;
			}
			else{
				rotation -= speed;
			}
			timing--;
		}
		
		if(!CookingPlusMain.blockGrabber.canPlaceBlockAt(this.getWorld(), this.getPos())){
			CookingPlusMain.blockGrabber.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
			this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
		}
		
	}
	
	public float getMovement(){
		return rotation;
	}

	

}
