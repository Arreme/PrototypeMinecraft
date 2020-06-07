package com.arreme.mtt3.register.inits;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.domain.tileentities.ExampleChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ModTry3.MOD_ID);

    public static final RegistryObject<TileEntityType<ExampleChestTileEntity>> EXAMPLE_CHEST = TILE_ENTITIES
            .register("example_chest", () -> TileEntityType.Builder
                    .create(ExampleChestTileEntity::new, BlockInit.EXAMPLE_CHEST.get()).build(null));
}
