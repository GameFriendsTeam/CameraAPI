package ru.gmp.capi.mod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.gmp.capi.CameraAPI;

@Mod.EventBusSubscriber(modid = CameraAPI.MODID, value = Dist.CLIENT)
public class CameraRenderer {

    @SubscribeEvent
    public static void onCameraAngles(ViewportEvent.ComputeCameraAngles event) {
        if (!CameraAPI.getCameraEnabled()) return;
        event.setYaw(CameraAPI.camYaw);
        event.setPitch(CameraAPI.camPitch);
    }
}
