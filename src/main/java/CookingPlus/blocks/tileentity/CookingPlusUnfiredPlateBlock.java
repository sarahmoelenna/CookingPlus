package CookingPlus.blocks.tileentity;

import java.util.List;

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
import net.minecraft.item.ItemFood;
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
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.UnfiredPlateTileEntity;

public class CookingPlusUnfiredPlateBlock extends BlockContainer {

        //Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
        //And the second three are the top-right corner.
		private final String name = "unfiredplate";
		public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
        public CookingPlusUnfiredPlateBlock() {
                super(Material.clay);
                this.setUnlocalizedName("unfiredplate");
                this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.2F, 0.8F);
        		this.setHardness(2.0F);
        		this.setResistance(6.0F);
        		this.setHarvestLevel("pickaxe", 0);
        		this.setStepSound(soundTypeWood);
        		//this.setBlockTextureName("cookingplus:salt");
        		//this.setTickRandomly(false);
        		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        		this.setLightOpacity(0);
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
			return new UnfiredPlateTileEntity();
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
			
	    }
		 
		private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
			myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)), newBlock.getDefaultState()); 
		}
		
		private Block GetWorldBlock(World myWorld, int x, int y, int z){
			return myWorld.getBlockState(new BlockPos(new Vec3(x, y, z))).getBlock();
		}
		
		public String getName(){
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
	        
	        ret.add(new ItemStack(Item.getItemFromBlock(CookingPlusMain.blockUnfiredPlate), 1, 0));
	        //System.out.println("blah");
	        if(world.getTileEntity(myPos) != null){
	        	//System.out.println("hmm");
	        	ItemStack[] TempArray = ((UnfiredPlateTileEntity)world.getTileEntity(myPos)).GetItems();
	        	
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