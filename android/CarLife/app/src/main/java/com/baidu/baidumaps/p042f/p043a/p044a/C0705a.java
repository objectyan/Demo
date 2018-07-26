package com.baidu.baidumaps.p042f.p043a.p044a;

import android.os.Bundle;
import com.baidu.baidumaps.p042f.p043a.p045b.C0706a;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import java.util.HashMap;

/* compiled from: CarResultModeManager */
/* renamed from: com.baidu.baidumaps.f.a.a.a */
public class C0705a {
    /* renamed from: a */
    public static final String f2270a = "cache_common_navi_page";
    /* renamed from: b */
    private static C0705a f2271b = null;
    /* renamed from: c */
    private static final String f2272c = C0705a.class.getSimpleName();
    /* renamed from: d */
    private int f2273d = -99;
    /* renamed from: e */
    private int f2274e = -99;
    /* renamed from: f */
    private boolean f2275f = true;
    /* renamed from: g */
    private HashMap<String, C0704a> f2276g = new HashMap();

    /* compiled from: CarResultModeManager */
    /* renamed from: com.baidu.baidumaps.f.a.a.a$a */
    public static class C0704a {
        /* renamed from: a */
        public int f2267a = -99;
        /* renamed from: b */
        public int f2268b = -99;
        /* renamed from: c */
        public boolean f2269c = true;
    }

    /* renamed from: a */
    public static C0705a m2962a() {
        if (f2271b == null) {
            f2271b = new C0705a();
        }
        return f2271b;
    }

    /* renamed from: b */
    public static void m2963b() {
        if (f2271b != null) {
            f2271b.m2985g();
        }
    }

    private C0705a() {
    }

    /* renamed from: c */
    public int m2975c() {
        MapGLSurfaceView mMapView = MapViewFactory.getInstance().getMapView();
        if (mMapView != null) {
            return mMapView.getController().getMapTheme();
        }
        return 1;
    }

