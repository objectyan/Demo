package com.baidu.navisdk.ui.routeguide.toolbox.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.toolbox.RGToolboxConstant;
import com.baidu.navisdk.ui.routeguide.toolbox.present.BaseNavPresent;
import com.baidu.navisdk.ui.routeguide.toolbox.present.RGToolBoxPresent;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.CustomLinearScrollView;
import com.baidu.navisdk.ui.widget.CustomLinearScrollView.OnStatusChangeListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class RGToolBoxView
  implements IRGToolBoxView, CustomLinearScrollView.OnStatusChangeListener
{
  public static final int SETTING_ST_CLOSE = 2;
  public static final int SETTING_ST_OPEN = 1;
  private static final String TAG = "BNToolBoxView";
  public static final int TOPBAR_STATE_BROWSEMAP = 1;
  public static final int TOPBAR_STATE_NORMAL = 0;
  private final int closeColor = BNStyleManager.getColor(1711800741);
  private Activity mActivity;
  private TextView mArrivetime;
  private BNWorkerNormalTask<String, String> mAutoHideRunnable = new BNWorkerNormalTask("RGToolBoxView-autoHideTask", null)
  {
    protected String execute()
    {
      RGToolBoxView.this.closeToolBox();
      return null;
    }
  };
  public String mCarNum;
  private View mClearPoiView = null;
  private int mContainnerViewId;
  private TextView mCurStateTipsTv;
  private boolean mIsCurDay = true;
  private TextView mNoProgressLoadingView;
  private ImageView mOpenCloseIV;
  private View mOpenCloseLy;
  private TextView mOpenCloseText;
  private View mQuitDividerView;
  private ImageView mQuitImageView;
  private TextView mReRoutePlanTextView = null;
  private View mReRoutePlanWattingView = null;
  private TextView mRemainTimeTv;
  private View mResumeSwitchLy = null;
  private View mRootView;
  private ViewGroup mRootViewContainer;
  private CustomLinearScrollView mScrollView;
  private View mTimeAndDistLy;
  private BaseNavPresent mToolBoxPresent = null;
  private View mViewBottomPanel;
  private View mViewChange;
  private View mViewClear;
  private View mViewContinue;
  private View mViewContinue2;
  private View mViewExit;
  private SparseArray<View> mViewMap = new SparseArray();
  private View mViewSetting;
  private SparseArray<Integer> mViewStatus = new SparseArray();
  private final int openColor = BNStyleManager.getColor(1711800784);
  
  public RGToolBoxView(Activity paramActivity, ViewGroup paramViewGroup, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mContainnerViewId = paramInt;
    this.mRootViewContainer = ((ViewGroup)paramViewGroup.findViewById(paramInt));
    inflate();
    updateStyle(BNStyleManager.getDayStyle());
    initPresent();
    this.mToolBoxPresent.startInit();
  }
  
  private void addToContainner()
  {
    LogUtil.e("BNToolBoxView", "addToContainner");
    if (this.mRootView == null) {
      inflate();
    }
    this.mRootViewContainer.addView(this.mRootView);
    if (RGViewController.getInstance().getPreloadOrientation() == 1) {
      this.mRootViewContainer.setPadding(0, 0, 0, 0);
    }
    for (;;)
    {
      this.mRootViewContainer.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((paramAnonymousMotionEvent.getAction() == 0) && (RGToolBoxView.this.mScrollView != null) && (RGToolBoxView.this.mScrollView.getCurStatus() == 0))
          {
            RGToolBoxView.this.closeToolBox();
            return true;
          }
          return false;
        }
      });
      if (this.mRootView.getVisibility() != 0) {
        break;
      }
      this.mRootViewContainer.setVisibility(0);
      return;
      this.mRootViewContainer.setPadding(RGViewController.getInstance().getmRootViewHeight() / 4, 0, 0, 0);
    }
    this.mRootViewContainer.setVisibility(8);
  }
  
  private int getColor(int paramInt)
  {
    return BNStyleManager.getColor(paramInt, this.mIsCurDay);
  }
  
  private Drawable getDrawable(int paramInt)
  {
    return BNStyleManager.getDrawable(paramInt, this.mIsCurDay);
  }
  
  private boolean getIsTrueCurDay(boolean paramBoolean)
  {
    if ((this.mViewMap != null) && (this.mViewMap.size() > 0) && (this.mViewMap.get(0) != null))
    {
      localObject = (View)this.mViewMap.get(0);
      if ((localObject instanceof TextView))
      {
        int i = ((TextView)localObject).getCurrentTextColor();
        if (JarUtils.getResources() != null)
        {
          if (i != JarUtils.getResources().getColor(1711800793)) {
            break label131;
          }
          bool = true;
          this.mIsCurDay = bool;
        }
      }
    }
    Object localObject = new StringBuilder().append("getIsTrueCurDay mIsCurDay");
    if (paramBoolean == this.mIsCurDay) {}
    for (boolean bool = true;; bool = false)
    {
      LogUtil.e("BNToolBoxView", bool);
      if (paramBoolean != this.mIsCurDay) {
        break label141;
      }
      return true;
      label131:
      bool = false;
      break;
    }
    label141:
    return false;
  }
  
  private void initPresent()
  {
    this.mToolBoxPresent = new RGToolBoxPresent(this);
  }
  
  private void rootViewFadeInAnim()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.mRootViewContainer != null))
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.mRootViewContainer, "backgroundColor", new int[] { this.closeColor, this.openColor });
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.start();
    }
  }
  
  private void rootViewFadeOutAnim()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.mRootViewContainer != null))
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.mRootViewContainer, "backgroundColor", new int[] { this.openColor, this.closeColor });
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.start();
    }
  }
  
  public void closeToolBox()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mScrollView != null)
    {
      bool1 = bool2;
      if (isOpenStatus())
      {
        bool1 = this.mScrollView.gotoBottom();
        rootViewFadeOutAnim();
      }
    }
    LogUtil.e("BNToolBoxView", "closeToolBox result :" + bool1);
  }
  
  public void closeToolBox(boolean paramBoolean)
  {
    LogUtil.e("BNToolBoxView", "closeToolBox isNeedAnim:" + paramBoolean);
    if ((this.mScrollView != null) && (isOpenStatus()))
    {
      this.mScrollView.gotoBottom();
      if (paramBoolean) {
        rootViewFadeOutAnim();
      }
    }
  }
  
  public Context getContext()
  {
    if (this.mActivity != null) {
      return this.mActivity.getApplicationContext();
    }
    LogUtil.e("BNToolBoxView", "getContext activity is null");
    return null;
  }
  
  public RGToolBoxPresent getPresent()
  {
    return (RGToolBoxPresent)this.mToolBoxPresent;
  }
  
  public void hideLoadingViewHasProgress()
  {
    LogUtil.e("BNToolBoxView", "hideLoadingViewHasProgress");
    this.mReRoutePlanWattingView.setVisibility(8);
    this.mViewBottomPanel.setVisibility(0);
    this.mScrollView.setScrollSupport(true);
  }
  
  public void hideLoadingViewNoProgress()
  {
    LogUtil.e("BNToolBoxView", "hideLoadingViewNoProgress");
    this.mNoProgressLoadingView.setVisibility(8);
    this.mRemainTimeTv.setVisibility(0);
    this.mArrivetime.setVisibility(0);
    this.mScrollView.setScrollSupport(true);
    this.mOpenCloseLy.setEnabled(true);
    this.mTimeAndDistLy.setEnabled(true);
    this.mOpenCloseLy.setAlpha(1.0F);
  }
  
  public void hideToolBox()
  {
    LogUtil.e("BNToolBoxView", "hideToolBox :");
    if (this.mRootView != null) {
      this.mRootView.setVisibility(8);
    }
    for (;;)
    {
      if (this.mRootViewContainer != null) {
        this.mRootViewContainer.setVisibility(8);
      }
      BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
      return;
      LogUtil.e("BNToolBoxView", "showToolBox error");
    }
  }
  
  public View inflate()
  {
    if (this.mRootView != null) {
      return this.mRootView;
    }
    this.mRootView = JarUtils.inflate(this.mActivity, 1711472725, null);
    if (this.mRootView == null)
    {
      LogUtil.e("BNToolBoxView", "inflate fail mRootView null");
      return null;
    }
    this.mScrollView = ((CustomLinearScrollView)this.mRootView.findViewById(1711866657));
    this.mScrollView.setInitScrollStatus(1);
    this.mScrollView.setOnStatusChangeListener(this);
    this.mNoProgressLoadingView = ((TextView)this.mRootView.findViewById(1711866666));
    this.mTimeAndDistLy = this.mRootView.findViewById(1711866665);
    this.mRemainTimeTv = ((TextView)this.mRootView.findViewById(1711866667));
    this.mArrivetime = ((TextView)this.mRootView.findViewById(1711866668));
    this.mCurStateTipsTv = ((TextView)this.mRootView.findViewById(1711866669));
    int i = 0;
    while (i < RGToolboxConstant.VIEW_CLICK_IDS.length)
    {
      this.mViewMap.put(i, this.mRootView.findViewById(RGToolboxConstant.VIEW_CLICK_IDS[i]));
      i += 1;
    }
    this.mOpenCloseLy = ((View)this.mViewMap.get(9));
    this.mOpenCloseText = ((TextView)this.mRootView.findViewById(1711866673));
    this.mOpenCloseIV = ((ImageView)this.mRootView.findViewById(1711866672));
    this.mQuitImageView = ((ImageView)this.mRootView.findViewById(1711866662));
    this.mQuitDividerView = this.mRootView.findViewById(1711866664);
    this.mReRoutePlanWattingView = this.mRootView.findViewById(1711866680);
    this.mReRoutePlanTextView = ((TextView)this.mRootView.findViewById(1711866946));
    this.mReRoutePlanWattingView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    int[] arrayOfInt = RGToolboxConstant.CLICK_ViewIndex;
    int j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      final int k = arrayOfInt[i];
      ((View)this.mViewMap.get(k)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGToolBoxView.this.mToolBoxPresent.onClick(paramAnonymousView, k);
        }
      });
      i += 1;
    }
    this.mViewExit = this.mRootView.findViewById(1711866661);
    this.mViewContinue = this.mRootView.findViewById(1711866669);
    this.mViewSetting = this.mRootView.findViewById(1711866671);
    this.mViewContinue2 = this.mRootView.findViewById(1711866676);
    this.mViewChange = this.mRootView.findViewById(1711866678);
    this.mViewClear = this.mRootView.findViewById(1711866679);
    this.mViewBottomPanel = this.mRootView.findViewById(1711866660);
    return this.mRootView;
  }
  
  public boolean isLastScrollEvent()
  {
    if (this.mScrollView != null) {
      return this.mScrollView.mLastEventIsScroll;
    }
    return false;
  }
  
  public boolean isOpenStatus()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mScrollView != null)
    {
      bool1 = bool2;
      if (this.mScrollView.getCurStatus() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isToolboxScrolling()
  {
    if (this.mScrollView != null) {
      return this.mScrollView.isScrolling();
    }
    return false;
  }
  
  public void onDestroy()
  {
    LogUtil.e("BNToolBoxView", "onDestroy :");
    this.mViewMap.clear();
    this.mActivity = null;
    this.mRemainTimeTv = null;
    this.mArrivetime = null;
    this.mCurStateTipsTv = null;
    this.mScrollView = null;
  }
  
  public void onOrientationChange(ViewGroup paramViewGroup, int paramInt)
  {
    LogUtil.e("BNToolBoxView", "onOrientationChange");
    this.mRootViewContainer.removeAllViews();
    this.mRootViewContainer = ((ViewGroup)paramViewGroup.findViewById(1711866531));
    addToContainner();
    if (isOpenStatus()) {
      this.mRootViewContainer.setBackgroundColor(this.openColor);
    }
  }
  
  public void onProgressChange(int paramInt)
  {
    LogUtil.e("BNToolBoxView", "onProgressChange : " + paramInt);
    View localView = (View)this.mViewMap.get(8);
    float f = paramInt / 100.0F;
    if (localView != null)
    {
      localView.setAlpha(f);
      if (paramInt >= 10) {
        break label130;
      }
      localView.setVisibility(4);
    }
    label130:
    do
    {
      for (;;)
      {
        if (this.mRootViewContainer != null)
        {
          int i = (int)(0.5F * (1.0F - f) * 255.0F);
          int j = (int)Math.pow(16.0D, 6.0D);
          this.mRootViewContainer.setBackgroundColor(i * j);
          if (paramInt <= 98) {
            break;
          }
          this.mRootViewContainer.setBackgroundColor(this.closeColor);
        }
        return;
        if (paramInt > 10) {
          localView.setVisibility(0);
        }
      }
    } while (paramInt >= 2);
    this.mRootViewContainer.setBackgroundColor(this.openColor);
  }
  
  public void onSizeChanged()
  {
    LogUtil.e("BNToolBoxView", "onSizeChanged");
    if (RGViewController.getInstance().getPreloadOrientation() != 1)
    {
      this.mRootViewContainer.setPadding(RGViewController.getInstance().getmRootViewHeight() / 4, 0, 0, 0);
      return;
    }
    this.mRootViewContainer.setPadding(0, 0, 0, 0);
  }
  
  public void onStatusChange(int paramInt)
  {
    LogUtil.e("BNToolBoxView", "onStatusChange :" + paramInt);
    if (this.mViewMap.size() < 1) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.mQuitDividerView != null) {
        this.mQuitDividerView.setVisibility(4);
      }
      if (this.mOpenCloseText != null) {
        this.mOpenCloseText.setText("收起");
      }
      if (this.mOpenCloseIV != null) {
        this.mOpenCloseIV.setImageDrawable(getDrawable(1711407879));
      }
      this.mToolBoxPresent.onTopStatus();
      BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mAutoHideRunnable, new BNWorkerConfig(2, 0), 10000L);
      return;
    }
    if (this.mQuitDividerView != null) {
      this.mQuitDividerView.setVisibility(0);
    }
    if (this.mOpenCloseText != null) {
      this.mOpenCloseText.setText("更多");
    }
    if (this.mOpenCloseIV != null) {
      this.mOpenCloseIV.setImageDrawable(getDrawable(1711407881));
    }
    BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
  }
  
  public void openToolBox()
  {
    boolean bool = false;
    if (this.mScrollView != null)
    {
      bool = this.mScrollView.gotoTop();
      rootViewFadeInAnim();
    }
    LogUtil.e("BNToolBoxView", "openToolBox result :" + bool);
  }
  
  public void setCurStateTips(String paramString)
  {
    LogUtil.e("BNToolBoxView", "setCurStateTips tips:" + paramString);
    this.mCurStateTipsTv.setText(paramString);
  }
  
  public void setTopBarState(int paramInt)
  {
    LogUtil.e("BNToolBoxView", "setTopBarState : " + paramInt);
    if (paramInt == 1)
    {
      if (this.mTimeAndDistLy != null) {
        this.mTimeAndDistLy.setVisibility(8);
      }
      if (this.mCurStateTipsTv != null) {
        this.mCurStateTipsTv.setVisibility(0);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      showResumeSwitchView(false);
      if (this.mTimeAndDistLy != null) {
        this.mTimeAndDistLy.setVisibility(0);
      }
    } while (this.mCurStateTipsTv == null);
    this.mCurStateTipsTv.setVisibility(8);
  }
  
  public void showClearPoiView(boolean paramBoolean)
  {
    int j = 8;
    boolean bool = false;
    LogUtil.e("BNToolBoxView", "showClearPoiView : " + paramBoolean);
    if (this.mClearPoiView == null)
    {
      if (!paramBoolean) {
        return;
      }
      this.mClearPoiView = this.mRootView.findViewById(1711866679);
    }
    Object localObject;
    int i;
    if (this.mViewBottomPanel != null)
    {
      localObject = this.mViewBottomPanel;
      if (paramBoolean)
      {
        i = 8;
        ((View)localObject).setVisibility(i);
      }
    }
    else
    {
      localObject = this.mClearPoiView;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.mScrollView;
      if (!paramBoolean) {
        break label132;
      }
    }
    label132:
    for (paramBoolean = bool;; paramBoolean = true)
    {
      ((CustomLinearScrollView)localObject).setScrollSupport(paramBoolean);
      closeToolBox();
      return;
      i = 0;
      break;
    }
  }
  
  public void showLoadingViewHasProgress(String paramString)
  {
    LogUtil.e("BNToolBoxView", "showLoadingViewHasProgress");
    this.mReRoutePlanWattingView.setVisibility(0);
    this.mViewBottomPanel.setVisibility(8);
    this.mReRoutePlanTextView.setText(paramString);
    this.mScrollView.setScrollSupport(false);
    closeToolBox(false);
  }
  
  public void showLoadingViewNoProgress(String paramString)
  {
    LogUtil.e("BNToolBoxView", "showLoadingViewNoProgress");
    this.mNoProgressLoadingView.setText(paramString);
    this.mRemainTimeTv.setVisibility(8);
    this.mArrivetime.setVisibility(8);
    this.mNoProgressLoadingView.setVisibility(0);
    this.mScrollView.setScrollSupport(false);
    this.mOpenCloseLy.setEnabled(false);
    this.mTimeAndDistLy.setEnabled(false);
    this.mOpenCloseLy.setAlpha(0.5F);
    closeToolBox();
  }
  
  public void showResumeSwitchView(boolean paramBoolean)
  {
    int j = 8;
    boolean bool = false;
    LogUtil.e("BNToolBoxView", "showResumeSwitchView : " + paramBoolean);
    if (this.mResumeSwitchLy == null)
    {
      if (!paramBoolean) {
        return;
      }
      this.mResumeSwitchLy = this.mRootView.findViewById(1711866675);
    }
    Object localObject;
    int i;
    if (this.mViewBottomPanel != null)
    {
      localObject = this.mViewBottomPanel;
      if (paramBoolean)
      {
        i = 8;
        ((View)localObject).setVisibility(i);
      }
    }
    else
    {
      localObject = this.mResumeSwitchLy;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.mScrollView;
      if (!paramBoolean) {
        break label128;
      }
    }
    label128:
    for (paramBoolean = bool;; paramBoolean = true)
    {
      ((CustomLinearScrollView)localObject).setScrollSupport(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void showToolBox()
  {
    LogUtil.e("BNToolBoxView", "showToolBox :");
    if (this.mRootViewContainer.getChildCount() == 0) {
      addToContainner();
    }
    updateStyle(BNStyleManager.getDayStyle());
    if (this.mRootView != null) {
      this.mRootView.setVisibility(0);
    }
    if (this.mRootViewContainer != null) {
      this.mRootViewContainer.setVisibility(0);
    }
  }
  
  public void switchToolBarMode(int paramInt) {}
  
  public void updateArriveTime(String paramString)
  {
    LogUtil.e("BNToolBoxView", "updateArriveTime:" + paramString);
    if (this.mArrivetime != null) {
      this.mArrivetime.setText(paramString);
    }
  }
  
  public void updateRemainTimeAndDist(String paramString)
  {
    LogUtil.e("BNToolBoxView", "updateRemainTimeAndDist remainTime:" + paramString);
    if (this.mRemainTimeTv != null) {
      this.mRemainTimeTv.setText(paramString);
    }
  }
  
  public void updateSettingStatus(int paramInt1, int paramInt2)
  {
    LogUtil.e("BNToolBoxView", "updateSettingStatus key=" + paramInt1 + " value = " + paramInt2);
    this.mViewStatus.put(paramInt1, Integer.valueOf(paramInt2));
    int i = -1;
    Drawable localDrawable = null;
    String str = "";
    switch (paramInt1)
    {
    default: 
      paramInt2 = i;
    }
    for (;;)
    {
      TextView localTextView = (TextView)this.mViewMap.get(paramInt1);
      if (localTextView != null)
      {
        localTextView.setText(str);
        localTextView.setTextColor(paramInt2);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      }
      return;
      i = BNStyleManager.getColor(1711800685, this.mIsCurDay);
      if (paramInt2 == 1)
      {
        localDrawable = getDrawable(1711407874);
        str = BNStyleManager.getString(1711670072);
        paramInt2 = i;
      }
      else
      {
        localDrawable = getDrawable(1711407889);
        str = BNStyleManager.getString(1711670071);
        paramInt2 = i;
        continue;
        str = "导航声音";
        if (paramInt2 == 1)
        {
          paramInt2 = getColor(1711800793);
          localDrawable = getDrawable(1711407897);
        }
        else
        {
          paramInt2 = getColor(1711800685);
          localDrawable = getDrawable(1711407899);
          continue;
          i = getColor(1711800685);
          if (paramInt2 == 1)
          {
            localDrawable = getDrawable(1711407878);
            str = "全览小窗";
            paramInt2 = i;
          }
          else
          {
            localDrawable = getDrawable(1711407873);
            str = "路况条";
            paramInt2 = i;
            continue;
            if (paramInt2 == 1)
            {
              paramInt2 = getColor(1711800685);
              localDrawable = getDrawable(1711407877);
              str = this.mCarNum;
            }
            else
            {
              paramInt2 = getColor(1711800793);
              localDrawable = getDrawable(1711407875);
              str = "车牌限行";
            }
          }
        }
      }
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    if (getIsTrueCurDay(paramBoolean)) {
      return;
    }
    this.mIsCurDay = paramBoolean;
    if (this.mOpenCloseIV != null)
    {
      if (this.mScrollView.getCurStatus() == 0) {
        this.mOpenCloseIV.setImageDrawable(getDrawable(1711407879));
      }
    }
    else
    {
      if (this.mQuitImageView != null) {
        this.mQuitImageView.setImageDrawable(getDrawable(1711407883));
      }
      if (this.mReRoutePlanWattingView != null) {
        this.mReRoutePlanWattingView.setBackgroundColor(getColor(1711800694));
      }
      j = RGToolboxConstant.VIEW_SETTINGS_ITEM.length;
      i = 0;
      label94:
      if (i >= j) {
        break label427;
      }
      localObject1 = (View)this.mViewMap.get(RGToolboxConstant.VIEW_SETTINGS_ITEM[i]);
      ((View)localObject1).setBackgroundDrawable(getDrawable(1711407444));
      ((View)localObject1).setPadding(0, ScreenUtil.getInstance().dip2px(16), 0, 0);
      switch (i)
      {
      }
    }
    int k;
    Object localObject2;
    for (;;)
    {
      i += 1;
      break label94;
      this.mOpenCloseIV.setImageDrawable(getDrawable(1711407881));
      break;
      k = getColor(1711800793);
      localObject2 = getDrawable(1711407892);
      ((TextView)localObject1).setTextColor(k);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject2, null, null);
      continue;
      k = getColor(1711800793);
      localObject2 = getDrawable(1711407900);
      ((TextView)localObject1).setTextColor(k);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject2, null, null);
      continue;
      k = getColor(1711800793);
      localObject2 = getDrawable(1711407895);
      ((TextView)localObject1).setTextColor(k);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject2, null, null);
      continue;
      k = getColor(1711800793);
      localObject2 = getDrawable(1711407890);
      ((TextView)localObject1).setTextColor(k);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject2, null, null);
      continue;
      localObject1 = (Integer)this.mViewStatus.get(RGToolboxConstant.VIEW_SETTINGS_ITEM[i]);
      if (localObject1 != null) {
        updateSettingStatus(RGToolboxConstant.VIEW_SETTINGS_ITEM[i], ((Integer)localObject1).intValue());
      }
    }
    label427:
    Object localObject1 = (View)this.mViewMap.get(14);
    if ((localObject1 != null) && ((localObject1 instanceof ImageView))) {
      ((ImageView)localObject1).setImageDrawable(getDrawable(1711407994));
    }
    localObject1 = (ProgressBar)this.mRootView.findViewById(1711866945);
    if (localObject1 != null)
    {
      localObject2 = getDrawable(1711407432);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      ((ProgressBar)localObject1).setIndeterminateDrawable((Drawable)localObject2);
    }
    localObject1 = RGToolboxConstant.VIEW_TEXT_A;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      k = localObject1[i];
      localObject2 = (TextView)this.mRootView.findViewById(k);
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(getColor(1711800791));
      }
      i += 1;
    }
    localObject1 = RGToolboxConstant.VIEW_TEXT_B;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      k = localObject1[i];
      localObject2 = (TextView)this.mRootView.findViewById(k);
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(getColor(1711800793));
      }
      i += 1;
    }
    localObject1 = RGToolboxConstant.VIEW_TEXT_B_TITLE;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      k = localObject1[i];
      localObject2 = (TextView)this.mRootView.findViewById(k);
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(getColor(1711800795));
      }
      i += 1;
    }
    localObject1 = RGToolboxConstant.VIEW_TEXT_B_SINGLE;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      k = localObject1[i];
      localObject2 = (TextView)this.mRootView.findViewById(k);
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(getColor(1711800797));
      }
      i += 1;
    }
    localObject1 = RGToolboxConstant.VIEW_BG_ID;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      k = localObject1[i];
      localObject2 = this.mRootView.findViewById(k);
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundColor(getColor(1711800694));
      }
      i += 1;
    }
    localObject1 = RGToolboxConstant.DIVIDER_H;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      k = localObject1[i];
      localObject2 = this.mRootView.findViewById(k);
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundColor(getColor(1711800785));
      }
      i += 1;
    }
    localObject1 = RGToolboxConstant.DIVIDER_V;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      k = localObject1[i];
      localObject2 = this.mRootView.findViewById(k);
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundColor(getColor(1711800787));
      }
      i += 1;
    }
    this.mViewExit.setBackgroundDrawable(getDrawable(1711407127));
    this.mViewContinue.setBackgroundDrawable(getDrawable(1711407127));
    this.mViewContinue2.setBackgroundDrawable(getDrawable(1711407127));
    this.mViewSetting.setBackgroundDrawable(getDrawable(1711407127));
    this.mViewChange.setBackgroundDrawable(getDrawable(1711407127));
    this.mViewClear.setBackgroundDrawable(getDrawable(1711407127));
  }
  
  public void updateSubListener(OnRGSubViewListener paramOnRGSubViewListener)
  {
    this.mToolBoxPresent.setOnSubViewClickListener(paramOnRGSubViewListener);
  }
  
  public void updateUIForStartNav()
  {
    if (this.mToolBoxPresent != null) {
      ((RGToolBoxPresent)this.mToolBoxPresent).updateToolBoxItemState(7);
    }
  }
  
  public static abstract interface LoadingCallback
  {
    public abstract void onQuitClick();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/toolbox/view/RGToolBoxView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */