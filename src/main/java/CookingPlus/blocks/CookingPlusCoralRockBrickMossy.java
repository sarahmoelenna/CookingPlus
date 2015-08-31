package CookingPlus.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCoralRockBrickMossy extends CookingPlusCustomBlock{

	private final String name = "coralrockbrickmossy";
	
	public CookingPlusCoralRockBrickMossy() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
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
