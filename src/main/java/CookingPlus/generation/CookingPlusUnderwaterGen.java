package CookingPlus.generation;

import java.util.Random;

import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSpreadingCoral;
import CookingPlus.blocks.CookingPlusCustomUnderwaterPlant;
import CookingPlus.prebuiltstructures.CookingPlusPreBuiltShipFront;
import CookingPlus.prebuiltstructures.CookingPlusPreBuiltSphereCoral;
import CookingPlus.prebuiltstructures.CookingPlusPreBuiltSpikyCoral;
import CookingPlus.prebuiltstructures.CookingPlusPreBuiltStructure;
import CookingPlus.prebuiltstructures.CookingPlusUnderwaterTempleStructure;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CookingPlusUnderwaterGen {

	static void GenerateUnderwaterStructures(World worldIn, Random randIn,int ChunkX, int ChunkZ) {

		
		BiomeGenBase biome = worldIn.getBiomeGenForCoords(new BlockPos(new Vec3(ChunkX * 16 + 8, 0, ChunkZ * 16 + 8)));
		if (biome.biomeID == 0 || biome.biomeID == 24 || biome.biomeID == 16) {
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					if (randIn.nextInt(CookingPlusConfig.SeaweedSpawnRate) == 0 && CookingPlusConfig.SeaweedSpawnRate != 0) {
						if (randIn.nextInt(50) > 48){
							int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(ChunkX * 16 + x, 0,ChunkZ * 16 + z))).getY();
							GenerateUnderwaterGrowingPlant(worldIn, ChunkX * 16+ x, y, ChunkZ * 16 + z, randIn, 2, 5, CookingPlusMain.blockKelpCrop);
						}
						else{
							int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(ChunkX * 16 + x, 0,ChunkZ * 16 + z))).getY();
							GenerateUnderwaterGrowingPlant(worldIn, ChunkX * 16+ x, y, ChunkZ * 16 + z, randIn, 2, 5, CookingPlusMain.blockSeaweedCrop);
						}
					}
				}
			}
		}
		
		
		if (biome.biomeID == CookingPlusConfig.KelpForestID) {
			//System.out.println("kelp forest");
			
			 int mx = ChunkX * 16 + randIn.nextInt(16);
	         int mz = ChunkZ * 16 + randIn.nextInt(16);
	         int my = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(mx, 0, mz))).getY();
			
			if(randIn.nextInt(CookingPlusConfig.TempleSpawnRate) == 0 && CookingPlusConfig.TempleSpawnRate != 0){
        	 	CookingPlusPreBuiltStructure myTempStructure = new CookingPlusUnderwaterTempleStructure();
            	myTempStructure.Generate(worldIn, mx, my + 1, mz, true, 0, randIn);
        	}
			
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					if (randIn.nextInt(2) == 0) {
						int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(ChunkX * 16 + x, 0,ChunkZ * 16 + z))).getY();
						GenerateUnderwaterGrowingPlant(worldIn, ChunkX * 16+ x, y, ChunkZ * 16 + z, randIn, 2, 5, CookingPlusMain.blockKelpCrop);
					}
				}
			}
			
			 int x = ChunkX * 16 + randIn.nextInt(16);
	         int z = ChunkZ * 16 + randIn.nextInt(16);
	         int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0,z))).getY();
	            
	         if(randIn.nextInt(CookingPlusConfig.ShipWreckSpawnRate) == 0  && CookingPlusConfig.ShipWreckSpawnRate != 0){
	        	 if(y < 62 - 9){
	            	CookingPlusPreBuiltStructure myTempStructure = new CookingPlusPreBuiltShipFront();
	            	myTempStructure.Generate(worldIn, x, y, z, true, 0, randIn);
	        	 }
	         }
		}
		
		if (biome.biomeID == CookingPlusConfig.CoralReefID) {
			int x = ChunkX * 16 + randIn.nextInt(16);
            int z = ChunkZ * 16 + randIn.nextInt(16);
            int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0,z))).getY();
            
            if(randIn.nextInt(4) == 0){
            	
            	if(randIn.nextInt(CookingPlusConfig.TempleSpawnRate) == 0 && CookingPlusConfig.TempleSpawnRate != 0){
                	CookingPlusPreBuiltStructure myTempStructure = new CookingPlusUnderwaterTempleStructure();
                	myTempStructure.Generate(worldIn, x, y + 1, z, true, 0, randIn);
            	}
            	else{
            		GeneratePatch(worldIn, randIn, new BlockPos(new Vec3(x, y, z)), 20, CookingPlusMain.blockCoralRock);
            	}
            	
            }
            else{
            	GenerateCoralReef(worldIn, x, y, z, randIn, 10, 35, CookingPlusMain.blockCoralRock, CookingPlusMain.blockCoralRock, randIn.nextInt(5));
            }
            
            x = ChunkX * 16 + randIn.nextInt(16);
            z = ChunkZ * 16 + randIn.nextInt(16);
            y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0,z))).getY();
            
            if(randIn.nextInt(CookingPlusConfig.ShipWreckSpawnRate) == 0  && CookingPlusConfig.ShipWreckSpawnRate != 0){
            	if(y < 62 - 9){
            		CookingPlusPreBuiltStructure myTempStructure = new CookingPlusPreBuiltShipFront();
            		myTempStructure.Generate(worldIn, x, y, z, true, 0, randIn);
            	}
            }
            
            AddCoral(worldIn, randIn, ChunkX, ChunkZ);
		}
		
		if (biome.biomeID == CookingPlusConfig.DeepReefID) {
			
			int x = ChunkX * 16 + randIn.nextInt(16);
            int z = ChunkZ * 16 + randIn.nextInt(16);
            int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0,z))).getY();
			
            		 GeneratePatch(worldIn, randIn, new BlockPos(new Vec3(x, y, z)), 20, CookingPlusMain.blockCoralRock);
            		 if(randIn.nextInt(CookingPlusConfig.UnderwaterVentSpawnRate) == 0 && CookingPlusConfig.UnderwaterVentSpawnRate != 0){
            			 GenerateVent(worldIn, x, y, z, randIn);
            		 }
            		 else{
            			 AddGiantCorals(CookingPlusConfig.GiantCoralDensity, ChunkX, ChunkZ, worldIn, randIn);
            		 }
            		 AddCoral(worldIn, randIn, ChunkX, ChunkZ);
            	 
		}

	}

	static void GenerateUnderwaterGrowingPlant(World worldIn, int x, int y, int z, Random randIn, int min, int max, Block myBlock){
			
		if(myBlock.canPlaceBlockAt(worldIn, new BlockPos(new Vec3(x, y, z)))){
			
			int Height = randIn.nextInt(max - min) + min;
			
			for(int i = 0; i< Height; i++){
				if(myBlock.canPlaceBlockAt(worldIn, new BlockPos(new Vec3(x, y + i, z)))){
					worldIn.setBlockState(new BlockPos(new Vec3(x, y + i, z)),myBlock.getDefaultState());
				}
			}
		}
	}
	
	static void GenerateCoralReef(World worldIn, int x, int y, int z, Random randIn, int min, int max, Block myBlock, Block BaseBlock, int heightBelowSea){
		//int prevWidthX = randIn.nextInt(5) + 3;
		//int prevWidthZ = randIn.nextInt(5) + 3;
		
		GeneratePatch(worldIn, randIn, new BlockPos(new Vec3(x, y, z)), 20, BaseBlock);
		
		float prevWidthX = 6;
		float prevWidthZ = 4;
		
		boolean SizeState = false; //false = grow
		
		for(int myY = 0; myY < max; myY++){
			
			if(worldIn.getBlockState(new BlockPos(new Vec3(x, y + myY + 2 + heightBelowSea, z))).getBlock() == Blocks.water){
			
				for(int myX = -7; myX <7; myX++){	
					for(int myZ = -7; myZ < 7; myZ++){
						if(((myX/(prevWidthX))*(myX/(prevWidthX)))+((myZ/(prevWidthZ))*(myZ/(prevWidthZ)))<=2){
							worldIn.setBlockState(new BlockPos(new Vec3(x + myX, y + myY, z + myZ)),myBlock.getDefaultState());
							if(randIn.nextInt(3) == 0){
								AddCoralBlock(worldIn, getCoralBlock(randIn), new BlockPos(new Vec3(x + myX, y + myY + 1, z + myZ)));
							}
						} 
					}
				}
			}
			else{
				myY = max+1;
			}
			
			if(prevWidthX >= 6 || prevWidthZ >= 6){
				SizeState = true;
			}
			if(prevWidthX <= 1 || prevWidthZ <= 1){
				SizeState = false;
			}
			
			if(SizeState == false){
				prevWidthX += randIn.nextInt(2) + 1;
				prevWidthZ += randIn.nextInt(2) + 1;
			}
			if(SizeState == true){
				prevWidthX -= randIn.nextInt(2) + 1;
				prevWidthZ -= randIn.nextInt(2) + 1;
			}
			
			if(prevWidthX > 6){
				prevWidthX = 6;
			}
			if(prevWidthZ > 6){
				prevWidthZ = 6;
			}
			if(prevWidthZ < 1){
				prevWidthZ = 1;
			}
			if(prevWidthX < 1){
				prevWidthX = 1;
			}
		}
		
		
	}
	
	static void GeneratePatch(World worldIn, Random p_180709_2_, BlockPos p_180709_3_, int radius, Block myBlock){
		int i = p_180709_2_.nextInt(radius - 2) + 2;
        byte b0 = 2;

        for (int j = p_180709_3_.getX() - i; j <= p_180709_3_.getX() + i; ++j)
        {
            for (int k = p_180709_3_.getZ() - i; k <= p_180709_3_.getZ() + i; ++k)
            {
                int l = j - p_180709_3_.getX();
                int i1 = k - p_180709_3_.getZ();

                if (l * l + i1 * i1 <= i * i)
                {
                    for (int j1 = p_180709_3_.getY() - b0; j1 <= p_180709_3_.getY() + b0; ++j1)
                    {
                        BlockPos blockpos1 = new BlockPos(j, j1, k);
                        Block block = worldIn.getBlockState(blockpos1).getBlock();
                        if(blockpos1.getY() < 62){
                        	if(block != Blocks.water && block != Blocks.air && (block instanceof CookingPlusCustomUnderwaterPlant) == false && (block == Blocks.sand || block == Blocks.dirt || block == Blocks.stone || block == Blocks.gravel || block == CookingPlusMain.blockCoralRock)){
                        		worldIn.setBlockState(blockpos1, myBlock.getDefaultState(), 2);
                        	}
                        }
                    }
                }
            }
        }
	}
	
	static void AddCoral(World worldIn, Random randIn, int ChunkX, int ChunkZ){
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				if (randIn.nextInt(3) == 0) {
					//System.out.println("spawn seaweed");
					int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(ChunkX * 16 + x, 0,ChunkZ * 16 + z))).getY();
					Block CoralBlock = getCoralBlock(randIn);
					if(((CookingPlusCustomSpreadingCoral) CoralBlock).canBlockStay(worldIn, new BlockPos(new Vec3(ChunkX * 16 + x, y,ChunkZ * 16 + z)))){
						worldIn.setBlockState(new BlockPos(new Vec3(ChunkX * 16 + x, y,ChunkZ * 16 + z)), CoralBlock.getDefaultState());
					}
				}
			}
		}
	}
	
	static void AddCoralBlock(World worldIn, Block CoralBlock, BlockPos myPos){
		//if(((CookingPlusCustomSpreadingCoral) CoralBlock).canBlockStay(worldIn, myPos)){
			worldIn.setBlockState(myPos, CoralBlock.getDefaultState());
		//}
	}
	
	static Block getCoralBlock(Random randIn){
		int which = randIn.nextInt(7);
		if(which == 0){
			return CookingPlusMain.blockWhiteCoral;
		}
		else if(which == 1){
			return CookingPlusMain.blockGreenCoral;
		}
		else if(which == 2){
			return CookingPlusMain.blockRedCoral;
		}
		else if(which == 3){
			return CookingPlusMain.blockBlueCoral;
		}
		else if(which == 4){
			return CookingPlusMain.blockBlackCoral;
		}
		else if(which == 5){
			return CookingPlusMain.blockOrangeCoral;
		}
		else if(which == 6){
			return CookingPlusMain.blockYellowCoral;
		}
		return null;
	}

	static void GenerateVent(World worldIn, int x, int y, int z, Random randIn){
	boolean done = false;
	int myY = y;
	int layer = randIn.nextInt(12);
	Block myFillingBlock = Blocks.lava;
	if(randIn.nextInt(2) == 0){
		myFillingBlock = CookingPlusMain.blockHydrothermal;
	}
	
	while(done == false){
		
		if(layer < 4){
			worldIn.setBlockState(new BlockPos(new Vec3(x + 4, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 4, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 4, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 4, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 4, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 4, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
		
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 3)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 3)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 3)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 3)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 3)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 3)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z + 2)), myFillingBlock.getDefaultState());
		}
		
		if(layer >= 4 && layer < 6){
			worldIn.setBlockState(new BlockPos(new Vec3(x + 4, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 4, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 4)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 3)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 3)), myFillingBlock.getDefaultState());
		}
		
		if(layer >= 6 && layer < 10){
			worldIn.setBlockState(new BlockPos(new Vec3(x + 3, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 3, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 3)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 2)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 2)), myFillingBlock.getDefaultState());
		}
		
		if(layer >= 10 && layer < 13){
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z )), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z )), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x , myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x , myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z)), myFillingBlock.getDefaultState());
		}
		
		if(layer >= 13 && layer < 15){
			worldIn.setBlockState(new BlockPos(new Vec3(x - 2, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 2, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 2)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY + 1, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z + 1)), myFillingBlock.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z - 1)), myFillingBlock.getDefaultState());
		}
		
		if(layer >= 15 && layer < 18){
			worldIn.setBlockState(new BlockPos(new Vec3(x + 1, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x - 1, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x , myY, z + 1)), CookingPlusMain.blockBasalt.getDefaultState());
			worldIn.setBlockState(new BlockPos(new Vec3(x , myY, z - 1)), CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY + 1, z)),  CookingPlusMain.blockBasalt.getDefaultState());
			
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z)), myFillingBlock.getDefaultState());
		}
		
		if(layer >= 18 && layer < 21){
			worldIn.setBlockState(new BlockPos(new Vec3(x, myY, z)), CookingPlusMain.blockBasalt.getDefaultState());
		}
		
		
		if(layer > 20){
			done = true;
		}
		else{
			layer++;
			myY++;
		}
	}
		
	}

	static void AddGiantCorals(int Attempts, int chunkX, int chunkZ, World worldIn, Random randIn){
		
		for(int i = 0; i < Attempts; i++){
		int x = chunkX * 16 + randIn.nextInt(16);
        int z = chunkZ * 16 + randIn.nextInt(16);
        int y = worldIn.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0, z))).getY();
		
		if(worldIn.getBlockState(new BlockPos(new Vec3(x, y - 1, z))).getBlock() == CookingPlusMain.blockCoralRock){
			 if(randIn.nextInt(3) == 0){
				 CookingPlusPreBuiltStructure myTempStructure = new CookingPlusPreBuiltSphereCoral(GetRandomCoralBlock(randIn));
				 myTempStructure.Generate(worldIn, x, y, z, true, 0, randIn);
		 	}
		 	else{
		 		CookingPlusPreBuiltStructure myTempStructure = new CookingPlusPreBuiltSpikyCoral(GetRandomCoralBlock(randIn));
		 		myTempStructure.Generate(worldIn, x, y, z, 3, 3, 0, randIn);
		 	}
		 }
		}
	}

	static Block GetRandomCoralBlock(Random randIn){
		int which = randIn.nextInt(7);
		if(which == 0){
			return CookingPlusMain.blockYellowCoralBlock;
		}
		else if(which == 1){
			return CookingPlusMain.blockBlueCoralBlock;
		}
		else if(which == 2){
			return CookingPlusMain.blockRedCoralBlock;
		}
		else if(which == 3){
			return CookingPlusMain.blockGreenCoralBlock;
		}
		else if(which == 4){
			return CookingPlusMain.blockOrangeCoralBlock;
		}
		else if(which == 5){
			return CookingPlusMain.blockWhiteCoralBlock;
		}
		else{
			return CookingPlusMain.blockBlackCoralBlock;
		}
	}
}
