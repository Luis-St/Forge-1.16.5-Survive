package net.luis.survive.events.entity.player.interact.block;

import java.util.ArrayList;
import java.util.List;

import net.luis.survive.Survive;
import net.luis.survive.api.world.WorldManager;
import net.minecraft.block.BellBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnBell {
	
	@SubscribeEvent
	public static void PlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		BlockState state = world.getBlockState(pos);
		boolean flag = BlockTags.getCollection().get(new ResourceLocation(Survive.MOD_ID, "bell")).contains(state.getBlock());
		
		if (state.getBlock() instanceof BellBlock || flag) {
			
			if (world instanceof ServerWorld) {
				
				ServerWorld serverWorld = (ServerWorld) world;
				Raid raid = serverWorld.getRaids().findRaid(pos, 100);
				AxisAlignedBB axisAligned = WorldManager.creatAxisAligned(pos, 150);
				
				if (raid == null) {
					
					List<VillagerEntity> villagers = serverWorld.getEntitiesWithinAABB(VillagerEntity.class, axisAligned);
					
					for (VillagerEntity villager : villagers) {
						
						villager.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 0, true, false));
						
					}
					
				} else {
					
					List<AbstractIllagerEntity> illagerEntities = serverWorld.getEntitiesWithinAABB(AbstractIllagerEntity.class, axisAligned);
					List<AbstractRaiderEntity> raiderEntities = serverWorld.getEntitiesWithinAABB(AbstractRaiderEntity.class, axisAligned);
					List<LivingEntity> raider = new ArrayList<LivingEntity>();
					raider.addAll(raiderEntities);
					raider.addAll(illagerEntities);
					
					for (LivingEntity entity : raider) {
						
						entity.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 0, true, false));
						
					}
					
				}
				
			}
			
		}

	}

}
