package com.rhtox.rooot.client;

import com.rhtox.rooot.component.ModComponents;
import com.rhtox.rooot.mana.BaseMana;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;


public class ManaHudOverlay implements ClientModInitializer, HudRenderCallback {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(this);
    }

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickDelta) {
        int posX = 10;
        int posY;

        MinecraftClient client = MinecraftClient.getInstance();
        if(client.player != null) {
            posY = client.getWindow().getScaledHeight() / 2;
            BaseMana playerMana = new BaseMana(client.player);
            String manaText = playerMana.getMana() + " / 100";
            drawContext.drawText(client.textRenderer, manaText, posX, posY, 0xFFFFFF, true);
        }
    }
}
