package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMRouteSearchView
  extends BNBaseView
{
  private static final int MSG_COUNT_DOWN_DELAY_MILLIS = 1000;
  private static final int MSG_WHAT_COUNT_DOWN = 1;
  private View mBankView;
  private final int[] mDrawableResId = { 1711407785, 1711407783, 1711407797, 1711407793, 1711407790, 1711407787 };
  private View mGasStationView;
  private final int[] mHLineViewId = { 1711866923, 1711866936 };
  private View mHotelView;
  private final int[] mImgViewId = { 1711866926, 1711866930, 1711866934, 1711866760, 1711866938, 1711866942 };
  private View mMenuClosePanel = null;
  private final int[] mNameResId = { 1711670075, 1711670077, 1711670078, 1711670073, 1711670076, 1711670074, 1711670079, 1711670080, 1711669887 };
  private View mRestaurantView;
  private ViewGroup mRouteSearchContainer;
  private ViewGroup mRouteSearchInnerPanel;
  private ViewGroup mRouteSearchPanel;
  private ViewGroup mRouteSearchView;
  private View mSpotsView;
  private final int[] mTextViewId = { 1711866927, 1711866931, 1711866935, 1711866761, 1711866939, 1711866943 };
  private View mToiletView;
  private TextView mTvTitle;
  private final int[] mVLineViewId = { 1711866928, 1711866932, 1711866940, 1711866944 };
  
  public RGMMRouteSearchView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private void initListener()
  {
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((RGMMRouteSearchView.this.mSubViewListener == null) || (paramAnonymousView == null)) {
          return;
        }
        if (paramAnonymousView == RGMMRouteSearchView.this.mRouteSearchPanel)
        {
          RGViewController.getInstance().hideRouteSearchView();
          return;
        }
        if (!RightHandResourcesProvider.isInternationalWithToast(RGMMRouteSearchView.this.mContext))
        {
          if (paramAnonymousView != RGMMRouteSearchView.this.mGasStationView) {
            break label87;
          }
          RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, "加油站");
        }
        for (;;)
        {
          com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsRouteSearchVisible = false;
          RGMMRouteSearchView.this.hide();
          return;
          label87:
          if (paramAnonymousView == RGMMRouteSearchView.this.mToiletView) {
            RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, "厕所");
          } else if (paramAnonymousView == RGMMRouteSearchView.this.mBankView) {
            RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, "银行");
          } else if (paramAnonymousView == RGMMRouteSearchView.this.mSpotsView) {
            RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, "景点");
          } else if (paramAnonymousView == RGMMRouteSearchView.this.mRestaurantView) {
            RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, "餐饮");
          } else if (paramAnonymousView == RGMMRouteSearchView.this.mHotelView) {
            RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, "酒店");
          }
        }
      }
    };
    this.mGasStationView.setOnClickListener(local1);
    this.mToiletView.setOnClickListener(local1);
    this.mBankView.setOnClickListener(local1);
    this.mSpotsView.setOnClickListener(local1);
    this.mRestaurantView.setOnClickListener(local1);
    this.mHotelView.setOnClickListener(local1);
    this.mRouteSearchPanel.setOnClickListener(local1);
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      return;
      this.mRouteSearchPanel = ((ViewGroup)this.mRootViewGroup.findViewById(1711866538));
      this.mRouteSearchContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866539));
      if (this.mRouteSearchContainer != null) {
        this.mRouteSearchContainer.removeAllViews();
      }
      this.mRouteSearchView = ((ViewGroup)JarUtils.inflate((Activity)this.mContext, 1711472736, null));
    } while ((this.mRouteSearchContainer == null) || (this.mRouteSearchView == null));
    this.mRouteSearchContainer.addView(this.mRouteSearchView);
    this.mRouteSearchInnerPanel = ((ViewGroup)this.mRouteSearchView.findViewById(1711866921));
    this.mTvTitle = ((TextView)this.mRouteSearchView.findViewById(1711866922));
    this.mGasStationView = this.mRouteSearchView.findViewById(1711866925);
    this.mToiletView = this.mRouteSearchView.findViewById(1711866933);
    this.mBankView = this.mRouteSearchView.findViewById(1711866929);
    this.mSpotsView = this.mRouteSearchView.findViewById(1711866759);
    this.mRestaurantView = this.mRouteSearchView.findViewById(1711866937);
    this.mHotelView = this.mRouteSearchView.findViewById(1711866941);
    this.mMenuClosePanel = this.mRouteSearchView.findViewById(1711866975);
  }
  
  public void hide()
  {
    super.hide();
    cancelAutoHide();
    Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_OUT, 0L, 300L);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        RGMMRouteSearchView.this.onHide();
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.mRouteSearchInnerPanel.startAnimation(localAnimation);
  }
  
  protected void hiedByTimeOut()
  {
    RGViewController.getInstance().hideRouteSearchView();
  }
  
  protected void onHide()
  {
    if (this.mRouteSearchInnerPanel != null) {
      this.mRouteSearchInnerPanel.setVisibility(8);
    }
    if (this.mRouteSearchPanel != null) {
      this.mRouteSearchPanel.setVisibility(8);
    }
    if (this.mRouteSearchContainer != null) {
      this.mRouteSearchContainer.setVisibility(8);
    }
  }
  
  public void show()
  {
    super.show();
    startAutoHide(10000);
    if (this.mRouteSearchContainer != null) {
      this.mRouteSearchContainer.setVisibility(0);
    }
    if (this.mRouteSearchPanel != null) {
      this.mRouteSearchPanel.setVisibility(0);
    }
    if (this.mRouteSearchInnerPanel != null)
    {
      Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_IN, 0L, 300L);
      this.mRouteSearchInnerPanel.startAnimation(localAnimation);
      this.mRouteSearchInnerPanel.setVisibility(0);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    Object localObject;
    if (this.mTvTitle != null)
    {
      this.mTvTitle.setTextColor(BNStyleManager.getColor(1711800793));
      localObject = BNStyleManager.getDrawable(1711407795);
      this.mTvTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    }
    if (this.mRouteSearchInnerPanel != null) {
      this.mRouteSearchInnerPanel.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mMenuClosePanel != null) {
      this.mMenuClosePanel.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mRouteSearchView != null)
    {
      int i = 0;
      while (i < this.mHLineViewId.length)
      {
        localObject = this.mRouteSearchView.findViewById(this.mHLineViewId[i]);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(BNStyleManager.getColor(1711800789));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mVLineViewId.length)
      {
        localObject = this.mRouteSearchView.findViewById(this.mVLineViewId[i]);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(BNStyleManager.getColor(1711800789));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mTextViewId.length)
      {
        localObject = (TextView)this.mRouteSearchView.findViewById(this.mTextViewId[i]);
        if (localObject != null)
        {
          ((TextView)localObject).setText(BNStyleManager.getString(this.mNameResId[i]));
          ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800793));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mImgViewId.length)
      {
        localObject = (ImageView)this.mRouteSearchView.findViewById(this.mImgViewId[i]);
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(BNStyleManager.getDrawable(this.mDrawableResId[i]));
        }
        i += 1;
      }
    }
    if (this.mGasStationView != null) {
      this.mGasStationView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mToiletView != null) {
      this.mToiletView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mBankView != null) {
      this.mBankView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mSpotsView != null) {
      this.mSpotsView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mRestaurantView != null) {
      this.mRestaurantView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mHotelView != null) {
      this.mHotelView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMRouteSearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */