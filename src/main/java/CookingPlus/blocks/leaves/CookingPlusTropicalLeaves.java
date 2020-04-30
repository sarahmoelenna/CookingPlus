package CookingPlus.blocks.leaves;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusTropicalLeaves extends CookingPlusCustomLeaves {

	public CookingPlusTropicalLeaves(String name) {
		super(name);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue() && ((Boolean)state.getValue(DECAYABLE)).booleanValue())
            {
                byte range = 4;
                int myX = pos.getX();
                int myY = pos.getY();
                int myZ = pos.getZ();
                
                int sustainableBlockCount = 0;

                if (worldIn.isAreaLoaded(new BlockPos(myX - range, myY - range, myZ - range), new BlockPos(myX + range, myY + range, myZ + range)))
                {
                   for(int x = 0; x < range * 2 + 1 && sustainableBlockCount == 0; x++){
                	   for(int y = 0; y < range * 2 + 1 && sustainableBlockCount == 0; y++){
                		   for(int z = 0; z < range * 2 + 1 && sustainableBlockCount == 0; z++){
                			   BlockPos myNewPos = new BlockPos(new Vec3d(myX - x + range + 1, myY - y + range + 1, myZ - z + range + 1));
                			   Block myCheckBlock = worldIn.getBlockState(myNewPos).getBlock();
                        	   if(myCheckBlock.canSustainLeaves(worldIn.getBlockState(myNewPos), worldIn, myNewPos)){
                        		   sustainableBlockCount += 1;
                        	   }
                           }
                       }
                   }
                }
                else{
                	sustainableBlockCount = 1;
                }

                if (sustainableBlockCount > 0)
                {
                    worldIn.setBlockState(pos, state.withProperty(CHECK_DECAY, Boolean.valueOf(false)), 4);
                }
                else
                {
                    this.destroy(worldIn, pos);
                }
            }
        }
    }

}
