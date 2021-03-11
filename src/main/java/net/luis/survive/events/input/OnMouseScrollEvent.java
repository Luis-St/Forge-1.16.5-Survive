package net.luis.survive.events.input;

import net.luis.survive.Survive;
import net.luis.survive.core.ModPacketHandler;
import net.luis.survive.core.message.backpack.BackpackNextDownToolMessage;
import net.luis.survive.core.message.backpack.BackpackNextTopToolMessage;
import net.luis.survive.init.capability.BackpackCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandlerModifiable;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnMouseScrollEvent {

	@SubscribeEvent
	@SuppressWarnings("resource")
	public static void MouseScroll(InputEvent.MouseScrollEvent event) {
		
		double delta = event.getScrollDelta();
		PlayerEntity player = Minecraft.getInstance().player;
		
		if (player.isSneaking()) {
			
			ItemStack main = player.getHeldItemMainhand();
			
			if (main.getItem() instanceof TieredItem) {
				
				IItemHandlerModifiable itemModifiable = player.getCapability(BackpackCapability.BACKPACK, null)
						.orElseThrow(() -> new NullPointerException("The mod Capability<IBackpackItemHandler> is null"));
				ItemStack top = itemModifiable.getStackInSlot(36).copy();
				ItemStack down = itemModifiable.getStackInSlot(37).copy();
				
				if (top != ItemStack.EMPTY && down != ItemStack.EMPTY) {
					
					if (delta > 0) {
						
						event.setCanceled(true);
						ModPacketHandler.simpleChannel.sendToServer(new BackpackNextTopToolMessage());
						
					} else if (delta < 0) {
						
						event.setCanceled(true);
						ModPacketHandler.simpleChannel.sendToServer(new BackpackNextDownToolMessage());
						
					}
					
				}
				
			}
			
		}
		
	}
	
}