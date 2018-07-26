package com.indooratlas.android.sdk._internal;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk._internal.gh.C5922a;
import com.indooratlas.android.sdk._internal.gk.C5925a;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class an extends C6009u {
    /* renamed from: d */
    static String f22962d = ee.m20406a(ac.class);
    /* renamed from: f */
    public static final Charset f22963f = Charset.forName("UTF-8");
    /* renamed from: g */
    static final /* synthetic */ boolean f22964g = (!an.class.desiredAssertionStatus());
    /* renamed from: k */
    private static final gg f22965k = gg.m20657a("application/json");
    /* renamed from: e */
    gh f22966e;
    /* renamed from: h */
    private String f22967h;
    /* renamed from: i */
    private Map<String, String> f22968i;
    /* renamed from: j */
    private al f22969j;

    public an(String str, String str2) {
        this(str, str2, (byte) 0);
    }

    private an(String str, String str2, byte b) {
        super(str, C6012w.f24589a);
        this.f22968i = null;
        C5922a b2 = new C5922a().m20673a(TimeUnit.SECONDS).m20678c(TimeUnit.SECONDS).m20676b(TimeUnit.SECONDS).m20672a(new ak()).m20672a(new aj()).m20675b(new ap(this));
        ei.m20418a(null);
        this.f22966e = b2.m20677b();
        this.f22967h = eg.m20414a(str2, "userAgent must be non empty", new Object[0]);
    }

    /* renamed from: a */
    public final void m19836a(String str) {
        f22962d = str;
        boolean a = ee.m20411a(str, 2);
        if (a && this.f22969j == null) {
            this.f22969j = new al();
            this.f22966e = this.f22966e.m20683b().m20675b(this.f22969j).m20677b();
        } else if (!a && this.f22969j != null) {
            C5922a b = this.f22966e.m20683b();
            b.m20674a().remove(this.f22969j);
            this.f22969j = null;
            this.f22966e = b.m20677b();
        }
    }

    /* renamed from: b */
    protected final gk m19837b(String str, byte[] bArr) {
        return m19835a(str, "POST", bArr, "application/json", null);
    }

    /* renamed from: a */
    protected final gk m19835a(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr, @Nullable String str3, @Nullable String[] strArr) {
        return m19834b(str, str2, bArr, str3, strArr);
    }

    @SuppressLint({"Assert"})
    /* renamed from: b */
    private gk m19834b(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr, @Nullable String str3, @Nullable String[] strArr) {
        try {
            gg ggVar;
            URL url = new URL(str);
            if (str3 == null) {
                ggVar = f22965k;
            } else {
                ggVar = gg.m20657a(str3);
            }
            C5925a a = new C5925a().m20705a(url).m20703a(str2, bArr != null ? gl.m19807a(ggVar, bArr) : null).m20704a("User-Agent", this.f22967h).m20704a("Date", af.m19796a()).m20704a("Connection", "Keep-Alive");
            if (str3 != null) {
                a.m20704a("Content-Type", str3);
            }
            if (this.f22968i != null) {
                for (Entry entry : this.f22968i.entrySet()) {
                    a.m20704a((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (strArr != null) {
                if (f22964g || strArr.length % 2 == 0) {
                    for (int i = 0; i < strArr.length; i += 2) {
                        a.m20704a(strArr[i], strArr[i + 1]);
                    }
                } else {
                    throw new AssertionError("headers must be pairs of key value");
                }
            }
            return a.m20706a();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("bad url: " + str);
        }
    }
}
