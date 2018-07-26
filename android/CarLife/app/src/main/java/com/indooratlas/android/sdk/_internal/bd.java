package com.indooratlas.android.sdk._internal;

public final class bd {
    /* renamed from: a */
    public static final String f23074a;

    static {
        String str = null;
        String[] strArr = new String[]{"com.indooratlas.android.Config"};
        int i = 0;
        while (i <= 0) {
            String str2;
            try {
                str2 = (String) Class.forName(strArr[i]).getDeclaredField("AUTHORITY").get(null);
            } catch (Throwable th) {
                str2 = str;
            }
            i++;
            str = str2;
        }
        if (str == null) {
            str = "com.indooratlas.sdk";
        }
        f23074a = str;
    }
}
