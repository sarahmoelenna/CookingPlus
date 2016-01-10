package CookingPlus.blocks.tileentity;

import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.BotTileEntity;
import CookingPlus.tiles.ButterChurnTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
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

public class CookingPlusBotBlock extends CookingPlusCustomTileEntityBlock {

        //Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
        //And the second three are the top-right corner.
		private final String name = "bot";
		public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
        public CookingPlusBotBlock() {
                super(Material.iron);
                this.setUnlocalizedName(name);
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
        		this.setHardness(2.0F);
        		this.setResistance(6.0F);
        		this.setStepSound(soundTypeMetal);
        		this.setTickRandomly(false);
        		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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
			return new BotTileEntity();
		}
		
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
        	if(!worldIn.isRemote)
            {
        		BotTileEntity t = (BotTileEntity) worldIn.getTileEntity(pos);
                    t.processActivate(playerIn);
            }
        	
        	return true;
        }
		
		@Override
		public void onBlockDestroyedByPlayer(World world, BlockPos myPos, IBlockState myState) {
			super.onBlockDestroyedByPlayer(world, myPos, myState);
			//SetWorldBlock(world, myPos.getX(), myPos.getY() + 1, myPos.getZ(), Blocks.air, 0, 2);
		}
		
		@Override
		public void onBlockDestroyedByExplosion(World world, BlockPos myPos, Explosion p_149664_5_) {
			super.onBlockDestroyedByExplosion(world, myPos, p_149664_5_);
			//SetWorldBlock(world, myPos.getX(), myPos.getY() + 1, myPos.getZ(), Blocks.air, 0, 2);
		}
		
		@Override
	    public void onBlockPlacedBy(World worldIn, BlockPos myPos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
			//SetWorldBlock(worldIn, myPos.getX(), myPos.getY() + 1, myPos.getZ(), CookingPlusMain.blockNull, 0, 2);
			
			EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
	        state = state.withProperty(FACING, enumfacing);
	        BlockPos blockpos1 = myPos.north();
	        BlockPos blockpos2 = myPos.south();
	        BlockPos blockpos3 = myPos.west();
	        BlockPos blockpos4 = myPos.east();
	        boolean flag = this == worldIn.getBlockState(blockpos1).getBlock();
	        boolean flag1 = this == worldIn.getBlockState(blockpos2).getBlock();
	        boolean flag2 = this == worldIn.getBlockState(blockpos3).getBlock();
	        boolean flag3 = this == worldIn.getBlockState(blockpos4).getBlock();

	        TileEntity tileentity = worldIn.getTileEntity(myPos);
	        
	        if (!flag && !flag1 && !flag2 && !flag3)
	        {
	            worldIn.setBlockState(myPos, state, 3);
	        }
	        else if (enumfacing.getAxis() == EnumFacing.Axis.X && (flag || flag1))
	        {
	            if (flag)
	            {
	                worldIn.setBlockState(blockpos1, state, 3);
	            }
	            else
	            {
	                worldIn.setBlockState(blockpos2, state, 3);
	            }

	            worldIn.setBlockState(myPos, state, 3);
	        }
	        else if (enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3))
	        {
	            if (flag2)
	            {
	                worldIn.setBlockState(blockpos3, state, 3);
	            }
	            else
	            {
	                worldIn.setBlockState(blockpos4, state, 3);
	            }

	            worldIn.setBlockState(myPos, state, 3);
	        }
	        //System.out.println(enumfacing);
	        if (tileentity instanceof BotTileEntity)
            {
	        	if(enumfacing == EnumFacing.EAST){
	        		((BotTileEntity)tileentity).setDirection(5);
	        	}
	        	if(enumfacing == EnumFacing.SOUTH){
	        		((BotTileEntity)tileentity).setDirection(3);
	        	}
	        	if(enumfacing == EnumFacing.WEST){
	        		((BotTileEntity)tileentity).setDirection(4);
	        	}
	        	if(enumfacing == EnumFacing.NORTH){
	        		((BotTileEntity)tileentity).setDirection(2);
	        	}
            }
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
		public IBlockState getStateFromMeta(int meta)
	    {
	        EnumFacing enumfacing = EnumFacing.getFront(meta);

	        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
	        {
	            enumfacing = EnumFacing.NORTH;
	        }

	        return this.getDefaultState().withProperty(FACING, enumfacing);
	    }

	    @Override
	    public int getMetaFromState(IBlockState state)
	    {
	        return ((EnumFacing)state.getValue(FACING)).getIndex();
	    }

	    @Override
	    protected BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {FACING});
	    }
	    
	    @Override
		public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
	    {
			List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
	        ret.clear();
	        
	        ret.add(new ItemStack(Item.getItemFromBlock(CookingPlusMain.blockBot), 1, 0));
	        if(world.getTileEntity(myPos) != null){
	        	ItemStack[] TempArray = ((BotTileEntity)world.getTileEntity(myPos)).GetItems();
	        	
	        	for(int i = 0; i < TempArray.length; i ++){
	        		if(TempArray[i] != null){
	        			ret.add(TempArray[i].copy()); 
	        		}
	        	}
	        	world.getTileEntity(myPos).invalidate();
	        }
	        return ret;
	    }
	    
	    @Override
	    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof BotTileEntity)
	            {
	                InventoryHelper.dropInventoryItems(worldIn, pos, (BotTileEntity)tileentity);
	            }
	            
	        super.breakBlock(worldIn, pos, state);
	    }

}