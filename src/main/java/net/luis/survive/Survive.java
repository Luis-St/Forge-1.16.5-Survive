package net.luis.survive;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.survive.api.capability.IBackpackItemHandler;
import net.luis.survive.api.capability.IEnderChestItemHandler;
import net.luis.survive.core.ModPacketHandler;
import net.luis.survive.init.ModEnchantment;
import net.luis.survive.init.blocks.ModBlockItems;
import net.luis.survive.init.blocks.ModBlocks;
import net.luis.survive.init.blocks.ModVerticalBlockItems;
import net.luis.survive.init.blocks.ModVerticalBlocks;
import net.luis.survive.init.blocks.VanillaBlockItems;
import net.luis.survive.init.blocks.VanillaBlocks;
import net.luis.survive.init.capability.BackpackCapability;
import net.luis.survive.init.capability.EnderChestCapability;
import net.luis.survive.init.items.ModItems;
import net.luis.survive.init.items.VanillaItems;
import net.luis.survive.init.recipe.ModRecipeSerializer;
import net.luis.survive.init.util.ModContainerType;
import net.luis.survive.init.util.ModPaintingType;
import net.luis.survive.init.util.ModTileEntityType;
import net.luis.survive.init.villager.ModPointOfInterestTypes;
import net.luis.survive.init.villager.ModVillagerProfessions;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Survive.MOD_ID)
public class Survive {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "survive";
	public static final String MINECRAFT_ID = "minecraft";
	
	public Survive() {
		
		LOGGER.info("Mod found: " + MOD_ID);
		LOGGER.info("Initialization has started");
		LOGGER.info("Override of vanilla elements found");
		LOGGER.warn("Initialization was stopped");
		LOGGER.info("The initialization was started again. Overrides of vanilla elements have been considered");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlocks.BLOCKS.register(modEventBus);
		ModBlockItems.ITEMS.register(modEventBus);
		VanillaBlocks.VANILLA_BLOCKS.register(modEventBus);
		VanillaBlockItems.ITEMS.register(modEventBus);
		LOGGER.info("Blocks were successfully initialized");
		
		ModVerticalBlocks.BLOCKS.register(modEventBus);
		ModVerticalBlockItems.ITEMS.register(modEventBus);
		LOGGER.info("Vertical slabs were successfully initialized");
		
		ModItems.ITEMS.register(modEventBus);
		VanillaItems.VANILLA_ITEMS.register(modEventBus);
		LOGGER.info("Items were successfully initialized");
		
		ModEnchantment.ENCHANTMENT.register(modEventBus);
		ModEnchantment.VANILLA_ENCHANTMENT.register(modEventBus);
		LOGGER.info("Enchantments were successfully initialized");
		
		ModTileEntityType.TILE_ENTITIES.register(modEventBus);
		ModContainerType.CONTAINERS.register(modEventBus);
		ModRecipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);
		LOGGER.info("Util were successfully initialized");
		
		ModPointOfInterestTypes.POI_TYPE.register(modEventBus);
		ModPointOfInterestTypes.VANILLA_POI_TYPE.register(modEventBus);
		ModVillagerProfessions.PROFESSIONS.register(modEventBus);
		LOGGER.info("Villager were successfully initialized");
		
		ModPaintingType.PAINTING_TYPES.register(modEventBus);
		LOGGER.info("Paintings were successfully initialized");
		
		MinecraftForge.EVENT_BUS.register(this);
		
		LOGGER.info("Mod: " + MOD_ID + " successfully initialized");
		
	}
	
	private void setup(FMLCommonSetupEvent event) {
		
		CapabilityManager.INSTANCE.register(IEnderChestItemHandler.class, 
				new EnderChestCapability.EnderChestStorage(), 
				new EnderChestCapability.EnderChestFactory());
		CapabilityManager.INSTANCE.register(IBackpackItemHandler.class, 
				new BackpackCapability.BagpackStorage(), 
				new BackpackCapability.BagpackFactory());
		
	}
	
	private void doClientStuff(FMLClientSetupEvent event) {
	
		ModPacketHandler.init();
		
	}
	
	public static final ItemGroup VERTICAL_SLABS = new ItemGroup("vertical_slabs") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Blocks.BRICK_SLAB);
			
		}
		
	};

	
	public static final ItemGroup DECORATIONS = new ItemGroup("decorations") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Blocks.PEONY);
			
		}
		
	};
	
	public static final ItemGroup FOOD = new ItemGroup("food") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.APPLE);
			
		}
		
	};

}

