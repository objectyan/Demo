package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.p031j.C0573l;
import com.baidu.android.pushservice.p031j.C0578p;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BasicPushNotificationBuilder extends PushNotificationBuilder {
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.mStatusbarIcon = objectInputStream.readInt();
        this.mNotificationFlags = objectInputStream.readInt();
        this.mNotificationDefaults = objectInputStream.readInt();
        if (objectInputStream.readBoolean()) {
            this.mNotificationsound = (String) objectInputStream.readObject();
        }
        int readInt = objectInputStream.readInt();
        this.mVibratePattern = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            this.mVibratePattern[i] = objectInputStream.readLong();
        }
        this.mNotificationTitle = (String) objectInputStream.readObject();
        this.mNotificationText = (String) objectInputStream.readObject();
        this.mChannelId = (String) objectInputStream.readObject();
        this.mChannelName = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i = 0;
        objectOutputStream.writeInt(this.mStatusbarIcon);
        objectOutputStream.writeInt(this.mNotificationFlags);
        objectOutputStream.writeInt(this.mNotificationDefaults);
        if (this.mNotificationsound != null) {
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeObject(this.mNotificationsound.toString());
        } else {
            objectOutputStream.writeBoolean(false);
        }
        if (this.mVibratePattern != null) {
            objectOutputStream.writeInt(this.mVibratePattern.length);
            while (i < this.mVibratePattern.length) {
                objectOutputStream.writeLong(this.mVibratePattern[i]);
                i++;
            }
        } else {
            objectOutputStream.writeInt(0);
        }
        objectOutputStream.writeObject(this.mNotificationTitle);
        objectOutputStream.writeObject(this.mNotificationText);
        objectOutputStream.writeObject(this.mChannelId);
        objectOutputStream.writeObject(this.mChannelName);
    }

    @SuppressLint({"NewApi"})
    public Notification construct(Context context) {
        Builder builder = new Builder(context);
        if (this.mNotificationDefaults != 0) {
            builder.setDefaults(this.mNotificationDefaults);
        }
        if (this.mNotificationsound != null) {
            builder.setSound(Uri.parse(this.mNotificationsound));
        }
        if (this.mVibratePattern != null) {
            builder.setVibrate(this.mVibratePattern);
        }
        if (this.mStatusbarIcon != 0) {
            builder.setSmallIcon(this.mStatusbarIcon);
        } else {
            builder.setSmallIcon(context.getApplicationInfo().icon);
        }
        builder.setContentTitle(this.mNotificationTitle);
        builder.setContentText(this.mNotificationText);
        if (C0578p.m2503G(context)) {
            if (TextUtils.isEmpty(this.mChannelId)) {
                this.mChannelId = "com.baidu.android.pushservice.push";
            }
            if (TextUtils.isEmpty(this.mChannelName)) {
                this.mChannelName = "Push";
            }
            C0573l.m2464a(context, this.mChannelId, this.mChannelName);
            builder.setChannelId(this.mChannelId);
        }
        Notification build = VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        if (build != null) {
            if (this.mNotificationFlags != 0) {
                build.flags = this.mNotificationFlags;
            } else {
                build.flags |= 16;
            }
        }
        return build;
    }
}
