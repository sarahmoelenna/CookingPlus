package CookingPlus.GUIs;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Containers.CookingPlusSheetPressContainer;
import CookingPlus.tiles.SheetPressTileEntity;

@SideOnly(Side.CLIENT)
public class CookingPlusSheetPressGUI  extends GuiContainer
{
    private static final ResourceLocation GuiTextures = new ResourceLocation("cookingplus:textures/gui/sheetpressgui.png");
    private final InventoryPlayer inventoryPlayer;
    private final SheetPressTileEntity tileGrinder;

    public CookingPlusSheetPressGUI(InventoryPlayer parInventoryPlayer, TileEntity parInventoryGrinder)
    {
        super(new CookingPlusSheetPressContainer(parInventoryPlayer, parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileGrinder = (SheetPressTileEntity) parInventoryGrinder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        
    	
    	mc.getTextureManager().bindTexture(GuiTextures);
        
        String s = "Sheet Press";
        fontRendererObj.drawString(s, xSize/2-fontRendererObj.getStringWidth(s)/2 - 40, 6, 4210752);
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
        //System.out.println(width + " " + height + " " + xSize + " " + ySize);
        drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, xSize, ySize);


        if (this.tileGrinder.getPressAmount() > 0)
        {
        	int i1 = this.tileGrinder.getPressAmountScaled(24);
            this.drawTexturedModalRect(marginHorizontal + 78, marginVertical + 29, 176, 14, 18, i1 + 1);
            //this.drawTexturedModalRect(marginHorizontal + 78, marginVertical + 29 + 24 - i1, 176, 38 - i1, 18, i1 + 1);
        }

    }

    private int getProgressLevel(int progressIndicatorPixelWidth)
    {
        //int ticksGrindingItemSoFar = tileGrinder.getField(2); 
        //int ticksPerItem = tileGrinder.getField(3);
        //return ticksPerItem != 0 && ticksGrindingItemSoFar != 0 ? 
        //      ticksGrindingItemSoFar*progressIndicatorPixelWidth/ticksPerItem 
        //      : 0;
    	return 0;
    }
 }
