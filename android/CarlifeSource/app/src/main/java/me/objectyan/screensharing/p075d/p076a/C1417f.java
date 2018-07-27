package com.baidu.carlife.p075d.p076a;

import android.util.Log;
import com.baidu.carlife.wechat.p105a.p106a.C2359b;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p003b.C0337r.C0336a;
import p003b.C0345w;
import p003b.ab;
import p003b.ab.C0298a;
import p003b.ac;
import p003b.ad;

/* compiled from: HttpUtils */
/* renamed from: com.baidu.carlife.d.a.f */
final class C1417f {
    /* renamed from: a */
    private static final String f4149a = "network_http";

    C1417f() {
    }

    /* renamed from: b */
    private static C0298a m5219b(String url) {
        return new C0298a().m838a(url).m845b("User-Agent", C2359b.f7809a);
    }

    /* renamed from: a */
    static ab m5215a(String url) {
        Log.i(f4149a, "GET url=" + url);
        return C1417f.m5219b(url).m849d();
    }

    /* renamed from: a */
    static ab m5217a(String url, Map<String, String> getParams) {
        int index = 0;
        StringBuffer paramBuffer = new StringBuffer();
        try {
            for (String key : getParams.keySet()) {
                if (index > 0) {
                    paramBuffer.append("&");
                }
                paramBuffer.append(String.format("%s=%s", new Object[]{key, URLEncoder.encode((String) getParams.get(key), "UTF-8")}));
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        url = String.format("%s?%s", new Object[]{url, paramBuffer.toString()});
        Log.i(f4149a, "GET url=" + url);
        return C1417f.m5219b(url).m849d();
    }

    /* renamed from: b */
    static ab m5220b(String url, Map<String, String> getParams) {
        int index = 0;
        StringBuffer paramBuffer = new StringBuffer();
        try {
            for (String key : getParams.keySet()) {
                if (index > 0) {
                    paramBuffer.append("&");
                }
                if ("data".equals(key)) {
                    paramBuffer.append(String.format("%s=%s", new Object[]{key, getParams.get(key)}));
                } else {
                    paramBuffer.append(String.format("%s=%s", new Object[]{key, URLEncoder.encode((String) getParams.get(key), "UTF-8")}));
                }
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        url = String.format("%s?%s", new Object[]{url, paramBuffer.toString()});
        Log.i(f4149a, "GET url=" + url);
        return C1417f.m5219b(url).m849d();
    }

    /* renamed from: c */
    static ab m5221c(String url, Map<String, String> postParams) {
        if (postParams == null) {
            postParams = new HashMap();
        }
        C0336a formBodyBuilder = new C0336a();
        for (Entry<String, String> entry : postParams.entrySet()) {
            formBodyBuilder.m1090a((String) entry.getKey(), (String) entry.getValue());
        }
        return C1417f.m5219b(url).m833a(formBodyBuilder.m1091a()).m849d();
    }

    /* renamed from: a */
    static ab m5216a(String url, String postJson) {
        return C1417f.m5219b(url).m833a(ac.m861a(C0345w.m1220a("application/json; charset=utf-8"), postJson)).m849d();
    }

    /* renamed from: a */
    static Map<String, String> m5218a(ad response) {
        Map<String, String> cookieMap = new HashMap();
        try {
            List<String> cookies = response.m898a("Set-Cookie");
            int len = cookies.size();
            for (int i = 0; i < len; i++) {
                String cookie = ((String) cookies.get(i)).split(";")[0].trim();
                cookieMap.put(cookie.split("=")[0], cookie.split("=")[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cookieMap;
    }
}
