package ru.whbex.develop.vkrelax.mixin;

import com.mojang.blaze3d.vulkan.VulkanDebug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ru.whbex.develop.vkrelax.VkRelax;

import java.util.Set;

@Mixin(VulkanDebug.class)
public interface VulkanDebugMixin {

    /**
     * @author whitebelyash
     * @reason Qualcomm sucks. TODO: implement different way
     */
    @Overwrite
    static VulkanDebug create(final int verbosity, final boolean wantsDebugLabels, final Set<String> availableExtensions, final Set<String> enabledExtensions){
        VkRelax.LOGGER.info("Returning disabled Debug");
        return new VulkanDebug.Disabled();
    }
}
