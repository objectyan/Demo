package com.baidu.navisdk.comapi.mapcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.gesture.opt.ZoomRotateOpt;
import com.baidu.platform.comapi.map.provider.CarRouteProvider;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.baidu.platform.comapi.util.C4820d;
import java.util.List;

public class BNMapController extends BNLogicController {
    public static final int[] ITS_CITY_ID = new int[]{NaviFragmentManager.TYPE_CAR_DRV_LIST, 289, 257, 340, C4820d.f19955a, CommonHandlerThread.MSG_START_RECORD_TRAJECTORY, 58, 53, 236, 178, CarRouteProvider.THROUGH_NODE_STYLE, 333, 138, 187, 104, 261, C1253f.dE, NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_NEWER, BNOfflineDataObserver.EVENT_UPDATE_MERGE_START, 179, 167, CarRouteProvider.WALK_START_STYLE, 92, 75, NaviFragmentManager.TYPE_CAR_DRV_SETTING, 315, RouteLineResConst.LINE_ARR_RED_FOCUS, 317, 348, 218, RouteLineResConst.LINE_ARR_DARK_RED_NORMAL, 300, RouteLineResConst.LINE_INTERNAL_NORMAL, 134, 119, 140, 48, 176};
    private static final String TAG = BNMapController.class.getSimpleName();
    private static volatile BNMapController me = new BNMapController();
    private boolean isDoubleClick = false;
    private MsgHandler mHandler = new BNMapController$1(this, Looper.getMainLooper());
    private int mLayerMode;
    private MapController mMapController;

    public BNMapController() {
        VMsgDispatcher.registerMsgHandler(this.mHandler);
    }

    public static BNMapController getInstance() {
        if (me == null) {
            synchronized (BNMapController.class) {
                if (me == null) {
                    me = new BNMapController();
                }
            }
        }
        return me;
    }

    public void initMapController(Context context, Bundle initParams) {
        if (this.mMapController == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("right", initParams.getInt(BNMapController$BNMapConfigParams.KEY_SCREEN_WIDTH));
            bundle.putInt("bottom", initParams.getInt(BNMapController$BNMapConfigParams.KEY_SCREEN_HEIGHT));
            this.mMapController = new MapController(context);
            this.mMapController.initBaseMap(bundle);
            this.mMapController.setMapViewListener(new BNMapController$NavMapViewListener(this));
            this.mMapController.setDrawNaviLogo(false);
        }
    }

    public void unInitMapController() {
        if (this.mMapController != null) {
            this.mMapController.unInit();
            this.mMapController = null;
        }
    }

    public void onMapAnimationFinish() {
        if (this.mMapController != null) {
            this.mMapController.onMapAnimationFinish();
        }
    }

    public static void destory() {
        if (me != null) {
            synchronized (BNMapController.class) {
                if (me != null) {
                    me.dispose();
                }
            }
        }
        me = null;
    }

    private void dispose() {
        if (this.mMapController != null) {
            this.mMapController.unInit();
            this.mMapController = null;
        }
        unInitMapController();
    }

    public MapController getMapController() {
        return this.mMapController;
    }

    public void notifyMapObservers(int type, int event, Object arg) {
        notifyObservers(type, event, arg);
        if (ZoomRotateOpt.isRotateOpt && event == 520) {
            UserOPController.getInstance().addMapOP(type, 521);
        } else {
            UserOPController.getInstance().addMapOP(type, event);
        }
    }

    public void setMapStatus(MapStatus st, AnimationType animationType) {
        if (this.mMapController != null) {
            this.mMapController.setMapStatus(st, animationType);
        }
    }

    public void setMapStatus(MapStatus st, AnimationType animationType, int duration) {
        if (this.mMapController != null) {
            this.mMapController.setMapStatus(st, animationType, duration);
        }
    }

    public MapStatus getMapStatus() {
        if (this.mMapController != null) {
            return this.mMapController.getMapStatus();
        }
        return null;
    }

    public MapStatus getMapStatus(boolean isEndstatus) {
        if (this.mMapController != null) {
            return this.mMapController.getMapStatus(isEndstatus);
        }
        return null;
    }

    public boolean SetMinimapWinSize(int iWidth, int iHeight) {
        if (this.mMapController != null) {
            return this.mMapController.SetMinimapWinSize(iWidth, iHeight);
        }
        return false;
    }

    public void ResetGLHandleWhenCreateOrDestroyContext(boolean bIsMinimap) {
        if (this.mMapController != null) {
            LogUtil.e("MinimapTexture", "BNMapController ReleaseMinimap");
            this.mMapController.ResetGLHandleWhenCreateOrDestroyContext(bIsMinimap);
            return;
        }
        LogUtil.e("MinimapTexture", "BNMapController ReleaseMinimap mMapController == null");
    }

    public int getZoomLevel() {
        if (this.mMapController != null) {
            return this.mMapController.getZoomLevel();
        }
        return 18;
    }

    public void zoomToFullView(Rect rect, boolean isVertical, int heightPixels, int widthPixels, boolean needAnimForFullview) {
        if (this.mMapController != null) {
            this.mMapController.zoomToFullView(rect, isVertical, heightPixels, widthPixels, needAnimForFullview);
        }
    }

    public double getZoomUnitsInMeter() {
        if (this.mMapController != null) {
            return this.mMapController.getZoomUnitsInMeter();
        }
        return 1.0d;
    }

    @Deprecated
    public void setLevel(float level) {
        MapStatus st = getMapStatus();
        if (st != null) {
            st._Level = level;
            setMapStatus(st, AnimationType.eAnimationLevel);
        }
    }

    public boolean zoomIn() {
        if (this.mMapController == null) {
            return false;
        }
        BNStatisticsManager.getInstance().onMapScaleSet(Math.min(this.mMapController.getZoomLevel() + 1, 20));
        return this.mMapController.zoomIn();
    }

    public boolean zoomOut() {
        if (this.mMapController == null) {
            return false;
        }
        BNStatisticsManager.getInstance().onMapScaleSet(Math.max(this.mMapController.getZoomLevel() - 1, 3));
        return this.mMapController.zoomOut();
    }

    public boolean updateLayer(int layerType) {
        if (this.mMapController == null) {
            return false;
        }
        this.mMapController.updateLayer(layerType);
        return true;
    }

    public boolean UpdataBaseLayers() {
        if (this.mMapController == null) {
            return false;
        }
        this.mMapController.UpdataBaseLayers();
        return true;
    }

    public boolean clearLayer(int layerType) {
        if (this.mMapController == null) {
            return false;
        }
        this.mMapController.clearLayer(layerType);
        return true;
    }

    public void resizeScreen(int width, int height) {
        if (this.mMapController != null) {
            this.mMapController.resizeSecreen(width, height);
        }
        notifyMapObservers(1, 256, null);
    }

    public int getScreenWidth() {
        if (this.mMapController != null) {
            return this.mMapController.getScreenWidth();
        }
        return 0;
    }

    public int getScreenHeight() {
        if (this.mMapController != null) {
            return this.mMapController.getScreenHeight();
        }
        return 0;
    }

    public void resetCompassPosition(int posX, int posY, int hideTime) {
        if (this.mMapController != null) {
            this.mMapController.resetCompassPosition(posX, posY, hideTime);
        }
    }

    public void resetScalePosition(int posX, int posY) {
        if (this.mMapController != null) {
            this.mMapController.resetScalePosition(posX, posY);
        }
    }

    public void onResume() {
        if (this.mMapController != null) {
            this.mMapController.onResume();
        }
    }

    public void onPause() {
        if (this.mMapController != null) {
            this.mMapController.onPause();
        }
    }

    public void onResumeMinimapReq() {
        if (this.mMapController != null) {
            this.mMapController.onResumeMinimapReq();
        }
    }

    public void onPauseMinimapReq() {
        if (this.mMapController != null) {
            this.mMapController.onPauseMinimapReq();
        }
    }

    public void showTrafficMap(boolean bShow) {
        if (this.mMapController != null) {
            this.mMapController.showTrafficMap(bShow, true);
        }
    }

    public void showTrafficMap(boolean bShow, boolean bUseLock) {
        if (this.mMapController != null) {
            this.mMapController.showTrafficMap(bShow, bUseLock);
        }
    }

    public void switchITSMode(boolean itsMode) {
        if (this.mMapController != null) {
            this.mMapController.switchITSMode(itsMode);
        }
    }

    public void SaveCache() {
        if (this.mMapController != null) {
            this.mMapController.SaveCache();
        }
    }

    public void StartMapDataRequest() {
        if (this.mMapController != null) {
            this.mMapController.StartMapDataRequest();
        }
    }

