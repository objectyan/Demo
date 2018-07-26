package com.indooratlas.android.sdk._internal;

import android.net.ConnectivityManager;
import com.indooratlas.algorithm.ClientProcessingManager;
import com.indooratlas.android.sdk._internal.bt.C5791a;
import com.indooratlas.android.sdk._internal.cr.C5843a;
import com.indooratlas.android.sdk.internal.DeviceWatchdog;
import java.io.IOException;
import java.net.URI;
import org.json.JSONObject;

public final class bk {
    /* renamed from: a */
    private static cr f23200a = new C5843a();

    /* renamed from: a */
    public static ClientProcessingManager m20096a(C6008t c6008t) {
        return new ClientProcessingManager(c6008t);
    }

    /* renamed from: c */
    public static bn m20105c(bf bfVar) {
        return new bn(bfVar, bfVar.f23160e, bfVar.f23157b);
    }

    /* renamed from: a */
    public static ac m20097a(String str, String str2, String str3, String str4) {
        ac aoVar = new ao(str, str4);
        aoVar.m19787a(str2, str3);
        aoVar.m19836a("IAWire");
        return aoVar;
    }

    /* renamed from: a */
    public static bx m20101a(bf bfVar, URI uri, String str, int i) throws IOException {
        return new bu(bfVar, uri, str, i);
    }

    /* renamed from: a */
    public static bt m20100a(bf bfVar, C5791a c5791a) {
        return new bt(bfVar.f23177v, c5791a);
    }

    /* renamed from: d */
    public static ca m20106d(bf bfVar) {
        return new ca(new by(bfVar.f23175t));
    }

    /* renamed from: a */
    public static bm m20099a() {
        return new bm();
    }

    /* renamed from: b */
    public static cr m20104b() {
        return f23200a;
    }

    /* renamed from: a */
    public static bb m20098a(JSONObject jSONObject) {
        return new bb(jSONObject);
    }

    /* renamed from: f */
    public static DeviceWatchdog m20108f(bf bfVar) {
        return new DeviceWatchdog(bfVar);
    }

    /* renamed from: a */
    public static cz m20102a(bf bfVar) {
        return cz.m20279a(bfVar.f23170o);
    }

    /* renamed from: b */
    public static ConnectivityManager m20103b(bf bfVar) {
        return (ConnectivityManager) bfVar.f23170o.getSystemService("connectivity");
    }

    /* renamed from: e */
    public static cj m20107e(bf bfVar) {
        return cj.m20218a(bfVar.f23170o);
    }
}
