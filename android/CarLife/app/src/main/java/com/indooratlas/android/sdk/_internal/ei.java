package com.indooratlas.android.sdk._internal;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;

public final class ei {
    /* renamed from: a */
    public static String m20417a(String str, Object... objArr) {
        try {
            return String.format(Locale.US, str, objArr);
        } catch (IllegalFormatException e) {
            return str + " " + Arrays.toString(objArr);
        }
    }

    /* renamed from: a */
    public static boolean m20418a(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        return charSequence.toString().trim().equals("");
    }
}
