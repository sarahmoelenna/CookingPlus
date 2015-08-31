package CookingPlus.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCoralRockSmooth extends CookingPlusCustomBlock{

	private final String name = "coralrocksmooth";
	
	public CookingPlusCoralRockSmooth() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("coralrocksmooth");
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
