package ru.gmp.capi.mod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.gmp.capi.CameraAPI;

@Mod.EventBusSubscriber(modid = CameraAPI.MODID, value = Dist.CLIENT)
public class GameOverlayHandler {
    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Pre event) {
        if (!CameraAPI.getCameraEnabled()) return;
        event.cancel();
    }

    @SubscribeEvent
    public static void onHand(RenderHandEvent event) {
        if (!CameraAPI.getCameraEnabled()) return;
        event.cancel();
    }
}
