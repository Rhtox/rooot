package com.rhtox.rooot;

import com.rhtox.rooot.component.ModComponents;
import com.rhtox.rooot.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rooot implements ModInitializer {
	public static final String MOD_ID = "rooot";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		new ModComponents().onInitialize();
		ModItems.registerModItems();
	}
}