package net.luis.survive.events.input;

import net.luis.survive.Survive;
import net.luis.survive.core.ModPacketHandler;
import net.luis.survive.core.message.backpack.BackpackDownToolMessage;
import net.luis.survive.core.message.backpack.BackpackNextToolMessage;
import net.luis.survive.core.message.backpack.BackpackOpenMessage;
import net.luis.survive.core.message.backpack.BackpackTopToolMessage;
import net.luis.survive.init.util.ModKeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnClientTickEvent {

	@SubscribeEvent
	public static void ClientTick(TickEvent.ClientTickEvent event) {
		
		if (event.phase == Phase.START) {
			
			if (ModKeyBinding.BACKPACK_OPEN.isKeyDown()) {
				
				ModPacketHandler.simpleChannel.sendToServer(new BackpackOpenMessage());
				
			} else if (ModKeyBinding.BACKPACK_NEXT.isKeyDown()) {
				
				ModPacketHandler.simpleChannel.sendToServer(new BackpackNextToolMessage());
				
			} else if (ModKeyBinding.BACKPACK_SLOT_TOP.isKeyDown()) {
				
				ModPacketHandler.simpleChannel.sendToServer(new BackpackTopToolMessage());
				
			} else if (ModKeyBinding.BACKPACK_SLOT_DOWN.isKeyDown()) {
				
				ModPacketHandler.simpleChannel.sendToServer(new BackpackDownToolMessage());
				
			}
			
		}

	}
	
}