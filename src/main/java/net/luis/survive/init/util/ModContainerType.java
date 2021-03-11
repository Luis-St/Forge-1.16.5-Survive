package net.luis.survive.init.util;

import net.luis.survive.Survive;
import net.luis.survive.common.inventory.container.BackpackContainer;
import net.luis.survive.common.inventory.container.CraftingStationContainer;
import net.luis.survive.common.inventory.container.ModBeaconContainer;
import net.luis.survive.common.inventory.container.ModChestContainer17x8;
import net.luis.survive.common.inventory.container.ModChestContainer9x8;
import net.luis.survive.common.inventory.container.ModEnchantingTableContainer;
import net.luis.survive.common.inventory.container.ModEnderChestContainer;
import net.luis.survive.common.inventory.container.SmeltingContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerType {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Survive.MOD_ID);
	
	
	public static final RegistryObject<ContainerType<SmeltingContainer>> SMELTING = CONTAINERS.register("smelting_container", 
			() -> IForgeContainerType.create(SmeltingContainer::new));
	
	public static final RegistryObject<ContainerType<ModChestContainer9x8>> GENERIC_9X8 = CONTAINERS.register("generic_9x8", 
			() -> IForgeContainerType.create(ModChestContainer9x8::new));
	
	public static final RegistryObject<ContainerType<ModEnderChestContainer>> ENDER_CHEST = CONTAINERS.register("mod_ender_chest", 
			() -> IForgeContainerType.create(ModEnderChestContainer::new));
	
	public static final RegistryObject<ContainerType<ModChestContainer17x8>> GENERIC_17X8 = CONTAINERS.register("generic_17x8", 
			() -> IForgeContainerType.create(ModChestContainer17x8::new));
	
	public static final RegistryObject<ContainerType<CraftingStationContainer>> CRAFTING_STATION = CONTAINERS.register("crafting_station", 
			() -> IForgeContainerType.create(CraftingStationContainer::new));
	
	public static final RegistryObject<ContainerType<ModEnchantingTableContainer>> ENCHANTING_TABLE = CONTAINERS.register("enchanting_table", 
			() -> IForgeContainerType.create(ModEnchantingTableContainer::new));
	
	public static final RegistryObject<ContainerType<ModBeaconContainer>> BEACON = CONTAINERS.register("beacon", 
			() -> IForgeContainerType.create(ModBeaconContainer::new));
	
	public static final RegistryObject<ContainerType<BackpackContainer>> BACKPACK = CONTAINERS.register("backpack", 
			() -> IForgeContainerType.create(BackpackContainer::new));
	
}
