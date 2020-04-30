package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusMain;

public class CookingPlusLightCrystalTileEntity extends CystalBaseTileEntity {
	
	public CookingPlusLightCrystalTileEntity(){
		super();

	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockLightCrystal) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockLightCrystal) == false){
				world.removeTileEntity(pos);
				for(int x = 0; x < 15; x++){
					for(int z = 0; z < 15; z++){
						for(int y = 0; y < 15; y++){
							BlockPos LightPos = new BlockPos(x - 7, y - 7, z - 7);
							if(this.getWorld().getBlockState(this.getPos().add(LightPos.getX(), LightPos.getY(), LightPos.getZ())).getBlock() == CookingPlusMain.blockLightAir){
								this.getWorld().setBlockState(this.getPos().add(LightPos.getX(), LightPos.getY(), LightPos.getZ()), Blocks.AIR.getDefaultState(), 1);
							}
						}
					}
				}
			}
		}
		return false;
    }
	
	@Override
	public void processActivate(EntityPlayer Player) {
		//Player.dropItem(new ItemStack(CookingPlusMain.waterorb), false);
	}
	
	@Override
    public void update(){
		super.update();
		for(int x = 0; x < 15; x++){
			for(int z = 0; z < 15; z++){
				for(int y = 0; y < 15; y++){
					BlockPos LightPos = new BlockPos(x - 7, y - 7, z - 7);
					if(this.getWorld().getBlockState(this.getPos().add(LightPos.getX(), LightPos.getY(), LightPos.getZ())).getBlock() == Blocks.AIR){
						this.getWorld().setBlockState(this.getPos().add(LightPos.getX(), LightPos.getY(), LightPos.getZ()), CookingPlusMain.blockLightAir.getDefaultState(), 1);
					}
				}
			}
		}
	}
        
	
}