    public void StopMapDataRequest() {
        if (this.mMapController != null) {
            this.mMapController.StopMapDataRequest();
        }
    }

    public GeoPoint getGeoPosByScreenPos(int inX, int inY) {
        if (this.mMapController != null) {
            return this.mMapController.getGeoPosByScreenPos(inX, inY);
        }
        return null;
    }

    public Point getScreenPosByGeoPos(GeoPoint geoPoint) {
        if (this.mMapController != null) {
            return this.mMapController.getScreenPosByGeoPos(geoPoint);
        }
        return null;
    }

    public boolean saveScreen(String path) {
        return this.mMapController.saveScreen(path);
    }

    public void ResetImageRes() {
        if (this.mMapController != null) {
            this.mMapController.resetImageRes();
        }
    }

    public MapItem getMapItemByGeoPos(int longitudeE6, int latitudeE6, int radius) {
        if (this.mMapController != null) {
            int[] srcX = new int[1];
            int[] srcY = new int[1];
            if (this.mMapController.getScreenPosByGeoPos(longitudeE6, latitudeE6, srcX, srcY)) {
                return this.mMapController.selectItem(srcX[0], srcY[0], radius);
            }
        }
        return null;
    }

    public boolean saveScreenToBuffer() {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.saveScreenToBuffer();
    }

    public boolean getScreenShot(int width, int height, int gap, Bitmap bmp) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.getScreenShot(width, height, gap, bmp);
    }

    public boolean getScreenMask(int width, int height, int radius, int gap, boolean white, Bitmap mask) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.getScreenMask(width, height, radius, gap, white, mask);
    }

    public boolean setDrawHouse(boolean bDrawHouse) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setDrawHouse(bDrawHouse, true);
    }

    public boolean setDrawHouse(boolean bDrawHouse, boolean bUseLock) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setDrawHouse(bDrawHouse, bUseLock);
    }

    public boolean setCharsetEncodeType(boolean encodeTypeExisted) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setCharsetEncodeType(encodeTypeExisted);
    }

    public int getLayerMode() {
        return this.mLayerMode;
    }

    public void setLayerMode(int mode) {
        if (this.mMapController != null) {
            this.mLayerMode = mode;
            MapController mapController;
            boolean z;
            switch (mode) {
                case 0:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, true);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 1:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, true);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 2:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, true);
                    this.mMapController.updateLayer(3);
                    this.mMapController.showLayer(4, true);
                    this.mMapController.updateLayer(4);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.showLayer(14, true);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 3:
                    this.mMapController.showLayer(9, true);
                    this.mMapController.updateLayer(9);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, true);
                    this.mMapController.updateLayer(10);
                    this.mMapController.showLayer(8, true);
                    this.mMapController.showLayer(15, true);
                    this.mMapController.updateLayer(8);
                    this.mMapController.showLayer(14, false);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    this.mMapController.showLayer(31, BNSettingManager.getUgcShow());
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    this.mMapController.showLayer(24, true);
                    this.mMapController.showLayer(25, true);
                    this.mMapController.showLayer(26, true);
                    this.mMapController.showLayer(27, true);
                    break;
                case 4:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, true);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, true);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 5:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, true);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, false);
                    this.mMapController.showLayer(13, true);
                    this.mMapController.updateLayer(13);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, true);
                    this.mMapController.showLayer(17, true);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 6:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, true);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, false);
                    this.mMapController.showLayer(13, true);
                    this.mMapController.updateLayer(13);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, true);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 7:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.updateLayer(8);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, false);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, true);
                    this.mMapController.updateLayer(20);
                    break;
                case 8:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.updateLayer(8);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, false);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, false);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.showLayer(19, true);
                    this.mMapController.updateLayer(19);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 9:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, true);
                    this.mMapController.updateLayer(8);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, false);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.updateLayer(13);
                    this.mMapController.showLayer(16, false);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 10:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, true);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 11:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, true);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, false);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, true);
                    this.mMapController.showLayer(33, false);
                    this.mMapController.showLayer(20, false);
                    break;
                case 12:
                    this.mMapController.showLayer(9, false);
                    this.mMapController.showLayer(3, false);
                    this.mMapController.showLayer(4, false);
                    this.mMapController.showLayer(10, false);
                    this.mMapController.showLayer(8, false);
                    this.mMapController.showLayer(15, false);
                    this.mMapController.showLayer(14, true);
                    this.mMapController.showLayer(13, false);
                    this.mMapController.showLayer(16, true);
                    this.mMapController.showLayer(11, true);
                    this.mMapController.showLayer(17, false);
                    this.mMapController.updateLayer(17);
                    this.mMapController.showLayer(19, false);
                    mapController = this.mMapController;
                    if (BNSettingManager.getUgcShow()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mapController.showLayer(31, z);
                    this.mMapController.showLayer(32, false);
                    this.mMapController.showLayer(33, true);
                    this.mMapController.showLayer(20, false);
                    break;
            }
            this.mMapController.showLayer(27, true);
            this.mMapController.showLayer(34, true);
        }
    }

    public boolean focusItem(int layerType, int itemId, boolean bFocus) {
        if (this.mMapController != null) {
            return this.mMapController.focusItem(layerType, itemId, bFocus);
        }
        return false;
    }

    public boolean setAnimationGlobalSwitch(boolean needAnimation) {
        if (this.mMapController != null) {
            return this.mMapController.setAnimationGlobalSwitch(needAnimation);
        }
        return false;
    }

    public boolean setNightMode(boolean isNightMode) {
        if (this.mMapController != null) {
            return this.mMapController.setNightMode(isNightMode);
        }
        return false;
    }

    public boolean setSlightScreenStatus(int type) {
        if (this.mMapController != null) {
            return this.mMapController.setSlightScreenStatus(type);
        }
        return false;
    }

    public void setShowTrackMaxSpeed(boolean ifShowMaxSpeed) {
        if (this.mMapController != null) {
            this.mMapController.setShowTrackMaxSpeed(ifShowMaxSpeed);
            updateLayer(19);
        }
    }

    public void setShowTrackCurve(boolean ifShowCurve) {
        if (this.mMapController != null) {
            this.mMapController.setShowTrackCurve(ifShowCurve);
            updateLayer(19);
        }
    }

    public void setShowTrackOverSpeed(boolean ifShowOverSpeed) {
        if (this.mMapController != null) {
            this.mMapController.setShowTrackOverSpeed(ifShowOverSpeed);
            updateLayer(19);
        }
    }

    public void setShowTrackRapidAcc(boolean ifShowRapidAcc) {
        if (this.mMapController != null) {
            this.mMapController.setShowTrackRapidAcc(ifShowRapidAcc);
            updateLayer(19);
        }
    }

    public void setShowTrackBrake(boolean ifShowBrake) {
        if (this.mMapController != null) {
            this.mMapController.setShowTrackBrake(ifShowBrake);
            updateLayer(19);
        }
    }

    public boolean checkRoadConditionSupport(int cityId) {
        return true;
    }

    public void enableTouchEventLookover(boolean b) {
        if (this.mMapController != null) {
            this.mMapController.enableTouchEventLookover(b);
        }
    }

    public boolean showLayer(int layerType, boolean show) {
        if (this.mMapController == null) {
            return false;
        }
        LogUtil.e("RGUgcRoadModel", "ugcpopup  showLayer  show: " + show + "   layerType " + layerType);
        return this.mMapController.showLayer(layerType, show);
    }

    public void showCarResultLayer(boolean show) {
        if (this.mMapController != null) {
            LogUtil.e("CarResult", "showCarResultLayer  show: " + show);
            this.mMapController.showLayer(10, show);
            if (!show) {
                this.mMapController.clearLayer(10);
            }
            this.mMapController.updateLayer(10);
            this.mMapController.showLayer(8, show);
            if (!show) {
                this.mMapController.clearLayer(8);
            }
            this.mMapController.updateLayer(8);
            this.mMapController.showLayer(27, show);
            if (!show) {
                this.mMapController.clearLayer(27);
            }
            this.mMapController.updateLayer(27);
        }
    }

    public boolean releaseSharedMapData() {
        if (this.mMapController != null) {
            return this.mMapController.releaseSharedMapData();
        }
        return false;
    }

    public boolean updateShareMapData() {
        if (this.mMapController != null) {
            return this.mMapController.updateShareMapData();
        }
        return false;
    }

    public boolean zoomToTrajectory() {
        if (this.mMapController != null) {
            return this.mMapController.zoomToTrajectory();
        }
        return false;
    }

    public void setDrawNaviLogo(boolean bDrawNaviLogo) {
        LogUtil.e(TAG, "setDrawNaviLogo mMapController=" + this.mMapController + " bDrawNaviLogo=" + bDrawNaviLogo);
        if (this.mMapController != null) {
            this.mMapController.setDrawNaviLogo(bDrawNaviLogo);
        }
    }

    public void updateChosenMultiRouteID(int selectMultiRouteId) {
        if (this.mMapController != null) {
            this.mMapController.updateChosenMultiRouteID(selectMultiRouteId);
        }
    }

    public boolean zoomToBound(Bundle bundle) {
        if (this.mMapController != null) {
            return this.mMapController.zoomToBound(bundle);
        }
        return false;
    }

    public void injectRenderMsg() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(MsgDefine.MSG_MAP_GLRENDER);
        }
    }

    public float GetZoomToBound(Bundle bundle, float width, float height) {
        if (this.mMapController != null) {
            return this.mMapController.GetZoomToBound(bundle, width, height);
        }
        return 0.0f;
    }

    public void setEnlargedStatus(boolean bEnlargedStatus) {
        if (this.mMapController != null) {
            this.mMapController.setEnlargedStatus(bEnlargedStatus);
        }
    }

    public void setMemoryScale(int memoryScale) {
        if (this.mMapController != null) {
            this.mMapController.setMemoryScale(memoryScale);
        }
    }

    public void setMapDrawScreenRect(Rect rect) {
        if (this.mMapController != null) {
            this.mMapController.setMapDrawScreenRect(rect);
        }
    }

    public void setTranslucentHeight(int dpContentOffset) {
        if (this.mMapController != null) {
            this.mMapController.setTranslucentHeight(dpContentOffset);
        }
    }

    public void updateMapView(List<SearchPoi> searchPois, Rect rect, boolean isVertical) {
        updateMapView(searchPois, rect, isVertical, AnimationType.eAnimationNone, -1);
    }

    public void updateMapView(List<SearchPoi> searchPois, Rect rect, boolean isVertical, AnimationType animationType, int duration) {
        float offsetY;
        float offsetX;
        LogUtil.e(TAG, "updateMapView searchPois size :" + searchPois.size());
        int left = Integer.MAX_VALUE;
        int right = 0;
        int bottom = Integer.MAX_VALUE;
        int top = 0;
        for (int i = 0; i < searchPois.size(); i++) {
            SearchPoi poi = (SearchPoi) searchPois.get(i);
            if (!(poi == null || poi.mViewPoint == null)) {
                if (left > poi.mViewPoint.getLongitudeE6()) {
                    left = poi.mViewPoint.getLongitudeE6();
                }
                if (right < poi.mViewPoint.getLongitudeE6()) {
                    right = poi.mViewPoint.getLongitudeE6();
                }
                if (top < poi.mViewPoint.getLatitudeE6()) {
                    top = poi.mViewPoint.getLatitudeE6();
                }
                if (bottom > poi.mViewPoint.getLatitudeE6()) {
                    bottom = poi.mViewPoint.getLatitudeE6();
                }
            }
        }
        Bundle bundleRB = CoordinateTransformUtil.LLE62MC(right, bottom);
        Bundle bundleLT = CoordinateTransformUtil.LLE62MC(left, top);
        int mcRight = bundleRB.getInt("MCx");
        int mcBottom = bundleRB.getInt("MCy");
        int mcLeft = bundleLT.getInt("MCx");
        int mcTop = bundleLT.getInt("MCy");
        Bundle bundle = new Bundle();
        bundle.putLong("left", (long) mcLeft);
        bundle.putLong("right", (long) mcRight);
        bundle.putLong("top", (long) mcTop);
        bundle.putLong("bottom", (long) mcBottom);
        float level = GetZoomToBound(bundle, (float) (rect.right - rect.left), (float) (rect.top - rect.bottom)) - 0.35f;
        float centerX = (float) ((mcRight + mcLeft) / 2);
        float centerY = (float) ((mcTop + mcBottom) / 2);
        if (isVertical) {
            offsetY = (float) (((rect.top + rect.bottom) - ScreenUtil.getInstance().getHeightPixels()) / 2);
            offsetX = (float) (((rect.right + rect.left) - ScreenUtil.getInstance().getWidthPixels()) / 2);
        } else {
            offsetY = (float) (((rect.top + rect.bottom) - ScreenUtil.getInstance().getWidthPixels()) / 2);
            offsetX = (float) (((rect.right + rect.left) - ScreenUtil.getInstance().getHeightPixels()) / 2);
        }
        MapStatus st = getMapStatus();
        if (st == null) {
            LogUtil.e(TAG, "updateMapView fail st is null");
            return;
        }
        st._Yoffset = (long) offsetY;
        st._Xoffset = (long) offsetX;
        st._CenterPtX = (int) centerX;
        st._CenterPtY = (int) centerY;
        st._Level = level;
        st._Rotation = 1;
        st._Overlooking = 0;
        setMapStatus(st, animationType, duration);
    }

    public void zoomToSlightNaviFullView(Bundle bundle, boolean flag) {
        if (this.mMapController != null) {
            this.mMapController.zoomToSlightNaviFullView(bundle, flag);
        }
    }

    public boolean setScreenShotParam(int type, int width, int height, long longtitude, long latitude, int inScale) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setScreenShotParam(type, width, height, longtitude, latitude, inScale);
    }

    public boolean getScreenShotImage(Bundle bundle) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.getScreenShotImage(bundle);
    }

    public boolean handleDoubleTouch(Object event) {
        if (this.mMapController != null) {
            BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_DOUBLECLICK);
            if (event != null) {
                this.mMapController.handleDoubleTouch((MotionEvent) event);
            }
            getInstance().notifyMapObservers(2, 513, null);
        }
        return true;
    }

    public boolean handleSingleTouch(Object event) {
        if (this.mMapController != null) {
            BNStatisticsManager.getInstance().onGestureEvent("dd");
            if (event != null) {
                this.mMapController.handleClickBackground((MotionEvent) event);
            }
            getInstance().notifyMapObservers(2, 514, event);
        }
        return true;
    }

    public boolean onMapItemClick(String jsonStr, int clickedX, int clickedY) {
        if (this.mMapController != null) {
            return this.mMapController.onMapItemClick(jsonStr, clickedX, clickedY);
        }
        return false;
    }

    public void setNaviStatus(boolean flag) {
        if (this.mMapController != null) {
            this.mMapController.setNaviStatus(flag);
        }
    }

    public void setMapShowScreenRect() {
        if (this.mMapController != null) {
            int left;
            int top;
            int right;
            int bottom;
            boolean isEnlargeShow = RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing();
            if (1 == RGCacheStatus.sOrientation) {
                left = 0;
                if (isEnlargeShow) {
                    top = ScreenUtil.getInstance().getHeightPixels() / 2;
                } else if (RGViewController.getInstance().isHighwayMiniPanelShowing()) {
                    top = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_top_guide_mini_height);
                } else {
                    top = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_top_panel_height);
                }
                right = ScreenUtil.getInstance().getWidthPixels();
                bottom = ScreenUtil.getInstance().getHeightPixels() - JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_bottom_panel_height);
            } else {
                if (isEnlargeShow) {
                    left = ScreenUtil.getInstance().getHeightPixels() / 2;
                } else {
                    left = ScreenUtil.getInstance().getHeightPixels() / 4;
                }
                top = 0;
                right = ScreenUtil.getInstance().getHeightPixels();
                bottom = ScreenUtil.getInstance().getWidthPixels() - JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_bottom_panel_height);
            }
            LogUtil.e(TAG, "setMapShowScreenRect left:" + left + " top:" + top + " right" + right + "bottom:" + bottom);
            this.mMapController.setMapShowScreenRect(new Rect(left, top, right, bottom));
        }
    }

    public void setHighLightAvoidTrafficRoute(int routeIdx) {
        if (this.mMapController != null) {
            this.mMapController.setHighLightRoute(2, routeIdx);
            getInstance().showLayer(17, false);
            getInstance().updateLayer(10);
            getInstance().showLayer(10, true);
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_a, JNIGuidanceControl.getInstance().getSelectRouteIdx() + "", routeIdx + "", "2");
        }
    }

    public void setHighLightRoute(int routeIdx) {
        if (this.mMapController != null) {
            this.mMapController.setHighLightRoute(1, routeIdx);
            getInstance().showLayer(17, false);
            getInstance().updateLayer(10);
            getInstance().showLayer(10, true);
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_a, JNIGuidanceControl.getInstance().getSelectRouteIdx() + "", routeIdx + "", "1");
        }
    }

    public void setHighLightRoute(int type, int routeIdx) {
        if (this.mMapController != null) {
            this.mMapController.setHighLightRoute(type, routeIdx);
        }
    }

    public void recoveryHighLightRoute() {
        if (this.mMapController != null) {
            this.mMapController.setHighLightRoute(0, 0);
            getInstance().showLayer(17, false);
            getInstance().updateLayer(10);
            getInstance().showLayer(10, true);
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_b, JNIGuidanceControl.getInstance().getSelectRouteIdx() + "", null, null);
        }
    }

    public void sendCommandToMapEngine(int commandType, Bundle commandParam) {
        if (this.mMapController != null) {
            this.mMapController.sendCommandToMapEngine(commandType, commandParam);
        }
    }

    public void mapClickEvent(int eventType) {
        if (this.mMapController != null) {
            this.mMapController.mapClickEvent(eventType);
        }
    }

    public boolean setDragMapStatus(boolean flag) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setDragMapStatus(flag);
    }

    public boolean setNaviMapMode(int mapMode) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setNaviMapMode(mapMode);
    }

    public boolean setPreRoutePlanStatus(boolean bPreRoutePlanStatus) {
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setPreRoutePlanStatus(bPreRoutePlanStatus);
    }

    public void createMiniMapControl() {
        if (this.mMapController != null) {
            this.mMapController.createMiniMapControl();
        }
    }

    public void destroyMiniMapControl() {
        if (this.mMapController != null) {
            this.mMapController.destroyMiniMapControl();
        }
    }

    public void setRedLineRender(boolean isShow) {
        if (this.mMapController != null) {
            this.mMapController.setRedLineRender(isShow);
        }
    }

    public void initCarAndMapPosition(boolean isForce2D) {
        if (!isForce2D) {
            GeoPoint carPt = RGEngineControl.getInstance().getCarGeoPoint();
            MapStatus st = NMapControlProxy.getInstance().getMapStatus();
            if (st != null && carPt != null) {
                boolean is3DState;
                if (isForce2D) {
                    is3DState = false;
                } else {
                    is3DState = BNSettingManager.getMapMode() == 1;
                }
                if (is3DState) {
                    Bundle bundle = new Bundle();
                    BNRouteGuider.getInstance().getVehicleInfo(bundle);
                    if (bundle.containsKey("vehicle_angle")) {
                        st._Rotation = (int) bundle.getDouble("vehicle_angle");
                    } else {
                        st._Rotation = (int) BNRouteGuider.getInstance().GetCarRotateAngle();
                    }
                    st._Overlooking = -45;
                } else {
                    st._Rotation = 1;
                    st._Overlooking = 0;
                }
                if (1 == RGCacheStatus.sOrientation) {
                    st._Xoffset = 0;
                    if (is3DState) {
                        st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getHeightPixels()) * 0.25d));
                    } else {
                        st._Yoffset = (long) (0 - ScreenUtil.getInstance().dip2px(64));
                    }
                } else if (2 == RGCacheStatus.sOrientation) {
                    st._Xoffset = (long) (ScreenUtil.getInstance().getHeightPixels() / 6);
                    if (is3DState) {
                        st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.25d));
                    } else {
                        st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.1d));
                    }
                }
                Bundle b = null;
                try {
                    b = CoordinateTransformUtil.LL2MC(((double) carPt.getLongitudeE6()) / 100000.0d, ((double) carPt.getLatitudeE6()) / 100000.0d);
                } catch (Throwable e) {
                    LogUtil.e(TAG, "initCarAndMapPosition err:" + e.getMessage());
                }
                if (b != null) {
                    st._CenterPtX = b.getInt("MCx");
                    st._CenterPtY = b.getInt("MCy");
                    st._Level = 19.0f;
                    if (isForce2D) {
                        NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationNone);
                    } else {
                        NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationAll);
                    }
                }
            }
        }
    }

    public boolean preNextRouteDetail(boolean bPre) {
        LogUtil.e(TAG, "preNextRouteDetail: mMapController --> " + this.mMapController + ", bPre=" + bPre);
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.preNextRouteDetail(bPre);
    }

    public boolean setRouteDetailIndex(int index) {
        LogUtil.e(TAG, "setRouteDetailIndex: mMapController --> " + this.mMapController + ", index=" + index);
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.setRouteDetailIndex(index);
    }

    public boolean resetRouteDetailIndex() {
        LogUtil.e(TAG, "resetRouteDetailIndex: mMapController --> " + this.mMapController);
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.resetRouteDetailIndex(true);
    }

    public boolean resetRouteDetailIndex(boolean bAnimation) {
        LogUtil.e(TAG, "resetRouteDetailIndex: mMapController --> " + this.mMapController + ", bAnimation=" + bAnimation);
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.resetRouteDetailIndex(bAnimation);
    }

    public boolean allViewSerialAnimation() {
        LogUtil.e(TAG, "allViewSerialAnimation: mMapController --> " + this.mMapController);
        if (this.mMapController == null) {
            return false;
        }
        return this.mMapController.allViewSerialAnimation();
    }

    public boolean setScreenShow(int screenWidth, int screenHeight, int top, int bottom, int left, int right) {
        LogUtil.e(TAG, "setScreenShow: mMapController --> " + this.mMapController);
        if (this.mMapController == null) {
            return false;
        }
        Bundle bundleParams = new Bundle();
        bundleParams.putInt("unScreenWidth", screenWidth);
        bundleParams.putInt("unScreenHeight", screenHeight);
        bundleParams.putInt("nTopHeight", top);
        bundleParams.putInt("nBottomHeight", bottom);
        bundleParams.putInt("nLeftWidth", left);
        bundleParams.putInt("nRightWidth", right);
        return this.mMapController.setScreenShow(bundleParams);
    }

    public boolean showEnterNavAnim() {
        if (this.mMapController == null) {
            return false;
        }
        GeoPoint carPt = new GeoPoint();
        int[] angle = new int[]{0};
        boolean getCarInfoResult = BNRouteGuider.getInstance().getCarInfoForAnim(carPt, angle);
        if (!(getCarInfoResult && carPt.isValid())) {
            carPt = RGEngineControl.getInstance().getCarGeoPoint();
        }
        MapStatus st = NMapControlProxy.getInstance().getMapStatus();
        if (st == null || carPt == null || !carPt.isValid()) {
            return false;
        }
        boolean is3DState = BNSettingManager.getMapMode() == 1;
        if (is3DState) {
            st._Overlooking = -45;
            if (getCarInfoResult) {
                st._Rotation = angle[0];
            } else {
                st._Rotation = (int) BNRouteGuider.getInstance().GetCarRotateAngle();
            }
        } else {
            st._Rotation = 1;
            st._Overlooking = 0;
        }
        if (1 == RGCacheStatus.sOrientation) {
            st._Xoffset = 0;
            if (is3DState) {
                int windHeightP = ScreenUtil.getInstance().getHeightPixels();
                if (windHeightP < 1) {
                    LogUtil.e(TAG, "showEnterNavAnim portrait error init default value :" + windHeightP);
                    windHeightP = 1920;
                }
                st._Yoffset = (long) (0.0d - (((double) windHeightP) * 0.25d));
            } else {
                st._Yoffset = 0 - ((long) ScreenUtil.getInstance().dip2px(20));
            }
        } else if (2 == RGCacheStatus.sOrientation) {
            int windHeightL = ScreenUtil.getInstance().getHeightPixels();
            if (windHeightL < 1) {
                LogUtil.e(TAG, "showEnterNavAnim landscape error init default value :" + windHeightL);
                windHeightL = 1920;
            }
            st._Xoffset = (long) (windHeightL / 8);
            if (is3DState) {
                st._Yoffset = 0 - ((long) ScreenUtil.getInstance().dip2px(20));
            } else {
                st._Yoffset = 0;
            }
        }
        Bundle b = null;
        try {
            b = CoordinateTransformUtil.LL2MC(((double) carPt.getLongitudeE6()) / 100000.0d, ((double) carPt.getLatitudeE6()) / 100000.0d);
        } catch (Throwable e) {
            LogUtil.e(TAG, "initCarAndMapPosition err:" + e.getMessage());
        }
        if (b != null) {
            st._CenterPtX = b.getInt("MCx");
            st._CenterPtY = b.getInt("MCy");
        }
        st._Level = -2.0f;
        this.mMapController.setNaviCarPos();
        this.mMapController.setMapStatus(st, AnimationType.eAnimationPoi, 2000);
        return true;
    }

    public void syncDVUserDatCfg() {
    }
}
