package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.p;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomPushNotificationBuilder
  extends PushNotificationBuilder
{
  private int mLayoutIconDrawable;
  private int mLayoutIconId;
  private int mLayoutId;
  private int mLayoutTextId;
  private int mLayoutTitleId;
  
  public CustomPushNotificationBuilder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLayoutId = paramInt1;
    this.mLayoutIconId = paramInt2;
    this.mLayoutTitleId = paramInt3;
    this.mLayoutTextId = paramInt4;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.mStatusbarIcon = paramObjectInputStream.readInt();
    this.mNotificationFlags = paramObjectInputStream.readInt();
    this.mNotificationDefaults = paramObjectInputStream.readInt();
    if (paramObjectInputStream.readBoolean()) {
      this.mNotificationsound = ((String)paramObjectInputStream.readObject());
    }
    int j = paramObjectInputStream.readInt();
    this.mVibratePattern = new long[j];
    int i = 0;
    while (i < j)
    {
      this.mVibratePattern[i] = paramObjectInputStream.readLong();
      i += 1;
    }
    this.mNotificationTitle = ((String)paramObjectInputStream.readObject());
    this.mNotificationText = ((String)paramObjectInputStream.readObject());
    this.mChannelId = ((String)paramObjectInputStream.readObject());
    this.mChannelName = ((String)paramObjectInputStream.readObject());
    this.mLayoutId = paramObjectInputStream.readInt();
    this.mLayoutIconId = paramObjectInputStream.readInt();
    this.mLayoutTitleId = paramObjectInputStream.readInt();
    this.mLayoutTextId = paramObjectInputStream.readInt();
    this.mLayoutIconDrawable = paramObjectInputStream.readInt();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    int i = 0;
    paramObjectOutputStream.writeInt(this.mStatusbarIcon);
    paramObjectOutputStream.writeInt(this.mNotificationFlags);
    paramObjectOutputStream.writeInt(this.mNotificationDefaults);
    if (this.mNotificationsound != null)
    {
      paramObjectOutputStream.writeBoolean(true);
      paramObjectOutputStream.writeObject(this.mNotificationsound.toString());
    }
    while (this.mVibratePattern != null)
    {
      paramObjectOutputStream.writeInt(this.mVibratePattern.length);
      while (i < this.mVibratePattern.length)
      {
        paramObjectOutputStream.writeLong(this.mVibratePattern[i]);
        i += 1;
      }
      paramObjectOutputStream.writeBoolean(false);
    }
    paramObjectOutputStream.writeInt(0);
    paramObjectOutputStream.writeObject(this.mNotificationTitle);
    paramObjectOutputStream.writeObject(this.mNotificationText);
    paramObjectOutputStream.writeObject(this.mChannelId);
    paramObjectOutputStream.writeObject(this.mChannelName);
    paramObjectOutputStream.writeInt(this.mLayoutId);
    paramObjectOutputStream.writeInt(this.mLayoutIconId);
    paramObjectOutputStream.writeInt(this.mLayoutTitleId);
    paramObjectOutputStream.writeInt(this.mLayoutTextId);
    paramObjectOutputStream.writeInt(this.mLayoutIconDrawable);
  }
  
  @SuppressLint({"NewApi"})
  public Notification construct(Context paramContext)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    if (this.mNotificationDefaults != 0) {
      localBuilder.setDefaults(this.mNotificationDefaults);
    }
    if (this.mNotificationsound != null) {
      localBuilder.setSound(Uri.parse(this.mNotificationsound));
    }
    if (this.mVibratePattern != null) {
      localBuilder.setVibrate(this.mVibratePattern);
    }
    if (this.mStatusbarIcon != 0) {
      localBuilder.setSmallIcon(this.mStatusbarIcon);
    }
    if (this.mLayoutId != 0)
    {
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), this.mLayoutId);
      if (this.mLayoutIconDrawable != 0) {
        localRemoteViews.setImageViewResource(this.mLayoutIconId, this.mLayoutIconDrawable);
      }
      if (this.mNotificationTitle != null) {
        localRemoteViews.setTextViewText(this.mLayoutTitleId, this.mNotificationTitle);
      }
      if (this.mNotificationText != null) {
        localRemoteViews.setTextViewText(this.mLayoutTextId, this.mNotificationText);
      }
      localBuilder.setContent(localRemoteViews);
      if (p.G(paramContext))
      {
        if (TextUtils.isEmpty(this.mChannelId)) {
          this.mChannelId = "com.baidu.android.pushservice.push";
        }
        if (TextUtils.isEmpty(this.mChannelName)) {
          this.mChannelName = "Push";
        }
        l.a(paramContext, this.mChannelId, this.mChannelName);
        localBuilder.setChannelId(this.mChannelId);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label277;
      }
    }
    label277:
    for (paramContext = localBuilder.build();; paramContext = localBuilder.getNotification())
    {
      if ((this.mNotificationFlags != 0) && (paramContext != null)) {
        paramContext.flags = this.mNotificationFlags;
      }
      return paramContext;
      localBuilder.setContentTitle(this.mNotificationTitle);
      localBuilder.setContentText(this.mNotificationText);
      break;
    }
  }
  
  public void setLayoutDrawable(int paramInt)
  {
    this.mLayoutIconDrawable = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/CustomPushNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */