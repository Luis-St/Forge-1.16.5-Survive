package net.luis.survive.events.world.block.destroy;

import net.luis.survive.Survive;
import net.luis.survive.api.world.block.BlockManager;
import net.luis.survive.init.ModEnchantment;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSmeltingDrop {
	
	@SubscribeEvent
	public static void SmeltingDrop(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		int enchSmelting = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.SMELTING.get(), player.getHeldItemMainhand());

		if(player instanceof PlayerEntity) {
			
			if (!player.abilities.isCreativeMode) {
					
				if (enchSmelting > 0) {
					
					if (BlockManager.hasSmelting(world, pos)) { 
						
						if (world.getBlockState(pos).getBlock() instanceof OreBlock) {
							
							BlockManager.addFortuneSmelting(world, pos, player);
							
						} else {
							
							BlockManager.addSmelting(world, pos, player);
							
						}
						
						event.setCanceled(true);
						world.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
						
						ItemStack stack = player.getHeldItemMainhand();
						stack.damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
								
					}
					
				}
				
			}
			
		}
		
	}
		
}
