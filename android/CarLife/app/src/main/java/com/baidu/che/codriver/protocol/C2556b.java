package com.baidu.che.codriver.protocol;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.baidu.che.codriver.protocol.C2566d.C2565a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2735o;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseHttpTask */
/* renamed from: com.baidu.che.codriver.protocol.b */
public abstract class C2556b<T> {
    /* renamed from: a */
    private static String f8471a = "HttpAsyncTask";
    /* renamed from: b */
    private boolean f8472b;
    /* renamed from: c */
    private Request<?> f8473c = null;
    /* renamed from: d */
    private Class<T> f8474d;
    /* renamed from: e */
    private C2566d<T> f8475e = null;

    /* compiled from: BaseHttpTask */
    /* renamed from: com.baidu.che.codriver.protocol.b$1 */
    class C25611 implements Listener<T> {
        /* renamed from: a */
        final /* synthetic */ C2556b f8511a;

        C25611(C2556b this$0) {
            this.f8511a = this$0;
        }

        public void onResponse(T response) {
            C2725h.m10207b(C2556b.f8471a, "onResponse()");
            this.f8511a.f8472b = true;
            if (this.f8511a.f8475e != null) {
                this.f8511a.f8475e.mo1972a((Object) response);
            }
            this.f8511a.f8473c = null;
        }
    }

    /* compiled from: BaseHttpTask */
    /* renamed from: com.baidu.che.codriver.protocol.b$2 */
    class C25622 implements ErrorListener {
        /* renamed from: a */
        final /* synthetic */ C2556b f8512a;

        C25622(C2556b this$0) {
            this.f8512a = this$0;
        }

        public void onErrorResponse(VolleyError error) {
            C2725h.m10214e(C2556b.f8471a, "onErrorResponse():" + error.getMessage());
            if (!(error == null || error.getMessage() == null)) {
                C2725h.m10214e(C2556b.f8471a, error.getMessage().toString());
            }
            this.f8512a.f8472b = true;
            if (this.f8512a.f8475e != null) {
                this.f8512a.f8475e.mo1971a(C2565a.ERROR_NETWORK);
            }
            this.f8512a.f8473c = null;
        }
    }

    /* renamed from: b */
    protected abstract String mo1882b();

    public C2556b(C2566d<T> listener, Class<T> clazz) {
        this.f8475e = listener;
        this.f8472b = true;
        this.f8474d = clazz;
    }

    /* renamed from: a */
    protected int mo1881a() {
        return 0;
    }

    /* renamed from: c */
    protected Map<String, String> m9665c() {
        return null;
    }

    /* renamed from: d */
    public final void m9666d() {
        String url = mo1882b();
        if (TextUtils.isEmpty(url)) {
            C2725h.m10212d(f8471a, "Request URL is null!!!");
            return;
        }
        C2725h.m10207b(f8471a, "Request URL = " + url);
        this.f8472b = false;
        this.f8473c = new C2563c<T>(this, mo1881a(), url, this.f8474d, new C25611(this), new C25622(this)) {
            /* renamed from: a */
            final /* synthetic */ C2556b f8517a;

            public Map<String, String> getHeaders() throws AuthFailureError {
                return this.f8517a.m9669g();
            }

            public byte[] getBody() throws AuthFailureError {
                return this.f8517a.mo1883h();
            }

            public Priority getPriority() {
                return this.f8517a.m9671i();
            }
        };
        this.f8473c.setRetryPolicy(new DefaultRetryPolicy(6000, 0, 1.0f));
        this.f8473c.setShouldCache(false);
        C2735o.m10254a(this.f8473c);
    }

    /* renamed from: e */
    public boolean m9667e() {
        return this.f8472b;
    }

    /* renamed from: a */
    public void m9663a(C2566d<T> listener) {
        this.f8475e = listener;
    }

    /* renamed from: f */
    public void m9668f() {
        if (this.f8473c != null && !this.f8473c.isCanceled()) {
            this.f8473c.cancel();
        }
    }

    /* renamed from: g */
    protected Map<String, String> m9669g() {
        return new HashMap();
    }

    /* renamed from: h */
    protected byte[] mo1883h() {
        return null;
    }

    /* renamed from: i */
    protected Priority m9671i() {
        return Priority.NORMAL;
    }
}
