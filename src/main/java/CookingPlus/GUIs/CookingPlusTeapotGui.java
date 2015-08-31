package CookingPlus.GUIs;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.Containers.CookingPlusTeapotContainer;
import CookingPlus.tiles.TeapotTileEntity;

@SideOnly(Side.CLIENT)
public class CookingPlusTeapotGui  extends GuiContainer
{
    private static final ResourceLocation GuiTextures = new ResourceLocation("cookingplus:textures/gui/teapotgui.png");
    private final InventoryPlayer inventoryPlayer;
    private final TeapotTileEntity tileGrinder;

    public CookingPlusTeapotGui(InventoryPlayer parInventoryPlayer, TileEntity parInventoryGrinder)
    {
        super(new CookingPlusTeapotContainer(parInventoryPlayer, parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileGrinder = (TeapotTileEntity) parInventoryGrinder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        
    	
    	mc.getTextureManager().bindTexture(GuiTextures);
    	
    	/*
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
    	
    	this.drawTexturedModalRect(150, 10, 176, 31, 18, 61);
    	*/
    	//System.out.println(tileGrinder.getLiquidAmount());
    	this.drawTexturedModalRect(11, 70 - tileGrinder.getLiquidAmount() * 6, 194, 90, 16, tileGrinder.getLiquidAmount() * 6);
    	
    	this.drawTexturedModalRect(10, 10, 176, 31, 18, 61);
    	
    	String s = "Teapot";
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
