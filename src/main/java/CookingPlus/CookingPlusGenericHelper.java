package CookingPlus;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CookingPlusGenericHelper {
	
	private static final CookingPlusGenericHelper GenericHelper = new CookingPlusGenericHelper();

	public static CookingPlusGenericHelper instance()
    {
        return GenericHelper;
    }
	
	public BlockPos NearestPlayerSafeSpot(BlockPos myPos, World worldIn){
		
		if(worldIn.getBlockState(myPos.north()).getBlock() == Blocks.air){
			if(worldIn.getBlockState(myPos.north().up()).getBlock() == Blocks.air){
				return myPos.north();
			}
		}
		else if(worldIn.getBlockState(myPos.south()).getBlock() == Blocks.air){
			if(worldIn.getBlockState(myPos.south().up()).getBlock() == Blocks.air){
				return myPos.south();
			}
		}
		else if(worldIn.getBlockState(myPos.east()).getBlock() == Blocks.air){
			if(worldIn.getBlockState(myPos.east().up()).getBlock() == Blocks.air){
				return myPos.east();
			}
		}
		else if(worldIn.getBlockState(myPos.west()).getBlock() == Blocks.air){
			if(worldIn.getBlockState(myPos.west().up()).getBlock() == Blocks.air){
				return myPos.west();
			}
		}
		return null;
	}
	
}
