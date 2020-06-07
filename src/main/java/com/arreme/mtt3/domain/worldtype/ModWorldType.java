package com.arreme.mtt3.domain.worldtype;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.CreateWorldScreen;
import net.minecraft.world.WorldType;

public class ModWorldType extends WorldType {

    public ModWorldType(String name) {
        super(name);
    }

    @Override
    public boolean canBeCreated() {
        Minecraft obj = Minecraft.getInstance();
        if (obj.currentScreen instanceof CreateWorldScreen)
            return ((CreateWorldScreen)obj.currentScreen).hardCoreMode;
        return false;
    }
}
