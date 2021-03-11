package net.luis.survive.events.entity.living.combat;

import net.luis.survive.Survive;
import net.luis.survive.init.ModEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingHurtEvent {
	
	@SubscribeEvent
	public static void LivingHurt(LivingHurtEvent event) {
		
		LivingEntity entity = event.getEntityLiving();
		DamageSource source = event.getSource();
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
			int enchElytraFalling = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.ELYTRA_FALLING.get(), item);
			
			if (source == DamageSource.FLY_INTO_WALL) {
				
				if (enchElytraFalling > 1) {
					
					event.setCanceled(true);
					
				}
				
			}
			
		}
		
	}
	
}

