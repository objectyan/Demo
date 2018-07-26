package com.tencent.mm.sdk.p288c;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.mm.sdk.p287b.C6094b;

/* renamed from: com.tencent.mm.sdk.c.a */
public final class C6105a {

    /* renamed from: com.tencent.mm.sdk.c.a$a */
    public static final class C6103a {
        /* renamed from: a */
        public static Object m21699a(int i, String str) {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    try {
                        C6094b.m21682b("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.sdk.c.a$b */
    public static final class C6104b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
