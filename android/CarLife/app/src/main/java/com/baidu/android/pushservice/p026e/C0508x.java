package com.baidu.android.pushservice.p026e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.C0528g;
import com.baidu.android.pushservice.C0554h;
import com.baidu.android.pushservice.C0580j;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p026e.C0485a.C0484a;
import com.baidu.android.pushservice.p027f.C0520a;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p032k.C0582b;
import com.baidu.android.pushservice.p032k.C0589e;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController$BNMapConfigParams;
import com.baidu.speech.asr.SpeechConstant;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.e.x */
public class C0508x implements Runnable {
    /* renamed from: a */
    private Context f1631a;
    /* renamed from: b */
    private int f1632b = 3;
    /* renamed from: c */
    private int f1633c = 0;
    /* renamed from: d */
    private boolean f1634d = false;
    /* renamed from: e */
    private boolean f1635e = true;
    /* renamed from: f */
    private C0484a f1636f;

    public C0508x(Context context, C0484a c0484a) {
        this.f1631a = context.getApplicationContext();
        this.f1636f = c0484a;
    }

    /* renamed from: b */
    private boolean m2106b() {
        boolean z;
        String d = C0554h.m2381d();
        if (this.f1633c > 2) {
            Object b = C0554h.m2375b(this.f1631a, this.f1635e);
            this.f1635e = false;
            if (!TextUtils.isEmpty(b)) {
                d = d.replace(C0554h.m2374b(), "http://" + b);
            }
        }
        InputStream inputStream = null;
        try {
            C0520a a = C0521b.m2163a(d, "POST", m2107c());
            int b2 = a.m2162b();
            inputStream = a.m2159a();
            if (b2 == 200) {
                JSONObject jSONObject = new JSONObject(C0532b.m2252a(inputStream)).getJSONObject("response_params");
                if (jSONObject != null) {
                    String string = jSONObject.getString("channel_id");
                    d = "";
                    d = C0554h.m2383f() ? jSONObject.getString("rsa_channel_token") : jSONObject.getString("channel_token");
                    jSONObject.getString("expires_time");
                    C0580j.m2614a(this.f1631a).m2617a(string, d);
                    z = true;
                } else {
                    z = false;
                }
            } else {
                C0532b.m2252a(inputStream);
                z = false;
            }
            try {
                this.f1633c = 0;
                if (inputStream == null) {
                    this.f1634d = true;
                } else {
                    this.f1634d = false;
                }
                C0521b.m2169a(inputStream);
            } catch (IOException e) {
                try {
                    this.f1634d = true;
                    C0521b.m2169a(inputStream);
                    return z;
                } catch (Throwable th) {
                    C0521b.m2169a(inputStream);
                }
            } catch (Exception e2) {
                this.f1634d = false;
                C0521b.m2169a(inputStream);
                return z;
            }
        } catch (IOException e3) {
            z = false;
            this.f1634d = true;
            C0521b.m2169a(inputStream);
            return z;
        } catch (Exception e4) {
            z = false;
            this.f1634d = false;
            C0521b.m2169a(inputStream);
            return z;
        }
        return z;
    }

    /* renamed from: c */
    private HashMap<String, String> m2107c() throws Exception {
        int i = 1;
        HashMap hashMap = new HashMap();
        hashMap.put("method", "token");
        C0486b.m2078a(hashMap);
        hashMap.put("device_type", "3");
        String b = C0589e.m2651b(this.f1631a);
        if (C0554h.m2383f()) {
            hashMap.put("rsa_device_id", C0582b.m2629a(BaiduAppSSOJni.encryptR(b.getBytes(), 1), "utf-8"));
        } else {
            hashMap.put("device_id", b);
        }
        hashMap.put("device_name", Build.MODEL);
        int b2 = C0574m.m2471b(this.f1631a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", -1);
        String a = C0574m.m2465a(this.f1631a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (b2 == 2) {
            hashMap.put("bduss", C0574m.m2465a(this.f1631a, "com.baidu.android.pushservice.PushManager.BDUSS"));
            hashMap.put(SpeechConstant.APP_ID, a);
        } else if (b2 == 1) {
            hashMap.put("access_token", a);
        } else {
            hashMap.put("apikey", a);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_level", VERSION.SDK_INT);
        int[] b3 = C0578p.m2552b(this.f1631a);
        jSONObject.put(BNMapController$BNMapConfigParams.KEY_SCREEN_HEIGHT, b3[0]);
        jSONObject.put(BNMapController$BNMapConfigParams.KEY_SCREEN_WIDTH, b3[1]);
        Object obj = Build.MODEL;
        if (obj.length() > 128) {
            obj = obj.substring(0, TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        jSONObject.put("model", obj);
        jSONObject.put("isroot", C0578p.m2533a(this.f1631a) ? 1 : 0);
        b = "is_baidu_app";
        if (!C0578p.m2568e(this.f1631a, this.f1631a.getPackageName())) {
            i = 0;
        }
        jSONObject.put(b, i);
        jSONObject.put("push_sdk_version", C0430a.m1854a());
        obj = Build.MANUFACTURER;
        if (obj.length() > 128) {
            obj = obj.substring(0, TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        jSONObject.put("manufacturer", obj);
        hashMap.put("info", jSONObject.toString());
        return hashMap;
    }

    /* renamed from: d */
    private void m2108d() {
        this.f1633c++;
        if (this.f1633c < this.f1632b) {
            try {
                Thread.sleep((long) (((1 << (this.f1633c - 1)) * 5) * 1000));
                return;
            } catch (InterruptedException e) {
                return;
            }
        }
        this.f1634d = false;
    }

    /* renamed from: a */
    protected void m2109a() {
        boolean b;
        do {
            b = m2106b();
            if (this.f1634d) {
                m2108d();
            }
            if (this.f1632b <= 0) {
                break;
            }
        } while (this.f1634d);
        if (this.f1636f != null) {
            this.f1636f.m2062a(Boolean.valueOf(b));
        } else {
            C0578p.m2546b("TokenRequester#execute-->mListener is null !!!!!", this.f1631a);
        }
        C0578p.m2546b("TokenRequester#execute-->RequestTokenThread connectResult: " + b, this.f1631a);
        if (b) {
            C0486b.m2076a(this.f1631a);
            if (C0528g.f1705a != null) {
                C0578p.m2546b("TokenRequester#execute-->TokenRequester start PushService after Request finish. ", this.f1631a);
                C0577o.m2484a(this.f1631a, new Intent());
                return;
            }
            return;
        }
        C0578p.m2565e(this.f1631a);
    }

    /* renamed from: a */
    public void m2110a(int i) {
        this.f1632b = i;
    }

    public void run() {
        m2109a();
    }
}
