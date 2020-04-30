package CookingPlus.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusConfig;

public class CookingPlusCustomSpreadingHerb extends CookingPlusCustomBlock {

	public static final PropertyInteger PlayerPlaced = PropertyInteger.create("placed", 0, 1);
	
	protected CookingPlusCustomSpreadingHerb() {
		super(Material.PLANTS);
		this.setSoundType(SoundType.GROUND);
		this.setTickRandomly(true);
		this.setLightOpacity(0);
		if(CookingPlusConfig.SpawnedHerbSpreading == false){
			this.setDefaultState(this.blockState.getBaseState().withProperty(PlayerPlaced, Integer.valueOf(0)));
		}
		else{
			this.setDefaultState(this.blockState.getBaseState().withProperty(PlayerPlaced, Integer.valueOf(1)));
		}
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
		if(CookingPlusConfig.PlayerHerbSpreading == true){
			return this.getStateFromMeta(meta).withProperty(PlayerPlaced, 1);
		}
		else{
			return this.getStateFromMeta(meta);
		}
    }
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos,IBlockState myState, int fortune) {
		List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
		ret.clear();

		Random MyRand = new Random();
		if (MyRand.nextInt(10) <= 8) {
			ret.add(new ItemStack(Item.getItemFromBlock(GetHerbItem()), 1, 0)); // extra seeds if grown
		}
		else{
			ret.add(new ItemStack(GetHarvestItem(), MyRand.nextInt(5) + 1, 0)); // extra seeds if grown
		}
		
		return ret;
	}
	
	protected Item GetHarvestItem(){
		return null;
	}
	
	protected Block GetHerbItem(){
		return null;
	}


	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) 
	{
		if(((Integer)state.getValue(PlayerPlaced)).intValue() == 1){
		if (worldIn.getLightFromNeighbors(pos.up()) >= 9){
			//System.out.println("ho ho ho");
			if(rand.nextInt(100) > 100 - CookingPlusConfig.HerbSpreadRate){
				int place = rand.nextInt(4);
				//System.out.println("place: " + place);
					if(place == 0){
						boolean done = false;
						if(worldIn.getBlockState(pos.north()) != null){ // up one block
							if(worldIn.getBlockState(pos.north()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.north().up()).getBlock().getMaterial(worldIn.getBlockState(pos.north().up())) == Material.AIR){
									worldIn.setBlockState(pos.north().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.north().down()) != null){ // same level
							if(worldIn.getBlockState(pos.north().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.north()).getBlock().getMaterial(worldIn.getBlockState(pos.north())) == Material.AIR){
									worldIn.setBlockState(pos.north(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.north().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.north().down().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.north().down()).getBlock().getMaterial(worldIn.getBlockState(pos.north().down())) == Material.AIR){
									worldIn.setBlockState(pos.north().down(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
					}
					
					if(place == 1){
						boolean done = false;
						if(worldIn.getBlockState(pos.east()) != null){ // up one block
							if(worldIn.getBlockState(pos.east()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.east().up()).getBlock().getMaterial(worldIn.getBlockState(pos.east().up())) == Material.AIR){
									worldIn.setBlockState(pos.east().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.east().down()) != null){ // same level
							if(worldIn.getBlockState(pos.east().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.east()).getBlock().getMaterial(worldIn.getBlockState(pos.east())) == Material.AIR){
									worldIn.setBlockState(pos.east(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.east().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.east().down().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.east().down()).getBlock().getMaterial(worldIn.getBlockState(pos.east().down())) == Material.AIR){
									worldIn.setBlockState(pos.east().down(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
					}
					
					if(place == 2){
						boolean done = false;
						if(worldIn.getBlockState(pos.west()) != null){ // up one block
							if(worldIn.getBlockState(pos.west()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.west().up()).getBlock().getMaterial(worldIn.getBlockState(pos.west().up())) == Material.AIR){
									worldIn.setBlockState(pos.west().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.west().down()) != null){ // same level
							if(worldIn.getBlockState(pos.west().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.west()).getBlock().getMaterial(worldIn.getBlockState(pos.west())) == Material.AIR){
									worldIn.setBlockState(pos.west(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.west().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.west().down().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.west().down()).getBlock().getMaterial(worldIn.getBlockState(pos.west().down())) == Material.AIR){
									worldIn.setBlockState(pos.west().down(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
					}
					
					if(place == 3){
						boolean done = false;
						if(worldIn.getBlockState(pos.south()) != null){ // up one block
							if(worldIn.getBlockState(pos.south()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.south().up()).getBlock().getMaterial(worldIn.getBlockState(pos.south().up())) == Material.AIR){
									worldIn.setBlockState(pos.south().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.south().down()) != null){ // same level
							if(worldIn.getBlockState(pos.south().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.south()).getBlock().getMaterial(worldIn.getBlockState(pos.south())) == Material.AIR){
									worldIn.setBlockState(pos.south(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.south().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.west().south().down()).getBlock() == Blocks.GRASS){
								if(worldIn.getBlockState(pos.south().down()).getBlock().getMaterial(worldIn.getBlockState(pos.south().down())) == Material.AIR){
									worldIn.setBlockState(pos.south().down(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
					}
			}
		}
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock)
    {
		if(worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	 {
		//System.out.println("meow");
	     return (worldIn.getBlockState(pos.down()).getBlock() == Blocks.GRASS);
	 }
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {PlayerPlaced});
    }

	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PlayerPlaced, Integer.valueOf(meta));
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(PlayerPlaced)).intValue();
    }
	
	
	
	
	
	 public void setBlockBounds(float x1, float y1, float z1, float x2, float y2, float z2){
			MY_FULL_BLOCK_AABB = new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
		}
		
	 @Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
			if(MY_FULL_BLOCK_AABB != null){
				return MY_FULL_BLOCK_AABB;
			}
			else{
				return super.getBoundingBox(state, source, pos);
			}
	    }
	    
	    
	  //LETS FIX THESE OPAQUE CUBES
	    public boolean isVisuallyOpaque()
	    {
	        return isOpaqueCube();
	    }
		
		public boolean isOpaqueCube()
	    {
	        return false;
	    }
		
		
		//LETS FIX THESE FULL CUBES
		@Override
		public boolean isFullCube(IBlockState state)
	    {
	        return isFullCube();
	    }
		
	    public boolean isFullCube()
	    {
	        return false;
	    }
		
	    
	    //LETS FIX OUR LEAVES
	    @Override
	    public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
	    {
	        return canSustainLeaves(world, pos);
	    }
	    
		public boolean canSustainLeaves(IBlockAccess world, BlockPos pos)
	    {
	        return false;
	    }
		
		@Override
	    @SideOnly(Side.CLIENT)
		 public BlockRenderLayer getBlockLayer()
		 {
		     return BlockRenderLayer.CUTOUT;
		 }
		
		@Override
		public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
	    {
	        return false;
	    }
		
		@Override
		public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	    {
	        return true;
	    }
		
		@Override
		public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_)
	    {
	        //addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, state.getSelectedBoundingBox(worldIn, pos));
	    }
		
	
}
