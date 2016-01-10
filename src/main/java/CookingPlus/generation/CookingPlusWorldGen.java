package CookingPlus.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusLootHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.Dimension.CookingPlusEdenDimensionWorldGen;
import CookingPlus.prebuiltstructures.CookingPlusPreBuiltShipFront;
import CookingPlus.prebuiltstructures.CookingPlusPreBuiltStructure;
import CookingPlus.prebuiltstructures.CookingPlusPreBuiltTropicalHut;
import CookingPlus.prebuiltstructures.CookingPlusPrebuiltFarmhouse;
import CookingPlus.prebuiltstructures.CookingPlusUnderwaterTempleStructure;

public class CookingPlusWorldGen implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimensionId()){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            
            CookingPlusNetherGen.GenerateNetherStructures(world, random, chunkX, chunkZ);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            
            if(random.nextInt(CookingPlusConfig.AbandonedFarmHouseSpawnRate) == 0 && CookingPlusConfig.AbandonedFarmHouseSpawnRate != 0)
            {
            	
            	int mx = chunkX * 16 + random.nextInt(16);
   	         	int mz = chunkZ * 16 + random.nextInt(16);
   	         	int my = world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(mx, 0, mz))).getY();
   	         	BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(new Vec3(mx, 0, mz)));
   	         	Block CheckBlock = world.getBlockState(new BlockPos(mx, my -1, mz)).getBlock();
   	         	if(CheckBlock == Blocks.grass || CheckBlock == Blocks.stone || CheckBlock == Blocks.dirt){
   	         		if(BiomeDictionary.isBiomeOfType(biome, Type.LUSH) || BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS) || BiomeDictionary.isBiomeOfType(biome, Type.FOREST) || BiomeDictionary.isBiomeOfType(biome, Type.PLAINS))
   	         		{
   	         			CookingPlusPreBuiltStructure myTempStructure = new CookingPlusPrebuiltFarmhouse();
   	         			myTempStructure.Generate(world, mx, my, mz, true, 0, random);
   	         		}
   	         	}
            }
            
            if(random.nextInt(CookingPlusConfig.UnderwaterVentSpawnRate) == 0 && CookingPlusConfig.UnderwaterVentSpawnRate != 0)
            {
            	
            	int mx = chunkX * 16 + random.nextInt(16);
   	         	int mz = chunkZ * 16 + random.nextInt(16);
   	         	BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(new Vec3(mx, 0, mz)));
   	         	Block CheckBlock = world.getBlockState(new BlockPos(mx, 1, mz)).getBlock();
   	         	if(!BiomeDictionary.isBiomeOfType(biome, Type.WATER) && !BiomeDictionary.isBiomeOfType(biome, Type.OCEAN))
             	{
   	         		CookingPlusUnderwaterGen.GenerateVent(world, mx, 1, mz, random);
             	}
            }
            
            if(random.nextInt(CookingPlusConfig.BushSpawnRate) == 0 && CookingPlusConfig.BushSpawnRate != 0)
            {
            	int x = chunkX * 16 + random.nextInt(16);
                int z = chunkZ * 16 + random.nextInt(16);
                
                BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(new Vec3(x, 0, z)));
                if(BiomeDictionary.isBiomeOfType(biome, Type.LUSH) || BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS) || BiomeDictionary.isBiomeOfType(biome, Type.FOREST) || BiomeDictionary.isBiomeOfType(biome, Type.PLAINS))
                {
                	SpawnBushes(world, random,x ,z);
                }
            }
            
            if(random.nextInt(CookingPlusConfig.HerbSpawnRate) == 0 && CookingPlusConfig.HerbSpawnRate != 0)
            {
            	int x = chunkX * 16 + random.nextInt(16);
                int z = chunkZ * 16 + random.nextInt(16);
                int y = world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0, z))).getY();
                BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(new Vec3(x, 0, z)));
                if(BiomeDictionary.isBiomeOfType(biome, Type.LUSH) || BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS) || BiomeDictionary.isBiomeOfType(biome, Type.FOREST) || BiomeDictionary.isBiomeOfType(biome, Type.PLAINS))
                {
                	AddHerb(world, random, x , y, z);
                }
            }
            
            if(random.nextInt(CookingPlusConfig.FruitTreeSpawnRate) == 0 && CookingPlusConfig.FruitTreeSpawnRate != 0)
            {
            	int x = chunkX * 16 + random.nextInt(16);
                int z = chunkZ * 16 + random.nextInt(16);
                
                BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(new Vec3(x, 0, z)));
                if(BiomeDictionary.isBiomeOfType(biome, Type.LUSH) || BiomeDictionary.isBiomeOfType(biome, Type.FOREST))
                {
                	int y = world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0, z))).getY();
                	CookingPlusOrchardBiome myBiome = new CookingPlusOrchardBiome(0);
                	myBiome.genBigTreeChance(random).generate(world, random, new BlockPos(new Vec3(x, y, z)));
                }
            }
            
            
            if(random.nextInt(CookingPlusConfig.CornucopiaSpawnRate) == 0  && CookingPlusConfig.CornucopiaSpawnRate != 0)
            {
            	int x = chunkX * 16 + random.nextInt(16);
                int z = chunkZ * 16 + random.nextInt(16);
                int y = world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0, z))).getY();
                AddCornocopia(world, random, x , y, z);
            }
            
            if(random.nextInt(CookingPlusConfig.TropicalHutSpawnRate) == 0 && CookingPlusConfig.TropicalHutSpawnRate != 0)
            {
            	int x = chunkX * 16 + random.nextInt(16);
                int z = chunkZ * 16 + random.nextInt(16);
               
                BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(new Vec3(x, 0, z)));
                if(biome.biomeID == CookingPlusConfig.TropicalID)
                {
                	removeWood(x, z, world);
                	int y = world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0, z))).getY();
                	if(world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x + 1, 0, z))).getY() == y && world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x - 1, 0, z))).getY() == y && world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0, z + 1))).getY() == y && world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(x, 0, z - 1))).getY() == y){
                		CookingPlusPreBuiltStructure myTempStructure = new CookingPlusPreBuiltTropicalHut();
            			myTempStructure.Generate(world, x, y - 1, z, true, 0, random);
                	}
                }
            }
            
            CookingPlusUnderwaterGen.GenerateUnderwaterStructures(world, random, chunkX, chunkZ);
            
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
        
        if(world.provider.getDimensionId() == CookingPlusConfig.EdenDimensionID){
     	   CookingPlusEdenDimensionWorldGen.GenerateWorld(chunkX, chunkZ, world, random);
        }
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for(int k = 0; k < 2; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(32 + 32);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	(new WorldGenMinable(CookingPlusMain.blockSalt.getDefaultState(), 22)).generate(world, rand, new BlockPos(new Vec3(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord)));
        }
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}

	private void clearTrees(int x, int z, int radius, World world)
	{
	        int radiusSquared = radius * radius;
	        for(int i = radius * -1; i <= radius; ++i)
	        {
	                for(int j = radius * -1; j <= radius; ++j)
	                {
	                        if(((i * i) + (j * j)) <= radiusSquared)
	                        {
	                                removeWood(x + i, z + j, world);
	                        }
	                }
	        }
	}
	
	private void removeWood(int x, int z, World world)
	{
	        int y = world.getHeight();
	        while(GetWorldBlock(world, x, y, z) == Blocks.log ||GetWorldBlock(world, x, y, z) == Blocks.log2 || GetWorldBlock(world, x, y, z).canSustainLeaves(world, new BlockPos(new Vec3(x ,y, z))))
	        {
	        	SetWorldBlock(world, x, y, z, Blocks.air, 0, 2); 
	            --y;
	        }
	}

	public static void FillFarmerChest(TileEntityChest MyChest, Random random){
		int chance = 80;
		for(int i = 0; i < 27; i++){
			int mychance = (int) (random.nextFloat() * 100);
			if(mychance > chance){
				chance = 90;
				MyChest.setInventorySlotContents(i, GenChestItem(random));
			}
			else{
				chance -= 7;
			}
		}
	}
	
	private static ItemStack GenChestItem(Random random){
		ItemStack MyStack = new ItemStack(CookingPlusMain.onionseed, 1);
		int which = (int) (random.nextFloat() * 100);
		
		if(which <= 60){
			MyStack = GetRandomSeedItem(random);
		}
		else if(which > 60 && which <= 90){
			MyStack = GetRandomGenericItem(random);
		}
		else if(which > 90 && which <= 100){
			MyStack = GetRandomRareItem(random);
		}
		
		return MyStack;
	}
	
	private static ItemStack GetRandomSeedItem(Random random){
		ItemStack myStack = new ItemStack(CookingPlusMain.onionseed);
		int which = (int) (random.nextFloat() * 100);
		int amount = 1 + (int)(random.nextFloat() * 4);
		int SeedVariations = 16;
		if(which <= 100/SeedVariations){
			myStack = new ItemStack(CookingPlusMain.onionseed, amount);
		}
		else if(which > 100/SeedVariations && which <= (100/SeedVariations) * 2){
			myStack = new ItemStack(CookingPlusMain.chilliseed, amount);
		}
		else if(which > (100/SeedVariations) * 2 && which <= (100/SeedVariations) * 3){
			myStack = new ItemStack(CookingPlusMain.beetrootseed, amount);
		}
		else if(which > (100/SeedVariations) * 3 && which <= (100/SeedVariations) * 4){
			myStack = new ItemStack(CookingPlusMain.grapeseed, amount);
		}
		else if(which > (100/SeedVariations) * 4 && which <= (100/SeedVariations) * 5){
			myStack = new ItemStack(CookingPlusMain.hopseed, amount);
		}
		else if(which > (100/SeedVariations) * 5 && which <= (100/SeedVariations) * 6){
			myStack = new ItemStack(CookingPlusMain.cottonseed, amount);
		}
		else if(which > (100/SeedVariations) * 6 && which <= (100/SeedVariations) * 7){
			myStack = new ItemStack(CookingPlusMain.teaseed, amount);
		}
		else if(which > (100/SeedVariations) * 7 && which <= (100/SeedVariations) * 8){
			myStack = new ItemStack(CookingPlusMain.vanillaseed, amount);
		}
		else if(which > (100/SeedVariations) * 8 && which <= (100/SeedVariations) * 9){
			myStack = new ItemStack(CookingPlusMain.pineappleseed, amount);
		}
		else if(which > (100/SeedVariations) * 9 && which <= (100/SeedVariations) * 10){
			myStack = new ItemStack(CookingPlusMain.riceSeed, amount);
		}
		else if(which > (100/SeedVariations) * 10 && which <= (100/SeedVariations) * 11){
			myStack = new ItemStack(CookingPlusMain.pricklypearseeds, amount);
		}
		else if(which > (100/SeedVariations) * 11 && which <= (100/SeedVariations) * 17){
			myStack = new ItemStack(CookingPlusMain.basicschematic, amount * 3);
		}
		
		return myStack;
	}
	
	private static ItemStack GetRandomGenericItem(Random random){
		ItemStack myStack = new ItemStack(CookingPlusMain.onionseed);
		int SeedVariations = 11;
		int which = random.nextInt(SeedVariations);
		int amount = 1;
		if(which == 0){
			myStack = new ItemStack(CookingPlusMain.woodenscythe, amount);
		}
		else if(which == 1){
			myStack = new ItemStack(CookingPlusMain.fishingnet, amount);
		}
		else if(which == 2){
			myStack = new ItemStack(CookingPlusMain.blockRope, amount);
		}
		else if(which == 3){
			myStack = new ItemStack(CookingPlusMain.mug, amount);
		}
		else if(which == 4){
			myStack = new ItemStack(CookingPlusMain.teapotguide, amount);
		}
		else if(which == 5){
			myStack = new ItemStack(CookingPlusMain.circlecutter, amount);
		}
		else if(which == 6){
			myStack = new ItemStack(CookingPlusMain.starcutter, amount);
		}
		else if(which == 7){
			myStack = new ItemStack(CookingPlusMain.heartcutter, amount);
		}
		else if(which == 8){
			myStack = new ItemStack(CookingPlusMain.mooncutter, amount);
		}
		else if(which == 9){
			myStack = CookingPlusLootHelper.instance().GetRandomProcessor(random);
		}
		else if(which == 10){
			if(random.nextInt(2) == 0){
				myStack = new ItemStack(CookingPlusMain.mysteriousorb, amount);
			}
			else{
				myStack = new ItemStack(CookingPlusMain.chipmold, amount);
			}
		}
		
		
		return myStack;
	}
	
	private static ItemStack GetRandomRareItem(Random random){
		ItemStack myStack = new ItemStack(CookingPlusMain.onionseed);
		int SeedVariations = 7;
		int which = random.nextInt(SeedVariations);
		int amount = 1;
		if(which == 0){
			myStack = new ItemStack(CookingPlusMain.juicer, amount);
		}
		else if(which == 1){
			myStack = new ItemStack(Items.bucket, amount);
		}
		else if(which == 2){
			myStack = new ItemStack(CookingPlusMain.rack, amount);
		}
		else if(which == 3){
			myStack = new ItemStack(CookingPlusMain.blockTeapot, amount);
		}
		else if(which == 4){
			myStack = new ItemStack(CookingPlusMain.blockPlate, amount);
		}
		else if(which == 5){
			myStack = new ItemStack(CookingPlusMain.blockFryingPan, amount);
		}
		else if(which == 6){
			if(random.nextInt(4) > 1){
				myStack = new ItemStack(CookingPlusLootHelper.instance().GetRandomCommonGuide(random), amount);
			}
			else{
				myStack = new ItemStack(CookingPlusLootHelper.instance().GetRandomRareGuide(random), amount);
			}
		}
		
		
		return myStack;
	}

	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
		myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private Block GetWorldBlock(World myWorld, int x, int y, int z){
		return myWorld.getBlockState(new BlockPos(new Vec3(x, y, z))).getBlock();
	}

	private void SpawnBushes(World world, Random rand, int chunkX, int chunkZ){
		int y = world.getTopSolidOrLiquidBlock(new BlockPos(new Vec3(chunkX, 0, chunkZ))).getY();
		//System.out.println("A" + world.getBlock(chunkX, y, chunkZ).getUnlocalizedName());
		if(GetWorldBlock(world, chunkX, y, chunkZ).equals(Blocks.air) == true){
			//System.out.println("B");
			//if(world.getBlock(chunkX, y + 1, chunkZ).equals(Blocks.air)){
				//System.out.println("C");
				AddBush(world, rand, chunkX, y, chunkZ);
			//}
		}
	}
	
	private void AddBush(World world,Random rand, int x, int y, int z){
		int Which = rand.nextInt(4);
		if(Which == 0)
		{
			SpawnBushNode(world, rand, x, y, z, CookingPlusMain.blockBlueBerryBush);
		}
		else if(Which == 1)
		{
			SpawnBushNode(world, rand, x, y, z, CookingPlusMain.blockGooseBerryBush);
		}
		else if(Which == 2)
		{
			SpawnBushNode(world, rand, x, y, z, CookingPlusMain.blockBush);
		}
		else if(Which == 3)
		{
			SpawnBushNode(world, rand, x, y, z, CookingPlusMain.blockStrawBerryBush);
		}
	}
	
	private void SpawnBushNode(World world, Random rand, int x, int y, int z, Block bushBlock){
		
		SetWorldBlock(world, x, y, z, bushBlock, 0, 2);
		if(rand.nextInt(4) == 0){
			if(GetWorldBlock(world,x, y, z + 1) .equals(Blocks.air)){
				SetWorldBlock(world,x, y, z + 1, bushBlock, 0, 2);
			}
		}
		if(rand.nextInt(4) == 0){
			if(GetWorldBlock(world,x, y, z - 1) .equals(Blocks.air)){
				SetWorldBlock(world,x, y, z - 1, bushBlock, 0, 2);
			}
		}
		if(rand.nextInt(4) == 0){
			if(GetWorldBlock(world,x + 1, y, z) .equals(Blocks.air)){
				SetWorldBlock(world,x + 1, y, z, bushBlock, 0, 2);
			}
		}
		if(rand.nextInt(4) == 0){
			if(GetWorldBlock(world,x - 1, y, z) .equals(Blocks.air)){
				SetWorldBlock(world,x - 1, y, z, bushBlock, 0, 2);
			}
		}
		if(rand.nextInt(4) == 0){
			if(GetWorldBlock(world,x, y + 1, z) .equals(Blocks.air)){
				SetWorldBlock(world,x, y + 1, z, bushBlock, 0, 2);
			}
		}
		
	}

	private void AddHerb(World world,Random rand, int x, int y, int z){
		int Which = rand.nextInt(6);
		if(Which == 0)
		{
			SetWorldBlock(world,x, y, z , CookingPlusMain.blockSage, 0, 2);
		}
		else if(Which == 1)
		{
			SetWorldBlock(world,x, y, z , CookingPlusMain.blockMint, 0, 2);
		}
		else if(Which == 2)
		{
			SetWorldBlock(world,x, y, z, CookingPlusMain.blockBuchu, 0, 2);
		}
		else if(Which == 3)
		{
			SetWorldBlock(world,x, y, z, CookingPlusMain.blockRosemary, 0, 2);
		}
		else if(Which == 4)
		{
			SetWorldBlock(world,x, y, z, CookingPlusMain.blockLicorice, 0, 2);
		}
		else if(Which == 5)
		{
			SetWorldBlock(world,x, y, z, CookingPlusMain.blockChamomile, 0, 2);
		}
	}

	private void AddCornocopia(World world,Random rand, int x, int y, int z){
		
		for(int i = y - 1; i > 1; i--){
			if(GetWorldBlock(world, x, i, z) == Blocks.air){
				if(GetWorldBlock(world, x, i-1, z) == Blocks.stone){
					SetWorldBlock(world, x, i, z, CookingPlusMain.blockOrnateChest, 0, 2);
					
					SetWorldBlock(world, x, i, z, Blocks.chest, 0, 2);
					TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(new BlockPos(new Vec3( x, i, z)));
					if (tileentitychest != null && tileentitychest.getSizeInventory() > 0) {
						FillCornocopiaChest(tileentitychest, rand);
						//ItemStack itemstack = new ItemStack(CookingPlusMain.onionseed, 2);
						//tileentitychest.setInventorySlotContents(0, itemstack);
					}
					
					SpreadCornocopia(world, rand, x, i, z);
					SetWorldBlock(world, x, i-1, z, Blocks.grass, 0, 2);
					//System.out.println(x + " " + i + " " + z);
					i = 0;
				}
			}
		}
		
	}
	
	private void SpreadCornocopia(World world,Random rand, int x, int y, int z){
		int CornSize = rand.nextInt(10) + 10;
		for(int w = x - CornSize/2; w < x + CornSize/2; w++){
			for(int h = z - CornSize/2; h < z + CornSize/2; h++){
				for(int d = y - CornSize/2; d < y + CornSize/2; d++){
					BlockPos myPos = new BlockPos(new Vec3(w, d, h));
					//System.out.println("blah");
					if(world.getBlockState(myPos) != null){
						if(world.getBlockState(myPos).getBlock() == Blocks.stone){
							//System.out.println("yo");
							if(world.getBlockState(myPos.up()).getBlock() == Blocks.air){
								SetWorldBlock(world, myPos.getX(), myPos.getY(), myPos.getZ(), Blocks.grass, 0, 2);
								SetWorldBlock(world, myPos.getX(), myPos.up().getY(), myPos.getZ(), GetRandomPlant(rand), 0, 2);
							}
							else if(world.getBlockState(myPos.down()).getBlock() == Blocks.air && myPos.down().getY() > y){
								SetWorldBlock(world, myPos.getX(), myPos.getY(), myPos.getZ(), Blocks.glowstone, 0, 2);
							}
							else{
								SetWorldBlock(world, myPos.getX(), myPos.getY(), myPos.getZ(), Blocks.dirt, 0, 2);
							}
						}
					}
				}
			}
		}
	}

	private void FillCornocopiaChest(TileEntityChest MyChest, Random random){
		int chance = 90;
		for(int i = 0; i < 27; i++){
			MyChest.setInventorySlotContents(i, GenChestItem(random));
		}
	}

	private Block GetRandomPlant(Random rand){
		int Which = rand.nextInt(6);
		if(Which == 0)
		{
			return CookingPlusMain.blockSage;
		}
		else if(Which == 1)
		{
			return CookingPlusMain.blockMint;
		}
		else if(Which == 2)
		{
			return CookingPlusMain.blockBuchu;
		}
		else if(Which == 3)
		{
			return CookingPlusMain.blockRosemary;
		}
		else if(Which == 4)
		{
			return CookingPlusMain.blockLicorice;
		}
		else if(Which == 5)
		{
			return CookingPlusMain.blockChamomile;
		}
		return null;
	}

}