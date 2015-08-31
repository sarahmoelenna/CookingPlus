package CookingPlus.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCoralRockBlock extends CookingPlusCustomBlock{

	private final String name = "coralrock";
	
	public CookingPlusCoralRockBlock() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("coralrock");
		//this.setBlockTextureName("cookingplus:butterblock");
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
