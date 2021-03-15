package net.luis.survive.events.capability;

import net.luis.survive.Survive;
import net.luis.survive.init.capability.BackpackCapability;
import net.luis.survive.init.capability.EnderChestCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandlerModifiable;
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
		
		original.getCapability(EnderChestCapability.ENDERCHEST, Direction.WEST).ifPresent(oldEnderChest -> {
			
			IItemHandlerModifiable oldItemModifiable = oldEnderChest;
			ItemStackHandler oldItemHandler = (ItemStackHandler) oldItemModifiable;
			CompoundNBT nbt = oldItemHandler.serializeNBT();
					
			player.getCapability(EnderChestCapability.ENDERCHEST, Direction.WEST).ifPresent(newEnderChest -> {
				
				IItemHandlerModifiable newItemModifiable = newEnderChest;
				ItemStackHandler newItemHandler = (ItemStackHandler) newItemModifiable;
				newItemHandler.deserializeNBT(nbt);
				
			});
			
		});
		
	}

}
