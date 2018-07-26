package com.baidu.carlife;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.p052m.C1917b;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapObj;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.event.CancelCompassEvent;
import com.baidu.platform.comapi.map.event.MapMoveEvent;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.BMEventBus$OnEvent;
import com.baidu.platform.comapi.util.C4835n;

public class MainActivity extends FragmentActivity implements OnClickListener, BMEventBus$OnEvent {
    /* renamed from: a */
    public static Activity f2403a = null;
    /* renamed from: b */
    public static FragmentManager f2404b = null;
    /* renamed from: c */
    public static MapObj f2405c = null;
    /* renamed from: g */
    private static final int f2406g = 1;
    /* renamed from: h */
    private static final int f2407h = 1;
    /* renamed from: i */
    private static final int f2408i = 3;
    /* renamed from: j */
    private static final int f2409j = 12;
    /* renamed from: k */
    private static final int f2410k = 17;
    /* renamed from: l */
    private static final double f2411l = 2.0d;
    /* renamed from: m */
    private static final double f2412m = 30000.0d;
    /* renamed from: d */
    private MapGLSurfaceView f2413d;
    /* renamed from: e */
    private MapController f2414e;
    /* renamed from: f */
    private MapViewConfig f2415f;
    /* renamed from: n */
    private int f2416n = Integer.MIN_VALUE;
    /* renamed from: o */
    private int f2417o = Integer.MIN_VALUE;
    /* renamed from: p */
    private int f2418p = Integer.MIN_VALUE;
    /* renamed from: q */
    private int f2419q = Integer.MIN_VALUE;
    /* renamed from: r */
    private LocData f2420r;
    /* renamed from: s */
    private PositionStatus f2421s;
    /* renamed from: t */
    private Handler f2422t;

    /* renamed from: com.baidu.carlife.MainActivity$1 */
    class C09451 extends C0944a {
        /* renamed from: b */
        final /* synthetic */ MainActivity f2400b;

        C09451(MainActivity this$0) {
            this.f2400b = this$0;
        }

        /* renamed from: d */
        protected void mo1360d(MapObj mapObj) {
        }

        /* renamed from: a */
        protected void mo1357a(MapObj mapObj) {
        }

        /* renamed from: b */
        protected void mo1358b(MapObj mapObj) {
        }

        /* renamed from: c */
        protected void mo1359c(MapObj mapObj) {
        }
    }

    /* renamed from: com.baidu.carlife.MainActivity$2 */
    class C09462 implements LocationChangeListener {
        /* renamed from: a */
        final /* synthetic */ MainActivity f2401a;

        C09462(MainActivity this$0) {
            this.f2401a = this$0;
        }

        public void onLocationChange(LocData locData) {
            if (LocationManager.getInstance().isLocationValid() && this.f2401a.f2413d != null) {
                MapStatus status = this.f2401a.f2413d.getMapStatus();
                status.centerPtX = (double) ((int) locData.longitude);
                status.centerPtY = (double) ((int) locData.latitude);
                this.f2401a.f2413d.animateTo(status, 0);
                this.f2401a.m3145a(locData, this.f2401a.f2415f.getPositionStatus());
                LocationManager.getInstance().removeLocationChangeLister(this);
            }
        }

        public CoordType onGetCoordType() {
            return CoordType.CoordType_BD09;
        }
    }

