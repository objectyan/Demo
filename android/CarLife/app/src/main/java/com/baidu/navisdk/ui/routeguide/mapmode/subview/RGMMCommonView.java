package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMCommonView
  extends BNBaseView
{
  private static final int DEFAULT_SOURCE = -1;
  public static final int EXPEND_VIEW_COUNT = 12;
  public static final int EXPEND_VIEW_TYPE_FOLLOW = 7;
  public static final int EXPEND_VIEW_TYPE_OFFLINE_TO_ONLINE = 10;
  public static final int EXPEND_VIEW_TYPE_OFF_SCREEN = 1;
  public static final int EXPEND_VIEW_TYPE_PARK = 2;
  public static final int EXPEND_VIEW_TYPE_ROAD_CONDITON_FAIL = 3;
  public static final int EXPEND_VIEW_TYPE_RP_PREFER = 6;
  public static final int EXPEND_VIEW_TYPE_SATELLITE = 9;
  public static final int EXPEND_VIEW_TYPE_UGC_OFFICIAL_EVENT = 8;
  private static final int FSM_SOURCE = 4;
  public static final int INTERVENE_TYPE_MSG = 100;
  public static final int INTERVENE_VIEW_COUNT = 3;
  private static final int MESSAGE_SOURCE = 0;
  public static final int NO_INTERVENE_TYPE_MSG = 101;
  private static final String TAG = RGMMCommonView.class.getSimpleName();
  private boolean isFellowShow = false;
  private View mCommonView = null;
  private int[] mCurrentSourceFlags = new int[12];
  private int mDefaultSource = -1;
  private boolean[] mExpendViewShowFlags = new boolean[12];
  private View mFollowLaneContainer = null;
  private View mFollowView = null;
  
  public RGMMCommonView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initView();
  }
  
  private void handleEnlargeCanShowView(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    LogUtil.e(RGLaneInfoModel.TAG, "handleEnlargeCanShowView " + paramInt1 + "," + paramBoolean + "," + paramInt2);
    if (paramInt1 != 7) {}
    do
    {
      return;
      if (paramInt2 == 2)
      {
        LogUtil.e(RGLaneInfoModel.TAG, "handleEnlargeCanShowView visible " + this.mFollowLaneContainer.getVisibility());
        RGMapModeViewController.getInstance().handleLaneLineViewShow(paramBoolean);
        return;
      }
    } while ((paramInt2 != 1) || (this.mFollowView == null));
    if (paramBoolean)
    {
      this.mFollowView.setVisibility(0);
      return;
    }
    this.mFollowView.setVisibility(8);
  }
  
  private void handleFollowLaneContinaerShow()
  {
    int i = this.mFollowView.getVisibility();
    int j = RGMapModeViewController.getInstance().getFellowLineVisibility();
    if ((i == 8) && (j == 8))
    {
      handleFollowLaneShow(false);
      return;
    }
    handleFollowLaneShow(true);
  }
  
  private void handleFollowLaneShow(boolean paramBoolean)
  {
    View localView;
    if (!paramBoolean)
    {
      LogUtil.e(RGLaneInfoModel.TAG, "handleFollowLaneShow flase gone");
      if (this.mFollowLaneContainer != null)
      {
        localView = this.mFollowLaneContainer;
        if (!paramBoolean) {
          break label47;
        }
      }
    }
    label47:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
      LogUtil.e(RGLaneInfoModel.TAG, "handleFollowLaneShow true show");
      break;
    }
  }
  
  private boolean hasActualShow(int paramInt)
  {
    boolean bool2 = true;
    switch (paramInt)
    {
    }
    do
    {
      boolean bool1 = false;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    bool1 = bool2;
                  } while (this.mExpendViewShowFlags[0] != 0);
                  bool1 = bool2;
                } while (this.mExpendViewShowFlags[1] != 0);
                bool1 = bool2;
              } while (this.mExpendViewShowFlags[2] != 0);
              if (this.mExpendViewShowFlags[3] == 0) {
                break;
              }
              return true;
              bool1 = bool2;
            } while (this.mExpendViewShowFlags[7] != 0);
            bool1 = bool2;
          } while (this.mExpendViewShowFlags[10] != 0);
          bool1 = bool2;
        } while (this.mExpendViewShowFlags[6] != 0);
        bool1 = bool2;
      } while (this.mExpendViewShowFlags[9] != 0);
    } while (this.mExpendViewShowFlags[8] == 0);
    return true;
  }
  
  private void initView()
  {
    if (this.mRootViewGroup != null)
    {
      this.mCommonView = this.mRootViewGroup.findViewById(1711866621);
      this.mFollowView = this.mRootViewGroup.findViewById(1711866432);
      this.mFollowLaneContainer = this.mRootViewGroup.findViewById(1711866431);
    }
    int i = 0;
    while (i < 12)
    {
      this.mExpendViewShowFlags[i] = false;
      this.mCurrentSourceFlags[i] = -1;
      i += 1;
    }
  }
  
  private void setFollowLaneLayout(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (this.mFollowLaneContainer != null)
    {
      if ((this.mExpendViewShowFlags[6] == 0) && (this.mExpendViewShowFlags[7] != 0)) {
        this.mFollowLaneContainer.setVisibility(0);
      }
      this.mFollowLaneContainer.setLayoutParams(paramMarginLayoutParams);
    }
  }
  
  private void setShowFlags(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 12)) {}
    do
    {
      return;
      switch (paramInt)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
        if ((paramBoolean) && (RGOffScreenModel.getInstance().isCurrentLocationActive) && (RGOffScreenModel.getInstance().canEnterOffScreenShow()))
        {
          this.mExpendViewShowFlags[paramInt] = true;
          return;
        }
        this.mExpendViewShowFlags[paramInt] = false;
        return;
      case 2: 
        if ((paramBoolean) && (BNavigator.getInstance().getCanParkShow()))
        {
          this.mExpendViewShowFlags[paramInt] = true;
          return;
        }
        this.mExpendViewShowFlags[paramInt] = false;
        return;
      }
    } while (this.mFollowView == null);
    if (((paramBoolean) || (this.mExpendViewShowFlags[paramInt] != 0)) && ((RGSimpleGuideModel.getInstance().isShowFollowInfo()) || (RGLaneInfoModel.getModel(false).isShowLaneLineView())))
    {
      this.mExpendViewShowFlags[paramInt] = true;
      return;
    }
    this.mExpendViewShowFlags[paramInt] = false;
    return;
    if ((paramBoolean) && (RGUpdateRCFailModel.getInstance().isRCUpdateFialCanShow()))
    {
      this.mExpendViewShowFlags[paramInt] = true;
      return;
    }
    this.mExpendViewShowFlags[paramInt] = false;
    return;
    if ((paramBoolean) && (RGSimpleGuideModel.mIsOfflineToOnline))
    {
      this.mExpendViewShowFlags[paramInt] = true;
      return;
    }
    this.mExpendViewShowFlags[paramInt] = false;
    return;
    if ((paramBoolean) && (RGSimpleGuideModel.mIsRPPrefer))
    {
      this.mExpendViewShowFlags[paramInt] = true;
      return;
    }
    this.mExpendViewShowFlags[paramInt] = false;
    return;
    if ((paramBoolean) && (RGSimpleGuideModel.mIsSatellite))
    {
      this.mExpendViewShowFlags[paramInt] = true;
      return;
    }
    this.mExpendViewShowFlags[paramInt] = false;
    return;
    if ((paramBoolean) && (RGSimpleGuideModel.mIsUgcOfficialEvent))
    {
      this.mExpendViewShowFlags[paramInt] = true;
      return;
    }
    this.mExpendViewShowFlags[paramInt] = false;
  }
  
  private void showExpendViewInner(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 12)) {}
    do
    {
      return;
      LogUtil.e(TAG, "RGMMCommonView.showExpendViewInner() type=" + paramInt + ", show=" + paramBoolean + ", sOrientation=" + RGCacheStatus.sOrientation);
      switch (paramInt)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
        if (paramBoolean)
        {
          RGViewController.getInstance().showOffScreenView();
          return;
        }
        RGViewController.getInstance().hideOffScreenView();
        return;
      case 2: 
        if (paramBoolean)
        {
          RGViewController.getInstance().showParkView();
          return;
        }
        RGViewController.getInstance().hideParkView();
        return;
      }
    } while ((this.mFollowView == null) || (this.mFollowLaneContainer == null));
    LogUtil.e(RGLaneInfoModel.TAG, "source is " + this.mCurrentSourceFlags[7] + "," + paramBoolean);
    if (paramBoolean)
    {
      if (RGSimpleGuideModel.getInstance().isShowFollowInfo()) {
        this.mFollowView.setVisibility(0);
      }
      for (;;)
      {
        RGMapModeViewController.getInstance().handleLaneLineViewShow(RGLaneInfoModel.getModel(false).isShowLaneLineView());
        handleFollowLaneContinaerShow();
        return;
        this.mFollowView.setVisibility(8);
      }
    }
    LogUtil.e(RGLaneInfoModel.TAG, "false hide source is " + this.mCurrentSourceFlags[7]);
    if (this.mCurrentSourceFlags[7] == 1) {
      this.mFollowView.setVisibility(8);
    }
    for (;;)
    {
      this.mCurrentSourceFlags[7] = -1;
      break;
      if (this.mCurrentSourceFlags[7] == 2)
      {
        RGMapModeViewController.getInstance().handleLaneLineViewShow(false);
      }
      else if ((this.mCurrentSourceFlags[7] == 0) || (this.mCurrentSourceFlags[7] == 4))
      {
        this.mFollowView.setVisibility(8);
        RGMapModeViewController.getInstance().handleLaneLineViewShow(false);
      }
      else
      {
        LogUtil.e(RGLaneInfoModel.TAG, "anther source is " + this.mCurrentSourceFlags[7]);
      }
    }
    if (paramBoolean)
    {
      RGViewController.getInstance().showRoadConditionUpdateFail();
      return;
    }
    RGViewController.getInstance().hideRoadConditonUpdateFail();
    return;
    RGViewController.getInstance().showOfflineToOnlineView(paramBoolean);
    return;
    RGViewController.getInstance().showRPPreferView(paramBoolean);
    return;
    RGViewController.getInstance().showSatelliteView(paramBoolean);
    return;
    RGViewController.getInstance().showUgcOfficialEventView(paramBoolean);
  }
  
  private boolean showInterveneView(boolean paramBoolean)
  {
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (paramBoolean)
    {
      int j = 0;
      i = 0;
      paramBoolean = bool1;
      if (i <= 3)
      {
        if (j != 0) {
          showExpendViewInner(i, false);
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.mExpendViewShowFlags[i] != 0)
          {
            showExpendViewInner(i, true);
            int m = 1;
            if ((i != 2) && (i != 3))
            {
              j = m;
              if (i != 1) {}
            }
            else
            {
              paramBoolean = true;
              j = m;
            }
          }
          else
          {
            showExpendViewInner(i, false);
          }
        }
      }
      bool1 = paramBoolean;
      if (this.mCommonView != null)
      {
        View localView = this.mCommonView;
        if (j == 0) {
          break label130;
        }
        i = k;
        localView.setVisibility(i);
        bool1 = paramBoolean;
      }
    }
    label130:
    do
    {
      return bool1;
      i = 8;
      break;
      bool1 = bool2;
    } while (this.mCommonView == null);
    this.mCommonView.setVisibility(8);
    return false;
  }
  
  private boolean showNoInterveneView(boolean paramBoolean)
  {
    int j = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean)
    {
      i = 6;
      paramBoolean = bool1;
      bool1 = paramBoolean;
      if (i <= 10)
      {
        if (paramBoolean) {
          showExpendViewInner(i, false);
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.mExpendViewShowFlags[i] != 0)
          {
            showExpendViewInner(i, true);
            paramBoolean = true;
          }
          else
          {
            showExpendViewInner(i, false);
          }
        }
      }
    }
    else
    {
      if (this.mFollowView != null) {
        this.mFollowView.setVisibility(8);
      }
      if (this.mFollowLaneContainer != null)
      {
        LogUtil.e(RGLaneInfoModel.TAG, "mFollowLaneContainer dismiss it");
        this.mFollowLaneContainer.setVisibility(8);
      }
      RGViewController.getInstance().handleLaneLineViewShow(false);
      RGViewController.getInstance().showOfflineToOnlineView(false);
      RGViewController.getInstance().showRPPreferView(false);
      RGViewController.getInstance().showSatelliteView(false);
      RGViewController.getInstance().showUgcOfficialEventView(false);
      bool1 = bool2;
    }
    if (bool1) {}
    for (int i = JarUtils.getResources().getDimensionPixelOffset(1711734937);; i = 0)
    {
      if (1 == RGViewController.getInstance().getOrientation()) {
        j = JarUtils.getResources().getDimensionPixelOffset(1711734797);
      }
      i += j;
      LogUtil.e(TAG, "RGCommonView.showCommonView()  carDiff  " + i);
      BNMapController.getInstance().setTranslucentHeight(i);
      return bool1;
    }
  }
  
  private boolean showOrHideView(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 100: 
      return showInterveneView(paramBoolean);
    }
    this.mCurrentSourceFlags[7] = 4;
    return showNoInterveneView(paramBoolean);
  }
  
  public void handleFollowLaneOrientation(int paramInt, boolean paramBoolean)
  {
    LogUtil.e(RGLaneInfoModel.TAG, "handleFollowLaneOrientation " + paramInt + "," + paramBoolean);
    Object localObject;
    if ((paramBoolean) && (RGMapModeViewController.getInstance().isEnlargeOrColladaShow()))
    {
      paramBoolean = true;
      localObject = (ViewGroup)this.mFollowLaneContainer.getParent();
      localObject = (ViewGroup.MarginLayoutParams)this.mFollowLaneContainer.getLayoutParams();
      if (paramInt != 2) {
        break label122;
      }
      if (!paramBoolean) {
        break label109;
      }
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = ScreenUtil.getInstance().getGuidePanelWidth();
      setFollowLaneLayout((ViewGroup.MarginLayoutParams)localObject);
    }
    for (;;)
    {
      RGMapModeViewController.getInstance().hanldleLandScapeLaneShow(paramBoolean);
      return;
      paramBoolean = false;
      break;
      label109:
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
      setFollowLaneLayout((ViewGroup.MarginLayoutParams)localObject);
    }
    label122:
    if (paramBoolean)
    {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (ScreenUtil.getInstance().getHeightPixels() / 2 - ScreenUtil.getInstance().dip2px(108));
      setFollowLaneLayout((ViewGroup.MarginLayoutParams)localObject);
    }
    for (;;)
    {
      RGMapModeViewController.getInstance().handlePortraitLargeLaneViewShow(paramBoolean);
      return;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
      setFollowLaneLayout((ViewGroup.MarginLayoutParams)localObject);
    }
  }
  
  public boolean isCommonViewShow()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mCommonView != null)
    {
      bool1 = bool2;
      if (this.mCommonView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initView();
  }
  
  public boolean requestShowExpendView(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= 12)) {
      paramBoolean = false;
    }
    do
    {
      return paramBoolean;
      this.mCurrentSourceFlags[7] = 0;
      setShowFlags(paramInt, paramBoolean);
      LogUtil.e(TAG, "RGMMCommonView.requestShowExpendView() type=" + paramInt + ", show=" + paramBoolean + ", actShow=" + this.mExpendViewShowFlags[paramInt]);
      int i = 0;
      if (RGViewController.getInstance().isEnlargeOrColladaShow()) {
        i = 1;
      }
      if ((i == 0) && ("NAV_STATE_NAVING".equals(RGControlPanelModel.getInstance().getNavState())) && (!RGViewController.getInstance().isEnlargeOrColladaShow()) && (!showInterveneView(true))) {
        showNoInterveneView(true);
      }
      paramBoolean = bool;
    } while (paramInt == -1);
    return false;
  }
  
  public boolean requestShowExpendView(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt1 < 0) || (paramInt1 >= 12)) {
      paramBoolean = false;
    }
    do
    {
      return paramBoolean;
      this.mCurrentSourceFlags[paramInt1] = paramInt2;
      setShowFlags(paramInt1, paramBoolean);
      LogUtil.e(TAG, "RGMMCommonView.requestShowExpendView() type=" + paramInt1 + ", show=" + paramBoolean + ", actShow=" + this.mExpendViewShowFlags[paramInt1]);
      int i = 0;
      if (RGViewController.getInstance().isEnlargeOrColladaShow())
      {
        handleEnlargeCanShowView(paramInt1, paramBoolean, paramInt2);
        i = 1;
      }
      if ((i == 0) && ("NAV_STATE_NAVING".equals(RGControlPanelModel.getInstance().getNavState())) && (!RGViewController.getInstance().isEnlargeOrColladaShow()) && (!showInterveneView(true))) {
        showNoInterveneView(true);
      }
      paramBoolean = bool;
    } while (paramInt1 == -1);
    return false;
  }
  
  public void showCommonView(boolean paramBoolean)
  {
    LogUtil.e(RGLaneInfoModel.TAG, "showCommonView tag are " + paramBoolean);
    if ((paramBoolean) && (RGViewController.getInstance().isEnlargeOrColladaShow())) {
      return;
    }
    if ((paramBoolean) && (hasActualShow(100)))
    {
      showOrHideView(true, 100);
      showOrHideView(this.isFellowShow, 101);
      return;
    }
    if ((paramBoolean) && (hasActualShow(101)))
    {
      showOrHideView(false, 100);
      showOrHideView(true, 101);
      return;
    }
    showOrHideView(false, 100);
    showOrHideView(false, 101);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMCommonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */