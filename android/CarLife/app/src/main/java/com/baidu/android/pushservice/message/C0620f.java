package com.baidu.android.pushservice.message;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.C0580j;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p031j.C0569h;
import com.baidu.android.pushservice.p031j.C0570i;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p032k.C0582b;
import com.baidu.android.pushservice.p032k.C0589e;
import com.baidu.carlife.core.audio.C1163a;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.util.common.SystemAuth;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.f */
public class C0620f extends C0618d {
    /* renamed from: b */
    private C0569h f1940b;

    public C0620f(Context context) {
        super(context);
    }

    /* renamed from: a */
    private byte[] m2726a(long j, C0621g c0621g) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C0570i c0570i = new C0570i(byteArrayOutputStream);
        try {
            c0570i.m2453a(j);
            c0570i.m2455b(c0621g.m2739a());
            c0570i.m2455b(0);
            if (c0621g.m2742b() != null) {
                c0570i.m2454a(c0621g.m2742b());
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
            try {
                c0570i.m2451a();
                return toByteArray;
            } catch (IOException e2) {
                return toByteArray;
            }
        } catch (Exception e3) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
            }
            try {
                c0570i.m2451a();
            } catch (IOException e5) {
            }
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
            }
            try {
                c0570i.m2451a();
            } catch (IOException e7) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    private byte[] m2727a(String str, int i) {
        Object obj = new byte[i];
        if (str != null) {
            Object bytes = str.getBytes();
            System.arraycopy(bytes, 0, obj, 0, Math.min(obj.length, bytes.length));
        }
        return obj;
    }

    /* renamed from: a */
    private byte[] m2728a(short s, byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C0570i c0570i = new C0570i(byteArrayOutputStream);
        int length = bArr != null ? bArr.length : 0;
        try {
            c0570i.m2452a((int) s);
            if (!(s == C0622h.MSG_ID_TINY_HEARTBEAT_CLIENT.m2744a() || s == C0622h.MSG_ID_TINY_HEARTBEAT_SERVER.m2744a())) {
                c0570i.m2452a(C0430a.m1854a());
                c0570i.m2455b(0);
                c0570i.m2454a(m2727a(C0578p.m2568e(this.a, this.a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                c0570i.m2455b(-76508268);
                c0570i.m2455b(1);
                c0570i.m2455b(length);
                if (bArr != null) {
                    c0570i.m2454a(bArr);
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            C0521b.m2169a(byteArrayOutputStream);
            try {
                c0570i.m2451a();
                return toByteArray;
            } catch (Exception e) {
                return toByteArray;
            }
        } catch (Exception e2) {
            C0521b.m2169a(byteArrayOutputStream);
            try {
                c0570i.m2451a();
            } catch (Exception e3) {
            }
            return null;
        } catch (Throwable th) {
            C0521b.m2169a(byteArrayOutputStream);
            try {
                c0570i.m2451a();
            } catch (Exception e4) {
            }
        }
    }

    /* renamed from: d */
    private String m2729d() {
        try {
            switch (C0578p.m2598t(this.a)) {
                case 1:
                    return C1981b.f6365e;
                case 2:
                    return "2g";
                case 3:
                    return "3g";
                case 4:
                    return "4g";
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: e */
    private String m2730e() {
        try {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            return defaultDisplay.getHeight() + JNISearchConst.LAYER_ID_DIVIDER + defaultDisplay.getWidth();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: f */
    private String m2731f() {
        try {
            String simOperator = ((TelephonyManager) this.a.getSystemService("phone")).getSimOperator();
            if (simOperator != null) {
                if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                    return "cm";
                }
                if (simOperator.equals("46001")) {
                    return "uni";
                }
                if (simOperator.equals("46003")) {
                    return Config.EXCEPTION_CRASH_TYPE;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: g */
    private String m2732g() {
        try {
            return C0578p.m2601u(this.a, SystemAuth.READ_PHONE_STATE_AUTH) ? ((TelephonyManager) this.a.getSystemService("phone")).getSubscriberId() : null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: h */
    private String m2733h() {
        try {
            return ((WifiManager) this.a.getSystemService(C1981b.f6365e)).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public C0619e mo1296a(byte[] bArr, int i) throws IOException {
        int i2 = C1163a.f3005i;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        this.f1940b = new C0569h(byteArrayInputStream);
        short c = this.f1940b.m2449c();
        C0619e c0619e = new C0619e(c);
        if (c == C0622h.MSG_ID_TINY_HEARTBEAT_SERVER.m2744a() || c == C0622h.MSG_ID_TINY_HEARTBEAT_CLIENT.m2744a()) {
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (this.f1940b != null) {
                this.f1940b.m2446a();
            }
            return c0619e;
        }
        byte[] bArr2;
        this.f1940b.m2449c();
        this.f1940b.m2448b();
        this.f1940b.m2447a(new byte[16]);
        this.f1940b.m2448b();
        this.f1940b.m2448b();
        int b = this.f1940b.m2448b();
        if (b > 0) {
            if (b <= C1163a.f3005i) {
                i2 = b;
            }
            bArr2 = new byte[i2];
            this.f1940b.m2447a(bArr2);
        } else {
            bArr2 = null;
        }
        c0619e.f1935c = bArr2;
        byteArrayInputStream.close();
        if (this.f1940b != null) {
            this.f1940b.m2446a();
        }
        return c0619e;
    }

    /* renamed from: a */
    public void mo1297a(int i) {
        JSONObject jSONObject = new JSONObject();
        Object obj = null;
        try {
            jSONObject.put("channel_token", C0580j.m2614a(this.a).m2618b());
            jSONObject.put("channel_id", C0580j.m2614a(this.a).m2615a());
            jSONObject.put("sa_mode", C0448d.m1932a(this.a).m1952b());
            jSONObject.put("highest_version", C0448d.m1932a(this.a).m1954d());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            if (C0578p.m2502F(this.a)) {
                jSONObject.put("connect_version", 3);
                Object obj2 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(obj2) && obj2.length() <= 128) {
                    jSONObject.put("manufacture", obj2);
                }
            } else {
                jSONObject.put("connect_version", 2);
            }
            jSONObject.put("tiny_msghead", 1);
            jSONObject.put("alarm_function", 1);
            JSONObject jSONObject2 = new JSONObject();
            String str = Build.MODEL;
            if (!(str == null || str == "")) {
                jSONObject2.put("model", str);
            }
            str = m2731f();
            if (!(str == null || str == "")) {
                jSONObject2.put("carrier", str);
            }
            str = m2730e();
            if (!(str == null || str == "")) {
                jSONObject2.put("resolution", str);
            }
            str = m2729d();
            if (!(str == null || str == "")) {
                jSONObject2.put(C1981b.f6367g, str);
            }
            str = m2733h();
            if (!(str == null || str == "")) {
                jSONObject2.put("mac", str);
            }
            str = C0589e.m2639a(this.a);
            if (!(str == null || str == "")) {
                jSONObject2.put("cuid", str);
            }
            str = m2732g();
            if (!(str == null || str == "")) {
                jSONObject2.put("imsi", str);
            }
            int length = jSONObject2.toString().length();
            jSONObject.put("devinfo", C0582b.m2629a(BaiduAppSSOJni.encryptAES(jSONObject2.toString(), 1), "utf-8"));
            jSONObject.put("devinfolength", length);
            obj = jSONObject.toString();
        } catch (Exception e) {
        } catch (UnsatisfiedLinkError e2) {
        }
        if (!TextUtils.isEmpty(obj)) {
            byte[] a = m2728a(C0622h.MSG_ID_HANDSHAKE.m2744a(), obj.getBytes());
            C0619e c0619e = new C0619e(C0622h.MSG_ID_HANDSHAKE.m2744a());
            c0619e.f1935c = a;
            c0619e.f1936d = true;
            c0619e.m2721a(false);
            m2716a(c0619e);
        }
    }

    /* renamed from: b */
    public void mo1298b() {
    }

    /* renamed from: b */
    public void mo1299b(C0619e c0619e) throws Exception {
        if (c0619e != null) {
            C0615a c0615a = new C0615a(this.a);
            C0622h a = C0622h.m2743a(c0619e.f1933a);
            C0616c a2 = c0615a.m2710a(a);
            if (a2 != null) {
                C0621g a3 = a2.mo1295a(c0619e);
                if (c0619e.f1937e) {
                    C0619e c0619e2 = new C0619e(c0619e.f1933a);
                    if (a == C0622h.MSG_ID_PUSH_MSG) {
                        c0619e2.f1935c = m2728a(C0622h.MSG_ID_PUSH_MSG.m2744a(), m2726a(c0619e.m2725d().m2768g(), a3));
                    } else if (a == C0622h.MSG_ID_TINY_HEARTBEAT_SERVER || a == C0622h.MSG_ID_HEARTBEAT_SERVER) {
                        c0619e2.f1935c = m2728a(c0619e.f1933a, null);
                    }
                    m2716a(c0619e2);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo1300c() {
        byte[] a = m2728a(C0622h.MSG_ID_TINY_HEARTBEAT_CLIENT.m2744a(), null);
        C0619e c0619e = new C0619e(C0622h.MSG_ID_TINY_HEARTBEAT_CLIENT.m2744a());
        c0619e.f1935c = a;
        c0619e.f1936d = true;
        c0619e.m2721a(true);
        m2716a(c0619e);
    }
}