    /* renamed from: com.baidu.carlife.MainActivity$3 */
    static /* synthetic */ class C09473 {
        /* renamed from: a */
        static final /* synthetic */ int[] f2402a = new int[PositionStatus.values().length];

        static {
            try {
                f2402a[PositionStatus.FOLLOWING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2402a[PositionStatus.COMPASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2402a[PositionStatus.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0965R.layout.mainactivity_main);
        f2403a = this;
        f2404b = getSupportFragmentManager();
        this.f2415f = MapViewConfig.getInstance();
        this.f2422t = new Handler(Looper.getMainLooper());
        Button button1 = (Button) findViewById(C0965R.id.btn_test1);
        Button button2 = (Button) findViewById(C0965R.id.btn_test2);
        Button button3 = (Button) findViewById(C0965R.id.btn_test3);
        Button zoomout = (Button) findViewById(C0965R.id.btn_zoomout);
        ((Button) findViewById(C0965R.id.btn_zoomin)).setOnClickListener(this);
        zoomout.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        C1328h.m4758a(new NaviFragmentManager(this));
        FrameLayout container = (FrameLayout) findViewById(C0965R.id.map_container);
        this.f2413d = MapViewFactory.getInstance().getMapView();
        this.f2414e = this.f2413d.getController();
        this.f2414e.setMapViewListener(new C09451(this));
        MapViewFactory.getInstance().relayoutMapView(container, 0);
        MapViewConfig.getInstance().setPositionStatus(PositionStatus.NORMAL);
        C1917b.m7339a();
        LocationManager.getInstance().init(DemoApp.m3126a());
        LocationManager.getInstance().onResume();
        NavMapAdapter.getInstance().initNaviEngine(this, null);
        LocationManager.getInstance().addLocationChangeLister(new C09462(this));
    }

    /* renamed from: a */
    public static void m3142a(Fragment fragment, Bundle bundle) {
        FragmentTransaction ft = f2404b.beginTransaction();
        if (!fragment.isAdded()) {
            fragment.setArguments(bundle);
            ft.replace(C0965R.id.fragment_container, fragment);
            ft.commitAllowingStateLoss();
        }
    }

    /* renamed from: a */
    public static void m3141a(Fragment fragment) {
        if (fragment.isAdded()) {
            FragmentTransaction ft = f2404b.beginTransaction();
            ft.remove(fragment);
            ft.commitAllowingStateLoss();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    protected void onResume() {
        super.onResume();
        MapViewFactory.getInstance().getMapView().onResume();
        MapViewFactory.getInstance().getMapView().onForeground();
        BMEventBus.getInstance().registSticky(this, CancelCompassEvent.class, MapMoveEvent.class);
    }

    protected void onPause() {
        super.onPause();
        MapViewFactory.getInstance().getMapView().onPause();
        MapViewFactory.getInstance().getMapView().onBackground();
        BMEventBus.getInstance().unregist(this);
    }

    /* renamed from: a */
    private void m3144a(PositionStatus lastStatus, boolean isFirstLocated) {
        float f = 18.0f;
        LocData locData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
        MapStatus st = this.f2413d.getMapStatus();
        if (st != null) {
            if (!isFirstLocated) {
                switch (C09473.f2402a[this.f2415f.getPositionStatus().ordinal()]) {
                    case 1:
                        st.centerPtX = (double) ((int) locData.longitude);
                        st.centerPtY = (double) ((int) locData.latitude);
                        if (lastStatus != PositionStatus.NORMAL) {
                            if (MapViewConfig.getInstance().getMapMode() != MapMode._3D) {
                                st.overlooking = 0;
                            }
                            st.rotation = 0;
                            break;
                        }
                        break;
                    case 2:
                        st.centerPtX = (double) ((int) locData.longitude);
                        st.centerPtY = (double) ((int) locData.latitude);
                        st.overlooking = -45;
                        if (locData.direction > 0.0f) {
                            st.rotation = (int) locData.direction;
                        } else if (this.f2416n != Integer.MIN_VALUE) {
                            st.rotation = this.f2416n;
                        }
                        if (locData.buildingId == null || locData.floorId == null) {
                            if (st.level >= 18.0f) {
                                f = st.level;
                            }
                            st.level = f;
                            break;
                        }
                    default:
                        break;
                }
            } else if (this.f2415f.getPositionStatus() == PositionStatus.FOLLOWING) {
                st.centerPtX = (double) ((int) locData.longitude);
                st.centerPtY = (double) ((int) locData.latitude);
                st.level = 17.0f;
                if (!(locData.floorId == null || locData.buildingId == null)) {
                    st.level = 20.0f;
                }
                if (lastStatus != PositionStatus.NORMAL) {
                    if (MapViewConfig.getInstance().getMapMode() != MapMode._3D) {
                        st.overlooking = 0;
                    }
                    st.rotation = 0;
                }
            }
            if (st.level < 12.0f) {
                st.level = 17.0f;
            }
            m3145a(locData, this.f2415f.getPositionStatus());
            PositionStatus positionStatus = this.f2415f.getPositionStatus();
            if (!isFirstLocated || !this.f2413d.getController().isMovedMap()) {
                if (positionStatus != PositionStatus.COMPASS && positionStatus != PositionStatus.FOLLOWING) {
                    return;
                }
                if (C4835n.a()) {
                    if (isFirstLocated) {
                        this.f2413d.setMapStatus(st);
                    } else {
                        this.f2413d.animateTo(st, 1000);
                    }
                } else if (isFirstLocated) {
                    this.f2413d.setMapStatus(st);
                } else {
                    this.f2413d.animateTo(st, 1000);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3145a(LocData locData, PositionStatus status) {
        if ((locData.latitude != -1.0d || locData.longitude != -1.0d) && this.f2415f.getPositionStatus() != PositionStatus.TRACKING) {
            float direction = locData.direction;
            if (m3149b(locData, status)) {
                String strData = locData.toLocationOverlayJsonString(status == PositionStatus.COMPASS);
                LocationOverlay locationOverlay = (LocationOverlay) this.f2413d.getOverlay(LocationOverlay.class);
                if (locationOverlay != null) {
                    locationOverlay.setData(strData);
                    locationOverlay.UpdateOverlay();
                }
                this.f2420r = locData;
                this.f2421s = status;
            }
        }
    }

    /* renamed from: b */
    private boolean m3149b(LocData locData, PositionStatus status) {
        return this.f2420r == null || Math.abs(this.f2420r.latitude - locData.latitude) >= 1.0d || Math.abs(this.f2420r.longitude - locData.longitude) >= 1.0d || Math.abs(this.f2420r.accuracy - locData.accuracy) >= 1.0f || Math.abs(this.f2420r.direction - locData.direction) >= 3.0f || this.f2421s == null || this.f2421s != status;
    }

    public void onClick(View v) {
        if (v.getId() == C0965R.id.btn_test1) {
            switch (C09473.f2402a[this.f2415f.getPositionStatus().ordinal()]) {
                case 1:
                    this.f2415f.setPositionStatus(PositionStatus.COMPASS);
                    m3144a(PositionStatus.FOLLOWING, false);
                    break;
                case 2:
                    this.f2415f.setPositionStatus(PositionStatus.FOLLOWING);
                    m3144a(PositionStatus.COMPASS, false);
                    break;
                case 3:
                    this.f2415f.setPositionStatus(PositionStatus.FOLLOWING);
                    m3144a(PositionStatus.NORMAL, false);
                    break;
            }
        }
        if (v.getId() == C0965R.id.btn_test2) {
            this.f2413d.setTraffic(false);
            if (f2405c != null) {
                Point point = new Point();
                point.setIntX(f2405c.geoPt.getIntX());
                point.setIntY(f2405c.geoPt.getIntY());
                m3146a(point, f2405c.strText, f2405c.strUid);
            }
        } else if (v.getId() == C0965R.id.btn_test3) {
            this.f2413d.setTraffic(true);
        } else if (v.getId() == C0965R.id.btn_zoomin) {
            m3140a();
            ((LocationOverlay) this.f2413d.getOverlay(LocationOverlay.class)).SetOverlayShow(false);
            BaiduNaviManager.getInstance().launchCruiser(this, Boolean.valueOf(true));
        } else if (v.getId() == C0965R.id.btn_zoomout) {
            m3148b();
            ((LocationOverlay) this.f2413d.getOverlay(LocationOverlay.class)).SetOverlayShow(true);
        }
    }

    /* renamed from: a */
    private void m3140a() {
        int level = (int) this.f2413d.getZoomLevel();
        if (level < m3150c()) {
            this.f2413d.setZoomLevel(level + 1);
        }
    }

    /* renamed from: b */
    private void m3148b() {
        int level = (int) this.f2413d.getZoomLevel();
        if (level > 4) {
            this.f2413d.setZoomLevel(level - 1);
        }
    }

    /* renamed from: c */
    private int m3150c() {
        return 21;
    }

    public void onEvent(Object o) {
        if (o instanceof CancelCompassEvent) {
            onEventMainThread((CancelCompassEvent) o);
        } else if (o instanceof MapMoveEvent) {
            onEventMainThread((MapMoveEvent) o);
        }
    }

    private void onEventMainThread(CancelCompassEvent event) {
        MapViewConfig.getInstance().setPositionStatus(PositionStatus.NORMAL);
        m3144a(PositionStatus.NORMAL, false);
    }

    private void onEventMainThread(MapMoveEvent event) {
        MapViewConfig.getInstance().setPositionStatus(PositionStatus.NORMAL);
        m3144a(PositionStatus.NORMAL, false);
    }

    /* renamed from: a */
    public static void m3146a(Point endPoint, String endStr, String endUid) {
        NavGeoPoint geoPoint;
        RouteNode startNode = NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), RoutePlanParams.MY_LOCATION, null);
        startNode.mFromType = 3;
        LocData curLocData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
        if (curLocData != null) {
            startNode.mGPSAccuracy = curLocData.accuracy;
            startNode.mGPSSpeed = curLocData.speed;
            startNode.mLocType = curLocData.type;
            startNode.mGPSAngle = curLocData.direction;
            startNode.mNetworkLocStr = curLocData.networkLocType;
            startNode.mAltitude = curLocData.altitude;
        }
        startNode.mFromType = 3;
        startNode.mCityID = 340;
        NavMapAdapter instance = NavMapAdapter.getInstance();
        if (endPoint != null) {
            geoPoint = NavMapAdapter.getInstance().getGeoPoint(endPoint, false);
        } else {
            geoPoint = null;
        }
        RouteNode endNode = instance.getRouteNode(geoPoint, endStr, endUid);
        if (endPoint != null) {
            endNode.mFromType = 1;
        } else {
            endNode.mFromType = 2;
        }
        BaiduNaviManager.getInstance().calcRouteToNaviRoute(startNode, endNode, null, 1, 15, 120, 1, 5, null);
    }
}
