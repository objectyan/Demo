package com.baidu.carlife.p075d.p076a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.carlife.core.LogUtil;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import p003b.C0281f;
import p003b.C0297e;
import p003b.C0351y;
import p003b.C0351y.C0350a;
import p003b.ab;

/* compiled from: HttpManager */
/* renamed from: com.baidu.carlife.d.a.e */
public final class C1416e {
    /* renamed from: a */
    private static final String f4145a = "network_http";
    /* renamed from: b */
    private C0351y f4146b;
    /* renamed from: c */
    private Handler f4147c;
    /* renamed from: d */
    private C1404a f4148d;

    /* compiled from: HttpManager */
    /* renamed from: com.baidu.carlife.d.a.e$1 */
    class C14101 implements HostnameVerifier {
        /* renamed from: a */
        final /* synthetic */ C1416e f4131a;

        C14101(C1416e this$0) {
            this.f4131a = this$0;
        }

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /* compiled from: HttpManager */
    /* renamed from: com.baidu.carlife.d.a.e$a */
    private static class C1415a {
        /* renamed from: a */
        public static final C1416e f4144a = new C1416e();

        private C1415a() {
        }
    }

    /* renamed from: d */
    private static C1416e m5214d() {
        return C1415a.f4144a;
    }

    private C1416e() {
        Log.i(f4145a, "init http manager");
        this.f4148d = new C1404a();
        this.f4146b = new C0350a().m1260a(10, TimeUnit.SECONDS).m1285c(10, TimeUnit.SECONDS).m1279b(10, TimeUnit.SECONDS).m1265a(this.f4148d).m1273a(new C14101(this)).m1274a(C1407b.m5189b()).m1287c();
        this.f4147c = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    public static C0351y m5197a() {
        return C1416e.m5214d().f4146b;
    }

    /* renamed from: b */
    public static void m5210b() {
        Log.i(f4145a, "cancel all http request");
        C1416e.m5214d().f4146b.m1313u().m1083d();
    }

    /* renamed from: a */
    public static void m5205a(String url) {
        for (C0297e call : C1416e.m5214d().f4146b.m1313u().m1085f()) {
            if (TextUtils.equals(call.mo1118a().m850a().toString(), url)) {
                call.mo1121c();
                LogUtil.e(f4145a, "cancel running reuqest, url=" + url);
            }
        }
        for (C0297e call2 : C1416e.m5214d().f4146b.m1313u().m1084e()) {
            if (TextUtils.equals(call2.mo1118a().m850a().toString(), url)) {
                call2.mo1121c();
                LogUtil.e(f4145a, "cancel queued reuqest, url=" + url);
            }
        }
    }

    /* renamed from: c */
    public static void m5212c() {
        Log.i(f4145a, "clear cookies");
        C1416e.m5214d().f4148d.m5185a();
    }

    /* renamed from: a */
    public static void m5208a(String name, String value, String domain) {
        Log.i(f4145a, "add cookies");
        C1416e.m5214d().f4148d.m5187a(name, value, domain);
    }

    /* renamed from: a */
    public static void m5206a(String url, C1408c httpCallback) {
        C1416e.m5214d().m5198a(C1417f.m5215a(url), httpCallback);
    }

    /* renamed from: a */
    public static void m5209a(String url, Map<String, String> paramMap, C1408c httpCallback) {
        C1416e.m5214d().m5198a(C1417f.m5217a(url, (Map) paramMap), httpCallback);
    }

    /* renamed from: b */
    public static void m5211b(String url, Map<String, String> paramMap, C1408c httpCallback) {
        C1416e.m5214d().m5198a(C1417f.m5220b(url, paramMap), httpCallback);
    }

    /* renamed from: c */
    public static void m5213c(String url, Map<String, String> postParams, C1408c httpCallback) {
        Log.i(f4145a, "POST url=" + url);
        C1416e.m5214d().m5198a(C1417f.m5221c(url, postParams), httpCallback);
    }

    /* renamed from: a */
    public static void m5207a(String url, String postJson, C1408c httpCallback) {
        Log.i(f4145a, "POST url=" + url);
        C1416e.m5214d().m5198a(C1417f.m5216a(url, postJson), httpCallback);
    }

    /* renamed from: a */
    private void m5198a(ab request, final C1408c httpCallback) {
        this.f4146b.mo1152a(request).mo1119a(new C0281f(this) {
            /* renamed from: b */
            final /* synthetic */ C1416e f4133b;

            /* renamed from: a */
            public void mo1106a(C0297e call, IOException e) {
                this.f4133b.m5200a(httpCallback, e.toString());
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public void mo1105a(p003b.C0297e r8, p003b.ad r9) {
                /*
                r7 = this;
                r3 = r7.f4133b;	 Catch:{ Exception -> 0x0044 }
                r4 = r4;	 Catch:{ Exception -> 0x0044 }
                r5 = com.baidu.carlife.p075d.p076a.C1417f.m5218a(r9);	 Catch:{ Exception -> 0x0044 }
                r3.m5201a(r4, r5);	 Catch:{ Exception -> 0x0044 }
                r2 = r9.m901c();	 Catch:{ Exception -> 0x0044 }
                r3 = r9.m902d();	 Catch:{ Exception -> 0x0044 }
                if (r3 == 0) goto L_0x0028;
            L_0x0015:
                r3 = r9.m906h();	 Catch:{ Exception -> 0x0044 }
                r0 = r3.m411g();	 Catch:{ Exception -> 0x0044 }
                r3 = r7.f4133b;	 Catch:{ Exception -> 0x0044 }
                r4 = r4;	 Catch:{ Exception -> 0x0044 }
                r3.m5199a(r4, r2, r0);	 Catch:{ Exception -> 0x0044 }
            L_0x0024:
                r9.close();
            L_0x0027:
                return;
            L_0x0028:
                r3 = r7.f4133b;	 Catch:{ Exception -> 0x0044 }
                r4 = r4;	 Catch:{ Exception -> 0x0044 }
                r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044 }
                r5.<init>();	 Catch:{ Exception -> 0x0044 }
                r6 = "statusCode=";
                r5 = r5.append(r6);	 Catch:{ Exception -> 0x0044 }
                r5 = r5.append(r2);	 Catch:{ Exception -> 0x0044 }
                r5 = r5.toString();	 Catch:{ Exception -> 0x0044 }
                r3.m5200a(r4, r5);	 Catch:{ Exception -> 0x0044 }
                goto L_0x0024;
            L_0x0044:
                r1 = move-exception;
                r3 = r7.f4133b;	 Catch:{ all -> 0x0054 }
                r4 = r4;	 Catch:{ all -> 0x0054 }
                r5 = r1.toString();	 Catch:{ all -> 0x0054 }
                r3.m5200a(r4, r5);	 Catch:{ all -> 0x0054 }
                r9.close();
                goto L_0x0027;
            L_0x0054:
                r3 = move-exception;
                r9.close();
                throw r3;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.d.a.e.2.a(b.e, b.ad):void");
            }
        });
    }

    /* renamed from: a */
    private void m5200a(final C1408c httpCallback, final String error) {
        Log.e(f4145a, "error=" + error);
        this.f4147c.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C1416e f4136c;

            public void run() {
                if (httpCallback != null) {
                    httpCallback.mo1772a(null, error);
                }
            }
        });
    }

    /* renamed from: a */
    private void m5199a(final C1408c httpCallback, final int statusCode, final String response) {
        this.f4147c.post(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C1416e f4140d;

            public void run() {
                if (httpCallback != null) {
                    httpCallback.mo1771a(statusCode, response);
                }
            }
        });
    }

    /* renamed from: a */
    private void m5201a(final C1408c httpCallback, final Map<String, String> cookies) {
        this.f4147c.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C1416e f4143c;

            public void run() {
                if (httpCallback != null) {
                    httpCallback.mo1773a(cookies);
                }
            }
        });
    }
}
