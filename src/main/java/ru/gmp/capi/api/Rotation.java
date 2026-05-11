package ru.gmp.capi.api;

import net.minecraft.world.phys.Vec3;

public class Rotation {
    public double x;
    public double y;
    public double z;

    public float yaw;
    public float pitch;

    public Rotation(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Vec3 toVector() {
        return new Vec3(x, y, z);
    }

    public static Rotation fromVector(Vec3 vec) {
        double x = vec.x;
        double y = vec.y;
        double z = vec.z;

        return new Rotation(x, y, z, 0, 0);
    }

    public void normalize() {
        yaw = wrapDegrees(yaw);
        pitch = Math.max(-90, Math.min(90, pitch));
    }

    private static float wrapDegrees(float angle) {
        angle %= 360.0F;
        if (angle >= 180.0F) angle -= 360.0F;
        if (angle < -180.0F) angle += 360.0F;
        return angle;
    }
}