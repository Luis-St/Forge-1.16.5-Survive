package net.luis.survive.init.items;

import net.luis.survive.Survive;
import net.luis.survive.common.item.vanilla.Sugar;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaItems {
	
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Survive.MINECRAFT_ID);
	
	
	public static final RegistryObject<Sugar> SUGAR = VANILLA_ITEMS.register("sugar", Sugar::new);

}
