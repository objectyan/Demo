package com.baidu.navi.cruise.control;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.view.CruiseMapView;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.model.CruiseParams.Key;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class CruiseMapController {
    private static final String TAG = "Cruise";
    private Context mContext;
    private CruiseMapView mCruiseMapView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsCruiseEngineStarted = false;
    private BNMapObserver mMapObserver = new C37482();

    /* renamed from: com.baidu.navi.cruise.control.CruiseMapController$2 */
    class C37482 implements BNMapObserver {
        C37482() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (1 == type) {
                switch (event) {
                    case 257:
                        CruiseMapController.this.saveMapScaleLevel();
                        if (CruiseMapController.this.mCruiseMapView != null) {
                            CruiseMapController.this.mCruiseMapView.updateControlPanel();
                        }
                        BNMapController.getInstance().updateLayer(10);
                        BNMapController.getInstance().UpdataBaseLayers();
                        break;
                    case 264:
                    case 265:
                    case 276:
                    case 277:
                        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                        break;
                    case 274:
                        CruiseMapController.this.saveMapScaleLevel();
                        if (CruiseMapController.this.mCruiseMapView != null) {
                            CruiseMapController.this.mCruiseMapView.updateControlPanel();
                        }
                        BNMapController.getInstance().updateLayer(10);
                        BNMapController.getInstance().UpdataBaseLayers();
                        break;
                }
            }
            if (2 == type) {
                switch (event) {
                    case 514:
                        if (CruiseMapController.this.mCruiseMapView != null) {
                            CruiseMapController.this.mCruiseMapView.showMapButtons();
                            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                            return;
                        }
                        return;
                    case 518:
                        if (CruiseMapController.this.mCruiseMapView != null) {
                            CruiseMapController.this.mCruiseMapView.resetLocMode();
                            CruiseMapController.this.mCruiseMapView.showMapButtons();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static class LazyHolder {
        private static final CruiseMapController sInstance = new CruiseMapController();

        private LazyHolder() {
        }
    }

    public static CruiseMapController getInstance() {
        return LazyHolder.sInstance;
    }

    public void init(Context context) {
        this.mContext = context;
        this.mCruiseMapView = null;
        this.mIsCruiseEngineStarted = false;
    }

    public void setCruiseMapView(CruiseMapView cruiseMapView) {
        this.mCruiseMapView = cruiseMapView;
    }

    public void setCruiseEngineStarted(boolean started) {
        this.mIsCruiseEngineStarted = started;
    }

    public void initMapView() {
        boolean z = true;
        LogUtil.m15791e("Cruise", "initMapView ...");
        BNRouteGuider.getInstance().setBrowseStatus(true);
        BNMapController.getInstance().deleteAllObserver();
        BNMapController.getInstance().addObserver(this.mMapObserver);
        clearPoiBkg();
        BNMapController.getInstance().setDrawHouse(false);
        BNMapController instance = BNMapController.getInstance();
        if (BNStyleManager.getRealDayStyle()) {
            z = false;
        }
        instance.setNightMode(z);
        setMapInitScaleLevel();
    }

    private void setMapInitScaleLevel() {
        LogUtil.m15791e("Cruise", "setMapInitScaleLevel");
        MapStatus mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus == null) {
            LogUtil.m15791e("Cruise", "setMapInitScaleLevel fail mapStatus is null");
            return;
        }
        mapStatus._Rotation = 0;
        BNMapController.getInstance().setMapStatus(mapStatus, AnimationType.eAnimationNone);
    }

    public void restoreMapView() {
        boolean z = true;
        writeMapScaleLevel();
        BNMapController.getInstance().onResume();
        BNRouteGuider.getInstance().setBrowseStatus(true);
        BNMapController.getInstance().deleteObserver(this.mMapObserver);
        BNMapController.getInstance().setDrawHouse(true);
        BNMapController instance = BNMapController.getInstance();
        if (BNStyleManager.getRealDayStyle()) {
            z = false;
        }
        instance.setNightMode(z);
    }

    public void changeToCar3DView(boolean withAnim) {
        changeToCar3DView(getCarPointLocation(), withAnim);
    }

    public void changeToCar3DView(LocData locData, boolean withAnim) {
        LogUtil.m15791e("Cruise", "changeToCar3DView with locData, anim " + withAnim);
        setMapStatus(locData, false, withAnim);
        BNRouteGuider.getInstance().setRotateMode(0);
        PreferenceHelper.getInstance(this.mContext).putBoolean(Key.SP_Last_Cruise_Map_Status, false);
    }

    public void changeToNorth2DView() {
        LogUtil.m15791e("Cruise", "changeToNorth2DView");
        setMapStatus(getCarPointLocation(), true, true);
        BNRouteGuider.getInstance().setRotateMode(1);
        PreferenceHelper.getInstance(this.mContext).putBoolean(Key.SP_Last_Cruise_Map_Status, true);
    }

    public void locateToCarPoint(boolean withAnim) {
        int i = 1;
        LogUtil.m15791e("Cruise", "locateToCarPoint");
        boolean is2DNorth = PreferenceHelper.getInstance(this.mContext).getBoolean(Key.SP_Last_Cruise_Map_Status, true);
        LocData locData = getCarPointLocation();
        setMapStatus(locData, is2DNorth, withAnim);
        BNRouteGuider instance = BNRouteGuider.getInstance();
        if (!is2DNorth) {
            i = 0;
        }
        instance.setRotateMode(i);
        if (this.mIsCruiseEngineStarted) {
            BNRouteGuider.getInstance().setBrowseStatus(false);
            return;
        }
        LocData wgs84LocData = new LocData();
        if (locData != null) {
            Bundle wgs84Bundle = CoordinateTransformUtil.transferGCJ02ToWGS84(locData.longitude, locData.latitude);
            wgs84LocData.longitude = wgs84Bundle.getDouble("LLx");
            wgs84LocData.latitude = wgs84Bundle.getDouble("LLy");
        }
        BCruiser.getInstance().updateLocation(wgs84LocData, locData);
    }

    public void setMapStatus(LocData locData, boolean isNorth2D, boolean withAnim) {
        int i = 0;
        MapStatus mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus != null) {
            mapStatus._Rotation = isNorth2D ? 0 : (int) BNRouteGuider.getInstance().GetCarRotateAngle();
            if (!isNorth2D) {
                i = -45;
            }
            mapStatus._Overlooking = i;
            mapStatus._Xoffset = 0;
            mapStatus._Yoffset = (long) ScreenUtil.getInstance().dip2px(40);
            LogUtil.m15791e("Cruise", "setMapStatus: north2D " + isNorth2D + ", anim " + withAnim + ", " + locData);
            if (locData != null && locData.isValid()) {
                Bundle b = CoordinateTransformUtil.LL2MC(locData.longitude, locData.latitude);
                int longitudeMC = b.getInt("MCx");
                int latitudeMC = b.getInt("MCy");
                mapStatus._CenterPtX = longitudeMC;
                mapStatus._CenterPtY = latitudeMC;
            }
            AnimationType animType = withAnim ? AnimationType.eAnimationAll : AnimationType.eAnimationNone;
            mapStatus._Level = -1.0f;
            BNMapController.getInstance().setMapStatus(mapStatus, animType);
        }
    }

    public void initMapStatus() {
        BNRouteGuider.getInstance().SetFullViewState(false);
        BNMapController.getInstance().enableTouchEventLookover(true);
        BNRouteGuider.getInstance().setBrowseStatus(true);
        boolean is2DNorth = PreferenceHelper.getInstance(this.mContext).getBoolean(Key.SP_Last_Cruise_Map_Status, true);
        LogUtil.m15791e("Cruise", "initMapStatus: isNorth2D " + is2DNorth);
        if (is2DNorth) {
            changeToNorth2DView();
        } else {
            changeToCar3DView(getCarPointLocation(), false);
        }
        if (this.mIsCruiseEngineStarted) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("initMapStatus-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    LogUtil.m15791e(TAG, "initMapStatus post task:  setBrowseStatus false");
                    BNRouteGuider.getInstance().setBrowseStatus(false);
                    return null;
                }
            }, new BNWorkerConfig(8, 0), 1000);
        }
    }

    public int readMapScaleLevel() {
        int level = PreferenceHelper.getInstance(this.mContext).getInt(PreferenceHelperConst.CRUISE_MAP_USER_SCALE_LEVEL, 18);
        if (level < 15) {
            return 15;
        }
        if (level > 20) {
            return 18;
        }
        return level;
    }

    public void writeMapScaleLevel() {
        int level = BNMapController.getInstance().getZoomLevel();
        LogUtil.m15791e("Cruise", "save MapScaleLevel = " + level);
        if (level < 15) {
            level = 15;
        } else if (level > 20) {
            level = 18;
        }
        PreferenceHelper.getInstance(this.mContext).putInt(PreferenceHelperConst.CRUISE_MAP_USER_SCALE_LEVEL, level);
    }

    private void clearPoiBkg() {
        BNPoiSearcher.getInstance().clearBkgCache();
        BNPoiSearcher.getInstance().clearPoiCache();
    }

    public void onUpdateOrientation(boolean isPortrait) {
        LogUtil.m15791e("Cruise", "onUpdateOrientation: portrait " + isPortrait);
        BNMapController.getInstance().showLayer(9, false);
        if (this.mIsCruiseEngineStarted) {
            BNMapController.getInstance().showLayer(20, true);
        }
        initMapStatus();
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateControlPanel();
        }
    }

    public void saveMapScaleLevel() {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("notifyDayNightObservers-" + getClass().getSimpleName(), null) {
            protected String execute() {
                int level = BNMapController.getInstance().getZoomLevel();
                LogUtil.m15791e(TAG, "saveMapScaleLevel: " + level);
                PreferenceHelper.getInstance(CruiseMapController.this.mContext).putInt(PreferenceHelperConst.CRUISE_MAP_USER_SCALE_LEVEL, level);
                return null;
            }
        }, new BNWorkerConfig(8, 0), 500);
    }

    private long getMapXOffset(boolean isPortrait) {
        long offset = 0;
        if (!isPortrait) {
            offset = (long) (ScreenUtil.getInstance().getHeightPixels() / 6);
        }
        LogUtil.m15791e("Cruise", "getMapXOffset: isPortrait " + isPortrait + ", X offset " + offset);
        return offset;
    }

    public LocData getCarPointLocation() {
        if (this.mIsCruiseEngineStarted) {
            int[] outX = new int[]{0};
            int[] outY = new int[]{0};
            if (!(!BNRouteGuider.getInstance().getCarPoint(outX, outY) || outX[0] == 0 || outY[0] == 0)) {
                LogUtil.m15791e("Cruise", "getCarPointLocation: Engine value is valid");
                LocData locData = new LocData();
                locData.longitude = ((double) outX[0]) / 100000.0d;
                locData.latitude = ((double) outY[0]) / 100000.0d;
                return locData;
            }
        }
        LogUtil.m15791e("Cruise", "getCarPointLocation: Engine value is invalid, engineStarted " + this.mIsCruiseEngineStarted);
        return GeoLocateModel.getInstance().getLastLocation();
    }

    public void showTrafficMap(boolean show) {
        if (show) {
            BNMapController.getInstance().switchITSMode(true);
            BNMapController.getInstance().showTrafficMap(true);
        } else {
            BNMapController.getInstance().showTrafficMap(false);
        }
        BNMapController.getInstance().onResume();
    }

    public void handleCruiseVoiceChanged(boolean isShowToast, boolean open) {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.handleCruiseVoiceChanged(isShowToast, open);
        }
    }
}
