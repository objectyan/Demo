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
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class CruiseMapController
{
  private static final String TAG = "Cruise";
  private Context mContext;
  private CruiseMapView mCruiseMapView;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mIsCruiseEngineStarted = false;
  private BNMapObserver mMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (1 == paramAnonymousInt1) {}
      switch (paramAnonymousInt2)
      {
      case 262: 
      default: 
        if (2 == paramAnonymousInt1) {
          switch (paramAnonymousInt2)
          {
          }
        }
        break;
      }
      do
      {
        do
        {
          return;
          CruiseMapController.this.saveMapScaleLevel();
          if (CruiseMapController.this.mCruiseMapView != null) {
            CruiseMapController.this.mCruiseMapView.updateControlPanel();
          }
          BNMapController.getInstance().updateLayer(10);
          BNMapController.getInstance().UpdataBaseLayers();
          break;
          CruiseMapController.this.saveMapScaleLevel();
          if (CruiseMapController.this.mCruiseMapView != null) {
            CruiseMapController.this.mCruiseMapView.updateControlPanel();
          }
          BNMapController.getInstance().updateLayer(10);
          BNMapController.getInstance().UpdataBaseLayers();
          break;
          EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
          break;
        } while (CruiseMapController.this.mCruiseMapView == null);
        CruiseMapController.this.mCruiseMapView.resetLocMode();
        CruiseMapController.this.mCruiseMapView.showMapButtons();
        return;
      } while (CruiseMapController.this.mCruiseMapView == null);
      CruiseMapController.this.mCruiseMapView.showMapButtons();
      EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
    }
  };
  
  private void clearPoiBkg()
  {
    BNPoiSearcher.getInstance().clearBkgCache();
    BNPoiSearcher.getInstance().clearPoiCache();
  }
  
  public static CruiseMapController getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private long getMapXOffset(boolean paramBoolean)
  {
    long l = 0L;
    if (!paramBoolean) {
      l = ScreenUtil.getInstance().getHeightPixels() / 6;
    }
    LogUtil.e("Cruise", "getMapXOffset: isPortrait " + paramBoolean + ", X offset " + l);
    return l;
  }
  
  private void setMapInitScaleLevel()
  {
    LogUtil.e("Cruise", "setMapInitScaleLevel");
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    if (localMapStatus == null)
    {
      LogUtil.e("Cruise", "setMapInitScaleLevel fail mapStatus is null");
      return;
    }
    localMapStatus._Rotation = 0;
    BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
  }
  
  public void changeToCar3DView(LocData paramLocData, boolean paramBoolean)
  {
    LogUtil.e("Cruise", "changeToCar3DView with locData, anim " + paramBoolean);
    setMapStatus(paramLocData, false, paramBoolean);
    BNRouteGuider.getInstance().setRotateMode(0);
    PreferenceHelper.getInstance(this.mContext).putBoolean("SP_Last_Cruise_Map_Status", false);
  }
  
  public void changeToCar3DView(boolean paramBoolean)
  {
    changeToCar3DView(getCarPointLocation(), paramBoolean);
  }
  
  public void changeToNorth2DView()
  {
    LogUtil.e("Cruise", "changeToNorth2DView");
    setMapStatus(getCarPointLocation(), true, true);
    BNRouteGuider.getInstance().setRotateMode(1);
    PreferenceHelper.getInstance(this.mContext).putBoolean("SP_Last_Cruise_Map_Status", true);
  }
  
  public LocData getCarPointLocation()
  {
    if (this.mIsCruiseEngineStarted)
    {
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 0;
      int[] arrayOfInt2 = new int[1];
      arrayOfInt2[0] = 0;
      if ((BNRouteGuider.getInstance().getCarPoint(arrayOfInt1, arrayOfInt2)) && (arrayOfInt1[0] != 0) && (arrayOfInt2[0] != 0))
      {
        LogUtil.e("Cruise", "getCarPointLocation: Engine value is valid");
        LocData localLocData = new LocData();
        localLocData.longitude = (arrayOfInt1[0] / 100000.0D);
        localLocData.latitude = (arrayOfInt2[0] / 100000.0D);
        return localLocData;
      }
    }
    LogUtil.e("Cruise", "getCarPointLocation: Engine value is invalid, engineStarted " + this.mIsCruiseEngineStarted);
    return GeoLocateModel.getInstance().getLastLocation();
  }
  
  public void handleCruiseVoiceChanged(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.handleCruiseVoiceChanged(paramBoolean1, paramBoolean2);
    }
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mCruiseMapView = null;
    this.mIsCruiseEngineStarted = false;
  }
  
  public void initMapStatus()
  {
    BNRouteGuider.getInstance().SetFullViewState(false);
    BNMapController.getInstance().enableTouchEventLookover(true);
    BNRouteGuider.getInstance().setBrowseStatus(true);
    boolean bool = PreferenceHelper.getInstance(this.mContext).getBoolean("SP_Last_Cruise_Map_Status", true);
    LogUtil.e("Cruise", "initMapStatus: isNorth2D " + bool);
    if (bool) {
      changeToNorth2DView();
    }
    for (;;)
    {
      if (this.mIsCruiseEngineStarted) {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("initMapStatus-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            LogUtil.e(TAG, "initMapStatus post task:  setBrowseStatus false");
            BNRouteGuider.getInstance().setBrowseStatus(false);
            return null;
          }
        }, new BNWorkerConfig(8, 0), 1000L);
      }
      return;
      changeToCar3DView(getCarPointLocation(), false);
    }
  }
  
  public void initMapView()
  {
    boolean bool = true;
    LogUtil.e("Cruise", "initMapView ...");
    BNRouteGuider.getInstance().setBrowseStatus(true);
    BNMapController.getInstance().deleteAllObserver();
    BNMapController.getInstance().addObserver(this.mMapObserver);
    clearPoiBkg();
    BNMapController.getInstance().setDrawHouse(false);
    BNMapController localBNMapController = BNMapController.getInstance();
    if (!BNStyleManager.getRealDayStyle()) {}
    for (;;)
    {
      localBNMapController.setNightMode(bool);
      setMapInitScaleLevel();
      return;
      bool = false;
    }
  }
  
  public void locateToCarPoint(boolean paramBoolean)
  {
    int i = 1;
    LogUtil.e("Cruise", "locateToCarPoint");
    boolean bool = PreferenceHelper.getInstance(this.mContext).getBoolean("SP_Last_Cruise_Map_Status", true);
    LocData localLocData = getCarPointLocation();
    setMapStatus(localLocData, bool, paramBoolean);
    Object localObject = BNRouteGuider.getInstance();
    if (bool) {}
    for (;;)
    {
      ((BNRouteGuider)localObject).setRotateMode(i);
      if (!this.mIsCruiseEngineStarted) {
        break;
      }
      BNRouteGuider.getInstance().setBrowseStatus(false);
      return;
      i = 0;
    }
    localObject = new LocData();
    if (localLocData != null)
    {
      Bundle localBundle = CoordinateTransformUtil.transferGCJ02ToWGS84(localLocData.longitude, localLocData.latitude);
      ((LocData)localObject).longitude = localBundle.getDouble("LLx");
      ((LocData)localObject).latitude = localBundle.getDouble("LLy");
    }
    BCruiser.getInstance().updateLocation((LocData)localObject, localLocData);
  }
  
  public void onUpdateOrientation(boolean paramBoolean)
  {
    LogUtil.e("Cruise", "onUpdateOrientation: portrait " + paramBoolean);
    BNMapController.getInstance().showLayer(9, false);
    if (this.mIsCruiseEngineStarted) {
      BNMapController.getInstance().showLayer(20, true);
    }
    initMapStatus();
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.updateControlPanel();
    }
  }
  
  public int readMapScaleLevel()
  {
    int j = PreferenceHelper.getInstance(this.mContext).getInt("sp_cruise_map_user_scale_level", 18);
    int i;
    if (j < 15) {
      i = 15;
    }
    do
    {
      return i;
      i = j;
    } while (j <= 20);
    return 18;
  }
  
  public void restoreMapView()
  {
    boolean bool = true;
    writeMapScaleLevel();
    BNMapController.getInstance().onResume();
    BNRouteGuider.getInstance().setBrowseStatus(true);
    BNMapController.getInstance().deleteObserver(this.mMapObserver);
    BNMapController.getInstance().setDrawHouse(true);
    BNMapController localBNMapController = BNMapController.getInstance();
    if (!BNStyleManager.getRealDayStyle()) {}
    for (;;)
    {
      localBNMapController.setNightMode(bool);
      return;
      bool = false;
    }
  }
  
  public void saveMapScaleLevel()
  {
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("notifyDayNightObservers-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        int i = BNMapController.getInstance().getZoomLevel();
        LogUtil.e(TAG, "saveMapScaleLevel: " + i);
        PreferenceHelper.getInstance(CruiseMapController.this.mContext).putInt("sp_cruise_map_user_scale_level", i);
        return null;
      }
    }, new BNWorkerConfig(8, 0), 500L);
  }
  
  public void setCruiseEngineStarted(boolean paramBoolean)
  {
    this.mIsCruiseEngineStarted = paramBoolean;
  }
  
  public void setCruiseMapView(CruiseMapView paramCruiseMapView)
  {
    this.mCruiseMapView = paramCruiseMapView;
  }
  
  public void setMapStatus(LocData paramLocData, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    int i;
    if (localMapStatus != null)
    {
      if (!paramBoolean1) {
        break label191;
      }
      i = 0;
      localMapStatus._Rotation = i;
      if (!paramBoolean1) {
        break label203;
      }
      i = j;
      label38:
      localMapStatus._Overlooking = i;
      localMapStatus._Xoffset = 0L;
      localMapStatus._Yoffset = ScreenUtil.getInstance().dip2px(40);
      LogUtil.e("Cruise", "setMapStatus: north2D " + paramBoolean1 + ", anim " + paramBoolean2 + ", " + paramLocData);
      if ((paramLocData != null) && (paramLocData.isValid()))
      {
        paramLocData = CoordinateTransformUtil.LL2MC(paramLocData.longitude, paramLocData.latitude);
        i = paramLocData.getInt("MCx");
        j = paramLocData.getInt("MCy");
        localMapStatus._CenterPtX = i;
        localMapStatus._CenterPtY = j;
      }
      if (!paramBoolean2) {
        break label210;
      }
    }
    label191:
    label203:
    label210:
    for (paramLocData = MapController.AnimationType.eAnimationAll;; paramLocData = MapController.AnimationType.eAnimationNone)
    {
      localMapStatus._Level = -1.0F;
      BNMapController.getInstance().setMapStatus(localMapStatus, paramLocData);
      return;
      i = (int)BNRouteGuider.getInstance().GetCarRotateAngle();
      break;
      i = -45;
      break label38;
    }
  }
  
  public void showTrafficMap(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      BNMapController.getInstance().switchITSMode(true);
      BNMapController.getInstance().showTrafficMap(true);
    }
    for (;;)
    {
      BNMapController.getInstance().onResume();
      return;
      BNMapController.getInstance().showTrafficMap(false);
    }
  }
  
  public void writeMapScaleLevel()
  {
    int j = BNMapController.getInstance().getZoomLevel();
    LogUtil.e("Cruise", "save MapScaleLevel = " + j);
    int i;
    if (j < 15) {
      i = 15;
    }
    for (;;)
    {
      PreferenceHelper.getInstance(this.mContext).putInt("sp_cruise_map_user_scale_level", i);
      return;
      i = j;
      if (j > 20) {
        i = 18;
      }
    }
  }
  
  private static class LazyHolder
  {
    private static final CruiseMapController sInstance = new CruiseMapController();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cruise/control/CruiseMapController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */