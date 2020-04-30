package CookingPlus.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusMain;

public class CookingPlusNetherGen {

	static void GenerateNetherStructures(World worldIn, Random randIn,
			int ChunkX, int ChunkZ) {
		
		if(CookingPlusConfig.NetherTangleSpawnRate != 0){
		if(randIn.nextFloat()*100 > (100 - CookingPlusConfig.NetherTangleSpawnRate)){
			int x = ChunkX * 16 + randIn.nextInt(16);
        	int z = ChunkZ * 16 + randIn.nextInt(16);
        	int y = randIn.nextInt(255) + 1;

			for (int i = y - 1; i > 1; i--) {
				if (worldIn.getBlockState(new BlockPos(x, i, z)).getBlock() == Blocks.AIR) {
					if (worldIn.getBlockState(new BlockPos(x, i - 1, z)).getBlock() == Blocks.NETHERRACK || worldIn.getBlockState(new BlockPos(x, i, z)).getBlock() == Blocks.SOUL_SAND) {
						SpreadTangle(worldIn, new BlockPos(x, i, z), randIn, 0);
						i = 0;
					}
				}
			}
		}
		}

	}
	
	static void GenerateNetherTangle(World worldIn, BlockPos myPos, Random randIn){
		worldIn.setBlockState(myPos, CookingPlusMain.blockTangleHeart.getDefaultState());
		SurroundWithBlock(worldIn, myPos, CookingPlusMain.blockTangleLeaves);
		SpreadTangle(worldIn, myPos, randIn, 1);
		SpreadTangle(worldIn, myPos, randIn, 1);
		SpreadTangle(worldIn, myPos, randIn, 1);
	}
	
	static void ChancetoSpreadTangle(World worldIn, BlockPos myPos, Random randIn, int Tier){
		if(randIn.nextInt(20) > 16){
			SpreadTangle(worldIn, myPos, randIn, Tier + 1);
		}
	}
	
	public static void SpreadTangle(World worldIn, BlockPos myPos, Random randIn, int Tier){
		
		Block myBlock = CookingPlusMain.blockTangleLeaves;
		Block logBlock = CookingPlusMain.blockTangleLog;
		
		BlockPos CurrentPos = myPos;
		int PreviousDirection = 0;
		PreviousDirection = randIn.nextInt(5);
		if(worldIn.getBlockState(CurrentPos).getBlock() != CookingPlusMain.blockTangleHeart){
			worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
		}
		
		for(int i = 0; i < 25 - Tier * 5; i++){
			int Direction = randIn.nextInt(5);
			if(randIn.nextFloat() > 0.5){
				Direction = PreviousDirection;
			}
			if(Direction == 0){
				if(canPlaceTangleBlock(worldIn, CurrentPos.up(), myBlock)){
					CurrentPos = CurrentPos.up();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.east(), myBlock)){
					CurrentPos = CurrentPos.east();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.west(), myBlock)){
					CurrentPos = CurrentPos.west();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.north(), myBlock)){
					CurrentPos = CurrentPos.north();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.south(), myBlock)){
					CurrentPos = CurrentPos.south();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
			}
			else if(Direction == 1){
				if(canPlaceTangleBlock(worldIn, CurrentPos.east(), myBlock)){
					CurrentPos = CurrentPos.east();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.north(), myBlock)){
					CurrentPos = CurrentPos.north();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.south(), myBlock)){
					CurrentPos = CurrentPos.south();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.west(), myBlock)){
					CurrentPos = CurrentPos.west();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.up(), myBlock)){
					CurrentPos = CurrentPos.up();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
			}
			else if(Direction == 2){
				if(canPlaceTangleBlock(worldIn, CurrentPos.north(), myBlock)){
					CurrentPos = CurrentPos.north();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.west(), myBlock)){
					CurrentPos = CurrentPos.west();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.south(), myBlock)){
					CurrentPos = CurrentPos.south();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.up(), myBlock)){
					CurrentPos = CurrentPos.up();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.east(), myBlock)){
					CurrentPos = CurrentPos.east();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
			}
			else if(Direction == 3){
				if(canPlaceTangleBlock(worldIn, CurrentPos.west(), myBlock)){
					CurrentPos = CurrentPos.west();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.north(), myBlock)){
					CurrentPos = CurrentPos.north();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.south(), myBlock)){
					CurrentPos = CurrentPos.south();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.up(), myBlock)){
					CurrentPos = CurrentPos.up();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.east(), myBlock)){
					CurrentPos = CurrentPos.east();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
			}
			else if(Direction == 4){
				if(canPlaceTangleBlock(worldIn, CurrentPos.south(), myBlock)){
					CurrentPos = CurrentPos.south();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.up(), myBlock)){
					CurrentPos = CurrentPos.up();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.east(), myBlock)){
					CurrentPos = CurrentPos.east();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.west(), myBlock)){
					CurrentPos = CurrentPos.west();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
				else if(canPlaceTangleBlock(worldIn, CurrentPos.north(), myBlock)){
					CurrentPos = CurrentPos.north();
					worldIn.setBlockState(CurrentPos, logBlock.getDefaultState());
					ChancetoSpreadTangle(worldIn, CurrentPos, randIn, Tier);
				}
			}
		}
	}

	public static void SurroundWithBlock(World worldIn, BlockPos myPos, Block myBlock){
		if(worldIn.getBlockState(myPos.up()).getBlock().isReplaceable(worldIn, myPos.up())){
			worldIn.setBlockState(myPos.up(), myBlock.getDefaultState());
		}
		if(worldIn.getBlockState(myPos.down()).getBlock().isReplaceable(worldIn, myPos.down())){
			worldIn.setBlockState(myPos.down(), myBlock.getDefaultState());
		}
		if(worldIn.getBlockState(myPos.east()).getBlock().isReplaceable(worldIn, myPos.east())){
			worldIn.setBlockState(myPos.east(), myBlock.getDefaultState());
		}
		if(worldIn.getBlockState(myPos.west()).getBlock().isReplaceable(worldIn, myPos.west())){
			worldIn.setBlockState(myPos.west(), myBlock.getDefaultState());
		}
		if(worldIn.getBlockState(myPos.south()).getBlock().isReplaceable(worldIn, myPos.south())){
			worldIn.setBlockState(myPos.south(), myBlock.getDefaultState());
		}
		if(worldIn.getBlockState(myPos.north()).getBlock().isReplaceable(worldIn, myPos.north())){
			worldIn.setBlockState(myPos.north(), myBlock.getDefaultState());
		}
	}

	static boolean canPlaceTangleBlock(World worldIn, BlockPos myPos, Block Ignore){
		if(worldIn.getBlockState(myPos).getBlock() == Blocks.AIR){
			SurroundWithBlock(worldIn, myPos, Ignore);
			return true;
		}
		else if(worldIn.getBlockState(myPos).getBlock() == Ignore){
			SurroundWithBlock(worldIn, myPos, Ignore);
			return true;
		}
		return false;
	}
}
