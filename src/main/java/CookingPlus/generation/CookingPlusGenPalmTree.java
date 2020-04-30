package CookingPlus.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import CookingPlus.CookingPlusMain;


public class CookingPlusGenPalmTree extends WorldGenAbstractTree
{
	private final int minTreeHeight;
	private final int randomTreeHeight;

	private final boolean vinesGrow;

	private final Block wood;
	private final Block leaves;
	
	private final int metaWood;
	private int metaLeaves;
	
	private int metaFruit = -1;
	
	public CookingPlusGenPalmTree(Block wood, Block leaves, int metaWood, int metaLeaves)
	{
		this(wood, leaves, metaWood, metaLeaves, false, 4, 3, false);
	}
	
	public CookingPlusGenPalmTree(Block wood, Block leaves, int metaWood, int metaLeaves, int metaFruit)
	{
		this(wood, leaves, metaWood, metaLeaves, false, 5, 4, false);
		
		this.metaFruit = metaFruit;
	}

	public CookingPlusGenPalmTree(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight, boolean vinesGrow)
	{
		super(doBlockNotify);
		
		this.wood = wood;
		this.leaves = leaves;
		this.metaWood = metaWood;
		this.metaLeaves = metaLeaves;
		this.minTreeHeight = minTreeHeight;
		this.randomTreeHeight = randomTreeHeight;
		this.vinesGrow = vinesGrow;
	}
	
	public CookingPlusGenPalmTree(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight, boolean vinesGrow, int metafruit)
	{
		super(doBlockNotify);
		
		this.wood = wood;
		this.leaves = leaves;
		this.metaWood = metaWood;
		this.metaLeaves = metaLeaves;
		this.minTreeHeight = minTreeHeight;
		this.randomTreeHeight = randomTreeHeight;
		this.vinesGrow = vinesGrow;
		this.metaFruit = metafruit;
	}

