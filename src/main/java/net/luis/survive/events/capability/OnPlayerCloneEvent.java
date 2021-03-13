package net.luis.survive.events.capability;

import net.luis.survive.Survive;
import net.luis.survive.init.capability.BackpackCapability;
import net.luis.survive.init.capability.EnderChestCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemStackHandler;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnPlayerCloneEvent {
	
	@SubscribeEvent
	public static void PlayerClone(PlayerEvent.Clone event) {
		
		PlayerEntity original = event.getOriginal();
		PlayerEntity player = event.getPlayer();
		
		original.getCapability(BackpackCapability.BACKPACK, null).ifPresent(oldBackpack -> {
			
			CompoundNBT nbt = ((ItemStackHandler) oldBackpack).serializeNBT();
					
			player.getCapability(BackpackCapability.BACKPACK, null).ifPresent(newBackpack -> {
				
				((ItemStackHandler) newBackpack).deserializeNBT(nbt);
				
			});
			
		});
		
		original.getCapability(EnderChestCapability.ENDERCHEST, null).ifPresent(oldEnderChest -> {
			
			
					
			player.getCapability(EnderChestCapability.ENDERCHEST, null).ifPresent(newEnderChest -> {
				
				
				
			});
			
		});
		
	}

}
