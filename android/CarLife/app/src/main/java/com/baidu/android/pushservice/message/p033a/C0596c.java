package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.a.c */
public abstract class C0596c {
    /* renamed from: a */
    protected Context f1902a;

    public C0596c(Context context) {
        this.f1902a = context;
    }

    /* renamed from: a */
    public abstract C0621g mo1294a(C0626k c0626k, byte[] bArr);

    /* renamed from: a */
    protected boolean m2680a(byte[] bArr) {
        int parseInt;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            parseInt = !jSONObject.isNull("bccs_fb") ? Integer.parseInt(jSONObject.getString("bccs_fb")) : 0;
        } catch (Exception e) {
            parseInt = 0;
        }
        return parseInt == 1;
    }
}