    /* renamed from: a */
    public void m2966a(int theme) {
        LogUtil.e(f2272c, "setMapTheme.theme=" + theme);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().setMapTheme(theme, new Bundle());
        }
    }

    /* renamed from: b */
    public void m2972b(int theme) {
        LogUtil.e(f2272c, "setMapThemeByJNI.theme=" + theme);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().setMapTheme(theme, new Bundle());
        }
    }

    /* renamed from: c */
    public void m2976c(int scene) {
        LogUtil.e(f2272c, "setMapScene.scene=" + scene);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().setMapScene(scene);
        }
    }

    /* renamed from: d */
    public void m2980d(int scene) {
        LogUtil.e(f2272c, "setMapSceneByJNI.scene=" + scene);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().setMapScene(scene);
        }
    }

    /* renamed from: e */
    public void m2982e(int scene) {
        LogUtil.e(f2272c, "setMapSceneForce.scene=" + scene);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().forceSetMapScene(scene);
        }
    }

    /* renamed from: a */
    public void m2967a(int theme, int scene) {
        LogUtil.e(f2272c, "setMapThemeScene.theme=" + theme + ", scene=" + scene);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().setMapThemeScene(theme, scene, new Bundle());
        }
    }

    /* renamed from: b */
    public void m2973b(int theme, int scene) {
        LogUtil.e(f2272c, "setMapThemeSceneByJNI.theme=" + theme + ", scene=" + scene + ", self=" + true);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().setMapThemeScene(theme, scene, new Bundle());
        }
    }

    /* renamed from: c */
    public void m2977c(int theme, int scene) {
        LogUtil.e(f2272c, "setMapThemeSceneForce.theme=" + theme + ", scene=" + scene);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().forceSetMapThemeScene(theme, scene, new Bundle());
        }
    }

    /* renamed from: h */
    private boolean m2965h() {
        if (this.f2273d < 0 || this.f2273d == 9 || this.f2274e < 0 || this.f2274e == 2) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public void m2979d() {
        if (!m2965h()) {
            MapGLSurfaceView mMapView = MapViewFactory.getInstance().getMapView();
            if (mMapView != null) {
                this.f2273d = mMapView.getController().getMapTheme();
                this.f2274e = 0;
                this.f2275f = mMapView.getController().isOverlookGestureEnable();
                if (this.f2273d == 9) {
                    this.f2273d = 1;
                }
                if (this.f2274e == 2 || m2984f(this.f2274e)) {
                    this.f2274e = 0;
                    return;
                }
                return;
            }
            this.f2274e = -99;
            this.f2275f = true;
        }
    }

    /* renamed from: e */
    public void m2981e() {
    }

    /* renamed from: b */
    private void m2964b(boolean noCareBySelf) {
        int i = 10;
        NavLogUtils.m3003e(f2272c, "restoreMapMode() noCareBySelf=" + noCareBySelf);
        PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
        MapGLSurfaceView mMapView = MapViewFactory.getInstance().getMapView();
        int tmpScene;
        if (this.f2273d < 0 || this.f2274e < 0) {
            if (!BNStyleManager.getRealDayStyle()) {
                i = 11;
            }
            this.f2273d = i;
            if (BNStyleManager.getRealDayStyle()) {
                tmpScene = 0;
            } else {
                tmpScene = 9;
            }
            m2967a(this.f2273d, tmpScene);
            if (mMapView != null) {
                mMapView.getController().setOverlookGestureEnable(this.f2275f);
            }
        } else if (mMapView != null) {
            int i2;
            tmpScene = this.f2274e;
            if (this.f2274e == 0 || this.f2274e == 5) {
                if (MapViewFactory.getInstance().getMapView().isTraffic()) {
                    tmpScene = 5;
                } else {
                    tmpScene = 0;
                }
            }
            if (BNStyleManager.getRealDayStyle()) {
                i2 = 10;
            } else {
                i2 = 11;
            }
            this.f2273d = i2;
            if (BNStyleManager.getRealDayStyle()) {
                tmpScene = 0;
            } else {
                tmpScene = 9;
            }
            m2967a(this.f2273d, tmpScene);
            mMapView.getController().setOverlookGestureEnable(this.f2275f);
            NavLogUtils.m3003e(f2272c, "restoreMapMode() theme=" + this.f2273d + ", scene=" + tmpScene + ", over=" + this.f2275f);
        }
        PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
    }

    /* renamed from: a */
    public void m2968a(BNMapObserver bnMapObserver) {
        if (C0706a.m2986a().m2993e()) {
            NavMapManager.getInstance().deleteMapObserver(bnMapObserver);
        } else {
            NavMapManager.getInstance().addMapObserver(bnMapObserver);
        }
    }

    /* renamed from: a */
    public boolean m2971a(boolean bPreRoutePlanStatus) {
        BNMapController.getInstance().showCarResultLayer(bPreRoutePlanStatus);
        return BNMapController.getInstance().setPreRoutePlanStatus(bPreRoutePlanStatus);
    }

    /* renamed from: a */
    public void m2970a(boolean force, BNMapObserver bnMapObserver) {
        int i = 1;
        NavLogUtils.m3003e(f2272c, "changeMode() isnaving" + BNavigator.getInstance().isNaviBegin());
        if (!BNavigator.getInstance().isNaviBegin()) {
            MapGLSurfaceView mMapView = MapViewFactory.getInstance().getMapView();
            if (C0706a.m2986a().m2993e()) {
                NavMapManager.getInstance().removeNaviMapListener();
                NavMapManager.getInstance().handleRoadCondition(0);
                NavMapManager.getInstance().setNaviMapMode(0);
                NavMapManager.getInstance().handleMapOverlays(0);
                NavMapManager.getInstance().deleteMapObserver(bnMapObserver);
                C0705a.m2962a().m2964b(true);
                if (mMapView != null) {
                    PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
                    m2973b(this.f2273d >= 0 ? this.f2273d : 1, 2);
                    PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
                }
            } else {
                if (mMapView != null) {
                    PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
                    PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
                }
                NavMapManager.getInstance().addNaviMapListener();
                NavMapManager.getInstance().initNaviSO();
                NavMapManager.getInstance().handleMapOverlays(5);
                NavMapManager.getInstance().setNaviMapMode(5);
                NavMapManager.getInstance().handleRoadCondition(5);
                NavMapManager.getInstance().addMapObserver(bnMapObserver);
                BNRouteGuider.getInstance().setBrowseStatus(true);
            }
            if (mMapView != null) {
                mMapView.getController().setOverlookGestureEnable(false);
                MapStatus mapStatus = mMapView.getMapStatus();
                if (mapStatus != null) {
                    mapStatus.overlooking = 0;
                    mapStatus.rotation = 0;
                    mMapView.setMapStatus(mapStatus);
                }
            }
            if (LogUtil.LOGGABLE) {
                String str = f2272c;
                StringBuilder append = new StringBuilder().append("changeMode() theme=");
                if (this.f2273d >= 0) {
                    i = this.f2273d;
                }
                NavLogUtils.m3003e(str, append.append(i).append(", scene=").append(2).append(", over=").append(this.f2275f).toString());
                LogUtil.printCallStatck();
            }
        }
    }

    /* renamed from: f */
    public void m2983f() {
        int i = 1;
        MapGLSurfaceView mMapView = MapViewFactory.getInstance().getMapView();
        if (C0706a.m2986a().m2993e()) {
            NavMapManager.getInstance().setNaviMapMode(0);
            if (mMapView != null) {
                int i2;
                if (this.f2273d >= 0) {
                    i2 = this.f2273d;
                } else {
                    i2 = 1;
                }
                m2973b(i2, 2);
            }
        } else {
            if (mMapView != null) {
                m2973b(this.f2273d >= 0 ? this.f2273d : 1, 2);
            }
            NavMapManager.getInstance().setNaviMapMode(5);
        }
        String str = f2272c;
        StringBuilder append = new StringBuilder().append("justChangeThemeScene() theme=");
        if (this.f2273d >= 0) {
            i = this.f2273d;
        }
        NavLogUtils.m3003e(str, append.append(i).append(", scene=").append(2).append(", over=").append(this.f2275f).toString());
    }

    /* renamed from: g */
    public void m2985g() {
        this.f2273d = -99;
        this.f2274e = -99;
        this.f2275f = true;
        this.f2276g.clear();
    }

    /* renamed from: a */
    public void m2969a(String cacheKey) {
        if (cacheKey != null && cacheKey.length() != 0) {
            C0704a cacheMode = new C0704a();
            MapGLSurfaceView mMapView = MapViewFactory.getInstance().getMapView();
            if (mMapView != null) {
                cacheMode.f2267a = mMapView.getController().getMapTheme();
                cacheMode.f2268b = 0;
                cacheMode.f2269c = mMapView.getController().isOverlookGestureEnable();
                if (cacheMode.f2267a == 9) {
                    cacheMode.f2267a = 1;
                }
                if (cacheMode.f2268b == 2 || m2984f(cacheMode.f2268b)) {
                    cacheMode.f2268b = 0;
                }
            } else {
                cacheMode.f2268b = -99;
                cacheMode.f2269c = true;
            }
            NavLogUtils.m3003e(f2272c, "cacheMapMode: --> cacheKey: " + cacheKey + ", theme: " + cacheMode.f2267a + ", scene: " + cacheMode.f2268b);
            this.f2276g.put(cacheKey, cacheMode);
        }
    }

    /* renamed from: b */
    public void m2974b(String cacheKey) {
        int i = 10;
        if (cacheKey != null && cacheKey.length() != 0 && this.f2276g.containsKey(cacheKey)) {
            C0704a cacheMode = (C0704a) this.f2276g.get(cacheKey);
            if (cacheMode != null) {
                PerformStatisticsController.peByType(0, "map_setmpamode_start", System.currentTimeMillis());
                MapGLSurfaceView mMapView = MapViewFactory.getInstance().getMapView();
                int i2;
                if (cacheMode.f2267a < 0 || cacheMode.f2268b < 0) {
                    if (!BNStyleManager.getRealDayStyle()) {
                        i = 11;
                    }
                    this.f2273d = i;
                    if (BNStyleManager.getRealDayStyle()) {
                        i2 = 0;
                    } else {
                        i2 = 9;
                    }
                    mMapView.getController().setOverlookGestureEnable(cacheMode.f2269c);
                } else if (mMapView != null) {
                    int i3;
                    i2 = cacheMode.f2268b;
                    if (cacheMode.f2268b == 0 || cacheMode.f2268b == 5) {
                        if (MapViewFactory.getInstance().getMapView().isTraffic()) {
                            i2 = 5;
                        } else {
                            i2 = 0;
                        }
                    }
                    if (BNStyleManager.getRealDayStyle()) {
                        i3 = 10;
                    } else {
                        i3 = 11;
                    }
                    this.f2273d = i3;
                    if (BNStyleManager.getRealDayStyle()) {
                        i2 = 0;
                    } else {
                        i2 = 9;
                    }
                    NavLogUtils.m3003e(f2272c, "restoreMapMode: all --> cacheKey: " + cacheKey + ", theme: " + cacheMode.f2267a + ", scene: " + i2);
                    mMapView.getController().setOverlookGestureEnable(cacheMode.f2269c);
                }
                this.f2276g.remove(cacheKey);
            }
        }
    }

    /* renamed from: c */
    public boolean m2978c(String cacheKey) {
        if (cacheKey == null || cacheKey.length() == 0 || !this.f2276g.containsKey(cacheKey)) {
            NavLogUtils.m3003e(f2272c, "keyHasCached: false --> key: " + cacheKey);
            return false;
        }
        NavLogUtils.m3003e(f2272c, "keyHasCached: true --> key: " + cacheKey);
        return true;
    }

    /* renamed from: f */
    public boolean m2984f(int sceneId) {
        if (sceneId < 8 || sceneId > 19) {
            return false;
        }
        return true;
    }
}
