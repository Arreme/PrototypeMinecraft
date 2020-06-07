package com.arreme.mtt3.client.gui;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.domain.containers.ExampleChestContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ExampleChestScreen extends ContainerScreen<ExampleChestContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ModTry3.MOD_ID,"textures/gui/example_chest.png");

    public ExampleChestScreen(ExampleChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        guiLeft = 0;
        guiTop = 0;
        this.xSize = 175;
        this.ySize = 183;
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();
        super.render(p_render_1_, p_render_2_, p_render_3_);
        this.renderHoveredToolTip(p_render_1_, p_render_2_);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.font.drawString(this.title.getFormattedText(),8.0f,6.0f,4210752);
        this.font.drawString("Kill me plz", 8.0f, 90.0f, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(0.0f,1.0f,1.0f,0.25f);
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.blit(x,y,0,0,xSize,ySize);
    }
}
