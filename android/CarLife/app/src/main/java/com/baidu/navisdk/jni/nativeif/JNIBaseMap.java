package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.nplatform.comjni.map.basemap.BaseMapCallback;
import com.baidu.nplatform.comjni.map.basemap.MapLayerDataInterface;

public class JNIBaseMap
{
  private BaseMapCallback mCallback = null;
  
  public JNIBaseMap()
  {
    this.mCallback = new BaseMapCallback();
    SetCallback(this.mCallback);
  }
  
  public JNIBaseMap(Boolean paramBoolean) {}
  
  public static native void ColladaDraw();
  
  public static native void ColladaEnable(boolean paramBoolean);
  
  public static native void ColladaInit(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native boolean ColladaModuleInit(String paramString);
  
  public static native void ColladaModuleUnload();
  
  public static native void ColladaResize(int paramInt1, int paramInt2);
  
  public static native int GLDraw();
  
  public static native int GLDrawMinimap();
  
  public static native void GLInit();
  
  public static native void GLResize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void MinimapGLResize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void UpdateNeedRender(boolean paramBoolean);
  
  public native void AddItemData(Object paramObject);
  
  public native int AddLayer(int paramInt1, int paramInt2, String paramString);
  
  public native boolean AddPopupData(Object paramObject);
  
  public native boolean AnimationTo(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public native boolean CancelMapJump();
  
  public native int CleanAfterDBClick(float paramFloat1, float paramFloat2);
  
  public native boolean ClearLayer(int paramInt);
  
  public native boolean ClearLayerByID(int paramInt);
  
  public native void DragMap(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
  
  public native boolean EnterStreetScapeMap();
  
  public native boolean EnterStreetScapeWaitingMode();
  
  public native boolean ExitStreetScapeMap();
  
  public native boolean FocusItem(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native String GetCurrentStreetId();
  
  public native boolean GetCurrentStreetInfo(Object paramObject, String paramString);
  
  public native boolean GetGeoPosByScreenPos(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public boolean GetMapStatus(Object paramObject)
  {
    return GetMapStatus(paramObject, true);
  }
  
  public native boolean GetMapStatus(Object paramObject, boolean paramBoolean);
  
  public native boolean GetNearlyObjIDStreet(int paramInt1, long paramLong1, long paramLong2, Object paramObject, int paramInt2);
  
  public native boolean GetScreenMask(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Object paramObject);
  
  public native boolean GetScreenPosByGeoPos(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native boolean GetScreenShot(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public native float GetZoomLevel();
  
  public native float GetZoomToBound(Object paramObject, float paramFloat1, float paramFloat2);
  
  public native boolean ImportVmpMapRecord();
  
  public native boolean IsInStreepScapeMode();
  
  public native boolean LayerIsShow(int paramInt);
  
  public native boolean Locate(int paramInt1, int paramInt2);
  
  public native int MapProc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  public native boolean MouseEvent(int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean Move(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native boolean MoveTo(int paramInt1, int paramInt2);
  
  public native void OnPause();
  
  public native void OnPauseMinimapReq();
  
  public native void OnResume();
  
  public native void OnResumeMinimapReq();
  
  public native boolean QueryThumbImage(String paramString);
  
  public native boolean ReleaseSharedMapData(int paramInt1, int paramInt2);
  
  public native boolean RemoveItemData(Object paramObject);
  
  public native int RemoveLayer(int paramInt);
  
  public native boolean RemoveVmpMapRecord(int paramInt);
  
  public native boolean ResetCompassPosition(int paramInt1, int paramInt2, int paramInt3);
  
  public native void ResetGLHandleWhenCreateOrDestroyContext(boolean paramBoolean);
  
  public native boolean ResetImageRes();
  
  public native boolean ResetScalePosition(int paramInt1, int paramInt2);
  
  public native void SaveCache();
  
  public native boolean SaveScreen(String paramString);
  
  public native boolean SaveScreenToBuffer();
  
  public native String ScrPtToGeoPoint(int paramInt1, int paramInt2);
  
  public native Object SelectItem(int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean SetAnimationGlobalSwitch(boolean paramBoolean);
  
  public native int SetCallback(Object paramObject);
  
  public native boolean SetCharsetEncodeType(boolean paramBoolean);
  
  public native boolean SetDrawHouse(boolean paramBoolean1, boolean paramBoolean2);
  
  public native void SetDrawNaviLogo(boolean paramBoolean);
  
  public native void SetEnlargedStatus(boolean paramBoolean);
  
  public native void SetIfInterruptAutoLevel(boolean paramBoolean);
  
  public native boolean SetLevel(float paramFloat);
  
  public boolean SetMapLayerDataCallback(MapLayerDataInterface paramMapLayerDataInterface)
  {
    if (paramMapLayerDataInterface == null) {
      return false;
    }
    return this.mCallback.SetMapCallback(paramMapLayerDataInterface);
  }
  
  public native boolean SetMapStatus(Object paramObject);
  
  public native void SetMemoryScale(int paramInt);
  
  public native boolean SetMinimapWinSize(int paramInt1, int paramInt2);
  
  public native boolean SetPreRoutePlanStatus(boolean paramBoolean);
  
  public native void SetShowTrackBrake(boolean paramBoolean);
  
  public native void SetShowTrackCurve(boolean paramBoolean);
  
  public native void SetShowTrackMaxSpeed(boolean paramBoolean);
  
  public native void SetShowTrackOverSpeed(boolean paramBoolean);
  
  public native void SetShowTrackRapidAcc(boolean paramBoolean);
  
  public native boolean SetStreetPOIUID(String paramString);
  
  @Deprecated
  public native boolean SetStyleMode(int paramInt);
  
  public native boolean ShowLayer(int paramInt, boolean paramBoolean);
  
  public native boolean ShowLayerByID(int paramInt, boolean paramBoolean);
  
  public native void ShowTrafficMap(boolean paramBoolean1, boolean paramBoolean2);
  
  public native void StartMapDataRequest();
  
  public native void StopMapDataRequest();
  
  public native void SwitchITSMode(boolean paramBoolean);
  
  public native boolean SwitchStreetScapeWithStreedId(String paramString);
  
  public native boolean SwitchToStreetScapeWithUID(String paramString1, String paramString2);
  
  public native boolean UpdataBaseLayers();
  
  public native void UpdateChosenMultiRouteID(int paramInt);
  
  public native boolean UpdateLayer(int paramInt);
  
  public native boolean UpdateLayerByID(int paramInt);
  
  public native boolean UpdateShareMapData(int paramInt1, int paramInt2);
  
  public native boolean Zoom(float paramFloat);
  
  public native boolean ZoomIn();
  
  public native boolean ZoomInByPos(int paramInt1, int paramInt2);
  
  public native boolean ZoomOut();
  
  public native boolean ZoomOutByPos(int paramInt1, int paramInt2);
  
  public native boolean ZoomToBound(Object paramObject);
  
  public native void ZoomToFullView(Object paramObject);
  
  public native boolean ZoomToTrajectory();
  
  public native boolean allViewSerialAnimation();
  
  public native int clearCarImage();
  
  public native void createMiniMapControl();
  
  public native void destroyMiniMapControl();
  
  public native boolean getScreenShotImage(Bundle paramBundle);
  
  public native int getStyleMode();
  
  public native void mapClickEvent(int paramInt);
  
  public native boolean preNextRouteDetail(boolean paramBoolean);
  
  public native boolean resetRouteDetailIndex(boolean paramBoolean);
  
  public native void sendCommandToMapEngine(int paramInt, Bundle paramBundle);
  
  public native void setAutoLevelEnable(boolean paramBoolean);
  
  public native int setCarImageToMap(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4);
  
  @Deprecated
  public native void setClientBoardLength(int paramInt);
  
  public native boolean setDragMapStatus(boolean paramBoolean);
  
  public native void setHighLightRoute(int paramInt1, int paramInt2);
  
  public native void setMapDrawScreenRect(Object paramObject);
  
  public native void setMapShowScreenRect(Object paramObject);
  
  public native boolean setNaviCarPos();
  
  public native boolean setNaviMapMode(int paramInt);
  
  public native boolean setNaviStatus(boolean paramBoolean);
  
  public native boolean setNightMode(boolean paramBoolean);
  
  public native boolean setRedLineRender(boolean paramBoolean);
  
  public native boolean setRouteDetailIndex(int paramInt);
  
  public native boolean setScreenShotParam(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4);
  
  public native boolean setScreenShow(Bundle paramBundle);
  
  public native boolean setSlightScreenStatus(int paramInt);
  
  @Deprecated
  public native void setTranslucentHeight(int paramInt);
  
  public native boolean stopAllAnimation();
  
  public native void zoomToSlightNaviFullView(Bundle paramBundle, boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNIBaseMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */