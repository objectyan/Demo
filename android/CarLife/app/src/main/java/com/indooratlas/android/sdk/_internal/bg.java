package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk.BuildConfig;
import com.indooratlas.android.sdk.IALocationManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class bg {
    @NonNull
    /* renamed from: a */
    public final String f23190a;
    @NonNull
    /* renamed from: b */
    public final String f23191b;
    @NonNull
    /* renamed from: c */
    public final String f23192c;
    @Nullable
    /* renamed from: d */
    public final String f23193d;
    /* renamed from: e */
    public final int f23194e;
    /* renamed from: f */
    public final boolean f23195f;
    @NonNull
    /* renamed from: g */
    final Bundle f23196g;

    /* renamed from: com.indooratlas.android.sdk._internal.bg$a */
    public static class C5819a {
        /* renamed from: a */
        public Bundle f23182a;
        /* renamed from: b */
        private Context f23183b;
        /* renamed from: c */
        private String f23184c;
        /* renamed from: d */
        private String f23185d;
        /* renamed from: e */
        private String f23186e;
        /* renamed from: f */
        private String f23187f;
        /* renamed from: g */
        private int f23188g = -1;
        /* renamed from: h */
        private boolean f23189h;

        public C5819a(Context context) {
            this.f23183b = (Context) eg.m20413a((Object) context, "context must be non-null", new Object[0]);
        }

        /* renamed from: a */
        public final bg m20094a() throws bc {
            Bundle bundle;
            boolean z = true;
            Bundle bundle2 = this.f23182a;
            if (bundle2 == null || bundle2.isEmpty()) {
                bundle = Bundle.EMPTY;
            } else {
                bundle = new Bundle(bundle2);
                Iterator it = new HashSet(bundle.keySet()).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str.contains(".debug.")) {
                        bundle.remove(str);
                    }
                }
            }
            try {
                String str2;
                int i;
                Bundle bundle3 = this.f23183b.getPackageManager().getApplicationInfo(this.f23183b.getPackageName(), 128).metaData;
                Object a = ct.m20259a(this.f23184c, ed.m20399a(bundle, IALocationManager.EXTRA_API_KEY), ed.m20399a(bundle3, "com.indooratlas.android.sdk.API_KEY"));
                Object a2 = ct.m20259a(this.f23185d, ed.m20399a(bundle, IALocationManager.EXTRA_API_SECRET), ed.m20399a(bundle3, "com.indooratlas.android.sdk.API_SECRET"));
                Object a3 = ct.m20259a(this.f23186e, ed.m20399a(bundle, "com.indooratlas.android.sdk.intent.extras.restEndpoint"), ed.m20399a(bundle3, "com.indooratlas.android.sdk.SERVICE_ENDPOINT"), BuildConfig.ENDPOINT_REST);
                if (!this.f23189h) {
                    boolean z2;
                    if (bundle != null) {
                        z2 = bundle.getBoolean(IALocationManager.EXTRA_PROXY_DISABLED, false);
                    } else {
                        z2 = false;
                    }
                    if (!z2 && (bundle3 == null || !bundle3.getBoolean("com.indooratlas.android.sdk.PROXY_DISABLED", false))) {
                        z = false;
                    }
                }
                if (z) {
                    str2 = null;
                    i = -1;
                } else {
                    int i2;
                    String a4 = ct.m20259a(this.f23187f, ed.m20399a(bundle, IALocationManager.EXTRA_PROXY_ADDRESS), ed.m20399a(bundle3, "com.indooratlas.android.sdk.PROXY_ADDRESS"), ct.m20268b("http.proxyHost"));
                    int[] iArr = new int[4];
                    iArr[0] = this.f23188g;
                    if (bundle != null) {
                        i2 = bundle.getInt(IALocationManager.EXTRA_PROXY_PORT, -1);
                    } else {
                        i2 = -1;
                    }
                    iArr[1] = i2;
                    iArr[2] = bundle3 != null ? bundle3.getInt("com.indooratlas.android.sdk.PROXY_PORT", -1) : -1;
                    iArr[3] = ct.m20270c("http.proxyPort");
                    i2 = ct.m20251a(iArr);
                    if (i2 <= 0 || i2 > 65535) {
                        i2 = -1;
                    }
                    str2 = a4;
                    i = i2;
                }
                if (ei.m20418a(a)) {
                    throw new bc("SDK API key not set, check that manifest contains: com.indooratlas.android.sdk.API_KEY");
                } else if (ei.m20418a(a2)) {
                    throw new bc("SDK API secret not set, check that manifest contains: com.indooratlas.android.sdk.API_SECRET");
                } else if (!ei.m20418a(a3)) {
                    return new bg(a3, a, a2, z, str2, i, bundle);
                } else {
                    throw new bc("Service endpoint empty, cannot proceed");
                }
            } catch (NameNotFoundException e) {
                throw new bc("reading metadata failed: " + e);
            }
        }
    }

    private bg(String str, String str2, String str3, boolean z, String str4, int i, Bundle bundle) {
        int i2 = 0;
        if (str != null) {
            try {
                URL url = new URL(str);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("invalid service endpoint: " + str);
            }
        }
        if (!(z || str4 == null)) {
            try {
                URL url2 = new URL(str4.startsWith("http://") ? str4 : "http://" + str4);
                i2 = 1;
            } catch (MalformedURLException e2) {
                ee.m20409a("IACore", "invalid proxy address: " + str4, new Object[0]);
            }
        }
        this.f23190a = str;
        this.f23195f = z;
        if (i2 == 0) {
            str4 = null;
        }
        this.f23193d = str4;
        if (i2 == 0 || i <= 0 || i > 65535) {
            i = -1;
        }
        this.f23194e = i;
        this.f23191b = str2;
        this.f23192c = str3;
        this.f23196g = bundle;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder("SdkEnvironment{restEndpoint='").append(this.f23190a).append('\'').append(", apiKey='").append(this.f23191b).append('\'');
        append.append(", mExtras=").append(this.f23196g).append('}');
        return append.toString();
    }
}
