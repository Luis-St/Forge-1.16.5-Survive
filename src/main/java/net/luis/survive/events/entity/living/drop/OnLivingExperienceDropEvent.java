package net.luis.survive.events.entity.living.drop;

import net.luis.survive.Survive;
import net.luis.survive.init.ModEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingExperienceDropEvent {

	@SubscribeEvent
	public static void LivingExperienceDrop(LivingExperienceDropEvent event) {
		
		PlayerEntity player = event.getAttackingPlayer();
		int xp = event.getOriginalExperience();
		
		if (player != null) {
			
			int enchExperience = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.EXPERIENCE.get(), player.getHeldItemMainhand());
			int enchLooting = EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, player.getHeldItemMainhand());
			
			if (enchExperience > 0) {
				
				event.setDroppedExperience(xp * ((enchExperience + 1) * ((enchExperience * 2) + enchLooting)));
				
			}
			
		}
		
	}

}
