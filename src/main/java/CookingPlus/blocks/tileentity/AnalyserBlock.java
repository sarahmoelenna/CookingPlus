package CookingPlus.blocks.tileentity;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.AnalyserTileEntity;

public class AnalyserBlock extends CookingPlusCustomTileEntityBlock {

	
		private final String name = "analyser";
		
        public AnalyserBlock() {
                super(Material.IRON);
                this.setUnlocalizedName("analyser");
        		this.setSoundType(SoundType.METAL);
        		GameRegistry.registerBlock(this, name);
        		this.setTickRandomly(false);
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
			return new AnalyserTileEntity();
		}
		
		@Override
	 	public boolean canPlaceBlockAt(World parWorld, BlockPos myPos)
	    {
			if(parWorld.getBlockState(myPos.down()).getBlock() instanceof CookingPlusBotBlock){
				return true;
			}
			return false;
	    }
		
		@Override
		public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
	    {
			if(!canPlaceBlockAt(worldIn, pos)){
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			}
	    }
		
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	        if (!worldIn.isRemote)
	        {
	        	playerIn.openGui(CookingPlusMain.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
	        }
	        
	        return true;
	    }
		 
		@Override
	    public String GetName()
		{
			return name;
		}
	    
	    @Override
	    public EnumBlockRenderType getRenderType(IBlockState state)
	    {
	        return EnumBlockRenderType.INVISIBLE;
	    }
	    
	    @Override
	    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof AnalyserTileEntity)
	            {
	                InventoryHelper.dropInventoryItems(worldIn, pos, (AnalyserTileEntity)tileentity);
	            }
	            
	        super.breakBlock(worldIn, pos, state);
	    }
}