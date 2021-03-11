package net.luis.survive.events.world.block.destroy;

import net.luis.survive.Survive;
import net.luis.survive.init.ModEnchantment;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnBlasting {
	
	@SubscribeEvent
	public static void Blasting(BlockEvent.BreakEvent event) {
		
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		double x = event.getPos().getX();
		double y = event.getPos().getY();
		double z = event.getPos().getZ();
		int enchBlasting = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.BLASTING.get(), player.getHeldItemMainhand());

		if (player instanceof PlayerEntity) {
			
			if (enchBlasting > 0) {
				
				world.createExplosion(player, x, y, z, 2.0f * (enchBlasting + 1), Explosion.Mode.BREAK);
				
				if (world.getGameRules().getBoolean(ModGameRule.ENABLE_BLASTING_DAMAGE.getRule())) {
					
					player.attackEntityFrom(DamageSource.causeExplosionDamage(player), enchBlasting + 2);
				
				}
				
			}
			
		}
		
	}
	
}
