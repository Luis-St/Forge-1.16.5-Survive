package net.luis.survive.common.enchantment.vanilla;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Piercing extends Enchantment {

	public Piercing(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 1 + (enchantmentLevel - 1) * 10;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return 50;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 4;
		
	}
	
}
