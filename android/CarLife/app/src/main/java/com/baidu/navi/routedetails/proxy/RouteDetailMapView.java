package com.baidu.navi.routedetails.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.routedetails.BNMapControlPanelSimple;
import com.baidu.navi.routedetails.RGRouteDetailsOutlineItemView;
import com.baidu.navi.routedetails.RGRouteDetailsView;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.ZoomButtonView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routedetails.IBNRouteDetailsListener;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.ArrayList;

public class RouteDetailMapView
{
  protected static final String TAG = "RouteDetailMapView";
  private Activity mActivity;
  private boolean mAddMapCtrlPanel = true;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (1 == paramAnonymousInt1) {}
      switch (paramAnonymousInt2)
      {
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
          LogUtil.e("RouteDetailMapView", "MapObserver update: EVENT_MAP_ZOOM_UPDATE");
          if (RouteDetailMapView.this.mMapControlPanel == null) {
            break;
          }
          RouteDetailMapView.this.mMapControlPanel.updateView();
          break;
          LogUtil.e("RouteDetailMapView", "MapObserver update: EVENT_MAP_ANIMATION_FINISHED");
          if (RouteDetailMapView.this.mMapControlPanel == null) {
            break;
          }
          RouteDetailMapView.this.mMapControlPanel.updateView();
          break;
          RouteDetailMapView.this.handleCompassClicked();
          break;
        } while (RouteDetailMapView.this.mMapControlPanel == null);
        RouteDetailMapView.this.mMapControlPanel.handleScrollGesture();
        return;
      } while (System.currentTimeMillis() - RouteDetailMapView.this.mLastSingleTapTime < 500L);
      RouteDetailMapView.access$802(RouteDetailMapView.this, System.currentTimeMillis());
      if (RouteDetailMapView.this.mMapControlPanel != null) {
        RouteDetailMapView.this.mMapControlPanel.handleSingleTouchGesture();
      }
      RouteDetailMapView.this.switchMapcontrolVisible();
    }
  };
  private IBNRouteDetailsListener mBNRouteDetailsListener = new IBNRouteDetailsListener()
  {
    public void onHideSidePanel() {}
    
    public void onNotifySwitchResult(int paramAnonymousInt) {}
    
    public void onPageJump(int paramAnonymousInt, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt)
      {
      }
      do
      {
        do
        {
          return;
        } while (RouteDetailMapView.this.mRouteDetailNavListener == null);
        RouteDetailMapView.this.mRouteDetailNavListener.onJumpHome();
        return;
      } while (RouteDetailMapView.this.mRouteDetailNavListener == null);
      RouteDetailMapView.this.mRouteDetailNavListener.onJumpBack();
    }
    
    public void onResetMapCtrlPanel()
    {
      if (RouteDetailMapView.this.mRGRouteDetailsView != null) {
        RouteDetailMapView.this.reloadMapControlPanel(RouteDetailMapView.this.mRGRouteDetailsView.getRootView());
      }
      if (RouteDetailMapView.this.mMapControlPanel != null) {
        RouteDetailMapView.this.mMapControlPanel.setVisible(false);
      }
    }
    
    public void onShowSidePanel() {}
    
    public void onStartNavi(boolean paramAnonymousBoolean)
    {
      RouteDetailMapView.this.startNavi(paramAnonymousBoolean);
    }
    
    public void onStartRealNavi()
    {
      RouteDetailMapView.this.startRealNavi();
    }
    
    public void onSwitchOtherRoute(int paramAnonymousInt) {}
    
    public void onUpdate(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt1)
      {
      }
      do
      {
        return;
      } while (RouteDetailMapView.this.mRouteDetailNavListener == null);
      RouteDetailMapView.this.mRouteDetailNavListener.onUpdate();
    }
    
    public void onYawingBackGuiding() {}
  };
  private Context mContext;
  private DistrictInfo mDistrict;
  private boolean mFirstItsOn = false;
  public BNMapControlPanel.IItsClickListener mItsClickListener = new BNMapControlPanel.IItsClickListener()
  {
    public void onClickIts()
    {
      StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
      RouteDetailMapView.access$502(RouteDetailMapView.this, BNSettingManager.isFirstItsOn());
      GeoPoint localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
      if ((localGeoPoint != null) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))) {
        RouteDetailMapView.access$602(RouteDetailMapView.this, BNPoiSearcher.getInstance().getDistrictByPoint(localGeoPoint, 0));
      }
      if (!BNSettingManager.isRoadCondOnOrOff())
      {
        StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
        if (PreferenceHelper.getInstance(RouteDetailMapView.this.mContext).getBoolean("NAVI_REAL_HISTORY_ITS", true))
        {
          if (RouteDetailMapView.this.mFirstItsOn) {
            BNSettingManager.setFirstItsOn(false);
          }
          if (!NetworkUtils.isNetworkAvailable(RouteDetailMapView.this.mContext)) {
            break label215;
          }
          BNMapController.getInstance().switchITSMode(true);
          BNMapController.getInstance().showTrafficMap(true);
          BNSettingManager.setRoadCondOnOff(true);
          if ((RouteDetailMapView.this.mDistrict != null) && (!BNMapController.getInstance().checkRoadConditionSupport(RouteDetailMapView.this.mDistrict.mId))) {
            TipTool.onCreateToastDialog(RouteDetailMapView.this.mContext, JarUtils.getResources().getString(1711669394));
          }
        }
        else
        {
          return;
        }
        TipTool.onCreateToastDialog(RouteDetailMapView.this.mContext, JarUtils.getResources().getString(1711670038));
        return;
        label215:
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669387));
        return;
      }
      BNMapController.getInstance().showTrafficMap(false);
      BNSettingManager.setRoadCondOnOff(false);
    }
  };
  private long mLastSingleTapTime = 0L;
  private BNMapControlPanelSimple mMapControlPanel;
  private ViewGroup mParentView;
  private RGRouteDetailsView mRGRouteDetailsView;
  private BNRouteDetail.BNRouteDetailNavListener mRouteDetailNavListener;
  private RoutePlanModel mRoutePlanModel = null;
  private ISensorChangeListener mSensorChangeListener = new ISensorChangeListener()
  {
    public void onSensorChange(int paramAnonymousInt)
    {
      if (RouteDetailMapView.this.mMapControlPanel != null) {
        RouteDetailMapView.this.mMapControlPanel.updateMapBySensorAngle(paramAnonymousInt);
      }
    }
  };
  
  public RouteDetailMapView(Activity paramActivity, ViewGroup paramViewGroup, e parame)
  {
    this.mActivity = paramActivity;
    this.mContext = paramActivity.getApplicationContext();
    this.mParentView = paramViewGroup;
    this.mRGRouteDetailsView = new RGRouteDetailsView(paramActivity, parame);
    this.mRGRouteDetailsView.onUpdateOrientation();
    if (firstRoutePlan()) {
      BNSettingManager.setFirstRoutePlanTag(false);
    }
    this.mRGRouteDetailsView.setBNRouteDetailsListener(this.mBNRouteDetailsListener);
    paramActivity = this.mRGRouteDetailsView.getRootView();
    loadMapCtrlPanel(paramActivity, true);
    if ((this.mParentView != null) && (paramActivity != null)) {
      this.mParentView.addView(paramActivity);
    }
    this.mRoutePlanModel = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel"));
    RGParkPointModel.getInstance().reset();
  }
  
  private boolean firstRoutePlan()
  {
    return BNSettingManager.getFirstRoutePlanTag();
  }
  
  private void startNavi(boolean paramBoolean)
  {
    if (this.mActivity == null) {}
    for (;;)
    {
      return;
      RoutePlanNode localRoutePlanNode1 = this.mRoutePlanModel.getStartNode();
      RoutePlanNode localRoutePlanNode2 = this.mRoutePlanModel.getEndNode();
      if ((localRoutePlanNode1 != null) && (localRoutePlanNode2 != null))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("routeguide_view_mode", 1);
        localBundle.putInt("calroute_done", 0);
        localBundle.putInt("start_x", localRoutePlanNode1.getLongitudeE6());
        localBundle.putInt("start_y", localRoutePlanNode1.getLatitudeE6());
        localBundle.putInt("end_x", localRoutePlanNode2.getLongitudeE6());
        localBundle.putInt("end_y", localRoutePlanNode2.getLatitudeE6());
        localBundle.putString("start_name", this.mRoutePlanModel.getStartName(this.mActivity, false));
        localBundle.putString("end_name", this.mRoutePlanModel.getEndName(this.mActivity, false));
        localBundle.putInt("menu_type", 0);
        if (paramBoolean) {
          localBundle.putInt("locate_mode", 2);
        }
        while (this.mRouteDetailNavListener != null)
        {
          this.mRouteDetailNavListener.onStartNavi(localBundle, paramBoolean);
          return;
          localBundle.putInt("locate_mode", 1);
        }
      }
    }
  }
  
  private void startRealNavi()
  {
    int i = BNLocationManagerProxy.getInstance().getGpsState();
    BNRoutePlaner.getInstance().triggerGPSStatus(i);
    startNavi(false);
  }
  
  private void switchMapcontrolVisible()
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
  
  public void cancleCountDownTask()
  {
    if (this.mRGRouteDetailsView != null) {
      this.mRGRouteDetailsView.cancleCountDownTask();
    }
  }
  
  public void handleCompassClicked()
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    localMapStatus._Rotation = 0;
    localMapStatus._Overlooking = 0;
    BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
  }
  
  public void initFocus(g paramg1, g paramg2, boolean paramBoolean)
  {
    if ((this.mRGRouteDetailsView == null) || (this.mMapControlPanel == null)) {
      return;
    }
    if ((paramg1 == null) || (paramBoolean))
    {
      paramg1 = new g(this.mRGRouteDetailsView.getRootView(), 3, true);
      paramg1.d(this.mRGRouteDetailsView.getBtnBack()).d(this.mRGRouteDetailsView.getBtnOpenPreference()).d(this.mMapControlPanel.getITSButtonView()).d(this.mMapControlPanel.getZoomInBtnView()).d(this.mMapControlPanel.getZoomOutBtnView()).d(this.mMapControlPanel.getLocationBtn());
    }
    if ((paramg2 == null) || (paramBoolean))
    {
      paramg2 = new g(this.mRGRouteDetailsView.getRootView(), 5);
      ArrayList localArrayList = this.mRGRouteDetailsView.getViewList();
      int i = 0;
      while (i < localArrayList.size())
      {
        paramg2.d(((RGRouteDetailsOutlineItemView)localArrayList.get(i)).getDetailItem());
        i += 1;
      }
      paramg2.d(this.mRGRouteDetailsView.getStartNaviLL());
      paramg2.b(this.mRGRouteDetailsView.getStartNaviLL());
    }
    d.a().b(new a[] { paramg1, paramg2 });
    d.a().h(paramg2);
  }
  
  public void loadMapCtrlPanel(View paramView, boolean paramBoolean)
  {
    this.mAddMapCtrlPanel = paramBoolean;
    reloadMapControlPanel(paramView);
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setVisible(false);
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.mRGRouteDetailsView != null) {
      return this.mRGRouteDetailsView.onBackPressed();
    }
    return false;
  }
  
  public void onDestory()
  {
    if (this.mRGRouteDetailsView != null)
    {
      this.mRGRouteDetailsView.hide();
      this.mRGRouteDetailsView.destory();
    }
    if ((this.mAddMapCtrlPanel) && (this.mMapControlPanel != null)) {
      this.mMapControlPanel.hide();
    }
  }
  
  public void onPause()
  {
    if (this.mRGRouteDetailsView != null) {
      this.mRGRouteDetailsView.onHide();
    }
    if ((this.mAddMapCtrlPanel) && (this.mMapControlPanel != null))
    {
      this.mMapControlPanel.onPause();
      BNaviModuleManager.addOrRemoveSensorListener(7, this.mSensorChangeListener);
    }
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    BNMapController.getInstance().onPause();
    if (MapViewFactory.getInstance().getMapView() != null) {}
  }
  
  public void onResume()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.onResume();
    }
    if (this.mAddMapCtrlPanel)
    {
      BNMapController.getInstance().addObserver(this.mBNMapObserver);
      BNaviModuleManager.addOrRemoveSensorListener(6, this.mSensorChangeListener);
      if (this.mMapControlPanel != null) {
        this.mMapControlPanel.onResume();
      }
    }
    if ((this.mRGRouteDetailsView != null) && (this.mMapControlPanel != null)) {
      this.mRGRouteDetailsView.onShow();
    }
  }
  
  public void onUpdateOrientation(int paramInt)
  {
    if (this.mRGRouteDetailsView != null) {
      this.mRGRouteDetailsView.onUpdateOrientation();
    }
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if (this.mRGRouteDetailsView != null) {
      this.mRGRouteDetailsView.onUpdateStyle(paramBoolean);
    }
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.onUpdateStyle(paramBoolean);
    }
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if (paramInt1 == 2) {
      if ((paramInt2 == 29) || (paramInt2 == 53))
      {
        if (this.mMapControlPanel != null) {
          this.mMapControlPanel.changeLocationModeByVoice(MapViewConfig.PositionStatus.FOLLOWING);
        }
      }
      else
      {
        label150:
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                if (paramInt2 == 30)
                {
                  if (this.mMapControlPanel == null) {
                    break label185;
                  }
                  this.mMapControlPanel.changeLocationModeByVoice(MapViewConfig.PositionStatus.COMPASS);
                  return true;
                }
                if (paramInt2 != 7) {
                  break;
                }
                VoiceCommandHelper.onITSChanged(true);
              } while (this.mMapControlPanel == null);
              this.mMapControlPanel.updateItsBtn();
              return true;
              if (paramInt2 != 8) {
                break;
              }
              VoiceCommandHelper.onITSChanged(false);
            } while (this.mMapControlPanel == null);
            this.mMapControlPanel.updateItsBtn();
            return true;
            if (paramInt2 != 2) {
              break label150;
            }
            if (this.mMapControlPanel == null) {
              break;
            }
            paramObject = this.mMapControlPanel.getZoomButtonView();
          } while (paramObject == null);
          ((ZoomButtonView)paramObject).handleZoomOut();
          return true;
          return false;
          if (paramInt2 != 3) {
            break label185;
          }
          if (this.mMapControlPanel == null) {
            break;
          }
          paramObject = this.mMapControlPanel.getZoomButtonView();
        } while (paramObject == null);
        ((ZoomButtonView)paramObject).handleZoomIn();
        return true;
        return false;
      }
    }
    label185:
    if (this.mRGRouteDetailsView != null) {
      return this.mRGRouteDetailsView.onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
    }
    return false;
  }
  
  public void reloadMapControlPanel(View paramView)
  {
    if ((paramView == null) || (this.mContext == null)) {}
    while (!this.mAddMapCtrlPanel) {
      return;
    }
    this.mMapControlPanel = new BNMapControlPanelSimple(this.mContext, paramView);
    this.mMapControlPanel.setNoNightStyle(true);
    this.mMapControlPanel.updateView();
    this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
  }
  
  public void setNaviListener(BNRouteDetail.BNRouteDetailNavListener paramBNRouteDetailNavListener)
  {
    this.mRouteDetailNavListener = paramBNRouteDetailNavListener;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/routedetails/proxy/RouteDetailMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */