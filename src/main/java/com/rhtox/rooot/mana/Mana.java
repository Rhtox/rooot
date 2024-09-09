package com.rhtox.rooot.mana;

import com.rhtox.rooot.Rooot;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentV3;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;

public interface Mana extends ComponentV3 {
    ComponentKey<Mana> KEY = ComponentRegistryV3.INSTANCE.getOrCreate(Identifier.of(
            Rooot.MOD_ID, "mana_component"),
            Mana.class);

    static Mana get(Object provider) {
        return KEY.get(provider);
    }

    public int getMana();
    public void setMana(int value);
    public void addMana(int amount);
    public void subtractMana(int amount);

}