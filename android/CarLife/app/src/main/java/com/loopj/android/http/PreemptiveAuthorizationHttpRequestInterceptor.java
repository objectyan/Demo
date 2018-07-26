package com.loopj.android.http;

import cz.msebera.android.httpclient.C6020w;
import cz.msebera.android.httpclient.C6033u;
import cz.msebera.android.httpclient.C6183p;
import cz.msebera.android.httpclient.C6592r;
import cz.msebera.android.httpclient.p155a.C2969i;
import cz.msebera.android.httpclient.p155a.C6182h;
import cz.msebera.android.httpclient.p155a.C6188n;
import cz.msebera.android.httpclient.p158b.C6265i;
import cz.msebera.android.httpclient.p173i.p174a.C3051b;
import cz.msebera.android.httpclient.p185n.C6198g;
import java.io.IOException;

public class PreemptiveAuthorizationHttpRequestInterceptor implements C6020w {
    public void process(C6033u request, C6198g context) throws C6183p, IOException {
        C2969i authState = (C2969i) context.mo5023a("http.auth.target-scope");
        C6265i credsProvider = (C6265i) context.mo5023a("http.auth.credentials-provider");
        C6592r targetHost = (C6592r) context.mo5023a("http.target_host");
        if (authState.c() == null) {
            C6188n creds = credsProvider.mo5111a(new C6182h(targetHost.m24203a(), targetHost.m24204b()));
            if (creds != null) {
                authState.a(new C3051b());
                authState.a(creds);
            }
        }
    }
}
