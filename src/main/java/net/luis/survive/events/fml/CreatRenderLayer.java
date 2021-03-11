package net.luis.survive.events.fml;

import net.luis.survive.Survive;
import net.luis.survive.client.render.tileentity.ModBeaconTileEntityRender;
import net.luis.survive.client.render.tileentity.ModEnchantingTableTileEntityRender;
import net.luis.survive.init.util.ModTileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreatRenderLayer {
	
	@SubscribeEvent
	public static void doClientSetup(FMLClientSetupEvent event) {
		
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.ENCHANTING_TABLE.get(), ModEnchantingTableTileEntityRender::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.BEACON.get(), ModBeaconTileEntityRender::new);
		
	}

}
