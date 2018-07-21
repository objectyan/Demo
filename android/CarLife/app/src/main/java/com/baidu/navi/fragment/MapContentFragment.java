package com.baidu.navi.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.view.dialog.c;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.MapControlPanel;
import com.baidu.navi.view.MapControlPanel.IItsClickListener;
import com.baidu.navi.view.MapControlPanel.ILocationBtnClickListener;
import com.baidu.navi.view.ZoomButtonView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.comapi.userdata.IBNFavUpdateListener;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysSensorManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapController.MapControlMode;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import java.util.ArrayList;

public abstract class MapContentFragment
  extends ContentFragment
{
  private static final String TAG = "MapHome";
  private boolean ifFavReaded = false;
  private boolean isMapControlVIewFirstVisible = false;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (1 == paramAnonymousInt1) {
        switch (paramAnonymousInt2)
        {
        }
      }
      for (;;)
      {
        if (2 == paramAnonymousInt1) {}
        switch (paramAnonymousInt2)
        {
        case 515: 
        case 516: 
        case 517: 
        case 519: 
        default: 
          return;
          LogUtil.e("MapHome", "MapObserver update: EVENT_MAP_ZOOM_UPDATE");
          if (MapContentFragment.this.mMapControlPanel != null) {
            MapContentFragment.this.mMapControlPanel.updateView();
          }
          MapContentFragment.this.saveMapZoomLevel();
          continue;
          LogUtil.e("MapHome", "MapObserver update: EVENT_MAP_ANIMATION_FINISHED");
          if (MapContentFragment.this.mMapControlPanel != null) {
            MapContentFragment.this.mMapControlPanel.updateView();
          }
          MapContentFragment.this.saveMapZoomLevel();
          continue;
          MapContentFragment.this.handleCompassClicked();
        }
      }
      MapContentFragment.this.mMapControlPanel.handleScrollGesture();
      return;
      MapContentFragment.this.mMapControlPanel.handleSingleTouchGesture();
      MapContentFragment.this.switchMapcontrolVisible();
    }
  };
  private c mDataDownloadAlertDialog;
  private boolean mDayStyle = true;
  private DistrictInfo mDistrict;
  private IBNFavUpdateListener mFavUpdateListener = new IBNFavUpdateListener()
  {
    public void onFavUpdateComplete()
    {
      MapContentFragment.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          MapContentFragment.this.fillFavAndPoiList();
          MapContentFragment.access$102(MapContentFragment.this, true);
        }
      });
    }
  };
  private c mFirstItsDialog;
  private boolean mFirstItsOn = false;
  private Handler mHandler = new Handler();
  protected boolean mIsForRouteDetails = false;
  public MapControlPanel.IItsClickListener mItsClickListener = new MapControlPanel.IItsClickListener()
  {
    public void onClickIts()
    {
      StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
      MapContentFragment.access$402(MapContentFragment.this, BNSettingManager.isFirstItsOn());
      GeoPoint localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(BaseFragment.mActivity.getWindowManager().getDefaultDisplay().getWidth() / 2, BaseFragment.mActivity.getWindowManager().getDefaultDisplay().getHeight() / 2);
      if ((localGeoPoint != null) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))) {
        MapContentFragment.access$502(MapContentFragment.this, BNPoiSearcher.getInstance().getDistrictByPoint(localGeoPoint, 0));
      }
      if (!BNSettingManager.isRoadCondOnOrOff())
      {
        StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
        if (PreferenceHelper.getInstance(a.a()).getBoolean("NAVI_REAL_HISTORY_ITS", true))
        {
          if (MapContentFragment.this.mFirstItsOn) {
            BNSettingManager.setFirstItsOn(false);
          }
          if (!NetworkUtils.isNetworkAvailable(a.a())) {
            break label197;
          }
          MapContentFragment.this.showTrafficMap(true);
          BNSettingManager.setRoadCondOnOff(true);
          if ((MapContentFragment.this.mDistrict != null) && (!BNMapController.getInstance().checkRoadConditionSupport(MapContentFragment.this.mDistrict.mId))) {
            TipTool.onCreateToastDialog(a.a(), 2131296541);
          }
        }
        else
        {
          return;
        }
        TipTool.onCreateToastDialog(a.a(), 2131296540);
        return;
        label197:
        MapContentFragment.this.showItsSettingDialog();
        return;
      }
      MapContentFragment.this.showTrafficMap(false);
      BNSettingManager.setRoadCondOnOff(false);
      TipTool.onCreateToastDialog(a.a(), 2131296539);
    }
  };
  private c mItsSettingAlertDialog;
  private MapControlPanel.ILocationBtnClickListener mLocationBtnClickListener = new MapControlPanel.ILocationBtnClickListener()
  {
    public void onClick(MapViewConfig.PositionStatus paramAnonymousPositionStatus)
    {
      MapContentFragment.this.onLocationBtnClicked(paramAnonymousPositionStatus);
    }
  };
  private LocationChangeListener mLocationChangeListener = new LocationChangeListener()
  {
    public LocationChangeListener.CoordType onGetCoordType()
    {
      return LocationChangeListener.CoordType.CoordType_BD09;
    }
    
    public void onLocationChange(LocationManager.LocData paramAnonymousLocData)
    {
      if (MapContentFragment.this.mMapControlPanel != null) {
        MapContentFragment.this.mMapControlPanel.onLocationChange(paramAnonymousLocData, MapContentFragment.this.mbMoveToLocationPoint);
      }
    }
  };
  protected MapControlPanel mMapControlPanel;
  private ISensorChangeListener mSensorChangeListener = new ISensorChangeListener()
  {
    public void onSensorChange(int paramAnonymousInt)
    {
      if (MapContentFragment.this.mMapControlPanel != null) {
        MapContentFragment.this.mMapControlPanel.updateMapBySensorAngle(paramAnonymousInt);
      }
    }
  };
  protected boolean mbAddMapCtrlPanelView = false;
  protected boolean mbMoveToLocationPoint = false;
  protected View view;
  
  private void fillFavAndPoiList()
  {
    ArrayList localArrayList1 = FavoriteModel.getInstance().getFavDataList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    int i = 0;
    if (i < localArrayList1.size())
    {
      FavoritePoiInfo localFavoritePoiInfo = (FavoritePoiInfo)localArrayList1.get(i);
      if ((localFavoritePoiInfo == null) || (localFavoritePoiInfo.mViewPoint == null)) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(i, BNFavoriteManager.getInstance().MCTogcjPoint(localFavoritePoiInfo.mViewPoint));
        localArrayList3.add(i, localFavoritePoiInfo.mFavName);
        localArrayList4.add(i, localFavoritePoiInfo.mFavAddr);
      }
    }
    if ((localArrayList2.size() > 0) && (BNMapController.getInstance().getMapController().getMapControlMode() == MapController.MapControlMode.DEFAULT))
    {
      BNMapController.getInstance().showLayer(16, true);
      BNPoiSearcher.getInstance().updateFavPoiCache(localArrayList2, localArrayList3, localArrayList4);
      BNMapController.getInstance().updateLayer(16);
      return;
    }
    BNMapController.getInstance().showLayer(16, false);
    BNPoiSearcher.getInstance().clearFavPoiCache();
    BNMapController.getInstance().updateLayer(16);
  }
  
  private void initLocationLayer()
  {
    LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
    if (localLocData == null) {
      return;
    }
    if (MainMapModel.getInstance().getCurLocMode() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      LocationCallback.setData(localLocData.toLocationOverlayJsonString(bool));
      return;
    }
  }
  
  private void loadFavDataList()
  {
    BNFavoriteManager.getInstance().asyncLoadFavListData(this.mFavUpdateListener);
    this.ifFavReaded = true;
  }
  
  private void saveMapInfo(int paramInt1, int paramInt2)
  {
    PreferenceHelper localPreferenceHelper = PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext());
    localPreferenceHelper.putInt("sp_last_longitude", paramInt1);
    localPreferenceHelper.putInt("sp_last_latitude", paramInt2);
  }
  
  private void saveMapZoomLevel()
  {
    int i = BNMapController.getInstance().getZoomLevel();
    PreferenceHelper.getInstance(BaiduNaviApplication.getInstance().getApplicationContext()).putInt("sp_last_scale", i);
  }
  
  private void showItsSettingDialog()
  {
    if (this.mItsSettingAlertDialog == null) {
      this.mItsSettingAlertDialog = new c(mActivity).b(2131296284).a(2131296542).c(2131296280).q().a(new b()
      {
        public void onClick()
        {
          if ((BaseFragment.mActivity == null) || (!MapContentFragment.this.isAdded())) {
            return;
          }
          MapContentFragment.this.dismissDialog(MapContentFragment.this.mItsSettingAlertDialog);
        }
      });
    }
    showDialog(this.mItsSettingAlertDialog);
  }
  
  protected void forseReloadMapControlPanel(View paramView)
  {
    if (paramView == null) {}
    while (!this.mbAddMapCtrlPanelView) {
      return;
    }
    this.mMapControlPanel = new MapControlPanel(mActivity, paramView, getNaviFragmentManager());
    this.mMapControlPanel.onUpdateStyle(this.mDayStyle);
    this.mMapControlPanel.updateView();
    this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
    this.mMapControlPanel.setLocationBtnClickListener(this.mLocationBtnClickListener);
    this.mMapControlPanel.setOnDialogListener(this);
  }
  
  public void handleCompassClicked()
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    localMapStatus._Rotation = 0;
    localMapStatus._Overlooking = 0;
    BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
  }
  
  protected void hideMapCtrlPanel()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.hide();
    }
  }
  
  public void initFocusChain(View paramView)
  {
    if (this.mMapControlPanel != null)
    {
      this.mMapControlPanel.initFocusChain(paramView);
      this.mMapControlPanel.switchMapFocus(false, false);
    }
  }
  
  public boolean isMapPage()
  {
    return true;
  }
  
  protected void loadMapCtrlPanel(boolean paramBoolean)
  {
    this.mbAddMapCtrlPanelView = true;
    this.isMapControlVIewFirstVisible = paramBoolean;
  }
  
  public void moveMapToPoint(int paramInt1, int paramInt2)
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    Bundle localBundle = CoordinateTransformUtil.LLE62MC(paramInt1, paramInt2);
    localMapStatus._CenterPtX = localBundle.getInt("MCx");
    localMapStatus._CenterPtY = localBundle.getInt("MCy");
    BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
    BNMapController.getInstance().updateLayer(14);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.view = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.view != null) {
      this.view.setClickable(false);
    }
    if ((this.mbAddMapCtrlPanelView) && (this.view != null))
    {
      this.mMapControlPanel = new MapControlPanel(mActivity, this.view, getNaviFragmentManager());
      this.mMapControlPanel.onUpdateStyle(StyleManager.getDayStyle());
      this.mMapControlPanel.updateView();
      this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
      this.mMapControlPanel.setLocationBtnClickListener(this.mLocationBtnClickListener);
      initFocusChain(this.view);
      this.mMapControlPanel.setOnDialogListener(this);
    }
    if ((BaseFragment.mUpdateIts) && (PreferenceHelper.getInstance(a.a()).getBoolean("NAVI_ROADCOND_ON_OFF", false))) {
      BNMapController.getInstance().showTrafficMap(true);
    }
    initLocationLayer();
    return this.view;
  }
  
  public void onDestroyView()
  {
    Object localObject = BNMapController.getInstance().getMapStatus();
    if (localObject != null)
    {
      localObject = CoordinateTransformUtil.MC2LL(((MapStatus)localObject)._CenterPtX, ((MapStatus)localObject)._CenterPtY);
      if (localObject != null) {
        saveMapInfo((int)(((Bundle)localObject).getDouble("LLx") * 100000.0D), (int)(((Bundle)localObject).getDouble("LLy") * 100000.0D));
      }
    }
    saveMapZoomLevel();
    super.onDestroyView();
  }
  
  public boolean onITSChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!BNSettingManager.isRoadCondOnOrOff())) {
      if (BNSettingManager.isNaviRealHistoryITS())
      {
        if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
          break label48;
        }
        showTrafficMap(true);
        BNSettingManager.setRoadCondOnOff(true);
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669388));
      }
    }
    label48:
    while ((paramBoolean) || (!PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean("NAVI_ROADCOND_ON_OFF", false)))
    {
      return true;
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669387));
      return true;
    }
    showTrafficMap(false);
    BNSettingManager.setRoadCondOnOff(false);
    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669390));
    return true;
  }
  
  protected void onInit()
  {
    super.onInit();
    onInitMap();
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
  }
  
  protected abstract void onInitMap();
  
  protected void onLocationBtnClicked(MapViewConfig.PositionStatus paramPositionStatus) {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    if (BaseFragment.mResumeMapView) {
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
          if (localMapGLSurfaceView != null)
          {
            BaseFragment.mResumeMapView = false;
            localMapGLSurfaceView.onResume();
          }
        }
      }, 100L);
    }
    MapViewFactory.getInstance().getMapView().onResume();
    MapViewFactory.getInstance().getMapView().onForeground();
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.onResume();
    }
    if (this.mbAddMapCtrlPanelView)
    {
      BNMapController.getInstance().setObserver(this.mBNMapObserver);
      LocationManager.getInstance().addLocationChangeLister(this.mLocationChangeListener);
      BNSysSensorManager.getInstance().initSensor(a.a());
      BNSysSensorManager.getInstance().addSensorChangeListener(this.mSensorChangeListener);
    }
    if (BaseFragment.mUpdateIts)
    {
      if (!BNSettingManager.isRoadCondOnOrOff()) {
        break label171;
      }
      if (!PreferenceHelper.getInstance(a.a()).getBoolean("NAVI_REAL_HISTORY_ITS", true)) {
        break label154;
      }
      BNMapController.getInstance().switchITSMode(true);
      BNMapController.getInstance().showTrafficMap(true);
    }
    for (;;)
    {
      BaseFragment.mUpdateIts = false;
      super.onResume();
      return;
      label154:
      BNMapController.getInstance().switchITSMode(false);
      BNMapController.getInstance().showTrafficMap(true);
      continue;
      label171:
      BNMapController.getInstance().showTrafficMap(false);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mbAddMapCtrlPanelView)
    {
      BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
      LocationManager.getInstance().removeLocationChangeLister(this.mLocationChangeListener);
      BNSysSensorManager.getInstance().removeSensorChangeListener(this.mSensorChangeListener);
    }
  }
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    LogUtil.e("StyleDebug", "MapContentFragment dayStyle = " + paramBoolean);
    this.mDayStyle = paramBoolean;
    if ((this.mMapControlPanel != null) && (this.mbAddMapCtrlPanelView) && (this.mMapControlPanel != null)) {
      this.mMapControlPanel.onUpdateStyle(this.mDayStyle);
    }
  }
  
  public boolean onVoiceCmdMyLocation()
  {
    int i = MainMapModel.getInstance().getCurLocMode();
    if ((this.mMapControlPanel != null) && (i == 0))
    {
      this.mMapControlPanel.handleLocationBtnClick();
      return true;
    }
    return false;
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    boolean bool = true;
    LogUtil.e("MapHome", "onVoiceCommand: type " + paramInt1 + ", subType " + paramInt2 + ", " + paramInt3 + ", " + paramObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramBoolean = false;
      do
      {
        do
        {
          return paramBoolean;
          LogUtil.e("MapHome", "onVoiceCommand: type INVALID");
          break;
          LogUtil.e("MapHome", "onVoiceCommand: type UI");
          switch (paramInt2)
          {
          default: 
            break;
          case 2: 
            if (this.mMapControlPanel != null)
            {
              paramObject = this.mMapControlPanel.getZoomButtonView();
              if (paramObject != null) {
                ((ZoomButtonView)paramObject).handleZoomOut();
              }
              replyVoiceCommand(paramInt1, 1, paramBoolean);
              return true;
            }
          case 19: 
            paramInt2 = MainMapModel.getInstance().getCurLocMode();
            if ((this.mMapControlPanel != null) && (paramInt2 == 1)) {
              this.mMapControlPanel.handleLocationBtnClick();
            }
            replyVoiceCommand(paramInt1, 1, paramBoolean);
            return true;
          case 3: 
            if (this.mMapControlPanel != null)
            {
              paramObject = this.mMapControlPanel.getZoomButtonView();
              if (paramObject != null) {
                ((ZoomButtonView)paramObject).handleZoomIn();
              }
              replyVoiceCommand(paramInt1, 1, paramBoolean);
              return true;
            }
            return false;
            return false;
          case 29: 
          case 53: 
            if (this.mMapControlPanel == null) {
              break;
            }
            this.mMapControlPanel.changeLocationModeByVoice(MapViewConfig.PositionStatus.FOLLOWING);
            return true;
          case 30: 
            if (this.mMapControlPanel == null) {
              break;
            }
            this.mMapControlPanel.changeLocationModeByVoice(MapViewConfig.PositionStatus.COMPASS);
            return true;
          case 8: 
            onITSChanged(false);
            paramBoolean = bool;
          }
        } while (this.mMapControlPanel == null);
        this.mMapControlPanel.updateMenuDialog();
        return true;
        onITSChanged(true);
        paramBoolean = bool;
      } while (this.mMapControlPanel == null);
      this.mMapControlPanel.updateMenuDialog();
      return true;
      LogUtil.e("MapHome", "onVoiceCommand: type PAGE");
    }
  }
  
  protected void setIsForRouteDetails(boolean paramBoolean)
  {
    this.mIsForRouteDetails = paramBoolean;
  }
  
  public void setLeftRightPanelVisible(boolean paramBoolean)
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setLeftRightPanelVisible(paramBoolean);
    }
  }
  
  public void setLeftTopPanelVisible(boolean paramBoolean)
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setLeftTopPanelVisible(paramBoolean);
    }
  }
  
  protected void setMapCtrlPanel(MapControlPanel paramMapControlPanel)
  {
    if (paramMapControlPanel != null) {
      this.mMapControlPanel = paramMapControlPanel;
    }
  }
  
  public void setMapFocusViewVisible(boolean paramBoolean)
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setMapFocusViewVisible(paramBoolean);
    }
  }
  
  protected void setMapLayerMode(int paramInt)
  {
    BNMapController.getInstance().setLayerMode(paramInt);
    BNMapController.getInstance().showLayer(24, false);
    BNMapController.getInstance().showLayer(25, false);
    BNMapController.getInstance().showLayer(26, false);
    BNMapController.getInstance().showLayer(27, false);
    BNMapController.getInstance().showLayer(10, false);
  }
  
  protected void showMapCtrlPanel()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.show();
    }
  }
  
  protected void showTrafficMap(boolean paramBoolean) {}
  
  public boolean switchMapFocus(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mMapControlPanel != null)
    {
      bool1 = bool2;
      if (this.mMapControlPanel.isMapFocusOpen())
      {
        this.mMapControlPanel.switchMapFocus(paramBoolean1, paramBoolean2);
        initFocusChain(this.view);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void switchMapcontrolVisible()
  {
    if (this.mMapControlPanel != null)
    {
      if (this.mMapControlPanel.isVisible()) {
        this.mMapControlPanel.setVisible(false);
      }
    }
    else {
      return;
    }
    this.mMapControlPanel.setVisible(true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/MapContentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */