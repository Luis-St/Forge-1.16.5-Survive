package net.luis.survive.events.world.block.destroy;

import net.luis.survive.Survive;
import net.luis.survive.api.world.block.BlockManager;
import net.luis.survive.init.ModEnchantment;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnHarvesting {
	
	@SubscribeEvent
	public static void Harvesting(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		BlockState state = event.getState();
		int enchHarvesting = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.HARVESTING.get(), player.getHeldItemMainhand());
		int destroyCount = enchHarvesting != 0 ? ((enchHarvesting) * 5) - 1 : 0;
		
		if (player instanceof PlayerEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRule.ENABLE_INFINITE_HARVESTING.getRule())) {
				
				if (enchHarvesting >= 5) {
					
					destroyCount = 255;
					
				}
				
			}
			
			if (!player.abilities.isCreativeMode) {
				
				if (enchHarvesting > 0) {
					
					if (BlockManager.isBrokenWood(state)) {
						
						int y = pos.getY() + 1;
						
						for (int i = 0; i < destroyCount; i++) {
							
							if (BlockManager.isBlockUpWood(world, pos.getX(), y, pos.getZ())) {
								
								world.destroyBlock(new BlockPos(pos.getX(), y, pos.getZ()), true);
								
								if (Math.random() >= 0.66) {
									
									player.getHeldItemMainhand().damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
									
								}
								
							} else {
								
								break;
								
							}
							
							y++;
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
