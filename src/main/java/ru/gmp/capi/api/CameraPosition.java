package ru.gmp.capi.api;

import net.minecraft.world.phys.Vec3;

public class CameraPosition {
    public final double x;
    public final double y;
    public final double z;

    public final float yaw;
    public final float pitch;

    public CameraPosition(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Vec3 toVector() {
        return new Vec3(x, y, z);
    }

    public static CameraPosition fromVector(Vec3 vec) {
        double x = vec.x;
        double y = vec.y;
        double z = vec.z;

        return new CameraPosition(x, y, z, 0, 0);
    }
}