    @Override
	public boolean generate(World par1World, Random par2Random, BlockPos MyPos)
    {
    	int Rotation = par2Random.nextInt(4);
    	int myX = MyPos.getX();
    	int myY = MyPos.getY();
    	int myZ = MyPos.getZ();
    	int Count = 0;
    	
        int l = par2Random.nextInt(this.randomTreeHeight) + this.minTreeHeight;
        boolean flag = true;

        if (myY >= 1 && myY + l + 1 <= 256)
        {
            byte b0;
            int k1;
            Block block;

            for (int i1 = myY; i1 <= myY + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == myY)
                {
                    b0 = 0;
                }

                if (i1 >= myY + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int j1 = myX - b0; j1 <= myX + b0 && flag; ++j1)
                {
                    for (k1 = myZ - b0; k1 <= myZ + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            block = GetWorldBlock(par1World, j1, i1, k1);

                            if (!this.isReplaceable(par1World, new BlockPos(new Vec3d(j1, i1, k1))))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = GetWorldBlock(par1World, myX, myY - 1, myZ);

                //boolean isSoil = block2.canSustainPlant(par1World, new BlockPos(new Vec3d(myX, myY - 1, myZ)), EnumFacing.UP, (BlockSapling)Blocks.sapling);
                
                if (block2 == Blocks.SAND && myY < 256 - l - 1)
                {
                    //block2.onPlantGrow(par1World, new BlockPos(new Vec3d(myX, myY - 1, myZ)), new BlockPos(new Vec3d(myX, myY, myZ)));
                    b0 = 3;
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;
                    BlockPos myPos = new BlockPos(new Vec3d(0, 0 ,0));
                    for (k1 = 0; k1 < l; ++k1)
                    {
                    	if(k1 < 2 || k1 > l - 3){
                    		myPos = new BlockPos(new Vec3d(myX, myY + k1, myZ));
                    	}
                    	else{
                    		if(Rotation == 0){
                    			myPos = new BlockPos(new Vec3d(myX + 1, myY + k1, myZ));
                    		}
                    		else if(Rotation == 1){
                    			myPos = new BlockPos(new Vec3d(myX - 1, myY + k1, myZ));
                    		}
                    		else if(Rotation == 2){
                    			myPos = new BlockPos(new Vec3d(myX, myY + k1, myZ + 1));
                    		}
                    		else if(Rotation == 3){
                    			myPos = new BlockPos(new Vec3d(myX, myY + k1, myZ - 1));
                    		}
                    	}
                    	if(k1 == l - 1){
                    		if(Rotation == 0){
                    			myPos = new BlockPos(new Vec3d(myX - 1, myY + k1, myZ));
                    			
                    			//setPosToWood(new BlockPos(new Vec3d(myX - 1 - 1, myY + k1, myZ)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX - 1 + 1, myY + k1, myZ)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX - 1, myY + k1, myZ + 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX - 1, myY + k1, myZ - 1)), par1World);
                    		}
                    		else if(Rotation == 1){
                    			myPos = new BlockPos(new Vec3d(myX + 1, myY + k1, myZ));
                    			
                    			//setPosToWood(new BlockPos(new Vec3d(myX + 1 - 1, myY + k1, myZ)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX + 1 + 1, myY + k1, myZ)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX + 1, myY + k1, myZ + 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX + 1, myY + k1, myZ - 1)), par1World);
                    		}
                    		else if(Rotation == 2){
                    			myPos = new BlockPos(new Vec3d(myX, myY + k1, myZ - 1));
                    			
                    			//setPosToWood(new BlockPos(new Vec3d(myX + 1, myY + k1, myZ - 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX - 1, myY + k1, myZ - 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX, myY + k1, myZ - 1 + 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX, myY + k1, myZ - 1 - 1)), par1World);
                    		}
                    		else if(Rotation == 3){
                    			myPos = new BlockPos(new Vec3d(myX, myY + k1, myZ + 1));
                    			
                    			//setPosToWood(new BlockPos(new Vec3d(myX + 1, myY + k1, myZ + 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX - 1, myY + k1, myZ + 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX, myY + k1, myZ + 1 + 1)), par1World);
                    			//setPosToWood(new BlockPos(new Vec3d(myX, myY + k1, myZ + 1 - 1)), par1World);
                    		}
                    	}
                    	
                        block = par1World.getBlockState(myPos).getBlock();

                        if (block.isAir(par1World.getBlockState(myPos), par1World, myPos) || block.isLeaves(par1World.getBlockState(myPos), par1World,myPos))
                        {
                            this.setBlockAndNotifyAdequately(par1World, myPos, this.wood.getDefaultState());
                            
                            if(k1 == l - 1){
                            	GenLeaves(par1World, myPos.up(), par2Random);
                            }
                        }
                    }
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void setPosToWood(BlockPos myPos, World par1World){
    	 Block block = par1World.getBlockState(myPos).getBlock();
    	 if (block.isAir(par1World.getBlockState(myPos), par1World, myPos) || block.isLeaves(par1World.getBlockState(myPos), par1World,myPos))
         {
             this.setBlockAndNotifyAdequately(par1World, myPos, this.wood.getDefaultState());
         }
    }
    
	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
		myWorld.setBlockState(new BlockPos(new Vec3d(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta){
		myWorld.setBlockState(new BlockPos(new Vec3d(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private Block GetWorldBlock(World myWorld, int x, int y, int z){
		return myWorld.getBlockState(new BlockPos(new Vec3d(x, y, z))).getBlock();
	}
	
	private boolean GenLeaves(World myWorld, BlockPos myPos, Random myRand){
			this.setBlockAndNotifyAdequately(myWorld, myPos.up(), this.leaves.getDefaultState());
			
			//System.out.println(this.metaFruit);
			
			AddLeaf(myWorld, myPos, myRand);
			AddLeaf(myWorld, myPos.north(), myRand);
			AddLeaf(myWorld, myPos.north().west(), myRand);
			AddLeaf(myWorld, myPos.north().east(), myRand);
			AddLeaf(myWorld, myPos.east(), myRand);
			AddLeaf(myWorld, myPos.south(), myRand);
			AddLeaf(myWorld, myPos.south().east(), myRand);
			AddLeaf(myWorld, myPos.south().west(), myRand);
			AddLeaf(myWorld, myPos.west(), myRand);
			
			AddLeaf(myWorld, myPos.north().north(), myRand);
			AddLeaf(myWorld, myPos.east().east(), myRand);
			AddLeaf(myWorld, myPos.south().south(), myRand);
			AddLeaf(myWorld, myPos.west().west(), myRand);
			
			AddLeaf(myWorld, myPos.north().north().east().east().down(), myRand);
			AddLeaf(myWorld, myPos.north().north().west().west().down(), myRand);
			AddLeaf(myWorld, myPos.south().south().east().east().down(), myRand);
			AddLeaf(myWorld, myPos.south().south().west().west().down(), myRand);
			
			AddLeaf(myWorld, myPos.north().north().north().down(), myRand);
			AddLeaf(myWorld, myPos.east().east().east().down(), myRand);
			AddLeaf(myWorld, myPos.south().south().south().down(), myRand);
			AddLeaf(myWorld, myPos.west().west().west().down(), myRand);
			
			return true;
	}

	private void AddLeaf(World myWorld, BlockPos myPos, Random myRand){
		if(myWorld.getBlockState(myPos).getBlock() == Blocks.AIR){
		this.setBlockAndNotifyAdequately(myWorld, myPos, this.leaves.getDefaultState());
		if(metaFruit > 0){
			if(myWorld.getBlockState(myPos.down()).getBlock() == Blocks.AIR){
				if(myRand.nextInt(10) > 7){
					if(metaFruit == 1){
						this.setBlockAndNotifyAdequately(myWorld, myPos.down(), CookingPlusMain.blockCoconutBlock.getDefaultState());
					}
					if(metaFruit == 2){
						this.setBlockAndNotifyAdequately(myWorld, myPos.down(), CookingPlusMain.blockBananaBlock.getDefaultState());
					}
				}
			}
		}
		}
	}

}

