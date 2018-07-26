package com.facebook.p135b.p137b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.common.p257e.C5320a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: DiskStorageCacheUtil */
/* renamed from: com.facebook.b.b.f */
public final class C5283f {
    /* renamed from: a */
    private static final String f21844a = C5283f.class.getSimpleName();

    private C5283f() {
    }

    /* renamed from: a */
    protected static void m18002a(Integer hashKey, String resourceId, SharedPreferences sharedPreferences) {
        Editor editor = sharedPreferences.edit();
        editor.putString(String.valueOf(hashKey), resourceId);
        editor.apply();
    }

    /* renamed from: a */
    protected static void m18001a(Integer hashKey, SharedPreferences sharedPreferences) {
        Editor editor = sharedPreferences.edit();
        editor.remove(String.valueOf(hashKey));
        editor.apply();
    }

    /* renamed from: a */
    protected static synchronized Map<Integer, String> m17999a(@Nullable SharedPreferences sharedPreferences, Set<String> resourceIndex) {
        Map<Integer, String> index;
        synchronized (C5283f.class) {
            index = new HashMap();
            if (sharedPreferences != null) {
                Map<String, ?> allEntries = sharedPreferences.getAll();
                Editor editor = sharedPreferences.edit();
                for (Entry<String, ?> entry : allEntries.entrySet()) {
                    if (entry.getValue() instanceof String) {
                        Integer key = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        if (resourceIndex.contains(entry.getValue())) {
                            index.put(key, (String) entry.getValue());
                        } else {
                            editor.remove(String.valueOf(entry.getKey()));
                        }
                    } else {
                        C5320a.m18184e(f21844a, "SharedPreference doesn't store right data type");
                    }
                }
                editor.apply();
            }
        }
        return index;
    }

    /* renamed from: a */
    protected static void m18000a(SharedPreferences sharedPreferences) {
        Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
