package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class am<R> implements aa<R> {
    /* renamed from: a */
    fr f22960a;
    /* renamed from: b */
    C6015z<R> f22961b;

    am(fr frVar, C6015z<R> c6015z) {
        this.f22960a = frVar;
        this.f22961b = c6015z;
    }

    @TargetApi(11)
    /* renamed from: a */
    public final void mo4592a() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable c57621 = new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ am f22954b;

            public final void run() {
                this.f22954b.f22960a.mo4696c();
                countDownLatch.countDown();
            }
        };
        if (VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(c57621);
        } else {
            Executors.newSingleThreadExecutor().submit(c57621);
        }
        try {
            countDownLatch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            String str = an.f22962d;
        }
    }

    /* renamed from: b */
    public final boolean mo4594b() {
        return this.f22960a.mo4697d();
    }

    /* renamed from: c */
    public final ae<R> mo4595c() {
        try {
            C6013x a = m19829a(this.f22960a.mo4695b());
            if (C6015z.b(a)) {
                try {
                    return ae.m19794a(ad.m19791a(a.a(), a), this.f22961b.a(a));
                } catch (Throwable th) {
                    return ae.m19794a(ad.m19791a(a.a(), a), null);
                }
            }
            try {
                return ae.m19795a(a, this.f22961b.a(a));
            } catch (Throwable th2) {
                return ae.m19794a(ad.m19792a(a.a(), a, th2), null);
            }
        } catch (IOException e) {
            return ae.m19794a(ad.m19793a(null, e), null);
        }
    }

    /* renamed from: a */
    final C6013x m19829a(final gm gmVar) {
        return new C6013x(this) {
            /* renamed from: b */
            final /* synthetic */ am f22959b;

            /* renamed from: a */
            public final String m19824a() {
                return gmVar.m20728a().m20709a().toString();
            }

            /* renamed from: b */
            public final int m19825b() {
                return gmVar.m20730b();
            }

            /* renamed from: d */
            public final String m19827d() throws IOException {
                return gmVar.m20734f().m20741d();
            }

            /* renamed from: e */
            public final boolean m19828e() {
                return gmVar.m20731c();
            }

            /* renamed from: c */
            public final String m19826c() {
                return gmVar.m20732d();
            }

            public final String toString() {
                return "HttpResponse{code: " + gmVar.m20730b() + "}";
            }
        };
    }

    /* renamed from: a */
    public final void mo4593a(final ag<R> agVar) {
        this.f22960a.mo4694a(new fs(this) {
            /* renamed from: b */
            final /* synthetic */ C6014y f22956b = null;
            /* renamed from: c */
            final /* synthetic */ am f22957c;

            /* renamed from: a */
            public final void mo4590a(fr frVar, IOException iOException) {
                agVar.mo4626a(ad.m19793a(frVar.mo4693a().m20709a().toString(), iOException));
            }

            /* renamed from: a */
            public final void mo4591a(gm gmVar) throws IOException {
                C6013x a = this.f22957c.m19829a(gmVar);
                if (C6015z.b(a)) {
                    agVar.mo4626a(ad.m19791a(a.a(), a));
                    return;
                }
                try {
                    agVar.mo4627a(ae.m19795a(a, this.f22957c.f22961b.a(a)));
                } catch (Throwable th) {
                    agVar.mo4626a(ad.m19792a(a.a(), a, th));
                }
            }
        });
    }
}
