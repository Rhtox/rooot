package com.rhtox.rooot.item;

import com.rhtox.rooot.Rooot;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FIRE_WAND = registerItem("fire_wand", new FireWandItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Rooot.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Rooot.LOGGER.info("Registering Mod Items for " + Rooot.MOD_ID);

        Rooot.LOGGER.info("Registering {}", FIRE_WAND.getName());
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(FIRE_WAND);
        });
    }
}
