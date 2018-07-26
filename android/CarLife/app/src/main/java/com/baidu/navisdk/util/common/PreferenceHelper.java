package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Map;

public class PreferenceHelper implements PreferenceHelperConst {
    private static PreferenceHelper mInstance;
    private Editor mEditor = this.mPreferences.edit();
    private SharedPreferences mPreferences;

    public static synchronized PreferenceHelper getInstance(Context context) {
        PreferenceHelper preferenceHelper;
        synchronized (PreferenceHelper.class) {
            if (mInstance == null) {
                mInstance = new PreferenceHelper(context);
            }
            preferenceHelper = mInstance;
        }
        return preferenceHelper;
    }

    public SharedPreferences getPreferences() {
        return this.mPreferences;
    }

    private PreferenceHelper(Context context) {
        this.mPreferences = context.getSharedPreferences("navi", 0);
    }

    public Map<String, ?> getAll() {
        return this.mPreferences.getAll();
    }

    public boolean contains(String key) {
        return this.mPreferences.contains(key);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return this.mPreferences.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return this.mPreferences.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return this.mPreferences.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return this.mPreferences.getLong(key, defValue);
    }

    public String getString(String key, String defValue) {
        return this.mPreferences.getString(key, defValue);
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        this.mPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        this.mPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public boolean putBoolean(String key, boolean b) {
        this.mEditor.putBoolean(key, b);
        return this.mEditor.commit();
    }

    public boolean putInt(String key, int i) {
        this.mEditor.putInt(key, i);
        return this.mEditor.commit();
    }

    public boolean putFloat(String key, float f) {
        this.mEditor.putFloat(key, f);
        return this.mEditor.commit();
    }

    public boolean putLong(String key, long l) {
        this.mEditor.putLong(key, l);
        return this.mEditor.commit();
    }

    public boolean putString(String key, String s) {
        this.mEditor.putString(key, s);
        return this.mEditor.commit();
    }

    public boolean remove(String key) {
        this.mEditor.remove(key);
        return this.mEditor.commit();
    }
}
