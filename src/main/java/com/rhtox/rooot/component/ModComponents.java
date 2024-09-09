package com.rhtox.rooot.component;

import com.rhtox.rooot.Rooot;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class ModComponents implements ModInitializer {
    @Override
    public void onInitialize() {
        Rooot.LOGGER.info("Registering {} components", Rooot.MOD_ID);
        ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> {
            if (alive) {
                ModComponents.MANA.get(newPlayer).setValue(ModComponents.MANA.get(oldPlayer).getValue());
            }
        });
    }

    public static final ComponentKey<ManaComponent> MANA = ComponentRegistryV3.INSTANCE.getOrCreate(
            Identifier.of(Rooot.MOD_ID, "mana_component"),
            ManaComponent.class);

}