package CookingPlus.blocks.leaves;

import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBambooLeaves extends CookingPlusCustomLeaves {

	private final String name = "bambooleaves";
	
	public CookingPlusBambooLeaves() {
		super("bambooleaves");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockBambooSprout);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockBambooLeaves;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune) {
		List<ItemStack> ret = super.getDrops(world, myPos, myState,fortune);
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		
		if (rand.nextInt(20) == 0)
		{
            ret.add(new ItemStack(getItemDropped(myState, rand, fortune), 1));
		}

		return ret;
	}

}
