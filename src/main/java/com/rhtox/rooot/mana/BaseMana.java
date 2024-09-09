package com.rhtox.rooot.mana;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;


public class BaseMana implements Mana, AutoSyncedComponent {
    private int mana;

    private final Object owner;


    public BaseMana(Object owner) {
        mana = 100;
        this.owner = owner;
    }

    public BaseMana(int newBaseManaValue, Object owner) {
        mana = newBaseManaValue;
        this.owner = owner;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int value) {
        mana = value;
        Mana.KEY.sync(owner);
    }

    @Override
    public void addMana(int amount) {
        mana += amount;
        Mana.KEY.sync(owner);
    }

    @Override
    public void subtractMana(int amount) {
        mana -= amount;
        Mana.KEY.sync(owner);
    }

    @Override
    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        mana = tag.getInt("mana");
    }

    @Override
    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        tag.putInt("mana", mana);
    }
}