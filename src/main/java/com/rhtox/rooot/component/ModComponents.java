package com.rhtox.rooot.component;

import com.rhtox.rooot.Rooot;
import com.rhtox.rooot.mana.Mana;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class ModComponents implements ModInitializer {
    public static final ComponentKey<Mana> MANA = ComponentRegistryV3.INSTANCE.getOrCreate(
            Identifier.of(Rooot.MOD_ID, "mana_component"), Mana.class
    );

    @Override
    public void onInitialize() {

    }
}