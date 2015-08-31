package CookingPlus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import CookingPlus.Containers.CookingPlusBrickOvenContainer;
import CookingPlus.Containers.CookingPlusFermenterContainer;
import CookingPlus.Containers.CookingPlusFryingPanContainer;
import CookingPlus.Containers.CookingPlusHeaterContainer;
import CookingPlus.Containers.CookingPlusIceBoxContainer;
import CookingPlus.Containers.CookingPlusSaucepanContainer;
import CookingPlus.Containers.CookingPlusSheetPressContainer;
import CookingPlus.Containers.CookingPlusTeapotContainer;
import CookingPlus.GUIs.CookingPlusBrickOvenGUI;
import CookingPlus.GUIs.CookingPlusFermenterGUI;
import CookingPlus.GUIs.CookingPlusFryingPanGUI;
import CookingPlus.GUIs.CookingPlusHeaterGUI;
import CookingPlus.GUIs.CookingPlusIceBoxGui;
import CookingPlus.GUIs.CookingPlusSaucepanGUI;
import CookingPlus.GUIs.CookingPlusSheetPressGUI;
import CookingPlus.GUIs.CookingPlusTeapotGui;
import CookingPlus.tiles.BrickOvenTileEntity;
import CookingPlus.tiles.FermenterTileEntity;
import CookingPlus.tiles.FryingPanTileEntity;
import CookingPlus.tiles.HeaterTileEntity;
import CookingPlus.tiles.IceBoxTileEntity;
import CookingPlus.tiles.SaucepanTileEntity;
import CookingPlus.tiles.SheetPressTileEntity;
import CookingPlus.tiles.TeapotTileEntity;


public class GUIHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
    { 
    	 TileEntity tileEntity = world.getTileEntity(new BlockPos(new Vec3(x, y, z)));
    	 //System.out.println("rawr - server");
         if (tileEntity != null)
         {
        	 if(tileEntity instanceof BrickOvenTileEntity){
        		 return new CookingPlusBrickOvenContainer(player.inventory, tileEntity);
        	 }
        	 if(tileEntity instanceof FermenterTileEntity){
        		 return new CookingPlusFermenterContainer(player.inventory, tileEntity);
        	 }
        	 if(tileEntity instanceof TeapotTileEntity){
        		 return new CookingPlusTeapotContainer(player.inventory, tileEntity);
        	 }
        	 if(tileEntity instanceof HeaterTileEntity){
        		 return new CookingPlusHeaterContainer(player.inventory, tileEntity);
        	 }
        	 if(tileEntity instanceof FryingPanTileEntity){
        		 return new CookingPlusFryingPanContainer(player.inventory, tileEntity);
        	 }
        	 if(tileEntity instanceof SheetPressTileEntity){
        		 return new CookingPlusSheetPressContainer(player.inventory, tileEntity);
        	 }
        	 if(tileEntity instanceof SaucepanTileEntity){
        		 return new CookingPlusSaucepanContainer(player.inventory, tileEntity);
        	 }
        	 if(tileEntity instanceof IceBoxTileEntity){
        		 return new CookingPlusIceBoxContainer(player.inventory, tileEntity);
        	 }
        	 
         }

        return null;
    }

	
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
		//System.out.println("rawr - server");
        TileEntity tileEntity = world.getTileEntity(new BlockPos(new Vec3(x, y, z)));

        if (tileEntity != null)
        {
        	if(tileEntity instanceof BrickOvenTileEntity){
        		return new CookingPlusBrickOvenGUI(player.inventory, tileEntity);
        	}
        	if(tileEntity instanceof FermenterTileEntity){
        		return new CookingPlusFermenterGUI(player.inventory, tileEntity);
        	}
        	if(tileEntity instanceof TeapotTileEntity){
        		return new CookingPlusTeapotGui(player.inventory, tileEntity);
        	}
        	if(tileEntity instanceof HeaterTileEntity){
        		return new CookingPlusHeaterGUI(player.inventory, tileEntity);
        	}
        	if(tileEntity instanceof FryingPanTileEntity){
        		return new CookingPlusFryingPanGUI(player.inventory, tileEntity);
        	}
        	if(tileEntity instanceof SheetPressTileEntity){
        		return new CookingPlusSheetPressGUI(player.inventory, tileEntity);
        	}
        	if(tileEntity instanceof SaucepanTileEntity){
        		return new CookingPlusSaucepanGUI(player.inventory, tileEntity);
        	}
        	if(tileEntity instanceof IceBoxTileEntity){
        		return new CookingPlusIceBoxGui(player.inventory, tileEntity);
        	}
        }

        return null;
    }
}