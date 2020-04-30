package CookingPlus;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CookingPlusModelLoader implements ICustomModelLoader {

    private IResourceManager resourceManager;
    
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public boolean accepts(ResourceLocation l) {
    	//if(l.getResourceDomain().equals("cookingplus")){
    	//	System.out.println(l.getResourcePath() + " " + (l.getResourceDomain().equals("cookingplus") && l.getResourcePath().startsWith("models/block/vanillacrop")));
    	//}
    	//System.out.println(l.getResourcePath());
    	//System.out.println(l.getResourcePath().startsWith("models/block/builtin/"));
    	/*if (l.getResourceDomain().equals("agriculturalrevolution") && l.getResourcePath().startsWith("models/block/")){
    	System.out.println(l.getResourcePath());
    	}*/
        return l.getResourceDomain().equals("agriculturalrevolution") && ((l.getResourcePath().startsWith("models/block/grapecrop") || l.getResourcePath().startsWith("models/block/hopcrop") || l.getResourcePath().startsWith("models/block/vanillacrop")));
    }

    @Override
    public IModel loadModel(ResourceLocation l) {
        String r = l.getResourcePath().substring("models/block/".length());
        //System.out.println(r + " yolo swag");
        if(r.equals("grapecrop")) {
        	//System.out.println(r + " yolo swag");
            return new CookingPlusBlockModel(resourceManager);
        }
        else if(r.equals("hopcrop")) {
        	//System.out.println(r + " yolo swag");
            return new CookingPlusBlockModel(resourceManager);
        }
        else if(r.equals("vanillacrop")) {
        	//System.out.println(r + " yolo swag");
            return new CookingPlusBlockModel(resourceManager);
        }
        throw new RuntimeException("A builtin model '" + r + "' is not defined.");
    }
}