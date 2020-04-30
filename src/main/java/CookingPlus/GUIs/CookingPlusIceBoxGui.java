package CookingPlus.GUIs;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Containers.CookingPlusIceBoxContainer;
import CookingPlus.tiles.IceBoxTileEntity;

@SideOnly(Side.CLIENT)
public class CookingPlusIceBoxGui  extends GuiContainer
{
    private static final ResourceLocation GuiTextures = new ResourceLocation("agriculturalrevolution:textures/gui/iceboxgui.png");
    private final InventoryPlayer inventoryPlayer;
    private final IceBoxTileEntity tileGrinder;

    public CookingPlusIceBoxGui(InventoryPlayer parInventoryPlayer, TileEntity parInventoryGrinder)
    {
        super(new CookingPlusIceBoxContainer(parInventoryPlayer, parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileGrinder = (IceBoxTileEntity) parInventoryGrinder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
      
        String s = "Ice Box";
        fontRendererObj.drawString(s, xSize/2-fontRendererObj.getStringWidth(s)/2, 6, 4210752);
        fontRendererObj.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX, int mouseY)
    {

        mc.getTextureManager().bindTexture(GuiTextures);
        int marginHorizontal = (width - xSize) / 2;
        int marginVertical = (height - ySize) / 2;

        drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, xSize, ySize);

 
    }

    private int getProgressLevel(int progressIndicatorPixelWidth)
    {

    	return 0;
    }
 }
