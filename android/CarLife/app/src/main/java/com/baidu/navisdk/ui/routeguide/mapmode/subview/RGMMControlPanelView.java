package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainForNav;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMControlPanelView
  extends BNBaseView
{
  private ImageView mAnologControlIcon = null;
  private View mAnologControlRl = null;
  private View mAnologQuit = null;
  private View mBridgeRoadView = null;
  private Runnable mCancelSwitch = new Runnable()
  {
    public void run()
    {
      if (BNLightNaviSwitchManager.getInstance().isSwitching())
      {
        RGMapModeViewController.getInstance().dismissSwitchProgressDialog();
        BNLightNaviSwitchManager.getInstance().cancleRoutePlan();
        BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
      }
    }
  };
  private View mControlPanelView = null;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private View mMainRoadView = null;
  private ImageView mMapControllIv = null;
  private View mMapControllView = null;
  private ImageView mMenuRedGuide = null;
  private ImageView mNavingSafeViewIv = null;
  private ImageView mRefreshRoadIv = null;
  private View mRefreshRoadLinear = null;
  private TextView mRefreshRoadTv = null;
  private View mRefreshRoadView = null;
  private View mRouteSearch = null;
  private ImageView mRouteSearchIv = null;
  private View mZoomDivider = null;
  private View mZoomLl = null;
  private ImageView mZoominIv = null;
  private ImageView mZoominOut = null;
  
  public RGMMControlPanelView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  private boolean getIsTrueCurDay(boolean paramBoolean)
  {
    if (this.mRefreshRoadTv != null)
    {
      int i = this.mRefreshRoadTv.getCurrentTextColor();
      if (JarUtils.getResources() != null) {
        if (i != JarUtils.getResources().getColor(1711800686)) {
          break label50;
        }
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      this.mIsCurDay = bool;
      if (paramBoolean != this.mIsCurDay) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    this.mControlPanelView = ((ViewStub)this.mRootViewGroup.findViewById(1711866529)).inflate();
    this.mMainRoadView = this.mControlPanelView.findViewById(1711866573);
    this.mBridgeRoadView = this.mControlPanelView.findViewById(1711866577);
    this.mRefreshRoadView = this.mControlPanelView.findViewById(1711866581);
    this.mRefreshRoadLinear = this.mControlPanelView.findViewById(1711866582);
    this.mRefreshRoadIv = ((ImageView)this.mControlPanelView.findViewById(1711866583));
    this.mRefreshRoadTv = ((TextView)this.mControlPanelView.findViewById(1711866584));
    this.mNavingSafeViewIv = ((ImageView)this.mRootViewGroup.findViewById(1711866444));
    this.mMapControllView = this.mRootViewGroup.findViewById(1711866585);
    this.mMapControllIv = ((ImageView)this.mRootViewGroup.findViewById(1711866586));
    if (this.mNavingSafeViewIv != null)
    {
      if ((!CloudlConfigDataModel.getInstance().mCommonConfig.safetyNavingShow) || (BNavConfig.pRGLocateMode == 2)) {
        break label604;
      }
      this.mNavingSafeViewIv.setVisibility(0);
      UrlDrawableContainForNav.getSrcDrawable(CloudlConfigDataModel.getInstance().mCommonConfig.safetyNavingIcon, 1711407521, this.mNavingSafeViewIv, null);
    }
    for (;;)
    {
      this.mNavingSafeViewIv.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((paramAnonymousMotionEvent.getAction() != 0) || (ForbidDaulClickUtils.isFastDoubleClick())) {}
          while (RightHandResourcesProvider.isInternationalWithToast(RGMMControlPanelView.this.mContext)) {
            return false;
          }
          UserOPController.getInstance().add("3.y.1", "1", null, null);
          BusinessActivityManager.getInstance().safetyUpload(0, true);
          return false;
        }
      });
      this.mNavingSafeViewIv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      this.mZoominIv = ((ImageView)this.mControlPanelView.findViewById(1711866592));
      this.mZoominOut = ((ImageView)this.mControlPanelView.findViewById(1711866594));
      this.mZoomLl = this.mControlPanelView.findViewById(1711866591);
      this.mZoomDivider = this.mControlPanelView.findViewById(1711866593);
      this.mAnologControlRl = this.mControlPanelView.findViewById(1711866595);
      this.mAnologControlIcon = ((ImageView)this.mControlPanelView.findViewById(1711866596));
      this.mAnologQuit = this.mControlPanelView.findViewById(1711866590);
      this.mRouteSearch = this.mRootViewGroup.findViewById(1711866568);
      this.mRouteSearchIv = ((ImageView)this.mRootViewGroup.findViewById(1711866569));
      this.mAnologQuit.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((paramAnonymousMotionEvent.getAction() == 0) && (RGMMControlPanelView.this.mSubViewListener != null)) {
            RGMMControlPanelView.this.mSubViewListener.onShowQuitNaviView();
          }
          return false;
        }
      });
      this.mAnologQuit.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      this.mRefreshRoadView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (RGMMControlPanelView.this.mSubViewListener != null) {
            RGMMControlPanelView.this.mSubViewListener.onRefreshRoadAction();
          }
        }
      });
      this.mZoominIv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (RGMMControlPanelView.this.mSubViewListener != null) {
            RGMMControlPanelView.this.mSubViewListener.onZoominAction();
          }
        }
      });
      this.mZoominIv.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousBoolean) && (RGMMControlPanelView.this.mSubViewListener != null)) {
            RGMMControlPanelView.this.mSubViewListener.onZoomInGetFocus();
          }
        }
      });
      this.mZoominOut.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (RGMMControlPanelView.this.mSubViewListener != null) {
            RGMMControlPanelView.this.mSubViewListener.onZoomoutAction();
          }
        }
      });
      this.mZoominOut.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousBoolean) && (RGMMControlPanelView.this.mSubViewListener != null)) {
            RGMMControlPanelView.this.mSubViewListener.onZoomOutGetFocus();
          }
        }
      });
      if (this.mAnologControlIcon != null) {
        this.mAnologControlIcon.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            if ((paramAnonymousMotionEvent.getAction() == 0) && (RGMMControlPanelView.this.mSubViewListener != null)) {
              RGMMControlPanelView.this.mSubViewListener.onAnologControlAction(RGControlPanelModel.getInstance().isAnologPlaying());
            }
            return false;
          }
        });
      }
      this.mAnologControlIcon.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      if (this.mRouteSearch != null)
      {
        this.mRouteSearch.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (RGMMControlPanelView.this.mSubViewListener != null) {
              RGMMControlPanelView.this.mSubViewListener.onOtherAction(14, 1, 1, null);
            }
          }
        });
        this.mRouteSearch.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if ((paramAnonymousBoolean) && (RGMMControlPanelView.this.mSubViewListener != null)) {
              RGMMControlPanelView.this.mSubViewListener.onViaPointGetFocus();
            }
          }
        });
      }
      if (this.mMapControllView != null)
      {
        this.mMapControllView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            RouteGuideFSM.getInstance().run("触碰地图");
            if (RGMMControlPanelView.this.mSubViewListener != null) {
              RGMMControlPanelView.this.mSubViewListener.onFocusMoreMenu();
            }
          }
        });
        this.mMapControllView.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if ((paramAnonymousBoolean) && (RGMMControlPanelView.this.mSubViewListener != null)) {
              RGMMControlPanelView.this.mSubViewListener.onFocusMoreMenuGetFocus();
            }
          }
        });
      }
      updateDataByLastest();
      showManualOperateArea(false);
      return;
      label604:
      this.mNavingSafeViewIv.setVisibility(8);
    }
  }
  
  private void setVoiceSpeakSetting(int paramInt1, int paramInt2)
  {
    if (this.mSubViewListener != null) {
      this.mSubViewListener.onOtherAction(6, paramInt1, paramInt2, null);
    }
  }
  
  private void zoomInEnabled(boolean paramBoolean)
  {
    if (this.mZoominIv != null)
    {
      if (paramBoolean) {
        this.mZoominIv.setImageDrawable(JarUtils.getResources().getDrawable(1711407303));
      }
    }
    else {
      return;
    }
    this.mZoominIv.setImageDrawable(JarUtils.getResources().getDrawable(1711407304));
  }
  
  private void zoomOutEnabled(boolean paramBoolean)
  {
    if (this.mZoominOut != null)
    {
      if (paramBoolean) {
        this.mZoominOut.setImageDrawable(JarUtils.getResources().getDrawable(1711407307));
      }
    }
    else {
      return;
    }
    this.mZoominOut.setImageDrawable(JarUtils.getResources().getDrawable(1711407308));
  }
  
  public void disMissSDKUI() {}
  
  public void dispose()
  {
    if (this.mNavingSafeViewIv != null) {
      UIUtils.releaseImageView(this.mNavingSafeViewIv);
    }
    UrlDrawableContainForNav.recycleBitmap();
    super.dispose();
  }
  
  public void hide()
  {
    super.hide();
    showAnologNavi(false);
    showManualOperateArea(false);
  }
  
  public void moveUpBottomButton(boolean paramBoolean)
  {
    if (this.mControlPanelView != null) {
      if (BNavConfig.pRGLocateMode != 2) {
        break label86;
      }
    }
    label86:
    for (int i = ScreenUtil.getInstance().dip2px(8);; i = JarUtils.getResources().getDimensionPixelOffset(1711734809))
    {
      ViewGroup.LayoutParams localLayoutParams = this.mControlPanelView.getLayoutParams();
      if ((localLayoutParams != null) && ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)))
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
        int j = i;
        if (paramBoolean) {
          j = i + JarUtils.getResources().getDimensionPixelOffset(1711734808);
        }
        localMarginLayoutParams.bottomMargin = j;
      }
      this.mControlPanelView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    this.mIsCurDay = true;
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  public void refreshRedGuide()
  {
    if ((!BNSettingManager.getFirstVoiceGuide()) || (!BNSettingManager.getFirstMoreMenuGuide()))
    {
      this.mMenuRedGuide.setVisibility(0);
      return;
    }
    BNSettingManager.setFristMenuGuide(true);
    this.mMenuRedGuide.setVisibility(8);
  }
  
  public void removeCancelSwitch()
  {
    this.mHandler.removeCallbacks(this.mCancelSwitch);
  }
  
  public void setRefreshButtonEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mRefreshRoadIv.setAlpha(1.0F);
      this.mRefreshRoadTv.setAlpha(1.0F);
      this.mRefreshRoadView.setEnabled(true);
      return;
    }
    this.mRefreshRoadIv.setAlpha(0.5F);
    this.mRefreshRoadTv.setAlpha(0.5F);
    this.mRefreshRoadView.setEnabled(false);
  }
  
  public void setTrafficStatus(boolean paramBoolean) {}
  
  public void show()
  {
    super.show();
    if (BNavConfig.pRGLocateMode == 2) {
      showAnologNavi(true);
    }
  }
  
  public void showAnologNavi(boolean paramBoolean)
  {
    int j = 0;
    Object localObject;
    if (this.mAnologControlRl != null)
    {
      localObject = this.mAnologControlRl;
      if (paramBoolean)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    else if (this.mAnologQuit != null)
    {
      localObject = this.mAnologQuit;
      if (!paramBoolean) {
        break label117;
      }
    }
    label117:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((paramBoolean) && (this.mControlPanelView != null))
      {
        localObject = this.mControlPanelView.getLayoutParams();
        if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams))) {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ScreenUtil.getInstance().dip2px(8);
        }
        this.mControlPanelView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      i = 8;
      break;
    }
  }
  
  public void showManualOperateArea(boolean paramBoolean)
  {
    int j = 0;
    RGControlPanelModel localRGControlPanelModel = RGControlPanelModel.getInstance();
    Object localObject;
    if (paramBoolean)
    {
      localObject = "NAV_STATE_OPERATE";
      localRGControlPanelModel.setNavState((String)localObject);
      if (!paramBoolean) {
        break label293;
      }
      i = 0;
      label29:
      if (BNavConfig.pRGLocateMode == 2) {
        i = 8;
      }
      if (this.mRefreshRoadView != null)
      {
        LogUtil.e("Map", "mRefreshRoadView. BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() = " + BNRoutePlaner.getInstance().getEngineCalcRouteNetMode());
        if ((i != 0) || (!NetworkUtils.isNetworkAvailable(this.mContext)) || (!RGMultiRouteModel.getInstance().isEnable()) || (!BNRouteGuider.getInstance().isCurDriveRouteOnline()) || (JNIGuidanceControl.getInstance().getViaCnt() != 0)) {
          break label299;
        }
        this.mRefreshRoadView.setVisibility(0);
      }
      label126:
      if (this.mRouteSearch != null)
      {
        if ((NetworkUtils.isNetworkAvailable(this.mContext)) && (!RGRouteSearchModel.getInstance().isRouteSearchMode())) {
          break label311;
        }
        this.mRouteSearch.setVisibility(8);
      }
      label161:
      if (this.mZoominIv != null) {
        this.mZoominIv.setVisibility(i);
      }
      if (this.mZoominOut != null) {
        this.mZoominOut.setVisibility(i);
      }
      if (this.mZoomLl != null) {
        this.mZoomLl.setVisibility(i);
      }
      if (this.mNavingSafeViewIv != null)
      {
        if ((!CloudlConfigDataModel.getInstance().mCommonConfig.safetyNavingShow) || (BNavConfig.pRGLocateMode == 2) || (paramBoolean) || (RGViewController.getInstance().isShowEnlargeRoadMap())) {
          break label322;
        }
        this.mNavingSafeViewIv.setVisibility(0);
      }
      label253:
      if (this.mMapControllView != null)
      {
        localObject = this.mMapControllView;
        if ((paramBoolean) || (!BNaviModuleManager.isFocusUIenable())) {
          break label334;
        }
      }
    }
    label293:
    label299:
    label311:
    label322:
    label334:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      localObject = "NAV_STATE_NAVING";
      break;
      i = 8;
      break label29;
      this.mRefreshRoadView.setVisibility(8);
      break label126;
      this.mRouteSearch.setVisibility(i);
      break label161;
      this.mNavingSafeViewIv.setVisibility(8);
      break label253;
    }
  }
  
  public void switchAnologNaviControlState(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mAnologControlIcon != null) {
        this.mAnologControlIcon.setImageDrawable(BNStyleManager.getRealDrawable(1711407426));
      }
    }
    while (this.mAnologControlIcon == null) {
      return;
    }
    this.mAnologControlIcon.setImageDrawable(BNStyleManager.getRealDrawable(1711407424));
  }
  
  public void updateDataByLastest()
  {
    if (!BNavigator.getInstance().hasCalcRouteOk()) {
      RGControlPanelModel.getInstance().updateLocateStatus(4);
    }
    if (!RGControlPanelModel.getInstance().isAnologPlaying()) {}
    for (boolean bool = true;; bool = false)
    {
      switchAnologNaviControlState(bool);
      setTrafficStatus(BNSettingManager.isRoadCondOnOrOff());
      return;
    }
  }
  
  public void updateNaviStatus()
  {
    if (BNSettingManager.isRoadCondOnOrOff())
    {
      UserOPController.getInstance().add("3.5.2", "", null, null);
      if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
        this.mSubViewListener.onITSAction(true);
      }
      setTrafficStatus(BNSettingManager.isRoadCondOnOrOff());
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    if (getIsTrueCurDay(paramBoolean)) {}
    do
    {
      return;
      super.updateStyle(paramBoolean);
    } while ((this.mZoominIv == null) || (this.mZoominOut == null) || (this.mRefreshRoadView == null) || (this.mAnologControlRl == null) || (this.mBridgeRoadView == null) || (this.mMainRoadView == null) || (this.mAnologControlIcon == null) || (this.mAnologQuit == null) || (this.mZoomLl == null) || (this.mZoomDivider == null) || (this.mRouteSearch == null) || (this.mRouteSearchIv == null));
    View localView;
    if (!RGControlPanelModel.getInstance().isAnologPlaying())
    {
      if (this.mAnologControlIcon != null) {
        this.mAnologControlIcon.setImageDrawable(getDrawable(1711407426));
      }
      this.mAnologControlRl.setBackgroundDrawable(getDrawable(1711407125));
      this.mAnologQuit.setBackgroundDrawable(getDrawable(1711407125));
      this.mRefreshRoadLinear.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407295));
      this.mMapControllIv.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407293));
      this.mZoominIv.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407202));
      this.mZoominOut.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407204));
      this.mZoomLl.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407289));
      localView = this.mZoomDivider;
      if (!BNStyleManager.getDayStyle()) {
        break label313;
      }
    }
    label313:
    for (int i = 14277081;; i = -13814976)
    {
      localView.setBackgroundColor(i);
      this.mRouteSearchIv.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407293));
      this.mRefreshRoadIv.setImageDrawable(getDrawable(1711407512));
      setTrafficStatus(BNSettingManager.isRoadCondOnOrOff());
      this.mRefreshRoadTv.setTextColor(getColor(1711800686));
      return;
      if (this.mAnologControlIcon == null) {
        break;
      }
      this.mAnologControlIcon.setImageDrawable(getDrawable(1711407424));
      break;
    }
  }
  
  public void updateZoomViewState()
  {
    int i = NMapControlProxy.getInstance().getZoomLevel();
    LogUtil.e("Map", "updateZoomButton. level = " + i);
    if (i <= 3)
    {
      zoomInEnabled(true);
      zoomOutEnabled(false);
      return;
    }
    if (i >= 20)
    {
      zoomInEnabled(false);
      zoomOutEnabled(true);
      return;
    }
    zoomInEnabled(true);
    zoomOutEnabled(true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMControlPanelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */