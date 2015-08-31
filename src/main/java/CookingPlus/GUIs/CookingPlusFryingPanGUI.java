package CookingPlus.GUIs;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Containers.CookingPlusFryingPanContainer;
import CookingPlus.Slots.CookingPlusOutputSlot;
import CookingPlus.Slots.CookingPlusSingleSlot;
import CookingPlus.tiles.FryingPanTileEntity;

@SideOnly(Side.CLIENT)
public class CookingPlusFryingPanGUI  extends GuiContainer
{
    private static final ResourceLocation GuiTextures = new ResourceLocation("cookingplus:textures/gui/fryingpangui.png");
    private final InventoryPlayer inventoryPlayer;
    private final FryingPanTileEntity tileGrinder;

    public CookingPlusFryingPanGUI(InventoryPlayer parInventoryPlayer, TileEntity parInventoryGrinder)
    {
        super(new CookingPlusFryingPanContainer(parInventoryPlayer, parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileGrinder = (FryingPanTileEntity) parInventoryGrinder;
        
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        
    	
    	mc.getTextureManager().bindTexture(GuiTextures);
    	
    	
    	this.drawTexturedModalRect(11, 70 - tileGrinder.getLiquidAmount() * 6, 194, 90, 16, tileGrinder.getLiquidAmount() * 6);
    	
    	this.drawTexturedModalRect(10, 10, 176, 31, 18, 61);
    	
    	String s = "Frying Pan";
        fontRendererObj.drawString(s, xSize/2-fontRendererObj.getStringWidth(s)/2, 6, 4210752);
        fontRendererObj.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
    	
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX, int mouseY)
    {
        //GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(GuiTextures);
        int marginHorizontal = (width - xSize) / 2;
        int marginVertical = (height - ySize) / 2;
        //System.out.println(width + " " + height + " " + xSize + " " + ySize);
        drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, xSize, ySize);

        
        int i1 = this.tileGrinder.getBoilAmount(29);
        this.drawTexturedModalRect(marginHorizontal + 31, marginVertical + 4 + 29 - i1, 208, 29 - i1, 14, i1 + 1);
        
        
    }

    private int getProgressLevel(int progressIndicatorPixelWidth)
    {

    	return 0;
    }
 }
