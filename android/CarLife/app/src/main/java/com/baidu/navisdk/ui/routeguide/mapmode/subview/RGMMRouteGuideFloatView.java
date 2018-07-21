package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMRouteGuideFloatView
{
  private static final int ROUTE_MODE_ALONG = 1;
  private static final int ROUTE_MODE_FUZZY = 2;
  private static final int ROUTE_MODE_INVALID = -1;
  private static final int ROUTE_MODE_NORMAL = 0;
  private static final String TAG = RGMMRouteGuideFloatView.class.getSimpleName();
  private boolean isMoved = false;
  private boolean isShowing = false;
  private TextView mAfterLabelInfoTV;
  private TextView mAfterMetersInfoTV = null;
  private View mAlongModeContainer = null;
  private ViewGroup mContentView;
  private TextView mCurRoadNameTV = null;
  private TextView mCurRoadRemainDistTV = null;
  private TextView mCurRoadRemainDistWordTV = null;
  private TextView mDirectionTV = null;
  private float mDownX = 0.0F;
  private float mDownY = 0.0F;
  private ViewGroup mFloatLayout;
  private View mFuzzyModeContainer = null;
  private TextView mFuzzyTV;
  private TextView mGoWhereInfoTV;
  private TextView mICCodeTV = null;
  private View mNormalModeContainer = null;
  private int mScreenHight;
  private int mScreenWidth;
  private int mTouchSlop;
  private ImageView mTurnIcon = null;
  private WindowManager mWindowManager;
  private float mXInFloatView;
  private float mXInScreen;
  private float mYInFloatView;
  private float mYInScreen;
  private WindowManager.LayoutParams wmParams;
  
  public RGMMRouteGuideFloatView()
  {
    initWindowsManger();
    intParams();
    initViews();
  }
  
  private boolean handleMotionEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.mXInFloatView = paramMotionEvent.getX();
      this.mYInFloatView = paramMotionEvent.getY();
      this.mDownX = paramMotionEvent.getRawX();
      this.mDownY = paramMotionEvent.getRawY();
      this.isMoved = false;
      return false;
    case 2: 
      this.mXInScreen = paramMotionEvent.getRawX();
      this.mYInScreen = (paramMotionEvent.getRawY() - ScreenUtil.getInstance().getStatusBarHeight());
      if ((Math.abs(this.mDownX - paramMotionEvent.getRawX()) > this.mTouchSlop) || (Math.abs(this.mDownY - paramMotionEvent.getRawY()) > this.mTouchSlop)) {
        this.isMoved = true;
      }
      updateViewPosition();
      return false;
    }
    updateViewPosition();
    return this.isMoved;
  }
  
  private void initViews()
  {
    this.mFloatLayout = ((ViewGroup)JarUtils.inflate(BNaviModuleManager.getActivity(), 1711472710, null));
    this.mNormalModeContainer = this.mFloatLayout.findViewById(1711866477);
    this.mAlongModeContainer = this.mFloatLayout.findViewById(1711866485);
    this.mFuzzyModeContainer = this.mFloatLayout.findViewById(1711866475);
    this.mContentView = ((ViewGroup)this.mFloatLayout.findViewById(1711866473));
    this.mTurnIcon = ((ImageView)this.mFloatLayout.findViewById(1711866474));
    this.mAfterMetersInfoTV = ((TextView)this.mFloatLayout.findViewById(1711866479));
    this.mGoWhereInfoTV = ((TextView)this.mFloatLayout.findViewById(1711866483));
    this.mAfterLabelInfoTV = ((TextView)this.mFloatLayout.findViewById(1711866480));
    this.mICCodeTV = ((TextView)this.mFloatLayout.findViewById(1711866482));
    this.mDirectionTV = ((TextView)this.mFloatLayout.findViewById(1711866484));
    this.mCurRoadNameTV = ((TextView)this.mFloatLayout.findViewById(1711866487));
    this.mCurRoadRemainDistTV = ((TextView)this.mFloatLayout.findViewById(1711866488));
    this.mCurRoadRemainDistWordTV = ((TextView)this.mFloatLayout.findViewById(1711866489));
    this.mFuzzyTV = ((TextView)this.mFuzzyModeContainer.findViewById(1711866476));
    this.mFloatLayout.findViewById(1711866491).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserOPController.getInstance().add("3.x.3");
        RGMMRouteGuideFloatView.this.hide();
        RGCacheStatus.hasClosedFoatView = true;
        if (!BNSettingManager.hasShowFloatCloseMsg())
        {
          BNSettingManager.setShowFloatClosedMsg(true);
          RGViewController.getInstance().showCloseRGFloatViewMsg();
        }
      }
    });
    this.mFloatLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return;
        }
        UserOPController.getInstance().add("3.x.4");
        BNaviModuleManager.launchMapsActivityToFront();
        RGMMRouteGuideFloatView.this.hide();
      }
    });
  }
  
  private void initWindowsManger()
  {
    this.wmParams = new WindowManager.LayoutParams();
    this.mWindowManager = ((WindowManager)BNaviModuleManager.getActivity().getApplicationContext().getSystemService("window"));
    if (Build.VERSION.SDK_INT >= 19) {}
    for (this.wmParams.type = 2005;; this.wmParams.type = 2002)
    {
      this.wmParams.format = 1;
      this.wmParams.flags = 8;
      this.wmParams.gravity = 51;
      this.wmParams.x = ScreenUtil.getInstance().dip2px(25);
      this.wmParams.y = 0;
      this.wmParams.width = ScreenUtil.getInstance().dip2px(196);
      this.wmParams.height = ScreenUtil.getInstance().dip2px(52);
      return;
    }
  }
  
  private void intParams()
  {
    this.mTouchSlop = ScreenUtil.getInstance().dip2px(4);
    this.mScreenWidth = ScreenUtil.getInstance().getWidthPixels();
    this.mScreenHight = ScreenUtil.getInstance().getHeightPixels();
  }
  
  private String subDirectionText(int paramInt, String paramString)
  {
    if (this.mGoWhereInfoTV == null) {}
    int i;
    do
    {
      do
      {
        return paramString;
      } while (UIUtils.isTextFullDisplay(this.mGoWhereInfoTV, paramInt, paramString, 1));
      i = paramString.lastIndexOf(" ");
    } while (i < 0);
    return subDirectionText(paramInt, paramString.substring(0, i));
  }
  
  private void updateExitCodeView() {}
  
  private void updateViewPosition()
  {
    this.wmParams.x = ((int)(this.mXInScreen - this.mXInFloatView));
    this.wmParams.y = ((int)(this.mYInScreen - this.mYInFloatView));
    try
    {
      this.mWindowManager.updateViewLayout(this.mFloatLayout, this.wmParams);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dispose()
  {
    this.isShowing = false;
    if (this.mFloatLayout != null) {
      this.mWindowManager.removeView(this.mFloatLayout);
    }
  }
  
  public void hide()
  {
    LogUtil.e(TAG, "hide");
    try
    {
      if ((this.mFloatLayout != null) && (this.mFloatLayout.getParent() != null)) {
        this.mWindowManager.removeView(this.mFloatLayout);
      }
      this.isShowing = false;
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "hide float excetion e:" + localException.getMessage());
    }
  }
  
  public boolean isShow()
  {
    return this.isShowing;
  }
  
  public boolean show()
  {
    LogUtil.e(TAG, "show :" + isShow());
    if (isShow()) {
      return true;
    }
    try
    {
      if (!RGCacheStatus.hasRecordFloatViewShow)
      {
        RGCacheStatus.hasRecordFloatViewShow = true;
        UserOPController.getInstance().add("3.x.2");
      }
      updateDataByLastest();
      this.mFloatLayout.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return RGMMRouteGuideFloatView.this.handleMotionEvent(paramAnonymousMotionEvent);
        }
      });
      this.mWindowManager.addView(this.mFloatLayout, this.wmParams);
      this.isShowing = true;
      return true;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "float excetion e:" + localException.getMessage());
      this.isShowing = false;
    }
    return false;
  }
  
  public void updateData(Bundle paramBundle, boolean paramBoolean)
  {
    int i;
    if ("Highway".equals(RouteGuideFSM.getInstance().getCurrentState())) {
      if (paramBoolean)
      {
        i = updateHighwayData();
        if (i != 0) {
          break label96;
        }
        this.mNormalModeContainer.setVisibility(0);
        this.mAlongModeContainer.setVisibility(8);
        this.mFuzzyModeContainer.setVisibility(8);
      }
    }
    for (;;)
    {
      this.mContentView.requestLayout();
      this.mContentView.invalidate();
      do
      {
        return;
      } while (paramBoolean);
      if (paramBundle != null) {}
      for (;;)
      {
        i = updateSimpleGuideData(paramBundle);
        break;
        paramBundle = RGSimpleGuideModel.getInstance().getNextGuideInfo();
      }
      label96:
      if (1 == i)
      {
        this.mNormalModeContainer.setVisibility(8);
        this.mAlongModeContainer.setVisibility(0);
        this.mFuzzyModeContainer.setVisibility(8);
      }
      else if (2 == i)
      {
        this.mNormalModeContainer.setVisibility(8);
        this.mAlongModeContainer.setVisibility(8);
        this.mFuzzyModeContainer.setVisibility(0);
      }
    }
  }
  
  public void updateDataByLastest()
  {
    if ("Highway".equals(RouteGuideFSM.getInstance().getCurrentState()))
    {
      updateData(null, true);
      return;
    }
    updateData(RGSimpleGuideModel.getInstance().getNextGuideInfo(), false);
  }
  
  public int updateHighwayData()
  {
    String str2 = RGHighwayModel.getInstance().getFormatExitRemainDist();
    String str1 = RGSimpleGuideModel.getInstance().getDistStart(str2);
    str2 = RGSimpleGuideModel.getInstance().getDistEnd(str2);
    String str3 = RGHighwayModel.getInstance().formatDirections();
    try
    {
      this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(1711407697));
      if (str3 == null)
      {
        if (this.mCurRoadNameTV != null) {
          this.mCurRoadNameTV.setText(RGHighwayModel.getInstance().getCurRoadName());
        }
        if (this.mCurRoadRemainDistTV != null) {
          this.mCurRoadRemainDistTV.setText(str1);
        }
        if (this.mCurRoadRemainDistWordTV != null) {
          this.mCurRoadRemainDistWordTV.setText(str2);
        }
        if (this.mDirectionTV != null) {
          this.mDirectionTV.setVisibility(8);
        }
        updateExitCodeView();
        return 1;
      }
      if ((this.mAfterMetersInfoTV != null) && (this.mAfterLabelInfoTV != null) && (str1 != null) && (str2 != null))
      {
        if (RGHighwayModel.getInstance().getTypeRemainDist(4) >= 10) {
          break label236;
        }
        this.mAfterMetersInfoTV.setText("现在");
        this.mAfterLabelInfoTV.setText("");
      }
      for (;;)
      {
        if ((this.mGoWhereInfoTV != null) && (str3 != null))
        {
          this.mGoWhereInfoTV.setText(subDirectionText(ScreenUtil.getInstance().dip2px(72), str3));
          this.mGoWhereInfoTV.setVisibility(0);
        }
        if (this.mDirectionTV != null) {
          this.mDirectionTV.setVisibility(0);
        }
        updateExitCodeView();
        return 0;
        label236:
        this.mAfterMetersInfoTV.setText(str1);
        this.mAfterLabelInfoTV.setText(str2 + "后");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public int updateSimpleGuideData(Bundle paramBundle)
  {
    if (paramBundle.getInt("updatetype") != 1) {
      return -1;
    }
    if (RGMapModeViewController.getInstance().isFuzzyMode())
    {
      this.mFuzzyTV.setText(RGSimpleGuideModel.getInstance().getFuzzyTV());
      this.mTurnIcon.setImageResource(1711407146);
      return 2;
    }
    int i = paramBundle.getInt("resid", 0);
    int j = paramBundle.getInt("remain_dist", 0);
    String str2 = paramBundle.getString("road_name");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = JarUtils.getResources().getString(1711669540);
    }
    if (i != 0) {}
    try
    {
      this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(i));
      String str3 = RGSimpleGuideModel.getInstance().getFormatAfterMeters(j);
      str2 = RGSimpleGuideModel.getInstance().getDistStart(str3);
      str3 = RGSimpleGuideModel.getInstance().getDistEnd(str3);
      if ((this.mAfterMetersInfoTV != null) && (this.mAfterLabelInfoTV != null) && (str2 != null) && (str3 != null))
      {
        if (j >= 10) {
          break label387;
        }
        this.mAfterMetersInfoTV.setText("现在");
        this.mAfterLabelInfoTV.setText("");
      }
      for (;;)
      {
        str1 = RGSimpleGuideModel.getInstance().getFormatGoNextRoad(str1);
        if ((str1 != null) && (this.mGoWhereInfoTV != null) && (!this.mGoWhereInfoTV.getText().equals(str1))) {
          this.mGoWhereInfoTV.setText(str1);
        }
        paramBundle = paramBundle.getString("cur_road_name");
        if ((this.mCurRoadNameTV != null) && (paramBundle != null) && (!paramBundle.equals(this.mCurRoadNameTV.getText()))) {
          this.mCurRoadNameTV.setText(paramBundle);
        }
        if ((this.mCurRoadRemainDistTV != null) && (str2 != null)) {
          this.mCurRoadRemainDistTV.setText(str2);
        }
        if ((this.mCurRoadRemainDistWordTV != null) && (str3 != null)) {
          this.mCurRoadRemainDistWordTV.setText(str3);
        }
        if (this.mICCodeTV != null) {
          this.mICCodeTV.setVisibility(8);
        }
        if (this.mDirectionTV != null) {
          this.mDirectionTV.setVisibility(8);
        }
        if (RGSimpleGuideModel.getInstance().isStraight()) {}
        try
        {
          this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(1711407697));
          return 1;
          label387:
          this.mAfterMetersInfoTV.setText(str2);
          this.mAfterLabelInfoTV.setText(str3 + "后");
          continue;
          return 0;
        }
        catch (Throwable paramBundle)
        {
          for (;;) {}
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMRouteGuideFloatView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */