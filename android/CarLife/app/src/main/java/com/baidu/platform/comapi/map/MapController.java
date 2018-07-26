package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.carlife.core.C1253f;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.platform.comapi.map.event.CancelCompassEvent;
import com.baidu.platform.comapi.map.event.MapMoveEvent;
import com.baidu.platform.comapi.map.event.MapOnTouchMoveEvent;
import com.baidu.platform.comapi.map.event.MapZoomEvent;
import com.baidu.platform.comapi.map.gesture.GestureController;
import com.baidu.platform.comapi.map.gesture.GestureMonitor;
import com.baidu.platform.comapi.p209e.C4770a;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.C4820d;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comapi.util.p211b.C4798b;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapController implements MapListenerInterface {
    public static final String CITY_AREA_TAG = "cityarea";
    public static final String COMPASS_LAYER_TAG = "compass";
    private static final int DB_CLICK_NON_CONFLICT = 300;
    private static final int DB_CLICK_ZOOM = 150;
    public static final String DEFAULT_LAYER_TAG = "default";
    public static final String DYNAMIC_MAP_LAYER_TAG = "dynamicmap";
    private static final int ENTER_INDOOR = 1;
    private static final int EXIT_INDOOR = 0;
    private static final int FLING_SPEED_MIN = 300;
    public static final String HEATMAP_LAYER_TAG = "heatmap";
    public static final String ITEM_LAYER_TAG = "item";
    public static final String ITSROUTE_LAYER_TAG = "itsroute";
    private static final int LEVEL_CITY = 0;
    private static final int LEVEL_STREET = 1;
    public static final String LOCATION_LAYER_TAG = "location";
    private static final double MAP_LEVEL_MAX = 22.0d;
    public static final int MSG_LONGLINK_CONNECT = 1;
    public static final int MSG_LONGLINK_DISCONNECT = 2;
    public static final String POISON_LAYER_TAG = "poison";
    public static final String POI_CHILD_POI_LAYER = "poimarkext";
    public static final String POPUP_LAYER_TAG = "popup";
    public static final String RTPOPUP_LAYER_TAG = "rtpopup";
    public static final String RT_POPUP_LAYER_TAG = "rtpopup";
    public static final String SHARELOCATION_BUBBLE = "smshare";
    public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
    public static final String STREETROUTE_LAYER_TAG = "streetroute";
    private static final String TAG = MapController.class.getSimpleName();
    public static final String TRACK_REGION_TAG = "extend";
    private static final boolean USER_LOG = true;
    private static float clickPointX;
    private static float clickPointY;
    private static boolean enableMove = true;
    public static boolean isCompass = false;
    private static boolean lastClickDown;
    private static long mDoubleClickTime = 0;
    private static MainLooperHandler mHandler = null;
    public static boolean mLocIconOnScreen = true;
    public static boolean m_registered_SENSOR_ORIENTATION;
    private boolean bFling = false;
    private boolean bMapclick = false;
    private long dmClickTime;
    private float dmLastLength = 0.0f;
    private float dmLastX = -1.0f;
    private float dmLastY = -1.0f;
    private GestureController gestureController = new GestureController(this);
    private GestureMonitor gestureMonitor;
    private boolean isMovedMap = false;
    private int mAddrBaseMap = 0;
    private boolean mBaseMapInited = false;
    private boolean mBaseMapReInited = false;
    private AppBaseMap mBasemap = null;
    CaptureMapListener mCapMapListener = null;
    EngineMsgListener mEngineMsgListener = null;
    HideIndoorPopupListener mHidePopupListener = null;
    private boolean mIs3DSet = false;
    private boolean mIsActingDDZoom = false;
    private boolean mIsEnableDDZoom = true;
    private boolean mIsEnableDMoveZoom = false;
    private boolean mIsOverlookSet = true;
    MapRenderModeChangeListener mMapRenderModeChangeListener = null;
    SoftReference<MapViewInterface> mMapView;
    MapViewListener mMapViewListener = null;
    StreetArrowClickListener mStreetArrowClickListener = null;
    private MapControlMode mapControlMode = MapControlMode.DEFAULT;
    private MapController$MapFirstFrameCallback mapFirstFrameCallback;
    private boolean moveLog = true;
    NaviMapViewListener naviMapViewListener;
    private int nearlyRadius = 20;
    int netStatus = 0;
    private int screenHeight = SysOSAPIv2.getInstance().getScreenHeight();
    private int screenWidth = SysOSAPIv2.getInstance().getScreenWidth();
    private int styleMode = 1;
    private int theme = 1;
    private boolean travelMode = false;

    public enum HeatMapType {
        CITY(0),
        SCENERY(1),
        CEMETERY(2);
        
        private final int id;

        private HeatMapType(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
    }

    class MapControlHandler extends MainLooperHandler {
        MapControlHandler() {
            super(Module.MAP_ENGINE, ScheduleConfig.forData());
        }

        public void onMessage(Message msg) {
            if (msg.what == m_AppUI.MSG_APP_SAVESCREEN && MapController.this.mCapMapListener != null) {
                MapController.this.mCapMapListener.onGetCaptureMap(msg.arg2 == 1);
            }
            if (msg.what == 519 && MapController.this.mHidePopupListener != null) {
                MapController.this.mHidePopupListener.onHideIndoorPopup();
            }
            if (msg.what == 39) {
                if (((Integer) msg.obj).intValue() == MapController.this.mAddrBaseMap) {
                    switch (msg.arg1) {
                        case 100:
                            if (MapController.this.mIsActingDDZoom) {
                                if (MapController.this.mMapView != null && MapController.this.mMapView.get() != null) {
                                    LooperManager.executeTask(Module.MAP_ENGINE, new LooperTask(30) {
                                        public void run() {
                                            GeoPoint geoPoint = ((MapViewInterface) MapController.this.mMapView.get()).getProjection().fromPixels(MapController.this.getScreenWidth() / 2, MapController.this.getScreenHeight() / 2);
                                            if (geoPoint != null) {
                                                MapController.CleanAfterDBClick(MapController.this.mAddrBaseMap, (float) geoPoint.getLongitudeE6(), (float) geoPoint.getLatitudeE6());
                                            }
                                            MapController.this.mIsActingDDZoom = false;
                                        }
                                    }, ScheduleConfig.forData());
                                } else {
                                    return;
                                }
                            }
                            MapController.this.bFling = false;
                            if (MapController.this.getMapViewListener() != null) {
                                MapController.this.getMapViewListener().onMapAnimationFinish();
                            }
                            if (MapController.this.isNaviMode() && MapController.this.naviMapViewListener != null) {
                                MapController.this.naviMapViewListener.onMapAnimationFinish();
                                break;
                            }
                            break;
                        case 300:
                            if (MapController.this.mapFirstFrameCallback != null) {
                                MapController.this.mapFirstFrameCallback.onFirstFrameDrawing(MapController.this);
                                break;
                            }
                            break;
                        default:
                            if (MapController.this.mMapRenderModeChangeListener != null) {
                                MapController.this.mMapRenderModeChangeListener.onMapRenderModeChange(msg.arg1);
                            }
                            if (MapController.this.isNaviMode() && MapController.this.naviMapViewListener != null) {
                                MapController.this.naviMapViewListener.onMapRenderModeChange(msg.arg1);
                                break;
                            }
                    }
                }
                return;
            }
            if (msg.what == 512) {
                int index = msg.arg1;
                if (MapController.this.getMapViewListener() != null) {
                    MapController.this.getMapViewListener().onClickedPopup(index);
                }
            }
            if (msg.what == 50 && MapController.this.mEngineMsgListener != null) {
                if (msg.arg1 == 1) {
                    MapController.this.mEngineMsgListener.onEnterIndoorMapMode(MapController.this.getFocusedBaseIndoorMapInfo());
                } else if (msg.arg1 == 0) {
                    MapController.this.mEngineMsgListener.onExitIndoorMapMode();
                }
            }
            if (msg.what == 51) {
                MapController.this.setNetStatus(msg.arg1);
            }
            if (msg.what == m_AppUI.V_WM_BMBAR && MapController.this.mEngineMsgListener != null) {
                if (msg.arg1 == 1) {
                    MapController.this.getMapBarData();
                } else if (msg.arg1 == 0) {
                    BMEventBus.getInstance().post(new BMBarHiddeEvent());
                }
            }
        }
    }

    public enum MapControlMode {
        DEFAULT(1),
        INDOOR(2),
        STREET(3),
        STREET_WAITING(4);
        
        private final int id;

        private MapControlMode(int id) {
            this.id = id;
        }
    }

    public enum MapLayerType {
        DEFAULT(1),
        SATELLITE(2),
        INDOOR(3),
        STREET(5);
        
        private final int id;

        private MapLayerType(int id) {
            this.id = id;
        }
    }

    public enum MapSceneMode {
        DEFAULT(0),
        POI(1),
        ROUTE(2),
        INTERNAL(3);
        
        private final int val;

        private MapSceneMode(int val) {
            this.val = val;
        }

        public int getMode() {
            return this.val;
        }
    }

    public enum MapStyleMode {
        DEFAULT(1),
        SEARCH_POI(2),
        SEARCH_ROUTE(3),
        NAV_DAY(4),
        NAV_NIGHT(5),
        WALK_DAY(6),
        INTERNAL(7),
        INTERNAL_SPECIAL(8),
        FOOT_PRINT(9);
        
        private final int val;

        private MapStyleMode(int val) {
            this.val = val;
        }

        public int getMode() {
            return this.val;
        }
    }

    public static native int CleanAfterDBClick(int i, float f, float f2);

    public static native int MapProc(int i, int i2, int i3, int i4, int i5, int i6, double d, double d2, double d3, double d4);

    public void setMapViewListener(MapViewListener mapListener) {
        this.mMapViewListener = mapListener;
    }

    public MapViewListener getMapViewListener() {
        return this.mMapViewListener;
    }

    public void setCaptureMapListener(CaptureMapListener capListener) {
        this.mCapMapListener = capListener;
    }

    public CaptureMapListener getCaptureMapListener() {
        return this.mCapMapListener;
    }

    public void setHideIndoorPopupListener(HideIndoorPopupListener hidePopupListener) {
        this.mHidePopupListener = hidePopupListener;
    }

    public HideIndoorPopupListener getHideIndoorPopupListener() {
        return this.mHidePopupListener;
    }

    public void setStreetArrowClickListener(StreetArrowClickListener streetArrowClickListener) {
        this.mStreetArrowClickListener = streetArrowClickListener;
    }

    public StreetArrowClickListener getStreetArrowClickListener() {
        return this.mStreetArrowClickListener;
    }

    public void setMapRenderModeChangeListener(MapRenderModeChangeListener renderModeChangeListener) {
        this.mMapRenderModeChangeListener = renderModeChangeListener;
    }

    public void setEngineMsgListener(EngineMsgListener engineMsgListener) {
        this.mEngineMsgListener = engineMsgListener;
    }

    public EngineMsgListener getIndoorMapListener() {
        return this.mEngineMsgListener;
    }

    public MapRenderModeChangeListener getMapRenderModeChangeListener() {
        return this.mMapRenderModeChangeListener;
    }

    public void setMapViewInterface(MapViewInterface mapview) {
        this.mMapView = new SoftReference(mapview);
    }

    public void setMapFirstFrameCallback(MapController$MapFirstFrameCallback mapFirstFrameCallback) {
        this.mapFirstFrameCallback = mapFirstFrameCallback;
    }

    public MapController() {
        mHandler = new MapControlHandler();
        registerMsgs();
    }

    public void initBaseMap() {
        this.mBasemap = new AppBaseMap();
        this.mBasemap.Create();
        this.mAddrBaseMap = this.mBasemap.GetId();
    }

    public int getMapId() {
        return this.mAddrBaseMap;
    }

    public boolean isMovedMap() {
        return this.isMovedMap;
    }

    public void saveScreenToLocal(String strPath, int startX, int startY, int width, int height) {
        if (checkAppBaseMap() && !TextUtils.isEmpty(strPath)) {
            String jsStrBound = null;
            if (!(width == 0 || height == 0)) {
                JSONObject boundParams = new JSONObject();
                try {
                    boundParams.put("x", startX);
                    boundParams.put("y", startY);
                    boundParams.put("width", width);
                    boundParams.put("height", height);
                    jsStrBound = boundParams.toString();
                } catch (Exception e) {
                    jsStrBound = null;
                }
            }
            this.mBasemap.SaveScreenToLocal(strPath, jsStrBound);
        }
    }

    public void saveScreenToLocal(String strPath) {
        saveScreenToLocal(strPath, 0, 0, 0, 0);
    }

    public AppBaseMap getBaseMap() {
        return this.mBasemap;
    }

    public void onResume() {
        if (checkAppBaseMap()) {
            this.mBasemap.OnResume();
        }
    }

    public void onPause() {
        if (checkAppBaseMap()) {
            this.mBasemap.OnPause();
        }
    }

    private boolean checkAppBaseMap() {
        return this.mBaseMapInited && this.mBasemap != null;
    }

    public boolean createByDuplicateAppBaseMap(int orgMapPtr) {
        this.mBasemap = new AppBaseMap();
        if (this.mBasemap.CreateByDuplicate(orgMapPtr)) {
            this.mAddrBaseMap = this.mBasemap.GetId();
            return true;
        }
        this.mBasemap = null;
        this.mAddrBaseMap = 0;
        return false;
    }

    public double getZoomUnitsInMeter() {
        AppBaseMap baseMap = getBaseMap();
        if (baseMap != null) {
            Bundle bundle = baseMap.GetMapStatus();
            if (bundle != null) {
                float adapterZoomUnits = bundle.getFloat("adapterZoomUnits");
                if (((double) adapterZoomUnits) > 1.0E-4d) {
                    return (double) adapterZoomUnits;
                }
            }
        }
        return Math.pow(2.0d, (double) (18.0f - getZoomLevel()));
    }

    void moveMapToScrPoint(int scrX, int scrY) {
        if (checkAppBaseMap()) {
            this.mBasemap.MoveToScrPoint(scrX, scrY);
        }
    }

    private boolean getClickedObject(int x, int y) {
        if (!checkAppBaseMap()) {
            return false;
        }
        if (getMapViewListener() == null && this.naviMapViewListener == null) {
            return false;
        }
        int radius = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());
        Point point = new Point((double) x, (double) y);
        Point tmpPt = null;
        if (isNaviMode() && this.naviMapViewListener != null) {
            tmpPt = this.naviMapViewListener.onTapInterception(point);
        }
        int tmpX = x;
        int tmpY = y;
        if (tmpPt != null) {
            tmpX = tmpPt.getIntX();
            tmpY = tmpPt.getIntY();
        }
        String strJson = this.mBasemap.GetNearlyObjID(-1, tmpX, tmpY, radius);
        if (strJson == null) {
            return false;
        }
        if (isNaviMode() && this.naviMapViewListener != null && this.naviMapViewListener.onItemClick(strJson, tmpX, tmpY)) {
            return true;
        }
        try {
            MapObj mapObj;
            JSONObject jSONObject = new JSONObject(strJson);
            List<MapObj> mapObjArray = new ArrayList();
            List<ItsMapObj> itsObjArray = null;
            List<MapObj> indoormapObjArray = null;
            List<MapObj> poiObjArray = null;
            List<MapObj> routeObjArray = null;
            List<MapObj> favorObjArray = null;
            List<MapObj> particleObjArray = null;
            if (jSONObject.has(MapObjKey.OBJ_MCAR)) {
                JSONObject jsonMcar = jSONObject.getJSONObject(MapObjKey.OBJ_MCAR);
                if (jsonMcar != null) {
                    routeObjArray = new ArrayList();
                    mapObj = new MapObj();
                    mapObj.routeType = MapObjKey.OBJ_MCAR;
                    if (jsonMcar.has("id")) {
                        mapObj.routeId = jsonMcar.getInt("id");
                    }
                    if (jsonMcar.has("status")) {
                        mapObj.status = jsonMcar.getInt("status");
                    }
                    if (jsonMcar.has("in")) {
                        mapObj.index = jsonMcar.getInt("in");
                    }
                    routeObjArray.add(mapObj);
                    getMapViewListener().onClickedRouteObj(routeObjArray);
                    return true;
                }
            }
            JSONArray jsonArray = jSONObject.getJSONArray("dataset");
            int type = ((JSONObject) jsonArray.get(0)).getInt("ty");
            if (type == 22) {
                itsObjArray = new ArrayList();
            } else if (type == 3 || type == 13 || type == 14 || type == 16 || type == 15 || type == 4 || type == 103 || type == 25 || type == 31 || type == 104 || type == 5000) {
                poiObjArray = new ArrayList();
            } else if (type == 8 || type == 1 || type == 2) {
                routeObjArray = new ArrayList();
            } else if (type == 6) {
                favorObjArray = new ArrayList();
            } else if (type == 24) {
                indoormapObjArray = new ArrayList();
            } else if (type == 1239) {
                routeObjArray = new ArrayList();
            } else if (type == 7000) {
                particleObjArray = new ArrayList();
            }
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonItem = (JSONObject) jsonArray.get(i);
                int itemType = jsonItem.getInt("ty");
                if (itemType != 26) {
                    mapObj = new MapObj();
                    if (jsonItem.has(MapObjKey.OBJ_LAYER_ID)) {
                        mapObj.layer_id = (int) jsonItem.getLong(MapObjKey.OBJ_LAYER_ID);
                    } else {
                        mapObj.layer_id = 0;
                    }
                    if (jsonItem.has("ud")) {
                        mapObj.strUid = jsonItem.getString("ud");
                    } else {
                        mapObj.strUid = "";
                    }
                    mapObj.strText = jsonItem.optString("tx");
                    if (jsonItem.has("in")) {
                        mapObj.nIndex = jsonItem.getInt("in");
                    } else if (jsonItem.has("index")) {
                        mapObj.nIndex = jsonItem.getInt("index");
                    } else {
                        mapObj.nIndex = 0;
                    }
                    if (jsonItem.has("geo")) {
                        Point p = CoordinateUtil.complexPtToPoint(jsonItem.getString("geo"));
                        mapObj.geoPt.setTo(p == null ? 0.0d : (double) p.getIntX(), p == null ? 0.0d : (double) p.getIntY());
                    } else if (jsonItem.has(MapObjKey.OBJ_SL_PTX) && jsonItem.has(MapObjKey.OBJ_SL_PTY)) {
                        mapObj.geoPt.setTo((double) ((int) jsonItem.getDouble(MapObjKey.OBJ_SL_PTX)), (double) ((int) jsonItem.getDouble(MapObjKey.OBJ_SL_PTY)));
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SL_TIME)) {
                        mapObj.sltime = jsonItem.getInt(MapObjKey.OBJ_SL_TIME);
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SL_OBJ)) {
                        mapObj.slobj = jsonItem.getInt(MapObjKey.OBJ_SL_OBJ);
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SL_VISI)) {
                        mapObj.slvisi = jsonItem.getInt(MapObjKey.OBJ_SL_VISI);
                    }
                    mapObj.nType = itemType;
                    if (jsonItem.has("of")) {
                        mapObj.offset = jsonItem.getInt("of");
                    }
                    if (jsonItem.has("poiname")) {
                        mapObj.ssName = jsonItem.getString("poiname");
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SS_INDOOR_ID)) {
                        mapObj.ssIndoorId = jsonItem.getString(MapObjKey.OBJ_SS_INDOOR_ID);
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SS_POIUID)) {
                        mapObj.ssPoiUid = jsonItem.getString(MapObjKey.OBJ_SS_POIUID);
                    }
                    if (jsonItem.has("dis")) {
                        mapObj.offset = jsonItem.getInt("dis");
                    }
                    if (jsonItem.has("x")) {
                        mapObj.geoPt.setIntX(jsonItem.getInt("x"));
                        mapObj.streetArrowCenterX = jsonItem.getDouble("x");
                    }
                    if (jsonItem.has("y")) {
                        mapObj.geoPt.setIntY(jsonItem.getInt("y"));
                        mapObj.streetArrowCenterY = jsonItem.getDouble("y");
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SS_ARROW_Z)) {
                        mapObj.ssZ = jsonItem.getInt(MapObjKey.OBJ_SS_ARROW_Z);
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                        mapObj.ssRotation = jsonItem.getDouble(MapObjKey.OBJ_SS_ARROW_ROTATION);
                    }
                    if (jsonItem.has("pid")) {
                        mapObj.ssPanoId = jsonItem.getString("pid");
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SS_DATA)) {
                        mapObj.ssData = jsonItem.getString(MapObjKey.OBJ_SS_DATA);
                    }
                    if (jsonItem.has(MapObjKey.OBJ_SRC)) {
                        mapObj.dynamicSrc = jsonItem.getInt(MapObjKey.OBJ_SRC);
                    } else {
                        mapObj.dynamicSrc = -1;
                    }
                    if (jsonItem.has(MapObjKey.OBJ_AD)) {
                        mapObj.ad = jsonItem.getInt(MapObjKey.OBJ_AD);
                    } else {
                        mapObj.ad = -1;
                    }
                    if (jsonItem.has(MapObjKey.OBJ_AD_STYLE)) {
                        mapObj.adstyle = jsonItem.getInt(MapObjKey.OBJ_AD_STYLE);
                    } else {
                        mapObj.adstyle = -1;
                    }
                    if (jsonItem.has("qid")) {
                        mapObj.qid = jsonItem.getString("qid");
                    } else {
                        mapObj.qid = "";
                    }
                    if (jsonItem.has(MapObjKey.OBJ_PUID)) {
                        mapObj.puid = jsonItem.getString(MapObjKey.OBJ_PUID);
                    } else {
                        mapObj.puid = "";
                    }
                    if (jsonItem.has(MapObjKey.OBJ_DY_SRC)) {
                        mapObj.dysrc = jsonItem.getInt(MapObjKey.OBJ_DY_SRC);
                    } else {
                        mapObj.dysrc = -1;
                    }
                    if (jsonItem.has(MapObjKey.OBJ_DY_STGE)) {
                        mapObj.dystge = jsonItem.getInt(MapObjKey.OBJ_DY_STGE);
                    } else {
                        mapObj.dystge = -1;
                    }
                    if (jsonItem.has(MapObjKey.AD_LOG)) {
                        mapObj.adLog = jsonItem.getString(MapObjKey.AD_LOG);
                    } else {
                        mapObj.adLog = "";
                    }
                    if (jsonItem.has("url")) {
                        mapObj.url = jsonItem.getString("url");
                    } else {
                        mapObj.url = "";
                    }
                    if (jsonItem.has(MapObjKey.OBJ_STYLE_ID)) {
                        mapObj.style_id = jsonItem.getInt(MapObjKey.OBJ_STYLE_ID);
                    } else {
                        mapObj.style_id = 0;
                    }
                    if (type == 22) {
                        ItsMapObj itsObj = new ItsMapObj();
                        itsObj.baseMapObj = mapObj;
                        itsObj.tTrafficStart = jsonItem.getLong(MapObjKey.OBJ_TRAFFIC_EVENT_START);
                        itsObj.tTrafficEnd = jsonItem.getLong(MapObjKey.OBJ_TRAFFIC_EVENT_END);
                        itsObj.strTrafficDetail = jsonItem.getString(MapObjKey.OBJ_TRAFFIC_EVENT_DETAIL);
                        itsObjArray.add(itsObj);
                    } else if (type == 3 || type == 13 || type == 14 || type == 16 || type == 15 || type == 4 || type == 103 || type == 25 || type == 31 || type == 104 || type == 5000) {
                        poiObjArray.add(mapObj);
                    } else if (type == 8 || type == 1 || type == 2) {
                        routeObjArray.add(mapObj);
                    } else if (type == 6) {
                        favorObjArray.add(mapObj);
                    } else if (type == 24) {
                        indoormapObjArray.add(mapObj);
                    } else if (type == 1234 || type == 1236 || type == 2000 || type == 2001) {
                        getMapViewListener().onClickedStreetIndoorPoi(mapObj);
                        break;
                    } else if (type == 1235) {
                        getMapViewListener().onClickStreetArrow(mapObj);
                        break;
                    } else if (type == 2002) {
                        getMapViewListener().onClickStreetSurface(mapObj);
                        break;
                    } else if (type == 1239) {
                        routeObjArray.add(mapObj);
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedRouteLabelObj(routeObjArray);
                        }
                    } else if (type == 6000) {
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedOPPoiEventMapObj(mapObj);
                        }
                    } else if (type == 7000) {
                        particleObjArray.add(mapObj);
                    } else if (type != 6002) {
                        mapObjArray.add(mapObj);
                    } else if (getMapViewListener() != null) {
                        getMapViewListener().onClickedTrafficUgcEventMapObj(mapObj, jsonItem.optBoolean("bchecked"));
                    }
                }
            }
            switch (type) {
                case 1:
                case 2:
                case 8:
                    getMapViewListener().onClickedRouteObj(routeObjArray);
                    break;
                case 3:
                case 4:
                case 13:
                case 14:
                case 15:
                case 16:
                case 25:
                case 31:
                case 103:
                case 104:
                case 5000:
                    if (getMapViewListener() != null) {
                        getMapViewListener().onClickedPoiObj(poiObjArray);
                        break;
                    }
                    break;
                case 6:
                    getMapViewListener().onClickedMapObj(favorObjArray);
                    break;
                case 17:
                case 18:
                case 19:
                    if (getMapViewListener() != null) {
                        getMapViewListener().onClickedMapObj(mapObjArray);
                        break;
                    }
                    break;
                case 20:
                    getMapViewListener().onClickedStreetPopup(strJson);
                    break;
                case 22:
                    getMapViewListener().onClickedItsMapObj(itsObjArray);
                    break;
                case 23:
                    getMapViewListener().onClickedMapObj(mapObjArray);
                    break;
                case NodeType.E_PARTICLE /*7000*/:
                    getMapViewListener().onClickedParticleEventMapObj(particleObjArray);
                    break;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public void animateTo(GeoPoint point, int span) {
        if (checkAppBaseMap()) {
            MapStatus st = getMapStatus();
            st.centerPtX = point.getLongitude();
            st.centerPtY = point.getLatitude();
            setMapStatusWithAnimation(st, span);
        }
    }

    public int MapMsgProc(int imessage, int lwparam, int lparam) {
        return MapMsgProc(imessage, lwparam, lparam, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public int MapMsgProc(int imessage, int lwparam, int lparam, int scale, int angle, double centerX, double centerY, double offsetX, double offsetY) {
        if (checkAppBaseMap()) {
            return MapProc(this.mAddrBaseMap, imessage, lwparam, lparam, scale, angle, centerX, centerY, offsetX, offsetY);
        }
        return -1;
    }

    public static int GetAdaptKeyCode(int keyCode) {
        switch (keyCode) {
            case 19:
                return 17;
            case 20:
                return 19;
            case 21:
                return 16;
            case 22:
                return 18;
            default:
                return 0;
        }
    }

    public boolean handleKeyEvent(int keyCode, KeyEvent event) {
        int wparam = GetAdaptKeyCode(keyCode);
        if (wparam == 0) {
            return false;
        }
        MapMsgProc(1, wparam, 0);
        return true;
    }

    public boolean handleTrackballEvent(MotionEvent event) {
        if (!checkAppBaseMap()) {
            return false;
        }
        switch (event.getAction()) {
            case 2:
                float rawx = event.getRawX();
                float rawy = event.getRawY();
                int vcode = 0;
                if (rawx > 0.0f) {
                    vcode = 18;
                } else if (rawx < 0.0f) {
                    vcode = 16;
                }
                if (rawy > 0.0f) {
                    vcode = 19;
                } else if (rawy < 0.0f) {
                    vcode = 17;
                }
                if (vcode != 0) {
                    MapMsgProc(1, vcode, 0);
                    break;
                }
                return false;
        }
        return true;
    }

    public void setNaviMapViewListener(NaviMapViewListener naviMapViewListener) {
        this.naviMapViewListener = naviMapViewListener;
    }

    public NaviMapViewListener getNaviMapViewListener() {
        return this.naviMapViewListener;
    }

    public boolean handleTouchEvent(MotionEvent event) {
        if (!checkAppBaseMap()) {
            return false;
        }
        if (!this.bFling) {
            this.gestureController.onTouchEvent(event);
        }
        if (event.getPointerCount() == 2) {
            this.moveLog = true;
            enableMove = false;
            resetDoubleClickStatus();
        }
        if (event.getAction() != 2 && this.mIsEnableDMoveZoom) {
            this.moveLog = true;
            resetDoubleClickStatus();
        }
        switch (event.getAction()) {
            case 0:
                this.moveLog = true;
                handleTouchDown(event);
                break;
            case 1:
                enableMove = true;
                this.moveLog = true;
                handleTouchUp(event);
                break;
            case 2:
                if (!this.mIsEnableDMoveZoom) {
                    handleTouchMove(event);
                    break;
                }
                handleDoubleClickZoom(event);
                break;
            default:
                return false;
        }
        return true;
    }

    private void handleTouchDown(MotionEvent event) {
        int xScreen = (int) event.getX();
        int yScreen = (int) event.getY();
        clickPointX = (float) xScreen;
        clickPointY = (float) yScreen;
        MapMsgProc(4, 0, (yScreen << 16) | xScreen);
        lastClickDown = true;
    }

    public MapViewInterface getMapView() {
        if (this.mMapView != null) {
            return (MapViewInterface) this.mMapView.get();
        }
        return null;
    }

    private void resetDoubleClickStatus() {
        this.mIsEnableDMoveZoom = false;
        this.dmLastLength = 0.0f;
        this.dmLastX = -1.0f;
        this.dmLastY = -1.0f;
    }

    public void handleDoubleClickZoom(MotionEvent event) {
        if (System.currentTimeMillis() - this.dmClickTime >= 100) {
            float y = event.getY();
            float length = this.dmLastY - y;
            MapMsgProc(8193, 3, (int) ((MAP_LEVEL_MAX / ((double) (((float) getScreenHeight()) * length))) / (Math.log(2.0d) * 10000.0d)));
            this.dmLastLength = length;
            this.dmLastY = y;
            BMEventBus.getInstance().post(new MapZoomEvent());
            if (isNaviMode() && getNaviMapViewListener() != null) {
                getNaviMapViewListener().onAction(521, null);
            }
        }
    }

    public boolean handleTouchMove(MotionEvent event) {
        if (!enableMove) {
            return true;
        }
        if (System.currentTimeMillis() - mDoubleClickTime < 300) {
            return true;
        }
        float dx = Math.abs(event.getX() - clickPointX);
        float dy = Math.abs(event.getY() - clickPointY);
        float density = SysOSAPIv2.getInstance().getDensity();
        float touchDetecMulti = (float) (((double) density) > 1.5d ? ((double) density) * 1.5d : (double) density);
        if (lastClickDown && dx / touchDetecMulti <= 3.0f && dy / touchDetecMulti <= 3.0f) {
            return true;
        }
        lastClickDown = false;
        if (isCompass) {
            BMEventBus.getInstance().post(new CancelCompassEvent());
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (this.moveLog) {
            getGestureMonitor().handleTouchMove();
            this.moveLog = false;
        }
        MapMsgProc(3, 0, (y << 16) | x);
        BMEventBus.getInstance().post(new MapMoveEvent(false));
        this.bFling = false;
        this.isMovedMap = true;
        return false;
    }

    public boolean handleTouchUp(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (enableMove) {
            MapMsgProc(5, 0, (y << 16) | x);
        }
        if (!(this.bFling || getMapViewListener() == null)) {
            getMapViewListener().onMapAnimationFinish();
        }
        if (!(this.bFling || !isNaviMode() || getNaviMapViewListener() == null)) {
            getNaviMapViewListener().onMapAnimationFinish();
        }
        this.bFling = false;
        BMEventBus.getInstance().post(new MapMoveEvent(true));
        BMEventBus.getInstance().post(new MapOnTouchMoveEvent());
        return true;
    }

    private boolean handleItemizedClick(int bclick, int x, int y) {
        if (this.mMapView == null || this.mMapView.get() == null) {
            return false;
        }
        MapViewInterface mapView = (MapViewInterface) this.mMapView.get();
        String itemRst = "";
        boolean rst = false;
        int index = -1;
        int clickIndex = -1;
        int layerid = 0;
        try {
            for (int i = mapView.getOverlays().size() - 1; i >= 0; i--) {
                Overlay overlay = (Overlay) mapView.getOverlays().get(i);
                if (overlay.mType == 27) {
                    layerid = overlay.mLayerID;
                    itemRst = this.mBasemap.GetNearlyObjID(layerid, x, y, (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter()));
                    if (!(itemRst == null || itemRst.equals(""))) {
                        JSONObject firstJsonItem = (JSONObject) new JSONObject(itemRst).getJSONArray("dataset").get(0);
                        index = firstJsonItem.getInt("itemindex");
                        clickIndex = firstJsonItem.optInt("clickindex", -1);
                        rst = true;
                        break;
                    }
                }
            }
        } catch (JSONException e) {
        }
        if (bclick != 1 || getMapViewListener() == null) {
            return rst;
        }
        GeoPoint itemGeo = mapView.getProjection().fromPixels(x, y);
        if (clickIndex != -1) {
            getMapViewListener().onClickedItem(index, clickIndex, itemGeo, layerid);
            return rst;
        }
        getMapViewListener().onClickedItem(index, itemGeo, layerid);
        return rst;
    }

    public boolean handleTouchSingleClick(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (handleParticleClick(x, y) || handlePopupClick(x, y) || handleItemizedClick(1, x, y)) {
            return true;
        }
        if (this.bMapclick && getClickedObject(x, y)) {
            return true;
        }
        if (isNaviMode() && this.naviMapViewListener != null) {
            this.naviMapViewListener.onAction(514, event);
        }
        if (getMapViewListener() != null) {
            getMapViewListener().onClickedBackground((int) event.getX(), (int) event.getY());
        }
        return false;
    }

    private boolean handleParticleClick(int x, int y) {
        JSONObject jSONObject;
        if (!checkAppBaseMap()) {
            return false;
        }
        if (getMapViewListener() == null) {
            return false;
        }
        String strJson = this.mBasemap.GetNearlyObjID(-1, x, y, (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter()));
        if (strJson == null) {
            return false;
        }
        List<MapObj> mapObjArray = new ArrayList();
        try {
            JSONObject jsonObj = new JSONObject(strJson);
            try {
                JSONArray jsonArray = jsonObj.getJSONArray("dataset");
                if (((JSONObject) jsonArray.get(0)).getInt("ty") == 7000) {
                    List<MapObj> particleObjArray = new ArrayList();
                    int i = 0;
                    while (i < jsonArray.length()) {
                        JSONObject jsonItem = null;
                        try {
                            jsonItem = (JSONObject) jsonArray.get(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            int itemType = jsonItem.getInt("ty");
                            if (itemType != 26) {
                                MapObj mapObj = new MapObj();
                                if (jsonItem.has("ud")) {
                                    mapObj.strUid = jsonItem.getString("ud");
                                } else {
                                    mapObj.strUid = "";
                                }
                                mapObj.strText = jsonItem.optString("tx");
                                if (jsonItem.has("in")) {
                                    mapObj.nIndex = jsonItem.getInt("in");
                                } else if (jsonItem.has("index")) {
                                    mapObj.nIndex = jsonItem.getInt("index");
                                } else {
                                    mapObj.nIndex = 0;
                                }
                                if (jsonItem.has("geo")) {
                                    Point p = CoordinateUtil.complexPtToPoint(jsonItem.getString("geo"));
                                    mapObj.geoPt.setTo(p == null ? 0.0d : (double) p.getIntX(), p == null ? 0.0d : (double) p.getIntY());
                                } else if (jsonItem.has(MapObjKey.OBJ_SL_PTX) && jsonItem.has(MapObjKey.OBJ_SL_PTY)) {
                                    mapObj.geoPt.setTo((double) ((int) jsonItem.getDouble(MapObjKey.OBJ_SL_PTX)), (double) ((int) jsonItem.getDouble(MapObjKey.OBJ_SL_PTY)));
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SL_TIME)) {
                                    mapObj.sltime = jsonItem.getInt(MapObjKey.OBJ_SL_TIME);
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SL_OBJ)) {
                                    mapObj.slobj = jsonItem.getInt(MapObjKey.OBJ_SL_OBJ);
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SL_VISI)) {
                                    mapObj.slvisi = jsonItem.getInt(MapObjKey.OBJ_SL_VISI);
                                }
                                mapObj.nType = itemType;
                                if (jsonItem.has("of")) {
                                    mapObj.offset = jsonItem.getInt("of");
                                }
                                if (jsonItem.has("poiname")) {
                                    mapObj.ssName = jsonItem.getString("poiname");
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SS_INDOOR_ID)) {
                                    mapObj.ssIndoorId = jsonItem.getString(MapObjKey.OBJ_SS_INDOOR_ID);
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SS_POIUID)) {
                                    mapObj.ssPoiUid = jsonItem.getString(MapObjKey.OBJ_SS_POIUID);
                                }
                                if (jsonItem.has("dis")) {
                                    mapObj.offset = jsonItem.getInt("dis");
                                }
                                if (jsonItem.has("x")) {
                                    mapObj.geoPt.setIntX(jsonItem.getInt("x"));
                                    mapObj.streetArrowCenterX = jsonItem.getDouble("x");
                                }
                                if (jsonItem.has("y")) {
                                    mapObj.geoPt.setIntY(jsonItem.getInt("y"));
                                    mapObj.streetArrowCenterY = jsonItem.getDouble("y");
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SS_ARROW_Z)) {
                                    mapObj.ssZ = jsonItem.getInt(MapObjKey.OBJ_SS_ARROW_Z);
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                                    mapObj.ssRotation = jsonItem.getDouble(MapObjKey.OBJ_SS_ARROW_ROTATION);
                                }
                                if (jsonItem.has("pid")) {
                                    mapObj.ssPanoId = jsonItem.getString("pid");
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SS_DATA)) {
                                    mapObj.ssData = jsonItem.getString(MapObjKey.OBJ_SS_DATA);
                                }
                                if (jsonItem.has(MapObjKey.OBJ_SRC)) {
                                    mapObj.dynamicSrc = jsonItem.getInt(MapObjKey.OBJ_SRC);
                                } else {
                                    mapObj.dynamicSrc = -1;
                                }
                                if (jsonItem.has(MapObjKey.OBJ_AD)) {
                                    mapObj.ad = jsonItem.getInt(MapObjKey.OBJ_AD);
                                } else {
                                    mapObj.ad = -1;
                                }
                                if (jsonItem.has(MapObjKey.OBJ_AD_STYLE)) {
                                    mapObj.adstyle = jsonItem.getInt(MapObjKey.OBJ_AD_STYLE);
                                } else {
                                    mapObj.adstyle = -1;
                                }
                                if (jsonItem.has("qid")) {
                                    mapObj.qid = jsonItem.getString("qid");
                                } else {
                                    mapObj.qid = "";
                                }
                                if (jsonItem.has(MapObjKey.OBJ_PUID)) {
                                    mapObj.puid = jsonItem.getString(MapObjKey.OBJ_PUID);
                                } else {
                                    mapObj.puid = "";
                                }
                                if (jsonItem.has(MapObjKey.AD_LOG)) {
                                    mapObj.adLog = jsonItem.getString(MapObjKey.AD_LOG);
                                } else {
                                    mapObj.adLog = "";
                                }
                                if (jsonItem.has("url")) {
                                    mapObj.url = jsonItem.getString("url");
                                } else {
                                    mapObj.url = "";
                                }
                                particleObjArray.add(mapObj);
                            }
                            i++;
                        } catch (JSONException e2) {
                            List<MapObj> list = particleObjArray;
                            jSONObject = jsonObj;
                        }
                    }
                    getMapViewListener().onClickedParticleEventMapObj(particleObjArray);
                    return true;
                }
                jSONObject = jsonObj;
                return false;
            } catch (JSONException e3) {
                jSONObject = jsonObj;
            }
        } catch (JSONException e4) {
        }
    }

    public void handleDoubleDownClick(MotionEvent event) {
        this.mIsEnableDMoveZoom = true;
        this.dmLastX = event.getX();
        this.dmLastY = event.getY();
        this.dmClickTime = System.currentTimeMillis();
        BMEventBus.getInstance().post(new MapZoomEvent());
    }

    public void handleDoubleTouch(MotionEvent event) {
        if (System.currentTimeMillis() - this.dmClickTime <= 150) {
            if (isNaviMode() && this.naviMapViewListener != null) {
                this.naviMapViewListener.onAction(513, event);
            } else if (this.mIsEnableDDZoom) {
                float tCenterX = 0.0f;
                float tCenterY = 0.0f;
                if (this.mMapView != null && this.mMapView.get() != null) {
                    GeoPoint geoPoint;
                    float tOffsetX = event.getX() - ((float) (getScreenWidth() / 2));
                    float tOffsetY = -1.0f * (event.getY() - ((float) (getScreenHeight() / 2)));
                    if (isCompass) {
                        tOffsetX = 0.0f;
                        tOffsetY = 0.0f;
                        geoPoint = ((MapViewInterface) this.mMapView.get()).getProjection().fromPixels(getScreenWidth() / 2, getScreenHeight() / 2);
                    } else {
                        geoPoint = ((MapViewInterface) this.mMapView.get()).getProjection().fromPixels((int) event.getX(), (int) event.getY());
                    }
                    if (geoPoint != null) {
                        tCenterX = (float) geoPoint.getLongitudeE6();
                        tCenterY = (float) geoPoint.getLatitudeE6();
                    }
                    this.mIsActingDDZoom = true;
                    getGestureMonitor().handleDoubleClick(((MapViewInterface) this.mMapView.get()).getZoomLevel() + 1.0f);
                    MapMsgProc(8195, ((int) event.getX()) | (((int) event.getY()) << 16), (this.screenWidth / 2) | ((this.screenHeight / 2) << 16), 0, 0, (double) tCenterX, (double) tCenterY, (double) tOffsetX, (double) tOffsetY);
                    if (isCompass) {
                        C4770a.m15846a().m15849a("st", "2");
                    }
                    C4770a.m15846a().m15851a("mapview_map_double_click");
                    mDoubleClickTime = System.currentTimeMillis();
                }
            }
        }
    }

    public void handleStreetscapeDoubleTouch(MotionEvent event) {
        float tCenterX = 0.0f;
        float tCenterY = 0.0f;
        if (this.mMapView != null && this.mMapView.get() != null) {
            GeoPoint geoPoint = ((MapViewInterface) this.mMapView.get()).getProjection().fromPixels(this.screenWidth / 2, this.screenHeight / 2);
            if (geoPoint != null) {
                tCenterX = (float) geoPoint.getLongitudeE6();
                tCenterY = (float) geoPoint.getLatitudeE6();
            }
            MapMsgProc(8195, ((int) event.getX()) | (((int) event.getY()) << 16), (this.screenWidth / 2) | ((this.screenHeight / 2) << 16), 0, 0, (double) tCenterX, (double) tCenterY, 0.0d, 0.0d);
            C4770a.m15846a().m15851a("mapview_map_double_click");
        }
    }

    public void setDoubleClickZoom(boolean isZoom) {
        this.mIsEnableDDZoom = isZoom;
    }

    public boolean isDoubleClickZoom() {
        return this.mIsEnableDDZoom;
    }

    public void set3DGestureEnable(boolean bValue) {
        this.mIs3DSet = bValue;
    }

    public boolean is3DGestureEnable() {
        return this.mIs3DSet;
    }

    public void setOverlookGestureEnable(boolean bValue) {
        this.mIsOverlookSet = bValue;
    }

    public boolean isOverlookGestureEnable() {
        return this.mIsOverlookSet;
    }

    public boolean isEnableDMoveZoom() {
        return this.mIsEnableDMoveZoom;
    }

    @SuppressLint({"FloatMath"})
    public boolean handleFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!enableMove) {
            return false;
        }
        float speed = ((float) Math.sqrt((double) ((velocityX * velocityX) + (velocityY * velocityY)))) / (((float) SysOSAPIv2.getInstance().getDensityDpi()) / 310.0f);
        if (getMapControlMode() == MapControlMode.STREET || speed >= 300.0f) {
            this.bFling = true;
            getGestureMonitor().handleFling();
            MapMsgProc(34, (int) speed, (((int) e2.getY()) << 16) | ((int) e2.getX()));
            if (getMapViewListener() != null) {
                BMEventBus.getInstance().post(new MapOnTouchMoveEvent());
            }
            return true;
        }
        this.bFling = false;
        return false;
    }

    public void handleLongClick(MotionEvent e) {
        MapMsgProc(20737, 0, (((int) e.getY()) << 16) | ((int) e.getX()));
    }

    public void handleClick(MotionEvent e) {
        MapMsgProc(20738, 0, (((int) e.getY()) << 16) | ((int) e.getX()));
    }

    public void handleRightClick() {
        MapMsgProc(20739, 0, 0);
    }

    public boolean handleZoomTo(int blockLevel) {
        switch (blockLevel) {
            case 0:
                MapMsgProc(4097, -1, 0);
                break;
            case 1:
                MapMsgProc(4096, -1, 0);
                break;
        }
        return false;
    }

    public GestureMonitor getGestureMonitor() {
        if (this.gestureMonitor == null) {
            this.gestureMonitor = new GestureMonitor(this);
        }
        return this.gestureMonitor;
    }

    boolean zoomIn() {
        boolean z = true;
        if (getZoomLevel() >= 21.0f) {
            return false;
        }
        if (MapMsgProc(4096, 0, 0) != 1) {
            z = false;
        }
        return z;
    }

    boolean zoomOut() {
        boolean z = true;
        if (getZoomLevel() <= 4.0f) {
            return false;
        }
        if (MapMsgProc(4097, 0, 0) != 1) {
            z = false;
        }
        return z;
    }

    public int handleMapModeGet() {
        return MapMsgProc(4113, 0, 0);
    }

    public void setScreenSize(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
    }

    public boolean getMapClickEnable() {
        return this.bMapclick;
    }

    public void setMapClickEnable(boolean b) {
        this.bMapclick = b;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public void setMapStatus(MapStatus mapStatus, boolean isAutoLink) {
        int i = 1;
        if (checkAppBaseMap() && mapStatus != null) {
            int i2;
            Bundle mParamsBundle = new Bundle();
            mParamsBundle.putDouble("level", (double) mapStatus.level);
            mParamsBundle.putDouble(MapObjKey.OBJ_SS_ARROW_ROTATION, (double) mapStatus.rotation);
            mParamsBundle.putDouble("overlooking", (double) mapStatus.overlooking);
            mParamsBundle.putDouble("centerptx", mapStatus.centerPtX);
            mParamsBundle.putDouble("centerpty", mapStatus.centerPtY);
            mParamsBundle.putDouble("centerptz", mapStatus.centerPtZ);
            mParamsBundle.putInt("left", mapStatus.winRound.left);
            mParamsBundle.putInt("right", mapStatus.winRound.right);
            mParamsBundle.putInt("top", mapStatus.winRound.top);
            mParamsBundle.putInt("bottom", mapStatus.winRound.bottom);
            mParamsBundle.putLong("gleft", mapStatus.geoRound.left);
            mParamsBundle.putLong("gbottom", mapStatus.geoRound.bottom);
            mParamsBundle.putLong("gtop", mapStatus.geoRound.top);
            mParamsBundle.putLong("gright", mapStatus.geoRound.right);
            mParamsBundle.putFloat("yoffset", mapStatus.yOffset);
            mParamsBundle.putFloat("xoffset", mapStatus.xOffset);
            mParamsBundle.putInt("animation", 0);
            mParamsBundle.putInt("animatime", 0);
            mParamsBundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            mParamsBundle.putString("panoid", mapStatus.panoId);
            String str = "autolink";
            if (isAutoLink) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            mParamsBundle.putInt(str, i2);
            mParamsBundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            String str2 = "isbirdeye";
            if (!mapStatus.isBirdEye) {
                i = 0;
            }
            mParamsBundle.putInt(str2, i);
            mParamsBundle.putInt("ssext", mapStatus.streetExt);
            this.mBasemap.SetMapStatus(mParamsBundle);
        }
    }

    public void setMapStatus(MapStatus mapStatus) {
        int i = 1;
        if (checkAppBaseMap() && mapStatus != null) {
            Bundle mParamsBundle = new Bundle();
            mParamsBundle.putDouble("level", (double) mapStatus.level);
            mParamsBundle.putDouble(MapObjKey.OBJ_SS_ARROW_ROTATION, (double) mapStatus.rotation);
            mParamsBundle.putDouble("overlooking", (double) mapStatus.overlooking);
            mParamsBundle.putDouble("centerptx", mapStatus.centerPtX);
            mParamsBundle.putDouble("centerpty", mapStatus.centerPtY);
            mParamsBundle.putDouble("centerptz", mapStatus.centerPtZ);
            mParamsBundle.putInt("left", mapStatus.winRound.left);
            mParamsBundle.putInt("right", mapStatus.winRound.right);
            mParamsBundle.putInt("top", mapStatus.winRound.top);
            mParamsBundle.putInt("bottom", mapStatus.winRound.bottom);
            mParamsBundle.putLong("gleft", mapStatus.geoRound.left);
            mParamsBundle.putLong("gbottom", mapStatus.geoRound.bottom);
            mParamsBundle.putLong("gtop", mapStatus.geoRound.top);
            mParamsBundle.putLong("gright", mapStatus.geoRound.right);
            mParamsBundle.putFloat("yoffset", mapStatus.yOffset);
            mParamsBundle.putFloat("xoffset", mapStatus.xOffset);
            mParamsBundle.putInt("animatime", mapStatus.animationTime);
            mParamsBundle.putInt("animation", mapStatus.hasAnimation);
            mParamsBundle.putInt("animatime", mapStatus.animationTime);
            mParamsBundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            mParamsBundle.putString("panoid", mapStatus.panoId);
            mParamsBundle.putInt("autolink", 0);
            mParamsBundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            String str = "isbirdeye";
            if (!mapStatus.isBirdEye) {
                i = 0;
            }
            mParamsBundle.putInt(str, i);
            mParamsBundle.putInt("ssext", mapStatus.streetExt);
            mParamsBundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            mParamsBundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            this.mBasemap.SetMapStatus(mParamsBundle);
        }
    }

    public void startIndoorAnimation() {
        this.mBasemap.StartIndoorAnimation();
    }

    public int setMapControlMode(MapControlMode mode) {
        if (!checkAppBaseMap()) {
            return -1;
        }
        this.mapControlMode = mode;
        return this.mBasemap.SetMapControlMode(mode.id);
    }

    public MapControlMode getMapControlMode() {
        return this.mapControlMode;
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int animTime, boolean isAutoLink) {
        int i = 1;
        if (checkAppBaseMap() && this.mBasemap != null && mapStatus != null) {
            int i2;
            Bundle mParamsBundle = new Bundle();
            mParamsBundle.putDouble("level", (double) mapStatus.level);
            mParamsBundle.putDouble(MapObjKey.OBJ_SS_ARROW_ROTATION, (double) mapStatus.rotation);
            mParamsBundle.putDouble("overlooking", (double) mapStatus.overlooking);
            mParamsBundle.putDouble("centerptx", mapStatus.centerPtX);
            mParamsBundle.putDouble("centerpty", mapStatus.centerPtY);
            mParamsBundle.putDouble("centerptz", mapStatus.centerPtZ);
            mParamsBundle.putInt("left", mapStatus.winRound.left);
            mParamsBundle.putInt("right", mapStatus.winRound.right);
            mParamsBundle.putInt("top", mapStatus.winRound.top);
            mParamsBundle.putInt("bottom", mapStatus.winRound.bottom);
            mParamsBundle.putLong("gleft", mapStatus.geoRound.left);
            mParamsBundle.putLong("gright", mapStatus.geoRound.right);
            mParamsBundle.putLong("gbottom", mapStatus.geoRound.bottom);
            mParamsBundle.putLong("gtop", mapStatus.geoRound.top);
            mParamsBundle.putFloat("xoffset", mapStatus.xOffset);
            mParamsBundle.putFloat("yoffset", mapStatus.yOffset);
            mParamsBundle.putInt("animation", 1);
            mParamsBundle.putInt("animatime", animTime);
            mParamsBundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            mParamsBundle.putString("panoid", mapStatus.panoId);
            String str = "autolink";
            if (isAutoLink) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            mParamsBundle.putInt(str, i2);
            mParamsBundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            String str2 = "isbirdeye";
            if (!mapStatus.isBirdEye) {
                i = 0;
            }
            mParamsBundle.putInt(str2, i);
            mParamsBundle.putInt("ssext", mapStatus.streetExt);
            mParamsBundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            mParamsBundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            this.mBasemap.SetMapStatus(mParamsBundle);
        }
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int animTime) {
        int i = 1;
        if (checkAppBaseMap() && this.mBasemap != null && mapStatus != null) {
            Bundle mParamsBundle = new Bundle();
            mParamsBundle.putDouble("level", (double) mapStatus.level);
            mParamsBundle.putDouble(MapObjKey.OBJ_SS_ARROW_ROTATION, (double) mapStatus.rotation);
            mParamsBundle.putDouble("overlooking", (double) mapStatus.overlooking);
            mParamsBundle.putDouble("centerptx", mapStatus.centerPtX);
            mParamsBundle.putDouble("centerpty", mapStatus.centerPtY);
            mParamsBundle.putDouble("centerptz", mapStatus.centerPtZ);
            mParamsBundle.putInt("left", mapStatus.winRound.left);
            mParamsBundle.putInt("right", mapStatus.winRound.right);
            mParamsBundle.putInt("top", mapStatus.winRound.top);
            mParamsBundle.putInt("bottom", mapStatus.winRound.bottom);
            mParamsBundle.putLong("gleft", mapStatus.geoRound.left);
            mParamsBundle.putLong("gright", mapStatus.geoRound.right);
            mParamsBundle.putLong("gbottom", mapStatus.geoRound.bottom);
            mParamsBundle.putLong("gtop", mapStatus.geoRound.top);
            mParamsBundle.putFloat("xoffset", mapStatus.xOffset);
            mParamsBundle.putFloat("yoffset", mapStatus.yOffset);
            mParamsBundle.putInt("animation", 1);
            mParamsBundle.putInt("animatime", animTime);
            mParamsBundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            mParamsBundle.putString("panoid", mapStatus.panoId);
            mParamsBundle.putInt("autolink", 0);
            mParamsBundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            String str = "isbirdeye";
            if (!mapStatus.isBirdEye) {
                i = 0;
            }
            mParamsBundle.putInt(str, i);
            mParamsBundle.putInt("ssext", mapStatus.streetExt);
            mParamsBundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            mParamsBundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            this.mBasemap.SetMapStatus(mParamsBundle);
        }
    }

    public MapStatus getMapStatus() {
        boolean z = true;
        if (!checkAppBaseMap()) {
            return new MapStatus();
        }
        Bundle b = this.mBasemap.GetMapStatus();
        if (b == null) {
            return new MapStatus();
        }
        boolean z2;
        MapStatus mapStatus = new MapStatus();
        mapStatus.level = (float) b.getDouble("level");
        mapStatus.rotation = (int) b.getDouble(MapObjKey.OBJ_SS_ARROW_ROTATION);
        mapStatus.overlooking = (int) b.getDouble("overlooking");
        mapStatus.centerPtX = b.getDouble("centerptx");
        mapStatus.centerPtY = b.getDouble("centerpty");
        mapStatus.centerPtZ = b.getDouble("centerptz");
        mapStatus.winRound.left = b.getInt("left");
        mapStatus.winRound.right = b.getInt("right");
        mapStatus.winRound.top = b.getInt("top");
        mapStatus.winRound.bottom = b.getInt("bottom");
        mapStatus.geoRound.left = b.getLong("gleft");
        mapStatus.geoRound.right = b.getLong("gright");
        mapStatus.geoRound.top = b.getLong("gtop");
        mapStatus.geoRound.bottom = b.getLong("gbottom");
        mapStatus.xOffset = b.getFloat("xoffset");
        mapStatus.yOffset = b.getFloat("yoffset");
        mapStatus.bfpp = b.getInt("bfpp") == 1;
        mapStatus.panoId = b.getString("panoid");
        mapStatus.streetIndicateAngle = b.getFloat("siangle");
        if (b.getInt("isbirdeye") == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        mapStatus.isBirdEye = z2;
        mapStatus.streetExt = b.getInt("ssext");
        mapStatus.roadOffsetX = b.getFloat("roadOffsetX");
        mapStatus.roadOffsetY = b.getFloat("roadOffsetY");
        if (b.getInt("boverlookback") != 1) {
            z = false;
        }
        mapStatus.bOverlookSpringback = z;
        mapStatus.minOverlooking = (int) b.getFloat("minoverlook");
        if (mapStatus.geoRound.left <= -20037508) {
            mapStatus.geoRound.left = -20037508;
        }
        if (mapStatus.geoRound.right >= 20037508) {
            mapStatus.geoRound.right = 20037508;
        }
        if (mapStatus.geoRound.top >= 20037508) {
            mapStatus.geoRound.top = 20037508;
        }
        if (mapStatus.geoRound.bottom > -20037508) {
            return mapStatus;
        }
        mapStatus.geoRound.bottom = -20037508;
        return mapStatus;
    }

    public float getZoomLevel() {
        if (this.mBasemap == null) {
            return 4.0f;
        }
        Bundle b = this.mBasemap.GetMapStatus();
        if (b != null) {
            return (float) b.getDouble("level");
        }
        return 4.0f;
    }

    public static int getScaleDis(int nLevel) {
        switch (nLevel) {
            case 1:
                return C1253f.iE;
            case 2:
                return 5000000;
            case 3:
                return 2000000;
            case 4:
                return 1000000;
            case 5:
                return 500000;
            case 6:
                return 200000;
            case 7:
                return 100000;
            case 8:
                return 50000;
            case 9:
                return 25000;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public void initMapResources(Bundle params) {
        if (!this.mBaseMapInited && params != null && this.mBasemap != null) {
            boolean flag = SysOSAPIv2.getInstance().getDensityDpi() >= C4820d.f19955a;
            this.nearlyRadius = (SysOSAPIv2.getInstance().getDensityDpi() * 25) / RGHUDDataModel.MAX_CAR_SPEED;
            String modulePath = params.getString("modulePath");
            String appSdcardPath = params.getString("appSdcardPath");
            String cachePath = params.getString("appCachePath");
            String secondCachePath = params.getString("appSecondCachePath");
            int nMapTmpStgMax = params.getInt("mapTmpMax");
            int nDomTmpStgMax = params.getInt("domTmpMax");
            int nItsTmpStgMax = params.getInt("itsTmpMax");
            int nSsgTmpStgMax = params.getInt("ssgTmpMax");
            String suffix = flag ? "/h/" : "/l/";
            modulePath = modulePath + "/cfg";
            appSdcardPath = appSdcardPath + "/vmp";
            String strCFGDataRoot = modulePath + "/a/";
            String strStyleResPath = modulePath + "/a/";
            this.mBasemap.Init(strCFGDataRoot, modulePath + "/idrres/", appSdcardPath + suffix, cachePath + "/tmp/", secondCachePath + "/tmp/", appSdcardPath + suffix, strStyleResPath, this.screenWidth, this.screenHeight, SysOSAPIv2.getInstance().getDensityDpi(), nMapTmpStgMax, nDomTmpStgMax, nItsTmpStgMax, nSsgTmpStgMax, false);
            this.mBasemap.SetMapStatus(params);
            this.mBaseMapInited = true;
        }
    }

    public void reinit(Bundle params) {
        if (!this.mBaseMapReInited) {
            if (params == null || this.mBasemap == null) {
                throw new IllegalArgumentException("IllegalArgument");
            }
            boolean flag = SysOSAPIv2.getInstance().getDensityDpi() >= C4820d.f19955a;
            this.nearlyRadius = (SysOSAPIv2.getInstance().getDensityDpi() * 25) / RGHUDDataModel.MAX_CAR_SPEED;
            String modulePath = params.getString("modulePath");
            String appSdcardPath = params.getString("appSdcardPath");
            String cachePath = params.getString("appCachePath");
            String secondCachePath = params.getString("appSecondCachePath");
            int nMapTmpStgMax = params.getInt("mapTmpMax");
            int nDomTmpStgMax = params.getInt("domTmpMax");
            int nItsTmpStgMax = params.getInt("itsTmpMax");
            int nSsgTmpStgMax = params.getInt("ssgTmpMax");
            String suffix = flag ? "/h/" : "/l/";
            modulePath = modulePath + "/cfg";
            appSdcardPath = appSdcardPath + "/vmp";
            String strCFGDataRoot = modulePath + "/a/";
            String strStyleResPath = modulePath + "/a/";
            this.mBasemap.Init(strCFGDataRoot, modulePath + "/idrres/", appSdcardPath + suffix, cachePath + "/tmp/", secondCachePath + "/tmp/", appSdcardPath + suffix, strStyleResPath, this.screenWidth, this.screenHeight, SysOSAPIv2.getInstance().getDensityDpi(), nMapTmpStgMax, nDomTmpStgMax, nItsTmpStgMax, nSsgTmpStgMax, true);
            this.mBasemap.SetMapStatus(params);
            this.mBaseMapReInited = true;
        }
    }

    public void setOverlayMapCallBack(OverlayMapCallBack overlayCallBack) {
        if (overlayCallBack != null && this.mBasemap != null) {
            this.mBasemap.SetCallback(overlayCallBack);
        }
    }

    private void registerMsgs() {
        MessageProxy.registerMessageHandler(m_AppUI.MSG_APP_SAVESCREEN, mHandler);
        MessageProxy.registerMessageHandler(519, mHandler);
        MessageProxy.registerMessageHandler(39, mHandler);
        MessageProxy.registerMessageHandler(512, mHandler);
        MessageProxy.registerMessageHandler(m_AppUI.V_WM_VSTREETCLICKARROW, mHandler);
        MessageProxy.registerMessageHandler(m_AppUI.V_WM_VSTREETCLICKBACKGROUND, mHandler);
        MessageProxy.registerMessageHandler(50, mHandler);
        MessageProxy.registerMessageHandler(51, mHandler);
        MessageProxy.registerMessageHandler(m_AppUI.V_WM_BMBAR, mHandler);
    }

    private void unRegisterMsgs() {
        MessageProxy.unRegisterMessageHandler(m_AppUI.MSG_APP_SAVESCREEN, mHandler);
        MessageProxy.unRegisterMessageHandler(519, mHandler);
        MessageProxy.unRegisterMessageHandler(39, mHandler);
        MessageProxy.unRegisterMessageHandler(512, mHandler);
        MessageProxy.unRegisterMessageHandler(m_AppUI.V_WM_VSTREETCLICKARROW, mHandler);
        MessageProxy.unRegisterMessageHandler(m_AppUI.V_WM_VSTREETCLICKBACKGROUND, mHandler);
        MessageProxy.unRegisterMessageHandler(50, mHandler);
        MessageProxy.unRegisterMessageHandler(51, mHandler);
        MessageProxy.unRegisterMessageHandler(m_AppUI.V_WM_BMBAR, mHandler);
    }

    public void unInit() {
        unRegisterMsgs();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
        if (this.mBaseMapInited && this.mBasemap != null) {
            this.mBasemap.Release();
            this.mBasemap = null;
            this.mBaseMapInited = false;
        }
    }

    public void scrollBy(int x, int y) {
        if (x != 0 || y != 0) {
            moveMapToScrPoint((this.screenWidth / 2) + x, (this.screenHeight / 2) + y);
        }
    }

    public int getCacheSize(MapLayerType type) {
        AppBaseMap appBaseMap = this.mBasemap;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.GetCacheSize(type.id);
    }

    public boolean cleanCache(MapLayerType type) {
        AppBaseMap appBaseMap = this.mBasemap;
        return appBaseMap != null && appBaseMap.CleanCache(type.id);
    }

    public String getCityInfoByID(int cityId) {
        if (this.mBasemap != null) {
            return this.mBasemap.GetCityInfoByID(cityId);
        }
        return null;
    }

    public int getVMPMapCityItsInfo() {
        if (this.mBasemap == null) {
            return 0;
        }
        Bundle b = new Bundle();
        b.putString("querytype", "its");
        this.mBasemap.GetVMPMapCityInfo(b);
        return b.getInt("rst");
    }

    public int getVMPMapCitySatInfo() {
        if (this.mBasemap == null) {
            return 0;
        }
        Bundle b = new Bundle();
        b.putString("querytype", "sat");
        this.mBasemap.GetVMPMapCityInfo(b);
        return b.getInt("rst");
    }

    public int getVMPMapCityLevel() {
        if (this.mBasemap == null) {
            return 0;
        }
        Bundle b = new Bundle();
        b.putString("querytype", "map");
        this.mBasemap.GetVMPMapCityInfo(b);
        return b.getInt("level");
    }

    public int getVMPMapCityCode() {
        if (this.mBasemap == null) {
            return 0;
        }
        Bundle b = new Bundle();
        b.putString("querytype", "map");
        this.mBasemap.GetVMPMapCityInfo(b);
        return b.getInt("code");
    }

    public boolean isPressedOnPopup(int x, int y) {
        return false;
    }

    public boolean handlePopupClick(int x, int y) {
        return false;
    }

    public boolean getMapBarData() {
        Bundle bundle = new Bundle();
        this.mBasemap.getMapBarData(bundle);
        String uid = null;
        String searchbound = null;
        String curfloor = null;
        byte[] barinfo = new byte[0];
        if (bundle.containsKey("uid")) {
            uid = bundle.getString("uid");
        }
        if (bundle.containsKey("searchbound")) {
            searchbound = bundle.getString("searchbound");
        }
        if (bundle.containsKey("curfloor")) {
            curfloor = bundle.getString("curfloor");
        }
        if (bundle.containsKey("barinfo")) {
            barinfo = bundle.getByteArray("barinfo");
        }
        BMEventBus.getInstance().post(new BMBarShowEvent(uid, searchbound, curfloor, barinfo));
        return true;
    }

    public boolean getMapBarShowData() {
        return this.mBasemap.getMapBarData(new Bundle());
    }

    public void setNetStatus(int newNetStatus) {
        if (this.mEngineMsgListener != null) {
            if (newNetStatus == 1) {
                this.mEngineMsgListener.onLongLinkConnect();
            } else if (newNetStatus == 2 && this.netStatus != newNetStatus) {
                this.mEngineMsgListener.onLongLinkDisConnect();
            }
            this.netStatus = newNetStatus;
        }
    }

    public float getZoomToBound(Bundle bundle, int width, int height) {
        return this.mBasemap.GetZoomToBound(bundle, width, height);
    }

    public float getZoomToBoundF(Bundle bundle) {
        return this.mBasemap.GetZoomToBoundF(bundle);
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle screenBd) {
        return this.mBasemap.GetFZoomToBoundF(bundle, screenBd);
    }

    public float getAdapterZoomUnitsEx() {
        return this.mBasemap.GetAdapterZoomUnitsEx();
    }

    public void SetStyleMode(int styleMode) {
        setMapScene(styleMode);
    }

    private boolean changeTravelMode(int styleMode) {
        if (this.travelMode && (styleMode == 0 || styleMode == 3 || styleMode == 2 || styleMode == 1)) {
            return true;
        }
        return false;
    }

    public void setTravelMode(boolean travelMode) {
        this.travelMode = travelMode;
    }

    public void setStyleMode(MapStyleMode mode) {
        this.mBasemap.SetStyleMode(mode.getMode());
    }

    public boolean setLayerSceneMode(int layerId, MapSceneMode mode) {
        return this.mBasemap.SetLayerSceneMode(layerId, mode.getMode());
    }

    public void showBaseIndoorMap(boolean bShow) {
        this.mBasemap.ShowBaseIndoorMap(bShow);
    }

    public boolean switchBaseIndoorMapFloor(String floorId, String buildingId) {
        return this.mBasemap.SwitchBaseIndoorMapFloor(floorId, buildingId);
    }

    public IndoorMapInfo getFocusedBaseIndoorMapInfo() {
        String str = this.mBasemap.GetFocusedBaseIndoorMapInfo();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int i;
            JSONObject jsonObject = new JSONObject(str);
            String buildingId = jsonObject.optString("focusindoorid");
            String floorId = jsonObject.optString("curfloor");
            int idrType = jsonObject.optInt("idrtype");
            JSONArray jsonArray = jsonObject.optJSONArray("floorlist");
            String[] floorList = null;
            if (jsonArray != null) {
                floorList = new String[jsonArray.length()];
                List<String> list = new ArrayList();
                for (i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getString(i));
                }
                list.toArray(floorList);
            }
            JSONArray jsonArrayAttr = jsonObject.optJSONArray("floorattribute");
            int[] floorAttr = null;
            if (jsonArrayAttr != null) {
                floorAttr = new int[jsonArrayAttr.length()];
                for (i = 0; i < jsonArrayAttr.length(); i++) {
                    floorAttr[i] = jsonArrayAttr.optInt(i);
                }
            }
            return new IndoorMapInfo(buildingId, floorId, floorList, floorAttr, idrType, jsonObject.optInt("idrguide"), jsonObject.optString("idrsearch"));
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean isBaseIndoorMapMode() {
        return this.mBasemap.IsBaseIndoorMapMode();
    }

    public boolean isInFocusIndoorBuilding(GeoPoint point) {
        return point != null && this.mBasemap.IsPointInFocusIDRBorder(point.getLongitude(), point.getLatitude());
    }

    public boolean isInFocusBarBorder(GeoPoint point, double radius) {
        return point != null && this.mBasemap.IsPointInFocusBarBorder(point.getLongitude(), point.getLatitude(), radius);
    }

    public boolean isStreetPOIMarkerShown() {
        return this.mBasemap.IsStreetPOIMarkerShown();
    }

    public void showStreetPOIMarker(boolean bShow) {
        this.mBasemap.ShowStreetPOIMarker(bShow);
    }

    public void setAllStreetCustomMarkerVisibility(boolean bShow) {
        this.mBasemap.SetAllStreetCustomMarkerVisibility(bShow);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean bShow, String hashKey) {
        this.mBasemap.SetTargetStreetCustomMarkerVisibility(bShow, hashKey);
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        this.mBasemap.AddStreetCustomMarker(bundle, bitmap);
    }

    public void removeStreetCustomMarker(String hashkey) {
        this.mBasemap.RemoveStreetCustomMaker(hashkey);
    }

    public void removeStreetAllCustomMarker() {
        this.mBasemap.RemoveStreetAllCustomMarker();
    }

    public void setStreetMarkerClickable(String hashkey, boolean bClickable) {
        this.mBasemap.SetStreetMarkerClickable(hashkey, bClickable);
    }

    public boolean isStreetArrowShown() {
        return this.mBasemap.IsStreetArrowShown();
    }

    public void setStreetArrowShow(boolean show) {
        this.mBasemap.SetStreetArrowShow(show);
    }

    public boolean isStreetRoadClickable() {
        return this.mBasemap.IsStreetRoadClickable();
    }

    public void setStreetRoadClickable(boolean bClickable) {
        this.mBasemap.SetStreetRoadClickable(bClickable);
    }

    public boolean isStreetCustomMarkerShown() {
        return this.mBasemap.IsStreetCustomMarkerShown();
    }

    public boolean importMapTheme(int modeId) {
        return this.mBasemap.importMapTheme(modeId);
    }

    public boolean setMapTheme(int modeId, @NotNull Bundle bundle) {
        if (this.mBasemap.getMapTheme() == modeId) {
            return true;
        }
        this.theme = modeId;
        return this.mBasemap.setMapTheme(modeId, bundle);
    }

    public boolean setMapThemeScene(int modeId, int sceneId, @NotNull Bundle bundle) {
        if (this.mBasemap.getMapTheme() == modeId && this.mBasemap.getMapScene() == sceneId) {
            return true;
        }
        this.theme = modeId;
        this.styleMode = sceneId;
        return this.mBasemap.setMapThemeScene(modeId, sceneId, bundle);
    }

    public boolean forceSetMapThemeScene(int modeId, int sceneId, @NotNull Bundle bundle) {
        this.theme = modeId;
        this.styleMode = sceneId;
        return this.mBasemap.setMapThemeScene(modeId, sceneId, bundle);
    }

    public void setMapScene(int modeId) {
        if (modeId != getMapScene()) {
            this.styleMode = modeId;
            this.mBasemap.setMapScene(this.styleMode);
        }
    }

    public void forceSetMapScene(int modeId) {
        this.styleMode = modeId;
        this.mBasemap.setMapScene(this.styleMode);
    }

    public int getMapScene() {
        return this.mBasemap.getMapScene();
    }

    public int getMapTheme() {
        return this.mBasemap.getMapTheme();
    }

    public int getLastSaveMapMode() {
        return C4798b.m15889a().m15910f();
    }

    public boolean isMapAnimationRunning() {
        return this.mBasemap.isAnimationRunning();
    }

    public String getProjectionPt(String content) {
        return this.mBasemap.getProjectionPt(content);
    }

    public boolean isNaviMode() {
        return this.mBasemap.isNaviMode();
    }

    public int getSceneLayerScene() {
        return this.styleMode;
    }

    public int getSceneLayerTheme() {
        return this.theme;
    }
}
