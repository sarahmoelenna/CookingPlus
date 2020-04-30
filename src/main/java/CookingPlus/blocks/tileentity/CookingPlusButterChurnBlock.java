package CookingPlus.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.ButterChurnTileEntity;

public class CookingPlusButterChurnBlock extends CookingPlusCustomTileEntityBlock {

        //Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
        //And the second three are the top-right corner.
		private final String name = "butterchurn";
	
        public CookingPlusButterChurnBlock() {
                super(Material.WOOD);
                this.setUnlocalizedName("butterchurn");
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        		this.setHardness(2.0F);
        		this.setResistance(6.0F);
        		this.setHarvestLevel("axe", 0);
        		this.setSoundType(SoundType.WOOD);
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
			return new ButterChurnTileEntity();
		}
		
		@Override
		public boolean canPlaceBlockAt(World parWorld, BlockPos myPos)
	    {
			if(myPos.getY() < 252){
				if(parWorld.getBlockState(myPos).getBlock().isReplaceable(parWorld, myPos)){
					if(parWorld.getBlockState(new BlockPos(new Vec3d(myPos.getX(), myPos.getY()+1, myPos.getZ()))).getBlock().isReplaceable(parWorld, new BlockPos(new Vec3d(myPos.getX(), myPos.getY()+1, myPos.getZ())))){
						return true;
					}
				}
			}
			return false;
	    }
		
		@Override
		public void onBlockDestroyedByPlayer(World world, BlockPos myPos, IBlockState myState) {
			super.onBlockDestroyedByPlayer(world, myPos, myState);
			SetWorldBlock(world, myPos.getX(), myPos.getY() + 1, myPos.getZ(), Blocks.AIR, 0, 2);
		}
		
		@Override
		public void onBlockDestroyedByExplosion(World world, BlockPos myPos, Explosion p_149664_5_) {
			super.onBlockDestroyedByExplosion(world, myPos, p_149664_5_);
			SetWorldBlock(world, myPos.getX(), myPos.getY() + 1, myPos.getZ(), Blocks.AIR, 0, 2);
		}
		
		@Override
	    public void onBlockPlacedBy(World worldIn, BlockPos myPos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
			SetWorldBlock(worldIn, myPos.getX(), myPos.getY() + 1, myPos.getZ(), CookingPlusMain.blockNull, 0, 2);
	    }
		
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        	if(!worldIn.isRemote)
            {
                    ButterChurnTileEntity t = (ButterChurnTileEntity) worldIn.getTileEntity(pos);
                    t.processActivate(playerIn);
            }
        	
        	return true;
        }
		 
		private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
			myWorld.setBlockState(new BlockPos(new Vec3d(x, y, z)), newBlock.getDefaultState()); 
		}
		
		private Block GetWorldBlock(World myWorld, int x, int y, int z){
			return myWorld.getBlockState(new BlockPos(new Vec3d(x, y, z))).getBlock();
		}
		
		public String getName(){
			return name;
		}


}