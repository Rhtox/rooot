package com.rhtox.rooot.component;

import org.ladysnake.cca.api.v3.component.ComponentV3;

public interface IntComponent extends ComponentV3 {
    int getValue();
    void setValue(int value);
    void addAmount(int amount);
    void subtractAmount(int amount);
}
