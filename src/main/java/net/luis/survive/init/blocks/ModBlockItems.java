package net.luis.survive.init.blocks;

import net.luis.survive.Survive;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Survive.MOD_ID);
	
	
	public static final RegistryObject<Item> INFINITE_ANVIL_ITEM = ITEMS.register("infinite_anvil", 
			() -> new BlockItem(ModBlocks.INFINITE_ANVIL.get(), new Item.Properties().group(Survive.DECORATIONS)));
	
	public static final RegistryObject<Item> SMELTING_FURNACE_ITEM = ITEMS.register("smelting_furnace", 
			() -> new BlockItem(ModBlocks.SMELTING_FURNACE.get(), new Item.Properties().group(Survive.DECORATIONS)));
	
	public static final RegistryObject<Item> CRAFTING_STATION_ITEM = ITEMS.register("crafting_station", 
			() -> new BlockItem(ModBlocks.CRAFTING_STATION.get(), new Item.Properties().group(Survive.DECORATIONS)));
	
}
