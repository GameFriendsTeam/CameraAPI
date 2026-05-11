package ru.gmp.capi;

import com.mojang.authlib.GameProfile;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import ru.gmp.capi.api.CameraEntity;
import ru.gmp.capi.api.Rotation;
import ru.gmp.capi.mod.GameOverlayHandler;

import java.util.UUID;

@Mod(CameraAPI.MODID)
public class CameraAPI {
    public static final Minecraft MC = Minecraft.getInstance();
    public static final String MODID = "cameraapi";
    private static final Logger LOGGER = LogUtils.getLogger();


    private static CameraEntity selfCamera = null;
    public static double camX, camY, camZ;
    public static float camYaw, camPitch;
    private static boolean enabled = false;

    public static boolean getCameraEnabled() {
        return enabled;
    }

    public CameraAPI() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new GameOverlayHandler());

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }

    public static void initCamera() {
        if (selfCamera != null) return;
        if (MC.level == null) return;
        selfCamera = new CameraEntity(MC.level, new GameProfile(UUID.randomUUID(), "CAPI_Camera"));
    }

    public static void toggleCamera() {
        initCamera();
        if (!enabled) {
            MC.cameraEntity = selfCamera;
        } else {
            MC.cameraEntity = MC.player;
        }
        enabled = !enabled;
    }

    public static void setCameraPos(Rotation pos) {
        camX = pos.x; camY = pos.y; camZ = pos.z;
        camYaw = pos.yaw; camPitch = pos.pitch;

        if (selfCamera != null) {
            selfCamera.setPos(camX, camY, camZ);
        }
    }
}
