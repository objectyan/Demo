package com.baidu.platform.comapi.map.config;

import android.content.Context;
import com.baidu.platform.comapi.C2907c;
import java.util.concurrent.ConcurrentHashMap;

public class Preferences extends CachePreference {
    public static final String SP_NAME = "map_pref";
    private static final ConcurrentHashMap<String, Preferences> cache = new ConcurrentHashMap();

    private Preferences(Context context, String cfgName) {
        super(context, cfgName);
    }

    public static synchronized Preferences build(Context context, String cfgName) {
        Preferences preferences;
        synchronized (Preferences.class) {
            if (cfgName == null) {
                cfgName = SP_NAME;
            }
            if (context == null) {
                context = C2907c.f();
            }
            if (cache.containsKey(cfgName)) {
                preferences = (Preferences) cache.get(cfgName);
            } else {
                Preferences preferences2 = new Preferences(context, cfgName);
                cache.put(cfgName, preferences2);
                preferences = preferences2;
            }
        }
        return preferences;
    }

    public static Preferences build(Context context) {
        return build(context, SP_NAME);
    }
}
