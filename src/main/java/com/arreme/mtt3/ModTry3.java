package com.arreme.mtt3;

import com.arreme.mtt3.register.inits.*;
import com.arreme.mtt3.domain.worldtype.ModWorldType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mtt3")
@Mod.EventBusSubscriber(modid = ModTry3.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTry3
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mtt3";
    public static final ResourceLocation example_dim_type = new ResourceLocation(MOD_ID,"dimensionone");

    public ModTry3() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        registerObjects(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerObjects(IEventBus modEventBus) {
        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        TileEntityInit.TILE_ENTITIES.register(modEventBus);
        ContainerInit.CONTAINER_TYPES.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);
        DimensionInit.DIMENSIONS.register(modEventBus);
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        BiomeInit.registerBiome();
    }

    private void setup(final FMLCommonSetupEvent event) {}

    private void doClientStuff(final FMLClientSetupEvent event) {
        new ModWorldType("permadeath");
    }

    public static final ItemGroup TAB = new ItemGroup("permamod") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.PERMABLOCK.get());
        }
    };

}
