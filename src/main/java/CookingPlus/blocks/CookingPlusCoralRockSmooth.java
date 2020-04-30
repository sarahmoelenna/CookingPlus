package CookingPlus.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCoralRockSmooth extends CookingPlusCustomBlock{

	private final String name = "coralrocksmooth";
	
	public CookingPlusCoralRockSmooth() {
		super(Material.ROCK);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("coralrocksmooth");
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
