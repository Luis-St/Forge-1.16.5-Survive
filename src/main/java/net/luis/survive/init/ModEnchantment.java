package net.luis.survive.init;

import net.luis.survive.Survive;
import net.luis.survive.common.enchantment.armor.ElytraFalling;
import net.luis.survive.common.enchantment.armor.ElytraProtection;
import net.luis.survive.common.enchantment.armor.Growth;
import net.luis.survive.common.enchantment.armor.VoidWalker;
import net.luis.survive.common.enchantment.curse.CurseOfBreaking;
import net.luis.survive.common.enchantment.curse.CurseOfHarming;
import net.luis.survive.common.enchantment.tool.Blasting;
import net.luis.survive.common.enchantment.tool.DoubleDrops;
import net.luis.survive.common.enchantment.tool.Experience;
import net.luis.survive.common.enchantment.tool.Harvesting;
import net.luis.survive.common.enchantment.tool.Smelting;
import net.luis.survive.common.enchantment.vanilla.Impaling;
import net.luis.survive.common.enchantment.vanilla.Infinity;
import net.luis.survive.common.enchantment.vanilla.Piercing;
import net.luis.survive.common.enchantment.vanilla.Punch;
import net.luis.survive.common.enchantment.vanilla.QuickCharge;
import net.luis.survive.common.enchantment.vanilla.Thorns;
import net.luis.survive.common.enchantment.weapon.EnderSlayer;
import net.luis.survive.common.enchantment.weapon.FrostAspect;
import net.luis.survive.common.enchantment.weapon.PoisonAspect;
import net.luis.survive.common.enchantment.weapon.Thunderbolt;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantment {
	
	public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Survive.MOD_ID);
	public static final DeferredRegister<Enchantment> VANILLA_ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Survive.MINECRAFT_ID);
	private static final EquipmentSlotType[] ARMOR_SLOTS = new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};
	
	public static final RegistryObject<Enchantment> DOUBLE_DROPS = ENCHANTMENT.register("double_drops", 
			() -> new DoubleDrops(Rarity.VERY_RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> BLASTING = ENCHANTMENT.register("blasting", 
			() -> new Blasting(Rarity.UNCOMMON, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> POISON_ASPECT = ENCHANTMENT.register("poison_aspect", 
			() -> new PoisonAspect(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> FROST_ASPECT = ENCHANTMENT.register("frost_aspect", 
			() -> new FrostAspect(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> EXPERIENCE = ENCHANTMENT.register("experience", 
			() -> new Experience(Rarity.UNCOMMON, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> SMELTING = ENCHANTMENT.register("smelting", 
			() -> new Smelting(Rarity.RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> INFINITY = VANILLA_ENCHANTMENT.register("infinity", 
			() -> new Infinity(Rarity.VERY_RARE, EnchantmentType.BOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> ELYTRA_PROTECTION = ENCHANTMENT.register("elytra_protection", 
			() -> new ElytraProtection(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, EquipmentSlotType.CHEST));
	
	public static final RegistryObject<Enchantment> ELYTRA_FALLING = ENCHANTMENT.register("elytra_falling", 
			() -> new ElytraFalling(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, EquipmentSlotType.CHEST));
	
	public static final RegistryObject<Enchantment> VOID_WALKER = ENCHANTMENT.register("void_walker", 
			() -> new VoidWalker(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, EquipmentSlotType.FEET));
	
	public static final RegistryObject<Enchantment> PIERCING = VANILLA_ENCHANTMENT.register("piercing",
			() -> new Piercing(Rarity.COMMON, EnchantmentType.CROSSBOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> QUICK_CHARGE = VANILLA_ENCHANTMENT.register("quick_charge", 
			() -> new QuickCharge(Rarity.UNCOMMON, EnchantmentType.CROSSBOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> GROWTH = ENCHANTMENT.register("growth", 
			() -> new Growth(Rarity.UNCOMMON, EnchantmentType.ARMOR, ARMOR_SLOTS));
	
	public static final RegistryObject<Enchantment> CURSE_OF_BREAKING = ENCHANTMENT.register("curse_of_breaking", 
			() -> new CurseOfBreaking(Rarity.VERY_RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.values()));
	
	public static final RegistryObject<Enchantment> CURSE_OF_HARMING = ENCHANTMENT.register("curse_of_harming", 
			() -> new CurseOfHarming(Rarity.VERY_RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> HARVESTING = ENCHANTMENT.register("harvesting", 
			() -> new Harvesting(Rarity.COMMON, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> THORNS = VANILLA_ENCHANTMENT.register("thorns", 
			() -> new Thorns(Rarity.VERY_RARE, EnchantmentType.ARMOR, ARMOR_SLOTS));
	
	public static final RegistryObject<Enchantment> PUNCH = VANILLA_ENCHANTMENT.register("punch", 
			() -> new Punch(Rarity.RARE, EnchantmentType.BOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> ENDER_SLYAER = ENCHANTMENT.register("ender_slayer", 
			() -> new EnderSlayer(Rarity.UNCOMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> THUNDERBOLT = ENCHANTMENT.register("thunderbolt", 
			() -> new Thunderbolt(Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> IMPALING = VANILLA_ENCHANTMENT.register("impaling", 
			() -> new Impaling(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

}