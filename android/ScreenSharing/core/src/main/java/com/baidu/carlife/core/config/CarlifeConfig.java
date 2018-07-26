package com.baidu.carlife.core.config;

import android.os.Build.VERSION;
import android.text.TextUtils;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.connect.ConnectClient;

import java.util.ArrayList;
import java.util.List;

/* compiled from: CarlifeConfig */
/* renamed from: com.baidu.carlife.core.b.a */
public class CarlifeConfig implements KeepClass {
    /* renamed from: a */
    public static final boolean f3155a;
    /* renamed from: b */
    public static final boolean f3156b = false;
    /* renamed from: c */
    public static boolean sNotSupportInternalScreen = false;
    /* renamed from: d */
    private static List<ChannelItem> sChannelItems = new ArrayList();

    /* compiled from: CarlifeConfig */
    /* renamed from: com.baidu.carlife.core.b.a$a */
    public static class ChannelItem implements KeepClass {
        /* renamed from: a */
        public String mChannel;
        /* renamed from: b */
        public String f3154b;
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        f3155a = z;
    }

    /* renamed from: a */
    public static void setNotSupportInternalScreen(boolean notSupportInternalScreen) {
        sNotSupportInternalScreen = notSupportInternalScreen;
    }

    /* renamed from: a */
    public static boolean m4065a() {
        if (!f3155a || sNotSupportInternalScreen) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static void addChannel(ChannelItem channel) {
        sChannelItems.add(channel);
    }

    /* renamed from: b */
    public static void clearChannel() {
        sChannelItems.clear();
    }

    /* renamed from: c */
    public static boolean m4067c() {
        String channel = CommonParams.sVehicleChannel.getChannel();
        boolean isWechatEnable = false;
        for (ChannelItem wechatChannel : sChannelItems) {
            if (TextUtils.equals(channel, wechatChannel.mChannel)) {
                isWechatEnable = true;
                break;
            }
        }
        return CarlifeUtil.newInstance().isConnected() && ConnectClient.newInstance().getIS() && isWechatEnable;
    }

    /* renamed from: d */
    public static String m4068d() {
        String channel = CommonParams.sVehicleChannel.getChannel();
        for (ChannelItem wechatChannel : sChannelItems) {
            if (TextUtils.equals(channel, wechatChannel.mChannel)) {
                return wechatChannel.f3154b;
            }
        }
        return "";
    }
}
