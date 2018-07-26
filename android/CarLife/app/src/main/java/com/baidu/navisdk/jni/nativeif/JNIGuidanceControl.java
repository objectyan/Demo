package com.baidu.navisdk.jni.nativeif;

import android.graphics.Rect;
import android.os.Bundle;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class JNIGuidanceControl {
    public static final int CONNECT_STATUS_CONNECT = 2;
    public static final int CONNECT_STATUS_DISCONNECT = 1;
    public static final int CONNECT_STATUS_POS = 3;
    public static final int LOCATE_MODE_GPS = 1;
    public static final int LOCATE_MODE_MANUAL_DEMO_GPS = 4;
    public static final int LOCATE_MODE_NEMA_DEMO_GPS = 3;
    public static final int LOCATE_MODE_ROUTE_DEMO_GPS = 2;
    public static final int NET_STATUS_NO_NET = 1;
    public static final int NET_STATUS_WIFI = 2;
    public static final int NET_STATUS_WWAN = 3;
    private static volatile JNIGuidanceControl mJNIGuidance = null;

    public native int CalcOtherRoute(int i, int i2);

    public native int CalcOtherRouteNew(String str, int i, int i2);

    public native int CalcRoute(int i, int i2, RoutePlanTime routePlanTime, int i3, int i4, boolean z, String str, int i5, int i6, boolean z2, String str2);

    public native int CalcRouteWithPB(int i, int i2, int i3, Bundle bundle, int i4, int i5);

    public native boolean CalcSpecPoiRouteInfo(ArrayList<RoutePlanNode> arrayList, int i, int i2, int i3, String str, Bundle bundle);

    public native void CancelCalcRoute(int i);

    public native int CancelFormOtherRoute();

    public native boolean ClearRouteBuffer();

    public native void EnableRoadCondition(boolean z);

    public native boolean GetAssistRemainDist(Bundle bundle);

    public native boolean GetAvoidInfo(int i);

    public native String GetAvoidTips(int i);

    public native boolean GetCarPoint(int[] iArr, int[] iArr2);

    public native float GetCarProgress();

    public native double GetCarRotateAngle();

    public native boolean GetCurRoadName(Bundle bundle);

    public native long GetCurrentRouteDrvieDistance();

    public native boolean GetDestStreetViewInfo(Bundle bundle);

    public native boolean GetDestsRemained(int[] iArr);

    public native boolean GetDirectBoardInfo(Bundle bundle);

    public native boolean GetDriveInfo(int i, Bundle bundle);

    public native boolean GetExitFastway(Bundle bundle);

    public native boolean GetHUDData(Bundle bundle);

    public native int GetHUDSDKCameraInfo(ArrayList<Bundle> arrayList);

    public native int GetHUDSDKRouteInfo(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2, ArrayList<Bundle> arrayList3);

    public native boolean GetHighWayInfo(Bundle bundle);

    public native boolean GetInHighWay(Bundle bundle);

    public native boolean GetLackOfData(boolean[] zArr);

    public native boolean GetLocalRouteInfo(Bundle bundle);

    public native int GetLocateMode();

    public native boolean GetMapVehiclePos(Bundle bundle);

    public native boolean GetNaviRouteBound(Bundle bundle);

    public native byte[] GetRasterExpandMapImage(String str, int i);

    public native boolean GetRasterExpandMapInfo(Bundle bundle);

    public native List<Bundle> GetRoadCondition();

    public native String GetRoadEventText();

    public native boolean GetRoadNameByPos(Bundle bundle, int i, int i2);

    public native void GetRouteBoundRect(ArrayList<Bundle> arrayList);

    public native int GetRouteCnt();

    public native int GetRouteInfo(int i, Bundle bundle);

    public native boolean GetRouteInfoInUniform(int i, Bundle bundle);

    public native boolean GetRoutePlanResultMapProtoBuf(Bundle bundle, int i);

    public native String GetRoutePlanSessionIDAndMrsl(String str, String str2);

    public native int GetRoutePlanSubResult(ArrayList<Bundle> arrayList, Bundle bundle);

    public native int GetRouteSessionIDAndMrsl(Bundle bundle);

    public native boolean GetRouteTollMode(int i, int i2);

    public native int GetShowPreferenceTap();

    public native boolean GetSimpleMapInfo(Bundle bundle);

    public native boolean GetSlightNaviRouteBound(Bundle bundle);

    public native boolean GetStartPos(int[] iArr, int[] iArr2);

    public native String GetTRURlParam();

    public native boolean GetVectorExpandMapInfo(Bundle bundle);

    public native boolean GetVehicleInfo(Bundle bundle);

    public native boolean IsBrowseStatus();

    public native boolean IsDestHitWanDa(boolean z);

    public native boolean IsMapLoggerOpen();

    public native boolean LightCalcRoute(int i, int i2);

    public native boolean MakeParkingSpeak(String str, int i);

    public native boolean ManualPlaySound();

    public native boolean MeetingPreloadRoute(RoutePlanNode routePlanNode, ArrayList<RoutePlanNode> arrayList, int i, Bundle bundle);

    public native boolean PauseRouteGuide();

    public native boolean RefreshRoute();

    public native boolean ResumeRouteGuide();

    public native boolean SelectRoute(int i);

    public native int SelectRouteWithMrsl(String str);

    public native boolean SetBrowseStatus(boolean z);

    public native void SetCalcRouteNetMode(int i);

    public native boolean SetCruiseSetting(Bundle bundle);

    public native boolean SetDestsPosNav(ArrayList<RoutePlanNode> arrayList);

    public native void SetElecCameraSpeak(boolean z);

    public native void SetFullViewState(boolean z);

    public native boolean SetGpsTrackFile(String str);

    public native void SetGuideEndType(int i);

    public native boolean SetHUDRouteGuideType(int i);

    public native void SetIsChangeBackgroun(int i);

    public native boolean SetIsMrslRoute(boolean z, String str);

    public native boolean SetLocalRouteCarInfo(String str, String str2, int i);

    public native boolean SetLocateMode(int i);

    public native void SetMapLoggerOpen(boolean z);

    public native boolean SetNaviCaclResultSpeak(int i);

    public native boolean SetNaviPVStat(boolean z);

    public native void SetOtherCameraSpeak(boolean z);

    public native void SetOverspeedSpeak(boolean z);

    public native void SetRoadConditionSpeak(boolean z);

    public native boolean SetRotateMode(int i);

    public native boolean SetRoutePlanStatistcsUrl(String str);

    public native void SetRouteSpec(boolean z);

    public native void SetSaftyDriveSpeak(boolean z);

    public native void SetSpeedCameraSpeak(boolean z);

    public native int SetStartPosNav(RoutePlanNode routePlanNode);

    public native void SetStraightDirectSpeak(boolean z);

    public native void SetStraightSpeak(boolean z);

    public native boolean SetTrackData(Bundle bundle);

    public native boolean SetUserMapScale(int i);

    public native void SetVoiceMode(int i);

    public native boolean StartDrivingCar();

    public native boolean StartRouteCruise();

    public native boolean StartRouteGuide(boolean z);

    public native boolean StopDrivingCar();

    public native boolean StopRouteCruise();

    public native boolean StopRouteGuide();

    public native boolean SwitchingToAvoidRoute(Boolean bool, int i);

    public native boolean TriggerGPSDataChange(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4);

    public native boolean TriggerGPSStarChange();

    public native void TriggerGPSStatus(int i);

    public native boolean TriggerNetStatusChange(int i);

    public native boolean TriggerStartLocationData(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4);

    public native boolean TriggerStartSensorData(float f, float f2, float f3);

    public native boolean UpdateCloudTrafficInfo(int i, String str);

    public native void UpdateNmea(String str);

    public native boolean UpdateRouteRoadCondation(int i);

    public native void UpdateSensor(double d, double d2, double d3, double d4, double d5, double d6);

    public native boolean UpdateSpecVoiceText(String str, boolean z);

    public native void ZoomToFullView(int i);

    public native boolean ZoomToFullViewFromCurrent(Rect rect, boolean z, int i, int i2);

    public native boolean ZoomToRouteBound();

    public native boolean ZoomToRouteNodeBound(int i);

    public native boolean cancelCalcRoute(int i);

    public native void enableExpandmapDownload(boolean z);

    public native boolean getCarInfoForAnimation(int[] iArr);

    public native String getCurRoadConditionText();

    public native int getCurrentRouteGPCnt();

    public native boolean getDataMiningPoiArray(ArrayList<Bundle> arrayList);

    public native boolean getFirstRouteGuideInfo(Bundle bundle);

    public native RGLineItem[] getLaneInfo(RGLaneInfoModel rGLaneInfoModel);

    public native String getLastGuideBroadcast();

    public native String getNextTurnPoint();

    public native boolean getRemainRouteInfo(Bundle bundle);

    public native boolean getRoadConditionText4LightGuide(Bundle bundle);

    public native long getRoutePlanNetWorkTime();

    public native int getRoutePlanResultKeyWordList(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2, Bundle bundle);

    public native int getSelectRouteIdx();

    public native int getValidRouteCnt();

    public native int getViaCnt();

    public native boolean isBuildRouteReady(boolean z, String str);

    public native boolean isCurDriveRouteOnline();

    public native boolean isExistLocalRPData(GeoPoint geoPoint, ArrayList<GeoPoint> arrayList);

    public native String isRouteGuideCloud();

    public native boolean judgeRouteInfoAllReady(int i);

    public native boolean loadUrlAddrConfigParams(String str, String str2);

    public native int naviSwitchingCalcRoute(int i);

    public native boolean onlineChangeRoute(int i);

    public native boolean removeRoute(int i);

    public native boolean resetUrlAddrConfigParams(String str);

    @Deprecated
    public native boolean setAvoidRouteMapStatus(int i);

    public native void setCloudControlCommand(String str);

    public native boolean setEngTTSActive(boolean z);

    public native boolean setFuncConfigParams(boolean z, int[] iArr, int i);

    public native boolean setGroundMode(int i);

    public native void setHUDEnabled(boolean z);

    public native boolean setNaviMode(int i);

    public native boolean setShowRouteChoose(int i);

    public native boolean setSpecVoiceTaskId(String str, boolean z);

    public native boolean setTTSPlayEnd();

    public native boolean setUserChooseRouteBit(int i);

    public native boolean switch2AlternativeRoute(int i);

    public native boolean triggerDataMiningPoiReq(String str);

    public native boolean triggerGPSStarInfoChange(int i, int i2, ArrayList<Bundle> arrayList);

    public native boolean triggerPressureChange(float f);

    public native boolean triggerRecordSensorData(float f, float f2, float f3, int i);

    public native boolean triggerSensorAngle(double d, double d2);

    public static JNIGuidanceControl getInstance() {
        if (mJNIGuidance == null) {
            synchronized (JNIGuidanceControl.class) {
                if (mJNIGuidance == null) {
                    mJNIGuidance = new JNIGuidanceControl();
                    BNaviEngineManager.getInstance().initSubSysHandle(1);
                }
            }
        }
        return mJNIGuidance;
    }

    private JNIGuidanceControl() {
    }
}
