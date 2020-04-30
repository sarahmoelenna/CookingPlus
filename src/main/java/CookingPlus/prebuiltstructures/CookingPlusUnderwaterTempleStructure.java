package CookingPlus.prebuiltstructures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import CookingPlus.CookingPlusMain;

public class CookingPlusUnderwaterTempleStructure extends CookingPlusPreBuiltStructure {

	public CookingPlusUnderwaterTempleStructure() {
		super(0, 0, 0);

	}
	
	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock){
		myWorld.setBlockState(new BlockPos(new Vec3d(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private Block GetWorldBlock(World myWorld, int x, int y, int z){
		return myWorld.getBlockState(new BlockPos(new Vec3d(x, y, z))).getBlock();
	}

	@Override
	public void Generate(World worldIn, int x, int y, int z, boolean offsetToBaseCenter, int rotation, Random randIn){
		
	//generate entrance
		for(int h = 0; h < 11; h++){
			if(h < 8){
				SetWorldBlock(worldIn, x, y - h, z, Blocks.AIR);
				SetWorldBlock(worldIn, x + 1, y - h, z, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 1, y - h, z, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x, y - h, z + 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x, y - h, z - 1, getRandomBrick(randIn));
				
				SetWorldBlock(worldIn, x + 1, y - h, z + 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 1, y - h, z - 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 1, y - h, z + 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 1, y - h, z - 1, getRandomBrick(randIn));
			}
			if(h >= 8 && h < 10){
				SetWorldBlock(worldIn, x, y - h, z, Blocks.AIR);
				SetWorldBlock(worldIn, x + 1, y - h, z, Blocks.AIR);
				SetWorldBlock(worldIn, x - 1, y - h, z, Blocks.AIR);
				SetWorldBlock(worldIn, x, y - h, z + 1, Blocks.AIR);
				SetWorldBlock(worldIn, x, y - h, z - 1, Blocks.AIR);
				
				SetWorldBlock(worldIn, x + 1, y - h, z + 1, Blocks.AIR);
				SetWorldBlock(worldIn, x - 1, y - h, z -1, Blocks.AIR);
				SetWorldBlock(worldIn, x - 1, y - h, z + 1, Blocks.AIR);
				SetWorldBlock(worldIn, x + 1, y - h, z - 1, Blocks.AIR);
				
				SetWorldBlock(worldIn, x + 2, y - h, z, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 2, y - h, z - 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 2, y - h, z + 1, getRandomBrick(randIn));
				
				SetWorldBlock(worldIn, x, y - h, z + 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 1, y - h, z + 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 1, y - h, z + 2, getRandomBrick(randIn));
				
				SetWorldBlock(worldIn, x, y - h, z - 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 1, y - h, z - 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 1, y - h, z - 2, getRandomBrick(randIn));
			}
			if(h == 10){
				SetWorldBlock(worldIn, x, y - h, z, Blocks.AIR);
				SetWorldBlock(worldIn, x, y - h - 1, z, Blocks.SEA_LANTERN);
				SetWorldBlock(worldIn, x + 1, y - h, z, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 1, y - h, z, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x, y - h, z + 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x, y - h, z - 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 1, y - h, z + 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 1, y - h, z -1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 1, y - h, z + 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 1, y - h, z - 1, CookingPlusMain.blockCoralRockSmooth);
			}
		}
		
		clearRoom(x - 7, y - 10, z, randIn, worldIn);
		
	}
	
	private void clearRoom(int x, int y, int z, Random randIn, World worldIn){
		for(int i = 0; i < 5; i++){
			if(i > 0 && i < 4){
				for(int h = 0; h < 7; h++){
					for(int j = 0; j < 7; j++){
						SetWorldBlock(worldIn, x + h - 3, y + i, z + j - 3, Blocks.AIR);
					}
				}
				
				SetWorldBlock(worldIn, x - 4, y + i, z, Blocks.AIR);
				SetWorldBlock(worldIn, x - 4, y + i, z + 1, Blocks.AIR);
				SetWorldBlock(worldIn, x - 4, y + i, z + 2, Blocks.AIR);
				SetWorldBlock(worldIn, x - 4, y + i, z + 3, Blocks.AIR);
				SetWorldBlock(worldIn, x - 4, y + i, z - 1, Blocks.AIR);
				SetWorldBlock(worldIn, x - 4, y + i, z - 2, Blocks.AIR);
				SetWorldBlock(worldIn, x - 4, y + i, z - 3, Blocks.AIR);
				
				SetWorldBlock(worldIn, x + 4, y + i, z, Blocks.AIR);
				SetWorldBlock(worldIn, x + 4, y + i, z + 1, Blocks.AIR);
				SetWorldBlock(worldIn, x + 4, y + i, z + 2, Blocks.AIR);
				SetWorldBlock(worldIn, x + 4, y + i, z + 3, Blocks.AIR);
				SetWorldBlock(worldIn, x + 4, y + i, z - 1, Blocks.AIR);
				SetWorldBlock(worldIn, x + 4, y + i, z - 2, Blocks.AIR);
				SetWorldBlock(worldIn, x + 4, y + i, z - 3, Blocks.AIR);
				
				SetWorldBlock(worldIn, x , y + i, z + 4, Blocks.AIR);
				SetWorldBlock(worldIn, x + 1, y + i, z + 4, Blocks.AIR);
				SetWorldBlock(worldIn, x + 2, y + i, z + 4, Blocks.AIR);
				SetWorldBlock(worldIn, x + 3, y + i, z + 4,Blocks.AIR);
				SetWorldBlock(worldIn, x - 1, y + i, z + 4, Blocks.AIR);
				SetWorldBlock(worldIn, x - 2, y + i, z + 4, Blocks.AIR);
				SetWorldBlock(worldIn, x - 3, y + i, z + 4, Blocks.AIR);
				
				SetWorldBlock(worldIn, x , y + i, z - 4, Blocks.AIR);
				SetWorldBlock(worldIn, x + 1, y + i, z - 4, Blocks.AIR);
				SetWorldBlock(worldIn, x + 2, y + i, z - 4, Blocks.AIR);
				SetWorldBlock(worldIn, x + 3, y + i, z - 4,Blocks.AIR);
				SetWorldBlock(worldIn, x - 1, y + i, z - 4, Blocks.AIR);
				SetWorldBlock(worldIn, x - 2, y + i, z - 4, Blocks.AIR);
				SetWorldBlock(worldIn, x - 3, y + i, z - 4, Blocks.AIR);
				

				//walls
				SetWorldBlock(worldIn, x - 5, y + i, z, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 5, y + i, z + 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 5, y + i, z + 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 5, y + i, z + 3, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 5, y + i, z - 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 5, y + i, z - 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 5, y + i, z - 3, getRandomBrick(randIn));
				
				if(i >= 3){
					SetWorldBlock(worldIn, x + 5, y + i, z, getRandomBrick(randIn));
				}
				else{
					SetWorldBlock(worldIn, x + 5, y + i, z, Blocks.AIR);
				}
				SetWorldBlock(worldIn, x + 5, y + i, z + 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 5, y + i, z + 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 5, y + i, z + 3, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 5, y + i, z - 1, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 5, y + i, z - 2, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 5, y + i, z - 3, getRandomBrick(randIn));
				
				SetWorldBlock(worldIn, x , y + i, z + 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 1, y + i, z + 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 2, y + i, z + 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 3, y + i, z + 5,getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 1, y + i, z + 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 2, y + i, z + 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 3, y + i, z + 5, getRandomBrick(randIn));
				
				SetWorldBlock(worldIn, x , y + i, z - 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 1, y + i, z - 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 2, y + i, z - 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x + 3, y + i, z - 5,getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 1, y + i, z - 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 2, y + i, z - 5, getRandomBrick(randIn));
				SetWorldBlock(worldIn, x - 3, y + i, z - 5, getRandomBrick(randIn));
				
				SetWorldBlock(worldIn, x - 4, y + i, z - 4, Blocks.SEA_LANTERN);
				SetWorldBlock(worldIn, x + 4, y + i, z + 4, Blocks.SEA_LANTERN);
				SetWorldBlock(worldIn, x - 4, y + i, z + 4, Blocks.SEA_LANTERN);
				SetWorldBlock(worldIn, x + 4, y + i, z - 4, Blocks.SEA_LANTERN);
				
			}
			else{
				for(int h = 0; h < 7; h++){
					for(int j = 0; j < 7; j++){
						SetWorldBlock(worldIn, x + h - 3, y + i, z + j - 3, CookingPlusMain.blockCoralRockSmooth);
					}
				}
				
				SetWorldBlock(worldIn, x - 4, y + i, z, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 4, y + i, z + 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 4, y + i, z + 2, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 4, y + i, z + 3, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 4, y + i, z - 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 4, y + i, z - 2, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 4, y + i, z - 3, CookingPlusMain.blockCoralRockSmooth);
				
				SetWorldBlock(worldIn, x + 4, y + i, z, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 4, y + i, z + 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 4, y + i, z + 2, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 4, y + i, z + 3,CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 4, y + i, z - 1, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 4, y + i, z - 2, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 4, y + i, z - 3, CookingPlusMain.blockCoralRockSmooth);
				
				SetWorldBlock(worldIn, x , y + i, z + 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 1, y + i, z + 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 2, y + i, z + 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 3, y + i, z + 4,CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 1, y + i, z + 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 2, y + i, z + 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 3, y + i, z + 4, CookingPlusMain.blockCoralRockSmooth);
				
				SetWorldBlock(worldIn, x , y + i, z - 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 1, y + i, z - 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 2, y + i, z - 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x + 3, y + i, z - 4,CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 1, y + i, z - 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 2, y + i, z - 4, CookingPlusMain.blockCoralRockSmooth);
				SetWorldBlock(worldIn, x - 3, y + i, z - 4, CookingPlusMain.blockCoralRockSmooth);
				
				SetWorldBlock(worldIn, x + 5, y + i, z, CookingPlusMain.blockCoralRockSmooth);
			}
		}
		
		SetWorldBlock(worldIn, x - 2, y + 1, z, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x - 2, y + 1, z + 1, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x - 2, y + 1, z - 1, CookingPlusMain.blockCoralRockCarved);
		
		SetWorldBlock(worldIn, x + 2, y + 1, z, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x + 2, y + 1, z + 1, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x + 2, y + 1, z - 1, CookingPlusMain.blockCoralRockCarved);
		
		SetWorldBlock(worldIn, x, y + 1, z + 2, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x + 1, y + 1, z + 2, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x - 1, y + 1, z + 2, CookingPlusMain.blockCoralRockCarved);
		
		SetWorldBlock(worldIn, x, y + 1, z - 2, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x + 1, y + 1, z - 2, CookingPlusMain.blockCoralRockCarved);
		SetWorldBlock(worldIn, x - 1, y + 1, z - 2, CookingPlusMain.blockCoralRockCarved);
		
	}
	
	private Block getRandomBrick(Random myRand){
		if(myRand.nextInt(2) == 0){
			return CookingPlusMain.blockCoralRockBrick;
		}
		else{
			return CookingPlusMain.blockCoralRockBrickMossy;
		}
	}
}
