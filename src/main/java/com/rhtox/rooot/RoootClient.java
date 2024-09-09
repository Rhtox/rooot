package com.rhtox.rooot;

import net.fabricmc.api.ClientModInitializer;
import com.rhtox.rooot.client.ManaHudOverlay;

public class RoootClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ManaHudOverlay.EVENT.register(new ManaHudOverlay());
    }
}
