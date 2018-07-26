package com.baidu.carlife.wechat.p113g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.wechat.p108b.C2380c;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SharedPreferenceUtil */
/* renamed from: com.baidu.carlife.wechat.g.b */
public final class C2498b {
    /* renamed from: a */
    private static final String f8131a = "wechathelper_prefs";
    /* renamed from: b */
    private static final String f8132b = "setting_mute";
    /* renamed from: c */
    private static final String f8133c = "setting_close_room_msg";
    /* renamed from: d */
    private static final String f8134d = "setting_auto_play";
    /* renamed from: e */
    private static final String f8135e = "blacklist_names_";
    /* renamed from: f */
    private static SharedPreferences f8136f = C1157a.m3876a().getSharedPreferences(f8131a, 0);
    /* renamed from: g */
    private static Editor f8137g = f8136f.edit();

    /* renamed from: a */
    public static void m9482a(boolean enable) {
        f8137g.putBoolean(f8132b, enable).commit();
    }

    /* renamed from: a */
    public static boolean m9483a() {
        return f8136f.getBoolean(f8132b, false);
    }

    /* renamed from: b */
    public static void m9484b(boolean enable) {
        f8137g.putBoolean(f8133c, enable).commit();
    }

    /* renamed from: b */
    public static boolean m9485b() {
        return f8136f.getBoolean(f8133c, true);
    }

    /* renamed from: c */
    public static void m9486c(boolean enable) {
        f8137g.putBoolean(f8134d, enable).commit();
    }

    /* renamed from: c */
    public static boolean m9487c() {
        return f8136f.getBoolean(f8134d, true);
    }

    /* renamed from: a */
    public static void m9481a(Set<String> nameSet) {
        f8137g.putStringSet(f8135e + C2380c.m9070a().m9085f().m9129a(), nameSet).commit();
    }

    /* renamed from: d */
    public static Set<String> m9488d() {
        return f8136f.getStringSet(f8135e + C2380c.m9070a().m9085f().m9129a(), new HashSet());
    }
}
