package CookingPlus.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.HeaterTileEntity;

public class CookingPlusHeaterBlock extends BlockContainer {

        //Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
        //And the second three are the top-right corner.
		private final String name = "heater";
	
        public CookingPlusHeaterBlock() {
                super(Material.iron);
                this.setUnlocalizedName("heater");
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        		this.setHardness(2.0F);
        		this.setResistance(6.0F);
        		this.setHarvestLevel("pickaxe", 0);
        		this.setStepSound(soundTypeMetal);
        		//this.setBlockTextureName("cookingplus:salt");
        		this.setTickRandomly(false);
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
			return new HeaterTileEntity();
		}
		
		@Override
		public void onBlockDestroyedByPlayer(World world, BlockPos myPos, IBlockState myState) {
			super.onBlockDestroyedByPlayer(world, myPos, myState);
		}
		
		@Override
		public void onBlockDestroyedByExplosion(World world, BlockPos myPos, Explosion p_149664_5_) {
			super.onBlockDestroyedByExplosion(world, myPos, p_149664_5_);
		}
			
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	        if (!worldIn.isRemote)
	        {
	        	playerIn.openGui(CookingPlusMain.instance, 2, worldIn, pos.getX(), pos.getY(), pos.getZ());
	        }
	        
	        return true;
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
	    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof HeaterTileEntity)
	            {
	                InventoryHelper.dropInventoryItems(worldIn, pos, (HeaterTileEntity)tileentity);
	            }
	            
	        super.breakBlock(worldIn, pos, state);
	    }

		

}