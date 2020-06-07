package com.arreme.mtt3.domain.generation.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.ShipwreckConfig;

public class BiomeOne extends Biome {

    public BiomeOne(Builder biomeBuilder) {
        super(biomeBuilder);
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SNOW_GOLEM,25,2,5));
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addExtraEmeraldOre(this);
        DefaultBiomeFeatures.addEndCity(this);
        addStructure(Feature.IGLOO.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        addStructure(Feature.SHIPWRECK.withConfiguration(new ShipwreckConfig(false)));
    }
}
