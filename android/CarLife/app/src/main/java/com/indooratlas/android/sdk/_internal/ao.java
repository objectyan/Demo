package com.indooratlas.android.sdk._internal;

import android.text.TextUtils;
import com.indooratlas.android.sdk._internal.ah.C5759a;
import com.indooratlas.android.sdk._internal.ah.C5760b;
import java.util.ArrayList;
import org.json.JSONObject;

public final class ao extends an implements ac {
    public ao(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public final <R> aa<R> mo4597a(C6015z<R> c6015z, JSONObject jSONObject) {
        b();
        return new am(this.e.m20681a(m19837b(a(C5759a.SDK_V1).m19803a("/init", new Object[0]).m19804a(), jSONObject.toString().getBytes(f))), c6015z);
    }

    /* renamed from: a */
    public final <R> aa<R> mo4596a(C6015z<R> c6015z, String str) {
        String str2;
        String a = eg.m20414a(str, "contextId must be non null", new Object[0]);
        if (a.indexOf(46) == -1) {
            a = "floorplan." + a;
        }
        int i = !TextUtils.isEmpty(null) ? 1 : 0;
        ah a2 = a(C5759a.CONTEXTS_V1).m19803a("/%s/raster_images", a);
        if (i != 0) {
            str2 = "ida-key";
            eg.m20414a(str2, "query parameter name must be non empty", new Object[0]);
            if (af.m19798a(null)) {
                throw new IllegalArgumentException("query param value for " + str2 + " must be non empty");
            }
            if (a2.f22943c == null) {
                a2.f22943c = new ArrayList();
            }
            a2.f22943c.add(new C5760b(str2));
        }
        str2 = a2.m19804a();
        String str3 = "GET";
        String[] strArr = new String[2];
        strArr[0] = "X-IA-Skip-Signature";
        strArr[1] = i != 0 ? "true" : "false";
        return new am(this.e.m20681a(m19835a(str2, str3, null, null, strArr)), c6015z);
    }

    /* renamed from: a */
    public final aa<Void> mo4598a(String str, byte[] bArr) {
        b();
        new Object[1][0] = new String(bArr, f);
        return new am(this.e.m20681a(m19837b(a(C5759a.SDK_V1).m19803a("/events/%s", str).m19804a(), bArr)), C6015z.f24590a);
    }
}
