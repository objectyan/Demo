package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.tencent.wxop.stat.C6160j;
import com.tencent.wxop.stat.C6161k;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.b */
public class C6121b extends C6119e {
    /* renamed from: a */
    protected C6122c f24765a = new C6122c();
    /* renamed from: m */
    private long f24766m = -1;

    public C6121b(Context context, int i, String str, C6161k c6161k) {
        super(context, i, c6161k);
        this.f24765a.f24767a = str;
    }

    /* renamed from: h */
    private void m21720h() {
        if (this.f24765a.f24767a != null) {
            Map b = C6160j.m22112b(this.f24765a.f24767a);
            if (b != null && b.size() > 0) {
                if (this.f24765a.f24769c == null || this.f24765a.f24769c.length() == 0) {
                    this.f24765a.f24769c = new JSONObject(b);
                    return;
                }
                for (Entry entry : b.entrySet()) {
                    try {
                        this.f24765a.f24769c.put(entry.getKey().toString(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.CUSTOM;
    }

    /* renamed from: a */
    public void m21722a(long j) {
        this.f24766m = j;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        jSONObject.put("ei", this.f24765a.f24767a);
        if (this.f24766m > 0) {
            jSONObject.put("du", this.f24766m);
        }
        if (this.f24765a.f24768b == null) {
            m21720h();
            jSONObject.put("kv", this.f24765a.f24769c);
        } else {
            jSONObject.put("ar", this.f24765a.f24768b);
        }
        return true;
    }

    /* renamed from: b */
    public C6122c m21724b() {
        return this.f24765a;
    }
}
