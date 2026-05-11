# CameraAPI | Forge 1.20.1

Mod-A.P.I. to easy camera control in Forge

# How to control?
Toggle camera-mod:
```java
import ru.gmp.capi.CameraAPI;

/* ... */
CameraAPI.toggleCamera();
/* ... */
```
Set camera position:
```java
import ru.gmp.capi.CameraAPI;
import ru.gmp.capi.api.CameraPosition;

CameraAPI.setCameraPos(new CameraPosition(x, y, z, yaw, pitch));
```


