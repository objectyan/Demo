package com.baidu.platform.comapi.map.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.basic.BMExecutorsManager;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.C4824h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class CachePreference {
    private static final ExecutorService WORKER = BMExecutorsManager.newSingleThreadExecutor(new C4824h("cache_preference_worker", true));
    private final Map<String, Object> memoryCache = new ConcurrentHashMap(64);
    private final Map<String, JSONObject> memoryCacheJSON = new ConcurrentHashMap();
    private final SharedPreferences preferences;

    /* renamed from: com.baidu.platform.comapi.map.config.CachePreference$1 */
    class C47861 extends ConcurrentTask {
        C47861() {
        }

        public void run() {
            CachePreference.this.memoryCache.clear();
            CachePreference.this.preferences.edit().clear().apply();
        }
    }

    private class PutRunnable implements Runnable {
        private String key;
        private Object value;

        public PutRunnable(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public void run() {
            Editor edit = CachePreference.this.preferences.edit();
            if (this.value instanceof String) {
                edit.putString(this.key, (String) this.value);
            } else if (this.value instanceof Long) {
                edit.putLong(this.key, ((Long) this.value).longValue());
            } else if (this.value instanceof Integer) {
                edit.putInt(this.key, ((Integer) this.value).intValue());
            } else if (this.value instanceof Boolean) {
                edit.putBoolean(this.key, ((Boolean) this.value).booleanValue());
            } else if (this.value instanceof Float) {
                edit.putFloat(this.key, ((Float) this.value).floatValue());
            }
            edit.commit();
        }
    }

    public CachePreference(Context context, String name) {
        this.preferences = context.getSharedPreferences(name, 0);
    }

    public void putJSON(String key, JSONObject value) {
        if (!TextUtils.isEmpty(key) && value != null) {
            this.memoryCacheJSON.put(key, value);
            asyncPut(key, value.toString());
        }
    }

    public JSONObject getJSON(String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.memoryCacheJSON.containsKey(key)) {
            return (JSONObject) this.memoryCacheJSON.get(key);
        }
        String value = getString(key, "");
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        try {
            JSONObject json = new JSONObject(value);
            this.memoryCacheJSON.put(key, json);
            return json;
        } catch (JSONException e) {
            C2911f.a("CachePreference", "exception", e);
            return null;
        }
    }

    public boolean putString(String key, String value) {
        if (!(key == null || value == null)) {
            this.memoryCache.put(key, value);
            asyncPut(key, value);
        }
        return false;
    }

    public String getString(String key, String defaultValue) {
        Object value = this.memoryCache.get(key);
        if (value instanceof String) {
            return (String) value;
        }
        if (!this.preferences.contains(key)) {
            return defaultValue;
        }
        String newValue = this.preferences.getString(key, defaultValue);
        this.memoryCache.put(key, newValue);
        return newValue;
    }

    public boolean putInt(String key, int value) {
        this.memoryCache.put(key, Integer.valueOf(value));
        asyncPut(key, Integer.valueOf(value));
        return false;
    }

    public int getInt(String key, int defaultValue) {
        Object value = this.memoryCache.get(key);
        if (value instanceof Integer) {
            return ((Integer) value).intValue();
        }
        if (!this.preferences.contains(key)) {
            return defaultValue;
        }
        int newValue = this.preferences.getInt(key, defaultValue);
        this.memoryCache.put(key, Integer.valueOf(newValue));
        return newValue;
    }

    public boolean putFloat(String key, float value) {
        this.memoryCache.put(key, Float.valueOf(value));
        asyncPut(key, Float.valueOf(value));
        return false;
    }

    public float getFloat(String key, float defaultValue) {
        Object value = this.memoryCache.get(key);
        if (value instanceof Float) {
            return ((Float) value).floatValue();
        }
        if (!this.preferences.contains(key)) {
            return defaultValue;
        }
        float newValue = this.preferences.getFloat(key, defaultValue);
        this.memoryCache.put(key, Float.valueOf(newValue));
        return newValue;
    }

    public boolean putBoolean(String key, boolean value) {
        this.memoryCache.put(key, Boolean.valueOf(value));
        asyncPut(key, Boolean.valueOf(value));
        return true;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Object value = this.memoryCache.get(key);
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue();
        }
        if (!this.preferences.contains(key)) {
            return defaultValue;
        }
        boolean newValue = this.preferences.getBoolean(key, defaultValue);
        this.memoryCache.put(key, Boolean.valueOf(newValue));
        return newValue;
    }

    public boolean putLong(String key, long value) {
        this.memoryCache.put(key, Long.valueOf(value));
        asyncPut(key, Long.valueOf(value));
        return false;
    }

    public Long getLong(String key, long defaultValue) {
        Object value = this.memoryCache.get(key);
        if (value instanceof Long) {
            return (Long) value;
        }
        if (!this.preferences.contains(key)) {
            return Long.valueOf(defaultValue);
        }
        long newValue = this.preferences.getLong(key, defaultValue);
        this.memoryCache.put(key, Long.valueOf(newValue));
        return Long.valueOf(newValue);
    }

    public boolean contains(String key) {
        return this.memoryCache.containsKey(key) || this.preferences.contains(key);
    }

    public void clear() {
        ConcurrentManager.executeTask(Module.BASE_FRAMEWORK_MODULE, new C47861(), ScheduleConfig.forData());
    }

    public boolean removeKey(String key) {
        this.memoryCache.remove(key);
        return this.preferences.edit().remove(key).commit();
    }

    public Map<String, ?> getAll() {
        return this.preferences.getAll();
    }

    private void asyncPut(String key, Object value) {
        WORKER.execute(new PutRunnable(key, value));
    }
}
