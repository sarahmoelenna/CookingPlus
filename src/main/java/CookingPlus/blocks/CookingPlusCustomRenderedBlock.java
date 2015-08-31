package CookingPlus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CookingPlusCustomRenderedBlock extends Block {

    public CookingPlusCustomRenderedBlock(Material materialIn) {
		super(materialIn);
	}

	public static final IUnlistedProperty<Integer> JAI = new IUnlistedProperty<Integer>() {
        @Override
        public String getName() {
            return "justAnotherInteger";
        }
        @Override
        public boolean isValid(Integer value) {
            return true;
        }
        @Override
        public Class<Integer> getType() {
            return Integer.class;
        }
        @Override
        public String valueToString(Integer value) {
            return value.toString();
        }
    };

    @Override
    protected BlockState createBlockState() {
        return new ExtendedBlockState(this, new IProperty[] { }, new IUnlistedProperty[]{ JAI }); // maybe need to add listed property?
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
        if(state instanceof IExtendedBlockState) {
            return ((IExtendedBlockState)state).withProperty(JAI, pos.getY());
        }
        return state;
    }
    
    public String getName(){
    	return null;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

}