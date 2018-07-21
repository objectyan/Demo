package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;

public class AppBaseMap
{
  private int a = 0;
  private NABaseMap b = null;
  
  public void AddItemData(Bundle paramBundle)
  {
    this.b.addItemData(paramBundle);
  }
  
  public int AddLayer(int paramInt1, int paramInt2, String paramString)
  {
    return this.b.addLayer(paramInt1, paramInt2, paramString);
  }
  
  public void AddPopupData(Bundle paramBundle)
  {
    this.b.addPopupData(paramBundle);
  }
  
  public void AddRtPopData(Bundle paramBundle)
  {
    this.b.addRtPopData(paramBundle);
  }
  
  public void AddStreetCustomMarker(Bundle paramBundle, Bitmap paramBitmap)
  {
    if (this.a != 0) {
      this.b.addStreetCustomMarker(paramBundle, paramBitmap);
    }
  }
  
  public boolean CleanCache(int paramInt)
  {
    return this.b.cleanCache(paramInt);
  }
  
  public void ClearLayer(int paramInt)
  {
    this.b.clearLayer(paramInt);
  }
  
  public void ClearLocationLayerData(Bundle paramBundle)
  {
    this.b.clearLocationLayerData(paramBundle);
  }
  
  public void ClearMistmapLayer()
  {
    this.b.clearMistmapLayer();
  }
  
  public boolean CloseCache()
  {
    return this.b.closeCache();
  }
  
  public boolean Create()
  {
    this.a = this.b.create();
    return true;
  }
  
  public boolean CreateByDuplicate(int paramInt)
  {
    this.a = this.b.createByDuplicate(paramInt);
    return this.a != 0;
  }
  
  public long CreateDuplicate()
  {
    return this.b.createDuplicate();
  }
  
  public int Draw()
  {
    if (this.a != 0) {
      return this.b.draw();
    }
    return 0;
  }
  
  public String GeoPtToScrPoint(int paramInt1, int paramInt2)
  {
    return this.b.geoPtToScrPoint(paramInt1, paramInt2);
  }
  
  public float GetAdapterZoomUnitsEx()
  {
    return this.b.getAdapterZoomUnitsEx();
  }
  
  public int GetCacheSize(int paramInt)
  {
    return this.b.getCacheSize(paramInt);
  }
  
  public String GetCityInfoByID(int paramInt)
  {
    return this.b.getCityInfoByID(paramInt);
  }
  
  public float GetFZoomToBoundF(Bundle paramBundle1, Bundle paramBundle2)
  {
    return this.b.getFZoomToBoundF(paramBundle1, paramBundle2);
  }
  
  public String GetFocusedBaseIndoorMapInfo()
  {
    if (this.a != 0) {
      return this.b.getFocusedBaseIndoorMapInfo();
    }
    return null;
  }
  
  public int GetId()
  {
    return this.a;
  }
  
  public int GetLayerPos(int paramInt)
  {
    return this.b.getLayerPos(paramInt);
  }
  
  public int GetMapRenderType()
  {
    return this.b.getMapRenderType();
  }
  
  public Bundle GetMapStatus()
  {
    return this.b.getMapStatus();
  }
  
  public String GetNearlyObjID(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.b.getNearlyObjID(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int GetVMPMapCityInfo(Bundle paramBundle)
  {
    return this.b.getVMPMapCityInfo(paramBundle);
  }
  
  public float GetZoomToBound(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    return this.b.getZoomToBound(paramBundle, paramInt1, paramInt2);
  }
  
  public float GetZoomToBoundF(Bundle paramBundle)
  {
    return this.b.getZoomToBoundF(paramBundle);
  }
  
  public boolean Init(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    return (this.a != 0) && (this.b.init(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean));
  }
  
  public int InsertLayerAt(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return this.b.insertLayerAt(paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public boolean IsBaseIndoorMapMode()
  {
    return (this.a != 0) && (this.b.isBaseIndoorMapMode());
  }
  
  public boolean IsPointInFocusBarBorder(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (this.a != 0) && (this.b.isPointInFocusBarBorder(paramDouble1, paramDouble2, paramDouble3));
  }
  
  public boolean IsPointInFocusIDRBorder(double paramDouble1, double paramDouble2)
  {
    return (this.a != 0) && (this.b.isPointInFocusIDRBorder(paramDouble1, paramDouble2));
  }
  
  public boolean IsStreetArrowShown()
  {
    return this.b.isStreetArrowShown();
  }
  
  public boolean IsStreetCustomMarkerShown()
  {
    return this.b.isStreetCustomMarkerShown();
  }
  
  public boolean IsStreetPOIMarkerShown()
  {
    return (this.a != 0) && (this.b.isStreetPOIMarkerShown());
  }
  
  public boolean IsStreetRoadClickable()
  {
    return this.b.isStreetRoadClickable();
  }
  
  public boolean LayersIsShow(int paramInt)
  {
    return this.b.layersIsShow(paramInt);
  }
  
  public void MoveToScrPoint(int paramInt1, int paramInt2)
  {
    this.b.moveToScrPoint(paramInt1, paramInt2);
  }
  
  public void OnBackground()
  {
    if (this.a != 0) {
      this.b.onBackground();
    }
  }
  
  public void OnForeground()
  {
    if (this.a != 0) {
      this.b.onForeground();
    }
  }
  
  public String OnHotcityGet()
  {
    return this.b.onHotcityGet();
  }
  
  public void OnPause()
  {
    if (this.a != 0) {
      this.b.onPause();
    }
  }
  
  public boolean OnRecordAdd(int paramInt)
  {
    return this.b.onRecordAdd(paramInt);
  }
  
  public String OnRecordGetAll()
  {
    return this.b.onRecordGetAll();
  }
  
  public String OnRecordGetAt(int paramInt)
  {
    return this.b.onRecordGetAt(paramInt);
  }
  
  public boolean OnRecordImport(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.b.onRecordImport(paramBoolean1, paramBoolean2);
  }
  
  public boolean OnRecordReload(int paramInt, boolean paramBoolean)
  {
    return this.b.onRecordReload(paramInt, paramBoolean);
  }
  
  public boolean OnRecordRemove(int paramInt, boolean paramBoolean)
  {
    return this.b.onRecordRemove(paramInt, paramBoolean);
  }
  
  public boolean OnRecordStart(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.b.onRecordStart(paramInt1, paramBoolean, paramInt2);
  }
  
  public boolean OnRecordSuspend(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.b.onRecordSuspend(paramInt1, paramBoolean, paramInt2);
  }
  
  public void OnResume()
  {
    if (this.a != 0) {
      this.b.onResume();
    }
  }
  
  public String OnSchcityGet(String paramString)
  {
    return this.b.onSchcityGet(paramString);
  }
  
  public boolean OnUsrcityMsgInterval(int paramInt)
  {
    return this.b.onUsrcityMsgInterval(paramInt);
  }
  
  public int OnWifiRecordAdd(int paramInt)
  {
    return this.b.onWifiRecordAdd(paramInt);
  }
  
  public boolean Release()
  {
    boolean bool = false;
    if (this.a != 0)
    {
      this.b.dispose();
      this.a = 0;
      bool = true;
    }
    return bool;
  }
  
  public void Remo() {}
  
  public boolean RemoveItemData(Bundle paramBundle)
  {
    return this.b.removeItemData(paramBundle);
  }
  
  public int RemoveLayer(int paramInt)
  {
    return this.b.removeLayer(paramInt);
  }
  
  public void RemoveStreetAllCustomMarker()
  {
    this.b.removeStreetAllCustomMarker();
  }
  
  public void RemoveStreetCustomMaker(String paramString)
  {
    this.b.removeStreetCustomMaker(paramString);
  }
  
  public void ResetImageRes()
  {
    if (this.a != 0) {
      this.b.resetImageRes();
    }
  }
  
  public boolean ResumeCache()
  {
    return this.b.resumeCache();
  }
  
  public boolean SaveCache()
  {
    try
    {
      boolean bool = this.b.saveCache();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.baidu.platform.comjni.util.a.a(localThrowable);
    }
    return false;
  }
  
  public void SaveScreenToLocal(String paramString1, String paramString2)
  {
    this.b.saveScreenToLocal(paramString1, paramString2);
  }
  
  public String ScrPtToGeoPoint(int paramInt1, int paramInt2)
  {
    return this.b.scrPtToGeoPoint(paramInt1, paramInt2);
  }
  
  public void SetAllStreetCustomMarkerVisibility(boolean paramBoolean)
  {
    if (this.a != 0) {
      this.b.setAllStreetCustomMarkerVisibility(paramBoolean);
    }
  }
  
  public boolean SetCallback(a parama)
  {
    return (parama != null) && (this.a != 0) && (BaseMapCallback.setMapCallback(this.a, parama));
  }
  
  public String SetFocus(int paramInt1, int paramInt2, boolean paramBoolean, Bundle paramBundle)
  {
    return this.b.setFocus(paramInt1, paramInt2, paramBoolean, paramBundle);
  }
  
  public boolean SetItsPreTime(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.b.setItsPreTime(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean SetLayerSceneMode(int paramInt1, int paramInt2)
  {
    return this.b.setLayerSceneMode(paramInt1, paramInt2);
  }
  
  public void SetLayersClickable(int paramInt, boolean paramBoolean)
  {
    this.b.setLayersClickable(paramInt, paramBoolean);
  }
  
  public void SetLocationLayerData(Bundle paramBundle)
  {
    this.b.setLocationLayerData(paramBundle);
  }
  
  public int SetMapControlMode(int paramInt)
  {
    return this.b.setMapControlMode(paramInt);
  }
  
  public void SetMapStatus(Bundle paramBundle)
  {
    this.b.setMapStatus(paramBundle);
  }
  
  public void SetStreetArrowShow(boolean paramBoolean)
  {
    this.b.setStreetArrowShow(paramBoolean);
  }
  
  public void SetStreetMarkerClickable(String paramString, boolean paramBoolean)
  {
    this.b.setStreetMarkerClickable(paramString, paramBoolean);
  }
  
  public void SetStreetRoadClickable(boolean paramBoolean)
  {
    this.b.setStreetRoadClickable(paramBoolean);
  }
  
  public void SetStyleMode(int paramInt)
  {
    this.b.setStyleMode(paramInt);
  }
  
  public void SetTargetStreetCustomMarkerVisibility(boolean paramBoolean, String paramString)
  {
    if (this.a != 0) {
      this.b.setTargetStreetCustomMarkerVisibility(paramBoolean, paramString);
    }
  }
  
  public void ShowBaseIndoorMap(boolean paramBoolean)
  {
    this.b.showBaseIndoorMap(paramBoolean);
  }
  
  public void ShowHotMap(boolean paramBoolean, int paramInt)
  {
    this.b.showHotMap(paramBoolean, paramInt);
  }
  
  public void ShowHotMap(boolean paramBoolean, int paramInt, String paramString)
  {
    this.b.showHotMap(paramBoolean, paramInt, paramString);
  }
  
  public void ShowLayers(int paramInt, boolean paramBoolean)
  {
    if (this.a != 0) {
      this.b.showLayers(paramInt, paramBoolean);
    }
  }
  
  public void ShowMistMap(boolean paramBoolean, String paramString)
  {
    this.b.showMistMap(paramBoolean, paramString);
  }
  
  public void ShowSatelliteMap(boolean paramBoolean)
  {
    this.b.showSatelliteMap(paramBoolean);
  }
  
  public void ShowStreetPOIMarker(boolean paramBoolean)
  {
    if (this.a != 0) {
      this.b.showStreetPOIMarker(paramBoolean);
    }
  }
  
  public void ShowStreetRoadMap(boolean paramBoolean)
  {
    this.b.showStreetRoadMap(paramBoolean);
  }
  
  public void ShowTrafficMap(boolean paramBoolean)
  {
    this.b.showTrafficMap(paramBoolean);
  }
  
  public void StartIndoorAnimation()
  {
    this.b.startIndoorAnimation();
  }
  
  public boolean SwitchBaseIndoorMapFloor(String paramString1, String paramString2)
  {
    return this.b.switchBaseIndoorMapFloor(paramString1, paramString2);
  }
  
  public boolean SwitchLayer(int paramInt1, int paramInt2)
  {
    return this.b.switchLayer(paramInt1, paramInt2);
  }
  
  public void UpdateLayers(int paramInt)
  {
    this.b.updateLayers(paramInt);
  }
  
  public void closeParticleEffect(String paramString)
  {
    this.b.closeParticleEffect(paramString);
  }
  
  public void focusTrafficUGCLabel()
  {
    this.b.focusTrafficUGCLabel();
  }
  
  public boolean getMapBarData(Bundle paramBundle)
  {
    return this.b.getMapBarData(paramBundle);
  }
  
  public int getMapScene()
  {
    return this.b.getMapScene();
  }
  
  public int getMapTheme()
  {
    return this.b.getMapTheme();
  }
  
  public String getProjectionPt(String paramString)
  {
    return this.b.getProjectionPt(paramString);
  }
  
  public boolean importMapTheme(int paramInt)
  {
    return this.b.importMapTheme(paramInt);
  }
  
  public boolean isAnimationRunning()
  {
    return this.b.isAnimationRunning();
  }
  
  public boolean isNaviMode()
  {
    return this.b.isNaviMode();
  }
  
  public boolean performAction(String paramString)
  {
    return this.b.performAction(paramString);
  }
  
  public void setMapScene(int paramInt)
  {
    this.b.setMapScene(paramInt);
  }
  
  public boolean setMapTheme(int paramInt, Bundle paramBundle)
  {
    return this.b.setMapTheme(paramInt, paramBundle);
  }
  
  public boolean setMapThemeScene(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.b.setMapThemeScene(paramInt1, paramInt2, paramBundle);
  }
  
  public void setTrafficUGCData(String paramString)
  {
    this.b.setTrafficUGCData(paramString);
  }
  
  public boolean showParticleEffect(int paramInt)
  {
    return this.b.showParticleEffect(paramInt);
  }
  
  public boolean showParticleEffectByName(String paramString, boolean paramBoolean)
  {
    return this.b.showParticleEffectByName(paramString, paramBoolean);
  }
  
  public boolean showParticleEffectByType(int paramInt)
  {
    return this.b.showParticleEffectByType(paramInt);
  }
  
  public void showTrafficUGCMap(boolean paramBoolean)
  {
    this.b.showTrafficUGCMap(paramBoolean);
  }
  
  public void unFocusTrafficUGCLabel()
  {
    this.b.unFocusTrafficUGCLabel();
  }
  
  public String worldPointToScreenPoint(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return this.b.worldPointToScreenPoint(paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/map/basemap/AppBaseMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */