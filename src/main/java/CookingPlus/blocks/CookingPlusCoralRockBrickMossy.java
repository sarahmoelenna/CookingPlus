package CookingPlus.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCoralRockBrickMossy extends CookingPlusCustomBlock{

	private final String name = "coralrockbrickmossy";
	
	public CookingPlusCoralRockBrickMossy() {
		super(Material.ROCK);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
		//this.setBlockTextureName("cookingplus:butterblock");
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
