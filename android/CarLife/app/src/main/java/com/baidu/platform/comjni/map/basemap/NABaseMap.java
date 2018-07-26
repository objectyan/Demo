package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.platform.comapi.map.OverlayMapCallBack;
import com.baidu.platform.comjni.C2912a;
import com.baidu.platform.comjni.util.C4840a;

class NABaseMap extends C2912a {
    /* renamed from: a */
    private int f20002a;

    private native void nativeAddItemData(long j, Bundle bundle);

    private native int nativeAddLayer(long j, int i, int i2, String str);

    private native void nativeAddPopupData(long j, Bundle bundle);

    private native void nativeAddRtPopData(long j, Bundle bundle);

    private native void nativeAddStreetCustomMarker(long j, Bundle bundle, Bitmap bitmap);

    private native void nativeAttachDC(long j, long j2);

    private native boolean nativeCleanCache(long j, int i);

    private native void nativeClearLayer(long j, int i);

    private native void nativeClearLocationLayerData(long j, Bundle bundle);

    private native void nativeClearMistmapLayer(long j);

    private native boolean nativeCloseCache(long j);

    private native void nativeCloseParticleEffect(long j, String str);

    private native int nativeCreate();

    private native int nativeCreateDuplicate(long j);

    private native int nativeDraw(long j);

    private native void nativeFocusTrafficUGCLabel(long j);

    private native String nativeGeoPtToScrPoint(long j, int i, int i2);

    private native float nativeGetAdapterZoomUnitsEx(long j);

    private native int nativeGetCacheSize(long j, int i);

    private native String nativeGetCityInfoByID(long j, int i);

    private native float nativeGetFZoomToBoundF(long j, Bundle bundle, Bundle bundle2);

    private native String nativeGetFocusedBaseIndoorMapInfo(long j);

    private native int nativeGetLayerPos(long j, int i);

    private native boolean nativeGetMapBarData(long j, Bundle bundle);

    private native int nativeGetMapRenderType(long j);

    private native int nativeGetMapScene(long j);

    private native Bundle nativeGetMapStatus(long j);

    private native int nativeGetMapTheme(long j);

    private native String nativeGetNearlyObjID(long j, int i, int i2, int i3, int i4);

    private native String nativeGetProjectionPt(long j, String str);

    private native int nativeGetVMPMapCityInfo(long j, Bundle bundle);

    private native float nativeGetZoomToBound(long j, Bundle bundle, int i, int i2);

    private native float nativeGetZoomToBoundF(long j, Bundle bundle);

    private native boolean nativeImportMapTheme(long j, int i);

