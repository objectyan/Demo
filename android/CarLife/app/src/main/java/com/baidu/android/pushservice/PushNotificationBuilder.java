package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import java.io.Serializable;

public abstract class PushNotificationBuilder implements Serializable {
    protected String mChannelId;
    protected String mChannelName;
    protected int mNotificationDefaults;
    protected int mNotificationFlags;
    protected String mNotificationText;
    protected String mNotificationTitle;
    protected String mNotificationsound;
    protected int mStatusbarIcon;
    protected long[] mVibratePattern;

    public abstract Notification construct(Context context);

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setChannelName(String str) {
        this.mChannelName = str;
    }

    public void setNotificationDefaults(int i) {
        this.mNotificationDefaults = i;
    }

    public void setNotificationFlags(int i) {
        this.mNotificationFlags = i;
    }

    public void setNotificationSound(String str) {
        this.mNotificationsound = str;
    }

    public void setNotificationText(String str) {
        this.mNotificationText = str;
    }

    public void setNotificationTitle(String str) {
        this.mNotificationTitle = str;
    }

    public void setNotificationVibrate(long[] jArr) {
        this.mVibratePattern = jArr;
    }

    public void setStatusbarIcon(int i) {
        this.mStatusbarIcon = i;
    }
}
