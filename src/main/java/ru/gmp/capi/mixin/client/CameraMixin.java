package ru.gmp.capi.mixin.client;

import net.minecraft.client.Camera;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.gmp.capi.CameraAPI;

@Mixin(Camera.class)
public class CameraMixin {
    @Inject(method = "getFluidInCamera", at = @At("HEAD"), cancellable = true)
    public void onGetSubmersionType(CallbackInfoReturnable<FogType> cir) {
        if (CameraAPI.getCameraEnabled()) {
            cir.setReturnValue(FogType.NONE);
        }
    }
}