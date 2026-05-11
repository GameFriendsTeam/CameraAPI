package ru.gmp.capi.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.gmp.capi.CameraAPI;

@Mixin(MouseHandler.class)
public abstract class MouseHandlerMixin {

    @Inject(method = "turnPlayer", at = @At("HEAD"), cancellable = true)
    public void cancelTurnPlayer(CallbackInfo ci) {
        if (!CameraAPI.getCameraEnabled()) return;
        ci.cancel();
    }
    @Inject(method = "onPress", at = @At("HEAD"), cancellable = true)
    private void cancelMouseClicks(long window, int button, int action, int mods, CallbackInfo ci) {
        if (!CameraAPI.getCameraEnabled()) return;
        if (Minecraft.getInstance().screen != null) return;
        ci.cancel();
    }
    @Inject(method = "onScroll", at = @At("HEAD"), cancellable = true)
    private void cancelScrollSlotSwitch(long window, double xOffset, double yOffset, CallbackInfo ci) {
        if (!CameraAPI.getCameraEnabled()) return;
        if (Minecraft.getInstance().screen == null) {
            ci.cancel();
        }
    }
}