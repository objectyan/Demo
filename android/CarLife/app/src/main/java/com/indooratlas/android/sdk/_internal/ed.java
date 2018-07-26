package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class ed {
    @TargetApi(21)
    /* renamed from: a */
    public static String m20399a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 12) {
            return bundle.getString(str, null);
        }
        String string = bundle.getString(str);
        if (string != null) {
            return string;
        }
        return null;
    }
}
