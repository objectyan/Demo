package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.platform.comjni.util.C4840a;

public class AppBaseMap {
    /* renamed from: a */
    private int f20000a;
    /* renamed from: b */
    private NABaseMap f20001b;

    public AppBaseMap() {
        this.f20000a = 0;
        this.f20001b = null;
        this.f20001b = new NABaseMap();
    }

    public boolean SetCallback(C4785a callback) {
        return (callback == null || this.f20000a == 0 || !BaseMapCallback.setMapCallback((long) this.f20000a, callback)) ? false : true;
    }

    public boolean Create() {
        this.f20000a = this.f20001b.create();
        return true;
    }

    public boolean Release() {
        if (this.f20000a == 0) {
            return false;
        }
        this.f20001b.dispose();
        this.f20000a = 0;
        return true;
    }

    public int GetId() {
        return this.f20000a;
    }

    public boolean Init(String strCFGDataRoot, String strIndoorStyleRoot, String strVMPDataRoot, String strTMPDataRoot, String strTMPDataPast, String strImportRoot, String strSytleResPath, int szViewcx, int szViewcy, int nScreenType, int nMapTmpStgMax, int nDomTmpStgMax, int nItsTmpStgMax, int nSsgTmpStgMax, boolean isPathChange) {
        return this.f20000a != 0 && this.f20001b.init(strCFGDataRoot, strIndoorStyleRoot, strVMPDataRoot, strTMPDataRoot, strTMPDataPast, strImportRoot, strSytleResPath, szViewcx, szViewcy, nScreenType, nMapTmpStgMax, nDomTmpStgMax, nItsTmpStgMax, nSsgTmpStgMax, isPathChange);
    }

    public int Draw() {
        if (this.f20000a != 0) {
            return this.f20001b.draw();
        }
        return 0;
    }

    public void OnPause() {
        if (this.f20000a != 0) {
            this.f20001b.onPause();
        }
    }

    public void OnResume() {
        if (this.f20000a != 0) {
            this.f20001b.onResume();
        }
    }

    public void OnBackground() {
        if (this.f20000a != 0) {
            this.f20001b.onBackground();
        }
    }

    public void OnForeground() {
        if (this.f20000a != 0) {
            this.f20001b.onForeground();
        }
    }

    public void ResetImageRes() {
        if (this.f20000a != 0) {
            this.f20001b.resetImageRes();
        }
    }

    public int GetMapRenderType() {
        return this.f20001b.getMapRenderType();
    }

    public void SetMapStatus(Bundle b) {
        this.f20001b.setMapStatus(b);
    }

    public void StartIndoorAnimation() {
        this.f20001b.startIndoorAnimation();
    }

    public int SetMapControlMode(int mode) {
        return this.f20001b.setMapControlMode(mode);
    }

    public Bundle GetMapStatus() {
        return this.f20001b.getMapStatus();
    }

    public float GetZoomToBound(Bundle b, int width, int height) {
        return this.f20001b.getZoomToBound(b, width, height);
    }

    public float GetZoomToBoundF(Bundle b) {
        return this.f20001b.getZoomToBoundF(b);
    }

    public float GetFZoomToBoundF(Bundle b, Bundle screenBd) {
        return this.f20001b.getFZoomToBoundF(b, screenBd);
    }

    public void ShowSatelliteMap(boolean bShow) {
        this.f20001b.showSatelliteMap(bShow);
    }

    public void ShowTrafficMap(boolean bShow) {
        this.f20001b.showTrafficMap(bShow);
    }

    public void ShowStreetRoadMap(boolean bShow) {
        this.f20001b.showStreetRoadMap(bShow);
    }

    public void ShowHotMap(boolean bShow, int type) {
        this.f20001b.showHotMap(bShow, type);
    }

    public void ShowHotMap(boolean bShow, int type, String uid) {
        this.f20001b.showHotMap(bShow, type, uid);
    }

