package com.baidu.navisdk.lightnavi.view;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class RGSlightGuideView
  extends RGSlightBaseView
{
  private BNWorkerNormalTask<String, String> mCancelNotifyTask = new BNWorkerNormalTask("mCancelNotify-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      try
      {
        if (RGSlightGuideView.this.mNotificationManager != null) {
          RGSlightGuideView.this.mNotificationManager.cancel(RGSlightGuideView.this.notification_id);
        }
        return null;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  };
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private LinearLayout mLLGuideBtn;
  private NotificationManager mNotificationManager;
  private RelativeLayout mRLGuideParent;
  private int notification_id = 1212;
  
  public RGSlightGuideView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    initView();
    initListener();
    try
    {
      this.mNotificationManager = ((NotificationManager)this.mContext.getSystemService("notification"));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void showNotify(long paramLong)
  {
    try
    {
      Notification.Builder localBuilder = new Notification.Builder(this.mContext);
      localBuilder.setSmallIcon(BNaviModuleManager.getAppIconId());
      localBuilder.setContentIntent(PendingIntent.getActivity(this.mContext, this.notification_id, new Intent(), 134217728));
      if (BNRoutePlaner.getInstance().getEntry() == 16)
      {
        localBuilder.setTicker("发现您正在行驶，已经进入路线雷达");
        UserOPController.getInstance().add("4.1", "", null, null);
      }
      for (;;)
      {
        localBuilder.setAutoCancel(true);
        if (this.mNotificationManager == null) {
          break;
        }
        this.mNotificationManager.notify(this.notification_id, localBuilder.build());
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mCancelNotifyTask, new BNWorkerConfig(9, 0), paramLong);
        return;
        localBuilder.setTicker("已经进入路线雷达");
        UserOPController.getInstance().add("4.1", null, "", null);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void initListener()
  {
    this.mLLGuideBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGSlightGuideView.this.mRLGuideParent.setVisibility(0);
      }
    });
    this.mRLGuideParent.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGSlightGuideView.this.mRLGuideParent.setVisibility(8);
      }
    });
  }
  
  public void initView()
  {
    this.mRLGuideParent = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866193));
    this.mLLGuideBtn = ((LinearLayout)this.mRootViewGroup.findViewById(1711866178));
  }
  
  public void quit()
  {
    if (this.mNotificationManager != null) {
      this.mNotificationManager.cancel(this.notification_id);
    }
    BNWorkerCenter.getInstance().cancelTask(this.mCancelNotifyTask, false);
  }
  
  public boolean quitGuide()
  {
    if (this.mRLGuideParent.getVisibility() == 0)
    {
      this.mRLGuideParent.setVisibility(8);
      return true;
    }
    return false;
  }
  
  public void showNotify()
  {
    if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
      showNotify(2500L);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/RGSlightGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */