package ru.gmp.capi.mixin.client;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.gmp.capi.CameraAPI;

@Mixin(KeyMapping.class)
public abstract class KeyMappingMixin {

    @Inject(method = "consumeClick", at = @At("HEAD"), cancellable = true)
    private void blockHotbarKeys(CallbackInfoReturnable<Boolean> cir) {
        if (!CameraAPI.getCameraEnabled()) return;
        KeyMapping self = (KeyMapping) (Object) this;
        Options options = Minecraft.getInstance().options;

        if (self == options.keyInventory ||
                self == options.keyChat ||
                self == options.keyAdvancements ||
                self == options.keySocialInteractions ||
                self == options.keySwapOffhand ||
                self == options.keyCommand
        ) {
            cir.setReturnValue(false);
            return;
        }

        for (KeyMapping hotbarKey : options.keyHotbarSlots) {
            if (self == hotbarKey) {
                cir.setReturnValue(false);
                return;
            }
        }
    }
}
