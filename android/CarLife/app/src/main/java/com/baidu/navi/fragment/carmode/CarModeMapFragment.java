package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.baidu.baidunavis.control.NavItemizedOverlayUtil;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.TopBarView;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navi.controller.CommonController;
import com.baidu.navi.controller.HomeController;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.cruise.control.ICruiseEnterQuiteLogic;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.MapHomeBasicFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.HomePoiBasicView;
import com.baidu.navi.view.HomePoiSimpleView;
import com.baidu.navi.view.MapControlPanel;
import com.baidu.navi.voice.NaviState;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.OnLongPressListener;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.event.MapMoveEvent;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.BMEventBus.OnEvent;
import java.util.ArrayList;
import java.util.List;

public class CarModeMapFragment
  extends MapHomeBasicFragment
  implements ICruiseEnterQuiteLogic, BMEventBus.OnEvent
{
  public static final String BUNDLE_KEY_LOCATION = "location";
  public static String TAG = "CarModeMapFragment";
  private CommonController mCommonController;
  private BNLocationManager mLocationManager;
  private MapGLSurfaceView mMapView;
  private MapViewConfig mMapViewConfig;
  g mMiddleFocusViewGroup;
  private HomePoiBasicView mPoiDetailView;
  g mRightFocusViewGroup;
  private boolean mShowDialoged = false;
  private TopBarView mTopBarView;
  protected ViewGroup mViewGroup;
  
  private Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    int i = ScreenUtil.getInstance().px2dip(paramDrawable.getIntrinsicWidth());
    int j = ScreenUtil.getInstance().px2dip(paramDrawable.getIntrinsicHeight());
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return (Bitmap)localObject;
    }
  }
  
  private void handleDialogShowLogic()
  {
    if ((this.mShowDialoged) || (!this.isDisplayed)) {
      this.mShowDialoged = true;
    }
    do
    {
      do
      {
        return;
        this.mShowDialoged = true;
      } while ((this.mCommonController == null) || (mActivity == null));
      this.mCommonController.checkOfflineDataOrNetwork();
      if (mActivity.i() > 0)
      {
        this.mCommonController.dismissNoNetAndOfflineDataDialog();
        mActivity.j();
        mActivity.a(0);
      }
    } while ((this.mLocationManager == null) || (this.mHomeController == null));
    com.baidu.carlife.i.a locala = com.baidu.carlife.i.a.a();
    if ((locala.c()) && (locala.d()))
    {
      this.mHomeController.dismissGPSSettingDialog();
      return;
    }
    if (!this.mLocationManager.isGpsEnabled())
    {
      this.mHomeController.showGPSSettingDialog();
      return;
    }
    this.mHomeController.dismissGPSSettingDialog();
  }
  
  private void initLocationManager()
  {
    ConcurrentManager.executeTask(Module.NAV_MODULE, new ConcurrentTask()
    {
      public void run()
      {
        CarModeMapFragment.access$002(CarModeMapFragment.this, BNSysLocationManager.getInstance());
        CarModeMapFragment.this.mLocationManager.init(BaseFragment.mActivity);
        CarModeMapFragment.this.mLocationManager.startNaviLocate(BaseFragment.mActivity);
      }
    }, ScheduleConfig.forSetupData());
  }
  
  private boolean isNeedShowDialog()
  {
    if (this.mShowDialoged) {}
    com.baidu.carlife.i.a locala;
    do
    {
      return false;
      if ((this.mCommonController != null) && (this.mCommonController.isNeedShowDialog())) {
        return true;
      }
      if ((mActivity != null) && (mActivity.i() > 0)) {
        return true;
      }
      locala = com.baidu.carlife.i.a.a();
    } while (((locala.c()) && (locala.d())) || (this.mLocationManager == null) || (this.mLocationManager.isGpsEnabled()));
    return true;
  }
  
  private void onEventMainThread(MapMoveEvent paramMapMoveEvent)
  {
    if (this.mMapControlPanel != null)
    {
      this.mMapControlPanel.handleScrollGesture();
      this.mMapControlPanel.updateView();
    }
    enterCruiseFollowModeDetect();
  }
  
  private void updateLocationIcon()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = StyleManager.getDrawable(2130838930);
    OverlayLocationData localOverlayLocationData;
    if (localObject != null)
    {
      localObject = drawableToBitmap((Drawable)localObject);
      localOverlayLocationData = new OverlayLocationData();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        localOverlayLocationData.setImage((Bitmap)localObject);
        localOverlayLocationData.setImgHeight(((Bitmap)localObject).getHeight());
        localOverlayLocationData.setImgWidth(((Bitmap)localObject).getWidth());
        localOverlayLocationData.setImgName("icon");
        localOverlayLocationData.setRotation(1);
        localArrayList.add(localOverlayLocationData);
      }
    }
    localObject = StyleManager.getDrawable(2130838931);
    if (localObject != null)
    {
      localObject = drawableToBitmap((Drawable)localObject);
      localOverlayLocationData = new OverlayLocationData();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        localOverlayLocationData.setImage((Bitmap)localObject);
        localOverlayLocationData.setImgHeight(((Bitmap)localObject).getHeight());
        localOverlayLocationData.setImgWidth(((Bitmap)localObject).getWidth());
        localOverlayLocationData.setImgName("direction");
        localOverlayLocationData.setRotation(1);
        localArrayList.add(localOverlayLocationData);
      }
    }
    MapViewFactory.getInstance().getMapView().setDefaultLocationLayerData(localArrayList);
  }
  
  private void updateMap()
  {
    if (NavMapManager.getInstance().getNaviMapMode() == 5)
    {
      com.baidu.baidumaps.f.a.a.a.a().e();
      com.baidu.baidumaps.f.a.a.a.a().g();
      NavMapManager.getInstance().handleMapOverlays(0);
    }
    com.baidu.baidumaps.f.a.a.a.a().g();
    NavMapManager.getInstance().setNaviMapMode(0);
    updateLocationIcon();
  }
  
  private void updateMapTheme(boolean paramBoolean)
  {
    MapController localMapController = this.mMapView.getController();
    int j = 10;
    if (paramBoolean)
    {
      i = 5;
      if (!StyleManager.getRealDayStyle())
      {
        if (!NavMapManager.getInstance().isChangedMapMode()) {
          break label70;
        }
        j = 11;
        if (!paramBoolean) {
          break label64;
        }
      }
    }
    label64:
    for (int i = 13;; i = 9)
    {
      localMapController.setMapThemeScene(j, i, new Bundle());
      return;
      i = 0;
      break;
    }
    label70:
    j = 12;
    if (paramBoolean) {}
    for (i = 5;; i = 0) {
      break;
    }
  }
  
  public void bnMapObserverUpdate(BNSubject paramBNSubject, int paramInt1, int paramInt2, Object paramObject)
  {
    if (2 == paramInt1) {
      enterCruiseFollowModeDetect();
    }
  }
  
  public void driving()
  {
    i.b("yftech", "CarModeMapFragment driving");
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.hideSearchView();
    }
    if (this.mPoiDetailView != null) {
      this.mPoiDetailView.hide();
    }
  }
  
  public void drivingSet()
  {
    if (getNaviFragmentManager().isDriving())
    {
      i.b("yftech", "CarModeMapFragment onResume driving");
      if (this.mMapControlPanel != null) {
        this.mMapControlPanel.hideSearchView();
      }
    }
    do
    {
      return;
      i.b("yftech", "CarModeMapFragment onResume stopDriving");
    } while (this.mMapControlPanel == null);
    this.mMapControlPanel.showSearchView();
  }
  
  public void enterCruise()
  {
    enterCruiseFollowModeDetect();
  }
  
  protected void handleLongPress(MotionEvent paramMotionEvent)
  {
    initFocusChain(this.mViewGroup);
    super.handleLongPress(paramMotionEvent);
  }
  
  public void handleLongPress(GeoPoint paramGeoPoint)
  {
    initFocusChain(this.mViewGroup);
    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
    onShowMapGeoPoint(paramGeoPoint);
  }
  
  public void hideTopbarView()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.hideShowTopBarView();
    }
  }
  
  public void initFocusChain(View paramView)
  {
    d locald = d.a();
    locald.g();
    if (this.mMapControlPanel != null)
    {
      if (this.mMiddleFocusViewGroup == null) {
        this.mMiddleFocusViewGroup = this.mMapControlPanel.initFocusChain(paramView);
      }
      this.mMapControlPanel.switchMapFocus(false, false);
      if ((this.mPoiDetailView != null) && (this.mPoiDetailView.isVisible())) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      setMapFocusViewVisible(bool);
      if (this.mRightFocusViewGroup == null)
      {
        this.mRightFocusViewGroup = new g(paramView.findViewById(2131624534), 5);
        this.mRightFocusViewGroup.d(this.mViewGroup.findViewById(2131624537));
        this.mRightFocusViewGroup.d(this.mViewGroup.findViewById(2131624541));
        this.mRightFocusViewGroup.d(this.mViewGroup.findViewById(2131624543));
      }
      this.mRightFocusViewGroup.c(null);
      this.mRightFocusViewGroup.b(this.mViewGroup.findViewById(2131624543));
      locald.b(new com.baidu.carlife.f.a[] { this.mMiddleFocusViewGroup, this.mRightFocusViewGroup });
      if ((!isNeedShowDialog()) && (!isDialogShown())) {
        break;
      }
      return;
    }
    locald.h(this.mMiddleFocusViewGroup);
  }
  
  protected HomePoiBasicView initMapPoiDetailView()
  {
    return this.mPoiDetailView;
  }
  
  protected ViewGroup initViews()
  {
    this.mViewGroup = ((ViewGroup)LayoutInflater.from(mActivity).inflate(2130968655, null));
    this.mViewGroup.findViewById(2131624534).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mTopBarView = ((TopBarView)this.mViewGroup.findViewById(2131623936));
    this.mTopBarView.setAlpha(1.0F);
    this.mPoiDetailView = new HomePoiSimpleView(mActivity, this.mViewGroup, getNaviFragmentManager(), this);
    this.mCommonController = new CommonController(mActivity, this);
    initLocationManager();
    NaviState.getInstance().registerCustomCmd();
    return this.mViewGroup;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (mActivity != null) {
      mActivity.setRequestedOrientation(0);
    }
    super.onAttach(paramActivity);
  }
  
  public boolean onBackPressed()
  {
    if (switchMapFocus(false, false)) {}
    do
    {
      do
      {
        return true;
        if ((this.mPoiDetailView == null) || (!this.mPoiDetailView.isVisible())) {
          break;
        }
        this.mPoiDetailView.hide();
        enterCruiseFollowModeDetect();
        setMapFocusViewVisible(true);
      } while (this.mMiddleFocusViewGroup == null);
      d.a().h(this.mMiddleFocusViewGroup);
      return true;
    } while (mActivity == null);
    mActivity.d();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EnterQuitLogicManager.getmInstance().setNaviFragmentManager(getNaviFragmentManager());
    this.mMapViewConfig = MapViewConfig.getInstance();
    this.mMapView = MapViewFactory.getInstance().getMapView();
    MapViewConfig.getInstance().setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    this.mMapView.setOnLongPressListener(new OnLongPressListener()
    {
      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        CarModeMapFragment.this.handleLongPress(paramAnonymousMotionEvent);
      }
    });
    NavMapManager.getInstance().init();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mMapControlPanel.registerCruiseHandler(this);
    this.mMapControlPanel.setHomeMapPage(true);
    this.mMapControlPanel.onUpdateStyle(StyleManager.getRealDayStyle());
    n.a().a(this);
    this.mHandler = new Handler(Looper.getMainLooper());
    setBottomBarBackgroud(r.b(2130838234));
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.mHomeController != null) {
      this.mHomeController.dismissGPSSettingDialog();
    }
    if (mActivity != null) {
      mActivity.k();
    }
    if (this.mCommonController != null) {
      this.mCommonController.dismissNoNetAndOfflineDataDialog();
    }
    PoiController.getInstance().clearPoiCache();
    super.onDestroyView();
  }
  
  public void onEvent(Object paramObject)
  {
    if ((paramObject instanceof MapMoveEvent)) {
      onEventMainThread((MapMoveEvent)paramObject);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if ((!paramBoolean) && (this.mMapControlPanel != null)) {
      this.mMapControlPanel.showWatermark();
    }
    if (!paramBoolean)
    {
      setBottomBarBackgroud(r.b(2130838234));
      if (getCurrentFragmentType() == 17) {
        enterCruiseFollowModeDetect();
      }
      drivingSet();
    }
    do
    {
      return;
      setBottomBarBackgroud(null);
      if (this.mHomeController != null) {
        this.mHomeController.dismissGPSSettingDialog();
      }
      if (mActivity != null) {
        mActivity.k();
      }
    } while (this.mCommonController == null);
    this.mCommonController.dismissNoNetAndOfflineDataDialog();
  }
  
  public void onInitFocusAreas()
  {
    if (this.isDisplayed) {
      initFocusChain(this.mViewGroup);
    }
  }
  
  protected void onInitMap()
  {
    super.onInitMap();
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    BMEventBus.getInstance().unregist(this);
  }
  
  public void onResume()
  {
    NavItemizedOverlayUtil.getInstance().initWrapper(false, null);
    super.onResume();
    if (this.mTopBarView != null) {
      this.mTopBarView.a(StyleManager.getRealDayStyle());
    }
    setLeftTopPanelVisible(true);
    setLeftRightPanelVisible(true);
    setMapFocusViewVisible(true);
    if (this.mPoiDetailView != null)
    {
      this.mPoiDetailView.show(false);
      if (this.mPoiDetailView.isVisible()) {
        setMapFocusViewVisible(false);
      }
    }
    i.b(TAG);
    initLocationManager();
    enterCruiseFollowModeDetect();
    handleDialogShowLogic();
    drivingSet();
    updateMap();
    if ((this.mMapControlPanel != null) && (this.mMapViewConfig.getPositionStatus() != MapViewConfig.PositionStatus.NORMAL)) {
      this.mMapControlPanel.changeLocationModeByVoice(this.mMapViewConfig.getPositionStatus());
    }
    BMEventBus.getInstance().regist(this, MapMoveEvent.class, new Class[0]);
  }
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    super.onUpdateStyle(paramBoolean);
    if (this.mTopBarView != null) {
      this.mTopBarView.a(paramBoolean);
    }
  }
  
  public void quitCruise()
  {
    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
  }
  
  public void requestInitView()
  {
    super.requestInitView();
    enterCruiseFollowModeDetect();
  }
  
  public void showMapFocusView(boolean paramBoolean)
  {
    if ((this.mPoiDetailView != null) && (this.mPoiDetailView.isVisible())) {
      setMapFocusViewVisible(false);
    }
    do
    {
      return;
      setMapFocusViewVisible(paramBoolean);
    } while (paramBoolean);
    switchMapFocus(false, false);
  }
  
  public void showTopbarView()
  {
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.showTopBarView();
    }
  }
  
  protected void showTrafficMap(boolean paramBoolean)
  {
    if (this.mMapView != null)
    {
      updateMapTheme(paramBoolean);
      this.mMapView.forceSetTraffic(paramBoolean);
    }
  }
  
  public void stopDriving()
  {
    i.b("yftech", "CarModeMapFragment stopDriving");
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.showSearchView();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */