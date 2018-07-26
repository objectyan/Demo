package com.baidu.carlife.push;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Utils */
/* renamed from: com.baidu.carlife.push.b */
public class C2104b {
    /* renamed from: a */
    public static final String f6682a = "PushDemoActivity";
    /* renamed from: b */
    public static String f6683b = "";

    /* renamed from: a */
    public static String m7890a(Context context, String metaKey) {
        Bundle metaData = null;
        String apiKey = null;
        if (context == null || metaKey == null) {
            return null;
        }
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (ai != null) {
                metaData = ai.metaData;
            }
            if (metaData != null) {
                apiKey = metaData.getString(metaKey);
            }
        } catch (NameNotFoundException e) {
            Log.e(f6682a, "error " + e.getMessage());
        }
        return apiKey;
    }

    /* renamed from: a */
    public static List<String> m7891a(String originalText) {
        if (TextUtils.isEmpty(originalText)) {
            return null;
        }
        List<String> tags = new ArrayList();
        int indexOfComma = originalText.indexOf(44);
        while (indexOfComma != -1) {
            tags.add(originalText.substring(0, indexOfComma));
            originalText = originalText.substring(indexOfComma + 1);
            indexOfComma = originalText.indexOf(44);
        }
        tags.add(originalText);
        return tags;
    }

    /* renamed from: a */
    public static String m7889a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("log_text", "");
    }

    /* renamed from: b */
    public static void m7892b(Context context, String text) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("log_text", text);
        editor.commit();
    }
}
