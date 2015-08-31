package CookingPlus.GUIs;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Containers.CookingPlusBrickOvenContainer;
import CookingPlus.Containers.CookingPlusFermenterContainer;
import CookingPlus.tiles.FermenterTileEntity;

@SideOnly(Side.CLIENT)
public class CookingPlusFermenterGUI  extends GuiContainer
{
    private static final ResourceLocation GuiTextures = new ResourceLocation("cookingplus:textures/gui/fermentergui.png");
    private final InventoryPlayer inventoryPlayer;
    private final FermenterTileEntity tileGrinder;

    public CookingPlusFermenterGUI(InventoryPlayer parInventoryPlayer, TileEntity parInventoryGrinder)
    {
        super(new CookingPlusFermenterContainer(parInventoryPlayer, parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileGrinder = (FermenterTileEntity) parInventoryGrinder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        
    	
    	mc.getTextureManager().bindTexture(GuiTextures);
    	//individual burn times
        //for(int i = 0; i < 3; i ++){
        //	for(int j = 0; j < 3; j ++){
        //    	//176 31
        //		this.drawTexturedModalRect(9 + i * 18, 33 + j * 18, 176, 31, tileGrinder.getItemCook(i + j * 3, 14), 2);
        //    }
        //}
    	
    	//grape
    	//System.out.println(tileGrinder.getLiquidInAmount());
    	if(tileGrinder.getLiquidIn().equals("grape")){
    		this.drawTexturedModalRect(11, 70 - tileGrinder.getLiquidInAmount() * 6, 194, 90, 16, tileGrinder.getLiquidInAmount() * 6);
    	}
    	else if(tileGrinder.getLiquidIn().equals("apple")){
    		this.drawTexturedModalRect(11, 70 - tileGrinder.getLiquidInAmount() * 6, 194 + 16, 90, 16, tileGrinder.getLiquidInAmount() * 6);
    	}
    	else if(tileGrinder.getLiquidIn().equals("hops")){
    		this.drawTexturedModalRect(11, 70 - tileGrinder.getLiquidInAmount() * 6, 194 + 32, 90, 16, tileGrinder.getLiquidInAmount() * 6);
    	}
    	
    	//wine
    	if(tileGrinder.getLiquidOut().equals("wine")){
    		this.drawTexturedModalRect(151, 70 - tileGrinder.getLiquidOutAmount() * 6, 194, 32, 16, tileGrinder.getLiquidOutAmount() * 6);
    	}
    	else if(tileGrinder.getLiquidOut().equals("cider")){
    		this.drawTexturedModalRect(151, 70 - tileGrinder.getLiquidOutAmount() * 6, 194 + 16, 32, 16, tileGrinder.getLiquidOutAmount() * 6);
    	}
    	else if(tileGrinder.getLiquidOut().equals("beer")){
    		this.drawTexturedModalRect(151, 70 - tileGrinder.getLiquidOutAmount() * 6, 194 + 32, 32, 16, tileGrinder.getLiquidOutAmount() * 6);
    	}
    	
    	//amount thingy
    	this.drawTexturedModalRect(10, 10, 176, 31, 18, 61);
    	this.drawTexturedModalRect(150, 10, 176, 31, 18, 61);
    	
    	String s = "Fermenter";
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

        
        int i1 = this.tileGrinder.getFermenter(29);
        this.drawTexturedModalRect(marginHorizontal + 31, marginVertical + 4 + 29 - i1, 208, 29 - i1, 14, i1 + 1);
        
        // Draw progress indicator
        //int progressLevel = getProgressLevel(24);
        //drawTexturedModalRect(marginHorizontal + 79, marginVertical + 34, 176, 14, progressLevel + 1, 16);
        //if (this.tileGrinder.isBurning())
        //{
        //	int i1 = this.tileGrinder.getBurnTimeRemainingScaled(13);
        //    this.drawTexturedModalRect(marginHorizontal + 81, marginVertical + 21 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
        //}
        //individual burn times
        //for(int i = 0; i < 3; i ++){
        //	for(int j = 0; j < 3; j ++){
        //    	//176 31
        //		this.drawTexturedModalRect(marginHorizontal + 9 + i * 18, marginVertical + 33 + j * 18, 176, 31, 14, 2);
        //    }
        //}
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
