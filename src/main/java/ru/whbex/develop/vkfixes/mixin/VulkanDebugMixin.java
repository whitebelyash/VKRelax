package ru.whbex.develop.vkfixes.mixin;

import com.mojang.blaze3d.vulkan.VulkanDebug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ru.whbex.develop.vkfixes.VulkanFixes;

import java.util.Set;

@Mixin(VulkanDebug.class)
public interface VulkanDebugMixin {

    /**
     * @author whitebelyash
     * @reason Qualcomm sucks. TODO: implement different way
     */
    @Overwrite
    static VulkanDebug create(final int verbosity, final boolean wantsDebugLabels, final Set<String> availableExtensions, final Set<String> enabledExtensions){
        VulkanFixes.LOGGER.info("Returning disabled Debug");
        return new VulkanDebug.Disabled();
    }
}
