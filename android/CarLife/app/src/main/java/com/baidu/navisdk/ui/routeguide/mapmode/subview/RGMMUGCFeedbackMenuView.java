package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMUGCFeedbackMenuView
  extends BNBaseView
{
  private int[] hDivider = { 1711865998, 1711866002, 1711866006, 1711866010, 1711866014 };
  private Button mMenuCloseButton = null;
  private View mMenuClosePanel = null;
  private View mMenuContentPanel = null;
  private ViewGroup mMenuViewContainer = null;
  private View mMenuViewLandscape = null;
  private View mMenuViewPanel = null;
  private View mMenuViewPortrait = null;
  private View.OnClickListener mOnClickListener = null;
  private View mPartTransBground = null;
  private View mRouteAddedItemView = null;
  private View mRouteBadItemView = null;
  private View mRouteBlockItemView = null;
  private int[] mTextViewId = { 1711866968, 1711866970, 1711866972, 1711866974, 1711866781 };
  private View mTraficFlagErrorItemView = null;
  
  public RGMMUGCFeedbackMenuView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    initViewsSetting();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private void initListener()
  {
    initOnClickListener();
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
    for (;;)
    {
      if (this.mRouteBlockItemView != null) {
        this.mRouteBlockItemView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mTraficFlagErrorItemView != null) {
        this.mTraficFlagErrorItemView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mRouteBadItemView != null) {
        this.mRouteBadItemView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mRouteAddedItemView != null) {
        this.mRouteAddedItemView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mMenuCloseButton != null) {
        this.mMenuCloseButton.setOnClickListener(this.mOnClickListener);
      }
      return;
      if (this.mMenuViewContainer != null) {
        this.mMenuViewContainer.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
      }
    }
  }
  
  private void initOnClickListener()
  {
    this.mOnClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((RGMMUGCFeedbackMenuView.this.mMenuCloseButton != null) && (RGMMUGCFeedbackMenuView.this.mMenuCloseButton == paramAnonymousView)) {
          if (RGMMUGCFeedbackMenuView.this.mSubViewListener != null) {
            RGMMUGCFeedbackMenuView.this.mSubViewListener.onUGCMenuAction();
          }
        }
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((RGMMUGCFeedbackMenuView.this.mRouteBlockItemView == null) || (RGMMUGCFeedbackMenuView.this.mRouteBlockItemView != paramAnonymousView)) {
                  break;
                }
              } while (RGMMUGCFeedbackMenuView.this.mSubViewListener == null);
              RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 0, 0, null);
              return;
              if ((RGMMUGCFeedbackMenuView.this.mTraficFlagErrorItemView == null) || (RGMMUGCFeedbackMenuView.this.mTraficFlagErrorItemView != paramAnonymousView)) {
                break;
              }
            } while (RGMMUGCFeedbackMenuView.this.mSubViewListener == null);
            RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 1, 0, null);
            return;
            if ((RGMMUGCFeedbackMenuView.this.mRouteBadItemView == null) || (RGMMUGCFeedbackMenuView.this.mRouteBadItemView != paramAnonymousView)) {
              break;
            }
          } while (RGMMUGCFeedbackMenuView.this.mSubViewListener == null);
          RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 2, 0, null);
          return;
        } while ((RGMMUGCFeedbackMenuView.this.mRouteAddedItemView == null) || (RGMMUGCFeedbackMenuView.this.mRouteAddedItemView != paramAnonymousView) || (RGMMUGCFeedbackMenuView.this.mSubViewListener == null));
        RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 3, 0, null);
      }
    };
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    for (;;)
    {
      return;
      this.mMenuViewPanel = this.mRootViewGroup.findViewById(1711866534);
      this.mMenuViewContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866535));
      if (this.mMenuViewContainer != null) {
        this.mMenuViewContainer.removeAllViews();
      }
      if (1 == RGViewController.getInstance().getOrientation())
      {
        this.mCurOrientation = 1;
        if (this.mMenuViewPortrait == null) {
          this.mMenuViewPortrait = JarUtils.inflate((Activity)this.mContext, 1711472742, null);
        }
      }
      for (View localView = this.mMenuViewPortrait; (this.mMenuViewContainer != null) && (localView != null); localView = this.mMenuViewLandscape)
      {
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mMenuViewContainer.addView(localView, localLayoutParams);
        this.mPartTransBground = this.mRootViewGroup.findViewById(1711866964);
        this.mMenuContentPanel = this.mRootViewGroup.findViewById(1711866966);
        this.mRouteBlockItemView = this.mRootViewGroup.findViewById(1711866967);
        this.mTraficFlagErrorItemView = this.mRootViewGroup.findViewById(1711866969);
        this.mRouteBadItemView = this.mRootViewGroup.findViewById(1711866971);
        this.mRouteAddedItemView = this.mRootViewGroup.findViewById(1711866973);
        this.mMenuCloseButton = ((Button)this.mRootViewGroup.findViewById(1711866976));
        this.mMenuClosePanel = this.mRootViewGroup.findViewById(1711866975);
        return;
        this.mCurOrientation = 2;
        if (this.mMenuViewLandscape == null) {
          this.mMenuViewLandscape = JarUtils.inflate((Activity)this.mContext, 1711472743, null);
        }
      }
    }
  }
  
  private void initViewsSetting()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.mPartTransBground.setAlpha(0.7F);
    }
  }
  
  public void hide()
  {
    super.hide();
    if (this.mMenuViewContainer != null) {
      this.mMenuViewContainer.setVisibility(8);
    }
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(8);
    }
  }
  
  public void show()
  {
    super.show();
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(0);
    }
    if (this.mMenuViewContainer != null)
    {
      Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_IN, 0L, 300L);
      this.mMenuViewContainer.startAnimation(localAnimation);
      this.mMenuViewContainer.setVisibility(0);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.mMenuContentPanel != null) {
      this.mMenuContentPanel.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mMenuClosePanel == null) {
      this.mMenuClosePanel = this.mRootViewGroup.findViewById(1711866975);
    }
    if (this.mMenuCloseButton == null) {
      this.mMenuCloseButton = ((Button)this.mRootViewGroup.findViewById(1711866976));
    }
    if (this.mMenuClosePanel != null) {
      this.mMenuClosePanel.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mRootViewGroup != null)
    {
      int i = 0;
      Object localObject;
      while (i < this.mTextViewId.length)
      {
        localObject = (TextView)this.mRootViewGroup.findViewById(this.mTextViewId[i]);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800674));
        }
        i += 1;
      }
      i = 0;
      while (i < this.hDivider.length)
      {
        localObject = this.mRootViewGroup.findViewById(this.hDivider[i]);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(BNStyleManager.getColor(1711800690));
        }
        i += 1;
      }
    }
    if (this.mMenuCloseButton != null) {
      this.mMenuCloseButton.setBackgroundDrawable(BNStyleManager.getDrawable(1711407148));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMUGCFeedbackMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */