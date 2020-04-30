package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class CookingPlusNullBlock extends CookingPlusCustomBlock {
	
	public CookingPlusNullBlock() {
        super(Material.GLASS);
        this.setUnlocalizedName("nullblock");
        //this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.setSoundType(SoundType.STONE);
		this.setLightOpacity(0);
		GameRegistry.registerBlock(this, "nullblock");
		//this.setBlockTextureName("cookingplus:nullblock");
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos myPos, IBlockState myState) {
		int i = myPos.getX();
		int j = myPos.getY();
		int k = myPos.getZ();
		//super.onBlockDestroyedByPlayer(world, i, j, k, p_149664_5_);
		if(GetWorldBlock(world, i, j - 1, k).equals(CookingPlusMain.blockBrickOven)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			SetWorldBlock(world, i, j + 1, k, Blocks.AIR, 0, 2);
			//GetWorldBlock(world, i, j - 1, k).breakBlock(world, i, j, k, Blocks.AIR, 2);
			GetWorldBlock(world, i, j - 1, k).dropBlockAsItem(world, new BlockPos(new Vec3d(i, j - 1, k)), myState, 0);
			world.setBlockToAir(new BlockPos(new Vec3d(i, j - 1, k)));
		}
		if(GetWorldBlock(world, i, j - 2, k).equals(CookingPlusMain.blockBrickOven)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			SetWorldBlock(world, i, j - 1, k, Blocks.AIR, 0, 2);
			//GetWorldBlock(world, i, j - 2, k).breakBlock(world, i, j, k, Blocks.AIR, 2);
			GetWorldBlock(world, i, j - 2, k).dropBlockAsItem(world, new BlockPos(new Vec3d(i, j - 2, k)), myState, 0);
			world.setBlockToAir(new BlockPos(new Vec3d(i, j - 2, k)));
		}
		if(GetWorldBlock(world, i, j - 1, k).equals(CookingPlusMain.blockButterChurn)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			GetWorldBlock(world, i, j - 1, k).dropBlockAsItem(world, new BlockPos(new Vec3d(i, j - 1, k)), myState, 0);
			world.setBlockToAir(new BlockPos(new Vec3d(i, j - 1, k)));
		}
		if(GetWorldBlock(world, i, j - 1, k).equals(CookingPlusMain.blockLeyDesynth)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			GetWorldBlock(world, i, j - 1, k).dropBlockAsItem(world, new BlockPos(new Vec3d(i, j - 1, k)), myState, 0);
			world.setBlockToAir(new BlockPos(new Vec3d(i, j - 1, k)));
		}
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos myPos, Explosion p_149723_5_) {
		
		int i = myPos.getX();
		int j = myPos.getY();
		int k = myPos.getZ();
		
		//super.onBlockDestroyedByPlayer(world, i, j, k, p_149664_5_);
		if(GetWorldBlock(world, i, j - 1, k).equals(CookingPlusMain.blockBrickOven)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			SetWorldBlock(world, i, j + 1, k, Blocks.AIR, 0, 2);
			GetWorldBlock(world, i, j - 1, k).breakBlock(world, new BlockPos(new Vec3d(i, j - 1, k)), world.getBlockState(new BlockPos(new Vec3d(i, j - 1, k))));
		}
		if(GetWorldBlock(world, i, j - 2, k).equals(CookingPlusMain.blockBrickOven)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			SetWorldBlock(world, i, j - 1, k, Blocks.AIR, 0, 2);
			GetWorldBlock(world, i, j - 2, k).breakBlock(world, new BlockPos(new Vec3d(i, j - 2, k)), world.getBlockState(new BlockPos(new Vec3d(i, j - 2, k))));
		}
		if(GetWorldBlock(world, i, j - 1, k).equals(CookingPlusMain.blockButterChurn)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			GetWorldBlock(world, i, j - 1, k).dropBlockAsItem(world, new BlockPos(new Vec3d(i, j - 1, k)), world.getBlockState(new BlockPos(new Vec3d(i, j - 1, k))), 0);
			world.setBlockToAir(new BlockPos(new Vec3d(i, j - 1, k)));
		}
		if(GetWorldBlock(world, i, j - 1, k).equals(CookingPlusMain.blockLeyDesynth)){
			SetWorldBlock(world, i, j, k, Blocks.AIR, 0, 2);
			GetWorldBlock(world, i, j - 1, k).dropBlockAsItem(world, new BlockPos(new Vec3d(i, j - 1, k)), world.getBlockState(new BlockPos(new Vec3d(i, j - 1, k))), 0);
			world.setBlockToAir(new BlockPos(new Vec3d(i, j - 1, k)));
		}
	}
	
	 
	 
	 public boolean isOpaqueCube()
	    {
	        return false;
	    }
	 
	 
	@Override
	public int quantityDropped(IBlockState myState, int fortune, Random random) {
		   return 0;
	}
	
	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
		myWorld.setBlockState(new BlockPos(new Vec3d(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private Block GetWorldBlock(World myWorld, int x, int y, int z){
		return myWorld.getBlockState(new BlockPos(new Vec3d(x, y, z))).getBlock();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
}
