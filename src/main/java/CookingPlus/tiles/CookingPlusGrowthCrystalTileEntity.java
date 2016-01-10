package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusMain;

public class CookingPlusGrowthCrystalTileEntity extends CystalBaseTileEntity {

	private Random myRand;
	private int growthRate;
	
	public CookingPlusGrowthCrystalTileEntity(){
		super();
		myRand = new Random();
		growthRate = myRand.nextInt(50);
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockGrowthCrystal) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockGrowthCrystal) == false){
				world.removeTileEntity(pos);
			}
		}
		return false;
    }
        
	@Override
    public void update(){
		super.update();
		
		growthRate++;
		
		if(growthRate > CookingPlusConfig.GrowthCrystalGrowRate){
		for(int w = 0; w < 8; w++){
			for(int l = 0; l < 8; l++){
				if(myRand.nextInt(5) == 0){
					if(this.getWorld().getBlockState(new BlockPos(new Vec3(this.getPos().getX() + w - 3, this.getPos().getY(), this.getPos().getZ() + l - 3))).getBlock() instanceof BlockCrops){
						BlockPos myPos = new BlockPos(new Vec3(this.getPos().getX() + w - 3, this.getPos().getY(), this.getPos().getZ() + l - 3));
						this.getWorld().getBlockState(myPos).getBlock().updateTick(this.getWorld(), myPos, this.getWorld().getBlockState(myPos), myRand);
					}
				}
			}
		}
		growthRate = 0;
		}
		
	}
	
}
