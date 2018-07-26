package com.baidu.mapframework.common.mapview;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.carlife.C0965R;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.platform.basic.BMExecutorsManager;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.map.CompassOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapController$MapFirstFrameCallback;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.C4835n;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MapViewFactory implements MapController$MapFirstFrameCallback {
    /* renamed from: b */
    private static MapGLSurfaceView f12675b = null;
    /* renamed from: f */
    private static final double f12676f = 0.5d;
    /* renamed from: a */
    private volatile boolean f12677a;
    /* renamed from: c */
    private MapGLSurfaceView f12678c;
    /* renamed from: d */
    private MapController f12679d;
    /* renamed from: e */
    private volatile boolean f12680e;
    /* renamed from: g */
    private Stack<ViewGroup> f12681g;
    /* renamed from: h */
    private Future f12682h;
    /* renamed from: i */
    private LooperTask f12683i;

    public static MapViewFactory getInstance() {
        return MapViewFactory$Holder.f18786a;
    }

    private MapViewFactory() {
        this.f12677a = false;
        this.f12680e = false;
        this.f12681g = new Stack();
        this.f12682h = null;
        this.f12683i = new MapViewFactory$1(this);
    }

    public synchronized void preCreateMapViewInstance() {
        if (f12675b == null) {
            C2911f.m11023e("MapView", "Create MapGLSurfaceView 1");
            f12675b = new MapGLSurfaceView(C2907c.m10977f());
        }
    }

    public synchronized MapGLSurfaceView getMapView() {
        startDataEngineThread();
        if (this.f12682h != null) {
            try {
                this.f12682h.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            }
        }
        if (f12675b == null) {
            if (C4835n.a()) {
                C2911f.m11023e("MapView", "Create MapGLSurfaceView 2");
                f12675b = new MapGLSurfaceView(C2907c.m10977f());
            } else {
                throw new RuntimeException("Create MapView in no-main Thread!!");
            }
        }
        f12675b.setMapController(this.f12679d);
        LooperManager.executeTask(Module.BASE_MAPVIEW_MODULE, this.f12683i, ScheduleConfig.forSetupData());
        return f12675b;
    }

    public MapGLSurfaceView getCachedMapView() {
        return f12675b;
    }

    @Keep
    public MapGLSurfaceView getDuplicateMapView() {
        if (this.f12678c == null && f12675b != null) {
            this.f12678c = new MapGLSurfaceView(C2907c.m10977f());
            MapController controller = new MapController();
            controller.createByDuplicateAppBaseMap(this.f12679d.getMapId());
            m10932a(controller);
            this.f12678c.setMapController(controller);
            this.f12678c.onResume();
            this.f12678c.onForeground();
        }
        return this.f12678c;
    }

    public boolean isHaveDuplicateMapView() {
        return this.f12678c != null;
    }

    public void relayoutMapView(ViewGroup parent, LayoutParams layoutParams, int flag) {
        if (flag == 0) {
            if (m10936a(parent, layoutParams)) {
                this.f12681g.push(parent);
            }
        } else if (flag == 1 && m10935a(parent)) {
            this.f12681g.pop();
            if (!this.f12681g.isEmpty()) {
                ((ViewGroup) this.f12681g.peek()).addView(f12675b, 0, new LayoutParams(-1, -1));
            }
        }
    }

    public void relayoutMapView(ViewGroup parent, int flag) {
        if (flag == 0) {
            if (m10936a(parent, null)) {
                this.f12681g.push(parent);
            }
        } else if (flag == 1 && m10935a(parent)) {
            this.f12681g.remove(parent);
            if (!this.f12681g.isEmpty()) {
                ((ViewGroup) this.f12681g.peek()).addView(f12675b, 0, new LayoutParams(-1, -1));
            }
        }
    }

    /* renamed from: a */
    private boolean m10936a(ViewGroup parent, LayoutParams layoutParams) {
        if (f12675b == null || parent == null) {
            return false;
        }
        ViewGroup lastParent = (ViewGroup) f12675b.getParent();
        if (lastParent != null) {
            if (lastParent.equals(parent)) {
                return false;
            }
            lastParent.removeView(f12675b);
            this.f12681g.remove(lastParent);
        }
        if (layoutParams != null) {
            parent.addView(f12675b, 0, layoutParams);
        } else {
            parent.addView(f12675b, 0, new LayoutParams(-1, -1));
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10935a(ViewGroup oldParent) {
        if (f12675b == null) {
            return false;
        }
        ViewGroup parent = (ViewGroup) f12675b.getParent();
        if (parent == null || !parent.equals(oldParent)) {
            return false;
        }
        parent.removeView(f12675b);
        return true;
    }

    /* renamed from: a */
    private void m10934a(MapGLSurfaceView mapView, int x, int y) {
        try {
            JSONObject dataObj = new JSONObject();
            JSONArray dataSet = new JSONArray();
            JSONObject internalVal = new JSONObject();
            internalVal.put("x", x);
            internalVal.put("y", y);
            internalVal.put("hidetime", 1000);
            dataSet.put(internalVal);
            dataObj.put("dataset", dataSet);
            CompassOverlay compassOverlay = (CompassOverlay) mapView.getOverlay(CompassOverlay.class);
            if (compassOverlay != null) {
                compassOverlay.setData(dataObj.toString());
                compassOverlay.UpdateOverlay();
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private void m10933a(MapGLSurfaceView mapView) {
        Resources resources = C2907c.m10977f().getResources();
        ConcurrentManager.executeTask(Module.BASE_MAPVIEW_MODULE, new MapViewFactory$2(this, mapView, (int) (((double) resources.getDimension(C0965R.dimen.default_compass_x)) + f12676f), (int) (((double) resources.getDimension(C0965R.dimen.default_compass_y)) + f12676f)), ScheduleConfig.forData());
    }

    /* renamed from: b */
    private void m10940b() {
        if (!this.f12680e) {
            if (this.f12679d == null) {
                this.f12679d = new MapController();
                this.f12679d.initBaseMap();
                m10932a(this.f12679d);
                this.f12679d.setMapFirstFrameCallback(this);
            }
            this.f12680e = true;
        }
    }

    /* renamed from: a */
    private void m10932a(MapController controller) {
        if (!C2907c.m10973b()) {
            synchronized (C2907c.class) {
            }
        }
        Bundle b = new Bundle();
        MapViewConfig config = MapViewConfig.getInstance();
        b.putDouble("level", (double) config.getLevel());
        b.putDouble("centerptx", (double) config.getCenterPtX());
        b.putDouble("centerpty", (double) config.getCenterPtY());
        b.putDouble("centerptz", (double) config.getCenterPtZ());
        b.putInt("left", 0);
        b.putInt("top", 0);
        int height = SysOSAPIv2.getInstance().getScreenHeight();
        b.putInt("right", SysOSAPIv2.getInstance().getScreenWidth());
        b.putInt("bottom", height);
        b.putString("modulePath", SysOSAPIv2.getInstance().getOutputDirPath());
        b.putString("appSdcardPath", StorageSettings.getInstance().getCurrentStorage().getDataPath());
        b.putString("appCachePath", StorageSettings.getInstance().getCurrentStorage().getPrimaryCachePath());
        b.putString("appSecondCachePath", StorageSettings.getInstance().getCurrentStorage().getSecondaryCachePath());
        b.putInt("mapTmpMax", StorageSettings.getInstance().getMapTmpStgMax());
        b.putInt("domTmpMax", StorageSettings.getInstance().getDomTmpStgMax());
        b.putInt("itsTmpMax", StorageSettings.getInstance().getItsTmpStgMax());
        b.putInt("ssgTmpMax", StorageSettings.getInstance().getSsgTmpStgMax());
        controller.initMapResources(b);
    }

    public void initDelayed() {
        waitforMapViewInit();
        LooperManager.executeTask(Module.BASE_MAPVIEW_MODULE, this.f12683i, ScheduleConfig.forSetupData());
    }

    public void waitforMapViewInit() {
        startDataEngineThread();
        if (this.f12682h != null) {
            try {
                this.f12682h.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            }
        }
        f12675b.setMapController(this.f12679d);
    }

    public void onFirstFrameDrawing(MapController mapController) {
        BNMapController.getInstance().resizeScreen(f12675b.getWidth(), f12675b.getHeight());
    }

    public synchronized void startDataEngineThread() {
        if (this.f12682h == null) {
            C2911f.m11023e("MapView", "startDataEngineThread");
            this.f12682h = BMExecutorsManager.APP_COMMON_EXECUTOR_SERVICE.submit(new MapViewFactory$3(this));
        }
    }

    public void saveMapStatus() {
        MapViewConfig config = MapViewConfig.getInstance();
        if (config != null && f12675b != null) {
            config.saveMapStatus(f12675b.getMapStatus());
        }
    }

    public void saveMapCache() {
        if (f12675b != null) {
            MapController mapController = f12675b.getController();
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap != null) {
                    baseMap.SaveCache();
                }
            }
        }
    }

    public void destroy() {
        this.f12677a = false;
        destroyDuplicateMapView();
        if (f12675b != null) {
            MapController mapController = f12675b.getController();
            if (this.f12683i != null) {
                this.f12683i.cancel();
            }
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap != null) {
                    baseMap.CloseCache();
                }
                mapController.unInit();
                f12675b = null;
            }
        }
    }

    public void destroyDuplicateMapView() {
        if (this.f12678c != null) {
            MapController mapController = this.f12678c.getController();
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap != null) {
                    baseMap.Release();
                }
                this.f12678c = null;
            }
        }
    }
}
