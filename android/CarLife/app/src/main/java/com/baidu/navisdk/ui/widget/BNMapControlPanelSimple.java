package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SensorAlgoFilter;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;

public class BNMapControlPanelSimple
  implements View.OnClickListener
{
  private static final int AUTO_HIDE_MAP_NETWORK = 1;
  private boolean isVisible = true;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (1 == paramAnonymousInt1) {
        switch (paramAnonymousInt2)
        {
        }
      }
      do
      {
        return;
      } while ((BNMapControlPanelSimple.this.mContext == null) || (!NetworkUtils.isNetworkAvailable(BNMapControlPanelSimple.this.mContext)));
      BNMapControlPanelSimple.this.mMapNetStatusIcon.setVisibility(8);
      BNMapControlPanelSimple.this.mMapNetworkHandler.removeMessages(1);
      BNMapControlPanelSimple.this.mMapNetworkHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  };
  private Context mContext;
  private DistrictInfo mDistrict;
  private Handler mHandler = new Handler();
  private View mITSButtonView;
  private ImageView mITSImageView;
  private BNMapControlPanel.IItsClickListener mItsClickListener;
  private View mLeftLayout;
  private ProgressBar mLocProgressBar;
  private RelativeLayout mLocationBtn;
  private BNMapControlPanel.ILocationBtnClickListener mLocationBtnClickListener;
  private ImageView mLocationImg;
  private ImageView mMapNetStatusIcon;
  private MapNetworkHandler mMapNetworkHandler = new MapNetworkHandler(this, null);
  private View mRightLayout;
  private View mRootView;
  private BNScaleLevelView mScaleLevelView;
  private SensorAlgoFilter mSensorFilter = new SensorAlgoFilter();
  private BNZoomButtonViewSimple mZoomButtonView;
  private LinearLayout mZoomPanel;
  private boolean noNightStyle = false;
  
  public BNMapControlPanelSimple(Context paramContext, View paramView, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mRootView = paramView.findViewById(1711865955);
    if (this.mRootView == null) {
      return;
    }
    this.mScaleLevelView = new BNScaleLevelView();
    this.mScaleLevelView.initView(this.mContext, this.mRootView);
    this.mLocationBtn = ((RelativeLayout)this.mRootView.findViewById(1711866147));
    this.mLocationBtn.setOnClickListener(this);
    this.mLocationImg = ((ImageView)this.mRootView.findViewById(1711866148));
    this.mLocProgressBar = ((ProgressBar)this.mRootView.findViewById(1711866149));
    this.mZoomButtonView = new BNZoomButtonViewSimple();
    this.mZoomButtonView.initView(this.mContext, this.mRootView, paramBoolean);
    this.mITSButtonView = this.mRootView.findViewById(1711866166);
    this.mITSButtonView.setOnClickListener(this);
    this.mITSImageView = ((ImageView)this.mRootView.findViewById(1711865961));
    this.mMapNetStatusIcon = ((ImageView)this.mRootView.findViewById(1711866158));
    this.mMapNetStatusIcon.setVisibility(8);
    updateCompassLocation(this.mContext);
    this.mLeftLayout = this.mRootView.findViewById(1711866146);
    this.mRightLayout = this.mRootView.findViewById(1711866157);
    this.mZoomPanel = ((LinearLayout)this.mRootView.findViewById(1711866169));
  }
  
  private void changeLocationMode(int paramInt)
  {
    MainMapModel.getInstance().mFirstAutoLocMode = paramInt;
    if (paramInt == MainMapModel.getInstance().getCurLocMode()) {}
    Object localObject;
    final MapStatus localMapStatus;
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              return;
              if (!BNLocationManagerProxy.getInstance().isLocationValid()) {
                break label328;
              }
              i = MainMapModel.getInstance().getCurLocMode();
              paramInt = MainMapModel.getInstance().setLocMode(paramInt);
              updateLocationBtn();
              localObject = BNLocationManagerProxy.getInstance().getCurLocation();
              if (paramInt != 1) {
                break;
              }
              localMapStatus = BNMapController.getInstance().getMapStatus();
            } while (localMapStatus == null);
            localObject = CoordinateTransformUtil.LL2MC(((LocData)localObject).longitude, ((LocData)localObject).latitude);
          } while (localObject == null);
          localMapStatus._CenterPtX = ((Bundle)localObject).getInt("MCx");
          localMapStatus._CenterPtY = ((Bundle)localObject).getInt("MCy");
          if (localMapStatus._Level < 14.0F) {
            localMapStatus._Level = 14.0F;
          }
          if (i == 2)
          {
            localMapStatus._Overlooking = 0;
            localMapStatus._Rotation = 0;
          }
          localMapStatus._Level = -1.0F;
          BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask(getClass().getSimpleName(), null)new BNWorkerConfig
          {
            protected String execute()
            {
              BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationAll);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        } while (this.mLocProgressBar.getVisibility() != 0);
        this.mLocProgressBar.setVisibility(8);
        return;
      } while (paramInt != 2);
      localMapStatus = BNMapController.getInstance().getMapStatus();
    } while (localMapStatus == null);
    Bundle localBundle = CoordinateTransformUtil.LL2MC(((LocData)localObject).longitude, ((LocData)localObject).latitude);
    localMapStatus._CenterPtX = localBundle.getInt("MCx");
    localMapStatus._CenterPtY = localBundle.getInt("MCy");
    localMapStatus._Overlooking = -45;
    if (((LocData)localObject).speed > 10.0F) {}
    for (localMapStatus._Rotation = ((int)((LocData)localObject).direction);; localMapStatus._Rotation = ((int)MainMapModel.getInstance().mAngleX))
    {
      localMapStatus._Level = -1.0F;
      BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationAll);
      return;
    }
    label328:
    MainMapModel.getInstance().setLocMode(0);
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711670037));
    this.mLocationImg.setImageDrawable(null);
    this.mLocProgressBar.setVisibility(0);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask(getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        BNMapControlPanelSimple.this.updateLocationTip();
        return null;
      }
    }, new BNWorkerConfig(100, 0), 15000L);
  }
  
  private void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.mMapNetStatusIcon.setVisibility(8);
  }
  
  private void initItsLayout()
  {
    GeoPoint localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
    if ((localGeoPoint != null) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))) {
      this.mDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(localGeoPoint, 0);
    }
    if (BNSettingManager.isRoadCondOnOrOff())
    {
      if (PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_REAL_HISTORY_ITS", true))
      {
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
          break label140;
        }
        BNMapController.getInstance().switchITSMode(true);
        BNMapController.getInstance().showTrafficMap(true);
        BNSettingManager.setRoadCondOnOff(true);
        if ((this.mDistrict != null) && (!BNMapController.getInstance().checkRoadConditionSupport(this.mDistrict.mId))) {
          TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669394));
        }
      }
      return;
      label140:
      BNSettingManager.setRoadCondOnOff(false);
      return;
    }
    BNMapController.getInstance().showTrafficMap(false);
    BNSettingManager.setRoadCondOnOff(false);
  }
  
  private void updateItsBtn()
  {
    if (BNSettingManager.isRoadCondOnOrOff())
    {
      if (RouteGuideParams.getRouteGuideMode() == 2)
      {
        this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(1711407931));
        return;
      }
      this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(1711408012));
      return;
    }
    if (RouteGuideParams.getRouteGuideMode() == 2)
    {
      this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(1711407930));
      return;
    }
    this.mITSImageView.setImageDrawable(BNStyleManager.getDrawable(1711408011));
  }
  
  private void updateLocOverlay(LocData paramLocData, boolean paramBoolean)
  {
    LocationCallback.setData(paramLocData.toLocationOverlayJsonString(true));
    if (paramBoolean) {
      BNMapController.getInstance().updateLayer(14);
    }
  }
  
  private void updateLocationTip()
  {
    this.mLocProgressBar.setVisibility(8);
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711670036));
    MainMapModel.getInstance().setLocMode(0);
  }
  
  private void updateScale()
  {
    int m = BNMapController.getInstance().getScreenWidth();
    int j = BNMapController.getInstance().getZoomLevel();
    double d = BNMapController.getInstance().getZoomUnitsInMeter();
    int i = MapController.getScaleDis(j);
    LogUtil.e("Map", "room updateScale dis=" + i + " level=" + j + " u=" + d);
    for (int k = (int)Math.ceil(i / d); (k > m / 2) && (j >= 3) && (j <= 20); k = (int)Math.ceil(i / d))
    {
      j += 1;
      i = MapController.getScaleDis(j);
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
    if (this.mZoomButtonView == null) {
      return;
    }
    this.mZoomButtonView.setNoNightStyle(this.noNightStyle);
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
  
  public View getView()
  {
    return this.mRootView;
  }
  
  public BNZoomButtonViewSimple getZoomButtonView()
  {
    return this.mZoomButtonView;
  }
  
  public void handleLocationBtnClick()
  {
    if (this.mLocationBtnClickListener != null)
    {
      int i = MainMapModel.getInstance().getCurLocMode();
      this.mLocationBtnClickListener.onClick(i);
    }
    if (RouteGuideParams.getRouteGuideMode() != 2)
    {
      changeLocationMode(-1);
      updateFullViewState(false);
    }
  }
  
  public void handleScrollGesture()
  {
    resetLocMode();
    updateFullViewState(false);
  }
  
  public void handleSingleTouchGesture()
  {
    resetLocMode();
    updateFullViewState(false);
  }
  
  public void hide()
  {
    this.mScaleLevelView.hide();
    this.mLocationBtn.setVisibility(4);
    this.mZoomButtonView.hide();
    this.mITSButtonView.setVisibility(4);
    this.mMapNetStatusIcon.setVisibility(8);
  }
  
  public boolean isFullView()
  {
    return this.mZoomButtonView.isFullView();
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
    if (i == 1711866147) {
      handleLocationBtnClick();
    }
    while (i != 1711866166) {
      return;
    }
    notifyItsClicked();
  }
  
  public void onPause()
  {
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
  }
  
  public void onResume()
  {
    initItsLayout();
    updateItsBtn();
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    LogUtil.e("StyleDebug", "MapControlPanel dayStyle = " + paramBoolean);
    if ((this.mZoomButtonView == null) || (this.mLocationBtn == null) || (this.mITSButtonView == null) || (this.mMapNetStatusIcon == null)) {
      return;
    }
    this.mZoomButtonView.onUpdateStyle(paramBoolean);
    if (RouteGuideParams.getRouteGuideMode() != 2)
    {
      this.mZoomPanel.setBackgroundDrawable(BNStyleManager.getDrawable(1711407125));
      this.mITSButtonView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407125));
      this.mLocationBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407125));
    }
    updateItsBtn();
    this.mMapNetStatusIcon.setImageDrawable(BNStyleManager.getDrawable(1711407383));
    this.mScaleLevelView.onUpdateStyle(paramBoolean);
  }
  
  public void resetLocMode()
  {
    if ((this.mLocProgressBar != null) && (this.mLocProgressBar.getVisibility() != 0)) {
      MainMapModel.getInstance().setLocMode(0);
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
        break label165;
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
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("setVisible-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          BNMapControlPanelSimple.this.mLeftLayout.setVisibility(8);
          return null;
        }
      }, new BNWorkerConfig(2, 0), 200L);
      break label63;
      label165:
      i = 8;
    }
  }
  
  public void setZoomBtnClickListener(BNZoomButtonViewSimple.OnZoomBtnClickListener paramOnZoomBtnClickListener)
  {
    this.mZoomButtonView.setZoomBtnClickListener(paramOnZoomBtnClickListener);
  }
  
  public void setZoomBtnMode(boolean paramBoolean)
  {
    this.mZoomButtonView.setTwoBtnMode(paramBoolean);
  }
  
  public void show()
  {
    this.mScaleLevelView.show();
    this.mLocationBtn.setVisibility(0);
    this.mZoomButtonView.show();
    this.mITSButtonView.setVisibility(0);
  }
  
  public void updateCompassLocation(Context paramContext) {}
  
  public void updateFullViewState(boolean paramBoolean)
  {
    LogUtil.e("jzc", "onZoomFullViewBtnClick FullView=" + paramBoolean);
    this.mZoomButtonView.updateFullViewState(paramBoolean);
  }
  
  public void updateLocationBtn()
  {
    switch (MainMapModel.getInstance().getCurLocMode())
    {
    default: 
      return;
    case 0: 
      if (this.noNightStyle)
      {
        this.mLocationImg.setImageDrawable(JarUtils.getResources().getDrawable(1711407684));
        return;
      }
      this.mLocationImg.setImageDrawable(BNStyleManager.getDrawable(1711407684));
      return;
    case 1: 
      if (this.noNightStyle)
      {
        this.mLocationImg.setImageDrawable(JarUtils.getResources().getDrawable(1711407381));
        return;
      }
      this.mLocationImg.setImageDrawable(BNStyleManager.getDrawable(1711407381));
      return;
    }
    if (this.noNightStyle)
    {
      this.mLocationImg.setImageDrawable(JarUtils.getResources().getDrawable(1711407385));
      return;
    }
    this.mLocationImg.setImageDrawable(BNStyleManager.getDrawable(1711407385));
  }
  
  public void updateView()
  {
    updateScale();
    updateZoomButton();
    BNMapController.getInstance().updateLayer(10);
    BNMapController.getInstance().UpdataBaseLayers();
  }
  
  private static class MapNetworkHandler
    extends Handler
  {
    private BNMapControlPanelSimple mPanel;
    
    private MapNetworkHandler(BNMapControlPanelSimple paramBNMapControlPanelSimple)
    {
      this.mPanel = paramBNMapControlPanelSimple;
    }
    
    public void handleMessage(Message paramMessage)
    {
      this.mPanel.handleMessage(paramMessage);
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNMapControlPanelSimple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */