package CookingPlus.GUIs;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Containers.CookingPlusMutationStationContainer;
import CookingPlus.tiles.MutationStationTileEntity;

@SideOnly(Side.CLIENT)
public class CookingPlusMutationStationGUI  extends GuiContainer
{
    private static final ResourceLocation GuiTextures = new ResourceLocation("agriculturalrevolution:textures/gui/mutationstationgui.png");
    private final InventoryPlayer inventoryPlayer;
    private final MutationStationTileEntity tileGrinder;

    public CookingPlusMutationStationGUI(InventoryPlayer parInventoryPlayer, TileEntity parInventoryGrinder)
    {
        super(new CookingPlusMutationStationContainer(parInventoryPlayer, parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileGrinder = (MutationStationTileEntity) parInventoryGrinder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        
    	
    	mc.getTextureManager().bindTexture(GuiTextures);
        
        String s = "Mutation Station";
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


        if (this.tileGrinder.getMutationTime() > 0)
        {
        	int i1 = this.tileGrinder.getTimeScaled(28);
            this.drawTexturedModalRect(marginHorizontal + 75, marginVertical + 47 - i1, 178, 61-i1, 26, i1 + 1);
        }
        
        if(this.tileGrinder.getCharges() > 0){
        	if(this.tileGrinder.getCharges() >= 1){
        		this.drawTexturedModalRect(marginHorizontal + 11, marginVertical + 62, 178, 65, 9, 9);
        	}
        	if(this.tileGrinder.getCharges() >= 2){
        		this.drawTexturedModalRect(marginHorizontal + 11, marginVertical + 51, 178, 65, 9, 9);
        	}
        	if(this.tileGrinder.getCharges() >= 3){
        		this.drawTexturedModalRect(marginHorizontal + 11, marginVertical + 40, 178, 65, 9, 9);
        	}
        	if(this.tileGrinder.getCharges() >= 4){
        		this.drawTexturedModalRect(marginHorizontal + 11, marginVertical + 29, 178, 65, 9, 9);
        	}
        	if(this.tileGrinder.getCharges() >= 5){
        		this.drawTexturedModalRect(marginHorizontal + 11, marginVertical + 18, 178, 65, 9, 9);
        	}
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
