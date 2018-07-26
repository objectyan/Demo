package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p023b.C0433c;
import com.baidu.android.pushservice.p023b.C0434d;
import com.baidu.android.pushservice.p023b.C0439h;
import com.baidu.android.pushservice.p031j.C0578p;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.a.h */
public class C0607h extends C0596c {
    public C0607h(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static String[] m2699a(Context context, int i, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (!C0578p.m2538a(context, bArr, str, str2, bArr2)) {
            return null;
        }
        String[] strArr = new String[2];
        if (i == C0612l.MSG_TYPE_SINGLE_PRIVATE.m2706a() || i == C0612l.MSG_TYPE_MULTI_PRIVATE.m2706a()) {
            strArr[0] = new String(bArr2);
            strArr[1] = null;
        } else if (i == C0612l.MSG_TYPE_PRIVATE_MESSAGE.m2706a()) {
            PublicMsg a = C0609j.m2702a(context, str2, str, bArr2);
            strArr[0] = a.mDescription;
            strArr[1] = a.mCustomContent;
        }
        return strArr;
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        int i;
        String e = c0626k.m2766e();
        String h = c0626k.m2769h();
        int i2 = c0626k.m2770i();
        byte[] j = c0626k.m2771j();
        String f = c0626k.m2767f();
        int i3 = 0;
        C0434d a = C0434d.m1889a(this.a, e);
        String str = null;
        if (!TextUtils.isEmpty(f) && C0578p.m2558c(this.a, f)) {
            str = f;
        } else if (a.m1890a() == C0433c.PUSH_CLIENT) {
            str = a.f1368a.m1867c();
        } else if (a.m1890a() == C0433c.SDK_CLIENT) {
            str = a.f1369b.m1867c();
        }
        switch (a.m1890a()) {
            case PUSH_CLIENT:
                j = C0578p.m2542a(this.a, h, bArr, j, str);
                try {
                    this.a.getPackageManager().getPackageInfo(str, 128);
                    PublicMsg a2 = C0609j.m2702a(this.a, h, e, bArr);
                    boolean a3 = m2680a(bArr);
                    if (a2 == null) {
                        i = 0;
                        break;
                    }
                    String str2;
                    Intent intent = new Intent();
                    if (C0430a.m1857b() > 0) {
                        intent.putExtra("bd.message.rate.GET", System.currentTimeMillis());
                        intent.putExtra("bd.message.rate.MH", true);
                    }
                    if (a3) {
                        str2 = "com.baidu.android.pushservice.action.FB_MESSAGE";
                    } else {
                        f = PushConstants.ACTION_MESSAGE;
                        intent.putExtra("msg_id", h);
                        str2 = f;
                    }
                    intent.putExtra("message_string", a2.mDescription);
                    intent.putExtra("message_id", h);
                    intent.putExtra("baidu_message_type", i2);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("app_id", e);
                    intent.putExtra("baidu_message_secur_info", j);
                    if (!TextUtils.isEmpty(a2.mCustomContent)) {
                        try {
                            JSONObject jSONObject = new JSONObject(a2.mCustomContent);
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                f = (String) keys.next();
                                intent.putExtra(f, jSONObject.getString(f));
                            }
                            intent.putExtra("extra_extra_custom_content", a2.mCustomContent);
                        } catch (JSONException e2) {
                        }
                    }
                    if (C0430a.m1857b() > 0) {
                        intent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
                    }
                    i = C0578p.m2514a(this.a, intent, str2, str);
                    C0578p.m2546b(">>> Deliver message to client: " + str + " msg: " + a2.mDescription + " result: " + i, this.a);
                    break;
                } catch (NameNotFoundException e3) {
                    i = 8;
                    str = ">>> NOT deliver to app: " + a.f1368a.m1867c() + ", package has been uninstalled.";
                    C0603f.m2694a(this.a, e);
                    C0578p.m2546b(str, this.a);
                    break;
                }
            case SDK_CLIENT:
                byte[] a4 = C0578p.m2542a(this.a, h, bArr, j, str);
                try {
                    Object optString = new JSONObject(new String(bArr)).optString("description");
                    if (TextUtils.isEmpty(optString)) {
                        i3 = 2;
                    } else {
                        try {
                            this.a.getPackageManager().getPackageInfo(str, 128);
                            Intent intent2 = new Intent();
                            intent2.setPackage(a.f1369b.m1867c());
                            intent2.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                            intent2.putExtra("message_string", optString);
                            intent2.setFlags(32);
                            intent2.putExtra("baidu_message_body", bArr);
                            intent2.putExtra("baidu_message_secur_info", a4);
                            intent2.putExtra("message_id", h);
                            intent2.putExtra("baidu_message_type", i2);
                            C0578p.m2545b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", str);
                        } catch (NameNotFoundException e4) {
                            ">>> NOT deliver to app: " + a.f1369b.m1867c() + ", package has been uninstalled.";
                            C0439h.m1902a(this.a).m1893a(a.f1369b, false);
                            i3 = 8;
                        }
                    }
                    i = i3;
                    break;
                } catch (JSONException e5) {
                    i = 2;
                    break;
                }
            default:
                i = 7;
                str = ">>> NOT found client for privateMessageHandler appid " + e;
                if (VERSION.SDK_INT < 24) {
                    C0603f.m2694a(this.a, e);
                }
                C0578p.m2546b(str, this.a);
                break;
        }
        C0621g c0621g = new C0621g();
        c0621g.m2740a(i);
        return c0621g;
    }
}