    public void ShowMistMap(boolean bShow, String uid) {
        this.f20001b.showMistMap(bShow, uid);
    }

    public void ClearMistmapLayer() {
        this.f20001b.clearMistmapLayer();
    }

    public void ShowLayers(int iLayerID, boolean bShow) {
        if (this.f20000a != 0) {
            this.f20001b.showLayers(iLayerID, bShow);
        }
    }

    public boolean LayersIsShow(int iLayerID) {
        return this.f20001b.layersIsShow(iLayerID);
    }

    public void SetLayersClickable(int iLayerID, boolean bAble) {
        this.f20001b.setLayersClickable(iLayerID, bAble);
    }

    public void UpdateLayers(int iLayerID) {
        this.f20001b.updateLayers(iLayerID);
    }

    public int AddLayer(int eUpdateType, int ulTimerEscap, String strTag) {
        return this.f20001b.addLayer(eUpdateType, ulTimerEscap, strTag);
    }

    public int RemoveLayer(int iLayerID) {
        return this.f20001b.removeLayer(iLayerID);
    }

    public boolean SwitchLayer(int iLayerSrc, int iLayerDest) {
        return this.f20001b.switchLayer(iLayerSrc, iLayerDest);
    }

    public void ClearLayer(int iLayerID) {
        this.f20001b.clearLayer(iLayerID);
    }

    public int GetLayerPos(int iLayerID) {
        return this.f20001b.getLayerPos(iLayerID);
    }

    public int InsertLayerAt(int iPos, int eUpdateType, int ulTimerEscap, String tag) {
        return this.f20001b.insertLayerAt(iPos, eUpdateType, ulTimerEscap, tag);
    }

    public String GetNearlyObjID(int iLayerID, int ptx, int pty, int nearlyRadius) {
        return this.f20001b.getNearlyObjID(iLayerID, ptx, pty, nearlyRadius);
    }

    public String SetFocus(int iLayerID, int ulFocusID, boolean bFocus, Bundle bundle) {
        return this.f20001b.setFocus(iLayerID, ulFocusID, bFocus, bundle);
    }

    public String ScrPtToGeoPoint(int scrx, int scry) {
        return this.f20001b.scrPtToGeoPoint(scrx, scry);
    }

    public String GeoPtToScrPoint(int geox, int geoy) {
        return this.f20001b.geoPtToScrPoint(geox, geoy);
    }

    public String worldPointToScreenPoint(float x, float y, float z) {
        return this.f20001b.worldPointToScreenPoint(x, y, z);
    }

    public void SaveScreenToLocal(String strPath, String jsStrBound) {
        this.f20001b.saveScreenToLocal(strPath, jsStrBound);
    }

    public boolean SetItsPreTime(int nweek, int nhour, int nMin) {
        return this.f20001b.setItsPreTime(nweek, nhour, nMin);
    }

    public boolean OnRecordAdd(int ncityid) {
        return this.f20001b.onRecordAdd(ncityid);
    }

    public boolean OnRecordStart(int nciryid, boolean bAll, int type) {
        return this.f20001b.onRecordStart(nciryid, bAll, type);
    }

    public boolean OnRecordSuspend(int ncityid, boolean bAll, int type) {
        return this.f20001b.onRecordSuspend(ncityid, bAll, type);
    }

    public boolean OnRecordReload(int ncityid, boolean bAll) {
        return this.f20001b.onRecordReload(ncityid, bAll);
    }

    public boolean OnRecordRemove(int ncityid, boolean bAll) {
        return this.f20001b.onRecordRemove(ncityid, bAll);
    }

    public String OnRecordGetAll() {
        return this.f20001b.onRecordGetAll();
    }

    public String OnRecordGetAt(int ncityid) {
        return this.f20001b.onRecordGetAt(ncityid);
    }

    public boolean OnRecordImport(boolean bDeleteFailed, boolean offImport) {
        return this.f20001b.onRecordImport(bDeleteFailed, offImport);
    }

    public String OnHotcityGet() {
        return this.f20001b.onHotcityGet();
    }

    public String OnSchcityGet(String strKey) {
        return this.f20001b.onSchcityGet(strKey);
    }

    public int OnWifiRecordAdd(int ncityid) {
        return this.f20001b.onWifiRecordAdd(ncityid);
    }

    public void MoveToScrPoint(int scrx, int scry) {
        this.f20001b.moveToScrPoint(scrx, scry);
    }

    public int GetCacheSize(int eLayerType) {
        return this.f20001b.getCacheSize(eLayerType);
    }

    public boolean CleanCache(int eLayerType) {
        return this.f20001b.cleanCache(eLayerType);
    }

    public String GetCityInfoByID(int cityId) {
        return this.f20001b.getCityInfoByID(cityId);
    }

    public int GetVMPMapCityInfo(Bundle bundle) {
        return this.f20001b.getVMPMapCityInfo(bundle);
    }

    public boolean CloseCache() {
        return this.f20001b.closeCache();
    }

    public boolean ResumeCache() {
        return this.f20001b.resumeCache();
    }

    public void AddPopupData(Bundle bundle) {
        this.f20001b.addPopupData(bundle);
    }

    public void AddItemData(Bundle bundle) {
        this.f20001b.addItemData(bundle);
    }

    public void AddRtPopData(Bundle bundle) {
        this.f20001b.addRtPopData(bundle);
    }

    public void SetLocationLayerData(Bundle bundle) {
        this.f20001b.setLocationLayerData(bundle);
    }

    public void ClearLocationLayerData(Bundle bundle) {
        this.f20001b.clearLocationLayerData(bundle);
    }

    public void Remo() {
    }

    public boolean RemoveItemData(Bundle bundle) {
        return this.f20001b.removeItemData(bundle);
    }

    public boolean SaveCache() {
        try {
            return this.f20001b.saveCache();
        } catch (Throwable e) {
            C4840a.m16052a(e);
            return false;
        }
    }

    public boolean OnUsrcityMsgInterval(int nValue) {
        return this.f20001b.onUsrcityMsgInterval(nValue);
    }

    public long CreateDuplicate() {
        return this.f20001b.createDuplicate();
    }

    public boolean CreateByDuplicate(int orgAddr) {
        this.f20000a = this.f20001b.createByDuplicate(orgAddr);
        return this.f20000a != 0;
    }

    public float GetAdapterZoomUnitsEx() {
        return this.f20001b.getAdapterZoomUnitsEx();
    }

    public void SetStyleMode(int styleMode) {
        this.f20001b.setStyleMode(styleMode);
    }

    public boolean SetLayerSceneMode(int layerId, int sceneMode) {
        return this.f20001b.setLayerSceneMode(layerId, sceneMode);
    }

    public void ShowBaseIndoorMap(boolean bShow) {
        this.f20001b.showBaseIndoorMap(bShow);
    }

    public boolean SwitchBaseIndoorMapFloor(String floorId, String buildingId) {
        return this.f20001b.switchBaseIndoorMapFloor(floorId, buildingId);
    }

    public String GetFocusedBaseIndoorMapInfo() {
        if (this.f20000a != 0) {
            return this.f20001b.getFocusedBaseIndoorMapInfo();
        }
        return null;
    }

    public boolean IsBaseIndoorMapMode() {
        return this.f20000a != 0 && this.f20001b.isBaseIndoorMapMode();
    }

    public boolean IsPointInFocusIDRBorder(double ptx, double pty) {
        return this.f20000a != 0 && this.f20001b.isPointInFocusIDRBorder(ptx, pty);
    }

    public boolean IsPointInFocusBarBorder(double ptx, double pty, double radius) {
        return this.f20000a != 0 && this.f20001b.isPointInFocusBarBorder(ptx, pty, radius);
    }

    public boolean IsStreetPOIMarkerShown() {
        return this.f20000a != 0 && this.f20001b.isStreetPOIMarkerShown();
    }

    public void ShowStreetPOIMarker(boolean bShow) {
        if (this.f20000a != 0) {
            this.f20001b.showStreetPOIMarker(bShow);
        }
    }

    public void SetAllStreetCustomMarkerVisibility(boolean bShow) {
        if (this.f20000a != 0) {
            this.f20001b.setAllStreetCustomMarkerVisibility(bShow);
        }
    }

    public void SetTargetStreetCustomMarkerVisibility(boolean bShow, String hashKey) {
        if (this.f20000a != 0) {
            this.f20001b.setTargetStreetCustomMarkerVisibility(bShow, hashKey);
        }
    }

    public void AddStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (this.f20000a != 0) {
            this.f20001b.addStreetCustomMarker(bundle, bitmap);
        }
    }

    public void RemoveStreetCustomMaker(String hashkey) {
        this.f20001b.removeStreetCustomMaker(hashkey);
    }

    public void RemoveStreetAllCustomMarker() {
        this.f20001b.removeStreetAllCustomMarker();
    }

    public void SetStreetMarkerClickable(String hashkey, boolean bClickable) {
        this.f20001b.setStreetMarkerClickable(hashkey, bClickable);
    }

    public boolean IsStreetArrowShown() {
        return this.f20001b.isStreetArrowShown();
    }

    public void SetStreetArrowShow(boolean show) {
        this.f20001b.setStreetArrowShow(show);
    }

    public boolean IsStreetRoadClickable() {
        return this.f20001b.isStreetRoadClickable();
    }

    public void SetStreetRoadClickable(boolean bClickable) {
        this.f20001b.setStreetRoadClickable(bClickable);
    }

    public boolean IsStreetCustomMarkerShown() {
        return this.f20001b.isStreetCustomMarkerShown();
    }

    public void closeParticleEffect(String particleName) {
        this.f20001b.closeParticleEffect(particleName);
    }

    public boolean showParticleEffect(int actionType) {
        return this.f20001b.showParticleEffect(actionType);
    }

    public boolean showParticleEffectByType(int actionType) {
        return this.f20001b.showParticleEffectByType(actionType);
    }

    public boolean showParticleEffectByName(String particleName, boolean bShow) {
        return this.f20001b.showParticleEffectByName(particleName, bShow);
    }

    public void showTrafficUGCMap(boolean bShow) {
        this.f20001b.showTrafficUGCMap(bShow);
    }

    public void setTrafficUGCData(String jsonContent) {
        this.f20001b.setTrafficUGCData(jsonContent);
    }

    public void unFocusTrafficUGCLabel() {
        this.f20001b.unFocusTrafficUGCLabel();
    }

    public void focusTrafficUGCLabel() {
        this.f20001b.focusTrafficUGCLabel();
    }

    public void setMapScene(int modeId) {
        this.f20001b.setMapScene(modeId);
    }

    public boolean importMapTheme(int themeId) {
        return this.f20001b.importMapTheme(themeId);
    }

    public boolean setMapTheme(int themeId, Bundle bundle) {
        return this.f20001b.setMapTheme(themeId, bundle);
    }

    public boolean setMapThemeScene(int themeId, int sceneId, Bundle bundle) {
        return this.f20001b.setMapThemeScene(themeId, sceneId, bundle);
    }

    public int getMapScene() {
        return this.f20001b.getMapScene();
    }

    public int getMapTheme() {
        return this.f20001b.getMapTheme();
    }

    public boolean getMapBarData(Bundle bundle) {
        return this.f20001b.getMapBarData(bundle);
    }

    public boolean performAction(String action) {
        return this.f20001b.performAction(action);
    }

    public boolean isAnimationRunning() {
        return this.f20001b.isAnimationRunning();
    }

    public String getProjectionPt(String content) {
        return this.f20001b.getProjectionPt(content);
    }

    public boolean isNaviMode() {
        return this.f20001b.isNaviMode();
    }
}
