package CookingPlus.blocks;

import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCustomSpreadingHerb extends CookingPlusCustomBlock {

	protected CookingPlusCustomSpreadingHerb() {
		super(Material.plants);
		this.setStepSound(soundTypeGrass);
		this.setTickRandomly(true);
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
    public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) 
	{
		if(CookingPlusConfig.HerbSpreading == true){
		if (worldIn.getLightFromNeighbors(pos.up()) >= 9){
			//System.out.println("ho ho ho");
			if(rand.nextInt(100) > 100 - CookingPlusConfig.HerbSpreadRate){
				int place = rand.nextInt(4);
				//System.out.println("place: " + place);
					if(place == 0){
						boolean done = false;
						if(worldIn.getBlockState(pos.north()) != null){ // up one block
							if(worldIn.getBlockState(pos.north()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.north().up()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.north().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.north().down()) != null){ // same level
							if(worldIn.getBlockState(pos.north().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.north()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.north(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.north().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.north().down().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.north().down()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.north().down(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
					}
					
					if(place == 1){
						boolean done = false;
						if(worldIn.getBlockState(pos.east()) != null){ // up one block
							if(worldIn.getBlockState(pos.east()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.east().up()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.east().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.east().down()) != null){ // same level
							if(worldIn.getBlockState(pos.east().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.east()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.east(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.east().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.east().down().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.east().down()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.east().down(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
					}
					
					if(place == 2){
						boolean done = false;
						if(worldIn.getBlockState(pos.west()) != null){ // up one block
							if(worldIn.getBlockState(pos.west()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.west().up()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.west().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.west().down()) != null){ // same level
							if(worldIn.getBlockState(pos.west().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.west()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.west(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.west().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.west().down().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.west().down()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.west().down(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
					}
					
					if(place == 3){
						boolean done = false;
						if(worldIn.getBlockState(pos.south()) != null){ // up one block
							if(worldIn.getBlockState(pos.south()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.south().up()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.south().up(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.south().down()) != null){ // same level
							if(worldIn.getBlockState(pos.south().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.south()).getBlock() == Blocks.air){
									worldIn.setBlockState(pos.south(), GetHerbItem().getDefaultState());
									done = true;
								}
							}
						}
						if(done == false && worldIn.getBlockState(pos.south().down().down()) != null){ // down one block
							if(worldIn.getBlockState(pos.west().south().down()).getBlock() == Blocks.grass){
								if(worldIn.getBlockState(pos.south().down()).getBlock() == Blocks.air){
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
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
		if(worldIn.getBlockState(pos.down()).getBlock() != Blocks.grass){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
    }
	
	@Override
	 public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	 {
		//System.out.println("meow");
	     return (worldIn.getBlockState(pos.down()).getBlock() == Blocks.grass);
	 }
	
	}
