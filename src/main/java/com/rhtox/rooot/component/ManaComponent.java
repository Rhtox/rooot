package com.rhtox.rooot.component;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;

public class ManaComponent implements IntComponent {
    private int mana = 100;

    @Override
    public int getValue() {
        return mana;
    }

    @Override
    public void setValue(int value) {
        mana = value;
    }

    @Override
    public void addAmount(int amount) {
        mana += amount;
    }

    @Override
    public void subtractAmount(int amount) {
        mana -= amount;
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