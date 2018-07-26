package com.facebook.imagepipeline.p273b.p274a;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.p257e.C5320a;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p153l.C2953c;
import com.facebook.imagepipeline.p153l.C5450e;
import com.facebook.imagepipeline.p153l.C5453r;
import com.facebook.imagepipeline.p153l.C5517j;
import com.facebook.imagepipeline.p153l.ae$a;
import com.facebook.imagepipeline.p153l.aj;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import p003b.C0281f;
import p003b.C0297e;
import p003b.C0317d.C0316a;
import p003b.C0351y;
import p003b.ab.C0298a;
import p003b.ad;
import p003b.ae;

/* compiled from: OkHttpNetworkFetcher */
/* renamed from: com.facebook.imagepipeline.b.a.c */
public class C5455c extends C2953c<C5454a> {
    /* renamed from: a */
    private static final String f22258a = "OkHttpNetworkFetchProducer";
    /* renamed from: b */
    private static final String f22259b = "queue_time";
    /* renamed from: c */
    private static final String f22260c = "fetch_time";
    /* renamed from: d */
    private static final String f22261d = "total_time";
    /* renamed from: e */
    private static final String f22262e = "image_size";
    /* renamed from: f */
    private final C0351y f22263f;
    /* renamed from: g */
    private Executor f22264g;

    /* compiled from: OkHttpNetworkFetcher */
    /* renamed from: com.facebook.imagepipeline.b.a.c$a */
    public static class C5454a extends C5453r {
        /* renamed from: a */
        public long f22255a;
        /* renamed from: b */
        public long f22256b;
        /* renamed from: c */
        public long f22257c;

        public C5454a(C5517j<C2952d> consumer, aj producerContext) {
            super(consumer, producerContext);
        }
    }

    /* renamed from: a */
    public /* synthetic */ Map m18726a(C5453r c5453r, int i) {
        return m18731b((C5454a) c5453r, i);
    }

    /* renamed from: b */
    public /* synthetic */ C5453r m18730b(C5517j c5517j, aj ajVar) {
        return m18725a(c5517j, ajVar);
    }

    /* renamed from: b */
    public /* synthetic */ void m18732b(C5453r c5453r, int i) {
        m18727a((C5454a) c5453r, i);
    }

    public C5455c(C0351y okHttpClient) {
        this.f22263f = okHttpClient;
        this.f22264g = okHttpClient.u().a();
    }

    /* renamed from: a */
    public C5454a m18725a(C5517j<C2952d> consumer, aj context) {
        return new C5454a(consumer, context);
    }

    /* renamed from: a */
    public void m18728a(final C5454a fetchState, final ae$a callback) {
        fetchState.f22255a = SystemClock.elapsedRealtime();
        final C0297e call = this.f22263f.a(new C0298a().a(new C0316a().b().e()).a(fetchState.m18720e().toString()).a().d());
        fetchState.m18717b().m19211a(new C5450e(this) {
            /* renamed from: b */
            final /* synthetic */ C5455c f22248b;

            /* compiled from: OkHttpNetworkFetcher */
            /* renamed from: com.facebook.imagepipeline.b.a.c$1$1 */
            class C54491 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C54511 f22246a;

                C54491(C54511 this$1) {
                    this.f22246a = this$1;
                }

                public void run() {
                    call.c();
                }
            }

            /* renamed from: a */
            public void mo4052a() {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    call.c();
                } else {
                    this.f22248b.f22264g.execute(new C54491(this));
                }
            }
        });
        call.a(new C0281f(this) {
            /* renamed from: c */
            final /* synthetic */ C5455c f22251c;

            /* renamed from: a */
            public void m18713a(C0297e call, ad response) throws IOException {
                fetchState.f22256b = SystemClock.elapsedRealtime();
                ae body = response.h();
                try {
                    if (response.d()) {
                        long contentLength = body.b();
                        if (contentLength < 0) {
                            contentLength = 0;
                        }
                        callback.mo4132a(body.d(), (int) contentLength);
                        try {
                            body.close();
                            return;
                        } catch (Throwable e) {
                            C5320a.m18177d(C5455c.f22258a, "Exception when closing response body", e);
                            return;
                        }
                    }
                    this.f22251c.m18723a(call, new IOException("Unexpected HTTP code " + response), callback);
                    try {
                        body.close();
                    } catch (Throwable e2) {
                        C5320a.m18177d(C5455c.f22258a, "Exception when closing response body", e2);
                    }
                } catch (Exception e3) {
                    this.f22251c.m18723a(call, e3, callback);
                    try {
                        body.close();
                    } catch (Throwable e22) {
                        C5320a.m18177d(C5455c.f22258a, "Exception when closing response body", e22);
                    }
                } catch (Throwable th) {
                    try {
                        body.close();
                    } catch (Throwable e222) {
                        C5320a.m18177d(C5455c.f22258a, "Exception when closing response body", e222);
                    }
                    throw th;
                }
            }

            /* renamed from: a */
            public void m18714a(C0297e call, IOException e) {
                this.f22251c.m18723a(call, e, callback);
            }
        });
    }

    /* renamed from: a */
    public void m18727a(C5454a fetchState, int byteSize) {
        fetchState.f22257c = SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public Map<String, String> m18731b(C5454a fetchState, int byteSize) {
        Map<String, String> extraMap = new HashMap(4);
        extraMap.put(f22259b, Long.toString(fetchState.f22256b - fetchState.f22255a));
        extraMap.put(f22260c, Long.toString(fetchState.f22257c - fetchState.f22256b));
        extraMap.put(f22261d, Long.toString(fetchState.f22257c - fetchState.f22255a));
        extraMap.put(f22262e, Integer.toString(byteSize));
        return extraMap;
    }

    /* renamed from: a */
    private void m18723a(C0297e call, Exception e, ae$a callback) {
        if (call.e()) {
            callback.mo4131a();
        } else {
            callback.mo4133a(e);
        }
    }
}
