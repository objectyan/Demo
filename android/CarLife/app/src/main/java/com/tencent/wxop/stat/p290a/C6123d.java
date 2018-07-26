package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.tencent.wxop.stat.C6156f;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.p291b.C6135d;
import com.tencent.wxop.stat.p291b.C6150s;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.d */
public class C6123d extends C6119e {
    /* renamed from: a */
    private String f24770a;
    /* renamed from: m */
    private int f24771m;
    /* renamed from: n */
    private int f24772n = 100;
    /* renamed from: o */
    private Thread f24773o = null;

    public C6123d(Context context, int i, int i2, Throwable th, C6161k c6161k) {
        super(context, i, c6161k);
        m21725a(i2, th);
    }

    public C6123d(Context context, int i, int i2, Throwable th, Thread thread, C6161k c6161k) {
        super(context, i, c6161k);
        m21725a(i2, th);
        this.f24773o = thread;
    }

    public C6123d(Context context, int i, String str, int i2, int i3, Thread thread, C6161k c6161k) {
        super(context, i, c6161k);
        if (str != null) {
            if (i3 <= 0) {
                i3 = C6156f.m22048x();
            }
            if (str.length() <= i3) {
                this.f24770a = str;
            } else {
                this.f24770a = str.substring(0, i3);
            }
        }
        this.f24773o = thread;
        this.f24771m = i2;
    }

    /* renamed from: a */
    private void m21725a(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.f24770a = stringWriter.toString();
            this.f24771m = i;
            printWriter.close();
        }
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.ERROR;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        C6150s.m21920a(jSONObject, "er", this.f24770a);
        jSONObject.put("ea", this.f24771m);
        if (this.f24771m == 2 || this.f24771m == 3) {
            new C6135d(this.l).m21842a(jSONObject, this.f24773o);
        }
        return true;
    }
}
