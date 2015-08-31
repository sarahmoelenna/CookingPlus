package CookingPlus.blocks.leaves;

import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusConfig;
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

public class CookingPlusBananaLeaves extends CookingPlusCustomLeaves {

	private final String name = "bananaleaves";
	
	public CookingPlusBananaLeaves() {
		super("bananaleaves");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public Item getSapling(){
		return Item.getItemFromBlock(CookingPlusMain.blockBananaSapling);
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockBananaLeaves;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public int GetFruitChance(){
		return 101;
	}

}
