package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class CookingPlusSaltBlock extends CookingPlusCustomBlock{

	private final String name = "saltblock";
	
	public CookingPlusSaltBlock() {
		super(Material.ROCK);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("saltblock");
		//this.setBlockTextureName("cookingplus:salt");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return CookingPlusMain.saltpile;
	}


	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
	    return 4;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	

}
