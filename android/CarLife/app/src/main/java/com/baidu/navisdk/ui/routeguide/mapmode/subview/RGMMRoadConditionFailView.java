package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel.OnCountDownListener;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class RGMMRoadConditionFailView
  extends BNBaseView
{
  private static String TAG = RGMMRoadConditionFailView.class.getName();
  private View bgView;
  private View dividerView;
  private Handler mHandler = null;
  private BNWorkerNormalTask mHideTask = new BNWorkerNormalTask("mHideTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
      RGViewController.getInstance().requestShowExpendView(3, false);
      return null;
    }
  };
  private ViewGroup mRoadConditionFailContainer = null;
  private TextView mRoadConditionFailKnown;
  private TextView mRoadConditionFailTips;
  private View mRoadConditionFailView = null;
  
  public RGMMRoadConditionFailView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private void initListener()
  {
    if (this.mRoadConditionFailKnown != null) {
      this.mRoadConditionFailKnown.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
          RGViewController.getInstance().requestShowExpendView(3, false);
        }
      });
    }
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      do
      {
        return;
        LogUtil.e(TAG, "initViews() in");
        this.mRoadConditionFailContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866622));
      } while (this.mRoadConditionFailContainer == null);
      LogUtil.e(TAG, "initViews() create");
      this.mRoadConditionFailContainer.removeAllViews();
      this.mRoadConditionFailView = JarUtils.inflate((Activity)this.mContext, 1711472738, null);
    } while ((this.mRoadConditionFailContainer == null) || (this.mRoadConditionFailView == null));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mRoadConditionFailContainer.addView(this.mRoadConditionFailView, localLayoutParams);
    this.bgView = this.mRootViewGroup.findViewById(1711866948);
    this.dividerView = this.mRootViewGroup.findViewById(1711866949);
    this.mRoadConditionFailKnown = ((TextView)this.mRootViewGroup.findViewById(1711866951));
    this.mRoadConditionFailTips = ((TextView)this.mRootViewGroup.findViewById(1711866950));
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e(TAG, "onHide()");
    BNWorkerCenter.getInstance().cancelTask(this.mHideTask, false);
    if (this.mRoadConditionFailContainer != null) {
      this.mRoadConditionFailContainer.setVisibility(8);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  public void show()
  {
    super.show();
    LogUtil.e(TAG, "onShow()");
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    if (this.mRoadConditionFailContainer == null)
    {
      BNWorkerCenter.getInstance().cancelTask(this.mHideTask, false);
      BNWorkerCenter.getInstance().submitMainThreadTask(this.mHideTask, new BNWorkerConfig(2, 0));
    }
    while (this.mRoadConditionFailContainer.getVisibility() == 0) {
      return;
    }
    this.mRoadConditionFailContainer.setVisibility(0);
    RGUpdateRCFailModel.getInstance().startCountDown();
    RGUpdateRCFailModel.getInstance().setOnCountDownListener(new RGUpdateRCFailModel.OnCountDownListener()
    {
      public void onCountDown(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0) {
          BNWorkerCenter.getInstance().submitMainThreadTask(RGMMRoadConditionFailView.this.mHideTask, new BNWorkerConfig(2, 0));
        }
      }
    });
  }
  
  public void updateData(Bundle paramBundle) {}
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.mRoadConditionFailKnown != null)
    {
      this.mRoadConditionFailKnown.setTextColor(BNStyleManager.getColor(1711800682));
      this.mRoadConditionFailKnown.setBackgroundDrawable(BNStyleManager.getDrawable(1711407113));
    }
    if (this.mRoadConditionFailTips != null) {
      this.mRoadConditionFailTips.setTextColor(BNStyleManager.getColor(1711800674));
    }
    if (this.bgView != null) {
      this.bgView.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.dividerView != null) {
      this.dividerView.setBackgroundColor(BNStyleManager.getColor(1711800690));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMRoadConditionFailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */