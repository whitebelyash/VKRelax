package ru.whbex.develop.vkfixes;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class VulkanFixes implements ModInitializer {
	public static final String MOD_ID = "vulkanfixes";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Set<String> FEATURES = Set.of("fillModeNonSolid");
	// This might not work as we don't enable push_descriptor which is required
	public static final Set<String> EXTENSIONS = Set.of("VK_KHR_dynamic_rendering", "VK_KHR_synchronization2", "VK_KHR_swapchain");

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + " installed!");
	}
}