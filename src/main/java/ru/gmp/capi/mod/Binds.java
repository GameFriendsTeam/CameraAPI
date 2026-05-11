package ru.gmp.capi.mod;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class Binds {
    public static final KeyMapping TOGGLE_CAMERA = new KeyMapping(
            "key.cameraapi.toggle_camera",
            GLFW.GLFW_KEY_F6,
            "key.categories.cameraapi"
    );
    public static final KeyMapping CHANGE_POS = new KeyMapping(
            "key.cameraapi.ch_pos",
            GLFW.GLFW_KEY_F4,
            "key.categories.cameraapi"
    );
}
