package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel.AssistInfo;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.ui.routeguide.subview.widget.RGRoadConditionView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.map.MapSwitchGLSurfaceView;

public class RGMMAssistGuideView
  extends BNBaseView
{
  public static final String TAG = RGMMAssistGuideView.class.getSimpleName();
  private static final int[] mProgressViewID = { 1711866447, 1711866446, 1711866445 };
  private View mAssistPanel = null;
  private CircleProgressImageView[] mAssistProgressView;
  private TextView mCurCarSpeedView = null;
  private View mCurCarSpeedViewRl = null;
  private TextView mCurCarSpeedViewTv = null;
  private CommonHandlerThread.Callback mDrawCallback;
  private View mFullViewModeBtn = null;
  private ImageView mFullViewModeIv = null;
  private TextView mFullViewModeText = null;
  private MapSwitchGLSurfaceView mMapSwitchSurfaceView;
  private LinearLayout mMapSwitchlayout = null;
  private View mRoadConditionBarLayout = null;
  private RGRoadConditionView mRoadConditionView = null;
  private View ugcBtnLayout = null;
  private ImageView ugcIcon;
  private TextView ugcTv;
  
  public RGMMAssistGuideView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    updateDataByLastest();
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.mRootViewGroup.findViewById(1711866523);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    this.mAssistPanel = this.mRootViewGroup.findViewById(1711866528);
    this.mCurCarSpeedView = ((TextView)this.mRootViewGroup.findViewById(1711866439));
    this.mCurCarSpeedViewRl = this.mRootViewGroup.findViewById(1711866438);
    this.mCurCarSpeedViewTv = ((TextView)this.mRootViewGroup.findViewById(1711866440));
    this.ugcBtnLayout = this.mRootViewGroup.findViewById(1711866441);
    this.ugcIcon = ((ImageView)this.mRootViewGroup.findViewById(1711866442));
    this.ugcTv = ((TextView)this.mRootViewGroup.findViewById(1711866443));
    this.mRoadConditionBarLayout = this.mRootViewGroup.findViewById(1711866616);
    if (this.mRoadConditionView != null)
    {
      this.mRoadConditionView.recycle();
      this.mRoadConditionView = null;
    }
    this.mRoadConditionView = ((RGRoadConditionView)this.mRootViewGroup.findViewById(1711866620));
    this.mFullViewModeIv = ((ImageView)this.mRootViewGroup.findViewById(1711866618));
    this.mFullViewModeText = ((TextView)this.mRootViewGroup.findViewById(1711866619));
    this.mFullViewModeBtn = this.mRootViewGroup.findViewById(1711866617);
    this.mFullViewModeBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RGControlPanelModel.getInstance().getFullviewState()) {
          if (RGMMAssistGuideView.this.mSubViewListener != null) {
            RGMMAssistGuideView.this.mSubViewListener.onOtherAction(3, 0, 0, null);
          }
        }
        while (RGMMAssistGuideView.this.mSubViewListener == null) {
          return;
        }
        RGMMAssistGuideView.this.mSubViewListener.onFullviewAction();
      }
    });
    this.mMapSwitchlayout = ((LinearLayout)this.mRootViewGroup.findViewById(1711866615));
    this.mMapSwitchlayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LogUtil.e(RGMMAssistGuideView.TAG, "mMapSwitchlayout onClick ==");
        UserOPController.getInstance().add("3.3");
        if (RGControlPanelModel.getInstance().getFullviewState()) {
          if (RGMMAssistGuideView.this.mSubViewListener != null) {
            RGMMAssistGuideView.this.mSubViewListener.onOtherAction(3, 0, 0, null);
          }
        }
        while (RGMMAssistGuideView.this.mSubViewListener == null) {
          return;
        }
        RGMMAssistGuideView.this.mSubViewListener.onFullviewAction();
      }
    });
    if (BNavConfig.pRGLocateMode == 2)
    {
      if (this.mMapSwitchlayout != null) {
        this.mMapSwitchlayout.setVisibility(8);
      }
      if (this.mMapSwitchSurfaceView != null) {
        this.mMapSwitchSurfaceView.setVisibility(8);
      }
      if (this.mRoadConditionBarLayout != null) {
        this.mRoadConditionBarLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      this.mAssistProgressView = new CircleProgressImageView[3];
      int i = 0;
      while (i < this.mAssistProgressView.length)
      {
        this.mAssistProgressView[i] = ((CircleProgressImageView)this.mRootViewGroup.findViewById(mProgressViewID[i]));
        this.mAssistProgressView[i].setVisibility(8);
        i += 1;
      }
      showMapSwitchOrRoadBar(true);
    }
    this.ugcBtnLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((paramAnonymousMotionEvent.getAction() != 0) || (ForbidDaulClickUtils.isFastDoubleClick())) {
          return false;
        }
        RouteGuideFSM.getInstance().run("触碰地图");
        UserOPController.getInstance().add("3.u", "5", null, null);
        if (RGMMAssistGuideView.this.mSubViewListener != null) {
          RGMMAssistGuideView.this.mSubViewListener.onUGCMenuAction();
        }
        RGViewController.getInstance().autoHideControlPanelView(10000);
        return false;
      }
    });
    this.ugcBtnLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
  }
  
  private void setAssistView(int paramInt, RGAssistGuideModel.AssistInfo paramAssistInfo)
  {
    if ((paramInt < 0) || (paramInt >= this.mAssistProgressView.length) || (paramAssistInfo == null) || (paramAssistInfo.mIconResId <= 0)) {
      return;
    }
    this.mAssistProgressView[paramInt].setMainProgress(paramAssistInfo.mProgress);
    if ("NAV_STATE_NAVING".equals(RGControlPanelModel.getInstance().getNavState()))
    {
      this.mAssistProgressView[paramInt].setVisibility(0);
      if (paramAssistInfo.mAssistType != 8) {
        break label147;
      }
      this.mAssistProgressView[paramInt].setBeamHeight(0);
      this.mAssistProgressView[paramInt].setText(paramAssistInfo.mSpeedLimit / 1000 + "");
    }
    for (;;)
    {
      this.mAssistProgressView[paramInt].setImageDrawable(BNStyleManager.getDrawable(paramAssistInfo.mIconResId));
      return;
      this.mAssistProgressView[paramInt].setVisibility(8);
      break;
      label147:
      if (paramAssistInfo.mAssistType == 11)
      {
        this.mAssistProgressView[paramInt].setBeamHeight(0);
        this.mAssistProgressView[paramInt].setText(paramAssistInfo.mSpeedLimit / 1000 + "");
      }
      else
      {
        this.mAssistProgressView[paramInt].setBeamHeight(0);
        this.mAssistProgressView[paramInt].setText("");
      }
    }
  }
  
  private void showMapSwitchOrRoadBar(boolean paramBoolean)
  {
    int i = 1;
    LogUtil.e(TAG, "showMapSwitchOrRoadBar : " + paramBoolean);
    int j;
    if ((paramBoolean) && (BNSettingManager.getIsShowMapSwitch() == 0))
    {
      j = 1;
      if ((!paramBoolean) || (BNSettingManager.getIsShowMapSwitch() != 1)) {
        break label114;
      }
      label51:
      if (BNavigator.getInstance().hasCalcRouteOk()) {
        break label119;
      }
      if ((this.mMapSwitchlayout != null) && (this.mMapSwitchSurfaceView != null))
      {
        this.mMapSwitchlayout.setVisibility(8);
        this.mMapSwitchSurfaceView.setVisibility(8);
      }
      if (this.mRoadConditionBarLayout != null) {
        this.mRoadConditionBarLayout.setVisibility(8);
      }
    }
    label114:
    label119:
    label165:
    label218:
    label225:
    label237:
    do
    {
      int k;
      do
      {
        return;
        j = 0;
        break;
        i = 0;
        break label51;
        if ((this.mMapSwitchlayout != null) && (this.mMapSwitchSurfaceView != null))
        {
          localObject = this.mMapSwitchlayout;
          if (j == 0) {
            break label218;
          }
          k = 0;
          ((LinearLayout)localObject).setVisibility(k);
          localObject = this.mMapSwitchSurfaceView;
          if (j == 0) {
            break label225;
          }
          j = 0;
          ((MapSwitchGLSurfaceView)localObject).setVisibility(j);
        }
      } while (this.mRoadConditionBarLayout == null);
      Object localObject = this.mRoadConditionBarLayout;
      if (i != 0) {}
      for (j = 0;; j = 8)
      {
        ((View)localObject).setVisibility(j);
        if ((i == 0) || (!RGControlPanelModel.getInstance().getFullviewState())) {
          break label237;
        }
        RGViewController.getInstance().setRoadConditionBarVisible(8);
        return;
        k = 8;
        break;
        j = 8;
        break label165;
      }
    } while (i != 0);
    this.mRoadConditionView.setVisibility(0);
  }
  
  private void updateAssistInfoView(int paramInt, RGAssistGuideModel.AssistInfo paramAssistInfo)
  {
    if ((paramInt < 0) || (paramInt >= this.mAssistProgressView.length)) {
      return;
    }
    switch (paramAssistInfo.mUpdateType)
    {
    default: 
      return;
    case 1: 
      LogUtil.e(TAG, "AssistantIconUpdate UPDATE_TYPE_SHOW! nAssistType:" + paramAssistInfo.mAssistType + ",nSpeed:" + paramAssistInfo.mSpeedLimit);
      setAssistView(paramInt, paramAssistInfo);
      return;
    case 2: 
      LogUtil.e(TAG, "AssistantIconUpdate UPDATE_TYPE_UPDATE! nAssistType:" + paramAssistInfo.mAssistType + ",nSpeed:" + paramAssistInfo.mSpeedLimit);
      updateAssistProgress(paramInt, paramAssistInfo.mAssistType, paramAssistInfo.mProgress);
      if ("NAV_STATE_NAVING".equals(RGControlPanelModel.getInstance().getNavState()))
      {
        this.mAssistProgressView[paramInt].setVisibility(0);
        return;
      }
      this.mAssistProgressView[paramInt].setVisibility(8);
      return;
    }
    LogUtil.e(TAG, "AssistantIconUpdate UPDATE_TYPE_HIDE! nAssistType:" + paramAssistInfo.mAssistType + ",nSpeed:" + paramAssistInfo.mSpeedLimit);
    this.mAssistProgressView[paramInt].setVisibility(8);
  }
  
  private void updateAssistProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mAssistProgressView[paramInt1] != null) {
      this.mAssistProgressView[paramInt1].setMainProgress(paramInt3);
    }
  }
  
  public void dispose()
  {
    if (this.mMapSwitchlayout != null) {
      this.mMapSwitchlayout.removeAllViews();
    }
    if (this.mMapSwitchSurfaceView != null) {
      this.mMapSwitchSurfaceView = null;
    }
    super.dispose();
  }
  
  public void hide()
  {
    super.hide();
    if (this.mAssistPanel != null) {
      this.mAssistPanel.setVisibility(8);
    }
    if ((this.mCurCarSpeedViewRl != null) && (this.ugcBtnLayout != null))
    {
      this.mCurCarSpeedViewRl.setVisibility(8);
      this.ugcBtnLayout.setVisibility(8);
    }
    showCameraView(false);
    showMapSwitchOrRoadBar(false);
  }
  
  public void hideAssistView()
  {
    if ((this.mCurCarSpeedViewRl != null) && (this.ugcBtnLayout != null))
    {
      this.mCurCarSpeedViewRl.setVisibility(8);
      this.ugcBtnLayout.setVisibility(8);
    }
    showCameraView(false);
    showMapSwitchOrRoadBar(false);
  }
  
  public void hideMapSwitchOrRoadBar()
  {
    showMapSwitchOrRoadBar(false);
  }
  
  public void initMiniMap(MapSwitchGLSurfaceView paramMapSwitchGLSurfaceView)
  {
    releaseMiniMap();
    this.mMapSwitchSurfaceView = paramMapSwitchGLSurfaceView;
    if (this.mMapSwitchSurfaceView.getParent() != null) {
      ((ViewGroup)this.mMapSwitchSurfaceView.getParent()).removeView(this.mMapSwitchSurfaceView);
    }
    paramMapSwitchGLSurfaceView = new LinearLayout.LayoutParams(-1, -1);
    if (this.mMapSwitchlayout != null)
    {
      this.mMapSwitchlayout.addView(this.mMapSwitchSurfaceView, paramMapSwitchGLSurfaceView);
      this.mMapSwitchlayout.requestLayout();
    }
    if (BNavConfig.pRGLocateMode == 2)
    {
      if (this.mMapSwitchlayout != null) {
        this.mMapSwitchlayout.setVisibility(8);
      }
      if (this.mMapSwitchSurfaceView != null) {
        this.mMapSwitchSurfaceView.setVisibility(8);
      }
    }
  }
  
  public boolean isShowingUgcBtnLayout()
  {
    if (this.ugcBtnLayout == null) {}
    while (this.ugcBtnLayout.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void miniRequestRender(boolean paramBoolean)
  {
    if (this.mMapSwitchSurfaceView != null)
    {
      if (!paramBoolean) {
        break label19;
      }
      this.mMapSwitchSurfaceView.requestRender();
    }
    label19:
    while ((this.mMapSwitchlayout == null) || (this.mMapSwitchlayout.getVisibility() != 0)) {
      return;
    }
    this.mMapSwitchSurfaceView.requestRender();
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    updateDataByLastest();
  }
  
  public void releaseMiniMap()
  {
    if ((this.mMapSwitchlayout != null) && (this.mMapSwitchSurfaceView != null)) {
      this.mMapSwitchlayout.removeView(this.mMapSwitchSurfaceView);
    }
    if (this.mMapSwitchSurfaceView != null) {
      this.mMapSwitchSurfaceView = null;
    }
  }
  
  public void resetRoadConditionData()
  {
    if (this.mRoadConditionView != null) {
      this.mRoadConditionView.resetRoadConditionData();
    }
  }
  
  public void setAssistContainerVisible()
  {
    if (!BNavigator.getInstance().hasCalcRouteOk()) {}
    while (this.mAssistPanel == null) {
      return;
    }
    this.mAssistPanel.setVisibility(0);
  }
  
  public void setRoadConditionBarVisible(int paramInt)
  {
    if (this.mRoadConditionView != null) {
      this.mRoadConditionView.setVisibility(paramInt);
    }
  }
  
  public void show()
  {
    super.show();
    if (!BNavigator.getInstance().hasCalcRouteOk()) {
      return;
    }
    if (this.mAssistPanel != null) {
      this.mAssistPanel.setVisibility(0);
    }
    if ((this.mCurCarSpeedViewRl != null) && (this.ugcBtnLayout != null))
    {
      if (BNavConfig.pRGLocateMode != 2) {
        break label73;
      }
      this.mCurCarSpeedViewRl.setVisibility(8);
      this.ugcBtnLayout.setVisibility(8);
    }
    for (;;)
    {
      showMapSwitchOrRoadBar();
      return;
      label73:
      this.mCurCarSpeedViewRl.setVisibility(0);
      if (!RGMapModeViewController.getInstance().isShowingUgcBtnLayout) {}
    }
  }
  
  public void showCameraView(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      int j = 0;
      while (j < this.mAssistProgressView.length)
      {
        this.mAssistProgressView[j].setVisibility(i);
        j += 1;
      }
    }
    if (paramBoolean) {
      BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410284", "410284");
    }
  }
  
  public void showMapSwitchOrRoadBar()
  {
    if (BNavConfig.pRGLocateMode == 2)
    {
      showMapSwitchOrRoadBar(false);
      return;
    }
    showMapSwitchOrRoadBar(true);
  }
  
  public void showUgcBtnLayout(boolean paramBoolean)
  {
    if (this.ugcBtnLayout == null) {}
    do
    {
      return;
      LogUtil.e(TAG, "showUgcBtnLayout: show --> " + paramBoolean);
    } while (paramBoolean);
    this.ugcBtnLayout.setVisibility(8);
  }
  
  public void updateAssistFullViewModeBtn()
  {
    if (this.mFullViewModeBtn == null) {
      return;
    }
    if (RGControlPanelModel.getInstance().getFullviewState())
    {
      this.mFullViewModeText.setText("退出全览");
      return;
    }
    this.mFullViewModeText.setText("全览");
  }
  
  public void updateCarProgress()
  {
    if (this.mRoadConditionView != null)
    {
      this.mRoadConditionView.updateCarProgress(RGAssistGuideModel.getInstance().getCarProgress());
      this.mRoadConditionView.invalidate();
    }
  }
  
  public void updateCurCarSpeed()
  {
    if ((this.mCurCarSpeedView != null) && (this.mCurCarSpeedViewRl != null) && (this.mCurCarSpeedViewTv != null))
    {
      this.mCurCarSpeedView.setText(RGAssistGuideModel.getInstance().getCurCarSpeed());
      if ((RGAssistGuideModel.getInstance().isOverSpeed()) && (RGAssistGuideModel.getInstance().isCarSpeedRight()))
      {
        this.mCurCarSpeedView.setTextColor(BNStyleManager.getColor(1711800700));
        this.mCurCarSpeedViewTv.setTextColor(BNStyleManager.getColor(1711800700));
        this.mCurCarSpeedViewRl.setBackgroundDrawable(BNStyleManager.getDrawable(1711407567));
      }
    }
    else
    {
      return;
    }
    this.mCurCarSpeedView.setTextColor(BNStyleManager.getColor(1711800698));
    this.mCurCarSpeedViewTv.setTextColor(BNStyleManager.getColor(1711800698));
    this.mCurCarSpeedViewRl.setBackgroundDrawable(BNStyleManager.getDrawable(1711407566));
  }
  
  public void updateData(Bundle paramBundle)
  {
    if (("EnlargeRoadmap".equals(RouteGuideFSM.getInstance().getCurrentState())) || ("Colladamap".equals(RouteGuideFSM.getInstance().getCurrentState()))) {}
    int i;
    do
    {
      return;
      int j = -1;
      i = j;
      if (paramBundle != null)
      {
        i = j;
        if (paramBundle.containsKey("key_assist_index")) {
          i = paramBundle.getInt("key_assist_index");
        }
      }
      if ((i < 0) || (i >= this.mAssistProgressView.length))
      {
        showCameraView(false);
        return;
      }
      paramBundle = RGAssistGuideModel.getInstance().getAssistInfo(i);
    } while (paramBundle == null);
    updateAssistInfoView(i, paramBundle);
  }
  
  public void updateDataByLastest()
  {
    int i = 0;
    while (i < 3)
    {
      RGAssistGuideModel.AssistInfo localAssistInfo2 = RGAssistGuideModel.getInstance().getAssistInfo(i);
      RGAssistGuideModel.AssistInfo localAssistInfo1 = null;
      if (localAssistInfo2 != null) {
        localAssistInfo1 = localAssistInfo2.cloneTo();
      }
      if ((localAssistInfo1 != null) && ((2 == localAssistInfo1.mUpdateType) || (1 == localAssistInfo1.mUpdateType)))
      {
        localAssistInfo1.mUpdateType = 1;
        updateAssistInfoView(i, localAssistInfo1);
      }
      i += 1;
    }
    updateCarProgress();
    updateRoadConditionBar();
    updateCurCarSpeed();
  }
  
  public void updateRoadConditionBar()
  {
    if (this.mRoadConditionView != null)
    {
      this.mRoadConditionView.updateCarProgress(RGAssistGuideModel.getInstance().getCarProgress());
      this.mRoadConditionView.updateRoadConditionData(RGAssistGuideModel.getInstance().getRoadConditionData());
      this.mRoadConditionView.invalidate();
    }
  }
  
  public void updateRoadConditionBarTimeInterval()
  {
    if ((this.mRoadConditionView != null) && (RGAssistGuideModel.getInstance().isTimeToRefreshRoadCondition()))
    {
      this.mRoadConditionView.updateCarProgress(RGAssistGuideModel.getInstance().getCarProgress());
      this.mRoadConditionView.updateRoadConditionData(RGAssistGuideModel.getInstance().getRoadConditionData());
      this.mRoadConditionView.invalidate();
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.ugcBtnLayout != null) {
      this.ugcBtnLayout.setBackgroundDrawable(BNStyleManager.getRealDrawable(1711407125));
    }
    if (this.ugcIcon != null) {
      this.ugcIcon.setImageDrawable(BNStyleManager.getDrawable(1711408022));
    }
    if (this.ugcTv != null) {
      this.ugcTv.setTextColor(BNStyleManager.getColor(1711800802));
    }
    if (this.mFullViewModeBtn != null) {
      this.mFullViewModeBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407125));
    }
    if (this.mFullViewModeIv != null) {
      this.mFullViewModeIv.setImageDrawable(BNStyleManager.getDrawable(1711407514));
    }
    if (this.mFullViewModeText != null) {
      this.mFullViewModeText.setTextColor(BNStyleManager.getColor(1711800686));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMAssistGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */