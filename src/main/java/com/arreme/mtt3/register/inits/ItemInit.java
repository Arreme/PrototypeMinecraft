package com.arreme.mtt3.register.inits;

import com.arreme.mtt3.ModTry3;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
            ModTry3.MOD_ID);

    public static final RegistryObject<BlockItem> PERMA_ITEM = ITEMS.register("permablock",
            () -> new BlockItem(BlockInit.PERMABLOCK.get(), new Item.Properties().group(ModTry3.TAB)));

    public static final RegistryObject<BlockItem> CHEST_ITEM = ITEMS.register("example_chest",
            () -> new BlockItem(BlockInit.EXAMPLE_CHEST.get(), new Item.Properties().group(ModTry3.TAB)));

}
