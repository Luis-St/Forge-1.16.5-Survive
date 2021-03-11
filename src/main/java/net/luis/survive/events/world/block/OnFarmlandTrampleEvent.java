package net.luis.survive.events.world.block;

import net.luis.survive.Survive;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnFarmlandTrampleEvent {
	
	@SubscribeEvent
	public static void FarmlandTrample(BlockEvent.FarmlandTrampleEvent event) {
		
		World world = (World) event.getWorld();
		
		if (world.getGameRules().getBoolean(ModGameRule.DISABLE_FARMLAND_TRAMPLE.getRule())) {
			
			event.setCanceled(true);
			
		}
		
	}
	
}

