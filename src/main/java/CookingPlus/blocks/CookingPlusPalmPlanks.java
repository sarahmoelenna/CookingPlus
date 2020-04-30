package CookingPlus.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPalmPlanks extends CookingPlusCustomBlock{

	private final String name = "palmplanks";
	
	public CookingPlusPalmPlanks() {
		super(Material.WOOD);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setSoundType(SoundType.WOOD);
		Blocks.FIRE.setFireInfo(this, 5, 20);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
