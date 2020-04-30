package CookingPlus;
import java.util.Arrays;
import java.util.Collection;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Function;

@SideOnly(Side.CLIENT)
public class CookingPlusBlockModel implements IModel {

    public static final ResourceLocation TA = new ResourceLocation("agriculturalrevolution:block/grapecrop_stage_0");
    public static final ResourceLocation TB = new ResourceLocation("agriculturalrevolution:block/ropeblock_straight");
    public static final ResourceLocation TC = new ResourceLocation("agriculturalrevolution:block/grapecrop_stage_1");
    public static final ResourceLocation TD = new ResourceLocation("agriculturalrevolution:block/grapecrop_stage_2");
    //public static final ResourceLocation TC = new ResourceLocation("mymodid:blocks/texturec");
    public static final ResourceLocation MA = new ResourceLocation("agriculturalrevolution:block/ropecropgrape_2");
    public static final ResourceLocation MB = new ResourceLocation("agriculturalrevolution:block/rope_straight");
    public static final ResourceLocation MC = new ResourceLocation("agriculturalrevolution:block/ropecropgrape_1");
    public static final ResourceLocation MD = new ResourceLocation("agriculturalrevolution:block/ropecropgrape_0");
    public static final ResourceLocation ME = new ResourceLocation("agriculturalrevolution:block/rope");
    public static final ResourceLocation MF = new ResourceLocation("agriculturalrevolution:block/rope_bottom");
    public static final ResourceLocation MG = new ResourceLocation("agriculturalrevolution:block/rope_top");
    public static final ResourceLocation MH = new ResourceLocation("agriculturalrevolution:block/ropecrophop_2");
    public static final ResourceLocation MI = new ResourceLocation("agriculturalrevolution:block/ropecropvanilla_2");
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
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
    	return new CookingPlusBakedBlockModel(format, bakedTextureGetter);
    }

    @Override
    public IModelState getDefaultState() {
        return null;
    }
}