package net.luis.survive.init.util;

import net.luis.survive.Survive;
import net.luis.survive.common.tileentity.CraftingStationTileEntity;
import net.luis.survive.common.tileentity.ModBarrelTileEntity;
import net.luis.survive.common.tileentity.ModBeaconTileEntity;
import net.luis.survive.common.tileentity.ModEnchantingTableTileEntity;
import net.luis.survive.common.tileentity.SmeltingFurnaceTileEntity;
import net.luis.survive.init.blocks.ModBlocks;
import net.luis.survive.init.blocks.VanillaBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityType {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Survive.MOD_ID);
	
	
	public static final RegistryObject<TileEntityType<SmeltingFurnaceTileEntity>> SMELTING_FURNACE = TILE_ENTITIES.register("smelting_furnace_tileentity", 
			() -> TileEntityType.Builder.create(SmeltingFurnaceTileEntity::new, ModBlocks.SMELTING_FURNACE.get()).build(null));
	
	public static final RegistryObject<TileEntityType<ModBarrelTileEntity>> BARREL = TILE_ENTITIES.register("barrel", 
			() -> TileEntityType.Builder.create(ModBarrelTileEntity::new, VanillaBlocks.BARREL.get()).build(null));
	
	public static final RegistryObject<TileEntityType<CraftingStationTileEntity>> CRAFTING_STATION = TILE_ENTITIES.register("crafting_station", 
			() -> TileEntityType.Builder.create(CraftingStationTileEntity::new, ModBlocks.CRAFTING_STATION.get()).build(null));
	
	public static final RegistryObject<TileEntityType<ModEnchantingTableTileEntity>> ENCHANTING_TABLE = TILE_ENTITIES.register("enchanting_table", 
			() -> TileEntityType.Builder.create(ModEnchantingTableTileEntity::new, VanillaBlocks.ENCHANTING_TABLE.get()).build(null));
	
	public static final RegistryObject<TileEntityType<ModBeaconTileEntity>> BEACON = TILE_ENTITIES.register("beacon", 
			() -> TileEntityType.Builder.create(ModBeaconTileEntity::new, VanillaBlocks.BEACON.get()).build(null));
	
}
