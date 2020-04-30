package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class UraniumOreBlock extends CookingPlusCustomBlock{

	private final String name = "uraniumore";
	
	public UraniumOreBlock() {
		super(Material.ROCK);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("uraniumore");
		this.setHardness(5.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return CookingPlusMain.uraniumchunk;
	}


	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
	    return 1 + random.nextInt(2 + fortune);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	

}
