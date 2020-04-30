package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ITickable;

public class CystalBaseTileEntity extends CookingPlusCustomTileEntity implements ITickable {

	private float rotation;
	private float bobbing;
	private boolean bobstate;
	
	public CystalBaseTileEntity() {
		Random myRand = new Random();
		rotation = myRand.nextInt(360);
		bobbing = myRand.nextInt(200)/200.0f;
		bobstate = false;
	}
	
	
	public void processActivate(EntityPlayer Player) {
		
	}
	

	@Override
    public void update(){
		rotation += 0.8f;
		if(rotation > 360){
			rotation = 0;
		}
		if(bobstate == false){
			bobbing += 0.05;
		}
		else{
			bobbing -= 0.05;
		}
		if(bobbing > 1){
			bobstate = true;
		}
		if(bobbing < 0){
			bobstate = false;
		}
	}
	
	public int getCrystalType(){
		return 0;
	}

	public float getRotation(){
		return rotation;
	}
	
	public float getBobbing(){
		return bobbing;
	}
	

}
