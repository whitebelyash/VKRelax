package ru.whbex.develop.vkrelax.mixin;

import com.mojang.blaze3d.vulkan.VulkanBackend;
import com.mojang.blaze3d.vulkan.init.VulkanFeature;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.whbex.develop.vkrelax.VkRelax;

import java.util.HashSet;
import java.util.Set;

@Mixin(VulkanBackend.class)
public class VulkanBackendMixin {
	// Uhhhh
	@Shadow
	@Final
    @Mutable
	public static Set<VulkanFeature> REQUIRED_DEVICE_FEATURES;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void removeFeature(CallbackInfo ci){
		Set<VulkanFeature> newFeatures = new HashSet<>();
		for (VulkanFeature feat : VulkanBackend.REQUIRED_DEVICE_FEATURES) {
			if (VkRelax.FEATURES.contains(feat.name()))
				continue;
			newFeatures.add(feat);
		}
		REQUIRED_DEVICE_FEATURES = newFeatures;
	}

	@Redirect(method = "isDeviceSuitable", at = @At(value = "FIELD", target = "Lcom/mojang/blaze3d/vulkan/VulkanBackend;REQUIRED_DEVICE_EXTENSIONS:Ljava/util/Set;", opcode = Opcodes.GETSTATIC))
	private static Set<String> access(){
		return VkRelax.EXTENSIONS;
	}
}