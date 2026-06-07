package ru.whbex.develop.vkfixes.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import org.lwjgl.vulkan.KHRSurface;
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(com.mojang.blaze3d.vulkan.VulkanGpuSurface.class)
public class VkGpuSurfaceMixin {

   @Inject(method = "configure", at = @At(value = "INVOKE",
           target = "Lorg/lwjgl/vulkan/VkSwapchainCreateInfoKHR;preTransform(I)Lorg/lwjgl/vulkan/VkSwapchainCreateInfoKHR;",
           shift = At.Shift.AFTER
   ))
    public void injectTransform(CallbackInfo ci, @Local(name = "swapchainCreateInfo") VkSwapchainCreateInfoKHR swapchainCreateInfo){
        swapchainCreateInfo.preTransform(KHRSurface.VK_SURFACE_TRANSFORM_IDENTITY_BIT_KHR);
    }
}
