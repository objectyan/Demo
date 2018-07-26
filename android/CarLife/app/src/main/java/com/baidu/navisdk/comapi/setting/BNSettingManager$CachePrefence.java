package com.baidu.navisdk.comapi.setting;

import android.content.Context;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.util.HashMap;

class BNSettingManager$CachePrefence {
    private static PreferenceHelper mPreferenceHelper;
    private static HashMap<String, Object> sCache = new HashMap();

    public BNSettingManager$CachePrefence(Context context) {
        mPreferenceHelper = PreferenceHelper.getInstance(context.getApplicationContext());
    }

    public boolean getBoolean(String key, boolean defValue) {
        try {
            if (sCache != null && sCache.containsKey(key)) {
                return ((Boolean) sCache.get(key)).booleanValue();
            }
        } catch (Exception e) {
        }
        return mPreferenceHelper.getBoolean(key, defValue);
    }

    public boolean putBoolean(String key, boolean value) {
        sCache.put(key, Boolean.valueOf(value));
        return mPreferenceHelper.putBoolean(key, value);
    }

    public int getInt(String key, int defValue) {
        if (sCache.containsKey(key)) {
            return ((Integer) sCache.get(key)).intValue();
        }
        return mPreferenceHelper.getInt(key, defValue);
    }

    public boolean putInt(String key, int value) {
        sCache.put(key, Integer.valueOf(value));
        return mPreferenceHelper.putInt(key, value);
    }

    public boolean putString(String key, String value) {
        sCache.put(key, value);
        return mPreferenceHelper.putString(key, value);
    }

    public String getString(String key, String defValue) {
        if (sCache.containsKey(key)) {
            return (String) sCache.get(key);
        }
        return mPreferenceHelper.getString(key, defValue);
    }

    public boolean putLong(String key, long value) {
        sCache.put(key, Long.valueOf(value));
        return mPreferenceHelper.putLong(key, value);
    }

    public long getLong(String key, long defValue) {
        if (sCache.containsKey(key)) {
            return ((Long) sCache.get(key)).longValue();
        }
        return mPreferenceHelper.getLong(key, defValue);
    }

    public boolean removeKey(String key) {
        sCache.remove(key);
        return mPreferenceHelper.remove(key);
    }

    public boolean containsKey(String key) {
        if (sCache.containsKey(key) || mPreferenceHelper.contains(key)) {
            return true;
        }
        return false;
    }
}
