package com.baidu.navi.routedetails;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.ScaleLevelView;
import com.baidu.navi.view.ZoomButtonView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.util.n;

public class BNMapControlPanelSimple
  implements View.OnClickListener
{
  private static final int FIVEK_LEVEL = 12;
  private static final int H_LEVEL = 17;
  private static final int LOCATION_ACC_THRESHOLD = 1;
  private static final int LOCATION_ANG_THRESHOLD = 3;
  private static final int LOCATION_DIS_THRESHOLD = 1;
  private static final double MAX_WALK_SPEED = 2.0D;
  private static final double WAIT_SPEED_TIME = 30000.0D;
  private boolean isVisible = true;
  private MapViewConfig.PositionStatus lastPositionStatus;
  private int locAngle = 0;
  private long locTime = 0L;
  private int mAngleX = Integer.MIN_VALUE;
  private Context mContext;
  private DistrictInfo mDistrict;
  private Handler mHandler = new Handler();
  private View mITSButtonView;
  private ImageView mITSImageView;
  private BNMapControlPanel.IItsClickListener mItsClickListener;
  private int mLastAngle = Integer.MIN_VALUE;
  private LocationManager.LocData mLastLoc;
  private View mLeftLayout;
  private ProgressBar mLocProgressBar;
  private RelativeLayout mLocationBtn;
  private BNMapControlPanel.ILocationBtnClickListener mLocationBtnClickListener;
  private ImageView mLocationImg;
  private MapGLSurfaceView mMapView;
  private MapViewConfig mMapViewConfig;
  private View mRightLayout;
  private View mRootView;
  private ScaleLevelView mScaleLevelView;
  private Thread mWaitingLocTimer = null;
  private ZoomButtonView mZoomButtonView;
  private LinearLayout mZoomPanel;
  private boolean noNightStyle = false;
  private boolean overlookAnimEnd = true;
  private long overlookAnimTime = 0L;
  private long sensorTime = 0L;
  
  public BNMapControlPanelSimple(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.mRootView = paramView.findViewById(2131624946);
    if (this.mRootView == null) {
      return;
    }
    this.mMapViewConfig = MapViewConfig.getInstance();
    this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    this.mMapView = MapViewFactory.getInstance().getMapView();
    this.mScaleLevelView = new ScaleLevelView();
    this.mScaleLevelView.initView(this.mContext, this.mRootView);
    this.mLocationBtn = ((RelativeLayout)this.mRootView.findViewById(2131624948));
    this.mLocationBtn.setOnClickListener(this);
    this.mLocationImg = ((ImageView)this.mRootView.findViewById(2131624949));
    this.mLocProgressBar = ((ProgressBar)this.mRootView.findViewById(2131624952));
    this.mZoomButtonView = new ZoomButtonView();
    this.mZoomButtonView.initView(this.mContext, this.mRootView, true);
    this.mITSButtonView = this.mRootView.findViewById(2131624960);
    this.mITSButtonView.setOnClickListener(this);
    this.mITSImageView = ((ImageView)this.mRootView.findViewById(2131624961));
    this.mLeftLayout = this.mRootView.findViewById(2131624947);
    this.mRightLayout = this.mRootView.findViewById(2131624956);
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
        break label470;
      }
      if (!paramBoolean1) {
        break label457;
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
    if (localLocData.direction > 0.0F)
    {
      localMapStatus.rotation = ((int)localLocData.direction);
      label389:
      if ((localLocData.buildingId != null) && (localLocData.floorId != null)) {
        break label445;
      }
      if (localMapStatus.level >= 18.0F) {
        break label447;
      }
    }
    for (;;)
    {
      localMapStatus.level = f;
      break;
      if (this.mAngleX == Integer.MIN_VALUE) {
        break label389;
      }
      localMapStatus.rotation = this.mAngleX;
      break label389;
      label445:
      break;
      label447:
      f = localMapStatus.level;
    }
    label457:
    this.mMapView.animateTo(localMapStatus, 1000);
    return;
    label470:
    if (paramBoolean1)
    {
      this.mMapView.setMapStatus(localMapStatus);
      return;
    }
    this.mMapView.animateTo(localMapStatus, 1000);
  }
  
  private boolean isNeedRefreshLocationOverlay(LocationManager.LocData paramLocData, MapViewConfig.PositionStatus paramPositionStatus)
  {
    return (this.mLastLoc == null) || (Math.abs(this.mLastLoc.latitude - paramLocData.latitude) >= 1.0D) || (Math.abs(this.mLastLoc.longitude - paramLocData.longitude) >= 1.0D) || (Math.abs(this.mLastLoc.accuracy - paramLocData.accuracy) >= 1.0F) || (Math.abs(this.mLastLoc.direction - paramLocData.direction) >= 3.0F) || (this.lastPositionStatus == null) || (this.lastPositionStatus != paramPositionStatus);
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
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711670036));
    this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    MainMapModel.getInstance().setLocMode(0);
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
    for (String str = i / 1000 + JarUtils.getResources().getString(1711670033);; str = i + JarUtils.getResources().getString(1711670034))
    {
      if (this.mScaleLevelView != null) {
        this.mScaleLevelView.updateScaleView(str, k);
      }
      return;
    }
  }
  
  private void updateZoomButton()
  {
    int i = BNMapController.getInstance().getZoomLevel();
    LogUtil.e("Map", "updateZoomButton. level = " + i);
    if (i <= 3)
    {
      this.mZoomButtonView.updateZoomBtn(true, false);
      return;
    }
    if (i >= 20)
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
      BNLocationManagerProxy.getInstance().getCurLocation();
    } while ((paramInt != 1) || (this.mLocProgressBar.getVisibility() != 0));
    this.mLocProgressBar.setVisibility(8);
    return;
    MainMapModel.getInstance().setLocMode(0);
    this.mMapViewConfig.setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711670037));
    this.mLocationImg.setImageDrawable(null);
    this.mLocProgressBar.setVisibility(0);
    if (this.mWaitingLocTimer == null) {
      this.mWaitingLocTimer = new Thread(getClass().getSimpleName())
      {
        public void run()
        {
          BNMapControlPanelSimple.this.updateLocationTip();
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
  
  public View getITSButtonView()
  {
    return this.mITSButtonView;
  }
  
  public View getLocationBtn()
  {
    return this.mLocationBtn;
  }
  
  public View getView()
  {
    return this.mRootView;
  }
  
  public ZoomButtonView getZoomButtonView()
  {
    return this.mZoomButtonView;
  }
  
  public View getZoomInBtnView()
  {
    if (this.mZoomButtonView != null) {
      return this.mZoomButtonView.getZoomInBtnView();
    }
    return null;
  }
  
  public View getZoomOutBtnView()
  {
    if (this.mZoomButtonView != null) {
      return this.mZoomButtonView.getZoomOutBtnView();
    }
    return null;
  }
  
  public void handleLocationBtnClick()
  {
    onLocationBtnClicked();
  }
  
  public void handleScrollGesture()
  {
    resetLocMode();
  }
  
  public void handleSingleTouchGesture()
  {
    resetLocMode();
  }
  
  public void hide()
  {
    this.mScaleLevelView.hide();
    this.mLocationBtn.setVisibility(4);
    this.mZoomButtonView.hide();
    this.mITSButtonView.setVisibility(4);
  }
  
  public boolean isNoNightStyle()
  {
    return this.noNightStyle;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public void notifyItsClicked()
  {
    if (this.mItsClickListener != null)
    {
      this.mItsClickListener.onClickIts();
      updateItsBtn();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131624948) {
      handleLocationBtnClick();
    }
    while (i != 2131624960) {
      return;
    }
    notifyItsClicked();
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
  
  public void onPause() {}
  
  public void onResume()
  {
    updateItsBtn();
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    LogUtil.e("StyleDebug", "MapControlPanel dayStyle = " + paramBoolean);
    if ((this.mZoomButtonView == null) || (this.mLocationImg == null) || (this.mScaleLevelView == null) || (this.mITSImageView == null)) {
      return;
    }
    this.mZoomButtonView.onUpdateStyle(paramBoolean);
    this.mScaleLevelView.onUpdateStyle(paramBoolean);
    this.mLocationImg.setBackground(StyleManager.getDrawable(2130838852));
    this.mITSImageView.setBackground(StyleManager.getDrawable(2130838852));
    updateItsBtn();
    updateLocationBtn();
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
  
  public void setItsClickListener(BNMapControlPanel.IItsClickListener paramIItsClickListener)
  {
    this.mItsClickListener = paramIItsClickListener;
  }
  
  public void setLocationBtnClickListener(BNMapControlPanel.ILocationBtnClickListener paramILocationBtnClickListener)
  {
    this.mLocationBtnClickListener = paramILocationBtnClickListener;
  }
  
  public void setNoNightStyle(boolean paramBoolean)
  {
    this.noNightStyle = paramBoolean;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    Animation localAnimation;
    if (paramBoolean)
    {
      localObject = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_LEFT_IN, 0L, 300L);
      localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_RIGHT_IN, 0L, 300L);
      this.mLeftLayout.startAnimation((Animation)localObject);
      this.mRightLayout.startAnimation(localAnimation);
      this.isVisible = paramBoolean;
      if (!paramBoolean) {
        break label107;
      }
      this.mLeftLayout.setVisibility(0);
      label63:
      localObject = this.mRightLayout;
      if (!this.isVisible) {
        break label132;
      }
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      return;
      localObject = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_LEFT_OUT, 0L, 300L);
      localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_RIGHT_OUT, 0L, 300L);
      break;
      label107:
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          BNMapControlPanelSimple.this.mLeftLayout.setVisibility(8);
        }
      }, 200L);
      break label63;
      label132:
      i = 8;
    }
  }
  
  public void show()
  {
    this.mScaleLevelView.show();
    this.mLocationBtn.setVisibility(0);
    this.mZoomButtonView.show();
    this.mITSButtonView.setVisibility(0);
  }
  
  public void updateItsBtn()
  {
    LogUtil.e("updateItsBtn", "updateItsBtn mIsItsOpen = " + BNSettingManager.isRoadCondOnOrOff());
    if (BNSettingManager.isRoadCondOnOrOff())
    {
      this.mITSImageView.setImageDrawable(StyleManager.getDrawable(2130838874));
      return;
    }
    this.mITSImageView.setImageDrawable(StyleManager.getDrawable(2130838873));
  }
  
  public void updateLocationBtn()
  {
    switch (MainMapModel.getInstance().getCurLocMode())
    {
    default: 
      return;
    case 0: 
      this.mLocationImg.setImageDrawable(StyleManager.getDrawable(2130838880));
      return;
    case 1: 
      this.mLocationImg.setImageDrawable(StyleManager.getDrawable(2130838891));
      return;
    }
    this.mLocationImg.setImageDrawable(StyleManager.getDrawable(2130838892));
  }
  
  public void updateMapBySensorAngle(int paramInt)
  {
    float f2 = 0.0F;
    int i = paramInt + MainMapModel.getInstance().mScreenRotation;
    this.mAngleX = i;
    if (this.mMapViewConfig.getPositionStatus() == MapViewConfig.PositionStatus.TRACKING) {}
    do
    {
      return;
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
    MapStatus localMapStatus;
    if (localLocData != null)
    {
      f1 = localLocData.direction;
      if (localLocData != null) {
        f2 = localLocData.speed;
      }
      localMapStatus = this.mMapView.getMapStatus();
      if ((localMapStatus == null) || (this.mMapViewConfig.getPositionStatus() != MapViewConfig.PositionStatus.COMPASS)) {
        break label340;
      }
      localMapStatus.centerPtX = ((int)localLocData.longitude);
      localMapStatus.centerPtY = ((int)localLocData.latitude);
      localMapStatus.overlooking = -45;
      if (f2 <= 2.0D) {
        break label308;
      }
      this.locAngle = ((int)f1);
      this.locTime = System.currentTimeMillis();
    }
    for (localMapStatus.rotation = this.locAngle;; localMapStatus.rotation = i)
    {
      if (this.mMapView.getController() != null) {
        this.mMapView.animateTo(localMapStatus, paramInt);
      }
      localLocData.direction = localMapStatus.rotation;
      updateLocOverlay(localLocData, this.mMapViewConfig.getPositionStatus());
      return;
      f1 = 0.0F;
      break;
      label308:
      if (System.currentTimeMillis() - this.locTime <= 30000.0D) {
        i = this.locAngle;
      }
    }
    label340:
    if (f2 > 2.0D) {}
    for (float f1 = (int)f1;; f1 = i)
    {
      localLocData.direction = f1;
      break;
    }
  }
  
  public void updateView()
  {
    updateScale();
    onUpdateStyle(StyleManager.getDayStyle());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/routedetails/BNMapControlPanelSimple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */