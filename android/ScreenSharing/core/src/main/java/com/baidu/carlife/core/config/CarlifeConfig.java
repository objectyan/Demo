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
    public static boolean f3157c = false;
    /* renamed from: d */
    private static List<C1189a> f3158d = new ArrayList();

    /* compiled from: CarlifeConfig */
    /* renamed from: com.baidu.carlife.core.b.a$a */
    public static class C1189a implements KeepClass {
        /* renamed from: a */
        public String f3153a;
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
    public static void m4064a(boolean notSupportInternalScreen) {
        f3157c = notSupportInternalScreen;
    }

    /* renamed from: a */
    public static boolean m4065a() {
        if (!f3155a || f3157c) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static void m4063a(C1189a channel) {
        f3158d.add(channel);
    }

    /* renamed from: b */
    public static void m4066b() {
        f3158d.clear();
    }

    /* renamed from: c */
    public static boolean m4067c() {
        String channel = CommonParams.sVehicleChannel.getChannel();
        boolean isWechatEnable = false;
        for (C1189a wechatChannel : f3158d) {
            if (TextUtils.equals(channel, wechatChannel.f3153a)) {
                isWechatEnable = true;
                break;
            }
        }
        return CarlifeUtil.newInstance().isConnected() && ConnectClient.newInstance().m4225c() && isWechatEnable;
    }

    /* renamed from: d */
    public static String m4068d() {
        String channel = CommonParams.sVehicleChannel.getChannel();
        for (C1189a wechatChannel : f3158d) {
            if (TextUtils.equals(channel, wechatChannel.f3153a)) {
                return wechatChannel.f3154b;
            }
        }
        return "";
    }
}
