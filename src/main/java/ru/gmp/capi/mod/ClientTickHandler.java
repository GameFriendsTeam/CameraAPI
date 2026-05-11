package ru.gmp.capi.mod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.gmp.capi.CameraAPI;

@Mod.EventBusSubscriber(modid = CameraAPI.MODID, value = Dist.CLIENT)
public class ClientTickHandler {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        if (Minecraft.getInstance().level != null) {
            CameraAPI.initCamera();
        }
    }
}
