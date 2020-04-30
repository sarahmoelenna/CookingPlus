package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusMain;

public class GoldBotTileEntity extends BotTileEntity {

	public GoldBotTileEntity(){
		super();
		this.speedMultiplier = CookingPlusConfig.HHBGoldSpeedModifier;
	}
	
	@Override
	public boolean shouldDestroyExcess(){
		return true;
	}
	
	@Override
	public int getBaseEnergyCost(){
		return 8;
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockGoldBot) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockGoldBot) == false){
				world.removeTileEntity(pos);
				//return true;
			}
		}
        return false;
    }
}
