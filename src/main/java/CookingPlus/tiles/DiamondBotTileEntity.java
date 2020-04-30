package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusMain;

public class DiamondBotTileEntity extends BotTileEntity {

	public DiamondBotTileEntity(){
		super();
		this.speedMultiplier = CookingPlusConfig.HHBDiamondSpeedModifier;
	}
	
	@Override
	public boolean shouldDestroyExcess(){
		return true;
	}
	
	@Override
	public int getBaseEnergyCost(){
		return 16;
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockDiamondBot) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockDiamondBot) == false){
				world.removeTileEntity(pos);
				//return true;
			}
		}
        return false;
    }
}
