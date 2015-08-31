package CookingPlus;
import com.google.common.base.Function;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IModelState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Collection;

@SideOnly(Side.CLIENT)
public class CookingPlusBlockModel implements IModel {

    public static final ResourceLocation TA = new ResourceLocation("cookingplus:blocks/grapecrop_stage_0");
    public static final ResourceLocation TB = new ResourceLocation("cookingplus:blocks/ropeblock_straight");
    public static final ResourceLocation TC = new ResourceLocation("cookingplus:blocks/grapecrop_stage_1");
    public static final ResourceLocation TD = new ResourceLocation("cookingplus:blocks/grapecrop_stage_2");
    //public static final ResourceLocation TC = new ResourceLocation("mymodid:blocks/texturec");
    public static final ResourceLocation MA = new ResourceLocation("cookingplus:block/ropecropgrape_2");
    public static final ResourceLocation MB = new ResourceLocation("cookingplus:block/rope_straight");
    public static final ResourceLocation MC = new ResourceLocation("cookingplus:block/ropecropgrape_1");
    public static final ResourceLocation MD = new ResourceLocation("cookingplus:block/ropecropgrape_0");
    public static final ResourceLocation ME = new ResourceLocation("cookingplus:block/rope");
    public static final ResourceLocation MF = new ResourceLocation("cookingplus:block/rope_bottom");
    public static final ResourceLocation MG = new ResourceLocation("cookingplus:block/rope_top");
    public static final ResourceLocation MH = new ResourceLocation("cookingplus:block/ropecrophop_2");
    public static final ResourceLocation MI = new ResourceLocation("cookingplus:block/ropecropvanilla_2");
   // public static final ResourceLocation MC = new ResourceLocation("mymodid:block/modelc");

    public CookingPlusBlockModel(IResourceManager resourceManager) {
    }

    @Override
    public Collection<ResourceLocation> getDependencies() {
        return Arrays.asList(MA, MB, MC, MD, ME, MF, MG, MH, MI);
    }

    @Override
    public Collection<ResourceLocation> getTextures() {
        return Arrays.asList(TA, TB, TC, TD);
    }

    @Override
    public IFlexibleBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
    	return new CookingPlusBakedBlockModel(format, bakedTextureGetter);
    }

    @Override
    public IModelState getDefaultState() {
        return null;
    }
}