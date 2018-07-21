package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGHUDView
  extends LinearLayout
{
  private View gpsView;
  private boolean isMirror;
  private TextView mAlongDistance;
  private TextView mArrivingTime;
  private TextView mCarSpeed;
  private CircleProgressImageView mCarSpeedProgress;
  private TextView mDirectCurrentRoad;
  private RelativeLayout mDirectRoadLayout;
  private TextView mHighWayEnter;
  private TextView mHighWayExitCode;
  private TextView mHighWayGoTo;
  private TextView mHighWayGoWhere;
  private RelativeLayout mHighWayLayout;
  private TextView mHighWayLeftDistance;
  private TextView mHighWayLeftDistanceLable;
  private ImageView mHighWayTurnIcon;
  private RelativeLayout mHudLayout;
  private int mLastResId = -1;
  private RelativeLayout mLeftDistanceLayout;
  private CircleProgressImageView mLeftDistanceProgress;
  private TextView mLeftTotalDistance;
  private TextView mNormalCurrentRoad;
  private TextView mNormalGoMeters;
  private TextView mNormalGoMetersLable;
  private RelativeLayout mNormalLayout;
  private ImageView mNormalTurnIcon;
  private RelativeLayout mSpeedLayout;
  private int mTextSizeFirst = 42;
  private int mTextSizeSecond = 38;
  private ViewGroup mViewGroup;
  private RelativeLayout mYawLayout;
  private View uiView;
  
  public RGHUDView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public RGHUDView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private int getCurrentOrientation()
  {
    return RGViewController.getInstance().getOrientation();
  }
  
  private void initView()
  {
    if (this.mViewGroup != null) {
      this.mViewGroup.removeAllViews();
    }
    if (1 == RGViewController.getInstance().getOrientation()) {}
    for (this.mViewGroup = ((ViewGroup)JarUtils.inflate((Activity)getContext(), 1711472701, null)); this.mViewGroup == null; this.mViewGroup = ((ViewGroup)JarUtils.inflate((Activity)getContext(), 1711472702, null))) {
      return;
    }
    addView(this.mViewGroup, new LinearLayout.LayoutParams(-1, -1));
    findView();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.isMirror)
    {
      paramCanvas.translate(0.0F, getMeasuredHeight());
      paramCanvas.scale(1.0F, -1.0F);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void findView()
  {
    this.mHudLayout = ((RelativeLayout)this.mViewGroup.findViewById(1711866383));
    this.mNormalLayout = ((RelativeLayout)this.mViewGroup.findViewById(1711866385));
    this.mNormalTurnIcon = ((ImageView)this.mViewGroup.findViewById(1711866386));
    this.mNormalGoMeters = ((TextView)this.mViewGroup.findViewById(1711866388));
    this.mNormalGoMetersLable = ((TextView)this.mViewGroup.findViewById(1711866389));
    this.mNormalCurrentRoad = ((TextView)this.mViewGroup.findViewById(1711866391));
    this.mDirectRoadLayout = ((RelativeLayout)this.mViewGroup.findViewById(1711866392));
    this.mAlongDistance = ((TextView)this.mViewGroup.findViewById(1711866398));
    this.mDirectCurrentRoad = ((TextView)this.mViewGroup.findViewById(1711866396));
    this.mHighWayLayout = ((RelativeLayout)this.mViewGroup.findViewById(1711866399));
    this.mHighWayTurnIcon = ((ImageView)this.mViewGroup.findViewById(1711866400));
    this.mHighWayLeftDistance = ((TextView)this.mViewGroup.findViewById(1711866402));
    this.mHighWayExitCode = ((TextView)this.mViewGroup.findViewById(1711866405));
    this.mHighWayGoTo = ((TextView)this.mViewGroup.findViewById(1711866406));
    this.mHighWayEnter = ((TextView)this.mViewGroup.findViewById(1711866407));
    this.mHighWayGoWhere = ((TextView)this.mViewGroup.findViewById(1711866409));
    this.mHighWayLeftDistanceLable = ((TextView)this.mViewGroup.findViewById(1711866403));
    this.mCarSpeedProgress = ((CircleProgressImageView)this.mViewGroup.findViewById(1711866413));
    this.mLeftDistanceProgress = ((CircleProgressImageView)this.mViewGroup.findViewById(1711866416));
    this.mCarSpeed = ((TextView)this.mViewGroup.findViewById(1711866414));
    this.mLeftTotalDistance = ((TextView)this.mViewGroup.findViewById(1711866417));
    this.mArrivingTime = ((TextView)this.mViewGroup.findViewById(1711866418));
    if (getCurrentOrientation() == 2)
    {
      this.mSpeedLayout = ((RelativeLayout)this.mViewGroup.findViewById(1711866424));
      this.mLeftDistanceLayout = ((RelativeLayout)this.mViewGroup.findViewById(1711866426));
    }
    this.mYawLayout = ((RelativeLayout)this.mViewGroup.findViewById(1711866422));
    this.gpsView = this.mViewGroup.findViewById(1711866419);
    this.uiView = this.mViewGroup.findViewById(1711866383);
  }
  
  public void gpsSignalRecover()
  {
    this.uiView.setVisibility(0);
    this.gpsView.setVisibility(8);
  }
  
  public boolean isMirror()
  {
    return this.isMirror;
  }
  
  public void lostGPSSignal()
  {
    this.gpsView.setVisibility(0);
    this.uiView.setVisibility(8);
  }
  
  public void onOrientationChanged()
  {
    if (this.mViewGroup != null) {
      this.mViewGroup.removeAllViews();
    }
    if (getCurrentOrientation() == 1)
    {
      JarUtils.inflate((Activity)getContext(), 1711472701, this.mViewGroup);
      findView();
      return;
    }
    JarUtils.inflate((Activity)getContext(), 1711472702, this.mViewGroup);
    findView();
  }
  
  public void setDirectCurrentRoad(String paramString)
  {
    if (!paramString.equals(this.mDirectCurrentRoad.getText().toString())) {
      this.mDirectCurrentRoad.setText(paramString);
    }
  }
  
  public void setDirectDistance(String paramString)
  {
    if (!paramString.equals(this.mAlongDistance.getText().toString())) {
      this.mAlongDistance.setText(paramString);
    }
  }
  
  public void setDirection(String paramString) {}
  
  public void setHighWayExitCode(String paramString)
  {
    if (!paramString.equals(this.mHighWayExitCode.getText().toString())) {
      this.mHighWayExitCode.setText(paramString);
    }
  }
  
  public void setHighWayExitRoad(String paramString)
  {
    if (!paramString.equals(this.mHighWayGoWhere.getText().toString())) {
      this.mHighWayGoWhere.setText(paramString);
    }
  }
  
  public void setHighWayRemainDistance(String paramString)
  {
    if (!paramString.equals(this.mHighWayLeftDistance))
    {
      if ("0米".equals(paramString))
      {
        this.mHighWayLeftDistance.setText("现在");
        this.mHighWayLeftDistanceLable.setText("");
      }
    }
    else {
      return;
    }
    this.mHighWayLeftDistance.setText(paramString);
    this.mHighWayLeftDistanceLable.setText("后");
  }
  
  public void setHighWayTurnIcon(int paramInt)
  {
    if (paramInt != this.mLastResId)
    {
      this.mLastResId = paramInt;
      this.mHighWayTurnIcon.setImageDrawable(RGHighwayModel.getInstance().getTurnIconDrawable(paramInt, true));
    }
  }
  
  public void setMirror(boolean paramBoolean)
  {
    this.isMirror = paramBoolean;
  }
  
  public void setNormalCurrentRoad(String paramString)
  {
    if (!paramString.equals(this.mNormalCurrentRoad.getText().toString())) {
      this.mNormalCurrentRoad.setText(paramString);
    }
  }
  
  public void setNormalGoMeters(String paramString)
  {
    if ("0米".equals(paramString))
    {
      this.mNormalGoMeters.setText("现在");
      this.mNormalGoMetersLable.setText("");
      return;
    }
    this.mNormalGoMeters.setText(paramString);
    this.mNormalGoMetersLable.setText("后");
  }
  
  public void setNormalTurnIcon(int paramInt)
  {
    if (RightHandResourcesProvider.getEnNaviType() == 0)
    {
      this.mNormalTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(paramInt));
      return;
    }
    this.mNormalTurnIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(paramInt));
  }
  
  public void updateCurrentCarSpeed()
  {
    if (this.mCarSpeed != null)
    {
      int i = RGHUDDataModel.getProgress(RGAssistGuideModel.getInstance().getCurCarSpeedInt(), 240);
      this.mCarSpeedProgress.setMainProgress(i);
      this.mCarSpeedProgress.setSubProgress(240);
      this.mCarSpeed.setText(RGAssistGuideModel.getInstance().getCurCarSpeed());
    }
  }
  
  public void updateDirectRoadInfoVisibility(boolean paramBoolean)
  {
    if (paramBoolean == true) {}
    for (int i = 0;; i = 8)
    {
      this.mDirectRoadLayout.setVisibility(i);
      return;
    }
  }
  
  public void updateHighWayAlongVisibility(boolean paramBoolean)
  {
    this.mHighWayTurnIcon.setVisibility(0);
    this.mHighWayLeftDistance.setVisibility(0);
    this.mHighWayGoWhere.setVisibility(0);
    if (paramBoolean)
    {
      this.mHighWayGoTo.setVisibility(8);
      this.mHighWayExitCode.setVisibility(0);
      this.mHighWayEnter.setVisibility(0);
      return;
    }
    this.mHighWayGoTo.setVisibility(0);
    this.mHighWayExitCode.setVisibility(8);
    this.mHighWayEnter.setVisibility(8);
  }
  
  public void updateHighWayVisibility(boolean paramBoolean)
  {
    if (paramBoolean == true) {}
    for (int i = 0;; i = 8)
    {
      this.mHighWayLayout.setVisibility(i);
      return;
    }
  }
  
  public void updateHudView(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      if (getCurrentOrientation() == 2)
      {
        this.mSpeedLayout.setVisibility(i);
        this.mLeftDistanceLayout.setVisibility(i);
      }
      this.mHudLayout.setVisibility(i);
      return;
    }
  }
  
  public void updateHudYaw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      updateHudView(paramBoolean);
      this.mYawLayout.setVisibility(0);
      return;
    }
    updateHudView(paramBoolean);
    this.mYawLayout.setVisibility(8);
  }
  
  public void updateNormalRoadInfoVisibility(boolean paramBoolean)
  {
    if (paramBoolean == true) {}
    for (int i = 0;; i = 8)
    {
      this.mNormalLayout.setVisibility(i);
      return;
    }
  }
  
  public void updateTotalRemainInfo()
  {
    if (this.mArrivingTime != null)
    {
      String str = RGSimpleGuideModel.getInstance().getArriveTimeString();
      this.mArrivingTime.setText(String.format(BNStyleManager.getString(1711669875), new Object[] { str }));
    }
    int i;
    int j;
    if (this.mLeftTotalDistance != null)
    {
      i = RGSimpleGuideModel.getInstance().getTotalRemainDist();
      if (i / 1000 < 1000) {
        break label118;
      }
      this.mLeftTotalDistance.setTextSize(this.mTextSizeSecond);
      j = RGHUDDataModel.getProgress(i, RGHUDDataModel.totalDistance);
      if (i >= 50) {
        break label133;
      }
      this.mLeftDistanceProgress.setMainProgress(0);
    }
    for (;;)
    {
      this.mLeftDistanceProgress.setSubProgress(100);
      this.mLeftTotalDistance.setText(RGHUDDataModel.getFormatDistance(i));
      return;
      label118:
      this.mLeftTotalDistance.setTextSize(this.mTextSizeFirst);
      break;
      label133:
      this.mLeftDistanceProgress.setMainProgress(j);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/hud/RGHUDView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */