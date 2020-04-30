package CookingPlus.GUIs;

import CookingPlus.Containers.CookingPlusAnalyserContainer;
import CookingPlus.tiles.AnalyserTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CookingPlusAnalyserGUI  extends GuiContainer
{
    private static final ResourceLocation GuiTextures = new ResourceLocation("agriculturalrevolution:textures/gui/analysergui.png");
    private final InventoryPlayer inventoryPlayer;
    private final AnalyserTileEntity tileGrinder;

    public CookingPlusAnalyserGUI(InventoryPlayer parInventoryPlayer, TileEntity parInventoryGrinder)
    {
        super(new CookingPlusAnalyserContainer(parInventoryPlayer, parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileGrinder = (AnalyserTileEntity) parInventoryGrinder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        
    	
    	mc.getTextureManager().bindTexture(GuiTextures);
        
        String s = "Spectographic Analyser";
        fontRendererObj.drawString(s, xSize/2-fontRendererObj.getStringWidth(s)/2 - 20, 6, 4210752);
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


        /*if (this.tileGrinder.getMutationTime() > 0)
        {
        	int i1 = this.tileGrinder.getTimeScaled(28);
            this.drawTexturedModalRect(marginHorizontal + 75, marginVertical + 47 - i1, 178, 61-i1, 26, i1 + 1);
        }*/
        

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
