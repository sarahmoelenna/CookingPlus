package CookingPlus.blocks.tileentity;

import java.util.List;

import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.NetBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusNetBlock extends CookingPlusCustomTileEntityBlock {

        //Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
        //And the second three are the top-right corner.
		private final String name = "netblock";
	
		public static final PropertyInteger LEVEL = PropertyInteger.create("level",0, 15);
		
        public CookingPlusNetBlock() {
                super(Material.water);
                this.setUnlocalizedName("netblock");
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        		this.setStepSound(soundTypeWood);
        		this.setTickRandomly(true);
        		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL,Integer.valueOf(0)));
        		GameRegistry.registerBlock(this, name);
        }

        //You don't want the normal render type, or it wont render properly.
        @Override
        public int getRenderType() {
                return -1;
        }
        
        //It's not an opaque cube, so you need this.
        @Override
        public boolean isOpaqueCube() {
                return false;
        }
        
        //It's not a normal block, so you need this too.
        public boolean renderAsNormalBlock() {
                return false;
        }
        
		@Override
		public TileEntity createNewTileEntity(World var1, int var2) {
			return new NetBlockTileEntity();
		}
		
		@Override
		public boolean canPlaceBlockAt(World parWorld, BlockPos myPos)
	    {
			if(parWorld.getBlockState(myPos.east()).getBlock().getMaterial() == Material.water){
				if(parWorld.getBlockState(myPos.west()).getBlock().getMaterial() == Material.water){
					if(parWorld.getBlockState(myPos.north()).getBlock().getMaterial() == Material.water){
						if(parWorld.getBlockState(myPos.south()).getBlock().getMaterial() == Material.water){
							if(parWorld.getBlockState(myPos.up()).getBlock().getMaterial() == Material.water){
								return true;
							}
						}
					}
				}
			}
			return false;
	    }
		
		@Override
		public void onBlockPlacedBy(World worldIn, BlockPos myPos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
			//System.out.println("blah");
			int i = myPos.getX();
			int j = myPos.getY();
			int k = myPos.getZ();
			
			EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
	        //state = state.withProperty(FACING, enumfacing);
	        BlockPos blockpos1 = myPos.north();
	        BlockPos blockpos2 = myPos.south();
	        BlockPos blockpos3 = myPos.west();
	        BlockPos blockpos4 = myPos.east();
	        boolean flag = this == worldIn.getBlockState(blockpos1).getBlock();
	        boolean flag1 = this == worldIn.getBlockState(blockpos2).getBlock();
	        boolean flag2 = this == worldIn.getBlockState(blockpos3).getBlock();
	        boolean flag3 = this == worldIn.getBlockState(blockpos4).getBlock();

	        TileEntity tileentity = worldIn.getTileEntity(myPos);
	        
	        //System.out.println(enumfacing);
	        if (tileentity instanceof NetBlockTileEntity)
            {
	        	if(enumfacing == EnumFacing.EAST){
	        		((NetBlockTileEntity)tileentity).setDirection(5);
	        	}
	        	if(enumfacing == EnumFacing.SOUTH){
	        		((NetBlockTileEntity)tileentity).setDirection(3);
	        	}
	        	if(enumfacing == EnumFacing.WEST){
	        		((NetBlockTileEntity)tileentity).setDirection(4);
	        	}
	        	if(enumfacing == EnumFacing.NORTH){
	        		((NetBlockTileEntity)tileentity).setDirection(2);
	        	}
            }

	        //worldIn.markBlockForUpdate(myPos);
	    }
		
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
        	if(!worldIn.isRemote)
            {
        		NetBlockTileEntity t = (NetBlockTileEntity) worldIn.getTileEntity(pos);
                t.processActivate(playerIn);
            }
        	
        	return true;
        }
		 
		private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
			myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)), newBlock.getDefaultState()); 
		}
		
		private Block GetWorldBlock(World myWorld, int x, int y, int z){
			return myWorld.getBlockState(new BlockPos(new Vec3(x, y, z))).getBlock();
		}
		
		@Override
		public String GetName(){
			return name;
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			return ((Integer) state.getValue(LEVEL)).intValue();
		}

		@Override
		protected BlockState createBlockState() {
			return new BlockState(this, new IProperty[] { LEVEL });
		}
		
		@Override
		public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
	    }

		@Override
	    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof NetBlockTileEntity)
	            {
	                InventoryHelper.dropInventoryItems(worldIn, pos, (NetBlockTileEntity)tileentity);
	            }
	            
	        super.breakBlock(worldIn, pos, state);
	    }

		@Override
	    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	    {
			if(worldIn.getBlockState(pos.up()).getBlock().getMaterial() != Material.water){
				worldIn.setBlockState(pos, Blocks.water.getDefaultState());
				this.dropBlockAsItemWithChance(worldIn, pos, getDefaultState(), 1, 0);
				this.breakBlock(worldIn, pos, getDefaultState());
			}
	    }

		@Override
		public boolean isReplaceable(World world, BlockPos pos)
		{
		   return false;
		}
		
		@Override
		public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
	    {
			List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
	        ret.clear();
	        
	        ret.add(new ItemStack(Item.getItemFromBlock(CookingPlusMain.blockNetBlock), 1, 0));
	        //System.out.println("blah");
	        if(world.getTileEntity(myPos) != null){
	        	//System.out.println("hmm");
	        	ItemStack[] TempArray = ((NetBlockTileEntity)world.getTileEntity(myPos)).GetItems();
	        	
	        	for(int i = 0; i < TempArray.length; i ++){
	        		if(TempArray[i] != null){
	        			ret.add(TempArray[i].copy()); 
	        		}
	        	}
	        	world.getTileEntity(myPos).invalidate();
	        }
	        return ret;
	    }
}