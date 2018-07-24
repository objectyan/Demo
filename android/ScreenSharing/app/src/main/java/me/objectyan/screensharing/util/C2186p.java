package com.baidu.carlife.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.CommonParams;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PreferenceUtil */
/* renamed from: com.baidu.carlife.util.p */
public class C2186p {
    /* renamed from: a */
    private static final String f6986a = "PreferenceUtil";
    /* renamed from: b */
    private static C2186p f6987b = null;
    /* renamed from: c */
    private SharedPreferences f6988c = null;
    /* renamed from: d */
    private Editor f6989d = null;
    /* renamed from: e */
    private Context f6990e = null;
    /* renamed from: f */
    private Map<String, Boolean> f6991f = new HashMap();

    /* renamed from: a */
    public static C2186p m8304a() {
        if (f6987b == null) {
            f6987b = new C2186p();
            f6987b.m8305a(BaiduNaviApplication.getInstance().getApplicationContext());
        }
        return f6987b;
    }

    /* renamed from: a */
    private void m8305a(Context context) {
        this.f6990e = context;
        this.f6988c = this.f6990e.getSharedPreferences(CommonParams.ia, 0);
        this.f6989d = this.f6988c.edit();
    }

    /* renamed from: b */
    public SharedPreferences m8313b() {
        return this.f6988c;
    }

    /* renamed from: c */
    public Map<String, ?> m8321c() {
        return this.f6988c.getAll();
    }

    /* renamed from: a */
    public boolean m8311a(String key) {
        return this.f6988c.contains(key);
    }

    /* renamed from: a */
    public boolean m8312a(String key, boolean defValue) {
        return this.f6988c.getBoolean(key, defValue);
    }

    /* renamed from: b */
    public boolean m8320b(String key, boolean defValue) {
        if (this.f6991f.containsKey(key)) {
            return ((Boolean) this.f6991f.get(key)).booleanValue();
        }
        boolean value = this.f6988c.getBoolean(key, defValue);
        this.f6991f.put(key, Boolean.valueOf(value));
        return value;
    }

    /* renamed from: a */
    public float m8306a(String key, float defValue) {
        return this.f6988c.getFloat(key, defValue);
    }

    /* renamed from: a */
    public int m8307a(String key, int defValue) {
        return this.f6988c.getInt(key, defValue);
    }

    /* renamed from: a */
    public long m8308a(String key, long defValue) {
        return this.f6988c.getLong(key, defValue);
    }

    /* renamed from: a */
    public String m8309a(String key, String defValue) {
        return this.f6988c.getString(key, defValue);
    }

    /* renamed from: a */
    public void m8310a(OnSharedPreferenceChangeListener listener) {
        this.f6988c.registerOnSharedPreferenceChangeListener(listener);
    }

    /* renamed from: b */
    public void m8314b(OnSharedPreferenceChangeListener listener) {
        this.f6988c.unregisterOnSharedPreferenceChangeListener(listener);
    }

    /* renamed from: b */
    public boolean m8315b(String key) {
        return this.f6988c.contains(key);
    }

    /* renamed from: c */
    public boolean m8323c(String key, boolean b) {
        this.f6989d.putBoolean(key, b);
        return this.f6989d.commit();
    }

    /* renamed from: d */
    public boolean m8324d(String key, boolean b) {
        this.f6989d.putBoolean(key, b);
        this.f6991f.put(key, Boolean.valueOf(b));
        return this.f6989d.commit();
    }

    /* renamed from: b */
    public boolean m8317b(String key, int i) {
        this.f6989d.putInt(key, i);
        return this.f6989d.commit();
    }

    /* renamed from: b */
    public boolean m8316b(String key, float f) {
        this.f6989d.putFloat(key, f);
        return this.f6989d.commit();
    }

    /* renamed from: b */
    public boolean m8318b(String key, long l) {
        this.f6989d.putLong(key, l);
        return this.f6989d.commit();
    }

    /* renamed from: b */
    public boolean m8319b(String key, String s) {
        this.f6989d.putString(key, s);
        return this.f6989d.commit();
    }

    /* renamed from: c */
    public boolean m8322c(String key) {
        this.f6989d.remove(key);
        return this.f6989d.commit();
    }
}
