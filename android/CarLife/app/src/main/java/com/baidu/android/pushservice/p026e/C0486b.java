package com.baidu.android.pushservice.p026e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p032k.C0590f;
import com.baidu.carlife.radio.p080b.C2125n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.baidu.android.pushservice.e.b */
public final class C0486b {
    /* renamed from: a */
    public static void m2076a(Context context) {
        C0486b.m2077a(context, (ArrayList) C0432b.m1870a(context).f1360a.clone());
    }

    /* renamed from: a */
    private static void m2077a(Context context, ArrayList<C0437f> arrayList) {
        if (arrayList != null) {
            PackageManager packageManager = context.getPackageManager();
            synchronized (arrayList) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0437f c0437f = (C0437f) it.next();
                    if (c0437f != null) {
                        CharSequence c = c0437f.m1867c();
                        try {
                            packageManager.getPackageInfo(c, 0);
                        } catch (Exception e) {
                            if (TextUtils.isEmpty(c)) {
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static void m2078a(HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put(C2125n.f6748P, currentTimeMillis + "");
        hashMap.put("expires", (86400 + currentTimeMillis) + "");
        hashMap.put("v", "1");
        try {
            hashMap.put("vcode", C0590f.m2669a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
        } catch (UnsupportedEncodingException e) {
        }
    }
}
