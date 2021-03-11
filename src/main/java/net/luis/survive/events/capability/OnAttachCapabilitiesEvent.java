package net.luis.survive.events.capability;

import net.luis.survive.Survive;
import net.luis.survive.init.capability.BackpackCapability;
import net.luis.survive.init.capability.EnderChestCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnAttachCapabilitiesEvent {
	
	@SubscribeEvent
	public static void AttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer)) {
			
			PlayerEntity player = (PlayerEntity) event.getObject();
			event.addCapability(new ResourceLocation("survive:extended_enderchest_gui"), new EnderChestCapability.EnderChestProvider(player));
			event.addCapability(new ResourceLocation("survive:backpack_gui"), new BackpackCapability.BagpackProvider());
			
		}
		
	}

}