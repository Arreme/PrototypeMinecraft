package com.arreme.mtt3.domain.generation.dimension;

import com.arreme.mtt3.register.inits.BiomeInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class BiomeOneProvider extends BiomeProvider {

    private Random rand;
    private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.TRY_BIOME.get());

    protected BiomeOneProvider() {
        super(biomeList);
        rand = new Random();
    }



    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return BiomeInit.TRY_BIOME.get();
    }
}
