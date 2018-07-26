package com.baidu.che.codriver.util;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/* compiled from: VolleyUtil */
/* renamed from: com.baidu.che.codriver.util.o */
public class C2735o {
    /* renamed from: a */
    private static RequestQueue f8965a;

    /* renamed from: a */
    public static RequestQueue m10252a() {
        if (f8965a == null) {
            C2735o.m10253a(C2716c.m10141a());
        }
        return f8965a;
    }

    /* renamed from: a */
    private static void m10253a(Context context) {
        if (f8965a != null) {
            f8965a.stop();
        }
        f8965a = Volley.newRequestQueue(context);
    }

    /* renamed from: a */
    public static void m10254a(Request request) {
        if (f8965a != null) {
            f8965a.add(request);
            return;
        }
        C2735o.m10253a(C2716c.m10141a());
        f8965a.add(request);
    }

    /* renamed from: b */
    public static void m10255b() {
        if (f8965a != null) {
            f8965a.stop();
        }
        f8965a = null;
    }
}
