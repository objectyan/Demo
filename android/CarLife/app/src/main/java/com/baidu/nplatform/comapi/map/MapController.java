package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnKeyListener;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.core.C1253f;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.mapcontrol.MapParams$Const$LayerType;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.gesture.GestureController;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import org.json.JSONException;
import org.json.JSONObject;

public class MapController implements OnKeyListener {
    private static final int DB_CLICK_NON_CONFLICT = 300;
    private static final int DOUBLE_TAP_SLOP = 60;
    private static final int DRAG_MIN_DIST = 20;
    private static long DoubleTapTimeout = 400;
    private static final float FLING_ADJUST = 0.6f;
    private static final int FLING_SPEED_MIN = 300;
    private static final int LOOK_ROATE_BUNDARY = 1;
    private static final int LOOK_ZOOM_BUNDARY = 3000;
    private static long LongPressTimeout = 500;
    public static final int NEARLYRADIUS = 25;
    public static final int NEARLYRADIUS_NEAREST_OBT = 35;
    private static final int ROATE_BUNDARY = 10;
    private static final String TAG = MapController.class.getSimpleName();
    public static final int TOUCH_MODE_LOOKOVER = 1;
    public static final int TOUCH_MODE_ROTATE = 4;
    public static final int TOUCH_MODE_ZOOM = 3;
    public static final int TOUCH_MODE_ZOOM_ROTATE = 2;
    private static final int ZOOM_BUNDARY = 2000;
    private static float clickPointX;
    private static float clickPointY;
    private static long curClickDown;
    private static boolean enableMove = true;
    private static boolean enterLookover;
    private static boolean enterZoomRotate;
    private static int flag = 0;
    private static boolean ifGestureZoomin = false;
    private static boolean ifGestureZoomout = false;
    private static boolean lastClickDown;
    private static float lastPointX;
    private static float lastPointY;
    private static boolean logLookover;
    private static boolean logRotate;
    private static long mDoubleClickTime = 0;
    private static long mMultiDownTime;
    private static long mMultiDownTimeTem;
    public static MultiTouch mMultiTouch = new MultiTouch();
    private static long mMultiUpTime;
    private static long mMultiUpTimeTem;
    private static int touchMode;
    private static VelocityTracker velocityTracker;
    private boolean bFling = false;
    private boolean bMapclick = true;
    private boolean enableTouchModeLookover = true;
    private GestureController gestureController = new GestureController(this);
    private int mAddrBaseMap = 0;
    private JNIBaseMap mBasemap = null;
    private Context mContext = null;
    private float mDensity = 1.0f;
    private DoubleTapController mDoubleTapController;
    final Handler mFocusHandler = new Handler();
    private int mFocusItemIndex = -1;
    private boolean mIs3DSet = true;
    private boolean mIsActingDDZoom = false;
    private boolean mIsEnableDDZoom = true;
    private float mLevel = -1.0f;
    public MapControlMode mMapControlMode = MapControlMode.DEFAULT;
    private MapGLSurfaceView mMapGlView = null;
    private MapViewListener mMapViewListener = null;
    private MsgHandler mMsgHandler = new C47411();
    private Bundle mParamsBundle = new Bundle();
    private Point mPtDown;
    private Point mPtFlingFrom;
    private Point mPtMove;
    private Point mPtUp;
    private boolean mbDown = false;
    private int nearlyRadius = 20;
    private int screenHeight;
    private int screenWidth;

    /* renamed from: com.baidu.nplatform.comapi.map.MapController$1 */
    class C47411 extends MsgHandler {
        C47411() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MsgDefine.MSG_MAP_REQUEST_START /*4197*/:
                    if (MapController.this.getMapViewListener() != null) {
                        MapController.this.getMapViewListener().onMapNetworkingChanged(true);
                        return;
                    }
                    return;
                case MsgDefine.MSG_MAP_REQUEST_END /*4198*/:
                    if (MapController.this.getMapViewListener() != null) {
                        MapController.this.getMapViewListener().onMapNetworkingChanged(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            observe((int) MsgDefine.MSG_MAP_REQUEST_START);
            observe((int) MsgDefine.MSG_MAP_REQUEST_END);
        }
    }

    public enum AnimationType {
        eAnimationNone(0),
        eAnimationPos(1),
        eAnimationRotate(16),
        eAnimationOverlook(256),
        eAnimationLevel(4096),
        eAnimationAll(4369),
        eAnimationInelligent(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL),
        eAnimationFrogleap(268435457),
        eAnimationArc(268435712),
        eAnimationViewall(268439552),
        eAnimationPoi(268500992);
        
        private final int value;

        private AnimationType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public static class LightRouteType {
        public static final int ALTERNATIVE = 1;
        public static final int AVOID_CONGEST = 2;
        public static final int CANCEL = 0;
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

    public static class MultiTouch {
        final int MAP_TWO_TOUCH = 2;
        float centerX;
        float centerY;
        double length;
        public boolean mTwoTouch;
        float startX1;
        float startX2;
        float startY1;
        float startY2;
        float x1;
        float x2;
        float y1;
        float y2;

        MultiTouch() {
        }
    }

    public MapController(Context context, MapGLSurfaceView mapview) {
        this.mContext = context;
        this.mMapGlView = mapview;
        this.mMapGlView.setOnKeyListener(this);
        VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
        this.mDensity = VDeviceAPI.getScreenDensity();
    }

    public MapController(Context context) {
        this.mContext = context;
        VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
        this.mDensity = VDeviceAPI.getScreenDensity();
    }

    public void resizeSecreen(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
    }

    public void initBaseMap(Bundle b) {
        this.nearlyRadius = (ScreenUtil.getInstance().getDPI() * 25) / RGHUDDataModel.MAX_CAR_SPEED;
        this.screenWidth = b.getInt("right");
        this.screenHeight = b.getInt("bottom");
        if (this.mBasemap == null) {
            try {
                this.mBasemap = new JNIBaseMap();
            } catch (Throwable th) {
            }
        }
    }

    public void initBaseMap() {
        if (this.mBasemap == null) {
            try {
                this.mBasemap = new JNIBaseMap();
            } catch (Throwable th) {
            }
        }
    }

    public JNIBaseMap getBaseMap() {
        return this.mBasemap;
    }

    public MapViewInterface getMapView() {
        return this.mMapGlView;
    }

    public void unInit() {
        if (this.mBasemap != null) {
            this.mBasemap = null;
        }
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public boolean handleTouchEvent(MotionEvent event) {
        this.gestureController.onTouchEvent(event);
        if (event.getPointerCount() == 2) {
            enableMove = false;
        }
        switch (event.getAction()) {
            case 0:
                handleTouchDown(event);
                break;
            case 1:
                enableMove = true;
                handleTouchUp(event);
                break;
            case 2:
                handleTouchMove(event);
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

    public boolean handleTouchMove(MotionEvent event) {
        if (isTouchFromTop()) {
            return true;
        }
        if (!enableMove) {
            return true;
        }
        if (System.currentTimeMillis() - mDoubleClickTime < 300) {
            return true;
        }
        float dx = Math.abs(event.getX() - clickPointX);
        float dy = Math.abs(event.getY() - clickPointY);
        float density = ScreenUtil.getInstance().getDensity();
        float touchDetecMulti = (float) (((double) density) > 1.5d ? ((double) density) * 1.5d : (double) density);
        if (lastClickDown && dx / touchDetecMulti <= 3.0f && dy / touchDetecMulti <= 3.0f) {
            return true;
        }
        lastClickDown = false;
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        MapMsgProc(3, 0, (y << 16) | x);
        return false;
    }

    private boolean isTouchFromTop() {
        if (clickPointY <= ((float) ScreenUtil.getInstance().dip2px(40))) {
            return true;
        }
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
        LogUtil.m15791e(ModuleName.MAP, "_MAP_handleTouchUp: bFling " + this.bFling);
        if (this.mMapGlView.mMapViewListener != null) {
            this.mMapGlView.mMapViewListener.onMapAnimationFinish();
        }
        return true;
    }

    private static void resetTouchMode() {
        touchMode = 0;
        enterLookover = false;
        enterZoomRotate = false;
        mMultiTouch.mTwoTouch = false;
        mMultiTouch.length = 0.0d;
        logLookover = false;
        logRotate = false;
    }

    public boolean handleTouchSingleClick(MotionEvent event) {
        LogUtil.m15791e(ModuleName.MAP, "handleTouchSingleClick");
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (handlePopupClick(x, y) || handleItemsizedClick(1, x, y)) {
            return true;
        }
        if (this.bMapclick && GetNearlyObject(x, y)) {
            return true;
        }
        if (this.mMapGlView.mMapViewListener != null) {
            this.mMapGlView.mMapViewListener.onClickedBackground((int) event.getX(), (int) event.getY());
        }
        return false;
    }

    public void handleClickBackground(MotionEvent event) {
        if (getMapViewListener() != null) {
            getMapViewListener().onClickedBackground((int) event.getX(), (int) event.getY());
        }
    }

    public void handleDoubleTouch(MotionEvent event) {
        if (this.mIsEnableDDZoom) {
            float tCenterX = 0.0f;
            float tCenterY = 0.0f;
            GeoPoint geoPoint = scrPtToGeoPoint((int) event.getX(), (int) event.getY());
            if (geoPoint != null) {
                tCenterX = (float) geoPoint.getLongitudeE6();
                tCenterY = (float) geoPoint.getLatitudeE6();
            }
            float tOffsetX = event.getX() - ((float) (getScreenWidth() / 2));
            float tOffsetY = -1.0f * (event.getY() - ((float) (getScreenHeight() / 2)));
            this.mIsActingDDZoom = true;
            BNStatisticsManager.getInstance().onMapScaleSet(Math.min(getZoomLevel() + 1, 20));
            MapMsgProc(8195, ((int) event.getX()) | (((int) event.getY()) << 16), (this.screenWidth / 2) | ((this.screenHeight / 2) << 16), 0, 0, (double) tCenterX, (double) tCenterY, (double) tOffsetX, (double) tOffsetY);
            mDoubleClickTime = System.currentTimeMillis();
        }
    }

    public void onDoubleFingerZoom() {
        if (this.mMapGlView.mMapViewListener != null) {
            this.mMapGlView.mMapViewListener.onDoubleFingerZoom();
        }
    }

    public void setDoubleClickZoom(boolean isZoom) {
        this.mIsEnableDDZoom = isZoom;
    }

    public void set3DGestureEnable(boolean bValue) {
        this.mIs3DSet = bValue;
    }

    public boolean get3DGestureEnable() {
        return this.mIs3DSet;
    }

    public void enableTouchEventLookover(boolean enable) {
        this.enableTouchModeLookover = enable;
    }

    public boolean handleFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (isTouchFromTop() || !enableMove) {
            return false;
        }
        float speed = (float) Math.sqrt((double) ((velocityX * velocityX) + (velocityY * velocityY)));
        if (getMapControlMode() != MapControlMode.STREET && speed < 300.0f) {
            return false;
        }
        this.bFling = true;
        MapMsgProc(34, (int) speed, (((int) e2.getY()) << 16) | ((int) e2.getX()));
        return true;
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

    private boolean GetNearlyObject(int x, int y) {
        int radius = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());
        if (RouteGuideParams.getRouteGuideMode() == 2) {
            y += ScreenUtil.getInstance().getStatusBarHeight();
        }
        MapItem item = (MapItem) this.mBasemap.SelectItem(x, y, 35);
        if (item == null) {
            return false;
        }
        LogUtil.m15791e("sunhao", "GetNearlyObject() type=" + item.mItemType);
        if (this.mMapGlView == null || this.mMapGlView.mMapViewListener == null) {
            return false;
        }
        switch (item.mItemType) {
            case 0:
                this.mMapGlView.mMapViewListener.onClickedBaseLayer();
                return true;
            case 3:
                this.mMapGlView.mMapViewListener.onClickedPOILayer(item);
                return true;
            case 4:
                this.mMapGlView.mMapViewListener.onClickedPOIBkgLayer(item);
                return true;
            case 9:
                this.mMapGlView.mMapViewListener.onClickedCompassLayer();
                return true;
            case 10:
                this.mMapGlView.mMapViewListener.onClickedRoute(item);
                return true;
            case 11:
                this.mMapGlView.mMapViewListener.onClickedPopupLayer();
                return true;
            case 12:
                this.mMapGlView.mMapViewListener.onClickedBasePOILayer(item);
                return true;
            case 13:
                this.mMapGlView.mMapViewListener.onClickedRouteSpecLayer(item);
                return true;
            case 16:
                this.mMapGlView.mMapViewListener.onClickedFavPoiLayer(item);
                return true;
            case 34:
                this.mMapGlView.mMapViewListener.onClickedUgcItem(item);
                return true;
            case 200:
                this.mMapGlView.mMapViewListener.onClickedCustomLayer(item, x, y);
                return true;
            default:
                return false;
        }
    }

    private MapItem convert2MapItem(String jsonStr) {
        LogUtil.m15791e(TAG, "convert2MapItem: jsonStr --> " + jsonStr);
        if (jsonStr == null) {
            return null;
        }
        MapItem mapItem = new MapItem();
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            boolean isMapItem = false;
            if (jsonObject.has("navi")) {
                isMapItem = jsonObject.getBoolean("navi");
            }
            if (!isMapItem) {
                return null;
            }
            if (jsonObject.has("in")) {
                mapItem.mItemID = jsonObject.getInt("in");
            }
            if (jsonObject.has("ty")) {
                mapItem.mItemType = jsonObject.getInt("ty");
            }
            if (jsonObject.has("ud")) {
                mapItem.mUid = jsonObject.getString("ud");
            }
            if (jsonObject.has("tx")) {
                mapItem.mTitle = jsonObject.getString("tx");
            }
            double lat = Double.MIN_VALUE;
            double lon = Double.MIN_VALUE;
            if (jsonObject.has(MapItem.KEY_LONGITUDE) && jsonObject.has(MapItem.KEY_LATITUDE)) {
                lon = jsonObject.getDouble(MapItem.KEY_LONGITUDE);
                lat = jsonObject.getDouble(MapItem.KEY_LATITUDE);
            }
            if (!(lat == Double.MIN_VALUE || lon == Double.MIN_VALUE)) {
                mapItem.mLatitudeMc = lat;
                mapItem.mLongitudeMc = lon;
                Bundle bundle = CoordinateTransformUtil.MC2LLE6((int) lon, (int) lat);
                mapItem.mLatitude = bundle.getInt("LLy");
                mapItem.mLongitude = bundle.getInt("LLx");
            }
            if (jsonObject.has(MapItem.KEY_CUR_ROUTE_INDEX)) {
                mapItem.mCurRouteIdx = jsonObject.getInt(MapItem.KEY_CUR_ROUTE_INDEX);
            }
            if (jsonObject.has(MapItem.KEY_CLICK_TYPE)) {
                mapItem.mClickType = jsonObject.getInt(MapItem.KEY_CLICK_TYPE);
            }
            LogUtil.m15791e(TAG, "convert2MapItem: mapItem --> " + mapItem.toString());
            return mapItem;
        } catch (JSONException e) {
            e.printStackTrace();
            return mapItem;
        }
    }

    public void setMapViewListener(MapViewListener mapListener) {
        this.mMapViewListener = mapListener;
    }

    public MapViewListener getMapViewListener() {
        return this.mMapViewListener;
    }

    public void onMapAnimationFinish() {
        if (getMapViewListener() != null) {
            getMapViewListener().onMapAnimationFinish();
        }
    }

    public boolean onMapItemClick(String jsonStr, int clickedX, int clickedY) {
        MapItem item = convert2MapItem(jsonStr);
        if (item == null || getMapViewListener() == null) {
            return false;
        }
        switch (item.mItemType) {
            case 0:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_BASE_MAP");
                getMapViewListener().onClickedBaseLayer();
                return true;
            case 1:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_START");
                getMapViewListener().onClickedStartLayer(item, clickedX, clickedY);
                return true;
            case 2:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_END");
                getMapViewListener().onClickedEndLayer(item, clickedX, clickedY);
                return true;
            case 3:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_POI");
                getMapViewListener().onClickedPOILayer(item);
                return true;
            case 4:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_POI_BKG");
                getMapViewListener().onClickedPOIBkgLayer(item);
                return true;
            case 9:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_COMPASS");
                getMapViewListener().onClickedCompassLayer();
                return true;
            case 10:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_ROUTE");
                getMapViewListener().onClickedRoute(item);
                return true;
            case 11:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_POPUP");
                getMapViewListener().onClickedPopupLayer();
                return true;
            case 12:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_BASE_POI");
                getMapViewListener().onClickedBasePOILayer(item);
                return true;
            case 13:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_ROUTE_SPEC");
                getMapViewListener().onClickedRouteSpecLayer(item);
                return true;
            case 16:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_FAVPOI");
                getMapViewListener().onClickedFavPoiLayer(item);
                return true;
            case 34:
                LogUtil.m15791e(TAG, "onMapItemClick: --> NE_Map_Layer_Type_MAP_UGC");
                getMapViewListener().onClickedUgcItem(item);
                return true;
            case 200:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_ITEM");
                return true;
            case MapParams$Const$LayerType.MAP_LAYER_TYPE_THROUGH_NODE /*1240*/:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_THROUGH_NODE");
                getMapViewListener().onClickedThroughNodeLayer(item, clickedX, clickedY);
                return true;
            case MapParams$Const$LayerType.MAP_LAYER_TYPE_ROUTE_UGC /*6016*/:
                LogUtil.m15791e(TAG, "onMapItemClick: --> MAP_LAYER_TYPE_ROUTE_UGC");
                getMapViewListener().onClickedRouteUgcItem(item);
                return true;
            default:
                return false;
        }
    }

    public boolean handlePopupClick(int x, int y) {
        return false;
    }

    private boolean handleItemsizedClick(int bclick, int x, int y) {
        return false;
    }

    public boolean getMapClickEnable() {
        return this.bMapclick;
    }

    public void setMapClickEnable(boolean b) {
        this.bMapclick = b;
    }

    public void setMapControlMode(MapControlMode mode) {
        this.mMapControlMode = mode;
    }

    public MapControlMode getMapControlMode() {
        return this.mMapControlMode;
    }

    public synchronized void setMapStatus(MapStatus mapStatus, AnimationType animationType) {
        setMapStatus(mapStatus, animationType, -1);
    }

    public synchronized void setMapStatus(MapStatus mapStatus, AnimationType animationType, int duration) {
        int i = 0;
        synchronized (this) {
            if (this.mBasemap != null) {
                this.mParamsBundle.clear();
                this.mParamsBundle.putDouble("level", (double) mapStatus._Level);
                this.mParamsBundle.putDouble(MapObjKey.OBJ_SS_ARROW_ROTATION, (double) mapStatus._Rotation);
                this.mParamsBundle.putDouble("overlooking", (double) mapStatus._Overlooking);
                this.mParamsBundle.putDouble("centerptx", (double) mapStatus._CenterPtX);
                this.mParamsBundle.putDouble("centerpty", (double) mapStatus._CenterPtY);
                this.mParamsBundle.putInt("left", mapStatus._WinRound.left);
                this.mParamsBundle.putInt("right", mapStatus._WinRound.right);
                this.mParamsBundle.putInt("top", mapStatus._WinRound.top);
                this.mParamsBundle.putInt("bottom", mapStatus._WinRound.bottom);
                this.mParamsBundle.putInt("lbx", mapStatus._GeoRound.lb.f19727x);
                this.mParamsBundle.putInt("lby", mapStatus._GeoRound.lb.f19728y);
                this.mParamsBundle.putInt("ltx", mapStatus._GeoRound.lt.f19727x);
                this.mParamsBundle.putInt("lty", mapStatus._GeoRound.lt.f19728y);
                this.mParamsBundle.putInt("rtx", mapStatus._GeoRound.rt.f19727x);
                this.mParamsBundle.putInt("rty", mapStatus._GeoRound.rt.f19728y);
                this.mParamsBundle.putInt("rbx", mapStatus._GeoRound.rb.f19727x);
                this.mParamsBundle.putInt("rby", mapStatus._GeoRound.rb.f19728y);
                this.mParamsBundle.putFloat("yoffset", (float) mapStatus._Yoffset);
                this.mParamsBundle.putFloat("xoffset", (float) mapStatus._Xoffset);
                this.mParamsBundle.putInt("animation", animationType.value());
                if (duration >= 0) {
                    this.mParamsBundle.putInt("animatime", duration);
                } else if (animationType.value() == AnimationType.eAnimationNone.value()) {
                    this.mParamsBundle.putInt("animatime", 0);
                } else {
                    this.mParamsBundle.putInt("animatime", 1000);
                }
                Bundle bundle = this.mParamsBundle;
                String str = "bfpp";
                if (mapStatus._bfpp) {
                    i = 1;
                }
                bundle.putInt(str, i);
                LogUtil.m15791e(TAG, "setMapStatus = " + this.mParamsBundle.toString());
                LogUtil.m15791e("mytestmParamsBundle", "result = " + this.mBasemap.SetMapStatus(this.mParamsBundle));
                LogUtil.m15791e("dingbbinpage", "level is " + mapStatus._Level);
            }
        }
    }

    public MapStatus getMapStatus() {
        return getMapStatus(true);
    }

    public MapStatus getMapStatus(boolean isEndStatus) {
        boolean z = true;
        if (this.mBasemap == null) {
            return null;
        }
        Bundle b = new Bundle();
        if (!this.mBasemap.GetMapStatus(b, isEndStatus)) {
            b = null;
        }
        MapStatus mapStatus = new MapStatus();
        if (b != null) {
            mapStatus._Level = (float) b.getDouble("level");
            mapStatus._Rotation = (int) b.getDouble(MapObjKey.OBJ_SS_ARROW_ROTATION);
            mapStatus._Overlooking = (int) b.getDouble("overlooking");
            mapStatus._CenterPtX = (int) b.getDouble("centerptx");
            mapStatus._CenterPtY = (int) b.getDouble("centerpty");
            mapStatus._WinRound.left = b.getInt("left");
            mapStatus._WinRound.right = b.getInt("right");
            mapStatus._WinRound.top = b.getInt("top");
            mapStatus._WinRound.bottom = b.getInt("bottom");
            mapStatus._GeoRound.left = b.getLong("gleft");
            mapStatus._GeoRound.right = b.getLong("gright");
            mapStatus._GeoRound.top = b.getLong("gtop");
            mapStatus._GeoRound.bottom = b.getLong("gbottom");
            mapStatus._GeoRound.lb.f19727x = b.getInt("lbx");
            mapStatus._GeoRound.lb.f19728y = b.getInt("lby");
            mapStatus._GeoRound.lt.f19727x = b.getInt("ltx");
            mapStatus._GeoRound.lt.f19728y = b.getInt("lty");
            mapStatus._GeoRound.rt.f19727x = b.getInt("rtx");
            mapStatus._GeoRound.rt.f19728y = b.getInt("rty");
            mapStatus._GeoRound.rb.f19727x = b.getInt("rbx");
            mapStatus._GeoRound.rb.f19728y = b.getInt("rby");
            mapStatus._Xoffset = (long) b.getFloat("xoffset");
            mapStatus._Yoffset = (long) b.getFloat("yoffset");
            if (b.getInt("bfpp") != 1) {
                z = false;
            }
            mapStatus._bfpp = z;
        }
        if (mapStatus._GeoRound.left <= -20037508) {
            mapStatus._GeoRound.left = -20037508;
        }
        if (mapStatus._GeoRound.right >= 20037508) {
            mapStatus._GeoRound.right = 20037508;
        }
        if (mapStatus._GeoRound.top >= 20037508) {
            mapStatus._GeoRound.top = 20037508;
        }
        if (mapStatus._GeoRound.bottom <= -20037508) {
            mapStatus._GeoRound.bottom = -20037508;
        }
        return mapStatus;
    }

    public boolean SetMinimapWinSize(int iWidth, int iHeight) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SetMinimapWinSize(iWidth, iHeight);
    }

    public void ResetGLHandleWhenCreateOrDestroyContext(boolean bIsMinimap) {
        if (this.mBasemap != null) {
            LogUtil.m15791e("MinimapTexture", "MapController ReleaseMinimap");
            this.mBasemap.ResetGLHandleWhenCreateOrDestroyContext(bIsMinimap);
        }
    }

    public int getZoomLevel() {
        if (this.mBasemap == null) {
            return 18;
        }
        return Math.round(this.mBasemap.GetZoomLevel());
    }

    public void zoomToFullView(Rect rect, boolean isVertical, int heightPixels, int widthPixels, boolean needAnimForFullview) {
        int i = 1;
        if (rect != null && this.mBasemap != null) {
            Bundle data = new Bundle();
            data.putLong("left", (long) rect.left);
            data.putLong("top", (long) rect.top);
            data.putLong("right", (long) rect.right);
            data.putLong("bottom", (long) rect.bottom);
            data.putInt("isVertical", isVertical ? 1 : 0);
            data.putInt("heightPixels", heightPixels);
            data.putInt("widthPixels", widthPixels);
            String str = "needAnimForFullview";
            if (!needAnimForFullview) {
                i = 0;
            }
            data.putInt(str, i);
            this.mBasemap.ZoomToFullView(data);
        }
    }

    public float getLevel() {
        if (this.mBasemap == null) {
            return 18.0f;
        }
        return this.mBasemap.GetZoomLevel();
    }

    public double getZoomUnitsInMeter() {
        if (this.mBasemap == null) {
            return 1.0d;
        }
        return Math.pow(2.0d, (double) (18.0f - this.mBasemap.GetZoomLevel()));
    }

    public boolean zoomIn() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.ZoomIn();
    }

    public boolean zoomOut() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.ZoomOut();
    }

    public boolean setLevel(int nLevel) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SetLevel((float) nLevel);
    }

    public boolean zoomToBound(Bundle bundle) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.ZoomToBound(bundle);
    }

    public boolean locate(int longitude, int latitude) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.Locate(longitude, latitude);
    }

    public boolean move(int srcX, int srcY, int desX, int desY) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.Move(srcX, srcY, desX, desY);
    }

    public void resetImageRes() {
        if (this.mBasemap != null) {
            this.mBasemap.ResetImageRes();
        }
    }

    public void showNaviSpecRouteLayer() {
        showLayer(10, false);
        showLayer(15, true);
        updateLayer(15);
        updateLayer(10);
        showLayer(13, true);
        updateLayer(13);
    }

    public void showNaviRouteLayer() {
        showLayer(13, false);
        showLayer(10, true);
        updateLayer(10);
        showLayer(15, true);
        updateLayer(15);
    }

    public boolean setStyleMode(int style) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SetStyleMode(style);
    }

    public int getStyleMode() {
        if (this.mBasemap == null) {
            return 1;
        }
        return this.mBasemap.getStyleMode();
    }

    public boolean setNightMode(boolean isNightMode) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setNightMode(isNightMode);
    }

    public boolean setSlightScreenStatus(int type) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setSlightScreenStatus(type);
    }

    public void setShowTrackMaxSpeed(boolean ifShowMaxSpeed) {
        if (this.mBasemap != null) {
            this.mBasemap.SetShowTrackMaxSpeed(ifShowMaxSpeed);
        }
    }

    public void setShowTrackOverSpeed(boolean ifShowOverSpeed) {
        if (this.mBasemap != null) {
            this.mBasemap.SetShowTrackOverSpeed(ifShowOverSpeed);
        }
    }

    public void setShowTrackRapidAcc(boolean ifShowRapidAcc) {
        if (this.mBasemap != null) {
            this.mBasemap.SetShowTrackRapidAcc(ifShowRapidAcc);
        }
    }

    public void setShowTrackBrake(boolean ifShowBrake) {
        if (this.mBasemap != null) {
            this.mBasemap.SetShowTrackBrake(ifShowBrake);
        }
    }

    public void setShowTrackCurve(boolean ifShowCurve) {
        if (this.mBasemap != null) {
            this.mBasemap.SetShowTrackCurve(ifShowCurve);
        }
    }

    public boolean showLayer(int layerType, boolean show) {
        LogUtil.m15791e(TAG, "showLayer: layerType --> " + layerType + ", show: " + show);
        if (this.mBasemap == null || !this.mBasemap.ShowLayer(layerType, show)) {
            return false;
        }
        switch (layerType) {
            case 13:
                if (!(this.mFocusItemIndex == -1 || show)) {
                    this.mFocusItemIndex = -1;
                    break;
                }
        }
        return true;
    }

    public boolean showLayerByID(int layerID, boolean show) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.ShowLayer(layerID, show);
    }

    public boolean updateLayer(int layerType) {
        if (this.mBasemap == null || !this.mBasemap.UpdateLayer(layerType)) {
            return false;
        }
        return true;
    }

    public boolean UpdataBaseLayers() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.UpdataBaseLayers();
    }

    public boolean clearLayer(int layerType) {
        if (this.mBasemap == null || !this.mBasemap.ClearLayer(layerType)) {
            return false;
        }
        switch (layerType) {
            case 13:
                this.mFocusItemIndex = -1;
                break;
        }
        return true;
    }

    public boolean saveScreen(String path) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SaveScreen(path);
    }

    public void addPopupData(Bundle bundle) {
        if (this.mBasemap != null) {
            this.mBasemap.AddPopupData(bundle);
        }
    }

    public void resetCompassPosition(int posX, int posY, int hideTime) {
        if (this.mBasemap != null) {
            this.mBasemap.ResetCompassPosition(posX, posY, hideTime);
        }
    }

    public void resetScalePosition(int posX, int posY) {
        if (this.mBasemap != null) {
            this.mBasemap.ResetScalePosition(posX, posY);
        }
    }

    public GeoPoint scrPtToGeoPoint(int inX, int inY) {
        if (this.mBasemap == null) {
            return null;
        }
        String strGeoPt = this.mBasemap.ScrPtToGeoPoint(inX, inY);
        GeoPoint geoPoint = new GeoPoint(0, 0);
        if (strGeoPt != null) {
            try {
                JSONObject jsonObj = new JSONObject(strGeoPt);
                geoPoint.setLongitudeE6(jsonObj.getInt("geox"));
                geoPoint.setLatitudeE6(jsonObj.getInt("geoy"));
                return geoPoint;
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public GeoPoint getGeoPosByScreenPos(int inX, int inY) {
        if (this.mBasemap == null) {
            return null;
        }
        int[] outX = new int[]{0};
        int[] outY = new int[]{0};
        if (this.mBasemap.GetGeoPosByScreenPos(inX, inY, outX, outY)) {
            return new GeoPoint(outX[0], outY[0]);
        }
        return null;
    }

    public Point getScreenPosByGeoPos(GeoPoint geoPoint) {
        if (this.mBasemap == null) {
            return null;
        }
        int[] outX = new int[]{0};
        int[] outY = new int[]{0};
        if (this.mBasemap.GetScreenPosByGeoPos(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6(), outX, outY)) {
            return new Point(outX[0], outY[0]);
        }
        return null;
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

    public int MapMsgProc(int imessage, int lwparam, int lparam) {
        if (this.mBasemap == null) {
            return 0;
        }
        try {
            return this.mBasemap.MapProc(imessage, lwparam, lparam, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d);
        } catch (Throwable th) {
            return 0;
        }
    }

    public int MapMsgProc(int imessage, int lwparam, int lparam, int scale, int angle, double centerX, double centerY, double offsetX, double offsetY) {
        if (this.mBasemap == null) {
            return 0;
        }
        try {
            return this.mBasemap.MapProc(imessage, lwparam, lparam, scale, angle, centerX, centerY, offsetX, offsetY);
        } catch (Throwable th) {
            return 0;
        }
    }

    private void mouseEvent(int x, int y, int type) {
        if (this.mBasemap != null) {
            this.mBasemap.MouseEvent(x, y, type);
        }
    }

    public void dragMap(int dx, int dy, int tx, int ty, long speed, long animationTime) {
        if (this.mBasemap != null) {
            this.mBasemap.DragMap(dx, dy, tx, ty, speed, animationTime);
        }
    }

    public void onPause() {
        if (this.mBasemap != null) {
            this.mBasemap.OnPause();
        }
    }

    public void onResume() {
        if (this.mBasemap != null) {
            this.mBasemap.OnResume();
        }
    }

    public void onPauseMinimapReq() {
        if (this.mBasemap != null) {
            this.mBasemap.OnPauseMinimapReq();
        }
    }

    public void onResumeMinimapReq() {
        if (this.mBasemap != null) {
            this.mBasemap.OnResumeMinimapReq();
        }
    }

    public void showTrafficMap(boolean bShow, boolean bUseLock) {
        if (this.mBasemap != null) {
            this.mBasemap.ShowTrafficMap(bShow, bUseLock);
        }
    }

    public void switchITSMode(boolean itsMode) {
        if (this.mBasemap != null) {
            this.mBasemap.SwitchITSMode(itsMode);
        }
    }

    public void SaveCache() {
        if (this.mBasemap != null) {
            this.mBasemap.SaveCache();
        }
    }

    public void StartMapDataRequest() {
        if (this.mBasemap != null) {
            this.mBasemap.StartMapDataRequest();
        }
    }

    public void StopMapDataRequest() {
        if (this.mBasemap != null) {
            this.mBasemap.StopMapDataRequest();
        }
    }

    public void glResize(int w, int h, int near, int far, int mid) {
        JNIBaseMap.GLResize(w, h, near, far, mid);
    }

    public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
        return false;
    }

    public boolean getScreenPosByGeoPos(int longitudeE6, int latitudeE6, int[] srcX, int[] srcY) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.GetScreenPosByGeoPos(longitudeE6, latitudeE6, srcX, srcY);
    }

    public MapItem selectItem(int scrX, int scrY, int radius) {
        if (this.mBasemap == null) {
            return null;
        }
        return (MapItem) this.mBasemap.SelectItem(scrX, scrY, radius);
    }

    public boolean saveScreenToBuffer() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SaveScreenToBuffer();
    }

    public boolean getScreenShot(int width, int height, int gap, Bitmap bmp) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.GetScreenShot(width, height, gap, bmp);
    }

    public boolean getScreenMask(int width, int height, int radius, int gap, boolean white, Bitmap mask) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.GetScreenMask(width, height, radius, gap, white, mask);
    }

    public boolean setDrawHouse(boolean bDrawHouse, boolean bUseLock) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SetDrawHouse(bDrawHouse, bUseLock);
    }

    public boolean setCharsetEncodeType(boolean encodeTypeExisted) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SetCharsetEncodeType(encodeTypeExisted);
    }

    public boolean focusItem(int layerType, int itemId, boolean bFocus) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.FocusItem(layerType, itemId, bFocus);
    }

    public boolean setAnimationGlobalSwitch(boolean needAnimation) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.SetAnimationGlobalSwitch(needAnimation);
    }

    public int AddLayer(int eUpdateType, int ulTimerEscap, String strTag) {
        if (this.mBasemap == null) {
            return -1;
        }
        return this.mBasemap.AddLayer(eUpdateType, ulTimerEscap, strTag);
    }

    public int RemoveLayer(int iLayerID) {
        if (this.mBasemap == null) {
            return -1;
        }
        return this.mBasemap.RemoveLayer(iLayerID);
    }

    public void AddItemData(Bundle bundle) {
        if (this.mBasemap != null) {
            LogUtil.m15791e("luoluo--->", "AddItemData :" + bundle.getInt("bshow"));
            this.mBasemap.AddItemData(bundle);
        }
    }

    public boolean RemoveItemData(Bundle bundle) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.RemoveItemData(bundle);
    }

    public boolean releaseSharedMapData() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.ReleaseSharedMapData(0, 0);
    }

    public boolean updateShareMapData() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.UpdateShareMapData(0, 0);
    }

    public boolean zoomToTrajectory() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.ZoomToTrajectory();
    }

    public void setDrawNaviLogo(boolean bDrawNaviLogo) {
        if (this.mBasemap != null) {
            try {
                this.mBasemap.SetDrawNaviLogo(bDrawNaviLogo);
            } catch (Throwable th) {
            }
        }
    }

    public void updateChosenMultiRouteID(int selectMultiRouteId) {
        if (this.mBasemap != null) {
            this.mBasemap.UpdateChosenMultiRouteID(selectMultiRouteId);
        }
    }

    public float GetZoomToBound(Bundle bundle, float width, float height) {
        if (this.mBasemap == null) {
            return -1.0f;
        }
        return this.mBasemap.GetZoomToBound(bundle, width, height);
    }

    public void setEnlargedStatus(boolean bEnlargedStatus) {
        if (this.mBasemap != null) {
            this.mBasemap.SetEnlargedStatus(bEnlargedStatus);
        }
    }

    public void setMemoryScale(int memoryScale) {
        if (this.mBasemap != null) {
            this.mBasemap.SetMemoryScale(memoryScale);
        }
    }

    public void setMapDrawScreenRect(Rect rect) {
        if (rect != null && this.mBasemap != null) {
            Bundle data = new Bundle();
            data.putLong("left", (long) rect.left);
            data.putLong("top", (long) rect.top);
            data.putLong("right", (long) rect.right);
            data.putLong("bottom", (long) rect.bottom);
            this.mBasemap.setMapDrawScreenRect(data);
        }
    }

    public void setMapShowScreenRect(Rect rect) {
        if (rect != null && this.mBasemap != null) {
            Bundle data = new Bundle();
            data.putLong("left", (long) rect.left);
            data.putLong("top", (long) rect.top);
            data.putLong("right", (long) rect.right);
            data.putLong("bottom", (long) rect.bottom);
            this.mBasemap.setMapShowScreenRect(data);
        }
    }

    public void setTranslucentHeight(int dpContentOffset) {
        if (this.mBasemap != null) {
            this.mBasemap.setTranslucentHeight(dpContentOffset);
        }
    }

    public void zoomToSlightNaviFullView(Bundle bundle, boolean flag) {
        if (this.mBasemap != null) {
            this.mBasemap.zoomToSlightNaviFullView(bundle, flag);
        }
    }

    public boolean setScreenShotParam(int type, int width, int height, long longtitude, long latitude, int inScale) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setScreenShotParam(type, width, height, longtitude, latitude, inScale);
    }

    public boolean getScreenShotImage(Bundle bundle) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.getScreenShotImage(bundle);
    }

    public boolean handleDoubleTapEvent(MotionEvent event) {
        if (this.mDoubleTapController == null) {
            this.mDoubleTapController = new DoubleTapController(this);
        }
        this.mDoubleTapController.onDoubleTapEvent(event);
        return true;
    }

    public void setNaviStatus(boolean flag) {
        if (this.mBasemap != null) {
            this.mBasemap.setNaviStatus(flag);
        }
    }

    public void setAutoLevel(boolean enable) {
        if (this.mBasemap != null) {
            this.mBasemap.setAutoLevelEnable(enable);
        }
    }

    public void SetInterruptAutoLevel(boolean interrupt) {
        if (this.mBasemap != null) {
            this.mBasemap.SetIfInterruptAutoLevel(interrupt);
        }
    }

    public void setClientBoardLength(int len) {
        if (this.mBasemap != null) {
            this.mBasemap.setClientBoardLength(len);
        }
    }

    public void setHighLightRoute(int type, int routeIdx) {
        if (this.mBasemap != null) {
            this.mBasemap.setHighLightRoute(type, routeIdx);
        }
    }

    public void setCarImageToMap(int width, int height, int bits, byte[] imageBytes) {
        if (this.mBasemap != null) {
            this.mBasemap.setCarImageToMap(width, height, bits, imageBytes, imageBytes.length);
        }
    }

    public void clearCarImage() {
        if (this.mBasemap != null) {
            this.mBasemap.clearCarImage();
        }
    }

    public void sendCommandToMapEngine(int commandType, Bundle commandParam) {
        if (this.mBasemap != null) {
            this.mBasemap.sendCommandToMapEngine(commandType, commandParam);
        }
    }

    public void mapClickEvent(int eventType) {
        if (this.mBasemap != null) {
            this.mBasemap.mapClickEvent(eventType);
        }
    }

    public boolean setNaviMapMode(int mapMode) {
        if (this.mBasemap == null) {
            return false;
        }
        LogUtil.m15791e(TAG, "setNaviMapMode: mapMode --> " + mapMode);
        boolean ret = this.mBasemap.setNaviMapMode(mapMode);
        LogUtil.m15791e(TAG, "setNaviMapMode: mapMode end--> ");
        return ret;
    }

    public boolean setPreRoutePlanStatus(boolean bPreRoutePlanStatus) {
        if (this.mBasemap == null) {
            return false;
        }
        LogUtil.m15791e(TAG, "setPreRoutePlanStatus: bPreRoutePlanStatus --> " + bPreRoutePlanStatus);
        return this.mBasemap.SetPreRoutePlanStatus(bPreRoutePlanStatus);
    }

    public boolean setDragMapStatus(boolean flag) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setDragMapStatus(flag);
    }

    public void createMiniMapControl() {
        if (this.mBasemap != null) {
            LogUtil.m15791e(TAG, "createMiniMapControl: --> ");
            this.mBasemap.createMiniMapControl();
        }
    }

    public void destroyMiniMapControl() {
        if (this.mBasemap != null) {
            LogUtil.m15791e(TAG, "destroyMiniMapControl: --> ");
            this.mBasemap.destroyMiniMapControl();
        }
    }

    public boolean preNextRouteDetail(boolean bPre) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.preNextRouteDetail(bPre);
    }

    public boolean setRouteDetailIndex(int index) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setRouteDetailIndex(index);
    }

    public boolean resetRouteDetailIndex(boolean bAnimation) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.resetRouteDetailIndex(bAnimation);
    }

    public boolean allViewSerialAnimation() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.allViewSerialAnimation();
    }

    public boolean setScreenShow(Bundle bundleParams) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setScreenShow(bundleParams);
    }

    public boolean setNaviCarPos() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setNaviCarPos();
    }

    public boolean stopAllAnimation() {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.stopAllAnimation();
    }

    public boolean setRedLineRender(boolean isShow) {
        if (this.mBasemap == null) {
            return false;
        }
        return this.mBasemap.setRedLineRender(isShow);
    }
}
