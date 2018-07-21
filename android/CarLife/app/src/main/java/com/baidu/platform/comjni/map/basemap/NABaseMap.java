package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.platform.comapi.map.OverlayMapCallBack;

class NABaseMap
  extends com.baidu.platform.comjni.a
{
  private int a;
  
  private native void nativeAddItemData(long paramLong, Bundle paramBundle);
  
  private native int nativeAddLayer(long paramLong, int paramInt1, int paramInt2, String paramString);
  
  private native void nativeAddPopupData(long paramLong, Bundle paramBundle);
  
  private native void nativeAddRtPopData(long paramLong, Bundle paramBundle);
  
  private native void nativeAddStreetCustomMarker(long paramLong, Bundle paramBundle, Bitmap paramBitmap);
  
  private native void nativeAttachDC(long paramLong1, long paramLong2);
  
  private native boolean nativeCleanCache(long paramLong, int paramInt);
  
  private native void nativeClearLayer(long paramLong, int paramInt);
  
  private native void nativeClearLocationLayerData(long paramLong, Bundle paramBundle);
  
  private native void nativeClearMistmapLayer(long paramLong);
  
  private native boolean nativeCloseCache(long paramLong);
  
  private native void nativeCloseParticleEffect(long paramLong, String paramString);
  
  private native int nativeCreate();
  
  private native int nativeCreateDuplicate(long paramLong);
  
  private native int nativeDraw(long paramLong);
  
  private native void nativeFocusTrafficUGCLabel(long paramLong);
  
  private native String nativeGeoPtToScrPoint(long paramLong, int paramInt1, int paramInt2);
  
  private native float nativeGetAdapterZoomUnitsEx(long paramLong);
  
  private native int nativeGetCacheSize(long paramLong, int paramInt);
  
  private native String nativeGetCityInfoByID(long paramLong, int paramInt);
  
  private native float nativeGetFZoomToBoundF(long paramLong, Bundle paramBundle1, Bundle paramBundle2);
  
  private native String nativeGetFocusedBaseIndoorMapInfo(long paramLong);
  
  private native int nativeGetLayerPos(long paramLong, int paramInt);
  
  private native boolean nativeGetMapBarData(long paramLong, Bundle paramBundle);
  
  private native int nativeGetMapRenderType(long paramLong);
  
  private native int nativeGetMapScene(long paramLong);
  
  private native Bundle nativeGetMapStatus(long paramLong);
  
  private native int nativeGetMapTheme(long paramLong);
  
  private native String nativeGetNearlyObjID(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native String nativeGetProjectionPt(long paramLong, String paramString);
  
  private native int nativeGetVMPMapCityInfo(long paramLong, Bundle paramBundle);
  
  private native float nativeGetZoomToBound(long paramLong, Bundle paramBundle, int paramInt1, int paramInt2);
  
  private native float nativeGetZoomToBoundF(long paramLong, Bundle paramBundle);
  
  private native boolean nativeImportMapTheme(long paramLong, int paramInt);
  
  private native boolean nativeInit(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean);
  
  private native int nativeInitLayerCallback(long paramLong);
  
  private native int nativeInsertLayerAt(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  private native boolean nativeIsAnimationRunning(long paramLong);
  
  private native boolean nativeIsBaseIndoorMapMode(long paramLong);
  
  private native boolean nativeIsNaviMode(long paramLong);
  
  private native boolean nativeIsPointInFocusBarBorder(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  private native boolean nativeIsPointInFocusIDRBorder(long paramLong, double paramDouble1, double paramDouble2);
  
  private native boolean nativeIsStreetArrowShown(long paramLong);
  
  private native boolean nativeIsStreetCustomMarkerShown(long paramLong);
  
  private native boolean nativeIsStreetPOIMarkerShown(long paramLong);
  
  private native boolean nativeIsStreetRoadClickable(long paramLong);
  
  private native boolean nativeLayersIsShow(long paramLong, int paramInt);
  
  private native void nativeMoveToScrPoint(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeOnBackground(long paramLong);
  
  private native void nativeOnForeground(long paramLong);
  
  private native String nativeOnHotcityGet(long paramLong);
  
  private native void nativeOnPause(long paramLong);
  
  private native boolean nativeOnRecordAdd(long paramLong, int paramInt);
  
  private native String nativeOnRecordGetAll(long paramLong);
  
  private native String nativeOnRecordGetAt(long paramLong, int paramInt);
  
  private native boolean nativeOnRecordImport(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private native boolean nativeOnRecordReload(long paramLong, int paramInt, boolean paramBoolean);
  
  private native boolean nativeOnRecordRemove(long paramLong, int paramInt, boolean paramBoolean);
  
  private native boolean nativeOnRecordStart(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  private native boolean nativeOnRecordSuspend(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  private native void nativeOnResume(long paramLong);
  
  private native String nativeOnSchcityGet(long paramLong, String paramString);
  
  private native boolean nativeOnUsrcityMsgInterval(long paramLong, int paramInt);
  
  private native int nativeOnWifiRecordAdd(long paramLong, int paramInt);
  
  private native boolean nativePerformAction(long paramLong, String paramString);
  
  private native int nativeQueryInterface(long paramLong);
  
  private native int nativeRelease(long paramLong);
  
  private native boolean nativeRemoveItemData(long paramLong, Bundle paramBundle);
  
  private native int nativeRemoveLayer(long paramLong, int paramInt);
  
  private native void nativeRemoveStreetAllCustomMarker(long paramLong);
  
  private native void nativeRemoveStreetCustomMaker(long paramLong, String paramString);
  
  private native void nativeResetImageRes(long paramLong);
  
  private native boolean nativeResumeCache(long paramLong);
  
  private native boolean nativeSaveCache(long paramLong);
  
  private native void nativeSaveScreenToLocal(long paramLong, String paramString1, String paramString2);
  
  private native String nativeScrPtToGeoPoint(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetAllStreetCustomMarkerVisibility(long paramLong, boolean paramBoolean);
  
  private native String nativeSetFocus(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, Bundle paramBundle);
  
  private native boolean nativeSetItsPreTime(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native boolean nativeSetLayerSceneMode(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetLayersClickable(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativeSetLocationLayerData(long paramLong, Bundle paramBundle);
  
  private native int nativeSetMapControlMode(long paramLong, int paramInt);
  
  private native boolean nativeSetMapScene(long paramLong, int paramInt);
  
  private native void nativeSetMapStatus(long paramLong, Bundle paramBundle);
  
  private native boolean nativeSetMapTheme(long paramLong, int paramInt, Bundle paramBundle);
  
  private native boolean nativeSetMapThemeScene(long paramLong, int paramInt1, int paramInt2, Bundle paramBundle);
  
  private native void nativeSetStreetArrowShow(long paramLong, boolean paramBoolean);
  
  private native void nativeSetStreetMarkerClickable(long paramLong, String paramString, boolean paramBoolean);
  
  private native void nativeSetStreetRoadClickable(long paramLong, boolean paramBoolean);
  
  private native void nativeSetStyleMode(long paramLong, int paramInt);
  
  private native void nativeSetTargetStreetCustomMarkerVisibility(long paramLong, boolean paramBoolean, String paramString);
  
  private native void nativeSetTrafficUGCData(long paramLong, String paramString);
  
  private native void nativeShowBaseIndoorMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowHotMap(long paramLong, boolean paramBoolean, int paramInt);
  
  private native void nativeShowHotMapWithUid(long paramLong, boolean paramBoolean, int paramInt, String paramString);
  
  private native void nativeShowLayers(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativeShowMistMap(long paramLong, boolean paramBoolean, String paramString);
  
  private native boolean nativeShowParticleEffect(long paramLong, int paramInt);
  
  private native boolean nativeShowParticleEffectByName(long paramLong, String paramString, boolean paramBoolean);
  
  private native boolean nativeShowParticleEffectByType(long paramLong, int paramInt);
  
  private native void nativeShowSatelliteMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowStreetPOIMarker(long paramLong, boolean paramBoolean);
  
  private native void nativeShowStreetRoadMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowTrafficMap(long paramLong, boolean paramBoolean);
  
  private native void nativeShowTrafficUGCMap(long paramLong, boolean paramBoolean);
  
  private native void nativeStartIndoorAnimation(long paramLong);
  
  private native boolean nativeSwitchBaseIndoorMapFloor(long paramLong, String paramString1, String paramString2);
  
  private native boolean nativeSwitchLayer(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeUnFocusTrafficUGCLabel(long paramLong);
  
  private native void nativeUpdateLayers(long paramLong, int paramInt);
  
  private native String nativeworldPointToScreenPoint(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public void addItemData(Bundle paramBundle)
  {
    nativeAddItemData(this.a, paramBundle);
  }
  
  public int addLayer(int paramInt1, int paramInt2, String paramString)
  {
    return nativeAddLayer(this.a, paramInt1, paramInt2, paramString);
  }
  
  public void addPopupData(Bundle paramBundle)
  {
    nativeAddPopupData(this.a, paramBundle);
  }
  
  public void addRtPopData(Bundle paramBundle)
  {
    nativeAddRtPopData(this.a, paramBundle);
  }
  
  public void addStreetCustomMarker(Bundle paramBundle, Bitmap paramBitmap)
  {
    if (this.a != 0) {
      nativeAddStreetCustomMarker(this.a, paramBundle, paramBitmap);
    }
  }
  
  public boolean cleanCache(int paramInt)
  {
    return nativeCleanCache(this.a, paramInt);
  }
  
  public void clearLayer(int paramInt)
  {
    nativeClearLayer(this.a, paramInt);
  }
  
  public void clearLocationLayerData(Bundle paramBundle)
  {
    nativeClearLocationLayerData(this.a, paramBundle);
  }
  
  public void clearMistmapLayer()
  {
    nativeClearMistmapLayer(this.a);
  }
  
  public boolean closeCache()
  {
    return nativeCloseCache(this.a);
  }
  
  public void closeParticleEffect(String paramString)
  {
    nativeCloseParticleEffect(this.a, paramString);
  }
  
  public int create()
  {
    this.a = nativeCreate();
    nativeInitLayerCallback(this.a);
    return this.a;
  }
  
  public int createByDuplicate(int paramInt)
  {
    this.a = nativeCreateDuplicate(paramInt);
    if (this.a != 0) {
      nativeInitLayerCallback(this.a);
    }
    return this.a;
  }
  
  public long createDuplicate()
  {
    return nativeCreateDuplicate(this.a);
  }
  
  public int dispose()
  {
    if (this.a != 0)
    {
      int i = nativeRelease(this.a);
      this.a = 0;
      return i;
    }
    return 0;
  }
  
  public int draw()
  {
    if (this.a != 0) {
      return nativeDraw(this.a);
    }
    return 0;
  }
  
  public void focusTrafficUGCLabel()
  {
    nativeFocusTrafficUGCLabel(this.a);
  }
  
  public String geoPtToScrPoint(int paramInt1, int paramInt2)
  {
    return nativeGeoPtToScrPoint(this.a, paramInt1, paramInt2);
  }
  
  public float getAdapterZoomUnitsEx()
  {
    return nativeGetAdapterZoomUnitsEx(this.a);
  }
  
  public int getCacheSize(int paramInt)
  {
    return nativeGetCacheSize(this.a, paramInt);
  }
  
  public String getCityInfoByID(int paramInt)
  {
    return nativeGetCityInfoByID(this.a, paramInt);
  }
  
  public float getFZoomToBoundF(Bundle paramBundle1, Bundle paramBundle2)
  {
    return nativeGetFZoomToBoundF(this.a, paramBundle1, paramBundle2);
  }
  
  public String getFocusedBaseIndoorMapInfo()
  {
    if (this.a != 0) {
      return nativeGetFocusedBaseIndoorMapInfo(this.a);
    }
    return null;
  }
  
  public int getLayerPos(int paramInt)
  {
    return nativeGetLayerPos(this.a, paramInt);
  }
  
  public boolean getMapBarData(Bundle paramBundle)
  {
    return nativeGetMapBarData(this.a, paramBundle);
  }
  
  public int getMapRenderType()
  {
    return nativeGetMapRenderType(this.a);
  }
  
  public int getMapScene()
  {
    return nativeGetMapScene(this.a);
  }
  
  public Bundle getMapStatus()
  {
    return nativeGetMapStatus(this.a);
  }
  
  public int getMapTheme()
  {
    return nativeGetMapTheme(this.a);
  }
  
  public int getNativeMapPointer()
  {
    return this.a;
  }
  
  public String getNearlyObjID(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return nativeGetNearlyObjID(this.a, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public String getProjectionPt(String paramString)
  {
    return nativeGetProjectionPt(this.a, paramString);
  }
  
  public int getVMPMapCityInfo(Bundle paramBundle)
  {
    return nativeGetVMPMapCityInfo(this.a, paramBundle);
  }
  
  public float getZoomToBound(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    return nativeGetZoomToBound(this.a, paramBundle, paramInt1, paramInt2);
  }
  
  public float getZoomToBoundF(Bundle paramBundle)
  {
    return nativeGetZoomToBoundF(this.a, paramBundle);
  }
  
  public boolean importMapTheme(int paramInt)
  {
    return nativeImportMapTheme(this.a, paramInt);
  }
  
  public boolean init(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    return (this.a != 0) && (nativeInit(this.a, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean));
  }
  
  public int insertLayerAt(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return nativeInsertLayerAt(this.a, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public boolean isAnimationRunning()
  {
    return nativeIsAnimationRunning(this.a);
  }
  
  public boolean isBaseIndoorMapMode()
  {
    return (this.a != 0) && (nativeIsBaseIndoorMapMode(this.a));
  }
  
  public boolean isNaviMode()
  {
    return nativeIsNaviMode(this.a);
  }
  
  public boolean isPointInFocusBarBorder(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (this.a != 0) && (nativeIsPointInFocusBarBorder(this.a, paramDouble1, paramDouble2, paramDouble3));
  }
  
  public boolean isPointInFocusIDRBorder(double paramDouble1, double paramDouble2)
  {
    return (this.a != 0) && (nativeIsPointInFocusIDRBorder(this.a, paramDouble1, paramDouble2));
  }
  
  public boolean isStreetArrowShown()
  {
    return nativeIsStreetArrowShown(this.a);
  }
  
  public boolean isStreetCustomMarkerShown()
  {
    return nativeIsStreetCustomMarkerShown(this.a);
  }
  
  public boolean isStreetPOIMarkerShown()
  {
    return (this.a != 0) && (nativeIsStreetPOIMarkerShown(this.a));
  }
  
  public boolean isStreetRoadClickable()
  {
    return nativeIsStreetRoadClickable(this.a);
  }
  
  public boolean layersIsShow(int paramInt)
  {
    return nativeLayersIsShow(this.a, paramInt);
  }
  
  public void moveToScrPoint(int paramInt1, int paramInt2)
  {
    nativeMoveToScrPoint(this.a, paramInt1, paramInt2);
  }
  
  public void onBackground()
  {
    if (this.a != 0) {
      nativeOnBackground(this.a);
    }
  }
  
  public void onForeground()
  {
    if (this.a != 0) {
      nativeOnForeground(this.a);
    }
  }
  
  public String onHotcityGet()
  {
    return nativeOnHotcityGet(this.a);
  }
  
  public void onPause()
  {
    if (this.a != 0) {
      nativeOnPause(this.a);
    }
  }
  
  public boolean onRecordAdd(int paramInt)
  {
    return nativeOnRecordAdd(this.a, paramInt);
  }
  
  public String onRecordGetAll()
  {
    return nativeOnRecordGetAll(this.a);
  }
  
  public String onRecordGetAt(int paramInt)
  {
    return nativeOnRecordGetAt(this.a, paramInt);
  }
  
  public boolean onRecordImport(boolean paramBoolean1, boolean paramBoolean2)
  {
    return nativeOnRecordImport(this.a, paramBoolean1, paramBoolean2);
  }
  
  public boolean onRecordReload(int paramInt, boolean paramBoolean)
  {
    return nativeOnRecordReload(this.a, paramInt, paramBoolean);
  }
  
  public boolean onRecordRemove(int paramInt, boolean paramBoolean)
  {
    return nativeOnRecordRemove(this.a, paramInt, paramBoolean);
  }
  
  public boolean onRecordStart(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return nativeOnRecordStart(this.a, paramInt1, paramBoolean, paramInt2);
  }
  
  public boolean onRecordSuspend(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return nativeOnRecordSuspend(this.a, paramInt1, paramBoolean, paramInt2);
  }
  
  public void onResume()
  {
    if (this.a != 0) {
      nativeOnResume(this.a);
    }
  }
  
  public String onSchcityGet(String paramString)
  {
    return nativeOnSchcityGet(this.a, paramString);
  }
  
  public boolean onUsrcityMsgInterval(int paramInt)
  {
    return nativeOnUsrcityMsgInterval(this.a, paramInt);
  }
  
  public int onWifiRecordAdd(int paramInt)
  {
    return nativeOnWifiRecordAdd(this.a, paramInt);
  }
  
  public boolean performAction(String paramString)
  {
    return nativePerformAction(this.a, paramString);
  }
  
  public boolean removeItemData(Bundle paramBundle)
  {
    return nativeRemoveItemData(this.a, paramBundle);
  }
  
  public int removeLayer(int paramInt)
  {
    return nativeRemoveLayer(this.a, paramInt);
  }
  
  public void removeStreetAllCustomMarker()
  {
    nativeRemoveStreetAllCustomMarker(this.a);
  }
  
  public void removeStreetCustomMaker(String paramString)
  {
    nativeRemoveStreetCustomMaker(this.a, paramString);
  }
  
  public void resetImageRes()
  {
    if (this.a != 0) {
      nativeResetImageRes(this.a);
    }
  }
  
  public boolean resumeCache()
  {
    return nativeResumeCache(this.a);
  }
  
  public boolean saveCache()
  {
    try
    {
      boolean bool = nativeSaveCache(this.a);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.baidu.platform.comjni.util.a.a(localThrowable);
    }
    return false;
  }
  
  public void saveScreenToLocal(String paramString1, String paramString2)
  {
    nativeSaveScreenToLocal(this.a, paramString1, paramString2);
  }
  
  public String scrPtToGeoPoint(int paramInt1, int paramInt2)
  {
    return nativeScrPtToGeoPoint(this.a, paramInt1, paramInt2);
  }
  
  public void setAllStreetCustomMarkerVisibility(boolean paramBoolean)
  {
    if (this.a != 0) {
      nativeSetAllStreetCustomMarkerVisibility(this.a, paramBoolean);
    }
  }
  
  public void setCallback(OverlayMapCallBack paramOverlayMapCallBack)
  {
    BaseMapCallback.setMapCallback(this.a, paramOverlayMapCallBack);
  }
  
  public String setFocus(int paramInt1, int paramInt2, boolean paramBoolean, Bundle paramBundle)
  {
    return nativeSetFocus(this.a, paramInt1, paramInt2, paramBoolean, paramBundle);
  }
  
  public boolean setItsPreTime(int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeSetItsPreTime(this.a, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean setLayerSceneMode(int paramInt1, int paramInt2)
  {
    return nativeSetLayerSceneMode(this.a, paramInt1, paramInt2);
  }
  
  public void setLayersClickable(int paramInt, boolean paramBoolean)
  {
    nativeSetLayersClickable(this.a, paramInt, paramBoolean);
  }
  
  public void setLocationLayerData(Bundle paramBundle)
  {
    nativeSetLocationLayerData(this.a, paramBundle);
  }
  
  public int setMapControlMode(int paramInt)
  {
    return nativeSetMapControlMode(this.a, paramInt);
  }
  
  public void setMapScene(int paramInt)
  {
    nativeSetMapScene(this.a, paramInt);
  }
  
  public void setMapStatus(Bundle paramBundle)
  {
    nativeSetMapStatus(this.a, paramBundle);
  }
  
  public boolean setMapTheme(int paramInt, Bundle paramBundle)
  {
    return nativeSetMapTheme(this.a, paramInt, paramBundle);
  }
  
  public boolean setMapThemeScene(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return nativeSetMapThemeScene(this.a, paramInt1, paramInt2, paramBundle);
  }
  
  public void setStreetArrowShow(boolean paramBoolean)
  {
    nativeSetStreetArrowShow(this.a, paramBoolean);
  }
  
  public void setStreetMarkerClickable(String paramString, boolean paramBoolean)
  {
    nativeSetStreetMarkerClickable(this.a, paramString, paramBoolean);
  }
  
  public void setStreetRoadClickable(boolean paramBoolean)
  {
    nativeSetStreetRoadClickable(this.a, paramBoolean);
  }
  
  public void setStyleMode(int paramInt)
  {
    nativeSetStyleMode(this.a, paramInt);
  }
  
  public void setTargetStreetCustomMarkerVisibility(boolean paramBoolean, String paramString)
  {
    if (this.a != 0) {
      nativeSetTargetStreetCustomMarkerVisibility(this.a, paramBoolean, paramString);
    }
  }
  
  public void setTrafficUGCData(String paramString)
  {
    nativeSetTrafficUGCData(this.a, paramString);
  }
  
  public void showBaseIndoorMap(boolean paramBoolean)
  {
    nativeShowBaseIndoorMap(this.a, paramBoolean);
  }
  
  public void showHotMap(boolean paramBoolean, int paramInt)
  {
    nativeShowHotMap(this.a, paramBoolean, paramInt);
  }
  
  public void showHotMap(boolean paramBoolean, int paramInt, String paramString)
  {
    nativeShowHotMapWithUid(this.a, paramBoolean, paramInt, paramString);
  }
  
  public void showLayers(int paramInt, boolean paramBoolean)
  {
    if (this.a != 0) {
      nativeShowLayers(this.a, paramInt, paramBoolean);
    }
  }
  
  public void showMistMap(boolean paramBoolean, String paramString)
  {
    nativeShowMistMap(this.a, paramBoolean, paramString);
  }
  
  public boolean showParticleEffect(int paramInt)
  {
    return nativeShowParticleEffect(this.a, paramInt);
  }
  
  public boolean showParticleEffectByName(String paramString, boolean paramBoolean)
  {
    return nativeShowParticleEffectByName(this.a, paramString, paramBoolean);
  }
  
  public boolean showParticleEffectByType(int paramInt)
  {
    return nativeShowParticleEffectByType(this.a, paramInt);
  }
  
  public void showSatelliteMap(boolean paramBoolean)
  {
    nativeShowSatelliteMap(this.a, paramBoolean);
  }
  
  public void showStreetPOIMarker(boolean paramBoolean)
  {
    if (this.a != 0) {
      nativeShowStreetPOIMarker(this.a, paramBoolean);
    }
  }
  
  public void showStreetRoadMap(boolean paramBoolean)
  {
    nativeShowStreetRoadMap(this.a, paramBoolean);
  }
  
  public void showTrafficMap(boolean paramBoolean)
  {
    nativeShowTrafficMap(this.a, paramBoolean);
  }
  
  public void showTrafficUGCMap(boolean paramBoolean)
  {
    nativeShowTrafficUGCMap(this.a, paramBoolean);
  }
  
  public void startIndoorAnimation()
  {
    nativeStartIndoorAnimation(this.a);
  }
  
  public boolean switchBaseIndoorMapFloor(String paramString1, String paramString2)
  {
    return nativeSwitchBaseIndoorMapFloor(this.a, paramString1, paramString2);
  }
  
  public boolean switchLayer(int paramInt1, int paramInt2)
  {
    return nativeSwitchLayer(this.a, paramInt1, paramInt2);
  }
  
  public void unFocusTrafficUGCLabel()
  {
    nativeUnFocusTrafficUGCLabel(this.a);
  }
  
  public void updateLayers(int paramInt)
  {
    nativeUpdateLayers(this.a, paramInt);
  }
  
  public String worldPointToScreenPoint(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return nativeworldPointToScreenPoint(this.a, paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/map/basemap/NABaseMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */