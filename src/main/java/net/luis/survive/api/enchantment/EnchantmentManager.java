package net.luis.survive.api.enchantment;

import net.luis.survive.init.ModEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BookItem;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnchantmentManager extends EnchantmentHelper {
	
	public static boolean enchantmentTransferCase1(ItemStack inputLeft, ItemStack inputRight) {
		
		if (inputLeft != null && inputRight != null) {
			
			if (inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
				
				if (inputRight.getItem() instanceof BookItem && inputRight.getCount() == 1) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public static boolean enchantmentTransferCase2(ItemStack inputLeft, ItemStack inputRight) {
		
		if (inputLeft != null && inputRight != null) {
			
			if (inputLeft.getItem() instanceof EnchantedBookItem && inputRight.getItem() instanceof BookItem) {
				
				if (inputRight.getCount() == 1) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public static int growthLevel(ItemStack[] item) {
		
		int enchGrowthHead = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[0]);
		int enchGrowthChest = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[1]);
		int enchGrowthLegs = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[2]);
		int enchGrowthFeet = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[3]);
		
		return enchGrowthHead + enchGrowthChest + enchGrowthLegs + enchGrowthFeet;
		
	}
	
	public static void voidWalker(World world, PlayerEntity player) {
		
		player.fallDistance = 0f;
		
		if (!player.isSneaking()) {
	
			if (!world.getBlockState(new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ())).isSolid()) {
				
				if (player.getMotion().getY() < 0) {
					
					player.setMotion(player.getMotion().getX(), 0, player.getMotion().getZ());
					player.setOnGround(true);
					
				}
				
			}
			
		}
		
	}
	
	public static boolean isItemEnchanted(ItemStack inputLeft, ItemStack inputRight) {
		
		if (!inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
			
			return false;
			
		} else if (inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
			
			return true;
			
		} else if (!inputLeft.isEnchanted() && inputRight.isEnchanted()) {
			
			return true;
			
		} else {
			
			return true;
			
		}
		
	}
	
}
