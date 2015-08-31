package CookingPlus.blocks;

import java.util.Iterator;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPalmPlanks extends CookingPlusCustomBlock{

	private final String name = "palmplanks";
	
	public CookingPlusPalmPlanks() {
		super(Material.wood);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setStepSound(soundTypeWood);
		Blocks.fire.setFireInfo(this, 5, 20);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
