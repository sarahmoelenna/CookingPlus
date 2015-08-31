package CookingPlus.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;


public class CookingPlusGenBambooTree extends WorldGenAbstractTree
{
	private final int minTreeHeight;
	private final int randomTreeHeight;

	private final boolean vinesGrow;

	private final Block wood;
	private final Block leaves;
	
	private final int metaWood;
	private int metaLeaves;
	
	private int metaFruit = -1;
	
	public CookingPlusGenBambooTree(Block wood, Block leaves, int metaWood, int metaLeaves)
	{
		this(wood, leaves, metaWood, metaLeaves, false, 4, 3, false);
	}
	
	public CookingPlusGenBambooTree(Block wood, Block leaves, int metaWood, int metaLeaves, int metaFruit)
	{
		this(wood, leaves, metaWood, metaLeaves, false, 5, 4, false);
		
		this.metaFruit = metaFruit;
	}

	public CookingPlusGenBambooTree(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight, boolean vinesGrow)
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

    @Override
	public boolean generate(World par1World, Random par2Random, BlockPos MyPos)
    {
    	
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

                            if (!this.isReplaceable(par1World, new BlockPos(new Vec3(j1, i1, k1))))
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

                boolean isSoil = block2.canSustainPlant(par1World, new BlockPos(new Vec3(myX, myY - 1, myZ)), EnumFacing.UP, (BlockSapling)Blocks.sapling);
                
                if (isSoil && myY < 256 - l - 1)
                {
                    //block2.onPlantGrow(par1World, new BlockPos(new Vec3(myX, myY - 1, myZ)), new BlockPos(new Vec3(myX, myY, myZ)));
                    b0 = 3;
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;
                    /*
                    for (k1 = myY - b0 + l; k1 <= myY + l; ++k1)
                    {
                        i3 = k1 - (myY + l);
                        l1 = b1 + 1 - i3 / 2;

                        for (i2 = myX - l1; i2 <= myX + l1; ++i2)
                        {
                            j2 = i2 - myX;

                            for (int k2 = myZ - l1; k2 <= myZ + l1; ++k2)
                            {
                                int l2 = k2 - myZ;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || par2Random.nextInt(2) != 0 && i3 != 0)
                                {
                                    Block block1 = GetWorldBlock(par1World, i2, k1, k2);

                                    if (block1.isAir(par1World, new BlockPos(new Vec3(i2, k1, k2))) || block1.isLeaves(par1World, new BlockPos(new Vec3(i2, k1, k2))))
                                    {                                    	
                                        this.func_175905_a(par1World, new BlockPos(new Vec3(i2, k1, k2)), this.leaves, this.metaLeaves);	////////hmmm
                                    }
                                }
                            }
                        }
                    }
					*/
                    for (k1 = 0; k1 < l; ++k1)
                    {
                        block = GetWorldBlock(par1World, myX, myY + k1, myZ);

                        if (block.isAir(par1World, new BlockPos(new Vec3(myX, myY + k1, myZ))) || block.isLeaves(par1World,new BlockPos(new Vec3(myX, myY + k1, myZ))))
                        {
                            this.func_175905_a(par1World, new BlockPos(new Vec3(myX, myY + k1, myZ)), this.wood, this.metaWood);
                            if(myY + k1 > minTreeHeight){
                            	Count++;
                            	if(GenLeaves(par1World, myX, myY + k1, myZ, par2Random, Count)){
                            		Count = 0;
                            	}
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

	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
		myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta){
		myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private Block GetWorldBlock(World myWorld, int x, int y, int z){
		return myWorld.getBlockState(new BlockPos(new Vec3(x, y, z))).getBlock();
	}
	
	private boolean GenLeaves(World myWorld, int x, int y, int z, Random myRand, int count){
		if(myRand.nextInt(5) + count > 5){
			this.func_175905_a(myWorld, new BlockPos(new Vec3(x + 1, y, z )), this.leaves, 0);
			this.func_175905_a(myWorld, new BlockPos(new Vec3(x - 1, y, z)), this.leaves, 0);
			this.func_175905_a(myWorld, new BlockPos(new Vec3(x, y, z - 1)), this.leaves, 0);
			this.func_175905_a(myWorld, new BlockPos(new Vec3(x, y, z + 1)), this.leaves, 0);
			return true;
		}
		return false;
	}
}