package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusMain;

public class LoggerTileEntity extends CookingPlusCustomTileEntity implements ITickable {

	int Rotation;
	int Type = 0;
	
	public LoggerTileEntity() {
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
		
		if(!CookingPlusMain.blockLogger.canPlaceBlockAt(this.getWorld(), this.getPos())){
			CookingPlusMain.blockLogger.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
			this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
		}
		
	}
	
	public int getType(){
		return Type/4;
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockLogger) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockLogger) == false){
				world.removeTileEntity(pos);
			}
		}
        return false;
    }

}
