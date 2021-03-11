package net.luis.survive.common.enchantment.tool;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;

public class Experience extends Enchantment {

	public Experience(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 2 + 10 * (enchantmentLevel - 1);
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 50;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 4;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return !(ench == Enchantments.SILK_TOUCH);
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() instanceof PickaxeItem)
			return true;
		if (stack.getItem() instanceof AxeItem)
			return true;
		if (stack.getItem() instanceof SwordItem)
			return true;
		if (stack.getItem() instanceof BowItem)
			return true;
		if (stack.getItem() instanceof CrossbowItem)
			return true;
		return false;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof PickaxeItem)
			return true;
		if (stack.getItem() instanceof AxeItem)
			return true;
		if (stack.getItem() instanceof SwordItem)
			return true;
		if (stack.getItem() instanceof BowItem)
			return true;
		if (stack.getItem() instanceof CrossbowItem)
			return true;
		return false;
	}
	
}
