package com.arreme.mtt3.register.inits;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.domain.blocks.ExampleChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ModTry3.MOD_ID);

    public static final RegistryObject<Block> PERMABLOCK = BLOCKS.register("permablock", () -> new Block(
            Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.GROUND)));

    public static final RegistryObject<ExampleChestBlock> EXAMPLE_CHEST = BLOCKS.register("example_chest",
            () -> new ExampleChestBlock(Block.Properties.from(Blocks.CHEST)));


}
