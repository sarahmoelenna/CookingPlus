package CookingPlus.blocks.tileentity;

import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.ButterChurnTileEntity;
import CookingPlus.tiles.CystalBaseTileEntity;
import CookingPlus.tiles.SpongeTileEntity;
import CookingPlus.tiles.VanillaTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCyrtsalBaseTileEntityBlock extends CookingPlusCustomTileEntityBlock {

	private String name;
	
	public CookingPlusCyrtsalBaseTileEntityBlock(String myname) {
		super(Material.rock);
		name = myname;
		this.setUnlocalizedName(name);
		this.setTickRandomly(false);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		GameRegistry.registerBlock(this, name);
	}

	public String GetName(){
		return name;
	}
	
	@Override
	public boolean canPlaceBlockAt(World parWorld, BlockPos myPos)
    {
		if(myPos.getY() < 252){
			if(parWorld.getBlockState(myPos).getBlock().isReplaceable(parWorld, myPos)){
				if(parWorld.getBlockState(new BlockPos(new Vec3(myPos.getX(), myPos.getY()+1, myPos.getZ()))).getBlock().isReplaceable(parWorld, new BlockPos(new Vec3(myPos.getX(), myPos.getY()+1, myPos.getZ())))){
					return true;
				}
			}
		}
		return false;
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(!worldIn.isRemote)
        {
				CystalBaseTileEntity t = (CystalBaseTileEntity) worldIn.getTileEntity(pos);
                t.processActivate(playerIn);
        }
    	
    	return true;
    }
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos myPos, IBlockState myState) {
		super.onBlockDestroyedByPlayer(world, myPos, myState);
		world.setBlockToAir(myPos.up());
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos myPos, Explosion p_149664_5_) {
		super.onBlockDestroyedByExplosion(world, myPos, p_149664_5_);
		world.setBlockToAir(myPos.up());
	}
	
	@Override
    public void onBlockPlacedBy(World worldIn, BlockPos myPos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
		worldIn.setBlockState(myPos.up(), CookingPlusMain.blockNull.getDefaultState(), 2);
    }
	
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

}
