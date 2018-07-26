package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.a.b */
public class C0598b extends C0596c {
    /* renamed from: b */
    private Context f1903b;

    public C0598b(Context context) {
        super(context);
        this.f1903b = context.getApplicationContext();
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        String string;
        int i;
        JSONObject jSONObject;
        JSONException e;
        Intent intent = null;
        String h = c0626k.m2769h();
        C0621g c0621g = new C0621g();
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(new String(bArr));
            try {
                string = jSONObject2.getString(VoiceKey.ACTION);
                JSONObject jSONObject3 = jSONObject2;
                i = 1;
                jSONObject = jSONObject3;
            } catch (JSONException e2) {
                e = e2;
                C0527a.m2218b("BaiduSupperHandler", "Supper message parsing action Fail:\r\n" + e.getMessage(), this.f1903b);
                jSONObject = jSONObject2;
                string = null;
                i = 0;
                if (i != 0) {
                }
                intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
                intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                C0578p.m2546b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
                if (intent != null) {
                    c0621g.m2740a(2);
                } else {
                    intent.setFlags(32);
                    this.a.sendBroadcast(intent);
                    c0621g.m2740a(0);
                }
                return c0621g;
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject2 = null;
            C0527a.m2218b("BaiduSupperHandler", "Supper message parsing action Fail:\r\n" + e.getMessage(), this.f1903b);
            jSONObject = jSONObject2;
            string = null;
            i = 0;
            if (i != 0) {
            }
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
            C0578p.m2546b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
            if (intent != null) {
                intent.setFlags(32);
                this.a.sendBroadcast(intent);
                c0621g.m2740a(0);
            } else {
                c0621g.m2740a(2);
            }
            return c0621g;
        }
        if (i != 0 || TextUtils.isEmpty(string)) {
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
            C0578p.m2546b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
        } else if (string.equalsIgnoreCase("push.NOTIFICATION")) {
            try {
                C0603f.m2696a(this.a, !jSONObject.isNull("title") ? jSONObject.getString("title") : null, jSONObject.getString("description"), !jSONObject.isNull("iconUrl") ? jSONObject.getString("iconUrl") : null, !jSONObject.isNull("url") ? jSONObject.getString("url") : null, h);
            } catch (JSONException e4) {
                C0527a.m2218b("BaiduSupperHandler", "Supper message parsing notification action Fail:\r\n" + e4.getMessage(), this.f1903b);
            }
        } else {
            String string2;
            try {
                string2 = jSONObject.getString(PushConstants.EXTRA_PUSH_MESSAGE);
            } catch (JSONException e5) {
                string2 = null;
            }
            intent = new Intent(string);
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, string2);
        }
        if (intent != null) {
            intent.setFlags(32);
            this.a.sendBroadcast(intent);
            c0621g.m2740a(0);
        } else {
            c0621g.m2740a(2);
        }
        return c0621g;
    }
}
