package ru.gmp.capi.api;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;

public class CameraEntity extends AbstractClientPlayer {
    public CameraEntity(ClientLevel pClientLevel, GameProfile pGameProfile) {
        super(pClientLevel, pGameProfile);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public double getEyeY() {
        return this.getY();
    }

    @Override
    public void lerpTo(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean teleport) {
        this.setPos(x, y, z);
        this.setYRot(yaw);
        this.setXRot(pitch);
    }

    @Override
    public void setYRot(float yaw) {
        super.setYRot(yaw);
        this.yRotO = yaw;
    }

    @Override
    public void setXRot(float pitch) {
        super.setXRot(pitch);
        this.xRotO = pitch;
    }

    @Override
    public void setPos(double x, double y, double z) {
        super.setPos(x, y, z);
        this.xOld = x;
        this.yOld = y;
        this.zOld = z;
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public boolean isNoGravity() { return true; }

    @Override
    public boolean canChangeDimensions() { return false; }

    @Override
    public boolean isInvulnerable() { return true; }

    @Override
    public void aiStep() {}


    private ClientLevel getClientLevel() {
        return (ClientLevel) level();
    }

    public void spawn() {
        getClientLevel().putNonPlayerEntity(14, this);
    }

    public void despawn() {
        getClientLevel().removeEntity(getId(), RemovalReason.DISCARDED);
    }
}
