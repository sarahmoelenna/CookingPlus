package CookingPlus.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCustomScythe extends CookingPlusCustomItem {

	private String name;

	public CookingPlusCustomScythe(String myName, int maxDurability) {
		super();
		name = myName;
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(name);
		this.setNoRepair();
		this.setMaxDamage(maxDurability);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState myblockIn, BlockPos pos, EntityLivingBase playerIn)
	{
		Block blockIn = myblockIn.getBlock();
		//System.out.println(blockIn.getUnlocalizedName());
		if (isBlockValid(blockIn,myblockIn)) {
			stack.damageItem(1, playerIn);
			if(isBlockValid(worldIn.getBlockState(pos.east()).getBlock(), worldIn.getBlockState(pos.east()))){
				worldIn.getBlockState(pos.east()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.east(), worldIn.getBlockState(pos.east()), worldIn.getTileEntity(pos.east()), stack);
				worldIn.setBlockToAir(pos.east());
				stack.damageItem(1, playerIn);
			}
			if(isBlockValid(worldIn.getBlockState(pos.west()).getBlock(),worldIn.getBlockState(pos.west()))){
				worldIn.getBlockState(pos.west()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.west(), worldIn.getBlockState(pos.west()), worldIn.getTileEntity(pos.west()), stack);
				worldIn.setBlockToAir(pos.west());
				stack.damageItem(1, playerIn);
			}
			if(isBlockValid(worldIn.getBlockState(pos.north()).getBlock(),worldIn.getBlockState(pos.north()))){
				worldIn.getBlockState(pos.north()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.north(), worldIn.getBlockState(pos.north()), worldIn.getTileEntity(pos.north()),stack);
				worldIn.setBlockToAir(pos.north());
				stack.damageItem(1, playerIn);
			}
			if(isBlockValid(worldIn.getBlockState(pos.south()).getBlock(),worldIn.getBlockState(pos.south()))){
				worldIn.getBlockState(pos.south()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.south(), worldIn.getBlockState(pos.south()), worldIn.getTileEntity(pos.south()),stack);
				worldIn.setBlockToAir(pos.south());
				stack.damageItem(1, playerIn);
			}
			
			
			if(isBlockValid(worldIn.getBlockState(pos.east().north()).getBlock(),worldIn.getBlockState(pos.east().north()))){
				worldIn.getBlockState(pos.east().north()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.east().north(), worldIn.getBlockState(pos.east().north()), worldIn.getTileEntity(pos.east().north()),stack);
				worldIn.setBlockToAir(pos.east().north());
				stack.damageItem(1, playerIn);
			}
			if(isBlockValid(worldIn.getBlockState(pos.west().south()).getBlock(),worldIn.getBlockState(pos.west().south()))){
				worldIn.getBlockState(pos.west().south()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.west().south(), worldIn.getBlockState(pos.west().south()), worldIn.getTileEntity(pos.west().south()),stack);
				worldIn.setBlockToAir(pos.west().south());
				stack.damageItem(1, playerIn);
			}
			if(isBlockValid(worldIn.getBlockState(pos.north().west()).getBlock(),worldIn.getBlockState(pos.north().west()))){
				worldIn.getBlockState(pos.north().west()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.north().west(), worldIn.getBlockState(pos.north().west()), worldIn.getTileEntity(pos.north().west()),stack);
				worldIn.setBlockToAir(pos.north().west());
				stack.damageItem(1, playerIn);
			}
			if(isBlockValid(worldIn.getBlockState(pos.south().east()).getBlock(),worldIn.getBlockState(pos.south().east()))){
				worldIn.getBlockState(pos.south().east()).getBlock().harvestBlock(worldIn, (EntityPlayer) playerIn, pos.south().east(), worldIn.getBlockState(pos.south().east()), worldIn.getTileEntity(pos.south().east()),stack);
				worldIn.setBlockToAir(pos.south().east());
				stack.damageItem(1, playerIn);
			}
		}

		return true;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public boolean isBlockValid(Block myBlock, IBlockState myState){
		if (myBlock.getMaterial(myState) == Material.GOURD || myBlock.getMaterial(myState) == Material.PLANTS || myBlock.getMaterial(myState) == Material.LEAVES  || myBlock.getMaterial(myState) == Material.VINE) {
			return true;
		}
		else{
			return false;
		}
	}
}
