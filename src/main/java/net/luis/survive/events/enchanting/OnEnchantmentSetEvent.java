package net.luis.survive.events.enchanting;

import net.luis.survive.Survive;
import net.luis.survive.api.event.events.EnchantmentSetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnchantmentSetEvent {

	@SubscribeEvent
	public static void EnchantmentSet(EnchantmentSetEvent event) {
		
		

	}

}
