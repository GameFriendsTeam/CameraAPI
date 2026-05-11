package ru.gmp.capi.mod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.gmp.capi.CameraAPI;

@Mod.EventBusSubscriber(modid = CameraAPI.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        //event.register(Binds.TOGGLE_CAMERA);
        //event.register(Binds.CHANGE_POS);
    }
}