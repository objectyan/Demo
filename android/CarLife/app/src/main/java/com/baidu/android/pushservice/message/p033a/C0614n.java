package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p031j.C0566e;
import com.baidu.android.pushservice.p031j.C0578p;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.a.n */
public class C0614n extends C0596c {
    public C0614n(Context context) {
        super(context);
    }

    /* renamed from: a */
    private C0621g m2708a(String str, long j, String str2, byte[] bArr, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
        intent.putExtra("message_id", str2);
        intent.putExtra("baidu_message_body", str3);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.setFlags(32);
        intent.setPackage(str);
        intent.setClassName(str, "com.baidu.android.pushservice.PushService");
        intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.ULTRON_DELIVER");
        intent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");
        intent.putExtra("bd.cross.request.SOURCE_PACKAGE", this.a.getPackageName());
        return new C0566e(this.a, intent).m2434b();
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        String e = c0626k.m2766e();
        String h = c0626k.m2769h();
        byte[] j = c0626k.m2771j();
        CharSequence f = c0626k.m2767f();
        C0621g c0621g = new C0621g();
        try {
            CharSequence charSequence;
            int i;
            String str;
            int i2;
            JSONObject jSONObject = new JSONObject(new String(bArr));
            int optInt = jSONObject.optInt("version_require", -1);
            int optInt2 = jSONObject.optInt("command_type");
            String optString = jSONObject.optString("command_body");
            if (TextUtils.isEmpty(e) || e.equals("0")) {
                charSequence = null;
                i = 0;
            } else {
                if (TextUtils.isEmpty(f) || !C0578p.m2558c(this.a, (String) f)) {
                    f = null;
                }
                C0437f d = C0432b.m1870a(this.a).m1886d(e);
                if (d == null || d.m1867c() == null) {
                    if (optInt2 == 1) {
                        i = 7;
                        charSequence = f;
                    }
                } else if (C0578p.m2558c(this.a, d.m1867c())) {
                    if (TextUtils.isEmpty(f)) {
                        f = d.m1867c();
                    }
                    if (optInt2 == 1 && d.m1868d() < optInt) {
                        i = 6;
                        charSequence = f;
                    }
                } else if (optInt2 == 1) {
                    i = 8;
                    charSequence = f;
                }
                i = 0;
                charSequence = f;
            }
            if (charSequence == null && i == 0) {
                C0437f a = C0432b.m1870a(this.a).m1877a(optInt, optInt2 == 2);
                if (a == null) {
                    str = charSequence;
                    i2 = 6;
                } else {
                    i2 = i;
                    str = a.m1867c();
                }
            } else {
                int i3 = i;
                CharSequence charSequence2 = charSequence;
                i2 = i3;
            }
            C0621g a2 = i2 == 0 ? m2708a(str, 0, h, j, optString) : c0621g;
            a2.m2740a(i2);
            return a2;
        } catch (JSONException e2) {
            c0621g.m2740a(2);
            return c0621g;
        }
    }
}
