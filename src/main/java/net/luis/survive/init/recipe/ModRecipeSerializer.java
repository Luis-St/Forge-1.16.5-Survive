package net.luis.survive.init.recipe;

import net.luis.survive.Survive;
import net.luis.survive.common.recipe.SmeltingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializer {
	
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Survive.MOD_ID);
	
	
	public static final RegistryObject<IRecipeSerializer<?>> SMELTING = RECIPE_SERIALIZERS.register("survive_smelting", 
			() -> new SmeltingRecipe.Serializer());
	
}
