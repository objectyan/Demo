package com.baidu.navisdk.ui.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDownloadNotifyManager
{
  public static final int MERGE_NOTIFY_NO_PROGRESS = -1;
  private static final int REQ_CODE = 10;
  private static final String TAG = "!#BNDownloadNotifyManager";
  private static BNDownloadNotifyManager mInstance;
  private BNOfflineDataObserver mDataObserver = new BNOfflineDataObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt1)
      {
      default: 
        return;
      case 2: 
        String str = "Observer recved: TYPE_DOWNLOAD_INFOR, event " + paramAnonymousInt2;
        switch (paramAnonymousInt2)
        {
        case 260: 
        case 261: 
        case 265: 
        case 266: 
        default: 
        case 258: 
        case 259: 
        case 262: 
        case 263: 
        case 267: 
        case 268: 
          for (;;)
          {
            paramAnonymousBNSubject = str;
            if (paramAnonymousObject != null)
            {
              paramAnonymousBNSubject = str;
              if ((paramAnonymousObject instanceof BNOfflineDataObserver.DownloadArg))
              {
                paramAnonymousObject = (BNOfflineDataObserver.DownloadArg)paramAnonymousObject;
                paramAnonymousBNSubject = str + ", " + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName + ":" + ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress;
                BNDownloadNotifyManager.this.updateNotificationByName(((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mName, ((BNOfflineDataObserver.DownloadArg)paramAnonymousObject).mProgress);
              }
            }
            LogUtil.e("!#BNDownloadNotifyManager", paramAnonymousBNSubject);
            return;
            BNDownloadNotifyManager.access$010(BNDownloadNotifyManager.this);
          }
        }
        BNDownloadNotifyManager.access$002(BNDownloadNotifyManager.this, 0);
        BNDownloadNotifyManager.this.clearNotification();
        return;
      }
      switch (paramAnonymousInt2)
      {
      default: 
        return;
      }
      BNDownloadNotifyManager.this.clearNotification();
    }
  };
  private Intent mIntent;
  private boolean mIsNotificationShown = false;
  private boolean mIsObserving = false;
  private Notification mNotification;
  private NotificationManager mNotifyManager;
  private int mProgressBarResId;
  private int mProgressTxtResId;
  private int mTitleTxtResId;
  private OnUpdateListener mUpdateListener;
  private int mWaitingTaskCount;
  
  public static BNDownloadNotifyManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNDownloadNotifyManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void updateNotificationByName(String paramString, int paramInt)
  {
    if (this.mWaitingTaskCount + 1 > 0) {
      updateNotification(JarUtils.getResources().getString(1711669834, new Object[] { paramString, Integer.valueOf(this.mWaitingTaskCount + 1) }), paramInt);
    }
  }
  
  public void clearNotification()
  {
    if (this.mNotifyManager != null) {
      this.mNotifyManager.cancel(10);
    }
    this.mIsNotificationShown = false;
  }
  
  public void init(Context paramContext, Intent paramIntent, int paramInt1, RemoteViews paramRemoteViews, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramContext != null) && (paramIntent != null) && (paramRemoteViews != null))
    {
      this.mNotifyManager = ((NotificationManager)paramContext.getSystemService("notification"));
      this.mNotification = new Notification();
      this.mNotification.icon = paramInt1;
      this.mNotification.contentView = paramRemoteViews;
      this.mNotification.flags = 16;
      this.mNotification.contentIntent = PendingIntent.getActivity(paramContext, 10, paramIntent, 0);
      this.mTitleTxtResId = paramInt2;
      this.mProgressBarResId = paramInt3;
      this.mProgressTxtResId = paramInt4;
    }
  }
  
  public void init(Context paramContext, Intent paramIntent, int paramInt, RemoteViews paramRemoteViews, OnUpdateListener paramOnUpdateListener)
  {
    if ((paramContext != null) && (paramIntent != null) && (paramRemoteViews != null))
    {
      this.mNotifyManager = ((NotificationManager)paramContext.getSystemService("notification"));
      this.mNotification = new Notification();
      this.mNotification.icon = paramInt;
      this.mNotification.contentView = paramRemoteViews;
      this.mNotification.flags = 16;
      this.mNotification.contentIntent = PendingIntent.getActivity(paramContext, 10, paramIntent, 0);
      this.mUpdateListener = paramOnUpdateListener;
    }
  }
  
  public boolean isNotificationShown()
  {
    return this.mIsNotificationShown;
  }
  
  public void startObserving()
  {
    if (!this.mIsObserving)
    {
      BNOfflineDataManager.getInstance().addObserver(this.mDataObserver);
      this.mIsObserving = true;
    }
  }
  
  public void stopObserving()
  {
    if (this.mIsObserving)
    {
      BNOfflineDataManager.getInstance().deleteObserver(this.mDataObserver);
      this.mIsObserving = false;
    }
  }
  
  public void updateNotification(String paramString, int paramInt)
  {
    LogUtil.e("!#BNDownloadNotifyManager", "updateNotification: " + paramString + ", progress " + paramInt);
    if ((this.mNotifyManager != null) && (this.mNotification != null))
    {
      if (this.mUpdateListener != null) {
        this.mUpdateListener.onUpdate(this.mNotification.contentView, paramString, paramInt);
      }
      if (paramInt != -1) {
        break label143;
      }
      this.mNotification.contentView.setViewVisibility(this.mProgressBarResId, 8);
      this.mNotification.contentView.setViewVisibility(this.mProgressTxtResId, 8);
      this.mNotification.contentView.setTextViewText(this.mTitleTxtResId, paramString);
    }
    for (;;)
    {
      label143:
      try
      {
        this.mNotifyManager.notify(10, this.mNotification);
        this.mIsNotificationShown = true;
        return;
      }
      catch (Exception paramString) {}
      this.mNotification.contentView.setViewVisibility(this.mProgressBarResId, 0);
      this.mNotification.contentView.setViewVisibility(this.mProgressTxtResId, 0);
      this.mNotification.contentView.setProgressBar(this.mProgressBarResId, 100, paramInt, false);
      this.mNotification.contentView.setTextViewText(this.mTitleTxtResId, paramString);
      this.mNotification.contentView.setTextViewText(this.mProgressTxtResId, paramInt + "%");
    }
  }
  
  public static abstract interface OnUpdateListener
  {
    public abstract void onUpdate(RemoteViews paramRemoteViews, String paramString, int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/download/BNDownloadNotifyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */