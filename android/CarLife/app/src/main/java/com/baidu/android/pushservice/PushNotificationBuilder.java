package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import java.io.Serializable;

public abstract class PushNotificationBuilder
  implements Serializable
{
  protected String mChannelId;
  protected String mChannelName;
  protected int mNotificationDefaults;
  protected int mNotificationFlags;
  protected String mNotificationText;
  protected String mNotificationTitle;
  protected String mNotificationsound;
  protected int mStatusbarIcon;
  protected long[] mVibratePattern;
  
  public abstract Notification construct(Context paramContext);
  
  public void setChannelId(String paramString)
  {
    this.mChannelId = paramString;
  }
  
  public void setChannelName(String paramString)
  {
    this.mChannelName = paramString;
  }
  
  public void setNotificationDefaults(int paramInt)
  {
    this.mNotificationDefaults = paramInt;
  }
  
  public void setNotificationFlags(int paramInt)
  {
    this.mNotificationFlags = paramInt;
  }
  
  public void setNotificationSound(String paramString)
  {
    this.mNotificationsound = paramString;
  }
  
  public void setNotificationText(String paramString)
  {
    this.mNotificationText = paramString;
  }
  
  public void setNotificationTitle(String paramString)
  {
    this.mNotificationTitle = paramString;
  }
  
  public void setNotificationVibrate(long[] paramArrayOfLong)
  {
    this.mVibratePattern = paramArrayOfLong;
  }
  
  public void setStatusbarIcon(int paramInt)
  {
    this.mStatusbarIcon = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */