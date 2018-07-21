package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class RGUserRightView
  extends BNBaseView
{
  private LinearLayout mUserCurMileaLL;
  private TextView mUserCurMileaTv;
  private LinearLayout mUserRightLL;
  private LinearLayout mUserRightUpgradeTipsLL;
  private TextView mUserRightUpgradeTipsTv;
  
  public RGUserRightView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    this.mUserRightLL = ((LinearLayout)this.mRootViewGroup.findViewById(1711866159));
    this.mUserCurMileaLL = ((LinearLayout)this.mRootViewGroup.findViewById(1711866160));
    this.mUserCurMileaTv = ((TextView)this.mRootViewGroup.findViewById(1711866161));
    this.mUserRightUpgradeTipsLL = ((LinearLayout)this.mRootViewGroup.findViewById(1711866163));
    this.mUserRightUpgradeTipsTv = ((TextView)this.mRootViewGroup.findViewById(1711866164));
    this.mUserRightLL.setVisibility(8);
    this.mUserRightUpgradeTipsLL.setVisibility(8);
    this.mUserCurMileaLL.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((RGUserRightView.this.mUserRightUpgradeTipsLL.getVisibility() != 0) && (!StringUtils.isEmpty(BusinessActivityManager.getInstance().getModel().userRightUpgradeTips)))
        {
          if (RGUserRightView.this.mUserRightUpgradeTipsTv != null) {
            RGUserRightView.this.mUserRightUpgradeTipsTv.setText(BusinessActivityManager.getInstance().getModel().userRightUpgradeTips);
          }
          RGUserRightView.this.mUserRightUpgradeTipsLL.setVisibility(0);
          BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("initViews-" + getClass().getSimpleName(), null)new BNWorkerConfig
          {
            protected String execute()
            {
              RGUserRightView.this.mUserRightUpgradeTipsLL.setVisibility(8);
              return null;
            }
          }, new BNWorkerConfig(2, 0), 3000L);
        }
      }
    });
  }
  
  public void hide()
  {
    if (this.mUserRightLL != null) {
      this.mUserRightLL.setVisibility(8);
    }
  }
  
  public void hideUserRightTipsView()
  {
    if (this.mUserRightUpgradeTipsLL != null) {
      this.mUserRightUpgradeTipsLL.setVisibility(8);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initViews();
  }
  
  public void show()
  {
    if ((NetworkUtils.isNetworkAvailable(this.mContext)) && (BNavConfig.pRGLocateMode != 2) && (BusinessActivityManager.getInstance().getModel().isShowUserRight == 1) && (!StringUtils.isEmpty(BusinessActivityManager.getInstance().getModel().userRightUpgradeTips))) {
      updateCurMileaInfo();
    }
  }
  
  public void updateCurMileaInfo()
  {
    String str = JNITrajectoryControl.sInstance.getCurrentUUID();
    if (str == null) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = JNITrajectoryControl.sInstance.getTrajectoryLength(str) / 1000L;
      l2 = BusinessActivityManager.getInstance().getModel().userHistoryMileas;
    } while (this.mUserCurMileaTv == null);
    str = String.valueOf(l1 + l2);
    if (str.length() < 4) {
      this.mUserCurMileaTv.setTextSize(20.0F);
    }
    for (;;)
    {
      this.mUserCurMileaTv.setText(str);
      return;
      if (str.length() == 4)
      {
        this.mUserCurMileaTv.setTextSize(16.0F);
      }
      else
      {
        this.mUserCurMileaTv.setTextSize(13.0F);
        str = "9999+";
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGUserRightView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */