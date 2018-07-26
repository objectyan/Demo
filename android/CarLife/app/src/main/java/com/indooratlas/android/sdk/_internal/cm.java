package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk._internal.ad.C5758a;
import com.indooratlas.android.sdk.resources.IAResult;
import com.indooratlas.android.sdk.resources.IAResult.Error;
import com.indooratlas.android.sdk.resources.IAResultCallback;
import com.indooratlas.android.sdk.resources.IATask;

public final class cm<R> implements IATask<R> {
    /* renamed from: a */
    private aa<R> f23333a;

    public cm(aa<R> aaVar) {
        this.f23333a = aaVar;
    }

    public final void cancel() {
        this.f23333a.mo4592a();
    }

    public final IAResult<R> get() {
        ae c = this.f23333a.mo4595c();
        if (c.f22927a) {
            return IAResult.success(c.f22928b);
        }
        return IAResult.failure(m20232b(c.f22930d));
    }

    public final boolean isCancelled() {
        return this.f23333a.mo4594b();
    }

    public final void setCallback(final IAResultCallback<R> callback, @Nullable final Looper looper) {
        this.f23333a.mo4593a(new ag<R>(this) {
            /* renamed from: c */
            final /* synthetic */ cm f23332c;

            /* renamed from: a */
            public final void mo4627a(final ae<R> aeVar) {
                cm.m20231a(looper, new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C58401 f23327b;

                    public final void run() {
                        callback.onResult(IAResult.success(aeVar.f22928b));
                    }
                });
            }

            /* renamed from: a */
            public final void mo4626a(final ad adVar) {
                cm.m20231a(looper, new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C58401 f23329b;

                    public final void run() {
                        callback.onResult(IAResult.failure(cm.m20232b(adVar)));
                    }
                });
            }
        });
    }

    /* renamed from: b */
    private static Error m20232b(ad adVar) {
        C5758a c5758a = adVar.f22924a;
        if (c5758a == C5758a.NETWORK) {
            return Error.networkError(adVar.getCause());
        }
        if (c5758a == C5758a.HTTP) {
            return Error.httpError(adVar.f22925b.b(), adVar.f22925b.c());
        }
        return Error.conversionError(adVar.getCause());
    }

    /* renamed from: a */
    static /* synthetic */ void m20231a(Looper looper, Runnable runnable) {
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        new Handler(looper).post(runnable);
    }
}
