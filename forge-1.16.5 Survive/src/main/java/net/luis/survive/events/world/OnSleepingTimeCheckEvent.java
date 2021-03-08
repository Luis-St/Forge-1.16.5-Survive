package net.luis.survive.events.world;

import net.luis.survive.Survive;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.SleepingTimeCheckEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSleepingTimeCheckEvent {
	
	@SubscribeEvent
	public static void SleepingTimeCheck(SleepingTimeCheckEvent event) {
		
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		
		if (world.isRaining()) {
			
			if (world.getGameRules().getBoolean(ModGameRule.ENABLE_RAIN_SLEEP.getRule())) {
				
				event.setResult(Result.ALLOW);
				
			}
			
		}

	}

}