    private native boolean nativeInit(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    private native int nativeInitLayerCallback(long j);

    private native int nativeInsertLayerAt(long j, int i, int i2, int i3, String str);

    private native boolean nativeIsAnimationRunning(long j);

    private native boolean nativeIsBaseIndoorMapMode(long j);

    private native boolean nativeIsNaviMode(long j);

    private native boolean nativeIsPointInFocusBarBorder(long j, double d, double d2, double d3);

    private native boolean nativeIsPointInFocusIDRBorder(long j, double d, double d2);

    private native boolean nativeIsStreetArrowShown(long j);

    private native boolean nativeIsStreetCustomMarkerShown(long j);

    private native boolean nativeIsStreetPOIMarkerShown(long j);

    private native boolean nativeIsStreetRoadClickable(long j);

    private native boolean nativeLayersIsShow(long j, int i);

    private native void nativeMoveToScrPoint(long j, int i, int i2);

    private native void nativeOnBackground(long j);

    private native void nativeOnForeground(long j);

    private native String nativeOnHotcityGet(long j);

    private native void nativeOnPause(long j);

    private native boolean nativeOnRecordAdd(long j, int i);

    private native String nativeOnRecordGetAll(long j);

    private native String nativeOnRecordGetAt(long j, int i);

    private native boolean nativeOnRecordImport(long j, boolean z, boolean z2);

    private native boolean nativeOnRecordReload(long j, int i, boolean z);

    private native boolean nativeOnRecordRemove(long j, int i, boolean z);

    private native boolean nativeOnRecordStart(long j, int i, boolean z, int i2);

    private native boolean nativeOnRecordSuspend(long j, int i, boolean z, int i2);

    private native void nativeOnResume(long j);

    private native String nativeOnSchcityGet(long j, String str);

    private native boolean nativeOnUsrcityMsgInterval(long j, int i);

    private native int nativeOnWifiRecordAdd(long j, int i);

    private native boolean nativePerformAction(long j, String str);

    private native int nativeQueryInterface(long j);

    private native int nativeRelease(long j);

    private native boolean nativeRemoveItemData(long j, Bundle bundle);

    private native int nativeRemoveLayer(long j, int i);

    private native void nativeRemoveStreetAllCustomMarker(long j);

    private native void nativeRemoveStreetCustomMaker(long j, String str);

    private native void nativeResetImageRes(long j);

    private native boolean nativeResumeCache(long j);

    private native boolean nativeSaveCache(long j);

    private native void nativeSaveScreenToLocal(long j, String str, String str2);

    private native String nativeScrPtToGeoPoint(long j, int i, int i2);

    private native void nativeSetAllStreetCustomMarkerVisibility(long j, boolean z);

    private native String nativeSetFocus(long j, int i, int i2, boolean z, Bundle bundle);

    private native boolean nativeSetItsPreTime(long j, int i, int i2, int i3);

    private native boolean nativeSetLayerSceneMode(long j, int i, int i2);

    private native void nativeSetLayersClickable(long j, int i, boolean z);

    private native void nativeSetLocationLayerData(long j, Bundle bundle);

    private native int nativeSetMapControlMode(long j, int i);

    private native boolean nativeSetMapScene(long j, int i);

    private native void nativeSetMapStatus(long j, Bundle bundle);

    private native boolean nativeSetMapTheme(long j, int i, Bundle bundle);

    private native boolean nativeSetMapThemeScene(long j, int i, int i2, Bundle bundle);

    private native void nativeSetStreetArrowShow(long j, boolean z);

    private native void nativeSetStreetMarkerClickable(long j, String str, boolean z);

    private native void nativeSetStreetRoadClickable(long j, boolean z);

    private native void nativeSetStyleMode(long j, int i);

    private native void nativeSetTargetStreetCustomMarkerVisibility(long j, boolean z, String str);

    private native void nativeSetTrafficUGCData(long j, String str);

    private native void nativeShowBaseIndoorMap(long j, boolean z);

    private native void nativeShowHotMap(long j, boolean z, int i);

    private native void nativeShowHotMapWithUid(long j, boolean z, int i, String str);

    private native void nativeShowLayers(long j, int i, boolean z);

    private native void nativeShowMistMap(long j, boolean z, String str);

    private native boolean nativeShowParticleEffect(long j, int i);

    private native boolean nativeShowParticleEffectByName(long j, String str, boolean z);

    private native boolean nativeShowParticleEffectByType(long j, int i);

    private native void nativeShowSatelliteMap(long j, boolean z);

    private native void nativeShowStreetPOIMarker(long j, boolean z);

    private native void nativeShowStreetRoadMap(long j, boolean z);

    private native void nativeShowTrafficMap(long j, boolean z);

    private native void nativeShowTrafficUGCMap(long j, boolean z);

    private native void nativeStartIndoorAnimation(long j);

    private native boolean nativeSwitchBaseIndoorMapFloor(long j, String str, String str2);

    private native boolean nativeSwitchLayer(long j, int i, int i2);

    private native void nativeUnFocusTrafficUGCLabel(long j);

    private native void nativeUpdateLayers(long j, int i);

    private native String nativeworldPointToScreenPoint(long j, float f, float f2, float f3);

    NABaseMap() {
    }

    public int create() {
        this.f20002a = nativeCreate();
        nativeInitLayerCallback((long) this.f20002a);
        return this.f20002a;
    }

    public int dispose() {
        if (this.f20002a == 0) {
            return 0;
        }
        int ret = nativeRelease((long) this.f20002a);
        this.f20002a = 0;
        return ret;
    }

    public void setCallback(OverlayMapCallBack overlayCallBack) {
        BaseMapCallback.setMapCallback((long) this.f20002a, overlayCallBack);
    }

    public int getNativeMapPointer() {
        return this.f20002a;
    }

    public boolean init(String strCFGDataRoot, String strIndoorStyleRoot, String strVMPDataRoot, String strTMPDataRoot, String strTMPDataPast, String strImportRoot, String strSytleResPath, int szViewcx, int szViewcy, int nScreenType, int nMapTmpStgMax, int nDomTmpStgMax, int nItsTmpStgMax, int nSsgTmpStgMax, boolean isPathChange) {
        return this.f20002a != 0 && nativeInit((long) this.f20002a, strCFGDataRoot, strIndoorStyleRoot, strVMPDataRoot, strTMPDataRoot, strTMPDataPast, strImportRoot, strSytleResPath, szViewcx, szViewcy, nScreenType, nMapTmpStgMax, nDomTmpStgMax, nItsTmpStgMax, nSsgTmpStgMax, isPathChange);
    }

    public int draw() {
        if (this.f20002a != 0) {
            return nativeDraw((long) this.f20002a);
        }
        return 0;
    }

    public void onPause() {
        if (this.f20002a != 0) {
            nativeOnPause((long) this.f20002a);
        }
    }

    public void onResume() {
        if (this.f20002a != 0) {
            nativeOnResume((long) this.f20002a);
        }
    }

    public void onBackground() {
        if (this.f20002a != 0) {
            nativeOnBackground((long) this.f20002a);
        }
    }

    public void onForeground() {
        if (this.f20002a != 0) {
            nativeOnForeground((long) this.f20002a);
        }
    }

    public void resetImageRes() {
        if (this.f20002a != 0) {
            nativeResetImageRes((long) this.f20002a);
        }
    }

    public int getMapRenderType() {
        return nativeGetMapRenderType((long) this.f20002a);
    }

    public void setMapStatus(Bundle b) {
        nativeSetMapStatus((long) this.f20002a, b);
    }

    public void startIndoorAnimation() {
        nativeStartIndoorAnimation((long) this.f20002a);
    }

    public int setMapControlMode(int mode) {
        return nativeSetMapControlMode((long) this.f20002a, mode);
    }

    public Bundle getMapStatus() {
        return nativeGetMapStatus((long) this.f20002a);
    }

    public float getZoomToBound(Bundle b, int width, int height) {
        return nativeGetZoomToBound((long) this.f20002a, b, width, height);
    }

    public float getZoomToBoundF(Bundle b) {
        return nativeGetZoomToBoundF((long) this.f20002a, b);
    }

    public float getFZoomToBoundF(Bundle b, Bundle screenBd) {
        return nativeGetFZoomToBoundF((long) this.f20002a, b, screenBd);
    }

    public void showSatelliteMap(boolean bShow) {
        nativeShowSatelliteMap((long) this.f20002a, bShow);
    }

    public void showTrafficMap(boolean bShow) {
        nativeShowTrafficMap((long) this.f20002a, bShow);
    }

    public void showStreetRoadMap(boolean bShow) {
        nativeShowStreetRoadMap((long) this.f20002a, bShow);
    }

    public void showHotMap(boolean bShow, int type) {
        nativeShowHotMap((long) this.f20002a, bShow, type);
    }

    public void showHotMap(boolean bShow, int type, String uid) {
        nativeShowHotMapWithUid((long) this.f20002a, bShow, type, uid);
    }

    public void showMistMap(boolean bShow, String uid) {
        nativeShowMistMap((long) this.f20002a, bShow, uid);
    }

    public void clearMistmapLayer() {
        nativeClearMistmapLayer((long) this.f20002a);
    }

    public void showLayers(int iLayerID, boolean bShow) {
        if (this.f20002a != 0) {
            nativeShowLayers((long) this.f20002a, iLayerID, bShow);
        }
    }

    public boolean layersIsShow(int iLayerID) {
        return nativeLayersIsShow((long) this.f20002a, iLayerID);
    }

    public void setLayersClickable(int iLayerID, boolean bAble) {
        nativeSetLayersClickable((long) this.f20002a, iLayerID, bAble);
    }

    public void updateLayers(int iLayerID) {
        nativeUpdateLayers((long) this.f20002a, iLayerID);
    }

    public int addLayer(int eUpdateType, int ulTimerEscap, String strTag) {
        return nativeAddLayer((long) this.f20002a, eUpdateType, ulTimerEscap, strTag);
    }

    public int removeLayer(int iLayerID) {
        return nativeRemoveLayer((long) this.f20002a, iLayerID);
    }

    public boolean switchLayer(int iLayerSrc, int iLayerDest) {
        return nativeSwitchLayer((long) this.f20002a, iLayerSrc, iLayerDest);
    }

    public void clearLayer(int iLayerID) {
        nativeClearLayer((long) this.f20002a, iLayerID);
    }

    public int getLayerPos(int iLayerID) {
        return nativeGetLayerPos((long) this.f20002a, iLayerID);
    }

    public int insertLayerAt(int iPos, int eUpdateType, int ulTimerEscap, String tag) {
        return nativeInsertLayerAt((long) this.f20002a, iPos, eUpdateType, ulTimerEscap, tag);
    }

    public String getNearlyObjID(int iLayerID, int ptx, int pty, int nearlyRadius) {
        return nativeGetNearlyObjID((long) this.f20002a, iLayerID, ptx, pty, nearlyRadius);
    }

    public String setFocus(int iLayerID, int ulFocusID, boolean bFocus, Bundle bundle) {
        return nativeSetFocus((long) this.f20002a, iLayerID, ulFocusID, bFocus, bundle);
    }

    public String scrPtToGeoPoint(int scrx, int scry) {
        return nativeScrPtToGeoPoint((long) this.f20002a, scrx, scry);
    }

    public String geoPtToScrPoint(int geox, int geoy) {
        return nativeGeoPtToScrPoint((long) this.f20002a, geox, geoy);
    }

    public String worldPointToScreenPoint(float x, float y, float z) {
        return nativeworldPointToScreenPoint((long) this.f20002a, x, y, z);
    }

    public void saveScreenToLocal(String strPath, String jsStrBound) {
        nativeSaveScreenToLocal((long) this.f20002a, strPath, jsStrBound);
    }

    public boolean setItsPreTime(int nweek, int nhour, int nMin) {
        return nativeSetItsPreTime((long) this.f20002a, nweek, nhour, nMin);
    }

    public boolean onRecordAdd(int ncityid) {
        return nativeOnRecordAdd((long) this.f20002a, ncityid);
    }

    public boolean onRecordStart(int nciryid, boolean bAll, int type) {
        return nativeOnRecordStart((long) this.f20002a, nciryid, bAll, type);
    }

    public boolean onRecordSuspend(int ncityid, boolean bAll, int type) {
        return nativeOnRecordSuspend((long) this.f20002a, ncityid, bAll, type);
    }

    public boolean onRecordReload(int ncityid, boolean bAll) {
        return nativeOnRecordReload((long) this.f20002a, ncityid, bAll);
    }

    public boolean onRecordRemove(int ncityid, boolean bAll) {
        return nativeOnRecordRemove((long) this.f20002a, ncityid, bAll);
    }

    public String onRecordGetAll() {
        return nativeOnRecordGetAll((long) this.f20002a);
    }

    public String onRecordGetAt(int ncityid) {
        return nativeOnRecordGetAt((long) this.f20002a, ncityid);
    }

    public boolean onRecordImport(boolean bDeleteFailed, boolean offImport) {
        return nativeOnRecordImport((long) this.f20002a, bDeleteFailed, offImport);
    }

    public String onHotcityGet() {
        return nativeOnHotcityGet((long) this.f20002a);
    }

    public String onSchcityGet(String strKey) {
        return nativeOnSchcityGet((long) this.f20002a, strKey);
    }

    public int onWifiRecordAdd(int ncityid) {
        return nativeOnWifiRecordAdd((long) this.f20002a, ncityid);
    }

    public void moveToScrPoint(int scrx, int scry) {
        nativeMoveToScrPoint((long) this.f20002a, scrx, scry);
    }

    public int getCacheSize(int eLayerType) {
        return nativeGetCacheSize((long) this.f20002a, eLayerType);
    }

    public boolean cleanCache(int eLayerType) {
        return nativeCleanCache((long) this.f20002a, eLayerType);
    }

    public String getCityInfoByID(int cityId) {
        return nativeGetCityInfoByID((long) this.f20002a, cityId);
    }

    public int getVMPMapCityInfo(Bundle bundle) {
        return nativeGetVMPMapCityInfo((long) this.f20002a, bundle);
    }

    public boolean closeCache() {
        return nativeCloseCache((long) this.f20002a);
    }

    public boolean resumeCache() {
        return nativeResumeCache((long) this.f20002a);
    }

    public void addPopupData(Bundle bundle) {
        nativeAddPopupData((long) this.f20002a, bundle);
    }

    public void addItemData(Bundle bundle) {
        nativeAddItemData((long) this.f20002a, bundle);
    }

    public void addRtPopData(Bundle bundle) {
        nativeAddRtPopData((long) this.f20002a, bundle);
    }

    public void setLocationLayerData(Bundle bundle) {
        nativeSetLocationLayerData((long) this.f20002a, bundle);
    }

    public void clearLocationLayerData(Bundle bundle) {
        nativeClearLocationLayerData((long) this.f20002a, bundle);
    }

    public boolean removeItemData(Bundle bundle) {
        return nativeRemoveItemData((long) this.f20002a, bundle);
    }

    public boolean saveCache() {
        try {
            return nativeSaveCache((long) this.f20002a);
        } catch (Throwable e) {
            C4840a.m16052a(e);
            return false;
        }
    }

    public boolean onUsrcityMsgInterval(int nValue) {
        return nativeOnUsrcityMsgInterval((long) this.f20002a, nValue);
    }

    public long createDuplicate() {
        return (long) nativeCreateDuplicate((long) this.f20002a);
    }

    public int createByDuplicate(int orgAddr) {
        this.f20002a = nativeCreateDuplicate((long) orgAddr);
        if (this.f20002a != 0) {
            nativeInitLayerCallback((long) this.f20002a);
        }
        return this.f20002a;
    }

    public float getAdapterZoomUnitsEx() {
        return nativeGetAdapterZoomUnitsEx((long) this.f20002a);
    }

    public void setStyleMode(int styleMode) {
        nativeSetStyleMode((long) this.f20002a, styleMode);
    }

    public boolean setLayerSceneMode(int layerId, int sceneMode) {
        return nativeSetLayerSceneMode((long) this.f20002a, layerId, sceneMode);
    }

    public void showBaseIndoorMap(boolean bShow) {
        nativeShowBaseIndoorMap((long) this.f20002a, bShow);
    }

    public boolean switchBaseIndoorMapFloor(String floorId, String buildingId) {
        return nativeSwitchBaseIndoorMapFloor((long) this.f20002a, floorId, buildingId);
    }

    public String getFocusedBaseIndoorMapInfo() {
        if (this.f20002a != 0) {
            return nativeGetFocusedBaseIndoorMapInfo((long) this.f20002a);
        }
        return null;
    }

    public boolean isBaseIndoorMapMode() {
        return this.f20002a != 0 && nativeIsBaseIndoorMapMode((long) this.f20002a);
    }

    public boolean isPointInFocusIDRBorder(double ptx, double pty) {
        return this.f20002a != 0 && nativeIsPointInFocusIDRBorder((long) this.f20002a, ptx, pty);
    }

    public boolean isPointInFocusBarBorder(double ptx, double pty, double radius) {
        return this.f20002a != 0 && nativeIsPointInFocusBarBorder((long) this.f20002a, ptx, pty, radius);
    }

    public boolean isStreetPOIMarkerShown() {
        return this.f20002a != 0 && nativeIsStreetPOIMarkerShown((long) this.f20002a);
    }

    public void showStreetPOIMarker(boolean bShow) {
        if (this.f20002a != 0) {
            nativeShowStreetPOIMarker((long) this.f20002a, bShow);
        }
    }

    public void setAllStreetCustomMarkerVisibility(boolean bShow) {
        if (this.f20002a != 0) {
            nativeSetAllStreetCustomMarkerVisibility((long) this.f20002a, bShow);
        }
    }

    public void setTargetStreetCustomMarkerVisibility(boolean bShow, String hashKey) {
        if (this.f20002a != 0) {
            nativeSetTargetStreetCustomMarkerVisibility((long) this.f20002a, bShow, hashKey);
        }
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (this.f20002a != 0) {
            nativeAddStreetCustomMarker((long) this.f20002a, bundle, bitmap);
        }
    }

    public void removeStreetCustomMaker(String hashkey) {
        nativeRemoveStreetCustomMaker((long) this.f20002a, hashkey);
    }

    public void removeStreetAllCustomMarker() {
        nativeRemoveStreetAllCustomMarker((long) this.f20002a);
    }

    public void setStreetMarkerClickable(String hashkey, boolean bClickable) {
        nativeSetStreetMarkerClickable((long) this.f20002a, hashkey, bClickable);
    }

    public boolean isStreetArrowShown() {
        return nativeIsStreetArrowShown((long) this.f20002a);
    }

    public void setStreetArrowShow(boolean show) {
        nativeSetStreetArrowShow((long) this.f20002a, show);
    }

    public boolean isStreetRoadClickable() {
        return nativeIsStreetRoadClickable((long) this.f20002a);
    }

    public void setStreetRoadClickable(boolean bClickable) {
        nativeSetStreetRoadClickable((long) this.f20002a, bClickable);
    }

    public boolean isStreetCustomMarkerShown() {
        return nativeIsStreetCustomMarkerShown((long) this.f20002a);
    }

    public void closeParticleEffect(String particleName) {
        nativeCloseParticleEffect((long) this.f20002a, particleName);
    }

    public boolean showParticleEffect(int actionType) {
        return nativeShowParticleEffect((long) this.f20002a, actionType);
    }

    public boolean showParticleEffectByType(int actionType) {
        return nativeShowParticleEffectByType((long) this.f20002a, actionType);
    }

    public boolean showParticleEffectByName(String particleName, boolean bShow) {
        return nativeShowParticleEffectByName((long) this.f20002a, particleName, bShow);
    }

    public void showTrafficUGCMap(boolean bShow) {
        nativeShowTrafficUGCMap((long) this.f20002a, bShow);
    }

    public void setTrafficUGCData(String jsonContent) {
        nativeSetTrafficUGCData((long) this.f20002a, jsonContent);
    }

    public void unFocusTrafficUGCLabel() {
        nativeUnFocusTrafficUGCLabel((long) this.f20002a);
    }

    public void focusTrafficUGCLabel() {
        nativeFocusTrafficUGCLabel((long) this.f20002a);
    }

    public void setMapScene(int modeId) {
        nativeSetMapScene((long) this.f20002a, modeId);
    }

    public boolean importMapTheme(int themeId) {
        return nativeImportMapTheme((long) this.f20002a, themeId);
    }

    public boolean setMapTheme(int themeId, Bundle bundle) {
        return nativeSetMapTheme((long) this.f20002a, themeId, bundle);
    }

    public boolean setMapThemeScene(int themeId, int sceneId, Bundle bundle) {
        return nativeSetMapThemeScene((long) this.f20002a, themeId, sceneId, bundle);
    }

    public int getMapScene() {
        return nativeGetMapScene((long) this.f20002a);
    }

    public int getMapTheme() {
        return nativeGetMapTheme((long) this.f20002a);
    }

    public boolean getMapBarData(Bundle bundle) {
        return nativeGetMapBarData((long) this.f20002a, bundle);
    }

    public boolean performAction(String action) {
        return nativePerformAction((long) this.f20002a, action);
    }

    public boolean isAnimationRunning() {
        return nativeIsAnimationRunning((long) this.f20002a);
    }

    public String getProjectionPt(String content) {
        return nativeGetProjectionPt((long) this.f20002a, content);
    }

    public boolean isNaviMode() {
        return nativeIsNaviMode((long) this.f20002a);
    }
}
