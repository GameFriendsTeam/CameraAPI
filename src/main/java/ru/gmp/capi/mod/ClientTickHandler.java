package ru.gmp.capi.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.gmp.capi.CameraAPI;
import ru.gmp.capi.api.Rotation;

@Mod.EventBusSubscriber(modid = CameraAPI.MODID, value = Dist.CLIENT)
public class ClientTickHandler {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        if (Minecraft.getInstance().level != null) {
            CameraAPI.initCamera();
        }

        /*if (Binds.TOGGLE_CAMERA.consumeClick()) {
            CameraAPI.toggleCamera();
        }
        if (Binds.CHANGE_POS.consumeClick()) {
            Vec3 pos = Minecraft.getInstance().player.position();
            CameraAPI.setCameraPos(new Rotation(pos.x, pos.y, pos.z, 0, 0));
        }*/
    }
}
