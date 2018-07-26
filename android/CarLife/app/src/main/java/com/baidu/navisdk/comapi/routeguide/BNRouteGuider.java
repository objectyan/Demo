package com.baidu.navisdk.comapi.routeguide;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import com.baidu.navisdk.util.common.BitmapLoadUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.statistic.GuideStatItem;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BNRouteGuider extends BNLogicController {
    public static final int REMOVE_LOCATION = 1;
    public static final int START_LOCATION = 0;
    private static final String TAG = "RoutePlan";
    public static final int TYPE_LOC_GPS = 0;
    public static final int TYPE_LOC_WIFI = 1;
    private static volatile BNRouteGuider mInstance;
    private Handler mGpsHandler = new BNRouteGuider$2(this, Looper.getMainLooper());
    private IGpsStatusListener mGpsStatusListener;
    private JNIGuidanceControl mGuidanceControl = null;
    private MsgHandler mMsgHandler = new BNRouteGuider$1(this, Looper.getMainLooper());
    private Map<IRGInfoListener, IRGInfoAdapter> mRGInfoAdapterMap = new HashMap();
    private Vector<OnRGInfoListener> mRGInfoListeners = new Vector(0);
    private OnRGInfoListener mRGInfoLister;
    private IRGSubStatusListener mRGSubStatusListener;
    private INaviSightListener mSightListener;
    private Vector<BNRouteGuider$OnRGSubStatusListener> mSubStatusListeners = new Vector(0);
    private boolean mbIsNavigating = false;

    private BNRouteGuider() {
        if (this.mGuidanceControl == null) {
            this.mGuidanceControl = JNIGuidanceControl.getInstance();
        }
        VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
    }

    public static BNRouteGuider getInstance() {
        if (mInstance == null) {
            synchronized (BNRouteGuider.class) {
                if (mInstance == null) {
                    mInstance = new BNRouteGuider();
                }
            }
        }
        return mInstance;
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (BNRouteGuider.class) {
                if (mInstance != null) {
                    mInstance.dispose();
                }
            }
        }
        mInstance = null;
    }

    private void dispose() {
        this.mGuidanceControl = null;
        VMsgDispatcher.unregisterMsgHandler(this.mMsgHandler);
    }

    @Deprecated
    public void setRouteGuideInfoListener(IRGInfoListener RGInfoListener) {
        this.mRGInfoLister = new IRGInfoAdapter(RGInfoListener);
    }

    public void setOnRGInfoListener(OnRGInfoListener onRGInfoListener) {
        this.mRGInfoLister = onRGInfoListener;
    }

    public void setRGSubStatusListener(IRGSubStatusListener RGSubStatusListener) {
        this.mRGSubStatusListener = RGSubStatusListener;
    }

    public void setGpsStatusListener(IGpsStatusListener GpsStatusListener) {
        this.mGpsStatusListener = GpsStatusListener;
    }

    public void setSightListener(INaviSightListener listener) {
        this.mSightListener = listener;
    }

    public void turnOnEnlargeRoadMap() {
        if (this.mMsgHandler != null) {
            this.mMsgHandler.observe(4101);
            this.mMsgHandler.observe(4102);
            this.mMsgHandler.observe(4103);
            this.mMsgHandler.observe(4109);
            this.mMsgHandler.observe(4110);
            this.mMsgHandler.observe(4111);
            this.mMsgHandler.observe(MsgDefine.MSG_NAVI_VECTOR_EXPAND_MAP_SHOW);
            this.mMsgHandler.observe(4609);
            this.mMsgHandler.observe(4610);
            this.mMsgHandler.observe(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_SHOW);
            this.mMsgHandler.observe(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_UPDATE);
            this.mMsgHandler.observe(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_HIDE);
            this.mMsgHandler.observe(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_DOWNLOAD);
            this.mMsgHandler.observe(MsgDefine.MSG_APP_DEST_STREET_VIEW_DOWNLOAD_SUCCESS);
        }
    }

    public void turnOffEnlargeRoadMap() {
        if (this.mMsgHandler != null) {
            this.mMsgHandler.ignore(4101);
            this.mMsgHandler.ignore(4102);
            this.mMsgHandler.ignore(4103);
            this.mMsgHandler.ignore(4109);
            this.mMsgHandler.ignore(4110);
            this.mMsgHandler.ignore(4111);
            this.mMsgHandler.ignore(MsgDefine.MSG_NAVI_VECTOR_EXPAND_MAP_SHOW);
            this.mMsgHandler.ignore(4609);
            this.mMsgHandler.ignore(4610);
            this.mMsgHandler.ignore(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_SHOW);
            this.mMsgHandler.ignore(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_UPDATE);
            this.mMsgHandler.ignore(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_HIDE);
            this.mMsgHandler.ignore(MsgDefine.MSG_NAVI_DEST_STREET_VIEW_DOWNLOAD);
            this.mMsgHandler.ignore(MsgDefine.MSG_APP_DEST_STREET_VIEW_DOWNLOAD_SUCCESS);
        }
    }

    public boolean setLocateMode(int locMod) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SetLocateMode(locMod);
    }

    public int getLocateMode() {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        return this.mGuidanceControl.GetLocateMode();
    }

    public boolean refreshRoute() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.RefreshRoute();
    }

    public void setGuideEndType(int type) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetGuideEndType(type);
        }
    }

    public boolean startRouteGuide(boolean isSpeakSpecVoice) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        GuideStatItem.getInstance().initMBaseTime();
        this.mbIsNavigating = true;
        LogUtil.e("RoutePlan", "startRouteGuide: --> ");
        return this.mGuidanceControl.StartRouteGuide(isSpeakSpecVoice);
    }

    public boolean stopRouteGuide() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        if (!this.mbIsNavigating) {
            return true;
        }
        LogUtil.e("RoutePlan", "stopRouteGuide");
        this.mbIsNavigating = false;
        return this.mGuidanceControl.StopRouteGuide();
    }

    public boolean setNaviMode(int naviMode) {
        LogUtil.e("RoutePlan", "setNaviMode: naviMode -->> " + naviMode);
        if (this.mGuidanceControl == null) {
            return false;
        }
        if (this.mGuidanceControl.setNaviMode(naviMode)) {
            RouteGuideParams.setRouteGuideMode(naviMode);
            return true;
        }
        LogUtil.e("RoutePlan", "setNaviMode: --> Fail");
        return false;
    }

    public boolean pauseRouteGuide() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.PauseRouteGuide();
    }

    public boolean resumeRouteGuide() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.ResumeRouteGuide();
    }

    public boolean setBrowseStatus(boolean bIsBrowseStatus) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SetBrowseStatus(bIsBrowseStatus);
    }

    public boolean isBrowseStatus() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.IsBrowseStatus();
    }

    public boolean getSimpleMapInfo(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetSimpleMapInfo(data);
    }

    public boolean getCurRoadName(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetCurRoadName(data);
    }

    public boolean getRoadNameByPos(Bundle data, int longitude, int latitude) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetRoadNameByPos(data, longitude, latitude);
    }

    public boolean triggerGPSDataChange(int longtitude, int latitude, float speed, float bearing, float accuracy, float altitude, int satellitesNum, int locType) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.TriggerGPSDataChange(longtitude, latitude, speed, bearing, accuracy, altitude, satellitesNum, locType);
    }

    public boolean triggerStartLocationData(int longtitude, int latitude, float altitude, float speed, float bearing, float accuracy, int locType, int isIndoor) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.TriggerStartLocationData(longtitude, latitude, altitude, speed, bearing, accuracy, locType, isIndoor);
    }

    public boolean setRotateMode(int mode) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SetRotateMode(mode);
    }

    public boolean removeRoute(int type) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.removeRoute(type);
    }

    public byte[] getRasterExpandMapImage(String imgPath, int flag) {
        if (this.mGuidanceControl == null) {
            return null;
        }
        return this.mGuidanceControl.GetRasterExpandMapImage(imgPath, flag);
    }

    public boolean getRasterExpandMapInfo(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetRasterExpandMapInfo(data);
    }

    public boolean getDirectBoardInfo(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetDirectBoardInfo(data);
    }

    public RGLineItem[] getLaneInfo(RGLaneInfoModel data) {
        if (this.mGuidanceControl == null) {
            return null;
        }
        return this.mGuidanceControl.getLaneInfo(data);
    }

    public boolean getDestStreetViewInfo(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetDestStreetViewInfo(data);
    }

    public boolean getVectorExpandMapInfo(Bundle data) {
        boolean z = false;
        if (this.mGuidanceControl != null) {
            try {
                z = this.mGuidanceControl.GetVectorExpandMapInfo(data);
            } catch (OutOfMemoryError e) {
            }
        }
        return z;
    }

    public boolean getHUDData(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetHUDData(data);
    }

    public boolean getHighWayInfo(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetHighWayInfo(data);
    }

    public boolean getInHighWay(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetInHighWay(data);
    }

    public boolean getEixtFastway(Bundle data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetExitFastway(data);
    }

    public boolean getCarPoint(int[] outX, int[] outY) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetCarPoint(outX, outY);
    }

    public boolean getVehicleInfo(Bundle bundle) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetVehicleInfo(bundle);
    }

    public Bundle getAssistRemainDist() {
        if (this.mGuidanceControl == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        this.mGuidanceControl.GetAssistRemainDist(bundle);
        return bundle;
    }

    public boolean setUserMapScale(int nLevel) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SetUserMapScale(nLevel);
    }

    public boolean setGpsTrackFile(String file) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SetGpsTrackFile(file);
    }

    public double GetCarRotateAngle() {
        if (this.mGuidanceControl == null) {
            return -1.0d;
        }
        return this.mGuidanceControl.GetCarRotateAngle();
    }

    public void UpdateSensor(double accx, double accy, double accz, double heading, double pitch, double roll) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.UpdateSensor(accx, accy, accz, heading, pitch, roll);
        }
    }

    public void setHUDEnabled(boolean enable) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.setHUDEnabled(enable);
        }
    }

    public void ZoomToFullView(int type) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.ZoomToFullView(type);
        }
    }

    public void SetFullViewState(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetFullViewState(b);
        }
    }

    public void setVoiceMode(int voiceMode) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetVoiceMode(voiceMode);
        }
    }

    public boolean setElecCameraSpeak(boolean b) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        this.mGuidanceControl.SetElecCameraSpeak(b);
        return true;
    }

    public boolean setSpeedCameraSpeak(boolean b) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        this.mGuidanceControl.SetSpeedCameraSpeak(b);
        return true;
    }

    public boolean setSaftyDriveSpeak(boolean b) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        this.mGuidanceControl.SetSaftyDriveSpeak(b);
        return true;
    }

    public boolean setRoadConditionSpeak(boolean b) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        this.mGuidanceControl.SetRoadConditionSpeak(b);
        return true;
    }

    public boolean setStraightDirectSpeak(boolean b) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        this.mGuidanceControl.SetStraightDirectSpeak(b);
        return true;
    }

    public void enableExpandmapDownload(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.enableExpandmapDownload(b);
        }
    }

    public int getCurrentRouteGPCnt() {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        return this.mGuidanceControl.getCurrentRouteGPCnt();
    }

    @Deprecated
    public void SetOverspeedSpeak(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetOverspeedSpeak(b);
        }
    }

    @Deprecated
    public void SetOtherCameraSpeak(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetOtherCameraSpeak(b);
        }
    }

    @Deprecated
    public void SetStraightSpeak(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetStraightSpeak(b);
        }
    }

    public void EnableRoadCondition(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.EnableRoadCondition(b);
        }
    }

    public void SetTrackData(Bundle caseBundle) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetTrackData(caseBundle);
        }
    }

    public boolean startRouteCruise() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.StartRouteCruise();
    }

    public boolean stopRouteCruise() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.StopRouteCruise();
    }

    public boolean SetCruiseSetting(Bundle bundle) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SetCruiseSetting(bundle);
    }

    public void addRGInfoListeners(OnRGInfoListener listener) {
        if (listener != null && !this.mRGInfoListeners.contains(listener)) {
            this.mRGInfoListeners.add(listener);
        }
    }

    public void removeRGInfoListeners(OnRGInfoListener listener) {
        if (listener != null && this.mRGInfoListeners.contains(listener)) {
            this.mRGInfoListeners.remove(listener);
        }
    }

    public void addRGInfoListeners(IRGInfoListener listener) {
        if (listener != null && !this.mRGInfoAdapterMap.containsKey(listener)) {
            IRGInfoAdapter ia = new IRGInfoAdapter(listener);
            this.mRGInfoAdapterMap.put(listener, ia);
            this.mRGInfoListeners.add(ia);
        }
    }

    public void removeRGInfoListeners(IRGInfoListener listener) {
        if (listener != null && this.mRGInfoAdapterMap.containsKey(listener)) {
            IRGInfoAdapter ia = (IRGInfoAdapter) this.mRGInfoAdapterMap.get(listener);
            if (ia != null) {
                this.mRGInfoListeners.remove(ia);
                this.mRGInfoAdapterMap.remove(listener);
            }
        }
    }

    public void addRGSubStatusListener(BNRouteGuider$OnRGSubStatusListener listener) {
        if (listener != null) {
            this.mSubStatusListeners.add(listener);
        }
    }

    private void startNaviLocate() {
        LogUtil.e("RoutePlan", "startNaviLocate");
        this.mGpsHandler.sendEmptyMessage(0);
    }

    private void stopNaviLocate() {
        LogUtil.e("RoutePlan", "stopNaviLocate");
        this.mGpsHandler.sendEmptyMessage(1);
    }

    public void removeRGSubStatusListener(BNRouteGuider$OnRGSubStatusListener listener) {
        if (listener != null) {
            this.mSubStatusListeners.remove(listener);
        }
    }

    public List<Bundle> getRoadCondition() {
        List<Bundle> list = null;
        if (this.mGuidanceControl != null) {
            try {
                list = this.mGuidanceControl.GetRoadCondition();
            } catch (OutOfMemoryError e) {
            }
        }
        return list;
    }

    public boolean switchingToAvoidRoute(Boolean bSwitch, int index) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SwitchingToAvoidRoute(bSwitch, index);
    }

    public boolean onlineChangeRoute(int changeType) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.onlineChangeRoute(changeType);
    }

    public int calcOtherRoute(int routeCnt, int isOtherRoute) {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        return this.mGuidanceControl.CalcOtherRoute(routeCnt, isOtherRoute);
    }

    public int calcOtherRoute(String eventId, int isOtherRoute, int comeFrom) {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        if (eventId == null) {
            eventId = "";
        }
        return this.mGuidanceControl.CalcOtherRouteNew(eventId, isOtherRoute, comeFrom);
    }

    public int cancelOtherRoute() {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        return this.mGuidanceControl.CancelFormOtherRoute();
    }

    public float getCarProgress() {
        if (this.mGuidanceControl == null) {
            return -1.0f;
        }
        return this.mGuidanceControl.GetCarProgress();
    }

    public long getCurrentRouteDrvieDistance() {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        return this.mGuidanceControl.GetCurrentRouteDrvieDistance();
    }

    public boolean makeParkingSpeak(String destName, int parkingCnt) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.MakeParkingSpeak(destName, parkingCnt);
    }

    public boolean ZoomToFullView(Rect rect, boolean isVertical) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.ZoomToFullViewFromCurrent(rect, isVertical, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
    }

    public boolean setSpecVoiceTaskId(String taskId) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.setSpecVoiceTaskId(taskId, false);
    }

    public boolean setSpecVoiceTaskId(String taskId, boolean isUseSpecVoice) {
        LogUtil.e("RoutePlan", "setSpecVoiceTaskId taskId:" + taskId + " isUseSpecVoice:" + isUseSpecVoice);
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.setSpecVoiceTaskId(taskId, isUseSpecVoice);
    }

    public boolean updateSpecVoiceText(String clbduss, boolean bNormal) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.UpdateSpecVoiceText(clbduss, bNormal);
    }

    public boolean isDestHitWanDa(boolean bIsWanda) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.IsDestHitWanDa(bIsWanda);
    }

    public String getCurRoadConditionText() {
        if (this.mGuidanceControl != null) {
            return this.mGuidanceControl.getCurRoadConditionText();
        }
        return null;
    }

    public String getLastTtsSpeech() {
        if (this.mGuidanceControl != null) {
            return this.mGuidanceControl.getLastGuideBroadcast();
        }
        return null;
    }

    public String getNextManeuverSpeech() {
        if (this.mGuidanceControl != null) {
            return this.mGuidanceControl.getNextTurnPoint();
        }
        return null;
    }

    public boolean triggerDataMiningPoiReq(String bduss) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (bduss == null) {
            bduss = "";
        }
        return jNIGuidanceControl.triggerDataMiningPoiReq(bduss);
    }

    public Bundle getRoadConditionText4LightGuide() {
        Bundle bundle = new Bundle();
        if (this.mGuidanceControl == null) {
            return null;
        }
        this.mGuidanceControl.getRoadConditionText4LightGuide(bundle);
        return bundle;
    }

    public boolean triggerRecordSensorData(float x, float y, float z, int sensorType) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.triggerRecordSensorData(x, y, z, sensorType);
    }

    public boolean triggerGPSStarInfoChange(int starVisibleCount, int starUsedCount, ArrayList<Bundle> starInfo) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        LogUtil.e(ModuleName.ROUTEGUIDE, "triggerRecordSensorData() starVisibleCount=" + starVisibleCount + ", starUsedCount=" + starUsedCount);
        return this.mGuidanceControl.triggerGPSStarInfoChange(starVisibleCount, starUsedCount, starInfo);
    }

    public int naviSwitchingCalcRoute(int type) {
        if (this.mGuidanceControl == null) {
            return 0;
        }
        return this.mGuidanceControl.naviSwitchingCalcRoute(type);
    }

    public boolean switch2AlternativeRoute(int type) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.switch2AlternativeRoute(type);
    }

    public boolean cancelCalcRoute(int handleId) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.cancelCalcRoute(handleId);
    }

    public boolean isCurDriveRouteOnline() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.isCurDriveRouteOnline();
    }

    public boolean setUserChooseRouteBit(int nBit) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.setUserChooseRouteBit(nBit);
    }

    public void clearCarImage() {
        if (BNMapController.getInstance().getMapController() != null) {
            BNMapController.getInstance().getMapController().clearCarImage();
        }
    }

    public void setCarImageToMap(String imagePath) {
        if (BNMapController.getInstance().getMapController() != null) {
            Bitmap bitmap = BitmapLoadUtils.getBitmapFromPath(imagePath);
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int bits = (bitmap.getByteCount() * 8) / (width * height);
                byte[] imageBytes = bitmap2Bytes(bitmap);
                if (imageBytes != null) {
                    BNMapController.getInstance().getMapController().setCarImageToMap(width, height, bits, imageBytes);
                }
            }
        }
    }

    private static byte[] bitmap2Bytes(Bitmap bm) {
        if (bm == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(CompressFormat.PNG, 100, baos);
        byte[] result = baos.toByteArray();
        try {
            baos.close();
            return result;
        } catch (IOException e) {
            return result;
        }
    }

    public boolean getCarInfoForAnim(GeoPoint carGeoPt, int[] angle) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        int[] outXy = new int[]{0, 0, 0};
        if (!this.mGuidanceControl.getCarInfoForAnimation(outXy) || outXy[0] == 0 || outXy[1] == 0) {
            carGeoPt.setLongitudeE6(Integer.MIN_VALUE);
            carGeoPt.setLatitudeE6(Integer.MIN_VALUE);
        } else {
            carGeoPt.setLongitudeE6(outXy[0]);
            carGeoPt.setLatitudeE6(outXy[1]);
        }
        angle[0] = outXy[2];
        return carGeoPt.isValid();
    }

    public boolean getRouteInfoInUniform(int type, Bundle bundle) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetRouteInfoInUniform(type, bundle);
    }

    public boolean getSlightNaviRouteBound(Bundle bundle) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetSlightNaviRouteBound(bundle);
    }
}
