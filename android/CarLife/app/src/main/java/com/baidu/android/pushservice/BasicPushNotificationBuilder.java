package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.p;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BasicPushNotificationBuilder
  extends PushNotificationBuilder
{
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
    if (this.mStatusbarIcon != 0)
    {
      localBuilder.setSmallIcon(this.mStatusbarIcon);
      localBuilder.setContentTitle(this.mNotificationTitle);
      localBuilder.setContentText(this.mNotificationText);
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
        break label203;
      }
    }
    label203:
    for (paramContext = localBuilder.build();; paramContext = localBuilder.getNotification())
    {
      if (paramContext != null)
      {
        if (this.mNotificationFlags == 0) {
          break label211;
        }
        paramContext.flags = this.mNotificationFlags;
      }
      return paramContext;
      localBuilder.setSmallIcon(paramContext.getApplicationInfo().icon);
      break;
    }
    label211:
    paramContext.flags |= 0x10;
    return paramContext;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/BasicPushNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */