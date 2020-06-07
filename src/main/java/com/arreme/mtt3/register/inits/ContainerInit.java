package com.arreme.mtt3.register.inits;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.domain.containers.ExampleChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
            ForgeRegistries.CONTAINERS, ModTry3.MOD_ID);

    public static final RegistryObject<ContainerType<ExampleChestContainer>> EXAMPLE_CHEST = CONTAINER_TYPES
            .register("example_chest", () -> IForgeContainerType.create(ExampleChestContainer::new));
}
