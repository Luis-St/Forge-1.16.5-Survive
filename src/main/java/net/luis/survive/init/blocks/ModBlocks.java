package net.luis.survive.init.blocks;

import net.luis.survive.Survive;
import net.luis.survive.common.block.CraftingStation;
import net.luis.survive.common.block.InfiniteAnvil;
import net.luis.survive.common.block.SmeltingFurnace;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Survive.MOD_ID);
	
	
	public static final RegistryObject<Block> INFINITE_ANVIL = BLOCKS.register("infinite_anvil", InfiniteAnvil::new);
	
	public static final RegistryObject<Block> SMELTING_FURNACE = BLOCKS.register("smelting_furnace", SmeltingFurnace::new);
	
	public static final RegistryObject<Block> CRAFTING_STATION = BLOCKS.register("crafting_station", CraftingStation::new);

}
