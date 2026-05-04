package ru.whbex.develop.vkrelax;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class VkRelax implements ModInitializer {
	public static final String MOD_ID = "vkrelax";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Set<String> FEATURES = Set.of("fillModeNonSolid");

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + " installed!");
	}
}