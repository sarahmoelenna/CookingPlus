package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;
import CookingPlus.CookingPlusMain;

public class CookingPlusSpeedBlockTileEntity extends CookingPlusCustomTileEntity implements ITickable {

	int Rotation;
	int Type = 0;
	
	public CookingPlusSpeedBlockTileEntity() {
		Random myRand = new Random();
		Rotation = 0;
	}
	
	public void processActivate(EntityPlayer Player) {
		
	}
	
	@Override
    public void update(){
		Type ++;
		if(Type > 20){
			Type = 0;
		}
		//System.out.println(Type);
		
		if(!CookingPlusMain.blockSpeedBlock.canPlaceBlockAt(this.getWorld(), this.getPos())){
			CookingPlusMain.blockSpeedBlock.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
			this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
		}
		
	}
	
	public int getType(){
		return Type/4;
	}

	

}
