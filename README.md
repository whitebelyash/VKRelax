# VulkanFixes

A tiny Minecraft mod that fixes some things around Minecraft Vulkan backend:
* Removes fillModeNonSolid - used for debug features. but completely blocks support for ARM_PROPRIETARY/KosmicKrisp/PanVK. Mali does not support this feature in hardware.
* KHR_push_descriptor - probably won't work thus will be removed soon

Removing these do not mean MC will boot on your GPU. It just makes possible to run it on some rare configurations.

Additionally, this mod patches preTransform for the game swapchain. ANativeWindow & MC 26.2 don't go well, who could think.
