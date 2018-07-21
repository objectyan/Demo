package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.adapter.RGRouteSortAdapter;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMRouteSortView
  extends BNBaseView
{
  private static final int[] ROUTE_SORTE_DIVIDER_H = { 1711867021 };
  private static final String TAG = RGMMRouteSortView.class.getSimpleName();
  private RGRouteSortAdapter mAdapter = null;
  private GridView mRouteSortGV = null;
  private TextView mSettingDefaultTV = null;
  private TextView mTitleTV = null;
  private View mView = null;
  private ViewGroup mViewContainer = null;
  private View mViewPanel = null;
  public int sPageFromType = 1;
  
  public RGMMRouteSortView(Context paramContext, ViewGroup paramViewGroup, View paramView1, View paramView2, int paramInt)
  {
    super(paramContext, paramViewGroup);
    this.mViewPanel = paramView1;
    if ((paramView2 != null) && ((paramView2 instanceof ViewGroup))) {
      this.mViewContainer = ((ViewGroup)paramView2);
    }
    this.sPageFromType = paramInt;
    initViews();
    initListener();
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  private void initListener()
  {
    if (this.mSettingDefaultTV != null) {
      this.mSettingDefaultTV.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UserOPController.getInstance().add("2.i.2", null, null, null);
          RGRouteSortController.getInstance().mIsShowDefaultSettingBtn = true;
          if (RGMMRouteSortView.this.mSettingDefaultTV != null) {
            RGMMRouteSortView.this.mSettingDefaultTV.setVisibility(8);
          }
          if (RGMMRouteSortView.this.mTitleTV != null) {}
          try
          {
            RGMMRouteSortView.this.mTitleTV.setText(JarUtils.getResources().getString(1711670351));
            if (RGMMRouteSortView.this.mAdapter != null) {
              RGMMRouteSortView.this.mAdapter.notifyDataSetChanged();
            }
            return;
          }
          catch (Exception paramAnonymousView)
          {
            for (;;) {}
          }
        }
      });
    }
    if (this.mViewPanel != null) {
      this.mViewPanel.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGMMRouteSortView.this.onClickCloseBtnOrMasking();
        }
      });
    }
  }
  
  private void initViews()
  {
    if ((this.mRootViewGroup == null) || (this.mContext == null)) {}
    for (;;)
    {
      return;
      if ((this.mViewPanel == null) || (this.mViewContainer == null)) {
        continue;
      }
      try
      {
        this.mView = JarUtils.inflate((Activity)this.mContext, 1711472748, null);
        if (this.mView == null) {
          continue;
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (localLayoutParams == null) {
          continue;
        }
        localLayoutParams.addRule(15);
        this.mViewContainer.addView(this.mView, localLayoutParams);
        this.mRouteSortGV = ((GridView)this.mView.findViewById(1711867022));
        this.mSettingDefaultTV = ((TextView)this.mView.findViewById(1711867020));
        this.mTitleTV = ((TextView)this.mView.findViewById(1711867019));
        if (this.mRouteSortGV == null) {
          continue;
        }
        if (this.mAdapter == null)
        {
          this.mAdapter = new RGRouteSortAdapter();
          this.mAdapter.setPageFromType(this.sPageFromType);
        }
        this.mRouteSortGV.setAdapter(this.mAdapter);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.mView = null;
        }
      }
    }
  }
  
  private void onClickCloseBtnOrMasking()
  {
    if (this.sPageFromType == 1) {
      if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn)
      {
        UserOPController.getInstance().add("2.i.1", "0", "2", null);
        RGRouteSortController.getInstance().onCloseAction();
      }
    }
    while (this.sPageFromType != 2) {
      for (;;)
      {
        if (this.mAdapter != null) {
          this.mAdapter.notifyDataSetChanged();
        }
        return;
        UserOPController.getInstance().add("2.i.3", "0", "2", null);
      }
    }
    if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
      UserOPController.getInstance().add("2.i.1", "0", "3", null);
    }
    for (;;)
    {
      RGViewController.getInstance().hideRouteSortView();
      break;
      UserOPController.getInstance().add("2.i.3", "0", "3", null);
    }
  }
  
  private void updateView()
  {
    if (this.sPageFromType == 1) {
      if (this.mSettingDefaultTV != null) {
        this.mSettingDefaultTV.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.mTitleTV != null) {}
      try
      {
        this.mTitleTV.setText(JarUtils.getResources().getString(1711670350));
        return;
      }
      catch (Exception localException) {}
      if ((this.sPageFromType == 2) && (this.mSettingDefaultTV != null)) {
        this.mSettingDefaultTV.setVisibility(8);
      }
    }
  }
  
  public void dispose()
  {
    if (this.sPageFromType == 2) {
      super.dispose();
    }
  }
  
  protected int getColor(int paramInt)
  {
    if (this.sPageFromType == 1) {
      return BNStyleManager.getColor(paramInt, true);
    }
    return super.getColor(paramInt);
  }
  
  protected Drawable getDrawable(int paramInt)
  {
    if (this.sPageFromType == 1) {
      return BNStyleManager.getDrawable(paramInt, true);
    }
    return super.getDrawable(paramInt);
  }
  
  public void hide()
  {
    super.hide();
    cancelAutoHide();
    if ((this.mViewPanel == null) || (this.mViewContainer == null) || (this.mView == null)) {
      return;
    }
    Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_OUT, 0L, 300L);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        RGMMRouteSortView.this.onHide();
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.mView.startAnimation(localAnimation);
  }
  
  protected void hiedByTimeOut()
  {
    RGViewController.getInstance().hideRouteSortView();
  }
  
  protected void onHide()
  {
    RGRouteSortController.getInstance().mIsShowDefaultSettingBtn = false;
    this.mViewPanel.setVisibility(8);
    this.mViewContainer.setVisibility(8);
    this.mView.setVisibility(8);
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  public void show()
  {
    super.show();
    startAutoHide(10000);
    if ((this.mViewPanel == null) || (this.mViewContainer == null) || (this.mView == null)) {
      return;
    }
    this.mViewPanel.setVisibility(0);
    this.mViewContainer.setVisibility(0);
    Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_IN, 0L, 300L);
    this.mView.startAnimation(localAnimation);
    this.mView.setVisibility(0);
    updateDataByLastest();
  }
  
  public void updateData(Bundle paramBundle)
  {
    updateView();
  }
  
  public void updateDataByLastest()
  {
    updateData(null);
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if ((this.sPageFromType == 1) && (!paramBoolean)) {}
    while (this.mView == null) {
      return;
    }
    this.mView.setBackgroundColor(getColor(1711800694));
    if (this.mTitleTV != null)
    {
      this.mTitleTV.setTextColor(getColor(1711800775));
      localObject = getDrawable(1711408038);
      this.mTitleTV.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    }
    Object localObject = ROUTE_SORTE_DIVIDER_H;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject[i];
      View localView = this.mView.findViewById(k);
      if (localView != null) {
        localView.setBackgroundColor(getColor(1711800789));
      }
      i += 1;
    }
    super.updateStyle(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMRouteSortView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */