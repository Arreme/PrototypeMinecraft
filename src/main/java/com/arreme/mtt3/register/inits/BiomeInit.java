package com.arreme.mtt3.register.inits;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.domain.generation.biomes.BiomeOne;
import com.arreme.mtt3.domain.generation.biomes.ExampleSurficeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, ModTry3.MOD_ID);

    public static RegistryObject<Biome> TRY_BIOME = BIOMES.register("biome_one", () -> new BiomeOne(new Biome.Builder()
            .waterColor(0x0535FF).waterFogColor(0x9BC5C1)
            .scale(1.5f)
            .precipitation(Biome.RainType.SNOW)
            .depth(10)
            .temperature(-0.5f)
            .surfaceBuilder(new ConfiguredSurfaceBuilder<>(
                    register("example_surface",
                            new ExampleSurficeBuilder(
                                    SurfaceBuilderConfig::deserialize)),
                    new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(),
                            Blocks.RED_NETHER_BRICKS.getDefaultState(),
                            Blocks.DIRT.getDefaultState()))
            )
            .category(Biome.Category.PLAINS)
            .downfall(0.8f)
            .depth(0.12f)
            .parent(null)

    ));

    public static void registerBiome() {
        registerBiome(TRY_BIOME.get(), BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome,100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
    @SuppressWarnings("deprecation")
    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
    }
}
