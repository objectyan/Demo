package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMHighwayView
  extends BNBaseView
{
  private static String TAG = "Highway";
  private TextView mAfterLabelInfoTV = null;
  private TextView mAfterMetersMultiTV = null;
  private TextView mArriveTimeTV = null;
  private TextView mCurRoadNameTV = null;
  private TextView mCurRoadRemainDistTV = null;
  private TextView mCurRoadRemainDistWordTV = null;
  private int mCurTurnIconType = -1;
  private TextView mDirectionTV = null;
  private View mExitDirectionsPanel = null;
  private ImageView mExitTurnIcon = null;
  private TextView mGoWhereInfoMultiTV = null;
  private View mHighwayAlongMode = null;
  private View mHighwayDirectionMode = null;
  private View mHighwayView = null;
  private ViewGroup mHighwayViewContainer = null;
  private ViewGroup mHighwayViewLayout = null;
  private ViewGroup mHighwayViewMiniLayout = null;
  private TextView mICCodeTV = null;
  private String mLastArriveTimeS = "";
  private int mLastSateliteNum = -1;
  private String mLastTotalRemainDistS = "";
  private TextView mMiniAfterMetersMultiTv;
  private LinearLayout mMiniAlongMode;
  private TextView mMiniCurRoadDistTv;
  private TextView mMiniCurRoadDistWordTv;
  private TextView mMiniCurRoadNameTv;
  private RelativeLayout mMiniDirectionMode;
  private TextView mMiniDirectionTv;
  private TextView mMiniGoWhereMultiTv;
  private float mMiniPanerDownY;
  private ImageView mMiniTurnIcon;
  private TextView mTotalDistTV = null;
  
  public RGMMHighwayView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
  }
  
  private int getGoWhereViewWidth()
  {
    if (RGViewController.getInstance().getPreloadOrientation() == 1)
    {
      int j = ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(134);
      int i = j;
      if (this.mICCodeTV != null)
      {
        i = j;
        if (this.mICCodeTV.getVisibility() == 0) {
          i = j - ScreenUtil.getInstance().dip2px(8) - UIUtils.mearsureTextWidth(this.mICCodeTV, this.mICCodeTV.getText().toString());
        }
      }
      j = i;
      if (this.mDirectionTV.getVisibility() == 0) {
        j = i - ScreenUtil.getInstance().dip2px(52);
      }
      return j;
    }
    return ScreenUtil.getInstance().getGuidePanelWidth();
  }
  
  private int getMiniDirectionWidth()
  {
    int j = 0;
    int i = j;
    if (this.mMiniAfterMetersMultiTv != null)
    {
      i = j;
      if (this.mMiniGoWhereMultiTv != null)
      {
        i = j;
        if (this.mMiniDirectionTv != null)
        {
          Object localObject = new int[2];
          this.mMiniGoWhereMultiTv.getLocationOnScreen((int[])localObject);
          i = localObject[0];
          localObject = (RelativeLayout.LayoutParams)this.mMiniDirectionTv.getLayoutParams();
          j = this.mMiniDirectionTv.getWidth();
          int k = ((RelativeLayout.LayoutParams)localObject).rightMargin;
          int m = ((RelativeLayout.LayoutParams)localObject).leftMargin;
          i = ScreenUtil.getInstance().getWidthPixels() - i - (j + k + m) - ScreenUtil.getInstance().dip2px(5);
        }
      }
    }
    return i;
  }
  
  private SpannableStringBuilder getSpannableStringBuilder(String paramString)
  {
    ForegroundColorSpan localForegroundColorSpan1 = new ForegroundColorSpan(JarUtils.getResources().getColor(1711800489));
    ForegroundColorSpan localForegroundColorSpan2 = new ForegroundColorSpan(JarUtils.getResources().getColor(1711800671));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    if (paramString.endsWith(JarUtils.getResources().getString(1711669871)))
    {
      localSpannableStringBuilder.setSpan(localForegroundColorSpan1, 0, paramString.length() - 2, 33);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan2, paramString.length() - 2, paramString.length(), 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.setSpan(localForegroundColorSpan1, 0, paramString.length(), 33);
    return localSpannableStringBuilder;
  }
  
  private void initMiniPaner()
  {
    LogUtil.e(TAG, "initMiniPaner - viewStub.inflate : mHighwayViewMiniLayout = " + this.mHighwayViewMiniLayout + ", mRootViewGroup = " + this.mRootViewGroup);
    if ((this.mHighwayViewMiniLayout == null) && (this.mRootViewGroup != null))
    {
      ViewStub localViewStub = (ViewStub)this.mRootViewGroup.findViewById(1711866506);
      if (localViewStub != null) {
        this.mHighwayViewMiniLayout = ((ViewGroup)localViewStub.inflate());
      }
      if (this.mHighwayViewMiniLayout == null) {
        this.mHighwayViewMiniLayout = ((ViewGroup)this.mRootViewGroup.findViewById(1711866231));
      }
      if (this.mHighwayViewMiniLayout != null)
      {
        this.mMiniDirectionMode = ((RelativeLayout)this.mHighwayViewMiniLayout.findViewById(1711866233));
        this.mMiniAlongMode = ((LinearLayout)this.mHighwayViewMiniLayout.findViewById(1711866238));
        this.mMiniTurnIcon = ((ImageView)this.mHighwayViewMiniLayout.findViewById(1711866232));
        this.mMiniAfterMetersMultiTv = ((TextView)this.mHighwayViewMiniLayout.findViewById(1711866234));
        this.mMiniGoWhereMultiTv = ((TextView)this.mHighwayViewMiniLayout.findViewById(1711866236));
        this.mMiniDirectionTv = ((TextView)this.mHighwayViewMiniLayout.findViewById(1711866237));
        this.mMiniCurRoadNameTv = ((TextView)this.mHighwayViewMiniLayout.findViewById(1711866240));
        this.mMiniCurRoadDistTv = ((TextView)this.mHighwayViewMiniLayout.findViewById(1711866241));
        this.mMiniCurRoadDistWordTv = ((TextView)this.mHighwayViewMiniLayout.findViewById(1711866242));
        this.mHighwayViewMiniLayout.setVisibility(8);
      }
    }
  }
  
  private void initViews()
  {
    boolean bool = true;
    if (this.mRootViewGroup == null) {}
    do
    {
      return;
      this.mHighwayViewContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866526));
    } while (this.mHighwayViewContainer == null);
    this.mHighwayViewContainer.removeAllViews();
    if (1 == RGViewController.getInstance().getPreloadOrientation())
    {
      this.mCurOrientation = 1;
      this.mHighwayView = JarUtils.inflate((Activity)this.mContext, 1711472712, null);
      label74:
      if (this.mHighwayView == null) {
        break label520;
      }
      if (1 != RGViewController.getInstance().getPreloadOrientation()) {
        break label522;
      }
    }
    label520:
    label522:
    for (Object localObject = new FrameLayout.LayoutParams(-1, -2);; localObject = new FrameLayout.LayoutParams(-1, -1))
    {
      this.mHighwayViewContainer.addView(this.mHighwayView, (ViewGroup.LayoutParams)localObject);
      this.mHighwayViewContainer.requestLayout();
      this.mHighwayDirectionMode = this.mHighwayView.findViewById(1711866508);
      this.mTotalDistTV = ((TextView)this.mRootViewGroup.findViewById(1711866693));
      this.mArriveTimeTV = ((TextView)this.mRootViewGroup.findViewById(1711866694));
      this.mExitTurnIcon = ((ImageView)this.mRootViewGroup.findViewById(1711866400));
      this.mExitDirectionsPanel = this.mRootViewGroup.findViewById(1711866408);
      this.mGoWhereInfoMultiTV = ((TextView)this.mRootViewGroup.findViewById(1711866409));
      if (RGViewController.getInstance().getPreloadOrientation() == 2)
      {
        localObject = (LinearLayout.LayoutParams)this.mGoWhereInfoMultiTV.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).gravity = 1;
        ((LinearLayout.LayoutParams)localObject).width = ScreenUtil.getInstance().getGuidePanelWidth();
        this.mGoWhereInfoMultiTV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.mAfterMetersMultiTV = ((TextView)this.mRootViewGroup.findViewById(1711866509));
      this.mAfterLabelInfoTV = ((TextView)this.mRootViewGroup.findViewById(1711866510));
      this.mICCodeTV = ((TextView)this.mRootViewGroup.findViewById(1711866405));
      this.mDirectionTV = ((TextView)this.mRootViewGroup.findViewById(1711866511));
      if (this.mExitTurnIcon != null) {
        this.mExitTurnIcon.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (2 != BNavConfig.pRGLocateMode) {
              UserOPController.getInstance().add("3.8");
            }
          }
        });
      }
      if (this.mHighwayView != null) {
        this.mHighwayView.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            RGMMHighwayView.this.miniPanerCutAction(paramAnonymousView, paramAnonymousMotionEvent);
            return true;
          }
        });
      }
      if (1 == RGViewController.getInstance().getPreloadOrientation()) {
        this.mHighwayViewLayout = ((ViewGroup)this.mHighwayView.findViewById(1711866507));
      }
      this.mHighwayAlongMode = this.mHighwayView.findViewById(1711866512);
      this.mCurRoadNameTV = ((TextView)this.mHighwayView.findViewById(1711866514));
      this.mCurRoadRemainDistTV = ((TextView)this.mHighwayView.findViewById(1711866515));
      this.mCurRoadRemainDistWordTV = ((TextView)this.mHighwayView.findViewById(1711866516));
      if (RGViewController.getInstance().getPreloadOrientation() == 1)
      {
        if (RGHighwayModel.getInstance().getCurrentPanerMode() == 0) {
          bool = false;
        }
        showMiniPaner(bool);
      }
      updateDataByLastest();
      return;
      this.mCurOrientation = 2;
      this.mHighwayView = JarUtils.inflate((Activity)this.mContext, 1711472713, null);
      break label74;
      break;
    }
  }
  
  private void miniPanerCutAction(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (RGViewController.getInstance().getPreloadOrientation() == 1)
    {
      if (paramMotionEvent.getAction() != 0) {
        break label67;
      }
      if (RGHighwayModel.getInstance().getMiniPanerDisplayable())
      {
        this.mMiniPanerDownY = paramMotionEvent.getRawY();
        LogUtil.e(TAG, "mMiniPanerDownY = " + this.mMiniPanerDownY);
      }
    }
    label67:
    float f;
    do
    {
      do
      {
        return;
      } while ((paramMotionEvent.getAction() != 1) || (!RGHighwayModel.getInstance().getMiniPanerDisplayable()));
      f = paramMotionEvent.getRawY() - this.mMiniPanerDownY;
      LogUtil.e(TAG, "moveDis = " + f);
      if (f > 30.0F)
      {
        LogUtil.e(TAG, " pull-down paner, mAutoShowMiniPanerAble = false");
        showMiniPaner(false);
        RGHighwayModel.getInstance().setAutoShowMiniPanerAble(false);
        return;
      }
      if (f < -30.0F)
      {
        LogUtil.e(TAG, "pull-up paner");
        showMiniPaner(true);
        return;
      }
    } while (Math.abs(f) > 10.0F);
    if (!ismMiniPanelShowing()) {}
    for (;;)
    {
      showMiniPaner(bool);
      RGHighwayModel.getInstance().setAutoShowMiniPanerAble(false);
      LogUtil.e(TAG, "click paner, mAutoShowMiniPanerAble = false");
      return;
      bool = false;
    }
  }
  
  private void setMiniDirectionText(final String paramString)
  {
    if (this.mMiniGoWhereMultiTv != null) {
      this.mMiniGoWhereMultiTv.post(new Runnable()
      {
        public void run()
        {
          int i = RGMMHighwayView.this.getMiniDirectionWidth();
          RGMMHighwayView.this.mMiniGoWhereMultiTv.setMaxWidth(i);
          if ((!StringUtils.isEmpty(paramString)) && (paramString.contains(" ")))
          {
            RGMMHighwayView.this.mMiniGoWhereMultiTv.setText(RGMMHighwayView.this.subDirectionText(RGMMHighwayView.this.mMiniGoWhereMultiTv, i, paramString, 1));
            return;
          }
          RGMMHighwayView.this.mMiniGoWhereMultiTv.setText(paramString);
        }
      });
    }
  }
  
  private void showMiniPaner(boolean paramBoolean)
  {
    LogUtil.e(TAG, "showMiniPaner -> " + paramBoolean);
    if (paramBoolean)
    {
      initMiniPaner();
      if ((this.mHighwayViewLayout != null) && (this.mHighwayViewMiniLayout != null) && (this.mMiniCurRoadDistTv != null))
      {
        this.mHighwayViewLayout.setVisibility(8);
        this.mHighwayViewMiniLayout.setVisibility(0);
        RGMapModeViewController.getInstance().hideDeviceStateView();
        RGHighwayModel.getInstance().setCurrentPanerMode(1);
      }
    }
    for (;;)
    {
      RGViewController.getInstance().setMapDrawScreenRect();
      BNMapController.getInstance().setMapShowScreenRect();
      return;
      if ((this.mHighwayViewLayout != null) && (this.mHighwayViewMiniLayout != null))
      {
        this.mHighwayViewLayout.setVisibility(0);
        this.mHighwayViewMiniLayout.setVisibility(8);
        RGMapModeViewController.getInstance().showDeviceStateView();
        RGHighwayModel.getInstance().setCurrentPanerMode(0);
      }
    }
  }
  
  private String subDirectionText(TextView paramTextView, int paramInt1, String paramString, int paramInt2)
  {
    if (paramTextView == null) {}
    int i;
    do
    {
      do
      {
        return paramString;
      } while (UIUtils.isTextFullDisplay(paramTextView, paramInt1, paramString, paramInt2));
      i = paramString.lastIndexOf(" ");
    } while (i < 0);
    return subDirectionText(paramTextView, paramInt1, paramString.substring(0, i), paramInt2);
  }
  
  private void switchMiniPanelVisible()
  {
    if ((RGViewController.getInstance().getPreloadOrientation() == 1) && (RGHighwayModel.getInstance().isAutoShowMiniPanerAble()))
    {
      if (!RGHighwayModel.getInstance().getMiniPanerDisplayable()) {
        break label103;
      }
      if (!"BrowseMap".equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
        break label53;
      }
      LogUtil.e(TAG, "FsmState = BrowseMap miniPaner, don't show!");
    }
    label53:
    do
    {
      String str2;
      String str1;
      do
      {
        return;
        str2 = RGHighwayModel.getInstance().getFormatExitRemainDist();
        str1 = RGSimpleGuideModel.getInstance().getDistStart(str2);
        str2 = RGSimpleGuideModel.getInstance().getDistEnd(str2);
      } while ((str1 == null) || (str2 == null));
      RGMapModeViewController.getInstance().hideDeviceStateView();
    } while (ismMiniPanelShowing());
    showMiniPaner(true);
    return;
    label103:
    showMiniPaner(false);
  }
  
  private void updateExitCodeView()
  {
    if (this.mICCodeTV == null) {}
    do
    {
      String str;
      do
      {
        return;
        if (!RGHighwayModel.getInstance().hasExitCode())
        {
          this.mICCodeTV.setVisibility(8);
          return;
        }
        str = String.format(BNStyleManager.getString(1711669870), new Object[] { RGHighwayModel.getInstance().getExitCode() });
      } while (TextUtils.isEmpty(str));
      this.mICCodeTV.setVisibility(0);
      this.mICCodeTV.setText(str);
    } while (this.mDirectionTV == null);
    this.mDirectionTV.setVisibility(8);
  }
  
  public void hide()
  {
    super.hide();
    if (this.mHighwayViewContainer != null) {
      this.mHighwayViewContainer.setVisibility(4);
    }
  }
  
  public boolean ismMiniPanelShowing()
  {
    return (isVisibility()) && (this.mHighwayViewMiniLayout != null) && (this.mHighwayViewMiniLayout.getVisibility() == 0);
  }
  
  public void onSwitchBackground(boolean paramBoolean)
  {
    if ((isVisibility()) && (!paramBoolean)) {}
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    this.mHighwayViewMiniLayout = null;
    initViews();
    if ((RGViewController.getInstance().getPreloadOrientation() == 1) && (RGHighwayModel.getInstance().getMiniPanerDisplayable()))
    {
      initMiniPaner();
      if ((this.mMiniCurRoadDistTv != null) && (StringUtils.isEmpty(this.mMiniCurRoadDistTv.getText().toString()))) {
        updateDataByLastest();
      }
    }
  }
  
  public void resetHighwayPanel()
  {
    showMiniPaner(false);
    RGHighwayModel.getInstance().reset();
  }
  
  public void show()
  {
    super.show();
    updateDataByLastest();
    if (this.mHighwayViewContainer != null) {
      this.mHighwayViewContainer.setVisibility(0);
    }
  }
  
  public void updateData(Bundle paramBundle)
  {
    if ((RouteGuideFSM.getInstance().getCurrentEvent() != null) && (RouteGuideFSM.getInstance().getCurrentEvent().equals("收到偏航开始的消息"))) {}
    label86:
    label113:
    label147:
    label322:
    label327:
    label332:
    label338:
    do
    {
      String str1;
      String str2;
      do
      {
        do
        {
          return;
          this.mCurTurnIconType = RGHighwayModel.getInstance().getExitTurnIconType();
          str1 = RGHighwayModel.getInstance().getFormatExitRemainDist();
          paramBundle = RGSimpleGuideModel.getInstance().getDistStart(str1);
          str1 = RGSimpleGuideModel.getInstance().getDistEnd(str1);
          str2 = RGHighwayModel.getInstance().formatDirections();
          Object localObject;
          if (this.mHighwayAlongMode != null)
          {
            localObject = this.mHighwayAlongMode;
            if (str2 == null)
            {
              i = 0;
              ((View)localObject).setVisibility(i);
            }
          }
          else
          {
            if (this.mHighwayDirectionMode != null)
            {
              localObject = this.mHighwayDirectionMode;
              if (str2 != null) {
                break label322;
              }
              i = 8;
              ((View)localObject).setVisibility(i);
            }
            if (ismMiniPanelShowing())
            {
              if (this.mMiniDirectionMode != null)
              {
                localObject = this.mMiniDirectionMode;
                if (str2 != null) {
                  break label327;
                }
                i = 8;
                ((RelativeLayout)localObject).setVisibility(i);
              }
              if (this.mMiniAlongMode != null)
              {
                localObject = this.mMiniAlongMode;
                if (str2 != null) {
                  break label332;
                }
              }
            }
          }
          for (int i = 0;; i = 8)
          {
            ((LinearLayout)localObject).setVisibility(i);
            updateTotalRemainInfo();
            switchMiniPanelVisible();
            if (str2 != null) {
              break label338;
            }
            if (this.mCurRoadNameTV != null) {
              this.mCurRoadNameTV.setText(RGHighwayModel.getInstance().getCurRoadName());
            }
            if (this.mCurRoadRemainDistTV != null) {
              this.mCurRoadRemainDistTV.setText(paramBundle);
            }
            if (this.mCurRoadRemainDistWordTV != null) {
              this.mCurRoadRemainDistWordTV.setText(str1);
            }
            if ((RGViewController.getInstance().getPreloadOrientation() != 1) || (!RGHighwayModel.getInstance().getMiniPanerDisplayable())) {
              break;
            }
            initMiniPaner();
            if ((this.mMiniCurRoadNameTv == null) || (this.mMiniCurRoadDistTv == null) || (this.mMiniCurRoadDistWordTv == null)) {
              break;
            }
            this.mMiniCurRoadNameTv.setText(RGHighwayModel.getInstance().getCurRoadName());
            this.mMiniCurRoadDistTv.setText(paramBundle);
            this.mMiniCurRoadDistWordTv.setText(str1);
            return;
            i = 8;
            break label86;
            i = 0;
            break label113;
            i = 0;
            break label147;
          }
          if ((this.mAfterMetersMultiTV != null) && (this.mAfterLabelInfoTV != null) && (paramBundle != null) && (str1 != null))
          {
            this.mAfterMetersMultiTV.setText(paramBundle);
            this.mAfterLabelInfoTV.setText(str1 + "后");
          }
          if (RGViewController.getInstance().getPreloadOrientation() != 1) {
            break;
          }
          if ((!RGHighwayModel.getInstance().hasExitCode()) && (this.mDirectionTV != null)) {
            this.mDirectionTV.setVisibility(0);
          }
          if ((this.mGoWhereInfoMultiTV != null) && (str2 != null))
          {
            this.mGoWhereInfoMultiTV.setText(subDirectionText(this.mGoWhereInfoMultiTV, getGoWhereViewWidth(), str2, 1));
            this.mGoWhereInfoMultiTV.setVisibility(0);
          }
        } while (!RGHighwayModel.getInstance().getMiniPanerDisplayable());
        initMiniPaner();
      } while ((this.mMiniTurnIcon == null) || (this.mMiniGoWhereMultiTv == null) || (this.mMiniAfterMetersMultiTv == null) || (this.mMiniDirectionTv == null) || (paramBundle == null) || (str1 == null));
      this.mMiniAfterMetersMultiTv.setText(paramBundle + str1 + "后");
      setMiniDirectionText(str2);
      return;
      if (this.mDirectionTV != null) {
        this.mDirectionTV.setVisibility(8);
      }
      paramBundle = str2 + "  " + JarUtils.getResources().getString(1711669871);
      paramBundle = getSpannableStringBuilder(subDirectionText(this.mGoWhereInfoMultiTV, getGoWhereViewWidth(), paramBundle, 2));
    } while ((this.mGoWhereInfoMultiTV == null) || (paramBundle == null));
    this.mGoWhereInfoMultiTV.setMaxLines(2);
    this.mGoWhereInfoMultiTV.setText(paramBundle);
    this.mGoWhereInfoMultiTV.setVisibility(0);
  }
  
  public void updateDataByLastest()
  {
    updateData(null);
  }
  
  public void updateHighwayFsmSate(String paramString)
  {
    if ((paramString.equals("North2D")) || (paramString.equals("Car3D"))) {
      if ((RGViewController.getInstance().getPreloadOrientation() == 1) && (RGHighwayModel.getInstance().getMiniPanerDisplayable()) && (RGHighwayModel.getInstance().isAutoShowMiniPanerAble()))
      {
        showMiniPaner(true);
        LogUtil.e(TAG, "checked state --> " + paramString + " , showMiniPaner --> " + true);
      }
    }
    while (!paramString.equals("SimpleGuide")) {
      return;
    }
    RGHighwayModel.getInstance().setMiniPanerDisplayable(false);
  }
  
  public void updateTotalRemainInfo()
  {
    if ((this.mTotalDistTV == null) || (this.mArriveTimeTV == null)) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = RGSimpleGuideModel.getInstance().getTotalRemainDistString();
      str2 = RGSimpleGuideModel.getInstance().getArriveTimeString();
    } while ((this.mLastTotalRemainDistS.equals(str1)) && (this.mLastArriveTimeS.equals(str2)));
    this.mLastTotalRemainDistS = str1;
    this.mLastArriveTimeS = str2;
    this.mTotalDistTV.setText(str1);
    this.mArriveTimeTV.setText(str2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMHighwayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */