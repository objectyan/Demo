package com.baidu.navi.view;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.custom.b;
import com.baidu.carlife.view.TopBarView;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.adapter.MapControlPanelAdapter;
import com.baidu.navi.cruise.control.ICruiseEnterQuiteLogic;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.util.n;

public class MapControlPanel
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final int FIVEK_LEVEL = 12;
  private static final int H_LEVEL = 17;
  private static final int LOCATION_ACC_THRESHOLD = 1;
  private static final int LOCATION_ANG_THRESHOLD = 3;
  private static final int LOCATION_DIS_THRESHOLD = 1;
  private static final double MAX_WALK_SPEED = 2.0D;
  private static final double WAIT_SPEED_TIME = 30000.0D;
  private boolean isDayStyle = true;
  private boolean isHomeMapPage = false;
  private boolean isVisible = false;
  private boolean isWatermarkEnable = true;
  private MapViewConfig.PositionStatus lastPositionStatus;
  private int locAngle = 0;
  private long locTime = 0L;
  private CarlifeActivity mActivity;
  private int mAngleX = Integer.MIN_VALUE;
  private View mCarlifeLeftLayout;
  private ICruiseEnterQuiteLogic mCruiseEnterQuiteHandle;
  private double mCurLatitude;
  private double mCurLongitude;
  private com.baidu.carlife.f.g mFocusArea;
  private NaviFragmentManager mFragmentManager;
  private Handler mHandler = new Handler();
  private boolean mIsMapFocusOpen = false;
  private IItsClickListener mItsClickListener;
  private int mLastAngle = Integer.MIN_VALUE;
  private LocationManager.LocData mLastLoc;
  private View mLayerView;
  private View mLeftLayout;
  private ProgressBar mLocProgressBar;
  private View mLocation;
  private ImageView mLocationBtn;
  private ILocationBtnClickListener mLocationBtnClickListener;
  private com.baidu.carlife.f.e mMapFocusArea;
  private ImageView mMapFocusBtn;
  private View mMapFocusImage;
  private View mMapFocusView;
  private MapGLSurfaceView mMapView;
  private MapViewConfig mMapViewConfig;
  private MapControlPanelAdapter mMenuAdapter;
  private ImageView mMenuBtn;
  private com.baidu.carlife.view.dialog.d mMenuDialog;
  private View mMenuView;
  private com.baidu.carlife.core.screen.e mOnDialogListener;
  private View mRightLayout;
  private View mRootView;
  private View mScaleLevelLayout;
  private ScaleLevelView mScaleLevelView;
  private ImageView mSearchIc;
  private TextView mSearchTextView;
  private View mSearchView;
  private TopBarView mTopBarView;
  private Thread mWaitingLocTimer = null;
  private ImageView mWatermark;
  ZoomButtonView.OnZoomBtnClickListener mZoomBtnClickListener = new ZoomButtonView.OnZoomBtnClickListener()
  {
    public void onZoomInBtnClick()
    {
      MapControlPanel.this.mZoomButtonView.handleZoomIn();
    }
    
    public void onZoomOutBtnClick()
    {
      MapControlPanel.this.mZoomButtonView.handleZoomOut();
    }
  };
  private ZoomButtonView mZoomButtonView;
  private ImageView mZoomInBtnView;
  private ImageView mZoomOutBtnView;
  private boolean overlookAnimEnd = true;
  private long overlookAnimTime = 0L;
  private long sensorTime = 0L;
  
  public MapControlPanel(CarlifeActivity paramCarlifeActivity, View paramView, NaviFragmentManager paramNaviFragmentManager)
  {
    if ((paramView == null) || (paramCarlifeActivity == null)) {}
    do
    {
      return;
      this.mActivity = paramCarlifeActivity;
      this.mFragmentManager = paramNaviFragmentManager;
      this.mMapViewConfig = MapViewConfig.getInstance();
      this.mMapView = MapViewFactory.getInstance().getMapView();
      this.mRootView = paramView.findViewById(2131624946);
      this.isDayStyle = StyleManager.getDayStyle();
    } while (this.mRootView == null);
    this.mLayerView = this.mRootView.findViewById(2131625611);
    this.mMenuView = this.mRootView.findViewById(2131625605);
    this.mMenuView.setOnClickListener(this);
    this.mMenuBtn = ((ImageView)this.mRootView.findViewById(2131624951));
    this.mMenuBtn.setOnClickListener(this);
    this.mSearchView = this.mRootView.findViewById(2131625603);
    this.mSearchView.setOnClickListener(this);
    this.mSearchIc = ((ImageView)this.mRootView.findViewById(2131625604));
    this.mSearchTextView = ((TextView)this.mRootView.findViewById(2131625606));
    this.mSearchTextView.setOnClickListener(this);
    this.mScaleLevelLayout = this.mRootView.findViewById(2131624953);
    this.mWatermark = ((ImageView)this.mRootView.findViewById(2131625609));
    this.mScaleLevelView = new ScaleLevelView();
    this.mScaleLevelView.initView(this.mActivity, this.mRootView);
    this.mLocation = this.mRootView.findViewById(2131624948);
    this.mLocationBtn = ((ImageView)this.mRootView.findViewById(2131624949));
    this.mLocationBtn.setOnClickListener(this);
    this.mLocation.setOnClickListener(this);
    this.mLocProgressBar = ((ProgressBar)this.mRootView.findViewById(2131624952));
    this.mZoomButtonView = new ZoomButtonView();
    this.mZoomButtonView.initView(this.mActivity, this.mRootView);
    this.mZoomInBtnView = ((ImageView)this.mRootView.findViewById(2131624950));
    this.mZoomOutBtnView = ((ImageView)this.mRootView.findViewById(2131624959));
    this.mMapFocusView = this.mRootView.findViewById(2131625615);
    if (this.mMapFocusView != null)
    {
      boolean bool = com.baidu.carlife.logic.g.a().c();
      paramCarlifeActivity = this.mMapFocusView;
      if (!bool) {
        break label596;
      }
    }
    label596:
    for (int i = 0;; i = 8)
    {
      paramCarlifeActivity.setVisibility(i);
      this.mMapFocusView.setOnClickListener(this);
      this.mMapFocusBtn = ((ImageView)this.mRootView.findViewById(2131625616));
      this.mMapFocusImage = this.mRootView.findViewById(2131625612);
      this.mLeftLayout = this.mRootView.findViewById(2131624947);
      this.mRightLayout = this.mRootView.findViewById(2131624956);
      this.mTopBarView = ((TopBarView)this.mRootView.findViewById(2131623936));
      this.mCarlifeLeftLayout = this.mRootView.findViewById(2131625602);
      return;
    }
  }
  
  private void cancelMenuDialog()
  {
    if (this.mOnDialogListener != null) {
      this.mOnDialogListener.dismissDialog(this.mMenuDialog);
    }
  }
  
  private void changeMapByStatus(MapViewConfig.PositionStatus paramPositionStatus, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f = 18.0F;
    LocationManager.LocData localLocData = LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
    MapStatus localMapStatus = this.mMapView.getMapStatus();
    if (localMapStatus == null) {
      return;
    }
    if (paramBoolean1) {
      if (this.mMapViewConfig.getPositionStatus() == MapViewConfig.PositionStatus.FOLLOWING)
      {
        localMapStatus.centerPtX = ((int)localLocData.longitude);
        localMapStatus.centerPtY = ((int)localLocData.latitude);
        localMapStatus.level = 17.0F;
        if ((localLocData.floorId != null) && (localLocData.buildingId != null)) {
          localMapStatus.level = 20.0F;
        }
        if (paramPositionStatus != MapViewConfig.PositionStatus.NORMAL)
        {
          if (MapViewConfig.getInstance().getMapMode() != MapViewConfig.MapMode._3D) {
            localMapStatus.overlooking = 0;
          }
          localMapStatus.rotation = 0;
        }
      }
    }
    for (;;)
    {
      if (localMapStatus.level < 12.0F) {
        localMapStatus.level = 17.0F;
      }
      updateLocOverlay(localLocData, this.mMapViewConfig.getPositionStatus());
      paramPositionStatus = this.mMapViewConfig.getPositionStatus();
      if (((paramBoolean1) && (this.mMapView.getController().isMovedMap())) || ((paramPositionStatus != MapViewConfig.PositionStatus.COMPASS) && (paramPositionStatus != MapViewConfig.PositionStatus.FOLLOWING))) {
        break;
      }
      if (!n.a()) {
        break label489;
      }
      if (!paramBoolean1) {
        break label476;
      }
      this.mMapView.setMapStatus(localMapStatus);
      return;
      switch (this.mMapViewConfig.getPositionStatus())
      {
      default: 
        break;
      case ???: 
        localMapStatus.centerPtX = ((int)localLocData.longitude);
        localMapStatus.centerPtY = ((int)localLocData.latitude);
        if (paramPositionStatus != MapViewConfig.PositionStatus.NORMAL)
        {
          if (MapViewConfig.getInstance().getMapMode() != MapViewConfig.MapMode._3D) {
            localMapStatus.overlooking = 0;
          }
          localMapStatus.rotation = 0;
        }
        if (paramBoolean2)
        {
          localMapStatus.overlooking = 0;
          localMapStatus.rotation = 0;
        }
        break;
      }
    }
    localMapStatus.centerPtX = ((int)localLocData.longitude);
    localMapStatus.centerPtY = ((int)localLocData.latitude);
    localMapStatus.overlooking = -45;
    if (this.isHomeMapPage) {
      localMapStatus.overlooking = -45;
    }
    if (localLocData.direction > 0.0F)
    {
      localMapStatus.rotation = ((int)localLocData.direction);
      label407:
      if ((localLocData.buildingId != null) && (localLocData.floorId != null)) {
        break label464;
      }
      if (localMapStatus.level >= 18.0F) {
        break label466;
      }
    }
    for (;;)
    {
      localMapStatus.level = f;
      break;
      if (this.mAngleX == Integer.MIN_VALUE) {
        break label407;
      }
      localMapStatus.rotation = this.mAngleX;
      break label407;
      label464:
      break;
      label466:
      f = localMapStatus.level;
    }
    label476:
    this.mMapView.animateTo(localMapStatus, 1000);
    return;
    label489:
    if (paramBoolean1)
    {
      this.mMapView.setMapStatus(localMapStatus);
      return;
    }
    this.mMapView.animateTo(localMapStatus, 1000);
  }
  
  private void handleMapFocusClicked()
  {
    this.mIsMapFocusOpen = false;
    switchMapFocus(true, false);
    if (this.mMapFocusArea == null)
    {
      this.mMapFocusArea = new com.baidu.carlife.f.e(this.mRootView, 4);
      if (this.mMapFocusImage != null) {
        this.mMapFocusArea.c(this.mMapFocusImage);
      }
    }
    this.mMapFocusArea.a(this.mZoomBtnClickListener);
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.mMapFocusArea });
    this.mMapFocusImage.requestFocus();
  }
  
  private boolean isNeedRefreshLocationOverlay(LocationManager.LocData paramLocData, MapViewConfig.PositionStatus paramPositionStatus)
  {
    return (this.mLastLoc == null) || (Math.abs(this.mLastLoc.latitude - paramLocData.latitude) >= 1.0D) || (Math.abs(this.mLastLoc.longitude - paramLocData.longitude) >= 1.0D) || (Math.abs(this.mLastLoc.accuracy - paramLocData.accuracy) >= 1.0F) || (Math.abs(this.mLastLoc.direction - paramLocData.direction) >= 3.0F) || (this.lastPositionStatus == null) || (this.lastPositionStatus != paramPositionStatus);
  }
  
  private void showMenuDialog()
  {
    cancelMenuDialog();
    if (this.mCruiseEnterQuiteHandle != null) {
      this.mCruiseEnterQuiteHandle.quitCruise();
    }
    if (this.mMenuAdapter == null) {
      this.mMenuAdapter = new MapControlPanelAdapter(this.mActivity);
    }
    if ((com.baidu.carlife.l.a.a().N()) && ((com.baidu.carlife.custom.a.a().b()) || (b.a().b()))) {
      this.mMenuAdapter.updateFavoriteItem();
    }
    if (this.mMenuDialog == null)
    {
      this.mMenuDialog = new com.baidu.carlife.view.dialog.d(this.mActivity, this.mMenuAdapter, this);
      this.mMenuDialog.j();
    }
    for (;;)
    {
      if (this.mOnDialogListener != null) {
        this.mOnDialogListener.showDialog(this.mMenuDialog, BaseDialog.a.d);
      }
      return;
      this.mMenuDialog.i();
    }
  }
  
  private void updateLocOverlay(LocationManager.LocData paramLocData, MapViewConfig.PositionStatus paramPositionStatus)
  {
    if ((paramLocData.latitude == -1.0D) && (paramLocData.longitude == -1.0D)) {
      break label22;
    }
    label22:
    while (this.mMapViewConfig.getPositionStatus() == MapViewConfig.PositionStatus.TRACKING) {
      return;
    }
    float f = paramLocData.direction;
    if ((paramLocData.speed > 2.0D) && (f > 0.0F)) {}
    for (;;)
    {
      paramLocData.direction = f;
      if (!isNeedRefreshLocationOverlay(paramLocData, paramPositionStatus)) {
        break;
      }
      String str = paramLocData.toLocationOverlayJsonString(true);
      LocationOverlay localLocationOverlay = (LocationOverlay)this.mMapView.getOverlay(LocationOverlay.class);
      if (localLocationOverlay != null)
      {
        localLocationOverlay.setData(str);
        localLocationOverlay.UpdateOverlay();
      }
      this.mLastLoc = paramLocData;
      this.lastPositionStatus = paramPositionStatus;
      return;
      f = this.mAngleX;
    }
  }
  
  private void updateLocationTip()
  {
    this.mLocProgressBar.setVisibility(8);
    switch (LocationManager.getInstance().getCurLocationType())
    {
    }
    for (;;)
    {
      this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
      MainMapModel.getInstance().setLocMode(0);
      updateLocationBtn();
      return;
      TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getResources().getString(2131296559));
      continue;
      TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getResources().getString(2131296558));
    }
  }
  
  private void updateScale()
  {
    int m = BNMapController.getInstance().getScreenWidth();
    int j = BNMapController.getInstance().getZoomLevel();
    double d = BNMapController.getInstance().getZoomUnitsInMeter();
    int i = com.baidu.nplatform.comapi.map.MapController.getScaleDis(j);
    LogUtil.e("Map", "room updateScale dis=" + i + " level=" + j + " u=" + d);
    for (int k = (int)Math.ceil(i / d); (k > m / 2) && (j >= 3) && (j <= 20); k = (int)Math.ceil(i / d))
    {
      j += 1;
      i = com.baidu.nplatform.comapi.map.MapController.getScaleDis(j);
    }
    if (i >= 1000) {}
    for (String str = i / 1000 + this.mActivity.getString(2131296549);; str = i + this.mActivity.getString(2131296593))
    {
      this.mScaleLevelView.updateScaleView(str, k);
      if (!this.isWatermarkEnable) {
        break;
      }
      this.mScaleLevelLayout.setVisibility(8);
      this.mWatermark.setVisibility(0);
      return;
    }
    this.mScaleLevelLayout.setVisibility(0);
    this.mWatermark.setVisibility(8);
  }
  
  private void updateZoomButton()
  {
    int i = BNMapController.getInstance().getZoomLevel();
    LogUtil.e("Map", "updateZoomButton. level = " + i);
    if (i <= 4)
    {
      this.mZoomButtonView.updateZoomBtn(true, false);
      return;
    }
    if (i >= 21)
    {
      this.mZoomButtonView.updateZoomBtn(false, true);
      return;
    }
    this.mZoomButtonView.updateZoomBtn(true, true);
  }
  
  public void changeLocationMode(int paramInt)
  {
    MainMapModel.getInstance().mFirstAutoLocMode = paramInt;
    if (paramInt == MainMapModel.getInstance().getCurLocMode()) {}
    do
    {
      return;
      if (!BNLocationManagerProxy.getInstance().isLocationValid()) {
        break;
      }
      paramInt = MainMapModel.getInstance().setLocMode(paramInt);
      updateLocationBtn();
    } while ((paramInt != 1) || (this.mLocProgressBar.getVisibility() != 0));
    this.mLocProgressBar.setVisibility(8);
    return;
    this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    MainMapModel.getInstance().setLocMode(0);
    TipTool.onCreateToastDialog(this.mActivity, this.mActivity.getResources().getString(2131296557));
    this.mLocationBtn.setImageDrawable(null);
    this.mLocProgressBar.setVisibility(0);
    if (this.mWaitingLocTimer == null) {
      this.mWaitingLocTimer = new Thread(getClass().getSimpleName())
      {
        public void run()
        {
          MapControlPanel.this.updateLocationTip();
        }
      };
    }
    this.mHandler.postDelayed(this.mWaitingLocTimer, 15000L);
  }
  
  public void changeLocationModeByVoice(MapViewConfig.PositionStatus paramPositionStatus)
  {
    int i = MainMapModel.getInstance().getCurLocMode();
    if (this.mMapViewConfig != null)
    {
      MapViewConfig.PositionStatus localPositionStatus = this.mMapViewConfig.getPositionStatus();
      this.mMapViewConfig.setPositionStatus(paramPositionStatus);
      changeMapByStatus(localPositionStatus, false, true);
      switch (paramPositionStatus)
      {
      }
    }
    for (;;)
    {
      changeLocationMode(i);
      this.overlookAnimTime = System.currentTimeMillis();
      return;
      i = 2;
      continue;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public void disableWatermark()
  {
    this.isWatermarkEnable = false;
  }
  
  public View getLocationView()
  {
    return this.mLocation;
  }
  
  public View getView()
  {
    return this.mRootView;
  }
  
  public ZoomButtonView getZoomButtonView()
  {
    return this.mZoomButtonView;
  }
  
  public ImageView getZoomInBtnView()
  {
    return this.mZoomInBtnView;
  }
  
  public ImageView getZoomOutBtnView()
  {
    return this.mZoomOutBtnView;
  }
  
  public void handleLocationBtnClick()
  {
    if (this.mLocationBtnClickListener != null) {
      this.mLocationBtnClickListener.onClick(this.mMapViewConfig.getPositionStatus());
    }
    onLocationBtnClicked();
  }
  
  public void handleScrollGesture()
  {
    disableWatermark();
    resetLocMode();
    setVisible(true);
  }
  
  public void handleSingleTouchGesture()
  {
    resetLocMode();
    switchMapFocus(false, true);
  }
  
  public void hide()
  {
    this.mTopBarView.setVisibility(8);
    this.mMenuView.setVisibility(8);
    this.mSearchView.setVisibility(8);
  }
  
  public void hideLayerView()
  {
    this.mLayerView.setVisibility(8);
  }
  
  public void hideSearchView()
  {
    this.mSearchView.setVisibility(8);
    if (this.mMenuDialog != null) {
      this.mMenuDialog.i();
    }
  }
  
  public void hideShowTopBarView()
  {
    this.mTopBarView.setVisibility(8);
  }
  
  public com.baidu.carlife.f.g initFocusChain(View paramView)
  {
    if (this.mFocusArea == null)
    {
      this.mFocusArea = new com.baidu.carlife.f.g(paramView.findViewById(2131624946), 4, true);
      this.mFocusArea.d(this.mMenuView).d(this.mSearchTextView);
      if (this.mMapFocusView != null) {
        this.mFocusArea.d(this.mMapFocusView);
      }
      this.mFocusArea.d(this.mZoomInBtnView).d(this.mZoomOutBtnView).d(this.mLocation);
      this.mFocusArea.b(true);
      this.mFocusArea.b(this.mSearchTextView);
    }
    return this.mFocusArea;
  }
  
  public boolean isMapFocusOpen()
  {
    return this.mIsMapFocusOpen;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131624949) || (i == 1711866148))
    {
      if (this.mCruiseEnterQuiteHandle != null) {
        this.mCruiseEnterQuiteHandle.enterCruise();
      }
      handleLocationBtnClick();
    }
    do
    {
      do
      {
        return;
        if ((i != 2131624948) && (i != 1711866147)) {
          break;
        }
        handleLocationBtnClick();
      } while (this.mCruiseEnterQuiteHandle == null);
      this.mCruiseEnterQuiteHandle.enterCruise();
      return;
      if (i == 2131625615)
      {
        handleMapFocusClicked();
        return;
      }
      if ((i == 2131624951) || (i == 2131625605))
      {
        showMenuDialog();
        return;
      }
    } while ((i != 2131625603) && (i != 2131625606));
    this.mFragmentManager.showFragment(49, null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    cancelMenuDialog();
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return;
        this.mFragmentManager.showFragment(304, null);
        return;
      } while (this.mItsClickListener == null);
      this.mItsClickListener.onClickIts();
      return;
    }
    StatisticManager.onEvent("NAVI_0003", "NAVI_0003");
    com.baidu.carlife.m.a.a().a(com.baidu.carlife.l.a.a().N());
    this.mFragmentManager.showFragment(114, null);
  }
  
  protected void onLocationBtnClicked()
  {
    int i = MainMapModel.getInstance().getCurLocMode();
    switch (this.mMapViewConfig.getPositionStatus())
    {
    }
    for (;;)
    {
      changeLocationMode(i);
      this.overlookAnimTime = System.currentTimeMillis();
      return;
      i = 1;
      this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.FOLLOWING);
      changeMapByStatus(MapViewConfig.PositionStatus.NORMAL, false, false);
      continue;
      i = 2;
      this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.COMPASS);
      changeMapByStatus(MapViewConfig.PositionStatus.FOLLOWING, false, false);
      continue;
      i = 1;
      this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.FOLLOWING);
      changeMapByStatus(MapViewConfig.PositionStatus.COMPASS, false, false);
    }
  }
  
  public void onLocationChange(LocationManager.LocData paramLocData, boolean paramBoolean)
  {
    if ((!LocationManager.getInstance().isLocationValid()) || (this.mMapView == null) || (System.currentTimeMillis() - this.overlookAnimTime < 3000L)) {}
    while ((paramLocData == null) || ((!MainMapModel.getInstance().bFirstShowLoc) && (this.mCurLongitude == paramLocData.longitude) && (this.mCurLatitude == paramLocData.latitude))) {
      return;
    }
    MapStatus localMapStatus = this.mMapView.getMapStatus();
    MainMapModel.getInstance().bFirstShowLoc = false;
    this.mCurLongitude = paramLocData.longitude;
    this.mCurLatitude = paramLocData.latitude;
    MapViewConfig.PositionStatus localPositionStatus;
    if ((this.mCurLongitude > 0.0D) && (this.mCurLatitude > 0.0D))
    {
      if ((MainMapModel.getInstance().bFirstLoc) && (paramBoolean))
      {
        MainMapModel.getInstance().bFirstLoc = false;
        localMapStatus.centerPtX = paramLocData.longitude;
        localMapStatus.centerPtY = paramLocData.latitude;
        this.mMapView.animateTo(localMapStatus, 0);
      }
      localPositionStatus = this.mMapViewConfig.getPositionStatus();
      if (((localPositionStatus == MapViewConfig.PositionStatus.COMPASS) || (localPositionStatus == MapViewConfig.PositionStatus.FOLLOWING)) && (paramBoolean) && (this.isHomeMapPage)) {
        if (localPositionStatus == MapViewConfig.PositionStatus.COMPASS)
        {
          localMapStatus.overlooking = -45;
          if (this.isHomeMapPage) {
            localMapStatus.overlooking = -45;
          }
          if (paramLocData.direction <= 0.0F) {
            break label290;
          }
          localMapStatus.rotation = ((int)paramLocData.direction);
        }
      }
    }
    for (;;)
    {
      localMapStatus.centerPtX = paramLocData.longitude;
      localMapStatus.centerPtY = paramLocData.latitude;
      this.mMapView.animateTo(localMapStatus, 0);
      updateLocOverlay(paramLocData, localPositionStatus);
      return;
      TipTool.onCreateToastDialog(this.mActivity, 2131297228);
      break;
      label290:
      if (this.mAngleX != Integer.MIN_VALUE) {
        localMapStatus.rotation = this.mAngleX;
      }
    }
  }
  
  public void onResume()
  {
    setMapFocusVisible(false);
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    LogUtil.e("StyleDebug", "MapControlPanel dayStyle = " + paramBoolean);
    if ((this.mZoomButtonView == null) || (this.mLocationBtn == null) || (this.mScaleLevelView == null) || (this.mMenuBtn == null) || (this.mLayerView == null) || (this.mSearchView == null) || (this.mMapFocusBtn == null) || (this.mSearchIc == null)) {
      return;
    }
    i.b("StyleDebug", "MapControlPanel dayStyle = " + paramBoolean);
    this.isDayStyle = paramBoolean;
    this.mLayerView.setBackground(StyleManager.getDrawable(2130838859, this.isDayStyle));
    this.mSearchView.setBackground(StyleManager.getDrawable(2130838848, this.isDayStyle));
    this.mMenuBtn.setBackground(StyleManager.getDrawable(2130838854, this.isDayStyle));
    this.mLocationBtn.setBackground(StyleManager.getDrawable(2130838852, this.isDayStyle));
    this.mMapFocusBtn.setBackground(StyleManager.getDrawable(2130838852, this.isDayStyle));
    updateLocationBtn();
    this.mZoomButtonView.onUpdateStyle(this.isDayStyle);
    this.mScaleLevelView.onUpdateStyle(this.isDayStyle);
  }
  
  public void registerCruiseHandler(ICruiseEnterQuiteLogic paramICruiseEnterQuiteLogic)
  {
    this.mCruiseEnterQuiteHandle = paramICruiseEnterQuiteLogic;
  }
  
  public void resetLocMode()
  {
    if ((this.mLocProgressBar != null) && (this.mLocProgressBar.getVisibility() != 0))
    {
      MainMapModel.getInstance().setLocMode(0);
      this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
      updateLocationBtn();
    }
  }
  
  public void setHomeMapPage(boolean paramBoolean)
  {
    this.isHomeMapPage = paramBoolean;
  }
  
  public void setItsClickListener(IItsClickListener paramIItsClickListener)
  {
    this.mItsClickListener = paramIItsClickListener;
  }
  
  public void setLeftRightPanelVisible(boolean paramBoolean)
  {
    int j = 0;
    View localView;
    if (this.mLeftLayout != null)
    {
      localView = this.mLeftLayout;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
      }
    }
    else if (this.mRightLayout != null)
    {
      localView = this.mRightLayout;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public void setLeftTopPanelVisible(boolean paramBoolean)
  {
    View localView;
    if (this.mCarlifeLeftLayout != null)
    {
      localView = this.mCarlifeLeftLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setLocationBtnClickListener(ILocationBtnClickListener paramILocationBtnClickListener)
  {
    this.mLocationBtnClickListener = paramILocationBtnClickListener;
  }
  
  public void setMapFocusViewVisible(boolean paramBoolean)
  {
    View localView;
    if (this.mMapFocusView != null)
    {
      boolean bool = com.baidu.carlife.logic.g.a().c();
      localView = this.mMapFocusView;
      if ((!paramBoolean) || (!bool)) {
        break label37;
      }
    }
    label37:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setMapFocusVisible(boolean paramBoolean)
  {
    View localView;
    if (this.mMapFocusImage != null)
    {
      localView = this.mMapFocusImage;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setOnDialogListener(com.baidu.carlife.core.screen.e parame)
  {
    this.mOnDialogListener = parame;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.isVisible == paramBoolean) {
      return;
    }
    this.isVisible = paramBoolean;
  }
  
  public void setZoomBtnClickListener(ZoomButtonView.OnZoomBtnClickListener paramOnZoomBtnClickListener)
  {
    this.mZoomButtonView.setZoomBtnClickListener(paramOnZoomBtnClickListener);
  }
  
  public void show()
  {
    this.mTopBarView.setVisibility(0);
    this.mMenuView.setVisibility(0);
    this.mSearchView.setVisibility(0);
  }
  
  public void showLayerView()
  {
    this.mLayerView.setVisibility(0);
  }
  
  public void showSearchView()
  {
    this.mSearchView.setVisibility(0);
    if (this.mMenuDialog != null) {
      this.mMenuDialog.i();
    }
  }
  
  public void showTopBarView()
  {
    this.mTopBarView.setVisibility(0);
  }
  
  public void showWatermark()
  {
    this.mWatermark.setVisibility(0);
    this.mScaleLevelLayout.setVisibility(8);
  }
  
  public void switchMapFocus(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.mIsMapFocusOpen == paramBoolean1) {
      return;
    }
    this.mIsMapFocusOpen = paramBoolean1;
    if (!paramBoolean2)
    {
      if (!paramBoolean1)
      {
        paramBoolean2 = true;
        setVisible(paramBoolean2);
      }
    }
    else
    {
      if (paramBoolean1) {
        break label64;
      }
      paramBoolean2 = true;
      label37:
      setLeftTopPanelVisible(paramBoolean2);
      if (paramBoolean1) {
        break label69;
      }
    }
    label64:
    label69:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      setLeftRightPanelVisible(paramBoolean2);
      setMapFocusVisible(paramBoolean1);
      return;
      paramBoolean2 = false;
      break;
      paramBoolean2 = false;
      break label37;
    }
  }
  
  public void updateLocationBtn()
  {
    switch (MainMapModel.getInstance().getCurLocMode())
    {
    default: 
      return;
    case 0: 
      this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(2130838880));
      return;
    case 1: 
      this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(2130838891));
      return;
    }
    this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(2130838892));
  }
  
  public void updateMapBySensorAngle(int paramInt)
  {
    float f2 = 0.0F;
    if (!this.isHomeMapPage) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramInt + MainMapModel.getInstance().mScreenRotation;
        this.mAngleX = i;
      } while (this.mMapViewConfig.getPositionStatus() == MapViewConfig.PositionStatus.TRACKING);
      int j = (int)(System.currentTimeMillis() - this.sensorTime);
      if (this.sensorTime != 0L)
      {
        paramInt = j;
        if (j > 500) {}
      }
      else
      {
        paramInt = 500;
      }
      if (Math.abs(i - this.mLastAngle) >= 30) {
        paramInt = 500;
      }
      this.sensorTime = System.currentTimeMillis();
      if (this.sensorTime - this.overlookAnimTime >= 3000L) {
        this.overlookAnimEnd = true;
      }
    } while ((i == this.mLastAngle) || (!this.overlookAnimEnd));
    this.mLastAngle = i;
    LocationManager.LocData localLocData = LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
    if (localLocData != null) {}
    MapStatus localMapStatus;
    for (float f1 = localLocData.direction;; f1 = 0.0F)
    {
      if (localLocData != null) {
        f2 = localLocData.speed;
      }
      localMapStatus = this.mMapView.getMapStatus();
      if ((localMapStatus == null) || (this.mMapViewConfig.getPositionStatus() != MapViewConfig.PositionStatus.COMPASS)) {
        break label364;
      }
      localMapStatus.centerPtX = ((int)localLocData.longitude);
      localMapStatus.centerPtY = ((int)localLocData.latitude);
      localMapStatus.overlooking = -45;
      if (this.isHomeMapPage) {
        localMapStatus.overlooking = -45;
      }
      if (f2 <= 2.0D) {
        break;
      }
      this.locAngle = ((int)f1);
      this.locTime = System.currentTimeMillis();
      localMapStatus.rotation = this.locAngle;
      if (this.mMapView.getController() != null) {
        this.mMapView.animateTo(localMapStatus, paramInt);
      }
      localLocData.direction = localMapStatus.rotation;
      updateLocOverlay(localLocData, this.mMapViewConfig.getPositionStatus());
      return;
    }
    if (System.currentTimeMillis() - this.locTime <= 30000.0D) {
      i = this.locAngle;
    }
    for (;;)
    {
      localMapStatus.rotation = i;
      break;
    }
    label364:
    if (f2 > 2.0D) {}
    for (f1 = (int)f1;; f1 = i)
    {
      localLocData.direction = f1;
      break;
    }
  }
  
  public void updateMenuDialog()
  {
    if (this.mMenuAdapter != null) {
      this.mMenuAdapter.notifyDataSetChanged();
    }
  }
  
  public void updateView()
  {
    updateScale();
    updateZoomButton();
    BNMapController.getInstance().updateLayer(10);
    BNMapController.getInstance().UpdataBaseLayers();
  }
  
  public static abstract interface IItsClickListener
  {
    public abstract void onClickIts();
  }
  
  public static abstract interface ILocationBtnClickListener
  {
    public abstract void onClick(MapViewConfig.PositionStatus paramPositionStatus);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/MapControlPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */