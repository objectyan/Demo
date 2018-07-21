package com.baidu.navi.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.carlife.CarlifeActivity;

public class DownNotifManager
{
  private static final int MERGE_ID = 15;
  private static final int PROGRESS_ID = 11;
  private static final int RESULT_ID = 13;
  private static final int SUSPEND_ID = 12;
  private static final int UPDATE_ID = 14;
  private static volatile DownNotifManager mInstance;
  private String mDownloadInfo;
  private Notification mMergeNotif;
  private NotificationManager mNotifManager;
  private int mProgress = 0;
  private Notification mProgressNotif;
  private Notification mResultNotif;
  private Notification mSuspendNotif;
  private Notification mUpdateNotif;
  private boolean mbProgressNotifShow = false;
  private boolean mbResultNotifShow = false;
  private String packageName;
  
  private DownNotifManager(Context paramContext)
  {
    this.packageName = paramContext.getPackageName();
    this.mNotifManager = ((NotificationManager)paramContext.getSystemService("notification"));
    this.mProgressNotif = new Notification();
    this.mProgressNotif.icon = 2130838698;
    Intent localIntent1 = new Intent(paramContext, CarlifeActivity.class);
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("OpenDownloadManager", "open");
    this.mProgressNotif.contentIntent = PendingIntent.getActivity(paramContext, 11, localIntent1, 0);
    this.mProgressNotif.flags = 16;
    this.mSuspendNotif = new Notification();
    this.mSuspendNotif.icon = 2130838698;
    localIntent1 = new Intent(paramContext, CarlifeActivity.class);
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("OpenDownloadManager", "open");
    this.mSuspendNotif.contentIntent = PendingIntent.getActivity(paramContext, 12, localIntent1, 0);
    this.mSuspendNotif.flags = 16;
    this.mResultNotif = new Notification();
    this.mResultNotif.icon = 2130838698;
    Intent localIntent2 = new Intent(paramContext, CarlifeActivity.class);
    localIntent2.setFlags(67108864);
    localIntent2.putExtra("OpenDownloadManager", "open");
    this.mResultNotif.contentIntent = PendingIntent.getActivity(paramContext, 13, localIntent1, 0);
    this.mResultNotif.flags = 16;
    this.mUpdateNotif = new Notification();
    this.mUpdateNotif.icon = 2130838698;
    localIntent1 = new Intent(paramContext, CarlifeActivity.class);
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("OpenDownloadManager", "open");
    this.mUpdateNotif.contentIntent = PendingIntent.getActivity(paramContext, 14, localIntent1, 0);
    this.mUpdateNotif.flags = 16;
    this.mMergeNotif = new Notification();
    this.mMergeNotif.icon = 2130838698;
    localIntent1 = new Intent(paramContext, CarlifeActivity.class);
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("OpenDownloadManager", "open");
    this.mMergeNotif.contentIntent = PendingIntent.getActivity(paramContext, 15, localIntent1, 0);
    this.mMergeNotif.flags = 16;
  }
  
  public static DownNotifManager getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new DownNotifManager(paramContext);
      }
      return mInstance;
    }
    finally {}
  }
  
  public void clearAllNotifs()
  {
    if (this.mNotifManager == null) {
      return;
    }
    try
    {
      this.mNotifManager.cancel(11);
      this.mNotifManager.cancel(12);
      this.mNotifManager.cancel(13);
      this.mNotifManager.cancel(14);
      setIsResultNotifShow(false);
      this.mbProgressNotifShow = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean isProgressNotifShow()
  {
    return this.mbProgressNotifShow;
  }
  
  public void setIsResultNotifShow(boolean paramBoolean)
  {
    this.mbResultNotifShow = paramBoolean;
  }
  
  public void showResultNotif(Context paramContext, String paramString)
  {
    if (this.mNotifManager == null) {}
    for (;;)
    {
      return;
      this.mNotifManager.cancel(11);
      this.mNotifManager.cancel(12);
      this.mResultNotif.contentView = new RemoteViews(this.packageName, 2130969023);
      if (this.mbProgressNotifShow) {
        this.mResultNotif.contentView.setTextViewText(2131625346, paramString);
      }
      try
      {
        this.mNotifManager.notify(13, this.mResultNotif);
        this.mbProgressNotifShow = false;
        setIsResultNotifShow(true);
        return;
        if (!this.mbResultNotifShow) {
          continue;
        }
        this.mResultNotif.contentView.setTextViewText(2131625346, paramString);
        try
        {
          this.mNotifManager.notify(13, this.mResultNotif);
          return;
        }
        catch (Exception paramContext) {}
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  public void showUpdateFinshedNotif(Context paramContext, String paramString)
  {
    if (this.mNotifManager == null) {
      return;
    }
    try
    {
      this.mNotifManager.cancel(13);
      this.mNotifManager.cancel(11);
      this.mNotifManager.cancel(12);
      this.mNotifManager.cancel(15);
      setIsResultNotifShow(false);
      this.mUpdateNotif.tickerText = paramString;
      this.mUpdateNotif.contentView = new RemoteViews(this.packageName, 2130969023);
      this.mUpdateNotif.contentView.setTextViewText(2131625346, paramString);
      try
      {
        this.mNotifManager.notify(14, this.mUpdateNotif);
        return;
      }
      catch (Exception paramContext) {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public void showUpdateMergeNotif(Context paramContext, String paramString)
  {
    if (this.mNotifManager == null) {
      return;
    }
    try
    {
      this.mNotifManager.cancel(12);
      this.mNotifManager.cancel(11);
      setIsResultNotifShow(false);
      this.mMergeNotif.tickerText = paramString;
      this.mMergeNotif.contentView = new RemoteViews(this.packageName, 2130969021);
      this.mMergeNotif.contentView.setTextViewText(2131625346, paramString);
      try
      {
        this.mNotifManager.notify(15, this.mMergeNotif);
        return;
      }
      catch (Exception paramContext) {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public void updateDowningNotif(String paramString1, int paramInt, String paramString2)
  {
    if (this.mNotifManager == null) {
      return;
    }
    this.mNotifManager.cancel(12);
    this.mNotifManager.cancel(13);
    setIsResultNotifShow(false);
    this.mProgress = paramInt;
    this.mDownloadInfo = paramString2;
    this.mProgressNotif.contentView = new RemoteViews(this.packageName, 2130969022);
    this.mProgressNotif.contentView.setProgressBar(2131626083, 100, paramInt, false);
    this.mProgressNotif.contentView.setTextViewText(2131625346, paramString1);
    this.mProgressNotif.contentView.setTextViewText(2131626086, paramString2);
    try
    {
      this.mNotifManager.notify(11, this.mProgressNotif);
      this.mbProgressNotifShow = true;
      return;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
  }
  
  public void updateSuspendingNotif(String paramString)
  {
    if (this.mNotifManager == null) {
      return;
    }
    this.mNotifManager.cancel(13);
    this.mNotifManager.cancel(11);
    this.mSuspendNotif.contentView = new RemoteViews(this.packageName, 2130969024);
    this.mSuspendNotif.contentView.setTextViewText(2131625346, paramString);
    this.mSuspendNotif.contentView.setProgressBar(2131626083, 100, this.mProgress, false);
    this.mSuspendNotif.contentView.setTextViewText(2131626086, this.mDownloadInfo);
    try
    {
      this.mNotifManager.notify(12, this.mSuspendNotif);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/DownNotifManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */