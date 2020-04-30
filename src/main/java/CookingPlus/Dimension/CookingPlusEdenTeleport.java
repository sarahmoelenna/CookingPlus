package CookingPlus.Dimension;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import CookingPlus.CookingPlusMain;

import com.google.common.collect.Lists;

public class CookingPlusEdenTeleport extends Teleporter {

	private final WorldServer worldServerInstance;
	private final List destinationCoordinateKeys = Lists.newArrayList();
	private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(4096);
	
	public CookingPlusEdenTeleport(WorldServer worldIn) {
		super(worldIn);
		
		worldServerInstance = worldIn;
	}
	
	@Override
	public boolean makePortal(Entity myEnt)
    {
		BlockPos myPos = myEnt.getPosition();
		
		myPos = this.worldServerInstance.getTopSolidOrLiquidBlock(myPos);
		
		if(myPos.getY() == 0){
			myPos = new BlockPos(myPos.getX(), 120, myPos.getZ());
		}
		
		int OffsetX = 0;
		int OffsetY = 0;
		int OffsetZ = 0;
		System.out.println(myPos.getX() + myPos.getY() + myPos.getZ());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 0 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 1 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, -1 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), CookingPlusMain.blockCoralRockSmooth.getDefaultState());
		
		OffsetY = 1;
		
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.WATER.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.WATER.getDefaultState());
		
		OffsetY = 2;
		
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.AIR.getDefaultState());
		
		OffsetY = 3;
		
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 0 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, -1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.AIR.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, -1 + OffsetY, 1 + OffsetZ), Blocks.AIR.getDefaultState());
		
		
		OffsetY = 0;
		
		worldServerInstance.setBlockState(myPos.add(2 + OffsetX, 0 + OffsetY, 0 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(2 + OffsetX, 0 + OffsetY, 1 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(2 + OffsetX, 0 + OffsetY, -1 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-2 + OffsetX, 0 + OffsetY, 0 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-2 + OffsetX, 0 + OffsetY, 1 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-2 + OffsetX, 0 + OffsetY, -1 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, 0 + OffsetY, 2 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, 0 + OffsetY, 2 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, 0 + OffsetY, 2 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(0 + OffsetX, 0 + OffsetY, -2 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(1 + OffsetX, 0 + OffsetY, -2 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		worldServerInstance.setBlockState(myPos.add(-1 + OffsetX, 0 + OffsetY, -2 + OffsetZ), CookingPlusMain.blockCoralRockCarved.getDefaultState());
		
		return true;
    }
	/*
	@Override
	 public boolean placeInExistingPortal(Entity entityIn, float rotationYaw)
    {
        int i = 128;
        double d0 = -1.0D;
        int j = MathHelper.floor_double(entityIn.posX);
        int k = MathHelper.floor_double(entityIn.posZ);
        boolean flag = true;
        BlockPos blockpos = BlockPos.ORIGIN;
        long l = ChunkCoordIntPair.chunkXZ2Int(j, k);

        if (this.destinationCoordinateCache.containsItem(l))
        {
            Teleporter.PortalPosition teleporter$portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(l);
            d0 = 0.0D;
            blockpos = teleporter$portalposition;
            teleporter$portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else
        {
            BlockPos blockpos3 = new BlockPos(entityIn);

            for (int i1 = -128; i1 <= 128; ++i1)
            {
                BlockPos blockpos2;

                for (int j1 = -128; j1 <= 128; ++j1)
                {
                    for (BlockPos blockpos1 = blockpos3.add(i1, this.worldServerInstance.getActualHeight() - 1 - blockpos3.getY(), j1); blockpos1.getY() >= 0; blockpos1 = blockpos2)
                    {
                        blockpos2 = blockpos1.down();

                        if (this.worldServerInstance.getBlockState(blockpos1).getBlock() == Blocks.portal)
                        {
                            while (this.worldServerInstance.getBlockState(blockpos2 = blockpos1.down()).getBlock() == Blocks.portal)
                            {
                                blockpos1 = blockpos2;
                            }

                            double d1 = blockpos1.distanceSq(blockpos3);

                            if (d0 < 0.0D || d1 < d0)
                            {
                                d0 = d1;
                                blockpos = blockpos1;
                            }
                        }
                    }
                }
            }
        }

        if (d0 >= 0.0D)
        {
            if (flag)
            {
                this.destinationCoordinateCache.add(l, new Teleporter.PortalPosition(blockpos, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(l));
            }

            double d5 = (double)blockpos.getX() + 0.5D;
            double d6 = (double)blockpos.getY() + 0.5D;
            double d7 = (double)blockpos.getZ() + 0.5D;
            BlockPattern.PatternHelper blockpattern$patternhelper = Blocks.portal.func_181089_f(this.worldServerInstance, blockpos);
            boolean flag1 = blockpattern$patternhelper.getFinger().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE;
            double d2 = blockpattern$patternhelper.getFinger().getAxis() == EnumFacing.Axis.X ? (double)blockpattern$patternhelper.func_181117_a().getZ() : (double)blockpattern$patternhelper.func_181117_a().getX();
            d6 = (double)(blockpattern$patternhelper.func_181117_a().getY() + 1) - entityIn.func_181014_aG().yCoord * (double)blockpattern$patternhelper.func_181119_e();

            if (flag1)
            {
                ++d2;
            }

            if (blockpattern$patternhelper.getFinger().getAxis() == EnumFacing.Axis.X)
            {
                d7 = d2 + (1.0D - entityIn.func_181014_aG().xCoord) * (double)blockpattern$patternhelper.func_181118_d() * (double)blockpattern$patternhelper.getFinger().rotateY().getAxisDirection().getOffset();
            }
            else
            {
                d5 = d2 + (1.0D - entityIn.func_181014_aG().xCoord) * (double)blockpattern$patternhelper.func_181118_d() * (double)blockpattern$patternhelper.getFinger().rotateY().getAxisDirection().getOffset();
            }

            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            float f3 = 0.0F;

            if (blockpattern$patternhelper.getFinger().getOpposite() == entityIn.func_181012_aH())
            {
                f = 1.0F;
                f1 = 1.0F;
            }
            else if (blockpattern$patternhelper.getFinger().getOpposite() == entityIn.func_181012_aH().getOpposite())
            {
                f = -1.0F;
                f1 = -1.0F;
            }
            else if (blockpattern$patternhelper.getFinger().getOpposite() == entityIn.func_181012_aH().rotateY())
            {
                f2 = 1.0F;
                f3 = -1.0F;
            }
            else
            {
                f2 = -1.0F;
                f3 = 1.0F;
            }

            double d3 = entityIn.motionX;
            double d4 = entityIn.motionZ;
            entityIn.motionX = d3 * (double)f + d4 * (double)f3;
            entityIn.motionZ = d3 * (double)f2 + d4 * (double)f1;
            entityIn.rotationYaw = rotationYaw - (float)(entityIn.func_181012_aH().getOpposite().getHorizontalIndex() * 90) + (float)(blockpattern$patternhelper.getFinger().getHorizontalIndex() * 90);
            entityIn.setLocationAndAngles(d5, d6, d7, entityIn.rotationYaw, entityIn.rotationPitch);
            return true;
        }
        else
        {
            return false;
        }
    }
	*/
	private boolean func_180265_a(BlockPos p_180265_1_)
    {
        return !this.worldServerInstance.isAirBlock(p_180265_1_) || !this.worldServerInstance.isAirBlock(p_180265_1_.up());
    }

	
}
