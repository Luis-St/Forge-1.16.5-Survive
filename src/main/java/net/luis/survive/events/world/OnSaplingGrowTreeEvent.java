package net.luis.survive.events.world;

import net.luis.survive.Survive;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.world.World;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSaplingGrowTreeEvent {
	
	@SubscribeEvent
	public static void SaplingGrowTree(SaplingGrowTreeEvent event) {
		
		World world = (World) event.getWorld();
		
		if (!world.getGameRules().getBoolean(ModGameRule.DO_SAPLING_GROW.getRule())) {
			
			event.setResult(Result.DENY);
			
		}
		
	}
	
}
