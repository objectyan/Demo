package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p026e.C0486b;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.android.pushservice.p031j.C0573l;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p032k.C0582b;
import com.baidu.android.pushservice.p032k.C0589e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.a.d */
public class C0600d extends C0596c {
    public C0600d(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static void m2684a(Context context) {
        long c = C0574m.m2474c(context, "com.baidu.pushservice.internal.bind.LATEST_TIME");
        final long currentTimeMillis = System.currentTimeMillis();
        c = currentTimeMillis - c;
        if (C0572k.m2457a(context) && c > 259200000) {
            final Context context2 = context;
            C0559d.m2387a().m2388a(new C0420c("uploadInternalBindApps", (short) 95) {
                /* renamed from: a */
                public void mo1272a() {
                    try {
                        C0574m.m2467a(context2, "com.baidu.pushservice.internal.bind.LATEST_TIME", currentTimeMillis);
                        String b = C0600d.m2688d(context2);
                        HashMap hashMap = new HashMap();
                        C0486b.m2078a(hashMap);
                        hashMap.put("device_type", "3");
                        hashMap.put("params", b);
                        int i = 0;
                        do {
                            i++;
                            if (C0521b.m2164a("https://api.tuisong.baidu.com/rest/3.0/oem/upload_unbind_oem", "POST", hashMap, "BCCS_SDK/3.0").m2162b() == 200) {
                                return;
                            }
                        } while (i < 2);
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m2685a(String str, String str2, Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.addFlags(32);
        intent.putExtra("method_version", "V2");
        intent.putExtra("secret_key", str);
        intent.putExtra(PushConstants.PACKAGE_NAME, str2);
        intent.putExtra("is_baidu_internal_bind", "true");
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra("bind_status", 0);
        intent.putExtra("push_sdk_version", C0430a.m1854a());
        if (VERSION.SDK_INT >= 19) {
            intent.putExtra("bind_notify_status", C0573l.m2463a(context) + "");
        }
        C0577o.m2484a(context, intent);
    }

    /* renamed from: c */
    private static String m2687c(Context context) {
        ArrayList q = C0578p.m2592q(context);
        if (!q.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = q.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!C0578p.m2607x(context, str)) {
                    Context v = C0578p.m2602v(context, str);
                    String w = C0578p.m2605w(v, str);
                    CharSequence a = C0578p.m2519a(v, str, "bp_reg_key");
                    if (!TextUtils.isEmpty(a)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("packagename", str);
                            jSONObject.put("apikey", a);
                            jSONObject.put("installtime", w);
                            jSONObject.put("pkgMD5info", C0578p.m2594r(v, str));
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray.toString();
            }
        }
        return null;
    }

    /* renamed from: d */
    private static String m2688d(Context context) throws Exception {
        CharSequence c = C0600d.m2687c(context);
        if (TextUtils.isEmpty(c)) {
            throw new Exception("NO INTERNAL BIND APP INFOS！");
        }
        JSONObject jSONObject = new JSONObject();
        String a = PushSettings.m1816a(context);
        String a2 = C0589e.m2639a(context);
        jSONObject.put("channel_id", a);
        jSONObject.put("cuid", a2);
        jSONObject.put("aksinfo", c);
        return C0582b.m2629a(BaiduAppSSOJni.encryptR(jSONObject.toString().getBytes(), 2), "utf-8");
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        int i = 0;
        c0626k.m2769h();
        c0626k.m2770i();
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (!jSONObject.isNull("custom_content")) {
                Object string = jSONObject.getString("custom_content");
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    int length = jSONArray.length();
                    if (length > 0) {
                        ArrayList q = C0578p.m2592q(this.a);
                        int i2 = 0;
                        while (i2 < length) {
                            int i3;
                            jSONObject = (JSONObject) jSONArray.get(i2);
                            String string2 = jSONObject.getString("package_name");
                            if (q.contains(string2)) {
                                string = jSONObject.getString("apikey");
                                if (!(TextUtils.isEmpty(string2) || TextUtils.isEmpty(string) || C0578p.m2607x(this.a, string2))) {
                                    m2685a(string, string2, this.a);
                                }
                                i3 = i;
                            } else {
                                i3 = 8;
                            }
                            i2++;
                            i = i3;
                        }
                    }
                }
            }
        } catch (Exception e) {
            i = 2;
        }
        C0621g c0621g = new C0621g();
        c0621g.m2740a(i);
        return c0621g;
    }
}
