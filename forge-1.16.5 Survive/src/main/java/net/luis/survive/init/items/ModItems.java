package net.luis.survive.init.items;

import net.luis.survive.Survive;
import net.luis.survive.common.item.FungusSoup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Survive.MOD_ID);
	
	
	public static final RegistryObject<Item> FUNGUS_SOUP = ITEMS.register("fungus_soup", FungusSoup::new);

	
}

