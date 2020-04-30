package CookingPlus.blocks.tileentity;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.ButterChurnTileEntity;
import CookingPlus.tiles.FryingPanTileEntity;
import CookingPlus.tiles.LeyDesynthTileEntity;
import CookingPlus.tiles.SpongeTileEntity;

public class LeyDesynthBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "leydesynth";
	
	public LeyDesynthBlock() {
		super(Material.IRON);
		this.setUnlocalizedName(name);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.setTickRandomly(false);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.setHarvestLevel("pickaxe", 0);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new LeyDesynthTileEntity();
	}
	
	public String GetName(){
		return name;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!worldIn.isRemote)
        {
                LeyDesynthTileEntity t = (LeyDesynthTileEntity) worldIn.getTileEntity(pos);
                t.processActivate(playerIn);
        }
    	
    	return true;
    }
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
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
		worldIn.setBlockState(myPos.up(), CookingPlusMain.blockNull.getDefaultState());
    }
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
	{
		List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
		ret.clear();
	        
		ret.add(new ItemStack(Item.getItemFromBlock(CookingPlusMain.blockLeyDesynth), 1, 0));
		if(world.getTileEntity(myPos) != null){
			if(((LeyDesynthTileEntity)world.getTileEntity(myPos)).getCurrentCrystal() != null){
				ret.add(new ItemStack(((LeyDesynthTileEntity)world.getTileEntity(myPos)).getCurrentCrystal()));
			}
			world.getTileEntity(myPos).invalidate();
		}
		return ret;
	}
	
	@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof LeyDesynthTileEntity)
            {
            	if(((LeyDesynthTileEntity)tileentity).getCurrentCrystal() != null){
            		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(((LeyDesynthTileEntity)tileentity).getCurrentCrystal()));
            	}
            }
            
        super.breakBlock(worldIn, pos, state);
    }

}
